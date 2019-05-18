package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserCouponRecordQuery查询对象类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserCouponRecordQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036245028443L;

    //t_coupon_record表的字段对应的属性
	// 抵扣券使用记录编号
	private Long couponRecordId;
	// 抵扣券使用记录编号（最小值）
	private Long couponRecordIdMin;
	// 抵扣券使用记录编号（最大值）
	private Long couponRecordIdMax;
	// 用户编号
	private Long couponRecordUserId;
	// 用户编号（最小值）
	private Long couponRecordUserIdMin;
	// 用户编号（最大值）
	private Long couponRecordUserIdMax;
	// 抵扣券编号
	private Long couponRecordCouponId;
	// 抵扣券编号（最小值）
	private Long couponRecordCouponIdMin;
	// 抵扣券编号（最大值）
	private Long couponRecordCouponIdMax;
	// 原价
	private Long couponRecordOldPrice;
	// 原价（最小值）
	private Long couponRecordOldPriceMin;
	// 原价（最大值）
	private Long couponRecordOldPriceMax;
	// 优惠价
	private Long couponRecordCouponPrice;
	// 优惠价（最小值）
	private Long couponRecordCouponPriceMin;
	// 优惠价（最大值）
	private Long couponRecordCouponPriceMax;
	// 价格
	private Long couponRecordPrice;
	// 价格（最小值）
	private Long couponRecordPriceMin;
	// 价格（最大值）
	private Long couponRecordPriceMax;
	// 版本号
	private Integer couponRecordVersion;
	// 版本号（最小值）
	private Integer couponRecordVersionMin;
	// 版本号（最大值）
	private Integer couponRecordVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponRecordCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponRecordCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponRecordCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponRecordUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponRecordUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponRecordUpdateTimeMax;
	// 是否激活
	private Byte couponRecordIsActive;
	// 是否激活（最小值）
	private Byte couponRecordIsActiveMin;
	// 是否激活（最大值）
	private Byte couponRecordIsActiveMax;
	//t_coupon表的字段对应的属性
	// 抵用券类别
	private String couponType;
	// 金额
	private Long couponMoney;
	// 金额（最小值）
	private Long couponMoneyMin;
	// 金额（最大值）
	private Long couponMoneyMax;
	
    public UserCouponRecordQuery () {}

    public UserCouponRecordQuery (Long couponRecordId, Long couponRecordIdMin, Long couponRecordIdMax, Long couponRecordUserId, Long couponRecordUserIdMin, Long couponRecordUserIdMax, Long couponRecordCouponId, Long couponRecordCouponIdMin, Long couponRecordCouponIdMax, Long couponRecordOldPrice, Long couponRecordOldPriceMin, Long couponRecordOldPriceMax, Long couponRecordCouponPrice, Long couponRecordCouponPriceMin, Long couponRecordCouponPriceMax, Long couponRecordPrice, Long couponRecordPriceMin, Long couponRecordPriceMax, Integer couponRecordVersion, Integer couponRecordVersionMin, Integer couponRecordVersionMax, Date couponRecordCreateTime, Date couponRecordCreateTimeMin, Date couponRecordCreateTimeMax, Date couponRecordUpdateTime, Date couponRecordUpdateTimeMin, Date couponRecordUpdateTimeMax, Byte couponRecordIsActive, Byte couponRecordIsActiveMin, Byte couponRecordIsActiveMax, String couponType, Long couponMoney, Long couponMoneyMin, Long couponMoneyMax) {
        this.couponRecordId = couponRecordId;
		this.couponRecordIdMin = couponRecordIdMin;
		this.couponRecordIdMax = couponRecordIdMax;
		this.couponRecordUserId = couponRecordUserId;
		this.couponRecordUserIdMin = couponRecordUserIdMin;
		this.couponRecordUserIdMax = couponRecordUserIdMax;
		this.couponRecordCouponId = couponRecordCouponId;
		this.couponRecordCouponIdMin = couponRecordCouponIdMin;
		this.couponRecordCouponIdMax = couponRecordCouponIdMax;
		this.couponRecordOldPrice = couponRecordOldPrice;
		this.couponRecordOldPriceMin = couponRecordOldPriceMin;
		this.couponRecordOldPriceMax = couponRecordOldPriceMax;
		this.couponRecordCouponPrice = couponRecordCouponPrice;
		this.couponRecordCouponPriceMin = couponRecordCouponPriceMin;
		this.couponRecordCouponPriceMax = couponRecordCouponPriceMax;
		this.couponRecordPrice = couponRecordPrice;
		this.couponRecordPriceMin = couponRecordPriceMin;
		this.couponRecordPriceMax = couponRecordPriceMax;
		this.couponRecordVersion = couponRecordVersion;
		this.couponRecordVersionMin = couponRecordVersionMin;
		this.couponRecordVersionMax = couponRecordVersionMax;
		this.couponRecordCreateTime = couponRecordCreateTime;
		this.couponRecordCreateTimeMin = couponRecordCreateTimeMin;
		this.couponRecordCreateTimeMax = couponRecordCreateTimeMax;
		this.couponRecordUpdateTime = couponRecordUpdateTime;
		this.couponRecordUpdateTimeMin = couponRecordUpdateTimeMin;
		this.couponRecordUpdateTimeMax = couponRecordUpdateTimeMax;
		this.couponRecordIsActive = couponRecordIsActive;
		this.couponRecordIsActiveMin = couponRecordIsActiveMin;
		this.couponRecordIsActiveMax = couponRecordIsActiveMax;
		this.couponType = couponType;
		this.couponMoney = couponMoney;
		this.couponMoneyMin = couponMoneyMin;
		this.couponMoneyMax = couponMoneyMax;
		
    }

    public Long getCouponRecordId() {
		return couponRecordId;
	}

	public void setCouponRecordId(Long couponRecordId) {
		this.couponRecordId = couponRecordId;
	}

	public Long getCouponRecordIdMin() {
		return couponRecordIdMin;
	}

	public void setCouponRecordIdMin(Long couponRecordIdMin) {
		this.couponRecordIdMin = couponRecordIdMin;
	}

	public Long getCouponRecordIdMax() {
		return couponRecordIdMax;
	}

	public void setCouponRecordIdMax(Long couponRecordIdMax) {
		this.couponRecordIdMax = couponRecordIdMax;
	}

	public Long getCouponRecordUserId() {
		return couponRecordUserId;
	}

	public void setCouponRecordUserId(Long couponRecordUserId) {
		this.couponRecordUserId = couponRecordUserId;
	}

	public Long getCouponRecordUserIdMin() {
		return couponRecordUserIdMin;
	}

	public void setCouponRecordUserIdMin(Long couponRecordUserIdMin) {
		this.couponRecordUserIdMin = couponRecordUserIdMin;
	}

	public Long getCouponRecordUserIdMax() {
		return couponRecordUserIdMax;
	}

	public void setCouponRecordUserIdMax(Long couponRecordUserIdMax) {
		this.couponRecordUserIdMax = couponRecordUserIdMax;
	}

	public Long getCouponRecordCouponId() {
		return couponRecordCouponId;
	}

	public void setCouponRecordCouponId(Long couponRecordCouponId) {
		this.couponRecordCouponId = couponRecordCouponId;
	}

	public Long getCouponRecordCouponIdMin() {
		return couponRecordCouponIdMin;
	}

	public void setCouponRecordCouponIdMin(Long couponRecordCouponIdMin) {
		this.couponRecordCouponIdMin = couponRecordCouponIdMin;
	}

	public Long getCouponRecordCouponIdMax() {
		return couponRecordCouponIdMax;
	}

	public void setCouponRecordCouponIdMax(Long couponRecordCouponIdMax) {
		this.couponRecordCouponIdMax = couponRecordCouponIdMax;
	}

	public Long getCouponRecordOldPrice() {
		return couponRecordOldPrice;
	}

	public void setCouponRecordOldPrice(Long couponRecordOldPrice) {
		this.couponRecordOldPrice = couponRecordOldPrice;
	}

	public Long getCouponRecordOldPriceMin() {
		return couponRecordOldPriceMin;
	}

	public void setCouponRecordOldPriceMin(Long couponRecordOldPriceMin) {
		this.couponRecordOldPriceMin = couponRecordOldPriceMin;
	}

	public Long getCouponRecordOldPriceMax() {
		return couponRecordOldPriceMax;
	}

	public void setCouponRecordOldPriceMax(Long couponRecordOldPriceMax) {
		this.couponRecordOldPriceMax = couponRecordOldPriceMax;
	}

	public Long getCouponRecordCouponPrice() {
		return couponRecordCouponPrice;
	}

	public void setCouponRecordCouponPrice(Long couponRecordCouponPrice) {
		this.couponRecordCouponPrice = couponRecordCouponPrice;
	}

	public Long getCouponRecordCouponPriceMin() {
		return couponRecordCouponPriceMin;
	}

	public void setCouponRecordCouponPriceMin(Long couponRecordCouponPriceMin) {
		this.couponRecordCouponPriceMin = couponRecordCouponPriceMin;
	}

	public Long getCouponRecordCouponPriceMax() {
		return couponRecordCouponPriceMax;
	}

	public void setCouponRecordCouponPriceMax(Long couponRecordCouponPriceMax) {
		this.couponRecordCouponPriceMax = couponRecordCouponPriceMax;
	}

	public Long getCouponRecordPrice() {
		return couponRecordPrice;
	}

	public void setCouponRecordPrice(Long couponRecordPrice) {
		this.couponRecordPrice = couponRecordPrice;
	}

	public Long getCouponRecordPriceMin() {
		return couponRecordPriceMin;
	}

	public void setCouponRecordPriceMin(Long couponRecordPriceMin) {
		this.couponRecordPriceMin = couponRecordPriceMin;
	}

	public Long getCouponRecordPriceMax() {
		return couponRecordPriceMax;
	}

	public void setCouponRecordPriceMax(Long couponRecordPriceMax) {
		this.couponRecordPriceMax = couponRecordPriceMax;
	}

	public Integer getCouponRecordVersion() {
		return couponRecordVersion;
	}

	public void setCouponRecordVersion(Integer couponRecordVersion) {
		this.couponRecordVersion = couponRecordVersion;
	}

	public Integer getCouponRecordVersionMin() {
		return couponRecordVersionMin;
	}

	public void setCouponRecordVersionMin(Integer couponRecordVersionMin) {
		this.couponRecordVersionMin = couponRecordVersionMin;
	}

	public Integer getCouponRecordVersionMax() {
		return couponRecordVersionMax;
	}

	public void setCouponRecordVersionMax(Integer couponRecordVersionMax) {
		this.couponRecordVersionMax = couponRecordVersionMax;
	}

	public Date getCouponRecordCreateTime() {
		return couponRecordCreateTime;
	}

	public void setCouponRecordCreateTime(Date couponRecordCreateTime) {
		this.couponRecordCreateTime = couponRecordCreateTime;
	}

	public Date getCouponRecordCreateTimeMin() {
		return couponRecordCreateTimeMin;
	}

	public void setCouponRecordCreateTimeMin(Date couponRecordCreateTimeMin) {
		this.couponRecordCreateTimeMin = couponRecordCreateTimeMin;
	}

	public Date getCouponRecordCreateTimeMax() {
		return couponRecordCreateTimeMax;
	}

	public void setCouponRecordCreateTimeMax(Date couponRecordCreateTimeMax) {
		this.couponRecordCreateTimeMax = couponRecordCreateTimeMax;
	}

	public Date getCouponRecordUpdateTime() {
		return couponRecordUpdateTime;
	}

	public void setCouponRecordUpdateTime(Date couponRecordUpdateTime) {
		this.couponRecordUpdateTime = couponRecordUpdateTime;
	}

	public Date getCouponRecordUpdateTimeMin() {
		return couponRecordUpdateTimeMin;
	}

	public void setCouponRecordUpdateTimeMin(Date couponRecordUpdateTimeMin) {
		this.couponRecordUpdateTimeMin = couponRecordUpdateTimeMin;
	}

	public Date getCouponRecordUpdateTimeMax() {
		return couponRecordUpdateTimeMax;
	}

	public void setCouponRecordUpdateTimeMax(Date couponRecordUpdateTimeMax) {
		this.couponRecordUpdateTimeMax = couponRecordUpdateTimeMax;
	}

	public Byte getCouponRecordIsActive() {
		return couponRecordIsActive;
	}

	public void setCouponRecordIsActive(Byte couponRecordIsActive) {
		this.couponRecordIsActive = couponRecordIsActive;
	}

	public Byte getCouponRecordIsActiveMin() {
		return couponRecordIsActiveMin;
	}

	public void setCouponRecordIsActiveMin(Byte couponRecordIsActiveMin) {
		this.couponRecordIsActiveMin = couponRecordIsActiveMin;
	}

	public Byte getCouponRecordIsActiveMax() {
		return couponRecordIsActiveMax;
	}

	public void setCouponRecordIsActiveMax(Byte couponRecordIsActiveMax) {
		this.couponRecordIsActiveMax = couponRecordIsActiveMax;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public Long getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(Long couponMoney) {
		this.couponMoney = couponMoney;
	}

	public Long getCouponMoneyMin() {
		return couponMoneyMin;
	}

	public void setCouponMoneyMin(Long couponMoneyMin) {
		this.couponMoneyMin = couponMoneyMin;
	}

	public Long getCouponMoneyMax() {
		return couponMoneyMax;
	}

	public void setCouponMoneyMax(Long couponMoneyMax) {
		this.couponMoneyMax = couponMoneyMax;
	}

	
    @Override
    public String toString() {
        return "UserCouponRecordQuery {" +
                "couponRecordId = " + couponRecordId + 
				", couponRecordIdMin = " + couponRecordIdMin + 
				", couponRecordIdMax = " + couponRecordIdMax + 
				", couponRecordUserId = " + couponRecordUserId + 
				", couponRecordUserIdMin = " + couponRecordUserIdMin + 
				", couponRecordUserIdMax = " + couponRecordUserIdMax + 
				", couponRecordCouponId = " + couponRecordCouponId + 
				", couponRecordCouponIdMin = " + couponRecordCouponIdMin + 
				", couponRecordCouponIdMax = " + couponRecordCouponIdMax + 
				", couponRecordOldPrice = " + couponRecordOldPrice + 
				", couponRecordOldPriceMin = " + couponRecordOldPriceMin + 
				", couponRecordOldPriceMax = " + couponRecordOldPriceMax + 
				", couponRecordCouponPrice = " + couponRecordCouponPrice + 
				", couponRecordCouponPriceMin = " + couponRecordCouponPriceMin + 
				", couponRecordCouponPriceMax = " + couponRecordCouponPriceMax + 
				", couponRecordPrice = " + couponRecordPrice + 
				", couponRecordPriceMin = " + couponRecordPriceMin + 
				", couponRecordPriceMax = " + couponRecordPriceMax + 
				", couponRecordVersion = " + couponRecordVersion + 
				", couponRecordVersionMin = " + couponRecordVersionMin + 
				", couponRecordVersionMax = " + couponRecordVersionMax + 
				", couponRecordCreateTime = " + couponRecordCreateTime + 
				", couponRecordCreateTimeMin = " + couponRecordCreateTimeMin + 
				", couponRecordCreateTimeMax = " + couponRecordCreateTimeMax + 
				", couponRecordUpdateTime = " + couponRecordUpdateTime + 
				", couponRecordUpdateTimeMin = " + couponRecordUpdateTimeMin + 
				", couponRecordUpdateTimeMax = " + couponRecordUpdateTimeMax + 
				", couponRecordIsActive = " + couponRecordIsActive + 
				", couponRecordIsActiveMin = " + couponRecordIsActiveMin + 
				", couponRecordIsActiveMax = " + couponRecordIsActiveMax + 
				", couponType = " + couponType + 
				", couponMoney = " + couponMoney + 
				", couponMoneyMin = " + couponMoneyMin + 
				", couponMoneyMax = " + couponMoneyMax + 
				" }";
    }

}
