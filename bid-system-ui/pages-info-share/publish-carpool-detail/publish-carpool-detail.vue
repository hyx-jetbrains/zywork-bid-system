<template>
	<view>
		<!-- 开标拼车详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.markCarpoolName}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
					 :src="item.userDetailHeadicon" />
					<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.userDetailNickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.markCarpoolStartTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发地</view>
					<view class="zy-disable-flex-right">{{item.markCarpoolStartCity}}-{{item.markCarpoolStartAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">目的地</view>
					<view class="zy-disable-flex-right">{{item.markCarpoolEndCity}}-{{item.markCarpoolEndAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发日期</view>
					<view class="zy-disable-flex-right">{{item.markCarpoolStartTime}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">车型</view>
					<view class="zy-disable-flex-right">{{item.markCarpoolCarType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">搭载人数</view>
					<view class="zy-disable-flex-right">{{item.markCarpoolPeopleCount}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">价格</view>
					<view class="zy-disable-flex-right">¥{{item.markCarpoolPrice / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">联系人</view>
					<view class="zy-disable-flex-right">{{item.markCarpoolName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.markCarpoolPhone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.markCarpoolMemo}}</view>
				</view>
			</view>
		</view>
		<view class="zy-type-title zy-text-bold zy-disable-flex">
			申请记录
			<view class="zy-disable-flex-right">
				{{item.markCarpoolRecordCount}}/{{item.markCarpoolPeopleCount}}
			</view>
		</view>
		<view class="zy-page-list">
			<view v-for="(item, index) in carpoolRecordList" :key="index" class="zy-disable-flex zy-page-list-item">
				<image v-if="item.userDetailHeadicon !== null && item.userDetailHeadicon !== undefined" class="zy-page-mini-headicon"
				 :src="item.userDetailHeadicon" />
				<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
				<view>
					<view class="zy-disable-flex">
						<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
						<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
						<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
						<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
					</view>
					<view class="zy-text-mini zy-text-info">{{item.markCarpoolRecordCreateTime}}</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	import {
		getMarkCarpoolRecord
	} from '@/common/info-share.js'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				defaultIcon: DEFAULT_HEADICON,
				item: {},
				carpoolRecordList: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'markCarpoolRecordCreateTime',
					sortOrder: 'desc',
					markCarpoolRecordIsActive: 0,
				},
			}
		},
		onLoad(event) {
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			uni.setNavigationBarTitle({
				title: this.item.markCarpoolName
			});
			this.refreshMarkCarpoolRecordList();
		},
		methods: {
			/** 刷新申请列表 */
			refreshMarkCarpoolRecordList() {
				this.pager.markCarpoolRecordMarkCarpoolId = this.item.markCarpoolId;
				getMarkCarpoolRecord(this, this.pager);
			},
			// 打电话
			callPhone() {
				uni.makePhoneCall({
					phoneNumber: this.item.markCarpoolPhone,
					success: () => {
						console.log("成功拨打电话")
					}
				})
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
