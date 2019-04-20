package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CouponRecordDO数据对象实体类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CouponRecordDO extends BaseDO {

    private static final long serialVersionUID = -9223372036468265349L;

    // 抵扣券使用记录编号
	private Long id;
	// 用户编号
	private Long userId;
	// 抵扣券编号
	private Long couponId;
	// 原价
	private Long oldPrice;
	// 优惠价
	private Long couponPrice;
	// 价格
	private Long price;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CouponRecordDO () {}

    public CouponRecordDO (Long id, Long userId, Long couponId, Long oldPrice, Long couponPrice, Long price, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.couponId = couponId;
		this.oldPrice = oldPrice;
		this.couponPrice = couponPrice;
		this.price = price;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Long oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Long getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(Long couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
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
        return "CouponRecordDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", couponId = " + couponId + 
				", oldPrice = " + oldPrice + 
				", couponPrice = " + couponPrice + 
				", price = " + price + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
