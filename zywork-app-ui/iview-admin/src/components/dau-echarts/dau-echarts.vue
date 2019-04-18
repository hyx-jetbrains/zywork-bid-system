<template>
  <div>
    <Row>
      <i-col :xs="24" :md="24" :lg="24" style="margin-bottom: 20px;">
        <Card shadow>
          <DatePicker @on-change="setDauSearchDate" type="daterange" split-panels placeholder="选择查询周期" style="width: 200px" />
          <Divider />
          <BasicEcharts ref="dauEcharts" style="height: 300px;" :xAxisData="dauXAxisData" :seriesData="dauSeriesData" :text="dauTitle" :titleName="dauTitleName"/>
        </Card>
      </i-col>
    </Row>
    <Row>
      <Card shadow>
        <DatePicker @on-change="setRegCountSearchDate" type="daterange" split-panels placeholder="选择查询周期" style="width: 200px" />
        <Divider />
        <BasicEcharts style="height: 310px;" ref="regCountCharts" :xAxisData="regCountXAxisData" :seriesData="regCountSeriesData" :text="regCountTitle" :titleName="regCountTitleName" />
      </Card>
    </Row>
  </div>
</template>

<script>
import {allDau, dauByDate, regCountByDate } from '@/api/home'
import {getDate} from '@/api/utils'
import BasicEcharts from '../charts/BasicEcharts'
import * as ResponseStatus from '@/api/response-status'

export default {
  name: 'DauEcharts',
  components: {
    BasicEcharts
  },
  data() {
    return {
      dauTitleName: '活跃用户量统计',
      dauTitle: '用户活跃量统计',
      dauXAxisData: '活跃用户',
      dauSeriesData: '',
      dauBeginDate: '',
      dauEndDate: '',
      regCountTitle: '新增用户',
      regCountTitleName: '新增用户量统计',
      regCountXAxisData: '',
      regCountSeriesData: '',
      regCountBeginDate: '',
      regCountEndDate: ''
    }
  },
  mounted() {
    this.initDauData()
    this.initRegCountData()
  },
  methods: {
    initDauData() {
      // 初始化活跃用户数据
      if (this.dauBeginDate === '') {
        this.dauBeginDate = getDate(-6)
      }
      if (this.dauEndDate === '') {
        this.dauEndDate = getDate(0)
      }
      const params = {
        beginDateStr: this.dauBeginDate,
        endDateStr: this.dauEndDate
      }
      dauByDate(params)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.dauTitle = data.message
            this.dauXAxisData = data.data.xAxisData
            this.dauSeriesData = data.data.seriesData
            this.$refs.dauEcharts.initData()
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    initRegCountData() {
      // 初始化注册统计数据
      if (this.regCountBeginDate === '') {
        this.regCountBeginDate = getDate(-6)
      }
      if (this.regCountEndDate === '') {
        this.regCountEndDate = getDate(0)
      }
      const params = {
        beginDateStr: this.regCountBeginDate,
        endDateStr: this.regCountEndDate
      }
      regCountByDate(params)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.regCountTitle = data.message
            this.regCountXAxisData = data.data.xAxisData
            this.regCountSeriesData = data.data.seriesData
            this.$refs.regCountCharts.initData()
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    setDauSearchDate(time) {
      const date = time.toString().split(",")
      this.dauBeginDate = date[0]
      this.dauEndDate = date[1]
      this.initDauData()
    },
    setRegCountSearchDate(time) {
      const date = time.toString().split(",")
      this.regCountBeginDate = date[0]
      this.regCountEndDate = date[1]
      this.initRegCountData()
    }
  }
}
</script>

<style lang="less">
</style>
