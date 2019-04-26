<template>
	<view>
		<uni-list>
			<zywork-list-item title="头像" imageUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556111133770&di=7b878fecade084667a237bbb4985f0aa&imgtype=0&src=http%3A%2F%2Ff.zhulong.com%2Fv1%2Ftfs%2FT1zAx_BQhT1RCvBVdK.jpg" @click="chooseImage"></zywork-list-item>
			<zywork-list-item title="昵称" note="王振宇" @click="toNickname"></zywork-list-item>
			<zywork-list-item title="姓名" note="王振宇" @click="toRealname"></zywork-list-item>
			<zywork-list-item title="性别" @click="toHelp"></zywork-list-item>
			<zywork-list-item title="身份证号" @click="toIdentity"></zywork-list-item>
			<zywork-list-item title="手机号" @click="toPhone"></zywork-list-item>
			<zywork-list-item title="工作单位" @click="toHelp"></zywork-list-item>
			<zywork-list-item title="职务" @click="toHelp"></zywork-list-item>
			<zywork-list-item title="办公地点" @click="toHelp"></zywork-list-item>
		</uni-list>
	</view>
</template>

<script>
	import {
		uploadHeadicon
	} from '../../common/user.js'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	export default {
		components: {
			uniList,
			zyworkListItem
		},
		data() {
			return {

			}
		},
		onLoad() {},
		methods: {
			chooseImage() {
				uploadHeadicon(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
