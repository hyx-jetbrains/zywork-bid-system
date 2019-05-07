<template>
	<view>
		<view class="uni-tab-bar zy-tab-bar" style="margin-bottom: 20upx;">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="questionType.scrollLeft">
				<view v-for="(tab,index) in questionType.tabbars" :key="tab.id" class="swiper-tab-list" :class="questionType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
		</view>
		<uni-list>
			<zywork-list-item v-for="(oftenQuestion, index) in oftenQuestionList" :key="index" 
				:title="oftenQuestion.title" show-extra-icon="true" 
				:extra-icon="{color: '#FF4539',size: '18',type: 'iconbangzhu'}"
				@click="toOftenQuestionDetail(oftenQuestion.id)"></zywork-list-item>
		</uni-list>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	export default {
		components: {
			uniSegmentedControl,
			zyworkIcon,
			uniList,
			zyworkListItem
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
						title: 'CA证书问题dfsdfdsfs淡粉色的适当方式分'
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
</style>
