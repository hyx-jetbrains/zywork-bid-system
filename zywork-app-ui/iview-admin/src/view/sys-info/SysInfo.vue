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
      :mask-closable="false"
    >
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="公司名称" prop="compName">
          <Input v-model="form.compName" placeholder="请输入公司名称"/>
        </FormItem>
        <FormItem label="域名" prop="doMain">
          <Input v-model="form.doMain" placeholder="请输入域名"/>
        </FormItem>
        <FormItem label="公司地址" prop="compAddr">
          <Input v-model="form.compAddr" placeholder="请输入公司地址"/>
        </FormItem>
        <FormItem label="公司电话" prop="compPhone">
          <Input v-model="form.compPhone" placeholder="请输入公司电话"/>
        </FormItem>
        <FormItem label="公司邮箱" prop="compEmail">
          <Input v-model="form.compEmail" placeholder="请输入公司邮箱"/>
        </FormItem>
        <FormItem label="公司说明" prop="compMemo">
          <Input
            v-model="form.compMemo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入公司说明"
          />
        </FormItem>
        <FormItem label="头部图标" prop="headIcon">
          <!-- <Input v-model="form.headIcon" placeholder="请输入头部图标"/> -->
          <div class="demo-upload-list" v-if="form.headIcon !== '' && form.headIcon !== null">
            <img :src="form.headIcon">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.headIcon)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('headIcon')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadHeadIcon"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadHeadIcon"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="菜单小图标" prop="menuIconMin">
          <!-- <Input v-model="form.menuIconMin" placeholder="请输入菜单小图标"/> -->
          <div class="demo-upload-list" v-if="form.menuIconMin !== '' && form.menuIconMin !== null">
            <img :src="form.menuIconMin">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.menuIconMin)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('menuIconMin')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadMenuIconMin"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadMenuIconMin"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="菜单大图标" prop="menuIconMax">
          <!-- <Input v-model="form.menuIconMax" placeholder="请输入菜单大图标"/> -->
          <div class="demo-upload-list" v-if="form.menuIconMax !== '' && form.menuIconMax !== null">
            <img :src="form.menuIconMax">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.menuIconMax)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('menuIconMax')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadMenuIconMax"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadMenuIconMax"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="默认头像" prop="defaultHead">
          <!-- <Input v-model="form.defaultHead" placeholder="请输入默认头像"/> -->
          <div class="demo-upload-list" v-if="form.defaultHead !== '' && form.defaultHead !== null">
            <img :src="form.defaultHead">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.defaultHead)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('defaultHead')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadDefaultHead"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadDefaultHead"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="背景图片" prop="backgroundIcon">
          <!-- <Input v-model="form.backgroundIcon" placeholder="请输入背景图片"/> -->
          <div
            class="demo-upload-list"
            v-if="form.backgroundIcon !== '' && form.backgroundIcon !== null"
          >
            <img :src="form.backgroundIcon">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.backgroundIcon)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('backgroundIcon')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadBackgroundIcon"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadBackgroundIcon"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
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
      :mask-closable="false"
    >
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="公司名称" prop="compName">
          <Input v-model="form.compName" placeholder="请输入公司名称"/>
        </FormItem>
        <FormItem label="域名" prop="doMain">
          <Input v-model="form.doMain" placeholder="请输入域名"/>
        </FormItem>
        <FormItem label="公司地址" prop="compAddr">
          <Input v-model="form.compAddr" placeholder="请输入公司地址"/>
        </FormItem>
        <FormItem label="公司电话" prop="compPhone">
          <Input v-model="form.compPhone" placeholder="请输入公司电话"/>
        </FormItem>
        <FormItem label="公司邮箱" prop="compEmail">
          <Input v-model="form.compEmail" placeholder="请输入公司邮箱"/>
        </FormItem>
        <FormItem label="公司说明" prop="compMemo">
          <Input
            v-model="form.compMemo"
            type="textarea"
            :autosize="descriptionAutoSize"
            placeholder="请输入公司说明"
          />
        </FormItem>
        <FormItem label="头部图标" prop="headIcon">
          <!-- <Input v-model="form.headIcon" placeholder="请输入头部图标"/> -->
          <div class="demo-upload-list" v-if="form.headIcon !== '' && form.headIcon !== null">
            <img :src="form.headIcon">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.headIcon)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('headIcon')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadHeadIcon"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadHeadIcon"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="菜单小图标" prop="menuIconMin">
          <!-- <Input v-model="form.menuIconMin" placeholder="请输入菜单小图标"/> -->
          <div class="demo-upload-list" v-if="form.menuIconMin !== '' && form.menuIconMin !== null">
            <img :src="form.menuIconMin">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.menuIconMin)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('menuIconMin')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadMenuIconMin"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadMenuIconMin"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="菜单大图标" prop="menuIconMax">
          <!-- <Input v-model="form.menuIconMax" placeholder="请输入菜单大图标"/> -->
          <div class="demo-upload-list" v-if="form.menuIconMax !== '' && form.menuIconMax !== null">
            <img :src="form.menuIconMax">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.menuIconMax)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('menuIconMax')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadMenuIconMax"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadMenuIconMax"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="默认头像" prop="defaultHead">
          <!-- <Input v-model="form.defaultHead" placeholder="请输入默认头像"/> -->
          <div class="demo-upload-list" v-if="form.defaultHead !== '' && form.defaultHead !== null">
            <img :src="form.defaultHead">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.defaultHead)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('defaultHead')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadDefaultHead"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadDefaultHead"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
        <FormItem label="背景图片" prop="backgroundIcon">
          <!-- <Input v-model="form.backgroundIcon" placeholder="请输入背景图片"/> -->
          <div
            class="demo-upload-list"
            v-if="form.backgroundIcon !== '' && form.backgroundIcon !== null"
          >
            <img :src="form.backgroundIcon">
            <div class="demo-upload-list-cover">
              <Icon type="ios-eye-outline" @click.native="handleView(form.backgroundIcon)"></Icon>
              <Icon type="ios-trash-outline" @click.native="handleRemove('backgroundIcon')"></Icon>
            </div>
          </div>
          <Upload
            ref="uploadBackgroundIcon"
            :show-upload-list="false"
            :on-success="handleSuccess"
            :format="['jpg','jpeg','png']"
            :max-size="2048"
            :on-format-error="handleFormatError"
            :on-exceeded-size="handleMaxSize"
            type="drag"
            :data="uploadBackgroundIcon"
            :action="urls.uploadUrl"
            :headers="uploadHeader"
            style="display: inline-block;width:58px;"
          >
            <div style="width: 58px;height:58px;line-height: 58px;">
              <Icon type="ios-camera" size="20"></Icon>
            </div>
          </Upload>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="系统信息编号">
          <Row>
            <i-col span="11">
              <FormItem prop="idMin">
                <InputNumber
                  v-model="searchForm.idMin"
                  placeholder="请输入开始系统信息编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
            <i-col span="2" style="text-align: center">-</i-col>
            <i-col span="11">
              <FormItem prop="idMax">
                <InputNumber
                  v-model="searchForm.idMax"
                  placeholder="请输入结束系统信息编号"
                  style="width: 100%;"
                />
              </FormItem>
            </i-col>
          </Row>
        </FormItem>
        <FormItem label="公司名称" prop="compName">
          <Input v-model="searchForm.compName" placeholder="请输入公司名称"/>
        </FormItem>
        <FormItem label="头部图标" prop="headIcon">
          <Input v-model="searchForm.headIcon" placeholder="请输入头部图标"/>
        </FormItem>
        <FormItem label="菜单小图标" prop="menuIconMin">
          <Input v-model="searchForm.menuIconMin" placeholder="请输入菜单小图标"/>
        </FormItem>
        <FormItem label="菜单大图标" prop="menuIconMax">
          <Input v-model="searchForm.menuIconMax" placeholder="请输入菜单大图标"/>
        </FormItem>
        <FormItem label="默认头像" prop="defaultHead">
          <Input v-model="searchForm.defaultHead" placeholder="请输入默认头像"/>
        </FormItem>
        <FormItem label="背景图片" prop="backgroundIcon">
          <Input v-model="searchForm.backgroundIcon" placeholder="请输入背景图片"/>
        </FormItem>
        <FormItem label="域名" prop="doMain">
          <Input v-model="searchForm.doMain" placeholder="请输入域名"/>
        </FormItem>
        <FormItem label="公司地址" prop="compAddr">
          <Input v-model="searchForm.compAddr" placeholder="请输入公司地址"/>
        </FormItem>
        <FormItem label="公司电话" prop="compPhone">
          <Input v-model="searchForm.compPhone" placeholder="请输入公司电话"/>
        </FormItem>
        <FormItem label="公司邮箱" prop="compEmail">
          <Input v-model="searchForm.compEmail" placeholder="请输入公司邮箱"/>
        </FormItem>
        <FormItem label="公司说明" prop="compMemo">
          <Input v-model="searchForm.compMemo" placeholder="请输入公司说明"/>
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
        系统信息编号:
        <span v-text="form.id"></span>
      </p>
      <p>
        公司名称:
        <span v-text="form.compName"></span>
      </p>
      <p>
        头部图标:
        <span v-text="form.headIcon"></span>
      </p>
      <p>
        菜单小图标:
        <span v-text="form.menuIconMin"></span>
      </p>
      <p>
        菜单大图标:
        <span v-text="form.menuIconMax"></span>
      </p>
      <p>
        默认头像:
        <span v-text="form.defaultHead"></span>
      </p>
      <p>
        背景图片:
        <span v-text="form.backgroundIcon"></span>
      </p>
      <p>
        域名:
        <span v-text="form.doMain"></span>
      </p>
      <p>
        公司地址:
        <span v-text="form.compAddr"></span>
      </p>
      <p>
        公司电话:
        <span v-text="form.compPhone"></span>
      </p>
      <p>
        公司邮箱:
        <span v-text="form.compEmail"></span>
      </p>
      <p>
        公司说明:
        <span v-text="form.compMemo"></span>
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
    <Modal title="预览图片" v-model="visible">
      <img :src="imgUrl" v-if="visible" style="width: 100%">
    </Modal>
  </div>
</template>

<script>
import * as utils from '@/api/utils'
import axios from '@/libs/api.request'
import * as ResponseStatus from '@/api/response-status'
import { isActiveSelect } from '@/api/select'
import config from '@/config'
const baseUrl =
  process.env.NODE_ENV === 'development'
    ? config.baseUrl.dev
    : config.baseUrl.pro
const cdnUrl = config.baseUrl.cdnUrl
import { getLocalStorageToken, localStorage } from '@/libs/util'
export const SYS_INFO_KEY = 'sysInfo'

export default {
  name: 'SysInfo',
  data() {
    return {
      modal: {
        add: false,
        edit: false,
        search: false,
        detail: false
      },
      loading: {
        add: false,
        edit: false,
        search: false
      },
      urls: {
        addUrl: '/sys-info/admin/save',
        batchAddUrl: '/sys-info/admin/batch-save',
        editUrl: '/sys-info/admin/update',
        batchEditUrl: '/sys-info/admin/batch-update',
        searchUrl: '/sys-info/admin/pager-cond',
        allUrl: '/sys-info/admin/all',
        removeUrl: '/sys-info/admin/remove/',
        batchRemoveUrl: '/sys-info/admin/batch-remove',
        detailUrl: '/sys-info/admin/one/',
        activeUrl: '/sys-info/admin/active',
        batchActiveUrl: '/sys-info/admin/batch-active',
        uploadUrl: baseUrl + '/sys-info/admin/upload-res'
      },
      page: {
        total: 0
      },
      form: {
        id: null,
        compName: null,
        headIcon: null,
        menuIconMin: null,
        menuIconMax: null,
        defaultHead: null,
        backgroundIcon: null,
        doMain: null,
        compAddr: null,
        compPhone: null,
        compEmail: null,
        compMemo: null,
        version: null,
        createTime: null,
        updateTime: null,
        isActive: null
      },
      validateRules: {
        compName: [
          {
            type: 'string',
            min: 1,
            max: 200,
            message: '必须1-200个字符',
            trigger: 'blur'
          }
        ],
        headIcon: [
          {
            type: 'string',
            min: 1,
            max: 300,
            message: '必须1-300个字符',
            trigger: 'blur'
          }
        ],
        menuIconMin: [
          {
            type: 'string',
            min: 1,
            max: 300,
            message: '必须1-300个字符',
            trigger: 'blur'
          }
        ],
        menuIconMax: [
          {
            type: 'string',
            min: 1,
            max: 300,
            message: '必须1-300个字符',
            trigger: 'blur'
          }
        ],
        defaultHead: [
          {
            type: 'string',
            min: 1,
            max: 300,
            message: '必须1-300个字符',
            trigger: 'blur'
          }
        ],
        backgroundIcon: [
          {
            type: 'string',
            min: 1,
            max: 300,
            message: '必须1-300个字符',
            trigger: 'blur'
          }
        ],
        doMain: [
          {
            type: 'string',
            min: 1,
            max: 300,
            message: '必须1-300个字符',
            trigger: 'blur'
          }
        ],
        compAddr: [
          {
            type: 'string',
            min: 1,
            max: 200,
            message: '必须1-200个字符',
            trigger: 'blur'
          }
        ],
        compPhone: [
          {
            type: 'string',
            min: 1,
            max: 20,
            message: '必须1-20个字符',
            trigger: 'blur'
          }
        ],
        compEmail: [
          {
            type: 'string',
            min: 1,
            max: 30,
            message: '必须1-30个字符',
            trigger: 'blur'
          }
        ],
        compMemo: [
          {
            type: 'string',
            min: 1,
            max: 500,
            message: '必须1-500个字符',
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
        compName: null,
        headIcon: null,
        menuIconMin: null,
        menuIconMax: null,
        defaultHead: null,
        backgroundIcon: null,
        doMain: null,
        compAddr: null,
        compPhone: null,
        compEmail: null,
        compMemo: null,
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
            title: '系统信息编号',
            key: 'id',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公司名称',
            key: 'compName',
            minWidth: 120,
            sortable: true
          },
          {
            title: '头部图标',
            key: 'headIcon',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const imgSrc = params.row.headIcon
              return h(
                'img',
                {
                  attrs: {
                    src: imgSrc
                  },
                  style: {
                    width: '100px',
                    height: '80px',
                    cursor: 'pointer'
                  },
                  on: {
                    click: () => {
                      this.handleView(imgSrc)
                    }
                  }
                },
                ''
              )
            }
          },
          {
            title: '菜单小图标',
            key: 'menuIconMin',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const imgSrc = params.row.menuIconMin
              return h(
                'img',
                {
                  attrs: {
                    src: imgSrc
                  },
                  style: {
                    width: '100px',
                    height: '80px',
                    cursor: 'pointer'
                  },
                  on: {
                    click: () => {
                      this.handleView(imgSrc)
                    }
                  }
                },
                ''
              )
            }
          },
          {
            title: '菜单大图标',
            key: 'menuIconMax',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const imgSrc = params.row.menuIconMax
              return h(
                'img',
                {
                  attrs: {
                    src: imgSrc
                  },
                  style: {
                    width: '100px',
                    height: '80px',
                    cursor: 'pointer'
                  },
                  on: {
                    click: () => {
                      this.handleView(imgSrc)
                    }
                  }
                },
                ''
              )
            }
          },
          {
            title: '默认头像',
            key: 'defaultHead',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const imgSrc = params.row.defaultHead
              return h(
                'img',
                {
                  attrs: {
                    src: imgSrc
                  },
                  style: {
                    width: '100px',
                    height: '80px',
                    cursor: 'pointer'
                  },
                  on: {
                    click: () => {
                      this.handleView(imgSrc)
                    }
                  }
                },
                ''
              )
            }
          },
          {
            title: '背景图片',
            key: 'backgroundIcon',
            minWidth: 120,
            sortable: true,
            render: (h, params) => {
              const imgSrc = params.row.backgroundIcon
              return h(
                'img',
                {
                  attrs: {
                    src: imgSrc
                  },
                  style: {
                    width: '100px',
                    height: '80px',
                    cursor: 'pointer'
                  },
                  on: {
                    click: () => {
                      this.handleView(imgSrc)
                    }
                  }
                },
                ''
              )
            }
          },
          {
            title: '域名',
            key: 'doMain',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公司地址',
            key: 'compAddr',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公司电话',
            key: 'compPhone',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公司邮箱',
            key: 'compEmail',
            minWidth: 120,
            sortable: true
          },
          {
            title: '公司说明',
            key: 'compMemo',
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
            title: '是否激活',
            key: 'isActive',
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
        selections: []
      },
      isActiveSelect: isActiveSelect,
      descriptionAutoSize: {
        minRows: 3,
        maxRows: 5
      },
      imgUrl: '',
      visible: false,
      uploadHeader: {
        Authorization: 'Bearer ' + getLocalStorageToken()
      },
      uploadHeadIcon: {
        type: 0
      },
      uploadMenuIconMin: {
        type: 1
      },
      uploadMenuIconMax: {
        type: 2
      },
      uploadDefaultHead: {
        type: 3
      },
      uploadBackgroundIcon: {
        type: 4
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
      }
    },
    add() {
      utils.add(this)
    },
    edit() {
      this.$refs['editForm'].validate(valid => {
        if (valid) {
          this.loading['edit'] = true
          axios
            .request({
              url: this.urls.editUrl,
              method: 'POST',
              data: this.form
            })
            .then(response => {
              this.loading['edit'] = false
              if (response.data.code !== ResponseStatus.OK) {
                this.$Message.error(response.data.message)
              } else {
                this.$Message.success(response.data.message)
                // 说明更新成功了
                console.log(this.form)
                if (localStorage) {
                  localStorage.setItem(SYS_INFO_KEY, JSON.stringify(this.form))
                  localStorage.setItem('favicon', this.form.headIcon)
                }
                this.resetForm('editForm')
                this.cancelModal('edit')
                this.search()
              }
            })
            .catch(error => {
              this.loading['edit'] = false
              console.log(error)
              this.$Message.error('修改数据失败，稍候再试')
            })
        }
      })
      // var tempForm = this.form
      // console.log(tempForm)
      // utils.edit(this).then(res => {
      //   if (res.data.code === ResponseStatus.OK) {
      //     // 说明更新成功了
      //     console.log(tempForm)
      //     if (localStorage) {
      //       localStorage.setItem(SYS_INFO_KEY, JSON.stringify(tempForm))
      //       localStorage.setItem('favicon', tempForm.headIcon)
      //     }
      //   }
      // })
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
    handleView(url) {
      this.imgUrl = url
      this.visible = true
    },
    handleRemove(itemName) {
      this.form[itemName] = ''
    },
    handleSuccess(res, file) {
      if (res.code === ResponseStatus.OK) {
        this.$Notice.success({
          title: '上传成功',
          desc: file.name + ' 上传成功'
        })
        const url = cdnUrl + '/' + res.data.url
        const type = res.message
        console.log(type)
        if (type == 0) {
          this.form.headIcon = url
        } else if (type == 1) {
          this.form.menuIconMin = url
        } else if (type == 2) {
          this.form.menuIconMax = url
        } else if (type == 3) {
          this.form.defaultHead = url
        } else if (type == 4) {
          this.form.backgroundIcon = url
        }
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
        desc: file.name + ' 的文件格式不正确，请选择JPG或PNG。'
      })
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: '超出文件大小限制',
        desc: file.name + ' 太大，不超过2M.'
      })
    }
  }
}
</script>

<style>
.demo-upload-list {
  display: inline-block;
  width: 60px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  border: 1px solid transparent;
  border-radius: 4px;
  overflow: hidden;
  background: #fff;
  position: relative;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
  margin-right: 4px;
}
.demo-upload-list img {
  width: 100%;
  height: 100%;
}
.demo-upload-list-cover {
  display: none;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.6);
}
.demo-upload-list:hover .demo-upload-list-cover {
  display: block;
}
.demo-upload-list-cover i {
  color: #fff;
  font-size: 20px;
  cursor: pointer;
  margin: 0 2px;
}
</style>
