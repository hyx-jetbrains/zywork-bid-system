<template>
	<view>
		<!-- 征信查询 -->
		<view class="zy-top-search">
			<view class="zy-search-bar" @click="toSearchPage">
				<zywork-icon type="iconchaxun" />
				<input type="text" placeholder="我要搜索" disabled />
			</view>
		</view>

		<view class="uni-tab-bar zy-tab-bar zy-disable-flex">
			<view>
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
					<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
					 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
				</scroll-view>
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
					<view>
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
							<view @click="toAchievementDetail(item)">
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
							<view @click="toAchievementDetail(item)">
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
							<view @click="toAchievementDetail(item)">
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">合同金额:</view>
									<view v-if="item.compTrafficAchievementContractAmount != ''" class="zy-text-info">
										{{item.compTrafficAchievementContractAmount}} 万元
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
							<view @click="toAchievementDetail(item)">
								<view class="zy-disable-flex">
									<view class="zy-text-info zy-text-bold zy-content-label">中标金额:</view>
									<view v-if="item.compKeyProjectAchievementMarkMoney != ''" class="zy-text-info">
										{{item.compKeyProjectAchievementMarkMoney}} 万元
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
							<view @click="toAchievementDetail(item)">
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
										{{item.compWaterMonitorAchievementContractAmount}} 万元
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
							<view @click="toAchievementDetail(item)">
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
										{{item.compWaterDeviseAchievementContractAmount}} 万元
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
								<view class="zy-text-info zy-text-bold zy-content-label" style="width: 40%;">注册证件号码:</view>
								<view v-if="item.compBuilderRegNum != ''" class="zy-text-info" v-html="item.compBuilderRegNum">
								</view>
								<view v-else class="zy-text-info">
									暂无
								</view>
							</view>
							<view class="zy-disable-flex">
								<view class="zy-text-info zy-text-bold zy-content-label" style="width: 40%;">专业等级:</view>
								<view v-if="item.compBuilderMajorLevel != ''" class="zy-text-info" v-html="item.compBuilderMajorLevel">
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
						<view @click="toCompanyDetail(item.compAptitudeCompId, 2)">
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
						<view @click="toAnnounceDetail(item)">
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


		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import * as ResponseStatus from '@/common/response-status.js'
	import * as creditQuery from '@/common/credit-query.js'
	import {
		achievementTypeArray,
		industryTypeArray,
		projectTypeArray
	} from '@/common/picker.data.js'
	import {
		showInfoToast,
		callPhone,
		validText,
		USER_FLAG,
		USER_FLAG_VIP,
		nullToStr,
		DOCUMENT_BASE_URL,
		CREDIT_QUERY_VIP,
		CREDIT_QUERY,
		isUserIdExist,
		notLoginToUserCenter
	} from '@/common/util.js'

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
				pager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					compBuilderIsActive: 0,
					compAptitudeIsActive: 0,
					industryType: '',
					companyIndustryType: '',
					projectType: ''
				},
				companyList: [],
				achievementList: [],
				builderList: [],
				aptitudeList: [],
				projectAnnounceList: [],
				achievementOpts: {
					current: 0,
					items: achievementTypeArray
				},
				industryTypeArray: industryTypeArray,
				industryTypeIndex: 0,
				projectTypeArray: projectTypeArray,
				projectTypeIndex: 0,
				creditQueryVip: false
			}
		},
		onLoad() {
			this.initData('init');
		},
		onPullDownRefresh() {
			this.pager.pageNo = 1
			this.initData('pullDown');
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			this.initData('reachBottom');
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
				let creditFlag = uni.getStorageSync(CREDIT_QUERY_VIP);
				if (creditFlag == CREDIT_QUERY) {
					this.creditQueryVip = true;
				}
				// } else {
				// 	notLoginToUserCenter();
				// }
			},
			/** 初始化查询条件 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			/** 前往查询页面 */
			toSearchPage() {
				const item = this.infoType
				uni.navigateTo({
					url: '/pages-credit-query/search-page/search-page?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			/** 查看企业详情 */
			toCompanyDetail(item, type) {
				if (type !== 0) {
					if (!this.creditQueryVip) {
						showInfoToast("只有购买征信查询服务才能查看");
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
				if (!this.creditQueryVip) {
					showInfoToast("只有购买征信查询服务才能查看");
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
					this.pager.companyCompName = tempSearchVal;
					this.refreshAptitudeList(type);
				} else if (INFO_MARK === tabIndex) {
					// 中标记录
					this.pager.firstCandidate = tempSearchVal;
					this.refreshProjectAnnounceList(type);
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
			/** 行业分类选择器 */
			onClickIndustryItem: function(e) {
				let index = e.target.value
				if (this.industryTypeIndex !== index) {
					this.industryTypeIndex = index
					if (index != 0) {
						this.pager.companyIndustryType = this.pager.industryType = this.industryTypeArray[index];
					} else {
						this.pager.companyIndustryType = this.pager.industryType = '';
					}
					this.initPager();
					this.checkRefresh(this.infoType.tabIndex, 'init');
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
			toAnnounceDetail(item) {
				if (!this.creditQueryVip) {
					showInfoToast("只有购买征信查询服务才能查看");
					return;
				}
				if (item.id !== null && item.inwordHtmlUrl !== '') {
					this.toWebViewPage("公示详情", DOCUMENT_BASE_URL + "/" + item.inwordHtmlUrl);
				} else {
					uni.showModal({
						title: '提示',
						content: '没有公示信息',
						showCancel: false
					})
				}
			},
			/** 项目分类选择器 */
			onClickProjectTypeItem: function(e) {
				let index = e.target.value
				if (this.projectTypeIndex !== index) {
					this.projectTypeIndex = index
					if (index != 0) {
						this.pager.projectType = this.projectTypeArray[index];
					} else {
						this.pager.projectType = '';
					}
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
