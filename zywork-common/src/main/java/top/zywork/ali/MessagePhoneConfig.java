package top.zywork.ali;

/***
 * @description:  申请保函和专家预约通知用户手机号配置类
 * @return:
 * @author: 危锦辉 http://wjhsmart.vip
 * @date: 2019-07-11 10:05
 */
public class MessagePhoneConfig extends AliyunBaseConfig {

    /**
     * 用户编号
     */
    private String ids;

    /**
     * 用户手机号
     */
    private String phone;

    public MessagePhoneConfig() {
    }

    public MessagePhoneConfig(String ids, String phone) {
        this.ids = ids;
        this.phone = phone;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
