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
        <FormItem label="用户编号" prop="userId">
	<InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;"/>
</FormItem>
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="form.transactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现金额" prop="amount">
	<InputNumber v-model="form.amount" placeholder="请输入提现金额" style="width: 100%;"/>
</FormItem>
<FormItem label="提现银行卡" prop="bankcardId">
	<InputNumber v-model="form.bankcardId" placeholder="请输入提现银行卡" style="width: 100%;"/>
</FormItem>
<FormItem label="提现状态" prop="withdrawStatus">
	<InputNumber v-model="form.withdrawStatus" placeholder="请输入提现状态" style="width: 100%;"/>
</FormItem>
<FormItem label="提现描述" prop="withdrawDescription">
	<Input v-model="form.withdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号" prop="checkedUserId">
	<InputNumber v-model="form.checkedUserId" placeholder="请输入审核人编号" style="width: 100%;"/>
</FormItem>
<FormItem label="审核时间" prop="checkedTime">
	<DatePicker @on-change="form.checkedTime=$event" :value="form.checkedTime" placeholder="请输入审核时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="完成时间" prop="completeTime">
	<DatePicker @on-change="form.completeTime=$event" :value="form.completeTime" placeholder="请输入完成时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="用户编号" prop="userId">
	<InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;"/>
</FormItem>
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="form.transactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现金额" prop="amount">
	<InputNumber v-model="form.amount" placeholder="请输入提现金额" style="width: 100%;"/>
</FormItem>
<FormItem label="提现银行卡" prop="bankcardId">
	<InputNumber v-model="form.bankcardId" placeholder="请输入提现银行卡" style="width: 100%;"/>
</FormItem>
<FormItem label="提现状态" prop="withdrawStatus">
	<InputNumber v-model="form.withdrawStatus" placeholder="请输入提现状态" style="width: 100%;"/>
</FormItem>
<FormItem label="提现描述" prop="withdrawDescription">
	<Input v-model="form.withdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号" prop="checkedUserId">
	<InputNumber v-model="form.checkedUserId" placeholder="请输入审核人编号" style="width: 100%;"/>
</FormItem>
<FormItem label="审核时间" prop="checkedTime">
	<DatePicker @on-change="form.checkedTime=$event" :value="form.checkedTime" placeholder="请输入审核时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="完成时间" prop="completeTime">
	<DatePicker @on-change="form.completeTime=$event" :value="form.completeTime" placeholder="请输入完成时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="提现编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始提现编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束提现编号" style="width: 100%;"/>
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
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="searchForm.transactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现金额"><Row>
	<i-col span="11">
	<FormItem prop="amountMin">
	<InputNumber v-model="searchForm.amountMin" placeholder="请输入开始提现金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="amountMax">
	<InputNumber v-model="searchForm.amountMax" placeholder="请输入结束提现金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现银行卡"><Row>
	<i-col span="11">
	<FormItem prop="bankcardIdMin">
	<InputNumber v-model="searchForm.bankcardIdMin" placeholder="请输入开始提现银行卡" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="bankcardIdMax">
	<InputNumber v-model="searchForm.bankcardIdMax" placeholder="请输入结束提现银行卡" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现状态"><Row>
	<i-col span="11">
	<FormItem prop="withdrawStatusMin">
	<InputNumber v-model="searchForm.withdrawStatusMin" placeholder="请输入开始提现状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="withdrawStatusMax">
	<InputNumber v-model="searchForm.withdrawStatusMax" placeholder="请输入结束提现状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现描述" prop="withdrawDescription">
	<Input v-model="searchForm.withdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号"><Row>
	<i-col span="11">
	<FormItem prop="checkedUserIdMin">
	<InputNumber v-model="searchForm.checkedUserIdMin" placeholder="请输入开始审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="checkedUserIdMax">
	<InputNumber v-model="searchForm.checkedUserIdMax" placeholder="请输入结束审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="审核时间"><Row>
	<i-col span="11">
	<FormItem prop="checkedTimeMin">
	<DatePicker @on-change="searchForm.checkedTimeMin=$event" :value="searchForm.checkedTimeMin" placeholder="请输入开始审核时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="checkedTimeMax">
	<DatePicker @on-change="searchForm.checkedTimeMax=$event" :value="searchForm.checkedTimeMax" placeholder="请输入结束审核时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="完成时间"><Row>
	<i-col span="11">
	<FormItem prop="completeTimeMin">
	<DatePicker @on-change="searchForm.completeTimeMin=$event" :value="searchForm.completeTimeMin" placeholder="请输入开始完成时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="completeTimeMax">
	<DatePicker @on-change="searchForm.completeTimeMax=$event" :value="searchForm.completeTimeMax" placeholder="请输入结束完成时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
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
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <p>提现编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>交易编号: <span v-text="form.transactionNo"></span></p>
<p>提现金额: <span v-text="form.amount"></span></p>
<p>提现银行卡: <span v-text="form.bankcardId"></span></p>
<p>提现状态: <span v-text="form.withdrawStatus"></span></p>
<p>提现描述: <span v-text="form.withdrawDescription"></span></p>
<p>审核人编号: <span v-text="form.checkedUserId"></span></p>
<p>审核时间: <span v-text="form.checkedTime"></span></p>
<p>完成时间: <span v-text="form.completeTime"></span></p>
<p>版本号: <span v-text="form.version"></span></p>
<p>创建时间: <span v-text="form.createTime"></span></p>
<p>更新时间: <span v-text="form.updateTime"></span></p>
<p>是否激活: <span v-text="form.isActive"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'
  import {check, confirm} from '@/api/withdraw.js'
  import * as ResponseStatus from '@/api/response-status'

  export default {
    name: 'FundsWithdraw',
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
          addUrl: '/funds-withdraw/admin/save',
          batchAddUrl: '/funds-withdraw/admin/batch-save',
          editUrl: '/funds-withdraw/admin/update',
          batchEditUrl: '/funds-withdraw/admin/batch-update',
          searchUrl: '/funds-withdraw/admin/pager-cond',
          allUrl: '/funds-withdraw/admin/all',
          removeUrl: '/funds-withdraw/admin/remove/',
          batchRemoveUrl: '/funds-withdraw/admin/batch-remove',
          detailUrl: '/funds-withdraw/admin/one/',
          activeUrl: '/funds-withdraw/admin/active',
          batchActiveUrl: '/funds-withdraw/admin/batch-active'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
transactionNo: null,
amount: null,
bankcardId: null,
withdrawStatus: null,
withdrawDescription: null,
checkedUserId: null,
checkedTime: null,
completeTime: null,
version: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        validateRules: {
          userId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
transactionNo: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
],
amount: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
bankcardId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
withdrawDescription: [
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
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
userId: null,
userIdMin: null, 
userIdMax: null, 
transactionNo: null,
amount: null,
amountMin: null, 
amountMax: null, 
bankcardId: null,
bankcardIdMin: null, 
bankcardIdMax: null, 
withdrawStatus: null,
withdrawStatusMin: null, 
withdrawStatusMax: null, 
withdrawDescription: null,
checkedUserId: null,
checkedUserIdMin: null, 
checkedUserIdMax: null, 
checkedTime: null,
checkedTimeMin: null, 
checkedTimeMax: null, 
completeTime: null,
completeTimeMin: null, 
completeTimeMax: null, 
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
title: '提现编号',
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
title: '交易编号',
key: 'transactionNo',
minWidth: 120,
sortable: true
},
{
title: '提现金额',
key: 'amount',
minWidth: 120,
sortable: true
},
{
title: '提现银行卡',
key: 'bankcardId',
minWidth: 120,
sortable: true
},
{
title: '提现状态',
key: 'withdrawStatus',
minWidth: 120,
sortable: true
},
{
title: '提现描述',
key: 'withdrawDescription',
minWidth: 120,
sortable: true
},
{
title: '审核人编号',
key: 'checkedUserId',
minWidth: 120,
sortable: true
},
{
title: '审核时间',
key: 'checkedTime',
minWidth: 120,
sortable: true
},
{
title: '完成时间',
key: 'completeTime',
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
                      ]),
                      h('DropdownItem', {
                        props:{
                          name: 'checkPass'
                        }
                      }, '审核通过'),
                      h('DropdownItem', {
                        props:{
                          name: 'checkNotPass'
                        }
                      }, '审核不通过'),
                      h('DropdownItem', {
                        props:{
                          name: 'withdrawSuccess'
                        }
                      }, '提现成功'),
                      h('DropdownItem', {
                        props:{
                          name: 'withdrawFail'
                        }
                      }, '提现失败')
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
        } else if (itemName === 'checkPass') {
          check(row.transactionNo, 1).then(response => {
            if (response.data.code === ResponseStatus.OK) {
              this.search()
            } else {
              this.$Message.error(response.data.message)
            }
          }).catch(error => {
            console.log(error)
          })
        } else if (itemName === 'checkNotPass') {
          check(row.transactionNo, 2).then(response => {
            if (response.data.code === ResponseStatus.OK) {
              this.search()
            } else {
              this.$Message.error(response.data.message)
            }
          }).catch(error => {
            console.log(error)
          })
        } else if (itemName === 'withdrawSuccess') {
          confirm(row.transactionNo, 4).then(response => {
            if (response.data.code === ResponseStatus.OK) {
              this.search()
            } else {
              this.$Message.error(response.data.message)
            }
          }).catch(error => {
            console.log(error)
          })
        } else if (itemName === 'withdrawFail') {
          confirm(row.transactionNo, 5).then(response => {
            if (response.data.code === ResponseStatus.OK) {
              this.search()
            } else {
              this.$Message.error(response.data.message)
            }
          }).catch(error => {
            console.log(error)
          })
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
