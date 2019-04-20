<template>
	<view>
		<view class="swiper">
			<swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
				<swiper-item v-for="(item, index) in swiperItems" :key="index">
					<view class="swiper-item" @click="showSwiperDetail(item.contentUrl)">
						<image :src="item.imgUrl" />
					</view>
				</swiper-item>
			</swiper>
		</view>
		
		<view v-if="latestNotice !== null" style="margin-top: 10upx;">
			<uni-notice-bar @getmore="toNoticeList" :show-get-more="true" more-text="查看更多" show-icon="true" single="true" :text="latestNotice"></uni-notice-bar>
		</view>

		
	</view>
</template>

<script>
	import uniNoticeBar from '@/components/uni-notice-bar/uni-notice-bar.vue'
	import {IMAGE_BASE_URL,DEFAULT_HEADICON, isUserTokenExist, toLoginPage} from '../../common/util.js'
	
	export default {
		components: {
			uniNoticeBar
		},
		data() {
			return {
				indicatorDots: true,
				autoplay: true,
				interval: 5000,
				duration: 500,
				swiperItems: [{
						imgUrl: "https://img-cdn-qiniu.dcloud.net.cn/uniapp/doc/img/ad.png",
						contentUrl: "http://39.108.116.103:8080/"
					},
					{
						imgUrl: "http://img.cdn.aliyun.dcloud.net.cn/ask/img/ke.qq.com.uniapp@2x.png",
						contentUrl: "http://39.108.116.103:8080/"
					}
				],
				latestNotice: null,
				pager: {
					pageNo: 1,
					pageSize: 5
				},
				imgBaseUrl: IMAGE_BASE_URL,
				headicon: DEFAULT_HEADICON
			}
		},
		onLoad() {
		},
		onPullDownRefresh() {
		},
		methods: {
			showSwiperDetail(contentUrl) {
				console.log(contentUrl)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/iconfont.css';
	.swiper {
		width: 100%;
		height: 300upx;
	}

	.swiper-item {
		display: block;
		height: 300upx;
		line-height: 300px;
		text-align: center;
	}
</style>
