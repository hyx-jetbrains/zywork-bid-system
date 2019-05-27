<template>
	<view>
		<!-- 求带资料详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.userDetailNickname}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				
				<view class="zy-disable-flex">
					<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.userDetailNickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.seekDataCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发地</view>
					<view class="zy-disable-flex-right">{{item.seekDataStartAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">目的地</view>
					<view class="zy-disable-flex-right">{{item.seekDataEndAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">资料类型</view>
					<view class="zy-disable-flex-right">{{item.seekDataDataType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">份数</view>
					<view class="zy-disable-flex-right">{{item.seekDataDataCount}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">最晚时间</view>
					<view class="zy-disable-flex-right">{{item.seekDataLatestTime}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">赏金(元)</view>
					<view class="zy-disable-flex-right">{{item.seekDataPrice / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">是否加急</view>
					<view class="zy-disable-flex-right">{{item.seekDataIsUrgent === 0 ? '是' : '否'}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<!-- <view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.phone}}</view> -->
					<view class="zy-disable-flex-right">{{item.seekDataPhone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.seekDataMemo}}</view>
				</view>
			</view>
		</view>
		<!-- <view class="zy-bottom-button">
			<button type="primary" @click="callPhone">马上联系</button>
		</view> -->

	</view>
</template>

<script>
	export default {
		data() {
			return {
				item: {}
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
				title: this.item.nickname
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
