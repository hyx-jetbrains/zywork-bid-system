<template>
	<view>
		<view class="uni-tab-bar zy-tab-bar" style="margin-bottom: 20upx;">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="questionType.scrollLeft">
				<view v-for="(tab,index) in questionType.tabbars" :key="tab.id" class="swiper-tab-list" :class="questionType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
		</view>
		<view class="zy-disable-flex zy-help-list" v-for="(oftenQuestion, index) in oftenQuestionList" 
				:key="index" @click="toOftenQuestionDetail(oftenQuestion.id)">
			<zywork-icon type="iconbangzhu" color="#dd524d" size="24" style="display: inline-block;" />
			<view class="zy-help-list-title">
				{{oftenQuestion.title}}
			</view>
			<zywork-icon class="zy-help-list-right-icon" type="iconiconfonti" color="#8A8A8A" size="20" style="display: inline-block;" />
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	export default {
		components: {
			uniSegmentedControl,
			zyworkIcon
		},
		data() {
			return {
				questionType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [
						{id: 'certificate', name: 'CA证书'},
						{id: 'registrationLogin', name: '注册登入'},
						{id: 'tendering', name: '招标'},
						{id: 'bid', name: '投标'},
						{id: 'openingOfTender', name: '开标'},
						{id: 'architectsAndPerformance', name: '建造师及业绩'}
					]
				},
				oftenQuestionList: [
					{
						id: '1',
						type: '',
						title: 'CA证书问题长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试'
					},
					{
						id: '2',
						type: '',
						title: 'CA证书问题1'
					}
				]
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
			// 监听导航菜单事件
			async tapTab(e) {
				let tabIndex = e.target.dataset.current
				if (this.questionType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.questionType.scrollLeft = tabBarScrollLeft
					this.questionType.tabIndex = tabIndex
				}
			},
			// 前往问题详情页面
			toOftenQuestionDetail(id) {
				uni.navigateTo({
					url: '/pages-user-center/help/help-detail'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-help-list {
		background-color: #FFFFFF;
		padding: 20upx;
		// position: relative;
		border-bottom: 2upx solid $border-color;
	}
	.zy-help-list-title {
		padding: 20upx;
		width: 800upx;
	}
	.zy-help-list-right-icon {
		text-align: right;
		// position: absolute;
		// top: 20upx;
		// right: 20upx;
	}
</style>
