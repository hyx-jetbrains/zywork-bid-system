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
	SHARE_CODE,
	setShareCode,
	USER_ID,
	USER_ROLES,
	IS_EXPERT_COLOR_TRUE,
	IS_EXPERT_COLOR_FALSE,
	CUSTOMER_CONFIG,
	nullToStr,
	LOGIN_FLAG,
	USER_PHONE,
	GUARANTEE_CONFIG
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

/**
 * 未登入页面调用的小程序登入
 */
export const xcxLoginSimple = (self) => {
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
						saveOpenid(res.data.data[1])
						saveUserToken(res.data.data[2])
						if (res.data.data[0] === 'firstLogin') {
							// 第一次小程序登录，需要点击登录按钮，才能获取用户信息再保存用户信息
							uni.removeStorageSync(SHARE_CODE)

						} else {
							// 第二次开始不需要点击登录按钮，而是直接从后台获取用户信息
							getUserDetailSimple(self)
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

/**
 * 未登入页面调用的保存用户详细信息
 */
export const saveUserDetailSimple = (self, params) => {
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
				uni.setStorageSync(LOGIN_FLAG, true)
				uni.navigateBack({
					delta: 1
				})
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
		title: '保存手机号'
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
				var userInfo = res.data.data.rows[0]
				if (userInfo.userDetailNickname) {
					self.user.nickname = userInfo.userDetailNickname
				}
				if (userInfo.userDetailHeadicon) {
					self.user.headicon = userInfo.userDetailHeadicon
				}
				if (self.user.headicon !== '' && self.user.headicon.indexOf('http') < 0) {
					self.user.headicon = IMAGE_BASE_URL + '/' + self.uesr.headicon
				}
				if (userInfo.userDetailGender) {
					self.user.gender = userInfo.userDetailGender
				}
				if (userInfo.userPhone) {
					self.user.phone = userInfo.userPhone
				}
				if (self.user.nickname !== '' && self.user.headicon !== '') {
					self.getUserInfo = true
					uni.setStorageSync(USER_ID, userInfo.userId)
					uni.setStorageSync(LOGIN_FLAG, true)
				} else {
					uni.setStorageSync(LOGIN_FLAG, false)
				}
				uni.setStorageSync(USER_PHONE, userInfo.userPhone)
				setShareCode(userInfo.userDetailShareCode)
				getUserRoles(self)
			} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
				// 如果token过期了，则直接使用小程序登录，获取最新的token
				removeUserToken()
				removeOpenid()
				uni.removeStorageSync(USER_ID)
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

/**
 * 未登入页面调用保存用户id
 */
export const getUserDetailSimple = (self) => {
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
				var userInfo = res.data.data.rows[0]
				let nickname = ''
				let headicon = ''
				if (userInfo.userDetailNickname) {
					nickname = userInfo.userDetailNickname
				}
				if (userInfo.userDetailHeadicon) {
					headicon = userInfo.userDetailHeadicon
				}
				if (nickname !== '' && headicon !== '') {
					uni.setStorageSync(LOGIN_FLAG, true)
					uni.navigateBack({
						delta: 1
					})
				} else {
					uni.setStorageSync( LOGIN_FLAG, false)
				}
				uni.setStorageSync(USER_PHONE, userInfo.userPhone)
				setShareCode(userInfo.userDetailShareCode)
			} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {
				// 如果token过期了，则直接使用小程序登录，获取最新的token
				removeUserToken()
				removeOpenid()
				uni.removeStorageSync(USER_ID)
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
			} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {} else {
				showInfoToast(res.data.message)
			}
		},
		fail: () => {
			networkError()
		}
	})
}

/**
 * 查询专家申请记录，判断当前用户是否是专家
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
				if (self.userExpert.examineStatus == 1) {
					self.expertIconColor = IS_EXPERT_COLOR_TRUE
				} else if (res.data.code === ResponseStatus.AUTHENTICATION_TOKEN_ERROR) {} else {
					self.expertIconColor = IS_EXPERT_COLOR_FALSE
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

/**
 * 查询我的分享记录
 */
export const getUserShareRecord = (self) => {
	uni.request({
		url: BASE_URL + '/distribution/user/direct-below',
		method: 'POST',
		data: self.pager,
		header: {
			'Authorization': 'Bearer ' + getUserToken(),
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.shareRecordList = [];
				var tempUserId = uni.getStorageSync(USER_ID);
				res.data.data.rows.forEach(item => {
					if (item.userId != tempUserId) {
						item = nullToStr(item);
						if (item.headicon !== '' && item.headicon.indexOf('http') < 0) {
							item.headicon = IMAGE_BASE_URL + '/' + item.headicon
						}
						self.shareRecordList.push(item)
					}
				})
				self.pager.pageTotal = res.data.data.total
				console.log(self.pager.pageTotal)
				console.log(res.data.data.total)
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
 * 获取用户角色
 */
export const getUserRoles = (self) => {
	uni.request({
		url: BASE_URL + '/user-role/user/list',
		method: 'GET',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				var rolesArrey = []
				res.data.data.rows.forEach(item => {
					rolesArrey.push(item.roleTitle)
				})
				uni.setStorage({
					key: USER_ROLES,
					data: rolesArrey
				})
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
 * 获取用户详情
 */
export const getUserWork = (self) => {
	uni.request({
		url: BASE_URL + '/user-work/user/getByUserId',
		method: 'POST',
		data: {},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.userWork = nullToStr(res.data.data)
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
 * 修改用户办公地点
 */
export const updateGrade = (self, gender) => {
	uni.request({
		url: BASE_URL + '/user-detail/user/update',
		method: 'POST',
		data: {
			'gender': gender
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.$event.$emit('chooseGender', {
					'gender': gender
				})
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
 * 修改用户身份证号码
 */
export const updateIdentity = (self) => {
	uni.request({
		url: BASE_URL + '/user-work/user/update',
		method: 'POST',
		data: {
			'idNum': self.identity
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.$event.$emit('changeIdentity', {
					'identity': self.identity
				})
				uni.navigateBack({

				})
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
 * 修改用户工作单位
 */
export const updateCompany = (self) => {
	uni.request({
		url: BASE_URL + '/user-work/user/update',
		method: 'POST',
		data: {
			'workUnit': self.company
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.$event.$emit('changeCompany', {
					'company': self.company
				})
				uni.navigateBack({

				})
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
 * 修改用户职务
 */
export const updateJobTitle = (self) => {
	uni.request({
		url: BASE_URL + '/user-work/user/update',
		method: 'POST',
		data: {
			'jobTitle': self.job
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.$event.$emit('changeJob', {
					'job': self.job
				})
				uni.navigateBack({

				})
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
 * 修改用户办公地点
 */
export const updateCompanyAddr = (self) => {
	uni.request({
		url: BASE_URL + '/user-work/user/update',
		method: 'POST',
		data: {
			'workAddr': self.companyAddr
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken()
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.$event.$emit('changeCompanyAddr', {
					'companyAddr': self.companyAddr
				})
				uni.navigateBack({

				})
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
 * 获取客服配置
 */
export const getCustomerConfig = () => {
	uni.request({
		url: BASE_URL + '/sys-config/any/customer-config',
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				console.log(res.data.data);
				uni.setStorage({
					key: CUSTOMER_CONFIG,
					data: res.data.data
				})
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
 * 获取申请保函说明配置
 */
export const getGuaranteeConfig = () => {
	uni.request({
		url: BASE_URL + '/sys-config/any/guarantee-config',
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				console.log(res.data.data);
				uni.setStorage({
					key: GUARANTEE_CONFIG,
					data: res.data.data
				})
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
 * 获取系统信息
 */
export const getSysInfo = (self) => {
	uni.request({
		url: BASE_URL + '/sys-info/any/sys-info',
		method: 'GET',
		data: {},
		header: {},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.sysInfo = nullToStr(res.data.data.rows[0])
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
 * 发送验证码
 */
export const sendSmsCode = (self) => {
	uni.request({
		url: BASE_URL + '/user/user/sms-code',
		method: 'POST',
		data: {
			phone: self.phone
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken(),
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				self.showBtn = false;
				self.minute = 5;
				showInfoToast('发送成功，请注意查收')
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
 * 更新用户手机号
 */
export const updatePhone = (self) => {
	uni.request({
		url: BASE_URL + '/user/user/update-phone',
		method: 'POST',
		data: {
			phone: self.phone,
			smsCode: self.code
		},
		header: {
			'Authorization': 'Bearer ' + getUserToken(),
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
		},
		success: (res) => {
			if (res.data.code === ResponseStatus.OK) {
				showInfoToast(res.data.message)
				setTimeout(function() {
					uni.switchTab({
						url: '/pages/user-center/user-center'
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

		}
	})
}
