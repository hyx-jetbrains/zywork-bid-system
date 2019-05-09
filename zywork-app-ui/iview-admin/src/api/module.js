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

/**
 * 根据优惠券id查询信息
 * @param {*} id 
 */
export const getCouponById = (id) => {
  return axios.request({
    url: '/coupon/admin/one/' + id,
    method: 'GET',
    data: ''
  })
}

/**
 * 根据用户id查询企业信息
 * @param {*} id 
 */
export const getCompanyById = (id) => {
	return axios.request({
		url: '/company/admin/one/' + id,
		method: 'GET',
		data: ''
	})
}

/**
 * 根据建造师id查询
 */
export const getBuilderById = (id) => {
	return axios.request({
		url: '/builder/admin/one/' + id,
		method: 'GET',
		data: ''
	})
}

/**
 * 根据资质id查询
 */
export const getAptitudeTransferById = (id) => {
	return axios.request({
		url: '/aptitude-transfer/admin/one/' + id,
		method: 'GET',
		data: ''
	})
}

/**
 * 根据问题类型id查询
 */
export const getExpertQuestionTypeById = (id) => {
	return axios.request({
		url: '/experquestion-type/admin/one/' + id,
		method: 'GET',
		data: ''
	})
}

/**
 * 根据问题类型id查询
 */
export const getuserExpertById = (id) => {
	return axios.request({
		url: '/user-expert/admin/one/' + id,
		method: 'GET',
		data: ''
	})
}