<template>
	<view>
		<view class="uni-padding-wrap uni-common-mt">
			<form @submit="formSubmit" @reset="formReset">
				<view class="uni-form-item uni-column zy-disable-flex zy-label-bottom-border">
					<view class="zy-text-bold">订阅城市</view>
					<view class="zy-disable-flex-right">
						<picker name="city" @change="chooseCity" :value="cityIndex" :range="cityArray">
							<view class="zy-disable-flex">
								<text>{{cityArray[cityIndex]}}</text>
								<zywork-icon type="iconxiangxia"/>
							</view>
						</picker>
					</view>
				</view>
				<view class="uni-form-item uni-column zy-disable-flex zy-label-bottom-border">
					<view class="zy-text-bold">企业资质</view>
					<picker name="aptitude" mode="multiSelector" @columnchange="qualificationsChange" :value="conditionIndex" :range="conditionArray">
						<view class="zy-qualifications">
							{{conditionArray[0][conditionIndex[0]]}}，{{conditionArray[1][conditionIndex[1]]}}
							<zywork-icon type="iconxiangxia"/>
						</view>
					</picker>
				</view>
				<view class="uni-form-item uni-column">
					<view class="zy-text-bold">选择项目类型</view>
					<checkbox-group name="projectType">
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="房建市政" :checked="building" color="#108ee9"/>
								房建市政
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox value="水利工程" :checked="hydraulic" color="#108ee9"/>
								水利工程
							</label>
						</view>
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="交通工程" :checked="traffic" color="#108ee9"/>
								交通工程
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox @click="chooseCheckbox" value="政府采购" :checked="purchase" color="#108ee9"/>
								政府采购
							</label>
						</view>
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="重点项目" :checked="important" color="#108ee9"/>
								重点项目
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox value="其他项目" :checked="other" color="#108ee9"/>
								其他项目
							</label>
						</view>
					</checkbox-group>
				</view>
				<view class="uni-form-item uni-column">
					<view class="zy-text-bold">金额区间(备选)</view>
					<view class="zy-money">
						¥
						<input class="uni-input" v-model="subscrible.minMoney" name="minMoney" type="number" />
						万
						——
						¥
						<input class="uni-input" v-model="subscrible.maxMoney" name="maxMoney" type="number" />
						万
					</view>
				</view>
				<view v-if="showKeyword" class="uni-form-item uni-column">
					<view class="zy-text-bold">关键字(备选)</view>
					<input class="uni-input" name="keyword" placeholder="请输入订阅关键字" />
				</view>
				<view class="uni-form-item uni-column">
					<view class="zy-text-bold">招标人(备选)</view>
					<view class="uni-list">
						<checkbox-group name="tenderee" @change="chooseTenderee">
							<label class="uni-list-cell uni-list-cell-pd" v-for="item in tendereeList" :key="item.value">
								<view>
									<checkbox :value="item.value" :checked="item.checked" color="#108ee9"/>
								</view>
								<view>{{item.name}}</view>
							</label>
						</checkbox-group>
					</view>
				</view>
				<view class="uni-form-item uni-column zy-disable-flex">
					<view class="zy-text-bold" style="margin-right: 30upx;">是否开通</view>
					<switch name="isSubscribe" :checked="isSubscribe" color="#108EE9"/>
				</view>
				<view class="uni-btn-v">
					<button type="primary" formType="submit">保存订阅</button>
					<button type="default" formType="reset">重置</button>
				</view>
			</form>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		jxCityArray
	} from '@/common/picker.data.js'
	import {
		getSubscribeByUserId,
		saveSubscribe
	} from '@/common/user-center.js'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				subscrible: null,
				cityArray: jxCityArray,
				cityIndex: 0,
				tendereeList: [
					{
						value: '某某公司',
						name: '某某公司'
					},
					{
						value: '某某公司1',
						name: '某某公司1'
					},
					{
						value: '某某公司2',
						name: '某某公司2'
					},
					{
						value: '某某公司3',
						name: '某某公司3'
					}
				],
				conditionArray: [
					['房建市政', '水利工程', '交通工程', '重点项目', '其他项目'],
					['一级', '二级', '三级']
				],
				conditionIndex: [0, 0],
				showKeyword: false,
				building: false,
				hydraulic: false,
				traffic: false,
				purchase: false,
				important: false,
				other: false,
				isSubscribe: false
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			// 订阅城市选中监听
			chooseCity(e) {
				this.cityIndex = e.target.value
			},
			// 政府采购选中监听
			chooseCheckbox: function(e) {
				if (this.showKeyword) {
					this.showKeyword = false
				} else {
					this.showKeyword = true
				}
			},
			// 提交form表单监听
			formSubmit: function(e) {
				var formObj = e.detail.value;
				if (formObj.isSubscribe) {
					formObj.isSubscribe = 1;
				} else {
					formObj.isSubscribe = 0;
				}
				formObj.city = this.cityArray[formObj.city];
				formObj.aptitudeType =  this.conditionArray[0][this.conditionIndex[0]]
						+ ',' + this.conditionArray[1][this.conditionIndex[1]];
				
				var projectType = formObj.projectType
				formObj.projectType = ""
				for(var i=0; i<projectType.length; i++ ) {
					formObj.projectType += projectType[i]
					if(i < projectType.length-1) {
						formObj.projectType += ","
					}					
				}
				
				var tenderee = formObj.tenderee
				formObj.tenderee = ""
				for(var i=0; i<tenderee.length; i++ ) {
					formObj.tenderee += tenderee[i]
					if(i < tenderee.length-1) {
						formObj.tenderee += ","
					}					
				}
				
				saveSubscribe(this, JSON.stringify(formObj))
			},
			// 重置form表单
			formReset: function(e) {
				console.log('清空数据')
				this.chosen = ''
			},
			// 选中招标人监听
			chooseTenderee: function (e) {
				var items = this.tendereeList,
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
			setValue() {
				var items = this.tendereeList
				if(this.subscrible.tenderee != null) {
					var tenderee = this.subscrible.tenderee.split(",")
					for (var i = 0, lenI = items.length; i < lenI; ++i) {
						const item = items[i]
						for(var j = 0, lenJ = tenderee.length; j< lenJ; j++) {
							if(tenderee[j] == item.value) {
								this.$set(item,'checked',true)
							}
						}
					}
				}
				
				if(this.subscrible.projectType != null) {
					var projectType = this.subscrible.projectType.split(",")
					for(var i = 0, lenI = projectType.length; i < lenI; ++i) {
						if(projectType[i] == "房建市政") {
							this.building = true
						} else if(projectType[i] == "水利工程") {
							this.hydraulic = true
						} else if(projectType[i] == "交通工程") {
							this.traffic = true
						}else if(projectType[i] == "政府采购") {
							this.purchase = true
						}else if(projectType[i] == "重点项目") {
							this.important = true
						}else if(projectType[i] == "其他项目") {
							this.other = true
						}
					}
				}
				
				if(this.subscrible.isSubscribe === 0) {
					this.isSubscribe = false
				} else if(this.subscrible.isSubscribe === 1) {
					this.isSubscribe = true
				}
				
				if(this.subscrible.aptitudeType != null) {
					var aptitudeType = this.subscrible.aptitudeType.split(",")
					var typeIndex = 0;
					var levelIndex = 0;
					for(var i=0; i<aptitudeType.length; i++) {
						
						 if(i == 0) {
							  typeIndex = this.conditionArray[0].findIndex(item => item===aptitudeType[i])
						 } else {
							 levelIndex = this.conditionArray[1].findIndex(item => item===aptitudeType[i])
						 }
						 this.conditionIndex =[[typeIndex],[levelIndex]]
					}
				}
				
				this.cityIndex = jxCityArray.findIndex(item => item===this.subscrible.city)
				
			},
			// 资质选中监听
			qualificationsChange: function(e) {
				console.log('修改的列为：' + e.detail.column + '，值为：' + e.detail.value)
				this.conditionIndex[e.detail.column] = e.detail.value
				this.$forceUpdate()
			},
			initData() {
				getSubscribeByUserId(this);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/uni.css';
	
	.uni-list-cell {
		justify-content: flex-start
	}

	.zy-sub-project-type {
		display: flex;
		flex-direction: row;
		justify-content: between;
		align-items: center;
	}
	
	.zy-sub-project-type-item {
		flex-grow: 1;
		flex-direction: column;
		align-items: center;
	}

	.zy-label-bottom-border {
		border-bottom: 1upx solid $seperator-color;
	}
	
	.zy-qualifications {
		display: flex;
		flex-direction: row;
		align-items: center;
		margin-right: 10upx;
		margin-left: 300upx;
	}
	
	.zy-money {
		display: flex;
		flex-direction: row;
		align-items: center;
	}
	.zy-money input {
		width: 80upx;
		margin: 0 10upx;
	}
	
</style>