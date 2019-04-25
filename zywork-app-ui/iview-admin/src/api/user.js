import axios from '@/libs/api.request'
import Qs from 'qs'
import * as ResponseStatus from '@/api/response-status'
import * as utils from '@/api/utils'
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

/**
 * 隐藏或开放简历
 * @param self this
 * @param row 需要隐藏或开放的数据对象
 */
export const setResumeIsShow = (self, row) => {
  return new Promise((resolve, reject) => {
    let isShow = row.isShow === 0 ? 1 : 0
    axios.request({
      url: self.urls.activeUrl,
      method: 'POST',
      data: {
        id: row.id,
        isShow: isShow
      }
    }).then(response => {
      if (response.data.code !== ResponseStatus.OK) {
        self.$Message.error(response.data.message)
      } else {
        self.$Message.success("隐藏或开放成功")
      }
      utils.search(self)
      resolve(response)
    }).catch(error => {
      console.log(error)
      self.$Message.error('隐藏或开放数据失败，稍候再试')
      reject(error)
    })
  })
}

/**
 * 设置是否允许推荐
 * @param self this
 * @param row 需要设置的对象
 */
export const setResumeIsRecommend = (self, row) => {
  return new Promise((resolve, reject) => {
    let isRecommend = row.isRecommend === 0 ? 1 : 0
    axios.request({
      url: self.urls.activeUrl,
      method: 'POST',
      data: {
        id: row.id,
        isRecommend: isRecommend
      }
    }).then(response => {
      if (response.data.code !== ResponseStatus.OK) {
        self.$Message.error(response.data.message)
      } else {
        self.$Message.success("设置成功")
      }
      utils.search(self)
      resolve(response)
    }).catch(error => {
      console.log(error)
      self.$Message.error('设置失败，稍候再试')
      reject(error)
    })
  })
}
