<template>
	<view>
		<!-- 招标信息搜索页面 -->
		<view class="zy-disable-flex zy-search-page-bar zy-comp-search-bar">
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun" />
				<input type="text" v-model="pager.compName" :focus="true" placeholder="输入关键字搜索" @confirm="searchData" />
			</view>
			<view class="zy-disable-flex-right zy-search-page-cancel" @click="searchData">
				搜索
			</view>
		</view>
		<view class="zy-disable-flex zy-comp-type">
			<view class="zy-type-title zy-text-bold">选择企业类别</view>
			<view class="zy-disable-flex-right">
				<view class="uni-list-cell-db">
					<picker @change="onClickIndustryItem" :value="industryTypeIndex" :range="industryTypeArray">
						<view class="zy-disable-flex">
							<text>{{industryTypeArray[industryTypeIndex]}}</text>
							<zywork-icon type="iconxiangxia" />
						</view>
					</picker>
				</view>
			</view>
		</view>
		<view style="margin-bottom: 100upx;">
			<view class="uni-list" v-if="companyList.length > 0">
				<checkbox-group @change="checkAllChange">
					<label class="uni-list-cell uni-list-cell-pd" style="border-bottom: 1upx solid #BFBFBF">
						<view>
							<checkbox value="all" :checked="allChecked" />全选
						</view>
					</label>
				</checkbox-group>
				<checkbox-group @change="checkCompChange">
					<label class="uni-list-cell uni-list-cell-pd" v-for="(item, index) in companyList" :key="index">
						<view style="margin-right: 10upx;">
							<checkbox :value="item.compName" :checked="item.checked" />
						</view>
						<view>{{item.compName}}</view>
					</label>
				</checkbox-group>
			</view>
			<zyworkNoData v-else text="暂无招标人信息"></zyworkNoData>
		</view>
		<view class="zy-bottom-button">
			<button type="primary" @click="toSubscriblePage">确定({{confirmCount}}/{{pager.pageSize}})</button>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		getCompanyList
	} from '@/common/user-center.js'
	import {
		industryTypeArray
	} from '@/common/picker.data.js'
	export default {
		components: {
			zyworkIcon,
			zyworkNoData
		},
		data() {
			return {
				item: null,
				confirmCount: 0,
				pager: {
					pageNo: 1,
					pageSize: 15,
					isActive: 0,
					compType: '投标人',
					compName: '',
					industryType: ''
				},
				companyList: [],
				selectArray: [],
				allChecked: false,
				industryTypeArray: industryTypeArray,
				industryTypeIndex: 0,
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
		},
		methods: {
			/** 初始化多选框选中 */
			initCheckBoxSelected() {
				const tenderee = this.item.tenderee;
				if (tenderee != null &&
					tenderee != undefined &&
					tenderee != '') {
					var tendereeArray = tenderee.split(',');
					this.companyList.forEach(item => {
						var compName = item.compName;
						tendereeArray.forEach(tendereeItem => {
							if (compName === tendereeItem) {
								this.$set(item, 'checked', true)
							}
						})
					})
					if (tendereeArray.length === this.companyList.length) {
						this.allChecked = true;
					}
					this.confirmCount = tendereeArray.length;
				}
			},
			/** 返回上个页面 */
			toBackPage() {
				// uni.navigateBack({
				// 	delta: 1
				// })
				this.item.isRequest = false;
				uni.redirectTo({
					url: '/pages-user-center/subscrible/subscrible?itemData=' + encodeURIComponent(JSON.stringify(this.item))
				})
			},
			/** 搜索数据 */
			searchData() {
				getCompanyList(this, this.pager);
			},
			/** 监听选择公司信息 */
			checkCompChange: function(e) {
				var values = e.target.value;
				this.selectArray = values;
				this.confirmCount = values.length;
				this.companyList.forEach(item => {
					if (values.includes(item.compName)) {
						this.$set(item, 'checked', true)
					} else {
						this.$set(item, 'checked', false)
					}
				})
				if (values.length === this.companyList.length) {
					this.allChecked = true;
				} else {
					this.allChecked = false;
				}
			},
			/** 监听是否全选 */
			checkAllChange: function(e) {
				var items = this.companyList,
					values = e.detail.value;
				if (values.includes('all')) {
					// 确定选中的
					this.confirmCount = this.companyList.length;
					// 把所有项都选中
					this.companyList.forEach(item => {
						this.$set(item, 'checked', true)
						this.selectArray.push(item.compName);
					})
				} else {
					this.confirmCount = 0;
					// 把所有项都取消选中
					this.companyList.forEach(item => {
						this.$set(item, 'checked', false)
						this.selectArray = [];
					})
				}
			},
			/** 确定选中，前往我的订阅页面 */
			toSubscriblePage() {
				if (this.selectArray.length > 0) {
					var tenderee = ''
					this.selectArray.forEach(item => {
						if (tenderee === '') {
							tenderee = item;
						} else {
							tenderee += ',' + item;
						}
					})
					this.item.tenderee = tenderee;
				}
				this.item.isRequest = false;
				uni.redirectTo({
					url: '/pages-user-center/subscrible/subscrible?itemData=' + encodeURIComponent(JSON.stringify(this.item))
				})
			},
			/** 行业分类选择器 */
			onClickIndustryItem: function(e) {
				let index = e.target.value
				if (this.industryTypeIndex !== index) {
					this.industryTypeIndex = index
					if (index != 0) {
						this.pager.industryType = this.industryTypeArray[index];
					} else {
						this.pager.industryType = '';
					}
					this.searchData();
				}
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.uni-list-cell:last-child {
		margin-bottom: 10upx;
	}

	.uni-list-cell {
		justify-content: flex-start
	}

	.zy-comp-search-bar {
		background-color: #FFF;
		margin-bottom: 10upx;
	}
	
	.zy-comp-type {
		background-color: #FFF;
	}
</style>
