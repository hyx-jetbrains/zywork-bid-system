<template>
  <div>
    <p>
      抵扣券编号:
      <span v-text="form.id"></span>
    </p>
    <p>
      抵用券类别:
      <span v-text="form.type"></span>
    </p>
    <p>
      金额:
      <span v-text="form.money"></span>
    </p>
    <p>
      数量:
      <span v-text="form.couponCount"></span>
    </p>
    <p>
      有效期至:
      <span v-text="form.validTime"></span>
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
      <span v-text="form.isActive === 0 ? '激活': '冻结'"></span>
    </p>
  </div>
</template>

<script>
export default {
  name: 'ConsultViewModal',
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
