package top.zywork.ali;

/**
 * 阿里云SDK配置基础类<br/>
 * 创建于2018-12-15<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class SmsSwitchConfig {

    /**
     * 订阅通知
     */
    private String subscribeNotice;
    /**
     * 开标通知
     */
    private String openMarkNotice;

    public SmsSwitchConfig() {}

    public SmsSwitchConfig(String subscribeNotice, String openMarkNotice) {
        this.subscribeNotice = subscribeNotice;
        this.openMarkNotice = openMarkNotice;
    }

    public String getSubscribeNotice() {
        return subscribeNotice;
    }

    public void setSubscribeNotice(String subscribeNotice) {
        this.subscribeNotice = subscribeNotice;
    }

    public String getOpenMarkNotice() {
        return openMarkNotice;
    }

    public void setOpenMarkNotice(String openMarkNotice) {
        this.openMarkNotice = openMarkNotice;
    }
}
