<template>
	<view class="zy-page-column-center zy-page-padding">
		<view class="zy-form">
			<view class="uni-form-item uni-column">
				<input v-model="job" class="uni-input" placeholder="请输入职务名称" />
			</view>
			<view class="uni-form-item">
				<button type="primary" style="width: 100%;" @click="changeJob">修改职务</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {updateJobTitle} from '../../common/user.js'
	export default {
		data() {
			return {
				job: ''
			}
		},
		onLoad(option) {
			uni.hideShareMenu();
			this.job = option.job
		},
		methods: {
			changeJob() {
				updateJobTitle(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
