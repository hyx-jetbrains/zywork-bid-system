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
								<checkbox value="房建市政" color="#108ee9"/>
								房建市政
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox value="水利工程" color="#108ee9"/>
								水利工程
							</label>
						</view>
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="交通工程" color="#108ee9"/>
								交通工程
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox @click="chooseCheckbox" value="政府采购" color="#108ee9"/>
								政府采购
							</label>
						</view>
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="重点项目" color="#108ee9"/>
								重点项目
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox value="其他项目" color="#108ee9"/>
								其他项目
							</label>
						</view>
					</checkbox-group>
				</view>
				<view class="uni-form-item uni-column">
					<view class="zy-text-bold">金额区间(备选)</view>
					<view class="zy-money">
						¥
						<input class="uni-input" name="minMoney" type="number" />
						万
						——
						¥
						<input class="uni-input" name="maxMoney" type="number" />
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
									<checkbox :value="item.value" color="#108ee9"/>
								</view>
								<view>{{item.name}}</view>
							</label>
						</checkbox-group>
					</view>
				</view>
				<view class="uni-form-item uni-column zy-disable-flex">
					<view class="zy-text-bold" style="margin-right: 30upx;">是否开通</view>
					<switch name="isSubscrible" color="#108EE9"/>
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
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
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
				showKeyword: false
			}
		},
		onLoad() {},
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
				if (formObj.isSubscrible) {
					formObj.isSubscrible = 1;
				} else {
					formObj.isSubscrible = 0;
				}
				formObj.city = this.cityArray[formObj.city];
				formObj.aptitude = this.conditionArray[0][this.conditionIndex[0]] 
						+ ',' + this.conditionArray[1][this.conditionIndex[1]];
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(formObj));
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
			// 资质选中监听
			qualificationsChange: function(e) {
				console.log('修改的列为：' + e.detail.column + '，值为：' + e.detail.value)
				this.conditionIndex[e.detail.column] = e.detail.value
				this.$forceUpdate()
			},
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