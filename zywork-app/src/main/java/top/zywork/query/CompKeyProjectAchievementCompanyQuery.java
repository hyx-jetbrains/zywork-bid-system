package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompKeyProjectAchievementCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompKeyProjectAchievementCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035923037250L;

    //t_comp_key_project_achievement表的字段对应的属性
	// 企业重点工程业绩编号
	private Long compKeyProjectAchievementId;
	// 企业重点工程业绩编号（最小值）
	private Long compKeyProjectAchievementIdMin;
	// 企业重点工程业绩编号（最大值）
	private Long compKeyProjectAchievementIdMax;
	// 企业编号
	private Long compKeyProjectAchievementCompId;
	// 企业编号（最小值）
	private Long compKeyProjectAchievementCompIdMin;
	// 企业编号（最大值）
	private Long compKeyProjectAchievementCompIdMax;
	// 工程名称
	private String compKeyProjectAchievementProjectName;
	// 建设单位
	private String compKeyProjectAchievementBuildComp;
	// 中标金额
	private String compKeyProjectAchievementMarkMoney;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementStartDate;
	// 开工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementStartDateMin;
	// 开工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementStartDateMax;
	// 竣工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementEndDate;
	// 竣工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementEndDateMin;
	// 竣工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementEndDateMax;
	// 版本号
	private Integer compKeyProjectAchievementVersion;
	// 版本号（最小值）
	private Integer compKeyProjectAchievementVersionMin;
	// 版本号（最大值）
	private Integer compKeyProjectAchievementVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compKeyProjectAchievementUpdateTimeMax;
	// 是否激活
	private Byte compKeyProjectAchievementIsActive;
	// 是否激活（最小值）
	private Byte compKeyProjectAchievementIsActiveMin;
	// 是否激活（最大值）
	private Byte compKeyProjectAchievementIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompKeyProjectAchievementCompanyQuery () {}

    public CompKeyProjectAchievementCompanyQuery (Long compKeyProjectAchievementId, Long compKeyProjectAchievementIdMin, Long compKeyProjectAchievementIdMax, Long compKeyProjectAchievementCompId, Long compKeyProjectAchievementCompIdMin, Long compKeyProjectAchievementCompIdMax, String compKeyProjectAchievementProjectName, String compKeyProjectAchievementBuildComp, String compKeyProjectAchievementMarkMoney, Date compKeyProjectAchievementStartDate, Date compKeyProjectAchievementStartDateMin, Date compKeyProjectAchievementStartDateMax, Date compKeyProjectAchievementEndDate, Date compKeyProjectAchievementEndDateMin, Date compKeyProjectAchievementEndDateMax, Integer compKeyProjectAchievementVersion, Integer compKeyProjectAchievementVersionMin, Integer compKeyProjectAchievementVersionMax, Date compKeyProjectAchievementCreateTime, Date compKeyProjectAchievementCreateTimeMin, Date compKeyProjectAchievementCreateTimeMax, Date compKeyProjectAchievementUpdateTime, Date compKeyProjectAchievementUpdateTimeMin, Date compKeyProjectAchievementUpdateTimeMax, Byte compKeyProjectAchievementIsActive, Byte compKeyProjectAchievementIsActiveMin, Byte compKeyProjectAchievementIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compKeyProjectAchievementId = compKeyProjectAchievementId;
		this.compKeyProjectAchievementIdMin = compKeyProjectAchievementIdMin;
		this.compKeyProjectAchievementIdMax = compKeyProjectAchievementIdMax;
		this.compKeyProjectAchievementCompId = compKeyProjectAchievementCompId;
		this.compKeyProjectAchievementCompIdMin = compKeyProjectAchievementCompIdMin;
		this.compKeyProjectAchievementCompIdMax = compKeyProjectAchievementCompIdMax;
		this.compKeyProjectAchievementProjectName = compKeyProjectAchievementProjectName;
		this.compKeyProjectAchievementBuildComp = compKeyProjectAchievementBuildComp;
		this.compKeyProjectAchievementMarkMoney = compKeyProjectAchievementMarkMoney;
		this.compKeyProjectAchievementStartDate = compKeyProjectAchievementStartDate;
		this.compKeyProjectAchievementStartDateMin = compKeyProjectAchievementStartDateMin;
		this.compKeyProjectAchievementStartDateMax = compKeyProjectAchievementStartDateMax;
		this.compKeyProjectAchievementEndDate = compKeyProjectAchievementEndDate;
		this.compKeyProjectAchievementEndDateMin = compKeyProjectAchievementEndDateMin;
		this.compKeyProjectAchievementEndDateMax = compKeyProjectAchievementEndDateMax;
		this.compKeyProjectAchievementVersion = compKeyProjectAchievementVersion;
		this.compKeyProjectAchievementVersionMin = compKeyProjectAchievementVersionMin;
		this.compKeyProjectAchievementVersionMax = compKeyProjectAchievementVersionMax;
		this.compKeyProjectAchievementCreateTime = compKeyProjectAchievementCreateTime;
		this.compKeyProjectAchievementCreateTimeMin = compKeyProjectAchievementCreateTimeMin;
		this.compKeyProjectAchievementCreateTimeMax = compKeyProjectAchievementCreateTimeMax;
		this.compKeyProjectAchievementUpdateTime = compKeyProjectAchievementUpdateTime;
		this.compKeyProjectAchievementUpdateTimeMin = compKeyProjectAchievementUpdateTimeMin;
		this.compKeyProjectAchievementUpdateTimeMax = compKeyProjectAchievementUpdateTimeMax;
		this.compKeyProjectAchievementIsActive = compKeyProjectAchievementIsActive;
		this.compKeyProjectAchievementIsActiveMin = compKeyProjectAchievementIsActiveMin;
		this.compKeyProjectAchievementIsActiveMax = compKeyProjectAchievementIsActiveMax;
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

	public Long getCompKeyProjectAchievementIdMin() {
		return compKeyProjectAchievementIdMin;
	}

	public void setCompKeyProjectAchievementIdMin(Long compKeyProjectAchievementIdMin) {
		this.compKeyProjectAchievementIdMin = compKeyProjectAchievementIdMin;
	}

	public Long getCompKeyProjectAchievementIdMax() {
		return compKeyProjectAchievementIdMax;
	}

	public void setCompKeyProjectAchievementIdMax(Long compKeyProjectAchievementIdMax) {
		this.compKeyProjectAchievementIdMax = compKeyProjectAchievementIdMax;
	}

	public Long getCompKeyProjectAchievementCompId() {
		return compKeyProjectAchievementCompId;
	}

	public void setCompKeyProjectAchievementCompId(Long compKeyProjectAchievementCompId) {
		this.compKeyProjectAchievementCompId = compKeyProjectAchievementCompId;
	}

	public Long getCompKeyProjectAchievementCompIdMin() {
		return compKeyProjectAchievementCompIdMin;
	}

	public void setCompKeyProjectAchievementCompIdMin(Long compKeyProjectAchievementCompIdMin) {
		this.compKeyProjectAchievementCompIdMin = compKeyProjectAchievementCompIdMin;
	}

	public Long getCompKeyProjectAchievementCompIdMax() {
		return compKeyProjectAchievementCompIdMax;
	}

	public void setCompKeyProjectAchievementCompIdMax(Long compKeyProjectAchievementCompIdMax) {
		this.compKeyProjectAchievementCompIdMax = compKeyProjectAchievementCompIdMax;
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

	public Date getCompKeyProjectAchievementStartDateMin() {
		return compKeyProjectAchievementStartDateMin;
	}

	public void setCompKeyProjectAchievementStartDateMin(Date compKeyProjectAchievementStartDateMin) {
		this.compKeyProjectAchievementStartDateMin = compKeyProjectAchievementStartDateMin;
	}

	public Date getCompKeyProjectAchievementStartDateMax() {
		return compKeyProjectAchievementStartDateMax;
	}

	public void setCompKeyProjectAchievementStartDateMax(Date compKeyProjectAchievementStartDateMax) {
		this.compKeyProjectAchievementStartDateMax = compKeyProjectAchievementStartDateMax;
	}

	public Date getCompKeyProjectAchievementEndDate() {
		return compKeyProjectAchievementEndDate;
	}

	public void setCompKeyProjectAchievementEndDate(Date compKeyProjectAchievementEndDate) {
		this.compKeyProjectAchievementEndDate = compKeyProjectAchievementEndDate;
	}

	public Date getCompKeyProjectAchievementEndDateMin() {
		return compKeyProjectAchievementEndDateMin;
	}

	public void setCompKeyProjectAchievementEndDateMin(Date compKeyProjectAchievementEndDateMin) {
		this.compKeyProjectAchievementEndDateMin = compKeyProjectAchievementEndDateMin;
	}

	public Date getCompKeyProjectAchievementEndDateMax() {
		return compKeyProjectAchievementEndDateMax;
	}

	public void setCompKeyProjectAchievementEndDateMax(Date compKeyProjectAchievementEndDateMax) {
		this.compKeyProjectAchievementEndDateMax = compKeyProjectAchievementEndDateMax;
	}

	public Integer getCompKeyProjectAchievementVersion() {
		return compKeyProjectAchievementVersion;
	}

	public void setCompKeyProjectAchievementVersion(Integer compKeyProjectAchievementVersion) {
		this.compKeyProjectAchievementVersion = compKeyProjectAchievementVersion;
	}

	public Integer getCompKeyProjectAchievementVersionMin() {
		return compKeyProjectAchievementVersionMin;
	}

	public void setCompKeyProjectAchievementVersionMin(Integer compKeyProjectAchievementVersionMin) {
		this.compKeyProjectAchievementVersionMin = compKeyProjectAchievementVersionMin;
	}

	public Integer getCompKeyProjectAchievementVersionMax() {
		return compKeyProjectAchievementVersionMax;
	}

	public void setCompKeyProjectAchievementVersionMax(Integer compKeyProjectAchievementVersionMax) {
		this.compKeyProjectAchievementVersionMax = compKeyProjectAchievementVersionMax;
	}

	public Date getCompKeyProjectAchievementCreateTime() {
		return compKeyProjectAchievementCreateTime;
	}

	public void setCompKeyProjectAchievementCreateTime(Date compKeyProjectAchievementCreateTime) {
		this.compKeyProjectAchievementCreateTime = compKeyProjectAchievementCreateTime;
	}

	public Date getCompKeyProjectAchievementCreateTimeMin() {
		return compKeyProjectAchievementCreateTimeMin;
	}

	public void setCompKeyProjectAchievementCreateTimeMin(Date compKeyProjectAchievementCreateTimeMin) {
		this.compKeyProjectAchievementCreateTimeMin = compKeyProjectAchievementCreateTimeMin;
	}

	public Date getCompKeyProjectAchievementCreateTimeMax() {
		return compKeyProjectAchievementCreateTimeMax;
	}

	public void setCompKeyProjectAchievementCreateTimeMax(Date compKeyProjectAchievementCreateTimeMax) {
		this.compKeyProjectAchievementCreateTimeMax = compKeyProjectAchievementCreateTimeMax;
	}

	public Date getCompKeyProjectAchievementUpdateTime() {
		return compKeyProjectAchievementUpdateTime;
	}

	public void setCompKeyProjectAchievementUpdateTime(Date compKeyProjectAchievementUpdateTime) {
		this.compKeyProjectAchievementUpdateTime = compKeyProjectAchievementUpdateTime;
	}

	public Date getCompKeyProjectAchievementUpdateTimeMin() {
		return compKeyProjectAchievementUpdateTimeMin;
	}

	public void setCompKeyProjectAchievementUpdateTimeMin(Date compKeyProjectAchievementUpdateTimeMin) {
		this.compKeyProjectAchievementUpdateTimeMin = compKeyProjectAchievementUpdateTimeMin;
	}

	public Date getCompKeyProjectAchievementUpdateTimeMax() {
		return compKeyProjectAchievementUpdateTimeMax;
	}

	public void setCompKeyProjectAchievementUpdateTimeMax(Date compKeyProjectAchievementUpdateTimeMax) {
		this.compKeyProjectAchievementUpdateTimeMax = compKeyProjectAchievementUpdateTimeMax;
	}

	public Byte getCompKeyProjectAchievementIsActive() {
		return compKeyProjectAchievementIsActive;
	}

	public void setCompKeyProjectAchievementIsActive(Byte compKeyProjectAchievementIsActive) {
		this.compKeyProjectAchievementIsActive = compKeyProjectAchievementIsActive;
	}

	public Byte getCompKeyProjectAchievementIsActiveMin() {
		return compKeyProjectAchievementIsActiveMin;
	}

	public void setCompKeyProjectAchievementIsActiveMin(Byte compKeyProjectAchievementIsActiveMin) {
		this.compKeyProjectAchievementIsActiveMin = compKeyProjectAchievementIsActiveMin;
	}

	public Byte getCompKeyProjectAchievementIsActiveMax() {
		return compKeyProjectAchievementIsActiveMax;
	}

	public void setCompKeyProjectAchievementIsActiveMax(Byte compKeyProjectAchievementIsActiveMax) {
		this.compKeyProjectAchievementIsActiveMax = compKeyProjectAchievementIsActiveMax;
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
        return "CompKeyProjectAchievementCompanyQuery {" +
                "compKeyProjectAchievementId = " + compKeyProjectAchievementId + 
				", compKeyProjectAchievementIdMin = " + compKeyProjectAchievementIdMin + 
				", compKeyProjectAchievementIdMax = " + compKeyProjectAchievementIdMax + 
				", compKeyProjectAchievementCompId = " + compKeyProjectAchievementCompId + 
				", compKeyProjectAchievementCompIdMin = " + compKeyProjectAchievementCompIdMin + 
				", compKeyProjectAchievementCompIdMax = " + compKeyProjectAchievementCompIdMax + 
				", compKeyProjectAchievementProjectName = " + compKeyProjectAchievementProjectName + 
				", compKeyProjectAchievementBuildComp = " + compKeyProjectAchievementBuildComp + 
				", compKeyProjectAchievementMarkMoney = " + compKeyProjectAchievementMarkMoney + 
				", compKeyProjectAchievementStartDate = " + compKeyProjectAchievementStartDate + 
				", compKeyProjectAchievementStartDateMin = " + compKeyProjectAchievementStartDateMin + 
				", compKeyProjectAchievementStartDateMax = " + compKeyProjectAchievementStartDateMax + 
				", compKeyProjectAchievementEndDate = " + compKeyProjectAchievementEndDate + 
				", compKeyProjectAchievementEndDateMin = " + compKeyProjectAchievementEndDateMin + 
				", compKeyProjectAchievementEndDateMax = " + compKeyProjectAchievementEndDateMax + 
				", compKeyProjectAchievementVersion = " + compKeyProjectAchievementVersion + 
				", compKeyProjectAchievementVersionMin = " + compKeyProjectAchievementVersionMin + 
				", compKeyProjectAchievementVersionMax = " + compKeyProjectAchievementVersionMax + 
				", compKeyProjectAchievementCreateTime = " + compKeyProjectAchievementCreateTime + 
				", compKeyProjectAchievementCreateTimeMin = " + compKeyProjectAchievementCreateTimeMin + 
				", compKeyProjectAchievementCreateTimeMax = " + compKeyProjectAchievementCreateTimeMax + 
				", compKeyProjectAchievementUpdateTime = " + compKeyProjectAchievementUpdateTime + 
				", compKeyProjectAchievementUpdateTimeMin = " + compKeyProjectAchievementUpdateTimeMin + 
				", compKeyProjectAchievementUpdateTimeMax = " + compKeyProjectAchievementUpdateTimeMax + 
				", compKeyProjectAchievementIsActive = " + compKeyProjectAchievementIsActive + 
				", compKeyProjectAchievementIsActiveMin = " + compKeyProjectAchievementIsActiveMin + 
				", compKeyProjectAchievementIsActiveMax = " + compKeyProjectAchievementIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
