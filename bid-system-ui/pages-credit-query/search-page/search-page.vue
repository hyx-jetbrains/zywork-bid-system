<template>
	<view>
		<!-- 征信查询搜索 -->
		<view class="zy-disable-flex zy-search-page-bar">
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun" />
				<input type="text" v-model="searchVal" :focus="true" :placeholder="keywordMemo" @confirm="searchData" />
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
			<view style="height: 10upx; background-color: #F8F8F8;"></view>

			<!-- 企业信息 -->
			<view v-if="infoType.tabIndex === 0">
				<view class="zy-page-list zy-page-card" v-if="companyList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in companyList" :key="index">
						<view @click="toCompanyDetail(item)">
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconqiyejianjie" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<view>
										<text class="zy-text-bold">{{item.compName}}</text>
									</view>
									<view class="zy-text-mini zy-text-info">
										法人：
										<text v-if="item.legalPerson !== ''" class="zy-text-mini zy-text-info">
											{{item.legalPerson}}
										</text>
										<text v-else class="zy-text-mini zy-text-info">
											暂无
										</text>
									</view>
								</view>
								<view class="zy-disable-flex-right" style="width: 38%; margin-right: 0upx;">
									<view>
										<uni-tag :text="item.compType" type="primary" size="small" :inverted="true" :circle="true" style="margin-right: 20upx;"></uni-tag>
										<uni-tag v-if="item.jurisdictionType === 0" text="省内" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
										<uni-tag v-else text="省外" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
									</view>
									<view v-html="space"></view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-page-item-row zy-disable-flex">
									<view class="zy-text-info">
										<text class="zy-text-info zy-text-bold">
											行业分类：
										</text>
										<text v-if="item.industryType != null && item.industryType != '' && item.industryType != undefined" class="zy-text-info">
											{{item.industryType}}
										</text>
										<text v-else class="zy-text-info">
											暂无
										</text>
									</view>
									<view class="zy-text-info">
										<text class="zy-text-info zy-text-bold">
											单位电话：
										</text>
										<text v-if="item.compPhone != ''" class="zy-text-info zy-detail-phone" @click="callPhone(item.compPhone)">
											{{item.compPhone}}
										</text>
										<text v-else class="zy-text-info">
											暂无
										</text>
									</view>
								</view>
								<view>
									<view class="zy-text-info zy-text-bold">联系地址:</view>
									<view v-if="item.compAddr != null && item.compAddr != '' && item.compAddr != undefined" class="zy-text-info">
										{{item.compAddr}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无企业信息"></zywork-no-data>
			</view>

			<!-- 业绩信息 -->
			<view v-if="infoType.tabIndex === 1">
				<!-- <view class="zy-uni-segmented-control">
				<uni-segmented-control :current="achievementOpts.current" :values="achievementOpts.items" v-on:clickItem="onClickAchievementItem"
					styleType="button" activeColor="#108EE9"></uni-segmented-control>
			</view> -->
				<view class="zy-disable-flex zy-achievement-type">
					<view class="zy-type-title zy-text-bold">选择业绩类别</view>
					<view class="zy-disable-flex-right">
						<view class="uni-list-cell-db">
							<picker @change="onClickAchievementItem" :value="achievementOpts.current" :range="achievementOpts.items">
								<view class="zy-disable-flex">
									<text>{{achievementOpts.items[achievementOpts.current]}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
				</view>
				<view class="zy-page-list zy-page-card" v-if="achievementList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in achievementList" :key="index">
						<view @click="toAchievementDetail(item)">
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<view>
										<text class="zy-text-bold">{{item.projectName}}</text>
									</view>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.createTime}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view v-if="achievementOpts.current == 0">
								<!-- 房建业绩 -->
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">注册建造师:</view>
									<view v-if="item.builderName != ''" class="zy-text-info">
										{{item.builderName}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目负责人:</view>
									<view v-if="item.name != ''" class="zy-text-info">
										{{item.name}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">建设单位:</view>
									<view v-if="item.buildComp != ''" class="zy-text-info">
										{{item.buildComp}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 4">
								<!-- 水利监理业绩 -->
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目类型:</view>
									<view v-if="item.projectType != ''" @click="validText(item.projectType)" class="zy-text-info" :class="item.projectType === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.projectType}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.contractAmount != ''" @click="validText(item.contractAmount)" class="zy-text-info" :class="item.contractAmount === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.contractAmount === '请购买VIP服务' ? item.contractAmount : item.contractAmount / 100}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">开工时间:</view>
									<view v-if="item.startDate != null && item.startDate != '' && item.startDate != undefined" class="zy-text-info">
										{{item.startDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 5">
								<!-- 水利勘查设计业绩 -->
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目类型:</view>
									<view v-if="item.tenderingComp != ''" @click="validText(item.tenderingComp)" class="zy-text-info" :class="item.tenderingComp === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.tenderingComp}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.contractAmount != ''" @click="validText(item.contractAmount)" class="zy-text-info" :class="item.contractAmount === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.contractAmount === '请购买VIP服务' ? item.contractAmount : item.contractAmount / 100}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目负责人:</view>
									<view v-if="item.name != null && item.name != '' && item.name != undefined" class="zy-text-info">
										{{item.name}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else>
								<!-- 水利业绩和交通业绩和重点工程 -->
								<view v-if="achievementOpts.current == 3" class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">中标金额:</view>
									<view v-if="item.markMoney != ''" @click="validText(item.markMoney)" class="zy-text-info" :class="item.markMoney === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.markMoney === '请购买VIP服务' ? item.markMoney : item.markMoney / 100}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view v-else class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.contractAmount != ''" @click="validText(item.contractAmount)" class="zy-text-info" :class="item.contractAmount === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.contractAmount === '请购买VIP服务' ? item.contractAmount : item.contractAmount / 100}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">开工时间:</view>
									<view v-if="item.startDate != null && item.startDate != '' && item.startDate != undefined" class="zy-text-info">
										{{item.startDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">竣工时间:</view>
									<view v-if="item.endDate != null && item.endDate != '' && item.endDate != undefined" class="zy-text-info">
										{{item.endDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无企业业绩信息"></zywork-no-data>
			</view>

			<!-- 建造师信息 -->
			<view v-if="infoType.tabIndex === 2">
				<view class="zy-page-list zy-page-card" v-if="builderList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in builderList" :key="index">
						<view @click="toCompanyDetail(item.compBuilderCompId, 1)">
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconjiaozaoshi" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<view class="zy-disable-flex">
										<text class="zy-text-bold" style="margin-right: 20upx;">{{item.compBuilderName}}</text>
										<zywork-icon v-if="item.compBuilderGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
										<zywork-icon v-else-if="item.compBuilderGender === 1" type="iconnan" color="#108EE9" size="20" />
										<zywork-icon v-else-if="item.compBuilderGender === 2" type="iconnv" color="#dd524d" size="20" />
									</view>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.companyCompName}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">注册证件号码:</view>
									<view v-if="item.compBuilderRegNum != null && item.compBuilderRegNum != '' && item.compBuilderRegNum != undefined"
									 class="zy-text-info">
										{{item.compBuilderRegNum}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">专业等级:</view>
									<view v-if="item.compBUilderMajorLevel != null && item.compBUilderMajorLevel != '' && item.compBUilderMajorLevel != undefined"
									 class="zy-text-info">
										{{item.compBUilderMajorLevel}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无企业建造师信息"></zywork-no-data>
			</view>

			<!-- 资质信息 -->
			<view v-if="infoType.tabIndex === 3">
				<view class="zy-page-list zy-page-card" v-if="aptitudeList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in aptitudeList" :key="index">
						<view @click="toCompanyDetail(item.compAptitudeCompId, 2)">
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconrongyu" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<text class="zy-text-bold">企业资质</text>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.companyCompName}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">证件号码:</view>
									<view v-if="item.compAptitudeCertificateNum != ''" @click="validText(item.compAptitudeCertificateNum)" class="zy-text-info"
									 :class="item.compAptitudeCertificateNum === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.compAptitudeCertificateNum}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">资质详情:</view>
									<view v-if="item.compAptitudeCertificateDetail != ''" @click="validText(item.compAptitudeCertificateDetail)"
									 class="zy-text-info" :class="item.compAptitudeCertificateDetail === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.compAptitudeCertificateDetail}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无企业资质信息"></zywork-no-data>
			</view>

			<!-- 中标记录 -->
			<view v-if="infoType.tabIndex === 4">
				<view class="zy-page-list zy-page-card" v-if="projectAnnounceList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in projectAnnounceList" :key="index">
						<view>
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconzhongbiao" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<text class="zy-text-bold">{{item.projectTitle}}</text>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.projectAnnounceCreateTime}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">第一中标人:</view>
									<view v-if="item.projectAnnounceFirstCandidate !== ''" class="zy-text-info" @click="validText(item.projectAnnounceFirstCandidate)"
									 :class="item.projectAnnounceFirstCandidate === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.projectAnnounceFirstCandidate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">建造师:</view>
									<view v-if="item.projectAnnounceFirstBuilderName !== ''" class="zy-text-info" @click="validText(item.projectAnnounceFirstBuilderName)"
									 :class="item.projectAnnounceFirstBuilderName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.projectAnnounceFirstBuilderName}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">中标金额:</view>
									<view v-if="item.projectAnnounceFirstMarkMoney !== ''" class="zy-text-info" @click="validText(item.projectAnnounceFirstMarkMoney)"
									 :class="item.projectAnnounceFirstMarkMoney === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.projectAnnounceFirstMarkMoney}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无中标记录"></zywork-no-data>
			</view>
		</view>

		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {
		showInfoToast,
		callPhone,
		validText
	} from '@/common/util.js'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as creditQuery from '@/common/credit-query.js'
	import {
		achievementTypeArray
	} from '@/common/picker.data.js'

	/** 企业信息 */
	const INFO_COMPANY = 0
	/** 业绩信息 */
	const INFO_ACHIEVEMENT = 1
	/** 企业建造师信息 */
	const INFO_BUILDER = 2
	/** 企业资质信息 */
	const INFO_APTITUDE = 3
	/** 中标记录 */
	const INFO_MARK = 4

	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
			uniTag
		},
		data() {
			return {
				loadMoreText: "加载中...",
				showLoadMore: false,
				keywordMemo: '输入企业名称关键字搜索',
				searchVal: '',
				oldKeywordList: [],
				isShowHistroy: true,
				space: '&#12288;',
				infoType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [{
							id: 'company',
							name: '查企业'
						},
						{
							id: 'achievement',
							name: '查业绩'
						},
						{
							id: 'builder',
							name: '查建造师'
						},
						{
							id: 'aptitude',
							name: '查资质'
						},
						{
							id: 'mark',
							name: '中标记录'
						}
					]
				},
				urls: {
					companyUrl: '/company/user/pager-cond',
					houseAchievementUrl: '/comp-house-achievement/user/pager-cond',
					waterAchievementUrl: '/comp-water-achievement/user/pager-cond',
					trafficAchievementUrl: '/comp-traffic-achievement/user/pager-cond',
					keyProjectAchievementUrl: '/comp-key-projecachievement/user/pager-cond',
					waterMonitorAchievementUrl: '/comp-water-monitor-achievement/user/pager-cond',
					waterDeviseAchievementUrl: '/comp-water-devise-achievement/user/pager-cond',
					builderUrl: '/CompBuilderCompany/any/pager-cond',
					aptitudeUrl: '/CompAptitudeCompany/user/pager-cond',
					projectAnnounceUrl: '/ProjectAnnounceProject/user/pager-cond',
				},
				pager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					compBuilderIsActive: 0,
					compAptitudeIsActive: 0
				},
				companyList: [],
				achievementList: [],
				builderList: [],
				aptitudeList: [],
				projectAnnounceList: [],
				achievementOpts: {
					current: 0,
					items: achievementTypeArray
				}
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.initData();
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			this.checkRefresh(this.infoType.tabIndex, 'reachBottom');
		},
		methods: {
			/** 初始化数据 */
			initData() {
				// 加载历史搜索数据
				this.loadOldKeyword();
			},
			/** 初始化查询数据 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
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
				this.checkRefresh(this.infoType.tabIndex, 'init');
			},
			/** 保存关键字到历史记录 */
			saveKeyword(keyword) {
				uni.getStorage({
					key: 'creditQueryOldKeys',
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
							key: 'creditQueryOldKeys',
							data: JSON.stringify(OldKeys)
						});
						this.oldKeywordList = OldKeys; //更新历史搜索
					},
					fail: (e) => {
						var OldKeys = [keyword];
						uni.setStorage({
							key: 'creditQueryOldKeys',
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
								key: 'creditQueryOldKeys'
							});
						} else if (res.cancel) {}
					}
				});
			},
			/** 加载历史搜索,自动读取本地Storage */
			loadOldKeyword() {
				uni.getStorage({
					key: 'creditQueryOldKeys',
					success: (res) => {
						var OldKeys = JSON.parse(res.data);
						this.oldKeywordList = OldKeys;
					}
				});
			},
			/** 查看企业详情 */
			toCompanyDetail(item, type) {
				if (type !== 0) {
					creditQuery.getOneById(this, '/company/any/one/', item)
						.then(data => {
							var [error, res] = data;
							if (res.data.code === ResponseStatus.OK) {
								item = res.data.data
								item.tabIndex = type
								uni.navigateTo({
									url: '/pages-credit-query/company-detail/company-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
								})
							} else {
								showInfoToast(res.data.message)
							}
						})
				} else {
					// 从企业信息点进来的
					item.tabIndex = type
					uni.navigateTo({
						url: '/pages-credit-query/company-detail/company-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
					})
				}
			},
			/** 查看企业业绩详情 */
			toAchievementDetail(item) {
				item.achievementType = this.achievementOpts.current;
				uni.navigateTo({
					url: '/pages-credit-query/company-achievement-detail/company-achievement-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
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
					this.initPager();
					this.checkRefresh(tabIndex, 'init');
				}
			},
			/** 刷新企业信息列表 */
			refreshCompanyList(type) {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.companyUrl, this.pager)
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
			/** 刷新业绩信息列表 */
			refreshAchievementList(index, type) {
				var url = '';
				if (index == 0) {
					// 房屋业绩
					url = this.urls.houseAchievementUrl;
				} else if (index == 1) {
					// 水利业绩
					url = this.urls.waterAchievementUrl;
				} else if (index == 2) {
					// 交通业绩
					url = this.urls.trafficAchievementUrl;
				} else if (index == 3) {
					// 重点工程业绩
					url = this.urls.keyProjectAchievementUrl;
				} else if (index == 4) {
					// 水利监理业绩
					url = this.urls.waterMonitorAchievementUrl;
				} else if (index == 5) {
					// 水利勘查设计业绩
					url = this.urls.waterDeviseAchievementUrl;
				} else {
					showInfoToast('查询错误')
					return;
				}
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, url, this.pager)
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
			/** 刷新企业建造师信息列表 */
			refreshBuilderList(type) {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.builderUrl, this.pager)
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
			/** 刷新企业资质信息列表 */
			refreshAptitudeList(type) {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.aptitudeUrl, this.pager)
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
			/** 刷新中标记录列表 */
			refreshProjectAnnounceList(type) {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.projectAnnounceUrl, this.pager)
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
				if (INFO_COMPANY === tabIndex) {
					// 企业信息
					if (type === 'add') {
						this.companyList = this.companyList.concat(rows);
					} else {
						this.companyList = rows;
					}
				} else if (INFO_ACHIEVEMENT === tabIndex) {
					// 业绩信息
					if (type === 'add') {
						this.achievementList = this.achievementList.concat(rows);
					} else {
						this.achievementList = rows;
					}

				} else if (INFO_BUILDER === tabIndex) {
					// 企业建造师信息
					if (type === 'add') {
						this.builderList = this.builderList.concat(rows);
					} else {
						this.builderList = rows;
					}
				} else if (INFO_APTITUDE === tabIndex) {
					// 企业资质信息
					if (type === 'add') {
						this.aptitudeList = this.aptitudeList.concat(rows);
					} else {
						this.aptitudeList = rows;
					}
				} else if (INFO_MARK === tabIndex) {
					// 中标记录
					if (type === 'add') {
						this.projectAnnounceList = this.projectAnnounceList.concat(rows);
					} else {
						this.projectAnnounceList = rows;
					}
				}
			},
			/** 检查刷新 */
			checkRefresh(tabIndex, type) {
				var tempSearchVal = '';
				if (this.searchVal != null && this.searchVal != '') {
					tempSearchVal = this.searchVal;
				}
				if (INFO_COMPANY === tabIndex) {
					// 企业信息
					this.pager.compName = tempSearchVal;
					this.refreshCompanyList(type);
					this.keywordMemo = '输入企业名称关键字搜索';
				} else if (INFO_ACHIEVEMENT === tabIndex) {
					// 业绩信息
					this.pager.projectName = tempSearchVal;
					this.refreshAchievementList(this.achievementOpts.current, type);
					this.keywordMemo = '输入工程名称关键字搜索';
				} else if (INFO_BUILDER === tabIndex) {
					// 企业建造师信息
					this.pager.name = tempSearchVal;
					this.refreshBuilderList(type);
					this.keywordMemo = '输入建造师姓名关键字搜索';
				} else if (INFO_APTITUDE === tabIndex) {
					// 企业资质信息
					this.pager.certificateDetail = tempSearchVal;
					this.refreshAptitudeList(type);
					this.keywordMemo = '输入资质详情信息关键字搜索';
				} else if (INFO_MARK === tabIndex) {
					// 中标记录
					this.pager.firstCandidate = tempSearchVal;
					this.refreshProjectAnnounceList(type);
					this.keywordMemo = '输入中标单位关键字搜索';
				}
			},
			/** 业绩类型选择器 */
			onClickAchievementItem: function(e) {
				let index = e.target.value
				if (this.achievementOpts.current !== index) {
					this.achievementOpts.current = index
					this.initPager();
					this.checkRefresh(this.infoType.tabIndex, 'init');
				}
			},
			/** 拨打电话 */
			callPhone(phone) {
				callPhone(phone);
			},
			/** 验证文字 */
			validText(text) {
				validText(text);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	page {
		background-color: $primary-backcolor;
	}

	.zy-page-card {
		margin-top: 10upx;
	}

	.zy-content-label {
		margin-right: 20upx;
	}

	.zy-page-item-row view {
		width: 50%;
	}

	.zy-achievement-type {
		background-color: #FFF;
	}
</style>
