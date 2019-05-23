package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompanyVO值对象类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class CompanyVO extends BaseVO {

    private static final long serialVersionUID = -9223372034810069684L;

    // 企业编号
	private Long id;
	// 辖区类别
	private Byte jurisdictionType;
	// 市区
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String city;
	// 企业类型
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compType;
	// 行业分类
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String industryType;
	// 企业名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String compName;
	// 法人
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String legalPerson;
	// 法人电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String legalPersonPhone;
	// 注册地区
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String regAddress;
	// 负责人
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String responsible;
	// 负责人电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String responsiblePhone;
	// 单位电话
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compPhone;
	// 联系地址
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String compAddr;
	// 注册资本
	@Size(min = 0, max = 25, message = "必须小于20个字符")
	private String regCapital;
	// 经营范围
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String businessScope;
	// 可承担业务
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String affordableBusiness;
	// 源地址
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String sourceUrl;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CompanyVO () {}

    public CompanyVO (Long id, Byte jurisdictionType, String city, String compType, String industryType, String compName, String legalPerson, String legalPersonPhone, String regAddress, String responsible, String responsiblePhone, String compPhone, String compAddr, String regCapital, String businessScope, String affordableBusiness, String sourceUrl, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.jurisdictionType = jurisdictionType;
		this.city = city;
		this.compType = compType;
		this.industryType = industryType;
		this.compName = compName;
		this.legalPerson = legalPerson;
		this.legalPersonPhone = legalPersonPhone;
		this.regAddress = regAddress;
		this.responsible = responsible;
		this.responsiblePhone = responsiblePhone;
		this.compPhone = compPhone;
		this.compAddr = compAddr;
		this.regCapital = regCapital;
		this.businessScope = businessScope;
		this.affordableBusiness = affordableBusiness;
		this.sourceUrl = sourceUrl;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Byte jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}

	public String getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getResponsiblePhone() {
		return responsiblePhone;
	}

	public void setResponsiblePhone(String responsiblePhone) {
		this.responsiblePhone = responsiblePhone;
	}

	public String getCompPhone() {
		return compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getAffordableBusiness() {
		return affordableBusiness;
	}

	public void setAffordableBusiness(String affordableBusiness) {
		this.affordableBusiness = affordableBusiness;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "CompanyVO {" +
                "id = " + id + 
				", jurisdictionType = " + jurisdictionType + 
				", city = " + city + 
				", compType = " + compType + 
				", industryType = " + industryType + 
				", compName = " + compName + 
				", legalPerson = " + legalPerson + 
				", legalPersonPhone = " + legalPersonPhone + 
				", regAddress = " + regAddress + 
				", responsible = " + responsible + 
				", responsiblePhone = " + responsiblePhone + 
				", compPhone = " + compPhone + 
				", compAddr = " + compAddr + 
				", regCapital = " + regCapital + 
				", businessScope = " + businessScope + 
				", affordableBusiness = " + affordableBusiness + 
				", sourceUrl = " + sourceUrl + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
