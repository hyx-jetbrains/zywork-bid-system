<template>
	<view>
		<view class="zy-disable-flex">
			<view class="zy-type-title zy-text-bold">选择问题类别</view>
			<view class="zy-disable-flex-right">
				<view class="uni-list-cell-db">
					<picker @change="chooseType" :value="questionTypeIndex" :range="questionTypeArray">
						<view class="zy-disable-flex">
							<text>{{questionTypeArray[questionTypeIndex]}}</text>
							<zywork-icon type="iconxiangxia" />
						</view>
					</picker>
				</view>
			</view>

		</view>
		<view v-if="oftenQuestionList.length > 0">
			<view class="zy-disable-flex zy-help-list" v-for="(oftenQuestion, index) in oftenQuestionList" :key="index" @click="toOftenQuestionDetail(oftenQuestion)">
				<zywork-icon type="iconbangzhu" color="#dd524d" size="24" style="display: inline-block;" />
				<view class="zy-help-list-title">
					{{oftenQuestion.title}}
				</view>
				<zywork-icon class="zy-help-list-right-icon" type="iconiconfonti" color="#8A8A8A" size="20" style="display: inline-block;" />
			</view>
		</view>
		<zyworkNoData v-else text="暂无问题数据"></zyworkNoData>
		
		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		getOftenQuerstion,
		getQuesTionType
	} from '@/common/user-center.js'

	export default {
		components: {
			zyworkIcon,
			zyworkNoData
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				pager: {
					pageNo: 1,
					pageSize: 10,
					questionTypeId: null
				},
				expertTypeList: [],
				questionTypeArray: [],
				questionTypeIndex: 0,
				oftenQuestionList: []
			}
		},
		onLoad() {
			this.initData()
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			getOftenQuerstion(this, this.pager, 'reachBottom');
		},
		methods: {
			// 初始化问题类型
			initQuestionType() {
				// 请求后台，获取到所有的类型
				getQuesTionType(this)
			},
			/** 初始化查询参数 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			// 监听类别选择
			chooseType: function(e) {
				let index = e.target.value
				let id = null
				this.questionTypeIndex = index
				// 等于0表示取全部数据
				if (index != 0) {
					id = this.expertTypeList[index - 1].id

				}
				this.initPager()
				this.pager.questionTypeId = id;
				getOftenQuerstion(this, this.pager, 'init');
			},
			// 前往问题详情页面
			toOftenQuestionDetail(item) {
				uni.navigateTo({
					url: '/pages-user-center/help/help-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			initData() {
				getOftenQuerstion(this, this.pager, 'init');
				this.initQuestionType();
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-help-list {
		background-color: #FFFFFF;
		padding: 20upx;
		// position: relative;
		border-bottom: 2upx solid $border-color;
	}

	.zy-help-list-title {
		padding: 20upx;
		width: 800upx;
	}

	.zy-help-list-right-icon {
		text-align: right;
		// position: absolute;
		// top: 20upx;
		// right: 20upx;
	}
</style>
