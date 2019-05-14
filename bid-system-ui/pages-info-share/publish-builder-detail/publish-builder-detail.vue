<template>
	<view>
		<!-- 建造师应聘详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.name}}</view>
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
					<view class="zy-text-bold">姓名</view>
					<view class="zy-disable-flex-right">{{item.name}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">性别</view>
					<view class="zy-disable-flex-right">{{item.gender === 1 ? '男' : item.gender === 2 ? '女' : '未知'}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">手机号</view>
					<view class="zy-disable-flex-right">{{item.phone}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">证书地址</view>
					<view class="zy-disable-flex-right">{{item.certificateAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">证书类别</view>
					<view class="zy-disable-flex-right">{{item.certificateType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">证书专业类别</view>
					<view class="zy-disable-flex-right">{{item.certificateMajorType}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">期望薪水</view>
					<view class="zy-disable-flex-right">{{item.salary}}</view>
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
				title: this.item.name
			});
		},
		methods: {}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
