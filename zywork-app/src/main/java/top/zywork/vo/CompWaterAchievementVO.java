package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompWaterAchievementVO值对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompWaterAchievementVO extends BaseVO {

    private static final long serialVersionUID = -9223372035352469148L;

    // 企业水利业绩编号
	private Long id;
	// 企业编号
	@NotNull(message = "此项是必须项")
	private Long compId;
	// 工程名称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String projectName;
	// 项目负责人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String name;
	// 合同金额
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String contractAmount;
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
	// 内部地址
	private String inwardHtmlUrl;

	public String getInwardHtmlUrl() {
		return inwardHtmlUrl;
	}

	public void setInwardHtmlUrl(String inwardHtmlUrl) {
		this.inwardHtmlUrl = inwardHtmlUrl;
	}
	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
    public CompWaterAchievementVO () {}

    public CompWaterAchievementVO (Long id, Long compId, String projectName, String name, String contractAmount, Date startDate, Date endDate, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
        return "CompWaterAchievementVO {" +
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
