<template>
	<view>
		<view class="zy-contact-page">
			<view class="zy-contact-icon">
				<zywork-icon type="icongongsi" color="#66affc" size="100" style="display: inline-block;" />
			</view>
			<view class="zy-text-bold zy-text-big zy-company-name">您还未登入哦</view>
			<button type="primary" style="width: 90%" open-type="getUserInfo" lang="zh_CN" @getuserinfo="bindGetUserInfo">
				点击授权登录
			</button>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		getOpenid
	} from '@/common/util.js'
	import {
		xcxLoginSimple,
		saveUserDetailSimple
	} from '@/common/user.js'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {}
		},
		onLoad() {
			xcxLoginSimple(this)
		},
		methods: {
			bindGetUserInfo(e) {
				saveUserDetailSimple(this, {
					openid: getOpenid(),
					nickname: e.detail.userInfo.nickName,
					headicon: e.detail.userInfo.avatarUrl,
					gender: e.detail.userInfo.gender
				})
			},
		}
	}
</script>

<style lang="scss">
	@import '@/common/zywork-main.scss';

	.zy-contact-page {
		text-align: center;
	}
	.zy-company-name {
		margin-bottom: 30upx;
	}
	.zy-company-memo {
		background-color: #FFFFFF;
		text-align: left;
	}
	.zy-company-memo-title {
		font-size: 32upx;
		text-overflow: ellipsis;
		white-space: nowrap;
		color: inherit;
		line-height: 1.5;
		margin-right: 10upx;
		padding: 20upx 30upx;
	}
	.zy-company-memo-content {
		padding: 0 30upx 30upx 30upx;
		text-indent: 2em;
	}
</style>
