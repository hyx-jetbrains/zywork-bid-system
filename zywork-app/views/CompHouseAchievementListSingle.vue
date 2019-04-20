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
        <FormItem label="企业房建业绩编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始企业房建业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束企业房建业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compIdMin">
	<InputNumber v-model="searchForm.compIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compIdMax">
	<InputNumber v-model="searchForm.compIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="工程名称" prop="projectName">
	<Input v-model="searchForm.projectName" placeholder="请输入工程名称"/>
</FormItem>
<FormItem label="注册建造师" prop="builderName">
	<Input v-model="searchForm.builderName" placeholder="请输入注册建造师"/>
</FormItem>
<FormItem label="中标金额" prop="markMoney">
	<Input v-model="searchForm.markMoney" placeholder="请输入中标金额"/>
</FormItem>
<FormItem label="建设规模" prop="buildScale">
	<Input v-model="searchForm.buildScale" placeholder="请输入建设规模"/>
</FormItem>
<FormItem label="项目所属地区归类" prop="regionType">
	<Input v-model="searchForm.regionType" placeholder="请输入项目所属地区归类"/>
</FormItem>
<FormItem label="建设单位" prop="buildComp">
	<Input v-model="searchForm.buildComp" placeholder="请输入建设单位"/>
</FormItem>
<FormItem label="工程地址" prop="projectAddr">
	<Input v-model="searchForm.projectAddr" placeholder="请输入工程地址"/>
</FormItem>
<FormItem label="合同签订日期"><Row>
	<i-col span="11">
	<FormItem prop="contractDateMin">
	<DatePicker @on-change="searchForm.contractDateMin=$event" :value="searchForm.contractDateMin" placeholder="请输入开始合同签订日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="contractDateMax">
	<DatePicker @on-change="searchForm.contractDateMax=$event" :value="searchForm.contractDateMax" placeholder="请输入结束合同签订日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="中标日期"><Row>
	<i-col span="11">
	<FormItem prop="markDateMin">
	<DatePicker @on-change="searchForm.markDateMin=$event" :value="searchForm.markDateMin" placeholder="请输入开始中标日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markDateMax">
	<DatePicker @on-change="searchForm.markDateMax=$event" :value="searchForm.markDateMax" placeholder="请输入结束中标日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目负责人" prop="name">
	<Input v-model="searchForm.name" placeholder="请输入项目负责人"/>
</FormItem>
<FormItem label="项目负责人证书号" prop="certificateNum">
	<Input v-model="searchForm.certificateNum" placeholder="请输入项目负责人证书号"/>
</FormItem>
<FormItem label="施工员" prop="constructors">
	<Input v-model="searchForm.constructors" placeholder="请输入施工员"/>
</FormItem>
<FormItem label="施工员证书号" prop="constructorsCertificateNum">
	<Input v-model="searchForm.constructorsCertificateNum" placeholder="请输入施工员证书号"/>
</FormItem>
<FormItem label="施工员身份证号" prop="constructorsIdNum">
	<Input v-model="searchForm.constructorsIdNum" placeholder="请输入施工员身份证号"/>
</FormItem>
<FormItem label="质量员" prop="qualityWorker">
	<Input v-model="searchForm.qualityWorker" placeholder="请输入质量员"/>
</FormItem>
<FormItem label="质量员证书号" prop="qualityWorkerCertificateNum">
	<Input v-model="searchForm.qualityWorkerCertificateNum" placeholder="请输入质量员证书号"/>
</FormItem>
<FormItem label="质量员身份证号" prop="qualityWorkerIdNum">
	<Input v-model="searchForm.qualityWorkerIdNum" placeholder="请输入质量员身份证号"/>
</FormItem>
<FormItem label="安全员" prop="securityOfficer">
	<Input v-model="searchForm.securityOfficer" placeholder="请输入安全员"/>
</FormItem>
<FormItem label="安全员证书号" prop="securityOfficerCertificateNum">
	<Input v-model="searchForm.securityOfficerCertificateNum" placeholder="请输入安全员证书号"/>
</FormItem>
<FormItem label="安全员身份证号" prop="securityOfficerIdNum">
	<Input v-model="searchForm.securityOfficerIdNum" placeholder="请输入安全员身份证号"/>
</FormItem>
<FormItem label="标准员" prop="standardWorker">
	<Input v-model="searchForm.standardWorker" placeholder="请输入标准员"/>
</FormItem>
<FormItem label="标准员证书号" prop="standardWorkerCertificateNum">
	<Input v-model="searchForm.standardWorkerCertificateNum" placeholder="请输入标准员证书号"/>
</FormItem>
<FormItem label="标准员身份证号" prop="standardWorkerIdNum">
	<Input v-model="searchForm.standardWorkerIdNum" placeholder="请输入标准员身份证号"/>
</FormItem>
<FormItem label="材料员" prop="materialMan">
	<Input v-model="searchForm.materialMan" placeholder="请输入材料员"/>
</FormItem>
<FormItem label="材料员证书号" prop="materialManCertificateNum">
	<Input v-model="searchForm.materialManCertificateNum" placeholder="请输入材料员证书号"/>
</FormItem>
<FormItem label="材料员身份证号" prop="materialManIdNum">
	<Input v-model="searchForm.materialManIdNum" placeholder="请输入材料员身份证号"/>
</FormItem>
<FormItem label="机械员" prop="mechanic">
	<Input v-model="searchForm.mechanic" placeholder="请输入机械员"/>
</FormItem>
<FormItem label="机械员证书号" prop="mechanicCertificateNum">
	<Input v-model="searchForm.mechanicCertificateNum" placeholder="请输入机械员证书号"/>
</FormItem>
<FormItem label="机械员身份证号" prop="mechanicIdNum">
	<Input v-model="searchForm.mechanicIdNum" placeholder="请输入机械员身份证号"/>
</FormItem>
<FormItem label="劳务员" prop="labors">
	<Input v-model="searchForm.labors" placeholder="请输入劳务员"/>
</FormItem>
<FormItem label="劳务员证书号" prop="laborsCertificateNum">
	<Input v-model="searchForm.laborsCertificateNum" placeholder="请输入劳务员证书号"/>
</FormItem>
<FormItem label="劳务员身份证号" prop="laborsIdNum">
	<Input v-model="searchForm.laborsIdNum" placeholder="请输入劳务员身份证号"/>
</FormItem>
<FormItem label="资料员" prop="dataClerk">
	<Input v-model="searchForm.dataClerk" placeholder="请输入资料员"/>
</FormItem>
<FormItem label="资料员证书号" prop="dataClerkCertificateNum">
	<Input v-model="searchForm.dataClerkCertificateNum" placeholder="请输入资料员证书号"/>
</FormItem>
<FormItem label="资料员身份证号" prop="dataClerkIdNum">
	<Input v-model="searchForm.dataClerkIdNum" placeholder="请输入资料员身份证号"/>
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
      <p>企业房建业绩编号: <span v-text="form.id"></span></p>
<p>企业编号: <span v-text="form.compId"></span></p>
<p>工程名称: <span v-text="form.projectName"></span></p>
<p>注册建造师: <span v-text="form.builderName"></span></p>
<p>中标金额: <span v-text="form.markMoney"></span></p>
<p>建设规模: <span v-text="form.buildScale"></span></p>
<p>项目所属地区归类: <span v-text="form.regionType"></span></p>
<p>建设单位: <span v-text="form.buildComp"></span></p>
<p>工程地址: <span v-text="form.projectAddr"></span></p>
<p>合同签订日期: <span v-text="form.contractDate"></span></p>
<p>中标日期: <span v-text="form.markDate"></span></p>
<p>项目负责人: <span v-text="form.name"></span></p>
<p>项目负责人证书号: <span v-text="form.certificateNum"></span></p>
<p>施工员: <span v-text="form.constructors"></span></p>
<p>施工员证书号: <span v-text="form.constructorsCertificateNum"></span></p>
<p>施工员身份证号: <span v-text="form.constructorsIdNum"></span></p>
<p>质量员: <span v-text="form.qualityWorker"></span></p>
<p>质量员证书号: <span v-text="form.qualityWorkerCertificateNum"></span></p>
<p>质量员身份证号: <span v-text="form.qualityWorkerIdNum"></span></p>
<p>安全员: <span v-text="form.securityOfficer"></span></p>
<p>安全员证书号: <span v-text="form.securityOfficerCertificateNum"></span></p>
<p>安全员身份证号: <span v-text="form.securityOfficerIdNum"></span></p>
<p>标准员: <span v-text="form.standardWorker"></span></p>
<p>标准员证书号: <span v-text="form.standardWorkerCertificateNum"></span></p>
<p>标准员身份证号: <span v-text="form.standardWorkerIdNum"></span></p>
<p>材料员: <span v-text="form.materialMan"></span></p>
<p>材料员证书号: <span v-text="form.materialManCertificateNum"></span></p>
<p>材料员身份证号: <span v-text="form.materialManIdNum"></span></p>
<p>机械员: <span v-text="form.mechanic"></span></p>
<p>机械员证书号: <span v-text="form.mechanicCertificateNum"></span></p>
<p>机械员身份证号: <span v-text="form.mechanicIdNum"></span></p>
<p>劳务员: <span v-text="form.labors"></span></p>
<p>劳务员证书号: <span v-text="form.laborsCertificateNum"></span></p>
<p>劳务员身份证号: <span v-text="form.laborsIdNum"></span></p>
<p>资料员: <span v-text="form.dataClerk"></span></p>
<p>资料员证书号: <span v-text="form.dataClerkCertificateNum"></span></p>
<p>资料员身份证号: <span v-text="form.dataClerkIdNum"></span></p>
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
    name: 'CompHouseAchievementListSingle',
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
          searchUrl: '/comp-house-achievement/admin/pager-cond',
          allUrl: '/comp-house-achievement/admin/all',
          detailUrl: '/comp-house-achievement/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
compId: null,
projectName: null,
builderName: null,
markMoney: null,
buildScale: null,
regionType: null,
buildComp: null,
projectAddr: null,
contractDate: null,
markDate: null,
name: null,
certificateNum: null,
constructors: null,
constructorsCertificateNum: null,
constructorsIdNum: null,
qualityWorker: null,
qualityWorkerCertificateNum: null,
qualityWorkerIdNum: null,
securityOfficer: null,
securityOfficerCertificateNum: null,
securityOfficerIdNum: null,
standardWorker: null,
standardWorkerCertificateNum: null,
standardWorkerIdNum: null,
materialMan: null,
materialManCertificateNum: null,
materialManIdNum: null,
mechanic: null,
mechanicCertificateNum: null,
mechanicIdNum: null,
labors: null,
laborsCertificateNum: null,
laborsIdNum: null,
dataClerk: null,
dataClerkCertificateNum: null,
dataClerkIdNum: null,
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
compId: null,
compIdMin: null, 
compIdMax: null, 
projectName: null,
builderName: null,
markMoney: null,
buildScale: null,
regionType: null,
buildComp: null,
projectAddr: null,
contractDate: null,
contractDateMin: null, 
contractDateMax: null, 
markDate: null,
markDateMin: null, 
markDateMax: null, 
name: null,
certificateNum: null,
constructors: null,
constructorsCertificateNum: null,
constructorsIdNum: null,
qualityWorker: null,
qualityWorkerCertificateNum: null,
qualityWorkerIdNum: null,
securityOfficer: null,
securityOfficerCertificateNum: null,
securityOfficerIdNum: null,
standardWorker: null,
standardWorkerCertificateNum: null,
standardWorkerIdNum: null,
materialMan: null,
materialManCertificateNum: null,
materialManIdNum: null,
mechanic: null,
mechanicCertificateNum: null,
mechanicIdNum: null,
labors: null,
laborsCertificateNum: null,
laborsIdNum: null,
dataClerk: null,
dataClerkCertificateNum: null,
dataClerkIdNum: null,
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
title: '企业房建业绩编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compId',
minWidth: 120,
sortable: true
},
{
title: '工程名称',
key: 'projectName',
minWidth: 120,
sortable: true
},
{
title: '注册建造师',
key: 'builderName',
minWidth: 120,
sortable: true
},
{
title: '中标金额',
key: 'markMoney',
minWidth: 120,
sortable: true
},
{
title: '建设规模',
key: 'buildScale',
minWidth: 120,
sortable: true
},
{
title: '项目所属地区归类',
key: 'regionType',
minWidth: 120,
sortable: true
},
{
title: '建设单位',
key: 'buildComp',
minWidth: 120,
sortable: true
},
{
title: '工程地址',
key: 'projectAddr',
minWidth: 120,
sortable: true
},
{
title: '合同签订日期',
key: 'contractDate',
minWidth: 120,
sortable: true
},
{
title: '中标日期',
key: 'markDate',
minWidth: 120,
sortable: true
},
{
title: '项目负责人',
key: 'name',
minWidth: 120,
sortable: true
},
{
title: '项目负责人证书号',
key: 'certificateNum',
minWidth: 120,
sortable: true
},
{
title: '施工员',
key: 'constructors',
minWidth: 120,
sortable: true
},
{
title: '施工员证书号',
key: 'constructorsCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '施工员身份证号',
key: 'constructorsIdNum',
minWidth: 120,
sortable: true
},
{
title: '质量员',
key: 'qualityWorker',
minWidth: 120,
sortable: true
},
{
title: '质量员证书号',
key: 'qualityWorkerCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '质量员身份证号',
key: 'qualityWorkerIdNum',
minWidth: 120,
sortable: true
},
{
title: '安全员',
key: 'securityOfficer',
minWidth: 120,
sortable: true
},
{
title: '安全员证书号',
key: 'securityOfficerCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '安全员身份证号',
key: 'securityOfficerIdNum',
minWidth: 120,
sortable: true
},
{
title: '标准员',
key: 'standardWorker',
minWidth: 120,
sortable: true
},
{
title: '标准员证书号',
key: 'standardWorkerCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '标准员身份证号',
key: 'standardWorkerIdNum',
minWidth: 120,
sortable: true
},
{
title: '材料员',
key: 'materialMan',
minWidth: 120,
sortable: true
},
{
title: '材料员证书号',
key: 'materialManCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '材料员身份证号',
key: 'materialManIdNum',
minWidth: 120,
sortable: true
},
{
title: '机械员',
key: 'mechanic',
minWidth: 120,
sortable: true
},
{
title: '机械员证书号',
key: 'mechanicCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '机械员身份证号',
key: 'mechanicIdNum',
minWidth: 120,
sortable: true
},
{
title: '劳务员',
key: 'labors',
minWidth: 120,
sortable: true
},
{
title: '劳务员证书号',
key: 'laborsCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '劳务员身份证号',
key: 'laborsIdNum',
minWidth: 120,
sortable: true
},
{
title: '资料员',
key: 'dataClerk',
minWidth: 120,
sortable: true
},
{
title: '资料员证书号',
key: 'dataClerkCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '资料员身份证号',
key: 'dataClerkIdNum',
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
