<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <!-- <Button @click="showModal('add')" type="primary">添加</Button>&nbsp; -->
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
              <!-- <DropdownItem name="batchRemove" divided>
                <span style="color: red;">批量删除</span>
              </DropdownItem> -->
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
        <FormItem label="用户编号" prop="userId">
          <InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;"/>
        </FormItem>
        <FormItem label="抵扣券编号" prop="couponId">
          <InputNumber v-model="form.couponId" placeholder="请输入抵扣券编号" style="width: 100%;"/>
        </FormItem>
        <FormItem label="原价" prop="oldPriceDisplay">
          <InputNumber v-model="form.oldPriceDisplay" placeholder="请输入原价" style="width: 100%;"/>
        </FormItem>
        <FormItem label="优惠价" prop="couponPriceDisplay">
          <InputNumber v-model="form.couponPriceDisplay" placeholder="请输入优惠价" style="width: 100%;"/>
        </FormItem>
        <FormItem label="价格" prop="priceDisplay">
          <InputNumber v-model="form.priceDisplay" placeholder="请输入价格" style="width: 100%;"/>
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
        <FormItem label="用户编号" prop="userId">
          <InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;"/>
        </FormItem>
        <FormItem label="抵扣券编号" prop="couponId">
          <InputNumber v-model="form.couponId" placeholder="请输入抵扣券编号" style="width: 100%;"/>
        </FormItem>
        <FormItem label="原价" prop="oldPriceDisplay">
          <InputNumber v-model="form.oldPriceDisplay" placeholder="请输入原价" style="width: 100%;"/>
        </FormItem>
        <FormItem label="优惠价" prop="couponPriceDisplay">
          <InputNumber v-model="form.couponPriceDisplay" placeholder="请输入优惠价" style="width: 100%;"/>
        </FormItem>
        <FormItem label="价格" prop="priceDisplay">
          <InputNumber v-model="form.priceDisplay" placeholder="请输入价格" style="width: 100%;"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="抵扣券使用记录编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始抵扣券使用记录编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束抵扣券使用记录编号"
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
        <FormItem label="抵扣券编号">
          <Row>
            <i-col span="11">
              <FormItem prop="couponIdMin">
                <InputNumber
                  v-model="searchForm.couponIdMin"
                  placeholder="请输入开始抵扣券编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="couponIdMax">
                <InputNumber
                  v-model="searchForm.couponIdMax"
                  placeholder="请输入结束抵扣券编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="原价">
          <Row>
            <i-col span="11">
              <FormItem prop="oldPriceMin">
                <InputNumber
                  v-model="searchForm.oldPriceMin"
                  placeholder="请输入开始原价"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="oldPriceMax">
                <InputNumber
                  v-model="searchForm.oldPriceMax"
                  placeholder="请输入结束原价"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="优惠价">
          <Row>
            <i-col span="11">
              <FormItem prop="couponPriceMin">
                <InputNumber
                  v-model="searchForm.couponPriceMin"
                  placeholder="请输入开始优惠价"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="couponPriceMax">
                <InputNumber
                  v-model="searchForm.couponPriceMax"
                  placeholder="请输入结束优惠价"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="价格">
          <Row>
            <i-col span="11">
              <FormItem prop="priceMin">
                <InputNumber
                  v-model="searchForm.priceMin"
                  placeholder="请输入开始价格"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="priceMax">
                <InputNumber
                  v-model="searchForm.priceMax"
                  placeholder="请输入结束价格"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
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
        抵扣券使用记录编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        抵扣券编号:
        <span v-text="form.couponId"></span>
      </p>
      <p>
        原价:
        <span v-text="form.oldPrice/100"></span>
      </p>
      <p>
        优惠价:
        <span v-text="form.couponPrice/100"></span>
      </p>
      <p>
        价格:
        <span v-text="form.price/100"></span>
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

     <Modal :transfer="false" v-model="modal.couponDetail" title="优惠券详情">
      <couponDetail :form="couponDetailForm"/>
    </Modal>

    <Modal :transfer="false" fullscreen v-model="modal.couponDetalSearch" title="搜索主表信息">
      <coupon-list ref="couponList" v-on:confirmSelectionCoupon="confirmSelectionCoupon"/>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelModal('couponDetalSearch')">取消</Button>
        <Button type="primary" size="large" @click="confirmCoupon">确认选择</Button>
      </div>
    </Modal>

  </div>
</template>

<script>
import * as utils from '@/api/utils'
import * as ResponseStatus from '@/api/response-status'
import UserListSingle from '@/view/user/UserListSingle.vue'
import userDetail from '@/view/user-detail/UserDetail.vue'
import CouponList from '@/view/coupon/CouponListSingle.vue'
import CouponDetail from '@/view/coupon/CouponDetail.vue'
import { getUserById,getCouponById } from '@/api/module'
import { isActiveSelect } from '@/api/select'

export default {
  name: 'CouponRecord',
  components: {
    userDetail,
    UserListSingle,
    CouponList,
    CouponDetail
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
      couponDetailForm: {
        id: null,
        type: null,
        money: null,
        couponCount: null,
        validTime: null,
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
        userDetail: false,
        userDetalSearch: false,
        couponDetalSearch: false,
        couponDetail: false
      },
      loading: {
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/coupon-record/admin/save',
        batchAddUrl: '/coupon-record/admin/batch-save',
        editUrl: '/coupon-record/admin/update',
        batchEditUrl: '/coupon-record/admin/batch-update',
        searchUrl: '/coupon-record/admin/pager-cond',
        allUrl: '/coupon-record/admin/all',
        removeUrl: '/coupon-record/admin/remove/',
        batchRemoveUrl: '/coupon-record/admin/batch-remove',
        detailUrl: '/coupon-record/admin/one/',
        activeUrl: '/coupon-record/admin/active',
        batchActiveUrl: '/coupon-record/admin/batch-active'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        userId: null,
        couponId: null,
        oldPrice: null,
        couponPrice: null,
        price: null,
				oldPriceDisplay: null,
				couponPriceDisplay: null,
				priceDisplay: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {},
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
        couponId: null,
        couponIdMin: null,
        couponIdMax: null,
        oldPrice: null,
        oldPriceMin: null,
        oldPriceMax: null,
        couponPrice: null,
        couponPriceMin: null,
        couponPriceMax: null,
        price: null,
        priceMin: null,
        priceMax: null,
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
            title: '抵扣券使用记录编号',
            key: 'id',
            minWidth: 180,
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
            title: '抵扣券编号',
            key: 'couponId',
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
                    params.row.couponId,
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
                            name: 'moduleDetailCoupon'
                          }
                        },
                        '详情'
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showSearchCoupon'
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
            title: '原价',
            key: 'oldPrice',
            minWidth: 120,
            sortable: true,
						render: (h, params) => {
							let text = params.row.oldPrice/100;
						  return h('span', '￥' + text)
						}
          },
          {
            title: '优惠价',
            key: 'couponPrice',
            minWidth: 120,
            sortable: true,
						render: (h, params) => {
							let text = params.row.couponPrice/100;
						  return h('span', '￥' + text)
						}
          },
          {
            title: '价格',
            key: 'price',
            minWidth: 120,
            sortable: true,
						render: (h, params) => {
							let text = params.row.price/100;
						  return h('span', '￥' + text)
						}
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
					  title: '版本号',
					  key: 'version',
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
                      // h(
                      //   'DropdownItem',
                      //   {
                      //     props: {
                      //       name: 'showEdit'
                      //     }
                      //   },
                      //   '编辑'
                      // ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showDetail'
                          }
                        },
                        '详情'
                      ),
                      // h(
                      //   'DropdownItem',
                      //   {
                      //     props: {
                      //       name: 'remove'
                      //     }
                      //   },
                      //   [
                      //     h(
                      //       'span',
                      //       {
                      //         style: {
                      //           color: 'red'
                      //         }
                      //       },
                      //       '删除'
                      //     )
                      //   ]
                      // )
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
      } else if (itemName === 'moduleDetail') {
        this.showUserDetailModal(row.userId)
      } else if (itemName === 'showSearch') {
        utils.showModal(this, 'userDetalSearch')
      } else if (itemName === 'moduleDetailCoupon') {
        this.showCouponDetailModal(row.couponId)
      } else if (itemName === 'showSearchCoupon') {
        utils.showModal(this, 'couponDetalSearch')
      }
    },
    showUserDetailModal(id) {
      getUserById(id)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
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
    showCouponDetailModal(id) {
      getCouponById(id)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.couponDetailForm = data.data
            this.modal.couponDetail = true
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
    confirmSelectionCoupon(id) {
      this.cancelModal('couponDetalSearch')
      this.searchForm.couponIdMin = id
      this.searchForm.couponIdMax = id
      utils.search(this)
    },
    confirm() {
      this.$refs.UserListSingle.confirmSelection()
    },
    confirmCoupon() {
      this.$refs.couponList.confirmSelection()
    },
		setPrice(type) {
		  if (type === 0) {
		    if (this.form.oldPrice !== null && this.form.oldPrice !== 0) {
		      this.form.oldPriceDisplay = this.form.oldPrice / 100
		    }
				 if (this.form.couponPrice !== null && this.form.couponPrice !== 0) {
				  this.form.couponPriceDisplay = this.form.couponPrice / 100
				}
				 if (this.form.price !== null && this.form.price !== 0) {
				  this.form.priceDisplay = this.form.price / 100
				}
		  } else if (type === 1) {
		    if (this.form.oldPriceDisplay !== null && this.form.oldPriceDisplay !== 0) {
		      this.form.oldPrice = this.form.oldPriceDisplay * 100
		    }
				 if (this.form.couponPriceDisplay !== null && this.form.couponPriceDisplay !== 0) {
				  this.form.couponPrice = this.form.couponPriceDisplay * 100
				}
				 if (this.form.priceDisplay !== null && this.form.priceDisplay !== 0) {
				  this.form.price = this.form.priceDisplay * 100
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
