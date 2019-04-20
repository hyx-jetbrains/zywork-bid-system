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
        <FormItem label="求带资料编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始求带资料编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束求带资料编号" style="width: 100%;"/>
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
<FormItem label="出发地点" prop="startAddr">
	<Input v-model="searchForm.startAddr" placeholder="请输入出发地点"/>
</FormItem>
<FormItem label="目的地" prop="endAddr">
	<Input v-model="searchForm.endAddr" placeholder="请输入目的地"/>
</FormItem>
<FormItem label="资料类型" prop="dataType">
	<Input v-model="searchForm.dataType" placeholder="请输入资料类型"/>
</FormItem>
<FormItem label="资料数量"><Row>
	<i-col span="11">
	<FormItem prop="dataCountMin">
	<InputNumber v-model="searchForm.dataCountMin" placeholder="请输入开始资料数量" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="dataCountMax">
	<InputNumber v-model="searchForm.dataCountMax" placeholder="请输入结束资料数量" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="最晚时间"><Row>
	<i-col span="11">
	<FormItem prop="latestTimeMin">
	<DatePicker @on-change="searchForm.latestTimeMin=$event" :value="searchForm.latestTimeMin" placeholder="请输入开始最晚时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="latestTimeMax">
	<DatePicker @on-change="searchForm.latestTimeMax=$event" :value="searchForm.latestTimeMax" placeholder="请输入结束最晚时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="赏金"><Row>
	<i-col span="11">
	<FormItem prop="priceMin">
	<InputNumber v-model="searchForm.priceMin" placeholder="请输入开始赏金" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="priceMax">
	<InputNumber v-model="searchForm.priceMax" placeholder="请输入结束赏金" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="联系电话" prop="phone">
	<Input v-model="searchForm.phone" placeholder="请输入联系电话"/>
</FormItem>
<FormItem label="是否加急"><Row>
	<i-col span="11">
	<FormItem prop="isUrgentMin">
	<InputNumber v-model="searchForm.isUrgentMin" placeholder="请输入开始是否加急" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isUrgentMax">
	<InputNumber v-model="searchForm.isUrgentMax" placeholder="请输入结束是否加急" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="备注" prop="memo">
	<Input v-model="searchForm.memo" placeholder="请输入备注"/>
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
      <p>求带资料编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>出发地点: <span v-text="form.startAddr"></span></p>
<p>目的地: <span v-text="form.endAddr"></span></p>
<p>资料类型: <span v-text="form.dataType"></span></p>
<p>资料数量: <span v-text="form.dataCount"></span></p>
<p>最晚时间: <span v-text="form.latestTime"></span></p>
<p>赏金: <span v-text="form.price"></span></p>
<p>联系电话: <span v-text="form.phone"></span></p>
<p>是否加急: <span v-text="form.isUrgent"></span></p>
<p>备注: <span v-text="form.memo"></span></p>
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
    name: 'SeekDataListSingle',
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
          searchUrl: '/seek-data/admin/pager-cond',
          allUrl: '/seek-data/admin/all',
          detailUrl: '/seek-data/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
startAddr: null,
endAddr: null,
dataType: null,
dataCount: null,
latestTime: null,
price: null,
phone: null,
isUrgent: null,
memo: null,
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
startAddr: null,
endAddr: null,
dataType: null,
dataCount: null,
dataCountMin: null, 
dataCountMax: null, 
latestTime: null,
latestTimeMin: null, 
latestTimeMax: null, 
price: null,
priceMin: null, 
priceMax: null, 
phone: null,
isUrgent: null,
isUrgentMin: null, 
isUrgentMax: null, 
memo: null,
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
title: '求带资料编号',
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
title: '资料类型',
key: 'dataType',
minWidth: 120,
sortable: true
},
{
title: '资料数量',
key: 'dataCount',
minWidth: 120,
sortable: true
},
{
title: '最晚时间',
key: 'latestTime',
minWidth: 120,
sortable: true
},
{
title: '赏金',
key: 'price',
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
title: '是否加急',
key: 'isUrgent',
minWidth: 120,
sortable: true
},
{
title: '备注',
key: 'memo',
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
