package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompWaterAchievementCompanyDTO数据传输对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterAchievementCompanyDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035061597046L;

    //t_comp_water_achievement表的字段对应的属性
	// 企业水利业绩编号
	private Long compWaterAchievementId;
	// 企业编号
	private Long compWaterAchievementCompId;
	// 工程名称
	private String compWaterAchievementProjectName;
	// 项目负责人
	private String compWaterAchievementName;
	// 合同金额
	private String compWaterAchievementContractAmount;
	// 开工时间
	private Date compWaterAchievementStartDate;
	// 竣工时间
	private Date compWaterAchievementEndDate;
	// 版本号
	private Integer compWaterAchievementVersion;
	// 创建时间
	private Date compWaterAchievementCreateTime;
	// 更新时间
	private Date compWaterAchievementUpdateTime;
	// 是否激活
	private Byte compWaterAchievementIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	// 金额
	private BigDecimal money;
	// 内部地址
	private String compWaterAchievementInwardHtmlUrl;

	public String getCompWaterAchievementInwardHtmlUrl() {
		return compWaterAchievementInwardHtmlUrl;
	}

	public void setCompWaterAchievementInwardHtmlUrl(String compWaterAchievementInwardHtmlUrl) {
		this.compWaterAchievementInwardHtmlUrl = compWaterAchievementInwardHtmlUrl;
	}
	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
    public CompWaterAchievementCompanyDTO () {}

    public CompWaterAchievementCompanyDTO (Long compWaterAchievementId, Long compWaterAchievementCompId, String compWaterAchievementProjectName, String compWaterAchievementName, String compWaterAchievementContractAmount, Date compWaterAchievementStartDate, Date compWaterAchievementEndDate, Integer compWaterAchievementVersion, Date compWaterAchievementCreateTime, Date compWaterAchievementUpdateTime, Byte compWaterAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compWaterAchievementId = compWaterAchievementId;
		this.compWaterAchievementCompId = compWaterAchievementCompId;
		this.compWaterAchievementProjectName = compWaterAchievementProjectName;
		this.compWaterAchievementName = compWaterAchievementName;
		this.compWaterAchievementContractAmount = compWaterAchievementContractAmount;
		this.compWaterAchievementStartDate = compWaterAchievementStartDate;
		this.compWaterAchievementEndDate = compWaterAchievementEndDate;
		this.compWaterAchievementVersion = compWaterAchievementVersion;
		this.compWaterAchievementCreateTime = compWaterAchievementCreateTime;
		this.compWaterAchievementUpdateTime = compWaterAchievementUpdateTime;
		this.compWaterAchievementIsActive = compWaterAchievementIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompWaterAchievementId() {
		return compWaterAchievementId;
	}

	public void setCompWaterAchievementId(Long compWaterAchievementId) {
		this.compWaterAchievementId = compWaterAchievementId;
	}

	public Long getCompWaterAchievementCompId() {
		return compWaterAchievementCompId;
	}

	public void setCompWaterAchievementCompId(Long compWaterAchievementCompId) {
		this.compWaterAchievementCompId = compWaterAchievementCompId;
	}

	public String getCompWaterAchievementProjectName() {
		return compWaterAchievementProjectName;
	}

	public void setCompWaterAchievementProjectName(String compWaterAchievementProjectName) {
		this.compWaterAchievementProjectName = compWaterAchievementProjectName;
	}

	public String getCompWaterAchievementName() {
		return compWaterAchievementName;
	}

	public void setCompWaterAchievementName(String compWaterAchievementName) {
		this.compWaterAchievementName = compWaterAchievementName;
	}

	public String getCompWaterAchievementContractAmount() {
		return compWaterAchievementContractAmount;
	}

	public void setCompWaterAchievementContractAmount(String compWaterAchievementContractAmount) {
		this.compWaterAchievementContractAmount = compWaterAchievementContractAmount;
	}

	public Date getCompWaterAchievementStartDate() {
		return compWaterAchievementStartDate;
	}

	public void setCompWaterAchievementStartDate(Date compWaterAchievementStartDate) {
		this.compWaterAchievementStartDate = compWaterAchievementStartDate;
	}

	public Date getCompWaterAchievementEndDate() {
		return compWaterAchievementEndDate;
	}

	public void setCompWaterAchievementEndDate(Date compWaterAchievementEndDate) {
		this.compWaterAchievementEndDate = compWaterAchievementEndDate;
	}

	public Integer getCompWaterAchievementVersion() {
		return compWaterAchievementVersion;
	}

	public void setCompWaterAchievementVersion(Integer compWaterAchievementVersion) {
		this.compWaterAchievementVersion = compWaterAchievementVersion;
	}

	public Date getCompWaterAchievementCreateTime() {
		return compWaterAchievementCreateTime;
	}

	public void setCompWaterAchievementCreateTime(Date compWaterAchievementCreateTime) {
		this.compWaterAchievementCreateTime = compWaterAchievementCreateTime;
	}

	public Date getCompWaterAchievementUpdateTime() {
		return compWaterAchievementUpdateTime;
	}

	public void setCompWaterAchievementUpdateTime(Date compWaterAchievementUpdateTime) {
		this.compWaterAchievementUpdateTime = compWaterAchievementUpdateTime;
	}

	public Byte getCompWaterAchievementIsActive() {
		return compWaterAchievementIsActive;
	}

	public void setCompWaterAchievementIsActive(Byte compWaterAchievementIsActive) {
		this.compWaterAchievementIsActive = compWaterAchievementIsActive;
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
        return "CompWaterAchievementCompanyDTO {" +
                "compWaterAchievementId = " + compWaterAchievementId + 
				", compWaterAchievementCompId = " + compWaterAchievementCompId + 
				", compWaterAchievementProjectName = " + compWaterAchievementProjectName + 
				", compWaterAchievementName = " + compWaterAchievementName + 
				", compWaterAchievementContractAmount = " + compWaterAchievementContractAmount + 
				", compWaterAchievementStartDate = " + compWaterAchievementStartDate + 
				", compWaterAchievementEndDate = " + compWaterAchievementEndDate + 
				", compWaterAchievementVersion = " + compWaterAchievementVersion + 
				", compWaterAchievementCreateTime = " + compWaterAchievementCreateTime + 
				", compWaterAchievementUpdateTime = " + compWaterAchievementUpdateTime + 
				", compWaterAchievementIsActive = " + compWaterAchievementIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
