<template>
	<view>
		<!-- 信息共享搜索 -->
		<view class="zy-disable-flex zy-search-page-bar">
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun" />
				<input type="text" v-model="searchVal" :focus="true" placeholder="输入关键字搜索" @confirm="searchData" />
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

			<view class="zy-history-record">
				<text v-for="(oldKey, index) in oldKeywordList" @click="doSearch(oldKey)" :key="index">{{oldKey}}</text>
			</view>
		</view>
		<view v-else>
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
					<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
					 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
				</scroll-view>
			</view>

			<view>
				<!-- 建造师 -->
				<view v-if="infoType.tabIndex === 0">
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
											<image v-if="item.headicon !== null && item.headicon !== undefined" class="zy-page-mini-headicon" :src="item.headicon" />
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
											<view class="zy-text-big zy-text-bold">建筑工程</view>
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
											<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											 :src="item.userDetailHeadicon" />
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
											<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											 :src="item.userDetailHeadicon" />
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
											<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											 :src="item.userDetailHeadicon" />
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
				<view v-if="infoType.tabIndex === 2">
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
											<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											 :src="item.userDetailHeadicon" />
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
											<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
											 :src="item.userDetailHeadicon" />
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
				<view v-if="infoType.tabIndex === 3">
					<view class="zy-page-list-item" style="padding-top: 10upx;">
						<!-- 其他岗位招聘信息 -->
						<view class="zy-page-list" v-if="recruitList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in recruitList" :key="index">
								<view @click="toRecruitDetailPage(item)">
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
										<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
										 :src="item.userDetailHeadicon" />
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
												<zywork-icon v-if="item.seekDataIsUrgent === 0" type="iconjinjidingdan" color="#dd524d" size="20" />
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
		builderTypeArray,
		aptitudeTypeArray,
		openMarkArray,
		hireArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON,
		showInfoToast
	} from '@/common/util.js'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as infoShare from '@/common/info-share.js'

	const INFO_BUILDER = 0
	const INFO_APTITUDE = 1
	const INFO_CARPOOL = 2
	const INFO_HIRE = 3
	const INFO_MATERIAL = 4

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
				urls: {
					builderUrl: '/UserBuilder/any/list-page',
					builderReqUrl: '/UserBuilderReq/any/list-page',
					aptitudeUrl: '/UserAptitudeTransfer/any/list-page',
					carpoolUrl: '/UserMarkCarpool/any/list-page',
					seekcarUrl: '/UserMarkSeekcar/any/list-page',
					recruitUrl: '/UserRecruit/any/list-page',
					seekDataUrl: '/UserSeekData/any/list-page'
				},
				pager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0
				},
				defaultIcon: DEFAULT_HEADICON,
				searchVal: '',
				oldKeywordList: [],
				isShowHistroy: true,
				infoType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [{
							id: 'builder',
							name: '建造师'
						},
						{
							id: 'aptitude',
							name: '资质转让'
						},
						{
							id: 'carPool',
							name: '开标拼车'
						},
						{
							id: 'hire',
							name: '岗位招聘'
						},
						{
							id: 'material',
							name: '求带资料'
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
				seekDataList: []
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
				this.isShowHistroy = false;
				this.saveKeyword(this.searchVal);
				this.searchCheck(this.infoType.tabIndex);
			},
			/** 保存关键字到历史记录 */
			saveKeyword(keyword) {
				uni.getStorage({
					key: 'InfoShareOldKeys',
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
							key: 'InfoShareOldKeys',
							data: JSON.stringify(OldKeys)
						});
						this.oldKeywordList = OldKeys; //更新历史搜索
					},
					fail: (e) => {
						var OldKeys = [keyword];
						uni.setStorage({
							key: 'InfoShareOldKeys',
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
								key: 'InfoShareOldKeys'
							});
						} else if (res.cancel) {}
					}
				});
			},
			/** 加载历史搜索,自动读取本地Storage */
			loadOldKeyword() {
				uni.getStorage({
					key: 'InfoShareOldKeys',
					success: (res) => {
						var OldKeys = JSON.parse(res.data);
						this.oldKeywordList = OldKeys;
					}
				});
			},
			/** 刷新建造师需求列表 */
			refreshBuilderReqList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.builderReqCompName = this.searchVal;
				} else {
					this.pager.builderCertificateMajorType = '';
				}
				infoShare.getListInfoToPost(this, this.urls.builderReqUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.builderReqList = res.data.data.rows;
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新建造师列表 */
			refreshBuilderList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.builderCertificateMajorType = this.searchVal;
				} else {
					this.pager.builderCertificateMajorType = '';
				}
				infoShare.getListInfoToPost(this, this.urls.builderUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.builderList = res.data.data.rows;
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新资质转让列表 */
			refreshAptitudeList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.aptitudeTransferTitle = this.searchVal;
				} else {
					this.pager.aptitudeTransferTitle = ''
				}
				this.pager.aptitudeTransferType = this.aptitudeOpts.current;
				infoShare.getListInfoToPost(this, this.urls.aptitudeUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							if (this.aptitudeOpts.current === 0) {
								// 求购
								this.aptitudeBuyList = res.data.data.rows;
							} else {
								// 转让
								this.aptitudeSellList = res.data.data.rows;
							}
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新开标拼车列表 */
			refreshCarpoolList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.markCarpoolCarType = this.searchVal;
				} else {
					this.pager.markCarpoolCarType = ''
				}
				infoShare.getListInfoToPost(this, this.urls.carpoolUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.carpoolList = res.data.data.rows;
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新开标找车列表 */
			refreshSeekcarList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.markSeekcarMemo = this.searchVal;
				} else {
					this.pager.markSeekcarMemo = ''
				}
				infoShare.getListInfoToPost(this, this.urls.seekcarUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.seekcarList = res.data.data.rows;
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新其他招聘列表 */
			refreshRecruitList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.recruitJobTitle = this.searchVal;
				} else {
					this.pager.recruitJobTitle = ''
				}
				infoShare.getListInfoToPost(this, this.urls.recruitUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.recruitList = res.data.data.rows;
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新求带资料列表 */
			refreshSeekDataList() {
				uni.showLoading({
					title: '加载中'
				})
				if (this.searchVal != null && this.searchVal != '') {
					this.pager.seekDataStartAddr = this.searchVal;
				} else {
					this.pager.seekDataStartAddr = ''
				}
				infoShare.getListInfoToPost(this, this.urls.seekDataUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.seekDataList = res.data.data.rows;
						} else {
							showInfoToast(res.data.message)
						}
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
				if (this.infoType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.infoType.scrollLeft = tabBarScrollLeft
					this.infoType.tabIndex = tabIndex
					this.searchCheck(tabIndex);
				}
			},
			/** 搜索判断 */
			searchCheck(tabIndex) {
				if (INFO_BUILDER === tabIndex) {
					// 建造师
					if (this.builderOpts.current === 0) {
						this.refreshBuilderReqList();
					} else {
						this.refreshBuilderList();
					}
				} else if (INFO_APTITUDE === tabIndex) {
					// 资质转让
					this.refreshAptitudeList();
				} else if (INFO_CARPOOL === tabIndex) {
					// 开标拼车
					if (this.carPoolOpts.current === 0) {
						this.refreshCarpoolList();
					} else {
						this.refreshSeekcarList();
					}
				} else if (INFO_HIRE === tabIndex) {
					// 其他岗位招聘
					this.refreshRecruitList();
				} else if (INFO_MATERIAL === tabIndex) {
					// 求带资料
					this.refreshSeekDataList();
				}
			},
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-info-share/search-page/search-page'
				})
			},
			toPublishChoose() {
				uni.navigateTo({
					url: '/pages-info-share/publish-choose/publish-choose'
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
			/** 建造师分段器选择器 */
			onClickBuilderItem(index) {
				if (this.builderOpts.current !== index) {
					this.builderOpts.current = index
					if (index === 0) {
						this.refreshBuilderReqList();
					} else {
						this.refreshBuilderList();
					}
				}
			},
			/** 资质转让分段器选择器 */
			onClickAptitudeItem(index) {
				if (this.aptitudeOpts.current !== index) {
					this.aptitudeOpts.current = index
					this.refreshAptitudeList();
				}
			},
			/** 开标拼车分段器选择器 */
			onClickCarPoolItem(index) {
				if (this.carPoolOpts.current !== index) {
					this.carPoolOpts.current = index
					if (index === 0) {
						this.refreshCarpoolList();
					} else {
						this.refreshSeekcarList();
					}
				}
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	page {
		background-color: $primary-backcolor;
	}

	.zy-icon view {
		line-height: 1.0;
	}
</style>
