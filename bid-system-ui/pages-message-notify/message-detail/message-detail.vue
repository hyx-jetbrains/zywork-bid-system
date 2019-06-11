<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{item.title}}
			</view>
			<view class="zy-content">{{item.detailContent}}</view>
			<view class="zy-text-info zy-disable-flex-right zy-create-time" v-text="item.createTime"></view>
		</view>
		<button v-if="showBtn" type="primary" @click="toDetailPage">立即查看</button>
	</view>
</template>

<script>
	import {
		getOneById
	} from '@/common/message.js'
	import {
		showInfoToast,
		nullToStr
	} from '@/common/util.js'
	import * as ResponseStatus from '@/common/response-status.js'
	export default {
		data() {
			return {
				item: {},
				showBtn: true
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
				title: this.item.title
			});
			if (this.item.noticeType === 4) {
				this.showBtn = false;
			}
		},
		methods: {
			/** 前往详情页面 */
			toDetailPage() {
				let toFlag = false;
				let url = '';
				const noticeType = this.item.noticeType;
				const pageUrl = this.item.pageUrl;
				const id = this.item.itemId;
				if (noticeType === 0 || noticeType === 1) {
					// 订阅通知 | 开标通知 - 获取项目详情
					url = '/project/user/multi/' + id
				} else if (noticeType === 2) {
					// 拼车通知 - 获取开标拼车详情
					url = '/UserMarkCarpool/user/one/' + id
				} else if (noticeType === 3) {
					// 找车通知 - 获取开标找车详情
					url = '/UserMarkSeekcar/user/one/' + id
				} else if (noticeType === 5) {
					// 专家回复通知 - 什么都不用做,前往专家回复页面
					toFlag = true;
				}
				getOneById(this, url)
					.then(data => {
						var [error, res] = data;
						if (res.data.code === ResponseStatus.OK) {
							const item = nullToStr(res.data.data.rows[0]);
							uni.navigateTo({
								url: pageUrl + '?itemData=' + encodeURIComponent(JSON.stringify(item))
							})
						} else {
							showInfoToast(res.data.message)
						}
					})
				if (toFlag) {
					uni.navigateTo({
						url: pageUrl
					})
				}

			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	.zy-create-time {
		text-align: right;
		margin-top: 30upx;
	}

	.zy-content {
		text-indent: 2em;
	}
</style>
