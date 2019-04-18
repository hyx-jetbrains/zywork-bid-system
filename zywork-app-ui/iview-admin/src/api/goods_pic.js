import axios from '@/libs/api.request'

/**
 * 条件查询商品图片
 * @param {*} params 
 */
export const allPicByGoods = (params) => {
  return new Promise((resolve, reject) => {
    axios.request({
      url: '/goods-pic/admin/all-cond',
      method: 'POST',
      data: params
    }).then(response => {
      resolve(response)
    }).catch(error => {
      reject(error)
    })
  })
}

/**
 * 更新商品图片信息
 * @param {*} params 
 */
export const updateGoodsPic = (params) => {
  return axios.request({
    url: '/goods-pic/admin/batch-update',
    method: 'POST',
    data: params
  })
}

/**
 * 根据图片id获取图片信息
 * @param {*} id 
 */
export const getPicById = (id) => {
  return axios.request({
    url: '/goods-pic/admin/one/' + id,
    method: 'GET',
    data: null
  })
}