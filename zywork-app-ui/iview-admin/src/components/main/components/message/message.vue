<template>
  <div>
    <Poptip title="消息提醒" placement="bottom" trigger="hover">
      <Badge dot :count="value" style="display: inline;">
        <Icon type="ios-notifications-outline" size="26"></Icon>
      </Badge>
      <div class="api" slot="content">
        <div v-if="guarantee === 1">
          您有新的保函申请通知：
          <a class="zy-search-link" @click="toGuaranteePage">立即查看</a>
        </div>
        <div v-else>
          暂无保函申请信息
        </div>
        <Divider :dashed="true" style="margin: 10px 0px;" />
        <div v-if="expert === 1">
          您有新的专家预约通知：
          <a class="zy-search-link" @click="toExpertPage">立即查看</a>
        </div>
        <div v-else>
          暂无专家预约信息
        </div>
        <Divider :dashed="true" style="margin: 10px 0px;" />
        <div v-if="consult === 1">
          您有新的用户咨询通知：
          <a class="zy-search-link" @click="toConsultPage">立即查看</a>
        </div>
        <div v-else>
          暂无用户咨询信息
        </div>
      </div>
    </Poptip>
  </div>
</template>

<script>
import { readMessage } from '@/api/message.js'
export default {
  name: 'Message',
  computed: {},
  props: {
    value: {
      type: Number,
      default: 0
    },
    guarantee: {
      type: Number,
      default: 0
    },
    expert: {
      type: Number,
      default: 0
    },
    consult: {
      type: Number,
      default: 0
    }
  },
  methods: {
    /**
     * 前往查看保函申请页面
     */
    toGuaranteePage() {
      readMessage(this, 0)
      this.$router.push({
        path: '/admin/Guarantee'
      })
    },
    /**
     * 前往专家预约页面
     */
    toExpertPage() {
      readMessage(this, -1)
      this.$router.push({
        path: '/admin/ExpertSubscribe'
      })
    },
    /**
     * 前往用户咨询页面
     */
    toConsultPage() {
      readMessage(this, -2)
      this.$router.push({
        path: '/admin/UserConsult'
      })
    }
  },
  mounted() {}
}
</script>

<style lang="less">
.top,
.bottom {
  text-align: center;
}
.center {
  width: 300px;
  margin: 10px auto;
  overflow: hidden;
}
.center-left {
  float: left;
}
.center-right {
  float: right;
}
.zy-search-link {
  color: #108EE9;
}
</style>
