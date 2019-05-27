<template>
	<view>
		<!-- 发布开标拼车 -->
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view v-if="type.current == 0">
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
								<input class="uni-input" type="text" :disabled="true" placeholder="请选择开标项目" v-model="carpool.projectName"
								 @click="showProjectDrawer" />
								<uni-drawer :visible="projectDrawer" mode="right" @close="projectDrawer = false">
									<uni-list>
										<view class="zy-search-bar zy-project-search">
											<zywork-icon type="iconchaxun" />
											<input type="text" v-model="projectPager.title" placeholder="输入项目名称搜索" @confirm="searchProject" />
										</view>
										<view class="zy-project-item" v-for="(projectItem, index) in projects" :key="index" @click="chooseProject(projectItem.id, projectItem.title)">
											<view class="zy-disable-flex">
												<view>
													<text>{{projectItem.projectType}}</text>
													<text style="margin-left: 30upx;">[{{projectItem.city}}]</text>
												</view>
												<view class="zy-disable-flex-right" style="color: #108EE9">{{projectItem.markStatus}}</view>
											</view>
											<view class="zy-text-mini" style="color: #dd524d; text-align: right;">
												开标时间：
												<text v-if="projectItem.openMarkTime !== null && projectItem.openMarkTime !== undefined"
													 class="zy-text-mini" style="color: #dd524d;">
													{{projectItem.openMarkTime}}
												</text>
												<text v-else class="zy-text-mini" style="color: #dd524d;">
													暂无
												</text>
											</view>
											<view class="zy-text-bold">
												{{projectItem.title}}
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
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									出发城市
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择出发城市" v-model="carpool.startCity" @tap="chooseStartCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									出发地
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入出发地点" v-model="carpool.startAddr"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									目的地城市
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择目的地城市" v-model="carpool.endCity" @tap="chooseEndCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									目的地
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入目的地地点" v-model="carpool.endAddr"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">出发日期</view>
							</view>
							<view class="uni-list-cell-db">
								<picker mode="date" :value="tempStartDate" :start="startDate" :end="endDate" placeholder="选择出发日期" @change="startDateChange">
									<view class="uni-input">{{tempStartDate}}</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">出发时间</view>
							</view>
							<view class="uni-list-cell-db">
								<picker mode="time" :value="tempStartTime" start="09:01" end="21:01" placeholder="选择出发时间" @change="startTimeChange">
									<view class="uni-input">{{tempStartTime}}</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									汽车车型
								</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseCarType" :range="carTypeArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{carpool.carType}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									搭载人数
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入搭载人数" v-model="carpool.peopleCount"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									价格
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入价格" v-model="carpool.price"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									联系姓名
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入联系姓名" v-model="carpool.name"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									联系手机
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入联系手机" v-model="carpool.phone"></input>
							</view>
						</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addCarpool" :disabled="disabled.carpoolBtn">发布信息</button>
						</cover-view>
					</view>
				</form>
			</view>
		</view>
		<view v-else>
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
								<input class="uni-input" type="text" :disabled="true" placeholder="请选择开标项目" v-model="seekcar.projectName"
								 @click="showProjectDrawer" />
								<uni-drawer :visible="projectDrawer" mode="right" @close="projectDrawer = false">
									<uni-list>
										<view class="zy-search-bar zy-project-search">
											<zywork-icon type="iconchaxun" />
											<input type="text" v-model="projectPager.title" placeholder="输入项目名称搜索" @confirm="searchProject" />
										</view>
										<view class="zy-project-item" v-for="(projectItem, index) in projects" :key="index" @click="chooseProject(projectItem.id, projectItem.title)">
											<view class="zy-disable-flex">
												<view>
													<text>{{projectItem.projectType}}</text>
													<text style="margin-left: 30upx;">[{{projectItem.city}}]</text>
												</view>
												<view class="zy-disable-flex-right" style="color: #108EE9">{{projectItem.markStatus}}</view>
											</view>
											<view class="zy-text-mini" style="color: #dd524d; text-align: right;">
												开标时间：
												<text v-if="projectItem.openMarkTime !== null && projectItem.openMarkTime !== undefined"
													 class="zy-text-mini" style="color: #dd524d;">
													{{projectItem.openMarkTime}}
												</text>
												<text v-else class="zy-text-mini" style="color: #dd524d;">
													暂无
												</text>
											</view>
											<view class="zy-text-bold">
												{{projectItem.title}}
											</view>
										</view>
										<!-- <zywork-list-item v-for="(projectItem, index) in projectList" :key="index" :title="projectItem.title" note="点击选择"
										 @click="chooseProject(projectItem.id, projectItem.title)"></zywork-list-item> -->
									</uni-list>
								</uni-drawer>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									出发城市
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择出发城市" v-model="seekcar.startCity" @tap="chooseStartCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									出发地
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入出发地点" v-model="seekcar.startAddr"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									目的地城市
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择目的地城市" v-model="seekcar.endCity" @tap="chooseEndCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									目的地
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入目的地地点" v-model="seekcar.endAddr"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">出发日期</view>
							</view>
							<view class="uni-list-cell-db">
								<picker mode="date" :value="tempStartDate" :start="startDate" :end="endDate" placeholder="选择出发日期" @change="startDateChange">
									<view class="uni-input">{{tempStartDate}}</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">出发时间</view>
							</view>
							<view class="uni-list-cell-db">
								<picker mode="time" :value="tempStartTime" start="09:01" end="21:01" placeholder="选择出发时间" @change="startTimeChange">
									<view class="uni-input">{{tempStartTime}}</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									联系姓名
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入联系姓名" v-model="seekcar.name"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									联系手机
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入联系手机" v-model="seekcar.phone"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold">备注</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请填写备注" v-model="seekcar.memo" />
							</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addSeekcar" :disabled="disabled.seekcarBtn">发布信息</button>
						</cover-view>
					</view>
				</form>
			</view>
		</view>
		<mpvue-city-picker :themeColor="themeColor" ref="startCityPicker" :pickerValueDefault="cityPickerValueDefault"
			@onCancel="onCancel" @onConfirm="onStartConfirm"></mpvue-city-picker>
		<mpvue-city-picker :themeColor="themeColor" ref="endCityPicker" :pickerValueDefault="cityPickerValueDefault"
			@onCancel="onCancel" @onConfirm="onEndConfirm"></mpvue-city-picker>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniDrawer from '@/components/uni-drawer/uni-drawer.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import mpvueCityPicker from '@/components/mpvue-citypicker/mpvueCityPicker.vue'
	import cityData from '@/common/city.data.js';
	
	import { 
		openMarkArray,
		carTypeArray
	} from '@/common/picker.data.js'
	import {
		getDate
	} from '@/common/util.js'
	import * as infoPublish from '@/common/info-publish.js'
	import {
		getProjectList
	} from '@/common/project-info.js'
	
	export default {
		components: {
			uniSegmentedControl,
			zyworkIcon,
			uniDrawer,
			uniList,
			zyworkListItem,
			mpvueCityPicker
		},
		data() {
			return {
				type: {
					current: 0,
					items: openMarkArray,
				},
				disabled: {
					carpoolBtn: false,
					seekcarBtn: false
				},
				tempStartDate: getDate({
					format: true
				}),
				tempStartTime: '12:01',
				carpool: {
					id: null,
					userId: null,
					projectId: null,
					projectName: null,
					startCity: null,
					startAddr: null,
					endCity: null,
					endAddr: null,
					startTime: null,
					carType: null,
					peopleCount: null,
					price: null,
					name: null,
					phone: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				projectDrawer: false,
				projectPager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					releaseStatus: '已发布',
					markStatus: '待开标',
					title: ''
				},
				projects: [],
				cityPickerValueDefault: [0, 0, 0],
				themeColor: '#007AFF',
				startDate: getDate('start'),
				endDate: getDate('end'),
				carTypeArray: carTypeArray,
				seekcar: {
					id: null,
					userId: null,
					projectId: null,
					startCity: null,
					startAddr: null,
					endCity: null,
					endAddr: null,
					startTime: null,
					name: null,
					phone: null,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				showBtn: true
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.initPicker()
		},
		methods: {
			/** 分段器选择类别 */
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
				}
			},
			/** 初始化下拉选择器 */
			initPicker() {
				this.carpool.carType = this.carTypeArray[0]
			},
			/** 选择开标项目 */
			chooseProject(id, title) {
				this.carpool.projectId = this.seekcar.projectId = id
				this.carpool.projectName = this.seekcar.projectName = title
				this.projectDrawer = false
			},
			/** 选择出发城市 */
			chooseStartCity() {
				this.$refs.startCityPicker.show()
				this.showBtn = false
			},
			/** 选择目的地城市 */
			chooseEndCity() {
				this.$refs.endCityPicker.show()
				this.showBtn = false
			},
			/** 出发城市地区选择框确认 */
			onStartConfirm(e) {
				this.carpool.startCity = this.seekcar.startCity = this.getAddressInfo(e) 
				this.showBtn = true
			},
			/** 目的地城市地区选择框确认 */
			onEndConfirm(e) {
				this.carpool.endCity = this.seekcar.endCity = this.getAddressInfo(e) 
				this.showBtn = true
			},
			/** 地区选择框取消 */
			onCancel(e) {
				console.log(e)
				this.showBtn = true
			},
			/** 取地址信息 */
			getAddressInfo(e) {
				var tempAddrLabel = e.label
				var tempAddr = tempAddrLabel.replace(/-/g, '/');
				return tempAddr
			},
			/** 监听出发日期选择器 */
			startDateChange: function(e) {
				this.tempStartDate = e.target.value
			},
			/** 监听出发时间选择器 */
			startTimeChange: function(e) {
				this.tempStartTime = e.target.value
			},
			/** 监听汽车车型选择器 */
			chooseCarType: function(e) {
				this.carpool.carType = this.carTypeArray[e.target.value]
			},
			/** 提交设置出发时间 */
			setStartTime() {
				this.carpool.startTime = this.seekcar.startTime
					= this.tempStartDate + ' ' + this.tempStartTime + ':00'
			},
			/** 发布开标拼车信息 */
			addCarpool() {
				this.setStartTime()
				// var formObj = e.detail.value;
				infoPublish.saveCarpool(this, this.carpool);
			},
			/** 发布开标找车信息 */
			addSeekcar() {
				this.setStartTime()
				infoPublish.saveSeekcar(this, this.seekcar);
			},
			/** 显示项目选择抽屉 */
			showProjectDrawer() {
				this.projectDrawer = true;
				this.searchProject();
			},
			/** 查询项目 */
			searchProject() {
				getProjectList(this, 'init', this.projectPager);
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
