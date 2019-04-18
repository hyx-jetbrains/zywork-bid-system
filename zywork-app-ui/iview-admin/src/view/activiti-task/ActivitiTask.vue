<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
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
    <Modal v-model="modal.detail" title="详情">
      <p>流程编号:
        <span v-text="form.id"></span>
      </p>
      <p>任务拥有者:
        <span v-text="form.owner"></span>
      </p>
      <p>任务名称:
        <span v-text="form.name"></span>
      </p>
      <p>执行者:
        <span v-text="form.assignee"></span>
      </p>
      <p>原执行者:
        <span v-text="form.originalAssignee"></span>
      </p>
      <p>父级ID:
        <span v-text="form.parentTaskId"></span>
      </p>
      <p>执行ID:
        <span v-text="form.executionId"></span>
      </p>
      <p>流程实例ID:
        <span v-text="form.processInstanceId"></span>
      </p>
      <p>任务定义Key:
        <span v-text="form.taskDefinitionKey"></span>
      </p>
      <p>formKey:
        <span v-text="form.formKey"></span>
      </p>
      <p>任务ID:
        <span v-text="form.tenantId"></span>
      </p>
      <p>说明:
        <span v-text="form.description"></span>
      </p>
      <p>优先级:
        <span v-text="form.priority"></span>
      </p>
      <p>创建时间:
        <span v-text="form.createTime"></span>
      </p>
      <p>结束日期:
        <span v-text="form.dueDate"></span>
      </p>
      <p>修订版本:
        <span v-text="form.revision"></span>
      </p>
      <p>租户ID:
        <span v-text="form.tenantId"></span>
      </p>
    </Modal>
    <Modal v-model="modal.img" title="流程图" width="1200">
      <Row style="text-align: center;">
        <img :src="imgUrl" />
      </Row>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import * as process from '@/api/process'
import * as ResponseStatus from '@/api/response-status'

export default {
  name: 'ActivitiInstance',
  components: {
  },
  data() {
    return {
      modal: {
        select: false,
        detail: false,
        img: false
      },
      imgUrl: '',
      loading: {
        search: false
      },
      urls: {
        searchUrl: '/process-activiti/admin/query/all-tasks',
        showActivitiImgUrl: '/process-activiti/user/query/bpmn-activity-png'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        owner: null,
        name: null,
        assignee: null,
        originalAssignee: null,
        parentTaskId: null,
        executionId: null,
        processInstanceId: null,
        taskDefinitionKey: null,
        formKey: null,
        tenantId: null,
        description: null,
        priority: null,
        createTime: null,
        dueDate: null,
        revision: null
      },
      searchForm: {
        pageNo: 1,
        pageSize: 10,
        processKey: null
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
            title: '任务编号',
            key: 'id',
            minWidth: 120
          },
          {
            title: '任务拥有者',
            key: 'owner',
            minWidth: 120
          },
          {
            title: '任务名称',
            key: 'name',
            minWidth: 120
          },
          {
            title: '任务执行者',
            key: 'assignee',
            minWidth: 120
          },
          {
            title: '原任务执行者',
            key: 'originalAssignee',
            minWidth: 120
          },
          {
            title: '父级任务ID',
            key: 'parentTaskId',
            minWidth: 120
          },
          {
            title: '执行者ID',
            key: 'executionId',
            minWidth: 120
          },
          {
            title: '流程实例ID',
            key: 'processInstanceId',
            minWidth: 120
          },
          {
            title: '任务定义Key',
            key: 'taskDefinitionKey',
            minWidth: 120
          },
          {
            title: 'formKey',
            key: 'formKey',
            minWidth: 120
          },
          {
            title: '说明',
            key: 'description',
            minWidth: 120
          },
          {
            title: '优先级',
            key: 'priority',
            minWidth: 120
          },
          {
            title: '创建时间',
            key: 'createTime',
            minWidth: 120
          },
          {
            title: '结束日期',
            key: 'dueDate',
            minWidth: 120
          },
          {
            title: '修订版本',
            key: 'revision',
            minWidth: 120
          },
          {
            title: '租户ID',
            key: 'tenantId',
            minWidth: 120
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
                            name: 'showImg'
                          }
                        },
                        '显示动态图'
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
      utils.search(this)
    },
    search() {
      // utils.search(this)
      process.searchTableData(this)
    },
    userOpt(itemName, row) {
      if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'showImg') {
        // 显示动态流程图
        const params = {
          processInstanceId: row.processInstanceId,
          processKey: ''
        }
        process.showActivitiImg(this, params)
      }
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
    confirmSelection() {
      // 确认选择的逻辑
    },
    // 选择流程
    selectProcess(processRow) {
      this.searchForm.processKey = processRow.processKey
      process.searchTableData(this)
        .then(res => {
          if (res.data.code === ResponseStatus.OK) {
            this.modal.select = false
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    }
  }
}
</script>

<style>
</style>
