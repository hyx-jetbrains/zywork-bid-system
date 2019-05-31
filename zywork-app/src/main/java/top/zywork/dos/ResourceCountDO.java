package top.zywork.dos;

import top.zywork.vo.BaseVO;

/**
 * User: DengMin
 * Date: 2019/05/30
 * Time: 17:55
 * Description: No Description
 */
public class ResourceCountDO extends BaseVO{

    private Long count;

    private Byte type;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}
