<template>
	<view>
		<!-- 建造师需求详情 -->
		<view class="zy-text-big zy-text-bold zy-detail-title">{{item.builderReqCompName}}</view>
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
						<view class="zy-text-mini zy-text-info">{{item.builderReqCreateTime}}</view>
					</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">所需人才</view>
					<view class="zy-disable-flex-right">{{item.builderReqPeople}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">所需人数</view>
					<view class="zy-disable-flex-right">{{item.builderReqPeopleCount}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">地址</view>
					<view class="zy-disable-flex-right">{{item.builderReqCompAddr}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">提供年薪</view>
					<view class="zy-disable-flex-right">¥{{item.builderReqSalary / 100}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">企业名称</view>
					<view class="zy-disable-flex-right">{{item.builderReqCompName}}</view>
				</view>
				<view class="zy-disable-flex zy-page-list-item">
					<view class="zy-text-bold">联系电话</view>
					<view class="zy-disable-flex-right zy-detail-phone" @click="callPhone">{{item.builderReqPhone}}</view>
				</view>
				<view class="zy-page-list-item">
					<view class="zy-text-bold">其他说明</view>
					<view class="">{{item.builderReqMemo}}</view>
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
				title: this.item.builderReqCompName
			});
		},
		methods: {
			callPhone() {
				callPhone(this.item.builderReqPhone);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
