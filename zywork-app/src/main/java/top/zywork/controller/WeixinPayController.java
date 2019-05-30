package top.zywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.*;
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

    private SysConfigService sysConfigService;

    private WeixinPayService weixinPayService;

    /**
     * User: DengMin
     * Date: 2019/05/29
     * Time: 9:53
     * Description: 服务购买
     */
    @PostMapping("user/servicePay")
    public ResponseStatusVO ServicePay(Long serviceId, int validYear, Long userCouponId, int type) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinXcxConfig.class);
        WXPayConfig wXPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);

        return weixinPayService.ServicePay(jwtUser.getUserId(), jwtUser.getUsername(), serviceId, validYear, userCouponId, type, weixinXcxConfig, wXPayConfig);
    }

    /**
     * User: DengMin
     * Date: 2019/05/29
     * Time: 9:53
     * Description: 预约专家
     */
    @PostMapping("user/expertSubscribePay")
    public ResponseStatusVO ExpertSubscribePay(@RequestBody @Validated ExpertSubscribeVO expertSubscribeVO) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinXcxConfig.class);
        WXPayConfig wXPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);
        return weixinPayService.ExpertSubscribePay(jwtUser.getUserId(), jwtUser.getUsername(), expertSubscribeVO.getId(), weixinXcxConfig, wXPayConfig);
    }

    @PostMapping("/payNotifyUrl")
    public void payNotifyUrl(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> payResultMap = WeixinUtils.payResultMap(request);
        PayResult payResult = WeixinUtils.payResult(payResultMap);
        if(WeixinUtils.isReturnSuccess(payResultMap)) {
            weixinPayService.payNotif(payResult.getOutTradeNo(), payResult.getTotalFee(), payResultMap.get("attach"));
        }
        WeixinUtils.responsePayNotify(response);
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
