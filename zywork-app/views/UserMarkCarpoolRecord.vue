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
        <FormItem label="拼车记录编号"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordIdMin">
	<InputNumber v-model="searchForm.markCarpoolRecordIdMin" placeholder="请输入开始拼车记录编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordIdMax">
	<InputNumber v-model="searchForm.markCarpoolRecordIdMax" placeholder="请输入结束拼车记录编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="用户编号"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordUserIdMin">
	<InputNumber v-model="searchForm.markCarpoolRecordUserIdMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordUserIdMax">
	<InputNumber v-model="searchForm.markCarpoolRecordUserIdMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="拼车编号"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordMarkCarpoolIdMin">
	<InputNumber v-model="searchForm.markCarpoolRecordMarkCarpoolIdMin" placeholder="请输入开始拼车编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordMarkCarpoolIdMax">
	<InputNumber v-model="searchForm.markCarpoolRecordMarkCarpoolIdMax" placeholder="请输入结束拼车编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordVersionMin">
	<InputNumber v-model="searchForm.markCarpoolRecordVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordVersionMax">
	<InputNumber v-model="searchForm.markCarpoolRecordVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordCreateTimeMin">
	<DatePicker @on-change="searchForm.markCarpoolRecordCreateTimeMin=$event" :value="searchForm.markCarpoolRecordCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordCreateTimeMax">
	<DatePicker @on-change="searchForm.markCarpoolRecordCreateTimeMax=$event" :value="searchForm.markCarpoolRecordCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordUpdateTimeMin">
	<DatePicker @on-change="searchForm.markCarpoolRecordUpdateTimeMin=$event" :value="searchForm.markCarpoolRecordUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordUpdateTimeMax">
	<DatePicker @on-change="searchForm.markCarpoolRecordUpdateTimeMax=$event" :value="searchForm.markCarpoolRecordUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordIsActiveMin">
	<InputNumber v-model="searchForm.markCarpoolRecordIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markCarpoolRecordIsActiveMax">
	<InputNumber v-model="searchForm.markCarpoolRecordIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="昵称" prop="userDetailNickname">
	<Input v-model="searchForm.userDetailNickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="userDetailHeadicon">
	<Input v-model="searchForm.userDetailHeadicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="性别"><Row>
	<i-col span="11">
	<FormItem prop="userDetailGenderMin">
	<InputNumber v-model="searchForm.userDetailGenderMin" placeholder="请输入开始性别" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userDetailGenderMax">
	<InputNumber v-model="searchForm.userDetailGenderMax" placeholder="请输入结束性别" style="width: 100%;"/>
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
    <Modal v-model="modal.detail" title="详情">
      <p>拼车记录编号: <span v-text="form.markCarpoolRecordId"></span></p>
<p>用户编号: <span v-text="form.markCarpoolRecordUserId"></span></p>
<p>拼车编号: <span v-text="form.markCarpoolRecordMarkCarpoolId"></span></p>
<p>版本号: <span v-text="form.markCarpoolRecordVersion"></span></p>
<p>创建时间: <span v-text="form.markCarpoolRecordCreateTime"></span></p>
<p>更新时间: <span v-text="form.markCarpoolRecordUpdateTime"></span></p>
<p>是否激活: <span v-text="form.markCarpoolRecordIsActive"></span></p>
<p>昵称: <span v-text="form.userDetailNickname"></span></p>
<p>头像地址: <span v-text="form.userDetailHeadicon"></span></p>
<p>性别: <span v-text="form.userDetailGender"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserMarkCarpoolRecord',
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
          searchUrl: '/UserMarkCarpoolRecord/admin/pager-cond',
          allUrl: '/UserMarkCarpoolRecord/admin/all',
          detailUrl: '/UserMarkCarpoolRecord/admin/one/',
          multiUrl: '/UserMarkCarpoolRecord/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          markCarpoolRecordId: null,
markCarpoolRecordUserId: null,
markCarpoolRecordMarkCarpoolId: null,
markCarpoolRecordVersion: null,
markCarpoolRecordCreateTime: null,
markCarpoolRecordUpdateTime: null,
markCarpoolRecordIsActive: null,
userDetailNickname: null,
userDetailHeadicon: null,
userDetailGender: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          markCarpoolRecordId: null,
markCarpoolRecordIdMin: null, 
markCarpoolRecordIdMax: null, 
markCarpoolRecordUserId: null,
markCarpoolRecordUserIdMin: null, 
markCarpoolRecordUserIdMax: null, 
markCarpoolRecordMarkCarpoolId: null,
markCarpoolRecordMarkCarpoolIdMin: null, 
markCarpoolRecordMarkCarpoolIdMax: null, 
markCarpoolRecordVersion: null,
markCarpoolRecordVersionMin: null, 
markCarpoolRecordVersionMax: null, 
markCarpoolRecordCreateTime: null,
markCarpoolRecordCreateTimeMin: null, 
markCarpoolRecordCreateTimeMax: null, 
markCarpoolRecordUpdateTime: null,
markCarpoolRecordUpdateTimeMin: null, 
markCarpoolRecordUpdateTimeMax: null, 
markCarpoolRecordIsActive: null,
markCarpoolRecordIsActiveMin: null, 
markCarpoolRecordIsActiveMax: null, 
userDetailNickname: null,
userDetailHeadicon: null,
userDetailGender: null,
userDetailGenderMin: null, 
userDetailGenderMax: null, 

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
title: '拼车记录编号',
key: 'markCarpoolRecordId',
minWidth: 120,
sortable: true
},
{
title: '用户编号',
key: 'markCarpoolRecordUserId',
minWidth: 120,
sortable: true
},
{
title: '拼车编号',
key: 'markCarpoolRecordMarkCarpoolId',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'markCarpoolRecordVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'markCarpoolRecordCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'markCarpoolRecordUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'markCarpoolRecordIsActive',
minWidth: 120,
sortable: true
},
{
title: '昵称',
key: 'userDetailNickname',
minWidth: 120,
sortable: true
},
{
title: '头像地址',
key: 'userDetailHeadicon',
minWidth: 120,
sortable: true
},
{
title: '性别',
key: 'userDetailGender',
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
