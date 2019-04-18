<template>
  <Form ref="loginForm" :model="form" :rules="rules" @keydown.enter.native="handleSubmit">
    <FormItem prop="username">
      <Input v-model="form.username" placeholder="请输入用户名" clearable />
      <span slot="prepend">
        <Icon :size="16" type="ios-person"></Icon>
      </span>
    </FormItem>
    <FormItem prop="password">
      <Input type="password" v-model="form.password" placeholder="请输入密码" clearable />
      <span slot="prepend">
        <Icon :size="14" type="md-lock"></Icon>
      </span>
    </FormItem>
    <FormItem prop="verifyCode">
      <Row>
        <i-col span="18">
          <Input v-model="form.verifyCode" placeholder="请输入验证码" clearable />
          <span slot="prepend">
            <Icon :size="14" type="ios-color-wand"></Icon>
          </span>
        </i-col>
        <i-col span="6">
          <Tooltip content="刷新验证码" placement="top">
            <img :src="imgUrl" style="height: 30px; margin-top: 2px; cursor: pointer" @click="refreshVerifyCode" />
          </Tooltip>
        </i-col>
      </Row>
    </FormItem>
    <FormItem>
      <Button @click="handleSubmit" type="primary" :loading="loginBtn" long>登录</Button>
    </FormItem>
  </Form>

</template>
<script>
import config from '@/config'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
export default {
  name: 'LoginForm',
  props: {
    userNameRules: {
      type: Array,
      default: () => {
        return [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ]
      }
    },
    passwordRules: {
      type: Array,
      default: () => {
        return [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      }
    },
    verifyCodeRules: {
      type: Array,
      default: () => {
        return [{
          required: true,
          message: '验证码不能为空',
          trigger: 'blur'
        }]
      }
    },
    loginBtn: false
  },
  data () {
    return {
      form: {
        username: '',
        password: '',
        verifyCode: ''
      },
      urls: {
        verifyCodeUrl: '/auth/verify-code' + '?' + Math.random()
      },
      imgUrl: ''
    }
  },
  computed: {
    rules () {
      return {
        username: this.userNameRules,
        password: this.passwordRules,
        verifyCode: this.verifyCodeRules
      }
    }
  },
  methods: {
    // 初始化方法
    init () {
      this.refreshVerifyCode()
    },
    handleSubmit () {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.$emit('on-success-valid', {
            username: this.form.username,
            password: this.form.password,
            verifyCode: this.form.verifyCode
          })
        }
      })
    },
    // 刷新验证码
    refreshVerifyCode () {
      this.imgUrl = baseUrl + this.urls.verifyCodeUrl + '?' + Math.random()
    }
  },
  mounted () {
    this.init()
  }
}
</script>
