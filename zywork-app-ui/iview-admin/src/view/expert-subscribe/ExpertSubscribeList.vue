<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
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
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="专家预约编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始专家预约编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束专家预约编号"
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
        <FormItem label="预约专家编号">
          <Row>
            <i-col span="11">
              <FormItem prop="expertUserIdMin">
                <InputNumber
                  v-model="searchForm.expertUserIdMin"
                  placeholder="请输入开始预约专家编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="expertUserIdMax">
                <InputNumber
                  v-model="searchForm.expertUserIdMax"
                  placeholder="请输入结束预约专家编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="问题类型" prop="questionType">
          <Select v-model="searchForm.questionType" placeholder="请选择问题类型" clearable filterable>
            <i-option
              v-for="item in questionTypeSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="回复用户编号">
          <Row>
            <i-col span="11">
              <FormItem prop="replyUserIdMin">
                <InputNumber
                  v-model="searchForm.replyUserIdMin"
                  placeholder="请输入开始回复用户编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="replyUserIdMax">
                <InputNumber
                  v-model="searchForm.replyUserIdMax"
                  placeholder="请输入结束回复用户编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="预约状态" prop="subscribeStatus">
          <Select v-model="searchForm.subscribeStatus" placeholder="请选择预约状态" clearable filterable>
            <i-option
              v-for="item in subscribeStatusSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="预约价格">
          <Row>
            <i-col span="11">
              <FormItem prop="priceMin">
                <InputNumber
                  v-model="searchForm.priceMin"
                  placeholder="请输入开始预约价格"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="priceMax">
                <InputNumber
                  v-model="searchForm.priceMax"
                  placeholder="请输入结束预约价格"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="支付状态" prop="payStatus">
          <Select v-model="searchForm.payStatus" placeholder="请选择支付状态" clearable filterable>
            <i-option
              v-for="item in payStatusSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="支付方式" prop="payType">
          <Select v-model="searchForm.payType" placeholder="请选择支付方式" clearable filterable>
            <i-option
              v-for="item in payTypeSelect"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="交易编号" prop="transactionNo">
          <Input v-model="searchForm.transactionNo" placeholder="请输入交易编号"/>
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
        >确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>
        专家预约编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        预约专家编号:
        <span v-text="form.expertUserId"></span>
      </p>
      <p>
        问题类型:
        <span v-text="form.questionType"></span>
      </p>
      <p>
        问题说明:
        <span v-text="form.questionDesc"></span>
      </p>
      <p>
        回复用户编号:
        <span v-text="form.replyUserId"></span>
      </p>
      <p>
        回复内容:
        <span v-text="form.replyContent"></span>
      </p>
      <p>
        回复时间:
        <span v-text="form.replyTime"></span>
      </p>
      <p>
        预约状态:
        <span v-text="form.subscribeStatus"></span>
      </p>
      <p>
        预约价格:
        <span v-text="form.price"></span>
      </p>
      <p>
        支付状态:
        <span v-text="form.payStatus"></span>
      </p>
      <p>
        支付方式:
        <span v-text="form.payType"></span>
      </p>
      <p>
        交易编号:
        <span v-text="form.transactionNo"></span>
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

    <Modal :transfer="false" v-model="modal.userDetail" title="模块详情">
      <userDetail :form="userDetailForm" v-on:setDetail="setDetailModal"/>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.userDetalSearch" title="搜索主表信息">
      <user-list ref="UserList" v-on:confirmSelection="confirmSelection"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('moduleSearch')">取消</Button>
        <Button type="primary" size="large" @click="confirm">确认选择</Button>
      </div>
    </Modal>

    <Modal
      :transfer="false"
      v-model="modal.replay"
      title="回复"
      @on-visible-change="changeModalVisibleResetForm('replayForm', $event)"
    >
      <Form ref="replayForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="问题类型" prop="questionType">
          <Input v-model="form.questionType" readonly/>
        </FormItem>
        <FormItem label="问题说明" prop="questionDesc">
          <Input
            v-model="form.questionDesc"
            type="textarea"
            :autosize="descriptionAutoSize"
            readonly
          />
        </FormItem>
        <FormItem label="回复内容" prop="replyContent">
          <Input v-model="form.replyContent" type="textarea" :autosize="descriptionAutoSize"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('replay')">取消</Button>
        <Button type="primary" size="large" @click="replay" :loading="loading.replay">回复</Button>
      </div>
    </Modal>
		
		<Modal
		  :transfer="false"
		  v-model="modal.replayPrice"
		  title="设置回复价格"
		>
			<Form ref="replayForm" :model="form" :label-width="80" :rules="validateRules">
		    <FormItem label="价格" prop="price">
		      <InputNumber v-model="form.price" placeholder="请输入问题价格" style="width: 100%;"/>
		    </FormItem>
		  </Form>
		  <div slot="footer">
		    <Button type="text" size="large" @click="cancelModal('replayPrice')">取消</Button>
		    <Button type="primary" size="large" @click="replayPrice" :loading="loading.replayPrice">设置价格</Button>
		  </div>
		</Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import UserList from '@/view/user/UserList.vue'
import userDetail from '@/view/user-detail/UserDetail.vue'
import { getUserById } from '@/api/module'
import {
  isActiveSelect,
  subscribeStatusSelect,
  payStatusSelect,
  payTypeSelect,
  questionTypeSelect
} from '@/api/select'
import * as es from '@/api/expert_subscribe'

export default {
  name: 'ExpertSubscribeList',
  components: {
    userDetail,
    UserList
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
        replay: false,
				replayPrice: false
      },
      loading: {
        search: false,
        replay: false,
				replayPrice: false
      },
      urls: {
        searchUrl: '/expersubscribe/admin/pager-cond',
        allUrl: '/expersubscribe/admin/all',
        detailUrl: '/expersubscribe/admin/one/',
        replayUrl: '/expersubscribe/admin/replay',
				replayPriceUrl: '/expersubscribe/admin/replayPrice'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        userId: null,
        expertUserId: null,
        questionType: null,
        questionDesc: null,
        replyUserId: null,
        replyContent: null,
        replyTime: null,
        subscribeStatus: null,
        price: 0,
        payStatus: null,
        payType: null,
        transactionNo: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        questionType: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        questionDesc: [
          {
            type: 'string',
            min: 1,
            max: 255,
            message: '必须1-255个字符',
            trigger: 'blur'
          }
        ],
        replyContent: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 255,
            message: '必须1-255个字符',
            trigger: 'blur'
          }
        ],
        subscribeStatus: [
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        payStatus: [
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        payType: [
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        transactionNo: [
          {
            type: 'string',
            min: 1,
            max: 32,
            message: '必须1-32个字符',
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
        expertUserId: null,
        expertUserIdMin: null,
        expertUserIdMax: null,
        questionType: null,
        questionDesc: null,
        replyUserId: null,
        replyUserIdMin: null,
        replyUserIdMax: null,
        replyContent: null,
        replyTime: null,
        replyTimeMin: null,
        replyTimeMax: null,
        subscribeStatus: null,
        price: null,
        priceMin: null,
        priceMax: null,
        payStatus: null,
        payType: null,
        transactionNo: null,
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
            title: '专家预约编号',
            key: 'id',
            minWidth: 130,
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
            title: '预约专家编号',
            key: 'expertUserId',
            minWidth: 130,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const text = row.expertUserId === 0 ? '无' : row.expertUserId
              return h('span', {}, text)
            }
          },
          {
            title: '问题类型',
            key: 'questionType',
            minWidth: 120,
            sortable: true
          },
          {
            title: '问题说明',
            key: 'questionDesc',
            minWidth: 180,
            sortable: true
          },
          {
            title: '回复用户编号',
            key: 'replyUserId',
            minWidth: 130,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const text = row.replyUserId === 0 ? '无' : row.replyUserId
              return h('span', {}, text)
            }
          },
          {
            title: '回复内容',
            key: 'replyContent',
            minWidth: 180,
            sortable: true
          },
          {
            title: '回复时间',
            key: 'replyTime',
            minWidth: 150,
            sortable: true
          },
          {
            title: '预约状态',
            key: 'subscribeStatus',
            minWidth: 120,
            sortable: true
          },
          {
            title: '预约价格',
            key: 'price',
            minWidth: 120,
            sortable: true
          },
          {
            title: '支付状态',
            key: 'payStatus',
            minWidth: 120,
            sortable: true
          },
          {
            title: '支付方式',
            key: 'payType',
            minWidth: 120,
            sortable: true
          },
          {
            title: '交易编号',
            key: 'transactionNo',
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
                      )
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
									          name: 'settingReplyPrice'
									        }
									      },
									      '设置回复价格'
									    )
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
                            name: 'replay'
                          }
                        },
                        '回复'
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
      subscribeStatusSelect: subscribeStatusSelect,
      payStatusSelect: payStatusSelect,
      payTypeSelect: payTypeSelect,
      questionTypeSelect: questionTypeSelect,
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
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
    userOpt(itemName, row) {
      if (itemName === 'moduleDetail') {
        this.showUserDetailModal(row.userId)
      } else if (itemName === 'replyDetail') {
        this.showUserDetailModal(row.replyUserId)
      } else if (itemName === 'expertDetail') {
        this.showUserDetailModal(row.expertUserId)
      } else if (itemName === 'showSearch') {
        utils.showModal(this, 'userDetalSearch')
      } else if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'replay') {
        utils.showModal(this, 'replay')
        this.form = JSON.parse(JSON.stringify(row))
      } else if(itemName == 'settingReplyPrice') {
				utils.showModal(this, 'replayPrice')
				this.form = JSON.parse(JSON.stringify(row))
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
      this.searchForm.userIdMin = this.searchForm.userIdMax = id
      utils.search(this)
    },
    confirm() {
      this.$refs.UserList.confirmSelection()
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
    replay() {
			es.replay(this)
		},
		replayPrice() {
			es.replayPrice(this)
		}
  }
}
</script>

<style>
</style>
