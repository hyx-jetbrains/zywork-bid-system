package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompWaterDeviseAchievementDO数据对象实体类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterDeviseAchievementDO extends BaseDO {

    private static final long serialVersionUID = -9223372035605376981L;

    // 企业水利勘查设计业绩编号
	private Long id;
	// 企业编号
	private Long compId;
	// 标段(包)名称
	private String projectName;
	// 项目类型
	private String tenderingComp;
	// 招标(单位)人
	private String buildComp;
	// 中标时间
	private Date markDate;
	// 合同金额
	private String contractAmount;
	// 项目负责人
	private String name;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CompWaterDeviseAchievementDO () {}

    public CompWaterDeviseAchievementDO (Long id, Long compId, String projectName, String tenderingComp, String buildComp, Date markDate, String contractAmount, String name, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.projectName = projectName;
		this.tenderingComp = tenderingComp;
		this.buildComp = buildComp;
		this.markDate = markDate;
		this.contractAmount = contractAmount;
		this.name = name;
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
        return "CompWaterDeviseAchievementDO {" +
                "id = " + id + 
				", compId = " + compId + 
				", projectName = " + projectName + 
				", tenderingComp = " + tenderingComp + 
				", buildComp = " + buildComp + 
				", markDate = " + markDate + 
				", contractAmount = " + contractAmount + 
				", name = " + name + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
