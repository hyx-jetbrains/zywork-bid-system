<template>
	<view>
		<web-view :src="item.url"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				item: {
					title: '详情页面',
					url: ''
				}
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
			console.log(this.item);
			uni.setNavigationBarTitle({
				title: this.item.title
			});
		},
		methods: {}
	}
</script>

<style lang="scss">
	@import '@/common/zywork-main.scss';
</style>
