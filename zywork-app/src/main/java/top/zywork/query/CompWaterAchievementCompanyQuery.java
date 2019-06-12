package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterAchievementCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterAchievementCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035238908839L;

    //t_comp_water_achievement表的字段对应的属性
	// 企业水利业绩编号
	private Long compWaterAchievementId;
	// 企业水利业绩编号（最小值）
	private Long compWaterAchievementIdMin;
	// 企业水利业绩编号（最大值）
	private Long compWaterAchievementIdMax;
	// 企业编号
	private Long compWaterAchievementCompId;
	// 企业编号（最小值）
	private Long compWaterAchievementCompIdMin;
	// 企业编号（最大值）
	private Long compWaterAchievementCompIdMax;
	// 工程名称
	private String compWaterAchievementProjectName;
	// 项目负责人
	private String compWaterAchievementName;
	// 合同金额
	private String compWaterAchievementContractAmount;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementStartDate;
	// 开工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementStartDateMin;
	// 开工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementStartDateMax;
	// 竣工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementEndDate;
	// 竣工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementEndDateMin;
	// 竣工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementEndDateMax;
	// 版本号
	private Integer compWaterAchievementVersion;
	// 版本号（最小值）
	private Integer compWaterAchievementVersionMin;
	// 版本号（最大值）
	private Integer compWaterAchievementVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compWaterAchievementUpdateTimeMax;
	// 是否激活
	private Byte compWaterAchievementIsActive;
	// 是否激活（最小值）
	private Byte compWaterAchievementIsActiveMin;
	// 是否激活（最大值）
	private Byte compWaterAchievementIsActiveMax;
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
	
    public CompWaterAchievementCompanyQuery () {}

    public CompWaterAchievementCompanyQuery (Long compWaterAchievementId, Long compWaterAchievementIdMin, Long compWaterAchievementIdMax, Long compWaterAchievementCompId, Long compWaterAchievementCompIdMin, Long compWaterAchievementCompIdMax, String compWaterAchievementProjectName, String compWaterAchievementName, String compWaterAchievementContractAmount, Date compWaterAchievementStartDate, Date compWaterAchievementStartDateMin, Date compWaterAchievementStartDateMax, Date compWaterAchievementEndDate, Date compWaterAchievementEndDateMin, Date compWaterAchievementEndDateMax, Integer compWaterAchievementVersion, Integer compWaterAchievementVersionMin, Integer compWaterAchievementVersionMax, Date compWaterAchievementCreateTime, Date compWaterAchievementCreateTimeMin, Date compWaterAchievementCreateTimeMax, Date compWaterAchievementUpdateTime, Date compWaterAchievementUpdateTimeMin, Date compWaterAchievementUpdateTimeMax, Byte compWaterAchievementIsActive, Byte compWaterAchievementIsActiveMin, Byte compWaterAchievementIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compWaterAchievementId = compWaterAchievementId;
		this.compWaterAchievementIdMin = compWaterAchievementIdMin;
		this.compWaterAchievementIdMax = compWaterAchievementIdMax;
		this.compWaterAchievementCompId = compWaterAchievementCompId;
		this.compWaterAchievementCompIdMin = compWaterAchievementCompIdMin;
		this.compWaterAchievementCompIdMax = compWaterAchievementCompIdMax;
		this.compWaterAchievementProjectName = compWaterAchievementProjectName;
		this.compWaterAchievementName = compWaterAchievementName;
		this.compWaterAchievementContractAmount = compWaterAchievementContractAmount;
		this.compWaterAchievementStartDate = compWaterAchievementStartDate;
		this.compWaterAchievementStartDateMin = compWaterAchievementStartDateMin;
		this.compWaterAchievementStartDateMax = compWaterAchievementStartDateMax;
		this.compWaterAchievementEndDate = compWaterAchievementEndDate;
		this.compWaterAchievementEndDateMin = compWaterAchievementEndDateMin;
		this.compWaterAchievementEndDateMax = compWaterAchievementEndDateMax;
		this.compWaterAchievementVersion = compWaterAchievementVersion;
		this.compWaterAchievementVersionMin = compWaterAchievementVersionMin;
		this.compWaterAchievementVersionMax = compWaterAchievementVersionMax;
		this.compWaterAchievementCreateTime = compWaterAchievementCreateTime;
		this.compWaterAchievementCreateTimeMin = compWaterAchievementCreateTimeMin;
		this.compWaterAchievementCreateTimeMax = compWaterAchievementCreateTimeMax;
		this.compWaterAchievementUpdateTime = compWaterAchievementUpdateTime;
		this.compWaterAchievementUpdateTimeMin = compWaterAchievementUpdateTimeMin;
		this.compWaterAchievementUpdateTimeMax = compWaterAchievementUpdateTimeMax;
		this.compWaterAchievementIsActive = compWaterAchievementIsActive;
		this.compWaterAchievementIsActiveMin = compWaterAchievementIsActiveMin;
		this.compWaterAchievementIsActiveMax = compWaterAchievementIsActiveMax;
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

	public Long getCompWaterAchievementIdMin() {
		return compWaterAchievementIdMin;
	}

	public void setCompWaterAchievementIdMin(Long compWaterAchievementIdMin) {
		this.compWaterAchievementIdMin = compWaterAchievementIdMin;
	}

	public Long getCompWaterAchievementIdMax() {
		return compWaterAchievementIdMax;
	}

	public void setCompWaterAchievementIdMax(Long compWaterAchievementIdMax) {
		this.compWaterAchievementIdMax = compWaterAchievementIdMax;
	}

	public Long getCompWaterAchievementCompId() {
		return compWaterAchievementCompId;
	}

	public void setCompWaterAchievementCompId(Long compWaterAchievementCompId) {
		this.compWaterAchievementCompId = compWaterAchievementCompId;
	}

	public Long getCompWaterAchievementCompIdMin() {
		return compWaterAchievementCompIdMin;
	}

	public void setCompWaterAchievementCompIdMin(Long compWaterAchievementCompIdMin) {
		this.compWaterAchievementCompIdMin = compWaterAchievementCompIdMin;
	}

	public Long getCompWaterAchievementCompIdMax() {
		return compWaterAchievementCompIdMax;
	}

	public void setCompWaterAchievementCompIdMax(Long compWaterAchievementCompIdMax) {
		this.compWaterAchievementCompIdMax = compWaterAchievementCompIdMax;
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

	public Date getCompWaterAchievementStartDateMin() {
		return compWaterAchievementStartDateMin;
	}

	public void setCompWaterAchievementStartDateMin(Date compWaterAchievementStartDateMin) {
		this.compWaterAchievementStartDateMin = compWaterAchievementStartDateMin;
	}

	public Date getCompWaterAchievementStartDateMax() {
		return compWaterAchievementStartDateMax;
	}

	public void setCompWaterAchievementStartDateMax(Date compWaterAchievementStartDateMax) {
		this.compWaterAchievementStartDateMax = compWaterAchievementStartDateMax;
	}

	public Date getCompWaterAchievementEndDate() {
		return compWaterAchievementEndDate;
	}

	public void setCompWaterAchievementEndDate(Date compWaterAchievementEndDate) {
		this.compWaterAchievementEndDate = compWaterAchievementEndDate;
	}

	public Date getCompWaterAchievementEndDateMin() {
		return compWaterAchievementEndDateMin;
	}

	public void setCompWaterAchievementEndDateMin(Date compWaterAchievementEndDateMin) {
		this.compWaterAchievementEndDateMin = compWaterAchievementEndDateMin;
	}

	public Date getCompWaterAchievementEndDateMax() {
		return compWaterAchievementEndDateMax;
	}

	public void setCompWaterAchievementEndDateMax(Date compWaterAchievementEndDateMax) {
		this.compWaterAchievementEndDateMax = compWaterAchievementEndDateMax;
	}

	public Integer getCompWaterAchievementVersion() {
		return compWaterAchievementVersion;
	}

	public void setCompWaterAchievementVersion(Integer compWaterAchievementVersion) {
		this.compWaterAchievementVersion = compWaterAchievementVersion;
	}

	public Integer getCompWaterAchievementVersionMin() {
		return compWaterAchievementVersionMin;
	}

	public void setCompWaterAchievementVersionMin(Integer compWaterAchievementVersionMin) {
		this.compWaterAchievementVersionMin = compWaterAchievementVersionMin;
	}

	public Integer getCompWaterAchievementVersionMax() {
		return compWaterAchievementVersionMax;
	}

	public void setCompWaterAchievementVersionMax(Integer compWaterAchievementVersionMax) {
		this.compWaterAchievementVersionMax = compWaterAchievementVersionMax;
	}

	public Date getCompWaterAchievementCreateTime() {
		return compWaterAchievementCreateTime;
	}

	public void setCompWaterAchievementCreateTime(Date compWaterAchievementCreateTime) {
		this.compWaterAchievementCreateTime = compWaterAchievementCreateTime;
	}

	public Date getCompWaterAchievementCreateTimeMin() {
		return compWaterAchievementCreateTimeMin;
	}

	public void setCompWaterAchievementCreateTimeMin(Date compWaterAchievementCreateTimeMin) {
		this.compWaterAchievementCreateTimeMin = compWaterAchievementCreateTimeMin;
	}

	public Date getCompWaterAchievementCreateTimeMax() {
		return compWaterAchievementCreateTimeMax;
	}

	public void setCompWaterAchievementCreateTimeMax(Date compWaterAchievementCreateTimeMax) {
		this.compWaterAchievementCreateTimeMax = compWaterAchievementCreateTimeMax;
	}

	public Date getCompWaterAchievementUpdateTime() {
		return compWaterAchievementUpdateTime;
	}

	public void setCompWaterAchievementUpdateTime(Date compWaterAchievementUpdateTime) {
		this.compWaterAchievementUpdateTime = compWaterAchievementUpdateTime;
	}

	public Date getCompWaterAchievementUpdateTimeMin() {
		return compWaterAchievementUpdateTimeMin;
	}

	public void setCompWaterAchievementUpdateTimeMin(Date compWaterAchievementUpdateTimeMin) {
		this.compWaterAchievementUpdateTimeMin = compWaterAchievementUpdateTimeMin;
	}

	public Date getCompWaterAchievementUpdateTimeMax() {
		return compWaterAchievementUpdateTimeMax;
	}

	public void setCompWaterAchievementUpdateTimeMax(Date compWaterAchievementUpdateTimeMax) {
		this.compWaterAchievementUpdateTimeMax = compWaterAchievementUpdateTimeMax;
	}

	public Byte getCompWaterAchievementIsActive() {
		return compWaterAchievementIsActive;
	}

	public void setCompWaterAchievementIsActive(Byte compWaterAchievementIsActive) {
		this.compWaterAchievementIsActive = compWaterAchievementIsActive;
	}

	public Byte getCompWaterAchievementIsActiveMin() {
		return compWaterAchievementIsActiveMin;
	}

	public void setCompWaterAchievementIsActiveMin(Byte compWaterAchievementIsActiveMin) {
		this.compWaterAchievementIsActiveMin = compWaterAchievementIsActiveMin;
	}

	public Byte getCompWaterAchievementIsActiveMax() {
		return compWaterAchievementIsActiveMax;
	}

	public void setCompWaterAchievementIsActiveMax(Byte compWaterAchievementIsActiveMax) {
		this.compWaterAchievementIsActiveMax = compWaterAchievementIsActiveMax;
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
        return "CompWaterAchievementCompanyQuery {" +
                "compWaterAchievementId = " + compWaterAchievementId + 
				", compWaterAchievementIdMin = " + compWaterAchievementIdMin + 
				", compWaterAchievementIdMax = " + compWaterAchievementIdMax + 
				", compWaterAchievementCompId = " + compWaterAchievementCompId + 
				", compWaterAchievementCompIdMin = " + compWaterAchievementCompIdMin + 
				", compWaterAchievementCompIdMax = " + compWaterAchievementCompIdMax + 
				", compWaterAchievementProjectName = " + compWaterAchievementProjectName + 
				", compWaterAchievementName = " + compWaterAchievementName + 
				", compWaterAchievementContractAmount = " + compWaterAchievementContractAmount + 
				", compWaterAchievementStartDate = " + compWaterAchievementStartDate + 
				", compWaterAchievementStartDateMin = " + compWaterAchievementStartDateMin + 
				", compWaterAchievementStartDateMax = " + compWaterAchievementStartDateMax + 
				", compWaterAchievementEndDate = " + compWaterAchievementEndDate + 
				", compWaterAchievementEndDateMin = " + compWaterAchievementEndDateMin + 
				", compWaterAchievementEndDateMax = " + compWaterAchievementEndDateMax + 
				", compWaterAchievementVersion = " + compWaterAchievementVersion + 
				", compWaterAchievementVersionMin = " + compWaterAchievementVersionMin + 
				", compWaterAchievementVersionMax = " + compWaterAchievementVersionMax + 
				", compWaterAchievementCreateTime = " + compWaterAchievementCreateTime + 
				", compWaterAchievementCreateTimeMin = " + compWaterAchievementCreateTimeMin + 
				", compWaterAchievementCreateTimeMax = " + compWaterAchievementCreateTimeMax + 
				", compWaterAchievementUpdateTime = " + compWaterAchievementUpdateTime + 
				", compWaterAchievementUpdateTimeMin = " + compWaterAchievementUpdateTimeMin + 
				", compWaterAchievementUpdateTimeMax = " + compWaterAchievementUpdateTimeMax + 
				", compWaterAchievementIsActive = " + compWaterAchievementIsActive + 
				", compWaterAchievementIsActiveMin = " + compWaterAchievementIsActiveMin + 
				", compWaterAchievementIsActiveMax = " + compWaterAchievementIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
