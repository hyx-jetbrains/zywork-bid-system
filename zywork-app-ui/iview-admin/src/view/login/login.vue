<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="欢迎登录" :bordered="false">
        <div class="form-con">
          <login-form @on-success-valid="handleSubmit" :loginBtn="loginBtn"></login-form>
          <!-- <p class="login-tip">输入任意用户名和密码即可</p> -->
          <other-login></other-login>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
import LoginForm from '_c/login-form'
import OtherLogin from '_c/other-login'
import { mapActions } from 'vuex'
export default {
  components: {
    LoginForm,
    OtherLogin
  },
  data () {
    return {
      loginForm: {
        'username': '',
        'password': '',
        'verifyCode': ''
      },
      loginBtn: false
    }
  },
  methods: {
    ...mapActions([
      'handleLogin',
      'getUserInfo'
    ]),
    handleSubmit ({ username, password, verifyCode }) {
      this.loginForm.username = username
      this.loginForm.password = password
      this.loginForm.verifyCode = verifyCode
      this.loginBtn = true
      this.handleLogin(this).then(res => {
        this.loginBtn = false
        // 登入成功获取用户信息
        this.getUserInfo().then(res => {
          // 成功获取用户信息，清除tab菜单并进入首页
          if (window.localStorage) {
            window.localStorage.removeItem('tagNaveList')
          }
          this.$router.push({
            name: this.$config.homeName
          })
        })
      })
    },
    notice() {
      this.$Notice.info({
        title: '体验账号密码',
        desc: '账号：demo@zywork.top 密码：Demo123456',
        duration: 5
      });
    }
  },
  mounted() {
    this.notice()
  }
}
</script>

<style>

</style>
