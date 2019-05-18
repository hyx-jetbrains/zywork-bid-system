package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserCouponQuery查询对象类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserUserCouponQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035837066209L;

    //t_user_coupon表的字段对应的属性
	// 用户抵扣券编号
	private Long userCouponId;
	// 用户抵扣券编号（最小值）
	private Long userCouponIdMin;
	// 用户抵扣券编号（最大值）
	private Long userCouponIdMax;
	// 用户编号
	private Long userCouponUserId;
	// 用户编号（最小值）
	private Long userCouponUserIdMin;
	// 用户编号（最大值）
	private Long userCouponUserIdMax;
	// 抵扣券编号
	private Long userCouponCouponId;
	// 抵扣券编号（最小值）
	private Long userCouponCouponIdMin;
	// 抵扣券编号（最大值）
	private Long userCouponCouponIdMax;
	// 使用状态
	private Integer userCouponUseStatus;
	// 使用状态（最小值）
	private Integer userCouponUseStatusMin;
	// 使用状态（最大值）
	private Integer userCouponUseStatusMax;
	// 版本号
	private Integer userCouponVersion;
	// 版本号（最小值）
	private Integer userCouponVersionMin;
	// 版本号（最大值）
	private Integer userCouponVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCouponCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCouponCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCouponCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCouponUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCouponUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCouponUpdateTimeMax;
	// 是否激活
	private Byte userCouponIsActive;
	// 是否激活（最小值）
	private Byte userCouponIsActiveMin;
	// 是否激活（最大值）
	private Byte userCouponIsActiveMax;
	//t_coupon表的字段对应的属性
	// 抵用券类别
	private String couponType;
	// 金额
	private Long couponMoney;
	// 金额（最小值）
	private Long couponMoneyMin;
	// 金额（最大值）
	private Long couponMoneyMax;
	// 有效期至
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponValidTime;
	// 有效期至（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponValidTimeMin;
	// 有效期至（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date couponValidTimeMax;
	
    public UserUserCouponQuery () {}

    public UserUserCouponQuery (Long userCouponId, Long userCouponIdMin, Long userCouponIdMax, Long userCouponUserId, Long userCouponUserIdMin, Long userCouponUserIdMax, Long userCouponCouponId, Long userCouponCouponIdMin, Long userCouponCouponIdMax, Integer userCouponUseStatus, Integer userCouponUseStatusMin, Integer userCouponUseStatusMax, Integer userCouponVersion, Integer userCouponVersionMin, Integer userCouponVersionMax, Date userCouponCreateTime, Date userCouponCreateTimeMin, Date userCouponCreateTimeMax, Date userCouponUpdateTime, Date userCouponUpdateTimeMin, Date userCouponUpdateTimeMax, Byte userCouponIsActive, Byte userCouponIsActiveMin, Byte userCouponIsActiveMax, String couponType, Long couponMoney, Long couponMoneyMin, Long couponMoneyMax, Date couponValidTime, Date couponValidTimeMin, Date couponValidTimeMax) {
        this.userCouponId = userCouponId;
		this.userCouponIdMin = userCouponIdMin;
		this.userCouponIdMax = userCouponIdMax;
		this.userCouponUserId = userCouponUserId;
		this.userCouponUserIdMin = userCouponUserIdMin;
		this.userCouponUserIdMax = userCouponUserIdMax;
		this.userCouponCouponId = userCouponCouponId;
		this.userCouponCouponIdMin = userCouponCouponIdMin;
		this.userCouponCouponIdMax = userCouponCouponIdMax;
		this.userCouponUseStatus = userCouponUseStatus;
		this.userCouponUseStatusMin = userCouponUseStatusMin;
		this.userCouponUseStatusMax = userCouponUseStatusMax;
		this.userCouponVersion = userCouponVersion;
		this.userCouponVersionMin = userCouponVersionMin;
		this.userCouponVersionMax = userCouponVersionMax;
		this.userCouponCreateTime = userCouponCreateTime;
		this.userCouponCreateTimeMin = userCouponCreateTimeMin;
		this.userCouponCreateTimeMax = userCouponCreateTimeMax;
		this.userCouponUpdateTime = userCouponUpdateTime;
		this.userCouponUpdateTimeMin = userCouponUpdateTimeMin;
		this.userCouponUpdateTimeMax = userCouponUpdateTimeMax;
		this.userCouponIsActive = userCouponIsActive;
		this.userCouponIsActiveMin = userCouponIsActiveMin;
		this.userCouponIsActiveMax = userCouponIsActiveMax;
		this.couponType = couponType;
		this.couponMoney = couponMoney;
		this.couponMoneyMin = couponMoneyMin;
		this.couponMoneyMax = couponMoneyMax;
		this.couponValidTime = couponValidTime;
		this.couponValidTimeMin = couponValidTimeMin;
		this.couponValidTimeMax = couponValidTimeMax;
		
    }

    public Long getUserCouponId() {
		return userCouponId;
	}

	public void setUserCouponId(Long userCouponId) {
		this.userCouponId = userCouponId;
	}

	public Long getUserCouponIdMin() {
		return userCouponIdMin;
	}

	public void setUserCouponIdMin(Long userCouponIdMin) {
		this.userCouponIdMin = userCouponIdMin;
	}

	public Long getUserCouponIdMax() {
		return userCouponIdMax;
	}

	public void setUserCouponIdMax(Long userCouponIdMax) {
		this.userCouponIdMax = userCouponIdMax;
	}

	public Long getUserCouponUserId() {
		return userCouponUserId;
	}

	public void setUserCouponUserId(Long userCouponUserId) {
		this.userCouponUserId = userCouponUserId;
	}

	public Long getUserCouponUserIdMin() {
		return userCouponUserIdMin;
	}

	public void setUserCouponUserIdMin(Long userCouponUserIdMin) {
		this.userCouponUserIdMin = userCouponUserIdMin;
	}

	public Long getUserCouponUserIdMax() {
		return userCouponUserIdMax;
	}

	public void setUserCouponUserIdMax(Long userCouponUserIdMax) {
		this.userCouponUserIdMax = userCouponUserIdMax;
	}

	public Long getUserCouponCouponId() {
		return userCouponCouponId;
	}

	public void setUserCouponCouponId(Long userCouponCouponId) {
		this.userCouponCouponId = userCouponCouponId;
	}

	public Long getUserCouponCouponIdMin() {
		return userCouponCouponIdMin;
	}

	public void setUserCouponCouponIdMin(Long userCouponCouponIdMin) {
		this.userCouponCouponIdMin = userCouponCouponIdMin;
	}

	public Long getUserCouponCouponIdMax() {
		return userCouponCouponIdMax;
	}

	public void setUserCouponCouponIdMax(Long userCouponCouponIdMax) {
		this.userCouponCouponIdMax = userCouponCouponIdMax;
	}

	public Integer getUserCouponUseStatus() {
		return userCouponUseStatus;
	}

	public void setUserCouponUseStatus(Integer userCouponUseStatus) {
		this.userCouponUseStatus = userCouponUseStatus;
	}

	public Integer getUserCouponUseStatusMin() {
		return userCouponUseStatusMin;
	}

	public void setUserCouponUseStatusMin(Integer userCouponUseStatusMin) {
		this.userCouponUseStatusMin = userCouponUseStatusMin;
	}

	public Integer getUserCouponUseStatusMax() {
		return userCouponUseStatusMax;
	}

	public void setUserCouponUseStatusMax(Integer userCouponUseStatusMax) {
		this.userCouponUseStatusMax = userCouponUseStatusMax;
	}

	public Integer getUserCouponVersion() {
		return userCouponVersion;
	}

	public void setUserCouponVersion(Integer userCouponVersion) {
		this.userCouponVersion = userCouponVersion;
	}

	public Integer getUserCouponVersionMin() {
		return userCouponVersionMin;
	}

	public void setUserCouponVersionMin(Integer userCouponVersionMin) {
		this.userCouponVersionMin = userCouponVersionMin;
	}

	public Integer getUserCouponVersionMax() {
		return userCouponVersionMax;
	}

	public void setUserCouponVersionMax(Integer userCouponVersionMax) {
		this.userCouponVersionMax = userCouponVersionMax;
	}

	public Date getUserCouponCreateTime() {
		return userCouponCreateTime;
	}

	public void setUserCouponCreateTime(Date userCouponCreateTime) {
		this.userCouponCreateTime = userCouponCreateTime;
	}

	public Date getUserCouponCreateTimeMin() {
		return userCouponCreateTimeMin;
	}

	public void setUserCouponCreateTimeMin(Date userCouponCreateTimeMin) {
		this.userCouponCreateTimeMin = userCouponCreateTimeMin;
	}

	public Date getUserCouponCreateTimeMax() {
		return userCouponCreateTimeMax;
	}

	public void setUserCouponCreateTimeMax(Date userCouponCreateTimeMax) {
		this.userCouponCreateTimeMax = userCouponCreateTimeMax;
	}

	public Date getUserCouponUpdateTime() {
		return userCouponUpdateTime;
	}

	public void setUserCouponUpdateTime(Date userCouponUpdateTime) {
		this.userCouponUpdateTime = userCouponUpdateTime;
	}

	public Date getUserCouponUpdateTimeMin() {
		return userCouponUpdateTimeMin;
	}

	public void setUserCouponUpdateTimeMin(Date userCouponUpdateTimeMin) {
		this.userCouponUpdateTimeMin = userCouponUpdateTimeMin;
	}

	public Date getUserCouponUpdateTimeMax() {
		return userCouponUpdateTimeMax;
	}

	public void setUserCouponUpdateTimeMax(Date userCouponUpdateTimeMax) {
		this.userCouponUpdateTimeMax = userCouponUpdateTimeMax;
	}

	public Byte getUserCouponIsActive() {
		return userCouponIsActive;
	}

	public void setUserCouponIsActive(Byte userCouponIsActive) {
		this.userCouponIsActive = userCouponIsActive;
	}

	public Byte getUserCouponIsActiveMin() {
		return userCouponIsActiveMin;
	}

	public void setUserCouponIsActiveMin(Byte userCouponIsActiveMin) {
		this.userCouponIsActiveMin = userCouponIsActiveMin;
	}

	public Byte getUserCouponIsActiveMax() {
		return userCouponIsActiveMax;
	}

	public void setUserCouponIsActiveMax(Byte userCouponIsActiveMax) {
		this.userCouponIsActiveMax = userCouponIsActiveMax;
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

	public Date getCouponValidTime() {
		return couponValidTime;
	}

	public void setCouponValidTime(Date couponValidTime) {
		this.couponValidTime = couponValidTime;
	}

	public Date getCouponValidTimeMin() {
		return couponValidTimeMin;
	}

	public void setCouponValidTimeMin(Date couponValidTimeMin) {
		this.couponValidTimeMin = couponValidTimeMin;
	}

	public Date getCouponValidTimeMax() {
		return couponValidTimeMax;
	}

	public void setCouponValidTimeMax(Date couponValidTimeMax) {
		this.couponValidTimeMax = couponValidTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserUserCouponQuery {" +
                "userCouponId = " + userCouponId + 
				", userCouponIdMin = " + userCouponIdMin + 
				", userCouponIdMax = " + userCouponIdMax + 
				", userCouponUserId = " + userCouponUserId + 
				", userCouponUserIdMin = " + userCouponUserIdMin + 
				", userCouponUserIdMax = " + userCouponUserIdMax + 
				", userCouponCouponId = " + userCouponCouponId + 
				", userCouponCouponIdMin = " + userCouponCouponIdMin + 
				", userCouponCouponIdMax = " + userCouponCouponIdMax + 
				", userCouponUseStatus = " + userCouponUseStatus + 
				", userCouponUseStatusMin = " + userCouponUseStatusMin + 
				", userCouponUseStatusMax = " + userCouponUseStatusMax + 
				", userCouponVersion = " + userCouponVersion + 
				", userCouponVersionMin = " + userCouponVersionMin + 
				", userCouponVersionMax = " + userCouponVersionMax + 
				", userCouponCreateTime = " + userCouponCreateTime + 
				", userCouponCreateTimeMin = " + userCouponCreateTimeMin + 
				", userCouponCreateTimeMax = " + userCouponCreateTimeMax + 
				", userCouponUpdateTime = " + userCouponUpdateTime + 
				", userCouponUpdateTimeMin = " + userCouponUpdateTimeMin + 
				", userCouponUpdateTimeMax = " + userCouponUpdateTimeMax + 
				", userCouponIsActive = " + userCouponIsActive + 
				", userCouponIsActiveMin = " + userCouponIsActiveMin + 
				", userCouponIsActiveMax = " + userCouponIsActiveMax + 
				", couponType = " + couponType + 
				", couponMoney = " + couponMoney + 
				", couponMoneyMin = " + couponMoneyMin + 
				", couponMoneyMax = " + couponMoneyMax + 
				", couponValidTime = " + couponValidTime + 
				", couponValidTimeMin = " + couponValidTimeMin + 
				", couponValidTimeMax = " + couponValidTimeMax + 
				" }";
    }

}
