<template>
	<view>
		<view class="zy-type-title zy-text-bold">已订购的服务</view>
		<view v-if="myServiceList.length > 0" class="zy-position-relative">
			<uni-card v-for="(item,index) in myServiceList" :key="index"
				:title="item.serviceTitle" :extra="item.userServiceValidYear + '年'">
				<view>
					<text class="zy-text-bold">结束日期：</text>
					<text>{{item.userServiceEndDate}}</text>
				</view>
				<view>
					<text class="zy-text-bold">服务说明：</text>
					{{item.serviceMemo}}
				</view>
				<view v-if="item.userServiceEndDate < currDate">
					<zywork-icon class="zy-icon-yiguoqi" type="iconyiguoqi" color="#afacac" size="80" style="display: inline-block;" />
				</view>
				<view v-if="item.userServiceEndDate < currDate">
					<button type="primary" @click="continuousBuy(item)">立即续订</button>
				</view>
			</uni-card>
		</view>
		<zyworkNoData v-else text="暂无订购服务"></zyworkNoData>
		<view class="zy-type-title zy-text-bold">未订购的服务</view>
		<view v-if="serviceList.length > 0">
			<uni-card v-for="(item, index) in serviceList" :key="index" :title="item.title" extra="立即订购" @click="toBuyServicePage(item, 0)">
				<view>
					<text class="zy-text-bold">价格：</text>
					<text class="zy-price">¥{{item.price / 100}}</text>
				</view>
				<view>
					<text class="zy-text-bold">服务说明：</text>
					{{item.memo}}
				</view>
				<view>
					<button type="primary">立即订购</button>
				</view>
			</uni-card>
		</view>
		<zyworkNoData v-else text="暂无未订购的服务"></zyworkNoData>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniCard from "@/components/uni-card/uni-card.vue"
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		getCalendarDate,
		getDate
	} from '@/common/util.js'
	import {
		getMyService,
		getOneServiceById
	} from '@/common/user-center.js'

	export default {
		components: {
			zyworkIcon,
			uniCard,
			zyworkNoData
		},
		data() {
			return {
				serviceList: [],
				myServiceList: [],
				currDate: getCalendarDate(new Date()),
			}
		},
		onLoad() {
			getMyService(this)
		},
		methods: {
			/** 前往购买服务页面 */
			toBuyServicePage(item, type) {
				item.type = type;
				uni.navigateTo({
					url: '/pages-user-center/user-vip/vip-record?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			/** 续订 */
			continuousBuy(item) {
				var id = item.userServiceServiceId;
				getOneServiceById(this, id);
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-icon-yiguoqi {
		position: absolute;
		top: -60upx;
		right: 60upx;
	}
</style>
