package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CouponDO数据对象实体类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CouponDO extends BaseDO {

    private static final long serialVersionUID = -9223372036605562634L;

    // 抵扣券编号
	private Long id;
	// 抵用券类别
	private String type;
	// 金额
	private Long money;
	// 数量
	private Integer couponCount;
	// 有效期至
	private Date validTime;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CouponDO () {}

    public CouponDO (Long id, String type, Long money, Integer couponCount, Date validTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.type = type;
		this.money = money;
		this.couponCount = couponCount;
		this.validTime = validTime;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "CouponDO {" +
                "id = " + id + 
				", type = " + type + 
				", money = " + money + 
				", couponCount = " + couponCount + 
				", validTime = " + validTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
