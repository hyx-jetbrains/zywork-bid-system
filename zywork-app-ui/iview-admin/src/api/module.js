import axios from '@/libs/api.request'

/**
 * 获取所有模块
 */
export const getAllModule = () => {
    return axios.request({
      url: '/module/admin/all',
      method: 'GET',
      data: ''
    })
  }

/**
 * 根据模块id获取模块信息
 */
export const getModuleById = (id) => {
    return axios.request({
      url: '/module/admin/one/' + id,
      method: 'GET',
      data: ''
    })
}