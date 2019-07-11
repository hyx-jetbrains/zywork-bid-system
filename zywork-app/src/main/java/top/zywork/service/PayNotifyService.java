package top.zywork.service;

import top.zywork.weixin.PayResult;

/**
 * 支付回调接口<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface PayNotifyService {

    /**
     * 支付回调
     * @param payResult 
     */
    void wxPayNotify(PayResult payResult);

}
