<template>
	<view>
		<view class="zy-disable-flex">
			<view class="zy-type-title zy-text-bold">选择问题类别</view>
			<view class="zy-disable-flex-right">
				<view class="uni-list-cell-db">
					<picker @change="chooseType" :value="questionTypeIndex" :range="questionTypeArray">
						<view class="zy-disable-flex">
							<text>{{questionTypeArray[questionTypeIndex]}}</text>
							<zywork-icon type="iconxiangxia"/>
						</view>
					</picker>
				</view>
			</view>
			
		</view>
		<view class="zy-disable-flex zy-help-list" v-for="(oftenQuestion, index) in oftenQuestionList" 
				:key="index" @click="toOftenQuestionDetail(oftenQuestion.id)">
			<zywork-icon type="iconbangzhu" color="#dd524d" size="24" style="display: inline-block;" />
			<view class="zy-help-list-title">
				{{oftenQuestion.title}}
			</view>
			<zywork-icon class="zy-help-list-right-icon" type="iconiconfonti" color="#8A8A8A" size="20" style="display: inline-block;" />
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	export default {
		components: {
			zyworkIcon
		},
		data() {
			return {
				questionTypeList: [
					{id: '1', name: '系统注册登录'},
					{id: '5', name: '工程量清单编制'},
					{id: '3', name: '招标文件制作'},
					{id: '4', name: '投标文件制作'},
					{id: '6', name: '工程造价'},
					{id: '2', name: 'CA锁办理及绑定激活'},
					{id: '7', name: '电子虚拟保证金缴纳'},
					{id: '8', name: '其他'}
				],
				questionTypeArray: [],
				questionTypeIndex: 0,
				oftenQuestionList: [
					{
						id: '1',
						type: '',
						title: 'CA证书问题长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试长标题测试'
					},
					{
						id: '2',
						type: '',
						title: 'CA证书问题1'
					}
				]
			}
		},
		onLoad() {
			this.initQuestionType()
		},
		methods: {
			// 初始化问题类型
			initQuestionType() {
				// 请求后台，获取到所有的类型
				// TODO 后面实现。。。
				let len = this.questionTypeList.length
				this.questionTypeArray.push('全部')
				for (var i = 0; i < len; i++) {
					this.questionTypeArray.push(this.questionTypeList[i].name)
				}
			},
			// 监听类别选择
			chooseType: function(e) {
				let index = e.target.value
				this.questionTypeIndex = index
				// 等于0表示取全部数据
				if (index !== '0') {
					console.log(this.questionTypeList[index - 1].id)
					console.log(this.questionTypeList[index - 1].name)
				}
			},
			// 前往问题详情页面
			toOftenQuestionDetail(id) {
				uni.navigateTo({
					url: '/pages-user-center/help/help-detail'
				})
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
	
	.zy-help-list {
		background-color: #FFFFFF;
		padding: 20upx;
		// position: relative;
		border-bottom: 2upx solid $border-color;
	}
	.zy-help-list-title {
		padding: 20upx;
		width: 800upx;
	}
	.zy-help-list-right-icon {
		text-align: right;
		// position: absolute;
		// top: 20upx;
		// right: 20upx;
	}
</style>
