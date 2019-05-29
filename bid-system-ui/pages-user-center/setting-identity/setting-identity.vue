<template>
	<view class="zy-page-column-center zy-page-padding">
		<view class="zy-form">
			<view class="uni-form-item uni-column">
				<input v-model="identity" class="uni-input" placeholder="请输入身份证号" />
			</view>
			<view class="uni-form-item">
				<button type="primary" style="width: 100%;" @click="changeIdentity">修改身份证号</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {updateIdentity} from '../../common/user.js'
	export default {
		data() {
			return {
				identity: ''
			}
		},
		onLoad(option) {
			uni.hideShareMenu();
			this.identity = option.identity
		},
		methods: {
			changeIdentity() {
				updateIdentity(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
