import axios from '@/libs/api.request'

/**
 * 批量保存商品类目的属性
 * @param {*} id 
 */
export const updateGoodsCategoryAttr = (params) => {
    return axios.request({
        url: '/goods-category-attr/admin/batch-save',
        method: 'POST',
        data: params
      })
}