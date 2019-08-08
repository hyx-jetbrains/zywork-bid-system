package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * ProjectDAO数据访问接口<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface ProjectDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    List<Object> listPageByUserId(@Param("query") Object queryObj, @Param("userId") Long userId);

    Long countByUserId(@Param("query") Object queryObj, @Param("userId") Long userId);

    Object getByTitle(@Param("title") String title);

    /**
     * 根据公告名称和公告时间查询公告信息
     * @param title
     * @param noticeTime
     * @return
     */
    Object getByTitleAndNoticeTime(@Param("title") String title, @Param("noticeTime") String noticeTime);

    Object getProjectBySelect(@Param("id") Long id, @Param("city") String city, @Param("list") List<Object> list);

    /***
     * @description:  更新开标状态，改成已开标，job执行这个方法，其他地方请不要调用
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-18 18:28
     */
    void updateMarkStatus();
}
