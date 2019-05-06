<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="functionType.current" :values="functionType.items" v-on:clickItem="onClickItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<!-- 抵用券 -->
		<view v-if="functionType.current == 0">
			<view class="zy-coupon-card" v-for="(coupon, index) in couponList" :key="index" style="position: relative;">
				<view class="zy-coupon-money">
					<text class="zy-coupon-money-detail">
						¥
						<text class="zy-text-bold zy-price">{{coupon.money / 100}}</text>
					</text>
				</view>
				<view style="margin-left: 30upx;">
					<view class="zy-text-big zy-text-bold">{{coupon.type}}VIP</view>
					<view class="zy-text-info">{{coupon.validDate}}</view>
				</view>
				<view style="margin-left: 200upx;">
					<view v-if="coupon.validDate < currDate">
						<zywork-icon class="zy-icon-yiguoqi" type="iconyiguoqi" color="#afacac" size="60" style="display: inline-block;" />
					</view>
					<uni-tag v-else text="立即使用" type="error" size="small" :inverted="true" :circle="true" @click="useCouupon"></uni-tag>
				</view>
			</view>
		</view>
		<!-- 抵用券使用记录 -->
		<view v-if="functionType.current == 1">
			<view class="zy-coupon-record">
				<view v-if="couponRecordlList.length > 0" class="zy-page-list" style="padding: 0upx 30upx;">
					<view v-for="(couponRecordItem, index) in couponRecordlList" :key="index" class="zy-page-list-item" style="position: relative;">
						<zywork-icon class="zy-icon-yishiyong" type="iconyishiyong" color="#afacac" size="60" style="display: inline-block;" />
						<view class="zy-coupon-title">
							<text class="zy-text-bold" style="font-size: 40upx;">{{couponRecordItem.type}}</text>
						</view>
						<view class="zy-disable-flex">
							<view>
								<text class="zy-text-bold">原价：</text>
								<text style="text-decoration: line-through;">
									<text class="zy-text-mini">¥</text>
									{{couponRecordItem.oldPrice / 100}}
								</text>
							</view>
							<view style="margin-left: 190upx;">
								<text class="zy-text-bold">优惠金额：</text>
								<text>
									<text class="zy-text-mini">¥</text>
									{{couponRecordItem.couponePrice / 100}}
								</text>
							</view>
						</view>
						<view>
							<text class="zy-text-bold">支付金额：</text>
							<text style="color: red;">¥</text>
							<text class="zy-price">
								{{couponRecordItem.price / 100}}
							</text>
						</view>
						<view style="text-align: right;">
							<text class="zy-text-info">{{couponRecordItem.createTime}}</text>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无使用记录"></zywork-no-data>
			</view>
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	
	import {
		getCalendarDate
	} from '../../common/util.js'
	
	export default {
		components: {
			uniSegmentedControl,
			uniTag,
			zyworkNoData,
			zyworkIcon
		},
		data() {
			return {
				currDate: getCalendarDate(new Date()),
				functionType: {
					current: 0,
					items: ['抵用券', '使用记录']
				},
				couponList: [
					{
						type: '充值VIP',
						validDate: '2019-04-30',
						money: 500
					},
					{
						type: '充值VIP',
						validDate: '2019-04-29',
						money: 800
					},
					{
						type: '充值VIP',
						validDate: '2019-05-30',
						money: 1000
					}
				],
				couponRecordlList: [
					{
						type: '充值VIP',
						oldPrice: 10000,
						couponePrice: 500,
						price: 9500,
						createTime: '2019-04-26 17:50:19'
					},
					{
						type: '充值VIP',
						oldPrice: 10000,
						couponePrice: 500,
						price: 9500,
						createTime: '2019-04-26 17:50:19'
					},
					{
						type: '充值VIP',
						oldPrice: 10000,
						couponePrice: 500,
						price: 9500,
						createTime: '2019-04-26 17:50:19'
					}
				]
			}
		},
		onLoad() {
			console.log(this.currDate)
		},
		methods: {
			// 分段器选择类别
			onClickItem(index) {
				if (this.functionType.current !== index) {
					this.functionType.current = index
				}
			},
			// 使用抵用券
			useCouupon() {
				uni.showModal({
					title: '立即使用'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-coupon-card {
		display: flex;
		flex-direction: row;
		align-items: center;
		margin:20upx 20upx;
		padding:40upx 30upx;
		background-color: #fff;
		border-radius: 10upx;
	}
	.zy-coupon-money {
		width: 100upx;
		text-align: center;
	}
	.zy-coupon-money-detail {
		color: red;
	}
	
	.zy-coupon-record {
		margin-top: 20upx
	}
	
	.zy-coupon-title {
		text-align: center;
	}
	
	.zy-icon-yishiyong {
		position: absolute;
		top: 0;
		right: 0;
	}
	.zy-icon-yiguoqi {
		position: absolute;
		top: 0;
	}
	
</style>
