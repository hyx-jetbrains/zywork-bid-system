package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectAnnounceProjectQuery查询对象类<br/>
 *
 * 创建于2019-05-29<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectAnnounceProjectQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034881782069L;

    //t_project_announce表的字段对应的属性
	// 公示编号
	private Long projectAnnounceId;
	// 公示编号（最小值）
	private Long projectAnnounceIdMin;
	// 公示编号（最大值）
	private Long projectAnnounceIdMax;
	// 项目编号
	private Long projectAnnounceProjectId;
	// 项目编号（最小值）
	private Long projectAnnounceProjectIdMin;
	// 项目编号（最大值）
	private Long projectAnnounceProjectIdMax;
	// 公示详情
	private String projectAnnounceAnnounceDesc;
	// 第一候选人
	private String projectAnnounceFirstCandidate;
	// 第二候选人
	private String projectAnnounceSecondCandidate;
	// 第三候选人
	private String projectAnnounceThirdCandidate;
	// 源地址
	private String projectAnnounceSourceUrl;
	// 内部地址
	private String projectAnnounceInwordHtmlUrl;
	// 版本号
	private Integer projectAnnounceVersion;
	// 版本号（最小值）
	private Integer projectAnnounceVersionMin;
	// 版本号（最大值）
	private Integer projectAnnounceVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceUpdateTimeMax;
	// 是否激活
	private Byte projectAnnounceIsActive;
	// 是否激活（最小值）
	private Byte projectAnnounceIsActiveMin;
	// 是否激活（最大值）
	private Byte projectAnnounceIsActiveMax;
	//t_project表的字段对应的属性
	// 项目名称
	private String projectTitle;
	
    public ProjectAnnounceProjectQuery () {}

    public ProjectAnnounceProjectQuery (Long projectAnnounceId, Long projectAnnounceIdMin, Long projectAnnounceIdMax, Long projectAnnounceProjectId, Long projectAnnounceProjectIdMin, Long projectAnnounceProjectIdMax, String projectAnnounceAnnounceDesc, String projectAnnounceFirstCandidate, String projectAnnounceSecondCandidate, String projectAnnounceThirdCandidate, String projectAnnounceSourceUrl, String projectAnnounceInwordHtmlUrl, Integer projectAnnounceVersion, Integer projectAnnounceVersionMin, Integer projectAnnounceVersionMax, Date projectAnnounceCreateTime, Date projectAnnounceCreateTimeMin, Date projectAnnounceCreateTimeMax, Date projectAnnounceUpdateTime, Date projectAnnounceUpdateTimeMin, Date projectAnnounceUpdateTimeMax, Byte projectAnnounceIsActive, Byte projectAnnounceIsActiveMin, Byte projectAnnounceIsActiveMax, String projectTitle) {
        this.projectAnnounceId = projectAnnounceId;
		this.projectAnnounceIdMin = projectAnnounceIdMin;
		this.projectAnnounceIdMax = projectAnnounceIdMax;
		this.projectAnnounceProjectId = projectAnnounceProjectId;
		this.projectAnnounceProjectIdMin = projectAnnounceProjectIdMin;
		this.projectAnnounceProjectIdMax = projectAnnounceProjectIdMax;
		this.projectAnnounceAnnounceDesc = projectAnnounceAnnounceDesc;
		this.projectAnnounceFirstCandidate = projectAnnounceFirstCandidate;
		this.projectAnnounceSecondCandidate = projectAnnounceSecondCandidate;
		this.projectAnnounceThirdCandidate = projectAnnounceThirdCandidate;
		this.projectAnnounceSourceUrl = projectAnnounceSourceUrl;
		this.projectAnnounceInwordHtmlUrl = projectAnnounceInwordHtmlUrl;
		this.projectAnnounceVersion = projectAnnounceVersion;
		this.projectAnnounceVersionMin = projectAnnounceVersionMin;
		this.projectAnnounceVersionMax = projectAnnounceVersionMax;
		this.projectAnnounceCreateTime = projectAnnounceCreateTime;
		this.projectAnnounceCreateTimeMin = projectAnnounceCreateTimeMin;
		this.projectAnnounceCreateTimeMax = projectAnnounceCreateTimeMax;
		this.projectAnnounceUpdateTime = projectAnnounceUpdateTime;
		this.projectAnnounceUpdateTimeMin = projectAnnounceUpdateTimeMin;
		this.projectAnnounceUpdateTimeMax = projectAnnounceUpdateTimeMax;
		this.projectAnnounceIsActive = projectAnnounceIsActive;
		this.projectAnnounceIsActiveMin = projectAnnounceIsActiveMin;
		this.projectAnnounceIsActiveMax = projectAnnounceIsActiveMax;
		this.projectTitle = projectTitle;
		
    }

    public Long getProjectAnnounceId() {
		return projectAnnounceId;
	}

	public void setProjectAnnounceId(Long projectAnnounceId) {
		this.projectAnnounceId = projectAnnounceId;
	}

	public Long getProjectAnnounceIdMin() {
		return projectAnnounceIdMin;
	}

	public void setProjectAnnounceIdMin(Long projectAnnounceIdMin) {
		this.projectAnnounceIdMin = projectAnnounceIdMin;
	}

	public Long getProjectAnnounceIdMax() {
		return projectAnnounceIdMax;
	}

	public void setProjectAnnounceIdMax(Long projectAnnounceIdMax) {
		this.projectAnnounceIdMax = projectAnnounceIdMax;
	}

	public Long getProjectAnnounceProjectId() {
		return projectAnnounceProjectId;
	}

	public void setProjectAnnounceProjectId(Long projectAnnounceProjectId) {
		this.projectAnnounceProjectId = projectAnnounceProjectId;
	}

	public Long getProjectAnnounceProjectIdMin() {
		return projectAnnounceProjectIdMin;
	}

	public void setProjectAnnounceProjectIdMin(Long projectAnnounceProjectIdMin) {
		this.projectAnnounceProjectIdMin = projectAnnounceProjectIdMin;
	}

	public Long getProjectAnnounceProjectIdMax() {
		return projectAnnounceProjectIdMax;
	}

	public void setProjectAnnounceProjectIdMax(Long projectAnnounceProjectIdMax) {
		this.projectAnnounceProjectIdMax = projectAnnounceProjectIdMax;
	}

	public String getProjectAnnounceAnnounceDesc() {
		return projectAnnounceAnnounceDesc;
	}

	public void setProjectAnnounceAnnounceDesc(String projectAnnounceAnnounceDesc) {
		this.projectAnnounceAnnounceDesc = projectAnnounceAnnounceDesc;
	}

	public String getProjectAnnounceFirstCandidate() {
		return projectAnnounceFirstCandidate;
	}

	public void setProjectAnnounceFirstCandidate(String projectAnnounceFirstCandidate) {
		this.projectAnnounceFirstCandidate = projectAnnounceFirstCandidate;
	}

	public String getProjectAnnounceSecondCandidate() {
		return projectAnnounceSecondCandidate;
	}

	public void setProjectAnnounceSecondCandidate(String projectAnnounceSecondCandidate) {
		this.projectAnnounceSecondCandidate = projectAnnounceSecondCandidate;
	}

	public String getProjectAnnounceThirdCandidate() {
		return projectAnnounceThirdCandidate;
	}

	public void setProjectAnnounceThirdCandidate(String projectAnnounceThirdCandidate) {
		this.projectAnnounceThirdCandidate = projectAnnounceThirdCandidate;
	}

	public String getProjectAnnounceSourceUrl() {
		return projectAnnounceSourceUrl;
	}

	public void setProjectAnnounceSourceUrl(String projectAnnounceSourceUrl) {
		this.projectAnnounceSourceUrl = projectAnnounceSourceUrl;
	}

	public String getProjectAnnounceInwordHtmlUrl() {
		return projectAnnounceInwordHtmlUrl;
	}

	public void setProjectAnnounceInwordHtmlUrl(String projectAnnounceInwordHtmlUrl) {
		this.projectAnnounceInwordHtmlUrl = projectAnnounceInwordHtmlUrl;
	}

	public Integer getProjectAnnounceVersion() {
		return projectAnnounceVersion;
	}

	public void setProjectAnnounceVersion(Integer projectAnnounceVersion) {
		this.projectAnnounceVersion = projectAnnounceVersion;
	}

	public Integer getProjectAnnounceVersionMin() {
		return projectAnnounceVersionMin;
	}

	public void setProjectAnnounceVersionMin(Integer projectAnnounceVersionMin) {
		this.projectAnnounceVersionMin = projectAnnounceVersionMin;
	}

	public Integer getProjectAnnounceVersionMax() {
		return projectAnnounceVersionMax;
	}

	public void setProjectAnnounceVersionMax(Integer projectAnnounceVersionMax) {
		this.projectAnnounceVersionMax = projectAnnounceVersionMax;
	}

	public Date getProjectAnnounceCreateTime() {
		return projectAnnounceCreateTime;
	}

	public void setProjectAnnounceCreateTime(Date projectAnnounceCreateTime) {
		this.projectAnnounceCreateTime = projectAnnounceCreateTime;
	}

	public Date getProjectAnnounceCreateTimeMin() {
		return projectAnnounceCreateTimeMin;
	}

	public void setProjectAnnounceCreateTimeMin(Date projectAnnounceCreateTimeMin) {
		this.projectAnnounceCreateTimeMin = projectAnnounceCreateTimeMin;
	}

	public Date getProjectAnnounceCreateTimeMax() {
		return projectAnnounceCreateTimeMax;
	}

	public void setProjectAnnounceCreateTimeMax(Date projectAnnounceCreateTimeMax) {
		this.projectAnnounceCreateTimeMax = projectAnnounceCreateTimeMax;
	}

	public Date getProjectAnnounceUpdateTime() {
		return projectAnnounceUpdateTime;
	}

	public void setProjectAnnounceUpdateTime(Date projectAnnounceUpdateTime) {
		this.projectAnnounceUpdateTime = projectAnnounceUpdateTime;
	}

	public Date getProjectAnnounceUpdateTimeMin() {
		return projectAnnounceUpdateTimeMin;
	}

	public void setProjectAnnounceUpdateTimeMin(Date projectAnnounceUpdateTimeMin) {
		this.projectAnnounceUpdateTimeMin = projectAnnounceUpdateTimeMin;
	}

	public Date getProjectAnnounceUpdateTimeMax() {
		return projectAnnounceUpdateTimeMax;
	}

	public void setProjectAnnounceUpdateTimeMax(Date projectAnnounceUpdateTimeMax) {
		this.projectAnnounceUpdateTimeMax = projectAnnounceUpdateTimeMax;
	}

	public Byte getProjectAnnounceIsActive() {
		return projectAnnounceIsActive;
	}

	public void setProjectAnnounceIsActive(Byte projectAnnounceIsActive) {
		this.projectAnnounceIsActive = projectAnnounceIsActive;
	}

	public Byte getProjectAnnounceIsActiveMin() {
		return projectAnnounceIsActiveMin;
	}

	public void setProjectAnnounceIsActiveMin(Byte projectAnnounceIsActiveMin) {
		this.projectAnnounceIsActiveMin = projectAnnounceIsActiveMin;
	}

	public Byte getProjectAnnounceIsActiveMax() {
		return projectAnnounceIsActiveMax;
	}

	public void setProjectAnnounceIsActiveMax(Byte projectAnnounceIsActiveMax) {
		this.projectAnnounceIsActiveMax = projectAnnounceIsActiveMax;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	
    @Override
    public String toString() {
        return "ProjectAnnounceProjectQuery {" +
                "projectAnnounceId = " + projectAnnounceId + 
				", projectAnnounceIdMin = " + projectAnnounceIdMin + 
				", projectAnnounceIdMax = " + projectAnnounceIdMax + 
				", projectAnnounceProjectId = " + projectAnnounceProjectId + 
				", projectAnnounceProjectIdMin = " + projectAnnounceProjectIdMin + 
				", projectAnnounceProjectIdMax = " + projectAnnounceProjectIdMax + 
				", projectAnnounceAnnounceDesc = " + projectAnnounceAnnounceDesc + 
				", projectAnnounceFirstCandidate = " + projectAnnounceFirstCandidate + 
				", projectAnnounceSecondCandidate = " + projectAnnounceSecondCandidate + 
				", projectAnnounceThirdCandidate = " + projectAnnounceThirdCandidate + 
				", projectAnnounceSourceUrl = " + projectAnnounceSourceUrl + 
				", projectAnnounceInwordHtmlUrl = " + projectAnnounceInwordHtmlUrl + 
				", projectAnnounceVersion = " + projectAnnounceVersion + 
				", projectAnnounceVersionMin = " + projectAnnounceVersionMin + 
				", projectAnnounceVersionMax = " + projectAnnounceVersionMax + 
				", projectAnnounceCreateTime = " + projectAnnounceCreateTime + 
				", projectAnnounceCreateTimeMin = " + projectAnnounceCreateTimeMin + 
				", projectAnnounceCreateTimeMax = " + projectAnnounceCreateTimeMax + 
				", projectAnnounceUpdateTime = " + projectAnnounceUpdateTime + 
				", projectAnnounceUpdateTimeMin = " + projectAnnounceUpdateTimeMin + 
				", projectAnnounceUpdateTimeMax = " + projectAnnounceUpdateTimeMax + 
				", projectAnnounceIsActive = " + projectAnnounceIsActive + 
				", projectAnnounceIsActiveMin = " + projectAnnounceIsActiveMin + 
				", projectAnnounceIsActiveMax = " + projectAnnounceIsActiveMax + 
				", projectTitle = " + projectTitle + 
				" }";
    }

}
