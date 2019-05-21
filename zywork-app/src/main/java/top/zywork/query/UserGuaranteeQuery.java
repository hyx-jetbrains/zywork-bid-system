package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserGuaranteeQuery查询对象类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserGuaranteeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034789141582L;

    //t_guarantee表的字段对应的属性
	// 保函编号
	private Long guaranteeId;
	// 保函编号（最小值）
	private Long guaranteeIdMin;
	// 保函编号（最大值）
	private Long guaranteeIdMax;
	// 项目编号
	private Long guaranteeProjectId;
	// 项目编号（最小值）
	private Long guaranteeProjectIdMin;
	// 项目编号（最大值）
	private Long guaranteeProjectIdMax;
	// 用户编号
	private Long guaranteeUserId;
	// 用户编号（最小值）
	private Long guaranteeUserIdMin;
	// 用户编号（最大值）
	private Long guaranteeUserIdMax;
	// 项目名称
	private String guaranteeProjectName;
	// 开标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeOpenMarkTime;
	// 开标时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeOpenMarkTimeMin;
	// 开标时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeOpenMarkTimeMax;
	// 招标单位名称
	private String guaranteeMarkUnitName;
	// 工期(天)
	private Integer guaranteeConstructionPeriod;
	// 工期(天)（最小值）
	private Integer guaranteeConstructionPeriodMin;
	// 工期(天)（最大值）
	private Integer guaranteeConstructionPeriodMax;
	// 担保金额(万元)
	private Long guaranteeAssurePrice;
	// 担保金额(万元)（最小值）
	private Long guaranteeAssurePriceMin;
	// 担保金额(万元)（最大值）
	private Long guaranteeAssurePriceMax;
	// 担保公司
	private String guaranteeGuaranteeComp;
	// 保函费(元)
	private Long guaranteeGuaranteePrice;
	// 保函费(元)（最小值）
	private Long guaranteeGuaranteePriceMin;
	// 保函费(元)（最大值）
	private Long guaranteeGuaranteePriceMax;
	// 申请人
	private String guaranteeApplicant;
	// 联系人
	private String guaranteeName;
	// 手机号
	private String guaranteePhone;
	// 地址
	private String guaranteeAddress;
	// 版本号
	private Integer guaranteeVersion;
	// 版本号（最小值）
	private Integer guaranteeVersionMin;
	// 版本号（最大值）
	private Integer guaranteeVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeUpdateTimeMax;
	// 是否激活
	private Byte guaranteeIsActive;
	// 是否激活（最小值）
	private Byte guaranteeIsActiveMin;
	// 是否激活（最大值）
	private Byte guaranteeIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	// 性别（最小值）
	private Byte userDetailGenderMin;
	// 性别（最大值）
	private Byte userDetailGenderMax;
	
    public UserGuaranteeQuery () {}

    public UserGuaranteeQuery (Long guaranteeId, Long guaranteeIdMin, Long guaranteeIdMax, Long guaranteeProjectId, Long guaranteeProjectIdMin, Long guaranteeProjectIdMax, Long guaranteeUserId, Long guaranteeUserIdMin, Long guaranteeUserIdMax, String guaranteeProjectName, Date guaranteeOpenMarkTime, Date guaranteeOpenMarkTimeMin, Date guaranteeOpenMarkTimeMax, String guaranteeMarkUnitName, Integer guaranteeConstructionPeriod, Integer guaranteeConstructionPeriodMin, Integer guaranteeConstructionPeriodMax, Long guaranteeAssurePrice, Long guaranteeAssurePriceMin, Long guaranteeAssurePriceMax, String guaranteeGuaranteeComp, Long guaranteeGuaranteePrice, Long guaranteeGuaranteePriceMin, Long guaranteeGuaranteePriceMax, String guaranteeApplicant, String guaranteeName, String guaranteePhone, String guaranteeAddress, Integer guaranteeVersion, Integer guaranteeVersionMin, Integer guaranteeVersionMax, Date guaranteeCreateTime, Date guaranteeCreateTimeMin, Date guaranteeCreateTimeMax, Date guaranteeUpdateTime, Date guaranteeUpdateTimeMin, Date guaranteeUpdateTimeMax, Byte guaranteeIsActive, Byte guaranteeIsActiveMin, Byte guaranteeIsActiveMax, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax) {
        this.guaranteeId = guaranteeId;
		this.guaranteeIdMin = guaranteeIdMin;
		this.guaranteeIdMax = guaranteeIdMax;
		this.guaranteeProjectId = guaranteeProjectId;
		this.guaranteeProjectIdMin = guaranteeProjectIdMin;
		this.guaranteeProjectIdMax = guaranteeProjectIdMax;
		this.guaranteeUserId = guaranteeUserId;
		this.guaranteeUserIdMin = guaranteeUserIdMin;
		this.guaranteeUserIdMax = guaranteeUserIdMax;
		this.guaranteeProjectName = guaranteeProjectName;
		this.guaranteeOpenMarkTime = guaranteeOpenMarkTime;
		this.guaranteeOpenMarkTimeMin = guaranteeOpenMarkTimeMin;
		this.guaranteeOpenMarkTimeMax = guaranteeOpenMarkTimeMax;
		this.guaranteeMarkUnitName = guaranteeMarkUnitName;
		this.guaranteeConstructionPeriod = guaranteeConstructionPeriod;
		this.guaranteeConstructionPeriodMin = guaranteeConstructionPeriodMin;
		this.guaranteeConstructionPeriodMax = guaranteeConstructionPeriodMax;
		this.guaranteeAssurePrice = guaranteeAssurePrice;
		this.guaranteeAssurePriceMin = guaranteeAssurePriceMin;
		this.guaranteeAssurePriceMax = guaranteeAssurePriceMax;
		this.guaranteeGuaranteeComp = guaranteeGuaranteeComp;
		this.guaranteeGuaranteePrice = guaranteeGuaranteePrice;
		this.guaranteeGuaranteePriceMin = guaranteeGuaranteePriceMin;
		this.guaranteeGuaranteePriceMax = guaranteeGuaranteePriceMax;
		this.guaranteeApplicant = guaranteeApplicant;
		this.guaranteeName = guaranteeName;
		this.guaranteePhone = guaranteePhone;
		this.guaranteeAddress = guaranteeAddress;
		this.guaranteeVersion = guaranteeVersion;
		this.guaranteeVersionMin = guaranteeVersionMin;
		this.guaranteeVersionMax = guaranteeVersionMax;
		this.guaranteeCreateTime = guaranteeCreateTime;
		this.guaranteeCreateTimeMin = guaranteeCreateTimeMin;
		this.guaranteeCreateTimeMax = guaranteeCreateTimeMax;
		this.guaranteeUpdateTime = guaranteeUpdateTime;
		this.guaranteeUpdateTimeMin = guaranteeUpdateTimeMin;
		this.guaranteeUpdateTimeMax = guaranteeUpdateTimeMax;
		this.guaranteeIsActive = guaranteeIsActive;
		this.guaranteeIsActiveMin = guaranteeIsActiveMin;
		this.guaranteeIsActiveMax = guaranteeIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		
    }

    public Long getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(Long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public Long getGuaranteeIdMin() {
		return guaranteeIdMin;
	}

	public void setGuaranteeIdMin(Long guaranteeIdMin) {
		this.guaranteeIdMin = guaranteeIdMin;
	}

	public Long getGuaranteeIdMax() {
		return guaranteeIdMax;
	}

	public void setGuaranteeIdMax(Long guaranteeIdMax) {
		this.guaranteeIdMax = guaranteeIdMax;
	}

	public Long getGuaranteeProjectId() {
		return guaranteeProjectId;
	}

	public void setGuaranteeProjectId(Long guaranteeProjectId) {
		this.guaranteeProjectId = guaranteeProjectId;
	}

	public Long getGuaranteeProjectIdMin() {
		return guaranteeProjectIdMin;
	}

	public void setGuaranteeProjectIdMin(Long guaranteeProjectIdMin) {
		this.guaranteeProjectIdMin = guaranteeProjectIdMin;
	}

	public Long getGuaranteeProjectIdMax() {
		return guaranteeProjectIdMax;
	}

	public void setGuaranteeProjectIdMax(Long guaranteeProjectIdMax) {
		this.guaranteeProjectIdMax = guaranteeProjectIdMax;
	}

	public Long getGuaranteeUserId() {
		return guaranteeUserId;
	}

	public void setGuaranteeUserId(Long guaranteeUserId) {
		this.guaranteeUserId = guaranteeUserId;
	}

	public Long getGuaranteeUserIdMin() {
		return guaranteeUserIdMin;
	}

	public void setGuaranteeUserIdMin(Long guaranteeUserIdMin) {
		this.guaranteeUserIdMin = guaranteeUserIdMin;
	}

	public Long getGuaranteeUserIdMax() {
		return guaranteeUserIdMax;
	}

	public void setGuaranteeUserIdMax(Long guaranteeUserIdMax) {
		this.guaranteeUserIdMax = guaranteeUserIdMax;
	}

	public String getGuaranteeProjectName() {
		return guaranteeProjectName;
	}

	public void setGuaranteeProjectName(String guaranteeProjectName) {
		this.guaranteeProjectName = guaranteeProjectName;
	}

	public Date getGuaranteeOpenMarkTime() {
		return guaranteeOpenMarkTime;
	}

	public void setGuaranteeOpenMarkTime(Date guaranteeOpenMarkTime) {
		this.guaranteeOpenMarkTime = guaranteeOpenMarkTime;
	}

	public Date getGuaranteeOpenMarkTimeMin() {
		return guaranteeOpenMarkTimeMin;
	}

	public void setGuaranteeOpenMarkTimeMin(Date guaranteeOpenMarkTimeMin) {
		this.guaranteeOpenMarkTimeMin = guaranteeOpenMarkTimeMin;
	}

	public Date getGuaranteeOpenMarkTimeMax() {
		return guaranteeOpenMarkTimeMax;
	}

	public void setGuaranteeOpenMarkTimeMax(Date guaranteeOpenMarkTimeMax) {
		this.guaranteeOpenMarkTimeMax = guaranteeOpenMarkTimeMax;
	}

	public String getGuaranteeMarkUnitName() {
		return guaranteeMarkUnitName;
	}

	public void setGuaranteeMarkUnitName(String guaranteeMarkUnitName) {
		this.guaranteeMarkUnitName = guaranteeMarkUnitName;
	}

	public Integer getGuaranteeConstructionPeriod() {
		return guaranteeConstructionPeriod;
	}

	public void setGuaranteeConstructionPeriod(Integer guaranteeConstructionPeriod) {
		this.guaranteeConstructionPeriod = guaranteeConstructionPeriod;
	}

	public Integer getGuaranteeConstructionPeriodMin() {
		return guaranteeConstructionPeriodMin;
	}

	public void setGuaranteeConstructionPeriodMin(Integer guaranteeConstructionPeriodMin) {
		this.guaranteeConstructionPeriodMin = guaranteeConstructionPeriodMin;
	}

	public Integer getGuaranteeConstructionPeriodMax() {
		return guaranteeConstructionPeriodMax;
	}

	public void setGuaranteeConstructionPeriodMax(Integer guaranteeConstructionPeriodMax) {
		this.guaranteeConstructionPeriodMax = guaranteeConstructionPeriodMax;
	}

	public Long getGuaranteeAssurePrice() {
		return guaranteeAssurePrice;
	}

	public void setGuaranteeAssurePrice(Long guaranteeAssurePrice) {
		this.guaranteeAssurePrice = guaranteeAssurePrice;
	}

	public Long getGuaranteeAssurePriceMin() {
		return guaranteeAssurePriceMin;
	}

	public void setGuaranteeAssurePriceMin(Long guaranteeAssurePriceMin) {
		this.guaranteeAssurePriceMin = guaranteeAssurePriceMin;
	}

	public Long getGuaranteeAssurePriceMax() {
		return guaranteeAssurePriceMax;
	}

	public void setGuaranteeAssurePriceMax(Long guaranteeAssurePriceMax) {
		this.guaranteeAssurePriceMax = guaranteeAssurePriceMax;
	}

	public String getGuaranteeGuaranteeComp() {
		return guaranteeGuaranteeComp;
	}

	public void setGuaranteeGuaranteeComp(String guaranteeGuaranteeComp) {
		this.guaranteeGuaranteeComp = guaranteeGuaranteeComp;
	}

	public Long getGuaranteeGuaranteePrice() {
		return guaranteeGuaranteePrice;
	}

	public void setGuaranteeGuaranteePrice(Long guaranteeGuaranteePrice) {
		this.guaranteeGuaranteePrice = guaranteeGuaranteePrice;
	}

	public Long getGuaranteeGuaranteePriceMin() {
		return guaranteeGuaranteePriceMin;
	}

	public void setGuaranteeGuaranteePriceMin(Long guaranteeGuaranteePriceMin) {
		this.guaranteeGuaranteePriceMin = guaranteeGuaranteePriceMin;
	}

	public Long getGuaranteeGuaranteePriceMax() {
		return guaranteeGuaranteePriceMax;
	}

	public void setGuaranteeGuaranteePriceMax(Long guaranteeGuaranteePriceMax) {
		this.guaranteeGuaranteePriceMax = guaranteeGuaranteePriceMax;
	}

	public String getGuaranteeApplicant() {
		return guaranteeApplicant;
	}

	public void setGuaranteeApplicant(String guaranteeApplicant) {
		this.guaranteeApplicant = guaranteeApplicant;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}

	public String getGuaranteePhone() {
		return guaranteePhone;
	}

	public void setGuaranteePhone(String guaranteePhone) {
		this.guaranteePhone = guaranteePhone;
	}

	public String getGuaranteeAddress() {
		return guaranteeAddress;
	}

	public void setGuaranteeAddress(String guaranteeAddress) {
		this.guaranteeAddress = guaranteeAddress;
	}

	public Integer getGuaranteeVersion() {
		return guaranteeVersion;
	}

	public void setGuaranteeVersion(Integer guaranteeVersion) {
		this.guaranteeVersion = guaranteeVersion;
	}

	public Integer getGuaranteeVersionMin() {
		return guaranteeVersionMin;
	}

	public void setGuaranteeVersionMin(Integer guaranteeVersionMin) {
		this.guaranteeVersionMin = guaranteeVersionMin;
	}

	public Integer getGuaranteeVersionMax() {
		return guaranteeVersionMax;
	}

	public void setGuaranteeVersionMax(Integer guaranteeVersionMax) {
		this.guaranteeVersionMax = guaranteeVersionMax;
	}

	public Date getGuaranteeCreateTime() {
		return guaranteeCreateTime;
	}

	public void setGuaranteeCreateTime(Date guaranteeCreateTime) {
		this.guaranteeCreateTime = guaranteeCreateTime;
	}

	public Date getGuaranteeCreateTimeMin() {
		return guaranteeCreateTimeMin;
	}

	public void setGuaranteeCreateTimeMin(Date guaranteeCreateTimeMin) {
		this.guaranteeCreateTimeMin = guaranteeCreateTimeMin;
	}

	public Date getGuaranteeCreateTimeMax() {
		return guaranteeCreateTimeMax;
	}

	public void setGuaranteeCreateTimeMax(Date guaranteeCreateTimeMax) {
		this.guaranteeCreateTimeMax = guaranteeCreateTimeMax;
	}

	public Date getGuaranteeUpdateTime() {
		return guaranteeUpdateTime;
	}

	public void setGuaranteeUpdateTime(Date guaranteeUpdateTime) {
		this.guaranteeUpdateTime = guaranteeUpdateTime;
	}

	public Date getGuaranteeUpdateTimeMin() {
		return guaranteeUpdateTimeMin;
	}

	public void setGuaranteeUpdateTimeMin(Date guaranteeUpdateTimeMin) {
		this.guaranteeUpdateTimeMin = guaranteeUpdateTimeMin;
	}

	public Date getGuaranteeUpdateTimeMax() {
		return guaranteeUpdateTimeMax;
	}

	public void setGuaranteeUpdateTimeMax(Date guaranteeUpdateTimeMax) {
		this.guaranteeUpdateTimeMax = guaranteeUpdateTimeMax;
	}

	public Byte getGuaranteeIsActive() {
		return guaranteeIsActive;
	}

	public void setGuaranteeIsActive(Byte guaranteeIsActive) {
		this.guaranteeIsActive = guaranteeIsActive;
	}

	public Byte getGuaranteeIsActiveMin() {
		return guaranteeIsActiveMin;
	}

	public void setGuaranteeIsActiveMin(Byte guaranteeIsActiveMin) {
		this.guaranteeIsActiveMin = guaranteeIsActiveMin;
	}

	public Byte getGuaranteeIsActiveMax() {
		return guaranteeIsActiveMax;
	}

	public void setGuaranteeIsActiveMax(Byte guaranteeIsActiveMax) {
		this.guaranteeIsActiveMax = guaranteeIsActiveMax;
	}

	public String getUserDetailNickname() {
		return userDetailNickname;
	}

	public void setUserDetailNickname(String userDetailNickname) {
		this.userDetailNickname = userDetailNickname;
	}

	public String getUserDetailHeadicon() {
		return userDetailHeadicon;
	}

	public void setUserDetailHeadicon(String userDetailHeadicon) {
		this.userDetailHeadicon = userDetailHeadicon;
	}

	public Byte getUserDetailGender() {
		return userDetailGender;
	}

	public void setUserDetailGender(Byte userDetailGender) {
		this.userDetailGender = userDetailGender;
	}

	public Byte getUserDetailGenderMin() {
		return userDetailGenderMin;
	}

	public void setUserDetailGenderMin(Byte userDetailGenderMin) {
		this.userDetailGenderMin = userDetailGenderMin;
	}

	public Byte getUserDetailGenderMax() {
		return userDetailGenderMax;
	}

	public void setUserDetailGenderMax(Byte userDetailGenderMax) {
		this.userDetailGenderMax = userDetailGenderMax;
	}

	
    @Override
    public String toString() {
        return "UserGuaranteeQuery {" +
                "guaranteeId = " + guaranteeId + 
				", guaranteeIdMin = " + guaranteeIdMin + 
				", guaranteeIdMax = " + guaranteeIdMax + 
				", guaranteeProjectId = " + guaranteeProjectId + 
				", guaranteeProjectIdMin = " + guaranteeProjectIdMin + 
				", guaranteeProjectIdMax = " + guaranteeProjectIdMax + 
				", guaranteeUserId = " + guaranteeUserId + 
				", guaranteeUserIdMin = " + guaranteeUserIdMin + 
				", guaranteeUserIdMax = " + guaranteeUserIdMax + 
				", guaranteeProjectName = " + guaranteeProjectName + 
				", guaranteeOpenMarkTime = " + guaranteeOpenMarkTime + 
				", guaranteeOpenMarkTimeMin = " + guaranteeOpenMarkTimeMin + 
				", guaranteeOpenMarkTimeMax = " + guaranteeOpenMarkTimeMax + 
				", guaranteeMarkUnitName = " + guaranteeMarkUnitName + 
				", guaranteeConstructionPeriod = " + guaranteeConstructionPeriod + 
				", guaranteeConstructionPeriodMin = " + guaranteeConstructionPeriodMin + 
				", guaranteeConstructionPeriodMax = " + guaranteeConstructionPeriodMax + 
				", guaranteeAssurePrice = " + guaranteeAssurePrice + 
				", guaranteeAssurePriceMin = " + guaranteeAssurePriceMin + 
				", guaranteeAssurePriceMax = " + guaranteeAssurePriceMax + 
				", guaranteeGuaranteeComp = " + guaranteeGuaranteeComp + 
				", guaranteeGuaranteePrice = " + guaranteeGuaranteePrice + 
				", guaranteeGuaranteePriceMin = " + guaranteeGuaranteePriceMin + 
				", guaranteeGuaranteePriceMax = " + guaranteeGuaranteePriceMax + 
				", guaranteeApplicant = " + guaranteeApplicant + 
				", guaranteeName = " + guaranteeName + 
				", guaranteePhone = " + guaranteePhone + 
				", guaranteeAddress = " + guaranteeAddress + 
				", guaranteeVersion = " + guaranteeVersion + 
				", guaranteeVersionMin = " + guaranteeVersionMin + 
				", guaranteeVersionMax = " + guaranteeVersionMax + 
				", guaranteeCreateTime = " + guaranteeCreateTime + 
				", guaranteeCreateTimeMin = " + guaranteeCreateTimeMin + 
				", guaranteeCreateTimeMax = " + guaranteeCreateTimeMax + 
				", guaranteeUpdateTime = " + guaranteeUpdateTime + 
				", guaranteeUpdateTimeMin = " + guaranteeUpdateTimeMin + 
				", guaranteeUpdateTimeMax = " + guaranteeUpdateTimeMax + 
				", guaranteeIsActive = " + guaranteeIsActive + 
				", guaranteeIsActiveMin = " + guaranteeIsActiveMin + 
				", guaranteeIsActiveMax = " + guaranteeIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				" }";
    }

}
