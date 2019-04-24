package top.zywork.service;

import org.apache.ibatis.annotations.Param;

/**
 * MarkCarpoolService服务接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface MarkCarpoolService extends BaseService {

    Object getByprojectId(@Param("projectId") Long projectId);
}
