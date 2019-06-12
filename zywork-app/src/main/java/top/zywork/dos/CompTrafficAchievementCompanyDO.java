package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompTrafficAchievementCompanyDO数据对象实体类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompTrafficAchievementCompanyDO extends BaseDO {

    private static final long serialVersionUID = -9223372034967462095L;

    //t_comp_traffic_achievement表的字段对应的属性
	// 企业交通业绩编号
	private Long compTrafficAchievementId;
	// 企业编号
	private Long compTrafficAchievementCompId;
	// 工程名称
	private String compTrafficAchievementProjectName;
	// 项目负责人
	private String compTrafficAchievementName;
	// 技术负责人
	private String compTrafficAchievementTechnologyName;
	// 合同金额
	private String compTrafficAchievementContractAmount;
	// 工程地点
	private String compTrafficAchievementWorkAddr;
	// 开工时间
	private Date compTrafficAchievementStartDate;
	// 竣工时间
	private Date compTrafficAchievementEndDate;
	// 验证状态
	private String compTrafficAchievementValidStatus;
	// 版本号
	private Integer compTrafficAchievementVersion;
	// 创建时间
	private Date compTrafficAchievementCreateTime;
	// 更新时间
	private Date compTrafficAchievementUpdateTime;
	// 是否激活
	private Byte compTrafficAchievementIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	// 金额
	private BigDecimal money;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
    public CompTrafficAchievementCompanyDO () {}

    public CompTrafficAchievementCompanyDO (Long compTrafficAchievementId, Long compTrafficAchievementCompId, String compTrafficAchievementProjectName, String compTrafficAchievementName, String compTrafficAchievementTechnologyName, String compTrafficAchievementContractAmount, String compTrafficAchievementWorkAddr, Date compTrafficAchievementStartDate, Date compTrafficAchievementEndDate, String compTrafficAchievementValidStatus, Integer compTrafficAchievementVersion, Date compTrafficAchievementCreateTime, Date compTrafficAchievementUpdateTime, Byte compTrafficAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compTrafficAchievementId = compTrafficAchievementId;
		this.compTrafficAchievementCompId = compTrafficAchievementCompId;
		this.compTrafficAchievementProjectName = compTrafficAchievementProjectName;
		this.compTrafficAchievementName = compTrafficAchievementName;
		this.compTrafficAchievementTechnologyName = compTrafficAchievementTechnologyName;
		this.compTrafficAchievementContractAmount = compTrafficAchievementContractAmount;
		this.compTrafficAchievementWorkAddr = compTrafficAchievementWorkAddr;
		this.compTrafficAchievementStartDate = compTrafficAchievementStartDate;
		this.compTrafficAchievementEndDate = compTrafficAchievementEndDate;
		this.compTrafficAchievementValidStatus = compTrafficAchievementValidStatus;
		this.compTrafficAchievementVersion = compTrafficAchievementVersion;
		this.compTrafficAchievementCreateTime = compTrafficAchievementCreateTime;
		this.compTrafficAchievementUpdateTime = compTrafficAchievementUpdateTime;
		this.compTrafficAchievementIsActive = compTrafficAchievementIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompTrafficAchievementId() {
		return compTrafficAchievementId;
	}

	public void setCompTrafficAchievementId(Long compTrafficAchievementId) {
		this.compTrafficAchievementId = compTrafficAchievementId;
	}

	public Long getCompTrafficAchievementCompId() {
		return compTrafficAchievementCompId;
	}

	public void setCompTrafficAchievementCompId(Long compTrafficAchievementCompId) {
		this.compTrafficAchievementCompId = compTrafficAchievementCompId;
	}

	public String getCompTrafficAchievementProjectName() {
		return compTrafficAchievementProjectName;
	}

	public void setCompTrafficAchievementProjectName(String compTrafficAchievementProjectName) {
		this.compTrafficAchievementProjectName = compTrafficAchievementProjectName;
	}

	public String getCompTrafficAchievementName() {
		return compTrafficAchievementName;
	}

	public void setCompTrafficAchievementName(String compTrafficAchievementName) {
		this.compTrafficAchievementName = compTrafficAchievementName;
	}

	public String getCompTrafficAchievementTechnologyName() {
		return compTrafficAchievementTechnologyName;
	}

	public void setCompTrafficAchievementTechnologyName(String compTrafficAchievementTechnologyName) {
		this.compTrafficAchievementTechnologyName = compTrafficAchievementTechnologyName;
	}

	public String getCompTrafficAchievementContractAmount() {
		return compTrafficAchievementContractAmount;
	}

	public void setCompTrafficAchievementContractAmount(String compTrafficAchievementContractAmount) {
		this.compTrafficAchievementContractAmount = compTrafficAchievementContractAmount;
	}

	public String getCompTrafficAchievementWorkAddr() {
		return compTrafficAchievementWorkAddr;
	}

	public void setCompTrafficAchievementWorkAddr(String compTrafficAchievementWorkAddr) {
		this.compTrafficAchievementWorkAddr = compTrafficAchievementWorkAddr;
	}

	public Date getCompTrafficAchievementStartDate() {
		return compTrafficAchievementStartDate;
	}

	public void setCompTrafficAchievementStartDate(Date compTrafficAchievementStartDate) {
		this.compTrafficAchievementStartDate = compTrafficAchievementStartDate;
	}

	public Date getCompTrafficAchievementEndDate() {
		return compTrafficAchievementEndDate;
	}

	public void setCompTrafficAchievementEndDate(Date compTrafficAchievementEndDate) {
		this.compTrafficAchievementEndDate = compTrafficAchievementEndDate;
	}

	public String getCompTrafficAchievementValidStatus() {
		return compTrafficAchievementValidStatus;
	}

	public void setCompTrafficAchievementValidStatus(String compTrafficAchievementValidStatus) {
		this.compTrafficAchievementValidStatus = compTrafficAchievementValidStatus;
	}

	public Integer getCompTrafficAchievementVersion() {
		return compTrafficAchievementVersion;
	}

	public void setCompTrafficAchievementVersion(Integer compTrafficAchievementVersion) {
		this.compTrafficAchievementVersion = compTrafficAchievementVersion;
	}

	public Date getCompTrafficAchievementCreateTime() {
		return compTrafficAchievementCreateTime;
	}

	public void setCompTrafficAchievementCreateTime(Date compTrafficAchievementCreateTime) {
		this.compTrafficAchievementCreateTime = compTrafficAchievementCreateTime;
	}

	public Date getCompTrafficAchievementUpdateTime() {
		return compTrafficAchievementUpdateTime;
	}

	public void setCompTrafficAchievementUpdateTime(Date compTrafficAchievementUpdateTime) {
		this.compTrafficAchievementUpdateTime = compTrafficAchievementUpdateTime;
	}

	public Byte getCompTrafficAchievementIsActive() {
		return compTrafficAchievementIsActive;
	}

	public void setCompTrafficAchievementIsActive(Byte compTrafficAchievementIsActive) {
		this.compTrafficAchievementIsActive = compTrafficAchievementIsActive;
	}

	public String getCompanyCompType() {
		return companyCompType;
	}

	public void setCompanyCompType(String companyCompType) {
		this.companyCompType = companyCompType;
	}

	public String getCompanyIndustryType() {
		return companyIndustryType;
	}

	public void setCompanyIndustryType(String companyIndustryType) {
		this.companyIndustryType = companyIndustryType;
	}

	public String getCompanyCompName() {
		return companyCompName;
	}

	public void setCompanyCompName(String companyCompName) {
		this.companyCompName = companyCompName;
	}

	
    @Override
    public String toString() {
        return "CompTrafficAchievementCompanyDO {" +
                "compTrafficAchievementId = " + compTrafficAchievementId + 
				", compTrafficAchievementCompId = " + compTrafficAchievementCompId + 
				", compTrafficAchievementProjectName = " + compTrafficAchievementProjectName + 
				", compTrafficAchievementName = " + compTrafficAchievementName + 
				", compTrafficAchievementTechnologyName = " + compTrafficAchievementTechnologyName + 
				", compTrafficAchievementContractAmount = " + compTrafficAchievementContractAmount + 
				", compTrafficAchievementWorkAddr = " + compTrafficAchievementWorkAddr + 
				", compTrafficAchievementStartDate = " + compTrafficAchievementStartDate + 
				", compTrafficAchievementEndDate = " + compTrafficAchievementEndDate + 
				", compTrafficAchievementValidStatus = " + compTrafficAchievementValidStatus + 
				", compTrafficAchievementVersion = " + compTrafficAchievementVersion + 
				", compTrafficAchievementCreateTime = " + compTrafficAchievementCreateTime + 
				", compTrafficAchievementUpdateTime = " + compTrafficAchievementUpdateTime + 
				", compTrafficAchievementIsActive = " + compTrafficAchievementIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
