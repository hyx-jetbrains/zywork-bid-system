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

/**
 * 根据用户id查询用户信息
 * @param {*} id 
 */
export const getUserById = (id) => {
	return axios.request({
		url: '/user-userdetail/admin/multi/' + id,
		method: 'GET',
		data: ''
	})
}

/**
 * 根据项目id查询项目信息
 * @param {*} id 
 */
export const getProjectById = (id) => {
  return axios.request({
    url: '/project/admin/one/' + id,
    method: 'GET',
    data: ''
  })
}