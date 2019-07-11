package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserMessageDAO数据访问接口<br/>
 *
 * 创建于2019-05-20<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Repository
public interface UserMessageDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 读取所有后台用户指定消息的未读消息
     * @param userId
     * @param messageId
     * @return
     */
    Long readAdminMsgByMsgId(@Param("userId")Long userId, @Param("messageId") Long messageId);
}
