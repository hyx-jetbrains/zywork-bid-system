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
 * 我要拼车-保存拼车记录
 */
export const saveMarkCarpoolRecord = (self, carpoolId) => {
	uni.request({
		url: BASE_URL + '/mark-carpool-record/any/save-carpool-record/' + carpoolId,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.refreshCarpoolList();
				showSuccessToast(res.data.message);
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

/**
 * 我要拼车-获取拼车记录
 */
export const getMarkCarpoolRecord = (self, params) => {
	uni.request({
		url: BASE_URL + '/UserMarkCarpoolRecord/any/list-page',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.carpoolRecordList = res.data.data.rows;
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

/**
 * 我要找车-保存找车记录
 */
export const saveMarkSeekcarRecord = (self, seekcarId) => {
	uni.request({
		url: BASE_URL + '/mark-seekcar-record/any/save-seekcar-record/' + seekcarId,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.refreshSeekcarList();
				showSuccessToast(res.data.message);
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

/**
 * 我要找车-获取找车记录
 */
export const getMarkSeekcarRecord = (self, params) => {
	uni.request({
		url: BASE_URL + '/UserMarkSeekcarRecord/any/list-page',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.seekcarRecordList = res.data.data.rows;
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