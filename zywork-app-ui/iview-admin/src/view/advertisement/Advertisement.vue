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
        <FormItem label="轮播图标题" prop="title">
          <Input v-model="form.title" placeholder="请输入轮播图标题"/>
        </FormItem>
        <FormItem label="封面图片" prop="imgUrl">
          <img :v-if="form.url !== ''" :src="form.url">
          <Upload
            ref="upload"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            multiple
            type="drag"
            :action="urls.uploadUrl"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="内容" prop="content">
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
        <FormItem label="轮播图标题" prop="title">
          <Input v-model="form.title" placeholder="请输入轮播图标题"/>
        </FormItem>
        <FormItem label="封面图片" prop="imgUrl">
          <img :v-if="form.url !== ''" :src="form.url">
          <Upload
            ref="upload"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            multiple
            type="drag"
            :action="urls.uploadUrl"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="内容" prop="content">
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
        <FormItem label="轮播广告编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始轮播广告编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束轮播广告编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="轮播图标题" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入轮播图标题"/>
        </FormItem>
        <FormItem label="是否激活" prop="isActive">
        <Select v-model="searchForm.isActive" placeholder="请选择是否激活" clearable filterable>
          <Option v-for="item in isActiveSelect" :value="item.value" :key="item.value">{{item.label}}</option>
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
        轮播广告编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        轮播图标题:
        <span v-text="form.title"></span>
      </p>
      <p>
        内容:
        <span v-html="form.content"></span>
      </p>
      <p>
        封面图:
        <img :src="form.url" />
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
      <p>是否激活: <span v-text="form.isActive === 0 ? '激活' : '冻结'"></span></p>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import * as responseStatus from '@/api/response-status'
import {
  isActiveSelect
} from '@/api/select'
import Editor from '_c/editor'
import config from '@/config'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
const cdnUrl = config.baseUrl.cdnUrl

export default {
  name: 'Advertisement',
  components: {
    Editor
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
        addUrl: '/advertisement/admin/save',
        batchAddUrl: '/advertisement/admin/batch-save',
        editUrl: '/advertisement/admin/update',
        batchEditUrl: '/advertisement/admin/batch-update',
        searchUrl: '/advertisement/admin/pager-cond',
        allUrl: '/advertisement/admin/all',
        removeUrl: '/advertisement/admin/remove/',
        batchRemoveUrl: '/advertisement/admin/batch-remove',
        detailUrl: '/advertisement/admin/one/',
        activeUrl: '/advertisement/admin/active',
        batchActiveUrl: '/advertisement/admin/batch-active',
        uploadUrl: baseUrl + '/advertisement/admin/upload-img'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        title: null,
        content: null,
        imgUrl: null,
        url: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        title: [
          {
            type: 'string',
            min: 1,
            max: 32,
            message: '必须1-32个字符',
            trigger: 'blur'
          }
        ],
        content: [
          {
            type: 'string',
            min: 1,
            max: 2000,
            message: '必须1-2000个字符',
            trigger: 'blur'
          }
        ],
        imgUrl: [
          {
            type: 'string',
            min: 1,
            max: 200,
            message: '必须1-200个字符',
            trigger: 'blur'
          }
        ],
        url: [
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
        content: null,
        imgUrl: null,
        url: null,
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
            title: '轮播广告编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '轮播图标题',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '内容',
            key: 'content',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              return h('a', {
                  on: {
                    click: () => {
                      utils.showModal(this, 'detail')
                      this.form = JSON.parse(JSON.stringify(params.row))
                    }
                  }
                },'点击查看')
            }
          },
          {
            title: '图片地址',
            key: 'imgUrl',
            minWidth: 120,
            sortable: true
          },
          {
            title: 'URL链接',
            key: 'url',
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
      },
      isActiveSelect: isActiveSelect
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
      if (modal === 'add') {
        this.form.url = ''
      }
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
      }
    },
    add() {
      console.log(this.form.content)
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
      if (res.code === responseStatus.OK) {
        this.$Notice.success({
          title: '上传成功',
          desc: file.name + ' 上传成功'
        })
        this.form.imgUrl = res.data
        this.form.url = cdnUrl + "/" + res.data
      } else {
        this.$Notice.error({
          title: '上传失败',
          desc: res.message
        })
      }
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: '文件格式不正确',
        desc: file.name + ' 文件格式不正确，请选择JPG或PNG。'
      })
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: '超出文件大小限制',
        desc: file.name + ' 太大，不得超过2M.'
      })
    },
  }
}
</script>

<style>
</style>
