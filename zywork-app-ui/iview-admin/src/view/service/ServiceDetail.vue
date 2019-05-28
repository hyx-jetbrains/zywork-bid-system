<template>
  <div>
      <p>服务编号: <span v-text="form.id"></span></p>
      <p>服务标题: <span v-text="form.title"></span></p>
      <p>详细说明: <span v-text="form.memo"></span></p>
      <p>所有收费的url: <span v-text="form.urls"></span></p>
      <p>服务价格: <span v-text="form.price/100"></span></p>
      <p>版本号: <span v-text="form.version"></span></p>
      <p>创建时间: <span v-text="form.createTime"></span></p>
      <p>更新时间: <span v-text="form.updateTime"></span></p>
      <p>是否激活: <span v-text="form.isActive"></span></p>
  </div>
</template>

<script>
export default {
  name: 'ServiceViewModal',
  props: {
    form: Object,
    detail: false
  },
  data() {
    return {}
  },
  computed: {},
  mounted() {},
  methods: {}
}
</script>

<style>
</style>
