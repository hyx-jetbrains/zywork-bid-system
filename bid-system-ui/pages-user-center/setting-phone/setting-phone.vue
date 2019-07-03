<template>
	<view class="zy-page-column-center zy-page-padding">
		<view class="zy-form">
			<view class="uni-form-item uni-column zy-position-relative">
				<input v-model="phone" class="uni-input" placeholder="请输入手机号"  />
			</view>
			<view>
				<button v-if="showBtn" class="zy-send-btn" size="mini" type="primary" @click="getCode">获取验证码</button>
				<uni-countdown v-else class="zy-send-btn" :show-day="false" :minute="minute" @timeup="timeup" />
			</view>
			<view class="uni-form-item uni-column">
				<input v-model="code" class="uni-input" placeholder="请输入手机验证码" />
			</view>
			<view class="uni-form-item">
				<button type="primary" style="width: 100%;" @click="updateUserPhone">修改手机号</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {updateNickname} from '../../common/user.js'
	import uniCountdown from '@/components/uni-countdown/uni-countdown.vue'
	import {
		showInfoToast,
		USER_PHONE
	} from '@/common/util.js'
	import {
		sendSmsCode,
		updatePhone
	} from '@/common/user.js'
	export default {
		components: {
			uniCountdown
		},
		data() {
			return {
				phone: '',
				code: '',
				showBtn: true,
				minute: 5
			}
		},
		onLoad(option) {
			uni.hideShareMenu();
			this.phone = option.phone
		},
		methods: {
			/** 获取验证码 */
			getCode() {
				const userPhone = uni.getStorageSync(USER_PHONE);
				if (userPhone) {
					// 用户原来的手机号不为空
					if (this.phone === userPhone) {
						showInfoToast('请输入新的手机号')
						return;
					}
				}
				sendSmsCode(this)
			},
			/** 倒计时结束 */
			timeup() {
				this.showBtn = true;
			},
			/** 更新手机号 */
			updateUserPhone() {
				if (!this.phone) {
					showInfoToast('请输入手机号')
					return;
				}
				const userPhone = uni.getStorageSync(USER_PHONE);
				if (userPhone) {
					// 用户原来的手机号不为空
					if (this.phone === userPhone) {
						showInfoToast('请输入新的手机号')
						return;
					}
				}
				if (!this.code) {
					showInfoToast('请输入验证码')
					return;
				}
				updatePhone(this)
			}
 		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	.zy-send-btn {
		position: absolute;
		top: 30upx;
		right: 30upx;
		z-index: 9999;
	}
</style>
