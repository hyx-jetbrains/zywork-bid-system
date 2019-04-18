<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="modal.select = true" type="primary">选择流程</Button>&nbsp;
          <Input v-model="searchForm.processName" style="width: 200px" placeholder="输入流程名称搜索，按回车搜索" @on-enter="search" />&nbsp;
          <Button @click="search" type="primary">搜索</Button>&nbsp;
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
      v-model="modal.select"
      title="选择流程"
      width="850"
    >
      <process-select @selectProcess="selectProcess" />
      <div slot="footer">
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>流程编号:
        <span v-text="form.id"></span>
      </p>
      <p>流程Name:
        <span v-text="form.name"></span>
      </p>
      <p>流程Key:
        <span v-text="form.key"></span>
      </p>
      <p>版本号:
        <span v-text="form.version"></span>
      </p>
      <p>部署ID:
        <span v-text="form.deploymentId"></span>
      </p>
      <p>说明:
        <span v-text="form.description"></span>
      </p>
      <p>资源名称:
        <span v-text="form.resourceName"></span>
      </p>
      <p>图片资源名称:
        <span v-text="form.diagramResourceName"></span>
      </p>
      <p>类别:
        <span v-text="form.category"></span>
      </p>
      <p>是否有开始表单:
        <span v-text="form.hasStartFormKey"></span>
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
import processSelect from '@/view/process/ProcessList.vue'
import * as process from '@/api/process'
import * as ResponseStatus from '@/api/response-status'

export default {
  name: 'ActivitiDefinition',
  components: {
    processSelect
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
        searchUrl: '/process-activiti/admin/query/all-definitions',
        showActivitiImgUrl: '/process-activiti/admin/query/bpmn-png'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        tenantId: null,
        name: null,
        key: null,
        deploymentTime: null,
        deploymentId: null,
        version: null,
        description: null,
        resourceName: null,
        diagramResourceName: null,
        category: null,
        hasStartFormKey: null,
        revision: null
      },
      searchForm: {
        pageNo: 1,
        pageSize: 10,
        processName: null
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
            title: '流程编号',
            key: 'id',
            minWidth: 120
          },
          {
            title: '流程Name',
            key: 'name',
            minWidth: 120
          },
          {
            title: '流程Key',
            key: 'key',
            minWidth: 120
          },
          {
            title: '版本号',
            key: 'version',
            minWidth: 120
          },
          {
            title: '部署ID',
            key: 'deploymentId',
            minWidth: 120
          },
          {
            title: '说明',
            key: 'description',
            minWidth: 120
          },
          {
            title: '资源名称',
            key: 'resourceName',
            minWidth: 120
          },
          {
            title: '图片资源名称',
            key: 'diagramResourceName',
            minWidth: 120
          },
          {
            title: '类别',
            key: 'category',
            minWidth: 120
          },
          {
            title: '是否有开始表单',
            key: 'hasStartFormKey',
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
                        '显示流程图'
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
        // 显示静态流程图
        const params = {
          processKey: row.key,
          version: row.version
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
      this.searchForm.processName = processRow.processName
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
