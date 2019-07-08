<template>
	<div>
		<Row>
			<i-col span="24">
				<Card>
					<!-- <Button @click="showModal('add')" type="primary">添加</Button>&nbsp; -->
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
				<FormItem label="服务标题" prop="title">
					<Input v-model="form.title" placeholder="请输入服务标题" />
				</FormItem>
				<FormItem label="详细说明" prop="memo">
					<Input v-model="form.memo" placeholder="请输入详细说明" />
				</FormItem>
				<FormItem label="所有收费的url" prop="urls">
					<Input v-model="form.urls" placeholder="请输入所有收费的url" />
				</FormItem>
				<FormItem label="服务价格" prop="priceDisplay">
					<InputNumber v-model="form.priceDisplay" placeholder="请输入服务价格" style="width: 100%;" />
				</FormItem>
        <FormItem label="折扣" prop="discount">
					<InputNumber v-model="form.discount" placeholder="请输入超过一年的折扣" style="width: 100%;" />
          <p style="color: red;">注：购买时效超过一年该折扣才有效</p>
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		<Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="服务标题" prop="title">
					<Input v-model="form.title" placeholder="请输入服务标题" />
				</FormItem>
				<FormItem label="详细说明" prop="memo">
					<Input v-model="form.memo" placeholder="请输入详细说明" />
				</FormItem>
				<FormItem label="所有收费的url" prop="urls">
					<Input v-model="form.urls" placeholder="请输入所有收费的url" />
				</FormItem>
				<FormItem label="服务价格" prop="priceDisplay">
					<InputNumber v-model="form.priceDisplay" placeholder="请输入服务价格" style="width: 100%;" />
				</FormItem>
        <FormItem label="折扣" prop="discount">
					<InputNumber v-model="form.discount" placeholder="请输入超过一年的折扣" style="width: 100%;" />
          <p style="color: red;">注：购买时效超过一年该折扣才有效</p>
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="服务编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始服务编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束服务编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="服务标题" prop="title">
					<Input v-model="searchForm.title" placeholder="请输入服务标题" />
				</FormItem>
				<FormItem label="详细说明" prop="memo">
					<Input v-model="searchForm.memo" placeholder="请输入详细说明" />
				</FormItem>
				<FormItem label="所有收费的url" prop="urls">
					<Input v-model="searchForm.urls" placeholder="请输入所有收费的url" />
				</FormItem>
				<FormItem label="服务价格">
					<Row>
						<i-col span="11">
							<FormItem prop="priceMin">
								<InputNumber v-model="searchForm.priceMin" placeholder="请输入开始服务价格" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="priceMax">
								<InputNumber v-model="searchForm.priceMax" placeholder="请输入结束服务价格" style="width: 100%;" />
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
			<p>服务编号: <span v-text="form.id"></span></p>
			<p>服务标题: <span v-text="form.title"></span></p>
			<p>详细说明: <span v-text="form.memo"></span></p>
			<p>所有收费的url: <span v-text="form.urls"></span></p>
			<p>服务价格: <span v-text="form.price/100"></span></p>
      <p>折扣: <span v-text="form.discount"></span></p>
			<p>版本号: <span v-text="form.version"></span></p>
			<p>创建时间: <span v-text="form.createTime"></span></p>
			<p>更新时间: <span v-text="form.updateTime"></span></p>
			<p>是否激活: <span v-text="form.isActive"></span></p>

		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'

	export default {
		name: 'Service',
		data() {
			return {
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/service/admin/save',
					batchAddUrl: '/service/admin/batch-save',
					editUrl: '/service/admin/update',
					batchEditUrl: '/service/admin/batch-update',
					searchUrl: '/service/admin/pager-cond',
					allUrl: '/service/admin/all',
					removeUrl: '/service/admin/remove/',
					batchRemoveUrl: '/service/admin/batch-remove',
					detailUrl: '/service/admin/one/',
					activeUrl: '/service/admin/active',
					batchActiveUrl: '/service/admin/batch-active'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					title: null,
					memo: null,
					urls: null,
					price: null,
          priceDisplay: null,
          discount: 100,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,

				},
				validateRules: {
					title: [{
						type: 'string',
						min: 1,
						max: 200,
						message: '必须1-200个字符',
						trigger: 'blur'
					}],
					memo: [{
						type: 'string',
						min: 1,
						max: 500,
						message: '必须1-500个字符',
						trigger: 'blur'
					}],
					urls: [{
						type: 'string',
						min: 1,
						max: 2000,
						message: '必须1-2000个字符',
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
					title: null,
					memo: null,
					urls: null,
					price: null,
					priceMin: null,
					priceMax: null,
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
							title: '服务编号',
							key: 'id',
							minWidth: 120,
							sortable: true
						},
						{
							title: '服务标题',
							key: 'title',
							minWidth: 150,
							sortable: true
						},
						{
							title: '详细说明',
							key: 'memo',
							minWidth: 200,
							sortable: true
						},
						{
							title: '所有收费的url',
							key: 'urls',
							minWidth: 300,
							sortable: true
						},
						{
							title: '服务价格',
							key: 'price',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = params.row.price/100;
								return h('span', text)
							}
            },
            {
							title: '折扣',
							key: 'discount',
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
					this.setPrice(0)
				} else if (itemName === 'showDetail') {
					utils.showModal(this, 'detail')
					this.form = JSON.parse(JSON.stringify(row))
				} else if (itemName === 'remove') {
					utils.remove(this, row)
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
			}
		}
	}
</script>

<style>
</style>
