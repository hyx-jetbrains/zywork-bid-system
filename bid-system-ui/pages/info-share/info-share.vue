<template>
	<view>
		<view class="zy-top-search">
			<view class="zy-search-bar">
				<i class="iconfont iconchaxun"></i>
				<input type="text" placeholder="我要搜索" @focus="searchFocus"/>
			</view>
		</view>
		信息共享
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {},
		methods: {
			searchFocus() {
				console.log('to search page')
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';
</style>
