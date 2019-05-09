<template>
  <div>
      <p>
        专家信息编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        专家姓名:
        <span v-text="form.name"></span>
      </p>
      <p>
        性别:
        <span v-text="(form.gender == '1' ? '男' : form.gender == '2' ? '女' : '未知')"></span>
      </p>
      <p>
        年龄:
        <span v-text="form.age"></span>
      </p>
      <p>
        专家类别:
        <span v-text="form.type"></span>
      </p>
      <p>
        联系电话:
        <span v-text="form.phone"></span>
      </p>
      <p>
        个人情况介绍:
        <span v-text="form.memo"></span>
      </p>
      <p>
        审核状态:
        <span
          v-text="(form.examineStatus == '0' ? '审核中' : form.examineStatus == '1' ? '审核通过' : '审核不通过')"
        ></span>
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
  name: 'UserExpertDetailViewModal',
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