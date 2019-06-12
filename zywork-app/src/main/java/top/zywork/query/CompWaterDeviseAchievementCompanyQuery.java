package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterDeviseAchievementCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterDeviseAchievementCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035848260852L;

    //t_comp_water_devise_achievement表的字段对应的属性
	// 企业水利勘查设计业绩编号
	private Long compWaterDeviseAchievementId;
	// 企业水利勘查设计业绩编号（最小值）
	private Long compWaterDeviseAchievementIdMin;
	// 企业水利勘查设计业绩编号（最大值）
	private Long compWaterDeviseAchievementIdMax;
	// 企业编号
	private Long compWaterDeviseAchievementCompId;
	// 企业编号（最小值）
	private Long compWaterDeviseAchievementCompIdMin;
	// 企业编号（最大值）
	private Long compWaterDeviseAchievementCompIdMax;
	// 标段(包)名称
	private String compWaterDeviseAchievementProjectName;
	// 项目类型
	private String compWaterDeviseAchievementTenderingComp;
	// 招标(单位)人
	private String compWaterDeviseAchievementBuildComp;
	// 中标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementMarkDate;
	// 中标时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementMarkDateMin;
	// 中标时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementMarkDateMax;
	// 合同金额
	private String compWaterDeviseAchievementContractAmount;
	// 项目负责人
	private String compWaterDeviseAchievementName;
	// 版本号
	private Integer compWaterDeviseAchievementVersion;
	// 版本号（最小值）
	private Integer compWaterDeviseAchievementVersionMin;
	// 版本号（最大值）
	private Integer compWaterDeviseAchievementVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterDeviseAchievementUpdateTimeMax;
	// 是否激活
	private Byte compWaterDeviseAchievementIsActive;
	// 是否激活（最小值）
	private Byte compWaterDeviseAchievementIsActiveMin;
	// 是否激活（最大值）
	private Byte compWaterDeviseAchievementIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompWaterDeviseAchievementCompanyQuery () {}

    public CompWaterDeviseAchievementCompanyQuery (Long compWaterDeviseAchievementId, Long compWaterDeviseAchievementIdMin, Long compWaterDeviseAchievementIdMax, Long compWaterDeviseAchievementCompId, Long compWaterDeviseAchievementCompIdMin, Long compWaterDeviseAchievementCompIdMax, String compWaterDeviseAchievementProjectName, String compWaterDeviseAchievementTenderingComp, String compWaterDeviseAchievementBuildComp, Date compWaterDeviseAchievementMarkDate, Date compWaterDeviseAchievementMarkDateMin, Date compWaterDeviseAchievementMarkDateMax, String compWaterDeviseAchievementContractAmount, String compWaterDeviseAchievementName, Integer compWaterDeviseAchievementVersion, Integer compWaterDeviseAchievementVersionMin, Integer compWaterDeviseAchievementVersionMax, Date compWaterDeviseAchievementCreateTime, Date compWaterDeviseAchievementCreateTimeMin, Date compWaterDeviseAchievementCreateTimeMax, Date compWaterDeviseAchievementUpdateTime, Date compWaterDeviseAchievementUpdateTimeMin, Date compWaterDeviseAchievementUpdateTimeMax, Byte compWaterDeviseAchievementIsActive, Byte compWaterDeviseAchievementIsActiveMin, Byte compWaterDeviseAchievementIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compWaterDeviseAchievementId = compWaterDeviseAchievementId;
		this.compWaterDeviseAchievementIdMin = compWaterDeviseAchievementIdMin;
		this.compWaterDeviseAchievementIdMax = compWaterDeviseAchievementIdMax;
		this.compWaterDeviseAchievementCompId = compWaterDeviseAchievementCompId;
		this.compWaterDeviseAchievementCompIdMin = compWaterDeviseAchievementCompIdMin;
		this.compWaterDeviseAchievementCompIdMax = compWaterDeviseAchievementCompIdMax;
		this.compWaterDeviseAchievementProjectName = compWaterDeviseAchievementProjectName;
		this.compWaterDeviseAchievementTenderingComp = compWaterDeviseAchievementTenderingComp;
		this.compWaterDeviseAchievementBuildComp = compWaterDeviseAchievementBuildComp;
		this.compWaterDeviseAchievementMarkDate = compWaterDeviseAchievementMarkDate;
		this.compWaterDeviseAchievementMarkDateMin = compWaterDeviseAchievementMarkDateMin;
		this.compWaterDeviseAchievementMarkDateMax = compWaterDeviseAchievementMarkDateMax;
		this.compWaterDeviseAchievementContractAmount = compWaterDeviseAchievementContractAmount;
		this.compWaterDeviseAchievementName = compWaterDeviseAchievementName;
		this.compWaterDeviseAchievementVersion = compWaterDeviseAchievementVersion;
		this.compWaterDeviseAchievementVersionMin = compWaterDeviseAchievementVersionMin;
		this.compWaterDeviseAchievementVersionMax = compWaterDeviseAchievementVersionMax;
		this.compWaterDeviseAchievementCreateTime = compWaterDeviseAchievementCreateTime;
		this.compWaterDeviseAchievementCreateTimeMin = compWaterDeviseAchievementCreateTimeMin;
		this.compWaterDeviseAchievementCreateTimeMax = compWaterDeviseAchievementCreateTimeMax;
		this.compWaterDeviseAchievementUpdateTime = compWaterDeviseAchievementUpdateTime;
		this.compWaterDeviseAchievementUpdateTimeMin = compWaterDeviseAchievementUpdateTimeMin;
		this.compWaterDeviseAchievementUpdateTimeMax = compWaterDeviseAchievementUpdateTimeMax;
		this.compWaterDeviseAchievementIsActive = compWaterDeviseAchievementIsActive;
		this.compWaterDeviseAchievementIsActiveMin = compWaterDeviseAchievementIsActiveMin;
		this.compWaterDeviseAchievementIsActiveMax = compWaterDeviseAchievementIsActiveMax;
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

	public Long getCompWaterDeviseAchievementIdMin() {
		return compWaterDeviseAchievementIdMin;
	}

	public void setCompWaterDeviseAchievementIdMin(Long compWaterDeviseAchievementIdMin) {
		this.compWaterDeviseAchievementIdMin = compWaterDeviseAchievementIdMin;
	}

	public Long getCompWaterDeviseAchievementIdMax() {
		return compWaterDeviseAchievementIdMax;
	}

	public void setCompWaterDeviseAchievementIdMax(Long compWaterDeviseAchievementIdMax) {
		this.compWaterDeviseAchievementIdMax = compWaterDeviseAchievementIdMax;
	}

	public Long getCompWaterDeviseAchievementCompId() {
		return compWaterDeviseAchievementCompId;
	}

	public void setCompWaterDeviseAchievementCompId(Long compWaterDeviseAchievementCompId) {
		this.compWaterDeviseAchievementCompId = compWaterDeviseAchievementCompId;
	}

	public Long getCompWaterDeviseAchievementCompIdMin() {
		return compWaterDeviseAchievementCompIdMin;
	}

	public void setCompWaterDeviseAchievementCompIdMin(Long compWaterDeviseAchievementCompIdMin) {
		this.compWaterDeviseAchievementCompIdMin = compWaterDeviseAchievementCompIdMin;
	}

	public Long getCompWaterDeviseAchievementCompIdMax() {
		return compWaterDeviseAchievementCompIdMax;
	}

	public void setCompWaterDeviseAchievementCompIdMax(Long compWaterDeviseAchievementCompIdMax) {
		this.compWaterDeviseAchievementCompIdMax = compWaterDeviseAchievementCompIdMax;
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

	public Date getCompWaterDeviseAchievementMarkDateMin() {
		return compWaterDeviseAchievementMarkDateMin;
	}

	public void setCompWaterDeviseAchievementMarkDateMin(Date compWaterDeviseAchievementMarkDateMin) {
		this.compWaterDeviseAchievementMarkDateMin = compWaterDeviseAchievementMarkDateMin;
	}

	public Date getCompWaterDeviseAchievementMarkDateMax() {
		return compWaterDeviseAchievementMarkDateMax;
	}

	public void setCompWaterDeviseAchievementMarkDateMax(Date compWaterDeviseAchievementMarkDateMax) {
		this.compWaterDeviseAchievementMarkDateMax = compWaterDeviseAchievementMarkDateMax;
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

	public Integer getCompWaterDeviseAchievementVersionMin() {
		return compWaterDeviseAchievementVersionMin;
	}

	public void setCompWaterDeviseAchievementVersionMin(Integer compWaterDeviseAchievementVersionMin) {
		this.compWaterDeviseAchievementVersionMin = compWaterDeviseAchievementVersionMin;
	}

	public Integer getCompWaterDeviseAchievementVersionMax() {
		return compWaterDeviseAchievementVersionMax;
	}

	public void setCompWaterDeviseAchievementVersionMax(Integer compWaterDeviseAchievementVersionMax) {
		this.compWaterDeviseAchievementVersionMax = compWaterDeviseAchievementVersionMax;
	}

	public Date getCompWaterDeviseAchievementCreateTime() {
		return compWaterDeviseAchievementCreateTime;
	}

	public void setCompWaterDeviseAchievementCreateTime(Date compWaterDeviseAchievementCreateTime) {
		this.compWaterDeviseAchievementCreateTime = compWaterDeviseAchievementCreateTime;
	}

	public Date getCompWaterDeviseAchievementCreateTimeMin() {
		return compWaterDeviseAchievementCreateTimeMin;
	}

	public void setCompWaterDeviseAchievementCreateTimeMin(Date compWaterDeviseAchievementCreateTimeMin) {
		this.compWaterDeviseAchievementCreateTimeMin = compWaterDeviseAchievementCreateTimeMin;
	}

	public Date getCompWaterDeviseAchievementCreateTimeMax() {
		return compWaterDeviseAchievementCreateTimeMax;
	}

	public void setCompWaterDeviseAchievementCreateTimeMax(Date compWaterDeviseAchievementCreateTimeMax) {
		this.compWaterDeviseAchievementCreateTimeMax = compWaterDeviseAchievementCreateTimeMax;
	}

	public Date getCompWaterDeviseAchievementUpdateTime() {
		return compWaterDeviseAchievementUpdateTime;
	}

	public void setCompWaterDeviseAchievementUpdateTime(Date compWaterDeviseAchievementUpdateTime) {
		this.compWaterDeviseAchievementUpdateTime = compWaterDeviseAchievementUpdateTime;
	}

	public Date getCompWaterDeviseAchievementUpdateTimeMin() {
		return compWaterDeviseAchievementUpdateTimeMin;
	}

	public void setCompWaterDeviseAchievementUpdateTimeMin(Date compWaterDeviseAchievementUpdateTimeMin) {
		this.compWaterDeviseAchievementUpdateTimeMin = compWaterDeviseAchievementUpdateTimeMin;
	}

	public Date getCompWaterDeviseAchievementUpdateTimeMax() {
		return compWaterDeviseAchievementUpdateTimeMax;
	}

	public void setCompWaterDeviseAchievementUpdateTimeMax(Date compWaterDeviseAchievementUpdateTimeMax) {
		this.compWaterDeviseAchievementUpdateTimeMax = compWaterDeviseAchievementUpdateTimeMax;
	}

	public Byte getCompWaterDeviseAchievementIsActive() {
		return compWaterDeviseAchievementIsActive;
	}

	public void setCompWaterDeviseAchievementIsActive(Byte compWaterDeviseAchievementIsActive) {
		this.compWaterDeviseAchievementIsActive = compWaterDeviseAchievementIsActive;
	}

	public Byte getCompWaterDeviseAchievementIsActiveMin() {
		return compWaterDeviseAchievementIsActiveMin;
	}

	public void setCompWaterDeviseAchievementIsActiveMin(Byte compWaterDeviseAchievementIsActiveMin) {
		this.compWaterDeviseAchievementIsActiveMin = compWaterDeviseAchievementIsActiveMin;
	}

	public Byte getCompWaterDeviseAchievementIsActiveMax() {
		return compWaterDeviseAchievementIsActiveMax;
	}

	public void setCompWaterDeviseAchievementIsActiveMax(Byte compWaterDeviseAchievementIsActiveMax) {
		this.compWaterDeviseAchievementIsActiveMax = compWaterDeviseAchievementIsActiveMax;
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
        return "CompWaterDeviseAchievementCompanyQuery {" +
                "compWaterDeviseAchievementId = " + compWaterDeviseAchievementId + 
				", compWaterDeviseAchievementIdMin = " + compWaterDeviseAchievementIdMin + 
				", compWaterDeviseAchievementIdMax = " + compWaterDeviseAchievementIdMax + 
				", compWaterDeviseAchievementCompId = " + compWaterDeviseAchievementCompId + 
				", compWaterDeviseAchievementCompIdMin = " + compWaterDeviseAchievementCompIdMin + 
				", compWaterDeviseAchievementCompIdMax = " + compWaterDeviseAchievementCompIdMax + 
				", compWaterDeviseAchievementProjectName = " + compWaterDeviseAchievementProjectName + 
				", compWaterDeviseAchievementTenderingComp = " + compWaterDeviseAchievementTenderingComp + 
				", compWaterDeviseAchievementBuildComp = " + compWaterDeviseAchievementBuildComp + 
				", compWaterDeviseAchievementMarkDate = " + compWaterDeviseAchievementMarkDate + 
				", compWaterDeviseAchievementMarkDateMin = " + compWaterDeviseAchievementMarkDateMin + 
				", compWaterDeviseAchievementMarkDateMax = " + compWaterDeviseAchievementMarkDateMax + 
				", compWaterDeviseAchievementContractAmount = " + compWaterDeviseAchievementContractAmount + 
				", compWaterDeviseAchievementName = " + compWaterDeviseAchievementName + 
				", compWaterDeviseAchievementVersion = " + compWaterDeviseAchievementVersion + 
				", compWaterDeviseAchievementVersionMin = " + compWaterDeviseAchievementVersionMin + 
				", compWaterDeviseAchievementVersionMax = " + compWaterDeviseAchievementVersionMax + 
				", compWaterDeviseAchievementCreateTime = " + compWaterDeviseAchievementCreateTime + 
				", compWaterDeviseAchievementCreateTimeMin = " + compWaterDeviseAchievementCreateTimeMin + 
				", compWaterDeviseAchievementCreateTimeMax = " + compWaterDeviseAchievementCreateTimeMax + 
				", compWaterDeviseAchievementUpdateTime = " + compWaterDeviseAchievementUpdateTime + 
				", compWaterDeviseAchievementUpdateTimeMin = " + compWaterDeviseAchievementUpdateTimeMin + 
				", compWaterDeviseAchievementUpdateTimeMax = " + compWaterDeviseAchievementUpdateTimeMax + 
				", compWaterDeviseAchievementIsActive = " + compWaterDeviseAchievementIsActive + 
				", compWaterDeviseAchievementIsActiveMin = " + compWaterDeviseAchievementIsActiveMin + 
				", compWaterDeviseAchievementIsActiveMax = " + compWaterDeviseAchievementIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
