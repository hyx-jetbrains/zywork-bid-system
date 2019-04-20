import {BASE_URL, getUserToken, invalidToken, networkError, showInfoToast} from './util.js'
import * as ResponseStatus from './response-status.js'

export const latestNotice = (self) => {
	uni.request({
		url: BASE_URL + '/notice/any/pager-cond',
		data: {
			pageNo: 1,
			pageSize: 1,
			sortColumn: 'stickStatus',
			sortOrder: 'desc'
		},
		method: 'POST',
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if (res.data.data.total === 1) {
					self.latestNotice = res.data.data.rows[0].title
				}
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		}
	})
}

export const loadNotice = (self, type) => {
	uni.request({
		url: BASE_URL + '/notice/any/pager-cond',
		data: {
			pageNo: self.pager.pageNo,
			pageSize: self.pager.pageSize,
			sortColumn: 'stickStatus',
			sortOrder: 'desc'
		},
		method: 'POST',
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				if (type === 'init') {
					self.noticeList = res.data.data.rows
				} else if (type === 'pullDown') {
					self.noticeList = res.data.data.rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (res.data.data.rows.length > 0) {
						self.noticeList = self.noticeList.concat(res.data.data.rows)
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
		}
	})
}

export const getNotice = (self, id) => {
	uni.request({
		url: BASE_URL + '/notice/any/one/' + id,
		method: 'GET',
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.notice = res.data.data
			} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		}
	})
}