import axios from '@/libs/api.request'
import Qs from 'qs'

/**
 * 查询指定用户的直接上级用户
 * @param {*} userId 
 */
export const directAboveUsers = (userId) => {
    return axios.request({
        url: '/distribution/admin/direct-above',
        method: 'POST',
        data: Qs.stringify({
          userId: userId
        })
      })
}

/**
 * 查询指定用户的直接下级用户
 * @param {*} userId 
 */
export const directBelowUsers = (userId) => {
  return axios.request({
      url: '/distribution/admin/direct-below',
      method: 'POST',
      data: Qs.stringify({
        userId: userId
      })
    })
}