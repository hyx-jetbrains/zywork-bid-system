package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserServiceServiceDO数据对象实体类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserServiceServiceDO extends BaseDO {

    private static final long serialVersionUID = -9223372036277288066L;

    //t_user_service表的字段对应的属性
	// 用户服务编号
	private Long userServiceId;
	// 用户编号
	private Long userServiceUserId;
	// 服务编号
	private Long userServiceServiceId;
	// 服务结束日期
	private Date userServiceEndDate;
	// 有效年
	private Integer userServiceValidYear;
	// 版本号
	private Integer userServiceVersion;
	// 创建时间
	private Date userServiceCreateTime;
	// 更新时间
	private Date userServiceUpdateTime;
	// 是否激活
	private Byte userServiceIsActive;
	//t_service表的字段对应的属性
	// 服务标题
	private String serviceTitle;
	// 详细说明
	private String serviceMemo;
	// 所有收费的url
	private String serviceUrls;
	// 服务价格
	private Long servicePrice;
	
    public UserServiceServiceDO () {}

    public UserServiceServiceDO (Long userServiceId, Long userServiceUserId, Long userServiceServiceId, Date userServiceEndDate, Integer userServiceValidYear, Integer userServiceVersion, Date userServiceCreateTime, Date userServiceUpdateTime, Byte userServiceIsActive, String serviceTitle, String serviceMemo, String serviceUrls, Long servicePrice) {
        this.userServiceId = userServiceId;
		this.userServiceUserId = userServiceUserId;
		this.userServiceServiceId = userServiceServiceId;
		this.userServiceEndDate = userServiceEndDate;
		this.userServiceValidYear = userServiceValidYear;
		this.userServiceVersion = userServiceVersion;
		this.userServiceCreateTime = userServiceCreateTime;
		this.userServiceUpdateTime = userServiceUpdateTime;
		this.userServiceIsActive = userServiceIsActive;
		this.serviceTitle = serviceTitle;
		this.serviceMemo = serviceMemo;
		this.serviceUrls = serviceUrls;
		this.servicePrice = servicePrice;
		
    }

    public Long getUserServiceId() {
		return userServiceId;
	}

	public void setUserServiceId(Long userServiceId) {
		this.userServiceId = userServiceId;
	}

	public Long getUserServiceUserId() {
		return userServiceUserId;
	}

	public void setUserServiceUserId(Long userServiceUserId) {
		this.userServiceUserId = userServiceUserId;
	}

	public Long getUserServiceServiceId() {
		return userServiceServiceId;
	}

	public void setUserServiceServiceId(Long userServiceServiceId) {
		this.userServiceServiceId = userServiceServiceId;
	}

	public Date getUserServiceEndDate() {
		return userServiceEndDate;
	}

	public void setUserServiceEndDate(Date userServiceEndDate) {
		this.userServiceEndDate = userServiceEndDate;
	}

	public Integer getUserServiceValidYear() {
		return userServiceValidYear;
	}

	public void setUserServiceValidYear(Integer userServiceValidYear) {
		this.userServiceValidYear = userServiceValidYear;
	}

	public Integer getUserServiceVersion() {
		return userServiceVersion;
	}

	public void setUserServiceVersion(Integer userServiceVersion) {
		this.userServiceVersion = userServiceVersion;
	}

	public Date getUserServiceCreateTime() {
		return userServiceCreateTime;
	}

	public void setUserServiceCreateTime(Date userServiceCreateTime) {
		this.userServiceCreateTime = userServiceCreateTime;
	}

	public Date getUserServiceUpdateTime() {
		return userServiceUpdateTime;
	}

	public void setUserServiceUpdateTime(Date userServiceUpdateTime) {
		this.userServiceUpdateTime = userServiceUpdateTime;
	}

	public Byte getUserServiceIsActive() {
		return userServiceIsActive;
	}

	public void setUserServiceIsActive(Byte userServiceIsActive) {
		this.userServiceIsActive = userServiceIsActive;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public String getServiceMemo() {
		return serviceMemo;
	}

	public void setServiceMemo(String serviceMemo) {
		this.serviceMemo = serviceMemo;
	}

	public String getServiceUrls() {
		return serviceUrls;
	}

	public void setServiceUrls(String serviceUrls) {
		this.serviceUrls = serviceUrls;
	}

	public Long getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Long servicePrice) {
		this.servicePrice = servicePrice;
	}

	
    @Override
    public String toString() {
        return "UserServiceServiceDO {" +
                "userServiceId = " + userServiceId + 
				", userServiceUserId = " + userServiceUserId + 
				", userServiceServiceId = " + userServiceServiceId + 
				", userServiceEndDate = " + userServiceEndDate + 
				", userServiceValidYear = " + userServiceValidYear + 
				", userServiceVersion = " + userServiceVersion + 
				", userServiceCreateTime = " + userServiceCreateTime + 
				", userServiceUpdateTime = " + userServiceUpdateTime + 
				", userServiceIsActive = " + userServiceIsActive + 
				", serviceTitle = " + serviceTitle + 
				", serviceMemo = " + serviceMemo + 
				", serviceUrls = " + serviceUrls + 
				", servicePrice = " + servicePrice + 
				" }";
    }

}
