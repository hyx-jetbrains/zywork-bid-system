<template>
	<view>
		<!-- 我的预约 -->
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="appointmentStatus.current" :values="appointmentStatus.items" v-on:clickItem="onClickItem"
			 styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-type-title zy-disable-flex">
			<text class="zy-text-bold">我的专家预约记录</text>
			<view class="zy-disable-flex-right">
				<picker @change="choosePayStatus" :value="payStatusIndex" :range="payStatusArray">
					<view class="zy-disable-flex">
						<text>{{payStatusArray[payStatusIndex]}}</text>
						<zywork-icon type="iconxiangxia" />
					</view>
				</picker>
			</view>
		</view>
		<view v-if="expertSubscribeList.length > 0">
			<view v-for="(expertSubscribe, index) in expertSubscribeList" :key="index">
				<uni-card :title="expertSubscribe.questionType" :extra="expertSubscribe.subscribeStatus">
					<view>
						<text>{{expertSubscribe.questionDesc}}</text>
						<view class="zy-time zy-text-info zy-text-small">{{expertSubscribe.createTime}}</view>
					</view>

					<!-- 支付成功之后才能查看专家回复的内容 -->
					<view v-if="expertSubscribe.price != 0">
						<view class="zy-bottom-border" />
						<view class="zy-text-bold">
							专家回复：
						</view>
						<text>
							{{expertSubscribe.replyContent}}
						</text>
						<view class="zy-time zy-text-info zy-text-small">
							{{expertSubscribe.replyTime}}
						</view>
					</view>

					<!-- 后台设置好金额之后，显示订单信息让用户进行支付 -->
					<view v-if="expertSubscribe.price != 0">
						<view class="zy-bottom-border zy-position-relative" />
						<zywork-icon v-if="expertSubscribe.vipFlag === 1" type="iconhuiyuantequan" size="24" color="#dd524d" class="zy-vip-flag"></zywork-icon>
						<view>
							<text class="zy-text-bold">价格：</text>

							<text class="zy-text-warning zy-text-big">
								¥{{expertSubscribe.price / 100}}
							</text>
						</view>
						<view>
							<text class="zy-text-bold">处理状态：</text>
							{{expertSubscribe.subscribeStatus}}
						</view>
						<view>
							<text class="zy-text-bold">支付状态：</text>
							{{expertSubscribe.payStatus}}
							<text v-if="expertSubscribe.payStatus === '待支付'" class="zy-text-warning">(支付成功之后即可查看专家回复内容)</text>
						</view>
						<view class="zy-button" v-if="expertSubscribe.payStatus == '待支付'">
							<button type="primary" @click="pay(expertSubscribe)" :disabled="payBtnDisabled">立即支付</button>
						</view>
					</view>
				</uni-card>
			</view>
		</view>
		<zywork-no-data v-else text="暂无预约记录"></zywork-no-data>

		<zywork-fab :pattern="pattern" :horizontal="horizontal" :vertical="vertical" :direction="direction" 
			:showContent="appointmentPopup" :iconType="iconType"
			@trigger="trigger"></zywork-fab>
		<uni-popup :show="appointmentPopup" position="bottom" @hidePopup="trigger(false)">
			<view class="zy-popup-bottom-title">选择预约类型</view>
			<view class="zy-popup-bottom-content">
				<view v-for="(item, index) in appointmentTypeData" :key="index" class="zy-popup-bottom-content-box" @click="toAppointmentPage(item.name)">
					<zywork-icon :type="item.icon" size="26" :color="item.iconColor"></zywork-icon>
					<view class="zy-popup-bottom-content-text">{{ item.text }}</view>
				</view>
			</view>
			<view class="zy-popup-bottom-btn" @click="trigger(false)">取消预约</view>
		</uni-popup>

		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import uniCard from "@/components/uni-card/uni-card.vue"
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkFab from '@/components/zywork-fab/zywork-fab.vue'
	import uniPopup from '@/components/uni-popup/uni-popup.vue'
	import {
		operationArray,
		payStatusArray
	} from '@/common/picker.data.js'
	import {
		getExpertSubscribeByUserId,
		payExpertRecord
	} from '@/common/user-center.js'
	import {
		showInfoToast,
		USER_FLAG,
		USER_FLAG_VIP,
		USER_FLAG_ORDINARY
	} from '@/common/util.js'
	export default {
		components: {
			uniCard,
			uniSegmentedControl,
			zyworkIcon,
			zyworkNoData,
			zyworkFab,
			uniPopup
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				pager: {
					pageNo: 1,
					pageSize: 10,
					subscribeStatus: null,
					payStatus: null
				},
				appointmentStatus: {
					current: 0,
					items: operationArray
				},
				payStatusArray: payStatusArray,
				payStatusIndex: 0,
				expertSubscribeList: [],
				payBtnDisabled: false,
				directionStr: '垂直',
				horizontal: 'right',
				vertical: 'bottom',
				direction: 'horizontal',
				iconType: 'uni-icon-chatbubble-filled',
				pattern: {
					color: '#7A7E83',
					backgroundColor: '#fff',
					selectedColor: '#007AFF',
					buttonColor: '#007AFF'
				},
				appointmentPopup: false,
				appointmentTypeData: [{
					text: '咨询专家',
					icon: 'iconzhuanjiarenzheng',
					iconColor: '#CCC',
					name: 'zxzj'
				}],
			}
		},
		onLoad() {
			uni.hideShareMenu();
			getExpertSubscribeByUserId(this, 'init');
			this.initData();
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			getExpertSubscribeByUserId(this, 'reachBottom')
		},
		methods: {
			initData() {
				var userFlag = uni.getStorageSync(USER_FLAG);
				if (userFlag === USER_FLAG_VIP) {
					this.appointmentTypeData.push({
						text: '快速咨询',
						icon: 'iconzixun',
						iconColor: '#CCC',
						name: 'kszx'
					})
				} else {
					this.appointmentTypeData = [{
						text: '咨询专家',
						icon: 'iconzhuanjiarenzheng',
						iconColor: '#CCC',
						name: 'zxzj'
					}]
				}
			},
			// 分段器选择是否处理
			onClickItem(index) {
				if (this.appointmentStatus.current !== index) {
					this.appointmentStatus.current = index
					this.showLoadMore = false
					if (index == 0) {
						this.pager.subscribeStatus = null
					} else if (index == 1) {
						this.pager.subscribeStatus = "未处理"
					} else if (index == 2) {
						this.pager.subscribeStatus = "已处理"
					}
					getExpertSubscribeByUserId(this, 'init')
				}
			},
			// 立即支付
			pay(item) {
				this.payBtnDisabled = true;
				payExpertRecord(this, item.id);
			},
			// 选择支付方式
			choosePayStatus: function(e) {
				this.payStatusIndex = e.target.value;
				this.showLoadMore = false
				if (this.payStatusIndex == 0) {
					this.pager.payStatus = null
				} else if (this.payStatusIndex == 1) {
					this.pager.payStatus = "待支付"
				} else if (this.payStatusIndex == 2) {
					this.pager.payStatus = "已支付"
				}
				getExpertSubscribeByUserId(this, 'init')
			},
			/** 悬浮按钮事件监听 */
			trigger(e) {
				this.appointmentPopup = e;
			},
			/** 前往咨询页面 */
			toAppointmentPage(name) {
				uni.redirectTo({
					url: '/pages-user-center/appointment/add-appointment?type=' + encodeURIComponent(name)
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-bottom-border {
		margin: 20upx 0;
		border-bottom: 1upx dashed $border-color;
	}

	.zy-button {
		margin-top: 20upx;
	}

	.zy-time {
		text-align: right;
	}

	.zy-vip-flag {
		position: absolute;
		top: 145upx;
		right: 30upx;
	}
</style>
