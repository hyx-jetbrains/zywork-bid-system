<template>
  <div class="editor-wrapper">
    <div :id="editorId"></div>
  </div>
</template>

<script>
import Editor from 'wangeditor'
import 'wangeditor/release/wangEditor.min.css'
import { oneOf } from '@/libs/tools'
import config from '@/config'
import {getLocalStorageToken} from '@/libs/util'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
const cdnUrl = config.baseUrl.cdnUrl

export default {
  name: 'Editor',
  props: {
    value: {
      type: String,
      default: ''
    },
    /**
     * 绑定的值的类型, enum: ['html', 'text']
     */
    valueType: {
      type: String,
      default: 'html',
      validator: (val) => {
        return oneOf(val, ['html', 'text'])
      }
    },
    /**
     * @description 设置change事件触发时间间隔
     */
    changeInterval: {
      type: Number,
      default: 200
    },
    /**
     * @description 是否开启本地存储
     */
    cache: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      menu: [
        'head', // 标题
        'bold', // 加粗
        'fontSize', // 字号
        'fontName', // 字体
        'italic', // 斜体
        'underline', // 下划线
        'strikeThrough', // 删除线
        'foreColor', // 字体颜色
        'backColor', // 背景颜色
        'link', // 插入连接
        'list', // 列表
        'justify', // 对其方式
        'quote', // 引用
        'emoticon', // 表情
        'image', // 插入图片
        'table', // 插入表格
        'video', // 插入视频
        'code', // 插入代码
        'undo', // 撤销
        'redo' // 重复
      ]
    }
  },
  computed: {
    editorId () {
      return `editor${this._uid}`
    }
  },
  methods: {
    setHtml (val) {
      this.editor.txt.html(val)
    },
    initEditor(uploadImgServer) {
      this.editor = new Editor(`#${this.editorId}`)
      this.editor.customConfig.onchange = (html) => {
        let text = this.editor.txt.text()
        if (this.cache) localStorage.editorCache = html
        this.$emit('input', this.valueType === 'html' ? html : text)
        this.$emit('on-change', html, text)
      }
      let self = this
      this.editor.customConfig.customAlert = function (info) {
          self.$Message.error(info)
      }
      this.editor.customConfig.onchangeTimeout = this.changeInterval
      // 设置菜单
      // this.editor.customConfig.menus = this.menu
      // 设置图片上传信息
      // this.editor.customConfig.uploadImgShowBase64 = true // base 64 存储图片
      this.editor.customConfig.uploadImgServer = baseUrl + uploadImgServer // 配置服务器端地址
      this.editor.customConfig.uploadImgHeaders = {
        'Authorization': 'Bearer ' + getLocalStorageToken()
      }// 自定义 header
      this.editor.customConfig.uploadFileName = 'file' // 后端接受上传文件的参数名
      this.editor.customConfig.uploadImgMaxSize = 2 * 1024 * 1024 // 将图片大小限制为 2M
      this.editor.customConfig.uploadImgMaxLength = 6 // 限制一次最多上传 3 张图片
      this.editor.customConfig.uploadImgTimeout = 3 * 60 * 1000 // 设置超时时间
      // 文件上传回调
      this.editor.customConfig.uploadImgHooks = {
        fail: (xhr, editor, result) => {
          // 插入图片失败回调
          this.$Message.error('图片上传失败')
        },
        success: (xhr, editor, result) => {
          // 图片上传成功回调
          console.log(result)
        },
        timeout: (xhr, editor) => {
          // 网络超时的回调
          this.$Message.error('图片上传超时')
        },
        error: (xhr, editor) => {
        // 图片上传错误的回调
        },
        customInsert: (insertImg, result, editor) => {
          // 图片上传成功，插入图片的回调
          insertImg(cdnUrl + "/" + result.data)
        }
      }
      // create这个方法一定要在所有配置项之后调用
      this.editor.create()
      // 如果本地有存储加载本地存储内容
      let html = this.value || localStorage.editorCache
      if (html) this.editor.txt.html(html)
    }
  },
  mounted () {}
}
</script>

<style lang="less">
.editor-wrapper *{
  z-index: 100 !important;
}
.w-e-menu{
  z-index: 2 !important;
}
.w-e-text-container{
  z-index: 1 !important;
}
.w-e-toolbar{
  flex-wrap:wrap;
}
</style>
