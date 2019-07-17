<template>
	<view>
		<view>
			<button class="zy-share-button" type="primary" open-type="share">
				立即分享
			</button>
		</view>
		
		<view class="zy-type-title zy-text-bold">邀请说明</view>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				1、点击立即分享（或右上角的转发），即可分享给好友或微信群。
			</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				2、好友点击分享卡片，进入个人中心，授权登入成功，则视为分享成功。
			</text>	
		</label>
		
		<view class="zy-type-title zy-text-bold">奖励说明</view>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				1、每成功邀请1位用户，即可获得一定金额的抵用券。
			</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				2、抵用券可用于服务购买抵扣使用。
			</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				3、抵用券可累积使用。
			</text>	
		</label>
		<view class="zy-type-title zy-text-bold">邀请记录</view>
		<view class="zy-share-record">
			<view v-if="shareRecordList.length > 0" class="zy-page-list" style="padding: 0upx 30upx;">
				<view v-for="(shareRecordItem, index) in shareRecordList" :key="index" class="zy-page-list-item">
					<view class="zy-disable-flex">
						<image class="zy-headicon" :src="shareRecordItem.headicon === '' ? headicon : shareRecordItem.headicon"></image>
						<view>
							<view class="zy-text-big zy-text-bold zy-overflow-hidden">{{shareRecordItem.nickname === '' ? '暂无昵称' : shareRecordItem.nickname}}</view>
							<view class="zy-text-info">{{shareRecordItem.createTime}}</view>
						</view>
					</view>
				</view>
				<uni-pagination :current="pager.pageNo" :total="pager.pageTotal" title="标题文字" prev-text="前一页" next-text="后一页" @change="changePageTotal" />
			</view>
			<zywork-no-data v-else text="暂无邀请记录"></zywork-no-data>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniPagination from '@/components/uni-pagination/uni-pagination.vue'
	
	import {
		DEFAULT_HEADICON,
		SHARE_CODE_PAGE_IMG,
		getShareCode,
		SHARE_TITLE
	} from '@/common/util.js'
	
	import {
		getUserShareRecord
	} from '@/common/user.js'
	
	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
			uniPagination
		},
		data() {
			return {
				headicon: DEFAULT_HEADICON,
				shareRecordList: [],
				pager: {
					pageNo: 1,
					pageSize: 10,
					pageTotal: 0
				}
			}
		},
		onLoad() {
			uni.hideShareMenu();
			getUserShareRecord(this);
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
			changePageTotal(e) {
				console.log(e.type)
				this.pager.pageNo = e.current;
				getUserShareRecord(this);
				// let type = e.type;
				// if (type === 'next') {
				// 	// 下一页
				// 	
				// } else if (type === 'prev') {
				// 	// 上一页
				// }
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	.zy-share-button {
		text-align: center;
		margin: 30upx 25upx;
		border-radius: 50upx 50upx;
	}
	.zy-share-record {
		margin: 10upx 20upx;
	}
	.zy-headicon {
		width: 120upx;
		height: 120upx;
		border-radius: 60upx;
		margin-right: 20upx;
	}
</style>
