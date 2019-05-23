<template>
	<view>
		<view class="zy-uni-segmented-control">
			<uni-segmented-control :current="messageStatus.current" :values="messageStatus.items" v-on:clickItem="onClickItem"
			 styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view v-if="messageList.length > 0" class="zy-page-list" style="margin-top: 10upx;">
			<view v-for="(message, index) in messageList" :key="index" class="zy-page-list-item" @click="toMessageDetail(message)">
				<view class="zy-message-head">
					<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{message.messageTitle}}</view>
					<uni-tag v-if="message.userMessageIsRead === 0" text="未读" type="error" size="small" :inverted="true"></uni-tag>
					<uni-tag v-else text="已读" type="success" size="small" :inverted="true"></uni-tag>
				</view>
				<view class="zy-message-content zy-overflow-hidden">{{message.messageContent}}</view>
				<view class="zy-text-info zy-text-small zy-message-time">{{message.userMessageCreateTime}}</view>
			</view>
		</view>
		<zywork-no-data v-else text="暂无消息通知"></zywork-no-data>
		
		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import {
		messageReadTypeArray
	} from '@/common/picker.data.js'
	import {
		loadMessage,
		readMessage,
		countNotReadMsg
	} from '@/common/message.js'
	
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
				loadMoreText: "加载中...",
				showLoadMore: false,
				messageStatus: {
					current: 0,
					items: messageReadTypeArray
				},
				messageList: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					userMessageIsRead: '',
					sortColumn: 't_user_message.is_read',
					sortOrder: 'asc',
				}
			}
		},
		onShow() {
			countNotReadMsg();
		},
		onLoad() {
			this.initMessage();
		},
		onPullDownRefresh() {
			this.pager.pageNo = 1
			loadMessage(this, this.pager, 'pullDown');
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			loadMessage(this, this.pager, 'reachBottom');
		},
		methods: {
			/** 初始化消息 */
			initMessage() {
				loadMessage(this, this.pager, 'init');
			},
			/** 初始查询信息 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			/** 分段器选择器 */
			onClickItem(index) {
				if (this.messageStatus.current !== index) {
					this.messageStatus.current = index
					if (MESSAGE_ALL === index) {
						this.pager.userMessageIsRead = '';
						this.pager.sortColumn = 't_user_message.is_read';
						this.pager.sortOrder = 'asc';
					} else {
						this.pager.sortColumn = 't_user_message.create_time';
						this.pager.sortOrder = 'desc';
						this.pager.userMessageIsRead = --index;
					}
					this.initPager();
					this.initMessage();
				}
			},
			/** 查看消息详情 */
			toMessageDetail(item) {
				if (item.userMessageIsRead === 0) {
					readMessage(this, item.userMessageId);
				}
				uni.navigateTo({
					url: '/pages-message-notify/message-detail/message-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
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
