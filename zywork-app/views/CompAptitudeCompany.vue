<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="showModal('search')" type="primary">高级搜索</Button>&nbsp;
          <Tooltip content="刷新" placement="right">
            <Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
          </Tooltip>
          <Table ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-selection-change="changeSelection" @on-sort-change="changeSort"></Table>
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
        <FormItem label="企业资质编号"><Row>
	<i-col span="11">
	<FormItem prop="compAptitudeIdMin">
	<InputNumber v-model="searchForm.compAptitudeIdMin" placeholder="请输入开始企业资质编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compAptitudeIdMax">
	<InputNumber v-model="searchForm.compAptitudeIdMax" placeholder="请输入结束企业资质编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compAptitudeCompIdMin">
	<InputNumber v-model="searchForm.compAptitudeCompIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compAptitudeCompIdMax">
	<InputNumber v-model="searchForm.compAptitudeCompIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="证件号码" prop="compAptitudeCertificateNum">
	<Input v-model="searchForm.compAptitudeCertificateNum" placeholder="请输入证件号码"/>
</FormItem>
<FormItem label="资质详情" prop="compAptitudeCertificateDetail">
	<Input v-model="searchForm.compAptitudeCertificateDetail" placeholder="请输入资质详情"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="compAptitudeVersionMin">
	<InputNumber v-model="searchForm.compAptitudeVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compAptitudeVersionMax">
	<InputNumber v-model="searchForm.compAptitudeVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="compAptitudeCreateTimeMin">
	<DatePicker @on-change="searchForm.compAptitudeCreateTimeMin=$event" :value="searchForm.compAptitudeCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compAptitudeCreateTimeMax">
	<DatePicker @on-change="searchForm.compAptitudeCreateTimeMax=$event" :value="searchForm.compAptitudeCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="compAptitudeUpdateTimeMin">
	<DatePicker @on-change="searchForm.compAptitudeUpdateTimeMin=$event" :value="searchForm.compAptitudeUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compAptitudeUpdateTimeMax">
	<DatePicker @on-change="searchForm.compAptitudeUpdateTimeMax=$event" :value="searchForm.compAptitudeUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="compAptitudeIsActiveMin">
	<InputNumber v-model="searchForm.compAptitudeIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compAptitudeIsActiveMax">
	<InputNumber v-model="searchForm.compAptitudeIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业类型" prop="companyCompType">
	<Input v-model="searchForm.companyCompType" placeholder="请输入企业类型"/>
</FormItem>
<FormItem label="行业分类" prop="companyIndustryType">
	<Input v-model="searchForm.companyIndustryType" placeholder="请输入行业分类"/>
</FormItem>
<FormItem label="企业名称" prop="companyCompName">
	<Input v-model="searchForm.companyCompName" placeholder="请输入企业名称"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>企业资质编号: <span v-text="form.compAptitudeId"></span></p>
<p>企业编号: <span v-text="form.compAptitudeCompId"></span></p>
<p>证件号码: <span v-text="form.compAptitudeCertificateNum"></span></p>
<p>资质详情: <span v-text="form.compAptitudeCertificateDetail"></span></p>
<p>版本号: <span v-text="form.compAptitudeVersion"></span></p>
<p>创建时间: <span v-text="form.compAptitudeCreateTime"></span></p>
<p>更新时间: <span v-text="form.compAptitudeUpdateTime"></span></p>
<p>是否激活: <span v-text="form.compAptitudeIsActive"></span></p>
<p>企业类型: <span v-text="form.companyCompType"></span></p>
<p>行业分类: <span v-text="form.companyIndustryType"></span></p>
<p>企业名称: <span v-text="form.companyCompName"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'CompAptitudeCompany',
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
          searchUrl: '/CompAptitudeCompany/admin/pager-cond',
          allUrl: '/CompAptitudeCompany/admin/all',
          detailUrl: '/CompAptitudeCompany/admin/one/',
          multiUrl: '/CompAptitudeCompany/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          compAptitudeId: null,
compAptitudeCompId: null,
compAptitudeCertificateNum: null,
compAptitudeCertificateDetail: null,
compAptitudeVersion: null,
compAptitudeCreateTime: null,
compAptitudeUpdateTime: null,
compAptitudeIsActive: null,
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          compAptitudeId: null,
compAptitudeIdMin: null, 
compAptitudeIdMax: null, 
compAptitudeCompId: null,
compAptitudeCompIdMin: null, 
compAptitudeCompIdMax: null, 
compAptitudeCertificateNum: null,
compAptitudeCertificateDetail: null,
compAptitudeVersion: null,
compAptitudeVersionMin: null, 
compAptitudeVersionMax: null, 
compAptitudeCreateTime: null,
compAptitudeCreateTimeMin: null, 
compAptitudeCreateTimeMax: null, 
compAptitudeUpdateTime: null,
compAptitudeUpdateTimeMin: null, 
compAptitudeUpdateTimeMax: null, 
compAptitudeIsActive: null,
compAptitudeIsActiveMin: null, 
compAptitudeIsActiveMax: null, 
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        table: {
          loading: false,
          tableColumns: [
            {
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
title: '企业资质编号',
key: 'compAptitudeId',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compAptitudeCompId',
minWidth: 120,
sortable: true
},
{
title: '证件号码',
key: 'compAptitudeCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '资质详情',
key: 'compAptitudeCertificateDetail',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'compAptitudeVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'compAptitudeCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'compAptitudeUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'compAptitudeIsActive',
minWidth: 120,
sortable: true
},
{
title: '企业类型',
key: 'companyCompType',
minWidth: 120,
sortable: true
},
{
title: '行业分类',
key: 'companyIndustryType',
minWidth: 120,
sortable: true
},
{
title: '企业名称',
key: 'companyCompName',
minWidth: 120,
sortable: true
},

            {
              title: '操作',
              key: 'action',
              width: 120,
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
        utils.search(this)
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
