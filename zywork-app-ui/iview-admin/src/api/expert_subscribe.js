import axios from '@/libs/api.request'
import fileDownload from 'js-file-download'
import * as ResponseStatus from '@/api/response-status'
import * as utils from '@/api/utils'

/**
 * 更新专家预约表，回复用户问题
 * @param self this
 */
export const replay = (self) => {
  return new Promise((resolve, reject) => {
    self.$refs['replayForm'].validate(valid => {
      if (valid) {
        self.loading['replay'] = true
        axios.request({
          url: self.urls.replayUrl,
          method: 'POST',
          data: self.form
        }).then(response => {
          self.loading['replay'] = false
          if (response.data.code !== ResponseStatus.OK) {
            self.$Message.error(response.data.message)
          } else {
            self.$Message.success(response.data.message)
            utils.resetForm(self, 'replayForm')
            utils.cancelModal(self, 'replay')
            utils.search(self)
          }
          resolve(response)
        }).catch(error => {
          console.log(error)
          self.loading['replay'] = false
          self.$Message.error('回复失败，稍候再试')
          reject(error)
        })
      }
    })
  })
}

export const replayPrice = (self) => {
	return new Promise((resolve, reject) => {
	  axios.request({
	    url: self.urls.replayPriceUrl,
	    method: 'POST',
	    data: self.form
	  }).then(response => {
	    self.loading['replayPrice'] = false
	    if (response.data.code !== ResponseStatus.OK) {
	      self.$Message.error(response.data.message)
	    } else {
	      self.$Message.success(response.data.message)
	      utils.cancelModal(self, 'replayPrice')
	      utils.search(self)
	    }
	    resolve(response)
	  }).catch(error => {
	    console.log(error)
	    self.loading['replayPrice'] = false
	    self.$Message.error('设置失败，稍候再试')
	    reject(error)
	  })
	})
}
