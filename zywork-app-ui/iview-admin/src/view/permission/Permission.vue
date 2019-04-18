<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="showModal('add')" type="primary">添加</Button>&nbsp;
          <Dropdown @on-click="batchOpt">
            <Button type="primary">导入导出
              <Icon type="ios-arrow-down"></Icon>
            </Button>
            <DropdownMenu slot="list">
              <DropdownItem name="import">
                导入权限
              </DropdownItem>
              <DropdownItem name="export">
                <span style="color: green;">导出权限</span>
              </DropdownItem>
            </DropdownMenu>
          </Dropdown>&nbsp;
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
        </Card>
      </i-col>
    </Row>
    <UploadModal ref="uploadModal"
      @search="search"
      :title="uploadModal.title"
      :format="uploadModal.format"/>
    <Modal
      v-model="modal.add"
      title="添加"
      @on-visible-change="changeModalVisibleResetForm('addForm', $event)"
    >
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="所属模块" prop="moduleId">
          <InputNumber v-model="form.moduleId" placeholder="请输入所属模块" style="width: 100%;"/>
        </FormItem>
        <FormItem label="权限标题" prop="title">
          <Input v-model="form.title" placeholder="请输入权限标题"/>
        </FormItem>
        <FormItem label="权限字符串" prop="permission">
          <Input v-model="form.permission" placeholder="请输入权限字符串"/>
        </FormItem>
        <FormItem label="权限描述" prop="description">
          <Input v-model="form.description" placeholder="请输入权限描述"/>
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
        <FormItem label="所属模块" prop="moduleId">
          <InputNumber v-model="form.moduleId" placeholder="请输入所属模块" style="width: 100%;"/>
        </FormItem>
        <FormItem label="权限标题" prop="title">
          <Input v-model="form.title" placeholder="请输入权限标题"/>
        </FormItem>
        <FormItem label="权限字符串" prop="permission">
          <Input v-model="form.permission" placeholder="请输入权限字符串"/>
        </FormItem>
        <FormItem label="权限描述" prop="description">
          <Input v-model="form.description" placeholder="请输入权限描述"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="权限编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始权限编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束权限编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="所属模块">
          <Row>
            <i-col span="11">
              <FormItem prop="moduleIdMin">
                <InputNumber
                  v-model="searchForm.moduleIdMin"
                  placeholder="请输入开始所属模块"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="moduleIdMax">
                <InputNumber
                  v-model="searchForm.moduleIdMax"
                  placeholder="请输入结束所属模块"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="权限标题" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入权限标题"/>
        </FormItem>
        <FormItem label="权限字符串" prop="permission">
          <Input v-model="searchForm.permission" placeholder="请输入权限字符串"/>
        </FormItem>
        <FormItem label="权限描述" prop="description">
          <Input v-model="searchForm.description" placeholder="请输入权限描述"/>
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
      <p>权限编号:
        <span v-text="form.id"></span>
      </p>
      <p>所属模块:
        <span v-text="form.moduleId"></span>
      </p>
      <p>权限标题:
        <span v-text="form.title"></span>
      </p>
      <p>权限字符串:
        <span v-text="form.permission"></span>
      </p>
      <p>权限描述:
        <span v-text="form.description"></span>
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
    <moduleDetail :form="moduleDetailForm" :detail="modal.moduleDetail" v-on:setDetail="setDetailModal"/>
    <Modal
      :transfer="false"
      fullscreen
      v-model="modal.moduleSearch"
      title="搜索主表信息">
      <module-list-single ref="moduleListSingle" v-on:confirmSelection="confirmSelection"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('moduleSearch')">取消</Button>
        <Button type="primary" size="large" @click="confirm">确认选择</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import UploadModal from '_c/upload-modal'
import moduleDetail from '@/view/module/ModuleDetail.vue'
import moduleListSingle from '@/view/module/ModuleListSingle.vue'
import {getModuleById} from '@/api/module'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'Permission',
  components: {
    UploadModal,
    moduleDetail,
    moduleListSingle
  },
  data() {
    return {
      uploadModal: {
        title: '导入权限信息',
        format: ['json'],
        uploadUrl: '/permission-import-export/import-permission'
      },
      exportFileName: 'permission.json',
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false,
        moduleDetail: false,
        moduleSearch: false
      },
      loading: {
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/permission/admin/save',
        batchAddUrl: '/permission/admin/batch-save',
        editUrl: '/permission/admin/update',
        batchEditUrl: '/permission/admin/batch-update',
        searchUrl: '/permission/admin/pager-cond',
        allUrl: '/permission/admin/all',
        removeUrl: '/permission/admin/remove/',
        batchRemoveUrl: '/permission/admin/batch-remove',
        detailUrl: '/permission/admin/one/',
        activeUrl: '/permission/admin/active',
        batchActiveUrl: '/permission/admin/batch-active',
        exportUrl: '/permission-import-export/export-permission'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        moduleId: null,
        title: null,
        permission: null,
        description: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      moduleDetailForm: {
        id: null,
        title: null,
        description: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        moduleId: [
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
            max: 50,
            message: '必须1-50个字符',
            trigger: 'blur'
          }
        ],
        permission: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 200,
            message: '必须1-200个字符',
            trigger: 'blur'
          }
        ],
        description: [
          {
            type: 'string',
            min: 1,
            max: 200,
            message: '必须1-200个字符',
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
        moduleId: null,
        moduleIdMin: null,
        moduleIdMax: null,
        title: null,
        permission: null,
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
            title: '权限编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '所属模块',
            key: 'moduleId',
            minWidth: 120,
            sortable: true,
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
                    'span',
                    [
                      params.row.moduleId,
                      h('Icon', {
                        props: {
                          type: 'ios-list',
                          size: '25'
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
                            name: 'moduleDetail'
                          }
                        },
                        '详情'
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showSearch'
                          }
                        },
                        '搜索'
                      )
                    ]
                  )
                ]
              )
            }
          },
          {
            title: '权限标题',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '权限字符串',
            key: 'permission',
            minWidth: 120,
            sortable: true
          },
          {
            title: '权限描述',
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
  computed: {},
  mounted() {
    this.search()
  },
  methods: {
    showUploadModal() {
      this.$refs.uploadModal.uploadUrl = this.uploadModal.uploadUrl
      this.$refs.uploadModal.uploadModal = true
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
      this.searchForm.moduleId = null
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
      } else if (itemName === 'import') {
        this.showUploadModal()
      } else if (itemName === 'export') {
        utils.exportJson(this)
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
      } else if (itemName === 'moduleDetail') {
        this.showModuleDetailModal(row.moduleId)
      } else if (itemName === 'showSearch') {
        utils.showModal(this, 'moduleSearch')
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
    },
    setDetailModal(val) {
      this.modal.moduleDetail = val
    },
    showModuleDetailModal(id) {
      getModuleById(id)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.moduleDetailForm = data.data
            this.modal.moduleDetail = true
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    confirmSelection(moduleId) {
      this.modal.moduleSearch = false
      this.searchForm.moduleIdMin = moduleId
      this.searchForm.moduleIdMax = moduleId
      utils.search(this)
    },
    confirm() {
      this.$refs.moduleListSingle.confirmSelection()
    }
  }
}
</script>

<style>
</style>
