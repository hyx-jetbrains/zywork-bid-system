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
					<view class="zy-text-mini zy-text-info">
						公告时间：
						<text v-if="project.noticeTime !== null && project.noticeTime !== undefined" class="zy-text-mini zy-text-info">
							{{project.noticeTime}}
						</text>
						<text v-else class="zy-text-mini zy-text-info">
							暂无
						</text>
					</view>
				</view>
				<view class="zy-disable-flex-right">
					<view class="zy-project-collection-button zy-text-info zy-text-small zy-disable-flex" :class="isCollection ? 'zy-project-collection-button-active' : ''"
					 @click="collectionProject">
						<zywork-icon type="iconshoucang" :color="collectionIconColor" style="margin-right: 10upx;"></zywork-icon>
						收藏
					</view>
				</view>
			</view>
			<!-- tab选项卡 -->
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="projectType.scrollLeft">
					<view class="swiper-tab-list" :class="currTabIndex === 0 ? 'active' : ''" @click="tapTab(0)">项目介绍</view>
					<view class="swiper-tab-list" :class="currTabIndex === 1 ? 'active' : ''" @click="tapTab(1)">公告详情</view>
					<view class="swiper-tab-list" :class="currTabIndex === 2 ? 'active' : ''" @click="tapTab(2)">开标详情</view>
					<view class="swiper-tab-list" :class="currTabIndex === 3 ? 'active' : ''" @click="tapTab(3)">公示详情</view>
					<view class="swiper-tab-list" :class="currTabIndex === 4 ? 'active' : ''" @click="tapTab(4)">开标搭车</view>
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
					<view class="zy-disable-flex-right">{{project.downloadEndTime !== null ? project.downloadEndTime : ''}}</view>
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
					<view class="zy-disable-flex-right">{{project.openMarkTime !== null ? project.openMarkTime : ''}}</view>
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
			<!-- 开标详情 -->
			<view v-if="currTabIndex === 2">
				<view v-if="project.markStatus === '已开标'">
					<view class="zy-project-desc-title zy-text-bold">
						开标信息
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">开标时间</view>
						<view class="zy-disable-flex-right">{{project.openMarkTime}}</view>
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">开标地点</view>
						<view class="zy-disable-flex-right">{{project.openMarkTime}}</view>
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">开标状态</view>
						<view class="zy-disable-flex-right">{{project.markStatus}}</view>
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">中标单位</view>
						<view class="zy-disable-flex-right">{{project.inMarkComp}}</view>
					</view>
				</view>
				<zyworkNoData v-else text="暂无开标信息"></zyworkNoData>
			</view>
			<!-- 公示详情 -->
			<view v-if="currTabIndex === 3">
				<view v-if="projectAnnounce.id !== null && projectAnnounce.id !== undefined">
					<view class="zy-project-desc-title zy-text-bold">
						中标信息
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">第一中标单位</view>
						<view class="zy-disable-flex-right">{{projectAnnounce.firstCandidate !== null ? projectAnnounce.firstCandidate : ''}}</view>
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">第二中标单位</view>
						<view class="zy-disable-flex-right">{{projectAnnounce.secondCandidate !== null ? projectAnnounce.secondCandidate : ''}}</view>
					</view>
					<view class="zy-disable-flex zy-project-desc-item">
						<view class="zy-text-bold">第三中标单位</view>
						<view class="zy-disable-flex-right">{{projectAnnounce.thirdCandidate !== null ? projectAnnounce.thirdCandidate : ''}}</view>
					</view>
					<view class="zy-project-desc-title zy-text-bold">
						中标公示
					</view>
					<view>
						<button class="zy-detail-button" type="primary" @click="toAnnounceDetail">
							查看详情
						</button>
					</view>
				</view>
				<zyworkNoData v-else text="暂无公示信息"></zyworkNoData>
			</view>
			<!-- 开标搭车 -->
			<view v-if="currTabIndex === 4">
				<view class="zy-uni-segmented-control">
					<uni-segmented-control :current="carPoolOpts.current" :values="carPoolOpts.items" v-on:clickItem="onClickCarPoolItem"
					 styleType="button" activeColor="#108EE9"></uni-segmented-control>
				</view>
				<view style="height: 10upx; background-color: #F8F8F8;"></view>
				<view class="zy-page-list-item" style="padding-top: 0upx;">
					<view v-if="carPoolOpts.current === 0">
						<!-- 拼车信息 -->
						<view class="zy-page-list" v-if="carpoolList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in carpoolList" :key="index">
								<view @click="toCarpoolDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											:src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view class="zy-disable-flex">
												<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
												<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
												<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
												<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
											</view>
											<view class="zy-text-mini zy-text-info">
												{{item.markCarpoolStartTime}}
												<text class="zy-text-mini" style="color: #108EE9; margin-left: 20upx;">{{item.markCarpoolCarType}}</text>
											</view>
										</view>
										<view class="zy-disable-flex-right">
											¥{{item.markCarpoolPrice / 100}}
										</view>
									</view>
									<view>
										<view class="zy-text-big zy-text-bold">
											{{item.markCarpoolStartAddr}}
											-
											{{item.markCarpoolEndAddr}}
										</view>
									</view>
								</view>
								<view class="zy-text-info zy-disable-flex">
									<view>
										<text style="margin-right: 20upx;">搭车人数:</text>
										{{item.markCarpoolRecordCount}}/{{item.markCarpoolPeopleCount}}
									</view>
									<view class="zy-disable-flex-right">
										<uni-tag text="我要拼车" type="primary" size="small" :inverted="true" :circle="true" @click="addCarpoolRecord(item)"></uni-tag>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无拼车信息"></zyworkNoData>
					</view>
					<view v-else>
						<!-- 找车信息 -->
						<view class="zy-page-list" v-if="seekcarList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in seekcarList" :key="index">
								<view @click="toSeekcarDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											:src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view class="zy-disable-flex">
												<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
												<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
												<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
												<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
											</view>
											<view class="zy-text-mini zy-text-info">{{item.markSeekcarStartTime}}</view>
										</view>
									</view>
									<view>
										<view class="zy-text-big zy-text-bold">
											{{item.markSeekcarStartAddr}}
											-
											{{item.markSeekcarEndAddr}}
										</view>
										<view class="zy-text-info">
											{{item.markSeekcarMemo}}
										</view>
									</view>
								</view>
								<view class="zy-text-info zy-disable-flex">
									<view>
										<text style="margin-right: 20upx;">申请人数:</text>
										{{item.markSeekcarRecordCount}}/1
									</view>
									<view class="zy-disable-flex-right">
										<uni-tag text="我有车" type="primary" size="small" :inverted="true" :circle="true" @click="addSeekcarRecord(item)"></uni-tag>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无找车信息"></zyworkNoData>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'

	import {
		openMarkArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON,
		showInfoToast
	} from '@/common/util.js'
	import {
		getProjectCollectionInfo,
		saveProjectCollection,
		cancelProjectCollection,
		getProjectAnnounce,
		getCarpoolList,
		getSeekcarList
	} from '@/common/project-info.js'
	import * as infoShare from '@/common/info-share.js'

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

	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
			uniTag,
			uniSegmentedControl
		},
		data() {
			return {
				defaultIcon: DEFAULT_HEADICON,
				imgIcon: PROJECT_TYPE_ICONS[0],
				isCollection: false,
				collectionIconColor: '#BFBFBF',
				currTabIndex: 0,
				project: {},
				projectAnnounce: {},
				carPoolOpts: {
					current: 0,
					items: openMarkArray
				},
				carpoolList: [],
				seekcarList: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					projectId: '',
					isActive: 0
				}
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.project = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.project = JSON.parse(payload);
			}
			this.initData();
		},
		methods: {
			/** 初始化数据 */
			initData() {
				this.initCollectionIcon();
				getProjectAnnounce(this, this.project.id);
				this.pager.projectId = this.project.id;
				getCarpoolList(this, this.pager);
				getSeekcarList(this, this.pager);
			},
			// 初始化项目图标
			initCollectionIcon() {
				// 请求后台判断该项目是否已经被当前用户收藏
				getProjectCollectionInfo(this, this.project.id)
			},
			// 切换项目收藏的图标颜色
			collectionOperation(projectId) {
				if (this.isCollection) {
					this.collectionIconColor = '#108EE9'
				} else {
					this.collectionIconColor = '#BFBFBF'
				}
			},
			// 收藏项目或取消收藏项目
			collectionProject() {
				if (this.isCollection) {
					// 取消收藏
					cancelProjectCollection(this, this.project.id);
				} else {
					// 保存收藏
					saveProjectCollection(this, this.project.id);
				}
			},
			// 切换标签页
			tapTab(type) {
				if (type == 1) {
					// 公告详情
					this.toWebViewPage("公告详情", this.project.inwardHtmlUrl)
				} else {
					this.currTabIndex = type;
				}
			},
			/** 前往webview页面 */
			toWebViewPage(title, url) {
				var item = {
					'title': title,
					'url': url
				}
				uni.navigateTo({
					url: '/pages-static/web-view/web-view?itemData=' + encodeURIComponent(JSON.stringify(item))
				});
			},
			/** 公示详情 */
			toAnnounceDetail() {
				if (this.projectAnnounce.id !== null) {
					this.toWebViewPage("公示详情", this.projectAnnounce.inwordHtmlUrl);
				} else {
					uni.showModal({
						title: '提示',
						content: '没有公示信息',
						showCancel: false
					})
				}
			},
			// 触发操作选项
			actionSheetTap() {
				uni.showActionSheet({
					title: '标题',
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
			},
			/** 开标拼车和找车分段器 */
			onClickCarPoolItem(index) {
				if (this.carPoolOpts.current !== index) {
					this.carPoolOpts.current = index
				}
			},
			/** 点击我要拼车，增加拼车记录 */
			addCarpoolRecord(item) {
				if (item.markCarpoolRecordCount >= item.markCarpoolPeopleCount) {
					showInfoToast('人数已满，不能申请')
					return;
				}
				// 调用接口保存拼车记录
				infoShare.saveMarkCarpoolRecord(this, item.markCarpoolId);
			},
			/** 点击我有车，增加找车记录 */
			addSeekcarRecord(item) {
				if (item.markSeekcarRecordCount >= 1) {
					showInfoToast('人数已满，不能申请')
					return;
				}
				// 调用接口保存找车记录
				infoShare.saveMarkSeekcarRecord(this, item.markSeekcarId);
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-info-share/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往拼车详情页面 */
			toCarpoolDetailPage(item) {
				this.toDetailPage('carpool', item);
			},
			/** 前往找车详情页面 */
			toSeekcarDetailPage(item) {
				this.toDetailPage('seekcar', item);
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	page {
		background-color: #FFFFFF;
	}

	.zy-project {}

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

	.zy-detail-button {
		text-align: center;
		margin: 30upx 25upx;
		border-radius: 50upx 50upx;
	}
</style>
