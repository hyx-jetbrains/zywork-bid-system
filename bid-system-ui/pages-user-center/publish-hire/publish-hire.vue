<template>
	<view>
		<!-- 我发布的其他岗位的招聘信息 -->
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<!-- 其他岗位招聘信息 -->
			<view class="zy-page-list" v-if="recruitList.length > 0">
				<view class="zy-page-list-item" v-for="(item, index) in recruitList" :key="index">
					<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
						<view @click="toRecruitDetailPage(item)">
							<view class="zy-disable-flex">
								<image class="zy-page-mini-headicon" :src="item.headicon" />
								<view>
									<view class="zy-disable-flex">
										<text class="zy-text-bold" style="margin-right: 20upx;">{{item.nickname}}</text>
										<zywork-icon v-if="item.gender === 0" type="iconyincang" color="#BFBFBF" size="20" />
										<zywork-icon v-else-if="item.gender === 1" type="iconnan" color="#108EE9" size="20" />
										<zywork-icon v-else-if="item.gender === 2" type="iconnv" color="#dd524d" size="20" />
									</view>
								</view>
								<view class="zy-disable-flex-right">
									{{item.recruitStatus}}
								</view>
							</view>
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-bold">
										招聘岗位：
										<text class="zy-text-info">{{item.jobTitle}}</text>
									</view>
									<view class="zy-disable-flex-right">
										{{item.isFulltime === 0 ? '全职' : '兼职'}}
										：
										¥{{item.salary}}/月
									</view>
								</view>
								<view class="zy-text-info zy-disable-flex">
									<view class="zy-text-bold">
										工作经验：
										<text class="zy-text-info">{{item.workYear}}年</text>
									</view>
									<view class="zy-text-bold zy-disable-flex-right">
										学历：
										<text class="zy-text-info">{{item.education}}</text>
									</view>
								</view>
							</view>
						</view>
					</uni-swipe-action>
				</view>
			</view>
			<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
		</view>
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	export default {
		components: {
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
				recruitList: [
					{
						id: 1,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						gender: 1,
						recruitStatus: '招聘中',
						isFulltime: 1,
						salary: '5-10万元',
						jobTitle: '建造师',
						workYear: 1,
						education: '大专',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 2,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						gender: 2,
						recruitStatus: '招聘中',
						isFulltime: 0,
						salary: '一万元以下',
						jobTitle: '建造师',
						workYear: 2,
						education: '大专',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 3,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						gender: 0,
						recruitStatus: '已停止',
						isFulltime: 0,
						salary: '一万元以下',
						jobTitle: '建造师',
						workYear: 2,
						education: '大专',
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
			toRecruitDetailPage(item) {
				this.toDetailPage('recruit', item);
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
