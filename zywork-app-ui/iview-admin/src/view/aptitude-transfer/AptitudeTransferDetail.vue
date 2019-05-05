<template>
  <div>
      <p>
        资质转让编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        转让类别:
        <span v-text="form.type"></span>
      </p>
      <p>
        项目名称:
        <span v-text="form.title"></span>
      </p>
      <p>
        企业资质等级:
        <span v-text="form.compAptitudeLevel"></span>
      </p>
      <p>
        企业资质类型:
        <span v-text="form.compAptitudeType"></span>
      </p>
      <p>
        联系电话:
        <span v-text="form.phone"></span>
      </p>
      <p>
        备注:
        <span v-text="form.memo"></span>
      </p>
      <p>
        版本号:
        <span v-text="form.version"></span>
      </p>
      <p>
        创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>
        更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>
        是否激活:
        <span v-text="form.isActive"></span>
      </p>
  </div>
</template>

<script>
export default {
  name: 'AptitudeViewModal',
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
