<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="showModal('add')" type="primary">添加</Button>&nbsp;
          <!-- <Dropdown @on-click="batchOpt">
            <Button type="primary">
              批量操作
              <Icon type="ios-arrow-down"></Icon>
            </Button>
            <DropdownMenu slot="list">
              <DropdownItem name="batchActive">批量激活</DropdownItem>
              <DropdownItem name="batchInactive"><span style="color: red;">批量冻结</span></DropdownItem>
              <DropdownItem name="batchRemove" divided><span style="color: red;">批量删除</span></DropdownItem>
            </DropdownMenu>
          </Dropdown>&nbsp;-->
          <Button @click="showModal('search')" type="primary">高级搜索</Button>&nbsp;
          <Tooltip content="刷新" placement="right">
            <Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
          </Tooltip>
          <Divider />
          <!-- <Table ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-selection-change="changeSelection" @on-sort-change="changeSort"></Table> -->
          <Row>
            <Spin size="large" fix v-if="table.loading"></Spin>
            <i-col span="8" class="scheduler-row-col" v-for="(item,index) in table.tableDetails" :key="item.id">
              <Card>
                <p slot="title">
                  <Icon type="ios-time-outline"/>
                  {{item.name}}
                </p>
                <span slot="extra">
                  <span v-if="item.jobStatus === 0" style="color: #696c6f;">
                    <Icon type="ios-more"></Icon>未启动
                  </span>
                  <span v-if="item.jobStatus === 1" style="color: #2af543;">
                    <Icon type="ios-play"></Icon>运行中
                  </span>
                  <span v-if="item.jobStatus === 2" style="color: #f70404;">
                    <Icon type="ios-power"></Icon>已停止
                  </span>
                  <span v-if="item.jobStatus === 3" style="color: #2d8cf0">
                    <Icon type="ios-pause"></Icon>已暂停
                  </span>
                  <span v-if="item.jobStatus === 4" style="color: #750312;">
                    <Icon type="ios-trash-outline"></Icon>已删除
                  </span>
                </span>
                <Scroll height="280">
                  <p>
                    <strong>类名：</strong>
                    <span v-text="item.className" />
                  </p>
                  <p>
                    <strong>作业组名称：</strong>
                    <span v-text="item.groupName" />
                  </p>
                  <p>
                    <strong>触发器组：</strong>
                    <span v-text="item.triggerGroup" />
                  </p>
                  <p>
                    <strong>触发器名称：</strong>
                    <span v-text="item.triggerName" />
                  </p>
                  <p>
                    <strong>cron表达式：</strong>
                    <span v-text="item.cronExpression" />
                    <Tooltip placement="top" content="修改Cron表达式">
                      <Icon type="md-create" class="opt-cron-icon" @click="userOpt('showEditCron', index)" />
                    </Tooltip>
                  </p>
                  <p>
                    <strong>作业描述：</strong>
                    <span v-text="item.description" />
                  </p>
                  <p>
                    <strong>版本号：</strong>
                    <span v-text="item.version" />
                  </p>
                  <p>
                    <strong>自动启动：</strong>
                    <i-switch v-model="autoStartArr[index]" @on-change="editAutoStatus(index)">
                      <span slot="open">是</span>
                      <span slot="close">否</span>
                    </i-switch>
                  </p>
                  <p>
                    <strong>是否激活：</strong>
                    <i-switch v-model="jobStatusArr[index]" size="large" @on-change="active(index)">
                      <span slot="open">激活</span>
                      <span slot="close">冻结</span>
                    </i-switch>
                  </p>
                  <p>
                    <strong>状态更新时间：</strong>
                    <span v-text="item.jobStatusTime" />
                  </p>
                  <p>
                    <strong>创建时间：</strong>
                    <span v-text="item.createTime" />
                  </p>
                  <p>
                    <strong>更新时间：</strong>
                    <span v-text="item.updateTime" />
                  </p>
                </Scroll>
                <Divider />
                <Row class="opt-row">
                  <span v-if="item.jobStatus === 0 || item.jobStatus === 2 || item.jobStatus === 4">
                    <Button @click="userOpt('start', index)" icon="ios-play" type="primary" size="small">启动</Button>&nbsp;
                  </span>
                  <span v-if="item.jobStatus === 3">
                    <Button @click="userOpt('resume', index)" icon="ios-play" type="primary" size="small">恢复启动</Button>&nbsp;
                  </span>
                  <span v-if="item.jobStatus === 1">
                    <Button @click="userOpt('pause', index)" icon="ios-pause" type="warning" size="small">暂停</Button>&nbsp;
                  </span>
                  <span v-if="item.jobStatus === 1 || item.jobStatus === 3">
                    <Button @click="userOpt('stop', index)" icon="ios-power" type="error" size="small">停止</Button>&nbsp;
                  </span>
                  <Button @click="userOpt('showEdit', index)" icon="md-create" type="info" size="small">编辑</Button>&nbsp;
                  <span v-if="item.jobStatus === 0">
                    <Button @click="userOpt('del', index)" icon="ios-trash-outline" type="error" size="small">删除</Button>&nbsp;
                  </span>
                </Row>
              </Card>
            </i-col>
          </Row>
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
        <FormItem label="作业名称" prop="name">
          <Input v-model="form.name" placeholder="请输入作业名称"/>
        </FormItem>
        <FormItem label="完整类名" prop="className">
          <Select v-model="form.className" placeholder="请选择类名称" clearable filterable>
            <Option v-for="item in jobClassessList" :value="item" :key="item">{{item}}</option>
          </Select>
        </FormItem>
        <FormItem label="cron表达式" prop="cronExpression">
          <Input v-model="form.cronExpression" placeholder="请输入cron表达式"/>
          <span style="color: red"><Icon type="information-circled"></Icon>如不清楚，请参考示例：</span>
          <i-button type="text" size="small" v-if="!showDemo" @click="showDemo = true">查看示例</i-button>
					<i-button type="text" size="small" v-if="showDemo" @click="showDemo = false">隐藏示例</i-button>
          <cron-demo :showDemo="showDemo" />
        </FormItem>
        <FormItem label="作业组名称" prop="groupName">
          <Input v-model="form.groupName" placeholder="请输入作业组名称"/>
        </FormItem>
        <FormItem label="触发器名称" prop="triggerName">
          <Input v-model="form.triggerName" placeholder="请输入触发器名称"/>
        </FormItem>
        <FormItem label="触发器组" prop="triggerGroup">
          <Input v-model="form.triggerGroup" placeholder="请输入触发器组"/>
        </FormItem>
        <FormItem label="作业描述" prop="description">
          <Input v-model="form.description" type="textarea" :autosize="descriptionAutoSize" placeholder="请输入作业描述"/>
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
        <FormItem label="作业名称" prop="name">
          <Input v-model="form.name" placeholder="请输入作业名称"/>
        </FormItem>
        <FormItem label="完整类名" prop="className">
          <Select v-model="form.className" placeholder="请选择类名称" clearable filterable>
            <Option v-for="item in jobClassessList" :value="item" :key="item">{{item}}</option>
          </Select>
        </FormItem>
        <FormItem label="cron表达式" prop="cronExpression">
          <Input v-model="form.cronExpression" placeholder="请输入cron表达式"/>
          <span style="color: red"><Icon type="information-circled"></Icon>如不清楚，请参考示例：</span>
          <i-button type="text" size="small" v-if="!showDemo" @click="showDemo = true">查看示例</i-button>
					<i-button type="text" size="small" v-if="showDemo" @click="showDemo = false">隐藏示例</i-button>
          <cron-demo :showDemo="showDemo" />
        </FormItem>
        <FormItem label="作业组名称" prop="groupName">
          <Input v-model="form.groupName" placeholder="请输入作业组名称"/>
        </FormItem>
        <FormItem label="触发器名称" prop="triggerName">
          <Input v-model="form.triggerName" placeholder="请输入触发器名称"/>
        </FormItem>
        <FormItem label="触发器组" prop="triggerGroup">
          <Input v-model="form.triggerGroup" placeholder="请输入触发器组"/>
        </FormItem>
        <FormItem label="作业描述" prop="description">
          <Input v-model="form.description" type="textarea" :autosize="descriptionAutoSize" placeholder="请输入作业描述"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal
      v-model="modal.editCron"
      title="修改cron表达式"
      @on-visible-change="changeModalVisibleResetForm('editCronForm', $event)">
      <Form ref="editCronForm" :model="cronForm" :label-width="80" :rules="validateRules1">
        <FormItem label="作业Id" prop="id">
          <Input v-model="cronForm.jobId" placeholder="请输入作业Id" readonly/>
        </FormItem>
        <FormItem label="作业名称" prop="name">
          <Input v-model="cronForm.jobName" placeholder="请输入作业名称" readonly/>
        </FormItem>
        <FormItem label="cron表达式" prop="cronExp">
          <Input v-model="cronForm.cronExp" placeholder="请输入cron表达式"/>
          <span style="color: red"><Icon type="information-circled"></Icon>如不清楚，请参考示例：</span>
          <i-button type="text" size="small" v-if="!showDemo" @click="showDemo = true">查看示例</i-button>
					<i-button type="text" size="small" v-if="showDemo" @click="showDemo = false">隐藏示例</i-button>
          <cron-demo :showDemo="showDemo" />
        </FormItem>
        <FormItem label="作业组名称" prop="groupName">
          <Input v-model="cronForm.jobGroup" placeholder="请输入作业组名称" readonly/>
        </FormItem>
        <FormItem label="触发器名称" prop="triggerName">
          <Input v-model="cronForm.triggerName" placeholder="请输入触发器名称" readonly/>
        </FormItem>
        <FormItem label="触发器组" prop="triggerGroup">
          <Input v-model="cronForm.triggerGroup" placeholder="请输入触发器组" readonly />
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editCronForm', 'editCron')">取消</Button>
        <Button type="primary" size="large" @click="editCron" :loading="loading.editCron">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="作业编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始作业编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束作业编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="作业名称" prop="name">
          <Input v-model="searchForm.name" placeholder="请输入作业名称"/>
        </FormItem>
        <FormItem label="自动启动">
          <Select v-model="searchForm.autoStart" placeholder="请选择是否自动启动的状态" clearable filterable>
            <Option v-for="item in isDefaultList" :value="item.value" :key="item.value">{{item.label}}</option>
          </Select>
        </FormItem>
        <FormItem label="完整类名" prop="className">
          <Select v-model="searchForm.className" placeholder="请选择类名称" clearable filterable>
            <Option v-for="item in jobClassessList" :value="item" :key="item">{{item}}</option>
          </Select>
        </FormItem>
        <FormItem label="作业组名称" prop="groupName">
          <Input v-model="searchForm.groupName" placeholder="请输入作业组名称"/>
        </FormItem>
        <FormItem label="触发器名称" prop="triggerName">
          <Input v-model="searchForm.triggerName" placeholder="请输入触发器名称"/>
        </FormItem>
        <FormItem label="触发器组" prop="triggerGroup">
          <Input v-model="searchForm.triggerGroup" placeholder="请输入触发器组"/>
        </FormItem>
        <FormItem label="作业状态">
          <Select v-model="searchForm.jobStatus" placeholder="请选择作业状态" clearable filterable>
            <Option v-for="item in jobStatusList" :value="item.value" :key="item.value">{{item.label}}</option>
          </Select>
        </FormItem>
        <FormItem label="是否激活">
          <Select v-model="searchForm.isActive" placeholder="请选择激活状态" clearable filterable>
            <Option v-for="item in isActiveList" :value="item.value" :key="item.value">{{item.label}}</option>
          </Select>
        </FormItem>
        <FormItem label="状态更新时间">
          <Row>
            <i-col span="11">
              <FormItem prop="jobStatusTimeMin">
                <DatePicker
                  @on-change="searchForm.jobStatusTimeMin=$event"
                  :value="searchForm.jobStatusTimeMin"
                  placeholder="请输入开始状态更新时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="jobStatusTimeMax">
                <DatePicker
                  @on-change="searchForm.jobStatusTimeMax=$event"
                  :value="searchForm.jobStatusTimeMax"
                  placeholder="请输入结束状态更新时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
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
    <!-- <Modal
      v-model="modal.detail"
      title="详情"
      @on-visible-change="changeModalVisibleResetForm('editForm', $event)"
    >
      <p>作业编号:
        <span v-text="form.id"></span>
      </p>
      <p>作业名称:
        <span v-text="form.name"></span>
      </p>
      <p>完整类名:
        <span v-text="form.className"></span>
      </p>
      <p>cron表达式:
        <span v-text="form.cronExpression"></span>
      </p>
      <p>作业组名称:
        <span v-text="form.groupName"></span>
      </p>
      <p>触发器名称:
        <span v-text="form.triggerName"></span>
      </p>
      <p>触发器组:
        <span v-text="form.triggerGroup"></span>
      </p>
      <p>作业描述:
        <span v-text="form.description"></span>
      </p>
      <p>作业状态:
        <span v-text="form.jobStatus"></span>
      </p>
      <p>状态更新时间:
        <span v-text="form.jobStatusTime"></span>
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
    </Modal> -->
  </div>
</template>

<script>
import axios from '@/libs/api.request'
import * as utils from '@/api/utils'
import {
  jobClassess,
  modify,
  optJob
} from '@/api/scheduler'
import {
  jobStatusSelect,
  isActiveSelect,
  isDefaultSelect
} from '@/api/select'
import * as ResponseStatus from '@/api/response-status'
import cronDemo from './CronDemo.vue'
import './Scheduler.less'
export default {
  name: 'Scheduler',
  components: {
    cronDemo
  },
  data() {
    return {
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false,
        editCorn: false
      },
      loading: {
        add: false,
        edit: false,
        search: false,
        editCron: false
      },
      urls: {
        addUrl: '/scheduler/admin/save',
        batchAddUrl: '/scheduler/admin/batch-save',
        editUrl: '/scheduler/admin/update',
        batchEditUrl: '/scheduler/admin/batch-update',
        searchUrl: '/scheduler/admin/pager-cond',
        allUrl: '/scheduler/admin/all',
        removeUrl: '/scheduler/admin/remove/',
        batchRemoveUrl: '/scheduler/admin/batch-remove',
        detailUrl: '/scheduler/admin/one/',
        activeUrl: '/scheduler/admin/active',
        batchActiveUrl: '/scheduler/admin/batch-active',
        startJobUrl: '/scheduler/admin/start',
        delJobUrl: '/scheduler/admin/del',
        stopJobUrl: '/scheduler/admin/stop',
        pauseJobUrl: '/scheduler/admin/pause',
        resumeJobUrl: '/scheduler/admin/resume'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        name: null,
        className: null,
        cronExpression: null,
        groupName: null,
        triggerName: null,
        triggerGroup: null,
        description: null,
        autoStart: null,
        jobStatus: null,
        jobStatusTime: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      cronForm: {
        cronExp: null,
        jobGroup: null,
        jobId: null,
        jobName: null,
        triggerGroup: null,
        triggerName: null,
        jobClassName: null
      },
      validateRules: {
        name: [
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
        className: [
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
        cronExpression: [
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
        groupName: [
          {
            type: 'string',
            min: 1,
            max: 50,
            message: '必须1-50个字符',
            trigger: 'blur'
          }
        ],
        triggerName: [
          {
            type: 'string',
            min: 1,
            max: 50,
            message: '必须1-50个字符',
            trigger: 'blur'
          }
        ],
        triggerGroup: [
          {
            type: 'string',
            min: 1,
            max: 50,
            message: '必须1-50个字符',
            trigger: 'blur'
          }
        ],
        description: [
          {
            type: 'string',
            min: 1,
            max: 500,
            message: '必须1-500个字符',
            trigger: 'blur'
          }
        ]
      },
      validateRules1: {
        cronExp: [
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
        name: null,
        className: null,
        cronExpression: null,
        groupName: null,
        triggerName: null,
        triggerGroup: null,
        description: null,
        autoStart: null,
        jobStatus: null,
        jobStatusMin: null,
        jobStatusMax: null,
        jobStatusTime: null,
        jobStatusTimeMin: null,
        jobStatusTimeMax: null,
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
        // tableColumns: [
        //   {
        //     type: 'selection',
        //     width: 45,
        //     key: 'id',
        //     align: 'center',
        //     fixed: 'left'
        //   },
        //   {
        //     width: 60,
        //     align: 'center',
        //     fixed: 'left',
        //     render: (h, params) => {
        //       return h(
        //         'span',
        //         params.index +
        //           (this.searchForm.pageNo - 1) * this.searchForm.pageSize +
        //           1
        //       )
        //     }
        //   },
        //   {
        //     title: '作业编号',
        //     key: 'id',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '作业名称',
        //     key: 'name',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '完整类名',
        //     key: 'className',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: 'cron表达式',
        //     key: 'cronExpression',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '作业组名称',
        //     key: 'groupName',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '触发器名称',
        //     key: 'triggerName',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '触发器组',
        //     key: 'triggerGroup',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '作业描述',
        //     key: 'description',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '作业状态',
        //     key: 'jobStatus',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '状态更新时间',
        //     key: 'jobStatusTime',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '版本号',
        //     key: 'version',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '创建时间',
        //     key: 'createTime',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '更新时间',
        //     key: 'updateTime',
        //     minWidth: 120,
        //     sortable: true
        //   },
        //   {
        //     title: '是否激活',
        //     key: 'isActive',
        //     minWidth: 120,
        //     sortable: true
        //   },

        //   {
        //     title: '激活状态',
        //     key: 'isActive',
        //     minWidth: 100,
        //     align: 'center',
        //     render: (h, params) => {
        //       return h(
        //         'i-switch',
        //         {
        //           props: {
        //             size: 'large',
        //             value: params.row.isActive === 0
        //           },
        //           style: {
        //             marginRight: '5px'
        //           },
        //           on: {
        //             'on-change': status => {
        //               this.active(params.row)
        //             }
        //           }
        //         },
        //         [
        //           h(
        //             'span',
        //             {
        //               slot: 'open'
        //             },
        //             '激活'
        //           ),
        //           h(
        //             'span',
        //             {
        //               slot: 'close'
        //             },
        //             '冻结'
        //           )
        //         ]
        //       )
        //     }
        //   },
        //   {
        //     title: '操作',
        //     key: 'action',
        //     width: 120,
        //     align: 'center',
        //     fixed: 'right',
        //     render: (h, params) => {
        //       return h(
        //         'Dropdown',
        //         {
        //           on: {
        //             'on-click': itemName => {
        //               this.userOpt(itemName, params.row)
        //             }
        //           },
        //           props: {
        //             transfer: true
        //           }
        //         },
        //         [
        //           h(
        //             'Button',
        //             {
        //               props: {
        //                 type: 'primary',
        //                 size: 'small'
        //               }
        //             },
        //             [
        //               '选择操作 ',
        //               h('Icon', {
        //                 props: {
        //                   type: 'ios-arrow-down'
        //                 }
        //               })
        //             ]
        //           ),
        //           h(
        //             'DropdownMenu',
        //             {
        //               slot: 'list'
        //             },
        //             [
        //               h(
        //                 'DropdownItem',
        //                 {
        //                   props: {
        //                     name: 'showEdit'
        //                   }
        //                 },
        //                 '编辑'
        //               ),
        //               h(
        //                 'DropdownItem',
        //                 {
        //                   props: {
        //                     name: 'showDetail'
        //                   }
        //                 },
        //                 '详情'
        //               ),
        //               h(
        //                 'DropdownItem',
        //                 {
        //                   props: {
        //                     name: 'remove'
        //                   }
        //                 },
        //                 [
        //                   h(
        //                     'span',
        //                     {
        //                       style: {
        //                         color: 'red'
        //                       }
        //                     },
        //                     '删除'
        //                   )
        //                 ]
        //               )
        //             ]
        //           )
        //         ]
        //       )
        //     }
        //   }
        // ],
        tableDetails: [],
        selections: []
      },
      descriptionAutoSize: {
        'minRows': 3,
        'maxRows': 5
      },
      jobClassessSelect: false,
      jobClassessList: [],
      jobStatusList: jobStatusSelect,
      isActiveList: isActiveSelect,
      isDefaultList: isDefaultSelect,
      showDemo: false,
      jobStatusArr: [],
      autoStartArr: []
    }
  },
  computed: {},
  mounted() {
    this.search()
    this.getJobClassess()
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
    userOpt(itemName, index) {
      const row = this.table.tableDetails[index]
      if (itemName === 'showEdit') {
        utils.showModal(this, 'edit')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'remove') {
        utils.remove(this, row)
      } else if (itemName === 'showEditCron') {
        if (row.jobStatus === 0) {
          utils.showModal(this, 'edit')
          this.form = JSON.parse(JSON.stringify(row))
        } else {
          utils.showModal(this, 'editCron')
          this.initCronForm(row)
        }
      } else if (itemName === 'stop') {
        this.initCronForm(row)
        this.optOneJob(this.urls.stopJobUrl)
      } else if (itemName === 'del') {
        this.initCronForm(row)
        this.optOneJob(this.urls.delJobUrl)
      } else if (itemName === 'start') {
        this.initCronForm(row)
        this.optOneJob(this.urls.startJobUrl)
      } else if (itemName === 'pause') {
        this.initCronForm(row)
        this.optOneJob(this.urls.pauseJobUrl)
      } else if (itemName === 'resume') {
        this.initCronForm(row)
        this.optOneJob(this.urls.resumeJobUrl)
      }
    },
    initCronForm(row) {
      this.cronForm.cronExp = row.cronExpression
      this.cronForm.jobGroup = row.groupName
      this.cronForm.jobId = row.id
      this.cronForm.jobName = row.name
      this.cronForm.triggerName = row.triggerName
      this.cronForm.triggerGroup = row.triggerGroup
      this.cronForm.jobClassName = row.className
      this.cronForm = JSON.parse(JSON.stringify(this.cronForm))
    },
    add() {
      utils.add(this)
    },
    edit() {
      utils.edit(this)
    },
    editCron() {
      this.$refs['editCronForm'].validate(valid => {
        if (valid) {
          this.loading.editCorn = true
          modify(this.cronForm)
            .then(res => {
              this.loading.editCorn = false
              const data = res.data
              if (data.code === ResponseStatus.OK) {
                this.$Message.success(data.message)
                this.resetFormCancelModal('editCronForm', 'editCron')
                this.search()
              } else {
                this.$Message.error(data.message)
              }
            })
            .catch(err => {
              this.$Message.error(err)
            })
        }
      })
    },
    active(index) {
      const row = this.table.tableDetails[index]
      utils.active(this, row)
      this.search()
    },
    editAutoStatus(index) {
      const row = this.table.tableDetails[index]
      this.form = JSON.parse(JSON.stringify(row))
      if (this.form.autoStart === 0) {
        this.form.autoStart = 1
      } else {
        this.form.autoStart = 0
      }
      axios.request({
          url: this.urls.editUrl,
          method: 'POST',
          data: this.form
        }).then(response => {
          if (response.data.code !== ResponseStatus.OK) {
            this.$Message.error(response.data.message)
          } else {
            this.$Message.success(response.data.message)
          }
          this.search()
        }).catch(error => {
          this.$Message.error('修改数据失败，稍候再试')
        })
    },
    search() {
      // utils.search(this)
      this.jobStatusArr = []
      this.autoStartArr = []
      this.loading['search'] = true
      this.table.loading = true
      axios.request({
        url: this.urls.searchUrl,
        method: 'POST',
        data: this.searchForm
      }).then(response => {
        this.loading['search'] = false
        this.table.loading = false
        if (response.data.code != ResponseStatus.OK) {
          this.$Message.error(response.data.message)
          return
        }
        this.page.total = response.data.data.total
        this.table.tableDetails = response.data.data.rows
        this.table.tableDetails.forEach(item => {
          this.jobStatusArr.push(item.isActive === 0)
          this.autoStartArr.push(item.autoStart === 1)
        })
      }).catch(error => {
        console.log(error)
        this.loading['search'] = false
        this.table.loading = false
        this.$Message.error('加载数据失败，稍候再试')
      })
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
    getJobClassess() {
      this.jobClassessSelect = true
      jobClassess()
        .then(res => {
          this.jobClassessSelect = false
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            if (data.data.total <= 0) {
              this.$Message.error("未获取到类名称")
              return
            }
            this.jobClassessList = data.data.rows
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    optOneJob(url) {
      optJob(url, this.cronForm) 
        .then(res => {
          const data = res.data
          if (data.code !== ResponseStatus.OK) {
            this.$Message.error(data.message)
            return
          }
          this.search()
          this.$Message.success(data.message)
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
