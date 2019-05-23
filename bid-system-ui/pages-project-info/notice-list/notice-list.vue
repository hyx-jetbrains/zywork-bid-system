<template>
	<view>
		<view v-if="notices.length > 0" class="zy-page-list" style="padding-top: 10upx;">
			<view v-for="(notice, index) in notices" :key="index" class="zy-page-list-item zy-disable-flex" @click="toNoticeDetail(notice)">
				<view>
					<view class="zy-text-big zy-text-bold zy-notice-title zy-overflow-hidden">{{notice.title}}</view>
					<view class="zy-text-small zy-text-info">{{notice.createTime}}</view>
				</view>
				<view class="zy-disable-flex-right">
					<uni-tag text="查看" type="error" size="small" :inverted="true" :circle="true" @click="toNoticeDetail(notice)"></uni-tag>
				</view>
			</view>
		</view>
		<zywork-no-data v-else text="暂无头条"></zywork-no-data>
		
		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {getHeadlinesList} from '@/common/project-info.js'
	export default {
		components: {
			zyworkNoData,
			uniTag
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				notices: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'createTime',
					sortOrder: 'desc'
				},
			}
		},
		onLoad() {
			this.initData();
		},
		onPullDownRefresh() {
			this.pager.pageNo = 1
			getHeadlinesList(this, 'pullDown', this.pager);
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			getHeadlinesList(this, 'reachBottom', this.pager);
		},
		methods: {
			/** 初始化数据 */
			initData() {
				getHeadlinesList(this, 'init', this.pager);
			},
			/** 前往公告详情 */
			toNoticeDetail(item) {
				uni.navigateTo({
					url: '/pages-project-info/notice-detail/notice-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				});
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-notice-title {
		width: 600upx;
	}
</style>
