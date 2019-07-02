<template>
	<view>
		<view class="zy-uni-segmented-control">
			<uni-segmented-control :current="builderType.current" :values="builderType.items" v-on:clickItem="onClickItem" styleType="button"
				activeColor="#108EE9"></uni-segmented-control>
		</view>
		<!-- 招聘 -->
		<view v-if="builderType.current == 0">
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
								<input class="uni-input" type="text" :disabled="false" placeholder="输入真实姓名" v-model="builderReq.name"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									所需人才
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入所需人才" v-model="builderReq.people"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									所需人数
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入所需人才数量" v-model="builderReq.peopleCount"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">薪资</view>
							</view>
							<view class="uni-list-cell-db">
								<!-- <picker @change="chooseSalary" :range="salaryArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{builderReq.salary}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker> -->
								<input class="uni-input" type="number" :disabled="false" placeholder="输入薪资(元/年)" v-model="builderReq.salary"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									公司地址
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择公司地址" v-model="builderReq.compAddr" @tap="chooseCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									公司名称
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入公司名称" v-model="builderReq.compName"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									手机号
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入手机号" v-model="builderReq.phone"></input>
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
							<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请填写说明" v-model="builderReq.memo" />
							</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addBuilderReq" :disabled="disabled.buildeReqBtn">发布信息</button>
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
									姓名
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="false" placeholder="输入真实姓名" v-model="builder.name"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">性别</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseGender" :range="genderArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{genderArray[builder.gender]}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">出生年份</view>
							</view>
							<view class="uni-list-cell-db">
								<picker mode="date" :value="builder.birthday" :start="startBirthdayDate" :end="endBirthdayDate" placeholder="选择生日"
								 @change="birdayChange">
									<view class="uni-input">{{builder.birthday}}</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">证件地址</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true" placeholder="选择证件地址" v-model="builder.certificateAddress"
								 @tap="chooseCity"></input>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">证书类别</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseCertificateType" :range="certificateTypeArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{builder.certificateType}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">证书专业类别</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseCertificateMajorType" :range="certificateMajorTypeArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{builder.certificateMajorType}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">证书状态</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseCertificateStatus" :range="certificateStatusArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{builder.certificateStatus}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">证书注册状态</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseCertificateRegStatus" :range="certificateRegStatusArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{builder.certificateRegStatus}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label">期望薪资</view>
							</view>
							<view class="uni-list-cell-db">
								<picker @change="chooseSalary" :range="salaryArray">
									<view class="zy-disable-flex">
										<text class="zy-list-form-picker zy-text-info">{{builder.salary}}</text>
										<zywork-icon type="iconxiangxia" />
									</view>
								</picker>
							</view>
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold zy-list-form-label zy-required">
									手机号
								</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="number" :disabled="false" placeholder="输入手机号" v-model="builder.phone"></input>
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
							<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;z-index: -99999;" placeholder="请填写说明" v-model="builder.memo" />
						</view>
						<view class="uni-list-cell">
							<view class="uni-pd">
								<view class="uni-label zy-text-bold">上传附件</view>
							</view>
							<view class="uni-list-cell-db">
								<input class="uni-input" type="text" :disabled="true"></input>
							</view>
						</view>
						<view class="uni-list list-pd" style="margin-bottom: 150upx;">
							<view class="uni-list-cell cell-pd">
								<view class="uni-uploader">
									<view class="uni-uploader-head zy-upload-head">
										<view class="uni-uploader-title">点击可预览选好的图片</view>
										<view class="uni-uploader-info">{{imageList.length}}/5</view>
									</view>
									<view class="uni-uploader-body zy-upload-body">
										<view class="uni-uploader__files">
											<block v-for="(image,index) in imageList" :key="index">
												<view class="uni-uploader__file">
													<image class="uni-uploader__img" :src="image" :data-src="image" @tap="previewImage"></image>
												</view>
											</block>
											<view class="uni-uploader__input-box">
												<view class="uni-uploader__input" @tap="chooseImage"></view>
											</view>
										</view>
										<view class="zy-text-warning">上传证书/证件，不超过5张(非必填)</view>
									</view>
								</view>
							</view>
						</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addBuilder" :disabled="disabled.buildeBtn">发布信息</button>
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
		certificateTypeArray, 
		certificateMajorTypeObj, 
		salaryArray, 
		genderArray,
		builderTypeArray,
		certificateStatusArray,
		certificateRegStatusArray
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
	
	var sourceType = [
		['camera'],
		['album'],
		['camera', 'album']
	]
	var sizeType = [
		['compressed'],
		['original'],
		['compressed', 'original']
	]

	export default {
		components: {
			uniSegmentedControl,
			zyworkIcon,
			mpvueCityPicker
		},
		data() {
			return {
				builderType: {
					current: 0,
					items: builderTypeArray,
				},
				genderArray: genderArray,
				disabled: {
					buildeReqBtn: false,
					builderBtn: false
				},
				builder: {
					id: null,
					userId: null,
					name: null,
					gender: 0,
					birthday: null,
					certificateAddress: null,
					certificateType: null,
					certificateMajorType: null,
					certificateStatus: null,
					certificateRegStatus: null,
					salary: null,
					phone: null,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
					resourceId: []
				},
				startBirthdayDate: getDate('start'),
				endBirthdayDate: getDate('end'),
				cityPickerValueDefault: [0, 0, 0],
				themeColor: '#007AFF',
				certificateTypeArray: certificateTypeArray,
				tempCertificateMajorTypeObj: certificateMajorTypeObj,
				certificateMajorTypeArray: [],
				certificateStatusArray: certificateStatusArray,
				certificateRegStatusArray: certificateRegStatusArray,
				salaryArray: salaryArray,
				imageList: [],
				sourceTypeIndex: 2,
				sizeTypeIndex: 2,
				count: [1, 2, 3, 4, 5],
				builderReq: {
					id: null,
					userId: null,
					name: null,
					phone: null,
					memo: null,
					people: null,
					peopleCount: null,
					salary: null,
					compAddr: null,
					compName: null,
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
				this.builderType.current = payload
			}
			this.builder.phone = this.builderReq.phone = getUserPhone();
		},
		methods: {
			/** 初始化选择器 */
			initPicker() {
				// 证书类别默认选中第一个
				this.builder.gender = 0;
				this.builder.birthday = getDate({
					format: true
				})
				this.builder.certificateType = this.certificateTypeArray[0];
				this.initCertificateMajorType(this.builder.certificateType);
				this.builder.certificateStatus = this.certificateStatusArray[0];
				this.builder.certificateRegStatus = this.certificateRegStatusArray[0];
				this.builder.salary = this.salaryArray[0];
			},
			/** 分段器选择类别 */
			onClickItem(index) {
				if (this.builderType.current !== index) {
					this.builderType.current = index
				}
			},
			/** 监听生日选择器 */
			birdayChange: function(e) {
				this.builder.birthday = e.target.value
			},
			/** 监听性别选择器 */
			chooseGender: function(e) {
				this.builder.gender = e.target.value
			},
			/** 监听证书类别选择器 */
			chooseCertificateType: function(e) {
				this.builder.certificateType = this.certificateTypeArray[e.target.value]
				this.initCertificateMajorType(this.builder.certificateType)
			},
			/** 监听证书专业类别选择器 */
			chooseCertificateMajorType: function(e) {
				this.builder.certificateMajorType = this.certificateMajorTypeArray[e.target.value]
			},
			/** 监听证书状态选择器 */
			chooseCertificateStatus: function(e) {
				this.builder.certificateStatus = this.certificateStatusArray[e.target.value]
			},
			/** 监听证书注册状态选择器 */
			chooseCertificateRegStatus: function(e) {
				this.builder.certificateRegStatus = this.certificateRegStatusArray[e.target.value]
			},
			/** 监听薪资选择器 */
			chooseSalary: function(e) {
				this.builder.salary = this.builderReq.salary = this.salaryArray[e.target.value]
			},
			/** 初始化证书专业类别 */
			initCertificateMajorType(val) {
			  this.certificateMajorTypeArray = []
			  this.certificateMajorTypeArray = this.tempCertificateMajorTypeObj[val]
			  if (this.certificateMajorTypeArray !== undefined && this.certificateMajorTypeArray.length > 0) {
				// 如果证书专业类别有值，则默认选中第一个
				this.builder.certificateMajorType = this.certificateMajorTypeArray[0]
			  }
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
				this.builder.certificateAddress = this.builderReq.compAddr = tempAddr
				this.showBtn = true
			},
			/** 地区选择框取消 */
			onCancel(e) {
				console.log(e)
				this.showBtn = true
			},
			/** 选择图片上传 */
			chooseImage: async function() {
				if (this.imageList.length === 5) {
					let isContinue = await this.isFullImg();
					if (!isContinue) {
						return;
					}
				}
				var myThis = this;
				uni.chooseImage({
					sourceType: sourceType[this.sourceTypeIndex],
					sizeType: sizeType[this.sizeTypeIndex],
					count: this.imageList.length + this.count[this.countIndex] > 5 ? 5 - this.imageList.length : this.count[this.countIndex],
					success: (chooseImageRes) => {
						const tempFilePaths = chooseImageRes.tempFilePaths;
						uni.showLoading({
							title: '正在上传'
						})
						uni.uploadFile({
							url: BASE_URL + '/builder/user/upload-res',
							filePath: tempFilePaths[0],
							name: 'file',
							header: {
								'Authorization': 'Bearer ' + getUserToken()
							},
							success: function (res) {
								const data = JSON.parse(res.data);
								if (data.code = ResponseStatus.OK) {
									showSuccessToast(data.message);
									myThis.builder.resourceId.push(data.data.id);
									myThis.imageList = myThis.imageList.concat(tempFilePaths);
								} else {
									showInfoToast(data.message);
								}
							},
							fail: () => {
								networkError()
							},
							complete: () => {
								uni.hideLoading()
							}
						});
					}
				})
			},
			/** 清空图片 */
			isFullImg: function() {
				return new Promise((res) => {
					uni.showModal({
						content: "已经有5张图片了,是否清空现有图片？",
						success: (e) => {
							if (e.confirm) {
								this.imageList = [];
								res(true);
							} else {
								res(false)
							}
						},
						fail: () => {
							res(false)
						}
					})
				})
			},
			/** 预览图片 */
			previewImage: function(e) {
				var current = e.target.dataset.src
				uni.previewImage({
					current: current,
					urls: this.imageList
				})
			},
			/** 发布招聘信息 */
			addBuilderReq() {
				infoPublish.saveBuilderReq(this, this.builderReq);
			},
			/** 发布应聘信息 */
			addBuilder() {
				infoPublish.saveBuilder(this, this.builder);
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
</style>
