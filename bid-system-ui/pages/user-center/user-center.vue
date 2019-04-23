<template>
	<view>
		<view class="zy-user-container">
			<view class="zy-user-info" v-if="isUserLogin">
				<view class="zy-user-left">
					<image class="zy-headicon" :src="user.headicon === null ? headicon : imgBaseUrl + '/' + user.headicon" @click="chooseImage"></image>
					<text class="zy-name">{{user.nickname}}</text>
				</view>
				<zywork-icon class="zy-user-more" type="iconiconfonti" color="#FFFFFF"/>
			</view>
			<view class="zy-user-info" v-else>
				<view class="zy-user-left">
					<image class="zy-headicon" :src="headicon"></image>
					<view>
						<view class="zy-name" @click="toLogin">点击登录</view>
						<view class="zy-text-small">您还未登录哦~</view>
					</view>
				</view>
			</view>
		</view>
		<view class="zy-user-balance">
			<view @click="toAccountDetail">
				<view>
					<text class="zy-data-text">{{userWallet.usableIntegral / 100}}/{{userWallet.integral / 100}}</text>
					<text class="zy-small-text">积分 ></text>
				</view>
			</view>
			<view class="zy-user-balance-opt">
				<view @click="toFundsRecharge">充值</view>
				<view @click="toFundsWithdraw">提现</view>
			</view>
		</view>
		<uni-list>
			<zywork-list-item title="帮助中心" show-extra-icon="true" :extra-icon="{color: '#E51C23',size: '18',type: 'iconbangzhu'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="关于TaskApp" show-extra-icon="true" :extra-icon="{color: '#535CA7',size: '18',type: 'iconguanyu'}"
			 @click="toAbout"></zywork-list-item>
		</uni-list>
		<view class="zy-list-button" @click="logout" v-if="isUserLogin">退出登录</view>
	</view>
</template>

<script>
	import {
		IMAGE_BASE_URL,
		DEFAULT_HEADICON,
		isUserTokenExist,
		removeUserToken,
		toLoginPage
	} from '../../common/util.js'
	import {
		userDetail,
		logout,
		uploadHeadicon
	} from '../../common/user.js'
	import {
		userWallet
	} from '../../common/funds.js'

	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	export default {
		components: {
			zyworkIcon,
			uniList,
			zyworkListItem
		},
		data() {
			return {
				isUserLogin: false,
				getUserInfo: false,
				user: {
					headicon: null,
					nickname: '',
					wechatQrcode: null
				},
				userWallet: {
					integral: 0,
					usableIntegral: 0,
					frezeeIntegral: 0
				},
				imgBaseUrl: IMAGE_BASE_URL,
				headicon: DEFAULT_HEADICON
			}
		},
		onLoad() {
		},
		onShow() {
			this.judgeUserLogin()
			userWallet(this)
		},
		methods: {
			judgeUserLogin() {
				if (isUserTokenExist()) {
					this.isUserLogin = true
				} else {
					this.isUserLogin = false
				}
				if (!this.getUserInfo && this.isUserLogin) {
					userDetail(this)
					this.getUserInfo = true
				}
			},
			chooseImage() {
				uploadHeadicon(this)
			},
			toLogin() {
				console.log('toLogin')
			},
			toNickname() {
				if (isUserTokenExist()) {
					const self = this
					this.$event.$on('changeNickname', function(data) {
						self.user.nickname = data.nickname
						self.$event.$off('changeNickname')
					});
					uni.navigateTo({
						url: '/pages/nickname/nickname?nickname=' + this.user.nickname
					})
				} else {
					toLoginPage()
				}
			},
			toHelp() {
				uni.navigateTo({
					url: '/pages-static/help/help'
				})
			},
			toAbout() {
				uni.navigateTo({
					url: '/pages-static/about/about'
				})
			},
			logout() {
				logout(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-user-container {
		background-color: $primary-color;
		padding: 30upx;
	}
	
	.zy-user-info {
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}
	
	.zy-user-left {
		display: flex;
		flex-direction: row;
		align-items: center;
	}

	.zy-user-left .zy-headicon {
		width: 120upx;
		height: 120upx;
		border-radius: 60upx;
		margin-right: 20upx;
	}

	.zy-user-left view {
		color: #FFFFFF;
	}

	.zy-user-left .zy-name {
		font-size: 30upx;
		font-weight: bold;
	}
	
	.zy-user-more {
		
	}

	.zy-user-balance {
		display: flex;
		flex-direction: column;
		align-items: center;
		background-color: $primary-backcolor;
		padding: 10upx;
		margin-bottom: 10upx;
	}

	.zy-data-text {
		padding: 10upx;
		font-size: 42upx;
		color: $primary-color;
	}

	.zy-small-text {
		font-size: 24upx;
		color: $primary-color;
		margin-left: 10upx;
	}

	.zy-user-balance-opt {
		width: 60%;
		margin-top: 30upx;
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: space-between;
	}

	.zy-user-balance-opt view {
		padding: 10upx;
		text-align: center;
		flex-grow: 1;
	}

	.zy-user-balance-opt view:first-child {
		border-right: 1px solid $primary-page-backcolor;
	}
</style>
