<template>
	<view>
		<view style="background-color: #FFFFFF; padding: 20upx 0;">
			<uni-segmented-control :current="type.current" :values="type.items" v-on:clickItem="onClickItem" styleType="button" activeColor="#108EE9"></uni-segmented-control>
		</view>
		<view v-if="type.current == 0">
			转让
		</view>
		<view v-else>
			求购
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import {
		aptitudeTypeArray
	} from '@/common/picker.data.js'
	export default {
		components: {
			uniSegmentedControl,
			zyworkNoData
		},
		data() {
			return {
				type: {
					current: 0,
					items: aptitudeTypeArray
				},
			}
		},
		onLoad() {},
		methods: {
			// 分段器选择类别
			onClickItem(index) {
				if (this.type.current !== index) {
					this.type.current = index
				}
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
