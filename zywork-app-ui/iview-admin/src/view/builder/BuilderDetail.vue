<template>
  <div>
      <p>
        建造师编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        姓名:
        <span v-text="form.name"></span>
      </p>
      <p>
        性别:
        <span v-text="form.gender === '1' ? '男' : form.gender === '2' ? '女' : '未知'"></span>
      </p>
      <p>
        出生年份:
        <span v-text="form.birthday"></span>
      </p>
      <p>
        证件地址:
        <span v-text="form.certificateAddress"></span>
      </p>
      <p>
        证书类别:
        <span v-text="form.certificateType"></span>
      </p>
      <p>
        证书专业类型:
        <span v-text="form.certificateMajorType"></span>
      </p>
      <p>
        证书状态:
        <span v-text="form.certificateStatus"></span>
      </p>
      <p>
        注册状态:
        <span v-text="form.certificateRegStatus"></span>
      </p>
      <p>
        期望年薪:
        <span v-text="form.salary"></span>
      </p>
      <p>
        手机号:
        <span v-text="form.phone"></span>
      </p>
      <p>
        说明:
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
        <span v-text="form.isActive === 0 ? '激活' : '冻结'"></span>
      </p>
  </div>
</template>

<script>
export default {
  name: 'BuilderViewModal',
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
