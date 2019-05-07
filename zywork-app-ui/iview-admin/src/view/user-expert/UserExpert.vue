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
				<FormItem label="专家姓名" prop="name">
					<Input v-model="form.name" placeholder="请输入专家姓名" />
				</FormItem>
				<FormItem label="性别" prop="gender">
					<Select
					  v-model="form.gender"
					  placeholder="请选择性别"
					  clearable
					  filterable
					>
					  <i-option v-for="item in genderList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="年龄" prop="age">
					<InputNumber v-model="form.age" placeholder="请输入年龄" style="width: 100%;" />
				</FormItem>
				<FormItem label="专家类别" prop="type">
					<Input v-model="form.type" placeholder="请输入专家类别" />
				</FormItem>
				<FormItem label="是否全职" prop="isFulltime">
					<Select
						v-model="form.isFulltime"
						placeholder="请选是否全职"
						clearable
						filterable
					>
						<i-option v-for="item in jobTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="联系电话" prop="phone">
					<Input v-model="form.phone" placeholder="请输入联系电话" />
				</FormItem>
				<FormItem label="个人情况介绍" prop="memo">
					<Input v-model="form.memo" 
						type="textarea"
						:autosize="descriptionAutoSize"
						placeholder="请输入个人情况介绍" />
				</FormItem>
				<FormItem label="审核状态" prop="examineStatus">
					<Select
						v-model="form.examineStatus"
						placeholder="请选审核状"
						clearable
						filterable
					>
						<i-option v-for="item in examineList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
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
				<FormItem label="专家姓名" prop="name">
					<Input v-model="form.name" placeholder="请输入专家姓名" />
				</FormItem>
				<FormItem label="性别" prop="gender">
					<Select
					  v-model="form.gender"
					  placeholder="请选择性别"
					  clearable
					  filterable
					>
					  <i-option v-for="item in genderList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="年龄" prop="age">
					<InputNumber v-model="form.age" placeholder="请输入年龄" style="width: 100%;" />
				</FormItem>
				<FormItem label="专家类别" prop="type">
					<Input v-model="form.type" placeholder="请输入专家类别" />
				</FormItem>
				<FormItem label="是否全职" prop="isFulltime">
					<Select
						v-model="form.isFulltime"
						placeholder="请选是否全职"
						clearable
						filterable
					>
						<i-option v-for="item in jobTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>
				<FormItem label="联系电话" prop="phone">
					<Input v-model="form.phone" placeholder="请输入联系电话" />
				</FormItem>
				<FormItem label="个人情况介绍" prop="memo">
					<Input v-model="form.memo"
						type="textarea"
						:autosize="descriptionAutoSize"
						placeholder="请输入个人情况介绍" />
				</FormItem>
				<FormItem label="审核状态" prop="examineStatus">
					<Select
						v-model="form.examineStatus"
						placeholder="请选审核状"
						clearable
						filterable
					>
						<i-option v-for="item in examineList" :value="item.value" :key="item.key">{{item.label}}</i-option>
					</Select>
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="专家信息编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始专家信息编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束专家信息编号" style="width: 100%;" />
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
				<FormItem label="专家姓名" prop="name">
					<Input v-model="searchForm.name" placeholder="请输入专家姓名" />
				</FormItem>
				<FormItem label="性别">
					<Row>
						<i-col span="11">
							<FormItem prop="genderMin">
								<InputNumber v-model="searchForm.genderMin" placeholder="请输入开始性别" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="genderMax">
								<InputNumber v-model="searchForm.genderMax" placeholder="请输入结束性别" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="年龄">
					<Row>
						<i-col span="11">
							<FormItem prop="ageMin">
								<InputNumber v-model="searchForm.ageMin" placeholder="请输入开始年龄" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="ageMax">
								<InputNumber v-model="searchForm.ageMax" placeholder="请输入结束年龄" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="专家类别" prop="type">
					<Input v-model="searchForm.type" placeholder="请输入专家类别" />
				</FormItem>
				<FormItem label="是否全职">
					<Row>
						<i-col span="11">
							<FormItem prop="isFulltimeMin">
								<InputNumber v-model="searchForm.isFulltimeMin" placeholder="请输入开始是否全职" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="isFulltimeMax">
								<InputNumber v-model="searchForm.isFulltimeMax" placeholder="请输入结束是否全职" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="联系电话" prop="phone">
					<Input v-model="searchForm.phone" placeholder="请输入联系电话" />
				</FormItem>
				<FormItem label="个人情况介绍" prop="memo">
					<Input v-model="searchForm.memo" placeholder="请输入个人情况介绍" />
				</FormItem>
				<FormItem label="审核状态">
					<Row>
						<i-col span="11">
							<FormItem prop="examineStatusMin">
								<InputNumber v-model="searchForm.examineStatusMin" placeholder="请输入开始审核状态" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="examineStatusMax">
								<InputNumber v-model="searchForm.examineStatusMax" placeholder="请输入结束审核状态" style="width: 100%;" />
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
			<p>专家信息编号: <span v-text="form.id"></span></p>
			<p>用户编号: <span v-text="form.userId"></span></p>
			<p>专家姓名: <span v-text="form.name"></span></p>
			<p>性别: <span v-text="(form.gender == '1' ? '男' : form.gender == '2' ? '女' : '未知')"></span></p>
			<p>年龄: <span v-text="form.age"></span></p>
			<p>专家类别: <span v-text="form.type"></span></p>
			<p>是否全职: <span v-text="(form.isFulltime == '0' ? '全职' : '兼职')"></span></p>
			<p>联系电话: <span v-text="form.phone"></span></p>
			<p>个人情况介绍: <span v-text="form.memo"></span></p>
			<p>审核状态: <span v-text="(form.examineStatus == '0' ? '审核中' : form.examineStatus == '1' ? '审核通过' : '审核不通过')"></span></p>
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
		  <user-list-choice ref="UserListChoice" v-on:confirmChoice="confirmChoice"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('userChoice')">取消</Button>
		  </div>
		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import UserListSingle from '@/view/user/UserListSingle.vue'
	import userDetail from '@/view/user-detail/UserDetail.vue'
	import UserListChoice from '@/view/user/UserListChoice.vue'
	import { getUserById } from '@/api/module'
	import {
	  gender,
		examine,
		jobType
	} from '@/api/select'

	export default {
		name: 'UserExpert',
		components: {
		  userDetail,
		  UserListSingle,
			UserListChoice
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
					userChoice: false
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/user-expert/admin/save',
					batchAddUrl: '/user-expert/admin/batch-save',
					editUrl: '/user-expert/admin/update',
					batchEditUrl: '/user-expert/admin/batch-update',
					searchUrl: '/user-expert/admin/pager-cond',
					allUrl: '/user-expert/admin/all',
					removeUrl: '/user-expert/admin/remove/',
					batchRemoveUrl: '/user-expert/admin/batch-remove',
					detailUrl: '/user-expert/admin/one/',
					activeUrl: '/user-expert/admin/active',
					batchActiveUrl: '/user-expert/admin/batch-active'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					userId: null,
					name: null,
					gender: null,
					age: null,
					type: null,
					isFulltime: null,
					phone: null,
					memo: null,
					examineStatus: null,
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
					name: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					type: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					phone: [{
						type: 'string',
						min: 1,
						max: 11,
						message: '必须1-11个字符',
						trigger: 'blur'
					}],
					memo: [{
						type: 'string',
						min: 1,
						max: 300,
						message: '必须1-300个字符',
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
					name: null,
					gender: null,
					genderMin: null,
					genderMax: null,
					age: null,
					ageMin: null,
					ageMax: null,
					type: null,
					isFulltime: null,
					isFulltimeMin: null,
					isFulltimeMax: null,
					phone: null,
					memo: null,
					examineStatus: null,
					examineStatusMin: null,
					examineStatusMax: null,
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
							title: '专家信息编号',
							key: 'id',
							minWidth: 130,
							sortable: true
						},
						{
							title: '用户编号',
							key: 'userId',
							minWidth: 130,
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
							title: '专家姓名',
							key: 'name',
							minWidth: 120,
							sortable: true
						},
						{
							title: '性别',
							key: 'gender',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = null
								if(params.row.gender === 0) {
									text = '未知'
								} else if(params.row.gender === 1) {
									text = '男'
								} else if(params.row.gender === 2) {
									text = '女'
								}
								return h('span', text)
							}
						},
						{
							title: '年龄',
							key: 'age',
							minWidth: 120,
							sortable: true
						},
						{
							title: '专家类别',
							key: 'type',
							minWidth: 120,
							sortable: true
						},
						{
							title: '是否全职',
							key: 'isFulltime',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = null
								if(params.row.isFulltime === 0) {
									text = '全职'
								} else if(params.row.isFulltime === 1) {
									text = '兼职'
								}
								return h('span', text)
							}
						},
						{
							title: '联系电话',
							key: 'phone',
							minWidth: 120,
							sortable: true
						},
						{
							title: '个人情况介绍',
							key: 'memo',
							minWidth: 140,
							sortable: true
						},
						{
							title: '审核状态',
							key: 'examineStatus',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								let text = null
								if(params.row.examineStatus === 0) {
									text = '审核中'
								} else if(params.row.examineStatus === 1) {
									text = '审核通过'
								} else if(params.row.examineStatus === 2) {
									text = '审核不通过'
								}
								return h('span', text)
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
				},
				genderList: gender,
				jobTypeList: jobType,
				examineList: examine,
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
			initSelect() {
			  this.form.gender = this.genderList[0].value
			},
			showModal(modal) {
				if (modal === 'add') {
				  this.initSelect()
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
			  this.form.userId = userId
			  this.cancelModal('userChoice')
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
			},
		}
	}
</script>

<style>
</style>
