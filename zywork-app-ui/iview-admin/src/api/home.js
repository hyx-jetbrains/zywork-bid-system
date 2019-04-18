import axios from '@/libs/api.request'
import Qs from 'qs'
/**
 * 统计注册用户数，包括所有注册用户数，今日新增注册用户数，昨日新增注册用户数
 */
export const regCount = () => {
  return axios.request({
    url: '/user-liveness-stat/reg-count',
    method: 'POST',
    data: ''
  })
}

/**
 * 指定时间周期内的总新增用户数
 */
export const regAllCountByDate = (params) => {
  return axios.request({
    url: '/user-liveness-stat/reg-all-count-by-date',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 获取指定周期内的总活跃用户数
 */
export const allDau = (params) => {
  return axios.request({
    url: '/user-liveness-stat/all-dau',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 获取指定周期内的每日活跃用户数（用于echarts统计）
 */
export const dauByDate = (params) => {
  return axios.request({
    url: '/user-liveness-stat/dau-by-date',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 指定时间周期内的每日新增用户数（用于echarts统计）
 */
export const regCountByDate = (params) => {
  return axios.request({
    url: '/user-liveness-stat/reg-count-by-date',
    method: 'POST',
    data: Qs.stringify(params)
  })
}
