<template>
	<view>
		<view class="zy-top-search">
			<picker @change="chooseCity" :value="cityIndex" :range="cityArray">
				<view class="zy-address">
					<text>{{cityArray[cityIndex]}}</text>
					<zywork-icon type="iconxiangxia"/>
				</view>
			</picker>
			<view class="zy-search-bar" @click="toSearchPage">
				<zywork-icon type="iconchaxun"/>
				<input type="text" placeholder="我要搜索" disabled/>
			</view>
		</view>

		<view class="swiper">
			<swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
				<swiper-item v-for="(item, index) in swiperItems" :key="index">
					<view class="swiper-item" @click="showSwiperDetail(item.contentUrl)">
						<image :src="item.imgUrl" />
					</view>
				</swiper-item>
			</swiper>
		</view>

		<view v-if="latestNotice !== null" style="margin-top: 10upx;">
			<zywork-notice-bar @click="toNoticeDetail" @getmore="toNoticeList" :show-get-more="true" more-text="查看更多" show-icon="true" single="true" color="#108ee9" :text="latestNotice"></zywork-notice-bar>
		</view>

		<view class="uni-tab-bar zy-tab-bar">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="projectType.scrollLeft">
				<view v-for="(tab,index) in projectType.tabbars" :key="tab.id" class="swiper-tab-list" :class="projectType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
		</view>
		<view style="background-color: #FFFFFF; padding-bottom: 10upx;">
			<uni-segmented-control :current="projectStatus.current" :values="projectStatus.items" v-on:clickItem="onClickItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		
		<view class="zy-choose-date" v-if="showChooseDate" @click="openCalendar">选择开标日期：{{calendar.currentFormatDate}}</view>
		
		<view class="zy-project" v-if="projects.length > 0">
			<view class="zy-project-item" v-for="(project, index) in projects" :key="index" @click="toProjectDetail">
				<view class="zy-project-head">
					<image class="zy-icon" :src="imgIcon"/>
					<view>
						<view>
							<text>{{projectTypeName}}</text>
							<text style="margin-left: 30upx;">[{{project.city}}]</text>
						</view>
						<view class="zy-text-mini zy-text-info">公告时间：{{project.publishTime}}</view>
					</view>
					<view class="zy-project-head-right">
						<view>
							<uni-tag text="最新" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
							<uni-tag :text="project.status" type="primary" size="small" :inverted="true" :circle="true" style="margin-left: 10upx;"></uni-tag>
						</view>
						<view class="zy-text-mini zy-text-warning" v-if="project.time !== null">开标时间：{{project.time}}</view>
						<view class="zy-text-mini zy-text-warning" v-else>开标时间：暂无</view>
					</view>
				</view>
				<view>
					<view class="zy-text-big zy-text-bold">{{project.title}}</view>
					<view class="zy-text-info"><text class="zy-text-info zy-text-bold">招标单位：</text>{{project.title}}</view>
					<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.title}}</view>
					<view class="zy-text-info"><text class="zy-text-info zy-text-bold">建造师等级：</text>{{project.title}}</view>
					<view class="zy-project-item-row">
						<view class="zy-text-info"><text class="zy-text-info zy-text-bold">审查方式：</text>{{project.checkWay}}</view>
						<view class="zy-text-info"><text class="zy-text-info zy-text-bold">项目投资：</text>{{project.money}}</view>
					</view>
				</view>
			</view>
		</view>
		
		<zywork-no-data v-else text="暂无招标信息"></zywork-no-data>
		
		<view v-if="calendar.showCalendar" class="calendar-mask" @click="closeMask">
			<view class="calendar-box" @click.stop="">
				<zywork-calendar :slide="calendar.slide" :disableBefore="calendar.disableBefore" :start-date="calendar.startDate" :date="calendar.date" @change="change" @to-click="toClick" />
				<view class="calendar-button-groups">
					<button type="primary" class="calendar-button-confirm" @click="closeMask">取消</button>
					<button type="primary" class="calendar-button-confirm" @click="confirm">确认</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoticeBar from '@/components/zywork-notice-bar/zywork-notice-bar.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkCalendar from '@/components/zywork-calendar/zywork-calendar.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		IMAGE_BASE_URL,
		DEFAULT_HEADICON,
		isUserTokenExist,
		toLoginPage,
		getCalendarDate,
		formatCalendarDate
	} from '../../common/util.js'
	
	const PROJECT_STATUS_ALL = 0
	const PROJECT_STATUS_SHOWING = 1
	const PROJECT_STATUS_WAITTING = 2
	const PROJECT_STATUS_ALREADY = 3
	
	const PROJECT_TYPE_BUILDING = 0
	const PROJECT_TYPE_HYDRAULIC = 1
	const PROJECT_TYPE_TRAFFIC = 2
	const PROJECT_TYPE_PURCHASE = 3
	const PROJECT_TYPE_IMPORTANT = 4
	const PROJECT_TYPE_OTHER = 5
	
	const PROJECT_TYPE_ICONS = ['../../static/icon/building.png',
								'../../static/icon/hydraulic.png',
								'../../static/icon/traffic.png',
								'../../static/icon/purchase.png',
								'../../static/icon/important.png',
								'../../static/icon/other.png']

	export default {
		components: {
			zyworkIcon,
			zyworkNoticeBar,
			uniSegmentedControl,
			zyworkCalendar,
			uniTag,
			zyworkNoData
		},
		data() {
			return {
				indicatorDots: true,
				autoplay: true,
				interval: 5000,
				duration: 500,
				swiperItems: [
					{
						imgUrl: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556111133770&di=7b878fecade084667a237bbb4985f0aa&imgtype=0&src=http%3A%2F%2Ff.zhulong.com%2Fv1%2Ftfs%2FT1zAx_BQhT1RCvBVdK.jpg",
						contentUrl: "http://39.108.116.103:8080/"
					},
					{
						imgUrl: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556111253594&di=5344d9889d61ccc8279bd26a7765e4b3&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180106%2F4042bb85604c4609a1c7da9e45edb2b4.jpeg",
						contentUrl: "http://39.108.116.103:8080/"
					}
				],
				cityArray: ['全省', '南昌', '赣州', '萍乡', '吉安', '上饶', '新余', '抚州', '九江', '鹰潭', '宜春', '景德镇'],
				cityIndex: 0,
				latestNotice: '头条标题',
				projectStatus: {
					current: 0,
					items: ['全部', '公告中', '待开标', '已开标']
				},
				projectType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [
						{id: 'building', name: '房建市政'},
						{id: 'hydraulic', name: '水利工程'},
						{id: 'traffic', name: '交通工程'},
						{id: 'purchase', name: '政府采购'},
						{id: 'important', name: '重点项目'},
						{id: 'other', name: '其他项目'}
					]
				},
				showChooseDate: false,
				calendar: {
					showCalendar: false,
					slide: 'horizontal',
					disableBefore: false,
					startDate: '',
					date: '',
					timeData: null,
					currentFormatDate: ''
				},
				imgIcon: PROJECT_TYPE_ICONS[0],
				projectTypeName: '房建市政',
				projects: [
					{
						title: '赣州中学工程招标',
						city: '南昌市',
						publishTime: '2019-04-24 18:00:00',
						status: '公告中',
						time: null,
						checkWay: '资格后审',
						money: 3000
					},
					{
						title: '赣州中学工程招标',
						city: '南昌市',
						publishTime: '2019-04-24 18:00:00',
						status: '待开标',
						time: '2019-04-25 10:30',
						checkWay: '资格后审',
						money: 3000
					}
				],
				pager: {
					pageNo: 1,
					pageSize: 10
				},
				imgBaseUrl: IMAGE_BASE_URL,
				headicon: DEFAULT_HEADICON
			}
		},
		onLoad() {
			this.calendar.currentFormatDate = formatCalendarDate(new Date())
		},
		onPullDownRefresh() {},
		methods: {
			chooseCity(e) {
				this.cityIndex = e.target.value
			},
			showSwiperDetail(contentUrl) {
				console.log(contentUrl)
			},
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
				if (this.projectType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.projectType.scrollLeft = tabBarScrollLeft
					this.projectType.tabIndex = tabIndex
					
					this.imgIcon = PROJECT_TYPE_ICONS[tabIndex]
				}
			},
			onClickItem(index) {
				if (this.current !== index) {
					this.current = index
					if (index === PROJECT_STATUS_WAITTING) {
						this.showChooseDate = true
					} else {
						this.showChooseDate = false
					}
				}
			},
			openCalendar() {
				this.calendar.startDate = getCalendarDate(new Date())
				this.calendar.date = this.calendar.date === '' ? getCalendarDate(new Date()) : this.calendar.date
				this.calendar.showCalendar = true
			},
			change(e) {
				this.calendar.timeData = e;
			},
			toClick(e) {
				this.calendar.timeData = e;
			},
			closeMask() {
				this.calendar.showCalendar = false;
			},
			confirm() {
				this.calendar.date = this.calendar.timeData.fulldate
				this.calendar.currentFormatDate = this.calendar.timeData.fulldate + ' ' + this.calendar.timeData.lunar.ncWeek
				this.calendar.showCalendar = false;
			},
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-project-info/search-page/search-page'
				})
			},
			toNoticeList() {
				uni.navigateTo({
					url: '/pages-project-info/notice-list/notice-list'
				})
			},
			toNoticeDetail() {
				uni.navigateTo({
					url: '/pages-project-info/notice-detail/notice-detail'
				})
			},
			toProjectDetail() {
				uni.navigateTo({
					url: '/pages-project-info/project-detail/project-detail'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';

	.zy-address {
		display: flex;
		flex-direction: row;
		align-items: center;
		margin-right: 10upx;
	}

	.swiper {
		width: 100%;
		height: 200upx;
	}

	.swiper-item {
		display: block;
		height: 200upx;
		line-height: 200px;
		text-align: center;
	}
	
	.swiper-item image {
		width: 100%;
	}
	
	.zy-tab-bar {
		background-color: $primary-backcolor;
	}
	
	.uni-tab-bar .active {
		color: $primary-color;
		font-weight: bold;
	}
	
	.uni-swiper-tab {
		border-bottom: none;
	}
	
	.segmented-control view {
		font-size: 24upx;
		line-height: 50upx;
	}
	
	.zy-choose-date {
		width:100%;
		background-color: $primary-backcolor;
		text-align: center;
	}
	
	.calendar-mask {
		position: fixed;
		/* #ifdef H5 */
		top: 45px;
		/* #endif */
		/* #ifndef H5 */
		top: 0;
		/* #endif */
		bottom: 0;
		display: flex;
		align-items: center;
		width: 100%;
		background: rgba(0, 0, 0, 0.4);
		z-index: 100;
	}
	
	.calendar-box {
		border: 1px #f5f5f5 solid;
		width: 100%;
		height: 100%;
		overflow: hidden;
		background: $primary-backcolor;
	}
	
	.calendar-button-groups {
		width: 100%;
		margin-top: 50upx;
		display: flex;
		flex-direction: row;
	}
	
	.calendar-button-confirm {
		width: 50%;
		margin: 10upx;
	}
	
	.uni-calender__date.uni-calender__disable view {
		color: #d4d4d4;
	}
	
	.uni-calender__date.uni-calender__is-day view {
		color: #fd2e32;
	}
	
	.zy-project {
		margin-top: 10upx;
		padding-left: 15upx;
		padding-right: 15upx;
		background-color: $primary-backcolor;
	}
	
	.zy-project-item {
		width: 100%;
		padding-top: 20upx;
		padding-bottom: 20upx;
		border-bottom: 1upx solid $seperator-color;
	}
	
	.zy-project-item:last-child {
		border-bottom: none;
	}
	
	.zy-project-head {
		display: flex;
		flex-direction: row;
		align-items: center;
	}
	
	.zy-project-head .zy-icon {
		width: 60upx;
		height: 60upx;
		margin-right: 15upx;
	}
	
	.zy-project-head-right {
		flex-grow: 1;
		justify-content: flex-end;
		text-align: right;
	}
	
	.zy-project-item-row {
		display: flex;
		flex-direction: row;
		align-items: center;
	}
	
	.zy-project-item-row view {
		width: 50%;
	}
</style>
