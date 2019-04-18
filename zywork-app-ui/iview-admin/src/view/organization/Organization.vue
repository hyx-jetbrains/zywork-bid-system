<template>
  <div>
    <Card>
      <Tabs value="orgTree">
        <TabPane label="结构树" name="orgTree">
          <Row style="height: 550px;">
            <div class="department-outer">
              <div class="tip-box">
                <!-- <b style="margin-right: 20px;">powered by <a target="blank" href="https://github.com/lison16">Lison</a></b>
                <a target="blank" href="https://github.com/lison16/v-org-tree" style="margin-right: 10px;">v-org-tree文档</a>-->
                <Tooltip content="刷新" placement="right">
                  <Button icon="md-refresh" type="success" shape="circle" @click="getDepartmentData"></Button>
                </Tooltip>
              </div>
              <div class="zoom-box">
                <zoom-controller v-model="zoom" :min="20" :max="200"></zoom-controller>
              </div>
              <div class="view-box">
                <org-view
                  v-if="orgTreeData"
                  :data="orgTreeData"
                  :zoom-handled="zoomHandled"
                  @on-menu-click="handleMenuClick"
                ></org-view>
              </div>
            </div>
          </Row>
          <Spin size="large" fix v-if="orgTreeSpinShow"></Spin>
        </TabPane>
        <TabPane label="列表" name="listTable">
          <Row>
            <i-col span="24">
              <Button @click="showModal('add')" type="primary">添加</Button>&nbsp;
              <Dropdown @on-click="batchOpt">
                <Button type="primary">批量操作
                  <Icon type="ios-arrow-down"></Icon>
                </Button>
                <DropdownMenu slot="list">
                  <DropdownItem name="batchActive">批量激活</DropdownItem>
                  <DropdownItem name="batchInactive">
                    <span style="color: red;">批量冻结</span>
                  </DropdownItem>
                  <DropdownItem name="batchRemove" divided>
                    <span style="color: red;">批量删除</span>
                  </DropdownItem>
                </DropdownMenu>
              </Dropdown>&nbsp;
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
            </i-col>
          </Row>
        </TabPane>
      </Tabs>
    </Card>

    <Modal
      v-model="modal.add"
      title="添加"
      @on-visible-change="changeModalVisibleResetForm('addForm', $event)"
    >
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="父编号" prop="parentId">
          <InputNumber v-model="form.parentId" placeholder="请输入父编号" style="width: 100%;"/>
        </FormItem>
        <FormItem label="组织名称" prop="title">
          <Input v-model="form.title" placeholder="请输入组织名称"/>
        </FormItem>
        <FormItem label="组织描述" prop="description">
          <Input v-model="form.description" placeholder="请输入组织描述"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal
      v-model="modal.edit"
      title="修改"
      @on-visible-change="changeModalVisibleResetForm('editForm', $event)"
    >
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="父编号" prop="parentId">
          <InputNumber v-model="form.parentId" placeholder="请输入父编号" style="width: 100%;"/>
        </FormItem>
        <FormItem label="组织名称" prop="title">
          <Input v-model="form.title" placeholder="请输入组织名称"/>
        </FormItem>
        <FormItem label="组织描述" prop="description">
          <Input v-model="form.description" placeholder="请输入组织描述"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="组织编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始组织编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束组织编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="父编号">
          <Row>
            <i-col span="11">
              <FormItem prop="parentIdMin">
                <InputNumber
                  v-model="searchForm.parentIdMin"
                  placeholder="请输入开始父编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="parentIdMax">
                <InputNumber
                  v-model="searchForm.parentIdMax"
                  placeholder="请输入结束父编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="组织名称" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入组织名称"/>
        </FormItem>
        <FormItem label="组织描述" prop="description">
          <Input v-model="searchForm.description" placeholder="请输入组织描述"/>
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
        <Button
          type="primary"
          size="large"
          @click="searchOkModal('search')"
          :loading="loading.search"
        >搜索</Button>
      </div>
    </Modal>
    <Modal
      v-model="modal.detail"
      title="详情"
      @on-visible-change="changeModalVisibleResetForm('editForm', $event)"
    >
      <p>
        组织编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        父编号:
        <span v-text="form.parentId"></span>
      </p>
      <p>
        组织名称:
        <span v-text="form.title"></span>
      </p>
      <p>
        组织描述:
        <span v-text="form.description"></span>
      </p>
      <p>
        版本号:
        <span v-text="form.version"></span>
      </p>
      <p>
        创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>
        更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>
        是否激活:
        <span v-text="form.isActive"></span>
      </p>
    </Modal>
  </div>
</template>

<script>
import axios from '@/libs/api.request'
import * as utils from '@/api/utils'
import OrgView from './components/org-view.vue'
import ZoomController from './components/zoom-controller.vue'
import * as ResponseStatus from '@/api/response-status'
import './index.less'
const menuDic = {
  edit: '编辑部门',
  detail: '查看部门',
  new: '新增子部门',
  delete: '删除部门'
}

export default {
  name: 'Organization',
  components: {
    OrgView,
    ZoomController
  },
  data() {
    return {
      orgTreeData: null,
      zoom: 100,
      orgTreeSpinShow: false,
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
        addUrl: '/organization/admin/save',
        batchAddUrl: '/organization/admin/batch-save',
        editUrl: '/organization/admin/update',
        batchEditUrl: '/organization/admin/batch-update',
        searchUrl: '/organization/admin/pager-cond',
        allUrl: '/organization/admin/all',
        removeUrl: '/organization/admin/remove/',
        batchRemoveUrl: '/organization/admin/batch-remove',
        detailUrl: '/organization/admin/one/',
        activeUrl: '/organization/admin/active',
        batchActiveUrl: '/organization/admin/batch-active',
        allCondUrl: '/organization/admin/all-cond'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        parentId: null,
        title: null,
        description: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        parentId: [
          {
            type: 'integer',
            required: true,
            message: '此项为必须项',
            trigger: 'blur, change'
          }
        ],
        title: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        description: [
          {
            type: 'string',
            min: 1,
            max: 255,
            message: '必须1-255个字符',
            trigger: 'blur'
          }
        ]
      },
      searchForm: {
        pageNo: 1,
        pageSize: 10,
        sortColumn: null,
        sortOrder: null,
        id: null,
        idMin: null,
        idMax: null,
        parentId: null,
        parentIdMin: null,
        parentIdMax: null,
        title: null,
        description: null,
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
            title: '组织编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '父编号',
            key: 'parentId',
            minWidth: 120,
            sortable: true
          },
          {
            title: '组织名称',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '组织描述',
            key: 'description',
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
              return h(
                'i-switch',
                {
                  props: {
                    size: 'large',
                    value: params.row.isActive === 0
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    'on-change': status => {
                      this.active(params.row)
                    }
                  }
                },
                [
                  h(
                    'span',
                    {
                      slot: 'open'
                    },
                    '激活'
                  ),
                  h(
                    'span',
                    {
                      slot: 'close'
                    },
                    '冻结'
                  )
                ]
              )
            }
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
                            name: 'showEdit'
                          }
                        },
                        '编辑'
                      ),
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
                            name: 'remove'
                          }
                        },
                        [
                          h(
                            'span',
                            {
                              style: {
                                color: 'red'
                              }
                            },
                            '删除'
                          )
                        ]
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
  computed: {
    zoomHandled() {
      return this.zoom / 100
    }
  },
  mounted() {
    this.getDepartmentData()
    this.search()
  },
  methods: {
    setDepartmentData(data) {
      data.isRoot = true
      return data
    },
    handleMenuClick({ data, key }) {
      const keyStr = JSON.stringify(key)
      const row = this.getRow(data.id)
      if (keyStr === '"edit"') {
        // 编辑部门
        utils.showModal(this, 'edit')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (keyStr === '"detail"') {
        // 查看部门
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (keyStr === '"new"') {
        // 新增子部门
        this.form.parentId = data.id
        this.showModal('add')
      } else if (keyStr === '"delete"') {
        // 删除部门
        utils.remove(this, row).then(res => {
          if (res.data.code === ResponseStatus.OK) {
            this.getDepartmentData()
          }
        })
      }
    },
    getDepartmentData() {
      this.orgTreeSpinShow = true
      this.searchForm.sortColumn = 'parentId'
      this.searchForm.sortOrder = 'asc'
      axios.request({
        url: this.urls.allCondUrl,
        method: 'POST',
        data: this.searchForm
      }).then(res => {
        this.orgTreeSpinShow = false
        const data = res.data
        if (data.code !== ResponseStatus.OK) {
          this.$Message.error(data.message)
          return
        }
        this.orgTreeData = this.getOrg(data.data.rows)
      }).catch(err => {
        this.$Message.error(err)
      })
    },
    // 对orgData循环，如果data.rows中的每个组织对象数据的parentId等于已经存在于orgData中的某个对象的id，则添加为其children
    getOrg(rows) {
      var orgData = {
        id: 0,
        label: '',
        children: []
      }
      for (var i = 0, len = rows.length; i < len; i++) {
        var row = rows[i]
        if (row.parentId === 0) {
          // 顶级
          orgData.id = row.id
          orgData.label = row.title
          orgData.children = []
        } else {
          // 非顶级
          if (orgData.children.length === 0) {
            // 如果顶级的子部门为空，则直接放入
            orgData.children.push({
              id: row.id,
              label: row.title,
              children: []
            })
          } else {
            // 如果顶级部门的子部门不为空，需要判断是否为子部门的子部门
            for (
              var j = 0, len1 = orgData.children.length;
              j < len1;
              j++
            ) {
              var org = orgData.children[j]
              if (org.id === row.parentId) {
                // 如果是子部门的子部门
                org.children.push({
                  id: row.id,
                  label: row.title,
                  children: []
                })
              } else {
                // 如果不是子部门的子部门，则直接添加为顶级的子部门
                orgData.children.push({
                  id: row.id,
                  label: row.title,
                  children: []
                })
              }
              break
            }
          }
        }
      }
      return orgData
    },
    // 根据id取表格行数据
    getRow(id) {
      var row = Object
      this.table.tableDetails.forEach(item => {
        if (item.id === id) {
          row = item
          return row
        }
      })
      return row
    },
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
        utils.remove(this, row).then(res => {
          if (res.data.code === ResponseStatus.OK) {
            this.getDepartmentData()
          }
        })
      }
    },
    add() {
      utils.add(this).then(res => {
        if (res.data.code === ResponseStatus.OK) {
          this.getDepartmentData()
        }
      })
    },
    edit() {
      utils.edit(this).then(res => {
        if (res.data.code === ResponseStatus.OK) {
          this.getDepartmentData()
        }
      })
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
