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
	IMAGE_BASE_URL,
	isPhone
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
	if (!isPhone(self.builderReq.phone)) {
		showInfoToast("请输入正确的手机号");
		return false;
	}
	if (self.builderReq.memo === null
		|| self.builderReq.memo === undefined) {
		showInfoToast("请输入说明");
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
	if (!isPhone(self.builder.phone)) {
		showInfoToast("请输入正确的手机号");
		return false;
	}
	if (self.builder.memo === null
		|| self.builder.memo === undefined) {
		showInfoToast("请输入说明");
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
	if (!isPhone(self.aptitude.phone)) {
		showInfoToast("请输入正确的手机号");
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
	if (!isPhone(self.carpool.phone)) {
		showInfoToast("请输入正确的手机号");
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
	if (!isPhone(self.seekcar.phone)) {
		showInfoToast("请输入正确的手机号");
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
/** 
 * 发布其他岗位招聘表单验证
 */
export const checkRecruit = (self) => {
	if (self.recruit.jobTitle === null
		|| self.recruit.jobTitle === undefined) {
		showInfoToast("请输入招聘岗位");
		return false;
	}
	if (self.recruit.workYear === null
		|| self.recruit.workYear === undefined) {
		showInfoToast("请输入工作年限");
		return false;
	}
	return true;
}
/**
 * 发布岗位招聘-保存岗位招聘记录
 */
export const saveRecruit = (self, params) => {
	self.disabled.recruitBtn = true;
	if (!checkRecruit(self)) {
		self.disabled.recruitBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/recruit/user/release-recruit',
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
				self.recruit = {}
				self.initPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.recruitBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.recruitBtn = false;
		}
	})
}
/** 
 * 发布求带资料表单验证
 */
export const checkSeekData = (self) => {
	if (self.seekData.startAddr === null
		|| self.seekData.startAddr === undefined) {
		showInfoToast("请输入出发地点");
		return false;
	}
	if (self.seekData.endAddr === null
		|| self.seekData.endAddr === undefined) {
		showInfoToast("请输入目的地地点");
		return false;
	}
	if (self.seekData.dataCount === null
		|| self.seekData.dataCount === undefined) {
		showInfoToast("请输入资料数量");
		return false;
	}
	if (self.seekData.price === null
		|| self.seekData.price === undefined) {
		showInfoToast("请输入赏金");
		return false;
	}
	if (self.seekData.phone === null
		|| self.seekData.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	if (!isPhone(self.seekData.phone)) {
		showInfoToast("请输入正确的手机号");
		return false;
	}
	return true;
}
/**
 * 发布求带资料-保存求带资料记录
 */
export const saveSeekData = (self, params) => {
	self.disabled.seekDataBtn = true;
	if (!checkSeekData(self)) {
		self.disabled.seekDataBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/seek-data/user/release-seekData',
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
				self.seekData = {}
				self.initPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.seekDataBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.seekDataBtn = false;
		}
	})
}

/** 
 * 申请保函表单验证
 */
export const checkGuarantee = (self) => {
	if (self.guarantee.projectName === null
		|| self.guarantee.projectName === undefined) {
		showInfoToast("请选择招标项目");
		return false;
	}
	if (self.guarantee.guaranteePrice === null
		|| self.guarantee.guaranteePrice === undefined) {
		showInfoToast("请输入保函费");
		return false;
	}
	if (self.guarantee.applicant === null
		|| self.guarantee.applicant === undefined) {
		showInfoToast("请输入申请人");
		return false;
	}
	if (self.guarantee.name === null
		|| self.guarantee.name === undefined) {
		showInfoToast("请输入联系人");
		return false;
	}
	if (self.guarantee.phone === null
		|| self.guarantee.phone === undefined) {
		showInfoToast("请输入联系人");
		return false;
	}
	return true;
}
/**
 * 申请保函-保存申请保函记录
 */
export const saveGuarantee = (self, params) => {
	self.disabled.guaranteeBtn = true;
	if (!checkGuarantee(self)) {
		self.disabled.guaranteeBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/guarantee/user/release-guarantee',
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
				self.guarantee = {}
				self.initPicker();
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.guaranteeBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.guaranteeBtn = false;
		}
	})
}


/** 
 * 发布劳务求职信息表单验证
 */
export const checkLabour = (self) => {
	if (self.labour.name == null
		|| self.labour.name == undefined) {
		showInfoToast("请输入姓名");
		return false;
	}
	if (self.labour.phone === null
		|| self.labour.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	if (!isPhone(self.labour.phone)) {
		showInfoToast("请输入正确的手机号");
		return false;
	}
	if (self.labour.jobType === null
		|| self.labour.jobType === undefined) {
		showInfoToast("请输入求职类型");
		return false;
	}
	if (self.labour.workType === null
		|| self.labour.workType === undefined) {
		showInfoToast("请输入从事工种");
		return false;
	}
	if (self.labour.memo === null
		|| self.labour.memo === undefined) {
		showInfoToast("请输入说明");
		return false;
	}
	return true;
}
/**
 * 发布劳务信息-保存劳务求职记录
 */
export const saveLabour = (self, params) => {
	self.disabled.labourBtn = true;
	if (!checkLabour(self)) {
		self.disabled.labourBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/labour/user/release-labour',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.labour = {}
				self.initPicker();
				uni.navigateTo({
					url: '/pages-info-share/publish-result/publish-result'
				})
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.labourBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.labourBtn = false;
		}
	})
}

/** 
 * 发布劳务招聘信息表单验证
 */
export const checkLabourReq = (self) => {
	if (self.labourReq.compName == null
		|| self.labourReq.compName == undefined) {
		showInfoToast("请输入企业名称");
		return false;
	}
	if (self.labourReq.phone === null
		|| self.labourReq.phone === undefined) {
		showInfoToast("请输入手机号");
		return false;
	}
	if (!isPhone(self.labourReq.phone)) {
		showInfoToast("请输入正确的手机号");
		return false;
	}
	if (self.labourReq.jobType === null
		|| self.labourReq.jobType === undefined) {
		showInfoToast("请输入求职类型");
		return false;
	}
	if (self.labourReq.workType === null
		|| self.labourReq.workType === undefined) {
		showInfoToast("请输入从事工种");
		return false;
	}
	if (self.labourReq.memo === null
		|| self.labourReq.memo === undefined) {
		showInfoToast("请输入说明");
		return false;
	}
	return true;
}
/**
 * 发布劳务信息-保存劳务招聘记录
 */
export const saveLabourReq = (self, params) => {
	self.disabled.labourReqBtn = true;
	if (!checkLabourReq(self)) {
		self.disabled.labourReqBtn = false;
		return;
	}
	uni.showLoading({
		title: '发布中'
	})
	uni.request({
		url: BASE_URL + '/labour-req/user/release-labour-req',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.labourReq = {}
				self.initPicker();
				uni.navigateTo({
					url: '/pages-info-share/publish-result/publish-result'
				})
			} else {
				showInfoToast(res.data.message);
			}
			self.disabled.labourReqBtn = false;
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
			self.disabled.labourReqBtn = false;
		}
	})
}