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
        <FormItem label="项目编号" prop="projectId">
          <span v-text="form.projectId" />
          &nbsp;<Button @click="showModal('projectChoice')" type="text">选择项目</Button>&nbsp;
        </FormItem>
        <FormItem label="第一候选人" prop="firstCandidate">
          <Input v-model="form.firstCandidate" placeholder="请输入第一候选人"/>
        </FormItem>
        <FormItem label="第二候选人" prop="secondCandidate">
          <Input v-model="form.secondCandidate" placeholder="请输入第二候选人"/>
        </FormItem>
        <FormItem label="第三候选人" prop="thirdCandidate">
          <Input v-model="form.thirdCandidate" placeholder="请输入第三候选人"/>
        </FormItem>
        <FormItem label="源地址" prop="sourceUrl">
          <Input v-model="form.sourceUrl" placeholder="请输入源地址" />
        </FormItem>
        <FormItem label="公示详情" prop="announceDesc">
          <editor ref="editorAdd" :value="form.announceDesc" @on-change="handleChange"/>
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
        <FormItem label="项目编号" prop="projectId">
          <span v-text="form.projectId" />
          &nbsp;<Button @click="showModal('projectChoice')" type="text">选择项目</Button>&nbsp;
        </FormItem>
        <FormItem label="第一候选人" prop="firstCandidate">
          <Input v-model="form.firstCandidate" placeholder="请输入第一候选人"/>
        </FormItem>
        <FormItem label="第二候选人" prop="secondCandidate">
          <Input v-model="form.secondCandidate" placeholder="请输入第二候选人"/>
        </FormItem>
        <FormItem label="第三候选人" prop="thirdCandidate">
          <Input v-model="form.thirdCandidate" placeholder="请输入第三候选人"/>
        </FormItem>
        <FormItem label="源地址" prop="sourceUrl">
          <Input v-model="form.sourceUrl" placeholder="请输入源地址" />
        </FormItem>
        <FormItem label="公示详情" prop="announceDesc">
          <editor ref="editorEdit" :value="form.announceDesc" @on-change="handleChange"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="公示编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始公示编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束公示编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="项目编号">
          <Row>
            <i-col span="11">
              <FormItem prop="projectIdMin">
                <InputNumber
                  v-model="searchForm.projectIdMin"
                  placeholder="请输入开始项目编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="projectIdMax">
                <InputNumber
                  v-model="searchForm.projectIdMax"
                  placeholder="请输入结束项目编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="第一候选人" prop="firstCandidate">
          <Input v-model="searchForm.firstCandidate" placeholder="请输入第一候选人"/>
        </FormItem>
        <FormItem label="第二候选人" prop="secondCandidate">
          <Input v-model="searchForm.secondCandidate" placeholder="请输入第二候选人"/>
        </FormItem>
        <FormItem label="第三候选人" prop="thirdCandidate">
          <Input v-model="searchForm.thirdCandidate" placeholder="请输入第三候选人"/>
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
    >
      <p>
        公示编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        项目编号:
        <span v-text="form.projectId"></span>
      </p>
      <p>
        第一候选人:
        <span v-text="form.firstCandidate"></span>
      </p>
      <p>
        第二候选人:
        <span v-text="form.secondCandidate"></span>
      </p>
      <p>
        第三候选人:
        <span v-text="form.thirdCandidate"></span>
      </p>
      <p>
        源地址：
        <a :href="form.sourceUrl" target="_blank">{{form.sourceUrl}}</a>
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
      <p>公示详情:</p>
      <span v-html="form.announceDesc"></span>
    </Modal>

    <Modal :transfer="false" v-model="modal.projectDetail" title="招投标项目详情">
      <project-detail :form="projectDetailForm" />
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.projectDetailSearch" title="搜索主表信息">
      <project-list-single ref="ProjectListSingle" v-on:confirmSelectionProject="confirmSelectionProject"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('projectDetailSearch')">取消</Button>
        <Button type="primary" size="large" @click="confirmProject">确认选择</Button>
      </div>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.projectChoice" title="选择招投标项目">
      <project-list-choice ref="ProjectListChoice" v-on:confirmChoiceProject="confirmChoiceProject"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('projectChoice')">取消</Button>
        <Button type="primary" size="large" @click="confirmChoice">确认选择</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import * as ResponseStatus from '@/api/response-status'
import * as projectUtils from '@/api/project'
import ProjectDetail from '@/view/project/ProjectDetail.vue'
import ProjectListSingle from '@/view/project/ProjectListSingle.vue'
import { getProjectById } from '@/api/module'
import ProjectListChoice from '@/view/project/ProjectListChoice.vue'
import Editor from '_c/editor'
import { isActiveSelect } from '@/api/select'
import config from '@/config'
const baseUrl =
  process.env.NODE_ENV === 'development'
    ? config.baseUrl.dev
    : config.baseUrl.pro
const cdnUrl = config.baseUrl.cdnUrl

export default {
  name: 'ProjectAnnounce',
  components: {
    Editor,
    ProjectDetail,
    ProjectListSingle,
    ProjectListChoice
  },
  data() {
    return {
      projectDetailForm: {
        id: null,
        title: null,
        projectType: null,
        city: null,
        projectDetail: null,
        releaseStatus: null,
        markUnitName: null,
        projectInvest: null,
        checkPattern: null,
        compAptitudeType: null,
        builderLevel: null,
        moneyToImplement: 100,
        tenderingAgent: null,
        phone: null,
        offerPrice: 0,
        assurePrice: 0,
        constructionPeriod: null,
        downloadEndTime: null,
        otherDemand: null,
        openMarkInfo: null,
        openMarkTime: null,
        openMarkAddr: null,
        inMarkPublicity: null,
        inMarkComp: null,
        noticeTime: null,
        clickCount: null,
        isElectronic: null,
        sourceUrl: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false,
        projectDetail: false,
        projectDetailSearch: false,
        projectChoice: false
      },
      loading: {
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/projecannounce/admin/save',
        batchAddUrl: '/projecannounce/admin/batch-save',
        editUrl: '/projecannounce/admin/update',
        batchEditUrl: '/projecannounce/admin/batch-update',
        searchUrl: '/projecannounce/admin/pager-cond',
        allUrl: '/projecannounce/admin/all',
        removeUrl: '/projecannounce/admin/remove/',
        batchRemoveUrl: '/projecannounce/admin/batch-remove',
        detailUrl: '/projecannounce/admin/one/',
        activeUrl: '/projecannounce/admin/active',
        batchActiveUrl: '/projecannounce/admin/batch-active',
        uploadUrl: baseUrl + '/projecannounce/admin/upload-img',
        projectSelectUrl: '/projecannounce/admin/project-select',
        oneProjectUrl: '/project/admin/one/'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        projectId: null,
        announceDesc: null,
        firstCandidate: null,
        secondCandidate: null,
        thirdCandidate: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        announceDesc: [
          {
            type: 'string',
            min: 1,
            max: 2000,
            message: '必须1-2000个字符',
            trigger: 'blur'
          }
        ],
        firstCandidate: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        secondCandidate: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        thirdCandidate: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
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
        projectId: null,
        projectIdMin: null,
        projectIdMax: null,
        announceDesc: null,
        firstCandidate: null,
        secondCandidate: null,
        thirdCandidate: null,
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
            title: '公示编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '项目编号',
            key: 'projectId',
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
                  h('span', [
                    params.row.projectId,
                    h('Icon', {
                      props: {
                        type: 'ios-list',
                        size: '25'
                      }
                    })
                  ]),
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
                            name: 'moduleDetailProject'
                          }
                        },
                        '详情'
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showSearchProject'
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
            title: '公示详情',
            key: 'announceDesc',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              return h(
                'a',
                {
                  on: {
                    click: () => {
                      utils.showModal(this, 'detail')
                      this.form = JSON.parse(JSON.stringify(params.row))
                    }
                  }
                },
                '点击查看'
              )
            }
          },
          {
            title: '第一候选人',
            key: 'firstCandidate',
            minWidth: 120,
            sortable: true
          },
          {
            title: '第二候选人',
            key: 'secondCandidate',
            minWidth: 120,
            sortable: true
          },
          {
            title: '第三候选人',
            key: 'thirdCandidate',
            minWidth: 120,
            sortable: true
          },
          {
            title: '源地址',
            key: 'sourceUrl',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              return h(
                'a',
                {
                  attrs: {
                    href: row.sourceUrl,
                    target: '_blank'
                  }
                },
                row.sourceUrl
              )
            }
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
        this.showModal('edit')
        this.form = JSON.parse(JSON.stringify(row))
        this.$refs.editorEdit.setHtml(this.form.announceDesc)
      } else if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'remove') {
        utils.remove(this, row)
      } else if (itemName === 'moduleDetailProject') {
        this.showProjectDetailModal(row.projectId)
      } else if (itemName === 'showSearchProject') {
        utils.showModal(this, 'projectDetailSearch')
      }
    },
    showProjectDetailModal(id) {
      getProjectById(id)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.projectDetailForm = data.data
            this.showModal('projectDetail')
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    confirmSelectionProject(id) {
      this.cancelModal('projectDetailSearch')
      this.searchForm.projectIdMin = this.searchForm.projectIdMax = id
      utils.search(this)
    },
    confirmProject() {
      this.$refs.ProjectListSingle.confirmSelection()
    },
    confirmChoiceProject(projectId) {
      this.form.projectId = projectId
      this.cancelModal('projectChoice')
    },
    confirmChoice() {
      this.$refs.ProjectListChoice.confirmSelection()
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
      this.form.announceDesc = html
    },
  }
}
</script>

<style>
</style>
