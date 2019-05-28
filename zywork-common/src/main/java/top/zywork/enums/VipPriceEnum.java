package top.zywork.enums;

/**
 * User: DengMin
 * Date: 2019/05/27
 * Time: 18:48
 * Description: No Description
 */
public enum VipPriceEnum {
    VIP1("vip1"),
    VIP2("vip2"),
    VIP3("vip3");

    VipPriceEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
