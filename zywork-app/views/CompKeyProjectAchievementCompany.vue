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
        <FormItem label="企业重点工程业绩编号"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementIdMin">
	<InputNumber v-model="searchForm.compKeyProjectAchievementIdMin" placeholder="请输入开始企业重点工程业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementIdMax">
	<InputNumber v-model="searchForm.compKeyProjectAchievementIdMax" placeholder="请输入结束企业重点工程业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementCompIdMin">
	<InputNumber v-model="searchForm.compKeyProjectAchievementCompIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementCompIdMax">
	<InputNumber v-model="searchForm.compKeyProjectAchievementCompIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="工程名称" prop="compKeyProjectAchievementProjectName">
	<Input v-model="searchForm.compKeyProjectAchievementProjectName" placeholder="请输入工程名称"/>
</FormItem>
<FormItem label="建设单位" prop="compKeyProjectAchievementBuildComp">
	<Input v-model="searchForm.compKeyProjectAchievementBuildComp" placeholder="请输入建设单位"/>
</FormItem>
<FormItem label="中标金额" prop="compKeyProjectAchievementMarkMoney">
	<Input v-model="searchForm.compKeyProjectAchievementMarkMoney" placeholder="请输入中标金额"/>
</FormItem>
<FormItem label="开工时间"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementStartDateMin">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementStartDateMin=$event" :value="searchForm.compKeyProjectAchievementStartDateMin" placeholder="请输入开始开工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementStartDateMax">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementStartDateMax=$event" :value="searchForm.compKeyProjectAchievementStartDateMax" placeholder="请输入结束开工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="竣工时间"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementEndDateMin">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementEndDateMin=$event" :value="searchForm.compKeyProjectAchievementEndDateMin" placeholder="请输入开始竣工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementEndDateMax">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementEndDateMax=$event" :value="searchForm.compKeyProjectAchievementEndDateMax" placeholder="请输入结束竣工时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementVersionMin">
	<InputNumber v-model="searchForm.compKeyProjectAchievementVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementVersionMax">
	<InputNumber v-model="searchForm.compKeyProjectAchievementVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementCreateTimeMin">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementCreateTimeMin=$event" :value="searchForm.compKeyProjectAchievementCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementCreateTimeMax">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementCreateTimeMax=$event" :value="searchForm.compKeyProjectAchievementCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementUpdateTimeMin">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementUpdateTimeMin=$event" :value="searchForm.compKeyProjectAchievementUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementUpdateTimeMax">
	<DatePicker @on-change="searchForm.compKeyProjectAchievementUpdateTimeMax=$event" :value="searchForm.compKeyProjectAchievementUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementIsActiveMin">
	<InputNumber v-model="searchForm.compKeyProjectAchievementIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compKeyProjectAchievementIsActiveMax">
	<InputNumber v-model="searchForm.compKeyProjectAchievementIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>企业重点工程业绩编号: <span v-text="form.compKeyProjectAchievementId"></span></p>
<p>企业编号: <span v-text="form.compKeyProjectAchievementCompId"></span></p>
<p>工程名称: <span v-text="form.compKeyProjectAchievementProjectName"></span></p>
<p>建设单位: <span v-text="form.compKeyProjectAchievementBuildComp"></span></p>
<p>中标金额: <span v-text="form.compKeyProjectAchievementMarkMoney"></span></p>
<p>开工时间: <span v-text="form.compKeyProjectAchievementStartDate"></span></p>
<p>竣工时间: <span v-text="form.compKeyProjectAchievementEndDate"></span></p>
<p>版本号: <span v-text="form.compKeyProjectAchievementVersion"></span></p>
<p>创建时间: <span v-text="form.compKeyProjectAchievementCreateTime"></span></p>
<p>更新时间: <span v-text="form.compKeyProjectAchievementUpdateTime"></span></p>
<p>是否激活: <span v-text="form.compKeyProjectAchievementIsActive"></span></p>
<p>企业类型: <span v-text="form.companyCompType"></span></p>
<p>行业分类: <span v-text="form.companyIndustryType"></span></p>
<p>企业名称: <span v-text="form.companyCompName"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'CompKeyProjectAchievementCompany',
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
          searchUrl: '/CompKeyProjectAchievementCompany/admin/pager-cond',
          allUrl: '/CompKeyProjectAchievementCompany/admin/all',
          detailUrl: '/CompKeyProjectAchievementCompany/admin/one/',
          multiUrl: '/CompKeyProjectAchievementCompany/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          compKeyProjectAchievementId: null,
compKeyProjectAchievementCompId: null,
compKeyProjectAchievementProjectName: null,
compKeyProjectAchievementBuildComp: null,
compKeyProjectAchievementMarkMoney: null,
compKeyProjectAchievementStartDate: null,
compKeyProjectAchievementEndDate: null,
compKeyProjectAchievementVersion: null,
compKeyProjectAchievementCreateTime: null,
compKeyProjectAchievementUpdateTime: null,
compKeyProjectAchievementIsActive: null,
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          compKeyProjectAchievementId: null,
compKeyProjectAchievementIdMin: null, 
compKeyProjectAchievementIdMax: null, 
compKeyProjectAchievementCompId: null,
compKeyProjectAchievementCompIdMin: null, 
compKeyProjectAchievementCompIdMax: null, 
compKeyProjectAchievementProjectName: null,
compKeyProjectAchievementBuildComp: null,
compKeyProjectAchievementMarkMoney: null,
compKeyProjectAchievementStartDate: null,
compKeyProjectAchievementStartDateMin: null, 
compKeyProjectAchievementStartDateMax: null, 
compKeyProjectAchievementEndDate: null,
compKeyProjectAchievementEndDateMin: null, 
compKeyProjectAchievementEndDateMax: null, 
compKeyProjectAchievementVersion: null,
compKeyProjectAchievementVersionMin: null, 
compKeyProjectAchievementVersionMax: null, 
compKeyProjectAchievementCreateTime: null,
compKeyProjectAchievementCreateTimeMin: null, 
compKeyProjectAchievementCreateTimeMax: null, 
compKeyProjectAchievementUpdateTime: null,
compKeyProjectAchievementUpdateTimeMin: null, 
compKeyProjectAchievementUpdateTimeMax: null, 
compKeyProjectAchievementIsActive: null,
compKeyProjectAchievementIsActiveMin: null, 
compKeyProjectAchievementIsActiveMax: null, 
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
title: '企业重点工程业绩编号',
key: 'compKeyProjectAchievementId',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compKeyProjectAchievementCompId',
minWidth: 120,
sortable: true
},
{
title: '工程名称',
key: 'compKeyProjectAchievementProjectName',
minWidth: 120,
sortable: true
},
{
title: '建设单位',
key: 'compKeyProjectAchievementBuildComp',
minWidth: 120,
sortable: true
},
{
title: '中标金额',
key: 'compKeyProjectAchievementMarkMoney',
minWidth: 120,
sortable: true
},
{
title: '开工时间',
key: 'compKeyProjectAchievementStartDate',
minWidth: 120,
sortable: true
},
{
title: '竣工时间',
key: 'compKeyProjectAchievementEndDate',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'compKeyProjectAchievementVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'compKeyProjectAchievementCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'compKeyProjectAchievementUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'compKeyProjectAchievementIsActive',
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
