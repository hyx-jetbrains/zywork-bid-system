<template>
	<view>
		<view class="zy-top-search">
			<view class="zy-search-bar" @click="toSearchPage">
				<zywork-icon type="iconchaxun"/>
				<input type="text" placeholder="我要搜索" disabled/>
			</view>
		</view>
		征信查询
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {

			}
		},
		onLoad() {},
		methods: {
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-credit-query/search-page/search-page'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';
</style>
