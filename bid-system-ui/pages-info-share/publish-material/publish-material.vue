<template>
	<view>
		<!-- 发布求带资料 -->
		<view class="uni-common-mt">
			<form>
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">
								<text class="zy-list-form-required">*</text>
								出发地点
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入出发地点" v-model="seekData.startAddr"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">
								<text class="zy-list-form-required">*</text>
								目的地地点
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入目的地地点" v-model="seekData.endAddr"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">资料类型</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseDataType" :range="dataTypeArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{dataTypeArray[dataTypeIndex]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">
								<text class="zy-list-form-required">*</text>
								资料数量
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入资料数量" v-model="seekData.dataCount"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">最晚日期</view>
						</view>
						<view class="uni-list-cell-db">
							<picker mode="date" :value="tempStartDate" :start="startDate" :end="endDate" placeholder="选择最晚日期"
								@change="latestDateChange">
								<view class="uni-input">{{tempStartDate}}</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">最晚时间</view>
						</view>
						<view class="uni-list-cell-db">
							<picker mode="time" :value="tempStartTime" start="09:01" end="21:01" placeholder="选择最晚时间"
								@change="latestTimeChange">
								<view class="uni-input">{{tempStartTime}}</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">
								<text class="zy-list-form-required">*</text>
								赏金
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入赏金" v-model="seekData.price"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">
								<text class="zy-list-form-required">*</text>
								联系电话
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入联系电话" v-model="seekData.phone"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">是否加急</view>
						</view>
						<view class="uni-list-cell-db">
							<switch :checked="seekData.isUrgent !== 0" @change="switchIsUrgent" color="#108EE9" />
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
						<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请输入备注" v-model="seekData.memo" />
					</view>
					<view class="zy-bottom-button">
						<cover-view>
							<button type="primary" @click="addSeekData" :disabled="disabled.seekDataBtn">发布信息</button>
						</cover-view>
					</view>
				</view>
			</form>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import * as infoPublish from '@/common/info-publish.js'
	import {
		dataTypeArray
	} from '@/common/picker.data.js'
	import {
		getDate
	} from '@/common/util.js'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				disabled: {
					seekDataBtn: false
				},
				seekData: {
					id: null,
					userId: null,
					startAddr: null,
					endAddr: null,
					dataType: null,
					dataCount: null,
					latestTime: null,
					price: null,
					phone: null,
					isUrgent: 0,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				dataTypeArray: dataTypeArray,
				dataTypeIndex: 0,
				tempStartDate: getDate({
					format: true
				}),
				tempStartTime: '12:01',
				startDate: getDate('start'),
				endDate: getDate('end'),
			}
		},
		onLoad() {
			this.initPicker();
		},
		methods: {
			/** 初始化下拉框 */	
			initPicker() {
				this.seekData.dataType = this.dataTypeArray[0];
				this.setStartTime();
			},
			/** 监听资料类型选择器 */
			chooseDataType: function(e) {
				this.dataTypeIndex = e.target.value
				this.seekData.dataType = this.dataTypeArray[this.dataTypeIndex]
			},
			/** 监听出发日期选择器 */
			latestDateChange: function(e) {
				this.tempStartDate = e.target.value
			},
			/** 监听出发时间选择器 */
			latestTimeChange: function(e) {
				this.tempStartTime = e.target.value
			},
			/** 监听是否开放简历 */
			switchIsUrgent: function(e) {
				if (e.target.value) {
					this.seekData.isUrgent = 1
				} else {
					this.seekData.isUrgent = 0
				}
			},
			/** 提交设置出发时间 */
			setStartTime() {
				this.seekData.latestTime = this.tempStartDate + ' ' + this.tempStartTime + ':00'
			},
			/** 发布求带资料信息 */
			addSeekData() {
				this.setStartTime()
				this.seekData.price *= 100
				infoPublish.saveSeekData(this, this.seekData);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
