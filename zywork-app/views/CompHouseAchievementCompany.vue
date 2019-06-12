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
        <FormItem label="企业房建业绩编号"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementIdMin">
	<InputNumber v-model="searchForm.compHouseAchievementIdMin" placeholder="请输入开始企业房建业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementIdMax">
	<InputNumber v-model="searchForm.compHouseAchievementIdMax" placeholder="请输入结束企业房建业绩编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="企业编号"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementCompIdMin">
	<InputNumber v-model="searchForm.compHouseAchievementCompIdMin" placeholder="请输入开始企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementCompIdMax">
	<InputNumber v-model="searchForm.compHouseAchievementCompIdMax" placeholder="请输入结束企业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="工程名称" prop="compHouseAchievementProjectName">
	<Input v-model="searchForm.compHouseAchievementProjectName" placeholder="请输入工程名称"/>
</FormItem>
<FormItem label="注册建造师" prop="compHouseAchievementBuilderName">
	<Input v-model="searchForm.compHouseAchievementBuilderName" placeholder="请输入注册建造师"/>
</FormItem>
<FormItem label="中标金额" prop="compHouseAchievementMarkMoney">
	<Input v-model="searchForm.compHouseAchievementMarkMoney" placeholder="请输入中标金额"/>
</FormItem>
<FormItem label="建设规模" prop="compHouseAchievementBuildScale">
	<Input v-model="searchForm.compHouseAchievementBuildScale" placeholder="请输入建设规模"/>
</FormItem>
<FormItem label="项目所属地区归类" prop="compHouseAchievementRegionType">
	<Input v-model="searchForm.compHouseAchievementRegionType" placeholder="请输入项目所属地区归类"/>
</FormItem>
<FormItem label="中标单位" prop="compHouseAchievementMarkComp">
	<Input v-model="searchForm.compHouseAchievementMarkComp" placeholder="请输入中标单位"/>
</FormItem>
<FormItem label="建设单位" prop="compHouseAchievementBuildComp">
	<Input v-model="searchForm.compHouseAchievementBuildComp" placeholder="请输入建设单位"/>
</FormItem>
<FormItem label="工程地址" prop="compHouseAchievementProjectAddr">
	<Input v-model="searchForm.compHouseAchievementProjectAddr" placeholder="请输入工程地址"/>
</FormItem>
<FormItem label="合同签订日期"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementContractDateMin">
	<DatePicker @on-change="searchForm.compHouseAchievementContractDateMin=$event" :value="searchForm.compHouseAchievementContractDateMin" placeholder="请输入开始合同签订日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementContractDateMax">
	<DatePicker @on-change="searchForm.compHouseAchievementContractDateMax=$event" :value="searchForm.compHouseAchievementContractDateMax" placeholder="请输入结束合同签订日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="中标日期"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementMarkDateMin">
	<DatePicker @on-change="searchForm.compHouseAchievementMarkDateMin=$event" :value="searchForm.compHouseAchievementMarkDateMin" placeholder="请输入开始中标日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementMarkDateMax">
	<DatePicker @on-change="searchForm.compHouseAchievementMarkDateMax=$event" :value="searchForm.compHouseAchievementMarkDateMax" placeholder="请输入结束中标日期" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目负责人" prop="compHouseAchievementName">
	<Input v-model="searchForm.compHouseAchievementName" placeholder="请输入项目负责人"/>
</FormItem>
<FormItem label="项目负责人证书号" prop="compHouseAchievementCertificateNum">
	<Input v-model="searchForm.compHouseAchievementCertificateNum" placeholder="请输入项目负责人证书号"/>
</FormItem>
<FormItem label="施工员" prop="compHouseAchievementConstructors">
	<Input v-model="searchForm.compHouseAchievementConstructors" placeholder="请输入施工员"/>
</FormItem>
<FormItem label="施工员证书号" prop="compHouseAchievementConstructorsCertificateNum">
	<Input v-model="searchForm.compHouseAchievementConstructorsCertificateNum" placeholder="请输入施工员证书号"/>
</FormItem>
<FormItem label="施工员身份证号" prop="compHouseAchievementConstructorsIdNum">
	<Input v-model="searchForm.compHouseAchievementConstructorsIdNum" placeholder="请输入施工员身份证号"/>
</FormItem>
<FormItem label="质量员" prop="compHouseAchievementQualityWorker">
	<Input v-model="searchForm.compHouseAchievementQualityWorker" placeholder="请输入质量员"/>
</FormItem>
<FormItem label="质量员证书号" prop="compHouseAchievementQualityWorkerCertificateNum">
	<Input v-model="searchForm.compHouseAchievementQualityWorkerCertificateNum" placeholder="请输入质量员证书号"/>
</FormItem>
<FormItem label="质量员身份证号" prop="compHouseAchievementQualityWorkerIdNum">
	<Input v-model="searchForm.compHouseAchievementQualityWorkerIdNum" placeholder="请输入质量员身份证号"/>
</FormItem>
<FormItem label="安全员" prop="compHouseAchievementSecurityOfficer">
	<Input v-model="searchForm.compHouseAchievementSecurityOfficer" placeholder="请输入安全员"/>
</FormItem>
<FormItem label="安全员证书号" prop="compHouseAchievementSecurityOfficerCertificateNum">
	<Input v-model="searchForm.compHouseAchievementSecurityOfficerCertificateNum" placeholder="请输入安全员证书号"/>
</FormItem>
<FormItem label="安全员身份证号" prop="compHouseAchievementSecurityOfficerIdNum">
	<Input v-model="searchForm.compHouseAchievementSecurityOfficerIdNum" placeholder="请输入安全员身份证号"/>
</FormItem>
<FormItem label="标准员" prop="compHouseAchievementStandardWorker">
	<Input v-model="searchForm.compHouseAchievementStandardWorker" placeholder="请输入标准员"/>
</FormItem>
<FormItem label="标准员证书号" prop="compHouseAchievementStandardWorkerCertificateNum">
	<Input v-model="searchForm.compHouseAchievementStandardWorkerCertificateNum" placeholder="请输入标准员证书号"/>
</FormItem>
<FormItem label="标准员身份证号" prop="compHouseAchievementStandardWorkerIdNum">
	<Input v-model="searchForm.compHouseAchievementStandardWorkerIdNum" placeholder="请输入标准员身份证号"/>
</FormItem>
<FormItem label="材料员" prop="compHouseAchievementMaterialMan">
	<Input v-model="searchForm.compHouseAchievementMaterialMan" placeholder="请输入材料员"/>
</FormItem>
<FormItem label="材料员证书号" prop="compHouseAchievementMaterialManCertificateNum">
	<Input v-model="searchForm.compHouseAchievementMaterialManCertificateNum" placeholder="请输入材料员证书号"/>
</FormItem>
<FormItem label="材料员身份证号" prop="compHouseAchievementMaterialManIdNum">
	<Input v-model="searchForm.compHouseAchievementMaterialManIdNum" placeholder="请输入材料员身份证号"/>
</FormItem>
<FormItem label="机械员" prop="compHouseAchievementMechanic">
	<Input v-model="searchForm.compHouseAchievementMechanic" placeholder="请输入机械员"/>
</FormItem>
<FormItem label="机械员证书号" prop="compHouseAchievementMechanicCertificateNum">
	<Input v-model="searchForm.compHouseAchievementMechanicCertificateNum" placeholder="请输入机械员证书号"/>
</FormItem>
<FormItem label="机械员身份证号" prop="compHouseAchievementMechanicIdNum">
	<Input v-model="searchForm.compHouseAchievementMechanicIdNum" placeholder="请输入机械员身份证号"/>
</FormItem>
<FormItem label="劳务员" prop="compHouseAchievementLabors">
	<Input v-model="searchForm.compHouseAchievementLabors" placeholder="请输入劳务员"/>
</FormItem>
<FormItem label="劳务员证书号" prop="compHouseAchievementLaborsCertificateNum">
	<Input v-model="searchForm.compHouseAchievementLaborsCertificateNum" placeholder="请输入劳务员证书号"/>
</FormItem>
<FormItem label="劳务员身份证号" prop="compHouseAchievementLaborsIdNum">
	<Input v-model="searchForm.compHouseAchievementLaborsIdNum" placeholder="请输入劳务员身份证号"/>
</FormItem>
<FormItem label="资料员" prop="compHouseAchievementDataClerk">
	<Input v-model="searchForm.compHouseAchievementDataClerk" placeholder="请输入资料员"/>
</FormItem>
<FormItem label="资料员证书号" prop="compHouseAchievementDataClerkCertificateNum">
	<Input v-model="searchForm.compHouseAchievementDataClerkCertificateNum" placeholder="请输入资料员证书号"/>
</FormItem>
<FormItem label="资料员身份证号" prop="compHouseAchievementDataClerkIdNum">
	<Input v-model="searchForm.compHouseAchievementDataClerkIdNum" placeholder="请输入资料员身份证号"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementVersionMin">
	<InputNumber v-model="searchForm.compHouseAchievementVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementVersionMax">
	<InputNumber v-model="searchForm.compHouseAchievementVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementCreateTimeMin">
	<DatePicker @on-change="searchForm.compHouseAchievementCreateTimeMin=$event" :value="searchForm.compHouseAchievementCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementCreateTimeMax">
	<DatePicker @on-change="searchForm.compHouseAchievementCreateTimeMax=$event" :value="searchForm.compHouseAchievementCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementUpdateTimeMin">
	<DatePicker @on-change="searchForm.compHouseAchievementUpdateTimeMin=$event" :value="searchForm.compHouseAchievementUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementUpdateTimeMax">
	<DatePicker @on-change="searchForm.compHouseAchievementUpdateTimeMax=$event" :value="searchForm.compHouseAchievementUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="compHouseAchievementIsActiveMin">
	<InputNumber v-model="searchForm.compHouseAchievementIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="compHouseAchievementIsActiveMax">
	<InputNumber v-model="searchForm.compHouseAchievementIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>企业房建业绩编号: <span v-text="form.compHouseAchievementId"></span></p>
<p>企业编号: <span v-text="form.compHouseAchievementCompId"></span></p>
<p>工程名称: <span v-text="form.compHouseAchievementProjectName"></span></p>
<p>注册建造师: <span v-text="form.compHouseAchievementBuilderName"></span></p>
<p>中标金额: <span v-text="form.compHouseAchievementMarkMoney"></span></p>
<p>建设规模: <span v-text="form.compHouseAchievementBuildScale"></span></p>
<p>项目所属地区归类: <span v-text="form.compHouseAchievementRegionType"></span></p>
<p>中标单位: <span v-text="form.compHouseAchievementMarkComp"></span></p>
<p>建设单位: <span v-text="form.compHouseAchievementBuildComp"></span></p>
<p>工程地址: <span v-text="form.compHouseAchievementProjectAddr"></span></p>
<p>合同签订日期: <span v-text="form.compHouseAchievementContractDate"></span></p>
<p>中标日期: <span v-text="form.compHouseAchievementMarkDate"></span></p>
<p>项目负责人: <span v-text="form.compHouseAchievementName"></span></p>
<p>项目负责人证书号: <span v-text="form.compHouseAchievementCertificateNum"></span></p>
<p>施工员: <span v-text="form.compHouseAchievementConstructors"></span></p>
<p>施工员证书号: <span v-text="form.compHouseAchievementConstructorsCertificateNum"></span></p>
<p>施工员身份证号: <span v-text="form.compHouseAchievementConstructorsIdNum"></span></p>
<p>质量员: <span v-text="form.compHouseAchievementQualityWorker"></span></p>
<p>质量员证书号: <span v-text="form.compHouseAchievementQualityWorkerCertificateNum"></span></p>
<p>质量员身份证号: <span v-text="form.compHouseAchievementQualityWorkerIdNum"></span></p>
<p>安全员: <span v-text="form.compHouseAchievementSecurityOfficer"></span></p>
<p>安全员证书号: <span v-text="form.compHouseAchievementSecurityOfficerCertificateNum"></span></p>
<p>安全员身份证号: <span v-text="form.compHouseAchievementSecurityOfficerIdNum"></span></p>
<p>标准员: <span v-text="form.compHouseAchievementStandardWorker"></span></p>
<p>标准员证书号: <span v-text="form.compHouseAchievementStandardWorkerCertificateNum"></span></p>
<p>标准员身份证号: <span v-text="form.compHouseAchievementStandardWorkerIdNum"></span></p>
<p>材料员: <span v-text="form.compHouseAchievementMaterialMan"></span></p>
<p>材料员证书号: <span v-text="form.compHouseAchievementMaterialManCertificateNum"></span></p>
<p>材料员身份证号: <span v-text="form.compHouseAchievementMaterialManIdNum"></span></p>
<p>机械员: <span v-text="form.compHouseAchievementMechanic"></span></p>
<p>机械员证书号: <span v-text="form.compHouseAchievementMechanicCertificateNum"></span></p>
<p>机械员身份证号: <span v-text="form.compHouseAchievementMechanicIdNum"></span></p>
<p>劳务员: <span v-text="form.compHouseAchievementLabors"></span></p>
<p>劳务员证书号: <span v-text="form.compHouseAchievementLaborsCertificateNum"></span></p>
<p>劳务员身份证号: <span v-text="form.compHouseAchievementLaborsIdNum"></span></p>
<p>资料员: <span v-text="form.compHouseAchievementDataClerk"></span></p>
<p>资料员证书号: <span v-text="form.compHouseAchievementDataClerkCertificateNum"></span></p>
<p>资料员身份证号: <span v-text="form.compHouseAchievementDataClerkIdNum"></span></p>
<p>版本号: <span v-text="form.compHouseAchievementVersion"></span></p>
<p>创建时间: <span v-text="form.compHouseAchievementCreateTime"></span></p>
<p>更新时间: <span v-text="form.compHouseAchievementUpdateTime"></span></p>
<p>是否激活: <span v-text="form.compHouseAchievementIsActive"></span></p>
<p>企业类型: <span v-text="form.companyCompType"></span></p>
<p>行业分类: <span v-text="form.companyIndustryType"></span></p>
<p>企业名称: <span v-text="form.companyCompName"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'CompHouseAchievementCompany',
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
          searchUrl: '/CompHouseAchievementCompany/admin/pager-cond',
          allUrl: '/CompHouseAchievementCompany/admin/all',
          detailUrl: '/CompHouseAchievementCompany/admin/one/',
          multiUrl: '/CompHouseAchievementCompany/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          compHouseAchievementId: null,
compHouseAchievementCompId: null,
compHouseAchievementProjectName: null,
compHouseAchievementBuilderName: null,
compHouseAchievementMarkMoney: null,
compHouseAchievementBuildScale: null,
compHouseAchievementRegionType: null,
compHouseAchievementMarkComp: null,
compHouseAchievementBuildComp: null,
compHouseAchievementProjectAddr: null,
compHouseAchievementContractDate: null,
compHouseAchievementMarkDate: null,
compHouseAchievementName: null,
compHouseAchievementCertificateNum: null,
compHouseAchievementConstructors: null,
compHouseAchievementConstructorsCertificateNum: null,
compHouseAchievementConstructorsIdNum: null,
compHouseAchievementQualityWorker: null,
compHouseAchievementQualityWorkerCertificateNum: null,
compHouseAchievementQualityWorkerIdNum: null,
compHouseAchievementSecurityOfficer: null,
compHouseAchievementSecurityOfficerCertificateNum: null,
compHouseAchievementSecurityOfficerIdNum: null,
compHouseAchievementStandardWorker: null,
compHouseAchievementStandardWorkerCertificateNum: null,
compHouseAchievementStandardWorkerIdNum: null,
compHouseAchievementMaterialMan: null,
compHouseAchievementMaterialManCertificateNum: null,
compHouseAchievementMaterialManIdNum: null,
compHouseAchievementMechanic: null,
compHouseAchievementMechanicCertificateNum: null,
compHouseAchievementMechanicIdNum: null,
compHouseAchievementLabors: null,
compHouseAchievementLaborsCertificateNum: null,
compHouseAchievementLaborsIdNum: null,
compHouseAchievementDataClerk: null,
compHouseAchievementDataClerkCertificateNum: null,
compHouseAchievementDataClerkIdNum: null,
compHouseAchievementVersion: null,
compHouseAchievementCreateTime: null,
compHouseAchievementUpdateTime: null,
compHouseAchievementIsActive: null,
companyCompType: null,
companyIndustryType: null,
companyCompName: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          compHouseAchievementId: null,
compHouseAchievementIdMin: null, 
compHouseAchievementIdMax: null, 
compHouseAchievementCompId: null,
compHouseAchievementCompIdMin: null, 
compHouseAchievementCompIdMax: null, 
compHouseAchievementProjectName: null,
compHouseAchievementBuilderName: null,
compHouseAchievementMarkMoney: null,
compHouseAchievementBuildScale: null,
compHouseAchievementRegionType: null,
compHouseAchievementMarkComp: null,
compHouseAchievementBuildComp: null,
compHouseAchievementProjectAddr: null,
compHouseAchievementContractDate: null,
compHouseAchievementContractDateMin: null, 
compHouseAchievementContractDateMax: null, 
compHouseAchievementMarkDate: null,
compHouseAchievementMarkDateMin: null, 
compHouseAchievementMarkDateMax: null, 
compHouseAchievementName: null,
compHouseAchievementCertificateNum: null,
compHouseAchievementConstructors: null,
compHouseAchievementConstructorsCertificateNum: null,
compHouseAchievementConstructorsIdNum: null,
compHouseAchievementQualityWorker: null,
compHouseAchievementQualityWorkerCertificateNum: null,
compHouseAchievementQualityWorkerIdNum: null,
compHouseAchievementSecurityOfficer: null,
compHouseAchievementSecurityOfficerCertificateNum: null,
compHouseAchievementSecurityOfficerIdNum: null,
compHouseAchievementStandardWorker: null,
compHouseAchievementStandardWorkerCertificateNum: null,
compHouseAchievementStandardWorkerIdNum: null,
compHouseAchievementMaterialMan: null,
compHouseAchievementMaterialManCertificateNum: null,
compHouseAchievementMaterialManIdNum: null,
compHouseAchievementMechanic: null,
compHouseAchievementMechanicCertificateNum: null,
compHouseAchievementMechanicIdNum: null,
compHouseAchievementLabors: null,
compHouseAchievementLaborsCertificateNum: null,
compHouseAchievementLaborsIdNum: null,
compHouseAchievementDataClerk: null,
compHouseAchievementDataClerkCertificateNum: null,
compHouseAchievementDataClerkIdNum: null,
compHouseAchievementVersion: null,
compHouseAchievementVersionMin: null, 
compHouseAchievementVersionMax: null, 
compHouseAchievementCreateTime: null,
compHouseAchievementCreateTimeMin: null, 
compHouseAchievementCreateTimeMax: null, 
compHouseAchievementUpdateTime: null,
compHouseAchievementUpdateTimeMin: null, 
compHouseAchievementUpdateTimeMax: null, 
compHouseAchievementIsActive: null,
compHouseAchievementIsActiveMin: null, 
compHouseAchievementIsActiveMax: null, 
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
title: '企业房建业绩编号',
key: 'compHouseAchievementId',
minWidth: 120,
sortable: true
},
{
title: '企业编号',
key: 'compHouseAchievementCompId',
minWidth: 120,
sortable: true
},
{
title: '工程名称',
key: 'compHouseAchievementProjectName',
minWidth: 120,
sortable: true
},
{
title: '注册建造师',
key: 'compHouseAchievementBuilderName',
minWidth: 120,
sortable: true
},
{
title: '中标金额',
key: 'compHouseAchievementMarkMoney',
minWidth: 120,
sortable: true
},
{
title: '建设规模',
key: 'compHouseAchievementBuildScale',
minWidth: 120,
sortable: true
},
{
title: '项目所属地区归类',
key: 'compHouseAchievementRegionType',
minWidth: 120,
sortable: true
},
{
title: '中标单位',
key: 'compHouseAchievementMarkComp',
minWidth: 120,
sortable: true
},
{
title: '建设单位',
key: 'compHouseAchievementBuildComp',
minWidth: 120,
sortable: true
},
{
title: '工程地址',
key: 'compHouseAchievementProjectAddr',
minWidth: 120,
sortable: true
},
{
title: '合同签订日期',
key: 'compHouseAchievementContractDate',
minWidth: 120,
sortable: true
},
{
title: '中标日期',
key: 'compHouseAchievementMarkDate',
minWidth: 120,
sortable: true
},
{
title: '项目负责人',
key: 'compHouseAchievementName',
minWidth: 120,
sortable: true
},
{
title: '项目负责人证书号',
key: 'compHouseAchievementCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '施工员',
key: 'compHouseAchievementConstructors',
minWidth: 120,
sortable: true
},
{
title: '施工员证书号',
key: 'compHouseAchievementConstructorsCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '施工员身份证号',
key: 'compHouseAchievementConstructorsIdNum',
minWidth: 120,
sortable: true
},
{
title: '质量员',
key: 'compHouseAchievementQualityWorker',
minWidth: 120,
sortable: true
},
{
title: '质量员证书号',
key: 'compHouseAchievementQualityWorkerCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '质量员身份证号',
key: 'compHouseAchievementQualityWorkerIdNum',
minWidth: 120,
sortable: true
},
{
title: '安全员',
key: 'compHouseAchievementSecurityOfficer',
minWidth: 120,
sortable: true
},
{
title: '安全员证书号',
key: 'compHouseAchievementSecurityOfficerCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '安全员身份证号',
key: 'compHouseAchievementSecurityOfficerIdNum',
minWidth: 120,
sortable: true
},
{
title: '标准员',
key: 'compHouseAchievementStandardWorker',
minWidth: 120,
sortable: true
},
{
title: '标准员证书号',
key: 'compHouseAchievementStandardWorkerCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '标准员身份证号',
key: 'compHouseAchievementStandardWorkerIdNum',
minWidth: 120,
sortable: true
},
{
title: '材料员',
key: 'compHouseAchievementMaterialMan',
minWidth: 120,
sortable: true
},
{
title: '材料员证书号',
key: 'compHouseAchievementMaterialManCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '材料员身份证号',
key: 'compHouseAchievementMaterialManIdNum',
minWidth: 120,
sortable: true
},
{
title: '机械员',
key: 'compHouseAchievementMechanic',
minWidth: 120,
sortable: true
},
{
title: '机械员证书号',
key: 'compHouseAchievementMechanicCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '机械员身份证号',
key: 'compHouseAchievementMechanicIdNum',
minWidth: 120,
sortable: true
},
{
title: '劳务员',
key: 'compHouseAchievementLabors',
minWidth: 120,
sortable: true
},
{
title: '劳务员证书号',
key: 'compHouseAchievementLaborsCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '劳务员身份证号',
key: 'compHouseAchievementLaborsIdNum',
minWidth: 120,
sortable: true
},
{
title: '资料员',
key: 'compHouseAchievementDataClerk',
minWidth: 120,
sortable: true
},
{
title: '资料员证书号',
key: 'compHouseAchievementDataClerkCertificateNum',
minWidth: 120,
sortable: true
},
{
title: '资料员身份证号',
key: 'compHouseAchievementDataClerkIdNum',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'compHouseAchievementVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'compHouseAchievementCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'compHouseAchievementUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'compHouseAchievementIsActive',
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
