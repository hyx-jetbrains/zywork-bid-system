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
        <FormItem label="项目资源表主键"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceIdMin">
	<InputNumber v-model="searchForm.projectResourceIdMin" placeholder="请输入开始项目资源表主键" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceIdMax">
	<InputNumber v-model="searchForm.projectResourceIdMax" placeholder="请输入结束项目资源表主键" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="项目编号"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceProjectIdMin">
	<InputNumber v-model="searchForm.projectResourceProjectIdMin" placeholder="请输入开始项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceProjectIdMax">
	<InputNumber v-model="searchForm.projectResourceProjectIdMax" placeholder="请输入结束项目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="资源编号"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceResourceIdMin">
	<InputNumber v-model="searchForm.projectResourceResourceIdMin" placeholder="请输入开始资源编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceResourceIdMax">
	<InputNumber v-model="searchForm.projectResourceResourceIdMax" placeholder="请输入结束资源编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="资源类别"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceResTypeMin">
	<InputNumber v-model="searchForm.projectResourceResTypeMin" placeholder="请输入开始资源类别" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceResTypeMax">
	<InputNumber v-model="searchForm.projectResourceResTypeMax" placeholder="请输入结束资源类别" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceVersionMin">
	<InputNumber v-model="searchForm.projectResourceVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceVersionMax">
	<InputNumber v-model="searchForm.projectResourceVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceCreateTimeMin">
	<DatePicker @on-change="searchForm.projectResourceCreateTimeMin=$event" :value="searchForm.projectResourceCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceCreateTimeMax">
	<DatePicker @on-change="searchForm.projectResourceCreateTimeMax=$event" :value="searchForm.projectResourceCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceUpdateTimeMin">
	<DatePicker @on-change="searchForm.projectResourceUpdateTimeMin=$event" :value="searchForm.projectResourceUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceUpdateTimeMax">
	<DatePicker @on-change="searchForm.projectResourceUpdateTimeMax=$event" :value="searchForm.projectResourceUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="projectResourceIsActiveMin">
	<InputNumber v-model="searchForm.projectResourceIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="projectResourceIsActiveMax">
	<InputNumber v-model="searchForm.projectResourceIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="用户编号"><Row>
	<i-col span="11">
	<FormItem prop="resourceUserIdMin">
	<InputNumber v-model="searchForm.resourceUserIdMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="resourceUserIdMax">
	<InputNumber v-model="searchForm.resourceUserIdMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="资源类型" prop="resourceMimeType">
	<Input v-model="searchForm.resourceMimeType" placeholder="请输入资源类型"/>
</FormItem>
<FormItem label="资源地址" prop="resourceUrl">
	<Input v-model="searchForm.resourceUrl" placeholder="请输入资源地址"/>
</FormItem>
<FormItem label="资源扩展名" prop="resourceExtension">
	<Input v-model="searchForm.resourceExtension" placeholder="请输入资源扩展名"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>项目资源表主键: <span v-text="form.projectResourceId"></span></p>
<p>项目编号: <span v-text="form.projectResourceProjectId"></span></p>
<p>资源编号: <span v-text="form.projectResourceResourceId"></span></p>
<p>资源类别: <span v-text="form.projectResourceResType"></span></p>
<p>版本号: <span v-text="form.projectResourceVersion"></span></p>
<p>创建时间: <span v-text="form.projectResourceCreateTime"></span></p>
<p>更新时间: <span v-text="form.projectResourceUpdateTime"></span></p>
<p>是否激活: <span v-text="form.projectResourceIsActive"></span></p>
<p>用户编号: <span v-text="form.resourceUserId"></span></p>
<p>资源类型: <span v-text="form.resourceMimeType"></span></p>
<p>资源地址: <span v-text="form.resourceUrl"></span></p>
<p>资源扩展名: <span v-text="form.resourceExtension"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'ProjectResourceResource',
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
          searchUrl: '/ProjectResourceResource/admin/pager-cond',
          allUrl: '/ProjectResourceResource/admin/all',
          detailUrl: '/ProjectResourceResource/admin/one/',
          multiUrl: '/ProjectResourceResource/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          projectResourceId: null,
projectResourceProjectId: null,
projectResourceResourceId: null,
projectResourceResType: null,
projectResourceVersion: null,
projectResourceCreateTime: null,
projectResourceUpdateTime: null,
projectResourceIsActive: null,
resourceUserId: null,
resourceMimeType: null,
resourceUrl: null,
resourceExtension: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          projectResourceId: null,
projectResourceIdMin: null, 
projectResourceIdMax: null, 
projectResourceProjectId: null,
projectResourceProjectIdMin: null, 
projectResourceProjectIdMax: null, 
projectResourceResourceId: null,
projectResourceResourceIdMin: null, 
projectResourceResourceIdMax: null, 
projectResourceResType: null,
projectResourceResTypeMin: null, 
projectResourceResTypeMax: null, 
projectResourceVersion: null,
projectResourceVersionMin: null, 
projectResourceVersionMax: null, 
projectResourceCreateTime: null,
projectResourceCreateTimeMin: null, 
projectResourceCreateTimeMax: null, 
projectResourceUpdateTime: null,
projectResourceUpdateTimeMin: null, 
projectResourceUpdateTimeMax: null, 
projectResourceIsActive: null,
projectResourceIsActiveMin: null, 
projectResourceIsActiveMax: null, 
resourceUserId: null,
resourceUserIdMin: null, 
resourceUserIdMax: null, 
resourceMimeType: null,
resourceUrl: null,
resourceExtension: null,

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
title: '项目资源表主键',
key: 'projectResourceId',
minWidth: 120,
sortable: true
},
{
title: '项目编号',
key: 'projectResourceProjectId',
minWidth: 120,
sortable: true
},
{
title: '资源编号',
key: 'projectResourceResourceId',
minWidth: 120,
sortable: true
},
{
title: '资源类别',
key: 'projectResourceResType',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'projectResourceVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'projectResourceCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'projectResourceUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'projectResourceIsActive',
minWidth: 120,
sortable: true
},
{
title: '用户编号',
key: 'resourceUserId',
minWidth: 120,
sortable: true
},
{
title: '资源类型',
key: 'resourceMimeType',
minWidth: 120,
sortable: true
},
{
title: '资源地址',
key: 'resourceUrl',
minWidth: 120,
sortable: true
},
{
title: '资源扩展名',
key: 'resourceExtension',
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
