<template>
	<view>
		<view class="zy-disable-flex zy-search-page-bar">
			<view class="zy-search-bar">
				<zywork-icon type="iconchaxun" />
				<input type="text" v-model="searchVal" placeholder="输入关键字搜索" @confirm="searchData" />
			</view>
			<view class="zy-disable-flex-right zy-search-page-cancel" @click="toBackPage">
				取消
			</view>
		</view>
		<view v-if="isShowHistroy" class="zy-search-page-history-record">
			<view class="zy-disable-flex">
				<view class="zy-type-title zy-text-bold">历史搜索</view>
				<view class="zy-disable-flex-right">
					<zywork-icon type="iconlajitong" size="22" @tap="oldDelete" />
				</view>
			</view>

			<view class="zy-history-record zy-disable-flex">
				<view v-for="(oldKey, index) in oldKeywordList" @click="doSearch(oldKey)" :key="index">{{oldKey}}</view>
			</view>
		</view>
		<view v-else>
			<view class="uni-tab-bar zy-tab-bar">
				<scroll-view id="tab-bar" class="uni-swiper-tab" scroll-x :scroll-left="infoType.scrollLeft">
					<view v-for="(tab,index) in infoType.tabbars" :key="tab.id" class="swiper-tab-list" :class="infoType.tabIndex==index ? 'active' : ''"
					 :id="tab.id" :data-current="index" @click="tapTab">{{tab.name}}</view>
				</scroll-view>
			</view>

			<view>
				<!-- 建造师 -->
				<view v-if="infoType.tabIndex === 0">
					<view class="zy-uni-segmented-control">
						<uni-segmented-control :current="builderOpts.current" :values="builderOpts.items" v-on:clickItem="onClickBuilderItem"
						 styleType="button" activeColor="#108EE9"></uni-segmented-control>
					</view>
					<view class="zy-page-list-item" style="padding-top: 10upx;">
						<view v-if="builderOpts.current === 0">
							<!-- 招聘信息 -->
							<view class="zy-page-list" v-if="builderReqList.length > 0">
								<view class="zy-page-list-item" v-for="(item, index) in builderReqList" :key="index">
									<view @click="toBuilderReqDetailPage(item)">
										<view class="zy-disable-flex">
											<image class="zy-page-mini-headicon" :src="item.headicon" />
											<view>
												<view>
													<text class="zy-text-bold">{{item.compName}}</text>
												</view>
												<view class="zy-text-mini zy-text-info">公告时间：{{item.createTime}}</view>
											</view>
											<view class="zy-disable-flex-right">
												¥{{item.salary / 100}}
											</view>
										</view>
										<view>
											<view class="zy-text-big zy-text-bold">建筑工程</view>
											<view class="zy-text-info">
												{{item.memo}}
											</view>
										</view>
									</view>
								</view>
							</view>
							<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
						</view>
						<view v-else>
							<!-- 应聘信息 -->
							<view class="zy-page-list" v-if="builderList.length > 0">
								<view class="zy-page-list-item" v-for="(item, index) in builderList" :key="index">
									<view @click="toBuilderDetailPage(item)">
										<view class="zy-disable-flex">
											<image class="zy-page-mini-headicon" :src="item.headicon" />
											<view>
												<view>
													<text class="zy-text-bold">{{item.name}}</text>
												</view>
												<view class="zy-text-mini zy-text-info">公告时间：{{item.createTime}}</view>
											</view>
										</view>
										<view>
											<view class="zy-text-big zy-text-bold">{{item.certificateMajorType}}</view>
											<view class="zy-text-info">
												{{item.memo}}
											</view>
										</view>
									</view>
								</view>
							</view>
							<zyworkNoData v-else text="暂无应聘信息"></zyworkNoData>
						</view>
					</view>
				</view>

				<!-- 资质转让 -->
				<view v-if="infoType.tabIndex === 1">
					<view class="zy-uni-segmented-control">
						<uni-segmented-control :current="aptitudeOpts.current" :values="aptitudeOpts.items" v-on:clickItem="onClickAptitudeItem"
						 styleType="button" activeColor="#108EE9"></uni-segmented-control>
					</view>
					<view class="zy-page-list-item" style="padding-top: 10upx;">
						<view v-if="aptitudeOpts.current === 0">
							<!-- 求购信息 -->
							<view class="zy-page-list" v-if="aptitudeBuyList.length > 0">
								<view class="zy-page-list-item" v-for="(item, index) in aptitudeBuyList" :key="index">
									<view @click="toAptitudeDetailPage(item)">
										<view class="zy-disable-flex">
											<image class="zy-page-mini-headicon" :src="item.headicon" />
											<view>
												<view>
													<text class="zy-text-bold">{{item.nickname}}</text>
												</view>
												<view class="zy-text-mini zy-text-info">{{item.createTime}}</view>
											</view>
										</view>
										<view>
											<view class="zy-text-big zy-text-bold">{{item.title}}</view>
											<view class="zy-text-info">
												{{item.memo}}
											</view>
										</view>
									</view>
								</view>
							</view>
							<zyworkNoData v-else text="暂无求购信息"></zyworkNoData>
						</view>
						<view v-else>
							<!-- 转让信息 -->
							<view class="zy-page-list" v-if="aptitudeSellList.length > 0">
								<view class="zy-page-list-item" v-for="(item, index) in aptitudeSellList" :key="index">
									<view @click="toAptitudeDetailPage(item)">
										<view class="zy-disable-flex">
											<image class="zy-page-mini-headicon" :src="item.headicon" />
											<view>
												<view>
													<text class="zy-text-bold">{{item.nickname}}</text>
												</view>
												<view class="zy-text-mini zy-text-info">{{item.createTime}}</view>
											</view>
										</view>
										<view>
											<view class="zy-text-big zy-text-bold">{{item.title}}</view>
											<view class="zy-text-info">
												{{item.memo}}
											</view>
										</view>
									</view>
								</view>
							</view>
							<zyworkNoData v-else text="暂无转让信息"></zyworkNoData>
						</view>
					</view>
				</view>

				<!-- 开标拼车 -->
				<view v-if="infoType.tabIndex === 2">
					<view class="zy-uni-segmented-control">
						<uni-segmented-control :current="carPoolOpts.current" :values="carPoolOpts.items" v-on:clickItem="onClickCarPoolItem"
						 styleType="button" activeColor="#108EE9"></uni-segmented-control>
					</view>
					<view class="zy-page-list-item" style="padding-top: 10upx;">
						<view v-if="carPoolOpts.current === 0">
							<!-- 拼车信息 -->
							<view class="zy-page-list" v-if="carpoolList.length > 0">
								<view class="zy-page-list-item" v-for="(item, index) in carpoolList" :key="index">
									<view @click="toCarpoolDetailPage(item)">
										<view class="zy-disable-flex">
											<image class="zy-page-mini-headicon" :src="item.headicon" />
											<view>
												<view>
													<text class="zy-text-bold">{{item.nickname}}</text>
												</view>
												<view class="zy-text-mini zy-text-info">
													{{item.startTime}}
													<text class="zy-text-mini" style="color: #108EE9; margin-left: 20upx;">{{item.carType}}</text>
												</view>
											</view>
											<view class="zy-disable-flex-right">
												¥{{item.price / 100}}
											</view>
										</view>
										<view>
											<view class="zy-text-big zy-text-bold">
												{{item.startAddr}}
												-
												{{item.endAddr}}
											</view>
										</view>
									</view>
									<view class="zy-text-info zy-disable-flex">
										<view>
											<text style="margin-right: 20upx;">搭车人数:</text>
											{{item.carpoolRecordCount}}/{{item.peopleCount}}
										</view>
										<view class="zy-disable-flex-right">
											<uni-tag text="我要拼车" type="primary" size="small" :inverted="true" :circle="true" @click="addCarpoolRecord(item)"></uni-tag>
										</view>
									</view>
								</view>
							</view>
							<zyworkNoData v-else text="暂无拼车信息"></zyworkNoData>
						</view>
						<view v-else>
							<!-- 找车信息 -->
							<view class="zy-page-list" v-if="seekcarList.length > 0">
								<view class="zy-page-list-item" v-for="(item, index) in seekcarList" :key="index">
									<view @click="toSeekcarDetailPage(item)">
										<view class="zy-disable-flex">
											<image class="zy-page-mini-headicon" :src="item.headicon" />
											<view>
												<view>
													<text class="zy-text-bold">{{item.nickname}}</text>
												</view>
												<view class="zy-text-mini zy-text-info">{{item.startTime}}</view>
											</view>
										</view>
										<view>
											<view class="zy-text-big zy-text-bold">
												{{item.startAddr}}
												-
												{{item.endAddr}}
											</view>
											<view class="zy-text-info">
												{{item.memo}}
											</view>
										</view>
									</view>
									<view class="zy-text-info zy-disable-flex">
										<view>
											<text style="margin-right: 20upx;">申请人数:</text>
											{{item.seekcarRecordCount}}/1
										</view>
										<view class="zy-disable-flex-right">
											<uni-tag text="我有车" type="primary" size="small" :inverted="true" :circle="true" @click="addSeekcarRecord(item)"></uni-tag>
										</view>
									</view>
								</view>
							</view>
							<zyworkNoData v-else text="暂无找车信息"></zyworkNoData>
						</view>
					</view>
				</view>

				<!-- 岗位招聘 -->
				<view v-if="infoType.tabIndex === 3">
					<view class="zy-page-list-item" style="padding-top: 10upx;">
						<!-- 其他岗位招聘信息 -->
						<view class="zy-page-list" v-if="recruitList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in recruitList" :key="index">
								<view @click="toRecruitDetailPage(item)">
									<view class="zy-disable-flex">
										<image class="zy-page-mini-headicon" :src="item.headicon" />
										<view>
											<view class="zy-disable-flex">
												<text class="zy-text-bold" style="margin-right: 20upx;">{{item.nickname}}</text>
												<zywork-icon v-if="item.gender === 0" type="iconyincang" color="#BFBFBF" size="20" />
												<zywork-icon v-else-if="item.gender === 1" type="iconnan" color="#108EE9" size="20" />
												<zywork-icon v-else-if="item.gender === 2" type="iconnv" color="#dd524d" size="20" />
											</view>
										</view>
										<view class="zy-disable-flex-right">
											{{item.recruitStatus}}
										</view>
									</view>
									<view>
										<view class="zy-disable-flex">
											<view class="zy-text-bold">
												招聘岗位：
												<text class="zy-text-info">{{item.jobTitle}}</text>
											</view>
											<view class="zy-disable-flex-right">
												{{item.isFulltime === 0 ? '全职' : '兼职'}}
												：
												¥{{item.salary}}/月
											</view>
										</view>
										<view class="zy-text-info zy-disable-flex">
											<view class="zy-text-bold">
												工作经验：
												<text class="zy-text-info">{{item.workYear}}年</text>
											</view>
											<view class="zy-text-bold zy-disable-flex-right">
												学历：
												<text class="zy-text-info">{{item.education}}</text>
											</view>
										</view>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无招聘信息"></zyworkNoData>
					</view>
				</view>

				<!-- 求带资料 -->
				<view v-if="infoType.tabIndex === 4">
					<view class="zy-page-list-item" style="padding-top: 10upx;">
						<!-- 求带资料信息 -->
						<view class="zy-page-list" v-if="seekDataList.length > 0">
							<view class="zy-page-list-item" v-for="(item, index) in seekDataList" :key="index">
								<view @click="toSeekDataDetailPage(item)">
									<view class="zy-disable-flex">
										<image class="zy-page-mini-headicon" :src="item.headicon" />
										<view>
											<view class="zy-disable-flex">
												<text class="zy-text-bold" style="margin-right: 20upx;">{{item.dataType}}</text>
												<text class="zy-text-bold">{{item.dataCount}}份</text>
											</view>
											<view class="zy-text-mini zy-text-info" style="color: #108EE9">最晚时间：{{item.latestTime}}</view>
										</view>
										<view class="zy-disable-flex-right">
											<view class="zy-disable-flex">
												赏金：
												<text style="margin-right: 10upx;">¥{{item.price / 100}}</text>
												<!-- <uni-tag v-if="item.isUrgent === 0" text="急" type="error" size="small" :inverted="true" :circle="false"></uni-tag> -->
												<zywork-icon v-if="item.isUrgent === 0" type="iconjinjidingdan" color="#dd524d" size="20" />
											</view>
										</view>

									</view>
									<view>
										<view class="zy-text-bold">
											出发地：
											<text class="zy-text-info">{{item.startAddr}}</text>
										</view>
										<view class="zy-text-bold">
											目的地：
											<text class="zy-text-info">{{item.endAddr}}</text>
										</view>
									</view>
								</view>
							</view>
						</view>
						<zyworkNoData v-else text="暂无求带资料信息"></zyworkNoData>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import zyworkIcon from '@/components/zywork-icon/zywork-icon.vue'
	import zyworkNoData from '@/components/zywork-no-data/zywork-no-data.vue'
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import zyworkCalendar from '@/components/zywork-calendar/zywork-calendar.vue'
	import uniTag from '@/components/uni-tag/uni-tag.vue'

	import {
		builderTypeArray,
		aptitudeTypeArray,
		openMarkArray,
		hireArray
	} from '@/common/picker.data.js'
	import {
		DEFAULT_HEADICON
	} from '@/common/util.js'
	
	const INFO_BUILDER = 0
	const INFO_APTITUDE = 1
	const INFO_CARPOOL = 2
	const INFO_HIRE = 3
	const INFO_MATERIAL = 4

	export default {
		components: {
			zyworkIcon,
			zyworkNoData,
			uniSegmentedControl,
			zyworkCalendar,
			uniTag
		},
		data() {
			return {
				searchVal: '',
				oldKeywordList: [],
				isShowHistroy: true,
				infoType: {
					scrollLeft: 0,
					tabIndex: 0,
					tabbars: [
						{id: 'builder', name: '建造师'},
						{id: 'aptitude', name: '资质转让'},
						{id: 'carPool', name: '开标拼车'},
						{id: 'hire', name: '岗位招聘'},
						{id: 'material', name: '求带资料'}
					]
				},
				builderOpts: {
					current: 0,
					items: builderTypeArray
				},
				aptitudeOpts: {
					current: 0,
					items: aptitudeTypeArray
				},
				carPoolOpts: {
					current: 0,
					items: openMarkArray
				},
				builderReqList: [
					{
						id: 1,
						headicon: DEFAULT_HEADICON,
						nickname: 'Carter',
						name: '危锦辉',
						people: '需要某某人才',
						peopleCount: 3,
						compName: '赣州智悦科技有限公司',
						compAddr: '山西/长治市/襄垣县',
						createTime: '2019-04-24 17:24:01',
						salary: '30000',
						phone: '18279700225',
						memo: '公司急招聘市政工程师，有意请联系18279700223'
					},
					{
						id: 2,
						headicon: DEFAULT_HEADICON,
						nickname: 'Carter1',
						name: '危锦辉1',
						people: '需要某某人才1',
						peopleCount: 5,
						compName: '赣州智悦科技有限公司1',
						compAddr: '山西/长治市/襄垣县',
						createTime: '2019-04-24 17:24:01',
						salary: '50000',
						phone: '18279700225',
						memo: '公司急招聘市政工程师，有意请联系18279700223',
					}
				],
				builderList: [
					{
						id: 1,
						nickname: 'Carter',
						name: '危锦辉',
						certificateMajorType: '机电工程',
						createTime: '2019-04-24 17:24:01',
						memo: '找工作，诚心的',
						headicon: DEFAULT_HEADICON,
						phone: '18279700225',
						gender: 1,
						certificateType: '建筑师',
						certificateMajorType: '一级建筑师',
						certificateAddr: '北京/北京市/东城区',
						salary: '5-10万元',
						memo: '无其他要求'
					},
					{
						id: 2,
						nickname: '刘某某',
						name: '刘某',
						certificateMajorType: '机电工程',
						createTime: '2019-04-24 17:24:01',
						memo: '找工作，诚心的',
						headicon: DEFAULT_HEADICON,
						phone: '18279700225',
						gender: 1,
						certificateType: '建筑师',
						certificateMajorType: '一级建筑师',
						certificateAddr: '北京/北京市/东城区',
						salary: '5-10万元',
						memo: '无其他要求'
					}
				],
				aptitudeBuyList: [
					{
						id: 1,
						nickname: '张某',
						headicon: DEFAULT_HEADICON,
						type: 0,
						title: '本人急购一家一级房建市政资质的企业',
						compAptitudeLevel: '三级',
						compAptitudeType: '交通工程',
						phone: '',
						memo: '诚心求购，诚心合作请联系：18279700232',
						createTime: '2019-04-24 17:24:01'
					}
				],
				aptitudeSellList: [
					{
						id: 2,
						nickname: '张某',
						headicon: DEFAULT_HEADICON,
						type: 1,
						title: '本人急售一家一级房建市政资质的企业',
						compAptitudeLevel: '三级',
						compAptitudeType: '交通工程',
						phone: '18279700224',
						memo: '诚心求购，诚心合作请联系：18279700232',
						createTime: '2019-04-24 17:24:01'
					}
				],
				carpoolList: [
					{
						id: 1,
						nickname: '刘某某',
						headicon: DEFAULT_HEADICON,
						startTime: '2019-04-24 17:24:01',
						startCity: '北京/北京市/东城区',
						startAddr: '赣州',
						endCity: '北京/北京市/东城区',
						endAddr: '上饶',
						price: 30000,
						carType: '小轿车',
						carpoolRecordCount: 1,
						peopleCount: 3,
						name: '危锦辉',
						phone: '18279700225'
					},
					{
						id: 2,
						nickname: '张某某',
						headicon: DEFAULT_HEADICON,
						startTime: '2019-04-24 17:24:01',
						startCity: '北京/北京市/东城区',
						startAddr: '赣州',
						endCity: '北京/北京市/东城区',
						endAddr: '上饶',
						price: 60000,
						carType: '小轿车',
						peopleCount: 2,
						name: '危锦辉',
						phone: '18279700225',
						carpoolRecordCount: 2,
					}
				],
				seekcarList: [
					{
						id: 1,
						nickname: '张某某',
						headicon: DEFAULT_HEADICON,
						startTime: '2019-04-24 17:24:01',
						startCity: '北京/北京市/东城区',
						startAddr: '赣州',
						endCity: '北京/北京市/东城区',
						endAddr: '上饶',
						memo: '去上饶，着急去，有意请联系',
						name: '危锦辉',
						phone: '18279700225',
						seekcarRecordCount: 0
					}
				],
				recruitList: [
					{
						id: 1,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						gender: 1,
						recruitStatus: '招聘中',
						isFulltime: 1,
						salary: '5-10万元',
						jobTitle: '建造师',
						workYear: 1,
						education: '大专',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 2,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						gender: 2,
						recruitStatus: '招聘中',
						isFulltime: 0,
						salary: '一万元以下',
						jobTitle: '建造师',
						workYear: 2,
						education: '大专',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 3,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						gender: 0,
						recruitStatus: '已停止',
						isFulltime: 0,
						salary: '一万元以下',
						jobTitle: '建造师',
						workYear: 2,
						education: '大专',
						createTime: '2019-04-24 17:24:01'
					}
				],
				seekDataList: [
					{
						id: 1,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						dataType: '资料',
						dataCount: 1,
						latestTime: '2019-04-25 00:00:00',
						price: 10000,
						isUrgent: 0,
						startAddr: '赣州',
						endAddr: '吉安',
						phone: '18279700225',
						memo: '没有说明',
						createTime: '2019-04-24 17:24:01'
					},
					{
						id: 2,
						nickname: '曾某某',
						headicon: DEFAULT_HEADICON,
						dataType: '资料',
						dataCount: 1,
						latestTime: '2019-04-25 00:00:00',
						price: 20000,
						isUrgent: 1,
						startAddr: '赣州',
						endAddr: '吉安',
						phone: '18279700225',
						memo: '',
						createTime: '2019-04-24 17:24:01'
					}
				]
			}
		},
		onLoad() {
			this.initData();
		},
		methods: {
			/** 初始化数据 */
			initData() {
				// 加载历史搜索数据
				this.loadOldKeyword();
			},
			/** 返回上个页面 */
			toBackPage() {
				uni.navigateBack({
					delta: 1
				})
			},
			/** 点击历史搜索执行搜索 */
			doSearch(key) {
				this.searchVal = key;
				this.searchData();
			},
			/** 搜索数据 */
			searchData() {
				console.log(this.searchVal)
				uni.showToast({
					title: this.searchVal
				})
				this.isShowHistroy = false;
				this.saveKeyword(this.searchVal)
			},
			/** 保存关键字到历史记录 */
			saveKeyword(keyword) {
				uni.getStorage({
					key: 'InfoShareOldKeys',
					success: (res) => {
						var OldKeys = JSON.parse(res.data);
						var findIndex = OldKeys.indexOf(keyword);
						if (findIndex == -1) {
							OldKeys.unshift(keyword);
						} else {
							OldKeys.splice(findIndex, 1);
							OldKeys.unshift(keyword);
						}
						//最多10个纪录
						OldKeys.length > 10 && OldKeys.pop();
						uni.setStorage({
							key: 'InfoShareOldKeys',
							data: JSON.stringify(OldKeys)
						});
						this.oldKeywordList = OldKeys; //更新历史搜索
					},
					fail: (e) => {
						var OldKeys = [keyword];
						uni.setStorage({
							key: 'InfoShareOldKeys',
							data: JSON.stringify(OldKeys)
						});
						this.oldKeywordList = OldKeys; //更新历史搜索
					}
				});
			},
			/** 清除历史搜索 */
			oldDelete() {
				uni.showModal({
					content: '确定清除历史搜索记录？',
					success: (res) => {
						if (res.confirm) {
							this.oldKeywordList = [];
							uni.removeStorage({
								key: 'InfoShareOldKeys'
							});
						} else if (res.cancel) {}
					}
				});
			},
			/** 加载历史搜索,自动读取本地Storage */
			loadOldKeyword() {
				uni.getStorage({
					key: 'InfoShareOldKeys',
					success: (res) => {
						var OldKeys = JSON.parse(res.data);
						this.oldKeywordList = OldKeys;
					}
				});
			},
			getElSize(id) {
				return new Promise((res, rej) => {
					uni.createSelectorQuery().select("#" + id).fields({
						size: true,
						scrollOffset: true
					}, (data) => {
						res(data);
					}).exec();
				})
			},
			async tapTab(e) {
				let tabIndex = e.target.dataset.current
				if (this.infoType.tabIndex === tabIndex) {
					return false
				} else {
					let tabBar = await this.getElSize("tab-bar"),
						tabBarScrollLeft = tabBar.scrollLeft
					this.infoType.scrollLeft = tabBarScrollLeft
					this.infoType.tabIndex = tabIndex
				}
			},
			toSearchPage() {
				uni.navigateTo({
					url: '/pages-info-share/search-page/search-page'
				})
			},
			toPublishChoose() {
				uni.navigateTo({
					url: '/pages-info-share/publish-choose/publish-choose'
				});
			},
			/** 前往详情页面 */
			toDetailPage(name, item) {
				uni.navigateTo({
					url: '/pages-info-share/publish-'+name+'-detail/publish-'+name+'-detail?itemData=' + encodeURIComponent(JSON.stringify(item))
				});
			},
			/** 前往建造师需求详情页面 */
			toBuilderReqDetailPage(item) {
				this.toDetailPage('builder-req', item);
			},
			/** 前往建造师应聘详情页面 */
			toBuilderDetailPage(item) {
				this.toDetailPage('builder', item);
			},
			/** 前往资质转让详情页面 */
			toAptitudeDetailPage(item) {
				this.toDetailPage('aptitude', item);
			},
			/** 前往拼车详情页面 */
			toCarpoolDetailPage(item) {
				this.toDetailPage('carpool', item);
			},
			/** 前往找车详情页面 */
			toSeekcarDetailPage(item) {
				this.toDetailPage('seekcar', item);
			},
			/** 前往其他岗位招聘详情页面 */
			toRecruitDetailPage(item) {
				this.toDetailPage('recruit', item);
			},
			/** 前往求带资料详情页面 */
			toSeekDataDetailPage(item) {
				this.toDetailPage('seek-data', item);
			},
			/** 点击我要拼车，增加拼车记录 */
			addCarpoolRecord(item) {
				if (item.carpoolRecordCount >= item.peopleCount) {
					uni.showModal({
						title: '操作提示',
						content: '人数已满，不能申请',
						showCancel: false,
						confirmText: "确定"
					})
					return;
				}
				console.log('我要拼车：' + item.id);
			},
			/** 点击我要拼车，增加找车记录 */
			addSeekcarRecord(item) {
				if (item.seekcarRecordCount >= 1) {
					uni.showModal({
						title: '操作提示',
						content: '人数已满，不能申请',
						showCancel: false,
						confirmText: "确定"
					})
					return;
				}
				console.log('我有车：' + item.id);
			},
			onClickBuilderItem(index) {
				if (this.builderOpts.current !== index) {
					this.builderOpts.current = index
				}
			},
			onClickAptitudeItem(index) {
				if (this.aptitudeOpts.current !== index) {
					this.aptitudeOpts.current = index
				}
			},
			onClickCarPoolItem(index) {
				if (this.carPoolOpts.current !== index) {
					this.carPoolOpts.current = index
				}
			},
		}
	}
</script>

<style lang="scss">
	@import '../../common/zywork-main.scss';

	page {
		background-color: $primary-backcolor;
	}
	
	.zy-icon view {
		line-height: 1.0;
	}
</style>
