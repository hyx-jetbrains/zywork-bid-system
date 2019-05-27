<template>
	<view class="zy-page-column-center zy-page-padding">
		<view class="zy-form">
			<view class="uni-form-item uni-column">
				<input v-model="companyAddr" class="uni-input" placeholder="请输入办公地点" />
			</view>
			<view class="uni-form-item">
				<button type="primary" style="width: 100%;" @click="changeCompanyAddr">修改办公地点</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {updateNickname} from '../../common/user.js'
	export default {
		data() {
			return {
				companyAddr: ''
			}
		},
		onLoad(option) {
			uni.hideShareMenu();
			this.companyAddr= option.companyAddr
		},
		methods: {
			changeCompanyAddr() {
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
