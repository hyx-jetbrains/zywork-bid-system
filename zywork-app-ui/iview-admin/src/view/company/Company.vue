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
				<FormItem label="辖区类别" prop="jurisdictionType">
					<Select v-model="form.jurisdictionType" placeholder="请输入辖区类别" clearable filterable @on-change="initJurisdictionType">
						<i-option v-for="item in regionList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="市区" prop="city">
					<Cascader :data="cityData" v-model="tempAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="企业类型" prop="compType">
					<Select v-model="form.compType" placeholder="请输入企业类型" clearable filterable @on-change="initcompType">
						<i-option v-for="item in compTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="行业分类" prop="industryType">
					<Select v-model="form.industryType" placeholder="请输入行业分类" clearable filterable @on-change="initIndustryType">
						<i-option v-for="item in industryTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="企业名称" prop="compName">
					<Input v-model="form.compName" placeholder="请输入企业名称" />
				</FormItem>
				<FormItem label="法人" prop="legalPerson">
					<Input v-model="form.legalPerson" placeholder="请输入法人" />
				</FormItem>
				<FormItem label="法人电话" prop="legalPersonPhone">
					<Input v-model="form.legalPersonPhone" placeholder="请输入法人电话" />
				</FormItem>
				<FormItem label="注册地区" prop="regAddress">
					<Cascader :data="cityData" v-model="regAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="负责人" prop="responsible">
					<Input v-model="form.responsible" placeholder="请输入负责人" />
				</FormItem>
				<FormItem label="负责人电话" prop="responsiblePhone">
					<Input v-model="form.responsiblePhone" placeholder="请输入负责人电话" />
				</FormItem>
				<FormItem label="单位电话" prop="compPhone">
					<Input v-model="form.compPhone" placeholder="请输入单位电话" />
				</FormItem>
				<FormItem label="联系地址" prop="compAddr">
					<Cascader :data="cityData" v-model="compAddr" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="注册资本" prop="regCapitalDisplay">
					<Input v-model="form.regCapitalDisplay" placeholder="请输入注册资本" />
				</FormItem>
				<FormItem label="经营范围" prop="businessScope">
					<Input v-model="form.businessScope" type="textarea" :autosize="descriptionAutoSize" placeholder="请输入经营范围" />
				</FormItem>
				<FormItem label="可承担业务" prop="affordableBusiness">
					<Input v-model="form.affordableBusiness" type="textarea" :autosize="descriptionAutoSize" placeholder="请输入可承担业务" />
				</FormItem>
				<FormItem label="源地址" prop="sourceUrl">
					<Input v-model="form.sourceUrl" placeholder="请输入源地址" />
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		<Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="辖区类别" prop="jurisdictionType">
					<Select v-model="form.jurisdictionType" placeholder="请输入辖区类别" clearable filterable @on-change="initJurisdictionType">
						<i-option v-for="item in regionList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="市区" prop="city">
					<Cascader :data="cityData" v-model="tempAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="企业类型" prop="compType">
					<Select v-model="form.compType" placeholder="请输入企业类型" clearable filterable @on-change="initcompType">
						<i-option v-for="item in compTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="行业分类" prop="industryType">
					<Input v-model="form.industryType" placeholder="请输入行业分类" />
				</FormItem>
				<FormItem label="企业名称" prop="compName">
					<Input v-model="form.compName" placeholder="请输入企业名称" />
				</FormItem>
				<FormItem label="法人" prop="legalPerson">
					<Input v-model="form.legalPerson" placeholder="请输入法人" />
				</FormItem>
				<FormItem label="法人电话" prop="legalPersonPhone">
					<Input v-model="form.legalPersonPhone" placeholder="请输入法人电话" />
				</FormItem>
				<FormItem label="注册地区" prop="regAddress">
					<Cascader :data="cityData" v-model="regAddress" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="负责人" prop="responsible">
					<Input v-model="form.responsible" placeholder="请输入负责人" />
				</FormItem>
				<FormItem label="负责人电话" prop="responsiblePhone">
					<Input v-model="form.responsiblePhone" placeholder="请输入负责人电话" />
				</FormItem>
				<FormItem label="单位电话" prop="compPhone">
					<Input v-model="form.compPhone" placeholder="请输入单位电话" />
				</FormItem>
				<FormItem label="联系地址" prop="compAddr">
					<Cascader :data="cityData" v-model="compAddr" trigger="hover" change-on-select filterable clearable />
				</FormItem>
				<FormItem label="注册资本" prop="regCapitalDisplay">
					<Input v-model="form.regCapitalDisplay" placeholder="请输入注册资本" />
				</FormItem>
				<FormItem label="经营范围" prop="businessScope">
					<Input v-model="form.businessScope" type="textarea" :autosize="descriptionAutoSize" placeholder="请输入经营范围" />
				</FormItem>
				<FormItem label="可承担业务" prop="affordableBusiness">
					<Input v-model="form.affordableBusiness" type="textarea" :autosize="descriptionAutoSize" placeholder="请输入可承担业务" />
				</FormItem>
				<FormItem label="源地址" prop="sourceUrl">
					<Input v-model="form.sourceUrl" placeholder="请输入源地址" />
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
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
					<Cascader :data="cityData" v-model="compAddr" trigger="hover" change-on-select filterable clearable />
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
				<Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
			</div>
		</Modal>
		<Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
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
			<p>注册资本: <span v-text="form.regCapital/100"></span></p>
			<p>经营范围: <span v-text="form.businessScope"></span></p>
			<p>可承担业务: <span v-text="form.affordableBusiness"></span></p>
			<p>
				源地址：
				<a :href="form.sourceUrl" target="_blank">{{form.sourceUrl}}</a>
			</p>
			<p>版本号: <span v-text="form.version"></span></p>
			<p>创建时间: <span v-text="form.createTime"></span></p>
			<p>更新时间: <span v-text="form.updateTime"></span></p>
			<p>是否激活: <span v-text="form.isActive"></span></p>

		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import city from '@/api/city.json'
	import {
		projectCity,
		region,
		compType,
		industryType
	} from '@/api/select'

	export default {
		name: 'Company',
		data() {
			return {
				regionList: region,
				compTypeList: compType,
				industryTypeList: industryType,
				cityData: city,
				tempAddress: [],
				regAddress: [],
				compAddr: [],
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
					addUrl: '/company/admin/save',
					batchAddUrl: '/company/admin/batch-save',
					editUrl: '/company/admin/update',
					batchEditUrl: '/company/admin/batch-update',
					searchUrl: '/company/admin/pager-cond',
					allUrl: '/company/admin/all',
					removeUrl: '/company/admin/remove/',
					batchRemoveUrl: '/company/admin/batch-remove',
					detailUrl: '/company/admin/one/',
					activeUrl: '/company/admin/active',
					batchActiveUrl: '/company/admin/batch-active'
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
					regCapitalDisplay: null,
					businessScope: null,
					affordableBusiness: null,
					sourceUrl: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,

				},
				validateRules: {
					city: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					compType: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					industryType: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					compName: [{
							type: 'string',
							required: true,
							message: '此项为必须项',
							trigger: 'blur'
						},
						{
							type: 'string',
							min: 1,
							max: 20,
							message: '必须1-20个字符',
							trigger: 'blur'
						}
					],
					legalPerson: [{
						type: 'string',
						min: 1,
						max: 10,
						message: '必须1-10个字符',
						trigger: 'blur'
					}],
					legalPersonPhone: [{
						type: 'string',
						min: 1,
						max: 11,
						message: '必须1-11个字符',
						trigger: 'blur'
					}],
					regAddress: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					responsible: [{
						type: 'string',
						min: 1,
						max: 10,
						message: '必须1-10个字符',
						trigger: 'blur'
					}],
					responsiblePhone: [{
						type: 'string',
						min: 1,
						max: 11,
						message: '必须1-11个字符',
						trigger: 'blur'
					}],
					compPhone: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					compAddr: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					regCapital: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-25个字符',
						trigger: 'blur'
					}],
					businessScope: [{
						type: 'string',
						min: 1,
						max: 255,
						message: '必须1-255个字符',
						trigger: 'blur'
					}],
					affordableBusiness: [{
						type: 'string',
						min: 1,
						max: 255,
						message: '必须1-255个字符',
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
							title: '企业编号',
							key: 'id',
							minWidth: 120,
							align: 'center',
							sortable: true
						},
						{
							title: '辖区类别',
							key: 'jurisdictionType',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = null;
								if (params.row.jurisdictionType == 0) {
									text = '省内'
								} else if (params.row.jurisdictionType == 1) {
									text = '省外'
								}
								return h('span', text)
							}
						},
						{
							title: '市区',
							key: 'city',
							minWidth: 150,
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
							minWidth: 120,
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
							minWidth: 150,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '注册资本',
							key: 'regCapital',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = params.row.regCapital/100;
								return h('span', '￥'+text)
							}
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
							title: '源地址',
							key: 'sourceUrl',
							minWidth: 150,
							sortable: true,
							render: (h, params) => {
								const row = params.row
								return h(
									'a', {
										attrs: {
											href: row.sourceUrl,
											target: '_blank'
										}
									},
									row.sourceUrl
								)
							}
						},
						{
							title: '版本号',
							key: 'version',
							minWidth: 120,
							align: 'center',
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
				},
				descriptionAutoSize: {
					minRows: 3,
					maxRows: 5
				},
			}
		},
		computed: {},
		mounted() {
			this.search()
		},
		methods: {
			showModal(modal) {
				if (modal === 'add') {
					this.tempAddress = []
					this.regAddress = []
					this.compAddr = []
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
					var tempAddress = this.form.city.split("/")
					for (var i = 0; tempAddress.length > i; i++) {
						this.tempAddress.push(tempAddress[i])
					}

					var regAddress = this.form.regAddress.split("/")
					for (var i = 0; regAddress.length > i; i++) {
						this.regAddress.push(regAddress[i])
					}

					var compAddr = this.form.compAddr.split("/")
					for (var i = 0; compAddr.length > i; i++) {
						this.compAddr.push(compAddr[i])
					}
				} else if (itemName === 'showDetail') {
					utils.showModal(this, 'detail')
					this.form = JSON.parse(JSON.stringify(row))
				} else if (itemName === 'remove') {
					utils.remove(this, row)
				}
			},
			setAddress() {
				if (this.tempAddress.length > 0) {
					this.form.city = this.tempAddress[0] + '/' + this.tempAddress[1] + '/' + this.tempAddress[2]
				}
				if (this.regAddress.length > 0) {
					this.form.regAddress = this.regAddress[0] + '/' + this.regAddress[1] + '/' + this.regAddress[2]
				}
				if (this.compAddr.length > 0) {
					this.form.compAddr = this.compAddr[0] + '/' + this.compAddr[1] + '/' + this.compAddr[2]
				}
			},
			setPrice(type) {
				if (type === 0) {
					if (this.form.regCapital !== null && this.form.regCapital !== 0) {
						this.form.regCapitalDisplay = this.form.regCapital / 100
					}
				} else if (type === 1) {
					if (this.form.regCapitalDisplay !== null && this.form.regCapitalDisplay !== 0) {
						this.form.regCapital = this.form.regCapitalDisplay * 100
					}
				}
			},
			add() {
				this.setAddress()
				this.setPrice(1)
				utils.add(this)
			},
			edit() {
				this.setAddress()
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
			initJurisdictionType(val) {
				this.form.jurisdictionType = val
			},
			initcompType(val) {
				this.form.compType = val
			},
			initIndustryType(val) {
				this.form.industryType = val
			}
		}
	}
</script>

<style>
</style>
