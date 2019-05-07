<template>
	<view>
		<uni-card :title="question.title" :extra="question.type">
			<view v-html="question.content"></view>
			<view class="zy-text-info zy-time" v-text="question.createTime"></view>
		</uni-card>
	</view>
</template>

<script>
	import uniCard from "@/components/uni-card/uni-card.vue"
	export default {
		components: {
			uniCard
		},
		data() {
			return {
				question: {
					id: '1',
					type: 'CA证书',
					title: 'CA证书问题dfsdfdsfs淡粉色的适当方式分',
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
	
	.zy-time {
		text-align: right;
		margin: 20upx 20upx;
	}
</style>
