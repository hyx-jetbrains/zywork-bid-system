<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<view v-if="type.current === 0">
				<!-- 求购信息 -->
				<view class="zy-page-list" v-if="aptitudeBuyList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in aptitudeBuyList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
							<view @click="toAptitudeDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.headicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.nickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">{{item.createTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.title}}</view>
									<view class="zy-text-info">
										{{item.memo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无求购信息"></zyworkNoData>
			</view>
			<view v-else>
				<!-- 转让信息 -->
				<view class="zy-page-list" v-if="aptitudeSellList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in aptitudeSellList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.id)">
							<view @click="toAptitudeDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.headicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.nickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">{{item.createTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.title}}</view>
									<view class="zy-text-info">
										{{item.memo}}
									</view>
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无转让信息"></zyworkNoData>
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
		aptitudeTypeArray
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
					items: aptitudeTypeArray
				},
				aptitudeBuyList: [
					{
						id: 1,
						nickname: '张某',
						headicon: DEFAULT_HEADICON,
						type: 0,
						title: '本人急购一家一级房建市政资质的企业',
						compAptitudeLevel: '三级',
						compAptitudeType: '交通工程',
						phone: '',
						memo: '诚心求购，诚心合作请联系：18279700232',
						createTime: '2019-04-24 17:24:01'
					}
				],
				aptitudeSellList: [
					{
						id: 2,
						nickname: '张某',
						headicon: DEFAULT_HEADICON,
						type: 1,
						title: '本人急售一家一级房建市政资质的企业',
						compAptitudeLevel: '三级',
						compAptitudeType: '交通工程',
						phone: '18279700224',
						memo: '诚心求购，诚心合作请联系：18279700232',
						createTime: '2019-04-24 17:24:01'
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
			/** 前往资质转让详情页面 */
			toAptitudeDetailPage(item) {
				this.toDetailPage('aptitude', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				console.log(id);
				uni.showToast({
					title: '删除：' + id,
					icon: 'none'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
