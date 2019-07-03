<template>
	<view>
		<uni-list>
			<zywork-list-item title="头像" :imageUrl="user.headicon === '' ? headicon : user.headicon" @click="chooseImage"></zywork-list-item>
			<zywork-list-item title="昵称" :note="user.nickname" @click="toSettingNickname"></zywork-list-item>
			<!-- <zywork-list-item title="姓名" :note="user.realname" @click="toSettingRealname"></zywork-list-item> -->
			<picker @change="chooseGender" :value="genderIndex" :range="genderArray">
				<zywork-list-item title="性别" :note="user.gender == 1 ? '男' : user.gender == 2 ? '女' : ''"></zywork-list-item>
			</picker>		
			</zywork-list-item>
			<zywork-list-item title="身份证号" :note="userWork.idNum" @click="toSettingIdentity"></zywork-list-item>
			<zywork-list-item title="手机号" :note="user.phone" @click="toSettingPhone"></zywork-list-item>
			<zywork-list-item title="工作单位" :note="userWork.workUnit" @click="toSettingCompany"></zywork-list-item>
			<zywork-list-item title="职务" :note="userWork.jobTitle" @click="toSettingJob"></zywork-list-item>
			<zywork-list-item title="办公地点" :note="userWork.workAddr" @click="toSettingCompanyAddr"></zywork-list-item>
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
		uploadHeadicon,
		getUserWork,
		updateGrade
	} from '../../common/user.js'
	import uniList from '@/components/uni-list/uni-list.vue'
	import zyworkListItem from '@/components/zywork-list-item/zywork-list-item.vue'
	import zyworkListItemInput from '@/components/zywork-list-item-input/zywork-list-item-input.vue'
	import {
		genderArray
	} from '@/common/picker.data.js'
	import {
		nullToStr,
		DEFAULT_HEADICON
	} from '@/common/util.js'
	export default {
		components: {
			uniList,
			zyworkListItem,
			zyworkListItemInput
		},
		data() {
			return {
				user: {
					headicon: DEFAULT_HEADICON,
					nickname: '',
					realname: '',
					gender: 0,
					phone: '',
				},
				userWork: {
					idNum: '',
					workUnit: '',
					jobTitle: '',
					workAddr: ''
				},
				visible: false,
				genderIndex: 0,
				genderArray: genderArray
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.user = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.user = JSON.parse(payload);
			}
			this.user = nullToStr(this.user);
			this.initData()
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
				this.user.gender = parseInt(this.genderIndex)
				updateGrade(this,this.genderIndex)
			},
			toSettingPhone() {
				const self = this
				this.$event.$on('changePhone', function(data) {
					self.user.phone = data.phone
					self.$event.$off('changePhone')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-phone/setting-phone?phone=' + this.user.phone
				})
			},
			toSettingIdentity() {
				const self = this
				this.$event.$on('changeIdentity', function(data) {
					self.userWork.idNum = data.identity
					self.$event.$off('changeIdentity')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-identity/setting-identity?identity=' + this.userWork.idNum
				})
			},
			toSettingCompany() {
				const self = this
				this.$event.$on('changeCompany', function(data) {
					self.userWork.workUnit = data.company
					self.$event.$off('changeCompany')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-company/setting-company?company=' + this.userWork.workUnit
				})
			},
			toSettingJob() {
				const self = this
				this.$event.$on('changeJob', function(data) {
					self.userWork.jobTitle = data.job
					self.$event.$off('changeJob')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-job/setting-job?job=' + this.userWork.jobTitle
				})
			},
			toSettingCompanyAddr() {
				const self = this
				this.$event.$on('changeCompanyAddr', function(data) {
					self.userWork.workAddr = data.companyAddr
					self.$event.$off('changeCompanyAddr')
				});
				uni.navigateTo({
					url: '/pages-user-center/setting-company-address/setting-company-address?companyAddr='+ this.userWork.workAddr
				})
			},
			initData() {
				getUserWork(this)
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>