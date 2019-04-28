<template>
	<view>
		<view style="margin-top: 10upx; margin-bottom: 10upx;">
			<uni-segmented-control :current="messageStatus.current" :values="messageStatus.items" v-on:clickItem="onClickItem"
			 styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view v-if="messages.length > 0" class="zy-message">
			<view v-for="(message, index) in messages" :key="index" class="zy-message-item" @click="toMessageDetail">
				<view class="zy-message-head">
					<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{message.title}}</view>
					<uni-tag v-if="message.isRead" text="已读" type="success" size="small" :inverted="true"></uni-tag>
					<uni-tag v-else text="未读" type="error" size="small" :inverted="true"></uni-tag>
				</view>
				<view class="zy-message-content zy-overflow-hidden">{{message.content}}</view>
				<view class="zy-text-info zy-text-small zy-message-time">{{message.createTime}}</view>
			</view>
		</view>
		<zywork-no-data v-else text="暂无消息通知"></zywork-no-data>
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	const MESSAGE_ALL = 0
	const MESSAGE_UNREAD = 1
	const MESSAGE_READ = 2
	export default {
		components: {
			zyworkNoData,
			uniTag,
			uniSegmentedControl
		},
		data() {
			return {
				messageStatus: {
					current: 0,
					items: ['全部', '未读', '已读']
				},
				messages: [
					{
						title: '消息标题',
						content: '消息内容',
						createTime: '2019-04-28 10:00:00',
						isRead: false,
					},
					{
						title: '消息标题',
						content: '消息内容',
						createTime: '2019-04-28 10:00:00',
						isRead: true,
					}
				]
			}
		},
		onLoad() {},
		methods: {
			onClickItem(index) {
				if (this.current !== index) {
					this.current = index
				}
			},
			toMessageDetail() {
				uni.navigateTo({
					url: '/pages-message-notify/message-detail/message-detail'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-message {
		padding-left: 15upx;
		padding-right: 15upx;
		background-color: $primary-backcolor;
	}

	.zy-message-item {
		width: 100%;
		padding-top: 20upx;
		padding-bottom: 20upx;
		border-bottom: 1upx solid $seperator-color;
	}

	.zy-message-head {
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: space-between;
	}

	.zy-message-content {
		max-height: 200upx;
	}

	.zy-message-time {
		text-align: right;
	}
</style>
