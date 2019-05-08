<template>
	<view>
		<view class="zy-help-detail-card">
			<view class="zy-help-detail-card-title zy-text-bold zy-text-big">
				{{question.title}}
			</view>
			<view v-html="question.content"></view>
			<view class="zy-text-info zy-time" v-text="question.createTime"></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				question: {
					id: '1',
					title: 'CA证书问题长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试',
					content: '<h2>内容</h2><p>内容内容内让</p>',
					createTime: '2019-04-28 10:34:04'
				}
			}
		},
		onLoad() {},
		methods: {}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-help-detail-card {
		background-color: #FFFFFF;
		margin: 20upx;
		padding: 20upx;
	}
	.zy-help-detail-card-title {
		text-align: center;
		padding-bottom: 20upx;
	}
	
	.zy-time {
		text-align: right;
		margin: 20upx 20upx;
	}
</style>
