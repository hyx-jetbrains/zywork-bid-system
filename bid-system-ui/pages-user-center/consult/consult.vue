<template>
	<view>
		<button class="zy-consult-button" type="primary" @click="toAddConsultPage">
			我要咨询
		</button>
		<view v-if="consultList.length > 0">
			<uni-card v-for="(consult, index) in consultList" :key="index" :title="consult.consultType">
				<view>
					<text>{{consult.consultDesc}}</text>
					<view class="zy-time zy-text-info zy-text-small">{{consult.createTime}}</view>
				</view>
				
				<view v-if="consult.replyContent != ''">
					<view class="zy-bottom-border" />
					<view class="zy-text-bold">
						咨询回复：
					</view>
					<text>
						{{consult.replyContent}}
					</text>
					<view class="zy-time zy-text-info zy-text-small">
						{{consult.replyTime}}
					</view>
				</view>
			</uni-card>
		</view>
		<zywork-no-data v-else text="暂无咨询记录"></zywork-no-data>
	</view>
</template>

<script>
	import uniCard from "@/components/uni-card/uni-card.vue"
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import {
		getConsultByUserId
	} from '@/common/user-center.js'
	export default {
		components: {
			uniCard,
			zyworkNoData,
			zyworkIcon
		},
		data() {
			return {
				consultList: []
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			// 前往搜索页面
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-user-center/consult/search-page'
				})
			},
			// 前往添加咨询页面
			toAddConsultPage() {
				uni.redirectTo({
					url: '/pages-user-center/consult/add-consult'
				})
			},
			// 分段器选择是否处理
			onClickItem(index) {
				console.log(index)
				console.log(this.current)
				if (this.current !== index) {
					this.current = index
				}
			},
			// 立即支付
			pay() {
				uni.showModal({
					title: '立即支付'
				})
			},
			// 选择支付方式
			choosePayStatus: function(e) {
				this.payStatusIndex = e.target.value;
			},
			initData() {
				getConsultByUserId(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-consult-button {
		text-align: center;
		margin: 30upx 25upx;
		border-radius: 50upx 50upx;
	}
	
	.zy-bottom-border {
		margin: 20upx 0;
		border-bottom: 1upx dashed $border-color;
	}
	
	.zy-button {
		margin-top: 20upx;
	}
	
	.zy-time {
		text-align: right;
	}
	
</style>
