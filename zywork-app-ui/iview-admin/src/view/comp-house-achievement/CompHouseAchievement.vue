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
          <Button @click="crawlData" type="primary">爬取数据</Button>&nbsp;
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
		<Modal v-model="modal.add" title="添加" width="900" @on-visible-change="changeModalVisibleResetForm('addForm', $event)">
			<Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
				<Row>
					<i-col span="12">
						<FormItem label="企业编号" prop="compId">
							<span v-text="form.compId"></span>
							&nbsp;
							<Button @click="showModal('companyChoice')" type="text">选择企业</Button>&nbsp;
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="工程名称" prop="projectName">
							<Input v-model="form.projectName" placeholder="请输入工程名称" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="注册建造师" prop="builderName">
							<Input v-model="form.builderName" placeholder="请输入注册建造师" />
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="中标日期" prop="markDate">
							<DatePicker @on-change="form.markDate=$event" :value="form.markDate" placeholder="请输入中标日期" type="datetime" format="yyyy-MM-dd HH:mm:ss"
							 style="width: 100%;"></DatePicker>
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="中标金额" prop="markMoneyDisplay">
							<Input v-model="form.markMoneyDisplay" placeholder="请输入中标金额" />
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="建设规模" prop="buildScale">
							<Input v-model="form.buildScale" placeholder="请输入建设规模" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="项目所属地区归类" prop="regionType">
							<Cascader
							  :data="cityData"
							  v-model="regionType"
							  trigger="hover"
							  change-on-select
							  filterable
							  clearable
							/>
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="建设单位" prop="buildComp">
							<Input v-model="form.buildComp" placeholder="请输入建设单位" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="工程地址" prop="projectAddr">
							<Cascader
							  :data="cityData"
							  v-model="projectAddr"
							  trigger="hover"
							  change-on-select
							  filterable
							  clearable
							/>
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="合同签订日期" prop="contractDate">
							<DatePicker @on-change="form.contractDate=$event" :value="form.contractDate" placeholder="请输入合同签订日期" type="datetime"
							 format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="项目负责人" prop="name">
							<Input v-model="form.name" placeholder="请输入项目负责人" />
						</FormItem>
					</i-col>
					</i-col>
					<i-col span="12">
						<FormItem label="项目负责人证书号" prop="certificateNum">
							<Input v-model="form.certificateNum" placeholder="请输入项目负责人证书号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="施工员" prop="constructors">
							<Input v-model="form.constructors" placeholder="请输入施工员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="施工员证书号" prop="constructorsCertificateNum">
							<Input v-model="form.constructorsCertificateNum" placeholder="请输入施工员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="施工员身份证号" prop="constructorsIdNum">
							<Input v-model="form.constructorsIdNum" placeholder="请输入施工员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="质量员" prop="qualityWorker">
							<Input v-model="form.qualityWorker" placeholder="请输入质量员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="质量员证书号" prop="qualityWorkerCertificateNum">
							<Input v-model="form.qualityWorkerCertificateNum" placeholder="请输入质量员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="质量员身份证号" prop="qualityWorkerIdNum">
							<Input v-model="form.qualityWorkerIdNum" placeholder="请输入质量员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="安全员" prop="securityOfficer">
							<Input v-model="form.securityOfficer" placeholder="请输入安全员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="安全员证书号" prop="securityOfficerCertificateNum">
							<Input v-model="form.securityOfficerCertificateNum" placeholder="请输入安全员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="安全员身份证号" prop="securityOfficerIdNum">
							<Input v-model="form.securityOfficerIdNum" placeholder="请输入安全员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="标准员" prop="standardWorker">
							<Input v-model="form.standardWorker" placeholder="请输入标准员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="标准员证书号" prop="standardWorkerCertificateNum">
							<Input v-model="form.standardWorkerCertificateNum" placeholder="请输入标准员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="标准员身份证号" prop="standardWorkerIdNum">
							<Input v-model="form.standardWorkerIdNum" placeholder="请输入标准员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="材料员" prop="materialMan">
							<Input v-model="form.materialMan" placeholder="请输入材料员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="材料员证书号" prop="materialManCertificateNum">
							<Input v-model="form.materialManCertificateNum" placeholder="请输入材料员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="材料员身份证号" prop="materialManIdNum">
							<Input v-model="form.materialManIdNum" placeholder="请输入材料员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="机械员" prop="mechanic">
							<Input v-model="form.mechanic" placeholder="请输入机械员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="机械员证书号" prop="mechanicCertificateNum">
							<Input v-model="form.mechanicCertificateNum" placeholder="请输入机械员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="机械员身份证号" prop="mechanicIdNum">
							<Input v-model="form.mechanicIdNum" placeholder="请输入机械员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="劳务员" prop="labors">
							<Input v-model="form.labors" placeholder="请输入劳务员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="劳务员证书号" prop="laborsCertificateNum">
							<Input v-model="form.laborsCertificateNum" placeholder="请输入劳务员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="劳务员身份证号" prop="laborsIdNum">
							<Input v-model="form.laborsIdNum" placeholder="请输入劳务员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="资料员" prop="dataClerk">
							<Input v-model="form.dataClerk" placeholder="请输入资料员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="资料员证书号" prop="dataClerkCertificateNum">
							<Input v-model="form.dataClerkCertificateNum" placeholder="请输入资料员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="资料员身份证号" prop="dataClerkIdNum">
							<Input v-model="form.dataClerkIdNum" placeholder="请输入资料员身份证号" />
						</FormItem>
					</i-col>
				</Row>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
				<Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
			</div>
		</Modal>
		
		<Modal v-model="modal.edit" title="修改" width="900" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
			<Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
				<Row>
					<i-col span="12">
						<FormItem label="企业编号" prop="compId">
							<span v-text="form.compId"></span>
							&nbsp;
							<Button @click="showModal('companyChoice')" type="text">选择企业</Button>&nbsp;
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="工程名称" prop="projectName">
							<Input v-model="form.projectName" placeholder="请输入工程名称" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="注册建造师" prop="builderName">
							<Input v-model="form.builderName" placeholder="请输入注册建造师" />
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="中标日期" prop="markDate">
							<DatePicker @on-change="form.markDate=$event" :value="form.markDate" placeholder="请输入中标日期" type="datetime" format="yyyy-MM-dd HH:mm:ss"
							 style="width: 100%;"></DatePicker>
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="中标金额" prop="markMoneyDisplay">
							<Input v-model="form.markMoneyDisplay" placeholder="请输入中标金额" />
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="建设规模" prop="buildScale">
							<Input v-model="form.buildScale" placeholder="请输入建设规模" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="项目所属地区归类" prop="regionType">
							<Cascader
							  :data="cityData"
							  v-model="regionType"
							  trigger="hover"
							  change-on-select
							  filterable
							  clearable
							/>
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="建设单位" prop="buildComp">
							<Input v-model="form.buildComp" placeholder="请输入建设单位" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="工程地址" prop="projectAddr">
							<Cascader
							  :data="cityData"
							  v-model="projectAddr"
							  trigger="hover"
							  change-on-select
							  filterable
							  clearable
							/>
						</FormItem>
					</i-col>
					<i-col span="12">
						<FormItem label="合同签订日期" prop="contractDate">
							<DatePicker @on-change="form.contractDate=$event" :value="form.contractDate" placeholder="请输入合同签订日期" type="datetime"
							 format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="12">
						<FormItem label="项目负责人" prop="name">
							<Input v-model="form.name" placeholder="请输入项目负责人" />
						</FormItem>
					</i-col>
					</i-col>
					<i-col span="12">
						<FormItem label="项目负责人证书号" prop="certificateNum">
							<Input v-model="form.certificateNum" placeholder="请输入项目负责人证书号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="施工员" prop="constructors">
							<Input v-model="form.constructors" placeholder="请输入施工员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="施工员证书号" prop="constructorsCertificateNum">
							<Input v-model="form.constructorsCertificateNum" placeholder="请输入施工员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="施工员身份证号" prop="constructorsIdNum">
							<Input v-model="form.constructorsIdNum" placeholder="请输入施工员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="质量员" prop="qualityWorker">
							<Input v-model="form.qualityWorker" placeholder="请输入质量员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="质量员证书号" prop="qualityWorkerCertificateNum">
							<Input v-model="form.qualityWorkerCertificateNum" placeholder="请输入质量员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="质量员身份证号" prop="qualityWorkerIdNum">
							<Input v-model="form.qualityWorkerIdNum" placeholder="请输入质量员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="安全员" prop="securityOfficer">
							<Input v-model="form.securityOfficer" placeholder="请输入安全员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="安全员证书号" prop="securityOfficerCertificateNum">
							<Input v-model="form.securityOfficerCertificateNum" placeholder="请输入安全员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="安全员身份证号" prop="securityOfficerIdNum">
							<Input v-model="form.securityOfficerIdNum" placeholder="请输入安全员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="标准员" prop="standardWorker">
							<Input v-model="form.standardWorker" placeholder="请输入标准员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="标准员证书号" prop="standardWorkerCertificateNum">
							<Input v-model="form.standardWorkerCertificateNum" placeholder="请输入标准员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="标准员身份证号" prop="standardWorkerIdNum">
							<Input v-model="form.standardWorkerIdNum" placeholder="请输入标准员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="材料员" prop="materialMan">
							<Input v-model="form.materialMan" placeholder="请输入材料员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="材料员证书号" prop="materialManCertificateNum">
							<Input v-model="form.materialManCertificateNum" placeholder="请输入材料员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="材料员身份证号" prop="materialManIdNum">
							<Input v-model="form.materialManIdNum" placeholder="请输入材料员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="机械员" prop="mechanic">
							<Input v-model="form.mechanic" placeholder="请输入机械员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="机械员证书号" prop="mechanicCertificateNum">
							<Input v-model="form.mechanicCertificateNum" placeholder="请输入机械员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="机械员身份证号" prop="mechanicIdNum">
							<Input v-model="form.mechanicIdNum" placeholder="请输入机械员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="劳务员" prop="labors">
							<Input v-model="form.labors" placeholder="请输入劳务员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="劳务员证书号" prop="laborsCertificateNum">
							<Input v-model="form.laborsCertificateNum" placeholder="请输入劳务员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="劳务员身份证号" prop="laborsIdNum">
							<Input v-model="form.laborsIdNum" placeholder="请输入劳务员身份证号" />
						</FormItem>
					</i-col>
				</Row>
				<Row>
					<i-col span="8">
						<FormItem label="资料员" prop="dataClerk">
							<Input v-model="form.dataClerk" placeholder="请输入资料员" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="资料员证书号" prop="dataClerkCertificateNum">
							<Input v-model="form.dataClerkCertificateNum" placeholder="请输入资料员证书号" />
						</FormItem>
					</i-col>
					<i-col span="8">
						<FormItem label="资料员身份证号" prop="dataClerkIdNum">
							<Input v-model="form.dataClerkIdNum" placeholder="请输入资料员身份证号" />
						</FormItem>
					</i-col>
				</Row>
			</Form>
			<div slot="footer">
				<Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
				<Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
			</div>
		</Modal>
		<Modal v-model="modal.search" title="高级搜索">
			<Form ref="searchForm" :model="searchForm" :label-width="80">
				<FormItem label="企业房建业绩编号">
					<Row>
						<i-col span="11">
							<FormItem prop="idMin">
								<InputNumber v-model="searchForm.idMin" placeholder="请输入开始企业房建业绩编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="idMax">
								<InputNumber v-model="searchForm.idMax" placeholder="请输入结束企业房建业绩编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="企业编号">
					<Row>
						<i-col span="11">
							<FormItem prop="compIdMin">
								<InputNumber v-model="searchForm.compIdMin" placeholder="请输入开始企业编号" style="width: 100%;" />
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="compIdMax">
								<InputNumber v-model="searchForm.compIdMax" placeholder="请输入结束企业编号" style="width: 100%;" />
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="工程名称" prop="projectName">
					<Input v-model="searchForm.projectName" placeholder="请输入工程名称" />
				</FormItem>
				<FormItem label="注册建造师" prop="builderName">
					<Input v-model="searchForm.builderName" placeholder="请输入注册建造师" />
				</FormItem>
				<FormItem label="中标金额" prop="markMoney">
					<Input v-model="searchForm.markMoney" placeholder="请输入中标金额" />
				</FormItem>
				<FormItem label="建设规模" prop="buildScale">
					<Input v-model="searchForm.buildScale" placeholder="请输入建设规模" />
				</FormItem>
				<FormItem label="项目所属地区归类" prop="regionType">
					<Input v-model="searchForm.regionType" placeholder="请输入项目所属地区归类" />
				</FormItem>
				<FormItem label="建设单位" prop="buildComp">
					<Input v-model="searchForm.buildComp" placeholder="请输入建设单位" />
				</FormItem>
        <FormItem label="中标单位" prop="markComp">
					<Input v-model="searchForm.markomp" placeholder="请输入中标单位" />
				</FormItem>
				<FormItem label="工程地址" prop="projectAddr">
					<Input v-model="searchForm.projectAddr" placeholder="请输入工程地址" />
				</FormItem>
				<FormItem label="合同签订日期">
					<Row>
						<i-col span="11">
							<FormItem prop="contractDateMin">
								<DatePicker @on-change="searchForm.contractDateMin=$event" :value="searchForm.contractDateMin" placeholder="请输入开始合同签订日期"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="contractDateMax">
								<DatePicker @on-change="searchForm.contractDateMax=$event" :value="searchForm.contractDateMax" placeholder="请输入结束合同签订日期"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="中标日期">
					<Row>
						<i-col span="11">
							<FormItem prop="markDateMin">
								<DatePicker @on-change="searchForm.markDateMin=$event" :value="searchForm.markDateMin" placeholder="请输入开始中标日期"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
						<i-col span="2" style="text-align: center">-</i-col>
						<i-col span="11">
							<FormItem prop="markDateMax">
								<DatePicker @on-change="searchForm.markDateMax=$event" :value="searchForm.markDateMax" placeholder="请输入结束中标日期"
								 type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
							</FormItem>
						</i-col>
					</Row>
				</FormItem>
				<FormItem label="项目负责人" prop="name">
					<Input v-model="searchForm.name" placeholder="请输入项目负责人" />
				</FormItem>
				<FormItem label="项目负责人证书号" prop="certificateNum">
					<Input v-model="searchForm.certificateNum" placeholder="请输入项目负责人证书号" />
				</FormItem>
				<FormItem label="施工员" prop="constructors">
					<Input v-model="searchForm.constructors" placeholder="请输入施工员" />
				</FormItem>
				<FormItem label="施工员证书号" prop="constructorsCertificateNum">
					<Input v-model="searchForm.constructorsCertificateNum" placeholder="请输入施工员证书号" />
				</FormItem>
				<FormItem label="施工员身份证号" prop="constructorsIdNum">
					<Input v-model="searchForm.constructorsIdNum" placeholder="请输入施工员身份证号" />
				</FormItem>
				<FormItem label="质量员" prop="qualityWorker">
					<Input v-model="searchForm.qualityWorker" placeholder="请输入质量员" />
				</FormItem>
				<FormItem label="质量员证书号" prop="qualityWorkerCertificateNum">
					<Input v-model="searchForm.qualityWorkerCertificateNum" placeholder="请输入质量员证书号" />
				</FormItem>
				<FormItem label="质量员身份证号" prop="qualityWorkerIdNum">
					<Input v-model="searchForm.qualityWorkerIdNum" placeholder="请输入质量员身份证号" />
				</FormItem>
				<FormItem label="安全员" prop="securityOfficer">
					<Input v-model="searchForm.securityOfficer" placeholder="请输入安全员" />
				</FormItem>
				<FormItem label="安全员证书号" prop="securityOfficerCertificateNum">
					<Input v-model="searchForm.securityOfficerCertificateNum" placeholder="请输入安全员证书号" />
				</FormItem>
				<FormItem label="安全员身份证号" prop="securityOfficerIdNum">
					<Input v-model="searchForm.securityOfficerIdNum" placeholder="请输入安全员身份证号" />
				</FormItem>
				<FormItem label="标准员" prop="standardWorker">
					<Input v-model="searchForm.standardWorker" placeholder="请输入标准员" />
				</FormItem>
				<FormItem label="标准员证书号" prop="standardWorkerCertificateNum">
					<Input v-model="searchForm.standardWorkerCertificateNum" placeholder="请输入标准员证书号" />
				</FormItem>
				<FormItem label="标准员身份证号" prop="standardWorkerIdNum">
					<Input v-model="searchForm.standardWorkerIdNum" placeholder="请输入标准员身份证号" />
				</FormItem>
				<FormItem label="材料员" prop="materialMan">
					<Input v-model="searchForm.materialMan" placeholder="请输入材料员" />
				</FormItem>
				<FormItem label="材料员证书号" prop="materialManCertificateNum">
					<Input v-model="searchForm.materialManCertificateNum" placeholder="请输入材料员证书号" />
				</FormItem>
				<FormItem label="材料员身份证号" prop="materialManIdNum">
					<Input v-model="searchForm.materialManIdNum" placeholder="请输入材料员身份证号" />
				</FormItem>
				<FormItem label="机械员" prop="mechanic">
					<Input v-model="searchForm.mechanic" placeholder="请输入机械员" />
				</FormItem>
				<FormItem label="机械员证书号" prop="mechanicCertificateNum">
					<Input v-model="searchForm.mechanicCertificateNum" placeholder="请输入机械员证书号" />
				</FormItem>
				<FormItem label="机械员身份证号" prop="mechanicIdNum">
					<Input v-model="searchForm.mechanicIdNum" placeholder="请输入机械员身份证号" />
				</FormItem>
				<FormItem label="劳务员" prop="labors">
					<Input v-model="searchForm.labors" placeholder="请输入劳务员" />
				</FormItem>
				<FormItem label="劳务员证书号" prop="laborsCertificateNum">
					<Input v-model="searchForm.laborsCertificateNum" placeholder="请输入劳务员证书号" />
				</FormItem>
				<FormItem label="劳务员身份证号" prop="laborsIdNum">
					<Input v-model="searchForm.laborsIdNum" placeholder="请输入劳务员身份证号" />
				</FormItem>
				<FormItem label="资料员" prop="dataClerk">
					<Input v-model="searchForm.dataClerk" placeholder="请输入资料员" />
				</FormItem>
				<FormItem label="资料员证书号" prop="dataClerkCertificateNum">
					<Input v-model="searchForm.dataClerkCertificateNum" placeholder="请输入资料员证书号" />
				</FormItem>
				<FormItem label="资料员身份证号" prop="dataClerkIdNum">
					<Input v-model="searchForm.dataClerkIdNum" placeholder="请输入资料员身份证号" />
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
			<p>企业房建业绩编号: <span v-text="form.id"></span></p>
			<p>企业编号: <span v-text="form.compId"></span></p>
			<p>工程名称: <span v-text="form.projectName"></span></p>
			<p>注册建造师: <span v-text="form.builderName"></span></p>
			<p>中标金额: <span v-text="form.markMoney/100"></span></p>
			<p>建设规模: <span v-text="form.buildScale"></span></p>
			<p>项目所属地区归类: <span v-text="form.regionType"></span></p>
			<p>建设单位: <span v-text="form.buildComp"></span></p>
      <p>中标单位: <span v-text="form.markComp"></span></p>
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
		
		<Modal :transfer="false" v-model="modal.companyDetail" title="企业详情">
		  <CompanyDetail :form="companyDetailForm" />
		</Modal>
		
		<Modal
		  :transfer="false"
		  fullscreen
		  v-model="modal.companyChoice"
		  title="搜索主表信息">
		  <company-list-single ref="CompanyListSingle" v-on:confirmSelection="confirmSelection"/>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('companyChoice')">取消</Button>
		    <Button type="primary" size="large" @click="confirm">确认选择</Button>
		  </div>
		</Modal>
	</div>
</template>

<script>
	import * as utils from '@/api/utils'
	import city from '@/api/city.json'
	import {getCompanyById} from '@/api/module'
	import CompanyDetail from '@/view/company/CompanyDetail.vue'
  import CompanyListSingle from '@/view/company/CompanyListSingle.vue'
  import axios from '@/libs/api.request'
  import * as ResponseStatus from '@/api/response-status'

	export default {
		name: 'CompHouseAchievement',
		components: {
			CompanyListSingle,
			CompanyDetail
		},
		data() {
			return {
				projectAddr: [],
				regionType: [],
				cityData: city,
				modal: {
					add: false,
					edit: false,
					search: false,
					detail: false,
					companyChoice: false,
					operate: ''
				},
				loading: {
					add: false,
					edit: false,
					search: false
				},
				urls: {
					addUrl: '/comp-house-achievement/admin/save',
					batchAddUrl: '/comp-house-achievement/admin/batch-save',
					editUrl: '/comp-house-achievement/admin/update',
					batchEditUrl: '/comp-house-achievement/admin/batch-update',
					searchUrl: '/comp-house-achievement/admin/pager-cond',
					allUrl: '/comp-house-achievement/admin/all',
					removeUrl: '/comp-house-achievement/admin/remove/',
					batchRemoveUrl: '/comp-house-achievement/admin/batch-remove',
					detailUrl: '/comp-house-achievement/admin/one/',
					activeUrl: '/comp-house-achievement/admin/active',
          batchActiveUrl: '/comp-house-achievement/admin/batch-active',
          pythonUpdateDataUrl: '/comp-house-achievement/admin/python'
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
					markMoneyDisplay: null,
					buildScale: null,
					regionType: null,
          buildComp: null,
          markComp: null,
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
				companyDetailForm: {
					id: null,
					jurisdictionType: null,
					city: null,
					compType: null,
					industryType: null,
					compName: null,
					legalPerson: null,
					legalPersonPhone: null,
					regAddress: null,
					responsible: null,
					responsiblePhone: null,
					compPhone: null,
					compAddr: null,
					regCapital: null,
					businessScope: null,
					affordableBusiness: null,
					version: null,
					createTime: null,
					updateTime: null,
					isActive: null,
				},
				validateRules: {
					compId: [{
						type: 'integer',
						required: true,
						message: '此项为必须项',
						trigger: 'blur, change'
					}],
					projectName: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					builderName: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					markMoney: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					buildScale: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					regionType: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					buildComp: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					projectAddr: [{
						type: 'string',
						min: 1,
						max: 32,
						message: '必须1-32个字符',
						trigger: 'blur'
					}],
					name: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					certificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					constructors: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					constructorsCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					constructorsIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					qualityWorker: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					qualityWorkerCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					qualityWorkerIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					securityOfficer: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					securityOfficerCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					securityOfficerIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					standardWorker: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					standardWorkerCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					standardWorkerIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					materialMan: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					materialManCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					materialManIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					mechanic: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					mechanicCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					mechanicIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					labors: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					laborsCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					laborsIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					dataClerk: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					dataClerkCertificateNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
					}],
					dataClerkIdNum: [{
						type: 'string',
						min: 1,
						max: 20,
						message: '必须1-20个字符',
						trigger: 'blur'
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
					compId: null,
					compIdMin: null,
					compIdMax: null,
					projectName: null,
					builderName: null,
					markMoney: null,
					buildScale: null,
					regionType: null,
          buildComp: null,
          markComp: null,
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
							title: '企业房建业绩编号',
							key: 'id',
							minWidth: 160,
							sortable: true
						},
						{
							title: '企业编号',
							key: 'compId',
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
							      h(
							        'span',
							        [
							          params.row.compId,
							          h('Icon', {
							            props: {
							              type: 'ios-list',
							              size: '25'
							            }
							          })
							        ]
							      ),
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
							sortable: true,
							render: (h, params) => {
								let text = params.row.markMoney/100;
								return h('span', '￥'+text)
							}
						},
						{
							title: '建设规模',
							key: 'buildScale',
							minWidth: 180,
							sortable: true
						},
						{
							title: '项目所属地区归类',
							key: 'regionType',
							minWidth: 200,
							sortable: true
						},
						{
							title: '建设单位',
							key: 'buildComp',
							minWidth: 200,
							sortable: true
            },
            {
							title: '中标单位',
							key: 'markComp',
							minWidth: 200,
							sortable: true
						},
						{
							title: '工程地址',
							key: 'projectAddr',
							minWidth: 180,
							sortable: true
						},
						{
							title: '合同签订日期',
							key: 'contractDate',
							minWidth: 160,
							sortable: true
						},
						{
							title: '中标日期',
							key: 'markDate',
							minWidth: 150,
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
							minWidth: 150,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '施工员身份证号',
							key: 'constructorsIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '质量员身份证号',
							key: 'qualityWorkerIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '安全员身份证号',
							key: 'securityOfficerIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '标准员身份证号',
							key: 'standardWorkerIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '材料员身份证号',
							key: 'materialManIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '机械员身份证号',
							key: 'mechanicIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '劳务员身份证号',
							key: 'laborsIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '资料员身份证号',
							key: 'dataClerkIdNum',
							minWidth: 160,
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
							minWidth: 150,
							sortable: true
						},
						{
							title: '更新时间',
							key: 'updateTime',
							minWidth: 150,
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
										h('DropdownItem', {
											props: {
												name: 'showEdit'
											}
										}, '编辑'),
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
				this.modal.operate = 'operate'
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
					this.setPrice(0)
					var projectAddr = this.form.projectAddr.split("/")
					for(var i=0; projectAddr.length>i; i++) {
						this.projectAddr.push(projectAddr[i])
					}
					
					var regionType = this.form.regionType.split("/")
					for(var i=0; regionType.length>i; i++) {
						this.regionType.push(regionType[i])
					}
				} else if (itemName === 'showDetail') {
					utils.showModal(this, 'detail')
					this.form = JSON.parse(JSON.stringify(row))
				} else if (itemName === 'remove') {
					utils.remove(this, row)
				} else if (itemName === 'moduleDetail') {
					this.showUserDetailModal(row.compId)
				} else if (itemName === 'showSearch') {
					utils.showModal(this, 'companyChoice')
					this.modal.operate = 'show'
				}
			},
			showUserDetailModal(id) {
			  getCompanyById(id)
			    .then(res => {
			      const data = res.data
			      if (data.code === 1001) {
			        this.companyDetailForm = data.data
			        this.modal.companyDetail = true
			      } else {
			        this.$Message.error(data.message)
			      }
			    })
			    .catch(err => {
			      this.$Message.error(err)
			    })
			},
			confirmSelection(id) {
				this.modal.companyChoice = false
				if(this.modal.operate === 'show') {
					this.searchForm.compIdMin = id
					this.searchForm.compIdMax = id
					utils.search(this)
				} else if(this.modal.operate === 'operate') {
					this.form.compId = id
				}
			},
			confirm() {
			  this.$refs.CompanyListSingle.confirmSelection()
			},
			setAddress() {
				if(this.projectAddr.length > 0) {
					this.form.projectAddr = this.projectAddr[0]+ '/' +this.projectAddr[1]+ '/' + this.projectAddr[2]
				}
				
				if(this.regionType.length > 0) {
					this.form.regionType = this.regionType[0]+ '/' + this.regionType[1]+ '/' + this.regionType[2]
				}
			},
			setPrice(type) {
				if (type === 0) {
					if (this.form.markMoney !== null && this.form.markMoney !== 0) {
						this.form.markMoneyDisplay = this.form.markMoney / 100
					}
				} else if (type === 1) {
					if (this.form.markMoneyDisplay !== null && this.form.markMoneyDisplay !== 0) {
						this.form.markMoney = this.form.markMoneyDisplay * 100
					}
				}
			},
			add() {
				this.setAddress()
				this.setPrice(1)
				utils.add(this)
			},
			edit() {
				this.setAddress()
				this.setPrice(1)
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
      // 爬取数据
      crawlData() {
        axios.request({
          url: this.urls.pythonUpdateDataUrl,
          method: 'GET',
          data: '',
        }).then(res => {
          if (res.data.code !== ResponseStatus.OK) {
            this.$Message.error(res.data.message)
          } else {
            this.$Message.success(res.data.message)
          }
        }).catch(err => {
          console.log(err)
          this.$Message.error("爬取数据失败")
        })
      }
		}
	}
</script>

<style>
</style>
