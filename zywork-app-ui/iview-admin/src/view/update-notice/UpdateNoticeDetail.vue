<template>
  <div>
      <p>
        更新公告编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        公告标题:
        <span v-text="form.title"></span>
      </p>
      <p>
        公告简介:
        <span v-text="form.synopsis"></span>
      </p>
      <p>
        版本号:
        <span v-text="form.version"></span>
      </p>
      <p>
        更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>
        创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>
        是否激活:
        <span v-text="form.isActive === 0 ? '激活' : '冻结'"></span>
      </p>
  </div>
</template>

<script>
export default {
  name: 'NoticeViewModal',
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
