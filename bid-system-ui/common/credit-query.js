import {
	BASE_URL,
	DEFAULT_HEADICON,
	saveUserToken,
	saveOpenid,
	isUserTokenExist,
	removeUserToken,
	getUserToken,
	clearForm,
	networkError,
	invalidToken,
	showInfoToast,
	showSuccessToast,
	IMAGE_BASE_URL
} from './util.js'
import * as ResponseStatus from './response-status.js'

/**
 * post请求获取列表信息，封装Promise
 */
export const getListInfoToPost = (self, url, params) => {
	return uni.request({
		url: BASE_URL + url,
		method: 'POST',
		data: params
	})
}

/**
 * 根据公司id，查询公司信息
 */
export const getCompanyInfoById = (self, id) => {
	uni.request({
		url: BASE_URL + '/company/any/one/' + id,
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.company = res.data.data;
			} else {
				showInfoToast(res.data.message);
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
		}
	})
}
