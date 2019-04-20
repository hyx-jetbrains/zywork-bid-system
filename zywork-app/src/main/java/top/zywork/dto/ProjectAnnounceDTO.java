package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectAnnounceDTO数据传输对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ProjectAnnounceDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035199940738L;

    // 公示编号
	private Long id;
	// 项目编号
	private Long projectId;
	// 公示详情
	private String announceDesc;
	// 第一候选人
	private String firstCandidate;
	// 第二候选人
	private String secondCandidate;
	// 第三候选人
	private String thirdCandidate;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ProjectAnnounceDTO () {}

    public ProjectAnnounceDTO (Long id, Long projectId, String announceDesc, String firstCandidate, String secondCandidate, String thirdCandidate, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.projectId = projectId;
		this.announceDesc = announceDesc;
		this.firstCandidate = firstCandidate;
		this.secondCandidate = secondCandidate;
		this.thirdCandidate = thirdCandidate;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getAnnounceDesc() {
		return announceDesc;
	}

	public void setAnnounceDesc(String announceDesc) {
		this.announceDesc = announceDesc;
	}

	public String getFirstCandidate() {
		return firstCandidate;
	}

	public void setFirstCandidate(String firstCandidate) {
		this.firstCandidate = firstCandidate;
	}

	public String getSecondCandidate() {
		return secondCandidate;
	}

	public void setSecondCandidate(String secondCandidate) {
		this.secondCandidate = secondCandidate;
	}

	public String getThirdCandidate() {
		return thirdCandidate;
	}

	public void setThirdCandidate(String thirdCandidate) {
		this.thirdCandidate = thirdCandidate;
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
        return "ProjectAnnounceDTO {" +
                "id = " + id + 
				", projectId = " + projectId + 
				", announceDesc = " + announceDesc + 
				", firstCandidate = " + firstCandidate + 
				", secondCandidate = " + secondCandidate + 
				", thirdCandidate = " + thirdCandidate + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
