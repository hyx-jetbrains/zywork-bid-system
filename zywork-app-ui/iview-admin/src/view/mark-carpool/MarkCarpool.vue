<template>
	<div>
		<Row>
			<i-col span="24">
				<Card>
					<Button @click="showModal('add')" type="primary">添加</Button>&nbsp;
					<Dropdown @on-click="batchOpt">
						<Button type="primary">
							批量操作
							<Icon type="ios-arrow-down"></Icon>
						</Button>
						<DropdownMenu slot="list">
							<DropdownItem name="batchActive">批量激活</DropdownItem>
							<DropdownItem name="batchInactive">
								<span style="color: red;">批量冻结</span>
							</DropdownItem>
							<DropdownItem name="batchRemove" divided>
								<span style="color: red;">批量删除</span>
							</DropdownItem>
						</DropdownMenu>
					</Dropdown>&nbsp;
					<Button @click="showModal('search')" type="primary">高级搜索</Button>&nbsp;
					<Tooltip content="刷新" placement="right">
						<Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
					</Tooltip>
					<Table ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails"
					 style="margin-top:20px;" @on-selection-change="changeSelection" @on-sort-change="changeSort"></Table>
					<div style="margin: 20px;overflow: hidden">
						<div style="float: right;">
							<Page :total="page.total" :current="searchForm.pageNo" @on-change="changePageNo" @on-page-size-change="changePageSize"
							 showSizer showTotal></Page>
						</div>
					</div>
				</Card>
			</i-col>
		</Row>
		<Modal v-model="modal.add" title="添加" @on-visible-change="changeModalVisibleResetForm('addForm', $event)">
			<Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="发布用户" prop="userId">
					<span v-text="form.userId"></span>
					&nbsp;
					<Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
				</FormItem>
				<FormItem label="项目编号" prop="projectId">
					<span v-text="form.projectId"></span>
					&nbsp;<Button @click="showModal('project')" type="text">选择项目</Button>&nbsp;
				</FormItem>
				<FormItem label="出发地城市" prop="startCity">
					<Cascader :data="cityData" v-model="tempAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="出发地点" prop="startAddr">
					<Input v-model="form.startAddr" placeholder="请输入出发地点" />
				</FormItem>
				<FormItem label="目的地城市" prop="endCity">
					<Cascader :data="cityData" v-model="endCityAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="目的地" prop="endAddr">
					<Input v-model="form.endAddr" placeholder="请输入目的地" />
				</FormItem>
				<FormItem label="出发时间" prop="startTime">
					<DatePicker @on-change="form.startTime=$event" :value="form.startTime" placeholder="请输入出发时间" type="datetime"
					 format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
				</FormItem>
				<FormItem label="汽车类型" prop="carType">
					<Select v-model="form.carType" placeholder="请选择汽车类型" clearable filterable>
						<i-option v-for="item in carTypeSelect" :value="item.value" :key="item.value">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="搭载人数" prop="peopleCount">
					<InputNumber v-model="form.peopleCount" placeholder="请输入搭载人数" style="width: 100%;" />
				</FormItem>
				<FormItem label="价格" prop="priceDisplay">
					<InputNumber v-model="form.priceDisplay" placeholder="请输入价格" style="width: 100%;" />
				</FormItem>
				<FormItem label="联系人姓名" prop="name">
					<Input v-model="form.name" placeholder="请输入联系人姓名" />
				</FormItem>
				<FormItem label="联系人电话" prop="phone">
					<Input v-model="form.phone" placeholder="请输入联系人电话" />
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		<Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="发布用户" prop="userId">
					<span v-text="form.userId"></span>
					&nbsp;
					<Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
				</FormItem>
				<FormItem label="项目编号" prop="projectId">
					<span v-text="form.projectId"></span>
					&nbsp;<Button @click="showModal('project')" type="text">选择项目</Button>&nbsp;
				</FormItem>
				<FormItem label="出发地城市" prop="startCity">
					<Cascader :data="cityData" v-model="tempAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="出发地点" prop="startAddr">
					<Input v-model="form.startAddr" placeholder="请输入出发地点" />
				</FormItem>
				<FormItem label="目的地城市" prop="endCity">
					<Cascader :data="cityData" v-model="endCityAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="目的地" prop="endAddr">
					<Input v-model="form.endAddr" placeholder="请输入目的地" />
				</FormItem>
				<FormItem label="出发时间" prop="startTime">
					<DatePicker @on-change="form.startTime=$event" :value="form.startTime" placeholder="请输入出发时间" type="datetime"
					 format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
				</FormItem>
				<FormItem label="汽车类型" prop="carType">
					<Select v-model="form.carType" placeholder="请选择汽车类型" clearable filterable>
						<i-option v-for="item in carTypeSelect" :value="item.value" :key="item.value">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="搭载人数" prop="peopleCount">
					<InputNumber v-model="form.peopleCount" placeholder="请输入搭载人数" style="width: 100%;" />
				</FormItem>
				<FormItem label="价格" prop="priceDisplay">
					<InputNumber v-model="form.priceDisplay" placeholder="请输入价格" style="width: 100%;" />
				</FormItem>
				<FormItem label="联系人姓名" prop="name">
					<Input v-model="form.name" placeholder="请输入联系人姓名" />
				</FormItem>
				<FormItem label="联系人电话" prop="phone">
					<Input v-model="form.phone" placeholder="请输入联系人电话" />
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="开标拼车编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始开标拼车编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束开标拼车编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="用户编号">
					<Row>
						<i-col span="11">
							<FormItem prop="userIdMin">
								<InputNumber v-model="searchForm.userIdMin" placeholder="请输入开始用户编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="userIdMax">
								<InputNumber v-model="searchForm.userIdMax" placeholder="请输入结束用户编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="项目编号">
					<Row>
						<i-col span="11">
							<FormItem prop="projectIdMin">
								<InputNumber v-model="searchForm.projectIdMin" placeholder="请输入开始项目编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="projectIdMax">
								<InputNumber v-model="searchForm.projectIdMax" placeholder="请输入结束项目编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="出发地点" prop="startAddr">
					<Input v-model="searchForm.startAddr" placeholder="请输入出发地点" />
				</FormItem>
				<FormItem label="目的地" prop="endAddr">
					<Input v-model="searchForm.endAddr" placeholder="请输入目的地" />
				</FormItem>
				<FormItem label="汽车类型" prop="carType">
					<Select v-model="searchForm.carType" placeholder="请选择汽车类型" clearable filterable>
						<i-option v-for="item in carTypeSelect" :value="item.value" :key="item.value">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="搭载人数">
					<Row>
						<i-col span="11">
							<FormItem prop="peopleCountMin">
								<InputNumber v-model="searchForm.peopleCountMin" placeholder="请输入开始搭载人数" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="peopleCountMax">
								<InputNumber v-model="searchForm.peopleCountMax" placeholder="请输入结束搭载人数" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="价格">
					<Row>
						<i-col span="11">
							<FormItem prop="priceMin">
								<InputNumber v-model="searchForm.priceMin" placeholder="请输入开始价格" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="priceMax">
								<InputNumber v-model="searchForm.priceMax" placeholder="请输入结束价格" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="联系人姓名" prop="name">
					<Input v-model="searchForm.name" placeholder="请输入联系人姓名" />
				</FormItem>
				<FormItem label="联系人电话" prop="phone">
					<Input v-model="searchForm.phone" placeholder="请输入联系人电话" />
				</FormItem>
				<FormItem label="是否激活" prop="isActive">
					<Select v-model="searchForm.isActive" placeholder="请选择是否激活" clearable filterable>
						<i-option v-for="item in isActiveSelect" :value="item.value" :key="item.value">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="版本号">
					<Row>
						<i-col span="11">
							<FormItem prop="versionMin">
								<InputNumber v-model="searchForm.versionMin" placeholder="请输入开始版本号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="versionMax">
								<InputNumber v-model="searchForm.versionMax" placeholder="请输入结束版本号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="创建时间">
					<Row>
						<i-col span="11">
							<FormItem prop="createTimeMin">
								<DatePicker @on-change="searchForm.createTimeMin=$event" :value="searchForm.createTimeMin" placeholder="请输入开始创建时间"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="createTimeMax">
								<DatePicker @on-change="searchForm.createTimeMax=$event" :value="searchForm.createTimeMax" placeholder="请输入结束创建时间"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="更新时间">
					<Row>
						<i-col span="11">
							<FormItem prop="updateTimeMin">
								<DatePicker @on-change="searchForm.updateTimeMin=$event" :value="searchForm.updateTimeMin" placeholder="请输入开始更新时间"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="updateTimeMax">
								<DatePicker @on-change="searchForm.updateTimeMax=$event" :value="searchForm.updateTimeMax" placeholder="请输入结束更新时间"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
				<Button type="text" size="large" @click="cancelModal('search')">取消</Button>
				<Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
			</div>
		</Modal>
		<Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<p>
				开标拼车编号:
				<span v-text="form.id"></span>
			</p>
			<p>
				用户编号:
				<span v-text="form.userId"></span>
			</p>
			<p>
				项目编号:
				<span v-text="form.projectId"></span>
			</p>
			<p>
				出发地城市:
				<span v-text="form.startCity"></span>
			</p>
			<p>
				出发地点:
				<span v-text="form.startAddr"></span>
			</p>
			<p>
				目的地城市:
				<span v-text="form.endCity"></span>
			</p>
			<p>
				目的地:
				<span v-text="form.endAddr"></span>
			</p>
			<p>
				出发时间:
				<span v-text="form.startTime"></span>
			</p>
			<p>
				汽车类型:
				<span v-text="form.carType"></span>
			</p>
			<p>
				搭载人数:
				<span v-text="form.peopleCount"></span>
			</p>
			<p>
				申请人数:
				<span v-text="form.recordCount"></span>
			</p>
			<p>
				价格:
				<span v-text="form.price/100"></span>
			</p>
			<p>
				联系人姓名:
				<span v-text="form.name"></span>
			</p>
			<p>
				联系人电话:
				<span v-text="form.phone"></span>
			</p>
			<p>
				版本号:
				<span v-text="form.version"></span>
			</p>
			<p>
				创建时间:
				<span v-text="form.createTime"></span>
			</p>
			<p>
				更新时间:
				<span v-text="form.updateTime"></span>
			</p>
			<p>
				是否激活:
				<span v-text="form.isActive === 0 ? '激活' : '冻结'"></span>
			</p>
		</Modal>

		<Modal :transfer="false" v-model="modal.userDetail" title="用户详情">
			<userDetail :form="userDetailForm" v-on:setDetail="setDetailModal" />
		</Modal>
		<Modal :transfer="false" fullscreen v-model="modal.userDetalSearch" title="搜索主表信息">
			<user-list-single ref="UserListSingle" v-on:confirmSelection="confirmSelection" />
			<div slot="footer">
				<Button type="text" size="large" @click="cancelModal('userDetalSearch')">取消</Button>
				<Button type="primary" size="large" @click="confirm">确认选择</Button>
			</div>
		</Modal>

		<Modal :transfer="false" v-model="modal.projectDetail" title="项目详情">
			<ProjectDetail :form="projectDetailForm" v-on:setDetail="setProjectDetailModal" />
		</Modal>
		<Modal :transfer="false" fullscreen v-model="modal.projectDetalSearch" title="搜索主表信息">
			<project-list-single ref="ProjectListSingle" v-on:confirmSelectionProject="projectConfirmSelection" />
			<div slot="footer">
				<Button type="text" size="large" @click="cancelModal('projectDetalSearch')">取消</Button>
				<Button type="primary" size="large" @click="projectConfirm">确认选择</Button>
			</div>
		</Modal>

		<Modal v-model="modal.project" title="选择招投标项目" :closable="false" :mask-closable="false" width="1000">
			<project-list ref="projectListItem" @initData="initData"></project-list>
			<div slot="footer">
				<Button type="default" size="large" @click="cancelModal('project')">取消</Button>
			</div>
		</Modal>

		<Modal :transfer="false" fullscreen v-model="modal.userChoice" title="选择用户">
			<user-list-choice ref="UserListChoice" v-on:confirmChoice="confirmChoice" />
			<div slot="footer">
				<Button type="text" size="large" @click="cancelModal('userChoice')">取消</Button>
			</div>
		</Modal>

		<Modal width="1000" v-model="modal.markCarpoolRecordSeach" title="拼车记录">
			<markCarpoolRecord-list-single ref="MarkCarpoolRecordListSingle" />
			<div slot="footer">
				<Button type="text" size="large" @click="cancelModal('markCarpoolRecordSeach')">取消</Button>
			</div>
		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import UserListSingle from '@/view/user/UserListSingle.vue'
	import userDetail from '@/view/user-detail/UserDetail.vue'
	import UserListChoice from '@/view/user/UserListChoice.vue'
	import ProjectDetail from '@/view/project/ProjectDetail.vue'
	import ProjectListSingle from '@/view/project/ProjectListSingle.vue'
	import MarkCarpoolRecordListSingle from '@/view/mark-carpool-record/MarkCarpoolRecordListSingle.vue'
	import {
		getUserById,
		getProjectById
	} from '@/api/module'
	import ProjectList from '@/view/project/ProjectList.vue'
	import city from '@/api/city.json'
	import {
		isActiveSelect,
		carType
	} from '@/api/select'

	export default {
		name: 'MarkCarpool',
		components: {
			userDetail,
			UserListSingle,
			ProjectList,
			UserListChoice,
			ProjectDetail,
			ProjectListSingle,
			MarkCarpoolRecordListSingle
		},
		data() {
			return {
				userDetailForm: {
					userId: null,
					userPhone: null,
					userEmail: null,
					userCreateTime: null,
					userDetailNickname: null,
					userDetailHeadicon: null,
					userDetailGender: null,
					userDetailBirthday: null,
					userDetailAge: null,
					userDetailQq: null,
					userDetailQqQrcode: null,
					userDetailWechat: null,
					userDetailWechatQrcode: null,
					userDetailAlipay: null,
					userDetailAlipayQrcode: null,
					userDetailShareCode: null,
					userDetailVersion: null
				},
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false,
					userDetail: false,
					userDetalSearch: false,
					project: false,
					userChoice: false,
					projectDetail: false,
					projectDetalSearch: false,
					markCarpoolRecordSeach: false
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/mark-carpool/admin/save',
					batchAddUrl: '/mark-carpool/admin/batch-save',
					editUrl: '/mark-carpool/admin/update',
					batchEditUrl: '/mark-carpool/admin/batch-update',
					searchUrl: '/mark-carpool/admin/pager-cond',
					allUrl: '/mark-carpool/admin/all',
					removeUrl: '/mark-carpool/admin/remove/',
					batchRemoveUrl: '/mark-carpool/admin/batch-remove',
					detailUrl: '/mark-carpool/admin/one/',
					activeUrl: '/mark-carpool/admin/active',
					batchActiveUrl: '/mark-carpool/admin/batch-active'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					userId: null,
					projectId: null,
					startCity: null,
					startAddr: null,
					endCity: null,
					endAddr: null,
					startTime: null,
					carType: null,
					peopleCount: null,
					recordCOunt: null,
					price: null,
					priceDisplay: null,
					name: null,
					phone: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				projectDetailForm: {
					id: null,
					title: null,
					projectType: null,
					startCity: null,
					projectDetail: null,
					releaseStatus: null,
					markUnitName: null,
					projectInvest: null,
					checkPattern: null,
					compAptitudeType: null,
					builderLevel: null,
					moneyToImplement: null,
					tenderingAgent: null,
					phone: null,
					offerPrice: null,
					assurePrice: null,
					constructionPeriod: null,
					downloadEndTime: null,
					otherDemand: null,
					openMarkInfo: null,
					openMarkTime: null,
					openMarkAddr: null,
					inMarkPublicity: null,
					inMarkComp: null,
					noticeTime: null,
					clickCount: null,
					isElectronic: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null
				},
				validateRules: {
					startAddr: [{
						type: 'string',
						min: 1,
						max: 10,
						message: '必须1-10个字符',
						trigger: 'blur'
					}],
					endAddr: [{
						type: 'string',
						min: 1,
						max: 10,
						message: '必须1-10个字符',
						trigger: 'blur'
					}],
					carType: [{
						type: 'string',
						min: 1,
						max: 10,
						message: '必须1-10个字符',
						trigger: 'blur'
					}],
					name: [{
							type: 'string',
							required: true,
							message: '此项为必须项',
							trigger: 'blur, change'
						},
						{
							type: 'string',
							min: 1,
							max: 10,
							message: '必须1-10个字符',
							trigger: 'blur'
						}
					],
					phone: [{
							type: 'string',
							required: true,
							message: '此项为必须项',
							trigger: 'blur, change'
						},
						{
							type: 'string',
							min: 1,
							max: 11,
							message: '必须1-11个字符',
							trigger: 'blur'
						}
					]
				},
				searchForm: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: null,
					sortOrder: null,
					id: null,
					idMin: null,
					idMax: null,
					userId: null,
					userIdMin: null,
					userIdMax: null,
					projectId: null,
					projectIdMin: null,
					projectIdMax: null,
					startCity: null,
					startAddr: null,
					endCity: null,
					endAddr: null,
					startTime: null,
					startTimeMin: null,
					startTimeMax: null,
					carType: null,
					peopleCount: null,
					peopleCountMin: null,
					peopleCountMax: null,
					price: null,
					priceMin: null,
					priceMax: null,
					name: null,
					phone: null,
					version: null,
					versionMin: null,
					versionMax: null,
					createTime: null,
					createTimeMin: null,
					createTimeMax: null,
					updateTime: null,
					updateTimeMin: null,
					updateTimeMax: null,
					isActive: null,
					isActiveMin: null,
					isActiveMax: null
				},
				table: {
					loading: false,
					tableColumns: [{
							type: 'selection',
							width: 45,
							key: 'id',
							align: 'center',
							fixed: 'left'
						},
						{
							width: 60,
							align: 'center',
							fixed: 'left',
							render: (h, params) => {
								return h(
									'span',
									params.index +
									(this.searchForm.pageNo - 1) * this.searchForm.pageSize +
									1
								)
							}
						},
						{
							title: '开标拼车编号',
							key: 'id',
							minWidth: 160,
							sortable: true
						},
						{
							title: '用户编号',
							key: 'userId',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								return h(
									'Dropdown', {
										on: {
											'on-click': itemName => {
												this.userOpt(itemName, params.row)
											}
										},
										props: {
											transfer: true
										}
									},
									[
										h('span', [
											params.row.userId,
											h('Icon', {
												props: {
													type: 'ios-list',
													size: '25'
												}
											})
										]),
										h(
											'DropdownMenu', {
												slot: 'list'
											},
											[
												h(
													'DropdownItem', {
														props: {
															name: 'moduleDetail'
														}
													},
													'详情'
												),
												h(
													'DropdownItem', {
														props: {
															name: 'showSearch'
														}
													},
													'搜索'
												)
											]
										)
									]
								)
							}
						},
						{
							title: '项目编号',
							key: 'projectId',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								return h(
									'Dropdown', {
										on: {
											'on-click': itemName => {
												this.userOpt(itemName, params.row)
											}
										},
										props: {
											transfer: true
										}
									},
									[
										h('span', [
											params.row.projectId,
											h('Icon', {
												props: {
													type: 'ios-list',
													size: '25'
												}
											})
										]),
										h(
											'DropdownMenu', {
												slot: 'list'
											},
											[
												h(
													'DropdownItem', {
														props: {
															name: 'projectDetail'
														}
													},
													'详情'
												),
												h(
													'DropdownItem', {
														props: {
															name: 'projectShowSearch'
														}
													},
													'搜索'
												)
											]
										)
									]
								)
							}
						},
						{
							title: '出发地城市',
							key: 'startCity',
							minWidth: 160,
							sortable: true
						},
						{
							title: '出发地点',
							key: 'startAddr',
							minWidth: 160,
							sortable: true
						},
						{
							title: '目的地城市',
							key: 'endCity',
							minWidth: 160,
							sortable: true
						},
						{
							title: '目的地',
							key: 'endAddr',
							minWidth: 160,
							sortable: true
						},
						{
							title: '出发时间',
							key: 'startTime',
							minWidth: 150,
							sortable: true
						},
						{
							title: '汽车类型',
							key: 'carType',
							minWidth: 120,
							sortable: true
						},
						{
							title: '申请人数',
							key: 'reocrdCount',
							minWidth: 120,
							sortable: true
						},
						{
							title: '搭载人数',
							key: 'peopleCount',
							minWidth: 120,
							sortable: true
						},
						{
							title: '价格',
							key: 'price',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = params.row.price/100;
								return h('span', '￥'+text)
							}
						},
						{
							title: '联系人姓名',
							key: 'name',
							minWidth: 120,
							sortable: true
						},
						{
							title: '联系人电话',
							key: 'phone',
							minWidth: 120,
							sortable: true
						},
						{
							title: '版本号',
							key: 'version',
							minWidth: 120,
							sortable: true
						},
						{
							title: '创建时间',
							key: 'createTime',
							minWidth: 150,
							sortable: true
						},
						{
							title: '更新时间',
							key: 'updateTime',
							minWidth: 150,
							sortable: true
						},
						{
							title: '激活状态',
							key: 'isActive',
							minWidth: 100,
							align: 'center',
							render: (h, params) => {
								return h(
									'i-switch', {
										props: {
											size: 'large',
											value: params.row.isActive === 0
										},
										style: {
											marginRight: '5px'
										},
										on: {
											'on-change': status => {
												this.active(params.row)
											}
										}
									},
									[
										h(
											'span', {
												slot: 'open'
											},
											'激活'
										),
										h(
											'span', {
												slot: 'close'
											},
											'冻结'
										)
									]
								)
							}
						},
						{
							title: '操作',
							key: 'action',
							width: 120,
							align: 'center',
							fixed: 'right',
							render: (h, params) => {
								return h(
									'Dropdown', {
										on: {
											'on-click': itemName => {
												this.userOpt(itemName, params.row)
											}
										},
										props: {
											transfer: true
										}
									},
									[
										h(
											'Button', {
												props: {
													type: 'primary',
													size: 'small'
												}
											},
											[
												'选择操作 ',
												h('Icon', {
													props: {
														type: 'ios-arrow-down'
													}
												})
											]
										),
										h(
											'DropdownMenu', {
												slot: 'list'
											},
											[
												h(
													'DropdownItem', {
														props: {
															name: 'showMarkCarpoolRecord'
														}
													},
													'拼车记录'
												),
												h(
													'DropdownItem', {
														props: {
															name: 'showEdit'
														}
													},
													'编辑'
												),
												h(
													'DropdownItem', {
														props: {
															name: 'showDetail'
														}
													},
													'详情'
												),
												h(
													'DropdownItem', {
														props: {
															name: 'remove'
														}
													},
													[
														h(
															'span', {
																style: {
																	color: 'red'
																}
															},
															'删除'
														)
													]
												)
											]
										)
									]
								)
							}
						}
					],
					tableDetails: [],
					selections: []
				},
				cityData: city,
				tempAddress: [],
				endCityAddress: [],
				isActiveSelect: isActiveSelect,
				carTypeSelect: carType
			}
		},
		computed: {},
		mounted() {
			this.search()
		},
		methods: {
			// 初始化数据
			initData(projectId) {
				this.cancelModal('project')
				this.form.projectId = projectId
			},
			showModal(modal) {
				if (modal === 'add') {
					this.form.carType = this.carTypeSelect[0].value
				}
				utils.showModal(this, modal)
			},
			changeModalVisibleResetForm(formRef, visible) {
				if (!visible) {
					utils.resetForm(this, formRef)
				}
			},
			resetForm(formRef) {
				utils.resetForm(this, formRef)
			},
			cancelModal(modal) {
				utils.cancelModal(this, modal)
			},
			resetFormCancelModal(formRef, modal) {
				utils.cancelModal(this, modal)
				utils.resetForm(this, formRef)
			},
			searchOkModal(modal) {
				utils.cancelModal(this, modal)
				this.searchForm.pageNo = 1
				utils.search(this)
			},
			batchOpt(itemName) {
				if (itemName === 'batchActive') {
					utils.batchActive(this, 0)
				} else if (itemName === 'batchInactive') {
					utils.batchActive(this, 1)
				} else if (itemName === 'batchRemove') {
					utils.batchRemove(this)
				}
			},
			userOpt(itemName, row) {
				if (itemName === 'showEdit') {
					utils.showModal(this, 'edit')
					this.form = JSON.parse(JSON.stringify(row))
					
					this.setPrice(0)
					var tempAddrArr = this.form.startCity.split('/')
					for (var i = 0; i < tempAddrArr.length; i++) {
						this.tempAddress.push(tempAddrArr[i])
					}
					
					var endCityAddress = this.form.endCity.split('/')
					for (var i = 0; i < endCityAddress.length; i++) {
						this.endCityAddress.push(endCityAddress[i])
					}
				} else if (itemName === 'showDetail') {
					utils.showModal(this, 'detail')
					this.form = JSON.parse(JSON.stringify(row))
				} else if (itemName === 'remove') {
					utils.remove(this, row)
				} else if (itemName === 'moduleDetail') {
					this.showUserDetailModal(row.userId)
				} else if (itemName === 'projectDetail') {
					this.showProjectDetailModal(row.projectId)
				} else if (itemName === 'showSearch') {
					utils.showModal(this, 'userDetalSearch')
				} else if (itemName === 'projectShowSearch') {
					utils.showModal(this, 'projectDetalSearch')
				} else if (itemName === 'showMarkCarpoolRecord') {
					utils.showModal(this, 'markCarpoolRecordSeach')
				}
			},
			showUserDetailModal(id) {
				getUserById(id)
					.then(res => {
						const data = res.data
						if (data.code === 1001) {
							this.userDetailForm = data.data.rows[0]
							this.modal.userDetail = true
						} else {
							this.$Message.error(data.message)
						}
					})
					.catch(err => {
						this.$Message.error(err)
					})
			},
			showProjectDetailModal(id) {
				getProjectById(id)
					.then(res => {
						const data = res.data
						if (data.code === 1001) {
							this.projectDetailForm = data.data
							this.modal.projectDetail = true
						} else {
							this.$Message.error(data.message)
						}
					})
					.catch(err => {
						this.$Message.error(err)
					})
			},
			setDetailModal(val) {
				this.modal.userDetail = val
			},
			setProjectDetailModal(val) {
				this.modal.projectDetail = val
			},
			confirmSelection(id) {
				this.modal.userDetalSearch = false
				this.searchForm.userIdMin = id
				this.searchForm.userIdMax = id
				utils.search(this)
			},
			confirm() {
				this.$refs.UserListSingle.confirmSelection()
			},
			projectConfirmSelection(id) {
				this.modal.projectDetalSearch = false
				this.searchForm.projectIdMin = id
				this.searchForm.projectIdMax = id
				utils.search(this)
			},
			projectConfirm() {
				this.$refs.ProjectListSingle.confirmSelection()
			},
			setAddress() {
				if (this.tempAddress.length <= 0) {
					this.$Message.error('地址为必填项')
					return
				} else if (this.tempAddress.length === 1) {
					this.form.startCity = this.tempAddress[0]
					this.form.endCity = this.endCityAddress[0]
				} else if (this.tempAddress.length === 2) {
					this.form.startCity = this.tempAddress[0] + '/' + this.tempAddress[1]
					this.form.endCity = this.endCityAddress[0] + '/' + this.endCityAddress[1]
				} else if (this.tempAddress.length === 3) {
					this.form.startCity =
						this.tempAddress[0] +
						'/' +
						this.tempAddress[1] +
						'/' +
						this.tempAddress[2]

					this.form.endCity =
						this.endCityAddress[0] +
						'/' +
						this.endCityAddress[1] +
						'/' +
						this.endCityAddress[2]
				}
			},
			setPrice(type) {
				if (type === 0) {
					if (this.form.price !== null && this.form.price !== 0) {
						this.form.priceDisplay = this.form.price / 100
					}
				} else if (type === 1) {
					if (this.form.priceDisplay !== null && this.form.priceDisplay !== 0) {
						this.form.price = this.form.priceDisplay * 100
					}
				}
			},
			add() {
				if (
					this.form.projectId === undefined ||
					this.form.projectId === null ||
					this.form.projectId === ''
				) {
					this.$Message.error('请选择项目')
					return
				}
				
				this.setPrice(1)
				this.setAddress()
				utils.add(this)
			},
			edit() {
				this.setPrice(1)
				this.setAddress()
				utils.edit(this)
			},
			active(row) {
				utils.active(this, row)
			},
			search() {
				utils.search(this)
			},
			changeSelection(selections) {
				utils.changeSelections(this, selections)
			},
			changeSort(sortColumn) {
				utils.changeSort(this, sortColumn)
			},
			changePageNo(pageNo) {
				utils.changePageNo(this, pageNo)
			},
			changePageSize(pageSize) {
				utils.changePageSize(this, pageSize)
			},
			// 确认选择用户
			confirmChoice(userId) {
				this.form.userId = userId
				this.cancelModal('userChoice')
			}
		}
	}
</script>

<style>
</style>
