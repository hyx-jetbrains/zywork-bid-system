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
 * 查询公司信息
 */
export const getCompanyList = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/company/any/pager-cond',
		method: 'POST',
		data: params,
		header: '',
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.companyList = res.data.data.rows;
				self.initCheckBoxSelected();
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 根据UserId查询我的订阅
 */
export const getSubscribeByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/subscribe/user/getByUserId',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if (res.data.data.id !== null) {
					// 有查询到之前保存的订阅信息
					self.subscrible = res.data.data
					self.subscrible.minMoney /= 100;
					self.subscrible.maxMoney /= 100;
					self.setValue();
				}
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 保存我的订阅
 */
export const saveSubscribe = (self, params) => {
	uni.showLoading({
		title: '正在保存'
	})
	uni.request({
		url: BASE_URL + '/subscribe/user/save',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast('保存订阅成功')
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我发布的建造师应聘信息
 */
export const getBuilderByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserBuilder/user/list-builder-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.builderList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我发布的建造师应聘信息
 */
export const deleteBuilderById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/builder/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast(res.data.message)
				getBuilderByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我发布的建造师招聘信息
 */
export const getBuilderReqByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserBuilderReq/user/list-builderReq-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.builderReqList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我发布的建造师招聘信息
 */
export const deleteBuilderReqById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/builder-req/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast(res.data.message)
				getBuilderReqByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我发布的资质转让
 */
export const getAptitudeTransfeByUserId = (self,type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserAptitudeTransfer/user/list-aptitudeTransfer-page',
		method: 'POST',
		data: {
			'aptitudeTransferType': type
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if(type == 0) {
					self.aptitudeBuyList = res.data.data.rows
				} else {
					self.aptitudeSellList = res.data.data.rows
				}
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我发布的资质转让
 */
export const deleteAptitudeTransferById = (self,id,type) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/aptitude-transfer/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				getAptitudeTransfeByUserId(self, type)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的开标拼车--车主找人
 */
export const getMarkCarpoolByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserMarkCarpool/user/list-markCarpool-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.carpoolList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我的开标拼车--车主找人
 */
export const deleteMarkCarpoolById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/mark-carpool/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				getMarkCarpoolByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的开标拼车--人找车
 */
export const getMarkSeekcarByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserMarkSeekcar/user/list-markSeekcar-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.seekcarList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我的开标拼车--人找车
 */
export const deleteMarkSeekcarById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/mark-seekcar/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				getMarkSeekcarByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我发布岗位招聘
 */
export const getRecruitByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserRecruit/user/list-recruit-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.recruitList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我发布岗位招聘
 */
export const deleteRecruitById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/recruit/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				getRecruitByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的求带资料
 */
export const getSeeDataByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserSeekData/user/list-seekData-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.seekDataList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我的求带资料
 */
export const deleteSeekDataById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/seek-data/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				getSeeDataByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的申请保函
 */
export const getGuaranteeByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserGuarantee/user/list-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.guaranteeList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 删除我的申请保函
 */
export const deleteGuaranteeById = (self,id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/guarantee/user/delete/'+id,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				getGuaranteeByUserId(self)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的收藏
 */
export const getProjectCollectionByUserId = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/project/user/list-projectCollection-page',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.projects = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的预约
 */
export const getExpertSubscribeByUserId = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/expersubscribe/user/list-page',
		method: 'POST',
		data: {
			'subscribeStatus': params.subscribeStatus,
			'payStatus': params.payStatus
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.expertSubscribeList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的咨询
 */
export const getConsultByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/consult/user/list-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.consultList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 咨询
 */
export const createConsult = (self, params) => {
	uni.showLoading({
		title: '正在保存'
	})
	uni.request({
		url: BASE_URL + '/consult/user/save',
		method: 'POST',
		data: {
			'questionTypeId': params.questionTypeId,
			'consultDesc': params.consultDesc
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			showInfoToast(res.data.message)
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的简历
 */
export const resume = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/resume/user/getByUserId',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.formInfo = res.data.data
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 保存我的简历
 */
export const saveResume = (self, params) => {
	uni.showLoading({
		title: '正在保存'
	})
	uni.request({
		url: BASE_URL + '/resume/user/save',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			showInfoToast(res.data.message)
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的抵扣券
 */
export const getCouponByUserId = (self,params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserUserCoupon/user/list-page/'+params.status,
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.couponList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 我的抵扣券使用记录
 */
export const getCouponRecordByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserCouponRecord/user/list-page',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.couponRecordlList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 常见问题
 */
export const getOftenQuerstion = (self, questionTypeId) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/often-question/user/list-page',
		method: 'POST',
		data: {
			'questionTypeId': questionTypeId
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.oftenQuestionList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}

/**
 * 常见问题详情
 */
export const getOftenQuerstionDetail = (self,id) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/often-question/user/getById?id='+id,
		method: 'GET',
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.oftenQuestionList = res.data.data.rows
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading()
		}
	})
}