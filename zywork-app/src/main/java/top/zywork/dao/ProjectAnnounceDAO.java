package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * ProjectAnnounceDAO数据访问接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface ProjectAnnounceDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);


    /***
     * @description: 取前端所需的下拉框，用于公示详情的下拉框
     * @return: java.util.List<java.lang.Object>
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-04-23 13:07
     */
    List<Object> getProjectSelect(@Param("projectId") Long projectId);

    Object getByProjectId(@Param("projectId") Long projectId);

    Object getByTitle(@Param("title") String title);

}
