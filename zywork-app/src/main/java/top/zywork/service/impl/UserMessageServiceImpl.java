package top.zywork.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.ali.AliyunSmsConfig;
import top.zywork.ali.AliyunSmsUtils;
import top.zywork.ali.MessagePhoneConfig;
import top.zywork.constant.NoticeConstants;
import top.zywork.constant.SmsConstants;
import top.zywork.constant.UserMessageConstants;
import top.zywork.dao.UserDAO;
import top.zywork.dao.UserMessageDAO;
import top.zywork.dos.UserMessageDO;
import top.zywork.dto.UserMessageDTO;
import top.zywork.enums.SysConfigEnum;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.SysConfigService;
import top.zywork.service.UserMessageService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * UserMessageServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-20<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "userMessageService")
public class UserMessageServiceImpl extends AbstractBaseService implements UserMessageService {

    private static final Logger logger = LoggerFactory.getLogger(UserMessageServiceImpl.class);

    private UserMessageDAO userMessageDAO;

    private SysConfigService sysConfigService;

    private UserDAO userDAO;

    @Autowired
    public void setUserMessageDAO(UserMessageDAO userMessageDAO) {
        super.setBaseDAO(userMessageDAO);
        this.userMessageDAO = userMessageDAO;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserMessageDO.class, UserMessageDTO.class);
    }

    @Override
    public Long readAdminMsgByMsgId(Long userId, Long messageId) {
        return userMessageDAO.readAdminMsgByMsgId(userId, messageId);
    }

    @Override
    public void saveUserMessage(Long messageId) {
        try {
            MessagePhoneConfig messagePhoneConfig = sysConfigService.getByName(SysConfigEnum.MESSAGE_PHONE_CONFIG.getValue(), MessagePhoneConfig.class);
            String ids = messagePhoneConfig.getIds();
            String phones = messagePhoneConfig.getPhone();
            String[] idsArr = ids.split(",");
            if (idsArr.length > 0) {
                // 发送系统消息通知
                for (String idStr : idsArr) {
                    UserMessageDTO userMessageDTO = new UserMessageDTO();
                    userMessageDTO.setMessageId(messageId);
                    userMessageDTO.setUserId(Long.valueOf(idStr));
                    save(userMessageDTO);
                }
            }
            if (phones.length() > 0) {
                // 发送短信通知
                String optType = "未知类型";
                if (UserMessageConstants.MESSAGE_NOTICE_GUARANTEE.longValue() == messageId) {
                    optType = "申请保函";
                } else if (UserMessageConstants.MESSAGE_NOTICE_EXPERT.longValue() == messageId) {
                    optType = "预约专家";
                } else if (UserMessageConstants.MESSAGE_NOTICE_CONSULT.longValue() == messageId) {
                    optType = "用户咨询";
                }
                JSONObject templateParam = new JSONObject();
                templateParam.put("optType", optType);
                AliyunSmsConfig aliyunSmsConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
                SendSmsResponse sendSmsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phones, SmsConstants.SMS_NOTICE_TEMPLATE_CODE_OPT_NOTICE,
                        templateParam.toJSONString(), null);
                if (!sendSmsResponse.getCode().equals("OK")) {
                    logger.error("{}:短信发送失败：{}-{}", phones, optType, sendSmsResponse.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
