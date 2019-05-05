<template>
	<view>
		<view class="zy-type-title zy-text-bold">专家信息</view>
		<view class="zy-expert-tag">
			<uni-tag text="非专家" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
		</view>
		<view class="zy-expert-icon">
			<zywork-icon type="iconzhuanjiarenzheng" color="#ccc" size="80" style="display: inline-block;"></zywork-icon>
		</view>
		<button type="primary" @click="appExpert()">申请成为专家</button>
		
		<view class="zy-type-title zy-text-bold zy-expert-equity">专家权益</view>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>1、第一条好处</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				2、第二条好处测试长内容测试长内容测试长内容测试长内容测试长内容测试长内容
				测试长内容测试长内容测试长内容测试长内容测试长内容测试长内容测试长内容测试长内容测试长内容
			</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>3、第三条好处</text>	
		</label>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	export default {
		components: {
			zyworkIcon,
			uniTag
		},
		data() {
			return {

			}
		},
		onLoad() {},
		methods: {
			// 申请成为专家
			appExpert() {
				uni.navigateTo({
					url: '/pages-user-center/user-expert/expert-setting'
				})
			}
			
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	@import '../../common/uni.css';
	
	.uni-list-cell {
		justify-content: flex-start
	}
	
	.zy-expert-tag {
		text-align: right;
		padding-right: 20upx;
	}
	
	.zy-expert-icon {
		text-align: center;
	}
	
	.zy-expert-equity {
		margin-top: 50upx;
	}
	
</style>
