<template>
	<view>
		<!-- 发布申请保函 -->
		<view class="uni-common-mt">
			<form>
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								绑定开标项目
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="请选择开标项目" v-model="guarantee.projectName"
							 @click="showProjectDrawer" />
							<uni-drawer :visible="projectDrawer" mode="right" @close="closeProjectDrawer">
								<uni-list>
									<view class="zy-search-bar zy-project-search">
										<zywork-icon type="iconchaxun" />
										<input type="text" v-model="projectPager.title" placeholder="输入项目名称搜索" @confirm="searchProject" />
									</view>
									<view class="zy-project-item" v-for="(projectItem, index) in projects" :key="index" @click="chooseProject(projectItem.project)">
										<view class="zy-disable-flex">
											<view>
												<text>{{projectItem.project.projectType}}</text>
												<text style="margin-left: 30upx;">[{{projectItem.project.city}}]</text>
											</view>
											<view class="zy-disable-flex-right" style="color: #108EE9">{{projectItem.project.markStatus}}</view>
										</view>
										<view class="zy-text-mini" style="color: #dd524d; text-align: right;">
											开标时间：
											<text v-if="projectItem.project.openMarkTime !== ''" class="zy-text-mini"
											 style="color: #dd524d;">
												{{projectItem.project.openMarkTime}}
											</text>
											<text v-else class="zy-text-mini" style="color: #dd524d;">
												暂无
											</text>
										</view>
										<view class="zy-text-bold">
											{{projectItem.project.title}}
										</view>
									</view>
									<!-- <zywork-list-item v-for="(projectItem, index) in projects" :key="index" :title="projectItem.title" note="点击选择"
										 @click="chooseProject(projectItem.id, projectItem.title)"></zywork-list-item> -->
								</uni-list>
							</uni-drawer>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">开标时间</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="开标时间" v-model="guarantee.openMarkTime"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">招标单位</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="招标单位" v-model="guarantee.markUnitName"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">工期(天)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="工期" v-model="guarantee.constructionPeriod"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">担保金额(万元)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="担保金额" v-model="guarantee.assurePrice"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">担保公司</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseGuaranteeCompany" :range="guaranteeCompanyArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{guarantee.guaranteeComp}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								保函费(元)
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入保函费" v-model="guarantee.guaranteePrice"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								申请人
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入申请人(建筑单位)" v-model="guarantee.applicant"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								联系人
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入联系人" v-model="guarantee.name"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								手机号
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入手机号" v-model="guarantee.phone"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">地址</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入保函邮寄地址" v-model="guarantee.address"></input>
						</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addGuarantee" :disabled="disabled.guaranteeBtn">确认申请</button>
						</cover-view>
					</view>
				</view>
			</form>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniDrawer from '@/components/uni-drawer/uni-drawer.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import * as infoPublish from '@/common/info-publish.js'
	import {
		getProjectList
	} from '@/common/project-info.js'
	import {
		guaranteeCompanyArray
	} from '@/common/picker.data.js'
	import {
		getUserPhone
	} from '@/common/util.js'
	export default {
		components: {
			uniDrawer,
			uniList,
			zyworkListItem,
			zyworkIcon
		},
		data() {
			return {
				disabled: {
					guaranteeBtn: false
				},
				projectDrawer: false,
				projectPager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					releaseStatus: '已发布',
					title: ''
				},
				projects: [],
				guarantee: {
					id: null,
					projectId: null,
					projectName: null,
					openMarkTime: null,
					markUnitName: null,
					constructionPeriod: null,
					assurePrice: null,
					guaranteeComp: null,
					guaranteePrice: null,
					applicant: null,
					name: null,
					phone: null,
					address: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				guaranteeCompanyArray: guaranteeCompanyArray,
				guaranteeCompanyIndex: 0,
				showBtn: true,
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.initPicker();
			this.guarantee.phone = getUserPhone();
		},
		methods: {
			/** 初始化下拉框 */
			initPicker() {
				this.guarantee.guaranteeComp = this.guaranteeCompanyArray[this.guaranteeCompanyIndex]
			},
			/** 选择开标项目 */
			chooseProject(project) {
				this.guarantee.projectId = project.id
				this.guarantee.projectName = project.title
				if (project.openMarkTime != null && project.openMarkTime != undefined) {
					this.guarantee.openMarkTime = project.openMarkTime
				}
				this.guarantee.markUnitName = project.markUnitName
				this.guarantee.constructionPeriod = project.constructionPeriod
				this.guarantee.assurePrice = project.assurePrice / 100
				this.projectDrawer = false
				this.showBtn = true;
			},
			/** 监听担保公司选择框 */
			chooseGuaranteeCompany: function(e) {
				this.guaranteeCompanyIndex = e.target.value
				this.guarantee.guaranteeComp = this.guaranteeCompanyArray[this.guaranteeCompanyIndex]
			},
			/** 显示项目选择抽屉 */
			showProjectDrawer() {
				this.projectDrawer = true;
				this.showBtn = false;
				this.searchProject();
			},
			/** 关闭项目选择抽屉 */
			closeProjectDrawer() {
				this.projectDrawer = false;
				this.showBtn = true;
			},
			/** 查询项目 */
			searchProject() {
				getProjectList(this, 'init', this.projectPager);
			},
			/** 确认申请保函 */
			addGuarantee() {
				this.guarantee.assurePrice *= 100;
				this.guarantee.guaranteePrice *= 100;
				infoPublish.saveGuarantee(this, this.guarantee);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-project-search {
		margin: 20upx auto;
		width: 90%;
	}

	.zy-project-item {
		padding: 10upx 20upx;
		border-bottom: 1upx solid $border-color;
	}

	.zy-project-item:last-child {
		border-bottom: none;
	}
</style>
