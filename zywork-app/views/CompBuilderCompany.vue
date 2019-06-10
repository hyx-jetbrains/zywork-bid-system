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
        <FormItem label="企业建造师编号"><Row>
	<i-col span="11">
	<FormItem prop="compBuilderIdMin">
	<InputNumber v-model="searchForm.compBuilderIdMin" placeholder="请输入开始企业建造师编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compBuilderIdMax">
	<InputNumber v-model="searchForm.compBuilderIdMax" placeholder="请输入结束企业建造师编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compBuilderCompIdMin">
	<InputNumber v-model="searchForm.compBuilderCompIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compBuilderCompIdMax">
	<InputNumber v-model="searchForm.compBuilderCompIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="姓名" prop="compBuilderName">
	<Input v-model="searchForm.compBuilderName" placeholder="请输入姓名"/>
</FormItem>
<FormItem label="性别" prop="compBuilderGender">
	<Input v-model="searchForm.compBuilderGender" placeholder="请输入性别"/>
</FormItem>
<FormItem label="注册证件号码" prop="compBuilderRegNum">
	<Input v-model="searchForm.compBuilderRegNum" placeholder="请输入注册证件号码"/>
</FormItem>
<FormItem label="专业等级" prop="compBuilderMajorLevel">
	<Input v-model="searchForm.compBuilderMajorLevel" placeholder="请输入专业等级"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="compBuilderVersionMin">
	<InputNumber v-model="searchForm.compBuilderVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compBuilderVersionMax">
	<InputNumber v-model="searchForm.compBuilderVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="compBuilderCreateTimeMin">
	<DatePicker @on-change="searchForm.compBuilderCreateTimeMin=$event" :value="searchForm.compBuilderCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compBuilderCreateTimeMax">
	<DatePicker @on-change="searchForm.compBuilderCreateTimeMax=$event" :value="searchForm.compBuilderCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="compBuilderUpdateTimeMin">
	<DatePicker @on-change="searchForm.compBuilderUpdateTimeMin=$event" :value="searchForm.compBuilderUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compBuilderUpdateTimeMax">
	<DatePicker @on-change="searchForm.compBuilderUpdateTimeMax=$event" :value="searchForm.compBuilderUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="compBuilderIsActiveMin">
	<InputNumber v-model="searchForm.compBuilderIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compBuilderIsActiveMax">
	<InputNumber v-model="searchForm.compBuilderIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="公示编号"><Row>
	<i-col span="11">
	<FormItem prop="projectAnnounceIdMin">
	<InputNumber v-model="searchForm.projectAnnounceIdMin" placeholder="请输入开始公示编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectAnnounceIdMax">
	<InputNumber v-model="searchForm.projectAnnounceIdMax" placeholder="请输入结束公示编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目编号"><Row>
	<i-col span="11">
	<FormItem prop="projectAnnounceProjectIdMin">
	<InputNumber v-model="searchForm.projectAnnounceProjectIdMin" placeholder="请输入开始项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectAnnounceProjectIdMax">
	<InputNumber v-model="searchForm.projectAnnounceProjectIdMax" placeholder="请输入结束项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="公示详情" prop="projectAnnounceAnnounceDesc">
	<Input v-model="searchForm.projectAnnounceAnnounceDesc" placeholder="请输入公示详情"/>
</FormItem>
<FormItem label="第一候选人" prop="projectAnnounceFirstCandidate">
	<Input v-model="searchForm.projectAnnounceFirstCandidate" placeholder="请输入第一候选人"/>
</FormItem>
<FormItem label="建造师姓名" prop="projectAnnounceFirstBuilderName">
	<Input v-model="searchForm.projectAnnounceFirstBuilderName" placeholder="请输入建造师姓名"/>
</FormItem>
<FormItem label="中标金额" prop="projectAnnounceFirstMarkMoney">
	<Input v-model="searchForm.projectAnnounceFirstMarkMoney" placeholder="请输入中标金额"/>
</FormItem>
<FormItem label="第二候选人" prop="projectAnnounceSecondCandidate">
	<Input v-model="searchForm.projectAnnounceSecondCandidate" placeholder="请输入第二候选人"/>
</FormItem>
<FormItem label="第三候选人" prop="projectAnnounceThirdCandidate">
	<Input v-model="searchForm.projectAnnounceThirdCandidate" placeholder="请输入第三候选人"/>
</FormItem>
<FormItem label="源地址" prop="projectAnnounceSourceUrl">
	<Input v-model="searchForm.projectAnnounceSourceUrl" placeholder="请输入源地址"/>
</FormItem>
<FormItem label="内部地址" prop="projectAnnounceInwordHtmlUrl">
	<Input v-model="searchForm.projectAnnounceInwordHtmlUrl" placeholder="请输入内部地址"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="projectAnnounceVersionMin">
	<InputNumber v-model="searchForm.projectAnnounceVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectAnnounceVersionMax">
	<InputNumber v-model="searchForm.projectAnnounceVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="projectAnnounceCreateTimeMin">
	<DatePicker @on-change="searchForm.projectAnnounceCreateTimeMin=$event" :value="searchForm.projectAnnounceCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectAnnounceCreateTimeMax">
	<DatePicker @on-change="searchForm.projectAnnounceCreateTimeMax=$event" :value="searchForm.projectAnnounceCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="projectAnnounceUpdateTimeMin">
	<DatePicker @on-change="searchForm.projectAnnounceUpdateTimeMin=$event" :value="searchForm.projectAnnounceUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectAnnounceUpdateTimeMax">
	<DatePicker @on-change="searchForm.projectAnnounceUpdateTimeMax=$event" :value="searchForm.projectAnnounceUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="projectAnnounceIsActiveMin">
	<InputNumber v-model="searchForm.projectAnnounceIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectAnnounceIsActiveMax">
	<InputNumber v-model="searchForm.projectAnnounceIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目名称" prop="projectTitle">
	<Input v-model="searchForm.projectTitle" placeholder="请输入项目名称"/>
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
      <p>企业建造师编号: <span v-text="form.compBuilderId"></span></p>
<p>企业编号: <span v-text="form.compBuilderCompId"></span></p>
<p>姓名: <span v-text="form.compBuilderName"></span></p>
<p>性别: <span v-text="form.compBuilderGender"></span></p>
<p>注册证件号码: <span v-text="form.compBuilderRegNum"></span></p>
<p>专业等级: <span v-text="form.compBuilderMajorLevel"></span></p>
<p>版本号: <span v-text="form.compBuilderVersion"></span></p>
<p>创建时间: <span v-text="form.compBuilderCreateTime"></span></p>
<p>更新时间: <span v-text="form.compBuilderUpdateTime"></span></p>
<p>是否激活: <span v-text="form.compBuilderIsActive"></span></p>
<p>公示编号: <span v-text="form.projectAnnounceId"></span></p>
<p>项目编号: <span v-text="form.projectAnnounceProjectId"></span></p>
<p>公示详情: <span v-text="form.projectAnnounceAnnounceDesc"></span></p>
<p>第一候选人: <span v-text="form.projectAnnounceFirstCandidate"></span></p>
<p>建造师姓名: <span v-text="form.projectAnnounceFirstBuilderName"></span></p>
<p>中标金额: <span v-text="form.projectAnnounceFirstMarkMoney"></span></p>
<p>第二候选人: <span v-text="form.projectAnnounceSecondCandidate"></span></p>
<p>第三候选人: <span v-text="form.projectAnnounceThirdCandidate"></span></p>
<p>源地址: <span v-text="form.projectAnnounceSourceUrl"></span></p>
<p>内部地址: <span v-text="form.projectAnnounceInwordHtmlUrl"></span></p>
<p>版本号: <span v-text="form.projectAnnounceVersion"></span></p>
<p>创建时间: <span v-text="form.projectAnnounceCreateTime"></span></p>
<p>更新时间: <span v-text="form.projectAnnounceUpdateTime"></span></p>
<p>是否激活: <span v-text="form.projectAnnounceIsActive"></span></p>
<p>项目名称: <span v-text="form.projectTitle"></span></p>
<p>企业类型: <span v-text="form.companyCompType"></span></p>
<p>行业分类: <span v-text="form.companyIndustryType"></span></p>
<p>企业名称: <span v-text="form.companyCompName"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'CompBuilderCompany',
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
          searchUrl: '/CompBuilderCompany/admin/pager-cond',
          allUrl: '/CompBuilderCompany/admin/all',
          detailUrl: '/CompBuilderCompany/admin/one/',
          multiUrl: '/CompBuilderCompany/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          compBuilderId: null,
compBuilderCompId: null,
compBuilderName: null,
compBuilderGender: null,
compBuilderRegNum: null,
compBuilderMajorLevel: null,
compBuilderVersion: null,
compBuilderCreateTime: null,
compBuilderUpdateTime: null,
compBuilderIsActive: null,
projectAnnounceId: null,
projectAnnounceProjectId: null,
projectAnnounceAnnounceDesc: null,
projectAnnounceFirstCandidate: null,
projectAnnounceFirstBuilderName: null,
projectAnnounceFirstMarkMoney: null,
projectAnnounceSecondCandidate: null,
projectAnnounceThirdCandidate: null,
projectAnnounceSourceUrl: null,
projectAnnounceInwordHtmlUrl: null,
projectAnnounceVersion: null,
projectAnnounceCreateTime: null,
projectAnnounceUpdateTime: null,
projectAnnounceIsActive: null,
projectTitle: null,
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          compBuilderId: null,
compBuilderIdMin: null, 
compBuilderIdMax: null, 
compBuilderCompId: null,
compBuilderCompIdMin: null, 
compBuilderCompIdMax: null, 
compBuilderName: null,
compBuilderGender: null,
compBuilderRegNum: null,
compBuilderMajorLevel: null,
compBuilderVersion: null,
compBuilderVersionMin: null, 
compBuilderVersionMax: null, 
compBuilderCreateTime: null,
compBuilderCreateTimeMin: null, 
compBuilderCreateTimeMax: null, 
compBuilderUpdateTime: null,
compBuilderUpdateTimeMin: null, 
compBuilderUpdateTimeMax: null, 
compBuilderIsActive: null,
compBuilderIsActiveMin: null, 
compBuilderIsActiveMax: null, 
projectAnnounceId: null,
projectAnnounceIdMin: null, 
projectAnnounceIdMax: null, 
projectAnnounceProjectId: null,
projectAnnounceProjectIdMin: null, 
projectAnnounceProjectIdMax: null, 
projectAnnounceAnnounceDesc: null,
projectAnnounceFirstCandidate: null,
projectAnnounceFirstBuilderName: null,
projectAnnounceFirstMarkMoney: null,
projectAnnounceSecondCandidate: null,
projectAnnounceThirdCandidate: null,
projectAnnounceSourceUrl: null,
projectAnnounceInwordHtmlUrl: null,
projectAnnounceVersion: null,
projectAnnounceVersionMin: null, 
projectAnnounceVersionMax: null, 
projectAnnounceCreateTime: null,
projectAnnounceCreateTimeMin: null, 
projectAnnounceCreateTimeMax: null, 
projectAnnounceUpdateTime: null,
projectAnnounceUpdateTimeMin: null, 
projectAnnounceUpdateTimeMax: null, 
projectAnnounceIsActive: null,
projectAnnounceIsActiveMin: null, 
projectAnnounceIsActiveMax: null, 
projectTitle: null,
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
title: '企业建造师编号',
key: 'compBuilderId',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compBuilderCompId',
minWidth: 120,
sortable: true
},
{
title: '姓名',
key: 'compBuilderName',
minWidth: 120,
sortable: true
},
{
title: '性别',
key: 'compBuilderGender',
minWidth: 120,
sortable: true
},
{
title: '注册证件号码',
key: 'compBuilderRegNum',
minWidth: 120,
sortable: true
},
{
title: '专业等级',
key: 'compBuilderMajorLevel',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'compBuilderVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'compBuilderCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'compBuilderUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'compBuilderIsActive',
minWidth: 120,
sortable: true
},
{
title: '公示编号',
key: 'projectAnnounceId',
minWidth: 120,
sortable: true
},
{
title: '项目编号',
key: 'projectAnnounceProjectId',
minWidth: 120,
sortable: true
},
{
title: '公示详情',
key: 'projectAnnounceAnnounceDesc',
minWidth: 120,
sortable: true
},
{
title: '第一候选人',
key: 'projectAnnounceFirstCandidate',
minWidth: 120,
sortable: true
},
{
title: '建造师姓名',
key: 'projectAnnounceFirstBuilderName',
minWidth: 120,
sortable: true
},
{
title: '中标金额',
key: 'projectAnnounceFirstMarkMoney',
minWidth: 120,
sortable: true
},
{
title: '第二候选人',
key: 'projectAnnounceSecondCandidate',
minWidth: 120,
sortable: true
},
{
title: '第三候选人',
key: 'projectAnnounceThirdCandidate',
minWidth: 120,
sortable: true
},
{
title: '源地址',
key: 'projectAnnounceSourceUrl',
minWidth: 120,
sortable: true
},
{
title: '内部地址',
key: 'projectAnnounceInwordHtmlUrl',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'projectAnnounceVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'projectAnnounceCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'projectAnnounceUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'projectAnnounceIsActive',
minWidth: 120,
sortable: true
},
{
title: '项目名称',
key: 'projectTitle',
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
