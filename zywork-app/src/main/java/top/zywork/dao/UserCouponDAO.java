package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.dos.UserCouponDO;
import top.zywork.dto.UserCouponDTO;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserCouponDAO数据访问接口<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Repository
public interface UserCouponDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    List<UserCouponDO> getByUserIdAndCouponIds(@Param("userId") Long userId, @Param("couponIds") String[] couponIds);

    Long sumMoneyByUserIdAndCouponIds(@Param("userId") Long userId, @Param("couponIds") String[] couponIds);
}
