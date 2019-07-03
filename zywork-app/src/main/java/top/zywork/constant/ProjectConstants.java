package top.zywork.constant;

/***
 * @description: 招标项目相关的常量类
 * @author: 危锦辉 http://wjhsmart.vip
 * @date: 2019-04-23 10:32
 */
public final class ProjectConstants {


    /**
     * 发布状态-已发布
     */
    public static final String RELEASE_STAUTS_TRUE = "已发布";

    /**
     * 中标公示状态-公告中
     */
    public static final String MARK_PUBLICIT_NOTICE = "公告中";

    /**
     * 中标公示状态-待开标
     */
    public static final String MARK_PUBLICIT_WAIT_MARK = "待开标";

    /**
     * 中标公示状态-已开标
     */
    public static final String MARK_PUBLICIT_IN_MARK = "已开标";

    /**
     * 项目资源类型-澄清文件-0
     */
    public static final int PROJECT_SOURCE_TYPE_CHENGQING = 0;
    /**
     * 项目资源类型-招标文件-1
     */
    public static final int PROJECT_SOURCE_TYPE_ZHAOBIAO = 1;
    /**
     * 项目资源类型-清单文件-2
     */
    public static final int PROJECT_SOURCE_TYPE_QINGDAN = 2;
    /**
     * 项目资源类型-资质文件-3
     */
    public static final int PROJECT_SOURCE_TYPE_ZIZHI = 3;


    /**
     * VIP标识
     */
    public static final String VIP_FLAG = "vipFlag";
    /**
     * vip开通服务提示-请购买VIP服务
     */
    public static final String VIP_TEXT_TIP = "请购买VIP服务";


    /**
     * 中字正则
     */
    public static final String ZHCN_TEXT_REG = "[\\u4e00-\\u9fa5]";


    /**
     * 不需要新建目录标识
     */
    public static final String NOT_CREATE_DIR = "0";


    /**
     * 项目订阅通知类型-项目更新
     */
    public static final String PROJECT_SUBSCRIBE_TYPE_UPDATE = "update";
    /**
     * 项目订阅通知类型-开标提醒
     */
    public static final String PROJECT_SUBSCRIBE_TYPE_OPEN_MARK = "openMark";

    /**
     * 短信开关-开-true
     */
    public static final String SMS_SWITCH_TRUE = "true";


}
