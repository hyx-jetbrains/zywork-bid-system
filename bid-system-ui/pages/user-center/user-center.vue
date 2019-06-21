<template>
	<view>
		<view class="zy-user-container">
			<view class="zy-user-info" v-if="getUserInfo">
				<view class="zy-user-left">
					<image class="zy-headicon" :src="user.headicon === '' ? headicon : user.headicon" @click="toUserSetting"></image>
					<view>
						<view class="zy-text-bold" @click="toUserSetting">{{user.nickname}}</view>
						<view class="zy-text-small" v-if="user.phone !== ''" @click="toUserSetting">{{user.phone}}</view>
						<button v-else class="zy-wx-btn" open-type="getPhoneNumber" lang="zh_CN" @getphonenumber="bindGetPhoneNumber">
							<view class="zy-text-small">获取手机号</view>
						</button>
					</view>
					<view style="margin-left: 100upx; display: flex; flex-direction: row; align-items: center;">
						<view class="zy-icon-text" @click="toUserVip">
							<zywork-icon type="iconhuiyuanquanyi" :color="vipIconColor" size="20" style="display: inline-block; margin-right: 20upx;"/>
							 <text :style="{color:vipIconColor}">服务订购</text>
						</view>
						<view class="zy-icon-text" @click="toUserExpert">
							<zywork-icon type="iconzhuanjiarenzheng" :color="expertIconColor" size="20" style="display: inline-block;"/>
							 <text :style="{color:expertIconColor}">专家申请</text>
						 </view>
					</view>
				</view>
				<zywork-icon class="zy-user-more" type="iconiconfonti" size="20" color="#FFFFFF" @click.native="toUserSetting" />
			</view>
			<view class="zy-user-info" v-else>
				<view class="zy-user-left">
					<image class="zy-headicon" :src="headicon"></image>
					<view>
						<button class="zy-wx-btn" open-type="getUserInfo" lang="zh_CN" @getuserinfo="bindGetUserInfo">
							<view class="zy-text-big zy-text-bold">点击登录</view>
						</button>
						<view class="zy-text-small">您还未登录哦~</view>
					</view>
				</view>
			</view>
		</view>
		<view class="zy-user-balance">
			<view class="zy-user-balance-item" @click="toComission">
				<text class="zy-text-primary zy-text-big zy-text-bold">{{userWallet.rmbBalance/100}}</text>
				<text class="zy-text-info">佣金</text>
			</view>
			<view class="zy-user-balance-item" @click="toIntegral">
				<text class="zy-text-primary zy-text-big zy-text-bold">{{userWallet.integral/100}}</text>
				<text class="zy-text-info">积分</text>
			</view>
		</view>
		<uni-list>
			<zywork-list-item title="我的订阅" show-extra-icon="true" :extra-icon="{color: '#FF4539',size: '18',type: 'icondingyue'}"
			 @click="toSubscrible"></zywork-list-item>
			<zywork-list-item title="我的发布" show-extra-icon="true" :extra-icon="{color: '#568999',size: '18',type: 'iconfabu'}"
			 @click="toPublish"></zywork-list-item>
			<zywork-list-item title="我的收藏" show-extra-icon="true" :extra-icon="{color: '#892398',size: '18',type: 'iconshoucang'}"
			 @click="toCollection"></zywork-list-item>
			<zywork-list-item title="我的专家预约" show-extra-icon="true" :extra-icon="{color: '#ABC033',size: '18',type: 'iconyuyue'}"
			 @click="toAppointment"></zywork-list-item>
			<zywork-list-item title="我的咨询反馈" show-extra-icon="true" :extra-icon="{color: '#F98E69',size: '18',type: 'iconshouye'}"
			 @click="toConsult"></zywork-list-item>
			<zywork-list-item title="我的简历" show-extra-icon="true" :extra-icon="{color: '#681899',size: '18',type: 'iconresume-line'}"
			 @click="toResume"></zywork-list-item>
			<zywork-list-item title="我的抵用券" show-extra-icon="true" :extra-icon="{color: '#23AA22',size: '18',type: 'iconquan'}"
			 @click="toCoupon"></zywork-list-item>
			<zywork-list-item title="我的分享邀请" show-extra-icon="true" :extra-icon="{color: '#567890',size: '18',type: 'iconicon-test1'}"
			 @click="toShare"></zywork-list-item>
			<!--
			<zywork-list-item title="业绩二维码" show-extra-icon="true" :extra-icon="{color: '#E51C23',size: '18',type: 'iconico'}"
			 @click="toPerformanceQrcode"></zywork-list-item>
			 -->
			<zywork-list-item title="常见问题" show-extra-icon="true" :extra-icon="{color: '#CC0022',size: '18',type: 'iconbangzhu'}"
			 @click="toHelp"></zywork-list-item>
			<zywork-list-item title="联系我们" show-extra-icon="true" :extra-icon="{color: '#535CA7',size: '18',type: 'iconguanyu'}"
			 @click="toContact"></zywork-list-item>
		</uni-list>
	</view>
</template>

<script>
	import {
		DEFAULT_HEADICON,
		getOpenid,
		SHARE_CODE_PAGE_IMG,
		getShareCode,
		USER_ROLES,
		USER_ROLES_VIP1,
		USER_ROLES_VIP2,
		USER_ROLES_VIP3,
		IS_EXPERT_COLOR_TRUE,
		IS_EXPERT_COLOR_FALSE,
		IS_VIP_COLOR_TRUE,
		IS_VIP_COLOR_FALSE
	} from '@/common/util.js'
	import {
		judgeLogin,
		saveUserDetail,
		saveUserPhone,
		geUserWalletByUserId,
		getUserExpertByUserId,
	} from '@/common/user.js'
	import {
		getMyServiceUserCenter
	} from '@/common/user-center.js'

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
				userExpert: null,
				expertIconColor: IS_EXPERT_COLOR_FALSE,
				vipIconColor: IS_VIP_COLOR_FALSE,
				user: {
					headicon: '',
					nickname: '',
					gender: '',
					phone: ''
				},
				userWallet: {
					rmbBalance: 0,
					integral: 0
				},
				headicon: DEFAULT_HEADICON,
				subscrible: {
					id: null,
					userId: null,
					city: '全省',
					projectType: null,
					minMoney: null,
					maxMoney: null,
					tenderee: null,
					aptitudeType: null,
					keyword: null,
					isSubscribe: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
					isRequest: true
				},
			}
		},
		onLoad() {
			this.initData('init');
		},
		onPullDownRefresh() {
			this.initData('pullDown')
		},
		onShareAppMessage(res) {
			var shareCode = getShareCode();
			return {
				title: '江西招投标平台信息共享',
				path: '/pages/project-info/project-info?shareCode=' + shareCode,
				imageUrl: SHARE_CODE_PAGE_IMG
			}
		},
		methods: {
			initData(type) {
				judgeLogin(this, type)
				this.initUserIcon();
			},
			/** 初始用户权益标识 */
			initUserIcon() {
				getMyServiceUserCenter(this);
			},
			bindGetUserInfo(e) {
				saveUserDetail(this, {
					openid: getOpenid(),
					nickname: e.detail.userInfo.nickName,
					headicon: e.detail.userInfo.avatarUrl,
					gender: e.detail.userInfo.gender
				})
			},
			bindGetPhoneNumber(e) {
				if (e.detail.errMsg === 'getPhoneNumber:ok') {
					saveUserPhone(this, {
						openid: getOpenid(),
						encryptedData: e.detail.encryptedData,
						iv: e.detail.iv
					})
				}
			},
			toUserSetting() {
				const self = this
				this.$event.$on('chooseGender', function(data) {
					self.user.gender = data.gender
					self.$event.$off('chooseGender')
				});
				uni.navigateTo({
					url: '/pages-user-center/user-setting/user-setting?itemData=' + encodeURIComponent(JSON.stringify(this.user))
				})
			},
			toUserVip() {
				uni.navigateTo({
					url: '/pages-user-center/user-vip/user-vip'
				})
			},
			toUserExpert() {
				uni.navigateTo({
					url: '/pages-user-center/user-expert/user-expert?itemData=' + encodeURIComponent(JSON.stringify(this.userExpert))
				})
			},
			toComission() {
				uni.navigateTo({
					url: '/pages-user-center/commission/commission?itemData=' + encodeURIComponent(JSON.stringify(this.userWallet))
				})
			},
			toIntegral() {
				uni.navigateTo({
					url: '/pages-user-center/integral/integral?itemData=' + encodeURIComponent(JSON.stringify(this.userWallet))
				})
			},
			toSubscrible() {
				uni.navigateTo({
					url: '/pages-user-center/subscrible/subscrible?itemData=' + encodeURIComponent(JSON.stringify(this.subscrible))
				})
			},
			toPublish() {
				uni.navigateTo({
					url: '/pages-user-center/publish/publish'
				})
			},
			toCollection() {
				uni.navigateTo({
					url: '/pages-user-center/collection/collection'
				})
			},
			toResume() {
				uni.navigateTo({
					url: '/pages-user-center/resume/resume'
				})
			},
			toConsult() {
				uni.navigateTo({
					url: '/pages-user-center/consult/consult'
				})
			},
			toAppointment() {
				uni.navigateTo({
					url: '/pages-user-center/appointment/appointment'
				})
			},
			toShare() {
				uni.navigateTo({
					url: '/pages-user-center/share/share'
				})
			},
			toCoupon() {
				uni.navigateTo({
					url: '/pages-user-center/coupon/coupon'
				})
			},
			toPerformanceQrcode() {
				uni.navigateTo({
					url: '/pages-user-center/performance-qrcode/performance-qrcode'
				})
			},
			toHelp() {
				uni.navigateTo({
					url: '/pages-user-center/help/help'
				})
			},
			toContact() {
				uni.navigateTo({
					url: '/pages-user-center/contact/contact'
				})
			},

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

	.zy-wx-btn {
		text-align: left;
		line-height: 1;
		display: inline;
		padding: 0;
		background-color: transparent;
	}

	.zy-user-balance {
		display: flex;
		flex-direction: row;
		justify-content: between;
		align-items: center;
		background-color: $primary-backcolor;
		padding: 10upx;
		margin-bottom: 10upx;
	}

	.zy-user-balance-item {
		flex-grow: 1;
		display: flex;
		flex-direction: column;
		align-items: center;
		text-align: center;
	}

	.zy-user-balance-item:first-child {
		border-right: 1px solid $seperator-color;
	}
	
	.zy-icon-text {
		display: flex;
		flex-direction: column;
		align-items: center;
		margin-right: 20upx;
	}
	
	.zy-icon-text text {
		font-size: 24upx;
	}
	
	.zy-icon-text zywork-icon view {
		line-height: 1.0;
	}
</style>
