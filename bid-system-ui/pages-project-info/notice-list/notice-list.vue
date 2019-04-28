<template>
	<view>
		<view v-if="notices.length > 0" class="zy-notice-list">
			<view v-for="(notice, index) in notices" :key="index" class="zy-notice-item" @click="toNoticeDetail">
				<view class="zy-text-big zy-text-bold">{{notice.title}}</view>
				<view class="zy-notice-summary zy-overflow-hidden">{{notice.summary}}</view>
				<view class="zy-text-small zy-text-info">{{notice.createTime}}</view>
			</view>
		</view>
		<zywork-no-data v-else text="暂无公告"></zywork-no-data>
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	export default {
		components: {
			zyworkNoData
		},
		data() {
			return {
				notices: [
					{
						title: '公告标题',
						summary: '公告摘要',
						createTime: '2019-04-28 10:30:00'
					},
					{
						title: '公告标题',
						summary: '公告摘要',
						createTime: '2019-04-28 10:30:00'
					}
				]
			}
		},
		onLoad() {},
		methods: {
			toNoticeDetail() {
				uni.navigateTo({
					url: '/pages-project-info/notice-detail/notice-detail'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-notice-list {
		padding-left: 15upx;
		padding-right: 15upx;
		background-color: $primary-backcolor;
	}
	
	.zy-notice-item {
		width: 100%;
		padding-top: 20upx;
		padding-bottom: 20upx;
		border-bottom: 1upx solid $seperator-color;
	}
	
	.zy-notice-item:last-child {
		border-bottom: none;
	}
	
	.zy-notice-summary {
		max-height: 200upx;
	}
</style>
