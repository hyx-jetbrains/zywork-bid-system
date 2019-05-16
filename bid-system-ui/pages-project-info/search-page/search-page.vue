<template>
	<view>
		<view class="zy-disable-flex zy-search-page-bar">
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun" />
				<input type="text" v-model="searchVal" placeholder="输入关键字搜索" @confirm="searchData" />
			</view>
			<view class="zy-disable-flex-right zy-search-page-cancel" @click="toBackPage">
				取消
			</view>
		</view>
		<view v-if="isShowHistroy" class="zy-search-page-history-record">
			<view class="zy-disable-flex">
				<view class="zy-type-title zy-text-bold">历史搜索</view>
				<view class="zy-disable-flex-right">
					<zywork-icon type="iconlajitong" size="22" @tap="oldDelete" />
				</view>
			</view>

			<view class="zy-history-record zy-disable-flex">
				<view v-for="(oldKey, index) in oldKeywordList" @click="doSearch(oldKey)" :key="index">{{oldKey}}</view>
			</view>
		</view>
		<view v-else>
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x>
					<view v-for="(tab,index) in projectType.tabbars" :key="tab.id" class="swiper-tab-list" :class="projectType.tabIndex==index ? 'active' : ''"
					 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
				</scroll-view>
			</view>
			<view style="background-color: #FFFFFF; padding-bottom: 10upx;">
				<uni-segmented-control :current="projectStatus.current" :values="projectStatus.items" v-on:clickItem="onClickItem"
				 styleType="button" activeColor="#108EE9"></uni-segmented-control>
			</view>

			<view class="zy-choose-date" v-if="showChooseDate" @click="openCalendar">选择开标日期：{{calendar.currentFormatDate}}</view>

			<view style="height: 10upx; background-color: #F8F8F8;"></view>
			<view class="zy-page-list zy-project" v-if="projects.length > 0">
				<view class="zy-page-list-item zy-position-relative" v-for="(project, index) in projects" :key="index">
					<zywork-icon class="zy-project-sheet-icon" type="iconxiangxia" size="30" @tap="actionSheetTap" />
					<view @click="toProjectDetail(project)">
						<view class="zy-disable-flex">
							<image class="zy-project-icon" :src="imgIcon" />
							<view>
								<view>
									<text>{{projectTypeName}}</text>
									<text style="margin-left: 30upx;">[{{project.city}}]</text>
								</view>
								<view class="zy-text-mini zy-text-info">公告时间：{{project.noticeTime}}</view>
							</view>
							<view class="zy-project-head-right">
								<view style="padding-right: 50upx;">
									<uni-tag text="最新" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
									<uni-tag :text="project.markStatus" type="primary" size="small" :inverted="true" :circle="true" style="margin-left: 10upx;"></uni-tag>
								</view>
								<view v-html="space"></view>
							</view>
						</view>

						<!-- 全部内容部分 -->
						<view v-if="projectStatus.current === 0">
							<!-- 公告中内容部分 -->
							<view v-if="project.markStatus === '公告中'">
								<view class="zy-text-big zy-text-bold">{{project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">招标单位：</text>{{project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">建造师等级：</text>{{project.title}}</view>
								<view class="zy-project-item-row">
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">审查方式：</text>{{project.checkPattern}}</view>
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">项目投资：</text>{{project.projectInvest}}</view>
								</view>
							</view>
							<!-- 待开标内容部分 -->
							<view v-else-if="project.markStatus === '待开标'">
								<view class="zy-text-big zy-text-bold">{{project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.title}}</view>
								<view class="zy-project-item-row">
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">保证金(万元)：</text>{{project.assurePrice / 100}}</view>
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">要约价(元)：</text>{{project.offerPrice / 100}}</view>
								</view>
								<view class="zy-project-item-row">
									<view class="zy-text-info">
										<text class="zy-text-info zy-text-bold">工期(天)：</text>
										{{project.constructionPeriod}}
									</view>
									<view class="zy-text-info"><text class="zy-text-info zy-text-bold">开标地点：</text>{{project.openMarkAddr}}</view>
								</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">其他要求：</text>{{project.otherDemand}}</view>
							</view>
							<!-- 已开标内容部分 -->
							<view v-else-if="project.markStatus === '已开标'">
								<view class="zy-text-big zy-text-bold">{{project.title}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">中标单位：</text>{{project.inMarkComp}}</view>
							</view>
						</view>
						<!-- 公告中内容部分 -->
						<view v-else-if="projectStatus.current === 1">
							<view class="zy-text-big zy-text-bold">{{project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">招标单位：</text>{{project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">建造师等级：</text>{{project.title}}</view>
							<view class="zy-project-item-row">
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">审查方式：</text>{{project.checkPattern}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">项目投资：</text>{{project.projectInvest}}</view>
							</view>
						</view>
						<!-- 待开标内容部分 -->
						<view v-else-if="projectStatus.current === 2">
							<view class="zy-text-big zy-text-bold">{{project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">企业资质：</text>{{project.title}}</view>
							<view class="zy-project-item-row">
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">保证金(万元)：</text>{{project.assurePrice / 100}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">要约价(元)：</text>{{project.offerPrice / 100}}</view>
							</view>
							<view class="zy-project-item-row">
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">工期(天)：</text>{{project.constructionPeriod}}</view>
								<view class="zy-text-info"><text class="zy-text-info zy-text-bold">开标地点：</text>{{project.openMarkAddr}}</view>
							</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">其他要求：</text>{{project.otherDemand}}</view>
						</view>
						<!-- 已开标内容部分 -->
						<view v-else-if="projectStatus.current === 3">
							<view class="zy-text-big zy-text-bold">{{project.title}}</view>
							<view class="zy-text-info"><text class="zy-text-info zy-text-bold">中标单位：</text>{{project.inMarkComp}}</view>
						</view>
					</view>
				</view>
			</view>
			<zywork-no-data v-else text="暂无招标信息"></zywork-no-data>

			<view v-if="calendar.showCalendar" class="calendar-mask" @click="closeMask">
				<view class="calendar-box" @click.stop="">
					<zywork-calendar :slide="calendar.slide" :disableBefore="calendar.disableBefore" :start-date="calendar.startDate"
					 :date="calendar.date" @change="change" @to-click="toClick" />
					<view class="calendar-button-groups">
						<button type="primary" class="calendar-button-confirm" @click="closeMask">取消</button>
						<button type="primary" class="calendar-button-confirm" @click="confirm">确认</button>
					</view>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkCalendar from '@/components/zywork-calendar/zywork-calendar.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'

	import {
		IMAGE_BASE_URL,
		DEFAULT_HEADICON,
		isUserTokenExist,
		toLoginPage,
		getCalendarDate,
		formatCalendarDate
	} from '@/common/util.js'
	import {
		projectStatusArray,
		jxCityArray
	} from '@/common/picker.data.js'

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

	/** 澄清文件标识-0 */
	const SEE_FILE_TYPE_CHENGQING = 0
	/** 招标文件标识-1 */
	const SEE_FILE_TYPE_ZHAOBIAO = 1
	/** 清单文件标识-2 */
	const SEE_FILE_TYPE_QINGDAN = 2
	/** 资质文件标识-3 */
	const SEE_FILE_TYPE_ZIZHI = 3
	/** 取消收藏-4 */
	const COLLECTION_PROJECT = 4
	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
			uniSegmentedControl,
			zyworkCalendar,
			uniTag
		},
		data() {
			return {
				searchVal: '',
				oldKeywordList: [],
				isShowHistroy: true,
				projectStatus: {
					current: 0,
					items: projectStatusArray
				},
				projectType: {
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
							name: '重点项目'
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
					currentFormatDate: formatCalendarDate(new Date())
				},
				imgIcon: PROJECT_TYPE_ICONS[0],
				projectTypeName: '房建市政',
				projects: [{
						id: 1,
						title: '[南昌市本级]南昌市昌南城市防洪工程管理处防汛排涝信息系统建设工程项目监理招标公告',
						projectType: '房建市政',
						city: '南昌市',
						projectDetail: null,
						releaseStatus: null,
						markUnitName: '宜春市实验小学',
						projectInvest: '约2400万元',
						checkPattern: '资格后审',
						compAptitudeType: '建筑工程总承包二级（含）以上资质',
						builderLevel: '建筑工程二级及以上（含临时）',
						moneyToImplement: 100,
						tenderingAgent: '江西锐创企业管理咨询有限公司',
						phone: '13766445188',
						offerPrice: 210000,
						assurePrice: 4000,
						constructionPeriod: 30,
						downloadEndTime: '2019-04-22 17:31:33',
						otherDemand: '八大员：基本户保函；计划竣工日期现变更为2020年05约14日；“信用中国”网站的查询系统中查询企业及建造师行贿犯罪档案查询结果截图；本次招标不解释联合体投标；',
						openMarkInfo: null,
						openMarkTime: '2019-04-22 17:31',
						openMarkAddr: '信誉是第一开标室',
						inMarkPublicity: null,
						inMarkComp: '某某公司',
						noticeTime: '2019-04-22 17:31:33',
						markStatus: '待开标',
						clickCount: null,
						isElectronic: null,
						sourceUrl: null,
						version: null,
						createTime: null,
						updateTime: null,
						isActive: null,
						inwordHtmlUrl: 'http://www.baidu.com/'
					},
					{
						id: 2,
						title: '[南昌市本级]南昌市昌南城市防洪工程管理处防汛排涝信息系统建设工程项目监理招标公告',
						projectType: '房建市政',
						city: '南昌市',
						projectDetail: null,
						releaseStatus: null,
						markUnitName: '宜春市实验小学',
						projectInvest: '约2400万元',
						checkPattern: '资格后审',
						compAptitudeType: '建筑工程总承包二级（含）以上资质',
						builderLevel: '建筑工程二级及以上（含临时）',
						moneyToImplement: 100,
						tenderingAgent: '江西锐创企业管理咨询有限公司',
						phone: '13766445188',
						offerPrice: 210000,
						assurePrice: 4000,
						constructionPeriod: 30,
						downloadEndTime: '2019-04-22 17:31:33',
						otherDemand: '八大员：基本户保函；计划竣工日期现变更为2020年05约14日；“信用中国”网站的查询系统中查询企业及建造师行贿犯罪档案查询结果截图；本次招标不解释联合体投标；',
						openMarkInfo: null,
						openMarkTime: '2019-04-22 17:31',
						openMarkAddr: '信誉是第一开标室',
						inMarkPublicity: null,
						inMarkComp: '某某公司',
						noticeTime: '2019-04-22 17:31:33',
						markStatus: '公告中',
						clickCount: null,
						isElectronic: null,
						sourceUrl: null,
						version: null,
						createTime: null,
						updateTime: null,
						isActive: null,
						inwordHtmlUrl: 'http://www.baidu.com/'
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
			this.initData();
		},
		methods: {
			/** 初始化数据 */
			initData() {
				// 加载历史搜索数据
				this.loadOldKeyword();
			},
			/** 返回上个页面 */
			toBackPage() {
				uni.navigateBack({
					delta: 1
				})
			},
			/** 点击历史搜索执行搜索 */
			doSearch(key) {
				this.searchVal = key;
				this.searchData();
			},
			/** 搜索数据 */
			searchData() {
				console.log(this.searchVal)
				uni.showToast({
					title: this.searchVal
				})
				this.isShowHistroy = false;
				this.saveKeyword(this.searchVal)
			},
			/** 保存关键字到历史记录 */
			saveKeyword(keyword) {
				uni.getStorage({
					key: 'ProjectOldKeys',
					success: (res) => {
						var OldKeys = JSON.parse(res.data);
						var findIndex = OldKeys.indexOf(keyword);
						if (findIndex == -1) {
							OldKeys.unshift(keyword);
						} else {
							OldKeys.splice(findIndex, 1);
							OldKeys.unshift(keyword);
						}
						//最多10个纪录
						OldKeys.length > 10 && OldKeys.pop();
						uni.setStorage({
							key: 'ProjectOldKeys',
							data: JSON.stringify(OldKeys)
						});
						this.oldKeywordList = OldKeys; //更新历史搜索
					},
					fail: (e) => {
						var OldKeys = [keyword];
						uni.setStorage({
							key: 'ProjectOldKeys',
							data: JSON.stringify(OldKeys)
						});
						this.oldKeywordList = OldKeys; //更新历史搜索
					}
				});
			},
			/** 清除历史搜索 */
			oldDelete() {
				uni.showModal({
					content: '确定清除历史搜索记录？',
					success: (res) => {
						if (res.confirm) {
							this.oldKeywordList = [];
							uni.removeStorage({
								key: 'ProjectOldKeys'
							});
						} else if (res.cancel) {}
					}
				});
			},
			/** 加载历史搜索,自动读取本地Storage */
			loadOldKeyword() {
				uni.getStorage({
					key: 'ProjectOldKeys',
					success: (res) => {
						var OldKeys = JSON.parse(res.data);
						this.oldKeywordList = OldKeys;
					}
				});
			},
			/** 导航栏切换 */
			async tapTab(e) {
				let tabIndex = e.target.dataset.current
				if (this.projectType.tabIndex === tabIndex) {
					return false
				} else {
					this.projectType.tabIndex = tabIndex

					this.imgIcon = PROJECT_TYPE_ICONS[tabIndex]
				}
			},
			/** 项目状态切换 */
			onClickItem(index) {
				if (this.projectStatus.current !== index) {
					this.projectStatus.current = index
					if (index === PROJECT_STATUS_WAITTING) {
						this.showChooseDate = true
					} else {
						this.showChooseDate = false
					}
				}
			},
			/** 打开日期框 */
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
			/** 前往项目详情 */
			toProjectDetail(item) {
				uni.navigateTo({
					url: '/pages-project-info/project-detail/project-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			// 触发操作选项
			actionSheetTap() {
				uni.showActionSheet({
					title: '标题',
					itemList: ['澄清文件', '招标文件', '清单文件', '资质文件', '收藏项目'],
					success: (e) => {
						this.seeFile(e.tapIndex)
						// uni.showToast({
						// 	title:"点击了第" + e.tapIndex + "个选项",
						// 	icon:"none"
						// })
					}
				})
			},
			// 查看文件
			seeFile(type) {
				console.log(type)
				if (SEE_FILE_TYPE_CHENGQING === type) {
					console.log("查看澄清文件")
				} else if (SEE_FILE_TYPE_ZHAOBIAO === type) {
					console.log("查看招标文件")
				} else if (SEE_FILE_TYPE_QINGDAN === type) {
					console.log("查看清单文件");
				} else if (SEE_FILE_TYPE_ZIZHI === type) {
					console.log("查看资质文件");
				} else if (COLLECTION_PROJECT === type) {
					console.log("收藏项目");
				}
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	page {
		background-color: $primary-backcolor;
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
</style>
