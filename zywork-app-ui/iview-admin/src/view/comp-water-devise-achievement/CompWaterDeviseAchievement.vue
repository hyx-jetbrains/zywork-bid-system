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
				<FormItem label="企业编号" prop="compId">
					<span v-text="form.compId"></span>
					&nbsp;
					<Button @click="showModal('companyChoice')" type="text">选择企业</Button>&nbsp;
				</FormItem>
				<FormItem label="标段(包)名称" prop="projectName">
					<Input v-model="form.projectName" placeholder="请输入标段(包)名称" />
				</FormItem>
				<FormItem label="项目类型" prop="tenderingComp">
					<Select
					  v-model="form.tenderingComp"
					  placeholder="项目类型"
					  clearable
					  filterable
						@on-change="initTenderingComp"
					>
						<i-option v-for="item in TenderingCompList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="招标(单位)人" prop="buildComp">
					<Input v-model="form.buildComp" placeholder="请输入招标(单位)人" />
				</FormItem>
				<FormItem label="中标时间" prop="markDate">
					<DatePicker @on-change="form.markDate=$event" :value="form.markDate" placeholder="请输入中标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss"
					 style="width: 100%;"></DatePicker>
				</FormItem>
				<FormItem label="合同金额（万元）" prop="contractAmount">
					<Input v-model="form.contractAmount" placeholder="请输入合同金额" />
				</FormItem>
				<FormItem label="项目负责人" prop="name">
					<Input v-model="form.name" placeholder="请输入项目负责人" />
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		<Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="企业编号" prop="compId">
					<span v-text="form.compId"></span>
					&nbsp;
					<Button @click="showModal('companyChoice')" type="text">选择企业</Button>&nbsp;
				</FormItem>
				<FormItem label="标段(包)名称" prop="projectName">
					<Input v-model="form.projectName" placeholder="请输入标段(包)名称" />
				</FormItem>
				<FormItem label="项目类型" prop="tenderingComp">
					<Select
					  v-model="form.tenderingComp"
					  placeholder="项目类型"
					  clearable
					  filterable
						@on-change="initTenderingComp"
					>
						<i-option v-for="item in TenderingCompList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="招标(单位)人" prop="buildComp">
					<Input v-model="form.buildComp" placeholder="请输入招标(单位)人" />
				</FormItem>
				<FormItem label="中标时间" prop="markDate">
					<DatePicker @on-change="form.markDate=$event" :value="form.markDate" placeholder="请输入中标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss"
					 style="width: 100%;"></DatePicker>
				</FormItem>
				<FormItem label="合同金额（万元）" prop="contractAmount">
					<Input v-model="form.contractAmount" placeholder="请输入合同金额" />
				</FormItem>
				<FormItem label="项目负责人" prop="name">
					<Input v-model="form.name" placeholder="请输入项目负责人" />
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="企业水利勘查设计业绩编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始企业水利勘查设计业绩编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束企业水利勘查设计业绩编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="企业编号">
					<Row>
						<i-col span="11">
							<FormItem prop="compIdMin">
								<InputNumber v-model="searchForm.compIdMin" placeholder="请输入开始企业编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="compIdMax">
								<InputNumber v-model="searchForm.compIdMax" placeholder="请输入结束企业编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="标段(包)名称" prop="projectName">
					<Input v-model="searchForm.projectName" placeholder="请输入标段(包)名称" />
				</FormItem>
				<FormItem label="项目类型" prop="tenderingComp">
					<Input v-model="searchForm.tenderingComp" placeholder="请输入项目类型" />
				</FormItem>
				<FormItem label="招标(单位)人" prop="buildComp">
					<Input v-model="searchForm.buildComp" placeholder="请输入招标(单位)人" />
				</FormItem>
				<FormItem label="中标时间">
					<Row>
						<i-col span="11">
							<FormItem prop="markDateMin">
								<DatePicker @on-change="searchForm.markDateMin=$event" :value="searchForm.markDateMin" placeholder="请输入开始中标时间"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="markDateMax">
								<DatePicker @on-change="searchForm.markDateMax=$event" :value="searchForm.markDateMax" placeholder="请输入结束中标时间"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="合同金额" prop="contractAmount">
					<Input v-model="searchForm.contractAmount" placeholder="请输入合同金额" />
				</FormItem>
				<FormItem label="项目负责人" prop="name">
					<Input v-model="searchForm.name" placeholder="请输入项目负责人" />
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
			<p>企业水利勘查设计业绩编号: <span v-text="form.id"></span></p>
			<p>企业编号: <span v-text="form.compId"></span></p>
			<p>标段(包)名称: <span v-text="form.projectName"></span></p>
			<p>项目类型: <span v-text="form.tenderingComp"></span></p>
			<p>招标(单位)人: <span v-text="form.buildComp"></span></p>
			<p>中标时间: <span v-text="form.markDate"></span></p>
			<p>合同金额: <span v-text="form.contractAmount/100"></span></p>
			<p>项目负责人: <span v-text="form.name"></span></p>
			<p>版本号: <span v-text="form.version"></span></p>
			<p>创建时间: <span v-text="form.createTime"></span></p>
			<p>更新时间: <span v-text="form.updateTime"></span></p>
			<p>是否激活: <span v-text="form.isActive"></span></p>

		</Modal>
		
		<Modal :transfer="false" v-model="modal.companyDetail" title="企业详情">
		  <CompanyDetail :form="companyDetailForm" />
		</Modal>
		
		<Modal
		  :transfer="false"
		  fullscreen
		  v-model="modal.companyChoice"
		  title="搜索主表信息">
		  <company-list-single ref="CompanyListSingle" v-on:confirmSelection="confirmSelection"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('companyChoice')">取消</Button>
		    <Button type="primary" size="large" @click="confirm">确认选择</Button>
		  </div>
		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import {getCompanyById} from '@/api/module'
	import CompanyDetail from '@/view/company/CompanyDetail.vue'
	import CompanyListSingle from '@/view/company/CompanyListSingle.vue'
	import {projectType} from '@/api/select'

	export default {
		name: 'CompWaterDeviseAchievement',
		components: {
			CompanyListSingle,
			CompanyDetail
		},
		data() {
			return {
				TenderingCompList: projectType,
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false,
					companyDetail: false,
					companyChoice: false,
					operate: ''
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/comp-water-devise-achievement/admin/save',
					batchAddUrl: '/comp-water-devise-achievement/admin/batch-save',
					editUrl: '/comp-water-devise-achievement/admin/update',
					batchEditUrl: '/comp-water-devise-achievement/admin/batch-update',
					searchUrl: '/comp-water-devise-achievement/admin/pager-cond',
					allUrl: '/comp-water-devise-achievement/admin/all',
					removeUrl: '/comp-water-devise-achievement/admin/remove/',
					batchRemoveUrl: '/comp-water-devise-achievement/admin/batch-remove',
					detailUrl: '/comp-water-devise-achievement/admin/one/',
					activeUrl: '/comp-water-devise-achievement/admin/active',
					batchActiveUrl: '/comp-water-devise-achievement/admin/batch-active'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					compId: null,
					projectName: null,
          tenderingComp: null,
          money: null,
					buildComp: null,
					markDate: null,
					contractAmount: null,
					contractAmountDisplay: null,
					name: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,

				},
				companyDetailForm: {
					id: null,
					jurisdictionType: null,
					city: null,
					compType: null,
					industryType: null,
					compName: null,
					legalPerson: null,
					legalPersonPhone: null,
					regAddress: null,
					responsible: null,
					responsiblePhone: null,
					compPhone: null,
					compAddr: null,
					regCapital: null,
					businessScope: null,
					affordableBusiness: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
				},
				validateRules: {
					compId: [{
						type: 'integer',
						required: true,
						message: '此项为必须项',
						trigger: 'blur, change'
					}],
					projectName: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					tenderingComp: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					buildComp: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					contractAmount: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					name: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
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
					compId: null,
					compIdMin: null,
					compIdMax: null,
					projectName: null,
					tenderingComp: null,
					buildComp: null,
					markDate: null,
					markDateMin: null,
					markDateMax: null,
					contractAmount: null,
					name: null,
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
							title: '企业水利勘查设计业绩编号',
							key: 'id',
							minWidth: 200,
							align: 'center',
							sortable: true
						},
						{
							title: '企业编号',
							key: 'compId',
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
							          params.row.compId,
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
							title: '标段(包)名称',
							key: 'projectName',
							minWidth: 120,
							sortable: true
						},
						{
							title: '项目类型',
							key: 'tenderingComp',
							minWidth: 120,
							sortable: true
						},
						{
							title: '招标(单位)人',
							key: 'buildComp',
							minWidth: 120,
							sortable: true
						},
						{
							title: '中标时间',
							key: 'markDate',
							minWidth: 150,
							sortable: true
						},
						{
							title: '合同金额（万元）',
							key: 'contractAmount',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = params.row.contractAmount;
								return h('span', '￥'+text)
							}
						},
						{
							title: '项目负责人',
							key: 'name',
							minWidth: 120,
							sortable: true
						},
						{
							title: '版本号',
							key: 'version',
							align: 'center',
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
							align: 'center',
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
				this.modal.operate = 'operate'
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
				} else if (itemName === 'showDetail') {
					utils.showModal(this, 'detail')
					this.form = JSON.parse(JSON.stringify(row))
				} else if (itemName === 'remove') {
					utils.remove(this, row)
				} else if (itemName === 'moduleDetail') {
					this.showUserDetailModal(row.compId)
				} else if (itemName === 'showSearch') {
					utils.showModal(this, 'companyChoice')
					this.modal.operate = 'show'
				}
			},
			showUserDetailModal(id) {
			  getCompanyById(id)
			    .then(res => {
			      const data = res.data
			      if (data.code === 1001) {
			        this.companyDetailForm = data.data
			        this.modal.companyDetail = true
			      } else {
			        this.$Message.error(data.message)
			      }
			    })
			    .catch(err => {
			      this.$Message.error(err)
			    })
			},
			confirmSelection(id) {
				this.modal.companyChoice = false
				if(this.modal.operate === 'show') {
					this.searchForm.compIdMin = id
					this.searchForm.compIdMax = id
					utils.search(this)
				} else if(this.modal.operate === 'operate') {
					this.form.compId = id
				}
			},
			confirm() {
			  this.$refs.CompanyListSingle.confirmSelection()
			},
			setPrice(type) {
				// if (type === 0) {
				// 	if (this.form.contractAmount !== null && this.form.contractAmount !== 0) {
				// 		this.form.contractAmountDisplay = this.form.contractAmount / 100
				// 	}
				// } else if (type === 1) {
				// 	if (this.form.contractAmountDisplay !== null && this.form.contractAmountDisplay !== 0) {
				// 		this.form.contractAmount = this.form.contractAmountDisplay * 100
				// 	}
        // }
        this.form.money = this.form.contractAmount
			},
			add() {
				this.setPrice(1)
				utils.add(this)
			},
			edit() {
				this.setPrice(1)
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
			initTenderingComp(val) {
				this.form.tenderingComp = val
			}
		}
	}
</script>

<style>
</style>
