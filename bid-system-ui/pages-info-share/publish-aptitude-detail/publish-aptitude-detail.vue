<template>
	<view>
		<!-- 资质转让和求购详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.aptitudeTransferTitle}}</view>
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
						<view class="zy-text-mini zy-text-info">{{item.aptitudeTransferCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">资质等级</view>
					<view class="zy-disable-flex-right">{{item.aptitudeTransferCompAptitudeLevel}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">资质类别</view>
					<view class="zy-disable-flex-right">{{item.aptitudeTransferCompAptitudeType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.aptitudeTransferPhone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.aptitudeTransferMemo}}</view>
				</view>
			</view>
		</view>


	</view>
</template>

<script>
	import {
		DEFAULT_HEADICON,
		callPhone
	} from '@/common/util.js'
	export default {
		data() {
			return {
				defaultIcon: DEFAULT_HEADICON,
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
				title: this.item.aptitudeTransferTitle
			});
		},
		methods: {
			// 打电话
			callPhone() {
				callPhone(this.item.aptitudeTransferPhone);
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
