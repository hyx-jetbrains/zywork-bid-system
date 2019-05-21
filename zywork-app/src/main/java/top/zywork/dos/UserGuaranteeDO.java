package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserGuaranteeDO数据对象实体类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserGuaranteeDO extends BaseDO {

    private static final long serialVersionUID = -9223372035348232929L;

    //t_guarantee表的字段对应的属性
	// 保函编号
	private Long guaranteeId;
	// 项目编号
	private Long guaranteeProjectId;
	// 用户编号
	private Long guaranteeUserId;
	// 项目名称
	private String guaranteeProjectName;
	// 开标时间
	private Date guaranteeOpenMarkTime;
	// 招标单位名称
	private String guaranteeMarkUnitName;
	// 工期(天)
	private Integer guaranteeConstructionPeriod;
	// 担保金额(万元)
	private Long guaranteeAssurePrice;
	// 担保公司
	private String guaranteeGuaranteeComp;
	// 保函费(元)
	private Long guaranteeGuaranteePrice;
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
	// 创建时间
	private Date guaranteeCreateTime;
	// 更新时间
	private Date guaranteeUpdateTime;
	// 是否激活
	private Byte guaranteeIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserGuaranteeDO () {}

    public UserGuaranteeDO (Long guaranteeId, Long guaranteeProjectId, Long guaranteeUserId, String guaranteeProjectName, Date guaranteeOpenMarkTime, String guaranteeMarkUnitName, Integer guaranteeConstructionPeriod, Long guaranteeAssurePrice, String guaranteeGuaranteeComp, Long guaranteeGuaranteePrice, String guaranteeApplicant, String guaranteeName, String guaranteePhone, String guaranteeAddress, Integer guaranteeVersion, Date guaranteeCreateTime, Date guaranteeUpdateTime, Byte guaranteeIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.guaranteeId = guaranteeId;
		this.guaranteeProjectId = guaranteeProjectId;
		this.guaranteeUserId = guaranteeUserId;
		this.guaranteeProjectName = guaranteeProjectName;
		this.guaranteeOpenMarkTime = guaranteeOpenMarkTime;
		this.guaranteeMarkUnitName = guaranteeMarkUnitName;
		this.guaranteeConstructionPeriod = guaranteeConstructionPeriod;
		this.guaranteeAssurePrice = guaranteeAssurePrice;
		this.guaranteeGuaranteeComp = guaranteeGuaranteeComp;
		this.guaranteeGuaranteePrice = guaranteeGuaranteePrice;
		this.guaranteeApplicant = guaranteeApplicant;
		this.guaranteeName = guaranteeName;
		this.guaranteePhone = guaranteePhone;
		this.guaranteeAddress = guaranteeAddress;
		this.guaranteeVersion = guaranteeVersion;
		this.guaranteeCreateTime = guaranteeCreateTime;
		this.guaranteeUpdateTime = guaranteeUpdateTime;
		this.guaranteeIsActive = guaranteeIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(Long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public Long getGuaranteeProjectId() {
		return guaranteeProjectId;
	}

	public void setGuaranteeProjectId(Long guaranteeProjectId) {
		this.guaranteeProjectId = guaranteeProjectId;
	}

	public Long getGuaranteeUserId() {
		return guaranteeUserId;
	}

	public void setGuaranteeUserId(Long guaranteeUserId) {
		this.guaranteeUserId = guaranteeUserId;
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

	public Long getGuaranteeAssurePrice() {
		return guaranteeAssurePrice;
	}

	public void setGuaranteeAssurePrice(Long guaranteeAssurePrice) {
		this.guaranteeAssurePrice = guaranteeAssurePrice;
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

	public Date getGuaranteeCreateTime() {
		return guaranteeCreateTime;
	}

	public void setGuaranteeCreateTime(Date guaranteeCreateTime) {
		this.guaranteeCreateTime = guaranteeCreateTime;
	}

	public Date getGuaranteeUpdateTime() {
		return guaranteeUpdateTime;
	}

	public void setGuaranteeUpdateTime(Date guaranteeUpdateTime) {
		this.guaranteeUpdateTime = guaranteeUpdateTime;
	}

	public Byte getGuaranteeIsActive() {
		return guaranteeIsActive;
	}

	public void setGuaranteeIsActive(Byte guaranteeIsActive) {
		this.guaranteeIsActive = guaranteeIsActive;
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

	
    @Override
    public String toString() {
        return "UserGuaranteeDO {" +
                "guaranteeId = " + guaranteeId + 
				", guaranteeProjectId = " + guaranteeProjectId + 
				", guaranteeUserId = " + guaranteeUserId + 
				", guaranteeProjectName = " + guaranteeProjectName + 
				", guaranteeOpenMarkTime = " + guaranteeOpenMarkTime + 
				", guaranteeMarkUnitName = " + guaranteeMarkUnitName + 
				", guaranteeConstructionPeriod = " + guaranteeConstructionPeriod + 
				", guaranteeAssurePrice = " + guaranteeAssurePrice + 
				", guaranteeGuaranteeComp = " + guaranteeGuaranteeComp + 
				", guaranteeGuaranteePrice = " + guaranteeGuaranteePrice + 
				", guaranteeApplicant = " + guaranteeApplicant + 
				", guaranteeName = " + guaranteeName + 
				", guaranteePhone = " + guaranteePhone + 
				", guaranteeAddress = " + guaranteeAddress + 
				", guaranteeVersion = " + guaranteeVersion + 
				", guaranteeCreateTime = " + guaranteeCreateTime + 
				", guaranteeUpdateTime = " + guaranteeUpdateTime + 
				", guaranteeIsActive = " + guaranteeIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
