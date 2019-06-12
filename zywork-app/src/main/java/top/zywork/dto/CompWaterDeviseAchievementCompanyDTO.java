package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompWaterDeviseAchievementCompanyDTO数据传输对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterDeviseAchievementCompanyDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036632256900L;

    //t_comp_water_devise_achievement表的字段对应的属性
	// 企业水利勘查设计业绩编号
	private Long compWaterDeviseAchievementId;
	// 企业编号
	private Long compWaterDeviseAchievementCompId;
	// 标段(包)名称
	private String compWaterDeviseAchievementProjectName;
	// 项目类型
	private String compWaterDeviseAchievementTenderingComp;
	// 招标(单位)人
	private String compWaterDeviseAchievementBuildComp;
	// 中标时间
	private Date compWaterDeviseAchievementMarkDate;
	// 合同金额
	private String compWaterDeviseAchievementContractAmount;
	// 项目负责人
	private String compWaterDeviseAchievementName;
	// 版本号
	private Integer compWaterDeviseAchievementVersion;
	// 创建时间
	private Date compWaterDeviseAchievementCreateTime;
	// 更新时间
	private Date compWaterDeviseAchievementUpdateTime;
	// 是否激活
	private Byte compWaterDeviseAchievementIsActive;
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
	
    public CompWaterDeviseAchievementCompanyDTO () {}

    public CompWaterDeviseAchievementCompanyDTO (Long compWaterDeviseAchievementId, Long compWaterDeviseAchievementCompId, String compWaterDeviseAchievementProjectName, String compWaterDeviseAchievementTenderingComp, String compWaterDeviseAchievementBuildComp, Date compWaterDeviseAchievementMarkDate, String compWaterDeviseAchievementContractAmount, String compWaterDeviseAchievementName, Integer compWaterDeviseAchievementVersion, Date compWaterDeviseAchievementCreateTime, Date compWaterDeviseAchievementUpdateTime, Byte compWaterDeviseAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compWaterDeviseAchievementId = compWaterDeviseAchievementId;
		this.compWaterDeviseAchievementCompId = compWaterDeviseAchievementCompId;
		this.compWaterDeviseAchievementProjectName = compWaterDeviseAchievementProjectName;
		this.compWaterDeviseAchievementTenderingComp = compWaterDeviseAchievementTenderingComp;
		this.compWaterDeviseAchievementBuildComp = compWaterDeviseAchievementBuildComp;
		this.compWaterDeviseAchievementMarkDate = compWaterDeviseAchievementMarkDate;
		this.compWaterDeviseAchievementContractAmount = compWaterDeviseAchievementContractAmount;
		this.compWaterDeviseAchievementName = compWaterDeviseAchievementName;
		this.compWaterDeviseAchievementVersion = compWaterDeviseAchievementVersion;
		this.compWaterDeviseAchievementCreateTime = compWaterDeviseAchievementCreateTime;
		this.compWaterDeviseAchievementUpdateTime = compWaterDeviseAchievementUpdateTime;
		this.compWaterDeviseAchievementIsActive = compWaterDeviseAchievementIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompWaterDeviseAchievementId() {
		return compWaterDeviseAchievementId;
	}

	public void setCompWaterDeviseAchievementId(Long compWaterDeviseAchievementId) {
		this.compWaterDeviseAchievementId = compWaterDeviseAchievementId;
	}

	public Long getCompWaterDeviseAchievementCompId() {
		return compWaterDeviseAchievementCompId;
	}

	public void setCompWaterDeviseAchievementCompId(Long compWaterDeviseAchievementCompId) {
		this.compWaterDeviseAchievementCompId = compWaterDeviseAchievementCompId;
	}

	public String getCompWaterDeviseAchievementProjectName() {
		return compWaterDeviseAchievementProjectName;
	}

	public void setCompWaterDeviseAchievementProjectName(String compWaterDeviseAchievementProjectName) {
		this.compWaterDeviseAchievementProjectName = compWaterDeviseAchievementProjectName;
	}

	public String getCompWaterDeviseAchievementTenderingComp() {
		return compWaterDeviseAchievementTenderingComp;
	}

	public void setCompWaterDeviseAchievementTenderingComp(String compWaterDeviseAchievementTenderingComp) {
		this.compWaterDeviseAchievementTenderingComp = compWaterDeviseAchievementTenderingComp;
	}

	public String getCompWaterDeviseAchievementBuildComp() {
		return compWaterDeviseAchievementBuildComp;
	}

	public void setCompWaterDeviseAchievementBuildComp(String compWaterDeviseAchievementBuildComp) {
		this.compWaterDeviseAchievementBuildComp = compWaterDeviseAchievementBuildComp;
	}

	public Date getCompWaterDeviseAchievementMarkDate() {
		return compWaterDeviseAchievementMarkDate;
	}

	public void setCompWaterDeviseAchievementMarkDate(Date compWaterDeviseAchievementMarkDate) {
		this.compWaterDeviseAchievementMarkDate = compWaterDeviseAchievementMarkDate;
	}

	public String getCompWaterDeviseAchievementContractAmount() {
		return compWaterDeviseAchievementContractAmount;
	}

	public void setCompWaterDeviseAchievementContractAmount(String compWaterDeviseAchievementContractAmount) {
		this.compWaterDeviseAchievementContractAmount = compWaterDeviseAchievementContractAmount;
	}

	public String getCompWaterDeviseAchievementName() {
		return compWaterDeviseAchievementName;
	}

	public void setCompWaterDeviseAchievementName(String compWaterDeviseAchievementName) {
		this.compWaterDeviseAchievementName = compWaterDeviseAchievementName;
	}

	public Integer getCompWaterDeviseAchievementVersion() {
		return compWaterDeviseAchievementVersion;
	}

	public void setCompWaterDeviseAchievementVersion(Integer compWaterDeviseAchievementVersion) {
		this.compWaterDeviseAchievementVersion = compWaterDeviseAchievementVersion;
	}

	public Date getCompWaterDeviseAchievementCreateTime() {
		return compWaterDeviseAchievementCreateTime;
	}

	public void setCompWaterDeviseAchievementCreateTime(Date compWaterDeviseAchievementCreateTime) {
		this.compWaterDeviseAchievementCreateTime = compWaterDeviseAchievementCreateTime;
	}

	public Date getCompWaterDeviseAchievementUpdateTime() {
		return compWaterDeviseAchievementUpdateTime;
	}

	public void setCompWaterDeviseAchievementUpdateTime(Date compWaterDeviseAchievementUpdateTime) {
		this.compWaterDeviseAchievementUpdateTime = compWaterDeviseAchievementUpdateTime;
	}

	public Byte getCompWaterDeviseAchievementIsActive() {
		return compWaterDeviseAchievementIsActive;
	}

	public void setCompWaterDeviseAchievementIsActive(Byte compWaterDeviseAchievementIsActive) {
		this.compWaterDeviseAchievementIsActive = compWaterDeviseAchievementIsActive;
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
        return "CompWaterDeviseAchievementCompanyDTO {" +
                "compWaterDeviseAchievementId = " + compWaterDeviseAchievementId + 
				", compWaterDeviseAchievementCompId = " + compWaterDeviseAchievementCompId + 
				", compWaterDeviseAchievementProjectName = " + compWaterDeviseAchievementProjectName + 
				", compWaterDeviseAchievementTenderingComp = " + compWaterDeviseAchievementTenderingComp + 
				", compWaterDeviseAchievementBuildComp = " + compWaterDeviseAchievementBuildComp + 
				", compWaterDeviseAchievementMarkDate = " + compWaterDeviseAchievementMarkDate + 
				", compWaterDeviseAchievementContractAmount = " + compWaterDeviseAchievementContractAmount + 
				", compWaterDeviseAchievementName = " + compWaterDeviseAchievementName + 
				", compWaterDeviseAchievementVersion = " + compWaterDeviseAchievementVersion + 
				", compWaterDeviseAchievementCreateTime = " + compWaterDeviseAchievementCreateTime + 
				", compWaterDeviseAchievementUpdateTime = " + compWaterDeviseAchievementUpdateTime + 
				", compWaterDeviseAchievementIsActive = " + compWaterDeviseAchievementIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
