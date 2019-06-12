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
		<view class="zy-type-title zy-text-bold">温馨提示</view>
		<view class="zy-bottom-tip">
			<view>
				1、提交您问题后，工作人员会审核您提交的问题，设定好处理的价格之后，您需要进行支付。
			</view>
			<view>
				2、您支付成功之后，工作人员会安排专家对您进行一对一的服务，直到帮助您解决问题。
			</view>
			<view v-if="type === 'kszx'">
				3、您提交的问题有快速回复的特权，我们会优先回复您提交的问题。
			</view>
		</view>
		<view class="zy-bottom-button">
			<button type="primary" @click="addAppointment">点击预约</button>
		</view>
	</view>
</template>

<script>
	import uniTag from '@/components/uni-tag/uni-tag.vue'
	import {
		createAppointment,
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
				type: 'zxzj',
				vipFlag: 0
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			getExpertQuesTionTypeByUserId(this);
			this.type = event.type;
			var title = '普通预约';
			if (this.type !== 'zxzj') {
				this.vipFlag = 1;
				title = '快速预约';
			}
			uni.setNavigationBarTitle({
				title: title
			})
		},
		methods: {
			// 设置当前选中的类型
			setCurrentTagIndex(id) {
				this.questionTypeId = id;
			},
			// 咨询
			addAppointment() {
				if (this.consultDesc === '' || this.consultDesc === null || this.consultDesc === undefined) {
					showInfoToast('请输入质询内容')
					return;
				}
				createAppointment(this)
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
	
	.zy-bottom-tip {
		padding: 20upx;
		margin-bottom: 150upx;
	}
</style>
