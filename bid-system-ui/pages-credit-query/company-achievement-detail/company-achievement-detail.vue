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
							<text class="zy-text-bold">{{company.compName}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">
							法人：
							<text v-if="company.legalPerson !== null && company.legalPerson !== undefined" class="zy-text-mini zy-text-info">
								{{company.legalPerson}}
							</text>
							<text v-else class="zy-text-mini zy-text-info">
								暂无
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
						<view class="zy-disable-flex-right">{{item.projectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">注册建造师</view>
						<view class="zy-disable-flex-right">{{item.builderName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标金额</view>
						<view class="zy-disable-flex-right">{{item.markMoney / 100}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设规模</view>
						<view class="zy-disable-flex-right">{{item.buildScale}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目所属地区归类</view>
						<view class="zy-disable-flex-right">{{item.regionType}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设单位</view>
						<view class="zy-disable-flex-right">{{item.buildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程地址</view>
						<view class="zy-disable-flex-right">{{item.projectAddr}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同签订日期</view>
						<view class="zy-disable-flex-right">{{item.contractDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标日期</view>
						<view class="zy-disable-flex-right">{{item.markDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.name}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人证书号</view>
						<view class="zy-disable-flex-right">{{item.certificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">施工员</view>
						<view class="zy-disable-flex-right">{{item.constructors}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">施工员证书号</view>
						<view class="zy-disable-flex-right">{{item.constructorsCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">施工员身份证号</view>
						<view class="zy-disable-flex-right">{{item.constructorsIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">质量员</view>
						<view class="zy-disable-flex-right">{{item.qualityWorker}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">质量员证书号</view>
						<view class="zy-disable-flex-right">{{item.qualityWorkerCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">质量员身份证号</view>
						<view class="zy-disable-flex-right">{{item.qualityWorkerIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">安全员</view>
						<view class="zy-disable-flex-right">{{item.securityOfficer}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">安全员证书号</view>
						<view class="zy-disable-flex-right">{{item.securityOfficerCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">安全员身份证号</view>
						<view class="zy-disable-flex-right">{{item.securityOfficerIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">标准员</view>
						<view class="zy-disable-flex-right">{{item.standardWorker}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">标准员证书号</view>
						<view class="zy-disable-flex-right">{{item.standardWorkerCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">标准员身份证号</view>
						<view class="zy-disable-flex-right">{{item.standardWorkerIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">材料员</view>
						<view class="zy-disable-flex-right">{{item.materialMan}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">材料员证书号</view>
						<view class="zy-disable-flex-right">{{item.materialManCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">材料员身份证号</view>
						<view class="zy-disable-flex-right">{{item.materialManIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">机械员</view>
						<view class="zy-disable-flex-right">{{item.mechanic}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">机械员证书号</view>
						<view class="zy-disable-flex-right">{{item.mechanicCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">机械员身份证号</view>
						<view class="zy-disable-flex-right">{{item.mechanicIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">劳务员</view>
						<view class="zy-disable-flex-right">{{item.labors}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">劳务员证书号</view>
						<view class="zy-disable-flex-right">{{item.laborsCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">劳务员身份证号</view>
						<view class="zy-disable-flex-right">{{item.laborsIdNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">资料员</view>
						<view class="zy-disable-flex-right">{{item.dataClerk}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">资料员证书号</view>
						<view class="zy-disable-flex-right">{{item.dataClerkCertificateNum}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">资料员身份证号</view>
						<view class="zy-disable-flex-right">{{item.dataClerkIdNum}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 1">
					<!-- 水利业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.projectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.name}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">{{item.contractAmount / 100}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.startDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">竣工时间</view>
						<view class="zy-disable-flex-right">{{item.endDate}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 2">
					<!-- 交通业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.projectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.name}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">技术负责人</view>
						<view class="zy-disable-flex-right">{{item.technologyName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">{{item.contractAmount}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程地点</view>
						<view class="zy-disable-flex-right">{{item.workAddr}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.startDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">竣工时间</view>
						<view class="zy-disable-flex-right">{{item.endDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">验证状态</view>
						<view class="zy-disable-flex-right">{{item.validStatus}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 3">
					<!-- 重点工程业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.projectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设单位</view>
						<view class="zy-disable-flex-right">{{item.buildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标金额</view>
						<view class="zy-disable-flex-right">{{item.markMoney / 100}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.startDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">竣工时间</view>
						<view class="zy-disable-flex-right">{{item.endDate}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 4">
					<!-- 水利监理业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.projectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目类型</view>
						<view class="zy-disable-flex-right">{{item.projectType}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">建设单位</view>
						<view class="zy-disable-flex-right">{{item.buildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">{{item.contractAmount / 100}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同签订日期</view>
						<view class="zy-disable-flex-right">{{item.contractDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">开工时间</view>
						<view class="zy-disable-flex-right">{{item.startDate}}</view>
					</view>
				</view>
				<view v-if="item.achievementType == 5">
					<!-- 水利勘查设计业绩 -->
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">工程名称</view>
						<view class="zy-disable-flex-right">{{item.projectName}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目类型</view>
						<view class="zy-disable-flex-right">{{item.tenderingComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">招标(单位)人</view>
						<view class="zy-disable-flex-right">{{item.buildComp}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">中标时间</view>
						<view class="zy-disable-flex-right">{{item.markDate}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">合同金额</view>
						<view class="zy-disable-flex-right">{{item.contractAmount / 100}}</view>
					</view>
					<view class="zy-disable-flex zy-page-list-item">
						<view class="zy-text-bold">项目负责人</view>
						<view class="zy-disable-flex-right">{{item.name}}</view>
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
				getCompanyInfoById(this, this.item.compId);
			},
			/** 前往公司详情 */
			toCompanyDetail() {
				uni.navigateTo({
					url: '/pages-credit-query/company-detail/company-detail?itemData=' + encodeURIComponent(JSON.stringify(this.company))
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
