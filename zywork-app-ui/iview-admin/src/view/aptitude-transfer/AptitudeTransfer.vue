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
				<FormItem label="用户编号" prop="userId">
					<span v-text="form.userId"></span>
					&nbsp;
					<Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
				</FormItem>
        <FormItem label="转让类别" prop="type">
          <Select v-model="form.type" placeholder="请选择转让类别" clearable filterable @on-change="switchType">
            <i-option
              v-for="item in aptitudeTransferType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="标题" prop="title">
          <Input v-model="form.title" placeholder="请输入标题"/>
        </FormItem>
        <FormItem label="企业资质等级" prop="compAptitudeLevel">
          <Select v-model="form.compAptitudeLevel" placeholder="请选择企业资质等级" clearable filterable @on-change="switchType">
            <i-option
              v-for="item in companyAptitudeLevel"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="企业资质类型" prop="compAptitudeType">
          <Select v-model="form.compAptitudeType" placeholder="请选择企业资质类型" clearable filterable @on-change="switchType">
            <i-option
              v-for="item in companyAptitudeType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="form.phone" placeholder="请输入联系电话"/>
        </FormItem>
        <FormItem label="备注" prop="memo">
          <Input
            v-model="form.memo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入备注"
          />
        </FormItem>
        <FormItem label="资源文件" prop="resourceId" v-if="isEnclosureShow">
          <Upload
            multiple
            type="drag"
            :action="urls.uploadResourceUrl"
            :on-success="handleSuccess"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :headers="uploadHeader"
          >
            <div style="padding: 20px 0">
              <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
              <p>单击或拖动文件到此处上传</p>
            </div>
          </Upload>
          <p style="color: red">请放心上传你的资质证书，我们平台承诺仅为核实企业真实性，不会对外透露贵公司信息。</p>
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
					<span v-text="form.userId"></span>
					&nbsp;
					<Button @click="showModal('userChoice')" type="text">选择用户</Button>&nbsp;
				</FormItem>
        <FormItem label="转让类别" prop="type">
          <Select v-model="form.type" placeholder="请选择转让类别" clearable filterable @on-change="switchType">
            <i-option
              v-for="item in aptitudeTransferType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="标题" prop="title">
          <Input v-model="form.title" placeholder="请输入标题"/>
        </FormItem>
        <FormItem label="企业资质等级" prop="compAptitudeLevel">
          <Select v-model="form.compAptitudeLevel" placeholder="请选择企业资质等级" clearable filterable @on-change="switchType">
            <i-option
              v-for="item in companyAptitudeLevel"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="企业资质类型" prop="compAptitudeType">
          <Select v-model="form.compAptitudeType" placeholder="请选择企业资质类型" clearable filterable @on-change="switchType">
            <i-option
              v-for="item in companyAptitudeType"
              :value="item.value"
              :key="item.value"
            >{{item.label}}</i-option>
          </Select>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="form.phone" placeholder="请输入联系电话"/>
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
        <FormItem label="资质转让编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始资质转让编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束资质转让编号"
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
        <FormItem label="转让类别">
          <Row>
            <i-col span="11">
              <FormItem prop="typeMin">
                <InputNumber
                  v-model="searchForm.typeMin"
                  placeholder="请输入开始转让类别"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="typeMax">
                <InputNumber
                  v-model="searchForm.typeMax"
                  placeholder="请输入结束转让类别"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="项目名称" prop="title">
          <Input v-model="searchForm.title" placeholder="请输入项目名称"/>
        </FormItem>
        <FormItem label="企业资质等级" prop="compAptitudeLevel">
          <Input v-model="searchForm.compAptitudeLevel" placeholder="请输入企业资质等级"/>
        </FormItem>
        <FormItem label="企业资质类型" prop="compAptitudeType">
          <Input v-model="searchForm.compAptitudeType" placeholder="请输入企业资质类型"/>
        </FormItem>
        <FormItem label="联系电话" prop="phone">
          <Input v-model="searchForm.phone" placeholder="请输入联系电话"/>
        </FormItem>
        <FormItem label="备注" prop="memo">
          <Input v-model="searchForm.memo" placeholder="请输入备注"/>
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
        资质转让编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        用户编号:
        <span v-text="form.userId"></span>
      </p>
      <p>
        转让类别:
        <span v-text="form.type"></span>
      </p>
      <p>
        项目名称:
        <span v-text="form.title"></span>
      </p>
      <p>
        企业资质等级:
        <span v-text="form.compAptitudeLevel"></span>
      </p>
      <p>
        企业资质类型:
        <span v-text="form.compAptitudeType"></span>
      </p>
      <p>
        联系电话:
        <span v-text="form.phone"></span>
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

    <Modal
      :transfer="false"
      fullscreen
      v-model="modal.userDetalSearch"
      title="搜索主表信息">
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
import * as ResponseStatus from '@/api/response-status'
import UserListSingle from '@/view/user/UserListSingle.vue'
import userDetail from '@/view/user-detail/UserDetail.vue'
import { getUserById } from '@/api/module'
import UserListChoice from '@/view/user/UserListChoice.vue'
import { 
  isActiveSelect,
  aptitudeTransferType,
  companyAptitudeLevel,
  companyAptitudeType 
} from '@/api/select'
import config from '@/config'
const baseUrl =
  process.env.NODE_ENV === 'development'
    ? config.baseUrl.dev
    : config.baseUrl.pro
const cdnUrl = config.baseUrl.cdnUrl
import { getLocalStorageToken } from '@/libs/util'

export default {
  name: 'AptitudeTransfer',
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
        addUrl: '/aptitude-transfer/admin/save',
        batchAddUrl: '/aptitude-transfer/admin/batch-save',
        editUrl: '/aptitude-transfer/admin/update',
        batchEditUrl: '/aptitude-transfer/admin/batch-update',
        searchUrl: '/aptitude-transfer/admin/pager-cond',
        allUrl: '/aptitude-transfer/admin/all',
        removeUrl: '/aptitude-transfer/admin/remove/',
        batchRemoveUrl: '/aptitude-transfer/admin/batch-remove',
        detailUrl: '/aptitude-transfer/admin/one/',
        activeUrl: '/aptitude-transfer/admin/active',
        batchActiveUrl: '/aptitude-transfer/admin/batch-active',
        uploadResourceUrl: baseUrl + '/aptitude-transfer/admin/upload-res'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        userId: null,
        type: null,
        title: null,
        compAptitudeLevel: null,
        compAptitudeType: null,
        phone: null,
        memo: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null,
        resourceId: []
      },
      validateRules: {
       
        title: [
          {
            type: 'string',
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 1,
            max: 32,
            message: '必须1-32个字符',
            trigger: 'blur'
          }
        ],
        compAptitudeLevel: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        compAptitudeType: [
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
            required: true,
            message: '此项为必须项',
            trigger: 'blur'
          },
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
        type: null,
        typeMin: null,
        typeMax: null,
        title: null,
        compAptitudeLevel: null,
        compAptitudeType: null,
        phone: null,
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
            title: '资质转让编号',
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
            title: '转让类别',
            key: 'type',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const row = params.row
              const color = row.type === 0 ? 'primary' : row.type === 1 ? 'info' : 'error'
              const text = row.type === 0?  '购买' : row.type === 1 ? '转让' : '未知'
              return h(
                'Button',{
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
            title: '项目名称',
            key: 'title',
            minWidth: 120,
            sortable: true
          },
          {
            title: '企业资质等级',
            key: 'compAptitudeLevel',
            minWidth: 160,
            sortable: true
          },
          {
            title: '企业资质类型',
            key: 'compAptitudeType',
            minWidth: 160,
            sortable: true
          },
          {
            title: '联系电话',
            key: 'phone',
            minWidth: 120,
            sortable: true
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
                      ),
                      h(
                        'DropdownItem',
                        {
                          props: {
                            name: 'showEnclosure'
                          }
                        },
                        '附件'
                      ),
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
      aptitudeTransferType: aptitudeTransferType,
      companyAptitudeLevel: companyAptitudeLevel,
      companyAptitudeType: companyAptitudeType,
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
      },
      uploadHeader: {
        Authorization: 'Bearer ' + getLocalStorageToken()
      },
      isEnclosureShow: false
    }
  },
  computed: {},
  mounted() {
    this.search()
  },
  methods: {
    showModal(modal) {
      if (modal === 'add') {
        this.form.type = this.aptitudeTransferType[0].value
        this.form.compAptitudeLevel = this.companyAptitudeLevel[0].value
        this.form.compAptitudeType = this.companyAptitudeType[0].value
        //this.switchType()
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
      } else if (itemName === 'showDetail') {
        utils.showModal(this, 'detail')
        this.form = JSON.parse(JSON.stringify(row))
      } else if (itemName === 'remove') {
        utils.remove(this, row)
      } else if (itemName === 'moduleDetail') {
        this.showUserDetailModal(row.userId)
      } else if (itemName === 'showSearch') {
        utils.showModal(this, 'userDetalSearch')
      } else if (itemName === 'showEnclosure') {
        // 查看附件
        this.showBuilderEnclosure(row.id)
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
		confirmChoice(userId) {
		  this.form.userId = userId
		  this.cancelModal('userChoice')
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
    handleSuccess(res, file) {
      if (res.code === ResponseStatus.OK) {
        this.$Notice.success({
          title: '上传成功',
          desc: file.name + ' 上传成功'
        })
        this.form.resourceId.push(res.data.id)
      } else {
        this.$Notice.error({
          title: '上传失败',
          desc: res.message
        })
      }
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: '文件格式不正确',
        desc: file.name + ' 文件格式不正确，请选择JPG或PNG。'
      })
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: '超出文件大小限制',
        desc: file.name + ' 太大，不得超过10M.'
      })
    },
    // 切换资质转让类别
    switchType() {
      if (this.form.type === 0) {
        this.isEnclosureShow = false
        this.form.title = '本人急购一家' + this.form.compAptitudeLevel + this.form.compAptitudeType + '资质的企业'
      } else {
        this.isEnclosureShow = true
        this.form.title = '本人急售一家' + this.form.compAptitudeLevel + this.form.compAptitudeType + '资质的企业'
      }
    },
    // 前往附件页面
    showBuilderEnclosure(aptitudeId) {
      this.$router.push({
        name: 'aptitude_resource_manage',
        params: { aptitudeId: aptitudeId }
      });
    }
  }
}
</script>

<style>
</style>
