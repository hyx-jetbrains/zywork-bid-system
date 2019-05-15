<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{message.title}}
			</view>
			<view class="zy-content">{{message.content}}</view>
			<view class="zy-text-info zy-disable-flex-right zy-create-time" v-text="message.createTime"></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				message: {
					id: 1,
					title: 'zywork-app体验版发布',
					content: 'zywork-app体验版于2019-01-22晚上10点45分正式发布，邀请您使用！',
					createTime: '2019-04-28 10:34:04'
				}
			}
		},
		onLoad() {},
		methods: {
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-create-time {
		text-align: right; 
		margin-top: 30upx;
	}
	.zy-content {
		text-indent: 2em;
	}
	
	
</style>
