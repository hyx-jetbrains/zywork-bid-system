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
        <FormItem label="企业水利业绩编号"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementIdMin">
	<InputNumber v-model="searchForm.compWaterAchievementIdMin" placeholder="请输入开始企业水利业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementIdMax">
	<InputNumber v-model="searchForm.compWaterAchievementIdMax" placeholder="请输入结束企业水利业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementCompIdMin">
	<InputNumber v-model="searchForm.compWaterAchievementCompIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementCompIdMax">
	<InputNumber v-model="searchForm.compWaterAchievementCompIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="工程名称" prop="compWaterAchievementProjectName">
	<Input v-model="searchForm.compWaterAchievementProjectName" placeholder="请输入工程名称"/>
</FormItem>
<FormItem label="项目负责人" prop="compWaterAchievementName">
	<Input v-model="searchForm.compWaterAchievementName" placeholder="请输入项目负责人"/>
</FormItem>
<FormItem label="合同金额" prop="compWaterAchievementContractAmount">
	<Input v-model="searchForm.compWaterAchievementContractAmount" placeholder="请输入合同金额"/>
</FormItem>
<FormItem label="开工时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementStartDateMin">
	<DatePicker @on-change="searchForm.compWaterAchievementStartDateMin=$event" :value="searchForm.compWaterAchievementStartDateMin" placeholder="请输入开始开工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementStartDateMax">
	<DatePicker @on-change="searchForm.compWaterAchievementStartDateMax=$event" :value="searchForm.compWaterAchievementStartDateMax" placeholder="请输入结束开工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="竣工时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementEndDateMin">
	<DatePicker @on-change="searchForm.compWaterAchievementEndDateMin=$event" :value="searchForm.compWaterAchievementEndDateMin" placeholder="请输入开始竣工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementEndDateMax">
	<DatePicker @on-change="searchForm.compWaterAchievementEndDateMax=$event" :value="searchForm.compWaterAchievementEndDateMax" placeholder="请输入结束竣工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementVersionMin">
	<InputNumber v-model="searchForm.compWaterAchievementVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementVersionMax">
	<InputNumber v-model="searchForm.compWaterAchievementVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementCreateTimeMin">
	<DatePicker @on-change="searchForm.compWaterAchievementCreateTimeMin=$event" :value="searchForm.compWaterAchievementCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementCreateTimeMax">
	<DatePicker @on-change="searchForm.compWaterAchievementCreateTimeMax=$event" :value="searchForm.compWaterAchievementCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementUpdateTimeMin">
	<DatePicker @on-change="searchForm.compWaterAchievementUpdateTimeMin=$event" :value="searchForm.compWaterAchievementUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementUpdateTimeMax">
	<DatePicker @on-change="searchForm.compWaterAchievementUpdateTimeMax=$event" :value="searchForm.compWaterAchievementUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="compWaterAchievementIsActiveMin">
	<InputNumber v-model="searchForm.compWaterAchievementIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterAchievementIsActiveMax">
	<InputNumber v-model="searchForm.compWaterAchievementIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>企业水利业绩编号: <span v-text="form.compWaterAchievementId"></span></p>
<p>企业编号: <span v-text="form.compWaterAchievementCompId"></span></p>
<p>工程名称: <span v-text="form.compWaterAchievementProjectName"></span></p>
<p>项目负责人: <span v-text="form.compWaterAchievementName"></span></p>
<p>合同金额: <span v-text="form.compWaterAchievementContractAmount"></span></p>
<p>开工时间: <span v-text="form.compWaterAchievementStartDate"></span></p>
<p>竣工时间: <span v-text="form.compWaterAchievementEndDate"></span></p>
<p>版本号: <span v-text="form.compWaterAchievementVersion"></span></p>
<p>创建时间: <span v-text="form.compWaterAchievementCreateTime"></span></p>
<p>更新时间: <span v-text="form.compWaterAchievementUpdateTime"></span></p>
<p>是否激活: <span v-text="form.compWaterAchievementIsActive"></span></p>
<p>企业类型: <span v-text="form.companyCompType"></span></p>
<p>行业分类: <span v-text="form.companyIndustryType"></span></p>
<p>企业名称: <span v-text="form.companyCompName"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'CompWaterAchievementCompany',
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
          searchUrl: '/CompWaterAchievementCompany/admin/pager-cond',
          allUrl: '/CompWaterAchievementCompany/admin/all',
          detailUrl: '/CompWaterAchievementCompany/admin/one/',
          multiUrl: '/CompWaterAchievementCompany/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          compWaterAchievementId: null,
compWaterAchievementCompId: null,
compWaterAchievementProjectName: null,
compWaterAchievementName: null,
compWaterAchievementContractAmount: null,
compWaterAchievementStartDate: null,
compWaterAchievementEndDate: null,
compWaterAchievementVersion: null,
compWaterAchievementCreateTime: null,
compWaterAchievementUpdateTime: null,
compWaterAchievementIsActive: null,
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          compWaterAchievementId: null,
compWaterAchievementIdMin: null, 
compWaterAchievementIdMax: null, 
compWaterAchievementCompId: null,
compWaterAchievementCompIdMin: null, 
compWaterAchievementCompIdMax: null, 
compWaterAchievementProjectName: null,
compWaterAchievementName: null,
compWaterAchievementContractAmount: null,
compWaterAchievementStartDate: null,
compWaterAchievementStartDateMin: null, 
compWaterAchievementStartDateMax: null, 
compWaterAchievementEndDate: null,
compWaterAchievementEndDateMin: null, 
compWaterAchievementEndDateMax: null, 
compWaterAchievementVersion: null,
compWaterAchievementVersionMin: null, 
compWaterAchievementVersionMax: null, 
compWaterAchievementCreateTime: null,
compWaterAchievementCreateTimeMin: null, 
compWaterAchievementCreateTimeMax: null, 
compWaterAchievementUpdateTime: null,
compWaterAchievementUpdateTimeMin: null, 
compWaterAchievementUpdateTimeMax: null, 
compWaterAchievementIsActive: null,
compWaterAchievementIsActiveMin: null, 
compWaterAchievementIsActiveMax: null, 
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
title: '企业水利业绩编号',
key: 'compWaterAchievementId',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compWaterAchievementCompId',
minWidth: 120,
sortable: true
},
{
title: '工程名称',
key: 'compWaterAchievementProjectName',
minWidth: 120,
sortable: true
},
{
title: '项目负责人',
key: 'compWaterAchievementName',
minWidth: 120,
sortable: true
},
{
title: '合同金额',
key: 'compWaterAchievementContractAmount',
minWidth: 120,
sortable: true
},
{
title: '开工时间',
key: 'compWaterAchievementStartDate',
minWidth: 120,
sortable: true
},
{
title: '竣工时间',
key: 'compWaterAchievementEndDate',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'compWaterAchievementVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'compWaterAchievementCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'compWaterAchievementUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'compWaterAchievementIsActive',
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
