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
<FormItem label="关系编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始关系编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束关系编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="祖先编号"><Row>
	<i-col span="11">
	<FormItem prop="ancestorIdMin">
	<InputNumber v-model="searchForm.ancestorIdMin" placeholder="请输入开始祖先编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="ancestorIdMax">
	<InputNumber v-model="searchForm.ancestorIdMax" placeholder="请输入结束祖先编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="昵称" prop="ancestorNickname">
	<Input v-model="searchForm.ancestorNickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="ancestorHeadicon">
	<Input v-model="searchForm.ancestorHeadicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="用户编号"><Row>
	<i-col span="11">
	<FormItem prop="usersIdMin">
	<InputNumber v-model="searchForm.usersIdMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="usersIdMax">
	<InputNumber v-model="searchForm.usersIdMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="昵称" prop="usersNickname">
	<Input v-model="searchForm.usersNickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="usersHeadicon">
	<Input v-model="searchForm.usersHeadicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="用户级别"><Row>
	<i-col span="11">
	<FormItem prop="levelMin">
	<InputNumber v-model="searchForm.levelMin" placeholder="请输入开始用户级别" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="levelMax">
	<InputNumber v-model="searchForm.levelMax" placeholder="请输入结束用户级别" style="width: 100%;"/>
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

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>关系编号: <span v-text="form.id"></span></p>
      <p>祖先编号: <span v-text="form.ancestorId"></span></p>
<p>昵称: <span v-text="form.ancestorNickname"></span></p>
<p>头像地址: <span v-text="form.ancestorHeadicon"></span></p>
<p>用户编号: <span v-text="form.usersId"></span></p>
<p>昵称: <span v-text="form.usersNickname"></span></p>
<p>头像地址: <span v-text="form.usersHeadicon"></span></p>
<p>用户级别: <span v-text="form.level"></span></p>
<p>创建时间: <span v-text="form.createTime"></span></p>
    </Modal>
    <DistributionTreeDrawer ref="distributionTreeDrawer"/>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'
  import DistributionTreeDrawer from './DistributionTreeDrawer'

  export default {
    name: 'TopDistribution',
    components: {
      DistributionTreeDrawer
    },
    data() {
      return {
        modal: {
          search: false,
          detail: false
        },
        loading: {
          search: false
        },
        urls: {
          searchUrl: '/distribution/admin/user-hierarchy'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
ancestorId: null,
ancestorPhone: null,
ancestorNickname: null,
ancestorHeadicon: null,
usersId: null,
usersPhone: null,
usersNickname: null,
usersHeadicon: null,
level: null,
createTime: null

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          id: null,
          idMin: null,
          idMax: null,
ancestorId: null,
ancestorIdMin: null,
ancestorIdMax: null,
ancestorPhone: null,
ancestorNickname: null,
ancestorHeadicon: null,
usersId: null,
usersIdMin: null,
usersIdMax: null,
usersPhone: null,
usersNickname: null,
usersHeadicon: null,
level: null,
levelMin: null,
levelMax: null,
createTime: null,
createTimeMin: null,
createTimeMax: null

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
title: '关系编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '祖先编号',
key: 'ancestorId',
minWidth: 120,
sortable: true
},
{
title: '手机号',
key: 'ancestorPhone',
minWidth: 120,
sortable: true
},
{
title: '昵称',
key: 'ancestorNickname',
minWidth: 120,
sortable: true
},
{
title: '头像地址',
key: 'ancestorHeadicon',
minWidth: 120,
sortable: true
},
{
title: '用户编号',
key: 'usersId',
minWidth: 120,
sortable: true
},
{
title: '手机号',
key: 'usersPhone',
minWidth: 120,
sortable: true
},
{
title: '昵称',
key: 'usersNickname',
minWidth: 120,
sortable: true
},
{
title: '头像地址',
key: 'usersHeadicon',
minWidth: 120,
sortable: true
},
{
title: '用户级别',
key: 'level',
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
            title: '操作',
            key: 'action',
            width: 120,
            align: 'center',
            fixed: 'right',
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
                    'Button',
                    {
                      props: {
                        type: 'primary',
                        size: 'small'
                      }
                    },
                    [
                      '选择操作 ',
                      h('Icon', {
                        props: {
                          type: 'ios-arrow-down'
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
                            name: 'showDetail'
                          }
                        },
                        '详情'
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showDistributionAbove'
                          }
                        },
                        '查看上级分销'
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showDistributionBelow'
                          }
                        },
                        '查看下级分销'
                      )
                    ]
                  )
                ]
              )
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
      userOpt(itemName, row) {
        if (itemName === 'showDetail') {
          utils.showModal(this, 'detail')
          this.form = JSON.parse(JSON.stringify(row))
        } else if (itemName === 'showDistributionAbove') {
          this.$refs.distributionTreeDrawer.initDistributionTreeData(row.usersId, row.usersNickname, row.usersPhone, row.usersHeadicon, 'above')
        } else if (itemName === 'showDistributionBelow') {
          this.$refs.distributionTreeDrawer.initDistributionTreeData(row.usersId, row.usersNickname, row.usersPhone, row.usersHeadicon, 'below')
        }
      },
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
      }
    }
  }
</script>

<style>
</style>
