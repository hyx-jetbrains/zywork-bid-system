<template>
	<view>
		<!-- 企业业绩详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.projectName}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<zywork-icon type="iconqiyejianjie" color="#108EE9" size="30" style="display: inline-block; margin-right: 20upx;" />
					<view @click="toCompanyDetail">
						<view>
							<text class="zy-text-bold">{{item.companyCompName}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">
							<text v-if="item.companyIndustryType !== ''" class="zy-text-mini zy-text-info">
								{{item.companyIndustryType}}
							</text>
						</view>
					</view>
					<view class="zy-disable-flex-right">
						<view>
							<uni-tag v-if="item.achievementType == 0" text="房建业绩" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
							<uni-tag v-else-if="item.achievementType == 1" text="水利业绩" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
							<uni-tag v-else-if="item.achievementType == 2" text="交通业绩" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
							<uni-tag v-else-if="item.achievementType == 3" text="重点工程业绩" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
							<uni-tag v-else-if="item.achievementType == 4" text="水利监理业绩" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
							<uni-tag v-else-if="item.achievementType == 5" text="水利勘查设计业绩" type="primary" size="small" :inverted="true" :circle="true"></uni-tag>
						</view>
						<view v-html="space"></view>
					</view>
				</view>
				<view v-if="item.achievementType == 0">
					<!-- 房建业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementProjectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">注册建造师</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementBuilderName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标金额</view>
						<view class="zy-disable-flex-right">
							{{item.compHouseAchievementMarkMoney}} 万元
						</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设规模</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementBuildScale}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目所属地区归类</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementRegionType}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设单位</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementBuildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标单位</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMarkComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程地址</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementProjectAddr}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同签订日期</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementContractDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标日期</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMarkDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">施工员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementConstructors}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">施工员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementConstructorsCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">施工员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementConstructorsIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">质量员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementQualityWorker}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">质量员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementQualityWorkerCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">质量员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementQualityWorkerIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">安全员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementSecurityOfficer}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">安全员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementSecurityOfficerCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">安全员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementSecurityOfficerIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">标准员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementStandardWorker}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">标准员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementStandardWorkerCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">标准员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementStandardWorkerIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">材料员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMaterialMan}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">材料员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMaterialManCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">材料员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMaterialManIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">机械员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMechanic}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">机械员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMechanicCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">机械员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementMechanicIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">劳务员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementLabors}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">劳务员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementLaborsCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">劳务员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementLaborsIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">资料员</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementDataClerk}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">资料员证书号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementDataClerkCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">资料员身份证号</view>
						<view class="zy-disable-flex-right">{{item.compHouseAchievementDataClerkIdNum}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 1">
					<!-- 水利业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.compWaterAchievementProjectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.compWaterAchievementName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">
							{{item.compWaterAchievementContractAmount}} 万元
						</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.compWaterAchievementStartDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">竣工时间</view>
						<view class="zy-disable-flex-right">{{item.compWaterAchievementEndDate}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 2">
					<!-- 交通业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementProjectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">技术负责人</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementTechnologyName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">
							{{item.compTrafficAchievementContractAmount}} 万元
						</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程地点</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementWorkAddr}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementStartDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">竣工时间</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementEndDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">验证状态</view>
						<view class="zy-disable-flex-right">{{item.compTrafficAchievementValidStatus}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 3">
					<!-- 重点工程业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.compKeyProjectAchievementProjectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设单位</view>
						<view class="zy-disable-flex-right">{{item.compKeyProjectAchievementBuildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标金额</view>
						<view class="zy-disable-flex-right">
							{{item.compKeyProjectAchievementMarkMoney}} 万元
						</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.compKeyProjectAchievementStartDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">竣工时间</view>
						<view class="zy-disable-flex-right">{{item.compKeyProjectAchievementEndDate}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 4">
					<!-- 水利监理业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.compWaterMonitorAchievementProjectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目类型</view>
						<view class="zy-disable-flex-right">{{item.compWaterMonitorAchievementProjectType}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设单位</view>
						<view class="zy-disable-flex-right">{{item.compWaterMonitorAchievementBuildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">
							{{item.compWaterMonitorAchievementContractAmount}} 万元
						</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同签订日期</view>
						<view class="zy-disable-flex-right">{{item.compWaterMonitorAchievementContractDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.compWaterMonitorAchievementStartDate}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 5">
					<!-- 水利勘查设计业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.compWaterDeviseAchievementProjectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目类型</view>
						<view class="zy-disable-flex-right">{{item.compWaterDeviseAchievementTenderingComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">招标(单位)人</view>
						<view class="zy-disable-flex-right">{{item.compWaterDeviseAchievementBuildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标时间</view>
						<view class="zy-disable-flex-right">{{item.compWaterDeviseAchievementMarkDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">
							{{item.compWaterDeviseAchievementContractAmount}} 万元
						</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.compWaterDeviseAchievementName}}</view>
					</view>
				</view>

			</view>
		</view>


	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {
		getCompanyInfoById
	} from '@/common/credit-query.js'
	import {
		validText,
		nullToStr,
		showInfoToast
	} from '@/common/util.js'

	export default {
		components: {
			zyworkIcon,
			uniTag
		},
		data() {
			return {
				item: {},
				company: null
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
			uni.setNavigationBarTitle({
				title: this.item.projectName
			});
			this.initCompany();
		},
		methods: {
			/** 初始化公司信息 */
			initCompany() {
				if (!this.item.compId) {
					showInfoToast('获取企业信息失败')
					return;
				}
				getCompanyInfoById(this, this.item.compId);
			},
			/** 前往公司详情 */
			toCompanyDetail() {
				var item = this.company
				item.tabIndex = 0
				uni.navigateTo({
					url: '/pages-credit-query/company-detail/company-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
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
</style>
