package top.zywork.ali;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.commons.lang.StringUtils;

/**
 * 阿里云短信接口工具类，包含发送短信，查询发送详情<br/>
 *
 * 创建于2018-12-10<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class AliyunSmsUtils {

    private static final String product = "Dysmsapi";
    private static final String domain = "dysmsapi.aliyuncs.com";

    /**
     * 发送短信
     * @param aliyunSmsConfig 阿里云短信发送配置对象
     * @param phoneNumbers 必填:待发送手机号，使用,隔开
     * @param templateCode 必填:短信模板-可在短信控制台中找到
     * @param templateParam 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为"{\"name\":\"Tom\", \"code\":\"123\"}"
     * @param outId 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendSms(AliyunSmsConfig aliyunSmsConfig, String phoneNumbers, String templateCode, String templateParam, String outId) throws ClientException {
        IAcsClient acsClient = getClient(aliyunSmsConfig);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phoneNumbers);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(aliyunSmsConfig.getSignName());
        request.setTemplateCode(templateCode);
        if (StringUtils.isNotEmpty(templateParam)) {
            request.setTemplateParam(templateParam);
        }
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        if (StringUtils.isNotEmpty(outId)) {
            request.setOutId(outId);
        }
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }

    /**
     * 查询发送详情
     * @param aliyunSmsConfig 阿里云短信发送配置对象
     * @param phoneNumber 必填-号码
     * @param bizId 可选-流水号
     * @param date 必填-发送日期 支持30天内记录查询，格式yyyyMMdd
     * @param pageNo 必填-页大小
     * @param pageSize 必填-当前页码从1开始计数
     * @return
     * @throws ClientException
     */
    public static QuerySendDetailsResponse querySendDetails(AliyunSmsConfig aliyunSmsConfig, String phoneNumber, String bizId, String date, Long pageNo, Long pageSize) throws ClientException {
        IAcsClient acsClient = getClient(aliyunSmsConfig);
        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber(phoneNumber);
        if (StringUtils.isNotEmpty(bizId)) {
            request.setBizId(bizId);
        }
        request.setSendDate(date);
        request.setPageSize(pageSize);
        request.setCurrentPage(pageNo);
        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
        return querySendDetailsResponse;
    }

    private static IAcsClient getClient(AliyunSmsConfig aliyunSmsConfig) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile(aliyunSmsConfig.getRegionId(), aliyunSmsConfig.getAccessKeyId(), aliyunSmsConfig.getAccessKeySecret());
        DefaultProfile.addEndpoint(aliyunSmsConfig.getRegionId(), aliyunSmsConfig.getRegionId(), product, domain);
        return new DefaultAcsClient(profile);
    }

    public static void main(String[] args) throws ClientException, InterruptedException {
        AliyunSmsConfig aliyunSmsConfig = new AliyunSmsConfig("accessKeyId", "accessKeySecret", "signName");
        //发短信
        SendSmsResponse response = sendSms(aliyunSmsConfig,"15000000000", "SMS_1000000",
                "{\"name\":\"Tom\", \"code\":\"123\"}", null);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());

        Thread.sleep(3000L);

        //查明细
        if(response.getCode() != null && response.getCode().equals("OK")) {
            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(aliyunSmsConfig, "15000000000", response.getBizId(),
                    "20181210", 1L, 15L);
            System.out.println("短信明细查询接口返回数据----------------");
            System.out.println("Code=" + querySendDetailsResponse.getCode());
            System.out.println("Message=" + querySendDetailsResponse.getMessage());
            int i = 0;
            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
            {
                System.out.println("SmsSendDetailDTO["+i+"]:");
                System.out.println("Content=" + smsSendDetailDTO.getContent());
                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
            }
            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
        }
    }

}
