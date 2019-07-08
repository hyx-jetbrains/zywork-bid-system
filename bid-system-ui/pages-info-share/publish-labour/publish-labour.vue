<template>
	<view>
		<view class="zy-uni-segmented-control">
			<uni-segmented-control :current="labourType.current" :values="labourType.items" v-on:clickItem="onClickItem"
			 styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<!-- 求职 -->
		<view v-if="labourType.current == 0">
			<view class="uni-common-mt">
				<form>
					<view class="uni-list">
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									姓名
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入真实姓名" v-model="labour.name"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">年龄</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入年龄" v-model="labour.age"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">工作地址</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择工作地址" v-model="labour.workAddr" @tap="chooseCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">详细地址</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入详细地址" v-model="labour.addrDesc"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									从事工种
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入从事工种" v-model="labour.workType"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">求职类型</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseJobType" :range="jobTypeArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{labour.jobType}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">待遇要求</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入待遇要求" v-model="labour.treatment"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									手机号
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入手机号" v-model="labour.phone"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-required">其他说明</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请填写说明" v-model="labour.memo" />
						</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addLabour" :disabled="disabled.labourBtn">发布信息</button>
						</cover-view>
					</view>
				</form>
			</view>
		</view>
		<!-- 应聘 -->
		<view v-else>
			<view class="uni-common-mt">
				<form>
					<view class="uni-list">
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									企业名称
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入企业名称" v-model="labourReq.compName"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">工作地址</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择工作地址" v-model="labourReq.workAddr" @tap="chooseCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">详细地址</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入详细地址" v-model="labourReq.addrDesc"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									从事工种
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入从事工种" v-model="labourReq.workType"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">求职类型</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseJobType" :range="jobTypeArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{labourReq.jobType}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">待遇要求</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入待遇要求" v-model="labourReq.treatment"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									手机号
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入手机号" v-model="labourReq.phone"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-required">其他说明</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请填写说明" v-model="labourReq.memo" />
						</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addLabourReq" :disabled="disabled.labourReqBtn">发布信息</button>
						</cover-view>
					</view>
				</form>
			</view>

		</view>
		<mpvue-city-picker :themeColor="themeColor" ref="mpvueCityPicker" :pickerValueDefault="cityPickerValueDefault"
		 @onCancel="onCancel" @onConfirm="onConfirm"></mpvue-city-picker>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import mpvueCityPicker from '@/components/mpvue-citypicker/mpvueCityPicker.vue'
	import cityData from '@/common/city.data.js';
	import {
		jobTypeArray,
		labourArray
	} from '@/common/picker.data.js'
	import {
		getDate,
		showInfoToast,
		BASE_URL,
		getUserToken,
		networkError,
		showSuccessToast,
		getUserPhone,
		isPhone
	} from '@/common/util.js'
	import * as infoPublish from '@/common/info-publish.js'
	import * as ResponseStatus from '@/common/response-status.js'

	export default {
		components: {
			uniSegmentedControl,
			zyworkIcon,
			mpvueCityPicker
		},
		data() {
			return {
				labourType: {
					current: 0,
					items: labourArray,
				},
				disabled: {
					labourReqBtn: false,
					labourBtn: false
				},
				labour: {
					id: null,
					name: null,
					age: null,
					workType: null,
					jobType: null,
					workAddr: null,
					addrDesc: null,
					treatment: null,
					phone: null,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				cityPickerValueDefault: [0, 0, 0],
				themeColor: '#007AFF',
				jobTypeArray: jobTypeArray,

				labourReq: {
					id: null,
					compName: null,
					workType: null,
					jobType: null,
					workAddr: null,
					addrDesc: null,
					treatment: null,
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
		onLoad(event) {
			uni.hideShareMenu();
			this.initPicker();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			if (payload !== undefined) {
				this.labourType.current = payload
			}
			this.labour.phone = this.labourReq.phone = getUserPhone();
		},
		methods: {
			/** 初始化选择器 */
			initPicker() {
				this.labour.jobType = this.labourReq.jobType = this.jobTypeArray[0];
			},
			/** 分段器选择类别 */
			onClickItem(index) {
				if (this.labourType.current !== index) {
					this.labourType.current = index
				}
			},
			/** 监听求职类型选择器 */
			chooseJobType: function(e) {
				this.labour.jobType = this.labourReq.jobType = this.jobTypeArray[e.target.value]
			},
			/** 选择地区 */
			chooseCity() {
				this.$refs.mpvueCityPicker.show()
				this.showBtn = false
			},
			/** 地区选择框确认 */
			onConfirm(e) {
				console.log(e);
				// this.pickerText = JSON.stringify(e)
				var tempAddrLabel = e.label
				var tempAddr = tempAddrLabel.replace(/-/g, '/');
				this.labour.workAddr = this.labourReq.workAddr = tempAddr
				this.showBtn = true
			},
			/** 地区选择框取消 */
			onCancel(e) {
				console.log(e)
				this.showBtn = true
			},
			/** 发布招聘信息 */
			addLabourReq() {
				infoPublish.saveLabourReq(this, this.labourReq);
			},
			/** 发布求职信息 */
			addLabour() {
				infoPublish.saveLabour(this, this.labour);
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
