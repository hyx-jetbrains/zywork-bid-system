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
					<view class="zy-text-bold zy-record-card-title">订单类型：</view>
					<view>充值VIP</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-text-bold zy-record-card-title">VIP等级：</view>
					<view>
						<picker @change="chooseLevel" :value="levelIndex" :range="levelArray">
							<view class="zy-disable-flex">
								<text>{{levelArray[levelIndex]}}</text>
								<zywork-icon type="iconiconfonti" />
							</view>
						</picker>
					</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-text-bold zy-record-card-title">支付方式：</view>
					<view>
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
					<view>
						¥{{recordInfo.oldMoney / 100}}
					</view>
				</view>
				<view class="zy-disable-flex zy-record-card-item">
					<view class="zy-record-card-title">抵用券：</view>
					<view>
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
					<view class="zy-price">¥{{recordInfo.money / 100}}</view>
				</view>
			</view>
		</view>
		<view class="zy-record-card-left"></view>
		<view class="zy-record-card-right"></view>
		<view class="zy-bottom-button" v-if="showBtn">
			<!-- #ifdef MP-WEIXIN -->
			<button type="primary" @click="payRecord" :loading="loading">微信支付</button>
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
		vipLevelArray,
		payTypeArray
	} from '@/common/picker.data.js'
	import {
		getCouponByUserId
	} from '@/common/user-center.js'

	const VIP_LEVEL_MONEY_ONE = 19900
	const VIP_LEVEL_MONEY_TWO = 29900
	const VIP_LEVEL_MONEY_THREE = 39900

	const VIP_LEVEL_ONE = 0
	const VIP_LEVEL_TWO = 1
	const VIP_LEVEL_THREE = 2

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
				levelArray: vipLevelArray,
				levelIndex: 0,
				payTypeArray: payTypeArray,
				payTypeIndex: 0,
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
				recordInfo: {
					oldMoney: 0,
					couponMoney: 0,
					money: 0
				},
				loading: false,
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
				this.recordInfo.money = val - this.recordInfo.couponMoney
			},
			couponMoney(val) {
				this.recordInfo.money = this.recordInfo.oldMoney - val
			}
		},
		onLoad(event) {
			// TODO 后面把参数名替换成 payload
			const payload = event.level || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.levelIndex = decodeURIComponent(payload);
			} catch (error) {
				this.levelIndex = payload;
			}
			this.setRecordMoneyByLevel(this.levelIndex);
		},
		methods: {
			// 监听等级选中
			chooseLevel(e) {
				this.levelIndex = e.target.value
				this.setRecordMoneyByLevel(this.levelIndex);
			},
			/** 设置订单价格 */
			setRecordMoneyByLevel(level) {
				if (level == VIP_LEVEL_ONE) {
					this.recordInfo.oldMoney = VIP_LEVEL_MONEY_ONE
				} else if (level == VIP_LEVEL_TWO) {
					this.recordInfo.oldMoney = VIP_LEVEL_MONEY_TWO
				} else if (level == VIP_LEVEL_THREE) {
					this.recordInfo.oldMoney = VIP_LEVEL_MONEY_THREE
				}
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
				console.log(id + "-" + money)
				this.hideCouponDrawer()
				this.recordInfo.couponMoney = money
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
				// uni.login({
				// 	success: (e) => {
				// 		console.log("login success", e);
				// 		uni.request({
				// 			url: `https://unidemo.dcloud.net.cn/payment/wx/mp?code=${e.code}&amount=${this.recordInfo.money}`,
				// 			success: (res) => {
				// 				console.log("pay request success", res);
				// 				if (res.statusCode !== 200) {
				// 					uni.showModal({
				// 						content: "支付失败，请重试！",
				// 						showCancel: false
				// 					});
				// 					return;
				// 				}
				// 				if (res.data.ret === 0) {
				// 					console.log("得到接口prepay_id", res.data.payment);
				// 					let paymentData = res.data.payment;
				// 					uni.requestPayment({
				// 						timeStamp: paymentData.timeStamp,
				// 						nonceStr: paymentData.nonceStr,
				// 						package: paymentData.package,
				// 						signType: 'MD5',
				// 						paySign: paymentData.paySign,
				// 						success: (res) => {
				// 							uni.showToast({
				// 								title: "感谢您的赞助!"
				// 							})
				// 						},
				// 						fail: (res) => {
				// 							uni.showModal({
				// 								content: "支付失败,原因为: " + res
				// 									.errMsg,
				// 								showCancel: false
				// 							})
				// 						},
				// 						complete: () => {
				// 							this.loading = false;
				// 						}
				// 					})
				// 				} else {
				// 					uni.showModal({
				// 						content: res.data.desc,
				// 						showCancel: false
				// 					})
				// 				}
				// 			},
				// 			fail: (e) => {
				// 				console.log("fail", e);
				// 				this.loading = false;
				// 				uni.showModal({
				// 					content: "支付失败,原因为: " + e.errMsg,
				// 					showCancel: false
				// 				})
				// 			}
				// 		})
				// 	},
				// 	fail: (e) => {
				// 		console.log("fail", e);
				// 		this.loading = false;
				// 		uni.showModal({
				// 			content: "支付失败,原因为: " + e.errMsg,
				// 			showCancel: false
				// 		})
				// 	}
				// })
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
		height: 800upx;
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
		width: 400upx;
		font-size: 36upx;
	}

	.zy-record-card-item-border {
		border-bottom: 2upx solid $border-color;
		margin: 80upx 30upx;
	}
</style>
