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
								<zywork-icon type="iconxiangxia" />
							</view>
						</picker>
					</view>
				</view>
				<!-- <view class="uni-form-item uni-column zy-disable-flex zy-label-bottom-border">
					<view class="zy-text-bold">企业资质</view>
					<picker name="aptitude" mode="multiSelector" @columnchange="qualificationsChange" :value="conditionIndex" :range="conditionArray">
						<view class="zy-qualifications">
							{{conditionArray[0][conditionIndex[0]]}}，{{conditionArray[1][conditionIndex[1]]}}
							<zywork-icon type="iconxiangxia" />
						</view>
					</picker>
				</view> -->
				<view class="uni-form-item uni-column">
					<view class="zy-text-bold">选择项目类型</view>
					<checkbox-group name="projectType" @change="checkProjectTypeChange">
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="房建市政" :checked="building" color="#108ee9" />
								房建市政
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox value="水利工程" :checked="hydraulic" color="#108ee9" />
								水利工程
							</label>
						</view>
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="交通工程" :checked="traffic" color="#108ee9" />
								交通工程
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox @click="chooseCheckbox" value="政府采购" :checked="purchase" color="#108ee9" />
								政府采购
							</label>
						</view>
						<view class="zy-sub-project-type">
							<label class="zy-sub-project-type-item">
								<checkbox value="重点项目" :checked="important" color="#108ee9" />
								重点项目
							</label>
							<label class="zy-sub-project-type-item">
								<checkbox value="其他项目" :checked="other" color="#108ee9" />
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
					<input class="uni-input" name="keyword" v-model="subscrible.keyword" placeholder="请输入订阅关键字" />
					<text class="zy-text-warning">只有订阅政府采购才需要输入关键字</text>
				</view>
				<view class="uni-form-item uni-column">
					<view class="zy-text-bold">招标人(备选)</view>
					<view class="uni-list">
						<uni-swipe-action v-for="(item, index) in tendereeArray" :key="index" class="uni-list-cell uni-list-cell-pd"
						 :options="options" @click="confirmOptions(item)">
							<view>{{item}}</view>
						</uni-swipe-action>
						<label class="uni-list-cell uni-list-cell-pd" @click="toSearchCompPage">
							<zywork-icon type="icontianjia" color="#108ee9" size="28" />
						</label>
					</view>
				</view>
				<view class="uni-form-item uni-column zy-disable-flex">
					<view class="zy-text-bold" style="margin-right: 30upx;">是否开通</view>
					<switch name="isSubscribe" :checked="isSubscribe" color="#108EE9" />
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
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import {
		showInfoToast
	} from '@/common/util.js'
	import {
		jxCityArray
	} from '@/common/picker.data.js'
	import {
		getSubscribeByUserId,
		saveSubscribe
	} from '@/common/user-center.js'
	export default {
		components: {
			zyworkIcon,
			uniSwipeAction
		},
		data() {
			return {
				options: [{
					text: '删除',
					style: {
						backgroundColor: 'rgb(255,58,49)'
					}
				}],
				subscrible: null,
				cityArray: jxCityArray,
				cityIndex: 0,
				tendereeArray: [],
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
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.subscrible = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.subscrible = JSON.parse(payload);
			}
			if (this.subscrible.isRequest) {
				// 说明是从个人中心进来的
				this.initData();
			} else {
				// 从选择招标人页面过来的
				this.setValue()
			}
		},
		methods: {
			// 订阅城市选中监听
			chooseCity(e) {
				this.cityIndex = e.target.value;
				this.subscrible.city = this.cityArray[this.cityIndex];
			},
			// 政府采购选中监听
			chooseCheckbox: function(e) {
				if (this.showKeyword) {
					this.showKeyword = false
					this.subscrible.keyword = ''
				} else {
					this.showKeyword = true
				}
			},
			/** 监听项目类型 */
			checkProjectTypeChange: function(e) {
				var values = e.target.value;
				values.forEach((item, index) => {
					if (index === 0) {
						this.subscrible.projectType = item;
					} else {
						this.subscrible.projectType += ',' + item;
					}
					
				})
			},
			/**根据数组设置招标人*/
			setTenderee() {
				var tenderee = '';
				this.tendereeArray.forEach(item => {
					if (tenderee === '') {
						tenderee = item;
					} else {
						tenderee += ',' + item;
					}
				})
				this.subscrible.tenderee = tenderee;
			},
			// 提交form表单监听
			formSubmit: function(e) {
				var formObj = e.detail.value;
				// 设置是否开通订阅
				if (formObj.isSubscribe) {
					formObj.isSubscribe = 1;
				} else {
					formObj.isSubscribe = 0;
				}
				// 设置订阅城市
				formObj.city = this.cityArray[formObj.city];
				// 设置订阅类型
				formObj.aptitudeType = this.conditionArray[0][this.conditionIndex[0]] +
					',' + this.conditionArray[1][this.conditionIndex[1]];

				// 设置项目类型
				var projectType = formObj.projectType
				formObj.projectType = ''
				for (var i = 0; i < projectType.length; i++) {
					if (formObj.projectType === '') {
						formObj.projectType = projectType[i];
					} else {
						formObj.projectType += "," + projectType[i];
					}
				}
				
				// 设置招标人
				this.setTenderee();
				formObj.tenderee = this.subscrible.tenderee;
				
				// 设置金额
				formObj.minMoney *= 100;
				formObj.maxMoney *= 100;

				saveSubscribe(this, JSON.stringify(formObj))
			},
			// 重置form表单
			formReset: function(e) {
				console.log('清空数据')
				this.chosen = ''
				this.subscrible.tenderee = ''
				this.tendereeArray = []
			},
			setValue() {
				this.initTendereeArray();
				
				this.setProjectType();

				if (this.subscrible.isSubscribe === 0) {
					this.isSubscribe = false
				} else if (this.subscrible.isSubscribe === 1) {
					this.isSubscribe = true
				}

				if (this.subscrible.aptitudeType != null) {
					var aptitudeType = this.subscrible.aptitudeType.split(",")
					var typeIndex = 0;
					var levelIndex = 0;
					for (var i = 0; i < aptitudeType.length; i++) {
						if (i == 0) {
							typeIndex = this.conditionArray[0].findIndex(item => item === aptitudeType[i])
						} else {
							levelIndex = this.conditionArray[1].findIndex(item => item === aptitudeType[i])
						}
						this.conditionIndex = [
							[typeIndex],
							[levelIndex]
						]
					}
				}

				this.cityIndex = jxCityArray.findIndex(item => item === this.subscrible.city)
				
				if (this.subscrible.minMoney !== '' && this.subscrible.minMoney !== 0) {
					this.subscrible.minMoney = this.subscrible.minMoney / 100;
				}
				if (this.subscrible.maxMoney !== '' && this.subscrible.maxMoney !== 0) {
					this.subscrible.maxMoney = this.subscrible.maxMoney / 100;
				}
			},
			/** 设置订阅的项目类型 */
			setProjectType() {
				if (this.subscrible.projectType != null) {
					var projectType = this.subscrible.projectType.split(",")
					for (var i = 0, lenI = projectType.length; i < lenI; ++i) {
						if (projectType[i] == "房建市政") {
							this.building = true
						} else if (projectType[i] == "水利工程") {
							this.hydraulic = true
						} else if (projectType[i] == "交通工程") {
							this.traffic = true
						} else if (projectType[i] == "政府采购") {
							this.purchase = true
							this.showKeyword = true
						} else if (projectType[i] == "重点项目") {
							this.important = true
						} else if (projectType[i] == "其他项目") {
							this.other = true
						}
					}
				}
			},
			// 资质选中监听
			qualificationsChange: function(e) {
				console.log('修改的列为：' + e.detail.column + '，值为：' + e.detail.value)
				this.conditionIndex[e.detail.column] = e.detail.value
				this.$forceUpdate()
				var tempAptitudeTypeArray = this.subscrible.aptitudeType.split(',')
				if (e.detail.column === 0) {
					// 修改的是资质类型
					tempAptitudeTypeArray[0] = this.conditionArray[0][e.detail.value];
				} else if (e.detail.column === 1) {
					// 修改的是等级
					tempAptitudeTypeArray[1] = this.conditionArray[1][e.detail.value];
				}
				this.subscrible.aptitudeType = tempAptitudeTypeArray[0] + ',' + tempAptitudeTypeArray[1]
			},
			/** 初始化招标人数组 */
			initTendereeArray() {
				if (this.subscrible.tenderee !== null &&
					this.subscrible.tenderee !== undefined &&
					this.subscrible.tenderee.length > 0) {
					this.tendereeArray = this.subscrible.tenderee.split(',')
				}
			},
			/** 初始化数据 */
			initData() {
				getSubscribeByUserId(this);
			},
			/** 删除确认操作 */
			confirmOptions(name) {
				this.tendereeArray.shift(name);
				this.setTenderee();
			},
			/** 前往查询招标人页面 */
			toSearchCompPage() {
				if (this.tendereeArray.length > 15) {
					showInfoToast("最多订阅15个招标人，请先删除部分")
					return;
				}
				uni.redirectTo({
					url: '/pages-user-center/choose-comp/choose-comp?itemData=' + encodeURIComponent(JSON.stringify(this.subscrible))
				})
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
