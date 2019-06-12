package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterMonitorAchievementCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterMonitorAchievementCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036149551899L;

    //t_comp_water_monitor_achievement表的字段对应的属性
	// 企业水利监理业绩编号
	private Long compWaterMonitorAchievementId;
	// 企业水利监理业绩编号（最小值）
	private Long compWaterMonitorAchievementIdMin;
	// 企业水利监理业绩编号（最大值）
	private Long compWaterMonitorAchievementIdMax;
	// 企业编号
	private Long compWaterMonitorAchievementCompId;
	// 企业编号（最小值）
	private Long compWaterMonitorAchievementCompIdMin;
	// 企业编号（最大值）
	private Long compWaterMonitorAchievementCompIdMax;
	// 工程名称
	private String compWaterMonitorAchievementProjectName;
	// 项目类型
	private String compWaterMonitorAchievementProjectType;
	// 建设单位
	private String compWaterMonitorAchievementBuildComp;
	// 合同金额
	private String compWaterMonitorAchievementContractAmount;
	// 合同签订日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementContractDate;
	// 合同签订日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementContractDateMin;
	// 合同签订日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementContractDateMax;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementStartDate;
	// 开工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementStartDateMin;
	// 开工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementStartDateMax;
	// 版本号
	private Integer compWaterMonitorAchievementVersion;
	// 版本号（最小值）
	private Integer compWaterMonitorAchievementVersionMin;
	// 版本号（最大值）
	private Integer compWaterMonitorAchievementVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterMonitorAchievementUpdateTimeMax;
	// 是否激活
	private Byte compWaterMonitorAchievementIsActive;
	// 是否激活（最小值）
	private Byte compWaterMonitorAchievementIsActiveMin;
	// 是否激活（最大值）
	private Byte compWaterMonitorAchievementIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	// 金额 （最小值）
	private BigDecimal moneyMin;
	// 金额 （最大值）
	private BigDecimal moneyMax;
	// 金额
	private BigDecimal money;

	public BigDecimal getMoneyMin() {
		return moneyMin;
	}

	public void setMoneyMin(BigDecimal moneyMin) {
		this.moneyMin = moneyMin;
	}

	public BigDecimal getMoneyMax() {
		return moneyMax;
	}

	public void setMoneyMax(BigDecimal moneyMax) {
		this.moneyMax = moneyMax;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
    public CompWaterMonitorAchievementCompanyQuery () {}

    public CompWaterMonitorAchievementCompanyQuery (Long compWaterMonitorAchievementId, Long compWaterMonitorAchievementIdMin, Long compWaterMonitorAchievementIdMax, Long compWaterMonitorAchievementCompId, Long compWaterMonitorAchievementCompIdMin, Long compWaterMonitorAchievementCompIdMax, String compWaterMonitorAchievementProjectName, String compWaterMonitorAchievementProjectType, String compWaterMonitorAchievementBuildComp, String compWaterMonitorAchievementContractAmount, Date compWaterMonitorAchievementContractDate, Date compWaterMonitorAchievementContractDateMin, Date compWaterMonitorAchievementContractDateMax, Date compWaterMonitorAchievementStartDate, Date compWaterMonitorAchievementStartDateMin, Date compWaterMonitorAchievementStartDateMax, Integer compWaterMonitorAchievementVersion, Integer compWaterMonitorAchievementVersionMin, Integer compWaterMonitorAchievementVersionMax, Date compWaterMonitorAchievementCreateTime, Date compWaterMonitorAchievementCreateTimeMin, Date compWaterMonitorAchievementCreateTimeMax, Date compWaterMonitorAchievementUpdateTime, Date compWaterMonitorAchievementUpdateTimeMin, Date compWaterMonitorAchievementUpdateTimeMax, Byte compWaterMonitorAchievementIsActive, Byte compWaterMonitorAchievementIsActiveMin, Byte compWaterMonitorAchievementIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compWaterMonitorAchievementId = compWaterMonitorAchievementId;
		this.compWaterMonitorAchievementIdMin = compWaterMonitorAchievementIdMin;
		this.compWaterMonitorAchievementIdMax = compWaterMonitorAchievementIdMax;
		this.compWaterMonitorAchievementCompId = compWaterMonitorAchievementCompId;
		this.compWaterMonitorAchievementCompIdMin = compWaterMonitorAchievementCompIdMin;
		this.compWaterMonitorAchievementCompIdMax = compWaterMonitorAchievementCompIdMax;
		this.compWaterMonitorAchievementProjectName = compWaterMonitorAchievementProjectName;
		this.compWaterMonitorAchievementProjectType = compWaterMonitorAchievementProjectType;
		this.compWaterMonitorAchievementBuildComp = compWaterMonitorAchievementBuildComp;
		this.compWaterMonitorAchievementContractAmount = compWaterMonitorAchievementContractAmount;
		this.compWaterMonitorAchievementContractDate = compWaterMonitorAchievementContractDate;
		this.compWaterMonitorAchievementContractDateMin = compWaterMonitorAchievementContractDateMin;
		this.compWaterMonitorAchievementContractDateMax = compWaterMonitorAchievementContractDateMax;
		this.compWaterMonitorAchievementStartDate = compWaterMonitorAchievementStartDate;
		this.compWaterMonitorAchievementStartDateMin = compWaterMonitorAchievementStartDateMin;
		this.compWaterMonitorAchievementStartDateMax = compWaterMonitorAchievementStartDateMax;
		this.compWaterMonitorAchievementVersion = compWaterMonitorAchievementVersion;
		this.compWaterMonitorAchievementVersionMin = compWaterMonitorAchievementVersionMin;
		this.compWaterMonitorAchievementVersionMax = compWaterMonitorAchievementVersionMax;
		this.compWaterMonitorAchievementCreateTime = compWaterMonitorAchievementCreateTime;
		this.compWaterMonitorAchievementCreateTimeMin = compWaterMonitorAchievementCreateTimeMin;
		this.compWaterMonitorAchievementCreateTimeMax = compWaterMonitorAchievementCreateTimeMax;
		this.compWaterMonitorAchievementUpdateTime = compWaterMonitorAchievementUpdateTime;
		this.compWaterMonitorAchievementUpdateTimeMin = compWaterMonitorAchievementUpdateTimeMin;
		this.compWaterMonitorAchievementUpdateTimeMax = compWaterMonitorAchievementUpdateTimeMax;
		this.compWaterMonitorAchievementIsActive = compWaterMonitorAchievementIsActive;
		this.compWaterMonitorAchievementIsActiveMin = compWaterMonitorAchievementIsActiveMin;
		this.compWaterMonitorAchievementIsActiveMax = compWaterMonitorAchievementIsActiveMax;
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

	public Long getCompWaterMonitorAchievementIdMin() {
		return compWaterMonitorAchievementIdMin;
	}

	public void setCompWaterMonitorAchievementIdMin(Long compWaterMonitorAchievementIdMin) {
		this.compWaterMonitorAchievementIdMin = compWaterMonitorAchievementIdMin;
	}

	public Long getCompWaterMonitorAchievementIdMax() {
		return compWaterMonitorAchievementIdMax;
	}

	public void setCompWaterMonitorAchievementIdMax(Long compWaterMonitorAchievementIdMax) {
		this.compWaterMonitorAchievementIdMax = compWaterMonitorAchievementIdMax;
	}

	public Long getCompWaterMonitorAchievementCompId() {
		return compWaterMonitorAchievementCompId;
	}

	public void setCompWaterMonitorAchievementCompId(Long compWaterMonitorAchievementCompId) {
		this.compWaterMonitorAchievementCompId = compWaterMonitorAchievementCompId;
	}

	public Long getCompWaterMonitorAchievementCompIdMin() {
		return compWaterMonitorAchievementCompIdMin;
	}

	public void setCompWaterMonitorAchievementCompIdMin(Long compWaterMonitorAchievementCompIdMin) {
		this.compWaterMonitorAchievementCompIdMin = compWaterMonitorAchievementCompIdMin;
	}

	public Long getCompWaterMonitorAchievementCompIdMax() {
		return compWaterMonitorAchievementCompIdMax;
	}

	public void setCompWaterMonitorAchievementCompIdMax(Long compWaterMonitorAchievementCompIdMax) {
		this.compWaterMonitorAchievementCompIdMax = compWaterMonitorAchievementCompIdMax;
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

	public Date getCompWaterMonitorAchievementContractDateMin() {
		return compWaterMonitorAchievementContractDateMin;
	}

	public void setCompWaterMonitorAchievementContractDateMin(Date compWaterMonitorAchievementContractDateMin) {
		this.compWaterMonitorAchievementContractDateMin = compWaterMonitorAchievementContractDateMin;
	}

	public Date getCompWaterMonitorAchievementContractDateMax() {
		return compWaterMonitorAchievementContractDateMax;
	}

	public void setCompWaterMonitorAchievementContractDateMax(Date compWaterMonitorAchievementContractDateMax) {
		this.compWaterMonitorAchievementContractDateMax = compWaterMonitorAchievementContractDateMax;
	}

	public Date getCompWaterMonitorAchievementStartDate() {
		return compWaterMonitorAchievementStartDate;
	}

	public void setCompWaterMonitorAchievementStartDate(Date compWaterMonitorAchievementStartDate) {
		this.compWaterMonitorAchievementStartDate = compWaterMonitorAchievementStartDate;
	}

	public Date getCompWaterMonitorAchievementStartDateMin() {
		return compWaterMonitorAchievementStartDateMin;
	}

	public void setCompWaterMonitorAchievementStartDateMin(Date compWaterMonitorAchievementStartDateMin) {
		this.compWaterMonitorAchievementStartDateMin = compWaterMonitorAchievementStartDateMin;
	}

	public Date getCompWaterMonitorAchievementStartDateMax() {
		return compWaterMonitorAchievementStartDateMax;
	}

	public void setCompWaterMonitorAchievementStartDateMax(Date compWaterMonitorAchievementStartDateMax) {
		this.compWaterMonitorAchievementStartDateMax = compWaterMonitorAchievementStartDateMax;
	}

	public Integer getCompWaterMonitorAchievementVersion() {
		return compWaterMonitorAchievementVersion;
	}

	public void setCompWaterMonitorAchievementVersion(Integer compWaterMonitorAchievementVersion) {
		this.compWaterMonitorAchievementVersion = compWaterMonitorAchievementVersion;
	}

	public Integer getCompWaterMonitorAchievementVersionMin() {
		return compWaterMonitorAchievementVersionMin;
	}

	public void setCompWaterMonitorAchievementVersionMin(Integer compWaterMonitorAchievementVersionMin) {
		this.compWaterMonitorAchievementVersionMin = compWaterMonitorAchievementVersionMin;
	}

	public Integer getCompWaterMonitorAchievementVersionMax() {
		return compWaterMonitorAchievementVersionMax;
	}

	public void setCompWaterMonitorAchievementVersionMax(Integer compWaterMonitorAchievementVersionMax) {
		this.compWaterMonitorAchievementVersionMax = compWaterMonitorAchievementVersionMax;
	}

	public Date getCompWaterMonitorAchievementCreateTime() {
		return compWaterMonitorAchievementCreateTime;
	}

	public void setCompWaterMonitorAchievementCreateTime(Date compWaterMonitorAchievementCreateTime) {
		this.compWaterMonitorAchievementCreateTime = compWaterMonitorAchievementCreateTime;
	}

	public Date getCompWaterMonitorAchievementCreateTimeMin() {
		return compWaterMonitorAchievementCreateTimeMin;
	}

	public void setCompWaterMonitorAchievementCreateTimeMin(Date compWaterMonitorAchievementCreateTimeMin) {
		this.compWaterMonitorAchievementCreateTimeMin = compWaterMonitorAchievementCreateTimeMin;
	}

	public Date getCompWaterMonitorAchievementCreateTimeMax() {
		return compWaterMonitorAchievementCreateTimeMax;
	}

	public void setCompWaterMonitorAchievementCreateTimeMax(Date compWaterMonitorAchievementCreateTimeMax) {
		this.compWaterMonitorAchievementCreateTimeMax = compWaterMonitorAchievementCreateTimeMax;
	}

	public Date getCompWaterMonitorAchievementUpdateTime() {
		return compWaterMonitorAchievementUpdateTime;
	}

	public void setCompWaterMonitorAchievementUpdateTime(Date compWaterMonitorAchievementUpdateTime) {
		this.compWaterMonitorAchievementUpdateTime = compWaterMonitorAchievementUpdateTime;
	}

	public Date getCompWaterMonitorAchievementUpdateTimeMin() {
		return compWaterMonitorAchievementUpdateTimeMin;
	}

	public void setCompWaterMonitorAchievementUpdateTimeMin(Date compWaterMonitorAchievementUpdateTimeMin) {
		this.compWaterMonitorAchievementUpdateTimeMin = compWaterMonitorAchievementUpdateTimeMin;
	}

	public Date getCompWaterMonitorAchievementUpdateTimeMax() {
		return compWaterMonitorAchievementUpdateTimeMax;
	}

	public void setCompWaterMonitorAchievementUpdateTimeMax(Date compWaterMonitorAchievementUpdateTimeMax) {
		this.compWaterMonitorAchievementUpdateTimeMax = compWaterMonitorAchievementUpdateTimeMax;
	}

	public Byte getCompWaterMonitorAchievementIsActive() {
		return compWaterMonitorAchievementIsActive;
	}

	public void setCompWaterMonitorAchievementIsActive(Byte compWaterMonitorAchievementIsActive) {
		this.compWaterMonitorAchievementIsActive = compWaterMonitorAchievementIsActive;
	}

	public Byte getCompWaterMonitorAchievementIsActiveMin() {
		return compWaterMonitorAchievementIsActiveMin;
	}

	public void setCompWaterMonitorAchievementIsActiveMin(Byte compWaterMonitorAchievementIsActiveMin) {
		this.compWaterMonitorAchievementIsActiveMin = compWaterMonitorAchievementIsActiveMin;
	}

	public Byte getCompWaterMonitorAchievementIsActiveMax() {
		return compWaterMonitorAchievementIsActiveMax;
	}

	public void setCompWaterMonitorAchievementIsActiveMax(Byte compWaterMonitorAchievementIsActiveMax) {
		this.compWaterMonitorAchievementIsActiveMax = compWaterMonitorAchievementIsActiveMax;
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
        return "CompWaterMonitorAchievementCompanyQuery {" +
                "compWaterMonitorAchievementId = " + compWaterMonitorAchievementId + 
				", compWaterMonitorAchievementIdMin = " + compWaterMonitorAchievementIdMin + 
				", compWaterMonitorAchievementIdMax = " + compWaterMonitorAchievementIdMax + 
				", compWaterMonitorAchievementCompId = " + compWaterMonitorAchievementCompId + 
				", compWaterMonitorAchievementCompIdMin = " + compWaterMonitorAchievementCompIdMin + 
				", compWaterMonitorAchievementCompIdMax = " + compWaterMonitorAchievementCompIdMax + 
				", compWaterMonitorAchievementProjectName = " + compWaterMonitorAchievementProjectName + 
				", compWaterMonitorAchievementProjectType = " + compWaterMonitorAchievementProjectType + 
				", compWaterMonitorAchievementBuildComp = " + compWaterMonitorAchievementBuildComp + 
				", compWaterMonitorAchievementContractAmount = " + compWaterMonitorAchievementContractAmount + 
				", compWaterMonitorAchievementContractDate = " + compWaterMonitorAchievementContractDate + 
				", compWaterMonitorAchievementContractDateMin = " + compWaterMonitorAchievementContractDateMin + 
				", compWaterMonitorAchievementContractDateMax = " + compWaterMonitorAchievementContractDateMax + 
				", compWaterMonitorAchievementStartDate = " + compWaterMonitorAchievementStartDate + 
				", compWaterMonitorAchievementStartDateMin = " + compWaterMonitorAchievementStartDateMin + 
				", compWaterMonitorAchievementStartDateMax = " + compWaterMonitorAchievementStartDateMax + 
				", compWaterMonitorAchievementVersion = " + compWaterMonitorAchievementVersion + 
				", compWaterMonitorAchievementVersionMin = " + compWaterMonitorAchievementVersionMin + 
				", compWaterMonitorAchievementVersionMax = " + compWaterMonitorAchievementVersionMax + 
				", compWaterMonitorAchievementCreateTime = " + compWaterMonitorAchievementCreateTime + 
				", compWaterMonitorAchievementCreateTimeMin = " + compWaterMonitorAchievementCreateTimeMin + 
				", compWaterMonitorAchievementCreateTimeMax = " + compWaterMonitorAchievementCreateTimeMax + 
				", compWaterMonitorAchievementUpdateTime = " + compWaterMonitorAchievementUpdateTime + 
				", compWaterMonitorAchievementUpdateTimeMin = " + compWaterMonitorAchievementUpdateTimeMin + 
				", compWaterMonitorAchievementUpdateTimeMax = " + compWaterMonitorAchievementUpdateTimeMax + 
				", compWaterMonitorAchievementIsActive = " + compWaterMonitorAchievementIsActive + 
				", compWaterMonitorAchievementIsActiveMin = " + compWaterMonitorAchievementIsActiveMin + 
				", compWaterMonitorAchievementIsActiveMax = " + compWaterMonitorAchievementIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
