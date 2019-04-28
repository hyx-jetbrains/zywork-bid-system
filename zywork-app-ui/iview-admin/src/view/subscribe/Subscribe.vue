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
							<DropdownItem name="batchInactive"><span style="color: red;">批量冻结</span></DropdownItem>
							<DropdownItem name="batchRemove" divided><span style="color: red;">批量删除</span></DropdownItem>
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
				<FormItem label="用户编号" prop="userId">
					<InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;" />
				</FormItem>
				<FormItem label="城市" prop="city">
					<Input v-model="form.city" placeholder="请输入城市" />
				</FormItem>
				<FormItem label="项目类型" prop="projectType">
					<Input v-model="form.projectType" placeholder="请输入项目类型" />
				</FormItem>
				<FormItem label="最小金额" prop="minMoney">
					<InputNumber v-model="form.minMoney" placeholder="请输入最小金额" style="width: 100%;" />
				</FormItem>
				<FormItem label="最大金额" prop="maxMoney">
					<InputNumber v-model="form.maxMoney" placeholder="请输入最大金额" style="width: 100%;" />
				</FormItem>
				<FormItem label="招标人" prop="tenderee">
					<Input v-model="form.tenderee" placeholder="请输入招标人" />
				</FormItem>
				<FormItem label="资质类别" prop="aptitudeType">
					<Input v-model="form.aptitudeType" placeholder="请输入资质类别" />
				</FormItem>
				<FormItem label="关键字" prop="keyword">
					<Input v-model="form.keyword" placeholder="请输入关键字" />
				</FormItem>
				<FormItem label="是否开通订阅" prop="isSubscribe">
					<InputNumber v-model="form.isSubscribe" placeholder="请输入是否开通订阅" style="width: 100%;" />
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		<Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="用户编号" prop="userId">
					<InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;" />
				</FormItem>
				<FormItem label="城市" prop="city">
					<Input v-model="form.city" placeholder="请输入城市" />
				</FormItem>
				<FormItem label="项目类型" prop="projectType">
					<Input v-model="form.projectType" placeholder="请输入项目类型" />
				</FormItem>
				<FormItem label="最小金额" prop="minMoney">
					<InputNumber v-model="form.minMoney" placeholder="请输入最小金额" style="width: 100%;" />
				</FormItem>
				<FormItem label="最大金额" prop="maxMoney">
					<InputNumber v-model="form.maxMoney" placeholder="请输入最大金额" style="width: 100%;" />
				</FormItem>
				<FormItem label="招标人" prop="tenderee">
					<Input v-model="form.tenderee" placeholder="请输入招标人" />
				</FormItem>
				<FormItem label="资质类别" prop="aptitudeType">
					<Input v-model="form.aptitudeType" placeholder="请输入资质类别" />
				</FormItem>
				<FormItem label="关键字" prop="keyword">
					<Input v-model="form.keyword" placeholder="请输入关键字" />
				</FormItem>
				<FormItem label="是否开通订阅" prop="isSubscribe">
					<InputNumber v-model="form.isSubscribe" placeholder="请输入是否开通订阅" style="width: 100%;" />
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="订阅编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始订阅编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束订阅编号" style="width: 100%;" />
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
				<FormItem label="城市" prop="city">
					<Input v-model="searchForm.city" placeholder="请输入城市" />
				</FormItem>
				<FormItem label="项目类型" prop="projectType">
					<Input v-model="searchForm.projectType" placeholder="请输入项目类型" />
				</FormItem>
				<FormItem label="最小金额">
					<Row>
						<i-col span="11">
							<FormItem prop="minMoneyMin">
								<InputNumber v-model="searchForm.minMoneyMin" placeholder="请输入开始最小金额" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="minMoneyMax">
								<InputNumber v-model="searchForm.minMoneyMax" placeholder="请输入结束最小金额" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="最大金额">
					<Row>
						<i-col span="11">
							<FormItem prop="maxMoneyMin">
								<InputNumber v-model="searchForm.maxMoneyMin" placeholder="请输入开始最大金额" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="maxMoneyMax">
								<InputNumber v-model="searchForm.maxMoneyMax" placeholder="请输入结束最大金额" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="招标人" prop="tenderee">
					<Input v-model="searchForm.tenderee" placeholder="请输入招标人" />
				</FormItem>
				<FormItem label="资质类别" prop="aptitudeType">
					<Input v-model="searchForm.aptitudeType" placeholder="请输入资质类别" />
				</FormItem>
				<FormItem label="关键字" prop="keyword">
					<Input v-model="searchForm.keyword" placeholder="请输入关键字" />
				</FormItem>
				<FormItem label="是否开通订阅">
					<Row>
						<i-col span="11">
							<FormItem prop="isSubscribeMin">
								<InputNumber v-model="searchForm.isSubscribeMin" placeholder="请输入开始是否开通订阅" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="isSubscribeMax">
								<InputNumber v-model="searchForm.isSubscribeMax" placeholder="请输入结束是否开通订阅" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
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
				<FormItem label="是否激活">
					<Row>
						<i-col span="11">
							<FormItem prop="isActiveMin">
								<InputNumber v-model="searchForm.isActiveMin" placeholder="请输入开始是否激活" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="isActiveMax">
								<InputNumber v-model="searchForm.isActiveMax" placeholder="请输入结束是否激活" style="width: 100%;" />
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
			<p>订阅编号: <span v-text="form.id"></span></p>
			<p>用户编号: <span v-text="form.userId"></span></p>
			<p>城市: <span v-text="form.city"></span></p>
			<p>项目类型: <span v-text="form.projectType"></span></p>
			<p>最小金额: <span v-text="form.minMoney"></span></p>
			<p>最大金额: <span v-text="form.maxMoney"></span></p>
			<p>招标人: <span v-text="form.tenderee"></span></p>
			<p>资质类别: <span v-text="form.aptitudeType"></span></p>
			<p>关键字: <span v-text="form.keyword"></span></p>
			<p>是否开通订阅: <span v-text="form.isSubscribe"></span></p>
			<p>版本号: <span v-text="form.version"></span></p>
			<p>创建时间: <span v-text="form.createTime"></span></p>
			<p>更新时间: <span v-text="form.updateTime"></span></p>
			<p>是否激活: <span v-text="form.isActive"></span></p>

		</Modal>
		
		<Modal
		  :transfer="false"
		  v-model="modal.userDetail"
		  title="模块详情">
			<userDetail :form="userDetailForm" v-on:setDetail="setDetailModal"/>
		</Modal>
		
		<Modal
		  :transfer="false"
		  fullscreen
		  v-model="modal.userDetalSearch"
		  title="搜索主表信息">
		  <user-list ref="UserList" v-on:confirmSelection="confirmSelection"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('userDetalSearch')">取消</Button>
		    <Button type="primary" size="large" @click="confirm">确认选择</Button>
		  </div>
		</Modal>
	</div>
</template>

<script>
  import * as utils from '@/api/utils'
  import * as ResponseStatus from '@/api/response-status'
	import UserList from '@/view/user/UserList.vue'
	import userDetail from '@/view/user-detail/UserDetail.vue'
	import {getUserById} from '@/api/module'

	export default {
		name: 'Subscribe',
		components: {
			userDetail,
			UserList
		},
		data() {
			return {
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false,
					userDetail: false,
					userDetalSearch: false
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/subscribe/admin/save',
					batchAddUrl: '/subscribe/admin/batch-save',
					editUrl: '/subscribe/admin/update',
					batchEditUrl: '/subscribe/admin/batch-update',
					searchUrl: '/subscribe/admin/pager-cond',
					allUrl: '/subscribe/admin/all',
					removeUrl: '/subscribe/admin/remove/',
					batchRemoveUrl: '/subscribe/admin/batch-remove',
					detailUrl: '/subscribe/admin/one/',
					activeUrl: '/subscribe/admin/active',
					batchActiveUrl: '/subscribe/admin/batch-active'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					userId: null,
					city: null,
					projectType: null,
					minMoney: null,
					maxMoney: null,
					tenderee: null,
					aptitudeType: null,
					keyword: null,
					isSubscribe: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,

				},
				validateRules: {
					userId: [{
						type: 'integer',
						required: true,
						message: '此项为必须项',
						trigger: 'blur, change'
					}],
					city: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					projectType: [{
						type: 'string',
						min: 1,
						max: 255,
						message: '必须1-255个字符',
						trigger: 'blur'
					}],
					tenderee: [{
						type: 'string',
						min: 1,
						max: 255,
						message: '必须1-255个字符',
						trigger: 'blur'
					}],
					aptitudeType: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					keyword: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],

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
					city: null,
					projectType: null,
					minMoney: null,
					minMoneyMin: null,
					minMoneyMax: null,
					maxMoney: null,
					maxMoneyMin: null,
					maxMoneyMax: null,
					tenderee: null,
					aptitudeType: null,
					keyword: null,
					isSubscribe: null,
					isSubscribeMin: null,
					isSubscribeMax: null,
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
					isActiveMax: null,

				},
				table: {
					loading: false,
					tableColumns: [{
							type: 'selection',
							width: 45,
							key: "id",
							align: 'center',
							fixed: 'left'
						},
						{
							width: 60,
							align: 'center',
							fixed: "left",
							render: (h, params) => {
								return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
							}
						},
						{
							title: '订阅编号',
							key: 'id',
							minWidth: 120,
							sortable: true
						},
						{
							title: '用户编号',
							key: 'userId',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
							  return h(
							    'Dropdown',
							    {
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
							        'span',
							        [
							          params.row.userId,
							          h('Icon', {
							            props: {
							              type: 'ios-list',
							              size: '25'
							            }
							          })
							        ]
							      ),
							      h(
							        'DropdownMenu',
							        {
							          slot: 'list'
							        },
							        [
							          h(
							            'DropdownItem',
							            {
							              props: {
							                name: 'moduleDetail'
							              }
							            },
							            '详情'
							          ),
							          h(
							            'DropdownItem',
							            {
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
							title: '城市',
							key: 'city',
							minWidth: 120,
							sortable: true
						},
						{
							title: '项目类型',
							key: 'projectType',
							minWidth: 120,
							sortable: true
						},
						{
							title: '最小金额',
							key: 'minMoney',
							minWidth: 120,
							sortable: true
						},
						{
							title: '最大金额',
							key: 'maxMoney',
							minWidth: 120,
							sortable: true
						},
						{
							title: '招标人',
							key: 'tenderee',
							minWidth: 120,
							sortable: true
						},
						{
							title: '资质类别',
							key: 'aptitudeType',
							minWidth: 120,
							sortable: true
						},
						{
							title: '关键字',
							key: 'keyword',
							minWidth: 120,
							sortable: true
						},
						{
							title: '是否开通订阅',
							key: 'isSubscribe',
							minWidth: 130,
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
							title: '是否激活',
							key: 'isActive',
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
							title: '激活状态',
							key: 'isActive',
							minWidth: 100,
							align: 'center',
							render: (h, params) => {
								return h('i-switch', {
									props: {
										size: 'large',
										value: params.row.isActive === 0
									},
									style: {
										marginRight: '5px'
									},
									on: {
										'on-change': (status) => {
											this.active(params.row)
										}
									}
								}, [
									h('span', {
										slot: 'open'
									}, '激活'),
									h('span', {
										slot: 'close'
									}, '冻结')
								])
							}
						},
						{
							title: '操作',
							key: 'action',
							width: 120,
							align: 'center',
							fixed: 'right',
							render: (h, params) => {
								return h('Dropdown', {
									on: {
										'on-click': (itemName) => {
											this.userOpt(itemName, params.row)
										}
									},
									props: {
										transfer: true
									}
								}, [
									h('Button', {
										props: {
											type: 'primary',
											size: 'small'
										}
									}, [
										'选择操作 ',
										h('Icon', {
											props: {
												type: 'ios-arrow-down'
											}
										})
									]),
									h('DropdownMenu', {
										slot: "list"
									}, [
										h('DropdownItem', {
											props: {
												name: 'showEdit'
											}
										}, '编辑'),
										h('DropdownItem', {
											props: {
												name: 'showDetail'
											}
										}, '详情'),
										h('DropdownItem', {
											props: {
												name: 'remove'
											}
										}, [
											h('span', {
												style: {
													color: 'red'
												}
											}, '删除')
										])
									])
								])
							}
						}
					],
					tableDetails: [],
					selections: []
				}
			}
		},
		computed: {},
		mounted() {
			this.search()
		},
		methods: {
			showModal(modal) {
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
				} else if (itemName === 'showDetail') {
					utils.showModal(this, 'detail')
					this.form = JSON.parse(JSON.stringify(row))
				} else if (itemName === 'remove') {
					utils.remove(this, row)
				} else if (itemName === 'moduleDetail') {
					this.showUserDetailModal(row.userId)
				} else if (itemName === 'showSearch') {
					utils.showModal(this, 'userDetalSearch')
				}
			},
			showUserDetailModal(id) {
			  getUserById(id)
			    .then(res => {
			      const data = res.data
			      if (data.code === ResponseStatus.OK) {
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
			setDetailModal(val) {
			  this.modal.userDetail = val
			},
			confirmSelection(id) {
        this.cancelModal('userDetalSearch')
			  this.searchForm.userIdMin = id
			  this.searchForm.userIdMax = id
			  utils.search(this)
			},
			confirm() {
			  this.$refs.UserList.confirmSelection()
			},
			add() {
				utils.add(this)
			},
			edit() {
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
			}
		}
	}
</script>

<style>
</style>
