<template>
	<view>
		<!-- 其他岗位招聘详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.recruitJobTitle}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				
				<view class="zy-disable-flex">
					<image class="zy-page-mini-headicon" :src="item.userDetailHeadicon" />
					<view>
						<view>
							<text class="zy-text-bold">{{item.userDetailNickname}}</text>
						</view>
						<view class="zy-text-mini zy-text-info">{{item.recruitCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">岗位名称</view>
					<view class="zy-disable-flex-right">{{item.recruitJobTitle}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">岗位类型</view>
					<view class="zy-disable-flex-right">{{item.recruitIsFulltime === 0 ? '全职' : '兼职'}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">工作年限</view>
					<view class="zy-disable-flex-right">{{item.recruitWorkYear}}年</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">学历要求</view>
					<view class="zy-disable-flex-right">{{item.recruitEducation}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">薪资范围</view>
					<view class="zy-disable-flex-right">{{item.recruitSalary}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">招聘状态</view>
					<view class="zy-disable-flex-right">{{item.recruitRecruitStatus}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">职位描述</view>
					<view class="">{{item.recruitMemo}}</view>
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
				title: this.item.jobTitle
			});
		},
		methods: {
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
