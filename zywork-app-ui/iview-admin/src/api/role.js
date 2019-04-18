import axios from '@/libs/api.request'

/**
 * 获取指定角色权限
 */
export const getMultiPermission = (params) => {
  return axios.request({
    url: '/role-permission/admin/multi/' + params,
    method: 'GET',
    data: ''
  })
}
/**
 * 获取当前登入用户的所有权限
 */
export const getUserPermission = () => {
  return axios.request({
    url: '/module-permission/user/all',
    method: 'GET',
    data: ''
  })
}

/**
 * 批量保存权限
 * @param {} params 参数
 */
export const batchSavePermission = (params) => {
  return axios.request({
    url: '/role-permission/admin/batch-save',
    method: 'POST',
    data: params
  })
}

/**
 * 根据用户id查询用户角色
 */
export const getUserRoleByUserId = (id) => {
  return axios.request({
    url: '/user-role/admin/multi/' + id,
    method: 'GET',
    data: ''
  })
}
