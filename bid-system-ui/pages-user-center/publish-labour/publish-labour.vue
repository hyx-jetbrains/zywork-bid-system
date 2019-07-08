<template>
	<view>
		<!-- 我的劳务信息 -->
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<view v-if="type.current === 0">
				<!-- 求职信息 -->
				<view class="zy-page-list" v-if="labourList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in labourList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.labourId)">
							<view @click="toLabourDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">发布时间：{{item.labourCreateTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.labourWorkType}}</view>
									<view class="zy-text-info">
										{{item.labourMemo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无求职信息"></zyworkNoData>
			</view>
			<view v-else>
				<!-- 招聘信息 -->
				<view class="zy-page-list" v-if="labourReqList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in labourReqList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.labourReqId)">
							<view @click="toLabourReqDetailPage(item)">
								<view class="zy-disable-flex">
									<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.labourReqCompName}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">发布时间：{{item.labourReqCreateTime}}</view>
									</view>
									<view class="zy-disable-flex-right">
										{{item.labourReqJobType}}
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.labourReqWorkType}}</view>
									<view class="zy-text-info">
										{{item.labourReqMemo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>

			</view>
		</view>

		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import {
		labourArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	import {
		getLabourByUserId,
		getLabourReqByUserId,
		deleteLabourById,
		deleteLabourReqById
	} from '@/common/user-center.js'
	export default {
		components: {
			uniSegmentedControl,
			zyworkNoData,
			zyworkIcon,
			uniSwipeAction
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				options: [{
					text: '删除',
					style: {
						backgroundColor: 'rgb(255,58,49)'
					}
				}],
				type: {
					current: 0,
					items: labourArray
				},
				pager: {
					pageNo: 1,
					pageSize: 10
				},
				labourReqList: [],
				labourList: [],
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.checkRefresh('init')
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			this.checkRefresh('reachBottom')
		},
		methods: {
			/** 初始化查询数据 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			// 分段器选择类别
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
					this.initPager()
					this.checkRefresh('init');
				}
			},
			/** 检查刷新 */
			checkRefresh(type) {
				if (this.type.current == 0) {
					// 刷新求职
					getLabourByUserId(this, type)
				} else {
					// 刷新招聘
					getLabourReqByUserId(this, type)
				}
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往劳务招聘详情页面 */
			toLabourReqDetailPage(item) {
				this.toDetailPage('labour-req', item);
			},
			/** 前往劳务求职详情页面 */
			toLabourDetailPage(item) {
				this.toDetailPage('labour', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				if (this.type.current === 0) {
					deleteLabourById(this, id)
				} else {
					deleteLabourReqById(this, id)
				}
			},

		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
