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
    <Modal
      v-model="modal.add"
      title="添加"
      @on-visible-change="changeModalVisibleResetForm('addForm', $event)"
      :fullscreen="true"
    >
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="公告标题" prop="title">
          <Input v-model="form.title" placeholder="请输入公告标题"/>
        </FormItem>
        <FormItem label="公告简介" prop="synopsis">
          <Input
            v-model="form.synopsis"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入公告简介"
          />
        </FormItem>
        <FormItem label="资源编号" prop="resourceId">
          <Upload
            type="drag"
            :action="urls.uploadResourceUrl"
            :on-success="handleSuccess"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            :on-progress="handleProgress"
            :format="['doc','docx','pdf']"
            :max-size="10240"
            :headers="uploadHeader"
          >
            <div style="padding: 20px 0">
              <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
              <p>单击或拖动文件到此处上传</p>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="公告内容" prop="content">
          <editor ref="editorAdd" :value="form.content" @on-change="handleChange"/>
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
      :fullscreen="true"
    >
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="公告标题" prop="title">
          <Input v-model="form.title" placeholder="请输入公告标题"/>
        </FormItem>
        <FormItem label="资源编号" prop="resourceId">
          <Upload
            type="drag"
            :action="urls.uploadResourceUrl"
            :on-success="handleSuccess"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            :on-progress="handleProgress"
            :format="['doc','docx','pdf']"
            :max-size="10240"
            :headers="uploadHeader"
          >
            <div style="padding: 20px 0">
              <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
              <p>单击或拖动文件到此处上传</p>
            </div>
          </Upload>
          <p style="color: red;">注：重新上传附件，会覆盖之前的附件，如不上传，则没有影响</p>
        </FormItem>
        <FormItem label="公告简介" prop="synopsis">
          <Input
            v-model="form.synopsis"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入公告简介"
          />
        </FormItem>
        <FormItem label="公告内容" prop="content">
          <editor ref="editorEdit" :value="form.content" @on-change="handleChange"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="更新公告编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始更新公告编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束更新公告编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="公告标题" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入公告标题"/>
        </FormItem>
        <FormItem label="公告简介" prop="synopsis">
          <Input v-model="searchForm.synopsis" placeholder="请输入公告简介"/>
        </FormItem>
        <FormItem label="是否激活" prop="isActive">
          <Select v-model="searchForm.isActive" placeholder="请选择是否激活" clearable filterable>
            <i-option
              v-for="item in isActiveSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
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
        通知公告编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        公告标题:
        <span v-text="form.title"></span>
      </p>
      <p>
        公告简介:
        <span v-text="form.synopsis"></span>
      </p>
      <p>
        版本号:
        <span v-text="form.version"></span>
      </p>
      <p>
        更新时间:
        <span v-text="form.updateTime"></span>
      </p>
      <p>
        创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>
        是否激活:
        <span v-text="form.isActive"></span>
      </p>
    </Modal>
    <Modal v-model="modal.detailContent" title="内容详情" :fullscreen="true">
      <span v-html="form.content"></span>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import Editor from '_c/editor'
import { isActiveSelect } from '@/api/select'
import * as ResponseStatus from '@/api/response-status'
import config from '@/config'
const baseUrl =
  process.env.NODE_ENV === 'development'
    ? config.baseUrl.dev
    : config.baseUrl.pro
const cdnUrl = config.baseUrl.cdnUrl
import { getLocalStorageToken } from '@/libs/util'

export default {
  name: 'UpdateNotice',
  components: {
    Editor
  },
  data() {
    return {
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false,
        detailContent: false
      },
      loading: {
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/update-notice/admin/save',
        batchAddUrl: '/update-notice/admin/batch-save',
        editUrl: '/update-notice/admin/update',
        batchEditUrl: '/update-notice/admin/batch-update',
        searchUrl: '/update-notice/admin/pager-cond',
        allUrl: '/update-notice/admin/all',
        removeUrl: '/update-notice/admin/remove/',
        batchRemoveUrl: '/update-notice/admin/batch-remove',
        detailUrl: '/update-notice/admin/one/',
        activeUrl: '/update-notice/admin/active',
        batchActiveUrl: '/update-notice/admin/batch-active',
        uploadUrl: '/update-notice/admin/admin/upload-img',
        uploadResourceUrl: baseUrl + '/update-notice/admin/upload-res/'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        title: null,
        content: null,
        synopsis: null,
        resourceId: null,
        version: null,
        updateTime: null,
        createTime: null,
        isActive: null
      },
      validateRules: {
        title: [
          {
            type: 'string',
            min: 1,
            max: 200,
            message: '必须1-200个字符',
            trigger: 'blur'
          }
        ],
        content: [
          {
            type: 'string',
            min: 1,
            max: 65535,
            message: '必须1-65535个字符',
            trigger: 'blur'
          }
        ],
        synopsis: [
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
        title: null,
        resourceId: null,
        content: null,
        synopsis: null,
        version: null,
        versionMin: null,
        versionMax: null,
        updateTime: null,
        updateTimeMin: null,
        updateTimeMax: null,
        createTime: null,
        createTimeMin: null,
        createTimeMax: null,
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
            title: '通知公告编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公告标题',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公告内容',
            key: 'content',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              return h(
                'a',
                {
                  on: {
                    click: () => {
                      this.showModal('detailContent')
                      this.form = JSON.parse(JSON.stringify(params.row))
                    }
                  }
                },
                '点击查看'
              )
            }
          },
          {
            title: '公告简介',
            key: 'synopsis',
            minWidth: 120,
            sortable: true
          },
          {
            title: '附件编号',
            key: 'resourceId',
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
            title: '更新时间',
            key: 'updateTime',
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
                      // h(
                      //   'DropdownItem',
                      //   {
                      //     props: {
                      //       name: 'showEnclosure'
                      //     }
                      //   },
                      //   '附件'
                      // ),
                    ]
                  )
                ]
              )
            }
          }
        ],
        tableDetails: [],
        selections: []
      },
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
      },
      isActiveSelect: isActiveSelect,
      uploadHeader: {
        Authorization: 'Bearer ' + getLocalStorageToken()
      }
    }
  },
  computed: {},
  mounted() {
    this.search()
    this.$refs.editorAdd.initEditor(this.urls.uploadUrl)
    this.$refs.editorEdit.initEditor(this.urls.uploadUrl)
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
        this.$refs.editorEdit.setHtml(this.form.content)
      } else if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'remove') {
        utils.remove(this, row)
      } else if (itemName === 'showEnclosure') {
        // 查看附件
        this.showNoticeResource(row.id)
      }
    },
    // 前往通知公告附件
    showNoticeResource(id) {
      this.$router.push({
        name: 'update_notice_resource',
        params: { noticeId: id }
      })
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
    handleChange(html, text) {
      this.form.content = html
    },
    handleSuccess(res, file) {
      if (res.code === ResponseStatus.OK) {
        this.$Notice.success({
          title: '上传成功',
          desc: file.name + ' 上传成功'
        })
        this.form.resourceId = res.data.id
      } else {
        this.$Notice.error({
          title: '上传失败',
          desc: res.message
        })
      }
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: '资源格式不正确',
        desc:
          file.name + ' 资源格式不正确，请选择DOC或者DOCX或者PDF格式的文档。'
      })
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: '超出文件大小限制',
        desc: file.name + ' 太大，不得超10M.'
      })
    },
    handleProgress(event, file) {
      this.$Notice.info({
        title: '文件正在上传',
        desc: file.name + ' 上传中...'
      })
    }
  }
}
</script>

<style>
</style>
