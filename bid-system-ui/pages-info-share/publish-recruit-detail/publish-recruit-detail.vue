<template>
	<view>
		<!-- 其他岗位招聘详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.recruitJobTitle}}</view>
		<view class="zy-page-list">
			<view class="zy-page-list-item">
				<view class="zy-disable-flex">
					<image v-if="item.userDetailHeadicon !== ''" class="zy-page-mini-headicon"
					 :src="item.userDetailHeadicon" />
					<image v-else class="zy-page-mini-headicon" :src="defaultIcon" />
					<view>
						<view class="zy-disable-flex">
							<text class="zy-text-bold" style="margin-right: 20upx;">{{item.userDetailNickname}}</text>
							<zywork-icon v-if="item.userDetailGender === 0" type="iconyincang" color="#BFBFBF" size="20" />
							<zywork-icon v-else-if="item.userDetailGender === 1" type="iconnan" color="#108EE9" size="20" />
							<zywork-icon v-else-if="item.userDetailGender === 2" type="iconnv" color="#dd524d" size="20" />
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
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">联系电话</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone(item.compPhone)">{{item.phone}}</view>
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
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		DEFAULT_HEADICON,
		callPhone
	} from '@/common/util.js'
	export default {
		components: {
			zyworkIcon
		},
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
				title: this.item.recruitJobTitle
			});
		},
		methods: {
			/** 拨打电话 */
			callPhone(phone) {
				if (!phone) {
					return;
				}
				callPhone(phone);
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
