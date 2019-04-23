<template>
	<view>
		<view class="zy-top-search">
			<picker @change="chooseCity" :value="cityIndex" :range="cityArray">
				<view class="zy-address">
					<text>{{cityArray[cityIndex]}}</text>
					<zywork-icon type="iconxiangxia"/>
				</view>
			</picker>
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun"/>
				<input type="text" placeholder="我要搜索" @focus="searchFocus" />
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
			<uni-notice-bar @getmore="toNoticeList" :show-get-more="true" more-text="查看更多" show-icon="true" single="true" :text="latestNotice"></uni-notice-bar>
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
		
		<view class="zy-project-item">
			
		</view>
		<view class="zy-project-item">
			
		</view>
		
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
	import uniNoticeBar from '@/components/uni-notice-bar/uni-notice-bar.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkCalendar from '@/components/zywork-calendar/zywork-calendar.vue'
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

	export default {
		components: {
			zyworkIcon,
			uniNoticeBar,
			uniSegmentedControl,
			zyworkCalendar
		},
		data() {
			return {
				indicatorDots: true,
				autoplay: true,
				interval: 5000,
				duration: 500,
				swiperItems: [{
						imgUrl: "https://img-cdn-qiniu.dcloud.net.cn/uniapp/doc/img/ad.png",
						contentUrl: "http://39.108.116.103:8080/"
					},
					{
						imgUrl: "http://img.cdn.aliyun.dcloud.net.cn/ask/img/ke.qq.com.uniapp@2x.png",
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
				projects: [],
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
			searchFocus() {
				console.log('to search page')
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
				let tabIndex = e.target.dataset.current;
// 				if (this.newsitems[tabIndex].data.length === 0) {
// 					this.addData(tabIndex)
// 				}
				if (this.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.projectType.scrollLeft = tabBarScrollLeft
					this.projectType.tabIndex = tabIndex
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
		height: 300upx;
	}

	.swiper-item {
		display: block;
		height: 300upx;
		line-height: 300px;
		text-align: center;
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
	
	.zy-project-item {
		width: 100%;
		margin-top: 10upx;
		background-color: $primary-backcolor;
		height: 200upx;
	}
</style>
