package top.zywork.service;

import org.apache.ibatis.annotations.Param;

/**
 * SubscribeService服务接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface SubscribeService extends BaseService {

    Object getByUserId(@Param("userId") Long userId);
}
