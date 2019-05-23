<script>
	import {
		countNotReadMsg
	} from '@/common/message.js'
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
			// uni.setTabBarBadge({
			//   index: 2,
			//   text: '4'
			// })
			countNotReadMsg()
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	@import './common/uni.css';
</style>
