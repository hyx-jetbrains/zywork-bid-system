package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserCouponDTO数据传输对象类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserUserCouponDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372034739218588L;

    //t_user_coupon表的字段对应的属性
	// 用户抵扣券编号
	private Long userCouponId;
	// 用户编号
	private Long userCouponUserId;
	// 抵扣券编号
	private Long userCouponCouponId;
	// 使用状态
	private Integer userCouponUseStatus;
	// 版本号
	private Integer userCouponVersion;
	// 创建时间
	private Date userCouponCreateTime;
	// 更新时间
	private Date userCouponUpdateTime;
	// 是否激活
	private Byte userCouponIsActive;
	//t_coupon表的字段对应的属性
	// 抵用券类别
	private String couponType;
	// 金额
	private Long couponMoney;
	// 有效期至
	private Date couponValidTime;
	
    public UserUserCouponDTO () {}

    public UserUserCouponDTO (Long userCouponId, Long userCouponUserId, Long userCouponCouponId, Integer userCouponUseStatus, Integer userCouponVersion, Date userCouponCreateTime, Date userCouponUpdateTime, Byte userCouponIsActive, String couponType, Long couponMoney, Date couponValidTime) {
        this.userCouponId = userCouponId;
		this.userCouponUserId = userCouponUserId;
		this.userCouponCouponId = userCouponCouponId;
		this.userCouponUseStatus = userCouponUseStatus;
		this.userCouponVersion = userCouponVersion;
		this.userCouponCreateTime = userCouponCreateTime;
		this.userCouponUpdateTime = userCouponUpdateTime;
		this.userCouponIsActive = userCouponIsActive;
		this.couponType = couponType;
		this.couponMoney = couponMoney;
		this.couponValidTime = couponValidTime;
		
    }

    public Long getUserCouponId() {
		return userCouponId;
	}

	public void setUserCouponId(Long userCouponId) {
		this.userCouponId = userCouponId;
	}

	public Long getUserCouponUserId() {
		return userCouponUserId;
	}

	public void setUserCouponUserId(Long userCouponUserId) {
		this.userCouponUserId = userCouponUserId;
	}

	public Long getUserCouponCouponId() {
		return userCouponCouponId;
	}

	public void setUserCouponCouponId(Long userCouponCouponId) {
		this.userCouponCouponId = userCouponCouponId;
	}

	public Integer getUserCouponUseStatus() {
		return userCouponUseStatus;
	}

	public void setUserCouponUseStatus(Integer userCouponUseStatus) {
		this.userCouponUseStatus = userCouponUseStatus;
	}

	public Integer getUserCouponVersion() {
		return userCouponVersion;
	}

	public void setUserCouponVersion(Integer userCouponVersion) {
		this.userCouponVersion = userCouponVersion;
	}

	public Date getUserCouponCreateTime() {
		return userCouponCreateTime;
	}

	public void setUserCouponCreateTime(Date userCouponCreateTime) {
		this.userCouponCreateTime = userCouponCreateTime;
	}

	public Date getUserCouponUpdateTime() {
		return userCouponUpdateTime;
	}

	public void setUserCouponUpdateTime(Date userCouponUpdateTime) {
		this.userCouponUpdateTime = userCouponUpdateTime;
	}

	public Byte getUserCouponIsActive() {
		return userCouponIsActive;
	}

	public void setUserCouponIsActive(Byte userCouponIsActive) {
		this.userCouponIsActive = userCouponIsActive;
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

	public Date getCouponValidTime() {
		return couponValidTime;
	}

	public void setCouponValidTime(Date couponValidTime) {
		this.couponValidTime = couponValidTime;
	}

	
    @Override
    public String toString() {
        return "UserUserCouponDTO {" +
                "userCouponId = " + userCouponId + 
				", userCouponUserId = " + userCouponUserId + 
				", userCouponCouponId = " + userCouponCouponId + 
				", userCouponUseStatus = " + userCouponUseStatus + 
				", userCouponVersion = " + userCouponVersion + 
				", userCouponCreateTime = " + userCouponCreateTime + 
				", userCouponUpdateTime = " + userCouponUpdateTime + 
				", userCouponIsActive = " + userCouponIsActive + 
				", couponType = " + couponType + 
				", couponMoney = " + couponMoney + 
				", couponValidTime = " + couponValidTime + 
				" }";
    }

}
