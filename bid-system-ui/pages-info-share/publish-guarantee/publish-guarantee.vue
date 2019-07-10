<template>
	<view>
		<!-- 发布申请保函 -->
		<view class="uni-common-mt">
			<form>
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								绑定开标项目
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="请选择开标项目" v-model="guarantee.projectName"
							 @click="showProjectDrawer" />
							<uni-drawer :visible="projectDrawer" mode="right" @close="closeProjectDrawer">
								<uni-list>
									<view class="zy-search-bar zy-project-search">
										<zywork-icon type="iconchaxun" />
										<input type="text" v-model="projectPager.title" placeholder="输入项目名称搜索" @confirm="searchProject" />
									</view>
									<view class="zy-project-item" v-for="(projectItem, index) in projects" :key="index" @click="chooseProject(projectItem.project)">
										<view class="zy-disable-flex">
											<view>
												<text>{{projectItem.project.projectType}}</text>
												<text style="margin-left: 30upx;">[{{projectItem.project.city}}]</text>
											</view>
											<view class="zy-disable-flex-right" style="color: #108EE9">{{projectItem.project.markStatus}}</view>
										</view>
										<view class="zy-text-mini" style="color: #dd524d; text-align: right;">
											开标时间：
											<text v-if="projectItem.project.openMarkTime !== ''" class="zy-text-mini" style="color: #dd524d;">
												{{projectItem.project.openMarkTime}}
											</text>
											<text v-else class="zy-text-mini" style="color: #dd524d;">
												暂无
											</text>
										</view>
										<view class="zy-text-bold">
											{{projectItem.project.title}}
										</view>
									</view>
									<!-- <zywork-list-item v-for="(projectItem, index) in projects" :key="index" :title="projectItem.title" note="点击选择"
										 @click="chooseProject(projectItem.id, projectItem.title)"></zywork-list-item> -->
								</uni-list>
							</uni-drawer>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">开标时间</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="开标时间" v-model="guarantee.openMarkTime"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">招标单位</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="招标单位" v-model="guarantee.markUnitName"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">工期(天)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="工期" v-model="guarantee.constructionPeriod"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">担保金额(万元)</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="true" placeholder="担保金额" v-model="guarantee.assurePrice"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">担保公司</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseGuaranteeCompany" :range="guaranteeCompanyArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{guarantee.guaranteeComp}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								保函费(元)
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="number" :disabled="false" placeholder="输入保函费" v-model="guarantee.guaranteePrice"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								企业基本户开户行
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入开户行" v-model="guarantee.bank"></input>
						</view>
					</view>
					<view class="uni-list list-pd">
						<view class="cell-pd">
							<view class="uni-uploader">
								<view class="uni-uploader-head zy-upload-head">
									<view class="uni-uploader-title">点击可预览选好的图片</view>
								</view>
								<view class="uni-uploader-body zy-upload-body">
									<view class="uni-uploader__files">
										<block v-if="guarantee.bankResSrc">
											<view class="uni-uploader__file">
												<image class="uni-uploader__img" :src="guarantee.bankResSrc" :data-src="guarantee.bankResSrc" @tap="previewImage"></image>
											</view>
										</block>
										<view class="uni-uploader__input-box">
											<view class="uni-uploader__input" @tap="chooseImage(0)"></view>
										</view>
									</view>
									<view class="zy-text-warning">上传开户银行证明文件图片</view>
								</view>
							</view>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								申请单位
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入申请单位" v-model="guarantee.applicant"></input>
						</view>
					</view>
					<view class="uni-list list-pd">
						<view class="cell-pd">
							<view class="uni-uploader">
								<view class="uni-uploader-head zy-upload-head">
									<view class="uni-uploader-title">点击可预览选好的图片</view>
								</view>
								<view class="uni-uploader-body zy-upload-body">
									<view class="uni-uploader__files">
										<block v-if="guarantee.applicantResSrc">
											<view class="uni-uploader__file">
												<image class="uni-uploader__img" :src="guarantee.applicantResSrc" :data-src="guarantee.applicantResSrc" @tap="previewImage"></image>
											</view>
										</block>
										<view class="uni-uploader__input-box">
											<view class="uni-uploader__input" @tap="chooseImage(1)"></view>
										</view>
									</view>
									<view class="zy-text-warning">上传企业的营业执照</view>
								</view>
							</view>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								联系人
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入联系人" v-model="guarantee.name"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label zy-required">
								手机号
							</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入手机号" v-model="guarantee.phone"></input>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">取件方式</view>
						</view>
						<view class="uni-list-cell-db">
							<picker @change="chooseGuaranteePickUpType" :range="pickUpTypeArray">
								<view class="zy-disable-flex">
									<text class="zy-list-form-picker zy-text-info">{{guarantee.pickUpType}}</text>
									<zywork-icon type="iconxiangxia" />
								</view>
							</picker>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-pd">
							<view class="uni-label zy-text-bold zy-list-form-label">地址</view>
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" type="text" :disabled="false" placeholder="输入保函邮寄地址(顺丰邮寄必填)" v-model="guarantee.address"></input>
						</view>
					</view>
					<view class="zy-bottom-button">
						<cover-view v-if="showBtn">
							<button type="primary" @click="addGuarantee" :disabled="disabled.guaranteeBtn">确认申请</button>
						</cover-view>
					</view>
				</view>
			</form>
		</view>
		<view class="zy-guarantee-memo" v-if="memoArray.length > 0">
			<view>
				注：
			</view>
			<view v-for="(item, index) in memoArray" :key="index">
				{{item}}
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniDrawer from '@/components/uni-drawer/uni-drawer.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import * as infoPublish from '@/common/info-publish.js'
	import {
		getProjectList
	} from '@/common/project-info.js'
	import {
		guaranteeCompanyArray,
		pickUpTypeArray
	} from '@/common/picker.data.js'
	import {
		getUserPhone,
		IMAGE_BASE_URL,
		showInfoToast,
		BASE_URL,
		getUserToken,
		networkError,
		showSuccessToast,
		GUARANTEE_CONFIG
	} from '@/common/util.js'
	import {
		getGuaranteeHistoryByUserId
	} from '@/common/user-center.js'

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
			uniDrawer,
			uniList,
			zyworkListItem,
			zyworkIcon
		},
		data() {
			return {
				disabled: {
					guaranteeBtn: false
				},
				projectDrawer: false,
				projectPager: {
					pageNo: 1,
					pageSize: 10,
					isActive: 0,
					releaseStatus: '已发布',
					isGuarantee: 1,
					title: ''
				},
				projects: [],
				guarantee: {
					id: null,
					projectId: null,
					projectName: null,
					openMarkTime: null,
					markUnitName: null,
					constructionPeriod: null,
					assurePrice: null,
					guaranteeComp: null,
					guaranteePrice: null,
					applicant: null,
					name: null,
					phone: null,
					address: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
					bank: null,
					bankResId: null,
					bankResSrc: null,
					pickUpType: null,
					applicantResId: null,
					applicantResSrc: null,
				},
				guaranteeCompanyArray: guaranteeCompanyArray,
				guaranteeCompanyIndex: 0,
				pickUpTypeArray: pickUpTypeArray,
				pickUpTypeIndex: 0,
				showBtn: true,
				imageList: [],
				sourceTypeIndex: 2,
				sizeTypeIndex: 2,
				count: [1, 2, 3, 4, 5],
				memoArray: []
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			if (payload) {
				try {
					this.guarantee = JSON.parse(decodeURIComponent(payload));
				} catch (error) {
					this.guarantee = JSON.parse(payload);
				}
			}
			this.initData();
		},
		methods: {
			/** 初始化数据 */
			initData() {
				this.initPicker();
				this.guarantee.phone = getUserPhone();
				// 获取说明配置
				this.initGuaranteeMemoConfig();
				// 获取历史申请记录
				getGuaranteeHistoryByUserId(this);
			},
			initGuaranteeMemoConfig() {
				var guarantee = uni.getStorageSync(GUARANTEE_CONFIG);
				if (!guarantee) {
					return;
				}
				var tempMemo = guarantee.memo;
				this.memoArray = tempMemo.split("#");
			},
			/** 初始化下拉框 */
			initPicker() {
				this.guarantee.guaranteeComp = this.guaranteeCompanyArray[this.guaranteeCompanyIndex];
				this.guarantee.pickUpType = this.pickUpTypeArray[this.pickUpTypeIndex];
			},
			/** 选择开标项目 */
			chooseProject(project) {
				this.guarantee.projectId = project.id
				this.guarantee.projectName = project.title
				if (project.openMarkTime) {
					this.guarantee.openMarkTime = project.openMarkTime
				}
				this.guarantee.markUnitName = project.markUnitName
				this.guarantee.constructionPeriod = project.constructionPeriod
				this.guarantee.assurePrice = project.assurePrice / 100
				this.projectDrawer = false
				this.showBtn = true;
			},
			/** 监听担保公司选择框 */
			chooseGuaranteeCompany: function(e) {
				this.guaranteeCompanyIndex = e.target.value
				this.guarantee.guaranteeComp = this.guaranteeCompanyArray[this.guaranteeCompanyIndex]
			},
			/** 监听取件方式选择框 */
			chooseGuaranteePickUpType: function(e) {
				this.pickUpTypeIndex = e.target.value
				this.guarantee.pickUpType = this.pickUpTypeArray[this.pickUpTypeIndex]
			},
			/** 显示项目选择抽屉 */
			showProjectDrawer() {
				this.projectDrawer = true;
				this.showBtn = false;
				this.searchProject();
			},
			/** 关闭项目选择抽屉 */
			closeProjectDrawer() {
				this.projectDrawer = false;
				this.showBtn = true;
			},
			/** 查询项目 */
			searchProject() {
				getProjectList(this, 'init', this.projectPager);
			},
			/** 确认申请保函 */
			addGuarantee() {
				this.guarantee.assurePrice *= 100;
				this.guarantee.guaranteePrice *= 100;
				infoPublish.saveGuarantee(this, this.guarantee);
			},
			/** 选择图片上传 */
			chooseImage: async function(type) {
				// if (this.imageList.length === 2) {
				// 	let isContinue = await this.isFullImg();
				// 	if (!isContinue) {
				// 		return;
				// 	}
				// }
				var myThis = this;
				uni.chooseImage({
					sourceType: sourceType[this.sourceTypeIndex],
					sizeType: sizeType[this.sizeTypeIndex],
					count: 1,
					success: (chooseImageRes) => {
						const tempFilePaths = chooseImageRes.tempFilePaths;
						uni.showLoading({
							title: '正在上传'
						})
						uni.uploadFile({
							url: BASE_URL + '/guarantee/user/upload-res',
							filePath: tempFilePaths[0],
							name: 'file',
							formData: {
								'type': type
							},
							header: {
								'Authorization': 'Bearer ' + getUserToken()
							},
							success: function(res) {
								const data = JSON.parse(res.data);
								if (data.code = ResponseStatus.OK) {
									showSuccessToast('上传成功');
									const id = data.data.id;
									const url = IMAGE_BASE_URL + '/' + data.data.url;
									const tempType = data.message;
									if (tempType == 0) {
										myThis.guarantee.bankResId = id;
										myThis.guarantee.bankResSrc = url;
									} else if (tempType == 1) {
										myThis.guarantee.applicantResId = id;
										myThis.guarantee.applicantResSrc = url;
									}
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
						content: "是否清空现有图片？",
						success: (e) => {
							if (e.confirm) {
								this.imageList = [];
								this.guarantee.bankResId = '';
								this.guarantee.bankResSrc = '';
								this.guarantee.applicantResId = '';
								this.guarantee.applicantResSrc = '';
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
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-project-search {
		margin: 20upx auto;
		width: 90%;
	}

	.zy-project-item {
		padding: 10upx 20upx;
		border-bottom: 1upx solid $border-color;
	}

	.zy-project-item:last-child {
		border-bottom: none;
	}

	.zy-guarantee-memo {
		padding: 20upx;
		background-color: #FFF;
		padding-top: 60upx;
	}
</style>
