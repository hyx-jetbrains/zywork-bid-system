<template>
	<view>
		<view class="zy-bottom-background">
			<view>
				<view class="zy-record-tip zy-record-tip-com zy-text-bold">待支付 。。。</view>
				<view class="zy-record-tip-desc zy-record-tip-com">
					请核对订单无误后点击《立即支付》完成付款
					<zywork-icon type="iconduigou" color="#FFFFFF" size="15" style="display: inline-block;" />
				</view>
			</view>
			<view class="zy-record-card">
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-text-bold zy-record-card-title">服务类型：</view>
					<view class="zy-disable-flex-right">{{item.title}}</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-text-bold zy-record-card-title">购买年限：</view>
					<view class="zy-disable-flex-right">
						<picker @change="chooseValidYear" :value="validYearIndex" :range="validYearArray">
							<view class="zy-disable-flex">
								<text>{{validYearArray[validYearIndex]}}年</text>
								<zywork-icon type="iconiconfonti" />
							</view>
						</picker>
					</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-text-bold zy-record-card-title">支付方式：</view>
					<view class="zy-disable-flex-right">
						<picker @change="choosePayType" :value="payTypeIndex" :range="payTypeArray">
							<view class="zy-disable-flex">
								<text>{{payTypeArray[payTypeIndex]}}</text>
								<zywork-icon type="iconiconfonti" />
							</view>
						</picker>
					</view>
				</view>
				<view class="zy-record-card-item-border"></view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-record-card-title">金额：</view>
					<view class="zy-disable-flex-right">
						¥{{recordInfo.oldMoney / 100}}
					</view>
				</view>
				<view v-if="showDiscount" class="zy-disable-flex zy-record-card-item">
					<view class="zy-record-card-title">折扣：</view>
					<view class="zy-disable-flex-right">
						{{recordInfo.discount}}折
					</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-record-card-title">抵用券：</view>
					<view class="zy-disable-flex-right">
						<view class="zy-disable-flex" @click="showCouponDrawer">
							<text v-if="recordInfo.couponMoney != 0">
								¥{{recordInfo.couponMoney / 100}}
							</text>
							<text v-else>选择抵用券</text>
							<zywork-icon type="iconiconfonti" />
						</view>
						<uni-drawer :visible="couponDrawer" mode="right" @close="couponDrawer = false">
							<uni-list>
								<view v-if="couponList.length > 0">
									<zywork-list-item title="暂不使用" @click="cancelUseCoupon"></zywork-list-item>
									<zywork-list-item v-for="(couponItem, index) in couponList" :key="index" :title="'¥' + couponItem.couponMoney / 100"
									 note="点击使用" @click="useCoupon(couponItem.userCouponId, couponItem.couponMoney)"></zywork-list-item>
								</view>
								<zywork-no-data v-else text="暂无可用的抵用券"></zywork-no-data>
							</uni-list>
						</uni-drawer>
					</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-record-card-title">实付金额：</view>
					<view class="zy-price zy-disable-flex-right">¥{{recordInfo.money / 100}}</view>
				</view>
			</view>
		</view>
		<view class="zy-record-card-left"></view>
		<view class="zy-record-card-right"></view>
		<view class="zy-bottom-button" v-if="showBtn">
			<!-- #ifdef MP-WEIXIN -->
			<button type="primary" @click="payRecord" :loading="loading">立即支付</button>
			<!-- #endif -->
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniDrawer from '@/components/uni-drawer/uni-drawer.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		payTypeArray,
		buyServiceValidYearArray
	} from '@/common/picker.data.js'
	import {
		getCouponByUserId,
		payServiceRecord
	} from '@/common/user-center.js'

	export default {
		components: {
			zyworkIcon,
			uniDrawer,
			uniList,
			zyworkListItem,
			zyworkNoData
		},
		data() {
			return {
				item: {},
				payTypeArray: payTypeArray,
				payTypeIndex: 0,
				validYearArray: buyServiceValidYearArray,
				validYearIndex: 0,
				couponDrawer: false,
				showBtn: true,
				pager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'couponValidTime',
					sortOrder: 'desc',
					status: 1
				},
				couponList: [],
				initPrice: 0,
				recordInfo: {
					validYear: 1,
					discount: 100,
					oldMoney: 0,
					couponMoney: 0,
					money: 0
				},
				showDiscount: false,
				loading: false,
				formData: {
					serviceId: 0,
					validYear: 1,
					userCouponId: 0,
					type: 0
				}
			}
		},
		computed: {
			oldMoney() {
				return this.recordInfo.oldMoney
			},
			couponMoney() {
				return this.recordInfo.couponMoney
			}
		},
		watch: {
			oldMoney(val) {
				if (!this.showDiscount) {
					this.recordInfo.money = val - this.recordInfo.couponMoney
				}
			},
			couponMoney(val) {
				this.recordInfo.money = this.recordInfo.money - val
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			this.initPrice = this.recordInfo.oldMoney = this.item.price;
			this.recordInfo.discount = this.item.discount;
			this.formData.serviceId = this.item.id;
			this.formData.type = this.item.type;
		},
		methods: {
			/** 监听购买年数 */
			chooseValidYear(e) {
				this.validYearIndex = e.target.value
				this.setRecordDiscount(this.validYearIndex)
				this.recordInfo.couponMoney = 0
			},
			/** 设置订单折扣 */
			setRecordDiscount(year) {
				var tempYear = parseInt(year) + 1;
				this.formData.validYear = tempYear;
				if (tempYear > 1) {
					this.showDiscount = true;
					this.recordInfo.money = tempYear * this.initPrice * (this.recordInfo.discount / 100);
				} else {
					this.showDiscount = false;
				}
				this.recordInfo.oldMoney = tempYear * this.initPrice;
			},
			// 监听支付方式选中
			choosePayType(e) {
				this.payTypeIndex = e.target.value
			},
			/** 显示选择抵用券的弹窗 */
			showCouponDrawer() {
				this.couponDrawer = true;
				this.showBtn = false;
				getCouponByUserId(this, 'init');
			},
			// 使用抵用券
			useCoupon(id, money) {
				this.formData.userCouponId = id;
				this.hideCouponDrawer()
				this.recordInfo.couponMoney = money
			},
			// 取消使用抵用券
			cancelUseCoupon() {
				this.hideCouponDrawer()
				this.recordInfo.couponMoney = 0;
				this.formData.userCouponId = 0;
			},
			// 隐藏抵用券弹窗
			hideCouponDrawer() {
				this.couponDrawer = false
				this.showBtn = true
			},
			// 支付订单
			payRecord() {
				console.log("发起支付");
				this.loading = true;
				console.log(this.formData);
				payServiceRecord(this, this.formData);
			}

		},
		onNavigationBarButtonTap(e) {
			this.couponDrawer = !this.couponDrawer
		},
		onBackPress() {
			if (this.couponDrawer) {
				this.hideCouponDrawer()
				return true
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-bottom-background {
		background-color: $primary-color;
		height: 560upx;
		position: relative;
	}

	.zy-record-card {
		width: 690upx;
		height: 830upx;
		background-color: #FFFFFF;
		position: absolute;
		top: 170upx;
		margin: 30upx;
		border-radius: 20upx;
		padding-top: 20upx;
	}

	.zy-record-card-left {
		position: absolute;
		top: 100;
		right: 0;
		width: 50upx;
		height: 50upx;
		background-color: $primary-page-backcolor;
		border-radius: 50upx 0 0 50upx;
	}

	.zy-record-card-right {
		position: absolute;
		top: 100;
		left: 0;
		width: 50upx;
		height: 50upx;
		background-color: $primary-page-backcolor;
		border-radius: 0 50upx 50upx 0;
	}

	.zy-record-tip-com {
		color: #FFFFFF;
		padding: 0 30upx;
	}

	.zy-record-tip {
		font-size: 44upx;
		padding-top: 20upx;
	}

	.zy-record-tip-desc {
		font-size: 28upx;
	}

	.zy-record-card-item {
		margin: 30upx 50upx 0 50upx;
	}

	.zy-record-card-title {
		font-size: 36upx;
	}

	.zy-record-card-item-border {
		border-bottom: 2upx solid $border-color;
		margin: 80upx 30upx;
	}
</style>
