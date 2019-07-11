package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.*;
import top.zywork.service.impl.AbstractPayService;
import top.zywork.vo.*;
import top.zywork.weixin.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: DengMin
 * Date: 2019/05/27
 * Time: 18:13
 * Description: 微信支付
 */
@RestController
@RequestMapping("/wx-pay")
public class WeixinPayController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(WeixinPayController.class);

    private SysConfigService sysConfigService;

    private WeixinPayService weixinPayService;

    /**
     * User: DengMin
     * Date: 2019/05/29
     * Time: 9:53
     * Description: 服务购买
     */
    @PostMapping("user/servicePay")
    public ResponseStatusVO ServicePay(Long serviceId, int validYear, String userCouponIds, int type, long userCouponMoney) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_XCX_CONFIG.getValue(), WeixinXcxConfig.class);
        WXPayConfig wXPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);

        return weixinPayService.ServicePay(jwtUser.getUserId(), jwtUser.getUsername(), serviceId, validYear, userCouponIds, type, userCouponMoney, weixinXcxConfig, wXPayConfig);
    }

    /**
     * User: DengMin
     * Date: 2019/05/29
     * Time: 9:53
     * Description: 预约专家
     */
    @PostMapping("user/expertSubscribePay/{id}")
    public ResponseStatusVO ExpertSubscribePay(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_XCX_CONFIG.getValue(), WeixinXcxConfig.class);
        WXPayConfig wXPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);
        return weixinPayService.ExpertSubscribePay(jwtUser.getUserId(), jwtUser.getUsername(), id, weixinXcxConfig, wXPayConfig);
    }

    @PostMapping("/payNotifyUrl")
    public void payNotifyUrl(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> payResultMap = WeixinPayUtils.payResultMap(request);
        PayResult payResult = WeixinPayUtils.payResult(payResultMap);
        logger.info("payResult:" + payResult.getOutTradeNo() + "-------" + payResult.getTotalFee());
        if(WeixinPayUtils.isReturnSuccess(payResultMap)) {
            weixinPayService.payNotif(payResult.getOutTradeNo(), payResult.getTotalFee(), payResultMap.get("attach"));
        }
        WeixinPayUtils.responsePayNotify(response);
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

    @Autowired
    public void setWeixinPayService(WeixinPayService weixinPayService) {
        this.weixinPayService = weixinPayService;
    }
}
