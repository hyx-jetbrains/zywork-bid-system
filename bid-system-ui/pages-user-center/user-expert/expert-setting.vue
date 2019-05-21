<template>
	<view>
		<view class="uni-common-mt">
			<form @submit="addExpertInfo">
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">姓名</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入真实姓名" v-model="formInfo.name"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">性别</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseGender" :range="genderArray">
								<view class="zy-disable-flex">
									<text class="zy-picker zy-text-info">{{genderArray[formInfo.gender]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">年龄</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入年龄" v-model="formInfo.age"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">专家类别</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<checkbox-group name="expertType" @change="chooseExpertType">
							<scroll-view scroll-y="true" style="height: 400upx;">
								<label class="zy-disable-flex uni-list-cell-pd" 
										v-for="item in expertTypeList" :key="item.id"
										v-if="item.name != '其他'">
									<view>
										<checkbox :value="item.id" color="#108ee9"/>
									</view>
									<view>{{item.name}}</view>
								</label>
							</scroll-view>
						</checkbox-group>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">申请类型</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseFulltime" :range="fulltimeArray">
								<view class="zy-disable-flex">
									<text class="zy-picker zy-text-info">{{fulltimeArray[formInfo.isFulltime]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">联系电话</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入联系电话" v-model="formInfo.phone"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">个人情况介绍</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<textarea class="zy-memo" placeholder="请简单介绍下个人情况" v-model="formInfo.memo"/>
					</view>
				</view>
				<view class="zy-bottom-button">
					<button type="primary" formType="submit">立即申请</button>
				</view>
			</form>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		genderArray,
		fulltimeArray
	} from '@/common/picker.data.js'
	import {
		getExpertQuesTionTypeByUserId,
		saveExpert
	} from '@/common/user-center.js'
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
					phone: null,
					memo: null,
					examineStatus: 0,
					expertQuestionTypeId: null,
				},
				expertTypeList: [],
				fulltimeArray: fulltimeArray
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			// 申请成为专家
			addExpertInfo: function(e) {
				var formObj = e.detail.value;
				for(var i = 0,lenI = formObj.expertType.length; i < lenI; ++i) {
					if(this.formInfo.expertQuestionTypeId == null) {
						this.formInfo.expertQuestionTypeId = formObj.expertType[i]
					} else {
						this.formInfo.expertQuestionTypeId += "," + formObj.expertType[i]
					}
				}
				console.log(this.formInfo.expertQuestionTypeId)
				saveExpert(this, this.formInfo)
			},
			// 监听性别选中
			chooseGender(e) {
				this.formInfo.gender = e.target.value
			},
			// 监听申请类型
			chooseFulltime(e) {
				this.formInfo.isFulltime = e.target.value
			},
			// 监听专家类别选中
			chooseExpertType(e) {
				var items = this.expertTypeList,
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
			initData() {
				getExpertQuesTionTypeByUserId(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/uni.css';
	
	.zy-picker {
		margin-left: 20upx;
		font-size: 28upx;
	}
	.zy-memo {
		margin-left: 40upx;
		margin-bottom: 150upx;
		padding-top: 20upx;
	}
</style>
