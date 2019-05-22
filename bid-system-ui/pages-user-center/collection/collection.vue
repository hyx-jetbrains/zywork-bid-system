<template>
	<view>
		<!-- 分类导航栏 -->
		<view class="uni-tab-bar zy-tab-bar">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="projectType.scrollLeft">
				<view v-for="(tab,index) in projectType.tabbars" :key="tab.id" class="swiper-tab-list" :class="projectType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
		</view>
		
		<!-- 类别标签页 -->
		<view style="background-color: #FFFFFF; padding-bottom: 10upx;">
			<uni-segmented-control :current="projectStatus.current" :values="projectStatus.items" v-on:clickItem="onClickItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		
		<!-- 列表 -->
		<view class="zy-page-list zy-project" v-if="projects.length > 0">
			<view class="zy-page-list-item zy-position-relative" v-for="(project, index) in projects" :key="index">
				<zywork-icon class="zy-project-sheet-icon" type="iconxiangxia" size="30" @tap="actionSheetTap(project.id)" />
				<view @click="toProjectDetail(project)">
					<view class="zy-disable-flex">
						<image class="zy-project-icon" :src="imgIcon" />
						<view>
							<view>
								<text>{{project.projectType}}</text>
								<text style="margin-left: 30upx;">[{{project.city}}]</text>
							</view>
							<view class="zy-text-mini zy-text-info">
								公告时间：
								<text v-if="project.noticeTime !== null && project.noticeTime !== undefined"
									class="zy-text-mini zy-text-info">
								{{project.noticeTime}}
								</text>
								<text v-else class="zy-text-mini zy-text-info">
									暂无
								</text>
							</view>
						</view>
						<view class="zy-project-head-right">
							<view style="padding-right: 50upx;">
								<uni-tag text="最新" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
								<uni-tag :text="project.markStatus" type="primary" size="small" :inverted="true" :circle="true" style="margin-left: 10upx;"></uni-tag>
							</view>
							<view v-html="space"></view>
							<!-- <view class="zy-text-mini zy-text-warning" 
								v-if="project.openMarkTime !== null && project.openMarkTime !== undefined">
								开标日期：{{project.openMarkTime}}
							</view>
							<view class="zy-text-mini zy-text-warning" v-else>开标日期：暂无</view> -->
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
		
		<!-- 没有数据 -->
		<zywork-no-data v-else text="暂无招标信息"></zywork-no-data>
		
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		IMAGE_BASE_URL,
		DEFAULT_HEADICON,
		isUserTokenExist,
		toLoginPage,
		getCalendarDate,
		formatCalendarDate
	} from '@/common/util.js'
	import {
		projectStatusArray
	} from '@/common/picker.data.js'
	import {
		getProjectCollectionByUserId
	} from '@/common/user-center.js'
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
								'../../static/icon/other.png']
	/** 澄清文件标识-0 */
	const SEE_FILE_TYPE_CHENGQING = 0
	/** 招标文件标识-1 */
	const SEE_FILE_TYPE_ZHAOBIAO = 1
	/** 清单文件标识-2 */
	const SEE_FILE_TYPE_QINGDAN = 2
	/** 资质文件标识-3 */
	const SEE_FILE_TYPE_ZIZHI = 3
	/** 收藏或取消收藏-4 */
	const SEE_FILE_TYPE_SC_QXSC = 4
	export default {
		components: {
			zyworkIcon,
			uniSegmentedControl,
			uniTag,
			zyworkNoData
		},
		data() {
			return {
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
							name: '重点项目'
						},
						{
							id: 'other',
							name: '其他项目'
						}
					]
				},
				projectStatus: {
					current: 0,
					items: projectStatusArray
				},
				imgIcon: PROJECT_TYPE_ICONS[0],
				projects: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'createTime',
					sortOrder: 'desc',
					projectType: '房建市政',
					markStatus: '',
					isActive: 0,
					releaseStatus: '已发布',
					city: ''
				},
				isCollection: false,
				actionSheetArray: ['澄清文件', '招标文件', '清单文件', '资质文件']
			}
		},
		onLoad() {
			this.initData()
		},
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
			// 点击导航栏触发
			async tapTab(e) {
				let tabIndex = e.target.dataset.current
				if (this.projectType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.projectType.scrollLeft = tabBarScrollLeft
					this.projectType.tabIndex = tabIndex
					this.pager.projectType = this.projectType.tabbars[tabIndex].name
					this.updateProjectList();
					this.imgIcon = PROJECT_TYPE_ICONS[tabIndex]
				}
			},
			// 点击分段器触发
			onClickItem(index) {
				if (this.projectStatus.current !== index) {
					this.projectStatus.current = index
					if (index === PROJECT_STATUS_ALL) {
						this.pager.markStatus = '';
					} else {
						this.pager.markStatus = this.projectStatus.items[index]
					}
					this.updateProjectList();
					if (index === PROJECT_STATUS_WAITTING) {
						this.showChooseDate = true
					} else {
						this.showChooseDate = false
					}
				}
			},
			// 前往项目详情
			toProjectDetail(item) {
				uni.navigateTo({
					url: '/pages-project-info/project-detail/project-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			// 触发操作选项
			actionSheetTap(projectId) {
				projectInfo.getProjectCollectionInfo(this, projectId);
			},
			// 查看文件
			seeFile(type, projectId) {
				console.log(type)
				if (SEE_FILE_TYPE_CHENGQING === type) {
					console.log("查看澄清文件")
				} else if (SEE_FILE_TYPE_ZHAOBIAO === type) {
					console.log("查看招标文件")
				} else if (SEE_FILE_TYPE_QINGDAN === type) {
					console.log("查看清单文件");
				} else if (SEE_FILE_TYPE_ZIZHI === type) {
					console.log("查看资质文件");
				} else if (SEE_FILE_TYPE_SC_QXSC === type) {
					const tempType = this.actionSheetArray[SEE_FILE_TYPE_SC_QXSC];
					if (tempType == '取消收藏') {
						projectInfo.cancelProjectCollection(this, projectId);
					} else if (tempType == '收藏项目') {
						projectInfo.saveProjectCollection(this, projectId);
					}
				}
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
				this.updateProjectList();
			},
			initData() {
				this.updateProjectList();
			},
			/** 更新项目列表 */
			updateProjectList() {
				getProjectCollectionByUserId(this, this.pager)
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';
	
	.zy-project {
		margin-top: 10upx;
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
	
	.zy-project-sheet-icon {
		margin-left: 20upx;
		position: absolute;
		top: -2upx;
		right: -10upx;
	}
</style>
