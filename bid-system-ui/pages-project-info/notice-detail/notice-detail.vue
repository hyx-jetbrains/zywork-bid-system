<template>
	<view>
		
		<web-view src="http://192.168.203.208:8080/index.html"></web-view>
	</view>
</template>

<script>
import {
	BASE_URL,
} from '@/common/util.js'
import uParse from '@/components/uParse/src/wxParse.vue'

	export default {
		components: {
			uParse
		},
		data() {
			return {
				notice: {
					title: '头条标题头条标题头条标题头条标题头条标题头条标题',
					content: '<h2>H2标签</h2><p>p标签</p>',
					createTime: '2019-04-28 10:30:00'
				}
			}
		},
		onLoad() {
			this.initData()
		},
		methods: {
			preview(src, e) {
				// do something
				console.log("src: " + src);
			},
			navigate(href, e) {
				// 如允许点击超链接跳转，则应该打开一个新页面，并传入href，由新页面内嵌webview组件负责显示该链接内容
				console.log("href: " + href);
				uni.showModal({
					content : "点击链接为：" + href,
					showCancel:false
				})
			},
			initData() {
				uni.request({
					url: BASE_URL + '/headlines/admin/one/1',
					method: 'GET',
					success: (res) => {
						if (res.data.code === 1001) {
							this.notice = res.data.data
						} else {
							showInfoToast(res.data.message)
						}
					},
					fail: () => {
						networkError()
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';
</style>
