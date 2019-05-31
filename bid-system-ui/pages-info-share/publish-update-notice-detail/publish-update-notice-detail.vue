<template>
	<view>
		<view class="zy-detail-card">
			<view class="zy-detail-card-title zy-text-bold zy-text-big">
				{{item.title}}
			</view>
			<view v-html="item.content"></view>
			<view class="zy-text-info zy-detail-card-time" v-text="item.createTime"></view>
		</view>
		<zywork-fab :pattern="pattern" :horizontal="horizontal" :vertical="vertical" :direction="direction" :showContent="appointmentPopup"
		 @trigger="trigger"></zywork-fab>
		<uni-popup :show="appointmentPopup" position="bottom" @hidePopup="trigger(false)">
			<view class="zy-popup-bottom-title">选择咨询类型</view>
			<view class="zy-popup-bottom-content">
				<view v-for="(item, index) in appointmentTypeData" :key="index" class="zy-popup-bottom-content-box" @click="toAppointmentPage(item.name)">
					<zywork-icon :type="item.icon" size="26" :color="item.iconColor"></zywork-icon>
					<view class="zy-popup-bottom-content-text">{{ item.text }}</view>
				</view>
			</view>
			<view class="zy-popup-bottom-btn" @click="trigger(false)">取消咨询</view>
		</uni-popup>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkFab from '@/components/zywork-fab/zywork-fab.vue'
	import uniPopup from '@/components/uni-popup/uni-popup.vue'
	import {
		showInfoToast,
		USER_FLAG,
		USER_FLAG_VIP,
		USER_FLAG_ORDINARY
	} from '@/common/util.js'
	export default {
		components: {
			zyworkFab,
			uniPopup,
			zyworkIcon
		},
		data() {
			return {
				item: {},
				directionStr: '垂直',
				horizontal: 'right',
				vertical: 'bottom',
				direction: 'horizontal',
				pattern: {
					color: '#7A7E83',
					backgroundColor: '#fff',
					selectedColor: '#007AFF',
					buttonColor: '#007AFF'
				},
				appointmentPopup: false,
				appointmentTypeData: [
					{
						text: '普通咨询',
						icon: 'iconshouye',
						iconColor: '#CCC',
						name: 'ptzx'
					},
					{
						text: '咨询专家',
						icon: 'iconzhuanjiarenzheng',
						iconColor: '#CCC',
						name: 'zxzj'
					}
				],
			}
		},
		onLoad(event) {
			uni.hideShareMenu();
			// TODO 后面把参数名替换成 payload
			const payload = event.itemData || event.payload;
			// 目前在某些平台参数会被主动 decode，暂时这样处理。
			try {
				this.item = JSON.parse(decodeURIComponent(payload));
			} catch (error) {
				this.item = JSON.parse(payload);
			}
			uni.setNavigationBarTitle({
				title: this.item.title
			});
			this.initData();
		},
		methods: {
			initData() {
				var userFlag = uni.getStorageSync(USER_FLAG);
				console.log(userFlag);
				if (userFlag === USER_FLAG_VIP) {
					this.appointmentTypeData.push({
						text: '快速咨询',
						icon: 'iconzixun',
						iconColor: '#CCC',
						name: 'kszx'
					})
				} else {
					this.appointmentTypeData = [
						{
							text: '普通咨询',
							icon: 'iconshouye',
							iconColor: '#CCC',
							name: 'ptzx'
						},
						{
							text: '咨询专家',
							icon: 'iconzhuanjiarenzheng',
							iconColor: '#CCC',
							name: 'zxzj'
						}
					]
				}
			},
			/** 悬浮按钮事件监听 */
			trigger(e) {
				this.appointmentPopup = e;
			},
			/** 前往咨询页面 */
			toAppointmentPage(name) {
				if (name === 'ptzx') {
					uni.redirectTo({
						url: '/pages-user-center/consult/add-consult'
					})
				} else {
					uni.redirectTo({
						url: '/pages-user-center/appointment/add-appointment?type=' + encodeURIComponent(name)
					})
				}
				
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
