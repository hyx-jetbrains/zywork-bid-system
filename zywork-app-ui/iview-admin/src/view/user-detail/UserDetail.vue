<template>
  <div>
      <p>用户编号: <span v-text="form.userId"></span></p>
      <p>手机号: <span v-text="form.userPhone"></span></p>
      <p>用户邮箱: <span v-text="form.userEmail"></span></p>
      <p>创建时间: <span v-text="form.userCreateTime"></span></p>
      <p>昵称: <span v-text="form.userDetailNickname"></span></p>
      <p>头像地址: <span v-text="form.userDetailHeadicon"></span></p>
      <p>性别: <span v-text="form.userDetailGender"></span></p>
      <p>生日: <span v-text="form.userDetailBirthday"></span></p>
      <p>年龄: <span v-text="form.userDetailAge"></span></p>
      <p>QQ号: <span v-text="form.userDetailQq"></span></p>
      <p>QQ二维码: <span v-text="form.userDetailQqQrcode"></span></p>
      <p>微信号: <span v-text="form.userDetailWechat"></span></p>
      <p>微信二维码: <span v-text="form.userDetailWechatQrcode"></span></p>
      <p>支付宝账号: <span v-text="form.userDetailAlipay"></span></p>
      <p>支付宝二维码: <span v-text="form.userDetailAlipayQrcode"></span></p>
      <p>分享码: <span v-text="form.userDetailShareCode"></span></p>
  </div>
</template>

<script>
export default {
  name: 'UserViewModal',
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
