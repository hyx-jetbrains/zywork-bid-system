package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * MarkSeekcarRecordDAO数据访问接口<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Repository
public interface MarkSeekcarRecordDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /***
     * @description: 根据用户id和找车id查询找车记录
     * @param userId 用户id
     * @param markSeekcarId 找车id
     * @return: java.lang.Object
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 11:40
     */
    Object getByUserIdAndSeekcarId(@Param("userId") Long userId, @Param("markSeekcarId") Long markSeekcarId);

}
