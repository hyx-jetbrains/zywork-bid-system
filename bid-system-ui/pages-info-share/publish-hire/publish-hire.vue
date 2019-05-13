<template>
	<view>
		<!-- 发布其他岗位招聘 -->
		<view class="uni-common-mt">
			<form @submit="addRecruit">
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">招聘岗位</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入招聘岗位" v-model="recruit.jobTitle"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">招聘类型</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseFulltime" :range="fulltimeArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{fulltimeArray[recruit.isFulltime]}}</text>
									<zywork-icon type="iconxiangxia"/>
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">工作时间(年)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入工作时间/年" v-model="recruit.workYear"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">要求学历</view>
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
							<view class="uni-label zy-text-bold zy-list-form-label">提供月薪</view>
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
							<view class="uni-label zy-text-bold zy-list-form-label">工作地址</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="选择工作地址" v-model="recruit.workAddr"
								@tap="chooseCity"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold">职位描述</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请输入职位描述" v-model="recruit.memo" />
					</view>
					<view class="zy-bottom-button">
						<button type="primary" formType="submit">发布信息</button>
					</view>
				</view>
			</form>
		</view>
		<mpvue-city-picker :themeColor="themeColor" ref="mpvueCityPicker" :pickerValueDefault="cityPickerValueDefault"
			@onCancel="onCancel" @onConfirm="onConfirm"></mpvue-city-picker>
	</view>
</template>

<script>
	import mpvueCityPicker from '@/components/mpvue-citypicker/mpvueCityPicker.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import { 
		fulltimeArray,
		educationArray,
		salaryArray
	} from '@/common/picker.data.js'
	export default {
		components: {
			mpvueCityPicker,
			zyworkIcon
		},
		data() {
			return {
				recruit: {
					id: null,
					userId: null,
					jobTitle: null,
					isFulltime: 0,
					workYear: null,
					education: null,
					salary: null,
					workAddr: null,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				fulltimeArray: fulltimeArray,
				educationArray: educationArray,
				educationIndex: 0,
				salaryArray: salaryArray,
				salaryIndex: 0,
				cityPickerValueDefault: [0, 0, 1],
				themeColor: '#007AFF',
			}
		},
		onLoad() {},
		methods: {
			// 监听招聘类型
			chooseFulltime(e) {
				this.recruit.isFulltime = e.target.value
			},
			// 监听学历选中
			chooseEducation(e) {
				this.educationIndex = e.target.value
				this.recruit.education = this.educationArray[this.educationIndex]
			},
			// 监听薪资选中
			chooseSalary(e) {
				this.salaryIndex = e.target.value
				this.recruit.salary = this.salaryArray[this.salaryIndex]
			},
			/** 选择地区 */
			chooseCity() {
				this.$refs.mpvueCityPicker.show()
			},
			/** 地区选择框确认 */
			onConfirm(e) {
				var tempAddrLabel = e.label
				var tempAddr = ''
				var tempAddrArray = tempAddrLabel.split('-')
				for (var i = 0; i < tempAddrArray.length; i++) {
					if (tempAddr == '') {
						tempAddr = tempAddrArray[i]
					} else {
						tempAddr += '/' + tempAddrArray[i]
					}
				}
				this.recruit.workAddr = tempAddr
			},
			/** 地区选择框取消 */
			onCancel(e) {
				console.log(e)
			},
			/** 发布招聘信息 */
			addRecruit: function(e) {
				var formObj = e.detail.value;
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(formObj));
				console.log(this.recruit)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
