<template>
	<view>
		<view class="zy-type-title zy-text-bold">问题说明</view>
		<textarea class="zy-memo" placeholder="请说明遇到的问题" v-model="consultDesc"/>
		<view class="zy-type-title zy-text-bold">问题类型</view>
		<view>
			<view class="zy-tag-view" v-for="(expertType, index) in expertTypeList" :key="index">
				<uni-tag :text="expertType.name" :inverted="true"
					:type="questionTypeId === expertType.id ? 'primary' : 'default'"
					 @click="setCurrentTagIndex(expertType.id)"/>
			</view>
		</view>
		<view class="zy-bottom-button">
			<button type="primary" @click="addConsult">点击咨询</button>
		</view>
	</view>
</template>

<script>
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {
		createConsult,
		getExpertQuesTionTypeByUserId
	} from '@/common/user-center.js'
	import {
		showInfoToast
	} from '@/common/util.js'
	export default {
		components: {
			uniTag
		},
		data() {
			return {
				consultDesc: null,
				questionTypeId: null,
				expertTypeList: [],
			}
		},
		onLoad() {
			uni.hideShareMenu();
			getExpertQuesTionTypeByUserId(this);
		},
		methods: {
			// 设置当前选中的类型
			setCurrentTagIndex(id) {
				this.questionTypeId = id;
			},
			// 咨询
			addConsult() {
				if (this.consultDesc === '' || this.consultDesc === null || this.consultDesc === undefined) {
					showInfoToast("请输入咨询内容")
					return;
				}
				createConsult(this)
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-memo {
		margin-left: 40upx;
		margin-bottom: 60upx;
		padding: 20upx;
		width: 630upx;
		background-color: #fff;
		border-radius: 20upx;
	}
	
	.zy-tag-view {
		margin: 10upx 20upx;
		display: inline-block;
	}
</style>
