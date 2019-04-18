import axios from '@/libs/api.request'
/**
* 获取文章分类下拉框
*/
export const getArticleCategorySelect = () => {
  return axios.request({
    url: '/article-category/admin/all',
    method: 'GET'
  })
}
