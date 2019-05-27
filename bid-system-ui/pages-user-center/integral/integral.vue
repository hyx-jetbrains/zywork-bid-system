<template>
	<view>
		<view class="zy-integral-card">
			<view style="color: #7bc0f1">我的积分</view>
			<view class="zy-integral zy-text-bold">{{userWallet.integral/100}}</view>
		</view>
		<view class="zy-type-title zy-text-bold">积分记录</view>
		<view class="zy-integral-record">
			<view v-if="integralList.length > 0" class="zy-page-list" style="padding: 0upx 30upx;">
				<view v-for="(integralItem, index) in integralList" :key="index" class="zy-page-list-item">
					<view class="zy-disable-flex">
						<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{integralItem.subType}}</view>
						<view class="zy-text-info zy-text-small zy-disable-flex-right" style="color: #F0AD4E">
							{{integralItem.amount > 0 ? '+' : ''}}{{integralItem.amount}}
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
	import {
		getAccountDetailByUserId
	} from '@/common/user-center.js'
	export default {
		components: {
			zyworkNoData
		},
		data() {
			return {
				userWallet: {},
				integralList: [],
				params: {
					pageNo: 1,
					pageSize: 10
				}
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.userWallet = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.userWallet = JSON.parse(payload);
			}
			
			this.initData()
		},
		methods: {
			initData() {
				getAccountDetailByUserId(this, this.params)
			}
		}
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
