import axios from '@/libs/api.request'
import * as ResponseStatus from '@/api/response-status'
import * as utils from '@/api/utils'
import Qs from 'qs'
/**
 * 发布单个招投标项目
 * @param self this
 * @param row 需要发布的数据对象
 */
export const releaseProject = (self, row) => {
  return new Promise((resolve, reject) => {
    axios.request({
      url: self.urls.releaseStatusUrl,
      method: 'POST',
      data: {
        id: row.id,
        releaseStatus: row.releaseStatus
      }
    }).then(response => {
      if (response.data.code !== ResponseStatus.OK) {
        self.$Message.error(response.data.message)
      } else {
        self.$Message.success(response.data.message)
      }
      utils.search(self)
      resolve(response)
    }).catch(error => {
      console.log(error)
      self.$Message.error('发布失败，稍候再试')
      reject(error)
    })
  })
}

/**
 * 根据所选的项，批量发布数据
 * @param self this
 * @param releaseStatus 发布状态
 */
export const batchRelease = (self, releaseStatus) => {
  return new Promise((resolve, reject) => {
    let rowArray = []
    if (self.table.selections.length === 0) {
      self.$Message.warning('请选择需要批量发布的数据')
    } else {
      self.table.selections.forEach((row, index) => {
        if (row.releaseStatus !== releaseStatus) {
          rowArray.push({
            id: row.id,
            releaseStatus: releaseStatus
          })
        }
      })
      if (rowArray.length > 0) {
        axios.request({
          url: self.urls.batchReleaseUrl,
          method: 'POST',
          data: rowArray
        }).then(response => {
          if (response.data.code !== ResponseStatus.OK) {
            self.$Message.error(response.data.message)
          } else {
            self.$Message.success(response.data.message)
            self.table.selections = []
            utils.search(self)
          }
          resolve(response)
        }).catch(error => {
          console.log(error)
          self.$Message.error('批量发布数据失败，稍候再试')
          reject(error)
        })
      } else {
        self.$Message.warning('没有需要批量发布的数据')
      }
    }
  })
}