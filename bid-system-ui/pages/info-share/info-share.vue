<template>
	<view>
		<view class="zy-top-search">
			<view class="zy-search-bar" @click="toSearchPage">
				<zywork-icon type="iconchaxun" />
				<input type="text" placeholder="我要搜索" disabled />
			</view>
			<view style="margin-left: 10upx;">
				<zywork-icon type="icontianjia" color="#108ee9" size="28" class="zy-icon" @click.native="toPublishChoose(0)" />
			</view>
		</view>
		<official-account></official-account>
		<view class="uni-tab-bar zy-tab-bar">
			<scroll-view id="tab-bar" class="uni-swiper-tab zy-swiper-tab-list" scroll-x :scroll-left="infoType.scrollLeft">
				<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
			</scroll-view>
		</view>

		<view>
			<!-- 建造师 -->
			<view v-if="infoType.tabIndex === 3">
				<view class="zy-uni-segmented-control">
					<uni-segmented-control :current="builderOpts.current" :values="builderOpts.items" v-on:clickItem="onClickBuilderItem"
					 styleType="button" activeColor="#108EE9"></uni-segmented-control>
				</view>
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<view v-if="builderOpts.current === 0">
						<!-- 招聘信息 -->
						<view class="zy-page-list" v-if="builderReqList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in builderReqList" :key="index">
								<view @click="toBuilderReqDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view>
												<text class="zy-text-bold">{{item.builderReqCompName}}</text>
											</view>
											<view class="zy-text-mini zy-text-info">公告时间：{{item.builderReqCreateTime}}</view>
										</view>
										<view class="zy-disable-flex-right">
											¥{{item.builderReqSalary / 100}}
										</view>
									</view>
									<view>
										<view class="zy-text-big zy-text-bold">{{item.builderReqPeople}}</view>
										<view class="zy-text-info">
											{{item.builderReqMemo}}
										</view>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
					</view>
					<view v-else>
						<!-- 应聘信息 -->
						<view class="zy-page-list" v-if="builderList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in builderList" :key="index">
								<view @click="toBuilderDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view>
												<text class="zy-text-bold">{{item.builderName}}</text>
											</view>
											<view class="zy-text-mini zy-text-info">公告时间：{{item.builderCreateTime}}</view>
										</view>
									</view>
									<view>
										<view class="zy-text-big zy-text-bold">{{item.builderCertificateMajorType}}</view>
										<view class="zy-text-info">
											{{item.builderMemo}}
										</view>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无应聘信息"></zyworkNoData>
					</view>
				</view>
			</view>

			<!-- 资质转让 -->
			<view v-if="infoType.tabIndex === 1">
				<view class="zy-uni-segmented-control">
					<uni-segmented-control :current="aptitudeOpts.current" :values="aptitudeOpts.items" v-on:clickItem="onClickAptitudeItem"
					 styleType="button" activeColor="#108EE9"></uni-segmented-control>
				</view>
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<view v-if="aptitudeOpts.current === 0">
						<!-- 求购信息 -->
						<view class="zy-page-list" v-if="aptitudeBuyList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in aptitudeBuyList" :key="index">
								<view @click="toAptitudeDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view>
												<text class="zy-text-bold">{{item.userDetailNickname}}</text>
											</view>
											<view class="zy-text-mini zy-text-info">{{item.aptitudeTransferCreateTime}}</view>
										</view>
									</view>
									<view>
										<view class="zy-text-big zy-text-bold">{{item.aptitudeTransferTitle}}</view>
										<view class="zy-text-info">
											{{item.aptitudeTransferMemo}}
										</view>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无求购信息"></zyworkNoData>
					</view>
					<view v-else>
						<!-- 转让信息 -->
						<view class="zy-page-list" v-if="aptitudeSellList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in aptitudeSellList" :key="index">
								<view @click="toAptitudeDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view>
												<text class="zy-text-bold">{{item.userDetailNickname}}</text>
											</view>
											<view class="zy-text-mini zy-text-info">{{item.aptitudeTransferCreateTime}}</view>
										</view>
									</view>
									<view>
										<view class="zy-text-big zy-text-bold">{{item.aptitudeTransferTitle}}</view>
										<view class="zy-text-info">
											{{item.aptitudeTransferMemo}}
										</view>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无转让信息"></zyworkNoData>
					</view>
				</view>
			</view>

			<!-- 开标拼车 -->
			<view v-if="infoType.tabIndex === 5">
				<view class="zy-uni-segmented-control">
					<uni-segmented-control :current="carPoolOpts.current" :values="carPoolOpts.items" v-on:clickItem="onClickCarPoolItem"
					 styleType="button" activeColor="#108EE9"></uni-segmented-control>
				</view>
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<view v-if="carPoolOpts.current === 0">
						<!-- 拼车信息 -->
						<view class="zy-page-list" v-if="carpoolList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in carpoolList" :key="index">
								<view @click="toCarpoolDetailPage(item)">
									<view class="zy-disable-flex">
										<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view>
												<view class="zy-disable-flex">
													<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
													<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
													<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
													<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
												</view>
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
										<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
										<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
										<view>
											<view>
												<view class="zy-disable-flex">
													<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
													<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
													<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
													<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
												</view>
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

			<!-- 岗位招聘 -->
			<view v-if="infoType.tabIndex === 6">
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<!-- 其他岗位招聘信息 -->
					<view class="zy-page-list" v-if="recruitList.length > 0">
						<view class="zy-page-list-item" v-for="(item, index) in recruitList" :key="index">
							<view @click="toRecruitDetailPage(item)">
								<view class="zy-disable-flex">
									<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
									<view>
										<view class="zy-disable-flex">
											<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
											<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
											<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
											<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
										</view>
									</view>
									<view class="zy-disable-flex-right">
										{{item.recruitRecruitStatus}}
									</view>
								</view>
								<view>
									<view class="zy-disable-flex">
										<view class="zy-text-bold">
											招聘岗位：
											<text class="zy-text-info">{{item.recruitJobTitle}}</text>
										</view>
										<view class="zy-disable-flex-right">
											{{item.recruitIsFulltime === 0 ? '全职' : '兼职'}}
											：
											¥{{item.recruitSalary}}/月
										</view>
									</view>
									<view class="zy-text-info zy-disable-flex">
										<view class="zy-text-bold">
											工作经验：
											<text class="zy-text-info">{{item.recruitWorkYear}}年</text>
										</view>
										<view class="zy-text-bold zy-disable-flex-right">
											学历：
											<text class="zy-text-info">{{item.recruitEducation}}</text>
										</view>
									</view>
								</view>
							</view>
						</view>
					</view>
					<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
				</view>
			</view>

			<!-- 求带资料 -->
			<view v-if="infoType.tabIndex === 4">
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<!-- 求带资料信息 -->
					<view class="zy-page-list" v-if="seekDataList.length > 0">
						<view class="zy-page-list-item" v-for="(item, index) in seekDataList" :key="index">
							<view @click="toSeekDataDetailPage(item)">
								<view class="zy-disable-flex">
									<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
									<view>
										<view class="zy-disable-flex">
											<text class="zy-text-bold" style="margin-right: 20upx;">{{item.seekDataDataType}}</text>
											<text class="zy-text-bold">{{item.seekDataDataCount}}份</text>
										</view>
										<view class="zy-text-mini zy-text-info" style="color: #108EE9">最晚时间：{{item.seekDataLatestTime}}</view>
									</view>
									<view class="zy-disable-flex-right">
										<view class="zy-disable-flex">
											赏金：
											<text style="margin-right: 10upx;">¥{{item.seekDataPrice / 100}}</text>
											<!-- <uni-tag v-if="item.isUrgent === 0" text="急" type="error" size="small" :inverted="true" :circle="false"></uni-tag> -->
											<zywork-icon v-if="item.seekDataIsUrgent === 1" type="iconjinjidingdan" color="#dd524d" size="20" />
										</view>
									</view>

								</view>
								<view>
									<view class="zy-text-bold">
										出发地：
										<text class="zy-text-info">{{item.seekDataStartAddr}}</text>
									</view>
									<view class="zy-text-bold">
										目的地：
										<text class="zy-text-info">{{item.seekDataEndAddr}}</text>
									</view>
								</view>
							</view>
						</view>
					</view>
					<zyworkNoData v-else text="暂无求带资料信息"></zyworkNoData>
				</view>
			</view>

			<!-- 更新公告 -->
			<view v-if="infoType.tabIndex === 0">
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<!-- 更新公告信息 -->
					<view class="zy-page-list" v-if="updateNoticeList.length > 0">
						<view class="zy-page-list-item" v-for="(item, index) in updateNoticeList" :key="index">
							<view @click="toUpdateNoticeDetailPage(item)">
								<view class="zy-disable-flex">
									<view style="width: 100upx;">
										<image class="zy-page-mini-headicon" :src="defaultIcon" />
									</view>
									<view>
										<view class="zy-text-bold" v-text="item.title"></view>
										<view class="zy-text-mini zy-text-info" style="color: #108EE9">公告时间：{{item.createTime}}</view>
									</view>
								</view>
								<view v-text="item.synopsis"></view>
							</view>
						</view>
					</view>
					<zyworkNoData v-else text="暂无通知公告信息"></zyworkNoData>
				</view>
			</view>

			<!-- 申请保函 -->
			<view v-if="infoType.tabIndex === 2">
				<view class="zy-page-list-item" style="padding-top: 10upx;">
					<!-- 申请保函信息 -->
					<view class="zy-page-list" v-if="guaranteeList.length > 0">
						<view class="zy-page-list-item" v-for="(item, index) in guaranteeList" :key="index">
							<view @click="toGuaranteeDetailPage(item)">
								<view class="zy-disable-flex">
									<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info" style="color: #108EE9">
											{{item.guaranteeCreateTime}}
										</view>
									</view>
								</view>
								<view>
									<view class="zy-text-bold">
										{{item.guaranteeProjectName}}
									</view>
									<view class="zy-text-info zy-disable-flex">
										<view class="zy-text-bold">
											招标单位名称：
											<text class="zy-text-info">{{item.guaranteeMarkUnitName}}</text>
										</view>
										<view class="zy-text-bold zy-disable-flex-right">
											工期(天)：
											<text class="zy-text-info">{{item.guaranteeConstructionPeriod}}</text>
										</view>
									</view>
								</view>
							</view>
						</view>
					</view>
					<zyworkNoData v-else text="暂无保函信息"></zyworkNoData>
				</view>
			</view>
		</view>

		<zywork-fab v-if="addPublish" :pattern="pattern" :horizontal="horizontal" 
			:vertical="vertical" :direction="direction" :showContent="false" :iconType="iconType"
		 @trigger="toPublishChoose(1)"></zywork-fab>

		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkFab from '@/components/zywork-fab/zywork-fab.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {
		builderTypeArray,
		aptitudeTypeArray,
		openMarkArray,
		hireArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON,
		showInfoToast,
		nullToStr,
		SHARE_CODE_PAGE_IMG,
		getShareCode,
		isUserIdExist,
		notLoginToUserCenter,
		LOGIN_FLAG
	} from '@/common/util.js'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as infoShare from '@/common/info-share.js'

	// 通知公告
	const INFO_NOTICE = 0
	// 资质转让
	const INFO_APTITUDE = 1
	// 申请保函
	const INFO_GUARANTEE = 2
	// 建造师
	const INFO_BUILDER = 3
	// 求带资料
	const INFO_MATERIAL = 4
	// 开标拼车
	const INFO_CARPOOL = 5
	// 岗位招聘
	const INFO_HIRE = 6

	export default {
		components: {
			zyworkIcon,
			uniSegmentedControl,
			zyworkNoData,
			uniTag,
			zyworkFab
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				urls: {
					builderUrl: '/UserBuilder/user/list-page',
					builderReqUrl: '/UserBuilderReq/user/list-page',
					aptitudeUrl: '/UserAptitudeTransfer/user/list-page',
					carpoolUrl: '/UserMarkCarpool/user/list-page',
					seekcarUrl: '/UserMarkSeekcar/user/list-page',
					recruitUrl: '/UserRecruit/user/list-page',
					seekDataUrl: '/UserSeekData/user/list-page',
					updateNoticeUrl: '/update-notice/user/list-page',
					guaranteeUrl: '/UserGuarantee/any/list-page'
				},
				pager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0
				},
				defaultIcon: DEFAULT_HEADICON,
				infoType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [
						{
							id: 'notice',
							name: '通知公告'
						},
						{
							id: 'aptitude',
							name: '资质转让'
						},
						{
							id: 'guarantee',
							name: '申请保函'
						},
						{
							id: 'builder',
							name: '建造师'
						},
						{
							id: 'material',
							name: '求带资料'
						},
						{
							id: 'carPool',
							name: '开标拼车'
						},
						{
							id: 'hire',
							name: '岗位招聘'
						}
					]
				},
				builderOpts: {
					current: 0,
					items: builderTypeArray
				},
				aptitudeOpts: {
					current: 0,
					items: aptitudeTypeArray
				},
				carPoolOpts: {
					current: 0,
					items: openMarkArray
				},
				builderReqList: [],
				builderList: [],
				aptitudeBuyList: [],
				aptitudeSellList: [],
				carpoolList: [],
				seekcarList: [],
				recruitList: [],
				seekDataList: [],
				updateNoticeList: [],
				guaranteeList: [],
				addPublish: false,
				directionStr: '垂直',
				horizontal: 'right',
				vertical: 'bottom',
				direction: 'horizontal',
				iconType: 'uni-icon-plusempty',
				pattern: {
					color: '#7A7E83',
					backgroundColor: '#fff',
					selectedColor: '#007AFF',
					buttonColor: '#007AFF'
				},
			}
		},
		onLoad() {
			this.initData('init');
		},
		onPullDownRefresh() {
			this.pager.pageNo = 1
			this.initData('pullDown')
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			this.initData('reachBottom')
		},
		onShareAppMessage(res) {
			var shareCode = getShareCode();
			return {
				title: '江西招投标平台信息共享',
				path: '/pages/project-info/project-info?shareCode=' + shareCode,
				imageUrl: SHARE_CODE_PAGE_IMG
			}
		},
		methods: {
			/** 初始化数据 */
			initData(type) {
				// if (isUserIdExist()) {
					this.checkRefresh(this.infoType.tabIndex, type);
				// } else {
				// 	notLoginToUserCenter();
				// }
			},
			/** 初始化查询数据 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			/** 公共的请求部分 */
			commonRequest(url, type) {
				uni.showLoading({
					title: '加载中'
				})
				infoShare.getListInfoToPost(this, url, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.requestSuccess(this.infoType.tabIndex, type, res.data.data.rows);
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新建造师需求列表 */
			refreshBuilderReqList(type) {
				this.commonRequest(this.urls.builderReqUrl, type);
			},
			/** 刷新建造师列表 */
			refreshBuilderList(type) {
				this.commonRequest(this.urls.builderUrl, type);
			},
			/** 刷新资质转让列表 */
			refreshAptitudeList(type) {
				this.pager.aptitudeTransferType = this.aptitudeOpts.current;
				this.commonRequest(this.urls.aptitudeUrl, type);
			},
			/** 刷新开标拼车列表 */
			refreshCarpoolList(type) {
				this.commonRequest(this.urls.carpoolUrl, type);
			},
			/** 刷新开标找车列表 */
			refreshSeekcarList(type) {
				this.commonRequest(this.urls.seekcarUrl, type);
			},
			/** 刷新其他招聘列表 */
			refreshRecruitList(type) {
				this.commonRequest(this.urls.recruitUrl, type);
			},
			/** 刷新求带资料列表 */
			refreshSeekDataList(type) {
				this.commonRequest(this.urls.seekDataUrl, type);
			},
			/** 刷新更新公告列表 */
			refreshUpdateNoticeList(type) {
				this.commonRequest(this.urls.updateNoticeUrl, type);
			},
			/** 刷新申请保函列表 */
			refreshGuaranteeList(type) {
				this.commonRequest(this.urls.guaranteeUrl, type);
			},
			/** 
			 * 请求成功之后的操作 
			 * @param tabIndex 当前选择的类型
			 * @param type 刷新的类型：init、pullDown、reachBottom
			 * @param rows 请求到的数据
			 */
			requestSuccess(tabIndex, type, rows) {
				if (type === 'init') {
					this.setListValue(tabIndex, rows, 'use');
				} else if (type === 'pullDown') {
					this.setListValue(tabIndex, rows, 'use');
					uni.stopPullDownRefresh()
					this.showLoadMore = false
					this.loadMoreText = '加载中...'
				} else if (type === 'reachBottom') {
					if (rows.length > 0) {
						this.setListValue(tabIndex, rows, 'add');
						this.loadMoreText = '加载更多'
					} else {
						this.loadMoreText = '已加载全部'
					}
				}
			},
			/**
			 * 设置list的值
			 * @param {Object} tabIndex 当前选择的类型
			 * @param {Object} rows 刷新的类型：init、pullDown、reachBottom
			 * @param {Object} type 是赋值还是追加数据：use、add
			 */
			setListValue(tabIndex, rows, type) {
				rows = nullToStr(rows)
				if (INFO_BUILDER === tabIndex) {
					// 建造师
					if (this.builderOpts.current === 0) {
						if (type === 'add') {
							this.builderReqList = this.builderReqList.concat(rows);
						} else {
							this.builderReqList = rows;
						}
					} else {
						if (type === 'add') {
							this.builderList = this.builderList.concat(rows);
						} else {
							this.builderList = rows;
						}
					}
				} else if (INFO_APTITUDE === tabIndex) {
					// 资质转让
					if (this.aptitudeOpts.current === 0) {
						if (type === 'add') {
							this.aptitudeBuyList = this.aptitudeBuyList.concat(rows);
						} else {
							this.aptitudeBuyList = rows;
						}
					} else {
						if (type === 'add') {
							this.aptitudeSellList = this.aptitudeSellList.concat(rows);
						} else {
							this.aptitudeSellList = rows;
						}
					}
				} else if (INFO_CARPOOL === tabIndex) {
					// 开标拼车
					if (this.carPoolOpts.current === 0) {
						if (type === 'add') {
							this.carpoolList = this.carpoolList.concat(rows);
						} else {
							this.carpoolList = rows;
						}
					} else {
						if (type === 'add') {
							this.seekcarList = this.seekcarList.concat(rows);
						} else {
							this.seekcarList = rows;
						}
					}
				} else if (INFO_HIRE === tabIndex) {
					// 其他岗位招聘
					if (type === 'add') {
						this.recruitList = this.recruitList.concat(rows);
					} else {
						this.recruitList = rows;
					}
				} else if (INFO_MATERIAL === tabIndex) {
					// 求带资料
					if (type === 'add') {
						this.seekDataList = this.seekDataList.concat(rows);
					} else {
						this.seekDataList = rows;
					}
				} else if (INFO_NOTICE === tabIndex) {
					// 更新公告
					if (type === 'add') {
						this.updateNoticeList = this.updateNoticeList.concat(rows);
					} else {
						this.updateNoticeList = rows;
					}
				} else if (INFO_GUARANTEE === tabIndex) {
					// 申请保函
					if (type === 'add') {
						this.guaranteeList = this.guaranteeList.concat(rows);
					} else {
						this.guaranteeList = rows;
					}
				}
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
				if (this.infoType.tabIndex === tabIndex) {
					return false
				} else {
					this.initPager();
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.infoType.scrollLeft = tabBarScrollLeft
					this.infoType.tabIndex = tabIndex
					this.checkRefresh(tabIndex, 'init')
					this.addPublish = true
					if (INFO_NOTICE === tabIndex) {
						// 更新公告
						this.addPublish = false
					}
				}
			},
			/** 检查刷新 */
			checkRefresh(tabIndex, type) {
				if (INFO_BUILDER === tabIndex) {
					// 建造师
					if (this.builderOpts.current === 0) {
						this.refreshBuilderReqList(type);
					} else {
						this.refreshBuilderList(type);
					}
				} else if (INFO_APTITUDE === tabIndex) {
					// 资质转让
					this.refreshAptitudeList(type);
				} else if (INFO_CARPOOL === tabIndex) {
					// 开标拼车
					if (this.carPoolOpts.current === 0) {
						this.refreshCarpoolList(type);
					} else {
						this.refreshSeekcarList(type);
					}
				} else if (INFO_HIRE === tabIndex) {
					// 其他岗位招聘
					this.refreshRecruitList(type);
				} else if (INFO_MATERIAL === tabIndex) {
					// 求带资料
					this.refreshSeekDataList(type);
				} else if (INFO_NOTICE === tabIndex) {
					// 更新公告
					this.refreshUpdateNoticeList(type);
				} else if (INFO_GUARANTEE === tabIndex) {
					// 申请保函
					this.refreshGuaranteeList(type);
				}
			},
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-info-share/search-page/search-page'
				})
			},
			toPublishChoose(type) {
				const loginFlag = uni.getStorageSync(LOGIN_FLAG);
				if (!loginFlag) {
					uni.navigateTo({
						url: '/pages-static/no-login/no-login'
					})
					return;
				}
				var url = '/pages-info-share/publish-choose/publish-choose';
				if (type === 1) {
					var tabIndex = this.infoType.tabIndex
					// 大按钮
					if (INFO_BUILDER === tabIndex) {
						// 建造师
						url = '/pages-info-share/publish-builder/publish-builder?itemData=' + encodeURIComponent(this.builderOpts.current)
					} else if (INFO_APTITUDE === tabIndex) {
						// 资质转让
						url = '/pages-info-share/publish-aptitude/publish-aptitude?itemData=' + encodeURIComponent(this.aptitudeOpts.current)
					} else if (INFO_CARPOOL === tabIndex) {
						// 开标拼车
						url = '/pages-info-share/publish-carpool/publish-carpool?itemData=' + encodeURIComponent(this.carPoolOpts.current)
					} else if (INFO_HIRE === tabIndex) {
						// 其他岗位招聘
						url = '/pages-info-share/publish-hire/publish-hire'
					} else if (INFO_MATERIAL === tabIndex) {
						// 求带资料
						url = '/pages-info-share/publish-material/publish-material'
					} else if (INFO_GUARANTEE === tabIndex) {
						// 申请保函
						url = '/pages-info-share/publish-guarantee/publish-guarantee'
					}
				}
				uni.navigateTo({
					url: url
				});
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-info-share/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往建造师需求详情页面 */
			toBuilderReqDetailPage(item) {
				this.toDetailPage('builder-req', item);
			},
			/** 前往建造师应聘详情页面 */
			toBuilderDetailPage(item) {
				this.toDetailPage('builder', item);
			},
			/** 前往资质转让详情页面 */
			toAptitudeDetailPage(item) {
				this.toDetailPage('aptitude', item);
			},
			/** 前往拼车详情页面 */
			toCarpoolDetailPage(item) {
				this.toDetailPage('carpool', item);
			},
			/** 前往找车详情页面 */
			toSeekcarDetailPage(item) {
				this.toDetailPage('seekcar', item);
			},
			/** 前往其他岗位招聘详情页面 */
			toRecruitDetailPage(item) {
				this.toDetailPage('recruit', item);
			},
			/** 前往求带资料详情页面 */
			toSeekDataDetailPage(item) {
				this.toDetailPage('seek-data', item);
			},
			/** 前往公告更新详情页面 */
			toUpdateNoticeDetailPage(item) {
				this.toDetailPage('update-notice', item);
			},
			/** 前往申请保函详情页面 */
			toGuaranteeDetailPage(item) {
				// this.toDetailPage('guarantee', item);
			},
			/** 点击我要拼车，增加拼车记录 */
			addCarpoolRecord(item) {
				const loginFlag = uni.getStorageSync(LOGIN_FLAG);
				if (!loginFlag) {
					uni.navigateTo({
						url: '/pages-static/no-login/no-login'
					})
					return;
				}
				if (item.markCarpoolRecordCount >= item.markCarpoolPeopleCount) {
					showInfoToast('人数已满，不能申请')
					return;
				}
				// 调用接口保存拼车记录
				infoShare.saveMarkCarpoolRecord(this, item.markCarpoolId);
			},
			/** 点击我有车，增加找车记录 */
			addSeekcarRecord(item) {
				const loginFlag = uni.getStorageSync(LOGIN_FLAG);
				if (!loginFlag) {
					uni.navigateTo({
						url: '/pages-static/no-login/no-login'
					})
					return;
				}
				if (item.markSeekcarRecordCount >= 1) {
					showInfoToast('人数已满，不能申请')
					return;
				}
				// 调用接口保存找车记录
				infoShare.saveMarkSeekcarRecord(this, item.markSeekcarId);
			},
			/** 建造师分段器选择器 */
			onClickBuilderItem(index) {
				if (this.builderOpts.current !== index) {
					this.initPager()
					this.builderOpts.current = index
					this.checkRefresh(this.infoType.tabIndex, 'init')
				}
			},
			/** 资质转让分段器选择器 */
			onClickAptitudeItem(index) {
				this.initPager()
				if (this.aptitudeOpts.current !== index) {
					this.aptitudeOpts.current = index
					this.checkRefresh(this.infoType.tabIndex, 'init')
				}
			},
			/** 开标拼车分段器选择器 */
			onClickCarPoolItem(index) {
				this.initPager()
				if (this.carPoolOpts.current !== index) {
					this.carPoolOpts.current = index
					this.checkRefresh(this.infoType.tabIndex, 'init')
				}
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-icon view {
		line-height: 1.0;
	}
</style>
