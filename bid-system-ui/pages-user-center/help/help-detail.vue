<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{question.title}}
			</view>
			<view class="zy-disable-flex">
				<view class="zy-detail-card-type">{{question.type}}</view>
				<view class="zy-text-info zy-disable-flex-right" v-text="question.createTime"></view>
			</view>
			<view v-html="question.content"></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				question: {
					id: '1',
					type: 'CA证书',
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
</style>
