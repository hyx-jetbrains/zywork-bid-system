<template>
	<view>
		<!-- 近一周的公示信息 -->
		<view class="zy-disable-flex zy-search-page-bar" style="background-color: #FFF;">
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun" />
				<input type="text" v-model="searchVal" :focus="true" placeholder="输入项目名称关键字搜索" @confirm="searchData" />
			</view>
			<view class="zy-disable-flex-right zy-search-page-cancel" @click="searchData">
				搜索
			</view>
		</view>
		<view class="zy-head-tip">
			注：只展示近一周的中标信息，如要查看更多信息及详情信息，请前往征信查询：
			<text @click="toCreditQueryPage">立即前往</text>
		</view>
		<view style="height: 10upx; background-color: #F8F8F8;"></view>

		<!-- 公示信息 -->
		<view>
			<view class="zy-disable-flex zy-achievement-type">
				<view class="zy-type-title zy-text-bold">选择项目类别</view>
				<view class="zy-disable-flex-right">
					<view class="uni-list-cell-db">
						<picker @change="onClickProjectTypeItem" :value="projectTypeIndex" :range="projectTypeArray">
							<view class="zy-disable-flex">
								<text>{{projectTypeArray[projectTypeIndex]}}</text>
								<zywork-icon type="iconxiangxia" />
							</view>
						</picker>
					</view>
				</view>
			</view>
			<view class="zy-page-list zy-page-card" v-if="projectAnnounceList.length > 0">
				<view class="zy-page-list-item" v-for="(item, index) in projectAnnounceList" :key="index">
					<view>
						<!-- 头部 -->
						<view class="zy-disable-flex">
							<zywork-icon type="iconzhongbiao" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
							<view>
								<text class="zy-text-bold" @click="validText(item.title)" :class="item.title === '请购买VIP服务' ? 'zy-detail-phone' : ''">{{item.title}}</text>
								<view class="zy-text-mini zy-text-info">
									<text class="zy-text-mini zy-text-info">
										{{item.projectType}}
									</text>
								</view>
							</view>
						</view>
						<!-- 内容部分 -->
						<view>
							<view class="zy-disable-flex">
								<view class="zy-text-info zy-text-bold zy-content-label">第一中标人:</view>
								<view v-if="item.firstCandidate !== ''" class="zy-text-info">
									{{item.firstCandidate}}
								</view>
								<view v-else class="zy-text-info">
									暂无
								</view>
							</view>
							<view class="zy-disable-flex">
								<view class="zy-text-info zy-text-bold zy-content-label">建造师:</view>
								<view v-if="item.firstBuilderName !== ''" class="zy-text-info">
									{{item.firstBuilderName}}
								</view>
								<view v-else class="zy-text-info">
									暂无
								</view>
							</view>
							<view class="zy-disable-flex">
								<view class="zy-text-info zy-text-bold zy-content-label">中标金额:</view>
								<view v-if="item.firstMarkMoney !== ''" class="zy-text-info">
									{{item.firstMarkMoney}}
								</view>
								<view v-else class="zy-text-info">
									暂无
								</view>
							</view>
						</view>
					</view>
				</view>
			</view>
			<zywork-no-data v-else text="暂无公示信息"></zywork-no-data>
		</view>


		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as projectInfo from '@/common/project-info.js'
	import {
		projectTypeArray
	} from '@/common/picker.data.js'
	import {
		showInfoToast,
		callPhone,
		validText,
		USER_FLAG,
		USER_FLAG_VIP,
		nullToStr,
		DOCUMENT_BASE_URL,
		CREDIT_QUERY_VIP,
		CREDIT_QUERY,
		isUserIdExist,
		notLoginToUserCenter,
		getDateStr
	} from '@/common/util.js'

	export default {
		components: {
			zyworkIcon,
			zyworkNoData
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				space: '&#12288;',
				pager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'createTime',
					sortOrder: 'desc',
					isActive: 0,
					createTimeMin: '',
					createTimeMax: '',
					projectType: '',
					title: ''
				},
				projectAnnounceList: [],
				projectTypeArray: projectTypeArray,
				projectTypeIndex: 0,
				searchVal: ''
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.initData('init');
		},
		onPullDownRefresh() {
			this.pager.pageNo = 1
			this.initData('pullDown');
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			this.initData('reachBottom');
		},
		methods: {
			/** 初始化数据 */
			initData(type) {
				if (type === 'init') {
					this.initPager();
				}
				projectInfo.getIndexProjectAnnounceList(this, type, this.pager);
			},
			/** 初始化查询条件 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
				// 查询近一周的数据
				var startDate = getDateStr(-7);
				var endDate = getDateStr(0);
				this.pager.createTimeMin = startDate + ' 0:0:0';
				this.pager.createTimeMax = endDate + ' 23:59:59';
			},
			/** 项目分类选择器 */
			onClickProjectTypeItem: function(e) {
				let index = e.target.value
				if (this.projectTypeIndex !== index) {
					this.projectTypeIndex = index
					if (index != 0) {
						this.pager.projectType = this.projectTypeArray[index];
					} else {
						this.pager.projectType = '';
					}
					this.initData('init');
				}
			},
			/** 搜索数据 */
			searchData() {
				this.pager.title = this.searchVal;
				this.initData('init');
			},
			/**
			 * 前往征信查询
			 */
			toCreditQueryPage() {
				uni.switchTab({
					url: '/pages/credit-query/credit-query'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-page-card {
		margin-top: 10upx;
	}

	.zy-content-label {
		margin-right: 20upx;
	}

	.zy-page-item-row view {
		width: 50%;
	}

	.zy-achievement-type {
		background-color: #FFF;
	}
	
	.zy-head-tip {
		color: red;
		padding: 20upx;
		background-color: #FFF;
	}
	.zy-head-tip text {
		color: #108EE9;	
	}
</style>
