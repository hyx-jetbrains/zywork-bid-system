<template>
	<view>
		<view v-if="!calendar.showCalendar">
			<view class="zy-top-search">
				<picker @change="chooseCity" :value="cityIndex" :range="cityArray">
					<view class="zy-address">
						<text>{{cityArray[cityIndex]}}</text>
						<zywork-icon type="iconxiangxia" />
					</view>
				</picker>
				<view class="zy-search-bar" @click="toSearchPage">
					<zywork-icon type="iconchaxun" />
					<input type="text" placeholder="我要搜索" disabled />
				</view>
			</view>

			<!-- 轮播图 -->
			<view class="swiper">
				<swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
					<swiper-item v-for="(item, index) in swiperItems" :key="index">
						<view class="swiper-item" @click="showSwiperDetail(item)">
							<image :src="item.url" />
						</view>
					</swiper-item>
				</swiper>
			</view>

			<!-- 把头条换成了公示 -->
			<!-- 
			<view v-if="latestNotice !== null" style="margin-top: 10upx;">
				<zywork-notice-bar @click="toNoticeDetail(latestNotice)" @getmore="toNoticeList" :show-get-more="true" more-text="更多头条"
				 show-icon="true" single="true" color="#108ee9" :text="latestNotice.title"></zywork-notice-bar>
			</view> 
			 -->
			<!-- 公示信息 -->
			<view class="zy-disable-flex zy-swiper-msg">
				<view class="uni-swiper-msg">
					<view class="uni-swiper-msg-icon zy-swiper-msg-icon">
						<uni-icon type="sound" size="12" color="#108EE9"></uni-icon>
					</view>
					<swiper vertical="true" autoplay="true" circular="true" interval="4000">
						<swiper-item v-for="(item, index) in projectAnnounceList" :key="index">
							<text>{{item.firstCandidate}}</text>
						</swiper-item>
					</swiper>
				</view>
				<view class="zy-disable-flex-right zy-disable-flex" style="width: 200upx;" @click="toProjectAnnounce">
					<text style="color: #108EE9;">更多公示</text>
					<zywork-icon type="iconiconfonti" size="16" color="#108EE9"></zywork-icon>
				</view>
			</view>

			<!-- 项目类型切换 -->
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="projectType.scrollLeft">
					<view v-for="(tab,index) in projectType.tabbars" :key="tab.id" class="swiper-tab-list" :class="projectType.tabIndex==index ? 'active' : ''"
					 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
				</scroll-view>
			</view>
			<view style="background-color: #FFFFFF; padding-bottom: 10upx;">
				<uni-segmented-control :current="projectStatus.current" :values="projectStatus.items" v-on:clickItem="onClickItem"
				 styleType="button" activeColor="#108EE9"></uni-segmented-control>
			</view>

			<view class="zy-choose-date zy-disable-flex" v-if="showChooseDate">
				<text style="margin-left:25%; color: red;" @click="openCalendar">
					开标日期：{{calendar.currentFormatDate}}
				</text>
				<text style="color: #108EE9;" class="zy-disable-flex-right" @click="resetCalendar">重置</text>
			</view>

			<view class="zy-page-list zy-project" v-if="projects.length > 0">
				<view class="zy-page-list-item zy-position-relative" v-for="(project, index) in projects" :key="index">
					<!-- <zywork-icon class="zy-project-sheet-icon" type="iconxiangxia" size="30" @tap="actionSheetTap(project.project.id)" /> -->
					<view @click="toProjectDetail(project)">
						<view class="zy-disable-flex">
							<image class="zy-project-icon" :src="imgIcon" />
							<view>
								<view>
									<text>{{project.project.projectType}}</text>
									<text style="margin-left: 30upx;">[{{project.project.city}}]</text>
								</view>
								<view class="zy-text-mini zy-text-info">
									公告时间：
									<text v-if="project.project.noticeTime !== ''" class="zy-text-mini zy-text-info">
										{{project.project.noticeTime.split(' ')[0]}}
									</text>
									<text v-else class="zy-text-mini zy-text-info">
										暂无
									</text>
								</view>
							</view>
							<view class="zy-project-head-right">
								<!-- <view style="padding-right: 50upx;"> -->
								<view>
									<uni-tag text="最新" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
									<uni-tag :text="project.project.markStatus" type="primary" size="small" :inverted="true" :circle="true" style="margin-left: 10upx;"></uni-tag>
								</view>
								<view class="zy-text-mini zy-text-warning" v-if="project.project.openMarkTime !== ''">
									开标日期：{{project.project.openMarkTime}}
								</view>
								<view class="zy-text-mini zy-text-warning" v-else>开标日期：暂无</view>
							</view>
						</view>

						<!-- 全部内容部分 -->
						<view v-if="projectStatus.current === 0">
							<!-- 公告中内容部分 -->
							<view v-if="project.project.markStatus === '公告中'">
								<view class="zy-text-big zy-text-bold">{{project.project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">招标单位：</text>{{project.project.markUnitName}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.project.compAptitudeType}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">建造师等级：</text>{{project.project.builderLevel}}</view>
								<view class="zy-project-item-row">
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">审查方式：</text>{{project.project.checkPattern}}</view>
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">项目投资：</text>{{project.project.projectInvest}}</view>
								</view>
							</view>
							<!-- 待开标内容部分 -->
							<view v-else-if="project.project.markStatus === '待开标'">
								<view class="zy-text-big zy-text-bold">{{project.project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.project.compAptitudeType}}</view>
								<view class="zy-project-item-row">
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">保证金(万元)：</text>{{project.project.assurePrice}}</view>
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">要约价(元)：</text>{{project.project.offerPrice}}</view>
								</view>
								<view class="zy-project-item-row">
									<view class="zy-text-info">
										<text class="zy-text-info zy-text-bold">工期(天)：</text>
										{{project.project.constructionPeriod}}
									</view>
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">开标地点：</text>{{project.project.openMarkAddr}}</view>
								</view>
								<!-- <view class="zy-text-info"><text class="zy-text-info zy-text-bold">其他要求：</text>{{project.project.otherDemand}}</view> -->
							</view>
							<!-- 已开标内容部分 -->
							<view v-else-if="project.project.markStatus === '已开标'">
								<view class="zy-text-big zy-text-bold">{{project.project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">中标单位：</text>{{project.project.inMarkComp}}</view>
							</view>
						</view>
						<!-- 公告中内容部分 -->
						<view v-else-if="projectStatus.current === 1">
							<view class="zy-text-big zy-text-bold">{{project.project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">招标单位：</text>{{project.project.markUnitName}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.project.compAptitudeType}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">建造师等级：</text>{{project.project.builderLevel}}</view>
							<view class="zy-project-item-row">
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">审查方式：</text>{{project.project.checkPattern}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">项目投资：</text>{{project.project.projectInvest}}</view>
							</view>
						</view>
						<!-- 待开标内容部分 -->
						<view v-else-if="projectStatus.current === 2">
							<view class="zy-text-big zy-text-bold">{{project.project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.project.compAptitudeType}}</view>
							<view class="zy-project-item-row">
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">保证金(万元)：</text>{{project.project.assurePrice}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">要约价(元)：</text>{{project.project.offerPrice}}</view>
							</view>
							<view class="zy-project-item-row">
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">工期(天)：</text>{{project.project.constructionPeriod}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">开标地点：</text>{{project.project.openMarkAddr}}</view>
							</view>
							<!-- <view class="zy-text-info"><text class="zy-text-info zy-text-bold">其他要求：</text>{{project.project.otherDemand}}</view> -->
						</view>
						<!-- 已开标内容部分 -->
						<view v-else-if="projectStatus.current === 3">
							<view class="zy-text-big zy-text-bold">{{project.project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">中标单位：</text>{{project.project.inMarkComp}}</view>
						</view>
					</view>
					<view v-for="(item, index_2) in project.obj" :key="index_2">
						<view v-if="item.type == 5" @tap='getResourceFile(project.project.id, item.type)' class="zy-text-bold" style="color:#E80080;">进赣报名信息</view>
					</view>
					<view class="zy-disable-flex" style="padding-right: 10px;margin-top: 10px;">
						<view>
							<uni-tag v-if="project.project.isGuarantee === 1" text="保函" @click="toGuaranteePage(project.project)" type="error"
							 size="normal" :inverted="false" :circle="true" style="margin-left: 20upx;"></uni-tag>
						</view>
						<view class="zy-disable-flex-right zy-disable-flex">
							<view v-for="(item, index_1) in project.obj" :key="index_1">
								<uni-tag v-if="item.type == 0" text="资" @click='getResourceFile(project.project.id, item.type)' type="error"
								 size="normal" :inverted="false" :circle="true" style="margin-left: 20upx;"></uni-tag>
								<uni-tag v-if="item.type == 1" text="招" @click='getResourceFile(project.project.id, item.type)' type="primary"
								 size="normal" :inverted="false" :circle="true" style="margin-left: 20upx;"></uni-tag>
								<uni-tag v-if="item.type == 2" text="清" @click='getResourceFile(project.project.id, item.type)' type="warning"
								 size="normal" :inverted="false" :circle="true" style="margin-left: 20upx;"></uni-tag>
								<uni-tag v-if="item.type == 3" text="控" @click='getResourceFile(project.project.id, item.type)' type="primary"
								 size="normal" :inverted="false" :circle="true" style="margin-left: 20upx;"></uni-tag>
								<uni-tag v-if="item.type == 4" text="澄" @click='getResourceFile(project.project.id, item.type)' type="success"
								 size="normal" :inverted="false" :circle="true" style="margin-left: 20upx;"></uni-tag>
							</view>
						</view>
					</view>
				</view>
			</view>
			<zywork-no-data v-else text="暂无招标信息"></zywork-no-data>

			<uni-popup :show="isShowFileList" position="middle" mode="fixed" @hidePopup="isShowFileList = false">
				<scroll-view :scroll-y="true" class="uni-center center-box">
					<view v-for="(item, index) in fileList" :key="index" class="uni-list-item" @click="openDocument(item.resourceUrl)">
						<view style="color: #108EE9;">
							{{index+1}}.{{ item.fileName }}
						</view>
					</view>
				</scroll-view>
			</uni-popup>

			<zywork-fab v-if="customerShow" :pattern="pattern" :horizontal="horizontal" :vertical="vertical" :direction="direction"
			 :showContent="customerPopup" :iconType="iconType" @trigger="trigger"></zywork-fab>
			<uni-popup :show="customerPopup" position="bottom" @hidePopup="trigger(false)">
				<view class="zy-popup-bottom-title">选择联系类型</view>
				<view class="zy-popup-bottom-content">
					<button @click="callPhone" style="background-color: #FFF;" @tap="trigger(false)">
						<zywork-icon type="icondianhua" size="26" color="#77e663"></zywork-icon>
						<view class="zy-popup-bottom-content-text">电话咨询</view>
					</button>
					<button open-type="contact" style="background-color: #FFF;" @tap="trigger(false)">
						<zywork-icon type="iconweixin" size="26" color="#5bb674"></zywork-icon>
						<view class="zy-popup-bottom-content-text">微信咨询</view>
					</button>
				</view>
				<view class="zy-popup-bottom-btn" @click="trigger(false)">取消选择</view>
			</uni-popup>
			<button open-type="contact" class="zy-hide-button" ref="contactBtn"></button>

			<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
		</view>
		<view v-if="calendar.showCalendar" class="calendar-mask" @click="closeMask">
			<view class="calendar-box" @click.stop="">
				<view class="zy-date-tag" style="margin: 30upx 0;">
					<uni-tag text="本周" type="default" size="normal" :inverted="true" :circle="true" @click="dateSearch(1)"></uni-tag>
					<uni-tag text="下周" type="default" size="normal" :inverted="true" :circle="true" @click="dateSearch(2)"></uni-tag>
					<uni-tag text="本月" type="default" size="normal" :inverted="true" :circle="true" @click="dateSearch(3)"></uni-tag>
					<uni-tag text="下月" type="default" size="normal" :inverted="true" :circle="true" @click="dateSearch(4)"></uni-tag>
				</view>
				<zywork-calendar :slide="calendar.slide" :disableBefore="calendar.disableBefore" :start-date="calendar.startDate"
				 :date="calendar.date" @change="change" @to-click="toClick" />
				<view class="calendar-button-groups">
					<button type="primary" size="mini" class="calendar-button-confirm" @click="closeMask">取消</button>
					<button type="primary" size="mini" class="calendar-button-confirm" @click="confirm">确认</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import uniIcon from '@/components/uni-icon/uni-icon.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoticeBar from '@/components/zywork-notice-bar/zywork-notice-bar.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkCalendar from '@/components/zywork-calendar/zywork-calendar.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniPopup from '@/components/uni-popup/uni-popup.vue'
	import zyworkFab from '@/components/zywork-fab/zywork-fab.vue'
	import {
		IMAGE_BASE_URL,
		DEFAULT_HEADICON,
		isUserTokenExist,
		toLoginPage,
		getCalendarDate,
		formatCalendarDate,
		DOCUMENT_BASE_URL,
		SHARE_CODE_PAGE_IMG,
		getShareCode,
		SHARE_CODE,
		getResourceByProjectId,
		callPhone,
		CUSTOMER_CONFIG,
		getCurrentDate,
		showInfoToast,
		getAppointWeekDate,
		showMonthFirstOrLastDay,
		showNextMonthFirstOrLastDay,
		getDateStr,
		SHARE_TITLE
	} from '@/common/util.js'
	import {
		projectStatusArray,
		jxCityArray,
		fileTypeArray
	} from '@/common/picker.data.js'
	import * as projectInfo from '@/common/project-info.js'

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
		'../../static/icon/other.png'
	]

	/** 资审文件标识-0 */
	const SEE_FILE_TYPE_ZIZHI = 0
	/** 招标文件标识-1 */
	const SEE_FILE_TYPE_ZHAOBIAO = 1
	/** 清单文件标识-2 */
	const SEE_FILE_TYPE_QINGDAN = 2
	/** 控股价文件标识-3 */
	const SEE_FILE_TYPE_KONGGUJIA = 3
	/** 澄清答疑文件标识-4 */
	const SEE_FILE_TYPE_CHENGQING = 4
	/** 收藏或取消收藏-5 */
	const SEE_FILE_TYPE_SC_QXSC = 5

	export default {
		components: {
			uniIcon,
			zyworkIcon,
			zyworkNoticeBar,
			uniSegmentedControl,
			zyworkCalendar,
			uniTag,
			zyworkNoData,
			uniPopup,
			zyworkFab
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				space: '&#12288;',
				indicatorDots: true,
				autoplay: true,
				interval: 5000,
				duration: 500,
				swiperItems: [],
				cityArray: jxCityArray,
				cityIndex: 0,
				latestNotice: {},
				noticePager: {
					pageNo: 1,
					pageSize: 1,
					sortColumn: 'createTime',
					sortOrder: 'desc',
					isActive: 0,
				},
				projectAnnounceList: [],
				projectAnnouncePager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'createTime',
					sortOrder: 'desc',
					isActive: 0,
					createTimeMin: '',
					createTimeMax: ''
				},
				projectStatus: {
					current: 0,
					items: projectStatusArray
				},
				projectType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [{
							id: 'building',
							name: '房建市政'
						},
						{
							id: 'hydraulic',
							name: '水利工程'
						},
						{
							id: 'traffic',
							name: '交通工程'
						},
						{
							id: 'purchase',
							name: '政府采购'
						},
						{
							id: 'important',
							name: '重点工程'
						},
						{
							id: 'other',
							name: '其他项目'
						}
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
					// currentFormatDate: formatCalendarDate(new Date())
					currentFormatDate: '请选择日期'
				},
				imgIcon: PROJECT_TYPE_ICONS[0],
				projects: [],
				projectPager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'noticeTime',
					sortOrder: 'desc',
					projectType: '房建市政',
					markStatus: '',
					isActive: 0,
					releaseStatus: '已发布',
					city: '',
					openMarkTimeMin: null,
					openMarkTimeMax: null
				},
				imgBaseUrl: IMAGE_BASE_URL,
				headicon: DEFAULT_HEADICON,
				isCollection: false,
				actionSheetArray: fileTypeArray,
				isShowFileList: false,
				fileList: [],
				directionStr: '垂直',
				horizontal: 'right',
				vertical: 'bottom',
				direction: 'horizontal',
				iconType: 'uni-icon-weixin',
				pattern: {
					color: '#7A7E83',
					backgroundColor: '#fff',
					selectedColor: '#007AFF',
					buttonColor: '#007AFF'
				},
				customerPopup: false,
				customerShow: false,
				customer: ''
			}
		},
		onLoad(options) {
			this.projectPager.pageNo = 1
			this.initData()
			if (options.shareCode != undefined) {
				uni.setStorage({
					key: SHARE_CODE,
					data: options.shareCode
				});
			}
			if (options.tabIndex) {
				this.projectType.tabIndex = options.tabIndex;
			}
			if (options.statusIndex) {
				this.projectStatus.current = options.statusIndex;
			}
		},
		onPullDownRefresh() {
			if (!this.calendar.showCalendar) {
				this.projectPager.pageNo = 1
				this.updateProjectList('pullDown');
				this.initHeadInfo();
			}
		},
		onReachBottom() {
			this.showLoadMore = true
			this.projectPager.pageNo += 1
			this.updateProjectList('reachBottom');
		},
		onShareAppMessage(res) {
			var shareCode = getShareCode();
			return {
				title: SHARE_TITLE,
				path: '/pages/project-info/project-info?shareCode=' + shareCode,
				imageUrl: SHARE_CODE_PAGE_IMG
			}
		},
		methods: {
			/** 初始化数据 */
			initData() {
				this.initHeadInfo();
				this.updateProjectList('init');
				this.initCustomerFab();
			},
			/** 初始化中标公示的查询条件 */
			initProjectAnnouncePager() {
				// 查询近一周的数据
				var startDate = getDateStr(-7);
				var endDate = getDateStr(0);
				this.projectAnnouncePager.createTimeMin = startDate + ' 0:0:0';
				this.projectAnnouncePager.createTimeMax = endDate + ' 23:59:59';
			},
			/** 初始化头部的轮播图和头条 */
			initHeadInfo() {
				projectInfo.getAdvertisementInfo(this);
				// 暂时不用公告了，换成公示
				// projectInfo.getFirstHeadlinesInfo(this, this.noticePager);
				this.initProjectAnnouncePager();
				projectInfo.getIndexProjectAnnounceTop(this, 10);
			},
			/** 初始化客服悬浮 */
			initCustomerFab() {
				var customer = uni.getStorageSync(CUSTOMER_CONFIG);
				if (null == customer) {
					return;
				}
				this.customer = customer;
				if (customer.isShow === 'true') {
					this.customerShow = true;
				} else {
					this.customerShow = false;
				}
			},
			/** 初始化查询数据 */
			initPager() {
				this.projectPager.pageNo = 1;
				this.showLoadMore = false;
			},
			/** 更新项目列表 */
			updateProjectList(type) {
				projectInfo.getProjectList(this, type, this.projectPager);
			},
			/** 选择城市 */
			chooseCity(e) {
				var index = e.target.value
				this.cityIndex = index
				if (index == 0) {
					this.projectPager.city = '';
				} else {
					this.projectPager.city = this.cityArray[index]
				}
				this.initPager();
				this.updateProjectList('init');
			},
			/** 查看广告详情 */
			showSwiperDetail(item) {
				uni.navigateTo({
					url: '/pages-project-info/advertisement-detail/advertisement-detail?itemData=' + encodeURIComponent(JSON.stringify(
						item.id))
				})
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
					this.projectPager.projectType = this.projectType.tabbars[tabIndex].name
					this.initPager();
					this.updateProjectList('init');
				}
			},
			onClickItem(index) {
				if (this.projectStatus.current !== index) {
					this.projectStatus.current = index
					if (index === PROJECT_STATUS_ALL) {
						this.projectPager.markStatus = '';
					} else {
						this.projectPager.markStatus = this.projectStatus.items[index]
					}
					this.initPager();
					if (index === PROJECT_STATUS_WAITTING) {
						this.showChooseDate = true
						this.projectPager.sortColumn = 'openMarkTime';
						this.projectPager.sortOrder = 'asc';
					} else {
						this.projectPager.sortColumn = 'noticeTime';
						this.projectPager.sortOrder = 'desc';
						this.showChooseDate = false
						this.projectPager.openMarkTimeMin = null
						this.projectPager.openMarkTimeMax = null
					}
					this.updateProjectList('init');
				}
			},
			openCalendar() {
				this.calendar.startDate = getCalendarDate(new Date())
				this.calendar.date = this.calendar.date === '' ? getCalendarDate(new Date()) : this.calendar.date
				this.calendar.showCalendar = true
			},
			resetCalendar() {
				this.calendar.currentFormatDate = '请选择日期'
				this.initPager();
				this.projectPager.openMarkTimeMin = null
				this.projectPager.openMarkTimeMax = null
				this.updateProjectList('init');
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
				this.initPager()
				this.projectPager.openMarkTimeMin = this.calendar.date + ' 0:0:0'
				this.projectPager.openMarkTimeMax = this.calendar.date + ' 23:59:59'
				this.updateProjectList('init');
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
			toNoticeDetail(item) {
				uni.navigateTo({
					url: '/pages-project-info/notice-detail/notice-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			toProjectDetail(item) {
				item.project.clickCount += 1;
				projectInfo.projectClickCount(this, item.project);
				uni.navigateTo({
					url: '/pages-project-info/project-detail/project-detail?itemData=' + encodeURIComponent(item.project.id)
				})
			},
			toProjectAnnounce() {
				uni.navigateTo({
					url: '/pages-project-info/project-announce/project-announce'
				})
			},
			getResourceFile(projectId, type) {
				projectInfo.getResourceByProjectIdAndType(this, projectId, type);
			},
			// 触发操作选项
			actionSheetTap(projectId) {
				projectInfo.getProjectCollectionInfo(this, projectId);
			},
			// 查看文件
			seeFile(type, projectId) {
				if (SEE_FILE_TYPE_SC_QXSC === type) {
					const tempType = this.actionSheetArray[SEE_FILE_TYPE_SC_QXSC];
					if (tempType == '取消收藏') {
						projectInfo.cancelProjectCollection(this, projectId);
					} else if (tempType == '收藏项目') {
						projectInfo.saveProjectCollection(this, projectId);
					}
				} else {
					// 其他几个选项，查看文件
					projectInfo.getResourceByProjectIdAndType(this, projectId, type);
				}
			},
			/** 打开文档 */
			openDocument(url) {
				if (this.isShowFileList) {
					this.isShowFileList = false;
				}
				uni.showLoading({
					title: '加载中...'
				})
				uni.downloadFile({
					url: DOCUMENT_BASE_URL + "/" + url,
					success: (res) => {
						uni.openDocument({
							filePath: res.tempFilePath,
							success: () => {
								console.log('打开文档成功');
							},
							complete: () => {
								uni.hideLoading()
							}
						});
					}
				});
			},
			/** 获取到是否收藏后的操作 */
			collectionOperation(projectId) {
				if (this.isCollection) {
					this.actionSheetArray[SEE_FILE_TYPE_SC_QXSC] = "取消收藏";
				} else {
					this.actionSheetArray[SEE_FILE_TYPE_SC_QXSC] = "收藏项目";
				}
				if (0 !== projectId) {
					uni.showActionSheet({
						title: '标题',
						itemList: this.actionSheetArray,
						success: (e) => {
							this.seeFile(e.tapIndex, projectId);
							// uni.showToast({
							// 	title:"点击了第" + e.tapIndex + "个选项",
							// 	icon:"none"
							// })
						}
					})
				}
			},
			/** 悬浮按钮事件监听 */
			trigger(e) {
				this.customerPopup = e;
			},
			/** 拨打电话 */
			callPhone() {
				callPhone(this.customer.phone)
			},
			/** 日期搜索，根据选择的时间搜索数据 */
			dateSearch(type) {
				this.calendar.currentFormatDate = '请选择日期';
				var startTime = null;
				var endTime = null;
				if (1 === type) {
					// 本周
					startTime = getAppointWeekDate(0);
					endTime = getAppointWeekDate(-6);
				} else if (2 === type) {
					// 下周
					startTime = getAppointWeekDate(-7);
					endTime = getAppointWeekDate(-13);
				} else if (3 === type) {
					// 本月
					startTime = showMonthFirstOrLastDay(0);
					endTime = showMonthFirstOrLastDay(1);
				} else if (4 === type) {
					// 下月
					startTime = showNextMonthFirstOrLastDay(0);
					endTime = showNextMonthFirstOrLastDay(1);
				} else {
					showInfoToast("类型错误");
					return;
				}
				this.projectPager.openMarkTimeMin = startTime + ' 0:0:0';
				this.projectPager.openMarkTimeMax = endTime + ' 23:59:59';
				this.calendar.showCalendar = false;
				this.updateProjectList('init');
			},
			/**
			 * 前往申请保函的页面
			 */
			toGuaranteePage(project) {
				var item = {};
				item.projectId = project.id;
				item.projectName = project.title;
				item.openMarkTime = project.openMarkTime;
				item.markUnitName = project.inMarkComp;
				item.constructionPeriod = project.constructionPeriod;
				item.assurePrice = project.assurePrice;
				item.applicant = '';
				item.name = '';
				item.address = '';
				item.bank = '';
				item.bankResId = '';
				item.bankResSrc = '';
				item.applicantResId = '';
				item.applicantResSrc = '';
				uni.navigateTo({
					url: '/pages-info-share/publish-guarantee/publish-guarantee?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

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
		height: 100%;
	}

	.segmented-control view {
		font-size: 24upx;
		line-height: 50upx;
	}

	.zy-choose-date {
		width: 100%;
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

	.zy-project-sheet-icon {
		margin-left: 20upx;
		position: absolute;
		top: -2upx;
		right: -10upx;
	}

	.zy-date-tag {
		text-align: center;
	}

	.zy-date-tag uni-tag {
		margin-left: 40upx;
	}

	button::after {
		border: 0;
	}

	.zy-swiper-msg {
		background-color: #FFFFFF;
		margin-bottom: 10upx;

		.zy-swiper-msg-icon {
			margin-left: 30upx;
		}
	}
</style>
