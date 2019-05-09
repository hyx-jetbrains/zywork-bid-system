<template>
	<view>
		<view class="zy-integral-card">
			<view style="color: #7bc0f1">我的积分</view>
			<view class="zy-integral zy-text-bold">{{integral}}</view>
		</view>
		<view class="zy-type-title zy-text-bold">积分记录</view>
		<view class="zy-integral-record">
			<view v-if="integralList.length > 0" class="zy-page-list" style="padding: 0upx 30upx;">
				<view v-for="(integralItem, index) in integralList" :key="index" class="zy-page-list-item">
					<view class="zy-disable-flex">
						<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{integralItem.title}}</view>
						<view class="zy-text-info zy-text-small zy-disable-flex-right" style="color: #F0AD4E">
							{{integralItem.count > 0 ? '+' : ''}}{{integralItem.count}}
						</view>
					</view>
					<view>{{integralItem.createTime}}</view>
				</view>
			</view>
			<zywork-no-data v-else text="暂无积分记录"></zywork-no-data>
		</view>
		
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	export default {
		components: {
			zyworkNoData
		},
		data() {
			return {
				integral: 9188,
				integralList: [
					{
						title: '充值VIP',
						count: 1,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: -10,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 1,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 1,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 1,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '充值VIP',
						count: 12,
						createTime: '2019-04-28 10:00:00'
					}
				]
			}
		},
		onLoad() {},
		methods: {}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-integral-card {
		height: 200upx;
		background-color:#f1f1f1;
		text-align: center;
		margin: 30upx 20upx;
		border-radius: 5%;
		padding-top: 60upx;
	}
	
	.zy-integral {
		color: #108EE9;
		font-size: 64upx;
	}
	
	.zy-integral-record {
		margin: 10upx 20upx;
	}
	
</style>
