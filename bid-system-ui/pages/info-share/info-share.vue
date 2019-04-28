<template>
	<view>
		<view class="zy-top-search">
			<view class="zy-search-bar" @click="toSearchPage">
				<zywork-icon type="iconchaxun"/>
				<input type="text" placeholder="我要搜索" disabled/>
			</view>
		</view>
		<view class="uni-tab-bar zy-tab-bar">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
				<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
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
				infoType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [
						{id: 'builder', name: '建造师'},
						{id: 'aptitude', name: '资质转让'},
						{id: 'carPool', name: '开标拼车'},
						{id: 'material', name: '求带资料'},
						{id: 'hire', name: '岗位招聘'}
					]
				}
			}
		},
		onLoad() {},
		methods: {
			getElSize(id) {
				return new Promise((res, rej) => {
					uni.createSelectorQuery().select("#" + id).fields({
						size: true,
						scrollOffset: true
					}, (data) => {
						res(data);
					}).exec();
				})
			},
			async tapTab(e) {
				let tabIndex = e.target.dataset.current
				if (this.infoType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.infoType.scrollLeft = tabBarScrollLeft
					this.infoType.tabIndex = tabIndex
				}
			},
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-info-share/search-page/search-page'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';
</style>
