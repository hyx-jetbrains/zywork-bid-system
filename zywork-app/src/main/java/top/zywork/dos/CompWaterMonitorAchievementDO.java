package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompWaterMonitorAchievementDO数据对象实体类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterMonitorAchievementDO extends BaseDO {

    private static final long serialVersionUID = -9223372034844921986L;

    // 企业水利监理业绩编号
	private Long id;
	// 企业编号
	private Long compId;
	// 工程名称
	private String projectName;
	// 项目类型
	private String projectType;
	// 建设单位
	private String buildComp;
	// 合同金额
	private String contractAmount;
	// 合同签订日期
	private Date contractDate;
	// 开工时间
	private Date startDate;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CompWaterMonitorAchievementDO () {}

    public CompWaterMonitorAchievementDO (Long id, Long compId, String projectName, String projectType, String buildComp, String contractAmount, Date contractDate, Date startDate, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.projectName = projectName;
		this.projectType = projectType;
		this.buildComp = buildComp;
		this.contractAmount = contractAmount;
		this.contractDate = contractDate;
		this.startDate = startDate;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "CompWaterMonitorAchievementDO {" +
                "id = " + id + 
				", compId = " + compId + 
				", projectName = " + projectName + 
				", projectType = " + projectType + 
				", buildComp = " + buildComp + 
				", contractAmount = " + contractAmount + 
				", contractDate = " + contractDate + 
				", startDate = " + startDate + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
