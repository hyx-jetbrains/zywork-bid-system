package top.zywork.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.common.RandomUtils;
import top.zywork.constant.UserCouponConstants;
import top.zywork.dao.*;
import top.zywork.dos.UserCouponDO;
import top.zywork.dto.CouponDTO;
import top.zywork.dto.CouponRecordDTO;
import top.zywork.dto.UserCouponDTO;
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
import java.util.List;
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

    private static final Logger logger = LoggerFactory.getLogger(WeixinPayServiceImpl.class);

    private ServiceDAO serviceDAO;

    private UserServiceDAO userServiceDAO;

    private UserCouponDAO userCouponDAO;

    private CouponDAO couponDAO;

    private CouponRecordDAO couponRecordDAO;

    private ExpertSubscribeDAO expertSubscribeDAO;

    private AccountDetailDAO accountDetailDAO;

    private UserWalletDAO userWalletDAO;

    @Override
    public ResponseStatusVO ServicePay(Long userId, String openid, Long serviceId, int validYear, String userCouponIds, int type, long userCouponMoney, WeixinXcxConfig weixinXcxConfig, WXPayConfig wXPayConfig) {
        Object obj = serviceDAO.getById(serviceId);
        if(obj == null) {
            return ResponseStatusVO.dataError("服务不存在", null);
        }
        logger.info("params:" + userId + "---" + openid + "--" + serviceId +  "---" + validYear + "---" + userCouponIds + "---" + type + "---" + userCouponMoney);
        JSONObject json = new JSONObject();

        ServiceVO serviceVO = BeanUtils.copy(obj, ServiceVO.class);

        int totalFee = 0;
        int price = serviceVO.getPrice().intValue();
        int discount = serviceVO.getDiscount()/100;
        if(validYear > 1) {
            // 购买服务大于1年,给打折
            totalFee = validYear * price * discount;
        } else if(validYear == 1) {
            totalFee = price;
        }

        if (!StringUtils.isEmpty(userCouponIds) && userCouponMoney > 0) {
            // 用户有选择抵用券
            String[] userCouponIdsArr = userCouponIds.split(",");
            List<UserCouponDO> userCouponDOList = userCouponDAO.getByUserIdAndCouponIds(userId, userCouponIdsArr);
            if (userCouponDOList.size() != userCouponIdsArr.length) {
                return ResponseStatusVO.dataError("抵扣券使用异常", null);
            }
            // 查询抵用券金额
            long couponMoney = userCouponDAO.sumMoneyByUserIdAndCouponIds(userId, userCouponIdsArr);
            if (userCouponMoney != couponMoney) {
                return ResponseStatusVO.dataError("抵扣券使用异常", null);
            }
            // 减去抵用券的金额
            totalFee -= couponMoney;
            json.put("userCouponId", userCouponIds);
        } else {
            json.put("userCouponId", null);
        }
        if (totalFee <= 0) {
            return ResponseStatusVO.dataError("抵扣券使用异常", null);
        }
        logger.info("totalFee:" + totalFee);
        json.put("userId", userId);
        json.put("serviceId", serviceId);
        json.put("validYear", validYear);
        json.put("type", type);
        json.put("payType", 1);

        String attach = json.toJSONString();

        String order = DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATETIME_SIMPLE.getValue()) + RandomUtils.randomNum(10000, 99999);
        String body = "服务购买";
        return WechatPay(openid, order, totalFee , body, attach, weixinXcxConfig, wXPayConfig);
    }


    @Override
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
        logger.info("notify:" + outTradeNo + "---" + totalFee + "---" + attach);
        JSONObject json = JSONObject.parseObject(attach);
        int payType = json.getIntValue("payType");
        Long userId = json.getLong("userId");
        String accountDetailType = null;
        if(payType == UserCouponConstants.PAY_TYPE_SERVICE) {
            // 服务购买
            accountDetailType = FundsChangeTypeEnum.PURCHASE_SERVICE.getValue();
            String userCouponIds = json.getString("userCouponId");
            Long serviceId = json.getLong("serviceId");
            int validYear = json.getInteger("validYear");
            int type = json.getIntValue("type");

            if(StringUtils.isNotEmpty(userCouponIds)) {
                // 有使用抵用券，更新抵扣券使用状态
                String[] couponIdsArr = userCouponIds.split(",");
                for (String couponIdStr : couponIdsArr) {
                    logger.info("couponId:{}", couponIdStr);
                    if (StringUtils.isEmpty(couponIdStr)) {
                        continue;
                    }
                    Long userCouponId = Long.valueOf(couponIdStr);
                    Object userCouponObj = userCouponDAO.getById(userCouponId);
                    if (null != userCouponObj) {
                        UserCouponDTO userCouponDTO = BeanUtils.copy(userCouponObj, UserCouponDTO.class);
                        userCouponDTO.setUseStatus(UserCouponConstants.COUPON_STATUS_TRUE);
                        logger.info("update t_user_coupon:{}", userCouponDTO);
                        userCouponDTO.setVersion(userCouponDTO.getVersion()+1);
                        int updateRow = userCouponDAO.update(userCouponDTO);
                        if (updateRow > 0) {
                            logger.info("t_user_coupon update success:" + updateRow);
                            Object couponObj = couponDAO.getById(userCouponDTO.getCouponId());
                            CouponDTO couponDTO = BeanUtils.copy(couponObj, CouponDTO.class);
                            long couponMoney = couponDTO.getMoney();
                            long price = Long.valueOf(totalFee);
                            // 更新抵用券状态成功，增加用户抵用券使用记录
                            CouponRecordDTO couponRecordDTO = new CouponRecordDTO();
                            couponRecordDTO.setUserId(userId);
                            couponRecordDTO.setCouponId(userCouponDTO.getCouponId());
                            long oldPrice = price + couponMoney;
                            couponRecordDTO.setPrice(price);
                            couponRecordDTO.setCouponPrice(couponMoney);
                            couponRecordDTO.setOldPrice(oldPrice);
                            couponRecordDAO.save(couponRecordDTO);
                        }
                    }
                }
            }

            UserServiceVO userServiceVO = new UserServiceVO();
            boolean updateFlag = false;
            if(type == UserCouponConstants.BUY_FLAG_FIRST) {
                // 第一次购买
                updateFlag = false;
                userServiceVO.setUserId(userId);
                userServiceVO.setServiceId(serviceId);
            } else if(type == UserCouponConstants.BUY_FLAG_SECOND) {
                // 续费购买
                updateFlag = true;
                Object obj = userServiceDAO.getByUsetIdEndService(userId, serviceId);
                userServiceVO = BeanUtils.copy(obj, UserServiceVO.class);
            }
            userServiceVO.setValidYear(validYear);
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.YEAR, validYear);
            userServiceVO.setEndDate(cal.getTime());
            if(updateFlag) {
                // 续费购买
                logger.info("update t_user_service:{}", userServiceVO);
                userServiceVO.setVersion(userServiceVO.getVersion()+1);
                userServiceDAO.update(userServiceVO);
            } else {
                // 第一次购买
                userServiceDAO.save(userServiceVO);
            }

        } else if(payType == UserCouponConstants.PAY_TYPE_EXPER) {
            // 预约专家
            accountDetailType = FundsChangeTypeEnum.APPOINTMENT_EXPERT.getValue();
            Long expertSubscribeId = json.getLong("expertSubscribeId");
            String transactionNo = json.getString("transactionNo");

            ExpertSubscribeVO expertSubscribeVO = new ExpertSubscribeVO();
            expertSubscribeVO.setId(expertSubscribeId);
            expertSubscribeVO.setPayStatus(GoodsOrderStatusEnum.PAY_SUCCESS.getDes());
            expertSubscribeVO.setTransactionNo(transactionNo);
            expertSubscribeVO.setVersion(expertSubscribeVO.getVersion()+1);
            expertSubscribeDAO.update(expertSubscribeVO);
        }


        Object walletObj = userWalletDAO.getById(userId);
        if(walletObj != null) {
            UserWalletVO userWalletVO = BeanUtils.copy(walletObj, UserWalletVO.class);
            long integral = userWalletVO.getIntegral();
            userWalletVO.setIntegral(integral + totalFee);
            logger.info("t_user_wallet:{}", userWalletVO);
            userWalletVO.setVersion(userWalletVO.getVersion()+1);
            userWalletDAO.update(userWalletVO);
        }

        AccountDetailVO accountDetailVO = new AccountDetailVO();
        accountDetailVO.setUserId(userId);
        accountDetailVO.setTransactionNo(outTradeNo);
        accountDetailVO.setAmount((long)totalFee * -1);
        accountDetailVO.setIntegral((long)totalFee);
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

    @Autowired
    public void setUserWalletDAO(UserWalletDAO userWalletDAO) {
        this.userWalletDAO = userWalletDAO;
    }

    @Autowired
    public void setCouponRecordDAO(CouponRecordDAO couponRecordDAO) {
        this.couponRecordDAO = couponRecordDAO;
    }
}
