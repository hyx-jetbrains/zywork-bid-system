import axios from '@/libs/api.request'

/**
 * 根据商品类目条件查询所有商品属性
 * @param {*}
 */
export const getAttrsByCategory = (params) => {
    return axios.request({
        url: '/goods-category-attr/admin/all-cond',
        method: 'POST',
        data: params
      })
}

/**
 * 批量更新类目属性排序
 * @param {*} params 
 */
export const updateGoodsCategoryAttr = (params) => {
    return axios.request({
        url: '/goods-category-attr/admin/batch-update',
        method: 'POST',
        data: params
      })
}

/**
 * 根据条件查询sku属性值
 * @param {*} params 
 */
export const skuAttrVals = (params) => {
  return axios.request({
    url: '/goods-sku-attr-val/admin/all-cond',
    method: 'POST',
    data: params
  }) 
}