<template>
  <div class="user-avator-dropdown">
    <Dropdown @on-click="handleClick">
      
      <span class="main-user-name">{{username === 'null' ? '' : username}}</span>
      <Icon :size="18" type="md-arrow-dropdown"></Icon>
      <DropdownMenu slot="list">
        <!-- <DropdownItem name="message">
          消息中心<Badge style="margin-left: 10px" :count="messageUnreadCount"></Badge>
        </DropdownItem> -->
        <DropdownItem name="info">个人信息</DropdownItem>
        <DropdownItem name="logout">退出登录</DropdownItem>
      </DropdownMenu>
    </Dropdown>
    <Badge :dot="!!messageUnreadCount">
        <Avatar :src="userAvator"/>
      </Badge>
  </div>
</template>

<script>
import './user.less'
import { mapActions } from 'vuex'
import Cookie from 'js-cookie'
import headImg from '@/assets/images/head.png'
export default {
  name: 'User',
  props: {
    // userAvator: {
    //   type: String,
    //   default: ''
    // },
    messageUnreadCount: {
      type: Number,
      default: 0
    }
  },
  data () {
    return {
      username: '',
      userAvator: headImg
    }
  },
  methods: {
    ...mapActions([
      'handleLogOut'
    ]),
    init() {
      this.username = Cookie.get('user')
    },
    logout () {
      this.handleLogOut().then(() => {
        this.$router.push({
          name: 'login'
        })
      })
    },
    message () {
      this.$router.push({
        name: 'message_page'
      })
    },
    info () {
      this.$router.push({
        path: '/UserInfo'
      })
    },
    handleClick (name) {
      switch (name) {
        case 'logout': this.logout()
          break
        case 'message': this.message()
          break
        case 'info': this.info()
          break
      }
    }
  },
  mounted() {
    this.init()
  }
}
</script>
