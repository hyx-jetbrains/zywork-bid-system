<template>
	<view>
		<view class="zy-type-title zy-text-bold">我的等级</view>
		<uni-card title="V0">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconVIP" color="#CCCCCC" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">拥有权限：</text>
				没有权限
			</view>
		</uni-card>
		<view class="zy-type-title zy-text-bold">等级介绍</view>
		<uni-card title="V1">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconvip1" color="#33FF66" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">权限：</text>
				某某某权限查看特权
			</view>
			<view>
				<text class="zy-text-bold">价格：</text>
				<text class="zy-text-warning zy-text-big">¥199</text>
			</view>
			<view class="zy-vip-button">
				<button type="primary" @click="openVIP('1')">立即开通</button>
			</view>
		</uni-card>
		
		<uni-card title="V2">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconvip2" color="#33CCFF" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">权限：</text>
				某某某权限查看特权
			</view>
			<view>
				<text class="zy-text-bold">价格：</text>
				<text class="zy-text-warning zy-text-big">¥299</text>
			</view>
			<view class="zy-vip-button">
				<button type="primary" @click="openVIP('2')">立即开通</button>
			</view>
		</uni-card>
		
		<uni-card title="V3">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconvip3" color="#CC00FF" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">权限：</text>
				某某某权限查看特权
			</view>
			<view>
				<text class="zy-text-bold">价格：</text>
				<text class="zy-text-warning zy-text-big">¥399</text>
			</view>
			<view class="zy-vip-button">
				<button type="primary" @click="openVIP('3')">立即开通</button>
			</view>
		</uni-card>
	</view>
</template>

<script>
	import uniCard from "@/components/uni-card/uni-card.vue"
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	export default {
		components: {
			uniCard,
			zyworkIcon
		},
		data() {
			return {

			}
		},
		onLoad() {},
		methods: {
			// 开通VIP
			openVIP(type) {
				uni.showModal({
					title: type
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-type-title {
		padding-left: 10upx;
		margin: 10upx 15upx;
		border-left: 10upx solid $primary-color;
	}
	
	.zy-vip-button {
		margin-top: 20upx;
	}
	
</style>
