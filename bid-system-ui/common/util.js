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

export const getCalendarDate = (date) => {
	if (typeof date !== 'object') {
		date = date.replace(/-/g, '/')
	}
	let dd = new Date(date);
	let y = dd.getFullYear();
	let m = dd.getMonth() + 1 < 10 ? '0' + (dd.getMonth() + 1) : dd.getMonth() + 1
	let d = dd.getDate() < 10 ? '0' + dd.getDate() : dd.getDate()
	return y + '-' + m + '-' + d
}

export const formatCalendarDate = (date) => {
	if (typeof date !== 'object') {
		date = date.replace(/-/g, '/')
	}
	let dd = new Date(date);
	let y = dd.getFullYear();
	let m = dd.getMonth() + 1
	let d = dd.getDate()
	let w = dd.getDay()
	let week = '星期'
	switch (w) {
		case 0 : week = week + '日'; break;
		case 1 : week = week + '一'; break;
		case 2 : week = week + '二'; break;
		case 3 : week = week + '三'; break;
		case 4 : week = week + '四'; break;
		case 5 : week = week + '五'; break;
		case 6 : week = week + '六'; break;
		default: break;
	}
	return y + '-' + m + '-' + d + ' ' + week
}