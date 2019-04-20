<template>
	<view class="zy-tab-bar">
		<view v-for="(item, index) in tabBarList" :key="index" class="zy-tab-bar-item" @click="selectTab(index)">
			<image v-if="currentTab === index" :src="item.selectImg" />
			<image v-else :src="item.unselectImg"/>
			<text :class="[currentTab === index ? 'zy-select' : '']">{{item.text}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			tabBarList: Array
		},
		data() {
			return {
				currentTab: 0
			}
		},
		mounted() {
			
		},
		methods: {
			selectTab(index) {
				this.currentTab = index
				this.$emit('changeTab', index)
			}
		}
	}
</script>

<style lang="scss">
	@import '../common/zywork-main.scss';
	.zy-tab-bar {
		height: 120upx;
		width: 100%;
		display: flex;
	    flex-direction: row;
		justify-content: space-between;
		align-items: center;
		align-content: center;
		background-color: $tabbar-backcolor;
		position: fixed;
		bottom: 0upx;
		left: 0upx;
		border-top: 1px solid #E9E9E9;
	}
	
	.zy-tab-bar .zy-tab-bar-item {
		height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-grow: 1;
		flex-direction: column;
	}
	
	.zy-tab-bar-item image {
		width: 50upx;
		height: 50upx;
		margin-top: 10upx;
	}
	
	.zy-tab-bar-item text {
		color: $tabbar-text;
	}
	
	.zy-tab-bar-item .zy-select {
		color: $tabbar-select-text;
	}
</style>
