export const BASE_URL = 'https://www.shudagroup.com/api'
// export const BASE_URL = 'http://localhost:8088'
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
export const USER_FLAG = 'userFlag'
export const USER_FLAG_VIP = 'vip'
export const CUSTOMER_CONFIG = 'customerConfig'
export const CREDIT_QUERY_VIP = 'creditQueryVip'
export const CREDIT_QUERY = 'creditQuery'
export const CREDIT_QUERY_ID = 2
export const USER_FLAG_ORDINARY = 'ordinary'
export const SHARE_CODE_PAGE_IMG = '/static/share.jpg'
export const LOGIN_FLAG = 'loginFlag'
export const USER_PHONE = 'userPhone'

export const DEFAULT_HEADICON = '/static/icon/headicon.png'

export const isEmpty = (data) => {
	// return data === null || data === undefined || data === ''
	return !data
}

export const isUserTokenExist = () => {
	const userToken = uni.getStorageSync(USER_TOKEN_KEY)
	return !isEmpty(userToken)
}

export const isUserIdExist = () => {
	const userId = uni.getStorageSync(USER_ID)
	return !isEmpty(userId)
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
	month = month > 9 ? month : '0' + month;
	day = day > 9 ? day : '0' + day;

	return `${year}-${month}-${day}`;
}

export const getCurrentDate = () => {
	let date = new Date()
	let year = date.getFullYear()
	let month = date.getMonth() + 1
	let day = date.getDate()
	month = month > 9 ? month : '0' + month
	day = day > 9 ? day : '0' + day
	return year + '-' + month + '-' + day
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
 * 获取当前用户的手机号，如果有则获取，没有获取到的是空字符串
 */
export const getUserPhone = () => {
	const userPhone = uni.getStorageSync(USER_PHONE)
	if (userPhone) {
		return userPhone;
	}
	return "";
}

/**
 * 拨打电话
 */
export const callPhone = (phone) => {
	if (phone === '请购买VIP服务') {
		const loginFlag = uni.getStorageSync(LOGIN_FLAG);
		if (!loginFlag) {
			uni.navigateTo({
				url: '/pages-static/no-login/no-login'
			})
			return;
		}
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
		const loginFlag = uni.getStorageSync(LOGIN_FLAG);
		if (!loginFlag) {
			uni.navigateTo({
				url: '/pages-static/no-login/no-login'
			})
			return;
		}
		uni.navigateTo({
			url: '/pages-user-center/user-vip/user-vip'
		})
	}
}

/**
 * 未登入，前往个人中心页面
 */
export const notLoginToUserCenter = () => {
	showInfoToast("请先登录哦,即将前往个人中心")
	setTimeout(function() {
		uni.switchTab({
			url: '/pages/user-center/user-center'
		})
	}, 2000)
}

/**
 * 获取指定几天前或几天后的时间
 * console.log("半年前："+GetDateStr(-180));
 *	console.log("三月前："+GetDateStr(-90));
 *	console.log("一月前："+GetDateStr(-30));
 *	console.log("昨天："+GetDateStr(-1));
 *	console.log("今天："+GetDateStr(0));
 *	console.log("明天："+GetDateStr(1));
 *	console.log("后天："+GetDateStr(2));
 *	console.log("一月后："+GetDateStr(30));
 *	console.log("三月后："+GetDateStr(90));
 *	console.log("半年后："+GetDateStr(180));
 */
export const getDateStr = (dayCount) => {
	var dd = new Date();
	// 获取AddDayCount天后的日期
	dd.setDate(dd.getDate() + dayCount); 
	var y = dd.getFullYear();
	// 获取当前月份的日期，不足10补0
	var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1); 
	// 获取当前几号，不足10补0
	var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); 
	return y + "-" + m + "-" + d;
}

/**
 * 取指定的日期
 * @param {type} 7：上周开始时间 1：上周结束时间 0：本周开始时间 -6：本周结束时间 -7：下周开始时间 -13：下周结束时间  
 */
export const getAppointWeekDate = (n) => {
	var now = new Date();
	var year = now.getFullYear();
	//因为月份是从0开始的,所以获取这个月的月份数要加1才行
	var month = now.getMonth() + 1;
	var date = now.getDate();
	var day = now.getDay();
	//判断是否为周日,如果不是的话,就让今天的day-1(例如星期二就是2-1)
	if (day !== 0) {
		n = n + (day - 1);
	} else {
		n = n + day;
	}
	if (day) {
		//这个判断是为了解决跨年的问题
		if (month > 1) {
			month = month;
		}
		//这个判断是为了解决跨年的问题,月份是从0开始的
		else {
			year = year - 1;
			month = 12;
		}
	}
	now.setDate(now.getDate() - n);
	year = now.getFullYear();
	month = now.getMonth() + 1;
	date = now.getDate();
	// console.log(n);
	var s = year + "-" + (month < 10 ? ('0' + month) : month) + "-" + (date < 10 ? ('0' + date) : date);
	return s;
}

/**
 * 获取本月第一天或最后一天的日期
 * @param type 默认是获取本月第一天的日期，传入1:获取本月最后一天的日期
 */
export const showMonthFirstOrLastDay = (type) => {
	var nowDate = new Date();
	var monthFirstDay = new Date(nowDate.getYear(), nowDate.getMonth() + 1, 1);
	var monthLastDay = new Date(monthFirstDay - 86400000);
	var month = Number(monthFirstDay.getMonth())
	if (month === 0) {
		month = 12
	}
	var day = monthFirstDay.getDate();
	if (1 === type) {
		month = Number(monthLastDay.getMonth()) + 1
		day = Number(monthLastDay.getDate());
	}
	month = month < 10 ? '0' + month : month;
	day = day < 10 ? '0' + day : day;
	return nowDate.getFullYear() + "-" + month + "-" + day;
}

/**
 * 获取下月第一天或最后一天的日期
 * @param type 默认是获取下月第一天的日期，传入1:获取下月最后一天的日期
 */
export const showNextMonthFirstOrLastDay = (type) => {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	// 解决跨年的问题
	if (12 === month) {
		// 当前是12月，则下月是1月
		month = 1;
		year = year + 1;
	} else {
		// 获取下个月的月份
		month = month + 1;
	}
	var monthFirstDay = new Date(year, month, 1);
	var monthLastDay = new Date(year, month, 0);
	var tempMonth = Number(monthFirstDay.getMonth())
	var tempDay = monthFirstDay.getDate();
	if (1 === type) {
		tempMonth = Number(monthLastDay.getMonth()) + 1
		tempDay = Number(monthLastDay.getDate());
	}
	tempMonth = tempMonth < 10 ? '0' + tempMonth : tempMonth;
	tempDay = tempDay < 10 ? '0' + tempDay : tempDay;
	return year + "-" + tempMonth + "-" + tempDay;
}

/**
 * 判断是否是手机号
 */
export const isPhone = (phone) => {
	var phoneExp = /^[1][3,4,5,7,8,9][0-9]{9}$/;
	return phoneExp.test(phone);
}
