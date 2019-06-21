package top.zywork.service;

import top.zywork.vo.ResponseStatusVO;
import top.zywork.weixin.WXPayConfig;
import top.zywork.weixin.WeixinXcxConfig;

/**
 * User: DengMin
 * Date: 2019/05/28
 * Time: 17:50
 * Description: No Description
 */
public interface WeixinPayService extends BaseService {

    ResponseStatusVO ServicePay(Long UserId, String openid, Long serviceId, int validYear, String userCouponId, int type, long userCouponMoney, WeixinXcxConfig weixinXcxConfig, WXPayConfig wXPayConfig);

    ResponseStatusVO ExpertSubscribePay(Long UserId, String openid, Long id, WeixinXcxConfig weixinXcxConfig, WXPayConfig wXPayConfig);

    void payNotif(String outTradeNo, int totalFee, String attach);
}
