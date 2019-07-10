package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserGuaranteeVO值对象类<br/>
 *
 * 创建于2019-07-10<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserGuaranteeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035883503308L;

    //t_guarantee表的字段对应的属性
	// 保函编号
	private Long guaranteeId;
	// 项目编号
	private Long guaranteeProjectId;
	// 用户编号
	private Long guaranteeUserId;
	// 项目名称
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String guaranteeProjectName;
	// 开标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeOpenMarkTime;
	// 招标单位名称
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String guaranteeMarkUnitName;
	// 工期(天)
	private Integer guaranteeConstructionPeriod;
	// 担保金额(万元)
	private Long guaranteeAssurePrice;
	// 担保公司
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String guaranteeGuaranteeComp;
	// 保函费
	private Long guaranteeGuaranteePrice;
	// 申请单位
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String guaranteeApplicant;
	// 营业执照
	private Long guaranteeApplicantResId;
	// 营业执照地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String guaranteeApplicantResSrc;
	// 联系人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String guaranteeName;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String guaranteePhone;
	// 地址
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String guaranteeAddress;
	// 开户行
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String guaranteeBank;
	// 开户行照片
	private Long guaranteeBankResId;
	// 开户行照片地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String guaranteeBankResSrc;
	// 取件方式
	@Size(min = 0, max = 50, message = "必须小于50个字符")
	private String guaranteePickUpType;
	// 办理状态
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String guaranteeHandleStatus;
	// 版本号
	private Integer guaranteeVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date guaranteeUpdateTime;
	// 是否激活
	private Byte guaranteeIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserGuaranteeVO () {}

    public UserGuaranteeVO (Long guaranteeId, Long guaranteeProjectId, Long guaranteeUserId, String guaranteeProjectName, Date guaranteeOpenMarkTime, String guaranteeMarkUnitName, Integer guaranteeConstructionPeriod, Long guaranteeAssurePrice, String guaranteeGuaranteeComp, Long guaranteeGuaranteePrice, String guaranteeApplicant, Long guaranteeApplicantResId, String guaranteeApplicantResSrc, String guaranteeName, String guaranteePhone, String guaranteeAddress, String guaranteeBank, Long guaranteeBankResId, String guaranteeBankResSrc, String guaranteePickUpType, String guaranteeHandleStatus, Integer guaranteeVersion, Date guaranteeCreateTime, Date guaranteeUpdateTime, Byte guaranteeIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
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
		this.guaranteeApplicantResId = guaranteeApplicantResId;
		this.guaranteeApplicantResSrc = guaranteeApplicantResSrc;
		this.guaranteeName = guaranteeName;
		this.guaranteePhone = guaranteePhone;
		this.guaranteeAddress = guaranteeAddress;
		this.guaranteeBank = guaranteeBank;
		this.guaranteeBankResId = guaranteeBankResId;
		this.guaranteeBankResSrc = guaranteeBankResSrc;
		this.guaranteePickUpType = guaranteePickUpType;
		this.guaranteeHandleStatus = guaranteeHandleStatus;
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

	public Long getGuaranteeApplicantResId() {
		return guaranteeApplicantResId;
	}

	public void setGuaranteeApplicantResId(Long guaranteeApplicantResId) {
		this.guaranteeApplicantResId = guaranteeApplicantResId;
	}

	public String getGuaranteeApplicantResSrc() {
		return guaranteeApplicantResSrc;
	}

	public void setGuaranteeApplicantResSrc(String guaranteeApplicantResSrc) {
		this.guaranteeApplicantResSrc = guaranteeApplicantResSrc;
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

	public String getGuaranteeBank() {
		return guaranteeBank;
	}

	public void setGuaranteeBank(String guaranteeBank) {
		this.guaranteeBank = guaranteeBank;
	}

	public Long getGuaranteeBankResId() {
		return guaranteeBankResId;
	}

	public void setGuaranteeBankResId(Long guaranteeBankResId) {
		this.guaranteeBankResId = guaranteeBankResId;
	}

	public String getGuaranteeBankResSrc() {
		return guaranteeBankResSrc;
	}

	public void setGuaranteeBankResSrc(String guaranteeBankResSrc) {
		this.guaranteeBankResSrc = guaranteeBankResSrc;
	}

	public String getGuaranteePickUpType() {
		return guaranteePickUpType;
	}

	public void setGuaranteePickUpType(String guaranteePickUpType) {
		this.guaranteePickUpType = guaranteePickUpType;
	}

	public String getGuaranteeHandleStatus() {
		return guaranteeHandleStatus;
	}

	public void setGuaranteeHandleStatus(String guaranteeHandleStatus) {
		this.guaranteeHandleStatus = guaranteeHandleStatus;
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
        return "UserGuaranteeVO {" +
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
				", guaranteeApplicantResId = " + guaranteeApplicantResId + 
				", guaranteeApplicantResSrc = " + guaranteeApplicantResSrc + 
				", guaranteeName = " + guaranteeName + 
				", guaranteePhone = " + guaranteePhone + 
				", guaranteeAddress = " + guaranteeAddress + 
				", guaranteeBank = " + guaranteeBank + 
				", guaranteeBankResId = " + guaranteeBankResId + 
				", guaranteeBankResSrc = " + guaranteeBankResSrc + 
				", guaranteePickUpType = " + guaranteePickUpType + 
				", guaranteeHandleStatus = " + guaranteeHandleStatus + 
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
