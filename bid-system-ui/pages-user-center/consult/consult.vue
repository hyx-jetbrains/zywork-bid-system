<template>
	<view>
		<view class="zy-type-title zy-text-bold">我的咨询反馈记录</view>
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
</template>

<script>
	import uniCard from "@/components/uni-card/uni-card.vue"
	export default {
		components: {
			uniCard
		},
		data() {
			return {
				consultList: [
					{
						consultType: 'CA证书',
						consultDesc: '遇到个什么问题',
						replyContent: '',
						replyTime: '',
						createTime: '2019-04-26 10:51:19'
					},
					{
						consultType: 'CA证书',
						consultDesc: '遇到个什么问题',
						replyContent: '问题的答案',
						replyTime: '2019-04-26 10:51:19',
						createTime: '2019-04-26 10:51:19'
					},
				]
			}
		},
		onLoad() {},
		methods: {
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
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
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
