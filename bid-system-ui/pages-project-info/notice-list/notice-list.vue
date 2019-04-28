<template>
	<view>
		<view v-if="notices.length > 0" class="zy-page-list">
			<view v-for="(notice, index) in notices" :key="index" class="zy-page-list-item" @click="toNoticeDetail">
				<view class="zy-text-big zy-text-bold">{{notice.title}}</view>
				<view class="zy-notice-summary zy-overflow-hidden">{{notice.summary}}</view>
				<view class="zy-text-small zy-text-info">{{notice.createTime}}</view>
			</view>
		</view>
		<zywork-no-data v-else text="暂无头条"></zywork-no-data>
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
						title: '头条标题',
						createTime: '2019-04-28 10:30:00'
					},
					{
						title: '头条标题',
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
</style>
