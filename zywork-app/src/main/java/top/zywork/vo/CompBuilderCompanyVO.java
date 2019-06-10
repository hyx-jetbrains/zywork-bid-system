package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompBuilderCompanyVO值对象类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompBuilderCompanyVO extends BaseVO {

    private static final long serialVersionUID = -9223372035457117431L;

    //t_project_announce表的字段对应的属性
	// 公示编号
	@NotNull(message = "此项是必须项")
	private Long projectAnnounceId;
	// 项目编号
	private Long projectAnnounceProjectId;
	// 公示详情
	@Size(min = 0, max = 65535, message = "必须小于65535个字符")
	private String projectAnnounceAnnounceDesc;
	// 第一候选人
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String projectAnnounceFirstCandidate;
	// 建造师姓名
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String projectAnnounceFirstBuilderName;
	// 中标金额
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String projectAnnounceFirstMarkMoney;
	// 第二候选人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String projectAnnounceSecondCandidate;
	// 第三候选人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String projectAnnounceThirdCandidate;
	// 源地址
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String projectAnnounceSourceUrl;
	// 内部地址
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String projectAnnounceInwordHtmlUrl;
	// 版本号
	private Integer projectAnnounceVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectAnnounceUpdateTime;
	// 是否激活
	private Byte projectAnnounceIsActive;
	//t_project表的字段对应的属性
	// 项目名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 200, message = "必须是1-200个字符")
	private String projectTitle;
	//t_comp_builder表的字段对应的属性
	// 企业建造师编号
	private Long compBuilderId;
	// 企业编号
	@NotNull(message = "此项是必须项")
	private Long compBuilderCompId;
	// 姓名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String compBuilderName;
	// 性别
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String compBuilderGender;
	// 注册证件号码
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compBuilderRegNum;
	// 专业等级
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String compBuilderMajorLevel;
	// 版本号
	private Integer compBuilderVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderUpdateTime;
	// 是否激活
	private Byte compBuilderIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String companyCompType;
	// 行业分类
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String companyIndustryType;
	// 企业名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String companyCompName;
	
    public CompBuilderCompanyVO () {}

    public CompBuilderCompanyVO (Long projectAnnounceId, Long projectAnnounceProjectId, String projectAnnounceAnnounceDesc, String projectAnnounceFirstCandidate, String projectAnnounceFirstBuilderName, String projectAnnounceFirstMarkMoney, String projectAnnounceSecondCandidate, String projectAnnounceThirdCandidate, String projectAnnounceSourceUrl, String projectAnnounceInwordHtmlUrl, Integer projectAnnounceVersion, Date projectAnnounceCreateTime, Date projectAnnounceUpdateTime, Byte projectAnnounceIsActive, String projectTitle, Long compBuilderId, Long compBuilderCompId, String compBuilderName, String compBuilderGender, String compBuilderRegNum, String compBuilderMajorLevel, Integer compBuilderVersion, Date compBuilderCreateTime, Date compBuilderUpdateTime, Byte compBuilderIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
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
		this.compBuilderId = compBuilderId;
		this.compBuilderCompId = compBuilderCompId;
		this.compBuilderName = compBuilderName;
		this.compBuilderGender = compBuilderGender;
		this.compBuilderRegNum = compBuilderRegNum;
		this.compBuilderMajorLevel = compBuilderMajorLevel;
		this.compBuilderVersion = compBuilderVersion;
		this.compBuilderCreateTime = compBuilderCreateTime;
		this.compBuilderUpdateTime = compBuilderUpdateTime;
		this.compBuilderIsActive = compBuilderIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
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

	public Long getCompBuilderId() {
		return compBuilderId;
	}

	public void setCompBuilderId(Long compBuilderId) {
		this.compBuilderId = compBuilderId;
	}

	public Long getCompBuilderCompId() {
		return compBuilderCompId;
	}

	public void setCompBuilderCompId(Long compBuilderCompId) {
		this.compBuilderCompId = compBuilderCompId;
	}

	public String getCompBuilderName() {
		return compBuilderName;
	}

	public void setCompBuilderName(String compBuilderName) {
		this.compBuilderName = compBuilderName;
	}

	public String getCompBuilderGender() {
		return compBuilderGender;
	}

	public void setCompBuilderGender(String compBuilderGender) {
		this.compBuilderGender = compBuilderGender;
	}

	public String getCompBuilderRegNum() {
		return compBuilderRegNum;
	}

	public void setCompBuilderRegNum(String compBuilderRegNum) {
		this.compBuilderRegNum = compBuilderRegNum;
	}

	public String getCompBuilderMajorLevel() {
		return compBuilderMajorLevel;
	}

	public void setCompBuilderMajorLevel(String compBuilderMajorLevel) {
		this.compBuilderMajorLevel = compBuilderMajorLevel;
	}

	public Integer getCompBuilderVersion() {
		return compBuilderVersion;
	}

	public void setCompBuilderVersion(Integer compBuilderVersion) {
		this.compBuilderVersion = compBuilderVersion;
	}

	public Date getCompBuilderCreateTime() {
		return compBuilderCreateTime;
	}

	public void setCompBuilderCreateTime(Date compBuilderCreateTime) {
		this.compBuilderCreateTime = compBuilderCreateTime;
	}

	public Date getCompBuilderUpdateTime() {
		return compBuilderUpdateTime;
	}

	public void setCompBuilderUpdateTime(Date compBuilderUpdateTime) {
		this.compBuilderUpdateTime = compBuilderUpdateTime;
	}

	public Byte getCompBuilderIsActive() {
		return compBuilderIsActive;
	}

	public void setCompBuilderIsActive(Byte compBuilderIsActive) {
		this.compBuilderIsActive = compBuilderIsActive;
	}

	public String getCompanyCompType() {
		return companyCompType;
	}

	public void setCompanyCompType(String companyCompType) {
		this.companyCompType = companyCompType;
	}

	public String getCompanyIndustryType() {
		return companyIndustryType;
	}

	public void setCompanyIndustryType(String companyIndustryType) {
		this.companyIndustryType = companyIndustryType;
	}

	public String getCompanyCompName() {
		return companyCompName;
	}

	public void setCompanyCompName(String companyCompName) {
		this.companyCompName = companyCompName;
	}

	
    @Override
    public String toString() {
        return "CompBuilderCompanyVO {" +
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
				", compBuilderId = " + compBuilderId + 
				", compBuilderCompId = " + compBuilderCompId + 
				", compBuilderName = " + compBuilderName + 
				", compBuilderGender = " + compBuilderGender + 
				", compBuilderRegNum = " + compBuilderRegNum + 
				", compBuilderMajorLevel = " + compBuilderMajorLevel + 
				", compBuilderVersion = " + compBuilderVersion + 
				", compBuilderCreateTime = " + compBuilderCreateTime + 
				", compBuilderUpdateTime = " + compBuilderUpdateTime + 
				", compBuilderIsActive = " + compBuilderIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
