package top.zywork.service;

import org.apache.ibatis.annotations.Param;

/**
 * ProjectCollectionService服务接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface ProjectCollectionService extends BaseService {

    Object getByUserAndProject(@Param("userId") Long userId, @Param("projectId") Long projectId);
}
