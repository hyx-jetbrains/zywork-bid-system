<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="confirmSelection" type="primary">确认选择</Button>&nbsp;
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
    <Modal v-model="modal.search" title="高级搜索">
      <div slot="header">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button
          type="primary"
          size="large"
          @click="searchOkModal('search')"
          :loading="loading.search"
        >搜索</Button>
      </div>
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="招投标项目编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始招投标项目编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束招投标项目编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="项目名称" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入项目名称"/>
        </FormItem>
        <FormItem label="项目类型" prop="projectType">
          <Select v-model="searchForm.projectType" placeholder="请选择项目类型" clearable filterable>
            <i-option
              v-for="item in projectType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="城市" prop="city">
          <Select v-model="searchForm.city" placeholder="请选择城市" clearable filterable>
            <i-option
              v-for="item in projectCity"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="项目详情" prop="projectDetail">
          <Input v-model="searchForm.projectDetail" placeholder="请输入项目详情"/>
        </FormItem>
        <FormItem label="发布状态" prop="releaseStatus">
          <Select v-model="searchForm.releaseStatus" placeholder="请选择发布状态" clearable filterable>
            <i-option
              v-for="item in projectReleaseStatus"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="招标单位名称" prop="markUnitName">
          <Input v-model="searchForm.markUnitName" placeholder="请输入招标单位名称"/>
        </FormItem>
        <FormItem label="项目投资" prop="projectInvest">
          <Input v-model="searchForm.projectInvest" placeholder="请输入项目投资"/>
        </FormItem>
        <FormItem label="审查方式" prop="checkPattern">
          <Input v-model="searchForm.checkPattern" placeholder="请输入审查方式"/>
        </FormItem>
        <FormItem label="企业资质类型" prop="compAptitudeType">
          <Input v-model="searchForm.compAptitudeType" placeholder="请输入企业资质类型"/>
        </FormItem>
        <FormItem label="建造师等级" prop="builderLevel">
          <Input v-model="searchForm.builderLevel" placeholder="请输入建造师等级"/>
        </FormItem>
        <FormItem label="是否电子标">
          <Select v-model="searchForm.isElectronic" placeholder="请选择是否电子标" clearable filterable>
            <i-option
              v-for="item in isElectronic"
              :value="item.value"
              :key="item.value"
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
        <FormItem label="招标代理" prop="tenderingAgent">
          <Input v-model="searchForm.tenderingAgent" placeholder="请输入招标代理"/>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="searchForm.phone" placeholder="请输入联系电话"/>
        </FormItem>
        <FormItem label="保证金(万元)">
          <Row>
            <i-col span="11">
              <FormItem prop="assurePriceMin">
                <InputNumber
                  v-model="searchForm.assurePriceMin"
                  placeholder="请输入开始保证金(万元)"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="assurePriceMax">
                <InputNumber
                  v-model="searchForm.assurePriceMax"
                  placeholder="请输入结束保证金(万元)"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="其他要求" prop="otherDemand">
          <Input v-model="searchForm.otherDemand" placeholder="请输入其他要求"/>
        </FormItem>
        <FormItem label="开标信息" prop="openMarkInfo">
          <Select v-model="searchForm.openMarkInfo" placeholder="请选择开标信息" clearable filterable>
            <i-option
              v-for="item in projectMarkStatus"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="开标地点" prop="openMarkAddr">
          <Input v-model="searchForm.openMarkAddr" placeholder="请输入开标地点"/>
        </FormItem>
        <FormItem label="中标公示" prop="markStatus">
          <Input v-model="searchForm.markStatus" placeholder="请输入中标公示"/>
        </FormItem>
        <FormItem label="中标单位" prop="inMarkComp">
          <Input v-model="searchForm.inMarkComp" placeholder="请输入中标单位"/>
        </FormItem>
        <FormItem label="点击次数">
          <Row>
            <i-col span="11">
              <FormItem prop="clickCountMin">
                <InputNumber
                  v-model="searchForm.clickCountMin"
                  placeholder="请输入开始点击次数"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="clickCountMax">
                <InputNumber
                  v-model="searchForm.clickCountMax"
                  placeholder="请输入结束点击次数"
                  style="width: 100%;"
                />
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
    <Modal
      v-model="modal.detail"
      title="详情"
    >
      <p>
        招投标项目编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        项目名称:
        <span v-text="form.title"></span>
      </p>
      <p>
        项目类型:
        <span v-text="form.projectType"></span>
      </p>
      <p>
        城市:
        <span v-text="form.city"></span>
      </p>
      <p>
        发布状态:
        <span v-text="form.releaseStatus"></span>
      </p>
      <p>
        招标单位名称:
        <span v-text="form.markUnitName"></span>
      </p>
      <p>
        项目投资:
        <span v-text="form.projectInvest"></span>
      </p>
      <p>
        审查方式:
        <span v-text="form.checkPattern"></span>
      </p>
      <p>
        企业资质类型:
        <span v-text="form.compAptitudeType"></span>
      </p>
      <p>
        建造师等级:
        <span v-text="form.builderLevel"></span>
      </p>
      <p>
        资金落实(%):
        <span v-text="form.moneyToImplement"></span>
      </p>
      <p>
        招标代理:
        <span v-text="form.tenderingAgent"></span>
      </p>
      <p>
        联系电话:
        <span v-text="form.phone"></span>
      </p>
      <p>
        要约价(元):
        <span v-text="form.offerPrice"></span>
      </p>
      <p>
        保证金(万元):
        <span v-text="form.assurePrice"></span>
      </p>
      <p>
        工期(天):
        <span v-text="form.constructionPeriod"></span>
      </p>
      <p>
        下载截止时间:
        <span v-text="form.downloadEndTime"></span>
      </p>
      <p>
        源地址：
        <a :href="form.sourceUrl" target="_blank">{{form.sourceUrl}}</a>
      </p>
      <p>
        其他要求:
        <span v-text="form.otherDemand"></span>
      </p>
      <p>
        开标信息:
        <span v-text="form.openMarkInfo"></span>
      </p>
      <p>
        开标时间:
        <span v-text="form.openMarkTime"></span>
      </p>
      <p>
        开标地点:
        <span v-text="form.openMarkAddr"></span>
      </p>
      <p>
        中标公示:
        <span v-text="form.markStatus"></span>
      </p>
      <p>
        中标单位:
        <span v-text="form.inMarkComp"></span>
      </p>
      <p>
        公告时间:
        <span v-text="form.noticeTime"></span>
      </p>
      <p>
        点击次数:
        <span v-text="form.clickCount"></span>
      </p>
      <p>
        是否电子标:
        <span v-text="form.isElectronic === 0 ? '非电子' : '电子'"></span>
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
    <Modal
      v-model="modal.projectDetail"
      title="招投标项目公示详情"
      :fullscreen="true"
    >
      <span v-html="form.projectDetail"></span>
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import {
  isActiveSelect,
  projectType,
  isElectronic,
  projectReleaseStatus,
  projectCity,
  projectMarkStatus
} from '@/api/select'

export default {
  name: 'ProjectList',
  data() {
    return {
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false,
        projectDetail: false
      },
      loading: {
        search: false
      },
      urls: {
        searchUrl: '/project/admin/pager-cond',
        allUrl: '/project/admin/all',
        detailUrl: '/project/admin/one/'
      },
      page: {
        total: 0
      },
      form: {
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
        moneyToImplement: null,
        tenderingAgent: null,
        phone: null,
        offerPrice: null,
        assurePrice: null,
        constructionPeriod: null,
        downloadEndTime: null,
        otherDemand: null,
        openMarkInfo: null,
        openMarkTime: null,
        openMarkAddr: null,
        markStatus: null,
        inMarkComp: null,
        noticeTime: null,
        clickCount: null,
        isElectronic: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
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
        projectType: null,
        city: null,
        projectDetail: null,
        releaseStatus: null,
        markUnitName: null,
        projectInvest: null,
        checkPattern: null,
        compAptitudeType: null,
        builderLevel: null,
        moneyToImplement: null,
        moneyToImplementMin: null,
        moneyToImplementMax: null,
        tenderingAgent: null,
        phone: null,
        offerPrice: null,
        offerPriceMin: null,
        offerPriceMax: null,
        assurePrice: null,
        assurePriceMin: null,
        assurePriceMax: null,
        constructionPeriod: null,
        constructionPeriodMin: null,
        constructionPeriodMax: null,
        downloadEndTime: null,
        downloadEndTimeMin: null,
        downloadEndTimeMax: null,
        otherDemand: null,
        openMarkInfo: null,
        openMarkTime: null,
        openMarkTimeMin: null,
        openMarkTimeMax: null,
        openMarkAddr: null,
        markStatus: null,
        inMarkComp: null,
        noticeTime: null,
        noticeTimeMin: null,
        noticeTimeMax: null,
        clickCount: null,
        clickCountMin: null,
        clickCountMax: null,
        isElectronic: null,
        isElectronicMin: null,
        isElectronicMax: null,
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
            title: '招投标项目编号',
            key: 'id',
            minWidth: 140,
            sortable: true
          },
          {
            title: '项目名称',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '项目类型',
            key: 'projectType',
            minWidth: 120,
            sortable: true
          },
          {
            title: '城市',
            key: 'city',
            minWidth: 120,
            sortable: true
          },
          {
            title: '项目详情',
            key: 'projectDetail',
            minWidth: 120,
            render: (h, params) => {
              return h('a', {
                  on: {
                    click: () => {
                      utils.showModal(this, 'projectDetail')
                      this.form = JSON.parse(JSON.stringify(params.row))
                    }
                  }
                },'点击查看')
            }
          },
          {
            title: '发布状态',
            key: 'releaseStatus',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const color = row.releaseStatus === '待审核' ? 'default' 
                          : row.releaseStatus === '已发布' ? 'success' : 'error'
              return h('Button', {
                  props: {
                    size: 'small',
                    type: color
                  }
                }, row.releaseStatus)
              
            }
          },
          {
            title: '招标单位名称',
            key: 'markUnitName',
            minWidth: 130,
            sortable: true
          },
          {
            title: '项目投资',
            key: 'projectInvest',
            minWidth: 120,
            sortable: true
          },
          {
            title: '审查方式',
            key: 'checkPattern',
            minWidth: 120,
            sortable: true
          },
          {
            title: '企业资质类型',
            key: 'compAptitudeType',
            minWidth: 130,
            sortable: true
          },
          {
            title: '建造师等级',
            key: 'builderLevel',
            minWidth: 120,
            sortable: true
          },
          {
            title: '资金落实(%)',
            key: 'moneyToImplement',
            minWidth: 200,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              return h('Progress', {
                  props: {
                    percent: row.moneyToImplement,
                    status: 'active'
                  }
                }, row.moneyToImplement + '%')
            }
          },
          {
            title: '招标代理',
            key: 'tenderingAgent',
            minWidth: 130,
            sortable: true
          },
          {
            title: '联系电话',
            key: 'phone',
            minWidth: 120,
            sortable: true
          },
          {
            title: '要约价(元)',
            key: 'offerPrice',
            minWidth: 120,
            sortable: true
          },
          {
            title: '保证金(万元)',
            key: 'assurePrice',
            minWidth: 130,
            sortable: true
          },
          {
            title: '工期(天)',
            key: 'constructionPeriod',
            minWidth: 120,
            sortable: true
          },
          {
            title: '下载截止时间',
            key: 'downloadEndTime',
            minWidth: 130,
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
            title: '其他要求',
            key: 'otherDemand',
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
            title: '开标信息',
            key: 'openMarkInfo',
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
            title: '开标地点',
            key: 'openMarkAddr',
            minWidth: 120,
            sortable: true
          },
          {
            title: '中标公示',
            key: 'markStatus',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const color = row.markStatus === '待开标' ? 'default' 
                          : row.markStatus === '公告中' ? 'success' 
                          : row.markStatus === '已开标' ? 'primary' : 'error'
              return h('Button', {
                  props: {
                    size: 'small',
                    type: color
                  }
                }, row.markStatus)
            }
          },
          {
            title: '中标单位',
            key: 'inMarkComp',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公告时间',
            key: 'noticeTime',
            minWidth: 120,
            sortable: true
          },
          {
            title: '点击次数',
            key: 'clickCount',
            minWidth: 120,
            sortable: true
          },
          {
            title: '是否电子标',
            key: 'isElectronic',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const color = row.isElectronic === 0 ? 'default' : row.isElectronic === 1 ? 'success' : 'error'
              const text = row.isElectronic === 0 ? '非电子' : row.isElectronic === 1 ? '电子' : '未知'
              return h('Button', {
                  props: {
                    size: 'small',
                    type: color
                  }
                }, text)
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
              const row = params.row
              const color = row.isActive === 0 ? 'primary' : row.isActive === 1 ? 'default' : 'error'
              const text = row.isActive === 0 ? '激活' : row.isActive === 1 ? '冻结' : '未知'
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
            title: '操作',
            key: 'action',
            width: 80,
            align: 'center',
            fixed: 'right',
            render: (h, params) => {
              return h('div', [
                h(
                  'Button',
                  {
                    props: {
                      type: 'primary',
                      size: 'small'
                    },
                    style: {
                      marginRight: '5px'
                    },
                    on: {
                      click: () => {
                        this.showDetail('detail', params.row)
                      }
                    }
                  },
                  '详情'
                )
              ])
            }
          }
        ],
        tableDetails: [],
        selections: []
      },
      isActiveSelect: isActiveSelect,
      projectReleaseStatus: projectReleaseStatus,
      isElectronic: isElectronic,
      projectType: projectType,
      projectCity: projectCity,
      projectMarkStatus: projectMarkStatus,
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
      this.searchForm.pageNo = 1
      utils.search(this)
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
    confirmSelection() {
      // 确认选择的逻辑
      if (this.table.selections.length !== 1) {
        this.$Message.warning("只能选择一个项目")
        return
      }
      this.$emit('initData', this.table.selections[0].id, this.table.selections[0].title)
    }
  }
}
</script>

<style>
</style>
