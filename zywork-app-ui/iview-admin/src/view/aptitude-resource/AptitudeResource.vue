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
				<FormItem label="资质编号" prop="aptitudeId">
					<span v-text="form.aptitudeId" />
					&nbsp;
					<Button @click="showModal('aptitudeTransferDetailSearch')" type="text">选择资质</Button>&nbsp;
				</FormItem>
				<FormItem label="资源编号" prop="resourceId">
					<Upload type="drag"
						:action="urls.uploadResourceUrl"
						:on-success="handleSuccess"
						:on-format-error="handleFormatError"
					  :on-exceeded-size="handleMaxSize"
						:format="['jpg','jpeg','png','bmp']"
						:max-size="10240"
						:headers="uploadHeader">
							<div style="padding: 20px 0">
								<Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
								<p>单击或拖动文件到此处上传</p>
							</div>
					</Upload>
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		<Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<FormItem label="资质编号" prop="aptitudeId">
					<InputNumber v-model="form.aptitudeId" placeholder="请输入资质编号" style="width: 100%;" />
				</FormItem>
				<FormItem label="资源编号" prop="resourceId">
					<InputNumber v-model="form.resourceId" placeholder="请输入资源编号" style="width: 100%;" />
				</FormItem>

			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="资质资源编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始资质资源编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束资质资源编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="资质编号">
					<Row>
						<i-col span="11">
							<FormItem prop="aptitudeIdMin">
								<InputNumber v-model="searchForm.aptitudeIdMin" placeholder="请输入开始资质编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="aptitudeIdMax">
								<InputNumber v-model="searchForm.aptitudeIdMax" placeholder="请输入结束资质编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="资源编号">
					<Row>
						<i-col span="11">
							<FormItem prop="resourceIdMin">
								<InputNumber v-model="searchForm.resourceIdMin" placeholder="请输入开始资源编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="resourceIdMax">
								<InputNumber v-model="searchForm.resourceIdMax" placeholder="请输入结束资源编号" style="width: 100%;" />
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
			<p>资质资源编号: <span v-text="form.id"></span></p>
			<p>资质编号: <span v-text="form.aptitudeId"></span></p>
			<p>资源编号: <span v-text="form.resourceId"></span></p>
			<p>版本号: <span v-text="form.version"></span></p>
			<p>创建时间: <span v-text="form.createTime"></span></p>
			<p>更新时间: <span v-text="form.updateTime"></span></p>
			<p>是否激活: <span v-text="form.isActive"></span></p>

		</Modal>
		
		<Modal :transfer="false" v-model="modal.aptitudeTransferDetail" title="资质详情">
			<aptitudeTransfer-detail :form="aptitudeTransferDetailForm" />
		</Modal>
		
		<Modal :transfer="false" fullscreen v-model="modal.aptitudeTransferDetailSearch" title="搜索主表信息">
			<aptitudeTransfer-list-single ref="BuilderListSingle" v-on:confirmSelectionAptitude="confirmSelectionAptitude" />
			<div slot="footer">
				<Button type="text" size="large" @click="cancelModal('aptitudeTransferDetailSearch')">取消</Button>
				<Button type="primary" size="large" @click="confirmaptitudeTransfer">确认选择</Button>
			</div>
		</Modal>
		
		<Modal :transfer="false" v-model="modal.resourceDetail" title="资源预览">
			<img :src="imgUrl" style="width: 490px" />
			<div slot="footer">
				<Button type="default" size="large" @click="cancelModal('resourceDetail')">取消</Button>
			</div>
		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import * as ResponseStatus from '@/api/response-status'
	import AptitudeTransferListSingle from '@/view/aptitude-transfer/AptitudeTransferListSingle'
	import AptitudeTransferDetail from '@/view/aptitude-transfer/AptitudeTransferDetail.vue'
	import { getAptitudeTransferById } from '@/api/module'
	import config from '@/config'
	const baseUrl = process.env.NODE_ENV === 'development'
		? config.baseUrl.dev
		: config.baseUrl.pro
	const cdnUrl = config.baseUrl.cdnUrl
	import { getLocalStorageToken } from '@/libs/util'

	export default {
		name: 'AptitudeResource',
		components: {
			AptitudeTransferListSingle,
			AptitudeTransferDetail
		},
		data() {
			return {
				imgUrl: '',
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false,
					aptitudeTransferDetailSearch: false,
					aptitudeTransferDetail: false,
					resourceDetail: false
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/aptitude-resource/admin/save',
					batchAddUrl: '/aptitude-resource/admin/batch-save',
					editUrl: '/aptitude-resource/admin/update',
					batchEditUrl: '/aptitude-resource/admin/batch-update',
					searchUrl: '/aptitude-resource/admin/pager-cond',
					allUrl: '/aptitude-resource/admin/all',
					removeUrl: '/aptitude-resource/admin/remove/',
					batchRemoveUrl: '/aptitude-resource/admin/batch-remove',
					detailUrl: '/aptitude-resource/admin/one/',
					activeUrl: '/aptitude-resource/admin/active',
					batchActiveUrl: '/aptitude-resource/admin/batch-active',
					resourceOneUrl: '/resource/admin/one/',
					uploadResourceUrl: baseUrl + '/aptitude-transfer/admin/upload-res/'
				},
				page: {
					total: 0
				},
				form: {
					id: null,
					aptitudeId: null,
					resourceId: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,

				},
				aptitudeTransferDetailForm: {
					id: null,
					userId: null,
					type: null,
					title: null,
					compAptitudeLevel: null,
					compAptitudeType: null,
					phone: null,
					memo: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
				},
				validateRules: {
					aptitudeId: [{
						type: 'integer',
						required: true,
						message: '此项为必须项',
						trigger: 'blur, change'
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
					aptitudeId: null,
					aptitudeIdMin: null,
					aptitudeIdMax: null,
					resourceId: null,
					resourceIdMin: null,
					resourceIdMax: null,
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
							title: '资质资源编号',
							key: 'id',
							minWidth: 120,
							sortable: true
						},
						{
							title: '资质编号',
							key: 'aptitudeId',
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
							        params.row.aptitudeId,
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
							title: '资源编号',
							key: 'resourceId',
							minWidth: 120,
							sortable: true,
							render: (h, params) => {
								return h(
									'Button', {
										props: {
											size: 'small',
											type: 'text'
										},
										on: {
											click: () => {
												this.showResource(params.row)
											}
										}
									},
									'点击查看'
								)
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
							minWidth: 120,
							sortable: true
						},
						{
							title: '更新时间',
							key: 'updateTime',
							minWidth: 120,
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
										/* h('DropdownItem', {
											props: {
												name: 'showEdit'
											}
										}, '编辑'), */
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
				aptitudeId: this.$route.params.aptitudeId,
				uploadHeader: {
				  Authorization: 'Bearer ' + getLocalStorageToken()
				},
			}
		},
		computed: {},
		mounted() {
			if (this.aptitudeId !== undefined) {
				this.searchForm.aptitudeIdMin = this.aptitudeId
				this.searchForm.aptitudeIdMax = this.aptitudeId
			}
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
					this.showAptitudeDetailModal(row.aptitudeId)
				} else if (itemName === 'showSearch') {
					utils.showModal(this, 'aptitudeTransferDetailSearch')
				}
			},
			showAptitudeDetailModal(id) {
			  getAptitudeTransferById(id)
			    .then(res => {
			      const data = res.data
			      if (data.code === 1001) {
			        this.aptitudeTransferDetailForm = data.data
			        this.modal.aptitudeTransferDetail = true
			      } else {
			        this.$Message.error(data.message)
			      }
			    })
			    .catch(err => {
			      this.$Message.error(err)
			    })
			},
			setDetailModal(val) {
			  this.modal.AptitudeTransferDetail = val
			},
			confirmSelectionAptitude(id) {
			  this.modal.aptitudeTransferDetailSearch = false
			  this.searchForm.aptitudeIdMin = id
			  this.searchForm.aptitudeIdMax = id
				
				this.form.aptitudeId = id
			  utils.search(this)
			},
			confirmaptitudeTransfer() {
			  this.$refs.AptitudeTransferListSingle.confirmSelection()
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
			showResource(row) {
					utils.getOneById(this.urls.resourceOneUrl, row.resourceId)
						.then(res => {
							const data = res.data
							if (data.code === ResponseStatus.OK) {
								const mimeType = data.data.mimeType
								const url = cdnUrl + '/' + data.data.url
								if (mimeType === 'Image') {
									this.imgUrl = url
									this.showModal('resourceDetail')
								} else if (mimeType === 'Document') {
									this.imgUrl = url
									window.open(url)
								} else {
									this.$Message.error(mimeType)
								}
							} else {
								this.$Message.error(data.message)
							}
						})
						.catch(err => {
							this.$Message.error(err)
						})
				},
				handleSuccess(res, file) {
				  if (res.code === ResponseStatus.OK) {
				    this.$Notice.success({
				      title: '上传成功',
				      desc: file.name + ' 上传成功'
				    })
				    this.form.resourceId = res.data.id
				  } else {
				    this.$Notice.error({
				      title: '上传失败',
				      desc: res.message
				    })
				  }
				},
				handleFormatError(file) {
				  this.$Notice.warning({
				    title: '图片格式不正确',
				    desc: file.name + ' 图片格式不正确，请选择JPG图片或PNG图片。'
				  })
				},
				handleMaxSize(file) {
				  this.$Notice.warning({
				    title: '超出文件大小限制',
				    desc: file.name + ' 太大，不得超10M.'
				  })
				},
			}
	}
</script>

<style>
</style>
