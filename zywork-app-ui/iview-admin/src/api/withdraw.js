import axios from '@/libs/api.request'
import Qs from 'qs'
import { getLocalStorageToken } from '@/libs/util'

/**
 * 用户提现审核，通过或未通过
 * @param {*} transactionNo 
 * @param {*} withdrawStatus 
 */
export const check = (transactionNo, withdrawStatus) => {
  return axios.request({
    url: '/withdraw/admin/check',
    method: 'POST',
    data: Qs.stringify({
      transactionNo: transactionNo,
      withdrawStatus: withdrawStatus
    }),
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      'Authorization': 'Bearer ' + getLocalStorageToken()
    }
  })
}

/**
 * 完成提现，成功或失败
 * @param {*} transactionNo 
 * @param {*} withdrawStatus 
 */
export const confirm = (transactionNo, withdrawStatus) => {
  return axios.request({
    url: '/withdraw/admin/confirm-human',
    method: 'POST',
    data: Qs.stringify({
      transactionNo: transactionNo,
      withdrawStatus: withdrawStatus
    }),
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      'Authorization': 'Bearer ' + getLocalStorageToken()
    }
  })
}