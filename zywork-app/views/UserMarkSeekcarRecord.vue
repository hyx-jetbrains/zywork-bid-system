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
	<FormItem prop="markSeekcarRecordIdMin">
	<InputNumber v-model="searchForm.markSeekcarRecordIdMin" placeholder="请输入开始拼车记录编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordIdMax">
	<InputNumber v-model="searchForm.markSeekcarRecordIdMax" placeholder="请输入结束拼车记录编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="用户编号"><Row>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordUserIdMin">
	<InputNumber v-model="searchForm.markSeekcarRecordUserIdMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordUserIdMax">
	<InputNumber v-model="searchForm.markSeekcarRecordUserIdMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="找车编号"><Row>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordMarkSeekcarIdMin">
	<InputNumber v-model="searchForm.markSeekcarRecordMarkSeekcarIdMin" placeholder="请输入开始找车编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordMarkSeekcarIdMax">
	<InputNumber v-model="searchForm.markSeekcarRecordMarkSeekcarIdMax" placeholder="请输入结束找车编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordVersionMin">
	<InputNumber v-model="searchForm.markSeekcarRecordVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordVersionMax">
	<InputNumber v-model="searchForm.markSeekcarRecordVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordCreateTimeMin">
	<DatePicker @on-change="searchForm.markSeekcarRecordCreateTimeMin=$event" :value="searchForm.markSeekcarRecordCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordCreateTimeMax">
	<DatePicker @on-change="searchForm.markSeekcarRecordCreateTimeMax=$event" :value="searchForm.markSeekcarRecordCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordUpdateTimeMin">
	<DatePicker @on-change="searchForm.markSeekcarRecordUpdateTimeMin=$event" :value="searchForm.markSeekcarRecordUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordUpdateTimeMax">
	<DatePicker @on-change="searchForm.markSeekcarRecordUpdateTimeMax=$event" :value="searchForm.markSeekcarRecordUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordIsActiveMin">
	<InputNumber v-model="searchForm.markSeekcarRecordIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="markSeekcarRecordIsActiveMax">
	<InputNumber v-model="searchForm.markSeekcarRecordIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>拼车记录编号: <span v-text="form.markSeekcarRecordId"></span></p>
<p>用户编号: <span v-text="form.markSeekcarRecordUserId"></span></p>
<p>找车编号: <span v-text="form.markSeekcarRecordMarkSeekcarId"></span></p>
<p>版本号: <span v-text="form.markSeekcarRecordVersion"></span></p>
<p>创建时间: <span v-text="form.markSeekcarRecordCreateTime"></span></p>
<p>更新时间: <span v-text="form.markSeekcarRecordUpdateTime"></span></p>
<p>是否激活: <span v-text="form.markSeekcarRecordIsActive"></span></p>
<p>昵称: <span v-text="form.userDetailNickname"></span></p>
<p>头像地址: <span v-text="form.userDetailHeadicon"></span></p>
<p>性别: <span v-text="form.userDetailGender"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserMarkSeekcarRecord',
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
          searchUrl: '/UserMarkSeekcarRecord/admin/pager-cond',
          allUrl: '/UserMarkSeekcarRecord/admin/all',
          detailUrl: '/UserMarkSeekcarRecord/admin/one/',
          multiUrl: '/UserMarkSeekcarRecord/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          markSeekcarRecordId: null,
markSeekcarRecordUserId: null,
markSeekcarRecordMarkSeekcarId: null,
markSeekcarRecordVersion: null,
markSeekcarRecordCreateTime: null,
markSeekcarRecordUpdateTime: null,
markSeekcarRecordIsActive: null,
userDetailNickname: null,
userDetailHeadicon: null,
userDetailGender: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          markSeekcarRecordId: null,
markSeekcarRecordIdMin: null, 
markSeekcarRecordIdMax: null, 
markSeekcarRecordUserId: null,
markSeekcarRecordUserIdMin: null, 
markSeekcarRecordUserIdMax: null, 
markSeekcarRecordMarkSeekcarId: null,
markSeekcarRecordMarkSeekcarIdMin: null, 
markSeekcarRecordMarkSeekcarIdMax: null, 
markSeekcarRecordVersion: null,
markSeekcarRecordVersionMin: null, 
markSeekcarRecordVersionMax: null, 
markSeekcarRecordCreateTime: null,
markSeekcarRecordCreateTimeMin: null, 
markSeekcarRecordCreateTimeMax: null, 
markSeekcarRecordUpdateTime: null,
markSeekcarRecordUpdateTimeMin: null, 
markSeekcarRecordUpdateTimeMax: null, 
markSeekcarRecordIsActive: null,
markSeekcarRecordIsActiveMin: null, 
markSeekcarRecordIsActiveMax: null, 
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
key: 'markSeekcarRecordId',
minWidth: 120,
sortable: true
},
{
title: '用户编号',
key: 'markSeekcarRecordUserId',
minWidth: 120,
sortable: true
},
{
title: '找车编号',
key: 'markSeekcarRecordMarkSeekcarId',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'markSeekcarRecordVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'markSeekcarRecordCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'markSeekcarRecordUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'markSeekcarRecordIsActive',
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
