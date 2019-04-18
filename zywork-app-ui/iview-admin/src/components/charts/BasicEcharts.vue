<template>
  <div ref="basicEcharts"></div>
</template>

<script>
import echarts from 'echarts'
import { on, off } from '@/libs/tools'
export default {
  name: 'BasicEcharts',
  props: {
    text: String,
    subtext: String,
    xAxisData: '',
    seriesData: '',
    titleName: ''
  },
  data() {
    return {
      basicEcharts: null
    }
  },
  methods: {
    resize() {
      this.basicEcharts.resize()
    },
    initData() {
      this.$nextTick(() => {
        let xAxisData = this.xAxisData
        let seriesData = this.seriesData
        let titleName = this.titleName
        const option = {
          title: {
            text: this.text,
            subtext: this.subtext,
            x: 'center'
          },
          tooltip: {
            trigger: 'axis'
          },
          toolbox: {
            show: true,
            feature: {
              dataZoom: {
                yAxisIndex: 'none'
              },
              dataView: { readOnly: false },
              magicType: { type: ['line', 'bar'] },
              restore: {},
              saveAsImage: {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: xAxisData
          },
          yAxis: {
            type: 'value',
            axisLabel: {
              formatter: '{value} 个'
            }
          },
          series: [
            {
              name: titleName,
              type: 'line',
              data: seriesData,
              markPoint: {
                data: [{ name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }]
              },
              markLine: {
                data: [
                  { type: 'average', name: '平均值' },
                  [
                    {
                      symbol: 'none',
                      x: '90%',
                      yAxis: 'max'
                    },
                    {
                      symbol: 'circle',
                      label: {
                        normal: {
                          position: 'start',
                          formatter: '最大值'
                        }
                      },
                      type: 'max',
                      name: '最高点'
                    }
                  ]
                ]
              }
            }
          ]
        }
        this.$nextTick(() => {
          this.basicEcharts = echarts.init(this.$refs.basicEcharts)
          this.basicEcharts.setOption(option)
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
