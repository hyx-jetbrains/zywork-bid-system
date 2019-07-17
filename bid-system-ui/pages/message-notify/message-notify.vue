<template>
	<view>
		<view class="uni-tab-bar zy-tab-bar">
			<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
				<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
				 :id="tab.id" :data-current="index" @click="tapTab">
					{{tab.name}}
				</view>
			</scroll-view>
		</view>
		<view class="zy-uni-segmented-control zy-position-relative">
			<text class="zy-text-subscrible" @click="toSubscriblePage">订阅</text>
			<uni-segmented-control :current="messageStatus.current" :values="messageStatus.items" v-on:clickItem="onClickItem"
			 styleType="button" activeColor="#108EE9"></uni-segmented-control>
			 <zywork-icon class="zy-clear-message" type="iconqingchu" color="#6D6D6D" size="20" @tap="clearMessage"/>
		</view>
		
		<view v-if="messageList.length > 0" class="zy-page-list" style="margin-top: 10upx;">
			<view v-for="(message, index) in messageList" :key="index" class="zy-page-list-item" @click="toMessageDetail(message)">
				<view class="zy-message-head">
					<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{message.title}}</view>
					<view style="width: 20%;">
						<uni-tag v-if="message.isRead === 0" text="未读" type="error" size="small" :inverted="true"></uni-tag>
						<uni-tag v-else text="已读" type="success" size="small" :inverted="true"></uni-tag>
					</view>
				</view>
				<view class="zy-message-content zy-overflow-hidden">{{message.mainContent}}</view>
				<view class="zy-text-info zy-text-small zy-message-time">{{message.createTime}}</view>
			</view>
		</view>
		<zywork-no-data v-else text="暂无消息通知"></zywork-no-data>
		
		<view class="uni-loadmore" v-if="showLoadMore">{{loadMoreText}}</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import uniBadge from '@/components/uni-badge/uni-badge.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import {
		messageReadTypeArray
	} from '@/common/picker.data.js'
	import {
		loadMessage,
		readMessage,
		countNotReadMsg,
		clearNoReadMessage
	} from '@/common/message.js'
	import {
		SHARE_CODE_PAGE_IMG,
		getShareCode,
		isUserIdExist,
		notLoginToUserCenter,
		LOGIN_FLAG,
		SHARE_TITLE
	} from '@/common/util.js'
	
	const MESSAGE_ALL = 0
	const MESSAGE_UNREAD = 1
	const MESSAGE_READ = 2
	export default {
		components: {
			zyworkNoData,
			uniTag,
			uniSegmentedControl,
			zyworkIcon,
			uniBadge
		},
		data() {
			return {
				infoType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [{
							id: 'subscribleNotice',
							name: '订阅通知'
						},
						{
							id: 'markTimeNotice',
							name: '开标通知'
						},
						{
							id: 'markCarpoolNotice',
							name: '拼车通知'
						},
						{
							id: 'markSeekcarNotice',
							name: '找车通知'
						},
						{
							id: 'systemNotice',
							name: '系统通知'
						},
						{
							id: 'expertReplyNotice',
							name: '专家回复通知'
						},
					]
				},
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
					isRead: '',
					noticeType: 0,
					sortColumn: 'createTime',
					sortOrder: 'desc',
				},
				subscrible: {
					isRequest: true
				},
			}
		},
		onShow() {
			countNotReadMsg();
		},
		onLoad(option) {
			this.initMessage('init');
			if (option.tabIndex) {
				this.tabIndex = tabIndex;
			}
		},
		onPullDownRefresh() {
			this.pager.pageNo = 1
			this.initMessage('pullDown')
		},
		onReachBottom() {
			this.showLoadMore = true
			this.pager.pageNo += 1
			loadMessage(this, this.pager, 'reachBottom');
		},
		onShareAppMessage(res) {
			var shareCode = getShareCode();
			return  {
				title: SHARE_TITLE,
				path: '/pages/project-info/project-info?shareCode=' + shareCode,
				imageUrl: SHARE_CODE_PAGE_IMG
			}
		},
		methods: {
			/** 初始化消息 */
			initMessage(type) {
				const loginFlag = uni.getStorageSync(LOGIN_FLAG);
				if (loginFlag) {
					loadMessage(this, this.pager, type);
				}
				
			},
			/** 初始查询信息 */
			initPager() {
				this.pager.pageNo = 1;
				this.showLoadMore = false;
			},
			getElSize(id) {
				return new Promise((res, rej) => {
					uni.createSelectorQuery().select("#" + id).fields({
						size: true,
						scrollOffset: true
					}, (data) => {
						res(data);
					}).exec();
				})
			},
			async tapTab(e) {
				const loginFlag = uni.getStorageSync(LOGIN_FLAG);
				if (!loginFlag) {
					uni.navigateTo({
						url: '/pages-static/no-login/no-login'
					})
					return;
				}
				let tabIndex = e.target.dataset.current
				if (this.infoType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.infoType.scrollLeft = tabBarScrollLeft
					this.infoType.tabIndex = tabIndex
					this.pager.noticeType = tabIndex
					this.initPager();
					this.initMessage('init');
				}
			},
			/** 分段器选择器 */
			onClickItem(index) {
				const loginFlag = uni.getStorageSync(LOGIN_FLAG);
				if (!loginFlag) {
					uni.navigateTo({
						url: '/pages-static/no-login/no-login'
					})
					return;
				}
				if (this.messageStatus.current !== index) {
					this.messageStatus.current = index
					// if (MESSAGE_ALL === index) {
					// 	this.pager.isRead = '';
					// 	this.pager.sortColumn = 'isRead';
					// 	this.pager.sortOrder = 'asc';
					// } else {
					// 	this.pager.sortColumn = 'createTime';
					// 	this.pager.sortOrder = 'desc';
					// 	this.pager.isRead = --index;
					// }
					this.initPager();
					this.initMessage('init');
				}
			},
			/** 查看消息详情 */
			toMessageDetail(item) {
				if (item.isRead === 0) {
					// 消息是未读，改成已读
					readMessage(this, item.id);
				}
				uni.navigateTo({
					url: '/pages-message-notify/message-detail/message-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				})
			},
			/** 前往订阅页面 */
			toSubscriblePage() {
				uni.navigateTo({
					url: '/pages-user-center/subscrible/subscrible?itemData=' + encodeURIComponent(JSON.stringify(this.subscrible))
				})
			},
			/** 清除未读消息 */
			clearMessage() {
				console.log("清除未读消息")
				clearNoReadMessage(this, this.infoType.tabIndex);
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
	.zy-clear-message {
		position: absolute;
		top: 10upx;
		right: 30upx;
	}
	.zy-text-subscrible {
		position: absolute;
		top: 10upx;
		left: 20upx;
		color: #108EE9;
	}
	
	.zy-tab-badge {
		position: absolute;
		top: 10upx;
		right: 10upx;
	}
</style>
