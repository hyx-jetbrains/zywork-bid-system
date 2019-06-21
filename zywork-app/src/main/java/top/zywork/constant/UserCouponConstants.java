package top.zywork.constant;

/**
 * @program: zywork-app
 * @description: 用户抵用券相关的常量类
 * @author: 危锦辉 http://wjhsmart.vip
 * @create: 2019-06-05 11:24
 */
public class UserCouponConstants {

    /**
     * 抵用券使用状态-已使用-1
     */
    public static final int COUPON_STATUS_TRUE = 1;

    /**
     * 抵用券使用状态-待使用-0
     */
    public static final int COUPON_STATUS_FALSE = 0;


    /**
     * 第一次购买标识-0
     */
    public static final int BUY_FLAG_FIRST = 0;
    /**
     * 续购标识-1
     */
    public static final int BUY_FLAG_SECOND = 1;


    /**
     * 支付类型-服务购买-1
     */
    public static final int PAY_TYPE_SERVICE = 1;
    /**
     * 支付类型-专家预约-2
     */
    public static final int PAY_TYPE_EXPER = 2;
}
