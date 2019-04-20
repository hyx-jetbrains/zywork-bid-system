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
        <FormItem label="简历编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始简历编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束简历编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="用户编号"><Row>
	<i-col span="11">
	<FormItem prop="userIdMin">
	<InputNumber v-model="searchForm.userIdMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userIdMax">
	<InputNumber v-model="searchForm.userIdMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="姓名" prop="name">
	<Input v-model="searchForm.name" placeholder="请输入姓名"/>
</FormItem>
<FormItem label="性别" prop="gender">
	<Input v-model="searchForm.gender" placeholder="请输入性别"/>
</FormItem>
<FormItem label="年龄"><Row>
	<i-col span="11">
	<FormItem prop="ageMin">
	<InputNumber v-model="searchForm.ageMin" placeholder="请输入开始年龄" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="ageMax">
	<InputNumber v-model="searchForm.ageMax" placeholder="请输入结束年龄" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="求职类型"><Row>
	<i-col span="11">
	<FormItem prop="isFulltimeMin">
	<InputNumber v-model="searchForm.isFulltimeMin" placeholder="请输入开始求职类型" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isFulltimeMax">
	<InputNumber v-model="searchForm.isFulltimeMax" placeholder="请输入结束求职类型" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="求职岗位" prop="jobTitle">
	<Input v-model="searchForm.jobTitle" placeholder="请输入求职岗位"/>
</FormItem>
<FormItem label="工作时间（年）" prop="workYear">
	<Input v-model="searchForm.workYear" placeholder="请输入工作时间（年）"/>
</FormItem>
<FormItem label="学历" prop="education">
	<Input v-model="searchForm.education" placeholder="请输入学历"/>
</FormItem>
<FormItem label="要求薪资/月" prop="salary">
	<Input v-model="searchForm.salary" placeholder="请输入要求薪资/月"/>
</FormItem>
<FormItem label="是否允许平台推荐"><Row>
	<i-col span="11">
	<FormItem prop="isRecommendMin">
	<InputNumber v-model="searchForm.isRecommendMin" placeholder="请输入开始是否允许平台推荐" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isRecommendMax">
	<InputNumber v-model="searchForm.isRecommendMax" placeholder="请输入结束是否允许平台推荐" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="我的资质" prop="aptitude">
	<Input v-model="searchForm.aptitude" placeholder="请输入我的资质"/>
</FormItem>
<FormItem label="个人简介" prop="intorduce">
	<Input v-model="searchForm.intorduce" placeholder="请输入个人简介"/>
</FormItem>
<FormItem label="是否开放简历"><Row>
	<i-col span="11">
	<FormItem prop="isShowMin">
	<InputNumber v-model="searchForm.isShowMin" placeholder="请输入开始是否开放简历" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isShowMax">
	<InputNumber v-model="searchForm.isShowMax" placeholder="请输入结束是否开放简历" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
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
      <p>简历编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>姓名: <span v-text="form.name"></span></p>
<p>性别: <span v-text="form.gender"></span></p>
<p>年龄: <span v-text="form.age"></span></p>
<p>求职类型: <span v-text="form.isFulltime"></span></p>
<p>求职岗位: <span v-text="form.jobTitle"></span></p>
<p>工作时间（年）: <span v-text="form.workYear"></span></p>
<p>学历: <span v-text="form.education"></span></p>
<p>要求薪资/月: <span v-text="form.salary"></span></p>
<p>是否允许平台推荐: <span v-text="form.isRecommend"></span></p>
<p>我的资质: <span v-text="form.aptitude"></span></p>
<p>个人简介: <span v-text="form.intorduce"></span></p>
<p>是否开放简历: <span v-text="form.isShow"></span></p>
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
    name: 'ResumeList',
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
          searchUrl: '/resume/admin/pager-cond',
          allUrl: '/resume/admin/all',
          detailUrl: '/resume/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
name: null,
gender: null,
age: null,
isFulltime: null,
jobTitle: null,
workYear: null,
education: null,
salary: null,
isRecommend: null,
aptitude: null,
intorduce: null,
isShow: null,
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
userId: null,
userIdMin: null, 
userIdMax: null, 
name: null,
gender: null,
age: null,
ageMin: null, 
ageMax: null, 
isFulltime: null,
isFulltimeMin: null, 
isFulltimeMax: null, 
jobTitle: null,
workYear: null,
education: null,
salary: null,
isRecommend: null,
isRecommendMin: null, 
isRecommendMax: null, 
aptitude: null,
intorduce: null,
isShow: null,
isShowMin: null, 
isShowMax: null, 
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
title: '简历编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '用户编号',
key: 'userId',
minWidth: 120,
sortable: true
},
{
title: '姓名',
key: 'name',
minWidth: 120,
sortable: true
},
{
title: '性别',
key: 'gender',
minWidth: 120,
sortable: true
},
{
title: '年龄',
key: 'age',
minWidth: 120,
sortable: true
},
{
title: '求职类型',
key: 'isFulltime',
minWidth: 120,
sortable: true
},
{
title: '求职岗位',
key: 'jobTitle',
minWidth: 120,
sortable: true
},
{
title: '工作时间（年）',
key: 'workYear',
minWidth: 120,
sortable: true
},
{
title: '学历',
key: 'education',
minWidth: 120,
sortable: true
},
{
title: '要求薪资/月',
key: 'salary',
minWidth: 120,
sortable: true
},
{
title: '是否允许平台推荐',
key: 'isRecommend',
minWidth: 120,
sortable: true
},
{
title: '我的资质',
key: 'aptitude',
minWidth: 120,
sortable: true
},
{
title: '个人简介',
key: 'intorduce',
minWidth: 120,
sortable: true
},
{
title: '是否开放简历',
key: 'isShow',
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
        this.searchForm.pageNo = 1
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
      },
      confirmSelection() {
        // 确认选择的逻辑
      }
    }
  }
</script>

<style>
</style>
