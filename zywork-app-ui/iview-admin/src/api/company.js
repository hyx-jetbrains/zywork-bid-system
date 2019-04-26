import axios from '@/libs/api.request'

/**
* 获取所有公司信息
*/
export const getCompanyAll = () => {
  return axios.request({
    url: '/company/admin/all',
    method: 'GET',
    data: ''
  })
}
