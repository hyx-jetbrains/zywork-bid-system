<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<view v-if="type.current === 0">
				<!-- 招聘信息 -->
				<view class="zy-page-list" v-if="builderReqList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in builderReqList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
							<view @click="toBuilderReqDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.headicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.compName}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">公告时间：{{item.createTime}}</view>
									</view>
									<view class="zy-disable-flex-right">
										¥{{item.salary / 100}}
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">建筑工程</view>
									<view class="zy-text-info">
										{{item.memo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
			</view>
			<view v-else>
				<!-- 应聘信息 -->
				<view class="zy-page-list" v-if="builderList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in builderList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
							<view @click="toBuilderDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.headicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.name}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">公告时间：{{item.createTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.certificateMajorType}}</view>
									<view class="zy-text-info">
										{{item.memo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无应聘信息"></zyworkNoData>
			</view>
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action.vue'
	import {
		builderTypeArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	export default {
		components: {
			uniSegmentedControl,
			zyworkNoData,
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
				type: {
					current: 0,
					items: builderTypeArray
				},
				builderReqList: [
					{
						id: 1,
						headicon: DEFAULT_HEADICON,
						nickname: 'Carter',
						name: '危锦辉',
						people: '需要某某人才',
						peopleCount: 3,
						compName: '赣州智悦科技有限公司',
						compAddr: '山西/长治市/襄垣县',
						createTime: '2019-04-24 17:24:01',
						salary: '30000',
						phone: '18279700225',
						memo: '公司急招聘市政工程师，有意请联系18279700223'
					},
					{
						id: 2,
						headicon: DEFAULT_HEADICON,
						nickname: 'Carter1',
						name: '危锦辉1',
						people: '需要某某人才1',
						peopleCount: 5,
						compName: '赣州智悦科技有限公司1',
						compAddr: '山西/长治市/襄垣县',
						createTime: '2019-04-24 17:24:01',
						salary: '50000',
						phone: '18279700225',
						memo: '公司急招聘市政工程师，有意请联系18279700223',
					}
				],
				builderList: [
					{
						id: 1,
						nickname: 'Carter',
						name: '危锦辉',
						certificateMajorType: '机电工程',
						createTime: '2019-04-24 17:24:01',
						memo: '找工作，诚心的',
						headicon: DEFAULT_HEADICON,
						phone: '18279700225',
						gender: 1,
						certificateType: '建筑师',
						certificateMajorType: '一级建筑师',
						certificateAddr: '北京/北京市/东城区',
						salary: '5-10万元',
						memo: '无其他要求'
					},
					{
						id: 2,
						nickname: '刘某某',
						name: '刘某',
						certificateMajorType: '机电工程',
						createTime: '2019-04-24 17:24:01',
						memo: '找工作，诚心的',
						headicon: DEFAULT_HEADICON,
						phone: '18279700225',
						gender: 1,
						certificateType: '建筑师',
						certificateMajorType: '一级建筑师',
						certificateAddr: '北京/北京市/东城区',
						salary: '5-10万元',
						memo: '无其他要求'
					}
				],
			}
		},
		onLoad() {},
		methods: {
			// 分段器选择类别
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
				}
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-'+name+'-detail/publish-'+name+'-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				});
			},
			/** 前往建造师需求详情页面 */
			toBuilderReqDetailPage(item) {
				this.toDetailPage('builder-req', item);
			},
			/** 前往建造师应聘详情页面 */
			toBuilderDetailPage(item) {
				this.toDetailPage('builder', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				if (this.type.current === 0) {
					console.log(id);
					uni.showToast({
						title: '删除招聘：' + id,
						icon: 'none'
					})
				} else {
					console.log(id);
					uni.showToast({
						title: '删除应聘：' + id,
						icon: 'none'
					})
				}
				
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
