package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompKeyProjectAchievementCompanyDTO数据传输对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompKeyProjectAchievementCompanyDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035728512858L;

    //t_comp_key_project_achievement表的字段对应的属性
	// 企业重点工程业绩编号
	private Long compKeyProjectAchievementId;
	// 企业编号
	private Long compKeyProjectAchievementCompId;
	// 工程名称
	private String compKeyProjectAchievementProjectName;
	// 建设单位
	private String compKeyProjectAchievementBuildComp;
	// 中标金额
	private String compKeyProjectAchievementMarkMoney;
	// 开工时间
	private Date compKeyProjectAchievementStartDate;
	// 竣工时间
	private Date compKeyProjectAchievementEndDate;
	// 版本号
	private Integer compKeyProjectAchievementVersion;
	// 创建时间
	private Date compKeyProjectAchievementCreateTime;
	// 更新时间
	private Date compKeyProjectAchievementUpdateTime;
	// 是否激活
	private Byte compKeyProjectAchievementIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompKeyProjectAchievementCompanyDTO () {}

    public CompKeyProjectAchievementCompanyDTO (Long compKeyProjectAchievementId, Long compKeyProjectAchievementCompId, String compKeyProjectAchievementProjectName, String compKeyProjectAchievementBuildComp, String compKeyProjectAchievementMarkMoney, Date compKeyProjectAchievementStartDate, Date compKeyProjectAchievementEndDate, Integer compKeyProjectAchievementVersion, Date compKeyProjectAchievementCreateTime, Date compKeyProjectAchievementUpdateTime, Byte compKeyProjectAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compKeyProjectAchievementId = compKeyProjectAchievementId;
		this.compKeyProjectAchievementCompId = compKeyProjectAchievementCompId;
		this.compKeyProjectAchievementProjectName = compKeyProjectAchievementProjectName;
		this.compKeyProjectAchievementBuildComp = compKeyProjectAchievementBuildComp;
		this.compKeyProjectAchievementMarkMoney = compKeyProjectAchievementMarkMoney;
		this.compKeyProjectAchievementStartDate = compKeyProjectAchievementStartDate;
		this.compKeyProjectAchievementEndDate = compKeyProjectAchievementEndDate;
		this.compKeyProjectAchievementVersion = compKeyProjectAchievementVersion;
		this.compKeyProjectAchievementCreateTime = compKeyProjectAchievementCreateTime;
		this.compKeyProjectAchievementUpdateTime = compKeyProjectAchievementUpdateTime;
		this.compKeyProjectAchievementIsActive = compKeyProjectAchievementIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompKeyProjectAchievementId() {
		return compKeyProjectAchievementId;
	}

	public void setCompKeyProjectAchievementId(Long compKeyProjectAchievementId) {
		this.compKeyProjectAchievementId = compKeyProjectAchievementId;
	}

	public Long getCompKeyProjectAchievementCompId() {
		return compKeyProjectAchievementCompId;
	}

	public void setCompKeyProjectAchievementCompId(Long compKeyProjectAchievementCompId) {
		this.compKeyProjectAchievementCompId = compKeyProjectAchievementCompId;
	}

	public String getCompKeyProjectAchievementProjectName() {
		return compKeyProjectAchievementProjectName;
	}

	public void setCompKeyProjectAchievementProjectName(String compKeyProjectAchievementProjectName) {
		this.compKeyProjectAchievementProjectName = compKeyProjectAchievementProjectName;
	}

	public String getCompKeyProjectAchievementBuildComp() {
		return compKeyProjectAchievementBuildComp;
	}

	public void setCompKeyProjectAchievementBuildComp(String compKeyProjectAchievementBuildComp) {
		this.compKeyProjectAchievementBuildComp = compKeyProjectAchievementBuildComp;
	}

	public String getCompKeyProjectAchievementMarkMoney() {
		return compKeyProjectAchievementMarkMoney;
	}

	public void setCompKeyProjectAchievementMarkMoney(String compKeyProjectAchievementMarkMoney) {
		this.compKeyProjectAchievementMarkMoney = compKeyProjectAchievementMarkMoney;
	}

	public Date getCompKeyProjectAchievementStartDate() {
		return compKeyProjectAchievementStartDate;
	}

	public void setCompKeyProjectAchievementStartDate(Date compKeyProjectAchievementStartDate) {
		this.compKeyProjectAchievementStartDate = compKeyProjectAchievementStartDate;
	}

	public Date getCompKeyProjectAchievementEndDate() {
		return compKeyProjectAchievementEndDate;
	}

	public void setCompKeyProjectAchievementEndDate(Date compKeyProjectAchievementEndDate) {
		this.compKeyProjectAchievementEndDate = compKeyProjectAchievementEndDate;
	}

	public Integer getCompKeyProjectAchievementVersion() {
		return compKeyProjectAchievementVersion;
	}

	public void setCompKeyProjectAchievementVersion(Integer compKeyProjectAchievementVersion) {
		this.compKeyProjectAchievementVersion = compKeyProjectAchievementVersion;
	}

	public Date getCompKeyProjectAchievementCreateTime() {
		return compKeyProjectAchievementCreateTime;
	}

	public void setCompKeyProjectAchievementCreateTime(Date compKeyProjectAchievementCreateTime) {
		this.compKeyProjectAchievementCreateTime = compKeyProjectAchievementCreateTime;
	}

	public Date getCompKeyProjectAchievementUpdateTime() {
		return compKeyProjectAchievementUpdateTime;
	}

	public void setCompKeyProjectAchievementUpdateTime(Date compKeyProjectAchievementUpdateTime) {
		this.compKeyProjectAchievementUpdateTime = compKeyProjectAchievementUpdateTime;
	}

	public Byte getCompKeyProjectAchievementIsActive() {
		return compKeyProjectAchievementIsActive;
	}

	public void setCompKeyProjectAchievementIsActive(Byte compKeyProjectAchievementIsActive) {
		this.compKeyProjectAchievementIsActive = compKeyProjectAchievementIsActive;
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
        return "CompKeyProjectAchievementCompanyDTO {" +
                "compKeyProjectAchievementId = " + compKeyProjectAchievementId + 
				", compKeyProjectAchievementCompId = " + compKeyProjectAchievementCompId + 
				", compKeyProjectAchievementProjectName = " + compKeyProjectAchievementProjectName + 
				", compKeyProjectAchievementBuildComp = " + compKeyProjectAchievementBuildComp + 
				", compKeyProjectAchievementMarkMoney = " + compKeyProjectAchievementMarkMoney + 
				", compKeyProjectAchievementStartDate = " + compKeyProjectAchievementStartDate + 
				", compKeyProjectAchievementEndDate = " + compKeyProjectAchievementEndDate + 
				", compKeyProjectAchievementVersion = " + compKeyProjectAchievementVersion + 
				", compKeyProjectAchievementCreateTime = " + compKeyProjectAchievementCreateTime + 
				", compKeyProjectAchievementUpdateTime = " + compKeyProjectAchievementUpdateTime + 
				", compKeyProjectAchievementIsActive = " + compKeyProjectAchievementIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
