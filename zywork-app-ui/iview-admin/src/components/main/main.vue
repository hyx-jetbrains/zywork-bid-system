<template>
  <Layout style="height: 100%" class="main">
    <Sider
      hide-trigger
      collapsible
      :width="256"
      :collapsed-width="64"
      v-model="collapsed"
      class="left-sider"
      :style="{overflow: 'hidden'}"
    >
      <side-menu
        accordion
        ref="sideMenu"
        :active-name="$route.name"
        :collapsed="collapsed"
        @on-select="turnToPage"
        :menu-list="menuList"
      >
        <!-- 需要放在菜单上面的内容，如Logo，写在side-menu标签内部，如下 -->
        <div class="logo-con">
          <img v-show="!collapsed" :src="maxLogo" key="max-logo" />
          <img v-show="collapsed" :src="minLogo" key="min-logo" />
        </div>
      </side-menu>
    </Sider>
    <Layout>
      <Header class="header-con">
        <header-bar :collapsed="collapsed" @on-coll-change="handleCollapsedChange">
          <user :message-unread-count="unreadCount" :user-avator="userAvator" />
          <!-- <language v-if="$config.useI18n" @on-lang-change="setLocal" style="margin-right: 10px;" :lang="local"/> -->
          <!-- <error-store v-if="$config.plugin['error-store'] && $config.plugin['error-store'].showInHeader" :has-read="hasReadErrorPage" :count="errorCount"></error-store> -->
          <fullscreen v-model="isFullscreen" style="margin-right: 10px;" />
          <message
            v-model="messageCount"
            :expert="expert"
            :guarantee="guarantee"
            :consult="consult"
            @initNotReadMessage="initNotReadMessage"
            style="margin-right: 20px;"
          />
        </header-bar>
      </Header>
      <Content class="main-content-con">
        <Layout class="main-layout-con">
          <div class="tag-nav-wrapper">
            <tags-nav
              :value="$route"
              @input="handleClick"
              :list="tagNavList"
              @on-close="handleCloseTag"
            />
          </div>
          <Content class="content-wrapper">
            <keep-alive :include="cacheList">
              <router-view />
            </keep-alive>
            <ABackTop :height="100" :bottom="80" :right="50" container=".content-wrapper"></ABackTop>
          </Content>
        </Layout>
      </Content>
    </Layout>
  </Layout>
</template>
<script>
import SideMenu from './components/side-menu'
import HeaderBar from './components/header-bar'
import TagsNav from './components/tags-nav'
import User from './components/user'
import ABackTop from './components/a-back-top'
import Fullscreen from './components/fullscreen'
import Message from './components/message'
import Language from './components/language'
import ErrorStore from './components/error-store'
import { mapMutations, mapActions, mapGetters } from 'vuex'
import { getNewTagList, getNextRoute, routeEqual } from '@/libs/util'
import routers from '@/router/routers'
import minLogo from '@/assets/images/logo-min.png'
import maxLogo from '@/assets/images/logo.png'
import userAvator from '@/assets/images/head.png'
import './main.less'
import { SYS_INFO_KEY, localStorage } from '@/api/utils.js'
import { allByAdminMessage } from '@/api/message.js'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'Main',
  components: {
    SideMenu,
    HeaderBar,
    Language,
    TagsNav,
    Fullscreen,
    Message,
    ErrorStore,
    User,
    ABackTop
  },
  data() {
    return {
      collapsed: false,
      minLogo,
      maxLogo,
      userAvator,
      isFullscreen: false,
      messageCount: 0,
      guarantee: 0,
      tempGuaranteeCount: 0,
      expert: 0,
      tempExpertCount: 0,
      consult: 0,
      tempConsultCount: 0
    }
  },
  computed: {
    ...mapGetters(['errorCount']),
    tagNavList() {
      return this.$store.state.app.tagNavList
    },
    tagRouter() {
      return this.$store.state.app.tagRouter
    },
    // userAvator () {
    // return this.$store.state.user.avatorImgPath
    // return this.userAvator
    // },
    cacheList() {
      return [
        'ParentView',
        ...(this.tagNavList.length
          ? this.tagNavList
              .filter(item => !(item.meta && item.meta.notCache))
              .map(item => item.name)
          : [])
      ]
    },
    menuList() {
      return this.$store.getters.menuList
    },
    local() {
      return this.$store.state.app.local
    },
    hasReadErrorPage() {
      return this.$store.state.app.hasReadErrorPage
    },
    unreadCount() {
      return this.$store.state.user.unreadCount
    }
  },
  methods: {
    ...mapMutations([
      'setBreadCrumb',
      'setTagNavList',
      'addTag',
      'setLocal',
      'setHomeRoute'
    ]),
    ...mapActions(['handleLogin', 'getUnreadMessageCount']),
    turnToPage(route) {
      let { name, params, query } = {}
      if (typeof route === 'string') name = route
      else {
        name = route.name
        params = route.params
        query = route.query
      }
      if (name.indexOf('isTurnByHref_') > -1) {
        window.open(name.split('_')[1])
        return
      }
      this.$router.push({
        name,
        params,
        query
      })
    },
    handleCollapsedChange(state) {
      this.collapsed = state
    },
    handleCloseTag(res, type, route) {
      if (type === 'all') {
        this.turnToPage(this.$config.homeName)
      } else if (routeEqual(this.$route, route)) {
        if (type !== 'others') {
          const nextRoute = getNextRoute(this.tagNavList, route)
          this.$router.push(nextRoute)
        }
      }
      this.setTagNavList(res)
    },
    handleClick(item) {
      this.turnToPage(item)
    },
    initNotReadMessage() {
      var param = {
        isActive: 0,
        messageId: 0,
        isRead: 0
      }
      allByAdminMessage(this, param)
        .then(response => {
          if (response.data.code === ResponseStatus.OK) {
            const len = response.data.data.total
            if (len > 0) {
              this.guarantee = 1
              this.tempGuaranteeCount = len
            } else {
              this.guarantee = 0
              this.tempGuaranteeCount = 0
            }
          }
          param.messageId = -1
          allByAdminMessage(this, param)
            .then(response => {
              const len = response.data.data.total
              if (len > 0) {
                this.expert = 1
                this.tempExpertCount = len
              } else {
                this.expert = 0
                this.tempExpertCount = 0
              }
              param.messageId = -2
              allByAdminMessage(this, param)
                .then(response => {
                  const len = response.data.data.total
                  if (len > 0) {
                    this.consult = 1
                    this.tempConsultCount = len
                  } else {
                    this.consult = 0
                    this.tempConsultCount = 0
                  }
                })
                .catch(error => {
                  console.log(error)
                })
            })
            .catch(error => {
              console.log(error)
            })
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  watch: {
    $route(newRoute) {
      const { name, query, params, meta } = newRoute
      this.addTag({
        route: { name, query, params, meta },
        type: 'push'
      })
      this.setBreadCrumb(newRoute)
      this.setTagNavList(getNewTagList(this.tagNavList, newRoute))
      this.$refs.sideMenu.updateOpenName(newRoute.name)
    },
    tempGuaranteeCount(val) {
      this.messageCount = val + this.tempExpertCount + this.tempConsultCount
    },
    tempExpertCount(val) {
      this.messageCount = val + this.tempGuaranteeCount + this.tempConsultCount
    },
    tempConsultCount(val) {
      this.messageCount = val + this.tempGuaranteeCount + this.tempExpertCount
    }
  },
  mounted() {
    /**
     * @description 初始化设置面包屑导航和标签导航
     */
    this.setTagNavList()
    this.setHomeRoute(routers)
    this.addTag({
      route: this.$store.state.app.homeRoute
    })
    this.setBreadCrumb(this.$route)
    // 设置初始语言
    this.setLocal(this.$i18n.locale)
    // 如果当前打开页面不在标签栏中，跳到homeName页
    if (!this.tagNavList.find(item => item.name === this.$route.name)) {
      this.$router.push({
        name: this.$config.homeName
      })
    }
    // 获取未读消息条数
    this.getUnreadMessageCount()
    // 设置logo
    if (localStorage) {
      var sysInfo = localStorage.getItem(SYS_INFO_KEY)
      if (sysInfo !== undefined && sysInfo != null) {
        sysInfo = JSON.parse(sysInfo)
        if (
          sysInfo.menuIconMin !== null &&
          sysInfo.menuIconMin !== '' &&
          sysInfo.menuIconMin !== undefined
        ) {
          this.minLogo = sysInfo.menuIconMin
        }
        if (
          sysInfo.menuIconMax !== null &&
          sysInfo.menuIconMax !== '' &&
          sysInfo.menuIconMax !== undefined
        ) {
          this.maxLogo = sysInfo.menuIconMax
        }
        if (
          sysInfo.defaultHead !== null &&
          sysInfo.defaultHead !== '' &&
          sysInfo.defaultHead !== undefined
        ) {
          this.userAvator = sysInfo.defaultHead
        }
      }
    }
    // 初始化未读消息
    var myThis = this
    setInterval(function() {
      myThis.initNotReadMessage()
    }, 6000)
  }
}
</script>
