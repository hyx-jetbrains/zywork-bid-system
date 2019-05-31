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
        <FormItem label="系统信息编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始系统信息编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束系统信息编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="公司名称" prop="compName">
	<Input v-model="searchForm.compName" placeholder="请输入公司名称"/>
</FormItem>
<FormItem label="头部图标" prop="headIcon">
	<Input v-model="searchForm.headIcon" placeholder="请输入头部图标"/>
</FormItem>
<FormItem label="菜单小图标" prop="menuIconMin">
	<Input v-model="searchForm.menuIconMin" placeholder="请输入菜单小图标"/>
</FormItem>
<FormItem label="菜单大图标" prop="menuIconMax">
	<Input v-model="searchForm.menuIconMax" placeholder="请输入菜单大图标"/>
</FormItem>
<FormItem label="默认头像" prop="defaultHead">
	<Input v-model="searchForm.defaultHead" placeholder="请输入默认头像"/>
</FormItem>
<FormItem label="背景图片" prop="backgroundIcon">
	<Input v-model="searchForm.backgroundIcon" placeholder="请输入背景图片"/>
</FormItem>
<FormItem label="域名" prop="doMain">
	<Input v-model="searchForm.doMain" placeholder="请输入域名"/>
</FormItem>
<FormItem label="公司地址" prop="compAddr">
	<Input v-model="searchForm.compAddr" placeholder="请输入公司地址"/>
</FormItem>
<FormItem label="公司电话" prop="compPhone">
	<Input v-model="searchForm.compPhone" placeholder="请输入公司电话"/>
</FormItem>
<FormItem label="公司邮箱" prop="compEmail">
	<Input v-model="searchForm.compEmail" placeholder="请输入公司邮箱"/>
</FormItem>
<FormItem label="公司说明" prop="compMemo">
	<Input v-model="searchForm.compMemo" placeholder="请输入公司说明"/>
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
      <p>系统信息编号: <span v-text="form.id"></span></p>
<p>公司名称: <span v-text="form.compName"></span></p>
<p>头部图标: <span v-text="form.headIcon"></span></p>
<p>菜单小图标: <span v-text="form.menuIconMin"></span></p>
<p>菜单大图标: <span v-text="form.menuIconMax"></span></p>
<p>默认头像: <span v-text="form.defaultHead"></span></p>
<p>背景图片: <span v-text="form.backgroundIcon"></span></p>
<p>域名: <span v-text="form.doMain"></span></p>
<p>公司地址: <span v-text="form.compAddr"></span></p>
<p>公司电话: <span v-text="form.compPhone"></span></p>
<p>公司邮箱: <span v-text="form.compEmail"></span></p>
<p>公司说明: <span v-text="form.compMemo"></span></p>
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
    name: 'SysInfoList',
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
          searchUrl: '/sys-info/admin/pager-cond',
          allUrl: '/sys-info/admin/all',
          detailUrl: '/sys-info/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
compName: null,
headIcon: null,
menuIconMin: null,
menuIconMax: null,
defaultHead: null,
backgroundIcon: null,
doMain: null,
compAddr: null,
compPhone: null,
compEmail: null,
compMemo: null,
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
compName: null,
headIcon: null,
menuIconMin: null,
menuIconMax: null,
defaultHead: null,
backgroundIcon: null,
doMain: null,
compAddr: null,
compPhone: null,
compEmail: null,
compMemo: null,
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
title: '系统信息编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '公司名称',
key: 'compName',
minWidth: 120,
sortable: true
},
{
title: '头部图标',
key: 'headIcon',
minWidth: 120,
sortable: true
},
{
title: '菜单小图标',
key: 'menuIconMin',
minWidth: 120,
sortable: true
},
{
title: '菜单大图标',
key: 'menuIconMax',
minWidth: 120,
sortable: true
},
{
title: '默认头像',
key: 'defaultHead',
minWidth: 120,
sortable: true
},
{
title: '背景图片',
key: 'backgroundIcon',
minWidth: 120,
sortable: true
},
{
title: '域名',
key: 'doMain',
minWidth: 120,
sortable: true
},
{
title: '公司地址',
key: 'compAddr',
minWidth: 120,
sortable: true
},
{
title: '公司电话',
key: 'compPhone',
minWidth: 120,
sortable: true
},
{
title: '公司邮箱',
key: 'compEmail',
minWidth: 120,
sortable: true
},
{
title: '公司说明',
key: 'compMemo',
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
