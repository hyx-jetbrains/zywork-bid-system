package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompWaterMonitorAchievementCompanyDTO数据传输对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterMonitorAchievementCompanyDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036641190732L;

    //t_comp_water_monitor_achievement表的字段对应的属性
	// 企业水利监理业绩编号
	private Long compWaterMonitorAchievementId;
	// 企业编号
	private Long compWaterMonitorAchievementCompId;
	// 工程名称
	private String compWaterMonitorAchievementProjectName;
	// 项目类型
	private String compWaterMonitorAchievementProjectType;
	// 建设单位
	private String compWaterMonitorAchievementBuildComp;
	// 合同金额
	private String compWaterMonitorAchievementContractAmount;
	// 合同签订日期
	private Date compWaterMonitorAchievementContractDate;
	// 开工时间
	private Date compWaterMonitorAchievementStartDate;
	// 版本号
	private Integer compWaterMonitorAchievementVersion;
	// 创建时间
	private Date compWaterMonitorAchievementCreateTime;
	// 更新时间
	private Date compWaterMonitorAchievementUpdateTime;
	// 是否激活
	private Byte compWaterMonitorAchievementIsActive;
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
	
    public CompWaterMonitorAchievementCompanyDTO () {}

    public CompWaterMonitorAchievementCompanyDTO (Long compWaterMonitorAchievementId, Long compWaterMonitorAchievementCompId, String compWaterMonitorAchievementProjectName, String compWaterMonitorAchievementProjectType, String compWaterMonitorAchievementBuildComp, String compWaterMonitorAchievementContractAmount, Date compWaterMonitorAchievementContractDate, Date compWaterMonitorAchievementStartDate, Integer compWaterMonitorAchievementVersion, Date compWaterMonitorAchievementCreateTime, Date compWaterMonitorAchievementUpdateTime, Byte compWaterMonitorAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compWaterMonitorAchievementId = compWaterMonitorAchievementId;
		this.compWaterMonitorAchievementCompId = compWaterMonitorAchievementCompId;
		this.compWaterMonitorAchievementProjectName = compWaterMonitorAchievementProjectName;
		this.compWaterMonitorAchievementProjectType = compWaterMonitorAchievementProjectType;
		this.compWaterMonitorAchievementBuildComp = compWaterMonitorAchievementBuildComp;
		this.compWaterMonitorAchievementContractAmount = compWaterMonitorAchievementContractAmount;
		this.compWaterMonitorAchievementContractDate = compWaterMonitorAchievementContractDate;
		this.compWaterMonitorAchievementStartDate = compWaterMonitorAchievementStartDate;
		this.compWaterMonitorAchievementVersion = compWaterMonitorAchievementVersion;
		this.compWaterMonitorAchievementCreateTime = compWaterMonitorAchievementCreateTime;
		this.compWaterMonitorAchievementUpdateTime = compWaterMonitorAchievementUpdateTime;
		this.compWaterMonitorAchievementIsActive = compWaterMonitorAchievementIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompWaterMonitorAchievementId() {
		return compWaterMonitorAchievementId;
	}

	public void setCompWaterMonitorAchievementId(Long compWaterMonitorAchievementId) {
		this.compWaterMonitorAchievementId = compWaterMonitorAchievementId;
	}

	public Long getCompWaterMonitorAchievementCompId() {
		return compWaterMonitorAchievementCompId;
	}

	public void setCompWaterMonitorAchievementCompId(Long compWaterMonitorAchievementCompId) {
		this.compWaterMonitorAchievementCompId = compWaterMonitorAchievementCompId;
	}

	public String getCompWaterMonitorAchievementProjectName() {
		return compWaterMonitorAchievementProjectName;
	}

	public void setCompWaterMonitorAchievementProjectName(String compWaterMonitorAchievementProjectName) {
		this.compWaterMonitorAchievementProjectName = compWaterMonitorAchievementProjectName;
	}

	public String getCompWaterMonitorAchievementProjectType() {
		return compWaterMonitorAchievementProjectType;
	}

	public void setCompWaterMonitorAchievementProjectType(String compWaterMonitorAchievementProjectType) {
		this.compWaterMonitorAchievementProjectType = compWaterMonitorAchievementProjectType;
	}

	public String getCompWaterMonitorAchievementBuildComp() {
		return compWaterMonitorAchievementBuildComp;
	}

	public void setCompWaterMonitorAchievementBuildComp(String compWaterMonitorAchievementBuildComp) {
		this.compWaterMonitorAchievementBuildComp = compWaterMonitorAchievementBuildComp;
	}

	public String getCompWaterMonitorAchievementContractAmount() {
		return compWaterMonitorAchievementContractAmount;
	}

	public void setCompWaterMonitorAchievementContractAmount(String compWaterMonitorAchievementContractAmount) {
		this.compWaterMonitorAchievementContractAmount = compWaterMonitorAchievementContractAmount;
	}

	public Date getCompWaterMonitorAchievementContractDate() {
		return compWaterMonitorAchievementContractDate;
	}

	public void setCompWaterMonitorAchievementContractDate(Date compWaterMonitorAchievementContractDate) {
		this.compWaterMonitorAchievementContractDate = compWaterMonitorAchievementContractDate;
	}

	public Date getCompWaterMonitorAchievementStartDate() {
		return compWaterMonitorAchievementStartDate;
	}

	public void setCompWaterMonitorAchievementStartDate(Date compWaterMonitorAchievementStartDate) {
		this.compWaterMonitorAchievementStartDate = compWaterMonitorAchievementStartDate;
	}

	public Integer getCompWaterMonitorAchievementVersion() {
		return compWaterMonitorAchievementVersion;
	}

	public void setCompWaterMonitorAchievementVersion(Integer compWaterMonitorAchievementVersion) {
		this.compWaterMonitorAchievementVersion = compWaterMonitorAchievementVersion;
	}

	public Date getCompWaterMonitorAchievementCreateTime() {
		return compWaterMonitorAchievementCreateTime;
	}

	public void setCompWaterMonitorAchievementCreateTime(Date compWaterMonitorAchievementCreateTime) {
		this.compWaterMonitorAchievementCreateTime = compWaterMonitorAchievementCreateTime;
	}

	public Date getCompWaterMonitorAchievementUpdateTime() {
		return compWaterMonitorAchievementUpdateTime;
	}

	public void setCompWaterMonitorAchievementUpdateTime(Date compWaterMonitorAchievementUpdateTime) {
		this.compWaterMonitorAchievementUpdateTime = compWaterMonitorAchievementUpdateTime;
	}

	public Byte getCompWaterMonitorAchievementIsActive() {
		return compWaterMonitorAchievementIsActive;
	}

	public void setCompWaterMonitorAchievementIsActive(Byte compWaterMonitorAchievementIsActive) {
		this.compWaterMonitorAchievementIsActive = compWaterMonitorAchievementIsActive;
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
        return "CompWaterMonitorAchievementCompanyDTO {" +
                "compWaterMonitorAchievementId = " + compWaterMonitorAchievementId + 
				", compWaterMonitorAchievementCompId = " + compWaterMonitorAchievementCompId + 
				", compWaterMonitorAchievementProjectName = " + compWaterMonitorAchievementProjectName + 
				", compWaterMonitorAchievementProjectType = " + compWaterMonitorAchievementProjectType + 
				", compWaterMonitorAchievementBuildComp = " + compWaterMonitorAchievementBuildComp + 
				", compWaterMonitorAchievementContractAmount = " + compWaterMonitorAchievementContractAmount + 
				", compWaterMonitorAchievementContractDate = " + compWaterMonitorAchievementContractDate + 
				", compWaterMonitorAchievementStartDate = " + compWaterMonitorAchievementStartDate + 
				", compWaterMonitorAchievementVersion = " + compWaterMonitorAchievementVersion + 
				", compWaterMonitorAchievementCreateTime = " + compWaterMonitorAchievementCreateTime + 
				", compWaterMonitorAchievementUpdateTime = " + compWaterMonitorAchievementUpdateTime + 
				", compWaterMonitorAchievementIsActive = " + compWaterMonitorAchievementIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
