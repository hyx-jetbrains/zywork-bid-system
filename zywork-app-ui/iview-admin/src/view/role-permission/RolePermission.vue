<template>
  <div>
    <Drawer
        title="分配角色权限"
        :closable="true"
        :mask-closable="false"
        @on-close="closeDrawer"
        v-model="drawerFlag"
      >
        <Button size="small" type="primary" @click="savePermission">保存</Button>
        <Button size="small" style="margin-left: 10px" @click="closeDrawer">关闭</Button>
        <Divider/>
        <Tree :data="permissionData" show-checkbox multiple scrollable ref="permissionTree"></Tree>
        <Spin size="large" fix v-if="spinShow"></Spin>
      </Drawer>
  </div>
</template>
<script>
import {
  getAllPermission,
  getMultiPermission,
  getUserPermission,
  batchSavePermission
} from '@/api/role'
import {getAllModule} from '@/api/module'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'RolePerminission',
  props: {},
  data() {
    return {
      roleId: '',
      drawerFlag: false,
      spinShow: true,
      allModuleList: [],
      multiPermissionList: [],
      userPermissionList: [],
      permissionData: [
        {
          title: this.$config.permissionTreeTitle,
          expand: true,
          children: []
        }
      ]
    }
  },
  mounted() {},
  methods: {
    /**
     * 初始化数据，请求后端数据
     * @param roleId 角色id
     */
    initData(roleId) {
      this.drawerFlag = true
      this.spinShow = true
      this.roleId = roleId
      // 获取所有的模块
      getAllModule()
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.allModuleList = data.data.rows
            // 获取当前指定角色的权限
            getMultiPermission(roleId)
              .then(res => {
                const data = res.data
                if (data.code === ResponseStatus.OK) {
                  this.multiPermissionList = data.data.rows
                  // 获取当前登入用户的所有权限
                  getUserPermission()
                    .then(res => {
                      const data = res.data
                      if (data.code === ResponseStatus.OK) {
                        this.userPermissionList = data.data.rows
                        this.initPermissionData()
                      } else {
                        this.$Message.error(data.message)
                      }
                    })
                    .catch(err => {
                      this.$Message.error(err)
                    })
                } else {
                  this.$Message.error(data.message)
                }
              })
              .catch(err => {
                this.$Message.error(err)
              })
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    /**
     * 初始化权限数据
     */
    initPermissionData() {
      var moduleChildren = []
      this.allModuleList.forEach(module => {
        var tempModuleChildren = {}
        tempModuleChildren.title = module.title
        tempModuleChildren.expand = true
        var permissionChildern = []
        this.userPermissionList.forEach(permission => {
          if (permission.permissionModuleId === module.id) {
            // 该权限是当前module下的权限
            var permissionId = permission.permissionId
            var tempPermissionChildern = {}
            tempPermissionChildern.title = permission.permissionTitle
            tempPermissionChildern.expand = true
            var checked = false
            this.multiPermissionList.forEach(multi => {
              if (multi.permissionId === permissionId) {
                // 说明当前角色有该权限
                checked = true
              }
            })
            tempPermissionChildern.permissionId = permissionId
            tempPermissionChildern.checked = checked
            permissionChildern.push(tempPermissionChildern)
          }
        })
        tempModuleChildren.children = permissionChildern
        moduleChildren.push(tempModuleChildren)
      })
      this.permissionData[0].children = moduleChildren
      this.spinShow = false
    },
    // 关闭权限配置
    closeDrawer() {
      this.drawerFlag = false
      this.permissionData = [
        {
          title: this.$config.permissionTreeTitle,
          expand: true,
          children: []
        }
      ]
    },
    /**
     * 保存权限
     */
    savePermission() {
      if (this.roleId === '') {
        this.$Message.error('请刷新页面重试')
        return
      }
      var checkData = this.$refs.permissionTree.data
      var permissionIds = []
      checkData.forEach(root => {
        // 对所有的数据进行遍历
        var moduleList = root.children
        moduleList.forEach(module => {
          var permissionList = module.children
          permissionList.forEach(permission => {
            if (permission.checked === true) {
              // 当前权限被选中
              permissionIds.push(permission.permissionId)
            }
          })
        })
      })
      var params = []
      permissionIds.forEach(permission => {
        params.push({
          roleId: this.roleId,
          permissionId: permission
        })
      })
      batchSavePermission(params)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.$Message.info("保存成功")
            this.drawerFlag = false
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    }
  }
}
</script>
