<template>
	<view>
		<view class="zy-publish-result">
			<view class="zy-publish-result-icon">
				<zywork-icon type="iconchenggong" color="#108EE9" size="100" style="display: inline-block;"></zywork-icon>
			</view>
			<view class="zy-text-big zy-text-bold" style="color: #108EE9">发布成功</view>
			<view class="zy-disable-flex zy-text-info" @click="toMePublish" style="justify-content: center;">
				查看我发布的
				<zywork-icon type="iconshuangyoujiantou-" color="#8A8A8A" size="16" style="display: inline-block;"></zywork-icon>
			</view>
		</view>
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
		onLoad() {
			uni.hideShareMenu();
		},
		methods: {
			/** 前往我发布的页面 */
			toMePublish() {
				uni.redirectTo({
					url: '/pages-user-center/publish/publish'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-publish-result {
		text-align: center;
	}
	.zy-publish-result-icon {
		margin-top: 100upx; 
	}
</style>
