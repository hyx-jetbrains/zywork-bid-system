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
        <FormItem label="开标拼车编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始开标拼车编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束开标拼车编号" style="width: 100%;"/>
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
<FormItem label="项目编号"><Row>
	<i-col span="11">
	<FormItem prop="projectIdMin">
	<InputNumber v-model="searchForm.projectIdMin" placeholder="请输入开始项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectIdMax">
	<InputNumber v-model="searchForm.projectIdMax" placeholder="请输入结束项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="城市" prop="city">
	<Input v-model="searchForm.city" placeholder="请输入城市"/>
</FormItem>
<FormItem label="出发地点" prop="startAddr">
	<Input v-model="searchForm.startAddr" placeholder="请输入出发地点"/>
</FormItem>
<FormItem label="目的地" prop="endAddr">
	<Input v-model="searchForm.endAddr" placeholder="请输入目的地"/>
</FormItem>
<FormItem label="出发时间"><Row>
	<i-col span="11">
	<FormItem prop="startTimeMin">
	<DatePicker @on-change="searchForm.startTimeMin=$event" :value="searchForm.startTimeMin" placeholder="请输入开始出发时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="startTimeMax">
	<DatePicker @on-change="searchForm.startTimeMax=$event" :value="searchForm.startTimeMax" placeholder="请输入结束出发时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="汽车类型" prop="carType">
	<Input v-model="searchForm.carType" placeholder="请输入汽车类型"/>
</FormItem>
<FormItem label="搭载人数"><Row>
	<i-col span="11">
	<FormItem prop="peopleCountMin">
	<InputNumber v-model="searchForm.peopleCountMin" placeholder="请输入开始搭载人数" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="peopleCountMax">
	<InputNumber v-model="searchForm.peopleCountMax" placeholder="请输入结束搭载人数" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="价格"><Row>
	<i-col span="11">
	<FormItem prop="priceMin">
	<InputNumber v-model="searchForm.priceMin" placeholder="请输入开始价格" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="priceMax">
	<InputNumber v-model="searchForm.priceMax" placeholder="请输入结束价格" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="联系人姓名" prop="name">
	<Input v-model="searchForm.name" placeholder="请输入联系人姓名"/>
</FormItem>
<FormItem label="联系人电话" prop="phone">
	<Input v-model="searchForm.phone" placeholder="请输入联系人电话"/>
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
      <p>开标拼车编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>项目编号: <span v-text="form.projectId"></span></p>
<p>城市: <span v-text="form.city"></span></p>
<p>出发地点: <span v-text="form.startAddr"></span></p>
<p>目的地: <span v-text="form.endAddr"></span></p>
<p>出发时间: <span v-text="form.startTime"></span></p>
<p>汽车类型: <span v-text="form.carType"></span></p>
<p>搭载人数: <span v-text="form.peopleCount"></span></p>
<p>价格: <span v-text="form.price"></span></p>
<p>联系人姓名: <span v-text="form.name"></span></p>
<p>联系人电话: <span v-text="form.phone"></span></p>
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
    name: 'MarkCarpoolList',
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
          searchUrl: '/mark-carpool/admin/pager-cond',
          allUrl: '/mark-carpool/admin/all',
          detailUrl: '/mark-carpool/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
projectId: null,
city: null,
startAddr: null,
endAddr: null,
startTime: null,
carType: null,
peopleCount: null,
price: null,
name: null,
phone: null,
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
projectId: null,
projectIdMin: null, 
projectIdMax: null, 
city: null,
startAddr: null,
endAddr: null,
startTime: null,
startTimeMin: null, 
startTimeMax: null, 
carType: null,
peopleCount: null,
peopleCountMin: null, 
peopleCountMax: null, 
price: null,
priceMin: null, 
priceMax: null, 
name: null,
phone: null,
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
title: '开标拼车编号',
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
title: '项目编号',
key: 'projectId',
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
title: '出发地点',
key: 'startAddr',
minWidth: 120,
sortable: true
},
{
title: '目的地',
key: 'endAddr',
minWidth: 120,
sortable: true
},
{
title: '出发时间',
key: 'startTime',
minWidth: 120,
sortable: true
},
{
title: '汽车类型',
key: 'carType',
minWidth: 120,
sortable: true
},
{
title: '搭载人数',
key: 'peopleCount',
minWidth: 120,
sortable: true
},
{
title: '价格',
key: 'price',
minWidth: 120,
sortable: true
},
{
title: '联系人姓名',
key: 'name',
minWidth: 120,
sortable: true
},
{
title: '联系人电话',
key: 'phone',
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
