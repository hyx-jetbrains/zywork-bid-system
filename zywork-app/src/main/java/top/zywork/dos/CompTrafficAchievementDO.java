package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompTrafficAchievementDO数据对象实体类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompTrafficAchievementDO extends BaseDO {

    private static final long serialVersionUID = -9223372036086983569L;

    // 企业交通业绩编号
	private Long id;
	// 企业编号
	private Long compId;
	// 工程名称
	private String projectName;
	// 项目负责人
	private String name;
	// 技术负责人
	private String technologyName;
	// 合同金额
	private String contractAmount;
	// 工程地点
	private String workAddr;
	// 开工时间
	private Date startDate;
	// 竣工时间
	private Date endDate;
	// 验证状态
	private String validStatus;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	// 金额
	private BigDecimal money;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
    public CompTrafficAchievementDO () {}

    public CompTrafficAchievementDO (Long id, Long compId, String projectName, String name, String technologyName, String contractAmount, String workAddr, Date startDate, Date endDate, String validStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.projectName = projectName;
		this.name = name;
		this.technologyName = technologyName;
		this.contractAmount = contractAmount;
		this.workAddr = workAddr;
		this.startDate = startDate;
		this.endDate = endDate;
		this.validStatus = validStatus;
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

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}

	public String getWorkAddr() {
		return workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
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

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
        return "CompTrafficAchievementDO {" +
                "id = " + id + 
				", compId = " + compId + 
				", projectName = " + projectName + 
				", name = " + name + 
				", technologyName = " + technologyName + 
				", contractAmount = " + contractAmount + 
				", workAddr = " + workAddr + 
				", startDate = " + startDate + 
				", endDate = " + endDate + 
				", validStatus = " + validStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
