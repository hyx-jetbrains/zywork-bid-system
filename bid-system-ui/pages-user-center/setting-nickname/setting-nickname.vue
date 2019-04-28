<template>
	<view class="zy-page-column-center">
		<view class="zy-form">
			<view class="uni-form-item uni-column">
				<input v-model="user.nickname" class="uni-input" placeholder="请输入昵称" />
			</view>
			<view class="uni-form-item">
				<button type="primary" style="width: 100%;" @click="changeNickname">修改昵称</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {updateNickname} from '../../common/user.js'
	export default {
		data() {
			return {
				user: {
					nickname: null
				}
			}
		},
		onLoad(option) {
			this.user.nickname = option.nickname
		},
		methods: {
			changeNickname() {
				updateNickname(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
