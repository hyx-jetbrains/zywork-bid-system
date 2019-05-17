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
 * 发布招聘信息表单验证
 */
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
		|| self.builderReq.phone === undefined) {
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
				self.vinitPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.buildeReqBtn = false;
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

/** 
 * 发布应聘信息表单验证
 */
export const checkBuilder = (self) => {
	if (self.builder.name == null
		|| self.builder.name == undefined) {
		showInfoToast("请输入姓名");
		return false;
	}
	if (self.builder.phone === null
		|| self.builder.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	return true;
}
/**
 * 发布建造师-保存应聘记录
 */
export const saveBuilder = (self, params) => {
	self.disabled.buildeBtn = true;
	if (!checkBuilder(self)) {
		self.disabled.buildeBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	self.builder.birthday = self.builder.birthday + ' 00:00:00';
	uni.request({
		url: BASE_URL + '/builder/user/release-builder',
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
				self.builder = {}
				self.vinitPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.buildeBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.buildeBtn = false;
		}
	})
}
