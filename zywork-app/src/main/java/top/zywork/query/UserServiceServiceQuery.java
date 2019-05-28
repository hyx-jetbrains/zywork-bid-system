package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserServiceServiceQuery查询对象类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserServiceServiceQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034794157663L;

    //t_user_service表的字段对应的属性
	// 用户服务编号
	private Long userServiceId;
	// 用户服务编号（最小值）
	private Long userServiceIdMin;
	// 用户服务编号（最大值）
	private Long userServiceIdMax;
	// 用户编号
	private Long userServiceUserId;
	// 用户编号（最小值）
	private Long userServiceUserIdMin;
	// 用户编号（最大值）
	private Long userServiceUserIdMax;
	// 服务编号
	private Long userServiceServiceId;
	// 服务编号（最小值）
	private Long userServiceServiceIdMin;
	// 服务编号（最大值）
	private Long userServiceServiceIdMax;
	// 服务结束日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceEndDate;
	// 服务结束日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceEndDateMin;
	// 服务结束日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceEndDateMax;
	// 有效年
	private Integer userServiceValidYear;
	// 有效年（最小值）
	private Integer userServiceValidYearMin;
	// 有效年（最大值）
	private Integer userServiceValidYearMax;
	// 版本号
	private Integer userServiceVersion;
	// 版本号（最小值）
	private Integer userServiceVersionMin;
	// 版本号（最大值）
	private Integer userServiceVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userServiceUpdateTimeMax;
	// 是否激活
	private Byte userServiceIsActive;
	// 是否激活（最小值）
	private Byte userServiceIsActiveMin;
	// 是否激活（最大值）
	private Byte userServiceIsActiveMax;
	//t_service表的字段对应的属性
	// 服务标题
	private String serviceTitle;
	// 详细说明
	private String serviceMemo;
	// 所有收费的url
	private String serviceUrls;
	// 服务价格
	private Long servicePrice;
	// 服务价格（最小值）
	private Long servicePriceMin;
	// 服务价格（最大值）
	private Long servicePriceMax;
	
    public UserServiceServiceQuery () {}

    public UserServiceServiceQuery (Long userServiceId, Long userServiceIdMin, Long userServiceIdMax, Long userServiceUserId, Long userServiceUserIdMin, Long userServiceUserIdMax, Long userServiceServiceId, Long userServiceServiceIdMin, Long userServiceServiceIdMax, Date userServiceEndDate, Date userServiceEndDateMin, Date userServiceEndDateMax, Integer userServiceValidYear, Integer userServiceValidYearMin, Integer userServiceValidYearMax, Integer userServiceVersion, Integer userServiceVersionMin, Integer userServiceVersionMax, Date userServiceCreateTime, Date userServiceCreateTimeMin, Date userServiceCreateTimeMax, Date userServiceUpdateTime, Date userServiceUpdateTimeMin, Date userServiceUpdateTimeMax, Byte userServiceIsActive, Byte userServiceIsActiveMin, Byte userServiceIsActiveMax, String serviceTitle, String serviceMemo, String serviceUrls, Long servicePrice, Long servicePriceMin, Long servicePriceMax) {
        this.userServiceId = userServiceId;
		this.userServiceIdMin = userServiceIdMin;
		this.userServiceIdMax = userServiceIdMax;
		this.userServiceUserId = userServiceUserId;
		this.userServiceUserIdMin = userServiceUserIdMin;
		this.userServiceUserIdMax = userServiceUserIdMax;
		this.userServiceServiceId = userServiceServiceId;
		this.userServiceServiceIdMin = userServiceServiceIdMin;
		this.userServiceServiceIdMax = userServiceServiceIdMax;
		this.userServiceEndDate = userServiceEndDate;
		this.userServiceEndDateMin = userServiceEndDateMin;
		this.userServiceEndDateMax = userServiceEndDateMax;
		this.userServiceValidYear = userServiceValidYear;
		this.userServiceValidYearMin = userServiceValidYearMin;
		this.userServiceValidYearMax = userServiceValidYearMax;
		this.userServiceVersion = userServiceVersion;
		this.userServiceVersionMin = userServiceVersionMin;
		this.userServiceVersionMax = userServiceVersionMax;
		this.userServiceCreateTime = userServiceCreateTime;
		this.userServiceCreateTimeMin = userServiceCreateTimeMin;
		this.userServiceCreateTimeMax = userServiceCreateTimeMax;
		this.userServiceUpdateTime = userServiceUpdateTime;
		this.userServiceUpdateTimeMin = userServiceUpdateTimeMin;
		this.userServiceUpdateTimeMax = userServiceUpdateTimeMax;
		this.userServiceIsActive = userServiceIsActive;
		this.userServiceIsActiveMin = userServiceIsActiveMin;
		this.userServiceIsActiveMax = userServiceIsActiveMax;
		this.serviceTitle = serviceTitle;
		this.serviceMemo = serviceMemo;
		this.serviceUrls = serviceUrls;
		this.servicePrice = servicePrice;
		this.servicePriceMin = servicePriceMin;
		this.servicePriceMax = servicePriceMax;
		
    }

    public Long getUserServiceId() {
		return userServiceId;
	}

	public void setUserServiceId(Long userServiceId) {
		this.userServiceId = userServiceId;
	}

	public Long getUserServiceIdMin() {
		return userServiceIdMin;
	}

	public void setUserServiceIdMin(Long userServiceIdMin) {
		this.userServiceIdMin = userServiceIdMin;
	}

	public Long getUserServiceIdMax() {
		return userServiceIdMax;
	}

	public void setUserServiceIdMax(Long userServiceIdMax) {
		this.userServiceIdMax = userServiceIdMax;
	}

	public Long getUserServiceUserId() {
		return userServiceUserId;
	}

	public void setUserServiceUserId(Long userServiceUserId) {
		this.userServiceUserId = userServiceUserId;
	}

	public Long getUserServiceUserIdMin() {
		return userServiceUserIdMin;
	}

	public void setUserServiceUserIdMin(Long userServiceUserIdMin) {
		this.userServiceUserIdMin = userServiceUserIdMin;
	}

	public Long getUserServiceUserIdMax() {
		return userServiceUserIdMax;
	}

	public void setUserServiceUserIdMax(Long userServiceUserIdMax) {
		this.userServiceUserIdMax = userServiceUserIdMax;
	}

	public Long getUserServiceServiceId() {
		return userServiceServiceId;
	}

	public void setUserServiceServiceId(Long userServiceServiceId) {
		this.userServiceServiceId = userServiceServiceId;
	}

	public Long getUserServiceServiceIdMin() {
		return userServiceServiceIdMin;
	}

	public void setUserServiceServiceIdMin(Long userServiceServiceIdMin) {
		this.userServiceServiceIdMin = userServiceServiceIdMin;
	}

	public Long getUserServiceServiceIdMax() {
		return userServiceServiceIdMax;
	}

	public void setUserServiceServiceIdMax(Long userServiceServiceIdMax) {
		this.userServiceServiceIdMax = userServiceServiceIdMax;
	}

	public Date getUserServiceEndDate() {
		return userServiceEndDate;
	}

	public void setUserServiceEndDate(Date userServiceEndDate) {
		this.userServiceEndDate = userServiceEndDate;
	}

	public Date getUserServiceEndDateMin() {
		return userServiceEndDateMin;
	}

	public void setUserServiceEndDateMin(Date userServiceEndDateMin) {
		this.userServiceEndDateMin = userServiceEndDateMin;
	}

	public Date getUserServiceEndDateMax() {
		return userServiceEndDateMax;
	}

	public void setUserServiceEndDateMax(Date userServiceEndDateMax) {
		this.userServiceEndDateMax = userServiceEndDateMax;
	}

	public Integer getUserServiceValidYear() {
		return userServiceValidYear;
	}

	public void setUserServiceValidYear(Integer userServiceValidYear) {
		this.userServiceValidYear = userServiceValidYear;
	}

	public Integer getUserServiceValidYearMin() {
		return userServiceValidYearMin;
	}

	public void setUserServiceValidYearMin(Integer userServiceValidYearMin) {
		this.userServiceValidYearMin = userServiceValidYearMin;
	}

	public Integer getUserServiceValidYearMax() {
		return userServiceValidYearMax;
	}

	public void setUserServiceValidYearMax(Integer userServiceValidYearMax) {
		this.userServiceValidYearMax = userServiceValidYearMax;
	}

	public Integer getUserServiceVersion() {
		return userServiceVersion;
	}

	public void setUserServiceVersion(Integer userServiceVersion) {
		this.userServiceVersion = userServiceVersion;
	}

	public Integer getUserServiceVersionMin() {
		return userServiceVersionMin;
	}

	public void setUserServiceVersionMin(Integer userServiceVersionMin) {
		this.userServiceVersionMin = userServiceVersionMin;
	}

	public Integer getUserServiceVersionMax() {
		return userServiceVersionMax;
	}

	public void setUserServiceVersionMax(Integer userServiceVersionMax) {
		this.userServiceVersionMax = userServiceVersionMax;
	}

	public Date getUserServiceCreateTime() {
		return userServiceCreateTime;
	}

	public void setUserServiceCreateTime(Date userServiceCreateTime) {
		this.userServiceCreateTime = userServiceCreateTime;
	}

	public Date getUserServiceCreateTimeMin() {
		return userServiceCreateTimeMin;
	}

	public void setUserServiceCreateTimeMin(Date userServiceCreateTimeMin) {
		this.userServiceCreateTimeMin = userServiceCreateTimeMin;
	}

	public Date getUserServiceCreateTimeMax() {
		return userServiceCreateTimeMax;
	}

	public void setUserServiceCreateTimeMax(Date userServiceCreateTimeMax) {
		this.userServiceCreateTimeMax = userServiceCreateTimeMax;
	}

	public Date getUserServiceUpdateTime() {
		return userServiceUpdateTime;
	}

	public void setUserServiceUpdateTime(Date userServiceUpdateTime) {
		this.userServiceUpdateTime = userServiceUpdateTime;
	}

	public Date getUserServiceUpdateTimeMin() {
		return userServiceUpdateTimeMin;
	}

	public void setUserServiceUpdateTimeMin(Date userServiceUpdateTimeMin) {
		this.userServiceUpdateTimeMin = userServiceUpdateTimeMin;
	}

	public Date getUserServiceUpdateTimeMax() {
		return userServiceUpdateTimeMax;
	}

	public void setUserServiceUpdateTimeMax(Date userServiceUpdateTimeMax) {
		this.userServiceUpdateTimeMax = userServiceUpdateTimeMax;
	}

	public Byte getUserServiceIsActive() {
		return userServiceIsActive;
	}

	public void setUserServiceIsActive(Byte userServiceIsActive) {
		this.userServiceIsActive = userServiceIsActive;
	}

	public Byte getUserServiceIsActiveMin() {
		return userServiceIsActiveMin;
	}

	public void setUserServiceIsActiveMin(Byte userServiceIsActiveMin) {
		this.userServiceIsActiveMin = userServiceIsActiveMin;
	}

	public Byte getUserServiceIsActiveMax() {
		return userServiceIsActiveMax;
	}

	public void setUserServiceIsActiveMax(Byte userServiceIsActiveMax) {
		this.userServiceIsActiveMax = userServiceIsActiveMax;
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

	public Long getServicePriceMin() {
		return servicePriceMin;
	}

	public void setServicePriceMin(Long servicePriceMin) {
		this.servicePriceMin = servicePriceMin;
	}

	public Long getServicePriceMax() {
		return servicePriceMax;
	}

	public void setServicePriceMax(Long servicePriceMax) {
		this.servicePriceMax = servicePriceMax;
	}

	
    @Override
    public String toString() {
        return "UserServiceServiceQuery {" +
                "userServiceId = " + userServiceId + 
				", userServiceIdMin = " + userServiceIdMin + 
				", userServiceIdMax = " + userServiceIdMax + 
				", userServiceUserId = " + userServiceUserId + 
				", userServiceUserIdMin = " + userServiceUserIdMin + 
				", userServiceUserIdMax = " + userServiceUserIdMax + 
				", userServiceServiceId = " + userServiceServiceId + 
				", userServiceServiceIdMin = " + userServiceServiceIdMin + 
				", userServiceServiceIdMax = " + userServiceServiceIdMax + 
				", userServiceEndDate = " + userServiceEndDate + 
				", userServiceEndDateMin = " + userServiceEndDateMin + 
				", userServiceEndDateMax = " + userServiceEndDateMax + 
				", userServiceValidYear = " + userServiceValidYear + 
				", userServiceValidYearMin = " + userServiceValidYearMin + 
				", userServiceValidYearMax = " + userServiceValidYearMax + 
				", userServiceVersion = " + userServiceVersion + 
				", userServiceVersionMin = " + userServiceVersionMin + 
				", userServiceVersionMax = " + userServiceVersionMax + 
				", userServiceCreateTime = " + userServiceCreateTime + 
				", userServiceCreateTimeMin = " + userServiceCreateTimeMin + 
				", userServiceCreateTimeMax = " + userServiceCreateTimeMax + 
				", userServiceUpdateTime = " + userServiceUpdateTime + 
				", userServiceUpdateTimeMin = " + userServiceUpdateTimeMin + 
				", userServiceUpdateTimeMax = " + userServiceUpdateTimeMax + 
				", userServiceIsActive = " + userServiceIsActive + 
				", userServiceIsActiveMin = " + userServiceIsActiveMin + 
				", userServiceIsActiveMax = " + userServiceIsActiveMax + 
				", serviceTitle = " + serviceTitle + 
				", serviceMemo = " + serviceMemo + 
				", serviceUrls = " + serviceUrls + 
				", servicePrice = " + servicePrice + 
				", servicePriceMin = " + servicePriceMin + 
				", servicePriceMax = " + servicePriceMax + 
				" }";
    }

}
