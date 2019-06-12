<template>
	<view>
		<view>
			<!-- 头部部分 -->
			<view class="zy-disable-flex zy-detail-head">
				<zywork-icon type="iconqiyejianjie" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
				<view>
					<view>
						<text class="zy-text-bold">{{item.compName}}</text>
					</view>
					<view class="zy-text-mini zy-text-info">
						法人：
						<text v-if="item.legalPerson !== null && item.legalPerson !== undefined" class="zy-text-mini zy-text-info">
							{{item.legalPerson}}
						</text>
						<text v-else class="zy-text-mini zy-text-info">
							暂无
						</text>
					</view>
				</view>
			</view>
			<!-- tab选项卡 -->
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="projectType.scrollLeft">
					<view class="swiper-tab-list" :class="currTabIndex === 0 ? 'active' : ''" @click="tapTab(0)">基本信息</view>
					<view class="swiper-tab-list" :class="currTabIndex === 1 ? 'active' : ''" @click="tapTab(1)">建造师</view>
					<view class="swiper-tab-list" :class="currTabIndex === 2 ? 'active' : ''" @click="tapTab(2)">企业资质</view>
					<view class="swiper-tab-list" :class="currTabIndex === 3 ? 'active' : ''" @click="tapTab(3)">中标业绩</view>
					<view class="swiper-tab-list" :class="currTabIndex === 4 ? 'active' : ''" @click="tapTab(4)">企业人员</view>
				</scroll-view>
			</view>
			<!-- 基本信息 -->
			<view v-if="currTabIndex === 0">
				<view class="zy-detail-desc-title zy-text-bold">
					基本信息
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">辖区</view>
					<view class="zy-disable-flex-right">{{item.jurisdictionType === 0 ? '省内' : '省外'}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">市区</view>
					<view class="zy-disable-flex-right">{{item.city}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">企业类型</view>
					<view class="zy-disable-flex-right">{{item.compType}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">行业分类</view>
					<view class="zy-disable-flex-right">{{item.industryType}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">法人电话</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone(item.legalPersonPhone)">{{item.legalPersonPhone}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">注册地区</view>
					<view class="zy-disable-flex-right">{{item.regAddress}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">负责人</view>
					<view class="zy-disable-flex-right">{{item.responsible}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">负责人电话</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone(item.responsiblePhone)">{{item.responsiblePhone}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">单位电话</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone(item.compPhone)">{{item.compPhone}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">联系地址</view>
					<view class="zy-disable-flex-right">{{item.compAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">注册资本</view>
					<view class="zy-disable-flex-right">{{item.regCapital}}</view>
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">经营范围</view>
				</view>
				<view class="zy-detail-desc-textarea">
					{{item.businessScope}}
				</view>
				<view class="zy-disable-flex zy-detail-desc-item">
					<view class="zy-text-bold">可承担业务</view>
				</view>
				<view class="zy-detail-desc-textarea">
					{{item.affordableBusiness}}
				</view>
			</view>
			<!-- 建造师 -->
			<view v-if="currTabIndex === 1">
				<view class="zy-detail-desc-title zy-text-bold">
					企业建造师信息
				</view>
				<view class="zy-page-list zy-page-card" v-if="builderList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in builderList" :key="index">
						<view>
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
			<!-- 企业资质 -->
			<view v-if="currTabIndex === 2">
				<view class="zy-detail-desc-title zy-text-bold">
					企业资质信息
				</view>
				<view class="zy-page-list zy-page-card" v-if="aptitudeList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in aptitudeList" :key="index">
						<view>
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
			<!-- 中标业绩 -->
			<view v-if="currTabIndex === 3">
				<view class="zy-disable-flex zy-detail-desc-title zy-text-bold">
					<view>
						企业中标业绩
					</view>
					<view class="zy-disable-flex-right" style="margin-right: 0upx;">
						<view class="">
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
			<!-- 企业人员 -->
			<view v-if="currTabIndex === 4">
				<view class="zy-detail-desc-title zy-text-bold">
					企业人员信息
				</view>
				<view class="zy-page-list zy-page-card" v-if="personnelList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in personnelList" :key="index">
						<view>
							<!-- 头部 -->
							<view class="zy-disable-flex">
								<zywork-icon type="iconrenyuan" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
								<view>
									<view>
										<text class="zy-text-bold" style="margin-right: 20upx;">{{item.name}}</text>
									</view>
									<view class="zy-text-mini zy-text-info">
										<text class="zy-text-mini zy-text-info">
											{{item.createTime}}
										</text>
									</view>
								</view>
							</view>
							<!-- 内容部分 -->
							<view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">职称:</view>
									<view v-if="item.jobTitle != null && item.jobTitle != '' && item.jobTitle != undefined" class="zy-text-info">
										{{item.jobTitle}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">职业资格及专业:</view>
									<view v-if="item.jobDetail != null && item.jobDetail != '' && item.jobDetail != undefined" class="zy-text-info">
										{{item.jobDetail}}
									</view>
									<view v-else class="zy-text-info">
										暂无
									</view>
								</view>
							</view>
						</view>
					</view>
				</view>
				<zywork-no-data v-else text="暂无企业人员信息"></zywork-no-data>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as creditQuery from '@/common/credit-query.js'
	import {
		achievementTypeArray
	} from '@/common/picker.data.js'
	import {
		callPhone,
		validText,
		nullToStr,
		showInfoToast,
		USER_FLAG,
		USER_FLAG_VIP,
	} from '@/common/util.js'

	/** 企业建造师信息 */
	const INFO_BUILDER = 1
	/** 企业资质信息 */
	const INFO_APTITUDE = 2
	/** 业绩信息 */
	const INFO_ACHIEVEMENT = 3
	/** 企业人员 */
	const INFO_PERSONNEL = 4

	export default {
		components: {
			zyworkIcon,
			zyworkNoData
		},
		data() {
			return {
				item: {},
				currTabIndex: 0,
				urls: {
					houseAchievementUrl: '/CompHouseAchievementCompany/user/pager-cond',
					waterAchievementUrl: '/CompWaterAchievementCompany/user/pager-cond',
					trafficAchievementUrl: '/CompTrafficAchievementCompany/user/pager-cond',
					keyProjectAchievementUrl: '/CompKeyProjectAchievementCompany/user/pager-cond',
					waterMonitorAchievementUrl: '/CompWaterMonitorAchievementCompany/user/pager-cond',
					waterDeviseAchievementUrl: '/CompWaterDeviseAchievementCompany/user/pager-cond',
					builderUrl: '/CompBuilderCompany/any/pager-cond',
					aptitudeUrl: '/CompAptitudeCompany/user/pager-cond',
					personnelUrl: '/comp-personnel/any/pager-cond'
				},
				pager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					compId: ''
				},
				achievementList: [],
				builderList: [],
				aptitudeList: [],
				personnelList: [],
				achievementOpts: {
					current: 0,
					items: achievementTypeArray
				},
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			this.initCompId();
			this.tapTab(this.item.tabIndex);
		},
		methods: {
			initCompId() {
				this.pager.compHouseAchievementId = this.pager.compKeyProjectAchievementCompId = this.pager.compTrafficAchievementCompId =
					this.pager.compWaterAchievementCompId = this.pager.compWaterAchievementCompId = this.pager.compWaterMonitorAchievementCompId =
					this.pager.compAptitudeCompId = this.pager.compBuilderCompId = this.pager.compId = this.item.id;
			},
			/** 切换标签页 */
			tapTab(type) {
				this.currTabIndex = type;
				if (INFO_ACHIEVEMENT === type) {
					// 业绩信息
					this.refreshAchievementList(this.achievementOpts.current);
				} else if (INFO_BUILDER === type) {
					// 建造师信息
					this.refreshBuilderList();
				} else if (INFO_APTITUDE === type) {
					// 资质信息
					this.refreshAptitudeList();
				} else if (INFO_PERSONNEL === type) {
					// 企业人员
					this.refreshPersonnelList();
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
			/** 刷新企业建造师信息列表 */
			refreshBuilderList() {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.builderUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.builderList = nullToStr(res.data.data.rows);
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新业绩信息列表 */
			refreshAchievementList(index) {
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
							this.achievementList = nullToStr(res.data.data.rows);
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新企业资质信息列表 */
			refreshAptitudeList() {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.aptitudeUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.aptitudeList = nullToStr(res.data.data.rows);
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 刷新企业人员信息列表 */
			refreshPersonnelList() {
				uni.showLoading({
					title: '加载中'
				})
				creditQuery.getListInfoToPost(this, this.urls.personnelUrl, this.pager)
					.then(data => {
						uni.hideLoading()
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							this.personnelList = nullToStr(res.data.data.rows);
						} else {
							showInfoToast(res.data.message)
						}
					})
			},
			/** 业绩类型选择器 */
			onClickAchievementItem: function(e) {
				let index = e.target.value
				if (this.achievementOpts.current !== index) {
					this.achievementOpts.current = index
					this.refreshAchievementList(index);
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
		background-color: #FFFFFF;
	}

	.zy-detail-head {
		border-bottom: 2upx solid $border-color;
		padding: 20upx;
	}

	.zy-detail-collection-button {
		width: 110upx;
		height: 45upx;
		border: 1upx solid $border-color;
		border-radius: 10upx;
		padding-left: 10upx;
	}

	.zy-detail-collection-button-active {
		border: 1upx solid $primary-color;
		color: $primary-color;
	}

	.zy-detail-desc-title {
		background-color: #F8F8F8;
		padding: 5upx 20upx;
		border-left: 5upx solid $primary-color;
	}

	.zy-detail-desc-item {
		padding: 5upx 0 5upx 20upx;
	}

	.zy-detail-desc-item .zy-warning {
		color: #dd524d;
	}

	.zy-detail-desc-item .zy-primary {
		color: #108EE9;
	}

	.zy-detail-desc-textarea {
		padding: 0 20upx;
	}

	.zy-detail-button {
		text-align: center;
		margin: 30upx 25upx;
		border-radius: 50upx 50upx;
	}

	.zy-content-label {
		margin-right: 20upx;
	}
</style>
