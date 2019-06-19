<template>
	<view>
		<view class="zy-type-title zy-text-bold">专家信息</view>
		<view class="zy-expert-tag">
			<uni-tag v-if="userExpert.examineStatus == 1" text="专家" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
			<uni-tag v-else text="非专家" type="error" size="small" :inverted="true" :circle="true"></uni-tag>
		</view>
		<view class="zy-expert-icon">
			<zywork-icon type="iconzhuanjiarenzheng" :color="expertIconColor" size="80" style="display: inline-block;"></zywork-icon>
		</view>
		<button v-if="userExpert.examineStatus == null" type="primary" @click="appExpert()">申请成为专家</button>
		<button v-else-if="userExpert.examineStatus == 0" type="primary" disabled="true">审核中</button>
		<view class="zy-type-title zy-text-bold zy-expert-equity">专家权益</view>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>1、咨询回报：通过为用户解决问题，获得相应的劳动报酬；</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				2、资讯渠道：与平台签约，成为平台专家，获得所在行业最新信息，及时了解行业重大发展；
			</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>3、人脉交流：通过平台所组织的行业培训、沙龙聚会、在线会议、网络互动，帮助您拓展更多精英人脉；</text>	
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
				userExpert: null,
				expertIconColor: '#ccc',
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.userExpert = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.userExpert = JSON.parse(payload);
			}
			if(this.userExpert.examineStatus == 1) {
				this.expertIconColor = '#108EE9'
			} else {
				this.expertIconColor = '#ccc'
			}
		},
		methods: {
			// 申请成为专家
			appExpert() {
				uni.redirectTo({
					url: '/pages-user-center/user-expert/expert-setting'
				})
			},
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
