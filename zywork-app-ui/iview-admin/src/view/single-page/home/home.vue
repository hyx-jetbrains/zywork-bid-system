<template>
  <div>
    <Row :gutter="20">
      <i-col
        :xs="12"
        :md="8"
        :lg="4"
        v-for="(infor, i) in inforCardData"
        :key="`infor-${i}`"
        style="height: 120px;padding-bottom: 10px;margin-bottom:10px;">
        <infor-card shadow :color="infor.color" :icon="infor.icon" :icon-size="36">
          <count-to :end="infor.count" count-class="count-style"/>
          <p>{{ infor.title }}</p>
        </infor-card>
      </i-col>
    </Row>
    <Row style="margin-bottom: 20px;">
      <i-col :xs="24" :md="12" :lg="8">
        <Card>
          <p slot="title">
              <Icon type="ios-alarm"></Icon>
                指派人任务&nbsp;&nbsp;-（{{assigneeCount}}）
          </p>
          <a href="javascript:;" slot="extra" @click="showTaskDetail(0)">
            <Tooltip content="更多">
              <Icon type="ios-more"></Icon>
            </Tooltip>
          </a>
          <p class="not-data" v-if="assigneeDataShow">
            <Icon type="md-close-circle" /> 暂无任务
          </p>
          <ul style="list-style-type:none" v-if="!assigneeDataShow">
            <Tooltip content="点击查看详情">
              <li v-for="(item,index) in assigneeTaskList" :key="index">
                <a href="javascript:;" @click="showTaskDetail(0)">{{ item.name }}</a>
              </li>
            </Tooltip>
        </ul>
        </Card>
      </i-col>
      <i-col :xs="24" :md="12" :lg="8">
        <Card>
          <p slot="title">
              <Icon type="ios-alarm-outline"></Icon>
                候选人任务&nbsp;&nbsp;-（{{candidateCount}}）
          </p>
          <a href="javascript:;" slot="extra" @click="showTaskDetail(1)">
            <Tooltip content="更多">
              <Icon type="ios-more"></Icon>
            </Tooltip>
          </a>
          <p class="not-data" v-if="candidateDataShow">
            <Icon type="md-close-circle" /> 暂无任务
          </p>
          <ul style="list-style-type:none" v-if="!candidateDataShow">
            <Tooltip content="点击查看详情">
              <li v-for="(item,index) in candidateTaskList" :key="index">
                <a href="javascript:;" @click="showTaskDetail(1)">{{ item.name }}</a>
              </li>
            </Tooltip>
        </ul>
        </Card>
      </i-col>
      <i-col :xs="24" :md="12" :lg="8">
        <Card>
          <p slot="title">
              <Icon type="md-alarm"></Icon>
                候选组任务&nbsp;&nbsp;-（{{groupCount}}）
          </p>
          <a href="javascript:;" slot="extra" @click="showTaskDetail(2)">
            <Tooltip content="更多">
              <Icon type="ios-more"></Icon>
            </Tooltip>
          </a>
          <p class="not-data" v-if="groupDataShow">
            <Icon type="md-close-circle" /> 暂无任务
          </p>
          <ul style="list-style-type:none" v-if="!groupDataShow">
            <Tooltip content="点击查看详情">
              <li v-for="(item,index) in groupTaskList" :key="index">
                <a href="javascript:;" @click="showTaskDetail(1)">{{ item.name }}</a>
              </li>
            </Tooltip>
        </ul>
        </Card>
      </i-col>
    </Row>
    <DauEcharts/>
  </div>
</template>

<script>
import { regCount, regAllCountByDate, allDau} from '@/api/home'
import {searchWaitTask} from '@/api/process'
import {getDate} from '@/api/utils'
import InforCard from '_c/info-card'
import CountTo from '_c/count-to'
import DauEcharts from '_c/dau-echarts'
import * as ResponseStatus from '@/api/response-status'

export default {
  name: 'home',
  components: {
    InforCard,
    CountTo,
    DauEcharts
  },
  data() {
    return {
      inforCardData: [
        { title: '总用户数', icon: 'ios-people', count: 0, color: '#2d8cf0' },
        {
          title: '昨日新增',
          icon: 'ios-person-add-outline',
          count: 0,
          color: '#ff9900'
        },
        {
          title: '今日新增',
          icon: 'ios-person-add',
          count: 0,
          color: '#ed3f14'
        },
        {
          title: '一周新增',
          icon: 'md-person-add',
          count: 0,
          color: '#E46CBB'
        },
        { title: '一周活跃', icon: 'md-map', count: 0, color: '#9A66E4' }
      ],
      taskUrls: {
        assigneeTasksUrl: '/process-activiti/admin/query/assignee-tasks',
        candidateTasksUrl: '/process-activiti/admin/query/candidate-tasks',
        groupTasksUrl: '/process-activiti/admin/query/group-tasks'
      },
      taskParamForm: {
        pageNo: 1,
        pageSize: 3
      },
      assigneeDataShow: true,
      assigneeCount: 0,
      assigneeTaskList: [],
      candidateDataShow: true,
      candidateCount: 0,
      candidateTaskList: [],
      groupDataShow: true,
      groupCount: 0,
      groupTaskList: [],
    }
  },
  mounted() {
    this.initInforCardData()
  },
  methods: {
    // 初始化跳动的数字数据，从后台取
    initInforCardData() {
      // 取注册数据
      regCount()
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.inforCardData[0].count = data.data[0]
            this.inforCardData[1].count = data.data[1][0].totalCount
            this.inforCardData[2].count = data.data[1][1].totalCount
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
      // 本周开始时间
      const beginDate = getDate(-6)
      // 本周结束时间
      const endDate = getDate(0)
      const weekParams = {
        beginDateStr: beginDate,
        endDateStr: endDate
      }
      // 取本周总新增用户数
      regAllCountByDate(weekParams)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.inforCardData[3].count = data.data === null ? 0 : data.data
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
      // 取本周总活跃用户数
      allDau(weekParams)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.inforCardData[4].count = data.data === null ? 0 : data.data
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })

      // 取指派人任务
      this.assigneeDataShow = true
      searchWaitTask(this, this.taskUrls.assigneeTasksUrl)
        .then(res => {
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            self.$Message.error(res.data.message)
            return
          }
          this.assigneeCount = data.data.total
          if (data.data.total === 0) {
            this.assigneeDataShow = true
          } else {
            this.assigneeDataShow = false
            this.assigneeTaskList = data.data.rows
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
      // 取候选人任务
      this.candidateDataShow = true
      searchWaitTask(this, this.taskUrls.candidateTasksUrl)
        .then(res => {
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            self.$Message.error(res.data.message)
            return
          }
          this.candidateCount = data.data.total
          if (data.data.total === 0) {
            this.candidateDataShow = true
          } else {
            this.candidateDataShow = false
            this.candidateTaskList = data.data.rows
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
      // 取候选组任务
      this.groupDataShow = true
      searchWaitTask(this, this.taskUrls.groupTasksUrl)
        .then(res => {
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            self.$Message.error(res.data.message)
            return
          }
          this.groupCount = data.data.total
          if (data.data.total === 0) {
            this.groupDataShow = true
          } else {
            this.groupDataShow = false
            this.groupTaskList = data.data.rows
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    showTaskDetail(type) {
      this.$router.push({
        name: 'activiti_tasks',
        params: {
          type: type
        }
      })
    }
  }
}
</script>

<style lang="less">
.count-style {
  font-size: 50px;
}
.not-data {
  text-align: center;
  color: #515a6e;
}
</style>
