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
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	export default {
		components: {
			zyworkNoData,
			uniTag
		},
		data() {
			return {
				notices: [
					{
						title: '头条标题长标题长标题长标题长标题长标题长标题长标题长标题长标题长标题长标题',
						content: '内容内容内容内容内容',
						createTime: '2019-04-28 10:30:00'
					},
					{
						title: '头条标题',
						content: '内容内容内容内容内容',
						createTime: '2019-04-28 10:30:00'
					}
				]
			}
		},
		onLoad() {},
		methods: {
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
