<template>
  <div>
    <Card>
      <p slot="title">
        <Icon type="ios-contact"/>个人信息
      </p>
      <Tabs value="basic-info">
        <TabPane label="基础信息" name="basic-info">
          <Form :model="user" label-position="left" :label-width="100">
            <FormItem label="手机号">
              <Input v-model="user.userPhone" placeholder="请输入手机号码" readonly/>
            </FormItem>
            <FormItem label="邮箱">
              <Input v-model="user.userEmail" placeholder="请输入邮箱"/>
            </FormItem>
            <FormItem label="登入密码">
              <a href="javascript:;" @click="editPasswordModal = true">修改密码</a>
            </FormItem>
          </Form>
        </TabPane>
        <TabPane label="详细信息" name="detail-info">
          <Form :model="user" label-position="left" :label-width="100">
            <FormItem label="昵称">
              <Input v-model="user.userDetailNickname" placeholder="请输入昵称"/>
            </FormItem>
            <FormItem label="性别">
              <RadioGroup v-model="user.userDetailGender">
                <Radio label="0">
                  <Icon type="md-help-circle"/>未知
                </Radio>
                <Radio label="1">
                  <Icon type="md-male"/>男
                </Radio>
                <Radio label="2">
                  <Icon type="md-female"/>女
                </Radio>
              </RadioGroup>
            </FormItem>
            <FormItem label="生日">
              <DatePicker type="date" placeholder="请选择生日" @on-change="setDate" />
            </FormItem>
            <FormItem label="年龄">
              <Input v-model="user.userDetailAge" placeholder="请选择生日" readonly/>
            </FormItem>
            <FormItem>
              <Button type="primary" @click="saveInfo" :loading="saveBtnLoading">保存</Button>
            </FormItem>
          </Form>
        </TabPane>
        <TabPane label="社交信息" name="social-info">
          <Form :model="user" label-position="left" :label-width="100">
            <FormItem label="QQ">
              <Input v-model="user.userDetailWechat" placeholder="请输入QQ号"/>
            </FormItem>
            <FormItem label="微信">
              <Input v-model="user.userDetailWechat" placeholder="请输入微信号"/>
            </FormItem>
            <FormItem label="支付宝">
              <Input v-model="user.userDetailAlipay" placeholder="请输入微信号"/>
            </FormItem>
            <FormItem>
              <Button type="primary" @click="saveInfo" :loading="saveBtnLoading">保存</Button>
            </FormItem>
          </Form>
        </TabPane>
      </Tabs>
    </Card>
    <Modal v-model="editPasswordModal" title="修改登入密码">
      <Form ref="passwordForm" :model="passwordForm" :label-width="80" :rules="validateRules">
        <FormItem label="旧密码" prop="oldPassword">
          <Input type="password" v-model="passwordForm.oldPassword" placeholder="请输入旧密码"/>
        </FormItem>
        <FormItem label="新密码" prop="password">
          <Input type="password" v-model="passwordForm.password" placeholder="请输入新密码"/>
        </FormItem>
        <FormItem label="确认密码" prop="confirmPassword">
          <Input type="password" v-model="passwordForm.confirmPassword" placeholder="确认新密码"/>
        </FormItem>
        <FormItem class="des">
          <p>
            <strong>温馨提示：</strong>
          </p>
          <p>1、密码必须包含：数字、大写字母、小写字母</p>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancle">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="editBtnLoading">修改</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import { getUserInfo, updateLoaginPassword, logout } from '@/api/user.js'
import { removeToken } from '@/libs/util'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'UserInfo',
  components: {},
  data() {
    return {
      saveBtnLoading: false,
      editBtnLoading: false,
      editPasswordModal: false,
      user: {
        userId: null,
        userPhone: null,
        userEmail: null,
        userCreateTime: null,
        userDetailNickname: null,
        userDetailHeadicon: null,
        userDetailGender: '0',
        userDetailBirthday: null,
        userDetailAge: null,
        userDetailQq: null,
        userDetailQqQrcode: null,
        userDetailWechat: null,
        userDetailWechatQrcode: null,
        userDetailAlipay: null,
        userDetailAlipayQrcode: null,
        userDetailShareCode: null
      },
      passwordForm: {
        oldPassword: '',
        password: '',
        confirmPassword: ''
      },
      validateRules: {
        oldPassword: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          }
        ],
        password: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          }
        ],
        confirmPassword: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  computed: {},
  mounted() {
    this.initUserInfo()
  },
  methods: {
    // 初始化用户信息
    initUserInfo() {
      getUserInfo()
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.user = data.data.rows[0]
            this.user.userDetailGender = this.user.userDetailGender + ''
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 保存用户信息
    saveInfo() {},
    // 取消
    cancle() {
      this.$refs['passwordForm'].resetFields()
      this.editPasswordModal = false
    },
    // 修改密码
    edit() {
      this.$refs['passwordForm'].validate(valid => {
        if (valid) {
          if (this.passwordForm.password === this.passwordForm.oldPassword) {
            this.$Message.error('新密码和旧密码一致')
            return
          }
          this.editBtnLoading = true
          updateLoaginPassword(this.passwordForm)
            .then(res => {
              this.editBtnLoading = false
              const data = res.data
              if (data.code === ResponseStatus.OK) {
                this.$Message.info(data.message)
                this.cancle()
                setTimeout(() => {
                  logout().then(res => {
                    const data = res.data
                    if (data.code === ResponseStatus.OK) {
                      removeToken()
                      this.$router.push({
                        name: 'login'
                      })
                    }
                  })
                }, 500)
              } else {
                this.$Message.error(data.message)
              }
            })
            .catch(err => {
              this.$Message.error(err)
            })
        }
      })
    },
    // 设置生日日期
    setDate(time) {
      this.user.userDetailBirthday = time
      this.user.userDetailAge = this.countAge(time)
    },
    /*根据出生日期算出年龄*/
    countAge(strBirthday) {
      var returnAge
      var strBirthdayArr = strBirthday.split('-')
      var birthYear = strBirthdayArr[0]
      var birthMonth = strBirthdayArr[1]
      var birthDay = strBirthdayArr[2]

      var d = new Date()
      var nowYear = d.getFullYear()
      var nowMonth = d.getMonth() + 1
      var nowDay = d.getDate()

      if (nowYear == birthYear) {
        returnAge = 0 //同年 则为0岁
      } else {
        var ageDiff = nowYear - birthYear //年之差
        if (ageDiff > 0) {
          if (nowMonth == birthMonth) {
            var dayDiff = nowDay - birthDay //日之差
            if (dayDiff < 0) {
              returnAge = ageDiff - 1
            } else {
              returnAge = ageDiff
            }
          } else {
            var monthDiff = nowMonth - birthMonth //月之差
            if (monthDiff < 0) {
              returnAge = ageDiff - 1
            } else {
              returnAge = ageDiff
            }
          }
        } else {
          returnAge = -1 //返回-1 表示出生日期输入错误 晚于今天
        }
      }
      return returnAge //返回周岁年龄
    }
  }
}
</script>
<style lang="less">
.des {
  color: red;
}
</style>
