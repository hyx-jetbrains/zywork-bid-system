<template>
	<view>
		<!-- 我发布的申请保函 -->
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<!-- 其他岗位招聘信息 -->
			<view class="zy-page-list" v-if="guaranteeList.length > 0">
				<view class="zy-page-list-item" v-for="(item, index) in guaranteeList" :key="index">
					<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
						<view @click="toGuaranteeDetailPage(item)">
							<view class="zy-disable-flex">
								<image class="zy-page-mini-headicon" :src="item.headicon" />
								<view>
									<view>
										<text class="zy-text-bold">{{item.nickname}}</text>
									</view>
									<view class="zy-text-mini zy-text-info"  style="color: #108EE9">
										{{item.createTime}}
									</view>
								</view>
							</view>
							<view>
								<view class="zy-text-bold">
									{{item.projectName}}
								</view>
								<view class="zy-text-info zy-disable-flex">
									<view class="zy-text-bold">
										招标单位名称：
										<text class="zy-text-info">{{item.markUnitName}}</text>
									</view>
									<view class="zy-text-bold zy-disable-flex-right">
										工期(天)：
										<text class="zy-text-info">{{item.constructionPeriod}}</text>
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
				guaranteeList: [
					{
						id: 1,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						projectName: '某某项目',
						markUnitName: '某某公司',
						constructionPeriod: 20,
						openMarkTime: '2019-04-30 00:00:00',
						assurePrice: 10000,
						guaranteeComp: '赣州智悦网络科技有限公司',
						guaranteePrice: 20000,
						applicant: '危锦辉',
						name: '危锦辉',
						phone: '18279700225',
						address: '江西省赣州市章贡区xxx地址',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 2,
						nickname: '李某某',
						headicon: DEFAULT_HEADICON,
						projectName: '某某项目2',
						markUnitName: '某某公司2',
						constructionPeriod: 10,
						openMarkTime: '2019-04-30 00:00:00',
						assurePrice: 10000,
						guaranteeComp: '赣州智悦网络科技有限公司',
						guaranteePrice: 20000,
						applicant: '危锦辉',
						name: '危锦辉',
						phone: '18279700225',
						address: '江西省赣州市章贡区xxx地址',
						createTime: '2019-04-24 17:24:01'
					}
				],
			}
		},
		onLoad() {},
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
