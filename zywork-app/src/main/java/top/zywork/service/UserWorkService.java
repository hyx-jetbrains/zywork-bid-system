package top.zywork.service;

import org.apache.ibatis.annotations.Param;

/**
 * UserWorkService服务接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface UserWorkService extends BaseService {

    Object getByUserId(@Param("userId") Long userId);

}
