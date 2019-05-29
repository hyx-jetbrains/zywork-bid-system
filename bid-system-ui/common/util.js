export const BASE_URL = 'http://192.168.203.208:8088'
export const IMAGE_BASE_URL = 'https://www.shudagroup.com'
export const DOCUMENT_BASE_URL = 'https://www.shudagroup.com'
export const USER_TOKEN_KEY = 'userToken'
export const USER_OPENID = 'openid'
export const SHARE_CODE = 'shareCode'
export const MY_SHARE_CODE = 'myShareCode'
export const USER_ID = 'userId'
export const USER_ROLES = 'userRoles'
export const USER_ROLES_VIP1 = 'sys_vip1'
export const USER_ROLES_VIP2 = 'sys_vip2'
export const USER_ROLES_VIP3 = 'sys_vip3'
export const IS_EXPERT_COLOR_TRUE = '#FFF'
export const IS_EXPERT_COLOR_FALSE = '#CCC'
export const IS_VIP_COLOR_TRUE = '#FFF'
export const IS_VIP_COLOR_FALSE = '#CCC'
export const SHARE_CODE_PAGE_IMG = '/static/share.jpg'

export const DEFAULT_HEADICON = '/static/icon/headicon.png'

export const isEmpty = (data) => {
	// return data === null || data === undefined || data === ''
	return !data
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

export const saveOpenid = (openid) => {
	uni.setStorageSync(USER_OPENID, openid)
}

export const getOpenid = () => {
	const openid = uni.getStorageSync(USER_OPENID)
	if (!isEmpty(openid)) {
		return openid
	}
	return null
}

export const removeOpenid = () => {
	uni.removeStorageSync(USER_OPENID)
}

export const clearForm = (form) => {
	for (let key in form) {
		form[key] = null
	}
}

export const invalidToken = () => {
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
		case 0:
			week = week + '日';
			break;
		case 1:
			week = week + '一';
			break;
		case 2:
			week = week + '二';
			break;
		case 3:
			week = week + '三';
			break;
		case 4:
			week = week + '四';
			break;
		case 5:
			week = week + '五';
			break;
		case 6:
			week = week + '六';
			break;
		default:
			break;
	}
	return y + '-' + m + '-' + d + ' ' + week
}

export const getDate = (type) => {
	const date = new Date();

	let year = date.getFullYear();
	let month = date.getMonth() + 1;
	let day = date.getDate();

	if (type === 'start') {
		year = year - 60;
	} else if (type === 'end') {
		year = year + 2;
	}
	month = month > 9 ? month : '0' + month;;
	day = day > 9 ? day : '0' + day;

	return `${year}-${month}-${day}`;
}

/**
 * null转成空字符串
 */
export const nullToStr = (data) => {
	for (let x in data) {
		if (data[x] === null) { // 如果是null 把直接内容转为 ''
			data[x] = '';
		} else {
			if (Array.isArray(data[x])) { // 是数组遍历数组 递归继续处理
				data[x] = data[x].map(z => {
					return nullToStr(z);
				});
			}
			if (typeof(data[x]) === 'object') { // 是json 递归继续处理
				data[x] = nullToStr(data[x])
			}
		}
	}
	return data;
}

/**
 * 保存分享码
 * @param shareCode 分享码  
 */
export const setShareCode = (shareCode) => {
	uni.setStorage({
		key: MY_SHARE_CODE,
		data: shareCode
	});
}
/**
 * 取分享码
 */
export const getShareCode = () => {
	const shareCode = uni.getStorageSync(MY_SHARE_CODE)
	if (!isEmpty(shareCode)) {
		return shareCode
	}
	return null
}

/**
 * 拨打电话
 */
export const callPhone = (phone) => {
	if (phone === '请购买VIP服务') {
		uni.navigateTo({
			url: '/pages-user-center/user-vip/user-vip'
		})
	} else {
		uni.makePhoneCall({
			phoneNumber: phone + '',
			success: () => {
				console.log("成功拨打电话")
			}
		})
	}

}

/**
 * 验证文字
 */
export const validText = (text) => {
	if (text === '请购买VIP服务') {
		uni.navigateTo({
			url: '/pages-user-center/user-vip/user-vip'
		})
	}
}
