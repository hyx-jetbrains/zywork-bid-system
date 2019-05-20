<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button"
			 activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view class="zy-page-list-item" style="padding-top: 10upx;">
			<view v-if="type.current === 0">
				<!-- 拼车信息 -->
				<view class="zy-page-list" v-if="carpoolList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in carpoolList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.markCarpoolId)">
							<view @click="toCarpoolDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">
											{{item.markCarpoolStartTime}}
											<text class="zy-text-mini" style="color: #108EE9; margin-left: 20upx;">{{item.markCarpoolCarType}}</text>
										</view>
									</view>
									<view class="zy-disable-flex-right">
										¥{{item.markCarpoolPrice / 100}}
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">
										{{item.markCarpoolStartAddr}}
										-
										{{item.markCarpoolEndAddr}}
									</view>
								</view>
							</view>
							<view class="zy-text-info zy-disable-flex">
								<view>
									<text style="margin-right: 20upx;">搭车人数:</text>
									{{item.markCarpoolPeopleCount}}/{{item.markCarpoolPeopleCount}}
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无拼车信息"></zyworkNoData>
			</view>
			<view v-else>
				<!-- 找车信息 -->
				<view class="zy-page-list" v-if="seekcarList.length > 0">
					<view class="zy-page-list-item" v-for="(item, index) in seekcarList" :key="index">
						<uni-swipe-action :options="options" @click="confirmOptions(item.markSeekcarId)">
							<view @click="toSeekcarDetailPage(item)">
								<view class="zy-disable-flex">
									<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
									<view>
										<view>
											<text class="zy-text-bold">{{item.userDetailNickname}}</text>
										</view>
										<view class="zy-text-mini zy-text-info">{{item.markSeekcarStartTime}}</view>
									</view>
								</view>
								<view>
									<view class="zy-text-big zy-text-bold">
										{{item.markSeekcarStartAddr}}
										-
										{{item.markSeekcarEndAddr}}
									</view>
									<view class="zy-text-info">
										{{item.markSeekcarMemo}}
									</view>
								</view>
							</view>
							<view class="zy-text-info zy-disable-flex">
								<view>
									<text style="margin-right: 20upx;">申请人数:</text>
									{{item.seekcarRecordCount}}/1
								</view>
							</view>
						</uni-swipe-action>
					</view>
				</view>
				<zyworkNoData v-else text="暂无找车信息"></zyworkNoData>
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
		openMarkArray
	} from '@/common/picker.data.js'
	import {
		getMarkCarpoolByUserId,
		getMarkSeekcarByUserId,
		deleteMarkCarpoolById,
		deleteMarkSeekcarById
	} from '@/common/user-center.js'
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
					items: openMarkArray
				},
				carpoolList: [],
				seekcarList: [],
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			/** 分段器选择类别 */
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
					if(index == 0) {
						getMarkCarpoolByUserId(this)
					} else {
						getMarkSeekcarByUserId(this)
					}
				}
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-user-center/publish-' + name + '-detail/publish-' + name + '-detail?itemData=' + encodeURIComponent(
						JSON.stringify(item))
				});
			},
			/** 前往拼车详情页面 */
			toCarpoolDetailPage(item) {
				this.toDetailPage('carpool', item);
			},
			/** 前往找车详情页面 */
			toSeekcarDetailPage(item) {
				this.toDetailPage('seekcar', item);
			},
			/** 确认操作 */
			confirmOptions(id) {
				if (this.type.current === 0) {
					deleteMarkCarpoolById(this, id)
				} else {
					deleteMarkSeekcarById(this, id)
				}
			},
			initData() {
				getMarkCarpoolByUserId(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
