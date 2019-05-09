<template>
	<view>
		<view class="zy-type-title zy-text-bold">问题说明</view>
		<textarea class="zy-memo" placeholder="请说明遇到的问题" v-model="formInfo.consultDesc"/>
		<view class="zy-type-title zy-text-bold">问题类型</view>
		<view>
			<view class="zy-tag-view" v-for="(expertType, index) in expertTypeList" :key="index">
				<uni-tag :text="expertType.name" :inverted="true"
					:type="currentTagIndex === expertType.id ? 'primary' : 'default'"
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
	export default {
		components: {
			uniTag
		},
		data() {
			return {
				formInfo: {
					questionTypeId: null,
					consultDesc: null
				},
				currentTagIndex: 1,
				expertTypeList: [
					{
						id: 1,
						name: '系统注册登录'
					},
					{
						id: 2,
						name: 'CA锁办理及绑定激活'
					},
					{
						id: 3,
						name: '招标文件制作'
					},
					{
						id: 4,
						name: '投标文件制作'
					},
					{
						id: 5,
						name: '工程量清单编制'
					},
					{
						id: 6,
						name: '工程造价'
					},
					{
						id: 7,
						name: '电子虚拟保证金缴纳'
					},
					{
						id: 8,
						name: '其他'
					}
				],
			}
		},
		onLoad() {},
		methods: {
			// 设置当前选中的类型
			setCurrentTagIndex(id) {
				console.log(id)
				this.currentTagIndex = id;
				this.formInfo.questionTypeId = id;
			},
			// 咨询
			addConsult() {
				console.log('咨询')
				console.log(this.formInfo)
			}
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
