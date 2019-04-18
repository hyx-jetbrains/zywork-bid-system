<template>
  <div>
    <Card>
       链接地址：
       <Input v-model="inputUrl" placeholder="输入链接地址,按回车前往" 
          style="width: 300px" @on-enter="openInIframe" clearable />&nbsp;
       <Button type="primary" icon="ios-send" @click="openInIframe">前往</Button>&nbsp;
       <Button icon="md-open" @click="openNewWindows">在新窗口打开</Button>
      <Divider style="margin-bottom: 0px;" />
      <Row>
        <iframe
          frameborder="0"
          name="showHere"
          scrolling="auto"
          :src="iframeUrl"
          style="width: 100%;height: 550px;"
        ></iframe>
      </Row>
    </Card>
  </div>
</template>

<script>
export default {
  name: 'ApiDocument',
  components: {},
  data() {
    return {
      inputUrl: 'http://localhost:8088/swagger-ui.html',
      iframeUrl: 'http://39.108.116.103:8080'
    }
  },
  computed: {},
  mounted() {
  },
  methods: {
    openInIframe() {
      this.iframeUrl = this.inputUrl
    },
    openNewWindows() {
      window.open(this.inputUrl, '_blank')
    }
  }
}
</script>

<style>
</style>
