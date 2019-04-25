import {BASE_URL, getUserToken, clearForm, networkError, showInfoToast, showSuccessToast} from './util.js'
import * as ResponseStatus from './response-status.js'

const graceChecker = require("./graceChecker.js");

export const userWallet = (self) => {
	uni.request({
		url: BASE_URL + '/user-wallet/user/one',
		method: 'GET',
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.userWallet.integral = res.data.data.rmbBalance
				self.userWallet.usableIntegral = res.data.data.usableRmbBalance
				self.userWallet.frezeeIntegral = res.data.data.frozenRmbBalance
			}
		},
		fail: () => {
			networkError()
		}
	})
}

export const loadAccountDetail = (self, type) => {
	uni.request({
		url: BASE_URL + '/accoundetail/user/pager-cond',
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
					self.accountDetails = res.data.data.rows
				} else if (type === 'pullDown') {
					self.accountDetails = res.data.data.rows
					uni.stopPullDownRefresh()
					self.showLoadMore = false
					self.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (res.data.data.rows.length > 0) {
						self.accountDetails = self.accountDetails.concat(res.data.data.rows)
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