<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<view v-if="type.current === 0">
				<!-- 拼车信息 -->
				<view class="zy-page-list" v-if="carpoolList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in carpoolList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
							<view @click="toCarpoolDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.headicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.nickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											{{item.startTime}}
											<text class="zy-text-mini" style="color: #108EE9; margin-left: 20upx;">{{item.carType}}</text>
										</view>
									</view>
									<view class="zy-disable-flex-right">
										¥{{item.price / 100}}
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">
										{{item.startAddr}}
										-
										{{item.endAddr}}
									</view>
								</view>
							</view>
							<view class="zy-text-info zy-disable-flex">
								<view>
									<text style="margin-right: 20upx;">搭车人数:</text>
									{{item.carpoolRecordCount}}/{{item.peopleCount}}
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无拼车信息"></zyworkNoData>
			</view>
			<view v-else>
				<!-- 找车信息 -->
				<view class="zy-page-list" v-if="seekcarList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in seekcarList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
							<view @click="toSeekcarDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.headicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.nickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">{{item.startTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">
										{{item.startAddr}}
										-
										{{item.endAddr}}
									</view>
									<view class="zy-text-info">
										{{item.memo}}
									</view>
								</view>
							</view>
							<view class="zy-text-info zy-disable-flex">
								<view>
									<text style="margin-right: 20upx;">申请人数:</text>
									{{item.seekcarRecordCount}}/1
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无找车信息"></zyworkNoData>
			</view>
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import {
		openMarkArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	export default {
		components: {
			uniSegmentedControl,
			zyworkNoData,
			zyworkIcon,
			uniSwipeAction
		},
		data() {
			return {
				options: [{
					text: '删除',
					style: {
						backgroundColor: 'rgb(255,58,49)'
					}
				}],
				type: {
					current: 0,
					items: openMarkArray
				},
				carpoolList: [{
						id: 1,
						nickname: '刘某某',
						headicon: DEFAULT_HEADICON,
						startTime: '2019-04-24 17:24:01',
						startCity: '北京/北京市/东城区',
						startAddr: '赣州',
						endCity: '北京/北京市/东城区',
						endAddr: '上饶',
						price: 30000,
						carType: '小轿车',
						carpoolRecordCount: 1,
						peopleCount: 3,
						name: '危锦辉',
						phone: '18279700225'
					},
					{
						id: 2,
						nickname: '张某某',
						headicon: DEFAULT_HEADICON,
						startTime: '2019-04-24 17:24:01',
						startCity: '北京/北京市/东城区',
						startAddr: '赣州',
						endCity: '北京/北京市/东城区',
						endAddr: '上饶',
						price: 60000,
						carType: '小轿车',
						peopleCount: 2,
						name: '危锦辉',
						phone: '18279700225',
						carpoolRecordCount: 2,
					}
				],
				seekcarList: [{
					id: 1,
					nickname: '张某某',
					headicon: DEFAULT_HEADICON,
					startTime: '2019-04-24 17:24:01',
					startCity: '北京/北京市/东城区',
					startAddr: '赣州',
					endCity: '北京/北京市/东城区',
					endAddr: '上饶',
					memo: '去上饶，着急去，有意请联系',
					name: '危锦辉',
					phone: '18279700225',
					seekcarRecordCount: 0
				}],
			}
		},
		onLoad() {},
		methods: {
			/** 分段器选择类别 */
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
				}
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往拼车详情页面 */
			toCarpoolDetailPage(item) {
				this.toDetailPage('carpool', item);
			},
			/** 前往找车详情页面 */
			toSeekcarDetailPage(item) {
				this.toDetailPage('seekcar', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				if (this.type.current === 0) {
					console.log(id);
					uni.showToast({
						title: '删除拼车：' + id,
						icon: 'none'
					})
				} else {
					console.log(id);
					uni.showToast({
						title: '删除找车：' + id,
						icon: 'none'
					})
				}
				
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
