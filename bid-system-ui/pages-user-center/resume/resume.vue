<template>
	<view>
		<view class="uni-common-mt">
			<form @submit="addResumeInfo">
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">姓名</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入真实姓名" v-model="formInfo.name"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">性别</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseGender" :range="genderArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{genderArray[formInfo.gender]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">年龄</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入年龄" v-model="formInfo.age"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">申请类型</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseFulltime" :range="fulltimeArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{fulltimeArray[formInfo.isFulltime]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">求职岗位</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入求职岗位" v-model="formInfo.jobTitle"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">工作时间(年)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入工作年限" v-model="formInfo.workYear"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">学历</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseEducation" :range="educationArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{educationArray[educationIndex]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">要求新增/月</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseSalary" :range="salaryArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{salaryArray[salaryIndex]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">允许平台推荐</view>
						</view>
						<view class="uni-list-cell-db">
							<switch :checked="formInfo.isRecommend !== 0" @change="switchIsRecommend" color="#108EE9" />
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">我的资质</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<checkbox-group name="aptitude" @change="chooseAptitude">
							<scroll-view scroll-y="true" style="height: 400upx;">
								<label class="zy-disable-flex uni-list-cell-pd" 
										v-for="item in aptitudeList" :key="item.name">
									<view>
										<checkbox :value="item.name" color="#108ee9"/>
									</view>
									<view>{{item.name}}</view>
								</label>
							</scroll-view>
						</checkbox-group>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">开放简历</view>
						</view>
						<view class="uni-list-cell-db">
							<switch :checked="formInfo.isShow !== 0" @change="switchIsShow" color="#108EE9" />
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">个人简介</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<textarea class="zy-list-form-memo" placeholder="请简单介绍下个人情况" v-model="formInfo.intorduce"/>
					</view>
				</view>
				<view class="zy-bottom-button">
					<button type="primary" formType="submit">保存简历</button>
				</view>
			</form>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		genderArray,
		educationArray,
		fulltimeArray,
		salaryArray
	} from '@/common/picker.data.js'
	
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				genderArray: genderArray,
				formInfo: {
					name: null,
					gender: 0,
					age: null,
					isFulltime: 0,
					jobTitle: null,
					workYear: null,
					education: null,
					salary: null,
					isRecommend: 0,
					aptitude: null,
					intorduce: null,
					isShow: 0
				},
				fulltimeArray: fulltimeArray,
				educationArray: educationArray,
				educationIndex: 0,
				salaryArray: salaryArray,
				salaryIndex: 0,
				aptitudeList: [
					{
						id: 1,
						name: '一级建造师'
					},
					{
						id: 2,
						name: '二级建造师'
					},
					{
						id: 3,
						name: '造价工程师'
					},
					{
						id: 4,
						name: '技工证'
					},
					{
						id: 5,
						name: '结构工程师'
					},
					{
						id: 6,
						name: '建筑师'
					},
					{
						id: 7,
						name: '监理工程师'
					},
					{
						id: 8,
						name: '注册咨询师'
					},
					{
						id: 9,
						name: '电气工程师'
					},
					{
						id: 10,
						name: '公用设备工程师'
					},
					{
						id: 11,
						name: '土木工程师'
					},
					{
						id: 12,
						name: '职称证书'
					},
					{
						id: 13,
						name: '中级职称证书'
					},
					{
						id: 14,
						name: '高级职称证书'
					},
					{
						id: 15,
						name: '八大员'
					},
					{
						id: 16,
						name: '其他证书'
					}
				]
			}
		},
		onLoad() {},
		methods: {
			// 提交简历信息
			addResumeInfo: function(e) {
				var formObj = e.detail.value;
				this.formInfo.education = this.educationArray[this.educationIndex];
				this.formInfo.salary = this.salaryArray[this.salaryIndex];
				var len = formObj.aptitude.length;
				if (len > 0) {
					for (var i = 0; i < len; i++) {
						if (this.formInfo.aptitude === null) {
							this.formInfo.aptitude = formObj.aptitude[i]
						} else {
							this.formInfo.aptitude += "," + formObj.aptitude[i]
						}
					}
				}
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(formObj));
				console.log(this.formInfo)
			},
			// 监听性别选中
			chooseGender(e) {
				this.formInfo.gender = e.target.value
			},
			// 监听申请类型
			chooseFulltime(e) {
				this.formInfo.isFulltime = e.target.value
			},
			// 监听学历选中
			chooseEducation(e) {
				this.educationIndex = e.target.value
			},
			// 监听薪资选中
			chooseSalary(e) {
				this.salaryIndex = e.target.value
			},
			// 监听是否允许平台推荐
			switchIsRecommend: function(e) {
				if (e.target.value) {
					this.formInfo.isRecommend = 1
				} else {
					this.formInfo.isRecommend = 0
				}
			},
			// 监听是否开放简历
			switchIsShow: function(e) {
				if (e.target.value) {
					this.formInfo.isShow = 1
				} else {
					this.formInfo.isShow = 0
				}
			},
			// 监听我的资质选中
			chooseAptitude(e) {
				var items = this.aptitudeList,
					values = e.detail.value;
				for (var i = 0, lenI = items.length; i < lenI; ++i) {
					const item = items[i]
					if(values.includes(item.value)){
						this.$set(item,'checked',true)
					}else{
						this.$set(item,'checked',false)
					}
				}
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/uni.css';

</style>
