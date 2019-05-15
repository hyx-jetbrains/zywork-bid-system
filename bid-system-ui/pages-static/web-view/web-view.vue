<template>
	<view>
		<web-view :src="url"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				url: ''
			}
		},
		onLoad(event) {
			// TODO 后面把参数名替换成 payload
			const payload = event.url || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.url = decodeURIComponent(payload);
			} catch (error) {
				this.url = payload;
			}
		},
		methods: {}
	}
</script>

<style lang="scss">
	@import '@/common/zywork-main.scss';
</style>
