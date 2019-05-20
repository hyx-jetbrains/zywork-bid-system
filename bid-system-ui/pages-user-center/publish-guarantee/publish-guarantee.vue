<template>
	<view>
		<!-- 我发布的申请保函 -->
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<!-- 其他岗位招聘信息 -->
			<view class="zy-page-list" v-if="guaranteeList.length > 0">
				<view class="zy-page-list-item" v-for="(item, index) in guaranteeList" :key="index">
					<uni-swipe-action :options="options" @click="confirmOptions(item.guaranteeId)">
						<view @click="toGuaranteeDetailPage(item)">
							<view class="zy-disable-flex">
								<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
								<view>
									<view>
										<text class="zy-text-bold">{{item.userDetailNickname}}</text>
									</view>
									<view class="zy-text-mini zy-text-info"  style="color: #108EE9">
										{{item.guaranteeCreateTime}}
									</view>
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
							</view>
						</view>
					</uni-swipe-action>
				</view>
			</view>
			<zyworkNoData v-else text="暂无保函信息"></zyworkNoData>
		</view>
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
				options: [{
					text: '删除',
					style: {
						backgroundColor: 'rgb(255,58,49)'
					}
				}],
				guaranteeList: [],
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-'+name+'-detail/publish-'+name+'-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				});
			},
			/** 前往其他岗位招聘详情页面 */
			toGuaranteeDetailPage(item) {
				this.toDetailPage('guarantee', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				deleteGuaranteeById(this,id)
			},
			initData() {
				getGuaranteeByUserId(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
