package top.zywork.service;

/**
 * UserNoticeService服务接口<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public interface UserNoticeService extends BaseService {
    /**
     * 清除指定用户指定类型的未读消息
     * @param userId 指定用户编号
     * @param noticeType 指定消息类型
     * @return
     */
    Long clearNoReadMessage(Long userId, Integer noticeType);
}
