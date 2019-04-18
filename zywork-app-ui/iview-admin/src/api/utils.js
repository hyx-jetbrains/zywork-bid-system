import axios from '@/libs/api.request'
import fileDownload from 'js-file-download'
import * as ResponseStatus from '@/api/response-status'
/**
 * 根据指定的modal名打开模态框
 * @param self this
 * @param modal modal名
 */
export const showModal = (self, modal) => {
  self.modal[modal] = true
}

/**
 * 根据指定的modal名关闭模态框
 * @param self this
 * @param modal modal名
 */
export const cancelModal = (self, modal) => {
  self.modal[modal] = false
}

/**
 * 重置表单
 * @param self this
 * @param formRef form ref名称
 */
export const resetForm = (self, formRef) => {
  self.$refs[formRef].resetFields()
}

/**
 * 根据form数据对象添加数据
 * @param self this
 */
export const add = (self) => {
  return new Promise((resolve, reject) => {
    self.$refs['addForm'].validate(valid => {
      if (valid) {
        self.loading['add'] = true
        axios.request({
          url: self.urls.addUrl,
          method: 'POST',
          data: self.form
        }).then(response => {
          self.loading['add'] = false
          if (response.data.code !== ResponseStatus.OK) {
            self.$Message.error(response.data.message)
          } else {
            self.$Message.success(response.data.message)
            resetForm(self, 'addForm')
            cancelModal(self, 'add')
            search(self)
          }
          resolve(response)
        }).catch(error => {
          console.log(error)
          self.loading['add'] = false
          self.$Message.error('添加数据失败，稍候再试')
          reject(error)
        })
      }
    })
  })
}

/**
 * 根据form数据对象修改数据
 * @param self this
 */
export const edit = (self) => {
  return new Promise((resolve, reject) => {
    self.$refs['editForm'].validate(valid => {
      if (valid) {
        self.loading['edit'] = true
        axios.request({
          url: self.urls.editUrl,
          method: 'POST',
          data: self.form
        }).then(response => {
          self.loading['edit'] = false
          if (response.data.code !== ResponseStatus.OK) {
            self.$Message.error(response.data.message)
          } else {
            self.$Message.success(response.data.message)
            resetForm(self, 'editForm')
            cancelModal(self, 'edit')
            search(self)
          }
          resolve(response)
        }).catch(error => {
          self.loading['edit'] = false
          console.log(error)
          self.$Message.error('修改数据失败，稍候再试')
          reject(error)
        })
      }
    })
  })
}

/**
 * 根据id删除数据
 * @param self this
 * @param row 需要删除的数据对象
 */
export const remove = (self, row) => {
  return new Promise((resolve, reject) => {
    self.$Modal.confirm({
      title: '确认删除吗？',
      content: '确认删除选择的数据吗？',
      onOk: () => {
        axios.request({
          url: self.urls.removeUrl + row.id,
          method: 'GET'
        }).then(response => {
          if (response.data.code !== ResponseStatus.OK) {
            self.$Message.error(response.data.message)
          } else {
            search(self)
          }
          resolve(response)
        }).catch(error => {
          console.log(error)
          self.$Message.error('删除数据失败，稍候再试')
          reject(error)
        })
      },
      onCancel: () => {

      }
    })
  })
}

/**
 * 根据所选择的数据批量删除
 * @param self this
 */
export const batchRemove = (self) => {
  return new Promise((resolve, reject) => {
    if (self.table.selections.length === 0) {
      self.$Message.warning('请选择需要批量删除的数据')
    } else {
      self.$Modal.confirm({
        title: '确认删除吗？',
        content: '确认批量删除选择的数据吗？',
        onOk: () => {
          let ids = []
          self.table.selections.forEach((row, index) => {
            ids.push(row.id)
          })
          axios.request({
            url: self.urls.batchRemoveUrl,
            method: 'POST',
            data: ids
          }).then(response => {
            if (response.data.code !== ResponseStatus.OK) {
              self.$Message.error(response.data.message)
            } else {
              self.$Message.success(response.data.message)
              self.table.selections = []
              search(self)
            }
            resolve(response)
          }).catch(error => {
            console.log(error)
            self.$Message.error('批量删除数据失败，稍候再试')
            reject(error)
          })
        },
        onCancel: () => {

        }
      })
    }
  })
}

/**
 * 激活或冻结数据
 * @param self this
 * @param row 需要激活或冻结的数据对象
 */
export const active = (self, row) => {
  return new Promise((resolve, reject) => {
    let isActive = row.isActive === 0 ? 1 : 0
    axios.request({
      url: self.urls.activeUrl,
      method: 'POST',
      data: {
        id: row.id,
        isActive: isActive
      }
    }).then(response => {
      if (response.data.code !== ResponseStatus.OK) {
        self.$Message.error(response.data.message)
      } else {
        self.$Message.success(response.data.message)
      }
      search(self)
      resolve(response)
    }).catch(error => {
      console.log(error)
      self.$Message.error('激活或冻结数据失败，稍候再试')
      reject(error)
    })
  })
}

/**
 * 根据所选的项，批量激活或冻结数据
 * @param self this
 * @param isActive 0表示需要激活，1表示需要冻结
 */
export const batchActive = (self, isActive) => {
  return new Promise((resolve, reject) => {
    let rowArray = []
    if (self.table.selections.length === 0) {
      self.$Message.warning('请选择需要批量' + (isActive === 0 ? '激活' : '冻结') + '的数据')
    } else {
      self.table.selections.forEach((row, index) => {
        if (row.isActive !== isActive) {
          rowArray.push({
            id: row.id,
            isActive: isActive
          })
        }
      })
      if (rowArray.length > 0) {
        axios.request({
          url: self.urls.batchActiveUrl,
          method: 'POST',
          data: rowArray
        }).then(response => {
          if (response.data.code !== ResponseStatus.OK) {
            self.$Message.error(response.data.message)
          } else {
            self.$Message.success(response.data.message)
            self.table.selections = []
            search(self)
          }
          resolve(response)
        }).catch(error => {
          console.log(error)
          self.$Message.error('批量激活或冻结数据失败，稍候再试')
          reject(error)
        })
      } else {
        self.$Message.warning('没有需要批量' + (isActive === 0 ? '激活' : '冻结') + '的数据')
      }
    }
  })
}

/**
 * 根据searchForm分页搜索
 * @param self this
 */
export const search = (self) => {
  return new Promise((resolve, reject) => {
    self.loading.search = true
    self.table.loading = true
    axios.request({
      url: self.urls.searchUrl,
      method: 'POST',
      data: self.searchForm
    }).then(response => {
      self.loading['search'] = false
      self.table.loading = false
      if (response.data.code !== ResponseStatus.OK) {
        self.$Message.error(response.data.message)
      } else {
        self.page.total = response.data.data.total
        self.table.tableDetails = response.data.data.rows
        
        }
      resolve(response)
    }).catch(error => {
      console.log(error)
      self.loading['search'] = false
      self.table.loading = false
      self.$Message.error('加载数据失败，稍候再试')
      reject(error)
    })
  })
}

/**
 * table表格选中事件处理，记录所有被选中的项
 * @param self this
 * @param selections 事件返回值
 */
export const changeSelections = (self, selections) => {
  self.table.selections = selections
}

/**
 * 单选
 * @param {*} currentRow 
 * @param {*} oldCurrentRow 
 */
export const changeCurrent = (self, currentRow, oldCurrentRow) => {
  self.table.currentRow = currentRow
}

/**
 * table表格排序事件处理
 * @param self this
 * @param sortColumn 排序字段信息
 */
export const changeSort = (self, sortColumn) => {
  self.searchForm.sortColumn = sortColumn.key
  self.searchForm.sortOrder = sortColumn.order
  search(self)
}

/**
 * 分页组件页码改变事件处理
 * @param self this
 * @param pageNo 修改后的页码
 */
export const changePageNo = (self, pageNo) => {
  self.searchForm.pageNo = pageNo
  search(self)
}

/**
 * 分页组件每页大小改变事件处理
 * @param self this
 * @param pageSize 修改后的每页大小
 */
export const changePageSize = (self, pageSize) => {
  self.searchForm.pageSize = pageSize
  search(self)
}

/**
 * table表格排序事件处理
 * @param self this
 * @param sortColumn 排序字段信息
 */
export const changeSelectTableSort = (self, sortColumn) => {
  self.searchForm.sortColumn = sortColumn.key
  self.searchForm.sortOrder = sortColumn.order
  initSelectTableData(self)
}

/**
 * 分页组件页码改变事件处理
 * @param self this
 * @param pageNo 修改后的页码
 */
export const changeSelectTablePageNo = (self, pageNo) => {
  self.searchForm.pageNo = pageNo
  initSelectTableData(self)
}

/**
 * 分页组件每页大小改变事件处理
 * @param self this
 * @param pageSize 修改后的每页大小
 */
export const changeSelectTablePageSize = (self, pageSize) => {
  self.searchForm.pageSize = pageSize
  initSelectTableData(self)
}

/**
 * 
 * @param {*} self this
 */
export const initSelectTableData = (self) => {
  return new Promise((resolve, reject) => {
    self.loading.search = true
    self.table.loading = true
    axios.request({
      url: self.urls.searchUrl,
      method: 'POST',
      data: self.searchForm
    }).then(response => {
      self.loading.search = false
      self.table.loading = false
      if (response.data.code !== ResponseStatus.OK) {
        self.$Message.error(response.data.message)
      } else {
        if (self.selectedData != null) {
          response.data.data.rows.forEach((dataItem,index) => {
            self.selectedData.forEach(dataRow => {
              if (dataItem.id === dataRow[self.selectedDataId]) {
                response.data.data.rows[index]._checked = true
                self.table.selections.push(response.data.data.rows[index])
              }
            }) 
          })
        }
        self.page.total = response.data.data.total
        self.table.tableDetails = response.data.data.rows
      }
      resolve(response)
    }).catch(error => {
      console.log(error)
      self.loading.search = false
      self.table.loading = false
      self.$Message.error('加载数据失败，稍候再试')
      reject(error)
    })
  })
}

/**
 * 把指定的表格以合适的列大小显示到屏幕
 * @param {*} self this
 * @param {*} tableRef 表格的ref
 * @param {*} tableColumns 表格所有的列信息
 * @param {*} columnKeys 需要重新设置大小的列
 * @param {*} fixedColumns 不需要重新设置大小的列个数
 */
export const fitTable = (self, tableRef, tableColumns, columnKeys, fixedColumns) => {
  self.$nextTick(() => {
    let tableWidth = self.$refs[tableRef].$el.clientWidth
    if (tableWidth === 0) {
      tableWidth = document.body.clientWidth - 66
    }
    let width = 0
    tableColumns.forEach((column, index) => {
      width += column.width
    })
    if (width < tableWidth) {
      let fitWidth = (tableWidth - width) / (tableColumns.length - (fixedColumns === undefined ? 3 : fixedColumns))
      columnKeys.forEach((key, index) => {
        tableColumns.forEach((column, index) => {
          if (column.key === key && column.type !== 'selection') {
            column.width += fitWidth
          }
        })
      })
    }
  })
}

/**
 * 根据路由名字打开一个新的tabl
 * @param {*} self this
 * @param {*} path 路由路径
 * @param {*} params 参数
 */
export const openTab = (self, path, params) => {
  self.$router.push({
    path: path,
    query: params
  })
}

/**
 * 导出json文件
 * @param self this
 */
export const exportJson = (self) => {
  axios.request({
    url: self.urls.exportUrl,
    method: 'GET',
    responseType: 'blob',
    data: ''
  }).then(response => {
    console.log(response)
    // fileDownload(JSON.stringify(response.data), self.exportFileName)
    fileDownload(response.data, self.exportFileName)
  }).catch(error => {
    console.log(error)
    self.$Message.error('导出失败，稍候再试')
  })
}

/**
 * 取指定多少天前或多少天后的时间
 * getDate(7)：7天后的时间
 * getDate(-7)：7天前的时间
 */
export const getDate = (days) => {
  var date1 = new Date()
  var time1 =
    date1.getFullYear() +
    '-' +
    (date1.getMonth() + 1) +
    '-' +
    date1.getDate()
  var date2 = new Date(date1)
  date2.setDate(date1.getDate() + days)
  var time2 =
    date2.getFullYear() +
    '-' +
    ((date2.getMonth() + 1) < 10 ? '0' + (date2.getMonth() + 1) : (date2.getMonth() + 1)) +
    '-' +
    (date2.getDate() < 10 ? '0' + date2.getDate() : date2.getDate())
  return time2
}

/**
 * 解析text文本到JSON对象
 * @param {*} data 
 */
export const parseJson = (data) => {
  return new Promise((resolve, reject) => {
    let json = JSON.parse(data)
    resolve(json)
  })
}

/**
 * 读取arrayBuffer数据到FileReader对象中，FileReader中存储字符串
 * @param {*} arrayBufferData 
 */
export const arrayBufferToReader = (arrayBufferData) => {
  let blob = new Blob([arrayBufferData])
  let reader = new FileReader()
  reader.readAsText(blob, 'utf-8')
  return reader
}

/**
 * 把arrayBuffer数据转化成指定类型的图片
 * @param {*} imageType 
 * @param {*} arrayBufferData 
 */
export const arrayBufferToImage = (imageType, arrayBufferData) => {
  return 'data:image/' + imageType + ';base64,' + btoa(
    new Uint8Array(arrayBufferData).reduce((data, byte) => data + String.fromCharCode(byte), '')
  )
}
    