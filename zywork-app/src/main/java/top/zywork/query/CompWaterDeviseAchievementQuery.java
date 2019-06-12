package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterDeviseAchievementQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterDeviseAchievementQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035402326149L;

    // 企业水利勘查设计业绩编号
	private Long id;
	// 企业水利勘查设计业绩编号（最小值）
	private Long idMin;
	// 企业水利勘查设计业绩编号（最大值）
	private Long idMax;
	// 企业编号
	private Long compId;
	// 企业编号（最小值）
	private Long compIdMin;
	// 企业编号（最大值）
	private Long compIdMax;
	// 标段(包)名称
	private String projectName;
	// 项目类型
	private String tenderingComp;
	// 招标(单位)人
	private String buildComp;
	// 中标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markDate;
	// 中标时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markDateMin;
	// 中标时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markDateMax;
	// 合同金额
	private String contractAmount;
	// 项目负责人
	private String name;
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
	
    public CompWaterDeviseAchievementQuery () {}

    public CompWaterDeviseAchievementQuery (Long id, Long idMin, Long idMax, Long compId, Long compIdMin, Long compIdMax, String projectName, String tenderingComp, String buildComp, Date markDate, Date markDateMin, Date markDateMax, String contractAmount, String name, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.compId = compId;
		this.compIdMin = compIdMin;
		this.compIdMax = compIdMax;
		this.projectName = projectName;
		this.tenderingComp = tenderingComp;
		this.buildComp = buildComp;
		this.markDate = markDate;
		this.markDateMin = markDateMin;
		this.markDateMax = markDateMax;
		this.contractAmount = contractAmount;
		this.name = name;
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

	public String getTenderingComp() {
		return tenderingComp;
	}

	public void setTenderingComp(String tenderingComp) {
		this.tenderingComp = tenderingComp;
	}

	public String getBuildComp() {
		return buildComp;
	}

	public void setBuildComp(String buildComp) {
		this.buildComp = buildComp;
	}

	public Date getMarkDate() {
		return markDate;
	}

	public void setMarkDate(Date markDate) {
		this.markDate = markDate;
	}

	public Date getMarkDateMin() {
		return markDateMin;
	}

	public void setMarkDateMin(Date markDateMin) {
		this.markDateMin = markDateMin;
	}

	public Date getMarkDateMax() {
		return markDateMax;
	}

	public void setMarkDateMax(Date markDateMax) {
		this.markDateMax = markDateMax;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
        return "CompWaterDeviseAchievementQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", compId = " + compId + 
				", compIdMin = " + compIdMin + 
				", compIdMax = " + compIdMax + 
				", projectName = " + projectName + 
				", tenderingComp = " + tenderingComp + 
				", buildComp = " + buildComp + 
				", markDate = " + markDate + 
				", markDateMin = " + markDateMin + 
				", markDateMax = " + markDateMax + 
				", contractAmount = " + contractAmount + 
				", name = " + name + 
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
