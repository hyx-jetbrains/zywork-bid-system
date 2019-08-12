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
					<span v-text="form.userId"></span>
					&nbsp;
					<Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
				</FormItem>
				<FormItem label="服务编号" prop="serviceId">
					<span v-text="form.serviceId"></span>
					&nbsp;
					<Button @click="showModal('serviceChoice')" type="text">选择服务</Button>&nbsp;
				</FormItem>
				<FormItem label="服务结束日期" prop="endDate">
					<DatePicker @on-change="form.endDate=$event" :value="form.endDate" placeholder="请输入服务结束日期" type="datetime" format="yyyy-MM-dd HH:mm:ss"
					 style="width: 100%;"></DatePicker>
				</FormItem>
				<FormItem label="有效年" prop="validYear">
					<InputNumber v-model="form.validYear" placeholder="请输入有效年" style="width: 100%;" />
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
					<span v-text="form.userId"></span>
					&nbsp;
					<Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
				</FormItem>
				<FormItem label="服务编号" prop="serviceId">
					<span v-text="form.serviceId"></span>
					&nbsp;
					<Button @click="showModal('serviceChoice')" type="text">选择服务</Button>&nbsp;
				</FormItem>
				<FormItem label="服务结束日期" prop="endDate">
					<DatePicker @on-change="form.endDate=$event" :value="form.endDate" placeholder="请输入服务结束日期" type="datetime" format="yyyy-MM-dd HH:mm:ss"
					 style="width: 100%;"></DatePicker>
				</FormItem>
				<FormItem label="有效年" prop="validYear">
					<InputNumber v-model="form.validYear" placeholder="请输入有效年" style="width: 100%;" />
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="用户服务编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始用户服务编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束用户服务编号" style="width: 100%;" />
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
				<FormItem label="服务编号">
					<Row>
						<i-col span="11">
							<FormItem prop="serviceIdMin">
								<InputNumber v-model="searchForm.serviceIdMin" placeholder="请输入开始服务编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="serviceIdMax">
								<InputNumber v-model="searchForm.serviceIdMax" placeholder="请输入结束服务编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="服务结束日期">
					<Row>
						<i-col span="11">
							<FormItem prop="endDateMin">
								<DatePicker @on-change="searchForm.endDateMin=$event" :value="searchForm.endDateMin" placeholder="请输入开始服务结束日期"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="endDateMax">
								<DatePicker @on-change="searchForm.endDateMax=$event" :value="searchForm.endDateMax" placeholder="请输入结束服务结束日期"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="有效年">
					<Row>
						<i-col span="11">
							<FormItem prop="validYearMin">
								<InputNumber v-model="searchForm.validYearMin" placeholder="请输入开始有效年" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="validYearMax">
								<InputNumber v-model="searchForm.validYearMax" placeholder="请输入结束有效年" style="width: 100%;" />
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
			<p>用户服务编号: <span v-text="form.id"></span></p>
			<p>用户编号: <span v-text="form.userId"></span></p>
			<p>服务编号: <span v-text="form.serviceId"></span></p>
			<p>服务结束日期: <span v-text="form.endDate"></span></p>
			<p>有效年: <span v-text="form.validYear"></span></p>
			<p>版本号: <span v-text="form.version"></span></p>
			<p>创建时间: <span v-text="form.createTime"></span></p>
			<p>更新时间: <span v-text="form.updateTime"></span></p>
			<p>是否激活: <span v-text="form.isActive"></span></p>

		</Modal>
		
		<Modal :transfer="false" v-model="modal.userDetail" title="用户详情">
		  <userDetail :form="userDetailForm" v-on:setDetail="setDetailModal"/>
		</Modal>
		
		<Modal :transfer="false" fullscreen v-model="modal.userDetalSearch" title="搜索主表信息">
		  <user-list-single ref="UserListSingle" v-on:confirmSelection="confirmSelection"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('userDetalSearch')">取消</Button>
		    <Button type="primary" size="large" @click="confirm">确认选择</Button>
		  </div>
		</Modal>
		
		<Modal :transfer="false" fullscreen v-model="modal.userChoice" title="选择用户">
		  <user-list-single ref="UserListSingle" v-on:confirmSelection="confirmChoice"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('userChoice')">取消</Button>
		  </div>
		</Modal>
		
		<Modal :transfer="false" v-model="modal.serviceDetail" title="服务配置详情">
		  <serviceDetail :form="serviceDetailForm" v-on:setDetail="setServiceDetailModal"/>
		</Modal>
		 
		<Modal :transfer="false" fullscreen v-model="modal.serviceDetalSearch" title="搜索主表信息">
		  <service-list-single ref="ServiceListSingle" v-on:confirmServiceSelection="confirmServiceSelection"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('serviceDetalSearch')">取消</Button>
		    <Button type="primary" size="large" @click="confirmService">确认选择</Button>
		  </div>
		</Modal>
		
		<Modal :transfer="false" fullscreen v-model="modal.serviceChoice" title="选择服务配置">
		  <service-list-single ref="ServiceListSingle" v-on:confirmServiceSelection="confirmserviceChoice"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('serviceChoice')">取消</Button>
		  </div>
		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import UserListSingle from '@/view/user/UserListSingle.vue'
	import userDetail from '@/view/user-detail/UserDetail.vue'
	import ServiceListSingle from '@/view/service/ServiceListSingle.vue'
	import ServiceDetail from '@/view/service/ServiceDetail.vue'
	import { getUserById,getServiceById } from '@/api/module'

	export default {
		name: 'UserService',
		components: {
		  userDetail,
		  UserListSingle,
			ServiceListSingle,
			ServiceDetail
		},
		data() {
			return {
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false,
					userDetail: false,
					userDetalSearch: false,
					userChoice: false,
					serviceDetail: false,
					serviceDetalSearch: false,
					serviceChoice: false,
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/user-service/admin/save',
					batchAddUrl: '/user-service/admin/batch-save',
					editUrl: '/user-service/admin/update',
					batchEditUrl: '/user-service/admin/batch-update',
					searchUrl: '/user-service/admin/pager-cond',
					allUrl: '/user-service/admin/all',
					removeUrl: '/user-service/admin/remove/',
					batchRemoveUrl: '/user-service/admin/batch-remove',
					detailUrl: '/user-service/admin/one/',
					activeUrl: '/user-service/admin/active',
					batchActiveUrl: '/user-service/admin/batch-active'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					userId: null,
					serviceId: null,
					endDate: null,
					validYear: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,

				},
				serviceDetailForm: {
					id: null,
					title: null,
					memo: null,
					urls: null,
					price: null,
					priceDisplay: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
				},
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
				validateRules: {

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
					serviceId: null,
					serviceIdMin: null,
					serviceIdMax: null,
					endDate: null,
					endDateMin: null,
					endDateMax: null,
					validYear: null,
					validYearMin: null,
					validYearMax: null,
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
							title: '用户服务编号',
							key: 'id',
							minWidth: 130,
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
							        'DropdownMenu',
							        {
							          slot: 'list'
							        },
							        [
							          h(
							            'DropdownItem',
							            {
							              props: {
							                name: 'userDetail'
							              }
							            },
							            '详情'
							          ),
							          h(
							            'DropdownItem',
							            {
							              props: {
							                name: 'showUserSearch'
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
							title: '服务编号',
							key: 'serviceId',
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
							      h('span', [
							        params.row.serviceId,
							        h('Icon', {
							          props: {
							            type: 'ios-list',
							            size: '25'
							          }
							        })
							      ]),
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
							                name: 'serviceDetail'
							              }
							            },
							            '详情'
							          ),
							          h(
							            'DropdownItem',
							            {
							              props: {
							                name: 'showServiceSearch'
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
							title: '服务结束日期',
							key: 'endDate',
							minWidth: 150,
							sortable: true
						},
						{
							title: '有效年',
							key: 'validYear',
							minWidth: 120,
							sortable: true
            },
            {
							title: '服务状态',
							key: 'endDate',
							minWidth: 150,
              sortable: true,
              render: (h, params) => {
                const endDate = params.row.endDate
                const currDate = utils.getDate(0)
                const color = endDate < currDate ? 'error' : 'primary'
                const txt =  endDate < currDate ? '已过期' : '正常'
                return h('Tag',{
                  props: {
                    color: color
                  }
                }, txt)
              }
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
							title: '是否激活',
							key: 'isActive',
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
				} else if (itemName === 'userDetail') {
					this.showUserDetailModal(row.userId)
				}else if (itemName === 'showUserSearch') {
					utils.showModal(this, 'userDetalSearch')
				}else if (itemName === 'serviceDetail') {
					this.showServiceDetailModal(row.serviceId)
				}else if (itemName === 'showServiceSearch') {
					utils.showModal(this, 'serviceDetalSearch')
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
			setDetailModal(val) {
			  this.modal.userDetail = val
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
			confirmChoice(userId) {
				console.log(userId)
			  this.form.userId = userId
			  this.cancelModal('userChoice')
			},
			showServiceDetailModal(id) {
			  getServiceById(id)
			    .then(res => {
			      const data = res.data
			      if (data.code === 1001) {
			        this.serviceDetailForm = data.data
			        this.modal.serviceDetail = true
			      } else {
			        this.$Message.error(data.message)
			      }
			    })
			    .catch(err => {
			      this.$Message.error(err)
			    })
			},
			setServiceDetailModal(val) {
			  this.modal.serviceDetail = val
			},
			confirmService() {
			  this.$refs.ServiceListSingle.confirmSelection()
			},
			confirmServiceSelection(id) {
			  this.modal.serviceDetalSearch = false
			  this.searchForm.serviceIdMin = id
			  this.searchForm.serviceIdMax = id
			  utils.search(this)
			},
			confirmserviceChoice(serviceId) {
			  this.form.serviceId = serviceId
			  this.cancelModal('serviceChoice')
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
