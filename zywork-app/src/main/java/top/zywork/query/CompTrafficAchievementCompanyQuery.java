package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompTrafficAchievementCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompTrafficAchievementCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036188977469L;

    //t_comp_traffic_achievement表的字段对应的属性
	// 企业交通业绩编号
	private Long compTrafficAchievementId;
	// 企业交通业绩编号（最小值）
	private Long compTrafficAchievementIdMin;
	// 企业交通业绩编号（最大值）
	private Long compTrafficAchievementIdMax;
	// 企业编号
	private Long compTrafficAchievementCompId;
	// 企业编号（最小值）
	private Long compTrafficAchievementCompIdMin;
	// 企业编号（最大值）
	private Long compTrafficAchievementCompIdMax;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementStartDate;
	// 开工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementStartDateMin;
	// 开工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementStartDateMax;
	// 竣工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementEndDate;
	// 竣工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementEndDateMin;
	// 竣工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementEndDateMax;
	// 验证状态
	private String compTrafficAchievementValidStatus;
	// 版本号
	private Integer compTrafficAchievementVersion;
	// 版本号（最小值）
	private Integer compTrafficAchievementVersionMin;
	// 版本号（最大值）
	private Integer compTrafficAchievementVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compTrafficAchievementUpdateTimeMax;
	// 是否激活
	private Byte compTrafficAchievementIsActive;
	// 是否激活（最小值）
	private Byte compTrafficAchievementIsActiveMin;
	// 是否激活（最大值）
	private Byte compTrafficAchievementIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompTrafficAchievementCompanyQuery () {}

    public CompTrafficAchievementCompanyQuery (Long compTrafficAchievementId, Long compTrafficAchievementIdMin, Long compTrafficAchievementIdMax, Long compTrafficAchievementCompId, Long compTrafficAchievementCompIdMin, Long compTrafficAchievementCompIdMax, String compTrafficAchievementProjectName, String compTrafficAchievementName, String compTrafficAchievementTechnologyName, String compTrafficAchievementContractAmount, String compTrafficAchievementWorkAddr, Date compTrafficAchievementStartDate, Date compTrafficAchievementStartDateMin, Date compTrafficAchievementStartDateMax, Date compTrafficAchievementEndDate, Date compTrafficAchievementEndDateMin, Date compTrafficAchievementEndDateMax, String compTrafficAchievementValidStatus, Integer compTrafficAchievementVersion, Integer compTrafficAchievementVersionMin, Integer compTrafficAchievementVersionMax, Date compTrafficAchievementCreateTime, Date compTrafficAchievementCreateTimeMin, Date compTrafficAchievementCreateTimeMax, Date compTrafficAchievementUpdateTime, Date compTrafficAchievementUpdateTimeMin, Date compTrafficAchievementUpdateTimeMax, Byte compTrafficAchievementIsActive, Byte compTrafficAchievementIsActiveMin, Byte compTrafficAchievementIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compTrafficAchievementId = compTrafficAchievementId;
		this.compTrafficAchievementIdMin = compTrafficAchievementIdMin;
		this.compTrafficAchievementIdMax = compTrafficAchievementIdMax;
		this.compTrafficAchievementCompId = compTrafficAchievementCompId;
		this.compTrafficAchievementCompIdMin = compTrafficAchievementCompIdMin;
		this.compTrafficAchievementCompIdMax = compTrafficAchievementCompIdMax;
		this.compTrafficAchievementProjectName = compTrafficAchievementProjectName;
		this.compTrafficAchievementName = compTrafficAchievementName;
		this.compTrafficAchievementTechnologyName = compTrafficAchievementTechnologyName;
		this.compTrafficAchievementContractAmount = compTrafficAchievementContractAmount;
		this.compTrafficAchievementWorkAddr = compTrafficAchievementWorkAddr;
		this.compTrafficAchievementStartDate = compTrafficAchievementStartDate;
		this.compTrafficAchievementStartDateMin = compTrafficAchievementStartDateMin;
		this.compTrafficAchievementStartDateMax = compTrafficAchievementStartDateMax;
		this.compTrafficAchievementEndDate = compTrafficAchievementEndDate;
		this.compTrafficAchievementEndDateMin = compTrafficAchievementEndDateMin;
		this.compTrafficAchievementEndDateMax = compTrafficAchievementEndDateMax;
		this.compTrafficAchievementValidStatus = compTrafficAchievementValidStatus;
		this.compTrafficAchievementVersion = compTrafficAchievementVersion;
		this.compTrafficAchievementVersionMin = compTrafficAchievementVersionMin;
		this.compTrafficAchievementVersionMax = compTrafficAchievementVersionMax;
		this.compTrafficAchievementCreateTime = compTrafficAchievementCreateTime;
		this.compTrafficAchievementCreateTimeMin = compTrafficAchievementCreateTimeMin;
		this.compTrafficAchievementCreateTimeMax = compTrafficAchievementCreateTimeMax;
		this.compTrafficAchievementUpdateTime = compTrafficAchievementUpdateTime;
		this.compTrafficAchievementUpdateTimeMin = compTrafficAchievementUpdateTimeMin;
		this.compTrafficAchievementUpdateTimeMax = compTrafficAchievementUpdateTimeMax;
		this.compTrafficAchievementIsActive = compTrafficAchievementIsActive;
		this.compTrafficAchievementIsActiveMin = compTrafficAchievementIsActiveMin;
		this.compTrafficAchievementIsActiveMax = compTrafficAchievementIsActiveMax;
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

	public Long getCompTrafficAchievementIdMin() {
		return compTrafficAchievementIdMin;
	}

	public void setCompTrafficAchievementIdMin(Long compTrafficAchievementIdMin) {
		this.compTrafficAchievementIdMin = compTrafficAchievementIdMin;
	}

	public Long getCompTrafficAchievementIdMax() {
		return compTrafficAchievementIdMax;
	}

	public void setCompTrafficAchievementIdMax(Long compTrafficAchievementIdMax) {
		this.compTrafficAchievementIdMax = compTrafficAchievementIdMax;
	}

	public Long getCompTrafficAchievementCompId() {
		return compTrafficAchievementCompId;
	}

	public void setCompTrafficAchievementCompId(Long compTrafficAchievementCompId) {
		this.compTrafficAchievementCompId = compTrafficAchievementCompId;
	}

	public Long getCompTrafficAchievementCompIdMin() {
		return compTrafficAchievementCompIdMin;
	}

	public void setCompTrafficAchievementCompIdMin(Long compTrafficAchievementCompIdMin) {
		this.compTrafficAchievementCompIdMin = compTrafficAchievementCompIdMin;
	}

	public Long getCompTrafficAchievementCompIdMax() {
		return compTrafficAchievementCompIdMax;
	}

	public void setCompTrafficAchievementCompIdMax(Long compTrafficAchievementCompIdMax) {
		this.compTrafficAchievementCompIdMax = compTrafficAchievementCompIdMax;
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

	public Date getCompTrafficAchievementStartDateMin() {
		return compTrafficAchievementStartDateMin;
	}

	public void setCompTrafficAchievementStartDateMin(Date compTrafficAchievementStartDateMin) {
		this.compTrafficAchievementStartDateMin = compTrafficAchievementStartDateMin;
	}

	public Date getCompTrafficAchievementStartDateMax() {
		return compTrafficAchievementStartDateMax;
	}

	public void setCompTrafficAchievementStartDateMax(Date compTrafficAchievementStartDateMax) {
		this.compTrafficAchievementStartDateMax = compTrafficAchievementStartDateMax;
	}

	public Date getCompTrafficAchievementEndDate() {
		return compTrafficAchievementEndDate;
	}

	public void setCompTrafficAchievementEndDate(Date compTrafficAchievementEndDate) {
		this.compTrafficAchievementEndDate = compTrafficAchievementEndDate;
	}

	public Date getCompTrafficAchievementEndDateMin() {
		return compTrafficAchievementEndDateMin;
	}

	public void setCompTrafficAchievementEndDateMin(Date compTrafficAchievementEndDateMin) {
		this.compTrafficAchievementEndDateMin = compTrafficAchievementEndDateMin;
	}

	public Date getCompTrafficAchievementEndDateMax() {
		return compTrafficAchievementEndDateMax;
	}

	public void setCompTrafficAchievementEndDateMax(Date compTrafficAchievementEndDateMax) {
		this.compTrafficAchievementEndDateMax = compTrafficAchievementEndDateMax;
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

	public Integer getCompTrafficAchievementVersionMin() {
		return compTrafficAchievementVersionMin;
	}

	public void setCompTrafficAchievementVersionMin(Integer compTrafficAchievementVersionMin) {
		this.compTrafficAchievementVersionMin = compTrafficAchievementVersionMin;
	}

	public Integer getCompTrafficAchievementVersionMax() {
		return compTrafficAchievementVersionMax;
	}

	public void setCompTrafficAchievementVersionMax(Integer compTrafficAchievementVersionMax) {
		this.compTrafficAchievementVersionMax = compTrafficAchievementVersionMax;
	}

	public Date getCompTrafficAchievementCreateTime() {
		return compTrafficAchievementCreateTime;
	}

	public void setCompTrafficAchievementCreateTime(Date compTrafficAchievementCreateTime) {
		this.compTrafficAchievementCreateTime = compTrafficAchievementCreateTime;
	}

	public Date getCompTrafficAchievementCreateTimeMin() {
		return compTrafficAchievementCreateTimeMin;
	}

	public void setCompTrafficAchievementCreateTimeMin(Date compTrafficAchievementCreateTimeMin) {
		this.compTrafficAchievementCreateTimeMin = compTrafficAchievementCreateTimeMin;
	}

	public Date getCompTrafficAchievementCreateTimeMax() {
		return compTrafficAchievementCreateTimeMax;
	}

	public void setCompTrafficAchievementCreateTimeMax(Date compTrafficAchievementCreateTimeMax) {
		this.compTrafficAchievementCreateTimeMax = compTrafficAchievementCreateTimeMax;
	}

	public Date getCompTrafficAchievementUpdateTime() {
		return compTrafficAchievementUpdateTime;
	}

	public void setCompTrafficAchievementUpdateTime(Date compTrafficAchievementUpdateTime) {
		this.compTrafficAchievementUpdateTime = compTrafficAchievementUpdateTime;
	}

	public Date getCompTrafficAchievementUpdateTimeMin() {
		return compTrafficAchievementUpdateTimeMin;
	}

	public void setCompTrafficAchievementUpdateTimeMin(Date compTrafficAchievementUpdateTimeMin) {
		this.compTrafficAchievementUpdateTimeMin = compTrafficAchievementUpdateTimeMin;
	}

	public Date getCompTrafficAchievementUpdateTimeMax() {
		return compTrafficAchievementUpdateTimeMax;
	}

	public void setCompTrafficAchievementUpdateTimeMax(Date compTrafficAchievementUpdateTimeMax) {
		this.compTrafficAchievementUpdateTimeMax = compTrafficAchievementUpdateTimeMax;
	}

	public Byte getCompTrafficAchievementIsActive() {
		return compTrafficAchievementIsActive;
	}

	public void setCompTrafficAchievementIsActive(Byte compTrafficAchievementIsActive) {
		this.compTrafficAchievementIsActive = compTrafficAchievementIsActive;
	}

	public Byte getCompTrafficAchievementIsActiveMin() {
		return compTrafficAchievementIsActiveMin;
	}

	public void setCompTrafficAchievementIsActiveMin(Byte compTrafficAchievementIsActiveMin) {
		this.compTrafficAchievementIsActiveMin = compTrafficAchievementIsActiveMin;
	}

	public Byte getCompTrafficAchievementIsActiveMax() {
		return compTrafficAchievementIsActiveMax;
	}

	public void setCompTrafficAchievementIsActiveMax(Byte compTrafficAchievementIsActiveMax) {
		this.compTrafficAchievementIsActiveMax = compTrafficAchievementIsActiveMax;
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
        return "CompTrafficAchievementCompanyQuery {" +
                "compTrafficAchievementId = " + compTrafficAchievementId + 
				", compTrafficAchievementIdMin = " + compTrafficAchievementIdMin + 
				", compTrafficAchievementIdMax = " + compTrafficAchievementIdMax + 
				", compTrafficAchievementCompId = " + compTrafficAchievementCompId + 
				", compTrafficAchievementCompIdMin = " + compTrafficAchievementCompIdMin + 
				", compTrafficAchievementCompIdMax = " + compTrafficAchievementCompIdMax + 
				", compTrafficAchievementProjectName = " + compTrafficAchievementProjectName + 
				", compTrafficAchievementName = " + compTrafficAchievementName + 
				", compTrafficAchievementTechnologyName = " + compTrafficAchievementTechnologyName + 
				", compTrafficAchievementContractAmount = " + compTrafficAchievementContractAmount + 
				", compTrafficAchievementWorkAddr = " + compTrafficAchievementWorkAddr + 
				", compTrafficAchievementStartDate = " + compTrafficAchievementStartDate + 
				", compTrafficAchievementStartDateMin = " + compTrafficAchievementStartDateMin + 
				", compTrafficAchievementStartDateMax = " + compTrafficAchievementStartDateMax + 
				", compTrafficAchievementEndDate = " + compTrafficAchievementEndDate + 
				", compTrafficAchievementEndDateMin = " + compTrafficAchievementEndDateMin + 
				", compTrafficAchievementEndDateMax = " + compTrafficAchievementEndDateMax + 
				", compTrafficAchievementValidStatus = " + compTrafficAchievementValidStatus + 
				", compTrafficAchievementVersion = " + compTrafficAchievementVersion + 
				", compTrafficAchievementVersionMin = " + compTrafficAchievementVersionMin + 
				", compTrafficAchievementVersionMax = " + compTrafficAchievementVersionMax + 
				", compTrafficAchievementCreateTime = " + compTrafficAchievementCreateTime + 
				", compTrafficAchievementCreateTimeMin = " + compTrafficAchievementCreateTimeMin + 
				", compTrafficAchievementCreateTimeMax = " + compTrafficAchievementCreateTimeMax + 
				", compTrafficAchievementUpdateTime = " + compTrafficAchievementUpdateTime + 
				", compTrafficAchievementUpdateTimeMin = " + compTrafficAchievementUpdateTimeMin + 
				", compTrafficAchievementUpdateTimeMax = " + compTrafficAchievementUpdateTimeMax + 
				", compTrafficAchievementIsActive = " + compTrafficAchievementIsActive + 
				", compTrafficAchievementIsActiveMin = " + compTrafficAchievementIsActiveMin + 
				", compTrafficAchievementIsActiveMax = " + compTrafficAchievementIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
