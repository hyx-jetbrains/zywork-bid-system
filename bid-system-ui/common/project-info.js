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
	DOCUMENT_BASE_URL,
	nullToStr
} from './util.js'
import * as ResponseStatus from './response-status.js'

/**
 * 获取轮播图广告信息
 */
export const getAdvertisementInfo = (self) => {
	uni.request({
		url: BASE_URL + '/advertisement/any/all-cond',
		method: 'POST',
		data: {
			pageNo: 1,
			pageSize: 5,
			isActive: 0
		},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var tempSwiperItems = res.data.data.rows;
				self.swiperItems = []
				tempSwiperItems.forEach(item => {
					item.url = IMAGE_BASE_URL + item.url;
					self.swiperItems.push(item);
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
 * 获取单个轮播图信息
 */
export const getAdvertisementOneInfo = (self, id) => {
	uni.showLoading({
		title: '加载中...'
	})
	uni.request({
		url: BASE_URL + '/advertisement/any/one/' + id,
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var row = res.data.data;
				row.url = IMAGE_BASE_URL + row.url;
				console.log(row.content)
				self.item = row
				uni.setNavigationBarTitle({
					title: row.title
				});
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
				self.latestNotice = nullToStr(res.data.data.rows[0]);
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
 * 获取首页的公示信息
 */
export const getIndexProjectAnnounceTop = (self, top) => {
	uni.request({
		url: BASE_URL + '/projecannounce/any/top/' + top,
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				const rows = nullToStr(res.data.data);
				self.projectAnnounceList = rows;
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
 * 获取公示列表信息
 */
export const getIndexProjectAnnounceList = (self, type, params) => {
	uni.showLoading({
		title: '加载中'
	})
	uni.request({
		url: BASE_URL + '/projecannounce/any/pager-cond',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				const rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.projectAnnounceList = rows;
				} else if (type === 'pullDown') {
					self.projectAnnounceList = rows;
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						self.projectAnnounceList = self.projectAnnounceList.concat(rows)
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
 * 获取头条列表
 */
export const getHeadlinesList = (self, type, params) => {
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
				if (type === 'init') {
					self.notices = res.data.data.rows;
				} else if (type === 'pullDown') {
					self.notices = res.data.data.rows;
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (res.data.data.rows.length > 0) {
						self.notices = self.notices.concat(res.data.data.rows)
						self.loadMoreText = '加载更多'
					} else {
						self.loadMoreText = '已加载全部'
					}
				}
				self.notices = nullToStr(self.notices);
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
export const getProjectList = (self, type, params) => {
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
				const rows = nullToStr(res.data.data.rows);
				if (type === 'init') {
					self.projects = rows;
				} else if (type === 'pullDown') {
					self.projects = rows;
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (res.data.data.total > 0) {
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
 * 根据id获取项目
 */
export const getProjectById = (self, params) => {
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
				const rows = res.data.data.rows;
				self.project = nullToStr(rows[0]);
				self.project.project.noticeTime = self.project.project.noticeTime.split(" ")[0]
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
 * 更新点击次数
 */
export const projectClickCount = (self, projectItem) => {
	uni.request({
		url: BASE_URL + '/project/user/update',
		method: 'POST',
		data: {
			id: projectItem.id,
			clickCount: projectItem.clickCount
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				console.log("更新点击次数成功"); 
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
		complete: () => {}
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
			'projectId': projectId
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.isCollection = true;
				self.collectionOperation(0);
				showSuccessToast('收藏成功');
			} else {
				self.isCollection = false;
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
				showSuccessToast('取消成功');
			} else {
				self.isCollection = true;
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
				self.projectAnnounce = nullToStr(res.data.data);
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
		url: BASE_URL + '/UserMarkCarpool/user/list-page',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.carpoolList = nullToStr(res.data.data.rows);
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
		url: BASE_URL + '/UserMarkSeekcar/user/list-page',
		method: 'POST',
		data: params,
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.seekcarList = nullToStr(res.data.data.rows);
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
 * 根据项目id和资源类别获取项目资源
 * @param {Object} self
 * @param {Object} projectId
 * @param {Object} type
 */
export const getResourceByProjectIdAndType = (self, projectId, type) => {
	uni.request({
		url: BASE_URL + '/ProjectResourceResource/any/all-cond',
		method: 'POST',
		data: {
			'projectResourceProjectId': projectId,
			'projectResourceResType': type
		},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.fileList = []
				if (res.data.data.total === 0) {
					// 没有文件
					showInfoToast("没有文件")
				} else if (res.data.data.total === 1) {
					// 只有一个资源文件
					self.openDocument(res.data.data.rows[0].resourceUrl)
				} else {
					// 有多个资源文件
					self.isShowFileList = true;
					let len = res.data.data.rows.length;
					for (var i = 0; i < len; i++) {
						var item = res.data.data.rows[i];
						var resourceUrlArr = item.resourceUrl.split('/');
						var fileName = resourceUrlArr[resourceUrlArr.length - 1];
						item.fileName = fileName;
						self.fileList.push(item);
					}
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
