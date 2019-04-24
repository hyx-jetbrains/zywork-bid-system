package top.zywork.service;

import top.zywork.dto.ResourceDTO;

/**
 * ResourceService服务接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface ResourceService extends BaseService {

    /***
     * @description: 保存资源，返回资源ID
     * @param userId 用户id
     * @param mimeType 资源类型
     * @param url 资源地址
     * @param extension 资源后缀
     * @return: ResourceDTO 资源
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-24 10:10
     */
    ResourceDTO saveResource(Long userId, String mimeType, String url, String extension);
}
