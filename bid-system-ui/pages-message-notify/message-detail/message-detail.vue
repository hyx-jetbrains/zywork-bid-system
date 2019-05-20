<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{item.messageTitle}}
			</view>
			<view class="zy-content">{{item.messageContent}}</view>
			<view class="zy-text-info zy-disable-flex-right zy-create-time" v-text="item.userMessageCreateTime"></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				item: {}
			}
		},
		onLoad(event) {
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			uni.setNavigationBarTitle({
				title: this.item.messageTitle
			});
		},
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
