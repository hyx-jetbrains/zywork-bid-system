import axios from '@/libs/api.request'
import Qs from 'qs'
/**
 * 获取所有类名
 */
export const jobClassess = () => {
  return axios.request({
    url: '/scheduler/admin/job-classes',
    method: 'GET',
    data: ''
  })
}

/**
 * 修改定时任务的cron表达式并重新调度
 */
export const modify = (params) => {
  return axios.request({
    url: '/scheduler/admin/modify',
    method: 'POST',
    data: Qs.stringify(params)
  })
}
/**
 * 操作定时任务:启动，暂停，回复，停止，删除
 */
export const optJob = (url, params) => {
  return axios.request({
    url: url,
    method: 'POST',
    data: Qs.stringify(params)
  })
}
