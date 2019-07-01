import {
	BASE_URL,
	getUserToken,
	invalidToken,
	networkError,
	showInfoToast
} from './util.js'
import * as ResponseStatus from './response-status.js'

/**
 * 加载消息
 */
export const loadMessage = (self, params, type) => {
	const token = getUserToken()
	if (token) {
		uni.request({
			url: BASE_URL + '/user-notice/user/pager-cond',
			data: params,
			method: 'POST',
			header: {
				'Authorization': 'Bearer ' + token
			},
			success: (res) => {
				if (res.data.code === ResponseStatus.OK) {
					if (type === 'init') {
						self.messageList = res.data.data.rows
					} else if (type === 'pullDown') {
						self.messageList = res.data.data.rows
						uni.stopPullDownRefresh()
						self.showLoadMore = false
						self.loadMoreText = '加载中...'
					} else if (type === 'reachBottom') {
						if (res.data.data.rows.length > 0) {
							self.messageList = self.messageList.concat(res.data.data.rows)
							self.loadMoreText = '加载更多'
						} else {
							self.loadMoreText = '已加载全部'
						}
					}
				} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
					invalidToken()
				} else {
					showInfoToast(res.data.message)
				}
			},
			fail: () => {
				networkError()
			}
		})
	}
}

/**
 * 读取消息
 */
export const readMessage = (self, id) => {
	uni.request({
		url: BASE_URL + '/user-notice/user/read/' + id,
		data: '',
		method: 'GET',
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.initMessage();
			} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
				invalidToken()
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		}
	})
}

/**
 * 统计未读消息
 */
export const countNotReadMsg = () => {
	const token = getUserToken()
	if (token) {
		uni.request({
			url: BASE_URL + '/user-notice/user/pager-cond',
			data: {
				isRead: 0
			},
			method: 'POST',
			header: {
				'Authorization': 'Bearer ' + token
			},
			success: (res) => {
				if (res.data.code === ResponseStatus.OK) {
					if (res.data.data.total > 0) {
						uni.setTabBarBadge({
							index: 2,
							text: res.data.data.total + ''
						})
					} else {
						uni.removeTabBarBadge({
							index: 2
						})
					}
				} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
					invalidToken()
				} else {
					showInfoToast(res.data.message)
				}
			},
			fail: () => {
				networkError()
			}
		})
	}
}

/**
 * get根据id获取对象信息，封装Promise
 */
export const getOneById = (self, url) => {
	return uni.request({
		url: BASE_URL + url,
		method: 'GET',
		data: {},
		header: {},
	})
}

/**
 * 清除未读的消息
 */
export const clearNoReadMessage = (self, type) => {
	uni.request({
		url: BASE_URL + '/user-notice/user/clear-msg/' + type,
		data: {},
		method: 'GET',
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.initMessage('init');
			} else {
				showInfoToast(res.data.message)
			}
			countNotReadMsg();
		},
		fail: () => {
			networkError()
		}
	})
}
