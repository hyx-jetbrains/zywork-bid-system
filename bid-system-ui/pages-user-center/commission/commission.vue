<template>
	<view>
		<view class="zy-commission-card">
			<view style="color: #7bc0f1">我的佣金</view>
			<view class="zy-commission zy-text-bold">{{commission}}</view>
		</view>
		<view class="zy-disable-flex">
			<view class="zy-type-title zy-text-bold">佣金记录</view>
			<view class="zy-disable-flex-right">
				<view class="uni-list-cell-db">
					<picker @change="chooseType" :value="typeIndex" :range="typeArray">
						<view class="zy-type-picker">
							<text>{{typeArray[typeIndex]}}</text>
							<zywork-icon type="iconxiangxia"/>
						</view>
					</picker>
				</view>
			</view>
		</view>
		<view class="zy-commission-record">
			<view v-if="commissionList.length > 0" class="zy-page-list" style="padding: 0upx 30upx;">
				<view v-for="(commissionItem, index) in commissionList" :key="index" class="zy-page-list-item">
					<view class="zy-disable-flex">
						<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{commissionItem.title}}</view>
						<view class="zy-text-info zy-text-small zy-disable-flex-right" style="color: #F0AD4E">
							{{commissionItem.count > 0 ? '+' : ''}}{{commissionItem.count}}
						</view>
					</view>
					<view>{{commissionItem.createTime}}</view>
				</view>
			</view>
			<zywork-no-data v-else text="暂无佣金记录"></zywork-no-data>
		</view>
		
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		revenueExpenditureStatusArray
	} from '@/common/picker.data.js'
	
	export default {
		components: {
			zyworkNoData,
			zyworkIcon
		},
		data() {
			return {
				commission: 9188,
				commissionList: [
					{
						title: '回复问题咨询',
						type: 0,
						count: 1,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 1,
						count: -10,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 0,
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 1,
						count: -11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 0,
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 0,
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 0,
						count: 11,
						createTime: '2019-04-28 10:00:00'
					},
					{
						title: '回复问题咨询',
						type: 0,
						count: 11,
						createTime: '2019-04-28 10:00:00'
					}
				],
				typeIndex: 0,
				typeArray: revenueExpenditureStatusArray,
			}
		},
		onLoad() {},
		methods: {
			// 选择收支类别
			chooseType: function(e) {
				this.typeIndex = e.target.value
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';
	
	.zy-commission-card {
		height: 200upx;
		background-color:#f1f1f1;
		text-align: center;
		margin: 30upx 20upx;
		border-radius: 20upx;
		padding-top: 60upx;
	}
	
	.zy-commission {
		color: #108EE9;
		font-size: 64upx;
	}
	
	.zy-type-picker {
		display: flex;
		flex-direction: row;
		align-items: center;
		margin-right: 10upx;
		width: 100upx;
	}
	
	.zy-commission-record {
		margin: 10upx 20upx;
	}
	
</style>
