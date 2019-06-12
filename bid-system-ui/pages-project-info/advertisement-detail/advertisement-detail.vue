<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{item.title}}
			</view>
			<image :src="item.url" style="width: 100%;"></image>
			<view v-html="item.content"></view>
			<view class="zy-text-info zy-detail-card-time" v-text="item.createTime"></view>
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
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			uni.setNavigationBarTitle({
				title: this.item.title
			});
		},
		methods: {
			
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
