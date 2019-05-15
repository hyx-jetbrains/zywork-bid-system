<template>
	<view>
		<!-- 开标找车详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.name}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<image class="zy-page-mini-headicon" :src="item.headicon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.nickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.startTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发地</view>
					<view class="zy-disable-flex-right">{{item.startCity}}{{item.startAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">目的地</view>
					<view class="zy-disable-flex-right">{{item.endCity}}{{item.endAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">出发日期</view>
					<view class="zy-disable-flex-right">{{item.startTime}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">联系人</view>
					<view class="zy-disable-flex-right">{{item.name}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.phone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">备注</view>
					<view class="">{{item.memo}}</view>
				</view>
			</view>
		</view>
		<view class="zy-type-title zy-text-bold">申请记录</view>
		<view class="zy-page-list">
			<view v-for="(item, index) in seekcarRecordList" :key="index" class="zy-disable-flex zy-page-list-item">
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
				seekcarRecordList: [
					{
						nickname: 'Carter',
						createTime: '2019-04-25 00:00:00'
					}
				]
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
