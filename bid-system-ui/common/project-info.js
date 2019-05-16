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
 * 获取轮播图广告信息
 */
export const getAdvertisementInfo = (self) => {
	uni.request({
		url: BASE_URL + '/advertisement/any/all',
		method: 'GET',
		data: '',
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.swiperItems = res.data.data.rows;
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
 * 获取第一条头条信息
 */
export const getFirstHeadlinesInfo = (self, params) => {
	uni.request({
		url: BASE_URL + '/headlines/any/pager-cond',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.latestNotice = res.data.data.rows[0];
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
 * 获取头条列表
 */
export const getHeadlinesList = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/headlines/any/pager-cond',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.notices = res.data.data.rows;
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
 * 获取项目列表
 */
export const getProjectList = (self, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/project/any/list-pager-cond',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.projects = res.data.data.rows;
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
 * 获取项目收藏信息
 */
export const getProjectCollectionInfo = (self, projectId) => {
	uni.request({
		url: BASE_URL + '/projeccollection/user/getByProject/' + projectId,
		method: 'GET',
		data: '',
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if (res.data.data.id !== null) {
					self.isCollection = true;
				} else {
					self.isCollection = false;
				}
				self.collectionOperation(projectId);
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
 * 创建项目收藏
 */
export const saveProjectCollection = (self, projectId) => {
	uni.request({
		url: BASE_URL + '/projeccollection/user/save',
		method: 'POST',
		data: {
			'projectId' : projectId
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.isCollection = true;
				self.collectionOperation(0);
				uni.showToast({
					title: '收藏成功'
				})
			} else {
				self.isCollection = false;
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
 * 取消项目收藏
 */
export const cancelProjectCollection = (self, projectId) => {
	uni.request({
		url: BASE_URL + '/projeccollection/user/cancel/' + projectId,
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.isCollection = false;
				self.collectionOperation(0);
				uni.showToast({
					title: '取消成功'
				})
			} else {
				self.isCollection = true;
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
 * 获取项目公示详情
 */
export const getProjectAnnounce = (self, projectId) => {
	uni.request({
		url: BASE_URL + '/projecannounce/any/getByProjectId/' + projectId,
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.projectAnnounce = res.data.data;
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
 * 获取开标拼车记录
 */
export const getCarpoolList = (self, params) => {
	uni.request({
		url: BASE_URL + '/UserMarkCarpool/any/list-page',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.carpoolList = res.data.data.rows;
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
 * 获取开标找车车记录
 */
export const getSeekcarList = (self, params) => {
	uni.request({
		url: BASE_URL + '/UserMarkSeekcar/any/list-page',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.seekcarList = res.data.data.rows;
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
