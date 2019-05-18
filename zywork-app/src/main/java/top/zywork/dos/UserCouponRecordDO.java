package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserCouponRecordDO数据对象实体类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserCouponRecordDO extends BaseDO {

    private static final long serialVersionUID = -9223372035968856045L;

    //t_coupon_record表的字段对应的属性
	// 抵扣券使用记录编号
	private Long couponRecordId;
	// 用户编号
	private Long couponRecordUserId;
	// 抵扣券编号
	private Long couponRecordCouponId;
	// 原价
	private Long couponRecordOldPrice;
	// 优惠价
	private Long couponRecordCouponPrice;
	// 价格
	private Long couponRecordPrice;
	// 版本号
	private Integer couponRecordVersion;
	// 创建时间
	private Date couponRecordCreateTime;
	// 更新时间
	private Date couponRecordUpdateTime;
	// 是否激活
	private Byte couponRecordIsActive;
	//t_coupon表的字段对应的属性
	// 抵用券类别
	private String couponType;
	// 金额
	private Long couponMoney;
	
    public UserCouponRecordDO () {}

    public UserCouponRecordDO (Long couponRecordId, Long couponRecordUserId, Long couponRecordCouponId, Long couponRecordOldPrice, Long couponRecordCouponPrice, Long couponRecordPrice, Integer couponRecordVersion, Date couponRecordCreateTime, Date couponRecordUpdateTime, Byte couponRecordIsActive, String couponType, Long couponMoney) {
        this.couponRecordId = couponRecordId;
		this.couponRecordUserId = couponRecordUserId;
		this.couponRecordCouponId = couponRecordCouponId;
		this.couponRecordOldPrice = couponRecordOldPrice;
		this.couponRecordCouponPrice = couponRecordCouponPrice;
		this.couponRecordPrice = couponRecordPrice;
		this.couponRecordVersion = couponRecordVersion;
		this.couponRecordCreateTime = couponRecordCreateTime;
		this.couponRecordUpdateTime = couponRecordUpdateTime;
		this.couponRecordIsActive = couponRecordIsActive;
		this.couponType = couponType;
		this.couponMoney = couponMoney;
		
    }

    public Long getCouponRecordId() {
		return couponRecordId;
	}

	public void setCouponRecordId(Long couponRecordId) {
		this.couponRecordId = couponRecordId;
	}

	public Long getCouponRecordUserId() {
		return couponRecordUserId;
	}

	public void setCouponRecordUserId(Long couponRecordUserId) {
		this.couponRecordUserId = couponRecordUserId;
	}

	public Long getCouponRecordCouponId() {
		return couponRecordCouponId;
	}

	public void setCouponRecordCouponId(Long couponRecordCouponId) {
		this.couponRecordCouponId = couponRecordCouponId;
	}

	public Long getCouponRecordOldPrice() {
		return couponRecordOldPrice;
	}

	public void setCouponRecordOldPrice(Long couponRecordOldPrice) {
		this.couponRecordOldPrice = couponRecordOldPrice;
	}

	public Long getCouponRecordCouponPrice() {
		return couponRecordCouponPrice;
	}

	public void setCouponRecordCouponPrice(Long couponRecordCouponPrice) {
		this.couponRecordCouponPrice = couponRecordCouponPrice;
	}

	public Long getCouponRecordPrice() {
		return couponRecordPrice;
	}

	public void setCouponRecordPrice(Long couponRecordPrice) {
		this.couponRecordPrice = couponRecordPrice;
	}

	public Integer getCouponRecordVersion() {
		return couponRecordVersion;
	}

	public void setCouponRecordVersion(Integer couponRecordVersion) {
		this.couponRecordVersion = couponRecordVersion;
	}

	public Date getCouponRecordCreateTime() {
		return couponRecordCreateTime;
	}

	public void setCouponRecordCreateTime(Date couponRecordCreateTime) {
		this.couponRecordCreateTime = couponRecordCreateTime;
	}

	public Date getCouponRecordUpdateTime() {
		return couponRecordUpdateTime;
	}

	public void setCouponRecordUpdateTime(Date couponRecordUpdateTime) {
		this.couponRecordUpdateTime = couponRecordUpdateTime;
	}

	public Byte getCouponRecordIsActive() {
		return couponRecordIsActive;
	}

	public void setCouponRecordIsActive(Byte couponRecordIsActive) {
		this.couponRecordIsActive = couponRecordIsActive;
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

	
    @Override
    public String toString() {
        return "UserCouponRecordDO {" +
                "couponRecordId = " + couponRecordId + 
				", couponRecordUserId = " + couponRecordUserId + 
				", couponRecordCouponId = " + couponRecordCouponId + 
				", couponRecordOldPrice = " + couponRecordOldPrice + 
				", couponRecordCouponPrice = " + couponRecordCouponPrice + 
				", couponRecordPrice = " + couponRecordPrice + 
				", couponRecordVersion = " + couponRecordVersion + 
				", couponRecordCreateTime = " + couponRecordCreateTime + 
				", couponRecordUpdateTime = " + couponRecordUpdateTime + 
				", couponRecordIsActive = " + couponRecordIsActive + 
				", couponType = " + couponType + 
				", couponMoney = " + couponMoney + 
				" }";
    }

}
