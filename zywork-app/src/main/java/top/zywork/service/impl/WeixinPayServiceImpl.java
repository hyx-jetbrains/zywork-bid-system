package top.zywork.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.common.RandomUtils;
import top.zywork.dao.*;
import top.zywork.enums.DatePatternEnum;
import top.zywork.enums.FundsChangeTypeEnum;
import top.zywork.enums.GoodsOrderStatusEnum;
import top.zywork.enums.PaymentTypeEnum;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.WeixinPayService;
import top.zywork.vo.*;
import top.zywork.weixin.WXPayConfig;
import top.zywork.weixin.WeixinUtils;
import top.zywork.weixin.WeixinXcxConfig;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * User: DengMin
 * Date: 2019/05/28
 * Time: 17:51
 * Description: No Description
 */
@Service(value = "weixinPayService")
@Transactional(rollbackFor = Exception.class)
public class WeixinPayServiceImpl extends AbstractBaseService implements WeixinPayService {

    private ServiceDAO serviceDAO;

    private UserServiceDAO userServiceDAO;

    private UserCouponDAO userCouponDAO;

    private CouponDAO couponDAO;

    private ExpertSubscribeDAO expertSubscribeDAO;

    private AccountDetailDAO accountDetailDAO;



    @Override
    public ResponseStatusVO ServicePay(Long UserId, String openid, Long serviceId, int validYear, Long userCouponId, int type, WeixinXcxConfig weixinXcxConfig, WXPayConfig wXPayConfig) {
        Object obj = serviceDAO.getById(serviceId);
        if(obj == null) {
            return ResponseStatusVO.dataError("服务不存在", null);
        }

        JSONObject json = new JSONObject();

        ServiceVO serviceVO = BeanUtils.copy(obj, ServiceVO.class);

        int totalFee = 0;

        if(validYear > 1) {
            // 购买服务大于1年可以获取折扣。
            totalFee = serviceVO.getPrice().intValue() * (serviceVO.getDiscount()/100);
        } else if(validYear == 1) {
            totalFee = serviceVO.getPrice().intValue();
        }

        if(userCouponId != null && userCouponId != 0) {
            // 使用抵扣券进行抵扣。
            Object uconObj = userCouponDAO.getById(userCouponId);
            if(uconObj == null) {
                return ResponseStatusVO.dataError("抵扣券不存在", null);
            }

            UserCouponVO userCouponVO = BeanUtils.copy(uconObj, UserCouponVO.class);
            if(userCouponVO.getUseStatus() == 1) {
                return ResponseStatusVO.dataError("抵扣券已使用", null);
            }

            Object couObj = couponDAO.getById(userCouponVO.getCouponId());

            if(couObj == null) {
                return ResponseStatusVO.dataError("系统中不存在这类抵扣券", null);
            }

            CouponVO couponVO = BeanUtils.copy(couObj, CouponVO.class);
            if((couponVO.getValidTime().getTime() - System.currentTimeMillis()) < 0) {
                return ResponseStatusVO.dataError("抵扣券已过期", null);
            }

            if(totalFee == 0) {
                // 购买服务没有折扣（购买服务没有大于1年），但是使用了抵扣券。
                totalFee = serviceVO.getPrice().intValue() -  couponVO.getMoney().intValue();
            } else {// 购买服务有折扣，并使用了抵扣券。
                totalFee = totalFee - couponVO.getMoney().intValue();
            }

            json.put("userCouponId",userCouponVO.getId());
        } else {
            json.put("userCouponId", null);
        }

        json.put("userId", UserId);
        json.put("serviceId", serviceId);
        json.put("validYear", validYear);
        json.put("type", type);
        json.put("payType", 1);

        String attach = json.toJSONString();

        String order = DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATETIME_SIMPLE.getValue()) + RandomUtils.randomNum(10000, 99999);
        String body = "服务购买";
        return WechatPay(openid, order, totalFee , body, attach, weixinXcxConfig, wXPayConfig);
    }

    public ResponseStatusVO ExpertSubscribePay (Long UserId, String openid, Long id, WeixinXcxConfig weixinXcxConfig, WXPayConfig wXPayConfig) {
        String order = DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATETIME_SIMPLE.getValue()) + RandomUtils.randomNum(10000, 99999);

        Object obj = expertSubscribeDAO.getById(id);
        if(obj == null) {
            return ResponseStatusVO.dataError("咨询的问题不存在", null);
        }

        ExpertSubscribeVO es = BeanUtils.copy(obj, ExpertSubscribeVO.class);

        String body = "预约专家";
        JSONObject json = new JSONObject();
        json.put("expertSubscribeId", es.getId());
        json.put("userId", UserId);
        json.put("payType", 2);
        json.put("transactionNo",order);

        String attach = json.toJSONString();

        return WechatPay(openid, order, es.getPrice().intValue(), body,attach, weixinXcxConfig, wXPayConfig);
    }

    public ResponseStatusVO WechatPay(String openid, String orderNo, int totalFee, String body,String attach, WeixinXcxConfig weixinXcxConfig, WXPayConfig wXPayConfig) {
        String appId = weixinXcxConfig.getAppId();
        String mchId =  wXPayConfig.getMchId();
        String apiKey = wXPayConfig.getApiSecret();
        String ip = "127.0.0.1";

        String payNotifyUrl = wXPayConfig.getBaseUrl() + wXPayConfig.getPayNotifyUrl();
        Map<String, String> unifiedOrderResult = WeixinUtils.unifiedOrder(appId, mchId, apiKey, openid, orderNo, ip, body, attach, totalFee, payNotifyUrl);
        Map<String, String> data = WeixinUtils.payDataMap(appId, apiKey, unifiedOrderResult);
        return ResponseStatusVO.ok("下单成功", data);
    }

    @Override
    public void payNotif(String outTradeNo, int totalFee, String attach) {
        JSONObject json = JSONObject.parseObject(attach);
        int payType = json.getIntValue("payType");
        Long userId = json.getLong("userId");
        String accountDetailType = null;
        if(payType == 1) {// 服务购买
            accountDetailType = FundsChangeTypeEnum.PURCHASE_SERVICE.getValue();
            Long userCouponId = json.getLong("userCouponId");
            Long serviceId = json.getLong("serviceId");
            int validYear = json.getInteger("validYear");
            int type = json.getIntValue("type");

            if(userCouponId != null) {
                int version = userCouponDAO.getVersionById(userCouponId);
                UserCouponVO uc = new UserCouponVO();
                uc.setId(userCouponId);
                uc.setUseStatus(1);
                uc.setVersion(version + 1);
                userCouponDAO.update(uc);
            }

            UserServiceVO userServiceVO = new UserServiceVO();
            if(type == 0) {
                userServiceVO.setUserId(userId);
                userServiceVO.setServiceId(serviceId);
                userServiceVO.setValidYear(validYear);
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.YEAR, validYear);
                userServiceVO.setEndDate(cal.getTime());
                userServiceDAO.save(userServiceVO);
            } else if(type == 1) {
                Object obj = userServiceDAO.getByUsetIdEndService(userId, serviceId);
                UserServiceVO uc = BeanUtils.copy(obj, UserServiceVO.class);

                userServiceVO.setId(uc.getId());
                userServiceVO.setValidYear(validYear);
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.YEAR, validYear);
                userServiceVO.setEndDate(cal.getTime());
                userServiceDAO.update(userServiceVO);
            }
        } else if(payType == 2) {// 预约专家
            accountDetailType = FundsChangeTypeEnum.APPOINTMENT_EXPERT.getValue();
            Long expertSubscribeId = json.getLong("expertSubscribeId");
            String transactionNo = json.getString("transactionNo");

            ExpertSubscribeVO expertSubscribeVO = new ExpertSubscribeVO();
            expertSubscribeVO.setId(expertSubscribeId);
            expertSubscribeVO.setPayStatus(GoodsOrderStatusEnum.PAY_SUCCESS.getDes());
            expertSubscribeVO.setPayType(PaymentTypeEnum.WEIXIN_PAY.getDes());
            expertSubscribeVO.setTransactionNo(transactionNo);
            expertSubscribeDAO.update(expertSubscribeVO);
        }

        AccountDetailVO accountDetailVO = new AccountDetailVO();
        accountDetailVO.setUserId(userId);
        accountDetailVO.setTransactionNo(outTradeNo);
        accountDetailVO.setAmount((long)totalFee);
        accountDetailVO.setType((byte)1);
        accountDetailVO.setPayType(PaymentTypeEnum.WEIXIN_PAY.getValue().byteValue());
        accountDetailVO.setSubType(accountDetailType);
        accountDetailDAO.save(accountDetailVO);
    }

    @Autowired
    public void setServiceDAO(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @Autowired
    public void setUserServiceDAO(UserServiceDAO userServiceDAO) {
        this.userServiceDAO = userServiceDAO;
    }

    @Autowired
    public void setUserCouponDAO(UserCouponDAO userCouponDAO) {
        this.userCouponDAO = userCouponDAO;
    }

    @Autowired
    public void setCouponDAO(CouponDAO couponDAO) {
        this.couponDAO = couponDAO;
    }

    @Autowired
    public void setExpertSubscribeDAO(ExpertSubscribeDAO expertSubscribeDAO) {
        this.expertSubscribeDAO = expertSubscribeDAO;
    }

    @Autowired
    public void setAccountDetailDAO(AccountDetailDAO accountDetailDAO) {
        this.accountDetailDAO = accountDetailDAO;
    }
}
