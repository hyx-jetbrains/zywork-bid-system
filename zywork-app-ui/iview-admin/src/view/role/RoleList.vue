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
          <Table
            ref="dataTable"
            stripe
            :loading="table.loading"
            :columns="table.tableColumns"
            :data="table.tableDetails"
            style="margin-top:20px;"
            @on-selection-change="changeSelection"
            @on-sort-change="changeSort"
          ></Table>
          <div style="margin: 20px;overflow: hidden">
            <div style="float: right;">
              <Page
                :total="page.total"
                :current="searchForm.pageNo"
                @on-change="changePageNo"
                @on-page-size-change="changePageSize"
                showSizer
                showTotal
              ></Page>
            </div>
          </div>
        </Card>
      </i-col>
    </Row>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="角色编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始角色编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束角色编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="角色标题" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入角色标题"/>
        </FormItem>
        <FormItem label="角色描述" prop="description">
          <Input v-model="searchForm.description" placeholder="请输入角色描述"/>
        </FormItem>
        <FormItem label="是否默认角色">
          <Row>
            <i-col span="11">
              <FormItem prop="isDefaultMin">
                <InputNumber
                  v-model="searchForm.isDefaultMin"
                  placeholder="请输入开始是否默认角色"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="isDefaultMax">
                <InputNumber
                  v-model="searchForm.isDefaultMax"
                  placeholder="请输入结束是否默认角色"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="版本号">
          <Row>
            <i-col span="11">
              <FormItem prop="versionMin">
                <InputNumber
                  v-model="searchForm.versionMin"
                  placeholder="请输入开始版本号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="versionMax">
                <InputNumber
                  v-model="searchForm.versionMax"
                  placeholder="请输入结束版本号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="创建时间">
          <Row>
            <i-col span="11">
              <FormItem prop="createTimeMin">
                <DatePicker
                  @on-change="searchForm.createTimeMin=$event"
                  :value="searchForm.createTimeMin"
                  placeholder="请输入开始创建时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="createTimeMax">
                <DatePicker
                  @on-change="searchForm.createTimeMax=$event"
                  :value="searchForm.createTimeMax"
                  placeholder="请输入结束创建时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="更新时间">
          <Row>
            <i-col span="11">
              <FormItem prop="updateTimeMin">
                <DatePicker
                  @on-change="searchForm.updateTimeMin=$event"
                  :value="searchForm.updateTimeMin"
                  placeholder="请输入开始更新时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="updateTimeMax">
                <DatePicker
                  @on-change="searchForm.updateTimeMax=$event"
                  :value="searchForm.updateTimeMax"
                  placeholder="请输入结束更新时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="是否激活">
          <Row>
            <i-col span="11">
              <FormItem prop="isActiveMin">
                <InputNumber
                  v-model="searchForm.isActiveMin"
                  placeholder="请输入开始是否激活"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="isActiveMax">
                <InputNumber
                  v-model="searchForm.isActiveMax"
                  placeholder="请输入结束是否激活"
                  style="width: 100%;"
                />
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
      <p>角色编号:
        <span v-text="form.id"></span>
      </p>
      <p>角色标题:
        <span v-text="form.title"></span>
      </p>
      <p>角色描述:
        <span v-text="form.description"></span>
      </p>
      <p>是否默认角色:
        <span v-text="form.isDefault"></span>
      </p>
      <p>版本号:
        <span v-text="form.version"></span>
      </p>
      <p>创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>是否激活:
        <span v-text="form.isActive"></span>
      </p>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import axios from '@/libs/api.request'
import {saveUserRole} from '@/api/user'
import * as ResponseStatus from '@/api/response-status'

export default {
  name: 'RoleList',
  props: {
    selectedData: null,
    selectedDataId: null,
    extraData: null
  },
  data() {
    return {
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false
      },
      loading: {
        search: false,
      },
      urls: {
        searchUrl: '/role/admin/pager-cond',
        allUrl: '/role/admin/all',
        detailUrl: '/role/admin/one/'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        title: null,
        description: null,
        isDefault: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      searchForm: {
        pageNo: 1,
        pageSize: 10,
        sortColumn: null,
        sortOrder: null,
        id: null,
        idMin: null,
        idMax: null,
        title: null,
        description: null,
        isDefault: null,
        isDefaultMin: null,
        isDefaultMax: null,
        version: null,
        versionMin: null,
        versionMax: null,
        createTime: null,
        createTimeMin: null,
        createTimeMax: null,
        updateTime: null,
        updateTimeMin: null,
        updateTimeMax: null,
        isActive: 0,
        isActiveMin: null,
        isActiveMax: null
      },
      table: {
        loading: false,
        tableColumns: [
          {
            type: 'selection',
            width: 45,
            key: 'id',
            align: 'center',
            fixed: 'left'
          },
          {
            width: 60,
            align: 'center',
            fixed: 'left',
            render: (h, params) => {
              return h(
                'span',
                params.index +
                  (this.searchForm.pageNo - 1) * this.searchForm.pageSize +
                  1
              )
            }
          },
          {
            title: '角色编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '角色标题',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '角色描述',
            key: 'description',
            minWidth: 120,
            sortable: true
          },
          {
            title: '是否默认角色',
            key: 'isDefault',
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
                h(
                  'Button',
                  {
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
                  },
                  '详情'
                )
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
  mounted() {},
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
      utils.initSelectTableData(this)
    },
    search() {
      utils.search(this)
    },
    changeSelection(selections) {
      utils.changeSelections(this, selections)
    },
    changeSort(sortColumn) {
      utils.changeSelectTableSort(this, sortColumn)
    },
    changePageNo(pageNo) {
      utils.changeSelectTablePageNo(this, pageNo)
    },
    changePageSize(pageSize) {
      utils.changeSelectTablePageSize(this, pageSize)
    },
    confirmSelection() {
      // 确认选择的逻辑
      if (this.extraData.userId === '') {
        this.$Message.error('请刷新页面重试')
        return
      }
      var params = []
      this.table.selections.forEach(item => {
        params.push({
          roleId: item.id,
          userId: this.extraData.userId
        })
      })
      saveUserRole(params)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.$Message.info("分配角色成功")
            this.$emit('closeDrawer')
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 初始化表格数据
    initTableData() {
      utils.initSelectTableData(this)
    },
    // 取消选择
    cancelSelect() {
      this.$refs.dataTable.selectAll(false);
    }
  }
}
</script>

<style>
</style>
