package top.zywork.controller;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.RandomUtils;
import top.zywork.enums.DatePatternEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.SysConfigService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.weixin.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: DengMin
 * Date: 2019/05/27
 * Time: 18:13
 * Description: No Description
 */
@RestController
@RequestMapping("/wx-pay")
public class WeixinPayController extends BaseController {

    private SysConfigService sysConfigService;

    /*public ResponseStatusVO vipPay() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        sysConfigService.getByName();

        String order = DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATETIME_SIMPLE.getValue()) + RandomUtils.randomNum(10000, 99999);

        return WechatPay(jwtUser.getUsername(), order,);
    }


    @PostMapping("user/createExpertSubscribeOrder")
    public ResponseStatusVO ExpertSubscribePay() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }

        String order = DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATETIME_SIMPLE.getValue()) + RandomUtils.randomNum(10000, 99999);

        return WechatPay(jwtUser.getUsername(), order, );
    }*/

    public ResponseStatusVO WechatPay(String openid, String orderNo, int totalFee, String body, String attach) {
        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinXcxConfig.class);
        WXPayConfig wXPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);
        String appId = weixinXcxConfig.getAppId();
        String mchId =  wXPayConfig.getMchId();
        String apiKey = wXPayConfig.getApiSecret();
        String ip = "127.0.0.1";

        String payNotifyUrl = wXPayConfig.getBaseUrl() + wXPayConfig.getPayNotifyUrl();
        Map<String, String> unifiedOrderResult = WeixinUtils.unifiedOrder(appId, mchId, apiKey, openid, orderNo, ip, body, attach, totalFee, payNotifyUrl);
        Map<String, String> data = WeixinUtils.payDataMap(appId, apiKey, unifiedOrderResult);
        return ResponseStatusVO.ok("下单成功", data);
    }

    @PostMapping("payNotifyUrl")
    public void payNotifyUrl(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> payResultMap = WeixinUtils.payResultMap(request);
        if(WeixinUtils.isReturnSuccess(payResultMap)) {
            //修改用户状态为VIP
        }
        WeixinUtils.responsePayNotify(response);
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
