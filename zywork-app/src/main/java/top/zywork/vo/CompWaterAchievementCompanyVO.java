package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterAchievementCompanyVO值对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterAchievementCompanyVO extends BaseVO {

    private static final long serialVersionUID = -9223372036358299399L;

    //t_comp_water_achievement表的字段对应的属性
	// 企业水利业绩编号
	private Long compWaterAchievementId;
	// 企业编号
	@NotNull(message = "此项是必须项")
	private Long compWaterAchievementCompId;
	// 工程名称
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String compWaterAchievementProjectName;
	// 项目负责人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compWaterAchievementName;
	// 合同金额
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compWaterAchievementContractAmount;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementStartDate;
	// 竣工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementEndDate;
	// 版本号
	private Integer compWaterAchievementVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementUpdateTime;
	// 是否激活
	@NotNull(message = "此项是必须项")
	private Byte compWaterAchievementIsActive;
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
	
    public CompWaterAchievementCompanyVO () {}

    public CompWaterAchievementCompanyVO (Long compWaterAchievementId, Long compWaterAchievementCompId, String compWaterAchievementProjectName, String compWaterAchievementName, String compWaterAchievementContractAmount, Date compWaterAchievementStartDate, Date compWaterAchievementEndDate, Integer compWaterAchievementVersion, Date compWaterAchievementCreateTime, Date compWaterAchievementUpdateTime, Byte compWaterAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
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
        return "CompWaterAchievementCompanyVO {" +
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
