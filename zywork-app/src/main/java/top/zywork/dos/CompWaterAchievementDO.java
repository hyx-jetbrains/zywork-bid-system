package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompWaterAchievementDO数据对象实体类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterAchievementDO extends BaseDO {

    private static final long serialVersionUID = -9223372035792791957L;

    // 企业水利业绩编号
	private Long id;
	// 企业编号
	private Long compId;
	// 工程名称
	private String projectName;
	// 项目负责人
	private String name;
	// 合同金额
	private String contractAmount;
	// 开工时间
	private Date startDate;
	// 竣工时间
	private Date endDate;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CompWaterAchievementDO () {}

    public CompWaterAchievementDO (Long id, Long compId, String projectName, String name, String contractAmount, Date startDate, Date endDate, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.projectName = projectName;
		this.name = name;
		this.contractAmount = contractAmount;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
        return "CompWaterAchievementDO {" +
                "id = " + id + 
				", compId = " + compId + 
				", projectName = " + projectName + 
				", name = " + name + 
				", contractAmount = " + contractAmount + 
				", startDate = " + startDate + 
				", endDate = " + endDate + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
