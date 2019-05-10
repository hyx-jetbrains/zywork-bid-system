<template>
	<view>
		<view class="zy-project">
			<view class="zy-text-big zy-text-bold zy-project-title">{{project.title}}</view>
			<!-- 头部部分 -->
			<view class="zy-disable-flex zy-project-head">
				<image class="zy-head-icon" :src="imgIcon" />
				<view>
					<view>
						<text>{{project.projectType}}</text>
						<text style="margin-left: 30upx;">[{{project.city}}]</text>
					</view>
					<view class="zy-text-mini zy-text-info">公告时间：{{project.noticeTime}}</view>
				</view>
				<view class="zy-disable-flex-right">
					<view class="zy-project-collection-button zy-text-info zy-text-small zy-disable-flex"
						:class="isCollection ? 'zy-project-collection-button-active' : ''"
						@click="collectionProject">
						<zywork-icon type="iconshoucang" :color="collectionIconColor" style="margin-right: 10upx;"></zywork-icon>
						收藏
					</view>
				</view>
			</view>
			<!-- tab选项卡 -->
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="projectType.scrollLeft">
					<view class="swiper-tab-list" :class="currTabIndex === 0 ? 'active' : ''"
						@click="tapTab(0)">项目介绍</view>
					<view class="swiper-tab-list" :class="currTabIndex === 1 ? 'active' : ''"
						@click="tapTab(1)">公告详情</view>
					<view class="swiper-tab-list" :class="currTabIndex === 2 ? 'active' : ''"
						@click="tapTab(2)">开标详情</view>
					<view class="swiper-tab-list" :class="currTabIndex === 3 ? 'active' : ''"
						@click="tapTab(3)">公示详情</view>
					<view class="swiper-tab-list" :class="currTabIndex === 4 ? 'active' : ''"
						@click="tapTab(4)">开标搭车</view>
				</scroll-view>
			</view>
			<!-- 项目介绍 -->
			<view v-if="currTabIndex === 0">
				<view class="zy-project-desc-title zy-text-bold">
					招标公告
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">招标单位名称</view>
					<view class="zy-disable-flex-right">{{project.markUnitName}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">本项目投资</view>
					<view class="zy-disable-flex-right zy-warning">{{project.projectInvest}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">审查方式</view>
					<view class="zy-disable-flex-right">{{project.checkPattern}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">企业资质类型</view>
					<view class="zy-disable-flex-right">{{project.compAptitudeType}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">建造师等级</view>
					<view class="zy-disable-flex-right">{{project.builderLevel}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">资金落实</view>
					<view class="zy-disable-flex-right">{{project.moneyToImplement}}%</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">招标代理</view>
					<view class="zy-disable-flex-right">{{project.tenderingAgent}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">联系电话</view>
					<view class="zy-disable-flex-right zy-primary">{{project.phone}}</view>
				</view>
				<view class="zy-project-desc-title zy-text-bold zy-disable-flex" style="position: relative;">
					<view>文件</view>
					<view class="zy-disable-flex-right" style="margin-right: 0upx;">
						<view class="zy-disable-flex" @tap="actionSheetTap">
							查看文件
							<zywork-icon type="iconxiangxia" />
						</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">要约价(元)</view>
					<view class="zy-disable-flex-right zy-warning">{{project.offerPrice / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">保证金(万元)</view>
					<view class="zy-disable-flex-right zy-primary">{{project.assurePrice / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">工期(天)</view>
					<view class="zy-disable-flex-right">{{project.constructionPeriod}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">下载时间</view>
					<view class="zy-disable-flex-right">{{project.downloadEndTime}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">其他要求</view>
				</view>
				<view class="zy-project-desc-textarea">
					{{project.otherDemand}}
				</view>
				<view class="zy-project-desc-title zy-text-bold">
					开标信息
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">开标时间</view>
					<view class="zy-disable-flex-right">{{project.openMarkTime}}</view>
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">开标地点</view>
					<view class="zy-disable-flex-right">{{project.openMarkAddr}}</view>
				</view>
				<view class="zy-project-desc-title zy-text-bold">
					中标公示
				</view>
				<view class="zy-disable-flex zy-project-desc-item">
					<view class="zy-text-bold">中标单位名称</view>
					<view class="zy-disable-flex-right">{{project.inMarkComp}}</view>
				</view>
			</view>
			<!-- 公告详情 -->
			<view v-if="currTabIndex === 1">
				公告详情
			</view>
			<!-- 开标详情 -->
			<view v-if="currTabIndex === 2">
				开标详情
			</view>
			<!-- 公示详情 -->
			<view v-if="currTabIndex === 3">
				公示详情
			</view>
			<!-- 开标搭车 -->
			<view v-if="currTabIndex === 4">
				开标搭车
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	
	/** 项目类型-房建市政 */
	const PROJECT_TYPE_BUILDING = '房建市政'
	/** 项目类型-水利工程 */
	const PROJECT_TYPE_HYDRAULIC = '水利工程'
	/** 项目类型-交通工程 */
	const PROJECT_TYPE_TRAFFIC = '交通工程'
	/** 项目类型-政府采购 */
	const PROJECT_TYPE_PURCHASE = '政府采购'
	/** 项目类型-重点项目 */
	const PROJECT_TYPE_IMPORTANT = '重点项目'
	/** 项目类型-其他项目 */
	const PROJECT_TYPE_OTHER = '其他项目'
	
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
								
	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
			uniTag
		},
		data() {
			return {
				imgIcon: PROJECT_TYPE_ICONS[0],
				isCollection: true,
				collectionIconColor: '#BFBFBF',
				currTabIndex: 0,
				project: {
					id: null,
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
					openMarkTime: '2019-04-22 17:31:33',
					openMarkAddr: '赣州分布开标室一',
					inMarkPublicity: null,
					inMarkComp: '某某公司',
					noticeTime: '2019-04-22 17:31:33',
					clickCount: null,
					isElectronic: null,
					sourceUrl: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
			}
		},
		onLoad() {
			this.initIconImg()
			this.initCollectionIcon()
		},
		methods: {
			// 初始化图标
			initIconImg() {
				var projectType = this.project.projectType;
				var currIndex = 0;
				if (PROJECT_TYPE_BUILDING === projectType) {
					// 房建市政
					currIndex = 0;
				} else if (PROJECT_TYPE_HYDRAULIC === projectType) {
					// 水利工程
					currIndex = 1;
				} else if (PROJECT_TYPE_TRAFFIC === projectType) {
					// 交通工程
					currIndex = 2;
				} else if (PROJECT_TYPE_PURCHASE === projectType) {
					// 政府采购
					currIndex = 3;
				} else if (PROJECT_TYPE_IMPORTANT === projectType) {
					// 重点项目
					currIndex = 3;
				} else if (PROJECT_TYPE_OTHER === projectType) {
					// 其他项目
					currIndex = 4;
				}
				this.imgIcon = PROJECT_TYPE_ICONS[currIndex]
			},
			// 初始化项目图标
			initCollectionIcon() {
				// 请求后台判断该项目是否已经被当前用户收藏
				// TODO 后面实现
				
				this.switchCollectionIconColor()
			},
			// 切换项目收藏的图标颜色
			switchCollectionIconColor() {
				if (this.isCollection) {
					this.collectionIconColor = '#108EE9'
				} else {
					this.collectionIconColor = '#BFBFBF'
				}
			},
			// 收藏项目
			collectionProject() {
				// 点击后请求后台，保存或删除收藏记录
				// TODO 以后实现
				
				if (this.isCollection) {
					this.isCollection = false
				} else {
					this.isCollection = true
				}
				this.switchCollectionIconColor()
			},
			// 切换标签页
			tapTab(type) {
				this.currTabIndex = type;
			},
			// 触发操作选项
			actionSheetTap() {
				uni.showActionSheet({
					title:'标题',
					itemList: ['澄清文件', '招标文件', '清单文件', '资质文件'],
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
				}
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	page {
		background-color: #FFFFFF;
	}
	
	.zy-project {
		
	}
	
	.zy-project-title {
		padding: 20upx 20upx 0 20upx;
	}
	
	.zy-project-head {
		border-bottom: 2upx solid $border-color;
		padding: 20upx;
	}
	
	.zy-head-icon {
		width: 60upx;
		height: 60upx;
		margin-right: 20upx;
	}
	
	.zy-project-collection-button {
		width: 110upx;
		height: 45upx;
		border: 1upx solid $border-color;
		border-radius: 10upx;
		padding-left: 10upx;
	}
	
	.zy-project-collection-button-active {
		border: 1upx solid $primary-color;
		color: $primary-color;
	}
	
	.zy-project-desc-title {
		background-color: #F8F8F8;
		padding: 5upx 20upx;
		border-left: 5upx solid $primary-color;
	}
	.zy-project-desc-item {
		padding: 5upx 0 5upx 20upx;
	}
	.zy-project-desc-item .zy-warning {
		color: #dd524d;
	}
	.zy-project-desc-item .zy-primary {
		color: #108EE9;
	}
	.zy-project-desc-textarea {
		padding: 0 20upx;
	}
</style>
