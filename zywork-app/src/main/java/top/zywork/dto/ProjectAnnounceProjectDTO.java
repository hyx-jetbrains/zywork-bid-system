package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectAnnounceProjectDTO数据传输对象类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectAnnounceProjectDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036308551075L;

    //t_project_announce表的字段对应的属性
	// 公示编号
	private Long projectAnnounceId;
	// 项目编号
	private Long projectAnnounceProjectId;
	// 公示详情
	private String projectAnnounceAnnounceDesc;
	// 第一候选人
	private String projectAnnounceFirstCandidate;
	// 建造师姓名
	private String projectAnnounceFirstBuilderName;
	// 中标金额
	private String projectAnnounceFirstMarkMoney;
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
	// 创建时间
	private Date projectAnnounceCreateTime;
	// 更新时间
	private Date projectAnnounceUpdateTime;
	// 是否激活
	private Byte projectAnnounceIsActive;
	//t_project表的字段对应的属性
	// 项目名称
	private String projectTitle;
	
    public ProjectAnnounceProjectDTO () {}

    public ProjectAnnounceProjectDTO (Long projectAnnounceId, Long projectAnnounceProjectId, String projectAnnounceAnnounceDesc, String projectAnnounceFirstCandidate, String projectAnnounceFirstBuilderName, String projectAnnounceFirstMarkMoney, String projectAnnounceSecondCandidate, String projectAnnounceThirdCandidate, String projectAnnounceSourceUrl, String projectAnnounceInwordHtmlUrl, Integer projectAnnounceVersion, Date projectAnnounceCreateTime, Date projectAnnounceUpdateTime, Byte projectAnnounceIsActive, String projectTitle) {
        this.projectAnnounceId = projectAnnounceId;
		this.projectAnnounceProjectId = projectAnnounceProjectId;
		this.projectAnnounceAnnounceDesc = projectAnnounceAnnounceDesc;
		this.projectAnnounceFirstCandidate = projectAnnounceFirstCandidate;
		this.projectAnnounceFirstBuilderName = projectAnnounceFirstBuilderName;
		this.projectAnnounceFirstMarkMoney = projectAnnounceFirstMarkMoney;
		this.projectAnnounceSecondCandidate = projectAnnounceSecondCandidate;
		this.projectAnnounceThirdCandidate = projectAnnounceThirdCandidate;
		this.projectAnnounceSourceUrl = projectAnnounceSourceUrl;
		this.projectAnnounceInwordHtmlUrl = projectAnnounceInwordHtmlUrl;
		this.projectAnnounceVersion = projectAnnounceVersion;
		this.projectAnnounceCreateTime = projectAnnounceCreateTime;
		this.projectAnnounceUpdateTime = projectAnnounceUpdateTime;
		this.projectAnnounceIsActive = projectAnnounceIsActive;
		this.projectTitle = projectTitle;
		
    }

    public Long getProjectAnnounceId() {
		return projectAnnounceId;
	}

	public void setProjectAnnounceId(Long projectAnnounceId) {
		this.projectAnnounceId = projectAnnounceId;
	}

	public Long getProjectAnnounceProjectId() {
		return projectAnnounceProjectId;
	}

	public void setProjectAnnounceProjectId(Long projectAnnounceProjectId) {
		this.projectAnnounceProjectId = projectAnnounceProjectId;
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

	public String getProjectAnnounceFirstBuilderName() {
		return projectAnnounceFirstBuilderName;
	}

	public void setProjectAnnounceFirstBuilderName(String projectAnnounceFirstBuilderName) {
		this.projectAnnounceFirstBuilderName = projectAnnounceFirstBuilderName;
	}

	public String getProjectAnnounceFirstMarkMoney() {
		return projectAnnounceFirstMarkMoney;
	}

	public void setProjectAnnounceFirstMarkMoney(String projectAnnounceFirstMarkMoney) {
		this.projectAnnounceFirstMarkMoney = projectAnnounceFirstMarkMoney;
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

	public Date getProjectAnnounceCreateTime() {
		return projectAnnounceCreateTime;
	}

	public void setProjectAnnounceCreateTime(Date projectAnnounceCreateTime) {
		this.projectAnnounceCreateTime = projectAnnounceCreateTime;
	}

	public Date getProjectAnnounceUpdateTime() {
		return projectAnnounceUpdateTime;
	}

	public void setProjectAnnounceUpdateTime(Date projectAnnounceUpdateTime) {
		this.projectAnnounceUpdateTime = projectAnnounceUpdateTime;
	}

	public Byte getProjectAnnounceIsActive() {
		return projectAnnounceIsActive;
	}

	public void setProjectAnnounceIsActive(Byte projectAnnounceIsActive) {
		this.projectAnnounceIsActive = projectAnnounceIsActive;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	
    @Override
    public String toString() {
        return "ProjectAnnounceProjectDTO {" +
                "projectAnnounceId = " + projectAnnounceId + 
				", projectAnnounceProjectId = " + projectAnnounceProjectId + 
				", projectAnnounceAnnounceDesc = " + projectAnnounceAnnounceDesc + 
				", projectAnnounceFirstCandidate = " + projectAnnounceFirstCandidate + 
				", projectAnnounceFirstBuilderName = " + projectAnnounceFirstBuilderName + 
				", projectAnnounceFirstMarkMoney = " + projectAnnounceFirstMarkMoney + 
				", projectAnnounceSecondCandidate = " + projectAnnounceSecondCandidate + 
				", projectAnnounceThirdCandidate = " + projectAnnounceThirdCandidate + 
				", projectAnnounceSourceUrl = " + projectAnnounceSourceUrl + 
				", projectAnnounceInwordHtmlUrl = " + projectAnnounceInwordHtmlUrl + 
				", projectAnnounceVersion = " + projectAnnounceVersion + 
				", projectAnnounceCreateTime = " + projectAnnounceCreateTime + 
				", projectAnnounceUpdateTime = " + projectAnnounceUpdateTime + 
				", projectAnnounceIsActive = " + projectAnnounceIsActive + 
				", projectTitle = " + projectTitle + 
				" }";
    }

}
