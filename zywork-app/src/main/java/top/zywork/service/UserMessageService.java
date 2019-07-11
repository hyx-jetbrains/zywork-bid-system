package top.zywork.service;

/**
 * UserMessageService服务接口<br/>
 *
 * 创建于2019-05-20<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public interface UserMessageService extends BaseService {

    /**
     * 读取后台用户的未读消息，一般用于申请保函和专家预约清除未读消息
     * @param userId
     * @param messageId 一般情况下传：0：申请保函  |  -1：专家预约
     */
    Long readAdminMsgByMsgId(Long userId, Long messageId);

    /**
     * 保存用户消息通知
     * @param messageId 一般情况下传：0：申请保函  |  -1：专家预约
     */
    void saveUserMessage(Long messageId);
}
