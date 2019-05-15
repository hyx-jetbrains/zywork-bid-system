<template>
	<view>
		<!-- 资质转让和求购详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.title}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				
				<view class="zy-disable-flex">
					<image class="zy-page-mini-headicon" :src="item.headicon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.nickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.createTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">资质等级</view>
					<view class="zy-disable-flex-right">{{item.compAptitudeLevel}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">资质类别</view>
					<view class="zy-disable-flex-right">{{item.compAptitudeType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.phone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.memo}}</view>
				</view>
			</view>
		</view>


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
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			uni.setNavigationBarTitle({
				title: this.item.title
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
