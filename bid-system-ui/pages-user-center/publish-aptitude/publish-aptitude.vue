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
						<uni-swipe-action :options="options" @click="confirmOptions(item.aptitudeTransferId)">
							<view @click="toAptitudeDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">{{item.aptitudeTransferCreateTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.aptitudeTransferTitle}}</view>
									<view class="zy-text-info">
										{{item.aptitudeTransferMemo}}
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
						<uni-swipe-action :options="options" @click="confirmOptions(item.aptitudeTransferId)">
							<view @click="toAptitudeDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">{{item.aptitudeTransferCreateTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">{{item.aptitudeTransferTitle}}</view>
									<view class="zy-text-info">
										{{item.aptitudeTransferMemo}}
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
	import {
		getAptitudeTransfeByUserId,
		deleteAptitudeTransferById
	} from '@/common/user-center.js'
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
				aptitudeBuyList: [],
				aptitudeSellList: [],
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			// 分段器选择类别
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
					getAptitudeTransfeByUserId(this,this.type.current)
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
				deleteAptitudeTransferById(this, id, this.type.current)
			},
			initData() {
				getAptitudeTransfeByUserId(this,this.type.current)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>