<template>
	<view>
		<view class="zy-contact-page">
			<view class="zy-contact-icon">
				<zywork-icon type="icongongsi" color="#66affc" size="100" style="display: inline-block;" />
			</view>
			<view class="zy-text-bold zy-text-big zy-company-name">{{sysInfo.compName}}</view>
			<uni-list>
				<zywork-list-item title="客服电话" :note="sysInfo.compPhone" @click="callPhone"></zywork-list-item>
				<zywork-list-item title="公司邮箱" :note="sysInfo.compEmail" @click="copyData(sysInfo.compEmail)"></zywork-list-item>
				<zywork-list-item title="公司地址" :note="sysInfo.compAddr" @click="copyData(sysInfo.compAddr)"></zywork-list-item>
			</uni-list>
			<view class="zy-company-memo">
				<view class="zy-company-memo-title">公司简介</view>
				<view class="zy-company-memo-content">
					{{sysInfo.compMemo}}
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import {getSysInfo} from '@/common/user.js'
	export default {
		components: {
			zyworkIcon,
			uniList,
			zyworkListItem
		},
		data() {
			return {
				sysInfo: {}
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.initData();
		},
		methods: {
			/** 初始化数据 */
			initData() {
				getSysInfo(this)
			},
			// 打电话
			callPhone() {
				uni.makePhoneCall({
					phoneNumber: this.sysInfo.compPhone,
					success: () => {
						console.log("成功拨打电话")
					}
				})
			},
			// 复制邮箱或地址
			copyData(data) {
				if (data.length <= 0) {
					uni.showModal({
						title: '复制失败',
						content: '内容为空',
						showCancel: false
					})
					return;
				}
				uni.setClipboardData({
					data: data,
					success: () => {
						console.log('复制成功：' + data)
					},
					fail: () => {
						uni.showModal({
							content: '复制失败',
							showCancel: false
						})
					}
				});
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
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
