import axios from '@/libs/api.request'
import Qs from 'qs'
/**
 * 获取Redis缓存信息
 */
export const redisCacheInfo = () => {
  return axios.request({
    url: '/redis-manage/info',
    method: 'GET',
    data: ''
  })
}

/**
 * 获取Redis指定的key，如不指定，则获取所有
 */
export const redisCacheKeys = (params) => {
  return axios.request({
    url: '/redis-manage/keys',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 获取key的个数
 */
export const redisCacheKeysCount = () => {
  return axios.request({
    url: '/redis-manage/keys-count',
    method: 'GET',
    data: ''
  })
}

/**
 * 根据key获取value信息
 */
export const getValueByKey = (params) => {
  return axios.request({
    url: '/redis-manage/value',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 根据key删除缓存信息
 */
export const delKey = (params) => {
  return axios.request({
    url: '/redis-manage/del-key',
    method: 'POST',
    data: Qs.stringify(params)
  })
}

/**
 * 删除所有缓存
 */
export const delKeys = (params) => {
  return axios.request({
    url: '/redis-manage/del-keys',
    method: 'POST',
    data: params
  })
}
