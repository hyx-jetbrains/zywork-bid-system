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
    >
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="发布用户" prop="userId">
          <span v-text="form.userId"></span>
          &nbsp;
          <Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
        </FormItem>
        <FormItem label="招聘岗位" prop="jobTitle">
          <Input v-model="form.jobTitle" placeholder="请输入招聘岗位"/>
        </FormItem>
        <FormItem label="是否全职" prop="isFulltime">
          <Select v-model="form.isFulltime" placeholder="请选择求职类型" filterable>
            <i-option v-for="item in jobTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="工作时间（年）" prop="workYear">
          <Input v-model="form.workYear" placeholder="请输入工作时间（年）"/>
        </FormItem>
        <FormItem label="要求学历" prop="education">
          <Select v-model="form.education" placeholder="请选择学历" clearable filterable>
            <i-option
              v-for="item in educationList"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="提供月薪" prop="salary">
          <Select v-model="form.salary" placeholder="请选择要求薪资/月" clearable filterable>
            <i-option
              v-for="item in salaryRangeList"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="工作地" prop="workAddr">
          <Cascader
            :data="cityData"
            v-model="tempAddress"
            trigger="hover"
            change-on-select
            filterable
            clearable
          />
        </FormItem>
        <FormItem label="招聘状态" prop="recruitStatus">
          <Select v-model="form.recruitStatus" placeholder="请选择招聘状态">
            <i-option
              v-for="item in recruitStatusSelect"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="职位描述" prop="memo">
          <Input
            v-model="form.memo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入职位描述"
          />
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
        <FormItem label="发布用户" prop="userId">
          <span v-text="form.userId"></span>
          &nbsp;
          <Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
        </FormItem>
        <FormItem label="招聘岗位" prop="jobTitle">
          <Input v-model="form.jobTitle" placeholder="请输入招聘岗位"/>
        </FormItem>
        <FormItem label="是否全职" prop="isFulltime">
          <Select v-model="form.isFulltime" placeholder="请选择求职类型" filterable>
            <i-option v-for="item in jobTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="工作时间（年）" prop="workYear">
          <Input v-model="form.workYear" placeholder="请输入工作时间（年）"/>
        </FormItem>
        <FormItem label="要求学历" prop="education">
          <Select v-model="form.education" placeholder="请选择学历" clearable filterable>
            <i-option
              v-for="item in educationList"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="提供月薪" prop="salary">
          <Select v-model="form.salary" placeholder="请选择要求薪资/月" clearable filterable>
            <i-option
              v-for="item in salaryRangeList"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="工作地" prop="workAddr">
          <Cascader
            :data="cityData"
            v-model="tempAddress"
            trigger="hover"
            change-on-select
            filterable
            clearable
          />
        </FormItem>
        <FormItem label="招聘状态" prop="recruitStatus">
          <Select v-model="form.recruitStatus" placeholder="请选择招聘状态">
            <i-option
              v-for="item in recruitStatusSelect"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="职位描述" prop="memo">
          <Input
            v-model="form.memo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入职位描述"
          />
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="招聘编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始招聘编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束招聘编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="用户编号">
          <Row>
            <i-col span="11">
              <FormItem prop="userIdMin">
                <InputNumber
                  v-model="searchForm.userIdMin"
                  placeholder="请输入开始用户编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="userIdMax">
                <InputNumber
                  v-model="searchForm.userIdMax"
                  placeholder="请输入结束用户编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="招聘岗位" prop="jobTitle">
          <Input v-model="searchForm.jobTitle" placeholder="请输入招聘岗位"/>
        </FormItem>
        <FormItem label="是否全职">
          <Select v-model="searchForm.isFulltime" placeholder="请选择求职类型" clearable filterable>
            <i-option v-for="item in jobTypeList" :value="item.value" :key="item.key">{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="工作时间（年）" prop="workYear">
          <Input v-model="searchForm.workYear" placeholder="请输入工作时间（年）"/>
        </FormItem>
        <FormItem label="要求学历" prop="education">
          <Select v-model="searchForm.education" placeholder="请选择学历" clearable filterable>
            <i-option
              v-for="item in educationList"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="提供月薪" prop="salary">
          <Select v-model="searchForm.salary" placeholder="请选择要求薪资/月" clearable filterable>
            <i-option
              v-for="item in salaryRangeList"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="招聘状态" prop="recruitStatus">
          <Select v-model="searchForm.recruitStatus" placeholder="请选择招聘状态">
            <i-option
              v-for="item in recruitStatusSelect"
              :value="item.value"
              :key="item.key"
            >{{item.label}}</i-option>
          </Select>
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
      @on-visible-change="changeModalVisibleResetForm('editForm', $event)"
    >
      <p>
        招聘编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        招聘岗位:
        <span v-text="form.jobTitle"></span>
      </p>
      <p>
        是否全职:
        <span v-text="form.isFulltime"></span>
      </p>
      <p>
        工作时间（年）:
        <span v-text="form.workYear"></span>
      </p>
      <p>
        要求学历:
        <span v-text="form.education"></span>
      </p>
      <p>
        提供月薪:
        <span v-text="form.salary"></span>
      </p>
      <p>
        工作地:
        <span v-text="form.workAddr"></span>
      </p>
      <p>
        职位描述:
        <span v-text="form.memo"></span>
      </p>
      <p>
        招聘状态:
        <span v-text="form.recruitStatus"></span>
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

    <Modal :transfer="false" v-model="modal.userDetail" title="用户详情">
      <userDetail :form="userDetailForm" v-on:setDetail="setDetailModal"/>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.userDetalSearch" title="搜索主表信息">
      <user-list-single ref="UserListSingle" v-on:confirmSelection="confirmSelection"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('userDetalSearch')">取消</Button>
        <Button type="primary" size="large" @click="confirm">确认选择</Button>
      </div>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.userChoice" title="选择用户">
      <user-list-choice ref="UserListChoice" v-on:confirmChoice="confirmChoice"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('userChoice')">取消</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import UserListSingle from '@/view/user/UserListSingle.vue'
import UserListChoice from '@/view/user/UserListChoice.vue'
import userDetail from '@/view/user-detail/UserDetail.vue'
import { getUserById } from '@/api/module'
import { isActiveSelect, jobType, education, salaryRange, recruitStatusSelect } from '@/api/select'
import city from '@/api/city.json'

export default {
  name: 'Recruit',
  components: {
    userDetail,
    UserListSingle,
    UserListChoice
  },
  data() {
    return {
      userDetailForm: {
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
        userDetailVersion: null
      },
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false,
        userDetail: false,
        userDetalSearch: false,
        userChoice: false
      },
      loading: {
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/recruit/admin/save',
        batchAddUrl: '/recruit/admin/batch-save',
        editUrl: '/recruit/admin/update',
        batchEditUrl: '/recruit/admin/batch-update',
        searchUrl: '/recruit/admin/pager-cond',
        allUrl: '/recruit/admin/all',
        removeUrl: '/recruit/admin/remove/',
        batchRemoveUrl: '/recruit/admin/batch-remove',
        detailUrl: '/recruit/admin/one/',
        activeUrl: '/recruit/admin/active',
        batchActiveUrl: '/recruit/admin/batch-active'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        userId: null,
        jobTitle: null,
        isFulltime: null,
        workYear: null,
        education: null,
        salary: null,
        workAddr: null,
        memo: null,
        recruitStatus: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        userId: [
          {
            type: 'integer',
            required: true,
            message: '此项为必须项',
            trigger: 'blur, change'
          }
        ],
        jobTitle: [
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
        workYear: [
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        education: [
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        salary: [
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        workAddr: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        memo: [
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
        userId: null,
        userIdMin: null,
        userIdMax: null,
        jobTitle: null,
        isFulltime: null,
        isFulltimeMin: null,
        isFulltimeMax: null,
        workYear: null,
        education: null,
        salary: null,
        workAddr: null,
        recruitStatus: null,
        memo: null,
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
            title: '招聘编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '用户编号',
            key: 'userId',
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
                    params.row.userId,
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
            title: '招聘岗位',
            key: 'jobTitle',
            minWidth: 120,
            sortable: true
          },
          {
            title: '是否全职',
            key: 'isFulltime',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const color =
                row.isFulltime === 0
                  ? 'primary'
                  : row.isFulltime === 1
                  ? 'info'
                  : 'error'
              const text =
                row.isFulltime === 0
                  ? '全职'
                  : row.isFulltime === 1
                  ? '兼职'
                  : '未知'
              return h(
                'Button',
                {
                  props: {
                    size: 'small',
                    type: color
                  }
                },
                text
              )
            }
          },
          {
            title: '工作时间（年）',
            key: 'workYear',
            minWidth: 160,
            sortable: true
          },
          {
            title: '要求学历',
            key: 'education',
            minWidth: 120,
            sortable: true
          },
          {
            title: '提供月薪',
            key: 'salary',
            minWidth: 120,
            sortable: true
          },
          {
            title: '工作地',
            key: 'workAddr',
            minWidth: 120,
            sortable: true
          },
          {
            title: '职位描述',
            key: 'memo',
            minWidth: 120,
            sortable: true
          },
          {
            title: '招聘状态',
            key: 'recruitStatus',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const color =
                row.recruitStatus === '招聘中'
                  ? 'primary'
                  : row.recruitStatus === '已停止'
                  ? 'default'
                  : 'error'
              return h(
                'Button',
                {
                  props: {
                    size: 'small',
                    type: color
                  }
                },
                row.recruitStatus
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
            minWidth: 150,
            sortable: true
          },
          {
            title: '更新时间',
            key: 'updateTime',
            minWidth: 150,
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
      isActiveSelect: isActiveSelect,
      jobTypeList: jobType,
      educationList: education,
      salaryRangeList: salaryRange,
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
      },
      cityData: city,
      tempAddress: [],
      recruitStatusSelect: recruitStatusSelect
    }
  },
  computed: {},
  mounted() {
    this.search()
  },
  methods: {
    showModal(modal) {
      if (modal === 'add') {
        this.form.recruitStatus = this.recruitStatusSelect[0].value
				this.form.isFulltime = this.jobTypeList[0].value
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
        var tempAddrArr = this.form.workAddr.split('/')
        for (var i = 0; i < tempAddrArr.length; i++) {
          this.tempAddress.push(tempAddrArr[i])
        }
      } else if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'remove') {
        utils.remove(this, row)
      } else if (itemName === 'moduleDetail') {
        this.showUserDetailModal(row.userId)
      } else if (itemName === 'showSearch') {
        utils.showModal(this, 'userDetalSearch')
      }
    },
    showUserDetailModal(id) {
      getUserById(id)
        .then(res => {
          const data = res.data
          if (data.code === 1001) {
            this.userDetailForm = data.data.rows[0]
            this.modal.userDetail = true
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    setDetailModal(val) {
      this.modal.userDetail = val
    },
    confirmSelection(id) {
      this.modal.userDetalSearch = false
      this.searchForm.userIdMin = id
      this.searchForm.userIdMax = id
      utils.search(this)
    },
    confirm() {
      this.$refs.UserListSingle.confirmSelection()
    },
    setAddress() {
      if (this.tempAddress.length <= 0) {
        this.$Message.error('地址为必填项')
        return
      } else if (this.tempAddress.length === 1) {
        this.form.workAddr = this.tempAddress[0]
      } else if (this.tempAddress.length === 2) {
        this.form.workAddr = this.tempAddress[0] + '/' + this.tempAddress[1]
      } else if (this.tempAddress.length === 3) {
        this.form.workAddr =
          this.tempAddress[0] +
          '/' +
          this.tempAddress[1] +
          '/' +
          this.tempAddress[2]
      }
    },
    add() {
      this.setAddress()
      utils.add(this)
    },
    edit() {
      this.setAddress()
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
    // 确认选择用户
    confirmChoice(userId) {
      this.form.userId = userId
      this.cancelModal('userChoice')
    }
  }
}
</script>

<style>
</style>
