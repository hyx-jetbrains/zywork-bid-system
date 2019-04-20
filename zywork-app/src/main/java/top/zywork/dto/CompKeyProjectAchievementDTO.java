package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompKeyProjectAchievementDTO数据传输对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompKeyProjectAchievementDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035643873938L;

    // 企业重点工程业绩编号
	private Long id;
	// 企业编号
	private Long compId;
	// 工程名称
	private String projectName;
	// 建设单位
	private String buildComp;
	// 中标金额
	private String markMoney;
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
	
    public CompKeyProjectAchievementDTO () {}

    public CompKeyProjectAchievementDTO (Long id, Long compId, String projectName, String buildComp, String markMoney, Date startDate, Date endDate, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.projectName = projectName;
		this.buildComp = buildComp;
		this.markMoney = markMoney;
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

	public String getBuildComp() {
		return buildComp;
	}

	public void setBuildComp(String buildComp) {
		this.buildComp = buildComp;
	}

	public String getMarkMoney() {
		return markMoney;
	}

	public void setMarkMoney(String markMoney) {
		this.markMoney = markMoney;
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
        return "CompKeyProjectAchievementDTO {" +
                "id = " + id + 
				", compId = " + compId + 
				", projectName = " + projectName + 
				", buildComp = " + buildComp + 
				", markMoney = " + markMoney + 
				", startDate = " + startDate + 
				", endDate = " + endDate + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
