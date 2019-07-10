<script>
	import {
		countNotReadMsg
	} from '@/common/message.js'
	import {
		getCustomerConfig,
		getGuaranteeConfig
	} from '@/common/user.js'
	export default {
		onLaunch: function() {
            const updateManager = uni.getUpdateManager();
            updateManager.onCheckForUpdate(function(res) {
                // 请求完新版本信息的回调
                console.log(res.hasUpdate);
            });
            updateManager.onUpdateReady(function(res) {
                uni.showModal({
                    title: '更新提示',
                    content: '发现新版本，是否重启应用？',
                    success(res) {
                        if (res.confirm) {
                            // 新的版本已经下载好，调用 applyUpdate 应用新版本并重启
                            updateManager.applyUpdate();
                        }
                    }
                });
            });
            updateManager.onUpdateFailed(function(res) {
                // 新的版本下载失败
            });
			getCustomerConfig();
			getGuaranteeConfig();
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
