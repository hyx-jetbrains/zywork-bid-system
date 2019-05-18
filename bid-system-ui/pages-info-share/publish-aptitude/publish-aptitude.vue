<template>
	<view>
		<!-- 发布资质转让 -->
		<view class="uni-common-mt">
			<form>
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">发布类型</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseAptitudeType" :range="aptitudeTypeArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{aptitude.typeName}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">标题</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入标题" v-model="aptitude.title"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">企业资质等级</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseCompanyAptitudeLevel" :range="companyAptitudeLevelArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{aptitude.compAptitudeLevel}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">企业资质类型</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseCompanyAptitudeType" :range="companyAptitudeTypeArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{aptitude.compAptitudeType}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">
								<text class="zy-list-form-required">*</text>
								手机号
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入手机号" v-model="aptitude.phone"></input>
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
						<textarea class="zy-list-form-memo" style="margin-bottom: 0upx;" placeholder="请填写备注" v-model="aptitude.memo" />
						</view>
					</view>
					<view v-if="isEnclosureShow">
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
										<view class="zy-text-warning">请放心上传你的资质证书，我们平台承诺仅为核实企业真实性，不会对外透露贵公司信息</view>
									</view>
								</view>
							</view>
						</view>
					</view>
					<view class="zy-bottom-button">
						<button type="primary" @click="addAptitudeTransfer" :disabled="disabled.aptitudeBtn">发布信息</button>
					</view>
				</form>
			</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		aptitudeTypeArray,
		companyAptitudeLevelArray,
		companyAptitudeTypeArray
	} from '@/common/picker.data.js'
	import {
		getDate,
		showInfoToast,
		BASE_URL,
		getUserToken,
		networkError,
		showSuccessToast
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
			zyworkIcon
		},
		data() {
			return {
				aptitudeTypeArray: aptitudeTypeArray,
				companyAptitudeTypeArray: companyAptitudeTypeArray,
				companyAptitudeLevelArray: companyAptitudeLevelArray,
				isEnclosureShow: true,
				disabled: {
					aptitudeBtn: false
				},
				aptitude: {
					id: null,
					userId: null,
					type: 0,
					typeName: null,
					title: null,
					compAptitudeLevel: null,
					compAptitudeType: null,
					phone: null,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
					resourceId: []
				},
				imageList: [],
				sourceTypeIndex: 2,
				sizeTypeIndex: 2,
				count: [1, 2, 3, 4, 5],
			}
		},
		onLoad() {
			this.initPicker()
		},
		methods: {
			/** 初始化下拉选择器 */
			initPicker() {
				this.aptitude.type = 0;
				this.aptitude.typeName = this.aptitudeTypeArray[this.aptitude.type];
				this.aptitude.compAptitudeLevel = this.companyAptitudeLevelArray[0];
				this.aptitude.compAptitudeType = this.companyAptitudeTypeArray[0];
				this.switchAptitudeType();
			},
			/** 监听发布资质类型选择器 */
			chooseAptitudeType: function(e) {
				let index = e.target.value
				this.aptitude.typeName = this.aptitudeTypeArray[index]
				this.aptitude.type = index
				this.switchAptitudeType()
			},
			/** 监听企业资质类型选择器 */
			chooseCompanyAptitudeType: function(e) {
				this.aptitude.compAptitudeType = this.companyAptitudeTypeArray[e.target.value]
				this.switchAptitudeType()
			},
			/** 监听企业资质等级选择器 */
			chooseCompanyAptitudeLevel: function(e) {
				this.aptitude.compAptitudeLevel = this.companyAptitudeLevelArray[e.target.value]
				this.switchAptitudeType()
			},
			// 切换资质转让类别
			switchAptitudeType() {
				if (this.aptitude.type == 0) {
					this.isEnclosureShow = false
					this.aptitude.title = '本人急购一家' + this.aptitude.compAptitudeLevel + this.aptitude.compAptitudeType + '资质的企业'
				} else {
					this.isEnclosureShow = true
					this.aptitude.title = '本人急售一家' + this.aptitude.compAptitudeLevel + this.aptitude.compAptitudeType + '资质的企业'
				}
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
							url: BASE_URL + '/aptitude-transfer/admin/upload-res',
							filePath: tempFilePaths[0],
							name: 'file',
							header: {
								'Authorization': 'Bearer ' + getUserToken()
							},
							success: function (res) {
								const data = JSON.parse(res.data);
								if (data.code = ResponseStatus.OK) {
									showSuccessToast(data.message);
									myThis.aptitude.resourceId.push(data.data.id);
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
			/** 发布资质转让信息 */
			addAptitudeTransfer() {
				infoPublish.saveAptitude(this, this.aptitude);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
