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
        <FormItem label="专家预约编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始专家预约编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束专家预约编号" style="width: 100%;"/>
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
<FormItem label="预约专家编号"><Row>
	<i-col span="11">
	<FormItem prop="expertUserIdMin">
	<InputNumber v-model="searchForm.expertUserIdMin" placeholder="请输入开始预约专家编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="expertUserIdMax">
	<InputNumber v-model="searchForm.expertUserIdMax" placeholder="请输入结束预约专家编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="问题类型" prop="questionType">
	<Input v-model="searchForm.questionType" placeholder="请输入问题类型"/>
</FormItem>
<FormItem label="问题说明" prop="questionDesc">
	<Input v-model="searchForm.questionDesc" placeholder="请输入问题说明"/>
</FormItem>
<FormItem label="回复用户编号"><Row>
	<i-col span="11">
	<FormItem prop="replyUserIdMin">
	<InputNumber v-model="searchForm.replyUserIdMin" placeholder="请输入开始回复用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="replyUserIdMax">
	<InputNumber v-model="searchForm.replyUserIdMax" placeholder="请输入结束回复用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="回复内容" prop="replyContent">
	<Input v-model="searchForm.replyContent" placeholder="请输入回复内容"/>
</FormItem>
<FormItem label="回复时间"><Row>
	<i-col span="11">
	<FormItem prop="replyTimeMin">
	<DatePicker @on-change="searchForm.replyTimeMin=$event" :value="searchForm.replyTimeMin" placeholder="请输入开始回复时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="replyTimeMax">
	<DatePicker @on-change="searchForm.replyTimeMax=$event" :value="searchForm.replyTimeMax" placeholder="请输入结束回复时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="预约状态" prop="subscribeStatus">
	<Input v-model="searchForm.subscribeStatus" placeholder="请输入预约状态"/>
</FormItem>
<FormItem label="预约价格"><Row>
	<i-col span="11">
	<FormItem prop="priceMin">
	<InputNumber v-model="searchForm.priceMin" placeholder="请输入开始预约价格" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="priceMax">
	<InputNumber v-model="searchForm.priceMax" placeholder="请输入结束预约价格" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付状态" prop="payStatus">
	<Input v-model="searchForm.payStatus" placeholder="请输入支付状态"/>
</FormItem>
<FormItem label="支付方式" prop="payType">
	<Input v-model="searchForm.payType" placeholder="请输入支付方式"/>
</FormItem>
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="searchForm.transactionNo" placeholder="请输入交易编号"/>
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
      <p>专家预约编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>预约专家编号: <span v-text="form.expertUserId"></span></p>
<p>问题类型: <span v-text="form.questionType"></span></p>
<p>问题说明: <span v-text="form.questionDesc"></span></p>
<p>回复用户编号: <span v-text="form.replyUserId"></span></p>
<p>回复内容: <span v-text="form.replyContent"></span></p>
<p>回复时间: <span v-text="form.replyTime"></span></p>
<p>预约状态: <span v-text="form.subscribeStatus"></span></p>
<p>预约价格: <span v-text="form.price"></span></p>
<p>支付状态: <span v-text="form.payStatus"></span></p>
<p>支付方式: <span v-text="form.payType"></span></p>
<p>交易编号: <span v-text="form.transactionNo"></span></p>
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
    name: 'ExpertSubscribeListSingle',
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
          searchUrl: '/expersubscribe/admin/pager-cond',
          allUrl: '/expersubscribe/admin/all',
          detailUrl: '/expersubscribe/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
expertUserId: null,
questionType: null,
questionDesc: null,
replyUserId: null,
replyContent: null,
replyTime: null,
subscribeStatus: null,
price: null,
payStatus: null,
payType: null,
transactionNo: null,
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
expertUserId: null,
expertUserIdMin: null, 
expertUserIdMax: null, 
questionType: null,
questionDesc: null,
replyUserId: null,
replyUserIdMin: null, 
replyUserIdMax: null, 
replyContent: null,
replyTime: null,
replyTimeMin: null, 
replyTimeMax: null, 
subscribeStatus: null,
price: null,
priceMin: null, 
priceMax: null, 
payStatus: null,
payType: null,
transactionNo: null,
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
title: '专家预约编号',
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
title: '预约专家编号',
key: 'expertUserId',
minWidth: 120,
sortable: true
},
{
title: '问题类型',
key: 'questionType',
minWidth: 120,
sortable: true
},
{
title: '问题说明',
key: 'questionDesc',
minWidth: 120,
sortable: true
},
{
title: '回复用户编号',
key: 'replyUserId',
minWidth: 120,
sortable: true
},
{
title: '回复内容',
key: 'replyContent',
minWidth: 120,
sortable: true
},
{
title: '回复时间',
key: 'replyTime',
minWidth: 120,
sortable: true
},
{
title: '预约状态',
key: 'subscribeStatus',
minWidth: 120,
sortable: true
},
{
title: '预约价格',
key: 'price',
minWidth: 120,
sortable: true
},
{
title: '支付状态',
key: 'payStatus',
minWidth: 120,
sortable: true
},
{
title: '支付方式',
key: 'payType',
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
