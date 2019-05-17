package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * MarkCarpoolRecordDAO数据访问接口<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Repository
public interface MarkCarpoolRecordDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /***
     * @description: 根据用户id和拼车id查询拼车记录
     * @param userId 用户id
     * @param markCarpoolId 拼车id
     * @return: java.lang.Object
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-05-17 11:40
     */
    Object getByUserIdAndCarpoolId(@Param("userId") Long userId, @Param("markCarpoolId") Long markCarpoolId);

}
