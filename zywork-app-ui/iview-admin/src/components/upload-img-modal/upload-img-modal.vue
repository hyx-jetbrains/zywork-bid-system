<template>
<Modal v-model="uploadModal" :title="title" :mask-closable="true">
  <div class="demo-upload-list" v-for="item in uploadList" :key="item.name">
        <div v-if="item.status === 'finished'">
            <img :src="item.url">
            <div class="demo-upload-list-cover">
                <Icon type="ios-eye-outline" @click="handleView(item.url)"></Icon>
                <Icon type="ios-trash-outline" @click="handleRemove(item)"></Icon>
            </div>
        </div>
        <div v-else>
            <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress>
        </div>
  </div>
    <Upload
        ref="upload"
        :show-upload-list="false"
        :default-file-list="defaultList"
        :on-success="handleSuccess"
        :format="format"
        :on-format-error="handleFormatError"
        :before-upload="handleBeforeUpload"
        :on-error="handleError"
        :headers="uploadHeaders"
        type="drag"
        :action="baseUrl + uploadUrl"
        :multiple="multiple"
        style="display: inline-block;width:58px;">
        <div style="width: 58px;height:58px;line-height: 58px;">
            <Icon type="ios-camera" size="20"></Icon>
        </div>
    </Upload>
    <Modal title="查看图片" v-model="imgModal">
        <img :src="imgUrl" v-if="imgModal" style="width: 100%">
    </Modal>
    <div slot="footer">
      <Button type="default" size="large" @click="uploadModal = false">关闭</Button>
    </div>
  </Modal>
</template>

<script>
import { getLocalStorageToken } from '@/libs/util'
import axios from '@/libs/api.request'
import config from '@/config'
import * as ResponseStatus from '@/api/response-status'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
export default {
  name: 'UploadImgModal',
  props: {
    title: '',
    name: '',
    format: '',
    multiple: false
  },
  components: {
  },
  data () {
    return {
      uploadModal: false,
      baseUrl: baseUrl,
      uploadUrl: '',
      uploadHeaders: {
        'Authorization': 'Bearer ' + getLocalStorageToken()
      },
      removeUrl: '',
      defaultList: [],
      uploadList: [],
      imgModal: false,
      imgUrl: ''
    }
  },
  methods: {
    handleBeforeUpload(file) {
      this.$Notice.warning({
        title: '图片正在上传',
        desc: '图片 ' + file.name + ' 正在上传'
      })
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: '图片格式不正确',
        desc: '图片 ' + file.name + ' 格式不正确，请选择 ' + this.format + ' 格式的图片' 
      })
    },
    handleSuccess(response, file) {
      if (response.code === ResponseStatus.OK) {
        file.url = '/' + response.data.picUrl
        file.name = response.data.id;
        this.$Notice.success({
          title: '图片上传成功',
          desc: response.message
        })
        // this.uploadModal = false
        this.updateUploadList()
      } else {
        this.$Notice.error({
          title: '图片上传失败',
          desc: '图片 ' + file.name + ' ' + response.message 
        })
      }
    },
    handleError(file) {
      this.$Notice.error({
        title: '图片上传失败',
        desc: '图片 ' + file.name + ' 上传失败，请重新上传' 
      })
    },
    handleView (imgUrl) {
      this.imgUrl = imgUrl
      this.imgModal = true
    },
    handleRemove (img) {
      this.$Modal.confirm({
        title: '确认删除吗？',
        content: '确认删除选择的图片吗？',
        onOk: () => {
          axios.request({
            url: this.removeUrl + img.name,
            method: 'GET'
          }).then(response => {
            if (response.data.code === ResponseStatus.OK) {
              const fileList = this.$refs.upload.fileList
              this.$refs.upload.fileList.splice(fileList.indexOf(img), 1)
              this.uploadList = this.$refs.upload.fileList
            } else {
              this.$Message.error(response.data.message)
            }
          }).catch(error => {
            console.log(error)
          })
        },
        onCancel: () => {

        }
      })
    },
    updateUploadList (type) {
      // fileList中的status属性，第一次打开上传组件时，为undefined，所以在查询出所有默认图片时，需要增加status: finished
      this.defaultList.forEach((item, index) => {
        item.status = 'finished'
      })
      if (type === 'default') {
        this.$refs.upload.fileList = this.defaultList
      }
      this.uploadList = this.$refs.upload.fileList
    }
  },
  mounted () {}
}
</script>

<style>
    .demo-upload-list {
        display: inline-block;
        width: 60px;
        height: 60px;
        text-align: center;
        line-height: 60px;
        border: 1px solid transparent;
        border-radius: 4px;
        overflow: hidden;
        background: #fff;
        position: relative;
        box-shadow: 0 1px 1px rgba(0,0,0,.2);
        margin-right: 4px;
    }
    .demo-upload-list img{
        width: 100%;
        height: 100%;
    }
    .demo-upload-list-cover{
        display: none;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background: rgba(0,0,0,.6);
    }
    .demo-upload-list:hover .demo-upload-list-cover{
        display: block;
    }
    .demo-upload-list-cover i{
        color: #fff;
        font-size: 20px;
        cursor: pointer;
        margin: 0 2px;
    }
</style>
