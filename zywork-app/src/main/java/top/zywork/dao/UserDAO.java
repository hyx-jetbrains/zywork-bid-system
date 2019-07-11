package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.dos.UserDO;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserDAO数据访问接口<br/>
 *
 * 创建于2018-12-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface UserDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 根据用户ids获取用户列表
     * @param ids id数组
     * @return
     */
    List<Object> listByUserIds(@Param("ids") String[] ids);

    /**
     * 根据手机号查询用户信息
     * @param phone 手机号数组
     * @return
     */
    List<UserDO> listByUserPhone(@Param("phone") String[] phone);
}
