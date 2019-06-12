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
        <FormItem label="企业水利勘查设计业绩编号"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementIdMin">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementIdMin" placeholder="请输入开始企业水利勘查设计业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementIdMax">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementIdMax" placeholder="请输入结束企业水利勘查设计业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementCompIdMin">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementCompIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementCompIdMax">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementCompIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="标段(包)名称" prop="compWaterDeviseAchievementProjectName">
	<Input v-model="searchForm.compWaterDeviseAchievementProjectName" placeholder="请输入标段(包)名称"/>
</FormItem>
<FormItem label="项目类型" prop="compWaterDeviseAchievementTenderingComp">
	<Input v-model="searchForm.compWaterDeviseAchievementTenderingComp" placeholder="请输入项目类型"/>
</FormItem>
<FormItem label="招标(单位)人" prop="compWaterDeviseAchievementBuildComp">
	<Input v-model="searchForm.compWaterDeviseAchievementBuildComp" placeholder="请输入招标(单位)人"/>
</FormItem>
<FormItem label="中标时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementMarkDateMin">
	<DatePicker @on-change="searchForm.compWaterDeviseAchievementMarkDateMin=$event" :value="searchForm.compWaterDeviseAchievementMarkDateMin" placeholder="请输入开始中标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementMarkDateMax">
	<DatePicker @on-change="searchForm.compWaterDeviseAchievementMarkDateMax=$event" :value="searchForm.compWaterDeviseAchievementMarkDateMax" placeholder="请输入结束中标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="合同金额" prop="compWaterDeviseAchievementContractAmount">
	<Input v-model="searchForm.compWaterDeviseAchievementContractAmount" placeholder="请输入合同金额"/>
</FormItem>
<FormItem label="项目负责人" prop="compWaterDeviseAchievementName">
	<Input v-model="searchForm.compWaterDeviseAchievementName" placeholder="请输入项目负责人"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementVersionMin">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementVersionMax">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementCreateTimeMin">
	<DatePicker @on-change="searchForm.compWaterDeviseAchievementCreateTimeMin=$event" :value="searchForm.compWaterDeviseAchievementCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementCreateTimeMax">
	<DatePicker @on-change="searchForm.compWaterDeviseAchievementCreateTimeMax=$event" :value="searchForm.compWaterDeviseAchievementCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementUpdateTimeMin">
	<DatePicker @on-change="searchForm.compWaterDeviseAchievementUpdateTimeMin=$event" :value="searchForm.compWaterDeviseAchievementUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementUpdateTimeMax">
	<DatePicker @on-change="searchForm.compWaterDeviseAchievementUpdateTimeMax=$event" :value="searchForm.compWaterDeviseAchievementUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementIsActiveMin">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compWaterDeviseAchievementIsActiveMax">
	<InputNumber v-model="searchForm.compWaterDeviseAchievementIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>企业水利勘查设计业绩编号: <span v-text="form.compWaterDeviseAchievementId"></span></p>
<p>企业编号: <span v-text="form.compWaterDeviseAchievementCompId"></span></p>
<p>标段(包)名称: <span v-text="form.compWaterDeviseAchievementProjectName"></span></p>
<p>项目类型: <span v-text="form.compWaterDeviseAchievementTenderingComp"></span></p>
<p>招标(单位)人: <span v-text="form.compWaterDeviseAchievementBuildComp"></span></p>
<p>中标时间: <span v-text="form.compWaterDeviseAchievementMarkDate"></span></p>
<p>合同金额: <span v-text="form.compWaterDeviseAchievementContractAmount"></span></p>
<p>项目负责人: <span v-text="form.compWaterDeviseAchievementName"></span></p>
<p>版本号: <span v-text="form.compWaterDeviseAchievementVersion"></span></p>
<p>创建时间: <span v-text="form.compWaterDeviseAchievementCreateTime"></span></p>
<p>更新时间: <span v-text="form.compWaterDeviseAchievementUpdateTime"></span></p>
<p>是否激活: <span v-text="form.compWaterDeviseAchievementIsActive"></span></p>
<p>企业类型: <span v-text="form.companyCompType"></span></p>
<p>行业分类: <span v-text="form.companyIndustryType"></span></p>
<p>企业名称: <span v-text="form.companyCompName"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'CompWaterDeviseAchievementCompany',
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
          searchUrl: '/CompWaterDeviseAchievementCompany/admin/pager-cond',
          allUrl: '/CompWaterDeviseAchievementCompany/admin/all',
          detailUrl: '/CompWaterDeviseAchievementCompany/admin/one/',
          multiUrl: '/CompWaterDeviseAchievementCompany/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          compWaterDeviseAchievementId: null,
compWaterDeviseAchievementCompId: null,
compWaterDeviseAchievementProjectName: null,
compWaterDeviseAchievementTenderingComp: null,
compWaterDeviseAchievementBuildComp: null,
compWaterDeviseAchievementMarkDate: null,
compWaterDeviseAchievementContractAmount: null,
compWaterDeviseAchievementName: null,
compWaterDeviseAchievementVersion: null,
compWaterDeviseAchievementCreateTime: null,
compWaterDeviseAchievementUpdateTime: null,
compWaterDeviseAchievementIsActive: null,
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          compWaterDeviseAchievementId: null,
compWaterDeviseAchievementIdMin: null, 
compWaterDeviseAchievementIdMax: null, 
compWaterDeviseAchievementCompId: null,
compWaterDeviseAchievementCompIdMin: null, 
compWaterDeviseAchievementCompIdMax: null, 
compWaterDeviseAchievementProjectName: null,
compWaterDeviseAchievementTenderingComp: null,
compWaterDeviseAchievementBuildComp: null,
compWaterDeviseAchievementMarkDate: null,
compWaterDeviseAchievementMarkDateMin: null, 
compWaterDeviseAchievementMarkDateMax: null, 
compWaterDeviseAchievementContractAmount: null,
compWaterDeviseAchievementName: null,
compWaterDeviseAchievementVersion: null,
compWaterDeviseAchievementVersionMin: null, 
compWaterDeviseAchievementVersionMax: null, 
compWaterDeviseAchievementCreateTime: null,
compWaterDeviseAchievementCreateTimeMin: null, 
compWaterDeviseAchievementCreateTimeMax: null, 
compWaterDeviseAchievementUpdateTime: null,
compWaterDeviseAchievementUpdateTimeMin: null, 
compWaterDeviseAchievementUpdateTimeMax: null, 
compWaterDeviseAchievementIsActive: null,
compWaterDeviseAchievementIsActiveMin: null, 
compWaterDeviseAchievementIsActiveMax: null, 
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
title: '企业水利勘查设计业绩编号',
key: 'compWaterDeviseAchievementId',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compWaterDeviseAchievementCompId',
minWidth: 120,
sortable: true
},
{
title: '标段(包)名称',
key: 'compWaterDeviseAchievementProjectName',
minWidth: 120,
sortable: true
},
{
title: '项目类型',
key: 'compWaterDeviseAchievementTenderingComp',
minWidth: 120,
sortable: true
},
{
title: '招标(单位)人',
key: 'compWaterDeviseAchievementBuildComp',
minWidth: 120,
sortable: true
},
{
title: '中标时间',
key: 'compWaterDeviseAchievementMarkDate',
minWidth: 120,
sortable: true
},
{
title: '合同金额',
key: 'compWaterDeviseAchievementContractAmount',
minWidth: 120,
sortable: true
},
{
title: '项目负责人',
key: 'compWaterDeviseAchievementName',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'compWaterDeviseAchievementVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'compWaterDeviseAchievementCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'compWaterDeviseAchievementUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'compWaterDeviseAchievementIsActive',
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
