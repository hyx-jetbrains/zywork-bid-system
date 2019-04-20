package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompanyQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class CompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034738121633L;

    // 企业编号
	private Long id;
	// 企业编号（最小值）
	private Long idMin;
	// 企业编号（最大值）
	private Long idMax;
	// 辖区类别
	private Byte jurisdictionType;
	// 辖区类别（最小值）
	private Byte jurisdictionTypeMin;
	// 辖区类别（最大值）
	private Byte jurisdictionTypeMax;
	// 市区
	private String city;
	// 企业类型
	private String compType;
	// 行业分类
	private String industryType;
	// 企业名称
	private String compName;
	// 法人
	private String legalPerson;
	// 法人电话
	private String legalPersonPhone;
	// 注册地区
	private String regAddress;
	// 负责人
	private String responsible;
	// 负责人电话
	private String responsiblePhone;
	// 单位电话
	private String compPhone;
	// 联系地址
	private String compAddr;
	// 注册资本
	private String regCapital;
	// 经营范围
	private String businessScope;
	// 可承担业务
	private String affordableBusiness;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public CompanyQuery () {}

    public CompanyQuery (Long id, Long idMin, Long idMax, Byte jurisdictionType, Byte jurisdictionTypeMin, Byte jurisdictionTypeMax, String city, String compType, String industryType, String compName, String legalPerson, String legalPersonPhone, String regAddress, String responsible, String responsiblePhone, String compPhone, String compAddr, String regCapital, String businessScope, String affordableBusiness, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.jurisdictionType = jurisdictionType;
		this.jurisdictionTypeMin = jurisdictionTypeMin;
		this.jurisdictionTypeMax = jurisdictionTypeMax;
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
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Byte getJurisdictionType() {
		return jurisdictionType;
	}

	public void setJurisdictionType(Byte jurisdictionType) {
		this.jurisdictionType = jurisdictionType;
	}

	public Byte getJurisdictionTypeMin() {
		return jurisdictionTypeMin;
	}

	public void setJurisdictionTypeMin(Byte jurisdictionTypeMin) {
		this.jurisdictionTypeMin = jurisdictionTypeMin;
	}

	public Byte getJurisdictionTypeMax() {
		return jurisdictionTypeMax;
	}

	public void setJurisdictionTypeMax(Byte jurisdictionTypeMax) {
		this.jurisdictionTypeMax = jurisdictionTypeMax;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "CompanyQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", jurisdictionType = " + jurisdictionType + 
				", jurisdictionTypeMin = " + jurisdictionTypeMin + 
				", jurisdictionTypeMax = " + jurisdictionTypeMax + 
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
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
