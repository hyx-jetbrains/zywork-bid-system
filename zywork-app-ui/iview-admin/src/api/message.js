import axios from '@/libs/api.request'
import * as ResponseStatus from '@/api/response-status'
import * as utils from '@/api/utils'
import Qs from 'qs'
/**
 * 获取保函申请和专家预约未读消息
 * @param self this
 * @param param
 */
export const allByAdminMessage = (self, param) => {
  return new Promise((resolve, reject) => {
    axios.request({
      url: '/user-message/admin/user-message',
      method: 'POST',
      data: param
    }).then(response => {
      resolve(response)
    }).catch(error => {
      console.log(error)
      reject(error)
    })
  })
}

/**
 * 读取保函申请和专家预约未读消息
 * @param self this
 * @param type
 */
export const readMessage = (self, type) => {
  return new Promise((resolve, reject) => {
    axios.request({
      url: '/user-message/admin/read-user-message/' + type,
      method: 'GET',
      data: {}
    }).then(response => {
      self.$emit('initNotReadMessage')
      resolve(response)
    }).catch(error => {
      console.log(error)
      reject(error)
    })
  })
}
