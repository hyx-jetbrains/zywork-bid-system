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
      <FormItem label="手机号" prop="phone">
        <Input v-model="form.phone" />
      </FormItem>
      <FormItem label="用户邮箱" prop="email">
        <Input v-model="form.email" />
      </FormItem>
      <FormItem label="登录密码" prop="password">
        <Input v-model="form.password" />
      </FormItem>
      <FormItem label="加密盐值" prop="salt">
        <Input v-model="form.salt" />
      </FormItem>

    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
      <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
    </div>
  </Modal>
  <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
    <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
      <FormItem label="手机号" prop="phone">
        <Input v-model="form.phone" />
      </FormItem>
      <FormItem label="用户邮箱" prop="email">
        <Input v-model="form.email" />
      </FormItem>
      <FormItem label="登录密码" prop="password">
        <Input v-model="form.password" />
      </FormItem>
      <FormItem label="加密盐值" prop="salt">
        <Input v-model="form.salt" />
      </FormItem>

    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
      <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
    </div>
  </Modal>
  <Modal v-model="modal.search" title="高级搜索">
    <Form ref="searchForm" :model="searchForm" :label-width="80">
      <FormItem label="用户编号">
        <Row>
          <i-col span="11">
            <FormItem prop="idMin">
              <InputNumber v-model="searchForm.idMin" style="width: 100%;" />
            </FormItem>
          </i-col>
          <i-col span="2" style="text-align: center">-</i-col>
          <i-col span="11">
            <FormItem prop="idMax">
              <InputNumber v-model="searchForm.idMax" style="width: 100%;" />
            </FormItem>
          </i-col>
        </Row>
      </FormItem>
      <FormItem label="手机号" prop="phone">
        <Input v-model="searchForm.phone" />
      </FormItem>
      <FormItem label="用户邮箱" prop="email">
        <Input v-model="searchForm.email" />
      </FormItem>
      <FormItem label="是否激活" prop="isActive">
        <Select v-model="searchForm.isActive" placeholder="请选择是否激活" clearable filterable>
          <Option v-for="item in isActiveSelect" :value="item.value" :key="item.value">{{item.label}}</option>
        </Select>
      </FormItem>
      <FormItem label="创建时间">
        <Row>
          <i-col span="11">
            <FormItem prop="createTimeMin">
              <DatePicker @on-change="searchForm.createTimeMin=$event" :value="searchForm.createTimeMin" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
            </FormItem>
          </i-col>
          <i-col span="2" style="text-align: center">-</i-col>
          <i-col span="11">
            <FormItem prop="createTimeMax">
              <DatePicker @on-change="searchForm.createTimeMax=$event" :value="searchForm.createTimeMax" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
            </FormItem>
          </i-col>
        </Row>
      </FormItem>
      <FormItem label="更新时间">
        <Row>
          <i-col span="11">
            <FormItem prop="updateTimeMin">
              <DatePicker @on-change="searchForm.updateTimeMin=$event" :value="searchForm.updateTimeMin" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
            </FormItem>
          </i-col>
          <i-col span="2" style="text-align: center">-</i-col>
          <i-col span="11">
            <FormItem prop="updateTimeMax">
              <DatePicker @on-change="searchForm.updateTimeMax=$event" :value="searchForm.updateTimeMax" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
            </FormItem>
          </i-col>
        </Row>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
      <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
      <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">查询</Button>
    </div>
  </Modal>
  <Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
    <p>用户编号: <span v-text="form.id"></span></p>
    <p>手机号: <span v-text="form.phone"></span></p>
    <p>用户邮箱: <span v-text="form.email"></span></p>
    <p>创建时间: <span v-text="form.createTime"></span></p>
    <p>更新时间: <span v-text="form.updateTime"></span></p>
    <p>是否激活: <span v-text="form.isActive === 0 ? '激活' : '冻结'"></span></p>
    <p>用户昵称: <span v-text="userDetail.userDetailNickname"></span></p>
    <p>性别: <span v-text="userDetail.userDetailGender"></span></p>
    <p>生日: <span v-text="userDetail.userDetailBirthday"></span></p>
    <p>年龄: <span v-text="userDetail.userDetailAge"></span></p>
    <p>QQ: <span v-text="userDetail.userDetailQq"></span></p>
    <p>微信: <span v-text="userDetail.userDetailWechat"></span></p>
    <p>支付宝: <span v-text="userDetail.userDetailAlipay"></span></p>
    <p>分享码: <span v-text="userDetail.userDetailShareCode"></span></p>
  </Modal>
  <user-role-drawer ref="userRoleDrawer" />
</div>
</template>

<script>
import * as utils from '@/api/utils'
import * as ResponseStatus from '@/api/response-status'
import userRoleDrawer from './UserRoleDrawer.vue'
import {
  isActiveSelect
} from '@/api/select'
import {
  getUserDetail
} from '@/api/user'
export default {
  name: 'User',
  components: {
    userRoleDrawer
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
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/user/admin/save',
        batchAddUrl: '/user/admin/batch-save',
        editUrl: '/user/admin/update',
        batchEditUrl: '/user/admin/batch-update',
        searchUrl: '/user/admin/pager-cond',
        allUrl: '/user/admin/all',
        removeUrl: '/user/admin/remove/',
        batchRemoveUrl: '/user/admin/batch-remove',
        detailUrl: '/user/admin/one/',
        activeUrl: '/user/admin/active',
        batchActiveUrl: '/user/admin/batch-active'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        phone: null,
        email: null,
        password: null,
        salt: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      userDetail: {
        userId: null,
        userPhone: null,
        userEmail: null,
        userCreateTime: null,
        userDetailNickname: null,
        userDetailHeadicon: null,
        userDetailGender: null,
        userDetailBirthday: null,
        userDetailAge: null,
        userDetailQq: null,
        userDetailQqQrcode: null,
        userDetailWechat: null,
        userDetailWechatQrcode: null,
        userDetailAlipay: null,
        userDetailAlipayQrcode: null,
        userDetailShareCode: null,
        userDetailVersion: null,
      },
      validateRules: {
        phone: [{
          type: 'string',
          min: 1,
          max: 11,
          message: '必须1-11个字符',
          trigger: 'blur'
        }],
        email: [{
          type: 'string',
          min: 1,
          max: 100,
          message: '必须1-100个字符',
          trigger: 'blur'
        }],
        password: [{
          type: 'string',
          min: 1,
          max: 100,
          message: '必须1-100个字符',
          trigger: 'blur'
        }],
        salt: [{
          type: 'string',
          min: 1,
          max: 200,
          message: '必须1-200个字符',
          trigger: 'blur'
        }],

      },
      searchForm: {
        pageNo: 1,
        pageSize: 10,
        sortColumn: null,
        sortOrder: null,
        id: null,
        idMin: null,
        idMax: null,
        phone: null,
        email: null,
        password: null,
        salt: null,
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
        tableColumns: [{
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
              return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
            }
          },
          {
            title: '用户编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '手机号',
            key: 'phone',
            minWidth: 120,
            sortable: true
          },
          {
            title: '用户邮箱',
            key: 'email',
            minWidth: 120,
            sortable: true
          },
          {
            title: "版本号",
            key: "version",
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
            title: "操作",
            key: "action",
            width: 120,
            align: "center",
            fixed: "right",
            render: (h, params) => {
              return h(
                "Dropdown",
                {
                  on: {
                    "on-click": itemName => {
                      this.userOpt(itemName, params.row);
                    }
                  },
                  props: {
                    transfer: true
                  }
                },
                [
                  h(
                    "Button",
                    {
                      props: {
                        type: "primary",
                        size: "small"
                      }
                    },
                    [
                      "选择操作 ",
                      h("Icon", {
                        props: {
                          type: "ios-arrow-down"
                        }
                      })
                    ]
                  ),
                  h(
                    "DropdownMenu",
                    {
                      slot: "list"
                    },
                    [
                      h(
                        "DropdownItem",
                        {
                          props: {
                            name: "showEdit"
                          }
                        },
                        "编辑"
                      ),
                      h(
                        "DropdownItem",
                        {
                          props: {
                            name: "showDetail"
                          }
                        },
                        "详情"
                      ),
                      h(
                        "DropdownItem",
                        {
                          props: {
                            name: "remove"
                          }
                        },
                        [
                          h(
                            "span",
                            {
                              style: {
                                color: "red"
                              }
                            },
                            "删除"
                          )
                        ]
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'role'
                          }
                        },
                        '角色'
                      ),
                    ]
                  )
                ]
              );
            }
          }
        ],
        tableDetails: [],
        selections: []
      },
      isActiveSelect: isActiveSelect
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
    showEdit(modal, row) {
      utils.showModal(this, modal)
      this.form = JSON.parse(JSON.stringify(row))
    },
    showDetail(modal, row) {
      utils.showModal(this, modal)
      this.form = JSON.parse(JSON.stringify(row))
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
      if (itemName === "showEdit") {
        utils.showModal(this, "edit");
        this.form = JSON.parse(JSON.stringify(row));
      } else if (itemName === "showDetail") {
        utils.showModal(this, "detail");
        this.form = JSON.parse(JSON.stringify(row));
        getUserDetail(row.id).then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            if (data.data.total !== 0) {{
              this.userDetail = data.data.rows[0]
            }}
          } else {
            this.$Message.error(data.message)
          }
        })
      } else if (itemName === "remove") {
        utils.remove(this, row);
      } else if (itemName === 'role') {
        // 分配用户角色
        this.$refs.userRoleDrawer.initData(row.id)
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
    remove(row) {
      utils.remove(this, row)
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
