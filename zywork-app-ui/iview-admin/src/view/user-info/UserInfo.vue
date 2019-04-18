<template>
  <div>
    <Card>
      <Row>
        <i-col span="6">
          <Menu theme="light" active-name="1" @on-select="switchMenu">
            <MenuItem name="1">{{itemMenuName1}}</MenuItem>
            <MenuItem name="2">{{itemMenuName2}}</MenuItem>
            <MenuItem name="3">{{itemMenuName3}}</MenuItem>
          </Menu>
        </i-col>
        <i-col span="18">
          <Row v-if="menuItem == 1">
            <i-col span="23" offset="1">
              <Form :model="user" label-position="left" :label-width="100">
                <Divider orientation="left">{{itemMenuName1}}</Divider>
                <!-- 暂时注释，后面实现 -->
                <!-- <FormItem label="头像">
                  <div class="demo-upload-list" v-for="item in uploadList" :key="item.name">
                    <template v-if="item.status === 'finished'">
                      <img :src="item.url">
                      <div class="demo-upload-list-cover">
                        <Icon type="ios-eye-outline" @click.native="handleView(item.name)"></Icon>
                      </div>
                    </template>
                    <template v-else>
                      <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress>
                    </template>
                  </div>
                  <Upload
                    ref="upload"
                    :show-upload-list="false"
                    :default-file-list="defaultList"
                    :on-success="handleSuccess"
                    :format="['jpg','jpeg','png']"
                    :max-size="2048"
                    :on-format-error="handleFormatError"
                    :on-exceeded-size="handleMaxSize"
                    :before-upload="handleBeforeUpload"
                    multiple
                    type="drag"
                    action="//jsonplaceholder.typicode.com/posts/"
                    style="display: inline-block;width:58px;"
                  >
                    <div style="width: 58px;height:58px;line-height: 58px;">
                      <Icon type="ios-camera" size="20"></Icon>
                    </div>
                  </Upload>
                </FormItem> -->
                <FormItem label="昵称">
                  <Input v-model="user.userDetailNickname" placeholder="请输入昵称" style="width: 200px;"/>
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
                  <DatePicker
                    type="date"
                    v-model="user.userDetailBirthday"
                    placeholder="请选择生日"
                    @on-change="setDate"
                    style="width: 200px;"
                  />
                </FormItem>
                <FormItem label="年龄">
                  <Input
                    v-model="user.userDetailAge"
                    placeholder="请选择生日"
                    readonly
                    style="width: 200px;"
                  />
                </FormItem>
                <FormItem label="注册时间">
                  <span v-text="user.userCreateTime"/>
                </FormItem>
                <FormItem>
                  <Button type="primary" @click="saveInfo" :loading="saveBtnLoading" style="width: 100px;">保存</Button>
                </FormItem>
              </Form>
            </i-col>
          </Row>
          <Row v-if="menuItem == 2">
            <i-col span="23" offset="1">
              <Divider orientation="left">{{itemMenuName2}}</Divider>
              <Row>
                <i-col span="2">
                  <img class="my-item-img" :src="weChatImg" />
                </i-col>
                <i-col span="18">
                  <strong>微信</strong>
                  <br />
                  <span class="my-item-span">{{user.userDetailWechat != null ? '已绑定微信：' + user.userDetailWechat : '未绑定微信'}}</span>
                </i-col>
                <i-col span="4" class="my-item">
                  <a href="javascript:;" @click="userOptBind('wechat', 'wechatA')" id="wechatA">{{user.userDetailWechat != null ? '解除绑定' : '立即绑定'}}</a>
                </i-col>
              </Row>
              <Divider />
              <Row>
                <i-col span="2">
                  <img class="my-item-img" :src="qqImg" />
                </i-col>
                <i-col span="18">
                  <strong>QQ</strong>
                  <br />
                  <span class="my-item-span">{{user.userDetailQq != null ? '已绑定QQ：' + user.userDetailQq : '未绑定QQ'}}</span>
                </i-col>
                <i-col span="4" class="my-item">
                  <a href="javascript:;" @click="userOptBind('qq', 'qqA')" id="qqA">{{user.userDetailQq != null ? '解除绑定' : '立即绑定'}}</a>
                </i-col>
              </Row>
              <Divider />
              <Row>
                <i-col span="2">
                  <img class="my-item-img" :src="aliPayImg" />
                </i-col>
                <i-col span="18">
                  <strong>支付宝</strong>
                  <br />
                  <span class="my-item-span">{{user.userDetailAlipay != null ? '已绑定支付宝：' + user.userDetailAlipay : '未绑定支付宝'}}</span>
                </i-col>
                <i-col span="4" class="my-item">
                  <a href="javascript:;" @click="userOptBind('alipay', 'alipayA')" id="alipayA">{{user.userDetailAlipay != null ? '解除绑定' : '立即绑定'}}</a>
                </i-col>
              </Row>
            </i-col>
          </Row>
          <Row v-if="menuItem == 3">
            <i-col span="23" offset="1">
              <Divider orientation="left">{{itemMenuName3}}</Divider>
              <Row>
                <i-col span="20">
                  <strong>账户密码</strong>
                  <br />
                  <span></span>
                </i-col>
                <i-col span="4" class="my-item">
                  <a href="javascript:;" @click="userOpt('password')">修改</a>
                </i-col>
              </Row>
              <Divider />
              <Row>
                <i-col span="20">
                  <strong>绑定手机</strong>
                  <br />
                  <span class="my-item-span">{{user.userPhone != null ? '已绑定手机：' + user.userPhone : '未绑定手机'}}</span>
                </i-col>
                <i-col span="4" class="my-item">
                  <a href="javascript:;" @click="userOpt('phone')">修改</a>
                </i-col>
              </Row>
              <Divider />
              <Row>
                <i-col span="20">
                  <strong>绑定邮箱</strong>
                  <br />
                  <span class="my-item-span">{{user.userEmail != null ? '已绑定邮箱：' + user.userEmail : '未绑定邮箱'}}</span>
                </i-col>
                <i-col span="4" class="my-item">
                  <a href="javascript:;" @click="userOpt('email')">修改</a>
                </i-col>
              </Row>
            </i-col>
          </Row>
          
        </i-col>
      </Row>
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
    <Modal title="查看图片" v-model="visible">
      <img
        :src="'https://o5wwk8baw.qnssl.com/' + imgName + '/large'"
        v-if="visible"
        style="width: 100%"
      >
    </Modal>
  </div>
</template>

<script>
import { getUserInfo, updateLoaginPassword, logout, updateUserInfo } from '@/api/user.js'
import { removeToken } from '@/libs/util'
import * as ResponseStatus from '@/api/response-status'
import qqImg from '@/assets/images/QQ.png'
import weChatImg from '@/assets/images/WeChat.png'
import aliPayImg from '@/assets/images/AliPay.png'
import './UserInfo.less'
export default {
  name: 'UserInfo',
  components: {},
  data() {
    return {
      defaultList: [
        {
          name: 'a42bdcc1178e62b4694c830f028db5c0',
          url:
            'https://o5wwk8baw.qnssl.com/a42bdcc1178e62b4694c830f028db5c0/avatar'
        }
      ],
      imgName: '',
      visible: false,
      uploadList: [],

      itemMenuName1: '基础信息',
      itemMenuName2: '社交信息',
      itemMenuName3: '安全设置',
      menuItem: 1,

      qqImg: qqImg,
      weChatImg: weChatImg,
      aliPayImg: aliPayImg,

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
    // 暂时注释，后面实现
    // this.uploadList = this.$refs.upload.fileList
  },
  methods: {
    // 查看图片
    handleView(name) {
      this.imgName = name
      this.visible = true
    },
    // 文件上传成功
    handleSuccess(res, file) {
      file.url =
        'https://o5wwk8baw.qnssl.com/7eb99afb9d5f317c912f08b5212fd69a/avatar'
      file.name = '7eb99afb9d5f317c912f08b5212fd69a'
    },
    // 监听文件格式
    handleFormatError(file) {
      this.$Notice.warning({
        title: '文件格式不正确',
        desc:
          '文件格式 ' +
          file.name +
          ' 不正确，请选择JPG或PNG。'
      })
    },
    // 监听文件大小
    handleMaxSize(file) {
      this.$Notice.warning({
        title: '超出文件大小限制',
        desc: '文件  ' + file.name + ' 太大, 最大上传 2M。'
      })
    },
    // 监听开始上传文件
    handleBeforeUpload() {
      const check = this.uploadList.length < 1
      if (!check) {
        this.$Notice.warning({
          title: '最多可以上载1张图片。'
        })
      }
      return check
    },
    // 切换菜单
    switchMenu(name) {
      this.menuItem = name
    },
    // 初始化用户信息
    initUserInfo() {
      getUserInfo().then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            if (data.data.total !== 0) {
              this.user = data.data.rows[0]
              this.user.userDetailGender = this.user.userDetailGender + ''
              if (this.user.userDetailBirthday != null) {
                this.user.userDetailBirthday = this.user.userDetailBirthday.split(' ')[0]
              }
            }
          } else {
            this.$Message.error(data.message)
          }
        }).catch(err => {
          console.log(err)
        })
    },
    generatorUserParam() {
      var userForm = {
        age: this.user.userDetailAge,
        alipay: this.user.userDetailAlipay,
        alipayQrcode: this.user.userDetailAlipayQrcode,
        birthday: this.user.userDetailBirthday + ' 00:00:00',
        createTime: this.user.userCreateTime,
        gender: this.user.userDetailGender,
        headicon: this.user.userDetailHeadicon,
        id: this.user.userId,
        isActive: this.user.isActive,
        nickname: this.user.userDetailNickname,
        qq: this.user.userDetailQq,
        qqQrcode: this.user.userDetailQqQrcode,
        shareCode: this.user.userDetailShareCode,
        updateTime: this.user.updateTime,
        version: this.user.version,
        wechat: this.user.wechat,
        wechatQrcode: this.user.wechatQrcode
      }
      return userForm
    },
    // 保存用户信息
    saveInfo() {
      var userForm = this.generatorUserParam()
      updateUserInfo(userForm)
        .then(res => {
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            this.$Message.error(data.message)
            return
          }
          this.$Message.success(data.message)
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 用户操作
    userOpt(type) {
      if (type === 'password') {
        // 修改密码
        this.editPasswordModal = true
      } else if (type === 'phone') {
        // 修改手机
        this.$Message.warning("暂不支持修改手机")
      } else if (type === 'email') {
        // 修改邮箱
        this.$Message.warning("暂不支持修改邮箱")
      }
    },
    // 绑定或解绑操作
    userOptBind(optType, id) {
      var type = document.getElementById(id).innerText;
      if (optType === 'wechat') {
        // 微信操作
        this.$Message.warning("暂未实现")
        if (type === '立即绑定') {
          // 绑定微信操作
        } else if (type === '解除绑定') {
          // 解除微信绑定
        }
      } else if (optType === 'qq') {
        // QQ操作
        this.$Message.warning("暂未实现")
        if (type === '立即绑定') {
          // 绑定QQ操作
        } else if (type === '解除绑定') {
          // 解除QQ绑定
        }
      } else if (optType === 'alipay') {
        // 支付宝操作
        this.$Message.warning("暂未实现")
        if (type === '立即绑定') {
          // 绑定支付宝操作
        } else if (type === '解除绑定') {
          // 解除支付宝绑定
        }
      }
    },
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
      if (time != "") {
        this.user.userDetailBirthday = time
        this.user.userDetailAge = this.countAge(time)
      } else {
        this.user.userDetailAge = ''
      }
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
