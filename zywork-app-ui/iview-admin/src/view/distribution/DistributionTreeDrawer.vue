<template>
  <div>
    <Drawer
        title="分销等级"
        :closable="true"
        :mask-closable="false"
        @on-close="closeDrawer"
        v-model="drawerFlag"
        width="40"
      >
        <Tree :data="distributionData" :load-data="loadData" :render="renderContent" scrollable ref="distributionTree"></Tree>
        <Spin size="large" fix v-if="spinShow"></Spin>
      </Drawer>
  </div>
</template>
<script>
import {directBelowUsers, directAboveUsers} from '@/api/distribution'
import headImg from '@/assets/images/head.png'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'DistributionTreeDrawer',
  props: {},
  data() {
    return {
      drawerFlag: false,
      spinShow: false,
      direction: null, 
      distributionData: [
        {
          id: null,
          nickname: null,
          phone: null,
          headicon: null,
          total: 0,
          loading: false,
          children: []
        }
      ]
    }
  },
  mounted() {},
  methods: {
    renderContent (h, { root, node, data }) {
      return h('div', {
          style: {
              display: 'inline-block',
              width: '100%'
          }
      }, [
          h('div', {
            style: {
              position: 'relative',
              marginBottom: '30px'
            }
          },[
              h('img', {
                attrs: {
                  src: data.headicon
                },
                style: {
                  width: '40px',
                  height: '40px',
                  borderRadius: '20px',
                  position: 'absolute',
                  top: '5px'
                }
              }),
              h('div',  {
                style: {
                  position: 'absolute',
                  left: '50px',
                  top: '15px'
                }
              }, [
                h('span', {
                  style: {
                    marginRight: '10px'
                  }
                }, data.nickname),
                h('span', {
                  style: {
                    marginRight: '10px'
                  }
                }, data.phone),
                h('span', {
                  style: {
                    marginRight: '10px'
                  }
                }, '总个数: ' + data.total)
              ])
          ])
      ]);
    },
    closeDrawer() {
      this.drawerFlag = false
      this.distributionData = [
        {
          id: null,
          nickname: null,
          phone: null,
          headicon: null,
          total: 0,
          loading: false,
          children: []
        }
      ]
    },
    initDistributionTreeData(userId, nickname, phone, headicon, direction) {
      this.drawerFlag = true
      this.spinShow = true
      this.distributionData[0].id = userId
      this.distributionData[0].nickname = nickname
      this.distributionData[0].phone = phone
      this.distributionData[0].headicon = headicon == null ? headImg : '/' + headicon
      this.direction = direction
      this.spinShow = false
    },
    loadData (item, callback) {
      if (this.direction === 'above') {
        this.aboveUsers(item, callback)
      } else if (this.direction === 'below') {
        this.belowUsers(item, callback)
      }
    },
    belowUsers(item, callback) {
      directBelowUsers(item.id).then(response => {
        let children = []
        if (response.data.code === ResponseStatus.OK) {
          if (response.data.data.total > 0) {
            item.total = response.data.data.total
            response.data.data.rows.forEach((row, index) => {
              children.push({
                id: row.userId,
                nickname: row.nickname,
                phone: row.phone,
                headicon: row.headicon == null ? headImg : '/' + row.headicon,
                total: 0,
                loading: false,
                children: []
              })
            })
          }
          callback(children)
          if (children.length === 0) {
            this.$Notice.info({
              title: '提示',
              desc: '此用户没有下级用户'
            })
          }
        } else {
          this.$Message.error(response.data.message)
        }
      }).catch(error => {
        console.log(error)
      })
    },
    aboveUsers(item, callback) {
      directAboveUsers(item.id).then(response => {
        let children = []
        if (response.data.code === ResponseStatus.OK) {
          if (response.data.data.total > 0) {
            item.total = response.data.data.total
            response.data.data.rows.forEach((row, index) => {
              children.push({
                id: row.userId,
                nickname: row.nickname,
                phone: row.phone,
                headicon: row.headicon == null ? headImg : '/' + row.headicon,
                total: 0,
                loading: false,
                children: []
              })
            })
          }
          callback(children)
          if (children.length === 0) {
            this.$Notice.info({
              title: '提示',
              desc: '此用户没有上级用户'
            })
          }
        } else {
          this.$Message.error(response.data.message)
        }
      }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>
