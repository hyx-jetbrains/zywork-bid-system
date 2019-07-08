<template>
	<view>
		<!-- 劳务求职详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.labourName}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon"
						:src="item.userDetailHeadicon" />
					<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.userDetailNickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.labourCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">姓名</view>
					<view class="zy-disable-flex-right">{{item.labourName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">年龄</view>
					<view class="zy-disable-flex-right">{{item.labourAge}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.labourPhone}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">从事工种</view>
					<view class="zy-disable-flex-right">{{item.labourWorkType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">求职类型</view>
					<view class="zy-disable-flex-right">{{item.labourJobType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">工作地点</view>
					<view class="zy-disable-flex-right">{{item.labourWorkAddr + ' ' + item.labourAddrDesc}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">待遇要求</view>
					<view class="zy-disable-flex-right">{{item.labourTreatment}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.labourMemo}}</view>
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
				title: this.item.labourName
			});
		},
		methods: {
			// 打电话
			callPhone() {
				callPhone(this.item.labourPhone);
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
