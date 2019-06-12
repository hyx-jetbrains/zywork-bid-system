package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompKeyProjectAchievementVO值对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompKeyProjectAchievementVO extends BaseVO {

    private static final long serialVersionUID = -9223372035959778112L;

    // 企业重点工程业绩编号
	private Long id;
	// 企业编号
	@NotNull(message = "此项是必须项")
	private Long compId;
	// 工程名称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String projectName;
	// 建设单位
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String buildComp;
	// 中标金额
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String markMoney;
	// 开工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startDate;
	// 竣工时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endDate;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
	
    public CompKeyProjectAchievementVO () {}

    public CompKeyProjectAchievementVO (Long id, Long compId, String projectName, String buildComp, String markMoney, Date startDate, Date endDate, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
        return "CompKeyProjectAchievementVO {" +
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
