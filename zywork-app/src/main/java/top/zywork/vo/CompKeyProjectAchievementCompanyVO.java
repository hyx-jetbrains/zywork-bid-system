package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompKeyProjectAchievementCompanyVO值对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompKeyProjectAchievementCompanyVO extends BaseVO {

    private static final long serialVersionUID = -9223372034812127975L;

    //t_comp_key_project_achievement表的字段对应的属性
	// 企业重点工程业绩编号
	private Long compKeyProjectAchievementId;
	// 企业编号
	@NotNull(message = "此项是必须项")
	private Long compKeyProjectAchievementCompId;
	// 工程名称
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String compKeyProjectAchievementProjectName;
	// 建设单位
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String compKeyProjectAchievementBuildComp;
	// 中标金额
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compKeyProjectAchievementMarkMoney;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementStartDate;
	// 竣工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementEndDate;
	// 版本号
	private Integer compKeyProjectAchievementVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementUpdateTime;
	// 是否激活
	@NotNull(message = "此项是必须项")
	private Byte compKeyProjectAchievementIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String companyCompType;
	// 行业分类
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String companyIndustryType;
	// 企业名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String companyCompName;
	
    public CompKeyProjectAchievementCompanyVO () {}

    public CompKeyProjectAchievementCompanyVO (Long compKeyProjectAchievementId, Long compKeyProjectAchievementCompId, String compKeyProjectAchievementProjectName, String compKeyProjectAchievementBuildComp, String compKeyProjectAchievementMarkMoney, Date compKeyProjectAchievementStartDate, Date compKeyProjectAchievementEndDate, Integer compKeyProjectAchievementVersion, Date compKeyProjectAchievementCreateTime, Date compKeyProjectAchievementUpdateTime, Byte compKeyProjectAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
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
        return "CompKeyProjectAchievementCompanyVO {" +
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
