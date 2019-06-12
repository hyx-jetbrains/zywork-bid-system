package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterMonitorAchievementQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterMonitorAchievementQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035868302069L;

    // 企业水利监理业绩编号
	private Long id;
	// 企业水利监理业绩编号（最小值）
	private Long idMin;
	// 企业水利监理业绩编号（最大值）
	private Long idMax;
	// 企业编号
	private Long compId;
	// 企业编号（最小值）
	private Long compIdMin;
	// 企业编号（最大值）
	private Long compIdMax;
	// 工程名称
	private String projectName;
	// 项目类型
	private String projectType;
	// 建设单位
	private String buildComp;
	// 合同金额
	private String contractAmount;
	// 合同签订日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date contractDate;
	// 合同签订日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date contractDateMin;
	// 合同签订日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date contractDateMax;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startDate;
	// 开工时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startDateMin;
	// 开工时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startDateMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
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
	
    public CompWaterMonitorAchievementQuery () {}

    public CompWaterMonitorAchievementQuery (Long id, Long idMin, Long idMax, Long compId, Long compIdMin, Long compIdMax, String projectName, String projectType, String buildComp, String contractAmount, Date contractDate, Date contractDateMin, Date contractDateMax, Date startDate, Date startDateMin, Date startDateMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.compId = compId;
		this.compIdMin = compIdMin;
		this.compIdMax = compIdMax;
		this.projectName = projectName;
		this.projectType = projectType;
		this.buildComp = buildComp;
		this.contractAmount = contractAmount;
		this.contractDate = contractDate;
		this.contractDateMin = contractDateMin;
		this.contractDateMax = contractDateMax;
		this.startDate = startDate;
		this.startDateMin = startDateMin;
		this.startDateMax = startDateMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public Long getCompIdMin() {
		return compIdMin;
	}

	public void setCompIdMin(Long compIdMin) {
		this.compIdMin = compIdMin;
	}

	public Long getCompIdMax() {
		return compIdMax;
	}

	public void setCompIdMax(Long compIdMax) {
		this.compIdMax = compIdMax;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getBuildComp() {
		return buildComp;
	}

	public void setBuildComp(String buildComp) {
		this.buildComp = buildComp;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getContractDateMin() {
		return contractDateMin;
	}

	public void setContractDateMin(Date contractDateMin) {
		this.contractDateMin = contractDateMin;
	}

	public Date getContractDateMax() {
		return contractDateMax;
	}

	public void setContractDateMax(Date contractDateMax) {
		this.contractDateMax = contractDateMax;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartDateMin() {
		return startDateMin;
	}

	public void setStartDateMin(Date startDateMin) {
		this.startDateMin = startDateMin;
	}

	public Date getStartDateMax() {
		return startDateMax;
	}

	public void setStartDateMax(Date startDateMax) {
		this.startDateMax = startDateMax;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "CompWaterMonitorAchievementQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", compId = " + compId + 
				", compIdMin = " + compIdMin + 
				", compIdMax = " + compIdMax + 
				", projectName = " + projectName + 
				", projectType = " + projectType + 
				", buildComp = " + buildComp + 
				", contractAmount = " + contractAmount + 
				", contractDate = " + contractDate + 
				", contractDateMin = " + contractDateMin + 
				", contractDateMax = " + contractDateMax + 
				", startDate = " + startDate + 
				", startDateMin = " + startDateMin + 
				", startDateMax = " + startDateMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
