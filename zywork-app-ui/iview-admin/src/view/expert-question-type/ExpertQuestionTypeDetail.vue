<template>
  <div>
      <p>专家问题分类编号: <span v-text="form.id"></span></p>
      <p>类别名称: <span v-text="form.name"></span></p>
      <p>备注: <span v-text="form.memo"></span></p>
      <p>版本号: <span v-text="form.version"></span></p>
      <p>创建时间: <span v-text="form.createTime"></span></p>
      <p>更新时间: <span v-text="form.updateTime"></span></p>
      <p>是否激活: <span v-text="form.isActive"></span></p>
  </div>
</template>

<script>
export default {
  name: 'ExpertQuestionTypeViewModal',
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