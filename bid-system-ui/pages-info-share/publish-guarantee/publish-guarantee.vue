<template>
	<view>
		<!-- 发布申请保函 -->
		<view class="uni-common-mt">
			<form @submit="addGuarantee">
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">绑定开标项目</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" 
								placeholder="请选择开标项目" v-model="guarantee.projectName"
								@click="projectDrawer = true" />
							<uni-drawer :visible="projectDrawer" mode="right" @close="projectDrawer = false">
								<uni-list>
									<zywork-list-item v-for="(projectItem, index) in projectList" :key="index" :title="projectItem.title" note="点击选择"
										@click="chooseProject(projectItem)"></zywork-list-item>
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
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">保函费(元)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入保函费" v-model="guarantee.guaranteePrice"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">申请人</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入申请人(建筑单位)" v-model="guarantee.applicant"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">联系人</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入联系人" v-model="guarantee.name"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">手机号</view>
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
						<button type="primary" formType="submit">确认申请</button>
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
	import {
		guaranteeCompanyArray
	} from '@/common/picker.data.js'
	export default {
		components: {
			uniDrawer,
			uniList,
			zyworkListItem,
			zyworkIcon
		},
		data() {
			return {
				projectDrawer: false,
				projectList: [
					{
						id: 1,
						title: '项目1',
						openMarkTime: '2019-04-30 00:00:00 ',
						markUnitName: '某某公司',
						constructionPeriod: 30,
						assurePrice: 10000
					},
					{
						id: 2,
						title: '项目2',
						openMarkTime: '2019-04-30 00:00:00',
						markUnitName: '某某公司',
						constructionPeriod: 30,
						assurePrice: 10000
					},
					{
						id: 3,
						title: '项目3',
						openMarkTime: '2019-04-30 00:00:00',
						markUnitName: '某某公司',
						constructionPeriod: 30,
						assurePrice: 10000
					},
					{
						id: 4,
						title: '项目4',
						openMarkTime: '2019-04-30 00:00:00',
						markUnitName: '某某公司',
						constructionPeriod: 30,
						assurePrice: 10000
					},
					{
						id: 5,
						title: '项目5',
						openMarkTime: '2019-04-30 00:00:00',
						markUnitName: '某某公司',
						constructionPeriod: 30,
						assurePrice: 10000
					}
				],
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
				guaranteeCompanyIndex: 0
			}
		},
		onLoad() {
			this.initPicker()
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
				this.guarantee.openMarkTime = project.openMarkTime.split(' ')[0]
				this.guarantee.markUnitName = project.markUnitName
				this.guarantee.constructionPeriod = project.constructionPeriod
				this.guarantee.assurePrice = project.assurePrice / 100
				this.projectDrawer = false
			},
			/** 监听担保公司选择框 */
			chooseGuaranteeCompany: function(e) {
				this.guaranteeCompanyIndex = e.target.value
				this.guarantee.guaranteeComp = this.guaranteeCompanyArray[this.guaranteeCompanyIndex]
			},
			/** 确认申请保函 */
			addGuarantee: function(e) {
				var formObj = e.detail.value;
				this.guarantee.assurePrice *= this.guarantee.assurePrice
				this.guarantee.guaranteePrice *= this.guarantee.guaranteePrice
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(formObj));
				console.log(this.guarantee)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
