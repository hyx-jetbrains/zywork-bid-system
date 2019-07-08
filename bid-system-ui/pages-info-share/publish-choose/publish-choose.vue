<template>
	<view>
		<uni-list>
			<zywork-list-item title="建造师" note="建造师招聘和应聘" show-extra-icon="true" :extra-icon="{color: '#FF4539',size: '18',type: 'iconjiaozaoshi'}"
			@click="toPublishBuilder"></zywork-list-item>
			<zywork-list-item title="资质转让" note="资质转让和求购" show-extra-icon="true" :extra-icon="{color: '#568999',size: '18',type: 'iconrongyu'}"
			@click="toPublishAptitude"></zywork-list-item>
			<zywork-list-item title="开标拼车" note="项目开标拼车" show-extra-icon="true" :extra-icon="{color: '#892398',size: '18',type: 'iconpinche'}"
			@click="toPublishCarpool"></zywork-list-item>
			<zywork-list-item title="岗位招聘" note="其他岗位招聘" show-extra-icon="true" :extra-icon="{color: '#ABC033',size: '18',type: 'iconzhaopin'}"
			@click="toPublishHire"></zywork-list-item>
			<zywork-list-item title="求带资料" note="帮忙带资料" show-extra-icon="true" :extra-icon="{color: '#F98E69',size: '18',type: 'icongeren'}"
			@click="toPublishMaterial"></zywork-list-item>
			<zywork-list-item title="申请保函" note="申请保函" show-extra-icon="true" :extra-icon="{color: '#23AA22',size: '18',type: 'iconbaohan'}"
			@click="toPublishGuarantee"></zywork-list-item>
			<zywork-list-item title="劳务信息" note="劳务信息" show-extra-icon="true" :extra-icon="{color: '#1296db',size: '18',type: 'iconlaowu'}"
			@click="toPublishLabour"></zywork-list-item>
		</uni-list>
	</view>
</template>

<script>
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
		onLoad() {
			uni.hideShareMenu();
		},
		methods: {
			/**
			 * 发布建造师
			 */
			toPublishBuilder() {
				uni.navigateTo({
					url: '/pages-info-share/publish-builder/publish-builder'
				})
			},
			/**
			 * 发布资质转让
			 */
			toPublishAptitude() {
				uni.navigateTo({
					url: '/pages-info-share/publish-aptitude/publish-aptitude'
				})
			},
			/**
			 * 发布开标拼车
			 */
			toPublishCarpool() {
				uni.navigateTo({
					url: '/pages-info-share/publish-carpool/publish-carpool'
				})
			},
			/**
			 * 发布岗位招聘
			 */
			toPublishHire() {
				uni.navigateTo({
					url: '/pages-info-share/publish-hire/publish-hire'
				})
			},
			/**
			 * 发布求带资料
			 */
			toPublishMaterial() {
				uni.navigateTo({
					url: '/pages-info-share/publish-material/publish-material'
				})
			},
			/**
			 * 发布申请保函
			 */
			toPublishGuarantee() {
				uni.navigateTo({
					url: '/pages-info-share/publish-guarantee/publish-guarantee'
				})
			},
			/**
			 * 发布劳务信息
			 */
			toPublishLabour() {
				uni.navigateTo({
					url: '/pages-info-share/publish-labour/publish-labour'
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>

