<template>
  <div ref="dom"></div>
</template>

<script>
import echarts from 'echarts'
import { on, off } from '@/libs/tools'
export default {
  name: 'serviceRequests',
  props: {
    xAxisData: '',
    seriesData: ''
  },
  data() {
    return {
      dom: null
    }
  },
  methods: {
    resize() {
      this.dom.resize()
    },
    initData() {
      this.$nextTick(() => {
        let xAxisData = this.xAxisData
        let seriesData = this.seriesData
        const option = {
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              label: {
                backgroundColor: '#6a7985'
              }
            }
          },
          grid: {
            top: '3%',
            left: '1.2%',
            right: '1%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [
            {
              type: 'category',
              boundaryGap: false,
              data: xAxisData
            }
          ],
          yAxis: [
            {
              type: 'value'
            }
          ],
          series: [
            {
              name: '新增用户',
              type: 'line',
              stack: '总量',
              areaStyle: {
                normal: {
                  color: '#2d8cf0'
                }
              },
              data: seriesData
            }
          ]
        }
        this.$nextTick(() => {
          this.dom = echarts.init(this.$refs.dom)
          this.dom.setOption(option)
          on(window, 'resize', this.resize)
        })
      })
    }
  },
  mounted() {
    this.initData()
  },
  beforeDestroy() {
    off(window, 'resize', this.resize)
  }
}
</script>
