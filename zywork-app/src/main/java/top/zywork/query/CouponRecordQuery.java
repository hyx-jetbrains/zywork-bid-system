package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CouponRecordQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CouponRecordQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035526258342L;

    // 抵扣券使用记录编号
	private Long id;
	// 抵扣券使用记录编号（最小值）
	private Long idMin;
	// 抵扣券使用记录编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 抵扣券编号
	private Long couponId;
	// 抵扣券编号（最小值）
	private Long couponIdMin;
	// 抵扣券编号（最大值）
	private Long couponIdMax;
	// 原价
	private Long oldPrice;
	// 原价（最小值）
	private Long oldPriceMin;
	// 原价（最大值）
	private Long oldPriceMax;
	// 优惠价
	private Long couponPrice;
	// 优惠价（最小值）
	private Long couponPriceMin;
	// 优惠价（最大值）
	private Long couponPriceMax;
	// 价格
	private Long price;
	// 价格（最小值）
	private Long priceMin;
	// 价格（最大值）
	private Long priceMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public CouponRecordQuery () {}

    public CouponRecordQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long couponId, Long couponIdMin, Long couponIdMax, Long oldPrice, Long oldPriceMin, Long oldPriceMax, Long couponPrice, Long couponPriceMin, Long couponPriceMax, Long price, Long priceMin, Long priceMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.couponId = couponId;
		this.couponIdMin = couponIdMin;
		this.couponIdMax = couponIdMax;
		this.oldPrice = oldPrice;
		this.oldPriceMin = oldPriceMin;
		this.oldPriceMax = oldPriceMax;
		this.couponPrice = couponPrice;
		this.couponPriceMin = couponPriceMin;
		this.couponPriceMax = couponPriceMax;
		this.price = price;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getCouponIdMin() {
		return couponIdMin;
	}

	public void setCouponIdMin(Long couponIdMin) {
		this.couponIdMin = couponIdMin;
	}

	public Long getCouponIdMax() {
		return couponIdMax;
	}

	public void setCouponIdMax(Long couponIdMax) {
		this.couponIdMax = couponIdMax;
	}

	public Long getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Long oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Long getOldPriceMin() {
		return oldPriceMin;
	}

	public void setOldPriceMin(Long oldPriceMin) {
		this.oldPriceMin = oldPriceMin;
	}

	public Long getOldPriceMax() {
		return oldPriceMax;
	}

	public void setOldPriceMax(Long oldPriceMax) {
		this.oldPriceMax = oldPriceMax;
	}

	public Long getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(Long couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Long getCouponPriceMin() {
		return couponPriceMin;
	}

	public void setCouponPriceMin(Long couponPriceMin) {
		this.couponPriceMin = couponPriceMin;
	}

	public Long getCouponPriceMax() {
		return couponPriceMax;
	}

	public void setCouponPriceMax(Long couponPriceMax) {
		this.couponPriceMax = couponPriceMax;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Long priceMin) {
		this.priceMin = priceMin;
	}

	public Long getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Long priceMax) {
		this.priceMax = priceMax;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "CouponRecordQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", couponId = " + couponId + 
				", couponIdMin = " + couponIdMin + 
				", couponIdMax = " + couponIdMax + 
				", oldPrice = " + oldPrice + 
				", oldPriceMin = " + oldPriceMin + 
				", oldPriceMax = " + oldPriceMax + 
				", couponPrice = " + couponPrice + 
				", couponPriceMin = " + couponPriceMin + 
				", couponPriceMax = " + couponPriceMax + 
				", price = " + price + 
				", priceMin = " + priceMin + 
				", priceMax = " + priceMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
