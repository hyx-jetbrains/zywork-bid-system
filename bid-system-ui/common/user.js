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
	SHARE_CODE
} from './util.js'
import * as ResponseStatus from './response-status.js'

const graceChecker = require("./graceChecker.js");

export const judgeLogin = (self, type) => {
	if (isUserTokenExist()) {
		self.isUserLogin = true
		getUserDetail(self)
		geUserWalletByUserId(self)
		getUserExpertByUserId(self)
	} else {
		// #ifdef MP-WEIXIN
		xcxLogin(self)
		// #endif
	}
	if (type === 'pullDown') {
		uni.stopPullDownRefresh();
	}
}

export const xcxLogin = (self) => {
	uni.login({
		provider: 'weixin',
		success: function(wxRes) {
			let theShareCode = uni.getStorageSync(SHARE_CODE)
			if (!theShareCode) {
				theShareCode = null
			}
			uni.request({
				url: BASE_URL + '/wx-auth/xcx',
				method: 'GET',
				data: {
					code: wxRes.code,
					shareCode: theShareCode
				},
				header: {
					'content-type': 'application/x-www-form-urlencoded'
				},
				success: (res) => {
					if (res.data.code === ResponseStatus.OK) {
						self.isUserLogin = true
						saveOpenid(res.data.data[1])
						saveUserToken(res.data.data[2])
						if (res.data.data[0] === 'firstLogin') {
							// 第一次小程序登录，需要点击登录按钮，才能获取用户信息再保存用户信息
							uni.removeStorageSync(SHARE_CODE)
						} else {
							// 第二次开始不需要点击登录按钮，而是直接从后台获取用户信息
							getUserDetail(self)
							geUserWalletByUserId(self)
							getUserExpertByUserId(self)
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
	})
}

export const saveUserDetail = (self, params) => {
	uni.showLoading({
		title: '登录中'
	})
	uni.request({
		url: BASE_URL + '/wx-auth/xcx-userdetail',
		method: 'POST',
		data: params,
		header: {
			'content-type': 'application/x-www-form-urlencoded'
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.getUserInfo = true
				self.user.headicon = params.headicon
				self.user.nickname = params.nickname
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

export const saveUserPhone = (self, params) => {
	uni.showLoading({
		title:'保存手机号'
	})
	uni.request({
		url: BASE_URL + '/wx-auth/xcx-phone',
		method: 'POST',
		data: params,
		header: {
			'content-type': 'application/x-www-form-urlencoded'
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.user.phone = res.data.data.phoneNumber
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

export const getUserDetail = (self) => {
	uni.showLoading({
		title: '登录中'
	})
	uni.request({
		url: BASE_URL + '/user-userdetail/user/get',
		method: 'GET',
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.getUserInfo = true
				self.user.nickname = res.data.data.rows[0].userDetailNickname
				self.user.headicon = res.data.data.rows[0].userDetailHeadicon
				if (self.user.headicon !== undefined && self.user.headicon.indexOf('http') < 0) {
					self.user.headicon = IMAGE_BASE_URL + '/' + self.uesr.headicon
				}
				self.user.phone = res.data.data.rows[0].userPhone
			} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
				// 如果token过期了，则直接使用小程序登录，获取最新的token
				xcxLogin(self)
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

export const uploadHeadicon = (self) => {
	uni.chooseImage({
		sizeType: ['original', 'compressed'],
		sourceType: ['album', 'camera'],
		count: 1,
		success: (res) => {
			self.user.headicon = res.tempFilePaths[0]
			uni.uploadFile({
				url: BASE_URL + '/user-detail/user/upload-headicon',
				filePath: res.tempFilePaths[0],
				name: 'file',
				header: {
					'Authorization': 'Bearer ' + getUserToken()
				},
				success: (uploadFileRes) => {
					const json = JSON.parse(uploadFileRes.data)
					if (json.code === ResponseStatus.OK) {
						showSuccessToast('上传成功')
					} else if (json.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
						invalidToken()
					} else {
						showInfoToast(res.data.message)
					}
				},
				fail: () => {
					networkError()
				}
			})
		},
		fail: (res) => {
			console.log(res)
		}
	})
}

export const updateNickname = (self) => {
	uni.request({
		url: BASE_URL + '/user-detail/user/update',
		method: 'POST',
		data: {
			nickname: self.user.nickname
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.$event.$emit('changeNickname', {
					'nickname': self.user.nickname
				})
				uni.navigateBack({

				})
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
 * 用户钱包信息
 */
export const geUserWalletByUserId = (self) => {
	uni.request({
		url: BASE_URL + '/user-wallet/user/one',
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.userWallet = res.data.data
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
 * 查询专家申请记录
 */
export const getUserExpertByUserId = (self) => {
	uni.request({
		url: BASE_URL + '/user-expert/user/getByUserId',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.userExpert = res.data.data
				if(self.userExpert.examineStatus == 1) {
					self.expertIconColor = '#FFF'
				} else {
					self.expertIconColor = '#ccc'
				}
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
