<template>
	<view>
		<!-- 开标找车详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.markSeekcarName}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
					<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.userDetailNickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.markSeekcarStartTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发地</view>
					<view class="zy-disable-flex-right">{{item.markSeekcarStartCity}}{{item.markSeekcarStartAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">目的地</view>
					<view class="zy-disable-flex-right">{{item.markSeekcarEndCity}}{{item.markSeekcarEndAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发日期</view>
					<view class="zy-disable-flex-right">{{item.markSeekcarStartTime}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">联系人</view>
					<view class="zy-disable-flex-right">{{item.markSeekcarName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone(item.markSeekcarPhone)">{{item.markSeekcarPhone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">备注</view>
					<view class="">{{item.markSeekcarMemo}}</view>
				</view>
			</view>
		</view>
		<view class="zy-type-title zy-text-bold zy-disable-flex">
			申请记录
			<view class="zy-disable-flex-right">
				{{item.markSeekcarRecordCount}}/1
			</view>
		</view>
		<view class="zy-page-list">
			<view class="zy-disable-flex" v-for="(item, index) in seekcarRecordList" :key="index" >
				<view class="zy-disable-flex zy-page-list-item">
					<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
					<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
					<view>
						<view class="zy-disable-flex">
							<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
							<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
							<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
							<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
						</view>
						<view class="zy-text-mini zy-text-info">{{item.markSeekcarRecordCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone(item.userPhone)">
					{{item.userPhone}}
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
		getMarkSeekcarRecord
	} from '@/common/info-share.js'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				defaultIcon: DEFAULT_HEADICON,
				item: {},
				seekcarRecordList: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: 'markSeekcarRecordCreateTime',
					sortOrder: 'desc',
					markSeekcarRecordIsActive: 0,
				},
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
			uni.setNavigationBarTitle({
				title: this.item.markSeekcarName
			});
			this.refreshMarkSeekcarRecordList();
		},
		methods: {
			/** 刷新申请列表 */
			refreshMarkSeekcarRecordList() {
				this.pager.markSeekcarRecordMarkSeekcarId = this.item.markSeekcarId;
				getMarkSeekcarRecord(this, this.pager);
			},
			// 打电话
			callPhone(phone) {
				uni.makePhoneCall({
					phoneNumber: phone + '',
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
