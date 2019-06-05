package top.zywork.enums;

/**
 * User: DengMin
 * Date: 2019/05/31
 * Time: 18:11
 * Description: No Description
 */
public enum NoticeEnum {

    SUBSCRIBE_MESSAGE((byte)0,"订阅通知"),
    BID_OPENING_MESSAGE((byte)1,"开标通知"),
    MARKCARPOOL_MESSAGE((byte)2,"拼车通知"),
    MARKSEEKCAR_MESSAGE((byte)3,"找车通知"),
    SYSTEM_MESSAGE((byte)4,"系统通知"),
    APPOINTMENT_EXPERT_MESSAGE((byte)5,"预约专家通知");

    NoticeEnum(byte value, String des){
        this.value = value;
        this.des = des;
    }

    private byte value;

    private String des;

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
