export const BASE_URL = 'http://192.168.203.132:8088'
export const IMAGE_BASE_URL = 'http://localhost'
export const USER_TOKEN_KEY = 'userToken'

export const DEFAULT_HEADICON = '/static/icon/headicon.png'

export const isEmpty = (data) => {
	return data === null || data === undefined || data === ''
}

export const isUserTokenExist = () => {
	const userToken = uni.getStorageSync(USER_TOKEN_KEY)
	return !isEmpty(userToken)
}

export const saveUserToken = (userToken) => {
	uni.setStorageSync(USER_TOKEN_KEY, userToken)
}

export const getUserToken = () => {
	const userToken = uni.getStorageSync(USER_TOKEN_KEY)
	if (!isEmpty(userToken)) {
		return userToken
	}
	return null
}

export const removeUserToken = () => {
	uni.removeStorageSync(USER_TOKEN_KEY)
}

export const toLoginPage = () => {
	uni.navigateTo({
		url: '/pages/login/login'
	})
	showInfoToast('请先登录')
}

export const clearForm = (form) => {
	for (let key in form) {
		form[key] = null
	}
}

export const invalidToken = () => {
	uni.navigateTo({
		url: '/pages/login/login'
	})
	removeUserToken()
	showInfoToast('登录已失效，请重新登录')
}

export const networkError = () => {
	showInfoToast('网络有问题哦~')
}

export const showInfoToast = (title) => {
	uni.showToast({
		title: title,
		icon: 'none',
		duration: 2000
	})
}

export const showSuccessToast = (title) => {
	uni.showToast({
		title: title,
		duration: 2000
	})
}