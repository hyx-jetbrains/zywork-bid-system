<template>
  <Modal v-model="uploadModal" :title="title" :mask-closable="true"> 
    <Upload type="drag" :format="format" :before-upload="handleBeforeUpload" :show-upload-list="false"
      :on-format-error="handleFormatError" :on-success="handleSuccess" :on-error="handleError"
      :action="baseUrl + uploadUrl" :headers="uploadHeaders" :multiple="multiple">
      <div style="padding: 20px 0">
        <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
        <p>单击或拖动文件到此处上传</p>
      </div>
    </Upload>
    <div slot="footer">
      <Button type="default" size="large" @click="uploadModal = false">关闭</Button>
    </div>
  </Modal>
</template>

<script>
import { getLocalStorageToken } from '@/libs/util'
import config from '@/config'
import * as ResponseStatus from '@/api/response-status'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
export default {
  name: 'UploadModal',
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
      }
    }
  },
  methods: {
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
        this.uploadModal = false
        this.$emit('search')
      } else {
        this.$Notice.error({
          title: '文件上传失败',
          desc: '文件 ' + file.name + ' ' + response.message 
        })
      }
    },
    handleError(file) {
      this.$Notice.error({
        title: '文件上传失败',
        desc: '文件 ' + file.name + ' 上传失败，请重新上传' 
      })
    }
  },
  mounted () {
  }
}
</script>

<style lang="less">
</style>
