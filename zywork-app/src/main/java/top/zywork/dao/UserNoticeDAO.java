package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserNoticeDAO数据访问接口<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Repository
public interface UserNoticeDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 清除指定用户指定类型的未读消息
     * @param userId 指定用户编号
     * @param noticeType 指定消息类型
     * @return
     */
    Long clearNoReadMessage(@Param("userId") Long userId, @Param("noticeType") Integer noticeType);
}
