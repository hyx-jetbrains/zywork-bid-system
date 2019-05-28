<template>
	<view>
		<view class="zy-type-title zy-text-bold">我的等级</view>
		<view>
			<uni-card title="V0" v-if="vipLevel == 0">
				<view>
					<text class="zy-text-bold">图标：</text>
					<zywork-icon type="iconvip" color="#CCC" size="24" style="display: inline-block;" />
				</view>
				<view>
					<text class="zy-text-bold">拥有权限：</text>
					没有权限
				</view>
			</uni-card>

			<uni-card title="V1" v-else-if="vipLevel == 1">
				<view>
					<text class="zy-text-bold">图标：</text>
					<zywork-icon type="iconvip1" color="#33FF66" size="24" style="display: inline-block;" />
				</view>
				<view>
					<text class="zy-text-bold">权限：</text>
					某某某权限查看特权
				</view>
			</uni-card>

			<uni-card title="V2" v-else-if="vipLevel == 2">
				<view>
					<text class="zy-text-bold">图标：</text>
					<zywork-icon type="iconvip2" color="#33CCFF" size="24" style="display: inline-block;" />
				</view>
				<view>
					<text class="zy-text-bold">权限：</text>
					某某某权限查看特权
				</view>
			</uni-card>

			<uni-card title="V3" v-else-if="vipLevel == 3">
				<view>
					<text class="zy-text-bold">图标：</text>
					<zywork-icon type="iconvip3" color="#CC00FF" size="24" style="display: inline-block;" />
				</view>
				<view>
					<text class="zy-text-bold">权限：</text>
					某某某权限查看特权
				</view>
			</uni-card>
		</view>
		<view class="zy-type-title zy-text-bold">等级介绍</view>
		<uni-card title="V1">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconvip1" color="#33FF66" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">权限：</text>
				某某某权限查看特权
			</view>
			<view>
				<text class="zy-text-bold">价格：</text>
				<text class="zy-text-warning zy-text-big">¥199</text>
			</view>
			<view class="zy-vip-button" v-if="vipLevel < 1">
				<button type="primary" @click="openVIP(0)">立即开通</button>
			</view>
		</uni-card>

		<uni-card title="V2">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconvip2" color="#33CCFF" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">权限：</text>
				某某某权限查看特权
			</view>
			<view>
				<text class="zy-text-bold">价格：</text>
				<text class="zy-text-warning zy-text-big">¥299</text>
			</view>
			<view class="zy-vip-button" v-if="vipLevel < 2">
				<button type="primary" @click="openVIP(1)">立即开通</button>
			</view>
		</uni-card>

		<uni-card title="V3">
			<view>
				<text class="zy-text-bold">图标：</text>
				<zywork-icon type="iconvip3" color="#CC00FF" size="24" style="display: inline-block;" />
			</view>
			<view>
				<text class="zy-text-bold">权限：</text>
				某某某权限查看特权
			</view>
			<view>
				<text class="zy-text-bold">价格：</text>
				<text class="zy-text-warning zy-text-big">¥399</text>
			</view>
			<view class="zy-vip-button" v-if="vipLevel < 3">
				<button type="primary" @click="openVIP(2)">立即开通</button>
			</view>
		</uni-card>
	</view>
</template>

<script>
	import uniCard from "@/components/uni-card/uni-card.vue"
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		USER_ROLES,
		USER_ROLES_VIP1,
		USER_ROLES_VIP2,
		USER_ROLES_VIP3
	} from '@/common/util.js'
	export default {
		components: {
			uniCard,
			zyworkIcon
		},
		data() {
			return {
				vipLevel: 0
			}
		},
		onLoad() {
			uni.hideShareMenu();
			this.initData();
		},
		methods: {
			/** 初始化数据 */
			initData() {
				var userRolesArray = uni.getStorageSync(USER_ROLES);
				userRolesArray.forEach(item => {
					if (item == USER_ROLES_VIP1) {
						this.vipLevel = 1
					} else if (item == USER_ROLES_VIP2) {
						this.vipLevel = 2
					} else if (item == USER_ROLES_VIP3) {
						this.vipLevel = 3
					}
				})
			},
			// 开通VIP
			openVIP(type) {
				uni.navigateTo({
					url: '/pages-user-center/user-vip/vip-record?level=' + encodeURIComponent(type)
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-vip-button {
		margin-top: 20upx;
	}
</style>
