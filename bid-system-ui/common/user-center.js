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
	nullToStr,
	IS_VIP_COLOR_TRUE,
	IS_VIP_COLOR_FALSE,
	getCalendarDate,
	USER_FLAG,
	USER_FLAG_VIP,
	USER_FLAG_ORDINARY
} from './util.js'
import * as ResponseStatus from './response-status.js'


/**
 * 用户账户佣金明细
 */
export const getFundsTransferByUserId = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/funds-transfer/user/list-page',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.commissionList = nullToStr(res.data.data.rows)
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
 * 用户账户积分明细
 */
export const getAccountDetailByUserId = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/accoundetail/user/pager-cond',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.integralList = nullToStr(res.data.data.rows)
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
				self.companyList = nullToStr(res.data.data.rows);
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
 * 查询专家问题
 */
export const getExpertQuesTionTypeByUserId = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/experquestion-type/user/list-all',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.expertTypeList = nullToStr(res.data.data.rows)
				self.questionTypeId = res.data.data.rows[0].id
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
 * 申请成为专家
 */
export const saveExpert = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/user-expert/user/saveExpert/' + params.expertQuestionTypeId,
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast(res.data.message)

				setTimeout(function() {
					uni.switchTab({
						url: '/pages/user-center/user-center',
						success() {
							let page = getCurrentPages().pop();
							if (page == undefined || page == null) {
								return;
							}
							page.onLoad();
						}
					})
				}, 2000)
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
					self.subscrible = nullToStr(res.data.data)
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
		}
	})
}

/**
 * 我发布的建造师应聘信息
 */
export const getBuilderByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserBuilder/user/list-builder-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.builderList = rows
				} else if (type === 'pullDown') {
					self.builderList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.builderList = self.builderList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我发布的建造师应聘信息
 */
export const deleteBuilderById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/builder/user/delete/' + id,
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
export const getBuilderReqByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserBuilderReq/user/list-builderReq-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.builderReqList = rows
				} else if (type === 'pullDown') {
					self.builderReqList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.builderReqList = self.builderReqList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我发布的建造师招聘信息
 */
export const deleteBuilderReqById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/builder-req/user/delete/' + id,
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
export const getAptitudeTransfeByUserId = (self, type, tempType) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserAptitudeTransfer/user/list-aptitudeTransfer-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize,
			'aptitudeTransferType': tempType
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					if (tempType == 0) {
						self.aptitudeBuyList = rows
					} else {
						self.aptitudeSellList = rows
					}
				} else if (type === 'pullDown') {
					if (tempType == 0) {
						self.aptitudeBuyList = rows
					} else {
						self.aptitudeSellList = rows
					}
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						if (tempType == 0) {
							self.aptitudeBuyList = self.aptitudeBuyList.concat(rows)
						} else {
							self.aptitudeSellList = self.aptitudeSellList.concat(rows)
						}
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
export const deleteAptitudeTransferById = (self, id, type) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/aptitude-transfer/user/delete/' + id,
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
export const getMarkCarpoolByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserMarkCarpool/user/list-markCarpool-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.carpoolList = rows
				} else if (type === 'pullDown') {
					self.carpoolList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.carpoolList = self.carpoolList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我的开标拼车--车主找人
 */
export const deleteMarkCarpoolById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/mark-carpool/user/delete/' + id,
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
export const getMarkSeekcarByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserMarkSeekcar/user/list-markSeekcar-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.seekcarList = rows
				} else if (type === 'pullDown') {
					self.seekcarList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.seekcarList = self.seekcarList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我的开标拼车--人找车
 */
export const deleteMarkSeekcarById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/mark-seekcar/user/delete/' + id,
		method: 'GET',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
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
export const getRecruitByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserRecruit/user/list-recruit-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.recruitList = rows
				} else if (type === 'pullDown') {
					self.recruitList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.recruitList = self.recruitList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我发布岗位招聘
 */
export const deleteRecruitById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/recruit/user/delete/' + id,
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
export const getSeeDataByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserSeekData/user/list-seekData-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.seekDataList = rows
				} else if (type === 'pullDown') {
					self.seekDataList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.seekDataList = self.seekDataList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我的求带资料
 */
export const deleteSeekDataById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/seek-data/user/delete/' + id,
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
export const getGuaranteeByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserGuarantee/user/list-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.guaranteeList = rows
				} else if (type === 'pullDown') {
					self.guaranteeList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.guaranteeList = self.guaranteeList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 删除我的申请保函
 */
export const deleteGuaranteeById = (self, id) => {
	uni.showLoading({
		title: '删除中'
	})
	uni.request({
		url: BASE_URL + '/guarantee/user/delete/' + id,
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
export const getProjectCollectionByUserId = (self, type, params) => {
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
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.projects = rows;
				} else if (type === 'pullDown') {
					self.projects = rows;
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.projects = self.projects.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 我的预约
 */
export const getExpertSubscribeByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/expersubscribe/user/list-page',
		method: 'POST',
		data: {
			'subscribeStatus': self.pager.subscribeStatus,
			'payStatus': self.pager.payStatus,
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.expertSubscribeList = rows
				} else if (type === 'pullDown') {
					self.expertSubscribeList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.expertSubscribeList = self.expertSubscribeList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 我的咨询-获取我的咨询记录
 */
export const getConsultByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/consult/user/list-page',
		method: 'POST',
		data: {
			'pageNo': self.pager.pageNo,
			'pageSize': self.pager.pageSize
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.consultList = rows
				} else if (type === 'pullDown') {
					self.consultList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.consultList = self.consultList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 我的咨询-添加咨询
 */
export const createConsult = (self) => {
	uni.showLoading({
		title: '咨询中'
	})
	uni.request({
		url: BASE_URL + '/consult/user/save',
		method: 'POST',
		data: {
			'questionTypeId': self.questionTypeId,
			'consultDesc': self.consultDesc
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast(res.data.message)
				setTimeout(function() {
					uni.redirectTo({
						url: '/pages-user-center/consult/consult'
					})
				}, 1500)
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
				if (res.data.data.id == null) {
					self.initPicker();
				} else {
					self.formInfo = res.data.data
					self.setValue()
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
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast("保存成功")
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
 * 我的抵扣券
 */
export const getCouponByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserUserCoupon/user/list-page/' + self.pager.status,
		method: 'POST',
		data: self.pager,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if (type === 'init') {
					self.couponList = res.data.data.rows
				} else if (type === 'pullDown') {
					self.couponList = res.data.data.rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (res.data.data.rows.length > 0) {
						self.couponList = self.couponList.concat(res.data.data.rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 我的抵扣券使用记录
 */
export const getCouponRecordByUserId = (self, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/UserCouponRecord/user/list-page',
		method: 'POST',
		data: self.pager,
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.couponRecordlList = rows
				} else if (type === 'pullDown') {
					self.couponRecordlList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.couponRecordlList = self.couponRecordlList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 常见问题-问题分类
 */
export const getQuesTionType = (self) => {
	uni.request({
		url: BASE_URL + '/experquestion-type/user/list-all',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.expertTypeList = nullToStr(res.data.data.rows)
				let len = res.data.data.total
				self.questionTypeArray.push('全部')
				for (var i = 0; i < len; i++) {
					self.questionTypeArray.push(res.data.data.rows[i].name)
				}
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {}
	})
}

/**
 * 根据问题类别id查询常见问题
 */
export const getOftenQuerstion = (self, params, type) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/often-question/user/list-page',
		method: 'POST',
		data: params,
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.oftenQuestionList = rows
				} else if (type === 'pullDown') {
					self.oftenQuestionList = rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.oftenQuestionList = self.oftenQuestionList.concat(rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
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
 * 常见问题详情
 */
export const getOftenQuerstionDetail = (self, id) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/often-question/user/getById?id=' + id,
		method: 'GET',
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.oftenQuestionList = nullToStr(res.data.data.rows)
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
 * 个人中心-获取我的服务-点亮身份标识
 */
export const getMyServiceUserCenter = (self) => {
	uni.request({
		url: BASE_URL + '/UserServiceService/user/all-cond',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.vipIconColor = IS_VIP_COLOR_FALSE
				uni.setStorage({
					key: USER_FLAG,
					data: USER_FLAG_ORDINARY
				})
				if (res.data.data.total > 0) {
					var currDate = getCalendarDate(new Date());
					res.data.data.rows.forEach(item => {
						if (item.userServiceEndDate >= currDate) {
							// 有购买过服务，并至少有个服务没到期，点亮图片
							self.vipIconColor = IS_VIP_COLOR_TRUE
							uni.setStorage({
								key: USER_FLAG,
								data: USER_FLAG_VIP
							})
							return true;
						}
					})

				}
			} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {}
	})
}

/**
 * 获取我的服务
 */
export const getMyService = (self) => {
	uni.request({
		url: BASE_URL + '/UserServiceService/user/all-cond',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.myServiceList = res.data.data.rows;
				listAllService(self);
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {}
	})
}

/**
 * 获取全部服务
 */
export const listAllService = (self) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/service/user/all-cond',
		method: 'POST',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if (self.myServiceList.length > 0) {
					res.data.data.rows.forEach(item => {
						var pushFlag = true;
						var serviceId = item.id;
						self.myServiceList.forEach(tempItem => {
							if (tempItem.userServiceServiceId === serviceId) {
								pushFlag = false;
								return false;
							}
						})
						if (pushFlag) {
							self.serviceList.push(item);
						}
					})
				} else {
					self.serviceList = res.data.data.rows;
				}
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {
			uni.hideLoading();
		}
	})
}

/**
 * 根据id获取服务
 */
export const getOneServiceById = (self, id) => {
	uni.request({
		url: BASE_URL + '/service/user/one/' + id,
		method: 'POST',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.toBuyServicePage(res.data.data, 1)
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {}
	})
}
/**
 * 支付购买服务的订单
 */
export const payServiceRecord = (self, params) => {
	uni.request({
		url: BASE_URL + '/wx-pay/user/servicePay',
		method: 'POST',
		data: params,
		header: {
			'Authorization': 'Bearer ' + getUserToken(),
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				uni.requestPayment({
					provider: 'wxpay',
					orderInfo: '1234',
					appId: res.data.data.appId,
					timeStamp: res.data.data.timeStamp,
					nonceStr: res.data.data.nonceStr,
					package: res.data.data.package,
					signType: res.data.data.signType,
					paySign: res.data.data.paySign,
					success: () => {
						uni.redirectTo({
							url: '/pages-user-center/user-vip/user-vip'
						})
					},
					complete: () => {
						self.payBtnDisabled = false
					}
				})
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {}
	})
}

/**
 * 支付预约专家的问题
 */
export const payExpertRecord = (self, id) => {
	uni.request({
		url: BASE_URL + '/wx-pay/user/expertSubscribePay/' + id,
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				uni.requestPayment({
					provider: 'wxpay',
					orderInfo: '1234',
					appId: res.data.data.appId,
					timeStamp: res.data.data.timeStamp,
					nonceStr: res.data.data.nonceStr,
					package: res.data.data.package,
					signType: res.data.data.signType,
					paySign: res.data.data.paySign,
					success: () => {
						uni.redirectTo({
							url: '/pages-user-center/appointment/appointment'
						})
					},
					complete: () => {
						self.payBtnDisabled = false
					}
				})
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		},
		complete: () => {}
	})
}

/**
 * 我的专家预约-添加预约
 */
export const createAppointment = (self) => {
	uni.showLoading({
		title: '咨询中'
	})
	uni.request({
		url: BASE_URL + '/expersubscribe/user/save',
		method: 'POST',
		data: {
			'questionTypeId': self.questionTypeId,
			'questionDesc': self.consultDesc,
			'vipFlag': self.vipFlag
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showSuccessToast(res.data.message)
				setTimeout(function() {
					uni.redirectTo({
						url: '/pages-user-center/appointment/appointment'
					})
				}, 1500)
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
