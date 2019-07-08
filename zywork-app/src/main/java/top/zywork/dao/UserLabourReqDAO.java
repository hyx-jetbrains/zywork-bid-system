package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserLabourReqDAO数据访问接口<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Repository
public interface UserLabourReqDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);
}
