import axios from '@/libs/api.request'
import Qs from 'qs'
/**
 * 登入
 */
export const login = (loginView) => {
  return axios.request({
    url: '/auth/login',
    method: 'POST',
    data: Qs.stringify(loginView.loginForm),
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      'Authorization': ''
    }
  })
}
/**
* 获取用户信息
*/
export const getUserInfo = () => {
  return axios.request({
    url: '/user-userdetail/user/get',
    method: 'GET',
    data: ''
  })
}

/**
* 退出登入
*/
export const logout = () => {
  return axios.request({
    url: '/auth/logout',
    method: 'GET',
    data: ''
  })
}

/**
 * 获取用户详细信息
 * @param {*} id 用户id
 */
export const getUserDetail = (id) => {
  return axios.request({
    url: '/user-userdetail/admin/multi/' + id,
    method: 'GET',
    data: ''
  })
}

/**
 * 修改用户登入密码
 */
export const updateLoaginPassword = (params) => {
  return axios.request({
    url: '/pwd/update-login',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 分配用户角色
 */
export const saveUserRole = (params) => {
  return axios.request({
    url: '/user-role/admin/batch-save',
    method: 'POST',
    data: params
  })
}

export const updateUserInfo = (params) => {
  return axios.request({
    url: 'user-detail/user/update',
    method: 'POST',
    data: params
  })
}

export const getUnreadCount = () => {
  return axios.request({
    url: 'message/count',
    method: 'get'
  })
}

export const getMessage = () => {
  return axios.request({
    url: 'message/init',
    method: 'get'
  })
}

export const getContentByMsgId = msg_id => {
  return axios.request({
    url: 'message/content',
    method: 'get',
    params: {
      msg_id
    }
  })
}

export const hasRead = msg_id => {
  return axios.request({
    url: 'message/has_read',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const removeReaded = msg_id => {
  return axios.request({
    url: 'message/remove_readed',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const restoreTrash = msg_id => {
  return axios.request({
    url: 'message/restore',
    method: 'post',
    data: {
      msg_id
    }
  })
}
