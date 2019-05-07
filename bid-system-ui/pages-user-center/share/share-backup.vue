<template>
	<view>
		<view class="zy-share-page">
			<view class="zy-share-icon">
				<zywork-icon type="iconicon-test1" color="#108EE9" size="100" style="display: inline-block;" />
			</view>
			<view class="zy-share-code zy-text-bold">
				<text class="zy-text-big zy-share-code-text">我的邀请码：</text>
				<text class="zy-text-big zy-share-code-text" v-text="myShareCode"></text>
			</view>
			<view class="zy-text-info" @click="copyShareCode" style="margin-bottom: 120upx;">复制邀请码</view>
			<view>
				<input class="uni-input zy-share-button-input zy-share-input" v-model="shareCode" placeholder="请填写我的邀请人邀请码" />
			</view>
			<view>
				<button class="zy-share-button-input zy-share-button" 
					type="primary" @click="submitShareCode" style="margin-bottom: 10upx;">
					提交邀请码
				</button>
			</view>
			<view class="zy-text-info" @click="showShareRecord">
				点击查看邀请记录
				<zywork-icon type="iconshuangyoujiantou-" color="#8A8A8A" size="15" style="display: inline-block;" />
			</view>
		</view>
		
		<view class="zy-type-title zy-text-bold">邀请说明</view>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				1、点击复制邀请码，好友输入邀请码并提交邀请码，视为邀请成功。
			</text>	
		</label>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				2、点击分享按钮，分享到微信群或者好友，好友点击链接，即个分享成功。
			</text>	
		</label>
		
		<view class="zy-type-title zy-text-bold" style="margin-top: 20upx;">奖励说明</view>
		<label class="uni-list-cell uni-list-cell-pd">
			<text>
				1、每成功邀请5位用户，即可随机获得抵扣券。
			</text>	
		</label>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				myShareCode: 765654,
				shareCode: ''
			}
		},
		onLoad() {},
		methods: {
			// 复制邀请码
			copyShareCode() {
				var data = this.myShareCode;
				if (data.length === 0) {
					uni.showModal({
						title: '复制失败',
						content: '没有邀请码',
						showCancel: false
					})
				} else {
					uni.setClipboardData({
						data: data + '',
						success: () => {
							console.log('复制成功：' + data)
						},
						fail: () => {
							uni.showModal({
								content: '复制失败',
								showCancel: false
							})
						}
					});
				}
			},
			// 提交邀请码
			submitShareCode() {
				console.log(this.shareCode)
			},
			// 查看邀请记录
			showShareRecord() {
				uni.navigateTo({
					url: '/pages-user-center/share/share-record'
				})
			},
			
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	.zy-share-page {
		text-align: center;
	}
	.zy-share-icon {
		margin-top: 50upx;
	}
	.zy-share-code {
		margin: 20upx 0;
	}
	.zy-share-code-text {
		color: red;
	}
	.zy-share-button-input {
		margin: 30upx 25upx;
		border-radius: 50upx 50upx;
	}
	.zy-share-input {
		border: 2upx solid #108EE9;
		width: 650upx;
	}
	.zy-share-button {
	}
</style>
