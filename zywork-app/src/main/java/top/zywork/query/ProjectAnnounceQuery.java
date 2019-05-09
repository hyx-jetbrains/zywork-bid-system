package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectAnnounceQuery查询对象类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class ProjectAnnounceQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035661012474L;

    // 公示编号
	private Long id;
	// 公示编号（最小值）
	private Long idMin;
	// 公示编号（最大值）
	private Long idMax;
	// 项目编号
	private Long projectId;
	// 项目编号（最小值）
	private Long projectIdMin;
	// 项目编号（最大值）
	private Long projectIdMax;
	// 公示详情
	private String announceDesc;
	// 第一候选人
	private String firstCandidate;
	// 第二候选人
	private String secondCandidate;
	// 第三候选人
	private String thirdCandidate;
	// 源地址
	private String sourceUrl;
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
	
    public ProjectAnnounceQuery () {}

    public ProjectAnnounceQuery (Long id, Long idMin, Long idMax, Long projectId, Long projectIdMin, Long projectIdMax, String announceDesc, String firstCandidate, String secondCandidate, String thirdCandidate, String sourceUrl, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.projectId = projectId;
		this.projectIdMin = projectIdMin;
		this.projectIdMax = projectIdMax;
		this.announceDesc = announceDesc;
		this.firstCandidate = firstCandidate;
		this.secondCandidate = secondCandidate;
		this.thirdCandidate = thirdCandidate;
		this.sourceUrl = sourceUrl;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getProjectIdMin() {
		return projectIdMin;
	}

	public void setProjectIdMin(Long projectIdMin) {
		this.projectIdMin = projectIdMin;
	}

	public Long getProjectIdMax() {
		return projectIdMax;
	}

	public void setProjectIdMax(Long projectIdMax) {
		this.projectIdMax = projectIdMax;
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

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
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
        return "ProjectAnnounceQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", projectId = " + projectId + 
				", projectIdMin = " + projectIdMin + 
				", projectIdMax = " + projectIdMax + 
				", announceDesc = " + announceDesc + 
				", firstCandidate = " + firstCandidate + 
				", secondCandidate = " + secondCandidate + 
				", thirdCandidate = " + thirdCandidate + 
				", sourceUrl = " + sourceUrl + 
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
