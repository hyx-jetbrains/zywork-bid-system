<template>
  <div>
      <p>企业编号: <span v-text="form.id"></span></p>
      <p>辖区类别: <span v-text="form.jurisdictionType"></span></p>
      <p>市区: <span v-text="form.city"></span></p>
      <p>企业类型: <span v-text="form.compType"></span></p>
      <p>行业分类: <span v-text="form.industryType"></span></p>
      <p>企业名称: <span v-text="form.compName"></span></p>
      <p>法人: <span v-text="form.legalPerson"></span></p>
      <p>法人电话: <span v-text="form.legalPersonPhone"></span></p>
      <p>注册地区: <span v-text="form.regAddress"></span></p>
      <p>负责人: <span v-text="form.responsible"></span></p>
      <p>负责人电话: <span v-text="form.responsiblePhone"></span></p>
      <p>单位电话: <span v-text="form.compPhone"></span></p>
      <p>联系地址: <span v-text="form.compAddr"></span></p>
      <p>注册资本: <span v-text="form.regCapital"></span></p>
      <p>经营范围: <span v-text="form.businessScope"></span></p>
      <p>可承担业务: <span v-text="form.affordableBusiness"></span></p>
      <p>版本号: <span v-text="form.version"></span></p>
      <p>创建时间: <span v-text="form.createTime"></span></p>
      <p>更新时间: <span v-text="form.updateTime"></span></p>
  </div>
</template>

<script>
export default {
  name: 'CompanyViewModal',
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
