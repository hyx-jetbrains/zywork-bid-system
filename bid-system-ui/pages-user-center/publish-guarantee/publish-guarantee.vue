<template>
	<view>
		<!-- 我发布的申请保函 -->
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<!-- 我发布的申请保函信息 -->
			<view class="zy-page-list" v-if="guaranteeList.length > 0">
				<view class="zy-page-list-item" v-for="(item, index) in guaranteeList" :key="index">
					<uni-swipe-action :options="options" @click="confirmOptions(item.guaranteeId)">
						<view @click="toGuaranteeDetailPage(item)">
							<view class="zy-disable-flex">
								<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
								<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
								<view>
									<view>
										<text class="zy-text-bold">{{item.userDetailNickname}}</text>
									</view>
									<view class="zy-text-mini zy-text-info" style="color: #108EE9">
										{{item.guaranteeCreateTime}}
									</view>
								</view>
								<view class="zy-disable-flex-right">
									<text style="margin-right: 10upx;">{{item.guaranteeHandleStatus}}</text>
								</view>
							</view>
							<view>
								<view class="zy-text-bold">
									{{item.guaranteeProjectName}}
								</view>
								<view class="zy-text-info zy-disable-flex">
									<view class="zy-text-bold">
										招标单位名称：
										<text class="zy-text-info">{{item.guaranteeMarkUnitName}}</text>
									</view>
									<view class="zy-text-bold zy-disable-flex-right">
										工期(天)：
										<text class="zy-text-info">{{item.guaranteeConstructionPeriod}}</text>
									</view>
								</view>
								<view class="zy-text-info zy-disable-flex">
									<view class="zy-text-bold">
										申请单位：
										<text class="zy-text-info">{{item.guaranteeApplicant}}</text>
									</view>
								</view>
							</view>
						</view>
					</uni-swipe-action>
				</view>
			</view>
			<zyworkNoData v-else text="暂无保函信息"></zyworkNoData>
		</view>

		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	import {
		getGuaranteeByUserId,
		deleteGuaranteeById
	} from '@/common/user-center.js'
	export default {
		components: {
			zyworkNoData,
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
				pager: {
					pageNo: 1,
					pageSize: 10
				},
				guaranteeList: [],
			}
		},
		onLoad() {
			uni.hideShareMenu();
			getGuaranteeByUserId(this, 'init');
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			getGuaranteeByUserId(this, 'reachBottom')
		},
		methods: {
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往其他岗位招聘详情页面 */
			toGuaranteeDetailPage(item) {
				this.toDetailPage('guarantee', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				deleteGuaranteeById(this, id)
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
