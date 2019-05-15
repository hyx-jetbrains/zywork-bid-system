<template>
	<view>
		<!-- 我发布的求带资料记录 -->
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<!-- 求带资料信息 -->
			<view class="zy-page-list" v-if="seekDataList.length > 0">
				<view class="zy-page-list-item" v-for="(item, index) in seekDataList" :key="index">
					<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
						<view @click="toSeekDataDetailPage(item)">
							<view class="zy-disable-flex">
								<image class="zy-page-mini-headicon" :src="item.headicon" />
								<view>
									<view class="zy-disable-flex">
										<text class="zy-text-bold" style="margin-right: 20upx;">{{item.dataType}}</text>
										<text class="zy-text-bold">{{item.dataCount}}份</text>
									</view>
									<view class="zy-text-mini zy-text-info" style="color: #108EE9">最晚时间：{{item.latestTime}}</view>
								</view>
								<view class="zy-disable-flex-right">
									<view class="zy-disable-flex">
										赏金：
										<text style="margin-right: 10upx;">¥{{item.price / 100}}</text>
										<!-- <uni-tag v-if="item.isUrgent === 0" text="急" type="error" size="small" :inverted="true" :circle="false"></uni-tag> -->
										<zywork-icon v-if="item.isUrgent === 0" type="iconjinjidingdan" color="#dd524d" size="20" />
									</view>
								</view>

							</view>
							<view>
								<view class="zy-text-bold">
									出发地：
									<text class="zy-text-info">{{item.startAddr}}</text>
								</view>
								<view class="zy-text-bold">
									目的地：
									<text class="zy-text-info">{{item.endAddr}}</text>
								</view>
							</view>
						</view>
					</uni-swipe-action>
				</view>
			</view>
			<zyworkNoData v-else text="暂无求带资料信息"></zyworkNoData>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
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
				seekDataList: [{
						id: 1,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						dataType: '资料',
						dataCount: 1,
						latestTime: '2019-04-25 00:00:00',
						price: 10000,
						isUrgent: 0,
						startAddr: '赣州',
						endAddr: '吉安',
						phone: '18279700225',
						memo: '没有说明',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 2,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						dataType: '资料',
						dataCount: 1,
						latestTime: '2019-04-25 00:00:00',
						price: 20000,
						isUrgent: 1,
						startAddr: '赣州',
						endAddr: '吉安',
						phone: '18279700225',
						memo: '',
						createTime: '2019-04-24 17:24:01'
					}
				]
			}
		},
		onLoad() {},
		methods: {
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往求带资料详情页面 */
			toSeekDataDetailPage(item) {
				this.toDetailPage('seek-data', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				console.log(id);
				uni.showToast({
					title: '删除：' + id,
					icon: 'none'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
