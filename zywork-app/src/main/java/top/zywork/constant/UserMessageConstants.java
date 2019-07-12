package top.zywork.constant;

/***
 * @description: 用户消息相关的常量类
 * @author: 危锦辉 http://wjhsmart.vip
 * @date: 2019-05-20 10:32
 */
public final class UserMessageConstants {

    /**
     * 消息读取类型-未读-0
     */
    public static final Integer MESSAGE_IS_READ_FALSE = 0;

    /**
     * 消息读取类型-已读-1
     */
    public static final Integer MESSAGE_IS_READ_TRUE = 1;


    /**
     * 消息通知类型-保函申请消息
     */
    public static final Long MESSAGE_NOTICE_GUARANTEE = 0L;
    /**
     * 消息通知类型-专家预约消息
     */
    public static final Long MESSAGE_NOTICE_EXPERT = -1L;
    /**
     * 消息通知类型-用户咨询消息
     */
    public static final Long MESSAGE_NOTICE_CONSULT = -2L;

}
