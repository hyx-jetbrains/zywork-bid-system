<template>
	<div>
		<Row>
			<i-col span="24">
				<Card>
					<Button @click="confirmSelection" type="primary">确认选择</Button>&nbsp;
					<Button @click="showModal('search')" type="primary">高级搜索</Button>&nbsp;
					<Tooltip content="刷新" placement="right">
						<Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
					</Tooltip>
					<Table highlight-row ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails"
					 style="margin-top:20px;" @on-current-change="changeCurrent" @on-sort-change="changeSort"></Table>
					<div style="margin: 20px;overflow: hidden">
						<div style="float: right;">
							<Page :total="page.total" :current="searchForm.pageNo" @on-change="changePageNo" @on-page-size-change="changePageSize"
							 showSizer showTotal></Page>
						</div>
					</div>
				</Card>
			</i-col>
		</Row>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="企业编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始企业编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束企业编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="辖区类别">
					<Row>
						<i-col span="11">
							<FormItem prop="jurisdictionTypeMin">
								<InputNumber v-model="searchForm.jurisdictionTypeMin" placeholder="请输入开始辖区类别" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="jurisdictionTypeMax">
								<InputNumber v-model="searchForm.jurisdictionTypeMax" placeholder="请输入结束辖区类别" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="市区" prop="city">
					<Input v-model="searchForm.city" placeholder="请输入市区" />
				</FormItem>
				<FormItem label="企业类型" prop="compType">
					<Input v-model="searchForm.compType" placeholder="请输入企业类型" />
				</FormItem>
				<FormItem label="行业分类" prop="industryType">
					<Input v-model="searchForm.industryType" placeholder="请输入行业分类" />
				</FormItem>
				<FormItem label="企业名称" prop="compName">
					<Input v-model="searchForm.compName" placeholder="请输入企业名称" />
				</FormItem>
				<FormItem label="法人" prop="legalPerson">
					<Input v-model="searchForm.legalPerson" placeholder="请输入法人" />
				</FormItem>
				<FormItem label="法人电话" prop="legalPersonPhone">
					<Input v-model="searchForm.legalPersonPhone" placeholder="请输入法人电话" />
				</FormItem>
				<FormItem label="注册地区" prop="regAddress">
					<Input v-model="searchForm.regAddress" placeholder="请输入注册地区" />
				</FormItem>
				<FormItem label="负责人" prop="responsible">
					<Input v-model="searchForm.responsible" placeholder="请输入负责人" />
				</FormItem>
				<FormItem label="负责人电话" prop="responsiblePhone">
					<Input v-model="searchForm.responsiblePhone" placeholder="请输入负责人电话" />
				</FormItem>
				<FormItem label="单位电话" prop="compPhone">
					<Input v-model="searchForm.compPhone" placeholder="请输入单位电话" />
				</FormItem>
				<FormItem label="联系地址" prop="compAddr">
					<Input v-model="searchForm.compAddr" placeholder="请输入联系地址" />
				</FormItem>
				<FormItem label="注册资本" prop="regCapital">
					<Input v-model="searchForm.regCapital" placeholder="请输入注册资本" />
				</FormItem>
				<FormItem label="经营范围" prop="businessScope">
					<Input v-model="searchForm.businessScope" placeholder="请输入经营范围" />
				</FormItem>
				<FormItem label="可承担业务" prop="affordableBusiness">
					<Input v-model="searchForm.affordableBusiness" placeholder="请输入可承担业务" />
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
				<Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">确定</Button>
			</div>
		</Modal>
		<Modal v-model="modal.detail" title="详情">
			<p>企业编号: <span v-text="form.id"></span></p>
			<p>辖区类别: <span v-text="form.jurisdictionType"></span></p>
			<p>市区: <span v-text="form.city"></span></p>
			<p>企业类型: <span v-text="form.compType"></span></p>
			<p>行业分类: <span v-text="form.industryType"></span></p>
			<p>企业名称: <span v-text="form.compName"></span></p>
			<p>法人: <span v-text="form.legalPerson"></span></p>
			<p>法人电话: <span v-text="form.legalPersonPhone"></span></p>
			<p>注册地区: <span v-text="form.regAddress"></span></p>
			<p>负责人: <span v-text="form.responsible"></span></p>
			<p>负责人电话: <span v-text="form.responsiblePhone"></span></p>
			<p>单位电话: <span v-text="form.compPhone"></span></p>
			<p>联系地址: <span v-text="form.compAddr"></span></p>
			<p>注册资本: <span v-text="form.regCapital"></span></p>
			<p>经营范围: <span v-text="form.businessScope"></span></p>
			<p>可承担业务: <span v-text="form.affordableBusiness"></span></p>
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
		name: 'CompanyListSingle',
		data() {
			return {
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false
				},
				loading: {
					search: false
				},
				urls: {
					searchUrl: '/company/admin/pager-cond',
					allUrl: '/company/admin/all',
					detailUrl: '/company/admin/one/'
				},
				page: {
					total: 0
				},
				form: {
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
				searchForm: {
					pageNo: 1,
					pageSize: 10,
					sortColumn: null,
					sortOrder: null,
					id: null,
					idMin: null,
					idMax: null,
					jurisdictionType: null,
					jurisdictionTypeMin: null,
					jurisdictionTypeMax: null,
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
							width: 60,
							align: 'center',
							fixed: "left",
							render: (h, params) => {
								return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
							}
						},
						{
							title: '企业编号',
							key: 'id',
							minWidth: 120,
							sortable: true
						},
						{
							title: '辖区类别',
							key: 'jurisdictionType',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = null;
								if(params.row.jurisdictionType == 1) {
									text = '省内'
								} else if(params.row.jurisdictionType == 2) {
									text = '省外'
								}
								return h('span', text)
							}
						},
						{
							title: '市区',
							key: 'city',
							minWidth: 180,
							sortable: true
						},
						{
							title: '企业类型',
							key: 'compType',
							minWidth: 120,
							sortable: true
						},
						{
							title: '行业分类',
							key: 'industryType',
							minWidth: 120,
							sortable: true
						},
						{
							title: '企业名称',
							key: 'compName',
							minWidth: 200,
							sortable: true
						},
						{
							title: '法人',
							key: 'legalPerson',
							minWidth: 120,
							sortable: true
						},
						{
							title: '法人电话',
							key: 'legalPersonPhone',
							minWidth: 120,
							sortable: true
						},
						{
							title: '注册地区',
							key: 'regAddress',
							minWidth: 180,
							sortable: true
						},
						{
							title: '负责人',
							key: 'responsible',
							minWidth: 120,
							sortable: true
						},
						{
							title: '负责人电话',
							key: 'responsiblePhone',
							minWidth: 120,
							sortable: true
						},
						{
							title: '单位电话',
							key: 'compPhone',
							minWidth: 120,
							sortable: true
						},
						{
							title: '联系地址',
							key: 'compAddr',
							minWidth: 180,
							sortable: true
						},
						{
							title: '注册资本',
							key: 'regCapital',
							minWidth: 120,
							sortable: true
						},
						{
							title: '经营范围',
							key: 'businessScope',
							minWidth: 350,
							sortable: true
						},
						{
							title: '可承担业务',
							key: 'affordableBusiness',
							minWidth: 350,
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
							title: '操作',
							key: 'action',
							width: 80,
							align: 'center',
							fixed: 'right',
							render: (h, params) => {
								return h('div', [
									h('Button', {
										props: {
											type: 'primary',
											size: 'small'
										},
										style: {
											marginRight: '5px'
										},
										on: {
											click: () => {
												this.showDetail('detail', params.row)
											}
										}
									}, '详情')
								])
							}
						}
					],
					tableDetails: [],
					currentRow: {}
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
			showDetail(modal, row) {
				utils.showModal(this, modal)
				this.form = row
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
			search() {
				utils.search(this)
			},
			changeCurrent(currentRow, oldCurrentRow) {
				utils.changeCurrent(this, currentRow, oldCurrentRow)
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
			confirmSelection() {
				// 确认选择的逻辑
				this.$emit("confirmSelection", this.table.currentRow.id)
			}
		}
	}
</script>

<style>
</style>
