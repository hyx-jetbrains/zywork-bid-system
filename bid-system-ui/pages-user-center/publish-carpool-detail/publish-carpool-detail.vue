<template>
	<view>
		<!-- 开标拼车详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.markCarpoolName}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
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
					<!-- <view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.phone}}</view> -->
					<view class="zy-disable-flex-right">{{item.markCarpoolPhone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.memo}}</view>
				</view>
			</view>
		</view>
		<view class="zy-type-title zy-text-bold">申请记录</view>
		<view class="zy-page-list">
			<view v-for="(item, index) in carpoolRecordList" :key="index" class="zy-disable-flex zy-page-list-item">
				<image class="zy-page-mini-headicon" :src="item.headicon" />
				<view>
					<view>
						<text class="zy-text-bold">{{item.nickname}}</text>
					</view>
					<view class="zy-text-mini zy-text-info">{{item.createTime}}</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				item: {},
				carpoolRecordList: [
					{
						nickname: 'Carter',
						createTime: '2019-04-25 00:00:00'
					}
				]
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
				title: this.item.name
			});
		},
		methods: {
			// 打电话
			callPhone() {
				uni.makePhoneCall({
					phoneNumber: this.item.phone,
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
