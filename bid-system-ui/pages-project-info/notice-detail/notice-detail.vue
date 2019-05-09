<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-help-detail-card-title zy-text-bold zy-text-big">
				{{notice.title}}
			</view>
			<view v-html="notice.content"></view>
			<view class="zy-text-info zy-detail-card-time" v-text="notice.createTime"></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				notice: {
					title: '头条标题头条标题头条标题头条标题头条标题头条标题',
					content: '<h2>H2标签</h2><p>p标签</p>',
					createTime: '2019-04-28 10:30:00'
				}
			}
		},
		onLoad() {},
		methods: {}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
