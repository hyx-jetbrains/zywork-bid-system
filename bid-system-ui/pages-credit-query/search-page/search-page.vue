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
		<view v-if="isShowHistroy">
			<view class="uni-tab-bar zy-tab-bar zy-disable-flex">
				<view style="width: 90%;">
					<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
						<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
						 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
					</scroll-view>
				</view>
				<view class="zy-disable-flex-right">
					<zywork-icon type="iconwebicon03" size="30" @tap="showSearchDrawer"></zywork-icon>
				</view>
			</view>
			<view v-if="infoType.tabIndex === 0">
				<view class="zy-disable-flex zy-achievement-type">
					<view class="zy-type-title zy-text-bold">选择企业类别</view>
					<view class="zy-disable-flex-right">
						<view class="uni-list-cell-db">
							<picker @change="onClickIndustryItem" :value="industryTypeIndex" :range="industryTypeArray">
								<view class="zy-disable-flex">
									<text>{{industryTypeArray[industryTypeIndex]}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
				</view>
			</view>
			<view class="zy-disable-flex zy-search-page-history-record">
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
			<view class="uni-tab-bar zy-tab-bar zy-disable-flex">
				<view style="width: 90%;">
					<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
						<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
						 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
					</scroll-view>
				</view>
				<view class="zy-disable-flex-right">
					<zywork-icon type="iconwebicon03" size="30" @tap="showSearchDrawer"></zywork-icon>
				</view>
			</view>
			<view style="height: 10upx; background-color: #F8F8F8;"></view>
			<view class="zy-search-result zy-disable-flex">
				<view>
					已找到
					<text class="zy-search-count" v-text="totalCount"></text>
					条相关信息
				</view>
				<view class="zy-disable-flex-right">
					<uni-tag text="已选条件" type="primary" size="small" :inverted="true" :circle="false" style="margin-right: 10upx;"
					 @tap="showSearchDrawer"></uni-tag>
					<uni-tag text="重新查询" type="primary" size="small" :inverted="false" :circle="false" @tap="searchData"></uni-tag>
				</view>
			</view>
			<view style="height: 10upx; background-color: #F8F8F8;"></view>
			<!-- 企业信息 -->
			<view v-if="infoType.tabIndex === 0">
				<view class="zy-disable-flex zy-achievement-type">
					<view class="zy-type-title zy-text-bold">选择企业类别</view>
					<view class="zy-disable-flex-right">
						<view class="uni-list-cell-db">
							<picker @change="onClickIndustryItem" :value="industryTypeIndex" :range="industryTypeArray">
								<view class="zy-disable-flex">
									<text>{{industryTypeArray[industryTypeIndex]}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
				</view>
				<view class="zy-page-list zy-page-card" v-if="companyList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in companyList" :key="index">
						<view>
							<!-- 头部 -->
							<view class="zy-disable-flex" @click="toCompanyDetail(item, 0)">
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
										<uni-tag :text="item.compType" type="primary" size="small" :inverted="true" :circle="true" style="margin-right: 10upx;"></uni-tag>
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
							<view v-if="achievementOpts.current == 0">
								<!-- 房建业绩 -->
								<view class="zy-disable-flex">
									<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
									<view>
										<view>
											<text class="zy-text-bold" @click="validText(item.compHouseAchievementProjectName)" :class="item.compHouseAchievementProjectName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.compHouseAchievementProjectName}}
											</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											<text class="zy-text-mini zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.companyCompName}}
											</text>
										</view>
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">注册建造师:</view>
									<view v-if="item.compHouseAchievementBuilderName != ''" class="zy-text-info">
										{{item.compHouseAchievementBuilderName}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目负责人:</view>
									<view v-if="item.compHouseAchievementName != ''" class="zy-text-info">
										{{item.compHouseAchievementName}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">建设单位:</view>
									<view v-if="item.compHouseAchievementBuildComp != ''" class="zy-text-info">
										{{item.compHouseAchievementBuildComp}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 1">
								<!-- 水利业绩 -->
								<view class="zy-disable-flex">
									<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
									<view>
										<view>
											<text class="zy-text-bold" @click="validText(item.compWaterAchievementProjectName)" :class="item.compWaterAchievementProjectName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.compWaterAchievementProjectName}}
											</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											<text class="zy-text-mini zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.companyCompName}}
											</text>
										</view>
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.compWaterAchievementContractAmount != ''" class="zy-text-info">
										{{item.compWaterAchievementContractAmount}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">开工时间:</view>
									<view v-if="item.compWaterAchievementStartDate != ''" class="zy-text-info">
										{{item.compWaterAchievementStartDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">竣工时间:</view>
									<view v-if="item.compWaterAchievementEndDate != ''" class="zy-text-info">
										{{item.compWaterAchievementEndDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 2">
								<!-- 交通业绩 -->
								<view class="zy-disable-flex">
									<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
									<view>
										<view>
											<text class="zy-text-bold" @click="validText(item.compTrafficAchievementProjectName)" :class="item.compTrafficAchievementProjectName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.compTrafficAchievementProjectName}}
											</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											<text class="zy-text-mini zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.companyCompName}}
											</text>
										</view>
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.compTrafficAchievementContractAmount != ''" class="zy-text-info">
										{{item.compTrafficAchievementContractAmount}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">开工时间:</view>
									<view v-if="item.compTrafficAchievementStartDate != ''" class="zy-text-info">
										{{item.compTrafficAchievementStartDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">竣工时间:</view>
									<view v-if="item.compTrafficAchievementEndDate != ''" class="zy-text-info">
										{{item.compTrafficAchievementEndDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 3">
								<!-- 重点工程业绩 -->
								<view class="zy-disable-flex">
									<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
									<view>
										<view>
											<text class="zy-text-bold" @click="validText(item.compKeyProjectAchievementProjectName)" :class="item.compKeyProjectAchievementProjectName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.compKeyProjectAchievementProjectName}}
											</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											<text class="zy-text-mini zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.companyCompName}}
											</text>
										</view>
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">中标金额:</view>
									<view v-if="item.compKeyProjectAchievementMarkMoney != ''" class="zy-text-info">
										{{item.compKeyProjectAchievementMarkMoney}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">开工时间:</view>
									<view v-if="item.compKeyProjectAchievementStartDate != ''" class="zy-text-info">
										{{item.compKeyProjectAchievementStartDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">竣工时间:</view>
									<view v-if="item.compKeyProjectAchievementEndDate != ''" class="zy-text-info">
										{{item.compKeyProjectAchievementEndDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 4">
								<!-- 水利监理业绩 -->
								<view class="zy-disable-flex">
									<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
									<view>
										<view>
											<text class="zy-text-bold" @click="validText(item.compWaterMonitorAchievementProjectName)" :class="item.compWaterMonitorAchievementProjectName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.compWaterMonitorAchievementProjectName}}
											</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											<text class="zy-text-mini zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.companyCompName}}
											</text>
										</view>
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目类型:</view>
									<view v-if="item.compWaterMonitorAchievementProjectType != ''" class="zy-text-info">
										{{item.compWaterMonitorAchievementProjectType}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.contractAmount != ''" class="zy-text-info">
										{{item.compWaterMonitorAchievementContractAmount}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">开工时间:</view>
									<view v-if="item.compWaterMonitorAchievementStartDate != ''" class="zy-text-info">
										{{item.compWaterMonitorAchievementStartDate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
							<view v-else-if="achievementOpts.current == 5">
								<!-- 水利勘查设计业绩 -->
								<view class="zy-disable-flex">
									<zywork-icon type="iconicon-test2" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
									<view>
										<view>
											<text class="zy-text-bold" @click="validText(item.compWaterDeviseAchievementProjectName)" :class="item.compWaterDeviseAchievementProjectName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.compWaterDeviseAchievementProjectName}}
											</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											<text class="zy-text-mini zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
												{{item.companyCompName}}
											</text>
										</view>
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目类型:</view>
									<view v-if="item.compWaterDeviseAchievementTenderingComp != ''" class="zy-text-info">
										{{item.compWaterDeviseAchievementTenderingComp}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.compWaterDeviseAchievementContractAmount != ''" class="zy-text-info">
										{{item.compWaterDeviseAchievementContractAmount}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">项目负责人:</view>
									<view v-if="item.compWaterDeviseAchievementName != ''" class="zy-text-info">
										{{item.compWaterDeviseAchievementName}}
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
										<zywork-icon v-if="item.compBuilderGender === '0'" type="iconyincang" color="#BFBFBF" size="20" />
										<zywork-icon v-else-if="item.compBuilderGender === '1'" type="iconnan" color="#108EE9" size="20" />
										<zywork-icon v-else-if="item.compBuilderGender === '2'" type="iconnv" color="#dd524d" size="20" />
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
				<view class="zy-disable-flex zy-achievement-type">
					<view class="zy-type-title zy-text-bold">选择企业类别</view>
					<view class="zy-disable-flex-right">
						<view class="uni-list-cell-db">
							<picker @change="onClickIndustryItem" :value="industryTypeIndex" :range="industryTypeArray">
								<view class="zy-disable-flex">
									<text>{{industryTypeArray[industryTypeIndex]}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
				</view>
				<view class="zy-page-list zy-page-card" v-if="aptitudeList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in aptitudeList" :key="index">
						<view @click="toCompanyDetail(item.compAptitudeCompId, 2)">
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconrongyu" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<text class="zy-text-bold zy-text-info" @click="validText(item.companyCompName)" :class="item.companyCompName === '请购买VIP服务' ? 'zy-detail-phone' : ''">
										{{item.companyCompName}}
									</text>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.companyIndustryType}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">证件号码:</view>
									<view v-if="item.compAptitudeCertificateNum != ''">
										{{item.compAptitudeCertificateNum}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">资质详情:</view>
									<view v-if="item.compAptitudeCertificateDetail != ''">
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
				<view class="zy-disable-flex zy-achievement-type">
					<view class="zy-type-title zy-text-bold">选择项目类别</view>
					<view class="zy-disable-flex-right">
						<view class="uni-list-cell-db">
							<picker @change="onClickProjectTypeItem" :value="projectTypeIndex" :range="projectTypeArray">
								<view class="zy-disable-flex">
									<text>{{projectTypeArray[projectTypeIndex]}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
				</view>
				<view class="zy-page-list zy-page-card" v-if="projectAnnounceList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in projectAnnounceList" :key="index">
						<view>
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconzhongbiao" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<text class="zy-text-bold" @click="validText(item.title)" :class="item.title === '请购买VIP服务' ? 'zy-detail-phone' : ''">{{item.title}}</text>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.projectType}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">第一中标人:</view>
									<view v-if="item.firstCandidate !== ''" class="zy-text-info">
										{{item.firstCandidate}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">建造师:</view>
									<view v-if="item.firstBuilderName !== ''" class="zy-text-info">
										{{item.firstBuilderName}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">中标金额:</view>
									<view v-if="item.firstMarkMoney !== ''" class="zy-text-info">
										{{item.firstMarkMoney}}
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

		<uni-drawer :visible="searchDrawer" mode="right" @close="closeSearchDrawer">
			<view v-if="infoType.tabIndex === 0" class="zy-search-view zy-search-title">
				<text class="zy-text-bold">查企业</text>
			</view>
			<view v-else-if="infoType.tabIndex === 1" class="zy-search-view zy-search-title">
				<text class="zy-text-bold">查业绩</text>
			</view>
			<view v-else-if="infoType.tabIndex === 2" class="zy-search-view zy-search-title">
				<text class="zy-text-bold">查建造师</text>
			</view>
			<view v-else-if="infoType.tabIndex === 3" class="zy-search-view zy-search-title">
				<text class="zy-text-bold">查资质</text>
			</view>
			<view v-else-if="infoType.tabIndex === 4" class="zy-search-view zy-search-title">
				<text class="zy-text-bold">查中标记录</text>
			</view>
			<view class="zy-search-view">
				<view class="zy-search-bar zy-search">
					<zywork-icon type="iconchaxun" />
					<input type="text" v-model="searchVal" :placeholder="keywordMemo" @confirm="searchData" />
				</view>
			</view>
			<!-- 企业信息搜索条件 -->
			<view v-if="infoType.tabIndex === 0">
				<!-- <view class="zy-search-view">
					<view class="zy-search-bar zy-search">
						<picker @change="onClickIndustryItem" :value="industryTypeIndex" :range="industryTypeArray">
							<view class="zy-disable-flex">
								<text>{{industryTypeArray[industryTypeIndex]}}</text>
								<zywork-icon type="iconxiangxia" />
							</view>
						</picker>
					</view>
				</view> -->
			</view>
			<!-- 业绩信息搜索条件 -->
			<view v-if="infoType.tabIndex === 1">
				<view class="zy-search-view">
					<view class="zy-search-bar zy-search">
						<zywork-icon type="iconchaxun" />
						<input type="text" v-model="pager.moneyMin" placeholder="输入开始中标金额(万元)" @confirm="searchData" />
					</view>
					<view class="zy-search-division">
						-
					</view>
					<view class="zy-search-bar zy-search">
						<zywork-icon type="iconchaxun" />
						<input type="text" v-model="pager.moneyMax" placeholder="输入结束中标金额(万元)" @confirm="searchData" />
					</view>
				</view>
			</view>
			<!-- 建造师信息搜索条件 -->
			<view v-else-if="infoType.tabIndex === 2">
				<view class="zy-search-view">
					<view class="zy-search-bar zy-search">
						<zywork-icon type="iconchaxun" />
						<input type="text" v-model="pager.companyCompName" placeholder="输入企业名称关键字搜索" @confirm="searchData" />
					</view>
				</view>
				<view class="zy-search-view">
					<view class="zy-search-bar zy-search">
						<zywork-icon type="iconchaxun" />
						<input type="text" v-model="pager.compBuilderRegNum" placeholder="输入证件号码关键字搜索" @confirm="searchData" />
					</view>
				</view>
			</view>
			<!-- 资质信息搜索条件 -->
			<view v-if="infoType.tabIndex === 3">
				<view class="zy-search-view">
					<view class="zy-search-bar zy-search">
						<zywork-icon type="iconchaxun" />
						<input type="text" v-model="pager.companyCompName" placeholder="输入企业名称关键字搜索" @confirm="searchData" />
					</view>
				</view>
			</view>
			<!-- 中标记录信息搜索条件 -->
			<view v-if="infoType.tabIndex === 4">
				<view class="zy-search-view">
					<view class="zy-search-bar zy-search">
						<zywork-icon type="iconchaxun" />
						<input type="text" v-model="pager.firstBuilderName" placeholder="输入建造师/项目负责人关键字搜索" @confirm="searchData" />
					</view>
				</view>
			</view>
			<view class="zy-search-view zy-search-bottom">
				<button class="mini-btn" type="default" size="mini" @click="clearSearchData">清空</button>
				<button class="mini-btn" type="primary" size="mini" @click="drawerSearchData">搜索</button>
			</view>
		</uni-drawer>

		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniDrawer from '@/components/uni-drawer/uni-drawer.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {
		showInfoToast,
		callPhone,
		validText,
		USER_FLAG,
		USER_FLAG_VIP,
		nullToStr
	} from '@/common/util.js'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as creditQuery from '@/common/credit-query.js'
	import {
		achievementTypeArray,
		industryTypeArray,
		projectTypeArray
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
			uniTag,
			uniDrawer,
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
				infoType: {},
				urls: {
					companyUrl: '/company/user/pager-cond',
					houseAchievementUrl: '/CompHouseAchievementCompany/user/pager-cond',
					waterAchievementUrl: '/CompWaterAchievementCompany/user/pager-cond',
					trafficAchievementUrl: '/CompTrafficAchievementCompany/user/pager-cond',
					keyProjectAchievementUrl: '/CompKeyProjectAchievementCompany/user/pager-cond',
					waterMonitorAchievementUrl: '/CompWaterMonitorAchievementCompany/user/pager-cond',
					waterDeviseAchievementUrl: '/CompWaterDeviseAchievementCompany/user/pager-cond',
					builderUrl: '/CompBuilderCompany/any/pager-cond',
					aptitudeUrl: '/CompAptitudeCompany/user/pager-cond',
					projectAnnounceUrl: '/projecannounce/user/pager-cond',
				},
				pager: {},
				companyList: [],
				achievementList: [],
				builderList: [],
				aptitudeList: [],
				projectAnnounceList: [],
				industryTypeArray: industryTypeArray,
				projectTypeArray: projectTypeArray,
				projectTypeIndex: 0,
				industryTypeIndex: 0,
				achievementOpts: {
					current: 0,
					items: achievementTypeArray
				},
				totalCount: 0,
				searchDrawer: false,
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.infoType = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.infoType = JSON.parse(payload);
			}
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
				this.initPagerData();
				this.initInputTip();
			},
			/** 初始化查询数据 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			/** 初始化input的提示信息 */
			initInputTip() {
				const tabIndex = this.infoType.tabIndex;
				if (INFO_COMPANY === tabIndex) {
					// 企业信息
					this.keywordMemo = '输入企业名称关键字搜索';
				} else if (INFO_ACHIEVEMENT === tabIndex) {
					// 业绩信息
					this.keywordMemo = '输入企业名称关键字搜索';
				} else if (INFO_BUILDER === tabIndex) {
					// 企业建造师信息
					this.keywordMemo = '输入建造师姓名关键字搜索';
				} else if (INFO_APTITUDE === tabIndex) {
					// 企业资质信息
					this.keywordMemo = '输入资质关键字搜索';
				} else if (INFO_MARK === tabIndex) {
					// 中标记录
					this.keywordMemo = '输入中标单位关键字搜索';
				}
			},
			/** 初始化查询数据的值 */
			initPagerData() {
				this.pager = {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					compBuilderIsActive: 0,
					compAptitudeIsActive: 0,
					companyCompName: '',
					compBuilderRegNum: '',
					markMoneyMin: '',
					markMoneyMax: '',
					contractAmountMin: '',
					contractAmountMax: '',
					firstBuilderName: '',
					compAptitudeCertificateDetail: '',
					industryType: '',
					companyIndustryType: '',
					projectType: ''
				}
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
					let userFlag = uni.getStorageSync(USER_FLAG);
					if (userFlag != USER_FLAG_VIP) {
						showInfoToast("只有VIP用户才能查看");
						return;
					}
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
				let userFlag = uni.getStorageSync(USER_FLAG);
				if (userFlag != USER_FLAG_VIP) {
					showInfoToast("只有VIP用户才能查看");
					return;
				}
				item.achievementType = this.achievementOpts.current;
				let projectName = '';
				let compId = '';
				const index = this.achievementOpts.current;
				if (index == 0) {
					// 房屋业绩
					projectName = item.compHouseAchievementProjectName;
					compId = item.compHouseAchievementCompId;
				} else if (index == 1) {
					// 水利业绩
					projectName = item.compWaterAchievementProjectName
					compId = item.compWaterAchievementCompId;
				} else if (index == 2) {
					// 交通业绩
					projectName = item.compTrafficAchievementProjectName
					compId = item.compTrafficAchievementCompId;
				} else if (index == 3) {
					// 重点工程业绩
					projectName = item.compKeyProjectAchievementProjectName
					compId = item.compKeyProjectAchievementCompId;
				} else if (index == 4) {
					// 水利监理业绩
					projectName = item.compWaterMonitorAchievementProjectName
					compId = item.compWaterMonitorAchievementCompId;
				} else if (index == 5) {
					// 水利勘查设计业绩
					projectName = item.compWaterDeviseAchievementProjectName
					compId = item.compWaterDeviseAchievementCompId;
				}
				item.projectName = projectName;
				item.compId = compId;
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
					if (this.isShowHistroy) {
						this.isShowHistroy = false;
					}
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
							this.requestSuccess(this.infoType.tabIndex, type, res.data.data);
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
							this.requestSuccess(this.infoType.tabIndex, type, res.data.data);
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
							this.requestSuccess(this.infoType.tabIndex, type, res.data.data);
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
							this.requestSuccess(this.infoType.tabIndex, type, res.data.data);
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
							this.requestSuccess(this.infoType.tabIndex, type, res.data.data);
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
			requestSuccess(tabIndex, type, data) {
				this.totalCount = data.total;
				const rows = nullToStr(data.rows);
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
				} else if (INFO_ACHIEVEMENT === tabIndex) {
					// 业绩信息
					this.pager.companyCompName = tempSearchVal;
					this.refreshAchievementList(this.achievementOpts.current, type);
				} else if (INFO_BUILDER === tabIndex) {
					// 企业建造师信息
					this.pager.compBuilderName = tempSearchVal;
					this.refreshBuilderList(type);
				} else if (INFO_APTITUDE === tabIndex) {
					// 企业资质信息
					this.pager.compAptitudeCertificateDetail = tempSearchVal;
					this.refreshAptitudeList(type);
				} else if (INFO_MARK === tabIndex) {
					// 中标记录
					this.pager.firstCandidate = tempSearchVal;
					this.refreshProjectAnnounceList(type);
				}
				this.initInputTip();
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
			/** 行业分类选择器 */
			onClickIndustryItem: function(e) {
				let index = e.target.value
				if (this.industryTypeIndex !== index) {
					this.industryTypeIndex = index
					this.initPagerData();
					if (index != 0) {
						this.pager.companyIndustryType = this.pager.industryType = this.industryTypeArray[index];
					}
					this.closeSearchDrawer();
					this.searchData();
				}
			},
			/** 项目分类选择器 */
			onClickProjectTypeItem: function(e) {
				let index = e.target.value
				if (this.projectTypeIndex !== index) {
					this.projectTypeIndex = index
					this.initPagerData();
					if (index != 0) {
						this.pager.projectType = this.projectTypeArray[index];
					}
					this.closeSearchDrawer();
					this.searchData();
				}
			},
			/** 拨打电话 */
			callPhone(phone) {
				callPhone(phone);
			},
			/** 验证文字 */
			validText(text) {
				validText(text);
			},
			/** 显示查询的弹窗 */
			showSearchDrawer() {
				this.searchDrawer = true;
			},
			/** 关闭查询的弹窗 */
			closeSearchDrawer() {
				this.searchDrawer = false;
			},
			/** 抽屉搜索按钮点击事件 */
			drawerSearchData() {
				this.closeSearchDrawer();
				this.searchData();
			},
			/** 清空搜索条件 */
			clearSearchData() {
				this.initPagerData()
				this.searchVal = ''
				this.industryTypeIndex = 0
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

	.zy-search-result {
		padding: 0 20upx;

		.zy-search-count {
			color: $warning-text-color;
			margin: 0upx 10upx;
			font-size: 40upx;
		}
	}

	.zy-search {
		margin: 20upx auto;
		width: 90%;
	}

	.zy-search-view {
		padding: 10upx 0upx;
		border-bottom: 1upx solid $seperator-color;
	}

	.zy-search-title {
		text-align: center;
	}

	.zy-search-bottom {
		line-height: 2upx;
		text-align: right;
	}

	.zy-search-bottom button {
		margin-right: 20upx;
	}

	.zy-search-division {
		text-align: center;
	}
</style>
