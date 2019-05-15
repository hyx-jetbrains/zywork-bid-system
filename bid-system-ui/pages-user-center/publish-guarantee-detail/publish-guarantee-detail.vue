<template>
	<view>
		<!-- 我的申请保函详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.projectName}}</view>
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
					<view class="zy-text-bold">项目名称</view>
					<view class="zy-disable-flex-right">{{item.projectName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">开标时间</view>
					<view class="zy-disable-flex-right">{{item.openMarkTime}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">招标单位名称</view>
					<view class="zy-disable-flex-right">{{item.markUnitName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">工期(天)</view>
					<view class="zy-disable-flex-right">{{item.constructionPeriod}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">担保金额(万元)</view>
					<view class="zy-disable-flex-right">{{item.assurePrice / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">担保公司</view>
					<view class="zy-disable-flex-right">{{item.guaranteeComp}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">保函费</view>
					<view class="zy-disable-flex-right">{{item.guaranteePrice / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">申请人</view>
					<view class="zy-disable-flex-right">{{item.applicant}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">联系人</view>
					<view class="zy-disable-flex-right">{{item.name}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<!-- <view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.phone}}</view> -->
					<view class="zy-disable-flex-right">{{item.phone}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">邮寄地址</view>
					<view class="zy-disable-flex-right">{{item.address}}</view>
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
				title: this.item.projectName
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
