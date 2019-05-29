<template>
	<view class="zy-page-column-center zy-page-padding">
		<view class="zy-form">
			<view class="uni-form-item uni-column">
				<input v-model="company" class="uni-input" placeholder="请输入单位名称" />
			</view>
			<view class="uni-form-item">
				<button type="primary" style="width: 100%;" @click="changeCompany">修改单位名称</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {updateCompany} from '../../common/user.js'
	export default {
		data() {
			return {
				company: ''
			}
		},
		onLoad(option) {
			uni.hideShareMenu();
			this.company = option.company
		},
		methods: {
			changeCompany() {
				updateCompany(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
