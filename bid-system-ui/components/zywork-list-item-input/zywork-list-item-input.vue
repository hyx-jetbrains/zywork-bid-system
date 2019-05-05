<template>
	<view class="uni-list-item" :class="[disabled === true || disabled === 'true' ? 'uni-list-item--disabled' : '']">
		<view class="uni-list-item__container">
			<view class="uni-list-item__icon" v-if="thumb">
				<image class="uni-list-item__icon-img" :src="thumb"></image>
			</view>
			<view class="uni-list-item__icon" v-else-if="showExtraIcon === true || showExtraIcon === 'true'">
				<zywork-icon :color="extraIcon.color" :size="extraIcon.size" :type="extraIcon.type"></zywork-icon>
			</view>
			<view class="uni-list-item__content" v-if="flexDirection === 'row'">
				<view class="uni-list-item__content-title">{{title}}</view>
				<slot name="content"></slot>
			</view>
			<view class="uni-list-item__content__textarea" v-if="flexDirection === 'column'">
				<view class="uni-list-item__content-title">{{title}}</view>
				<slot name="content"></slot>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '../zywork-icon/zywork-icon.vue'
	export default {
		name: 'zywork-list-item-input',
		components: {
			zyworkIcon
		},
		data() {
			return {

			};
		},
		props: {
			title: String, //列表标题
			flexDirection: String,
			disabled: { //是否禁用
				type: [Boolean, String],
				default: false
			},
			thumb: String, //缩略图
			extraIcon: {
				type: Object,
				default () {
					return {
						type: "contact",
						color: "#000000",
						size: "20"
					};
				}
			}
		},
		methods: {
			onClick() {
				this.$emit('click')
			},
			onSwitchChange(e) {
				this.$emit('switchChange', e.detail)
			}
		}
	}
</script>

<style>
	@charset "UTF-8";

	.uni-list-item {
		min-height: 120upx;
		font-size: 32upx;
		position: relative;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		align-items: center
	}

	.uni-list-item--disabled {
		opacity: .3
	}

	.uni-list-item__container {
		padding: 24upx 30upx;
		width: 100%;
		box-sizing: border-box;
		flex: 1;
		position: relative;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center
	}

	.uni-list-item__container:after {
		position: absolute;
		z-index: 3;
		right: 0;
		bottom: 0;
		left: 30upx;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(.5);
		transform: scaleY(.5);
		background-color: #c8c7cc
	}

	.uni-list-item__content {
		flex: 1;
		overflow: hidden;
		display: flex;
		flex-direction: row;
		align-items: center;
		margin-right: 10upx;
	}
	
	.uni-list-item__content__textarea {
		flex: 1;
		display: flex;
		flex-direction: column;
	}

	.uni-list-item__content-title {
		font-size: 32upx;
		text-overflow: ellipsis;
		white-space: nowrap;
		color: inherit;
		line-height: 1.5;
		margin-right: 10upx;
	}
	
	.uni-list-item__extra {
		display: flex;
		flex-direction: row;
		justify-content: flex-end;
		align-items: center
	}

	.uni-list-item__icon {
		margin-right: 18upx;
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center
	}

	.uni-list-item__icon-img {
		height: 52upx;
		width: 52upx
	}

	.uni-list>.uni-list-item:last-child .uni-list-item-container:after {
		height: 0
	}
</style>