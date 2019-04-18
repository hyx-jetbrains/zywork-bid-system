<template>
  <Modal v-model="importModal" :title="title" :mask-closable="false"> 
    <!-- <p style="margin-bottom: 20px;">
      {{title}}，只支持导入json格式的文件：<a href="javascript:;" @click="downloadTemplate" >模版下载</a>
    </p> -->
    <Upload type="drag" :format="['json']" :before-upload="handleBeforeUpload" :show-upload-list="false"
      :on-format-error="handleFormatError" :on-success="handleSuccess" :on-error="handleError"
      :action="baseImportUrl" :headers="importHeaders">
      <div style="padding: 20px 0">
        <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
        <p>单击或拖动文件到此处上传</p>
      </div>
    </Upload>
    <div slot="footer">
      <Button type="default" size="large" @click="importModal = false">关闭</Button>
    </div>
  </Modal>
</template>

<script>
import { getLocalStorageToken } from '@/libs/util'
import config from '@/config'
import * as ResponseStatus from '@/api/response-status'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
export default {
  name: 'import-json',
  props: {
    title: '',
    importUrl: '',
    importTemplate: ''
  },
  components: {
  },
  data () {
    return {
      importModal: false,
      baseImportUrl: baseUrl + this.importUrl,
      importHeaders: {
        'Authorization': 'Bearer ' + getLocalStorageToken()
      }
    }
  },
  methods: {
    downloadTemplate() {
      let fileName = JSON.stringify(this.importTemplate) // 下载模版
      let downName = (new Date()).getTime()+".json" // 文件下载名称
      const blob = new Blob([fileName])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE10
        navigator.msSaveBlob(blob, downName)
      } else {
        //  chrome/firefox
        let aTag = document.createElement('a')
        aTag.download = downName
        aTag.href = URL.createObjectURL(blob)
        aTag.click()
        URL.revokeObjectURL(aTag.href)
      }
    },
    handleBeforeUpload(file) {
      this.$Notice.warning({
        title: '文件正在上传',
        desc: '文件 ' + file.name + ' 正在上传'
      })
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: '文件格式不正确',
        desc: '文件 ' + file.name + ' 格式不正确，请选择json格式的文件' 
      })
    },
    handleSuccess(response, file) {
      if (response.code === ResponseStatus.OK) {
        this.$Notice.success({
          title: '文件上传成功',
          desc: response.message
        })
        this.importModal = false
        this.$emit('search')
      } else {
        this.$Notice.error({
          title: '文件上传失败',
          desc: '文件 ' + file.name + ' ' + response.message 
        })
      }
    },
    handleError(file) {
      this.$Notice.warning({
        title: '文件上传失败',
        desc: '文件 ' + file.name + ' 上传失败，请重新上传' 
      })
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: '文件超出大小限制',
        desc: '文件 ' + file.name + ' 文件太大' 
      })
    }
  },
  mounted () {
  }
}
</script>

<style lang="less">
</style>
