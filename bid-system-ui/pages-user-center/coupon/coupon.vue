<template>
	<view>
		<view class="zy-uni-segmented-control">
			<uni-segmented-control :current="functionType.current" :values="functionType.items" v-on:clickItem="onClickItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-type-title zy-disable-flex" v-if="functionType.current == 0">
			<text class="zy-text-bold">抵扣券类型</text>
			<view class="zy-disable-flex-right">
				<picker @change="chooseCouponStatus" :value="couponStatusIndex" :range="couponStatusArray">
					<view class="zy-disable-flex">
						<text>{{couponStatusArray[couponStatusIndex]}}</text>
						<zywork-icon type="iconxiangxia"/>
					</view>
				</picker>
			</view>
		</view>
		<!-- 抵用券 -->
		<view v-if="functionType.current == 0">
			<view v-if="couponList.length > 0">
				<view class="zy-coupon-card zy-disable-flex" v-for="(coupon, index) in couponList" :key="index" style="position: relative;">
					<view class="zy-coupon-money">
						<text class="zy-coupon-money-detail">
							¥
							<text class="zy-text-bold zy-price">{{coupon.couponMoney / 100}}</text>
						</text>
					</view>
					<view>
						<view class="zy-text-big zy-text-bold">{{coupon.couponType}}</view>
						<view class="zy-text-info">{{coupon.couponValidTime}}</view>
					</view>
					<view class="zy-disable-flex-right">
						<view v-if="coupon.couponValidTime < currDate">
							<zywork-icon class="zy-icon-yiguoqi" type="iconyiguoqi" color="#afacac" size="60" style="display: inline-block;" />
						</view>
						<uni-tag v-else text="立即使用" type="error" size="small" :inverted="true" :circle="true" @click="useCouupon"></uni-tag>
					</view>
				</view>
			</view>
			<zywork-no-data v-else text="还没有抵用券"></zywork-no-data>
		</view>
		<!-- 抵用券使用记录 -->
		<view v-if="functionType.current == 1">
			<view class="zy-coupon-record">
				<view v-if="couponRecordlList.length > 0" class="zy-page-list" style="padding: 0upx 30upx;">
					<view v-for="(couponRecordItem, index) in couponRecordlList" :key="index" class="zy-page-list-item" style="position: relative;">
						<zywork-icon class="zy-icon-yishiyong" type="iconyishiyong" color="#afacac" size="60" style="display: inline-block;" />
						<view class="zy-coupon-title">
							<text class="zy-text-bold" style="font-size: 40upx;">{{couponRecordItem.couponType}}</text>
						</view>
						<view class="zy-disable-flex">
							<view>
								<text class="zy-text-bold">原价：</text>
								<text style="text-decoration: line-through;">
									<text class="zy-text-mini">¥</text>
									{{couponRecordItem.couponRecordOldPrice / 100}}
								</text>
							</view>
							<view style="margin-left: 190upx;">
								<text class="zy-text-bold">优惠金额：</text>
								<text>
									<text class="zy-text-mini">¥</text>
									{{couponRecordItem.couponRecordCouponPrice / 100}}
								</text>
							</view>
						</view>
						<view>
							<text class="zy-text-bold">支付金额：</text>
							<text style="color: red;">¥</text>
							<text class="zy-price">
								{{couponRecordItem.couponRecordPrice / 100}}
							</text>
						</view>
						<view style="text-align: right;">
							<text class="zy-text-info">{{couponRecordItem.couponRecordCreateTime}}</text>
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
		getCalendarDate,
		getDate
	} from '../../common/util.js'
	
	import {
		couponStatusArray
	} from '../../common/picker.data.js'
	
	import {
		getCouponByUserId,
		getCouponRecordByUserId
	} from '../../common/user-center.js'
	
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
				couponStatusIndex: 0,
				couponStatusArray: couponStatusArray,
				projectPager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'couponValidTime',
					sortOrder: 'desc',
					status: 0,
				},
				functionType: {
					current: 0,
					items: ['抵用券', '使用记录']
				},
				couponList: [],
				couponRecordlList: []
				
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			// 分段器选择类别
			onClickItem(index) {
				if (this.functionType.current !== index) {
					this.functionType.current = index
					if(index == 0) {
						getCouponByUserId(this, this.projectPager)
					} else if(index == 1) {
						getCouponRecordByUserId(this)
					}
				}
			},
			chooseCouponStatus: function(e) {
				this.couponStatusIndex = e.target.value;
				if(this.couponStatusIndex == 1) {
					this.projectPager.status = 1
				} else if(this.couponStatusIndex == 2) {
					this.projectPager.status = 2
				}
				getCouponByUserId(this, this.projectPager)
			},
			// 使用抵用券
			useCouupon() {
				uni.navigateTo({
					url: '/pages-user-center/user-vip/user-vip'
				})
			},
			initData() {
				getCouponByUserId(this, this.projectPager)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-coupon-card {
		background-color: #fff;
		border-radius: 10upx;
		padding: 40upx;
		margin: 20upx;
	}
	.zy-coupon-money {
		width: 100upx;
		text-align: center;
		margin-right: 30upx;
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
		right: 0;
	}
	
</style>
