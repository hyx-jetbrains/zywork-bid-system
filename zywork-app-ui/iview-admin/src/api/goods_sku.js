import axios from '@/libs/api.request'

/**
 * 根据goods条件查询所有SKU
 * @param {*} id 
 */
export const allSkusByGoods = (params) => {
    return axios.request({
        url: '/goods-sku/admin/all-cond',
        method: 'POST',
        data: params
      })
}

/**
 * 批量保存商品sku属性值
 * @param {*} params 
 */
export const batchSaveGoodsAttrVals = (params) => {
  return axios.request({
    url: '/goods-attribute-value/admin/batch-save',
    method: 'POST',
    data: params
  })
}