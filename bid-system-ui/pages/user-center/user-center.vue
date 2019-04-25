<template>
	<view>
		<view class="zy-user-container">
			<view class="zy-user-info" v-if="isUserLogin">
				<view class="zy-user-left">
					<image class="zy-headicon" :src="user.headicon === null ? headicon : imgBaseUrl + '/' + user.headicon" @click="chooseImage"></image>
					<view>
						<view class="zy-text-bold">{{user.nickname}}</view>
						<view class="zy-text-small">手机号</view>
					</view>
					<view style="margin-left: 100upx;">
						<zywork-icon type="iconVIP" color="#ffffff" size="24" style="display: inline-block; margin-right: 20upx;"/>
						<zywork-icon type="iconzhuanjiarenzheng" color="#ccc" size="24" style="display: inline-block;"/>
					</view>
				</view>
				<zywork-icon class="zy-user-more" type="iconiconfonti" size="20" color="#FFFFFF"/>
			</view>
			<view class="zy-user-info" v-else>
				<view class="zy-user-left">
					<image class="zy-headicon" :src="headicon"></image>
					<view>
						<view class="zy-text-bold" @click="toLogin">点击登录</view>
						<view class="zy-text-small">您还未登录哦~</view>
					</view>
				</view>
			</view>
		</view>
		<view class="zy-user-balance">
			<view class="zy-user-balance-item">
				<text class="zy-text-primary zy-text-big zy-text-bold">0</text>
				<text class="zy-text-info">佣金</text>
			</view>
			<view class="zy-user-balance-item">
				<text class="zy-text-primary zy-text-big zy-text-bold">20</text>
				<text class="zy-text-info">积分</text>
			</view>
		</view>
		<uni-list>
			<zywork-list-item title="我的订阅" show-extra-icon="true" :extra-icon="{color: '#FF4539',size: '18',type: 'icondingyue'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的发布" show-extra-icon="true" :extra-icon="{color: '#568999',size: '18',type: 'iconfabu'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的收藏" show-extra-icon="true" :extra-icon="{color: '#892398',size: '18',type: 'iconshoucang'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的预约" show-extra-icon="true" :extra-icon="{color: '#ABC033',size: '18',type: 'iconyuyue'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的咨询反馈" show-extra-icon="true" :extra-icon="{color: '#F98E69',size: '18',type: 'iconshouye'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的简历" show-extra-icon="true" :extra-icon="{color: '#681899',size: '18',type: 'iconresume-line'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的抵用券" show-extra-icon="true" :extra-icon="{color: '#23AA22',size: '18',type: 'iconquan'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="我的分享邀请" show-extra-icon="true" :extra-icon="{color: '#567890',size: '18',type: 'iconicon-test1'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="业绩二维码" show-extra-icon="true" :extra-icon="{color: '#E51C23',size: '18',type: 'iconico'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="常见问题" show-extra-icon="true" :extra-icon="{color: '#CC0022',size: '18',type: 'iconbangzhu'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="联系我们" show-extra-icon="true" :extra-icon="{color: '#535CA7',size: '18',type: 'iconguanyu'}"
			 @click="toContact"></zywork-list-item>
		</uni-list>
	</view>
</template>

<script>
	import {
		IMAGE_BASE_URL,
		DEFAULT_HEADICON,
		isUserTokenExist,
		removeUserToken
	} from '../../common/util.js'
	import {
		userDetail,
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
				// #ifdef MP-WEIXIN
				uni.login({
				  provider: 'weixin',
				  success: function (loginRes) {
					console.log(loginRes.code)
					uni.getUserInfo({
					  provider: 'weixin',
					  success: function (infoRes) {
						console.log('用户昵称为：' + infoRes.userInfo.nickName)
					  }
					})
				  }
				})
				// #endif
				// #ifdef APP-PLUS
				uni.login({
				  provider: 'weixin',
				  success: function (loginRes) {
					console.log(loginRes.authResult)
					uni.getUserInfo({
					  provider: 'weixin',
					  success: function (infoRes) {
						console.log('用户昵称为：' + infoRes.userInfo.nickName)
					  }
					})
				  }
				})
				// #endif
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
				}
			},
			toHelp() {
				uni.navigateTo({
					url: '/pages-static/help/help'
				})
			},
			toContact() {
				uni.navigateTo({
					url: '/pages-static/contact/contact'
				})
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
	
	.zy-user-balance {
		display: flex;
		flex-direction: row;
		justify-content: space-around;
		align-items: center;
		background-color: $primary-backcolor;
		padding: 10upx;
		margin-bottom: 10upx;
	}
	
	.zy-user-balance-item {
		display: flex;
		flex-direction: column;
		align-items: center;
	}
</style>
