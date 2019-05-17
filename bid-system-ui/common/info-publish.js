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
	self.builderReq.salary *= 100;
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
				self.initPicker();
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
				self.builder.resourceId = []
				self.imageList = []
				self.initPicker();
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

/** 
 * 发布资质转让表单验证
 */
export const checkAptitude = (self) => {
	if (self.aptitude.phone === null
		|| self.aptitude.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	return true;
}
/**
 * 发布资质转让-保存资质转让记录
 */
export const saveAptitude = (self, params) => {
	self.disabled.aptitudeBtn = true;
	if (!checkAptitude(self)) {
		self.disabled.aptitudeBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/aptitude-transfer/user/release-aptitudeTransfer',
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
				self.aptitude = {}
				self.aptitude.resourceId = []
				self.imageList = []
				self.initPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.aptitudeBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.aptitudeBtn = false;
		}
	})
}

/** 
 * 发布开标拼车表单验证
 */
export const checkCarpool = (self) => {
	if (self.carpool.projectName === null
		|| self.carpool.projectName === undefined) {
		showInfoToast("请选择开标项目");
		return false;
	}
	if (self.carpool.startCity === null
		|| self.carpool.startCity === undefined) {
		showInfoToast("请选择出发城市");
		return false;
	}
	if (self.carpool.startAddr === null
		|| self.carpool.startAddr === undefined) {
		showInfoToast("请输入出发地点");
		return false;
	}
	if (self.carpool.endCity === null
		|| self.carpool.endCity === undefined) {
		showInfoToast("请选择目的地城市");
		return false;
	}
	if (self.carpool.endAddr === null
		|| self.carpool.endAddr === undefined) {
		showInfoToast("请输入目的地地点");
		return false;
	}
	if (self.carpool.carType === null
		|| self.carpool.carType === undefined) {
		showInfoToast("请选择汽车类型");
		return false;
	}
	if (self.carpool.peopleCount === null
		|| self.carpool.peopleCount === undefined) {
		showInfoToast("请输入搭载人数");
		return false;
	}
	if (self.carpool.price === null
		|| self.carpool.price === undefined) {
		showInfoToast("请输入价格");
		return false;
	}
	if (self.carpool.name === null
		|| self.carpool.name === undefined) {
		showInfoToast("请输入姓名");
		return false;
	}
	if (self.carpool.phone === null
		|| self.carpool.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	return true;
}
/**
 * 发布开标拼车-保存开标拼车记录
 */
export const saveCarpool = (self, params) => {
	self.disabled.carpoolBtn = true;
	if (!checkCarpool(self)) {
		self.disabled.carpoolBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	self.carpool.price *= 100;
	uni.request({
		url: BASE_URL + '/mark-carpool/user/release-markCarpool',
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
				self.carpool = {}
				self.initPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.carpoolBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.carpoolBtn = false;
		}
	})
}
/** 
 * 发布开标找车表单验证
 */
export const checkSeekcar = (self) => {
	if (self.seekcar.projectName === null
		|| self.seekcar.projectName === undefined) {
		showInfoToast("请选择开标项目");
		return false;
	}
	if (self.seekcar.startCity === null
		|| self.seekcar.startCity === undefined) {
		showInfoToast("请选择出发城市");
		return false;
	}
	if (self.seekcar.startAddr === null
		|| self.seekcar.startAddr === undefined) {
		showInfoToast("请输入出发地点");
		return false;
	}
	if (self.seekcar.endCity === null
		|| self.seekcar.endCity === undefined) {
		showInfoToast("请选择目的地城市");
		return false;
	}
	if (self.seekcar.endAddr === null
		|| self.seekcar.endAddr === undefined) {
		showInfoToast("请输入目的地地点");
		return false;
	}
	if (self.seekcar.name === null
		|| self.seekcar.name === undefined) {
		showInfoToast("请输入姓名");
		return false;
	}
	if (self.seekcar.phone === null
		|| self.seekcar.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	return true;
}
/**
 * 发布开标找车-保存开标找车记录
 */
export const saveSeekcar = (self, params) => {
	self.disabled.seekcarBtn = true;
	if (!checkSeekcar(self)) {
		self.disabled.seekcarBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/mark-seekcar/user/release-markSeekcar',
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
				self.seekcar = {}
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.seekcarBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.seekcarBtn = false;
		}
	})
}
