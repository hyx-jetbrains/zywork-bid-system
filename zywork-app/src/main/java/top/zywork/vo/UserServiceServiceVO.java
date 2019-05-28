package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserServiceServiceVO值对象类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserServiceServiceVO extends BaseVO {

    private static final long serialVersionUID = -9223372036600958805L;

    //t_user_service表的字段对应的属性
	// 用户服务编号
	private Long userServiceId;
	// 用户编号
	private Long userServiceUserId;
	// 服务编号
	private Long userServiceServiceId;
	// 服务结束日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceEndDate;
	// 有效年
	private Integer userServiceValidYear;
	// 版本号
	private Integer userServiceVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceUpdateTime;
	// 是否激活
	private Byte userServiceIsActive;
	//t_service表的字段对应的属性
	// 服务标题
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String serviceTitle;
	// 详细说明
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String serviceMemo;
	// 所有收费的url
	@Size(min = 0, max = 2000, message = "必须小于2000个字符")
	private String serviceUrls;
	// 服务价格
	private Long servicePrice;
	
    public UserServiceServiceVO () {}

    public UserServiceServiceVO (Long userServiceId, Long userServiceUserId, Long userServiceServiceId, Date userServiceEndDate, Integer userServiceValidYear, Integer userServiceVersion, Date userServiceCreateTime, Date userServiceUpdateTime, Byte userServiceIsActive, String serviceTitle, String serviceMemo, String serviceUrls, Long servicePrice) {
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
        return "UserServiceServiceVO {" +
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
