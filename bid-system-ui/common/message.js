import {BASE_URL, getUserToken, invalidToken, networkError, showInfoToast} from './util.js'
import * as ResponseStatus from './response-status.js'

export const loadMessage = (self, type) => {
	uni.request({
		url: BASE_URL + '/user-message/user/pager-cond',
		data: {
			pageNo: self.pager.pageNo,
			pageSize: self.pager.pageSize
		},
		method: 'POST',
		header: {
			'Authorization': 'Bearer ' + getUserToken()
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