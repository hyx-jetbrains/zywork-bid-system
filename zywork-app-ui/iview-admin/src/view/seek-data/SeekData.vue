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
          <Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
        </FormItem>
        <FormItem label="出发地点" prop="startAddr">
					<Select v-model="form.startAddr" placeholder="请选择出发地点" clearable filterable>
						<i-option v-for="item in projectCity" :value="item.value" :key="item.value">{{item.label}}</i-option>
					</Select>
        </FormItem>
        <FormItem label="目的地" prop="endAddr">
					<Select v-model="form.endAddr" placeholder="请选择目的地" clearable filterable>
						<i-option v-for="item in projectCity" :value="item.value" :key="item.value">{{item.label}}</i-option>
					</Select>
        </FormItem>
        <FormItem label="资料类型" prop="dataType">
          <Select v-model="form.dataType" placeholder="请选择资料类型" clearable filterable>
            <i-option
              v-for="item in seekDataType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="资料数量" prop="dataCount">
          <InputNumber v-model="form.dataCount" placeholder="请输入资料数量" style="width: 100%;"/>
        </FormItem>
        <FormItem label="最晚时间" prop="latestTime">
          <DatePicker
            @on-change="form.latestTime=$event"
            :value="form.latestTime"
            placeholder="请输入最晚时间"
            type="datetime"
            format="yyyy-MM-dd HH:mm:ss"
            style="width: 100%;"
          ></DatePicker>
        </FormItem>
        <FormItem label="赏金" prop="priceDisplay">
          <InputNumber v-model="form.priceDisplay" placeholder="请输入赏金（元）" style="width: 100%;"/>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="form.phone" placeholder="请输入联系电话"/>
        </FormItem>
        <FormItem label="是否加急" prop="isUrgent">
          <i-switch v-model="isUrgent">
            <Icon slot="open">是</Icon>
            <Icon slot="close">否</Icon>
          </i-switch>
        </FormItem>
        <FormItem label="备注" prop="memo">
          <Input
            v-model="form.memo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入备注"
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
          <Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
        </FormItem>
        <FormItem label="出发地点" prop="startAddr">
         <Select v-model="form.startAddr" placeholder="请选择出发地点" clearable filterable>
         	<i-option v-for="item in projectCity" :value="item.value" :key="item.value">{{item.label}}</i-option>
         </Select>
        </FormItem>
        <FormItem label="目的地" prop="endAddr">
          <Select v-model="form.endAddr" placeholder="请选择出发地点" clearable filterable>
          	<i-option v-for="item in projectCity" :value="item.value" :key="item.value">{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="资料类型" prop="dataType">
          <Select v-model="form.dataType" placeholder="请选择资料类型" clearable filterable>
            <i-option
              v-for="item in seekDataType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="资料数量" prop="dataCount">
          <InputNumber v-model="form.dataCount" placeholder="请输入资料数量" style="width: 100%;"/>
        </FormItem>
        <FormItem label="最晚时间" prop="latestTime">
          <DatePicker
            @on-change="form.latestTime=$event"
            :value="form.latestTime"
            placeholder="请输入最晚时间"
            type="datetime"
            format="yyyy-MM-dd HH:mm:ss"
            style="width: 100%;"
          ></DatePicker>
        </FormItem>
        <FormItem label="赏金" prop="priceDisplay">
          <InputNumber v-model="form.priceDisplay" placeholder="请输入赏金（元）" style="width: 100%;"/>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="form.phone" placeholder="请输入联系电话"/>
        </FormItem>
        <FormItem label="是否加急" prop="isUrgent">
          <i-switch v-model="isUrgent">
            <Icon slot="open">是</Icon>
            <Icon slot="close">否</Icon>
          </i-switch>
        </FormItem>
        <FormItem label="备注" prop="memo">
          <Input
            v-model="form.memo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入备注"
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
        <FormItem label="求带资料编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始求带资料编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束求带资料编号"
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
        <FormItem label="出发地点" prop="startAddr">
          <Input v-model="searchForm.startAddr" placeholder="请输入出发地点"/>
        </FormItem>
        <FormItem label="目的地" prop="endAddr">
          <Input v-model="searchForm.endAddr" placeholder="请输入目的地"/>
        </FormItem>
        <FormItem label="资料类型" prop="dataType">
          <Select v-model="searchForm.dataType" placeholder="请选择资料类型" clearable filterable>
            <i-option
              v-for="item in seekDataType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="资料数量">
          <Row>
            <i-col span="11">
              <FormItem prop="dataCountMin">
                <InputNumber
                  v-model="searchForm.dataCountMin"
                  placeholder="请输入开始资料数量"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="dataCountMax">
                <InputNumber
                  v-model="searchForm.dataCountMax"
                  placeholder="请输入结束资料数量"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="最晚时间">
          <Row>
            <i-col span="11">
              <FormItem prop="latestTimeMin">
                <DatePicker
                  @on-change="searchForm.latestTimeMin=$event"
                  :value="searchForm.latestTimeMin"
                  placeholder="请输入开始最晚时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="latestTimeMax">
                <DatePicker
                  @on-change="searchForm.latestTimeMax=$event"
                  :value="searchForm.latestTimeMax"
                  placeholder="请输入结束最晚时间"
                  type="datetime"
                  format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></DatePicker>
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="赏金">
          <Row>
            <i-col span="11">
              <FormItem prop="priceMin">
                <InputNumber
                  v-model="searchForm.priceMin"
                  placeholder="请输入开始赏金"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="priceMax">
                <InputNumber
                  v-model="searchForm.priceMax"
                  placeholder="请输入结束赏金"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="searchForm.phone" placeholder="请输入联系电话"/>
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
        求带资料编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        出发地点:
        <span v-text="form.startAddr"></span>
      </p>
      <p>
        目的地:
        <span v-text="form.endAddr"></span>
      </p>
      <p>
        资料类型:
        <span v-text="form.dataType"></span>
      </p>
      <p>
        资料数量:
        <span v-text="form.dataCount"></span>
      </p>
      <p>
        最晚时间:
        <span v-text="form.latestTime"></span>
      </p>
      <p>
        赏金:
        <span v-text="form.price/100"></span>
      </p>
      <p>
        联系电话:
        <span v-text="form.phone"></span>
      </p>
      <p>
        是否加急:
        <span v-text="form.isUrgent"></span>
      </p>
      <p>
        备注:
        <span v-text="form.memo"></span>
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
import userDetail from '@/view/user-detail/UserDetail.vue'
import UserListChoice from '@/view/user/UserListChoice.vue'
import { getUserById } from '@/api/module'
import {
  isActiveSelect,
  seekDataType,
	projectCity
} from '@/api/select'
import {
  setSeekDataIsUrgent
} from '@/api/user'

export default {
  name: 'SeekData',
  components: {
    userDetail,
    UserListSingle,
    UserListChoice
  },
  data() {
    return {
			projectCity: projectCity,
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
        addUrl: '/seek-data/admin/save',
        batchAddUrl: '/seek-data/admin/batch-save',
        editUrl: '/seek-data/admin/update',
        batchEditUrl: '/seek-data/admin/batch-update',
        searchUrl: '/seek-data/admin/pager-cond',
        allUrl: '/seek-data/admin/all',
        removeUrl: '/seek-data/admin/remove/',
        batchRemoveUrl: '/seek-data/admin/batch-remove',
        detailUrl: '/seek-data/admin/one/',
        activeUrl: '/seek-data/admin/active',
        batchActiveUrl: '/seek-data/admin/batch-active'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        userId: null,
        startAddr: null,
        endAddr: null,
        dataType: null,
        dataCount: null,
        latestTime: null,
        price: null,
				priceDisplay: null,
        phone: null,
        isUrgent: null,
        memo: null,
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
        startAddr: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        endAddr: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        dataType: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 10,
            message: '必须1-10个字符',
            trigger: 'blur'
          }
        ],
        dataCount: [
          {
            type: 'integer',
            required: true,
            message: '此项为必须项',
            trigger: 'blur, change'
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
        startAddr: null,
        endAddr: null,
        dataType: null,
        dataCount: null,
        dataCountMin: null,
        dataCountMax: null,
        latestTime: null,
        latestTimeMin: null,
        latestTimeMax: null,
        price: null,
        priceMin: null,
        priceMax: null,
        phone: null,
        isUrgent: null,
        isUrgentMin: null,
        isUrgentMax: null,
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
            title: '求带资料编号',
            key: 'id',
            minWidth: 160,
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
            title: '出发地点',
            key: 'startAddr',
            minWidth: 180,
            sortable: true
          },
          {
            title: '目的地',
            key: 'endAddr',
            minWidth: 180,
            sortable: true
          },
          {
            title: '资料类型',
            key: 'dataType',
            minWidth: 120,
            sortable: true
          },
          {
            title: '资料数量',
            key: 'dataCount',
            minWidth: 120,
            sortable: true
          },
          {
            title: '最晚时间',
            key: 'latestTime',
            minWidth: 150,
            sortable: true
          },
          {
            title: '赏金',
            key: 'price',
            minWidth: 120,
            sortable: true,
						render: (h, params) => {
							let text = params.row.price/100;
						  return h('span', '￥'+text)
						}
          },
          {
            title: '联系电话',
            key: 'phone',
            minWidth: 120,
            sortable: true
          },
          {
            title: '是否加急',
            key: 'isUrgent',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              return h(
                'i-switch',
                {
                  props: {
                    size: 'large',
                    value: params.row.isUrgent === 0
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    'on-change': status => {
                      this.setIsUrgent(params.row)
                    }
                  }
                },
                [
                  h(
                    'span',
                    {
                      slot: 'open'
                    },
                    '是'
                  ),
                  h(
                    'span',
                    {
                      slot: 'close'
                    },
                    '否'
                  )
                ]
              )
            }
          },
          {
            title: '备注',
            key: 'memo',
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
      seekDataType: seekDataType,
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
      },
      isUrgent: false
    }
  },
  computed: {},
  mounted() {
    this.search()
  },
  methods: {
    showModal(modal) {
      if (modal === 'add') {
        this.form.dataType = this.seekDataType[0].value
        this.isUrgent = false
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
    setSwitchData(row) {
      if (row.isUrgent === 0) {
        this.isUrgent = true
      } else {
        this.isUrgent = false
      }
    },
    userOpt(itemName, row) {
      if (itemName === 'showEdit') {
        utils.showModal(this, 'edit')
        this.form = JSON.parse(JSON.stringify(row))
				this.setPrice(0)
        this.setSwitchData(row)
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
    setSwitch() {
      if (this.isUrgent) {
        this.form.isUrgent = 0
      } else {
        this.form.isUrgent = 1
      }
    },
		setPrice(type) {
			if (type === 0) {
				if (this.form.price !== null && this.form.price !== 0) {
					this.form.priceDisplay = this.form.price / 100
				}
			} else if (type === 1) {
				if (this.form.priceDisplay !== null && this.form.priceDisplay !== 0) {
					this.form.price = this.form.priceDisplay * 100
				}
			}
		},
    add() {
      this.setSwitch()
			this.setPrice(1)
      utils.add(this)
    },
    edit() {
      this.setSwitch()
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
    },
    // 确认选择用户
    confirmChoice(userId) {
      this.form.userId = userId
      this.cancelModal('userChoice')
    },
    // 设置是否允加急
    setIsUrgent(row) {
      setSeekDataIsUrgent(this, row)
    }
  }
}
</script>

<style>
</style>
