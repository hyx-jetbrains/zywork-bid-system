<template>
	<view>
		<uni-list>
			<zywork-list-item title="头像" imageUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556111133770&di=7b878fecade084667a237bbb4985f0aa&imgtype=0&src=http%3A%2F%2Ff.zhulong.com%2Fv1%2Ftfs%2FT1zAx_BQhT1RCvBVdK.jpg" @click="chooseImage"></zywork-list-item>
			<zywork-list-item title="昵称" :note="user.nickname" @click="toSettingNickname"></zywork-list-item>
			<zywork-list-item title="姓名" :note="user.realname" @click="toSettingRealname"></zywork-list-item>
			<picker @change="chooseGender" :value="genderIndex" :range="genderArray">
				<zywork-list-item title="性别" :note="user.gender === 1 ? '男' : user.gender === 2 ? '女' : ''"></zywork-list-item>
			</picker>		
			</zywork-list-item>
			<zywork-list-item title="身份证号" :note="user.identity" @click="toSettingIdentity"></zywork-list-item>
			<zywork-list-item title="手机号" :note="user.phone" @click="toSettingPhone"></zywork-list-item>
			<zywork-list-item title="工作单位" :note="user.company" @click="toSettingCompany"></zywork-list-item>
			<zywork-list-item title="职务" :note="user.job" @click="toSettingJob"></zywork-list-item>
			<zywork-list-item title="办公地点" :note="user.companyAddress" @click="toSettingCompanyAddr"></zywork-list-item>
			<!--
			<zywork-list-item-input title="测试" flexDirection="row">
				<view slot="content" class="zy-list-item-input">
					<input type="text" placeholder="测试"></input>
				</view>
			</zywork-list-item-input>
			<zywork-list-item-input title="测试" flexDirection="column">
				<view slot="content" class="zy-list-item-input">
					<textarea placeholder="测试" style="height: 200upx;"></textarea>
				</view>
			</zywork-list-item-input>
			-->
		</uni-list>
	</view>
</template>

<script>
	import {
		uploadHeadicon
	} from '../../common/user.js'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import zyworkListItemInput from '@/components/zywork-list-item-input/zywork-list-item-input.vue'
	import {
		genderArray
	} from '@/common/picker.data.js'
	export default {
		components: {
			uniList,
			zyworkListItem,
			zyworkListItemInput
		},
		data() {
			return {
				user: {
					headicon: '',
					nickname: '',
					realname: '',
					gender: 0,
					identity: '',
					phone: '',
					company: '',
					job: '',
					companyAddress: ''
				},
				visible: false,
				genderIndex: 0,
				genderArray: genderArray
			}
		},
		onLoad() {
			uni.hideShareMenu();
		},
		methods: {
			chooseImage() {
				uploadHeadicon(this)
			},
			toSettingNickname() {
				const self = this
				this.$event.$on('changeNickname', function(data) {
					self.user.nickname = data.nickname
					self.$event.$off('changeNickname')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-nickname/setting-nickname?nickname=' + this.user.nickname
				})
			},
			toSettingRealname() {
				const self = this
				this.$event.$on('changeNickname', function(data) {
					self.user.nickname = data.nickname
					self.$event.$off('changeNickname')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-realname/setting-realname?realname=' + this.user.nickname
				})
			},
			chooseGender(e) {
				this.genderIndex = e.target.value
				this.user.gender = parseInt(this.genderIndex) + 1
			},
			toSettingPhone() {
				uni.navigateTo({
					url: '/pages-user-center/setting-phone/setting-phone'
				})
			},
			toSettingIdentity() {
				uni.navigateTo({
					url: '/pages-user-center/setting-identity/setting-identity'
				})
			},
			toSettingCompany() {
				uni.navigateTo({
					url: '/pages-user-center/setting-company/setting-company'
				})
			},
			toSettingJob() {
				uni.navigateTo({
					url: '/pages-user-center/setting-job/setting-job'
				})
			},
			toSettingCompanyAddr() {
				uni.navigateTo({
					url: '/pages-user-center/setting-company-address/setting-company-address'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
