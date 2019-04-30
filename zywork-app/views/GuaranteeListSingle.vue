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
          <Table highlight-row ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-current-change="changeCurrent" @on-sort-change="changeSort"></Table>
          <div style="margin: 20px;overflow: hidden">
            <div style="float: right;">
              <Page :total="page.total" :current="searchForm.pageNo" @on-change="changePageNo" @on-page-size-change="changePageSize" showSizer showTotal></Page>
            </div>
          </div>
        </Card>
      </i-col>
    </Row>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="保函编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始保函编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束保函编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目编号"><Row>
	<i-col span="11">
	<FormItem prop="projectIdMin">
	<InputNumber v-model="searchForm.projectIdMin" placeholder="请输入开始项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectIdMax">
	<InputNumber v-model="searchForm.projectIdMax" placeholder="请输入结束项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目名称" prop="projectName">
	<Input v-model="searchForm.projectName" placeholder="请输入项目名称"/>
</FormItem>
<FormItem label="开标时间"><Row>
	<i-col span="11">
	<FormItem prop="openMarkTimeMin">
	<DatePicker @on-change="searchForm.openMarkTimeMin=$event" :value="searchForm.openMarkTimeMin" placeholder="请输入开始开标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="openMarkTimeMax">
	<DatePicker @on-change="searchForm.openMarkTimeMax=$event" :value="searchForm.openMarkTimeMax" placeholder="请输入结束开标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="招标单位名称" prop="markUnitName">
	<Input v-model="searchForm.markUnitName" placeholder="请输入招标单位名称"/>
</FormItem>
<FormItem label="工期(天)"><Row>
	<i-col span="11">
	<FormItem prop="constructionPeriodMin">
	<InputNumber v-model="searchForm.constructionPeriodMin" placeholder="请输入开始工期(天)" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="constructionPeriodMax">
	<InputNumber v-model="searchForm.constructionPeriodMax" placeholder="请输入结束工期(天)" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="担保金额(万元)"><Row>
	<i-col span="11">
	<FormItem prop="assurePriceMin">
	<InputNumber v-model="searchForm.assurePriceMin" placeholder="请输入开始担保金额(万元)" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="assurePriceMax">
	<InputNumber v-model="searchForm.assurePriceMax" placeholder="请输入结束担保金额(万元)" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="担保公司" prop="guaranteeComp">
	<Input v-model="searchForm.guaranteeComp" placeholder="请输入担保公司"/>
</FormItem>
<FormItem label="申请人" prop="applicant">
	<Input v-model="searchForm.applicant" placeholder="请输入申请人"/>
</FormItem>
<FormItem label="联系人" prop="name">
	<Input v-model="searchForm.name" placeholder="请输入联系人"/>
</FormItem>
<FormItem label="手机号" prop="phone">
	<Input v-model="searchForm.phone" placeholder="请输入手机号"/>
</FormItem>
<FormItem label="地址" prop="address">
	<Input v-model="searchForm.address" placeholder="请输入地址"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="versionMin">
	<InputNumber v-model="searchForm.versionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="versionMax">
	<InputNumber v-model="searchForm.versionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="createTimeMin">
	<DatePicker @on-change="searchForm.createTimeMin=$event" :value="searchForm.createTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="createTimeMax">
	<DatePicker @on-change="searchForm.createTimeMax=$event" :value="searchForm.createTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="updateTimeMin">
	<DatePicker @on-change="searchForm.updateTimeMin=$event" :value="searchForm.updateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="updateTimeMax">
	<DatePicker @on-change="searchForm.updateTimeMax=$event" :value="searchForm.updateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="isActiveMin">
	<InputNumber v-model="searchForm.isActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isActiveMax">
	<InputNumber v-model="searchForm.isActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>保函编号: <span v-text="form.id"></span></p>
<p>项目编号: <span v-text="form.projectId"></span></p>
<p>项目名称: <span v-text="form.projectName"></span></p>
<p>开标时间: <span v-text="form.openMarkTime"></span></p>
<p>招标单位名称: <span v-text="form.markUnitName"></span></p>
<p>工期(天): <span v-text="form.constructionPeriod"></span></p>
<p>担保金额(万元): <span v-text="form.assurePrice"></span></p>
<p>担保公司: <span v-text="form.guaranteeComp"></span></p>
<p>申请人: <span v-text="form.applicant"></span></p>
<p>联系人: <span v-text="form.name"></span></p>
<p>手机号: <span v-text="form.phone"></span></p>
<p>地址: <span v-text="form.address"></span></p>
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
    name: 'GuaranteeListSingle',
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
          searchUrl: '/guarantee/admin/pager-cond',
          allUrl: '/guarantee/admin/all',
          detailUrl: '/guarantee/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
projectId: null,
projectName: null,
openMarkTime: null,
markUnitName: null,
constructionPeriod: null,
assurePrice: null,
guaranteeComp: null,
applicant: null,
name: null,
phone: null,
address: null,
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
projectId: null,
projectIdMin: null, 
projectIdMax: null, 
projectName: null,
openMarkTime: null,
openMarkTimeMin: null, 
openMarkTimeMax: null, 
markUnitName: null,
constructionPeriod: null,
constructionPeriodMin: null, 
constructionPeriodMax: null, 
assurePrice: null,
assurePriceMin: null, 
assurePriceMax: null, 
guaranteeComp: null,
applicant: null,
name: null,
phone: null,
address: null,
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
          tableColumns: [
            {
              width: 60,
              align: 'center',
              fixed: "left",
              render: (h, params) => {
                return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
              }
            },
            {
title: '保函编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '项目编号',
key: 'projectId',
minWidth: 120,
sortable: true
},
{
title: '项目名称',
key: 'projectName',
minWidth: 120,
sortable: true
},
{
title: '开标时间',
key: 'openMarkTime',
minWidth: 120,
sortable: true
},
{
title: '招标单位名称',
key: 'markUnitName',
minWidth: 120,
sortable: true
},
{
title: '工期(天)',
key: 'constructionPeriod',
minWidth: 120,
sortable: true
},
{
title: '担保金额(万元)',
key: 'assurePrice',
minWidth: 120,
sortable: true
},
{
title: '担保公司',
key: 'guaranteeComp',
minWidth: 120,
sortable: true
},
{
title: '申请人',
key: 'applicant',
minWidth: 120,
sortable: true
},
{
title: '联系人',
key: 'name',
minWidth: 120,
sortable: true
},
{
title: '手机号',
key: 'phone',
minWidth: 120,
sortable: true
},
{
title: '地址',
key: 'address',
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
      }
    }
  }
</script>

<style>
</style>
