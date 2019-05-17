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
		complete: () => {}
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
		complete: () => {}
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
		complete: () => {}
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
		complete: () => {}
	})
}
/** 发布招聘信息表单验证 */
export const checkBuilderReq = (self) => {
	if (self.builderReq.name == null
		|| self.builderReq.name == undefined) {
		showInfoToast("请输入姓名");
		return false;
	}
	if (self.builderReq.people === null
		|| self.builderReq.people === undefined) {
		showInfoToast("请输入所需人才");
		return false;
	}
	if (self.builderReq.peopleCount === null
		|| self.builderReq.peopleCount === undefined) {
		showInfoToast("请输入所需人才数量");
		return false;
	}
	if (self.builderReq.compAddr === null
		|| self.builderReq.compAddr === undefined) {
		showInfoToast("请输入公司地址");
		return false;
	}
	if (self.builderReq.compName === null
		|| self.builderReq.compName === undefined) {
		showInfoToast("请输入公司名称");
		return false;
	}
	if (self.builderReq.phone === null
		|| self.builderReq.compName === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	return true;
}
/**
 * 发布建造师-保存招聘记录
 */
export const saveBuilderReq = (self, params) => {
	self.disabled.buildeReqBtn = true;
	if (!checkBuilderReq(self)) {
		self.disabled.buildeReqBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	self.builderReq.salary = self.builderReq.salary * 100;
	uni.request({
		url: BASE_URL + '/builder-req/user/release-builderReq',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				uni.navigateTo({
					url: '/pages-info-share/publish-result/publish-result'
				})
				self.builderReq = {}
			} else {
				showInfoToast(res.data.message);
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.buildeReqBtn = false;
		}
	})
}
