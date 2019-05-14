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
          <Table ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-selection-change="changeSelection" @on-sort-change="changeSort"></Table>
          <div style="margin: 20px;overflow: hidden">
            <div style="float: right;">
              <Page :total="page.total" :current="searchForm.pageNo" @on-change="changePageNo" @on-page-size-change="changePageSize" showSizer showTotal></Page>
            </div>
          </div>
        </Card>
      </i-col>
    </Row>
    <Modal v-model="modal.add" title="添加" @on-visible-change="changeModalVisibleResetForm('addForm', $event)">
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="项目名称" prop="title">
	<Input v-model="form.title" placeholder="请输入项目名称"/>
</FormItem>
<FormItem label="项目类型" prop="projectType">
	<Input v-model="form.projectType" placeholder="请输入项目类型"/>
</FormItem>
<FormItem label="城市" prop="city">
	<Input v-model="form.city" placeholder="请输入城市"/>
</FormItem>
<FormItem label="项目详情" prop="projectDetail">
	<Input v-model="form.projectDetail" placeholder="请输入项目详情"/>
</FormItem>
<FormItem label="发布状态" prop="releaseStatus">
	<Input v-model="form.releaseStatus" placeholder="请输入发布状态"/>
</FormItem>
<FormItem label="招标单位名称" prop="markUnitName">
	<Input v-model="form.markUnitName" placeholder="请输入招标单位名称"/>
</FormItem>
<FormItem label="项目投资" prop="projectInvest">
	<Input v-model="form.projectInvest" placeholder="请输入项目投资"/>
</FormItem>
<FormItem label="审查方式" prop="checkPattern">
	<Input v-model="form.checkPattern" placeholder="请输入审查方式"/>
</FormItem>
<FormItem label="企业资质类型" prop="compAptitudeType">
	<Input v-model="form.compAptitudeType" placeholder="请输入企业资质类型"/>
</FormItem>
<FormItem label="建造师等级" prop="builderLevel">
	<Input v-model="form.builderLevel" placeholder="请输入建造师等级"/>
</FormItem>
<FormItem label="资金落实(%)" prop="moneyToImplement">
	<InputNumber v-model="form.moneyToImplement" placeholder="请输入资金落实(%)" style="width: 100%;"/>
</FormItem>
<FormItem label="招标代理" prop="tenderingAgent">
	<Input v-model="form.tenderingAgent" placeholder="请输入招标代理"/>
</FormItem>
<FormItem label="联系电话" prop="phone">
	<Input v-model="form.phone" placeholder="请输入联系电话"/>
</FormItem>
<FormItem label="要约价(元)" prop="offerPrice">
	<InputNumber v-model="form.offerPrice" placeholder="请输入要约价(元)" style="width: 100%;"/>
</FormItem>
<FormItem label="保证金(万元)" prop="assurePrice">
	<InputNumber v-model="form.assurePrice" placeholder="请输入保证金(万元)" style="width: 100%;"/>
</FormItem>
<FormItem label="工期(天)" prop="constructionPeriod">
	<InputNumber v-model="form.constructionPeriod" placeholder="请输入工期(天)" style="width: 100%;"/>
</FormItem>
<FormItem label="下载截止时间" prop="downloadEndTime">
	<DatePicker @on-change="form.downloadEndTime=$event" :value="form.downloadEndTime" placeholder="请输入下载截止时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="其他要求" prop="otherDemand">
	<Input v-model="form.otherDemand" placeholder="请输入其他要求"/>
</FormItem>
<FormItem label="开标信息" prop="openMarkInfo">
	<Input v-model="form.openMarkInfo" placeholder="请输入开标信息"/>
</FormItem>
<FormItem label="开标时间" prop="openMarkTime">
	<DatePicker @on-change="form.openMarkTime=$event" :value="form.openMarkTime" placeholder="请输入开标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="开标地点" prop="openMarkAddr">
	<Input v-model="form.openMarkAddr" placeholder="请输入开标地点"/>
</FormItem>
<FormItem label="开标状态" prop="markStatus">
	<Input v-model="form.markStatus" placeholder="请输入开标状态"/>
</FormItem>
<FormItem label="中标单位" prop="inMarkComp">
	<Input v-model="form.inMarkComp" placeholder="请输入中标单位"/>
</FormItem>
<FormItem label="公告时间" prop="noticeTime">
	<DatePicker @on-change="form.noticeTime=$event" :value="form.noticeTime" placeholder="请输入公告时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="点击次数" prop="clickCount">
	<InputNumber v-model="form.clickCount" placeholder="请输入点击次数" style="width: 100%;"/>
</FormItem>
<FormItem label="是否电子标" prop="isElectronic">
	<InputNumber v-model="form.isElectronic" placeholder="请输入是否电子标" style="width: 100%;"/>
</FormItem>
<FormItem label="源地址" prop="sourceUrl">
	<Input v-model="form.sourceUrl" placeholder="请输入源地址"/>
</FormItem>
<FormItem label="内部地址" prop="inwardHtmlUrl">
	<Input v-model="form.inwardHtmlUrl" placeholder="请输入内部地址"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="项目名称" prop="title">
	<Input v-model="form.title" placeholder="请输入项目名称"/>
</FormItem>
<FormItem label="项目类型" prop="projectType">
	<Input v-model="form.projectType" placeholder="请输入项目类型"/>
</FormItem>
<FormItem label="城市" prop="city">
	<Input v-model="form.city" placeholder="请输入城市"/>
</FormItem>
<FormItem label="项目详情" prop="projectDetail">
	<Input v-model="form.projectDetail" placeholder="请输入项目详情"/>
</FormItem>
<FormItem label="发布状态" prop="releaseStatus">
	<Input v-model="form.releaseStatus" placeholder="请输入发布状态"/>
</FormItem>
<FormItem label="招标单位名称" prop="markUnitName">
	<Input v-model="form.markUnitName" placeholder="请输入招标单位名称"/>
</FormItem>
<FormItem label="项目投资" prop="projectInvest">
	<Input v-model="form.projectInvest" placeholder="请输入项目投资"/>
</FormItem>
<FormItem label="审查方式" prop="checkPattern">
	<Input v-model="form.checkPattern" placeholder="请输入审查方式"/>
</FormItem>
<FormItem label="企业资质类型" prop="compAptitudeType">
	<Input v-model="form.compAptitudeType" placeholder="请输入企业资质类型"/>
</FormItem>
<FormItem label="建造师等级" prop="builderLevel">
	<Input v-model="form.builderLevel" placeholder="请输入建造师等级"/>
</FormItem>
<FormItem label="资金落实(%)" prop="moneyToImplement">
	<InputNumber v-model="form.moneyToImplement" placeholder="请输入资金落实(%)" style="width: 100%;"/>
</FormItem>
<FormItem label="招标代理" prop="tenderingAgent">
	<Input v-model="form.tenderingAgent" placeholder="请输入招标代理"/>
</FormItem>
<FormItem label="联系电话" prop="phone">
	<Input v-model="form.phone" placeholder="请输入联系电话"/>
</FormItem>
<FormItem label="要约价(元)" prop="offerPrice">
	<InputNumber v-model="form.offerPrice" placeholder="请输入要约价(元)" style="width: 100%;"/>
</FormItem>
<FormItem label="保证金(万元)" prop="assurePrice">
	<InputNumber v-model="form.assurePrice" placeholder="请输入保证金(万元)" style="width: 100%;"/>
</FormItem>
<FormItem label="工期(天)" prop="constructionPeriod">
	<InputNumber v-model="form.constructionPeriod" placeholder="请输入工期(天)" style="width: 100%;"/>
</FormItem>
<FormItem label="下载截止时间" prop="downloadEndTime">
	<DatePicker @on-change="form.downloadEndTime=$event" :value="form.downloadEndTime" placeholder="请输入下载截止时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="其他要求" prop="otherDemand">
	<Input v-model="form.otherDemand" placeholder="请输入其他要求"/>
</FormItem>
<FormItem label="开标信息" prop="openMarkInfo">
	<Input v-model="form.openMarkInfo" placeholder="请输入开标信息"/>
</FormItem>
<FormItem label="开标时间" prop="openMarkTime">
	<DatePicker @on-change="form.openMarkTime=$event" :value="form.openMarkTime" placeholder="请输入开标时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="开标地点" prop="openMarkAddr">
	<Input v-model="form.openMarkAddr" placeholder="请输入开标地点"/>
</FormItem>
<FormItem label="开标状态" prop="markStatus">
	<Input v-model="form.markStatus" placeholder="请输入开标状态"/>
</FormItem>
<FormItem label="中标单位" prop="inMarkComp">
	<Input v-model="form.inMarkComp" placeholder="请输入中标单位"/>
</FormItem>
<FormItem label="公告时间" prop="noticeTime">
	<DatePicker @on-change="form.noticeTime=$event" :value="form.noticeTime" placeholder="请输入公告时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="点击次数" prop="clickCount">
	<InputNumber v-model="form.clickCount" placeholder="请输入点击次数" style="width: 100%;"/>
</FormItem>
<FormItem label="是否电子标" prop="isElectronic">
	<InputNumber v-model="form.isElectronic" placeholder="请输入是否电子标" style="width: 100%;"/>
</FormItem>
<FormItem label="源地址" prop="sourceUrl">
	<Input v-model="form.sourceUrl" placeholder="请输入源地址"/>
</FormItem>
<FormItem label="内部地址" prop="inwardHtmlUrl">
	<Input v-model="form.inwardHtmlUrl" placeholder="请输入内部地址"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="招投标项目编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始招投标项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束招投标项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目名称" prop="title">
	<Input v-model="searchForm.title" placeholder="请输入项目名称"/>
</FormItem>
<FormItem label="项目类型" prop="projectType">
	<Input v-model="searchForm.projectType" placeholder="请输入项目类型"/>
</FormItem>
<FormItem label="城市" prop="city">
	<Input v-model="searchForm.city" placeholder="请输入城市"/>
</FormItem>
<FormItem label="项目详情" prop="projectDetail">
	<Input v-model="searchForm.projectDetail" placeholder="请输入项目详情"/>
</FormItem>
<FormItem label="发布状态" prop="releaseStatus">
	<Input v-model="searchForm.releaseStatus" placeholder="请输入发布状态"/>
</FormItem>
<FormItem label="招标单位名称" prop="markUnitName">
	<Input v-model="searchForm.markUnitName" placeholder="请输入招标单位名称"/>
</FormItem>
<FormItem label="项目投资" prop="projectInvest">
	<Input v-model="searchForm.projectInvest" placeholder="请输入项目投资"/>
</FormItem>
<FormItem label="审查方式" prop="checkPattern">
	<Input v-model="searchForm.checkPattern" placeholder="请输入审查方式"/>
</FormItem>
<FormItem label="企业资质类型" prop="compAptitudeType">
	<Input v-model="searchForm.compAptitudeType" placeholder="请输入企业资质类型"/>
</FormItem>
<FormItem label="建造师等级" prop="builderLevel">
	<Input v-model="searchForm.builderLevel" placeholder="请输入建造师等级"/>
</FormItem>
<FormItem label="资金落实(%)"><Row>
	<i-col span="11">
	<FormItem prop="moneyToImplementMin">
	<InputNumber v-model="searchForm.moneyToImplementMin" placeholder="请输入开始资金落实(%)" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="moneyToImplementMax">
	<InputNumber v-model="searchForm.moneyToImplementMax" placeholder="请输入结束资金落实(%)" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="招标代理" prop="tenderingAgent">
	<Input v-model="searchForm.tenderingAgent" placeholder="请输入招标代理"/>
</FormItem>
<FormItem label="联系电话" prop="phone">
	<Input v-model="searchForm.phone" placeholder="请输入联系电话"/>
</FormItem>
<FormItem label="要约价(元)"><Row>
	<i-col span="11">
	<FormItem prop="offerPriceMin">
	<InputNumber v-model="searchForm.offerPriceMin" placeholder="请输入开始要约价(元)" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="offerPriceMax">
	<InputNumber v-model="searchForm.offerPriceMax" placeholder="请输入结束要约价(元)" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="保证金(万元)"><Row>
	<i-col span="11">
	<FormItem prop="assurePriceMin">
	<InputNumber v-model="searchForm.assurePriceMin" placeholder="请输入开始保证金(万元)" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="assurePriceMax">
	<InputNumber v-model="searchForm.assurePriceMax" placeholder="请输入结束保证金(万元)" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
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
<FormItem label="下载截止时间"><Row>
	<i-col span="11">
	<FormItem prop="downloadEndTimeMin">
	<DatePicker @on-change="searchForm.downloadEndTimeMin=$event" :value="searchForm.downloadEndTimeMin" placeholder="请输入开始下载截止时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="downloadEndTimeMax">
	<DatePicker @on-change="searchForm.downloadEndTimeMax=$event" :value="searchForm.downloadEndTimeMax" placeholder="请输入结束下载截止时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="其他要求" prop="otherDemand">
	<Input v-model="searchForm.otherDemand" placeholder="请输入其他要求"/>
</FormItem>
<FormItem label="开标信息" prop="openMarkInfo">
	<Input v-model="searchForm.openMarkInfo" placeholder="请输入开标信息"/>
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
<FormItem label="开标地点" prop="openMarkAddr">
	<Input v-model="searchForm.openMarkAddr" placeholder="请输入开标地点"/>
</FormItem>
<FormItem label="开标状态" prop="markStatus">
	<Input v-model="searchForm.markStatus" placeholder="请输入开标状态"/>
</FormItem>
<FormItem label="中标单位" prop="inMarkComp">
	<Input v-model="searchForm.inMarkComp" placeholder="请输入中标单位"/>
</FormItem>
<FormItem label="公告时间"><Row>
	<i-col span="11">
	<FormItem prop="noticeTimeMin">
	<DatePicker @on-change="searchForm.noticeTimeMin=$event" :value="searchForm.noticeTimeMin" placeholder="请输入开始公告时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="noticeTimeMax">
	<DatePicker @on-change="searchForm.noticeTimeMax=$event" :value="searchForm.noticeTimeMax" placeholder="请输入结束公告时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="点击次数"><Row>
	<i-col span="11">
	<FormItem prop="clickCountMin">
	<InputNumber v-model="searchForm.clickCountMin" placeholder="请输入开始点击次数" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="clickCountMax">
	<InputNumber v-model="searchForm.clickCountMax" placeholder="请输入结束点击次数" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否电子标"><Row>
	<i-col span="11">
	<FormItem prop="isElectronicMin">
	<InputNumber v-model="searchForm.isElectronicMin" placeholder="请输入开始是否电子标" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isElectronicMax">
	<InputNumber v-model="searchForm.isElectronicMax" placeholder="请输入结束是否电子标" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="源地址" prop="sourceUrl">
	<Input v-model="searchForm.sourceUrl" placeholder="请输入源地址"/>
</FormItem>
<FormItem label="内部地址" prop="inwardHtmlUrl">
	<Input v-model="searchForm.inwardHtmlUrl" placeholder="请输入内部地址"/>
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
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <p>招投标项目编号: <span v-text="form.id"></span></p>
<p>项目名称: <span v-text="form.title"></span></p>
<p>项目类型: <span v-text="form.projectType"></span></p>
<p>城市: <span v-text="form.city"></span></p>
<p>项目详情: <span v-text="form.projectDetail"></span></p>
<p>发布状态: <span v-text="form.releaseStatus"></span></p>
<p>招标单位名称: <span v-text="form.markUnitName"></span></p>
<p>项目投资: <span v-text="form.projectInvest"></span></p>
<p>审查方式: <span v-text="form.checkPattern"></span></p>
<p>企业资质类型: <span v-text="form.compAptitudeType"></span></p>
<p>建造师等级: <span v-text="form.builderLevel"></span></p>
<p>资金落实(%): <span v-text="form.moneyToImplement"></span></p>
<p>招标代理: <span v-text="form.tenderingAgent"></span></p>
<p>联系电话: <span v-text="form.phone"></span></p>
<p>要约价(元): <span v-text="form.offerPrice"></span></p>
<p>保证金(万元): <span v-text="form.assurePrice"></span></p>
<p>工期(天): <span v-text="form.constructionPeriod"></span></p>
<p>下载截止时间: <span v-text="form.downloadEndTime"></span></p>
<p>其他要求: <span v-text="form.otherDemand"></span></p>
<p>开标信息: <span v-text="form.openMarkInfo"></span></p>
<p>开标时间: <span v-text="form.openMarkTime"></span></p>
<p>开标地点: <span v-text="form.openMarkAddr"></span></p>
<p>开标状态: <span v-text="form.markStatus"></span></p>
<p>中标单位: <span v-text="form.inMarkComp"></span></p>
<p>公告时间: <span v-text="form.noticeTime"></span></p>
<p>点击次数: <span v-text="form.clickCount"></span></p>
<p>是否电子标: <span v-text="form.isElectronic"></span></p>
<p>源地址: <span v-text="form.sourceUrl"></span></p>
<p>内部地址: <span v-text="form.inwardHtmlUrl"></span></p>
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
    name: 'Project',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        loading: {
          add: false,
          edit: false,
          search: false
        },
        urls: {
          addUrl: '/project/admin/save',
          batchAddUrl: '/project/admin/batch-save',
          editUrl: '/project/admin/update',
          batchEditUrl: '/project/admin/batch-update',
          searchUrl: '/project/admin/pager-cond',
          allUrl: '/project/admin/all',
          removeUrl: '/project/admin/remove/',
          batchRemoveUrl: '/project/admin/batch-remove',
          detailUrl: '/project/admin/one/',
          activeUrl: '/project/admin/active',
          batchActiveUrl: '/project/admin/batch-active'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
title: null,
projectType: null,
city: null,
projectDetail: null,
releaseStatus: null,
markUnitName: null,
projectInvest: null,
checkPattern: null,
compAptitudeType: null,
builderLevel: null,
moneyToImplement: null,
tenderingAgent: null,
phone: null,
offerPrice: null,
assurePrice: null,
constructionPeriod: null,
downloadEndTime: null,
otherDemand: null,
openMarkInfo: null,
openMarkTime: null,
openMarkAddr: null,
markStatus: null,
inMarkComp: null,
noticeTime: null,
clickCount: null,
isElectronic: null,
sourceUrl: null,
inwardHtmlUrl: null,
version: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        validateRules: {
          title: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
],
projectType: [
{type: 'string', min: 1, max: 10, message: '必须1-10个字符', trigger: 'blur'}
],
city: [
{type: 'string', min: 1, max: 10, message: '必须1-10个字符', trigger: 'blur'}
],
projectDetail: [
{type: 'string', min: 1, max: 65535, message: '必须1-65535个字符', trigger: 'blur'}
],
releaseStatus: [
{type: 'string', min: 1, max: 10, message: '必须1-10个字符', trigger: 'blur'}
],
markUnitName: [
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
],
projectInvest: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
checkPattern: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
compAptitudeType: [
{type: 'string', min: 1, max: 200, message: '必须1-200个字符', trigger: 'blur'}
],
builderLevel: [
{type: 'string', min: 1, max: 200, message: '必须1-200个字符', trigger: 'blur'}
],
tenderingAgent: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
phone: [
{type: 'string', min: 1, max: 11, message: '必须1-11个字符', trigger: 'blur'}
],
otherDemand: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
openMarkInfo: [
{type: 'string', min: 1, max: 10, message: '必须1-10个字符', trigger: 'blur'}
],
openMarkAddr: [
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
],
markStatus: [
{type: 'string', min: 1, max: 10, message: '必须1-10个字符', trigger: 'blur'}
],
inMarkComp: [
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
],
sourceUrl: [
{type: 'string', min: 1, max: 300, message: '必须1-300个字符', trigger: 'blur'}
],
inwardHtmlUrl: [
{type: 'string', min: 1, max: 300, message: '必须1-300个字符', trigger: 'blur'}
],

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          id: null,
idMin: null, 
idMax: null, 
title: null,
projectType: null,
city: null,
projectDetail: null,
releaseStatus: null,
markUnitName: null,
projectInvest: null,
checkPattern: null,
compAptitudeType: null,
builderLevel: null,
moneyToImplement: null,
moneyToImplementMin: null, 
moneyToImplementMax: null, 
tenderingAgent: null,
phone: null,
offerPrice: null,
offerPriceMin: null, 
offerPriceMax: null, 
assurePrice: null,
assurePriceMin: null, 
assurePriceMax: null, 
constructionPeriod: null,
constructionPeriodMin: null, 
constructionPeriodMax: null, 
downloadEndTime: null,
downloadEndTimeMin: null, 
downloadEndTimeMax: null, 
otherDemand: null,
openMarkInfo: null,
openMarkTime: null,
openMarkTimeMin: null, 
openMarkTimeMax: null, 
openMarkAddr: null,
markStatus: null,
inMarkComp: null,
noticeTime: null,
noticeTimeMin: null, 
noticeTimeMax: null, 
clickCount: null,
clickCountMin: null, 
clickCountMax: null, 
isElectronic: null,
isElectronicMin: null, 
isElectronicMax: null, 
sourceUrl: null,
inwardHtmlUrl: null,
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
title: '招投标项目编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '项目名称',
key: 'title',
minWidth: 120,
sortable: true
},
{
title: '项目类型',
key: 'projectType',
minWidth: 120,
sortable: true
},
{
title: '城市',
key: 'city',
minWidth: 120,
sortable: true
},
{
title: '项目详情',
key: 'projectDetail',
minWidth: 120,
sortable: true
},
{
title: '发布状态',
key: 'releaseStatus',
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
title: '项目投资',
key: 'projectInvest',
minWidth: 120,
sortable: true
},
{
title: '审查方式',
key: 'checkPattern',
minWidth: 120,
sortable: true
},
{
title: '企业资质类型',
key: 'compAptitudeType',
minWidth: 120,
sortable: true
},
{
title: '建造师等级',
key: 'builderLevel',
minWidth: 120,
sortable: true
},
{
title: '资金落实(%)',
key: 'moneyToImplement',
minWidth: 120,
sortable: true
},
{
title: '招标代理',
key: 'tenderingAgent',
minWidth: 120,
sortable: true
},
{
title: '联系电话',
key: 'phone',
minWidth: 120,
sortable: true
},
{
title: '要约价(元)',
key: 'offerPrice',
minWidth: 120,
sortable: true
},
{
title: '保证金(万元)',
key: 'assurePrice',
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
title: '下载截止时间',
key: 'downloadEndTime',
minWidth: 120,
sortable: true
},
{
title: '其他要求',
key: 'otherDemand',
minWidth: 120,
sortable: true
},
{
title: '开标信息',
key: 'openMarkInfo',
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
title: '开标地点',
key: 'openMarkAddr',
minWidth: 120,
sortable: true
},
{
title: '开标状态',
key: 'markStatus',
minWidth: 120,
sortable: true
},
{
title: '中标单位',
key: 'inMarkComp',
minWidth: 120,
sortable: true
},
{
title: '公告时间',
key: 'noticeTime',
minWidth: 120,
sortable: true
},
{
title: '点击次数',
key: 'clickCount',
minWidth: 120,
sortable: true
},
{
title: '是否电子标',
key: 'isElectronic',
minWidth: 120,
sortable: true
},
{
title: '源地址',
key: 'sourceUrl',
minWidth: 120,
sortable: true
},
{
title: '内部地址',
key: 'inwardHtmlUrl',
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
                      slot:"list"
                    },[
                      h('DropdownItem', {
                        props:{
                          name: 'showEdit'
                        }
                      }, '编辑'),
                      h('DropdownItem', {
                        props:{
                          name: 'showDetail'
                        }
                      }, '详情'),
                      h('DropdownItem', {
                        props:{
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
        }
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
      }
    }
  }
</script>

<style>
</style>
