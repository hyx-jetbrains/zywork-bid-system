<template>
	<view>
		<view class="zy-top-search">
			<view class="zy-search-bar" @click="toSearchPage">
				<zywork-icon type="iconchaxun"/>
				<input type="text" placeholder="我要搜索" disabled/>
			</view>
			<view style="margin-left: 10upx;">
				<zywork-icon type="icontianjia" color="#dd524d" size="28" class="zy-icon" @click.native="toPublishChoose"/>
			</view>
		</view>
		<view class="uni-tab-bar zy-tab-bar">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
				<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
		</view>
		
		<view class="zy-page-list">
			<!-- 建造师 -->
			<view v-if="infoType.tabIndex === 0">
				<uni-segmented-control :current="builderOpts.current" :values="builderOpts.items" v-on:clickItem="onClickBuilderItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
				<view class="zy-page-list-item">建造师1</view>
			</view>
			
			<!-- 资质转让 -->
			<view v-if="infoType.tabIndex === 1">
				<uni-segmented-control :current="aptitudeOpts.current" :values="aptitudeOpts.items" v-on:clickItem="onClickAptitudeItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
				<view class="zy-page-list-item">转让1</view>
			</view>
			
			<!-- 开标拼车 -->
			<view v-if="infoType.tabIndex === 2">
				<uni-segmented-control :current="carPoolOpts.current" :values="carPoolOpts.items" v-on:clickItem="onClickCarPoolItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
				<view class="zy-page-list-item">拼车</view>
			</view>
			
			<!-- 岗位招聘 -->
			<view v-if="infoType.tabIndex === 3">
				<uni-segmented-control :current="hireOpts.current" :values="hireOpts.items" v-on:clickItem="onClickHireItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
				<view class="zy-page-list-item">招聘</view>
			</view>
			
			<!-- 求带资料 -->
			<view v-if="infoType.tabIndex === 4">
				<view class="zy-page-list-item">带资料</view>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	
	const INFO_BUILDER = 0
	const INFO_APTITUDE = 1
	const INFO_CARPOOL = 2
	const INFO_HIRE = 3
	const INFO_MATERIAL = 4
	
	export default {
		components: {
			zyworkIcon,
			uniSegmentedControl
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
						{id: 'hire', name: '岗位招聘'},
						{id: 'material', name: '求带资料'}
					]
				},
				builderOpts: {
					current: 0,
					items: ['招聘', '应聘']
				},
				aptitudeOpts: {
					current: 0,
					items: ['转让', '求购']
				},
				carPoolOpts: {
					current: 0,
					items: ['我是车主', '我要找车']
				},
				hireOpts: {
					current: 0,
					items: ['职位', '人才']
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
			},
			toPublishChoose() {
				uni.navigateTo({
					url: '/pages-info-share/publish-choose/publish-choose'
				})
			},
			onClickBuilderItem(index) {
				if (this.builderOpts.current !== index) {
					this.builderOpts.current = index
				}
			},
			onClickAptitudeItem(index) {
				if (this.aptitudeOpts.current !== index) {
					this.aptitudeOpts.current = index
				}
			},
			onClickCarPoolItem(index) {
				if (this.carPoolOpts.current !== index) {
					this.carPoolOpts.current = index
				}
			},
			onClickHireItem(index) {
				if (this.hireOpts.current !== index) {
					this.hireOpts.current = index
				}
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-icon view {
		line-height: 1.0;
	}
</style>
