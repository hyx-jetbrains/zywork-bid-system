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
        <FormItem label="项目编号" prop="projectId">
          <span v-text="form.projectId" />
          &nbsp;<Button @click="showModal('projectChoice')" type="text">选择项目</Button>&nbsp;
        </FormItem>
        <FormItem label="项目名称" prop="projectName">
          <Input v-model="form.projectName" readonly placeholder="请输入项目名称"/>
        </FormItem>
        <FormItem label="开标时间" prop="openMarkTime">
          <DatePicker
            @on-change="form.openMarkTime=$event"
            readonly
            :value="form.openMarkTime"
            placeholder="请输入开标时间"
            type="datetime"
            format="yyyy-MM-dd HH:mm:ss"
            style="width: 100%;"
          ></DatePicker>
        </FormItem>
        <FormItem label="招标单位名称" prop="markUnitName">
          <Input v-model="form.markUnitName" readonly placeholder="请输入招标单位名称"/>
        </FormItem>
        <FormItem label="工期(天)" prop="constructionPeriod">
          <InputNumber
            readonly
            v-model="form.constructionPeriod"
            placeholder="请输入工期(天)"
            style="width: 100%;"
          />
        </FormItem>
        <FormItem label="担保金额(万元)" prop="assurePrice">
          <InputNumber v-model="form.assurePrice" placeholder="请输入担保金额(万元)" style="width: 100%;"/>
        </FormItem>
        <FormItem label="担保公司" prop="guaranteeComp">
          <Select v-model="form.guaranteeComp" placeholder="请选择担保公司" clearable filterable>
            <i-option
              v-for="item in guaranteeCompSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="申请人" prop="applicant">
          <Input v-model="form.applicant" placeholder="请输入申请人（建筑单位）"/>
        </FormItem>
        <FormItem label="联系人" prop="name">
          <Input v-model="form.name" placeholder="请输入联系人"/>
        </FormItem>
        <FormItem label="手机号" prop="phone">
          <Input v-model="form.phone" placeholder="请输入手机号"/>
        </FormItem>
        <FormItem label="地址" prop="address">
          <Input
            v-model="form.address"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入地址"
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
        <FormItem label="项目编号" prop="projectId">
          <span v-text="form.projectId" />
          &nbsp;<Button @click="showModal('projectChoice')" type="text">选择项目</Button>&nbsp;
        </FormItem>
        <FormItem label="项目名称" prop="projectName">
          <Input v-model="form.projectName" readonly placeholder="请输入项目名称"/>
        </FormItem>
        <FormItem label="开标时间" prop="openMarkTime">
          <DatePicker
            @on-change="form.openMarkTime=$event"
            readonly
            :value="form.openMarkTime"
            placeholder="请输入开标时间"
            type="datetime"
            format="yyyy-MM-dd HH:mm:ss"
            style="width: 100%;"
          ></DatePicker>
        </FormItem>
        <FormItem label="招标单位名称" prop="markUnitName">
          <Input v-model="form.markUnitName" readonly placeholder="请输入招标单位名称"/>
        </FormItem>
        <FormItem label="工期(天)" prop="constructionPeriod">
          <InputNumber
            readonly
            v-model="form.constructionPeriod"
            placeholder="请输入工期(天)"
            style="width: 100%;"
          />
        </FormItem>
        <FormItem label="担保金额(万元)" prop="assurePrice">
          <InputNumber v-model="form.assurePrice" placeholder="请输入担保金额(万元)" style="width: 100%;"/>
        </FormItem>
        <FormItem label="担保公司" prop="guaranteeComp">
          <Select v-model="form.guaranteeComp" placeholder="请选择担保公司" clearable filterable>
            <i-option
              v-for="item in guaranteeCompSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="申请人" prop="applicant">
          <Input v-model="form.applicant" placeholder="请输入申请人（建筑单位）"/>
        </FormItem>
        <FormItem label="联系人" prop="name">
          <Input v-model="form.name" placeholder="请输入联系人"/>
        </FormItem>
        <FormItem label="手机号" prop="phone">
          <Input v-model="form.phone" placeholder="请输入手机号"/>
        </FormItem>
        <FormItem label="地址" prop="address">
          <Input
            v-model="form.address"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入地址"
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
        <FormItem label="保函编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始保函编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束保函编号"
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
        <FormItem label="项目名称" prop="projectName">
          <Input v-model="searchForm.projectName" placeholder="请输入项目名称"/>
        </FormItem>
        <FormItem label="开标时间">
          <Row>
            <i-col span="11">
              <FormItem prop="openMarkTimeMin">
                <DatePicker
                  @on-change="searchForm.openMarkTimeMin=$event"
                  :value="searchForm.openMarkTimeMin"
                  placeholder="请输入开始开标时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="openMarkTimeMax">
                <DatePicker
                  @on-change="searchForm.openMarkTimeMax=$event"
                  :value="searchForm.openMarkTimeMax"
                  placeholder="请输入结束开标时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="招标单位名称" prop="markUnitName">
          <Input v-model="searchForm.markUnitName" placeholder="请输入招标单位名称"/>
        </FormItem>
        <FormItem label="工期(天)">
          <Row>
            <i-col span="11">
              <FormItem prop="constructionPeriodMin">
                <InputNumber
                  v-model="searchForm.constructionPeriodMin"
                  placeholder="请输入开始工期(天)"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="constructionPeriodMax">
                <InputNumber
                  v-model="searchForm.constructionPeriodMax"
                  placeholder="请输入结束工期(天)"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="担保金额(万元)">
          <Row>
            <i-col span="11">
              <FormItem prop="assurePriceMin">
                <InputNumber
                  v-model="searchForm.assurePriceMin"
                  placeholder="请输入开始担保金额(万元)"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="assurePriceMax">
                <InputNumber
                  v-model="searchForm.assurePriceMax"
                  placeholder="请输入结束担保金额(万元)"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="担保公司" prop="guaranteeComp">
          <Input v-model="searchForm.guaranteeComp" placeholder="请输入担保公司"/>
        </FormItem>
        <FormItem label="申请人" prop="applicant">
          <Input v-model="searchForm.applicant" placeholder="请输入申请人"/>
        </FormItem>
        <FormItem label="联系人" prop="name">
          <Input v-model="searchForm.name" placeholder="请输入联系人"/>
        </FormItem>
        <FormItem label="手机号" prop="phone">
          <Input v-model="searchForm.phone" placeholder="请输入手机号"/>
        </FormItem>
          <Select v-model="searchForm.isActive" placeholder="请选择是否激活" clearable filterable>
            <i-option
              v-for="item in isActiveSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
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
        保函编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        项目编号:
        <span v-text="form.projectId"></span>
      </p>
      <p>
        项目名称:
        <span v-text="form.projectName"></span>
      </p>
      <p>
        开标时间:
        <span v-text="form.openMarkTime"></span>
      </p>
      <p>
        招标单位名称:
        <span v-text="form.markUnitName"></span>
      </p>
      <p>
        工期(天):
        <span v-text="form.constructionPeriod"></span>
      </p>
      <p>
        担保金额(万元):
        <span v-text="form.assurePrice"></span>
      </p>
      <p>
        担保公司:
        <span v-text="form.guaranteeComp"></span>
      </p>
      <p>
        申请人:
        <span v-text="form.applicant"></span>
      </p>
      <p>
        联系人:
        <span v-text="form.name"></span>
      </p>
      <p>
        手机号:
        <span v-text="form.phone"></span>
      </p>
      <p>
        地址:
        <span v-text="form.address"></span>
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
        <span v-text="form.isActive === 0 ? '激活' : '冻结'"></span>
      </p>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.projectChoice" title="选择招投标项目">
      <project-list-choice ref="ProjectListChoice" v-on:confirmChoiceProject="confirmChoiceProject"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('projectChoice')">取消</Button>
        <Button type="primary" size="large" @click="confirmChoice">确认选择</Button>
      </div>
    </Modal>

    <Modal :transfer="false" v-model="modal.projectDetail" title="招投标项目详情">
      <project-detail :form="projectDetailForm"/>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.projectDetailSearch" title="搜索主表信息">
      <project-list-single
        ref="ProjectListSingle"
        v-on:confirmSelectionProject="confirmSelectionProject"
      />
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('projectDetailSearch')">取消</Button>
        <Button type="primary" size="large" @click="confirmProject">确认选择</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import * as ResponseStatus from '@/api/response-status'
import ProjectListChoice from '@/view/project/ProjectListChoice.vue'
import { getProjectById } from '@/api/module'
import {
  isActiveSelect,
  guaranteeCompSelect
} from '@/api/select'
import ProjectDetail from '@/view/project/ProjectDetail.vue'
import ProjectListSingle from '@/view/project/ProjectListSingle.vue'

export default {
  name: 'Guarantee',
  components: {
    ProjectListChoice,
    ProjectDetail,
    ProjectListSingle,
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
        addUrl: '/guarantee/admin/save',
        batchAddUrl: '/guarantee/admin/batch-save',
        editUrl: '/guarantee/admin/update',
        batchEditUrl: '/guarantee/admin/batch-update',
        searchUrl: '/guarantee/admin/pager-cond',
        allUrl: '/guarantee/admin/all',
        removeUrl: '/guarantee/admin/remove/',
        batchRemoveUrl: '/guarantee/admin/batch-remove',
        detailUrl: '/guarantee/admin/one/',
        activeUrl: '/guarantee/admin/active',
        batchActiveUrl: '/guarantee/admin/batch-active'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        projectId: null,
        projectName: null,
        openMarkTime: null,
        markUnitName: null,
        constructionPeriod: null,
        assurePrice: null,
        guaranteeComp: null,
        applicant: null,
        name: null,
        phone: null,
        address: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        projectName: [
          {
            type: 'string',
            min: 1,
            max: 100,
            message: '必须1-100个字符',
            trigger: 'blur'
          }
        ],
        markUnitName: [
          {
            type: 'string',
            min: 1,
            max: 32,
            message: '必须1-32个字符',
            trigger: 'blur'
          }
        ],
        guaranteeComp: [
          {
            type: 'string',
            min: 1,
            max: 32,
            message: '必须1-32个字符',
            trigger: 'blur'
          }
        ],
        applicant: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        name: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        phone: [
          {
            type: 'string',
            min: 1,
            max: 11,
            message: '必须1-11个字符',
            trigger: 'blur'
          }
        ],
        address: [
          {
            type: 'string',
            min: 1,
            max: 100,
            message: '必须1-100个字符',
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
        projectName: null,
        openMarkTime: null,
        openMarkTimeMin: null,
        openMarkTimeMax: null,
        markUnitName: null,
        constructionPeriod: null,
        constructionPeriodMin: null,
        constructionPeriodMax: null,
        assurePrice: null,
        assurePriceMin: null,
        assurePriceMax: null,
        guaranteeComp: null,
        applicant: null,
        name: null,
        phone: null,
        address: null,
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
            title: '保函编号',
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
            title: '项目名称',
            key: 'projectName',
            minWidth: 120,
            sortable: true
          },
          {
            title: '开标时间',
            key: 'openMarkTime',
            minWidth: 120,
            sortable: true
          },
          {
            title: '招标单位名称',
            key: 'markUnitName',
            minWidth: 120,
            sortable: true
          },
          {
            title: '工期(天)',
            key: 'constructionPeriod',
            minWidth: 120,
            sortable: true
          },
          {
            title: '担保金额(万元)',
            key: 'assurePrice',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const text = row.assurePrice / 100
              return h(
                'span',
                {},
                text
              )
            }
          },
          {
            title: '担保公司',
            key: 'guaranteeComp',
            minWidth: 120,
            sortable: true
          },
          {
            title: '申请人',
            key: 'applicant',
            minWidth: 120,
            sortable: true
          },
          {
            title: '联系人',
            key: 'name',
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
            title: '地址',
            key: 'address',
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
        selections: [],
      },
      isActiveSelect: isActiveSelect,
      guaranteeCompSelect: guaranteeCompSelect,
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
      },
    }
  },
  computed: {},
  mounted() {
    this.search()
  },
  methods: {
    showModal(modal) {
      if (modal === 'add') {
        this.form.guaranteeComp = this.guaranteeCompSelect[0].value
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
        this.setPrice(0)
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
      getProjectById(projectId)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.form.projectName = data.data.title
            this.form.openMarkTime = data.data.openMarkTime
            this.form.markUnitName = data.data.markUnitName
            this.form.constructionPeriod = data.data.constructionPeriod
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
      this.cancelModal('projectChoice')
    },
    confirmChoice() {
      this.$refs.ProjectListChoice.confirmSelection()
    },
    // 设置价格
    setPrice(type) {
      if (type === 0) {
        if (this.form.assurePrice !== null && this.form.assurePrice !== 0) {
          this.form.assurePrice = this.form.assurePrice / 100
        }
      } else if (type === 1) {
        if (this.form.assurePrice !== null && this.form.assurePrice !== 0) {
          this.form.assurePrice = this.form.assurePrice * 100
        }
      }
    },
    add() {
      this.setPrice(1)
      utils.add(this)
    },
    edit() {
      this.setPrice(1)
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
    }
  }
}
</script>

<style>
</style>
