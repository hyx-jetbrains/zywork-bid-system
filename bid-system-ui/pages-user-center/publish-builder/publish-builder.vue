<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<view v-if="type.current === 0">
				<!-- 招聘信息 -->
				<view class="zy-page-list" v-if="builderReqList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in builderReqList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.builderReqId)">
							<view @click="toBuilderReqDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">公告时间：{{item.builderReqCreateTime}}</view>
									</view>
									<view class="zy-disable-flex-right">
										¥{{item.builderReqSalary / 100}}
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">建筑工程</view>
									<view class="zy-text-info">
										{{item.builderReqMemo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
			</view>
			<view v-else>
				<!-- 应聘信息 -->
				<view class="zy-page-list" v-if="builderList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in builderList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.builderId)">
							<view @click="toBuilderDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">公告时间：{{item.builderCreateTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.builderCertificateType}}</view>
									<view class="zy-text-info">
										{{item.builderMemo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无应聘信息"></zyworkNoData>
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
		builderTypeArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	import {
		getBuilderByUserId,
		getBuilderReqByUserId,
		deleteBuilderById,
		deleteBuilderReqById
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
					items: builderTypeArray
				},
				pager: {
					pageNo: 1,
					pageSize: 10
				},
				builderReqList: [],
				builderList: [],
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
					// 刷新招聘
					getBuilderReqByUserId(this, type)
				} else {
					// 刷新应聘
					getBuilderByUserId(this, type)
				}
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往建造师需求详情页面 */
			toBuilderReqDetailPage(item) {
				this.toDetailPage('builder-req', item);
			},
			/** 前往建造师应聘详情页面 */
			toBuilderDetailPage(item) {
				this.toDetailPage('builder', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				if (this.type.current === 0) {
					deleteBuilderReqById(this, id)
				} else {
					deleteBuilderById(this, id)
				}
			},

		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
