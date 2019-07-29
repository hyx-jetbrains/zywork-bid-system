<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{item.title}}
			</view>
			<image :src="item.url" style="width: 100%;"></image>
			<view v-html="item.content"></view>
			<view class="zy-text-info zy-detail-card-time" v-text="item.createTime"></view>
		</view>
	</view>
</template>

<script>
	import {
		getAdvertisementOneInfo
	} from '@/common/project-info.js'
	export default {
		data() {
			return {
				urls: {
					oneUrl: '/advertisement/any/one/'
				},
				item: {},
				id: ''
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.id = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.id = JSON.parse(payload);
			}
			this.loadData();
		},
		methods: {
			/**
			 * 加载数据
			 */
			loadData() {
				getAdvertisementOneInfo(this, this.id);
			}
		}
	}
</script>

<style lang="scss">
</style>
