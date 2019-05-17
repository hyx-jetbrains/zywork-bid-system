<template>
	<view>
		<!-- 建造师应聘详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.builderName}}</view>
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
						<view class="zy-text-mini zy-text-info">{{item.builderCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">姓名</view>
					<view class="zy-disable-flex-right">{{item.builderName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">性别</view>
					<view class="zy-disable-flex-right">{{item.builderGender === 1 ? '男' : item.builderGender === 2 ? '女' : '未知'}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.builderPhone}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">证书地址</view>
					<view class="zy-disable-flex-right">{{item.builderCertificateAddress}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">证书类别</view>
					<view class="zy-disable-flex-right">{{item.builderCertificateType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">证书专业类别</view>
					<view class="zy-disable-flex-right">{{item.builderCertificateMajorType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">期望薪水</view>
					<view class="zy-disable-flex-right">{{item.builderSalary}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.builderMemo}}</view>
				</view>
			</view>
		</view>


	</view>
</template>

<script>
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	export default {
		data() {
			return {
				defaultIcon: DEFAULT_HEADICON,
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
				title: this.item.builderName
			});
		},
		methods: {
			// 打电话
			callPhone() {
				uni.makePhoneCall({
					phoneNumber: this.item.builderPhone,
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
