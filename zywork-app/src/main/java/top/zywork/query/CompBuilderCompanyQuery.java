package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompBuilderCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompBuilderCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036449229057L;

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
	//t_comp_builder表的字段对应的属性
	// 企业建造师编号
	private Long compBuilderId;
	// 企业建造师编号（最小值）
	private Long compBuilderIdMin;
	// 企业建造师编号（最大值）
	private Long compBuilderIdMax;
	// 企业编号
	private Long compBuilderCompId;
	// 企业编号（最小值）
	private Long compBuilderCompIdMin;
	// 企业编号（最大值）
	private Long compBuilderCompIdMax;
	// 姓名
	private String compBuilderName;
	// 性别
	private String compBuilderGender;
	// 注册证件号码
	private String compBuilderRegNum;
	// 专业等级
	private String compBuilderMajorLevel;
	// 版本号
	private Integer compBuilderVersion;
	// 版本号（最小值）
	private Integer compBuilderVersionMin;
	// 版本号（最大值）
	private Integer compBuilderVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compBuilderUpdateTimeMax;
	// 是否激活
	private Byte compBuilderIsActive;
	// 是否激活（最小值）
	private Byte compBuilderIsActiveMin;
	// 是否激活（最大值）
	private Byte compBuilderIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompBuilderCompanyQuery () {}

    public CompBuilderCompanyQuery (Long projectAnnounceId, Long projectAnnounceIdMin, Long projectAnnounceIdMax, Long projectAnnounceProjectId, Long projectAnnounceProjectIdMin, Long projectAnnounceProjectIdMax, String projectAnnounceAnnounceDesc, String projectAnnounceFirstCandidate, String projectAnnounceFirstBuilderName, String projectAnnounceFirstMarkMoney, String projectAnnounceSecondCandidate, String projectAnnounceThirdCandidate, String projectAnnounceSourceUrl, String projectAnnounceInwordHtmlUrl, Integer projectAnnounceVersion, Integer projectAnnounceVersionMin, Integer projectAnnounceVersionMax, Date projectAnnounceCreateTime, Date projectAnnounceCreateTimeMin, Date projectAnnounceCreateTimeMax, Date projectAnnounceUpdateTime, Date projectAnnounceUpdateTimeMin, Date projectAnnounceUpdateTimeMax, Byte projectAnnounceIsActive, Byte projectAnnounceIsActiveMin, Byte projectAnnounceIsActiveMax, String projectTitle, Long compBuilderId, Long compBuilderIdMin, Long compBuilderIdMax, Long compBuilderCompId, Long compBuilderCompIdMin, Long compBuilderCompIdMax, String compBuilderName, String compBuilderGender, String compBuilderRegNum, String compBuilderMajorLevel, Integer compBuilderVersion, Integer compBuilderVersionMin, Integer compBuilderVersionMax, Date compBuilderCreateTime, Date compBuilderCreateTimeMin, Date compBuilderCreateTimeMax, Date compBuilderUpdateTime, Date compBuilderUpdateTimeMin, Date compBuilderUpdateTimeMax, Byte compBuilderIsActive, Byte compBuilderIsActiveMin, Byte compBuilderIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.projectAnnounceId = projectAnnounceId;
		this.projectAnnounceIdMin = projectAnnounceIdMin;
		this.projectAnnounceIdMax = projectAnnounceIdMax;
		this.projectAnnounceProjectId = projectAnnounceProjectId;
		this.projectAnnounceProjectIdMin = projectAnnounceProjectIdMin;
		this.projectAnnounceProjectIdMax = projectAnnounceProjectIdMax;
		this.projectAnnounceAnnounceDesc = projectAnnounceAnnounceDesc;
		this.projectAnnounceFirstCandidate = projectAnnounceFirstCandidate;
		this.projectAnnounceFirstBuilderName = projectAnnounceFirstBuilderName;
		this.projectAnnounceFirstMarkMoney = projectAnnounceFirstMarkMoney;
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
		this.compBuilderId = compBuilderId;
		this.compBuilderIdMin = compBuilderIdMin;
		this.compBuilderIdMax = compBuilderIdMax;
		this.compBuilderCompId = compBuilderCompId;
		this.compBuilderCompIdMin = compBuilderCompIdMin;
		this.compBuilderCompIdMax = compBuilderCompIdMax;
		this.compBuilderName = compBuilderName;
		this.compBuilderGender = compBuilderGender;
		this.compBuilderRegNum = compBuilderRegNum;
		this.compBuilderMajorLevel = compBuilderMajorLevel;
		this.compBuilderVersion = compBuilderVersion;
		this.compBuilderVersionMin = compBuilderVersionMin;
		this.compBuilderVersionMax = compBuilderVersionMax;
		this.compBuilderCreateTime = compBuilderCreateTime;
		this.compBuilderCreateTimeMin = compBuilderCreateTimeMin;
		this.compBuilderCreateTimeMax = compBuilderCreateTimeMax;
		this.compBuilderUpdateTime = compBuilderUpdateTime;
		this.compBuilderUpdateTimeMin = compBuilderUpdateTimeMin;
		this.compBuilderUpdateTimeMax = compBuilderUpdateTimeMax;
		this.compBuilderIsActive = compBuilderIsActive;
		this.compBuilderIsActiveMin = compBuilderIsActiveMin;
		this.compBuilderIsActiveMax = compBuilderIsActiveMax;
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

	public Long getCompBuilderId() {
		return compBuilderId;
	}

	public void setCompBuilderId(Long compBuilderId) {
		this.compBuilderId = compBuilderId;
	}

	public Long getCompBuilderIdMin() {
		return compBuilderIdMin;
	}

	public void setCompBuilderIdMin(Long compBuilderIdMin) {
		this.compBuilderIdMin = compBuilderIdMin;
	}

	public Long getCompBuilderIdMax() {
		return compBuilderIdMax;
	}

	public void setCompBuilderIdMax(Long compBuilderIdMax) {
		this.compBuilderIdMax = compBuilderIdMax;
	}

	public Long getCompBuilderCompId() {
		return compBuilderCompId;
	}

	public void setCompBuilderCompId(Long compBuilderCompId) {
		this.compBuilderCompId = compBuilderCompId;
	}

	public Long getCompBuilderCompIdMin() {
		return compBuilderCompIdMin;
	}

	public void setCompBuilderCompIdMin(Long compBuilderCompIdMin) {
		this.compBuilderCompIdMin = compBuilderCompIdMin;
	}

	public Long getCompBuilderCompIdMax() {
		return compBuilderCompIdMax;
	}

	public void setCompBuilderCompIdMax(Long compBuilderCompIdMax) {
		this.compBuilderCompIdMax = compBuilderCompIdMax;
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

	public Integer getCompBuilderVersionMin() {
		return compBuilderVersionMin;
	}

	public void setCompBuilderVersionMin(Integer compBuilderVersionMin) {
		this.compBuilderVersionMin = compBuilderVersionMin;
	}

	public Integer getCompBuilderVersionMax() {
		return compBuilderVersionMax;
	}

	public void setCompBuilderVersionMax(Integer compBuilderVersionMax) {
		this.compBuilderVersionMax = compBuilderVersionMax;
	}

	public Date getCompBuilderCreateTime() {
		return compBuilderCreateTime;
	}

	public void setCompBuilderCreateTime(Date compBuilderCreateTime) {
		this.compBuilderCreateTime = compBuilderCreateTime;
	}

	public Date getCompBuilderCreateTimeMin() {
		return compBuilderCreateTimeMin;
	}

	public void setCompBuilderCreateTimeMin(Date compBuilderCreateTimeMin) {
		this.compBuilderCreateTimeMin = compBuilderCreateTimeMin;
	}

	public Date getCompBuilderCreateTimeMax() {
		return compBuilderCreateTimeMax;
	}

	public void setCompBuilderCreateTimeMax(Date compBuilderCreateTimeMax) {
		this.compBuilderCreateTimeMax = compBuilderCreateTimeMax;
	}

	public Date getCompBuilderUpdateTime() {
		return compBuilderUpdateTime;
	}

	public void setCompBuilderUpdateTime(Date compBuilderUpdateTime) {
		this.compBuilderUpdateTime = compBuilderUpdateTime;
	}

	public Date getCompBuilderUpdateTimeMin() {
		return compBuilderUpdateTimeMin;
	}

	public void setCompBuilderUpdateTimeMin(Date compBuilderUpdateTimeMin) {
		this.compBuilderUpdateTimeMin = compBuilderUpdateTimeMin;
	}

	public Date getCompBuilderUpdateTimeMax() {
		return compBuilderUpdateTimeMax;
	}

	public void setCompBuilderUpdateTimeMax(Date compBuilderUpdateTimeMax) {
		this.compBuilderUpdateTimeMax = compBuilderUpdateTimeMax;
	}

	public Byte getCompBuilderIsActive() {
		return compBuilderIsActive;
	}

	public void setCompBuilderIsActive(Byte compBuilderIsActive) {
		this.compBuilderIsActive = compBuilderIsActive;
	}

	public Byte getCompBuilderIsActiveMin() {
		return compBuilderIsActiveMin;
	}

	public void setCompBuilderIsActiveMin(Byte compBuilderIsActiveMin) {
		this.compBuilderIsActiveMin = compBuilderIsActiveMin;
	}

	public Byte getCompBuilderIsActiveMax() {
		return compBuilderIsActiveMax;
	}

	public void setCompBuilderIsActiveMax(Byte compBuilderIsActiveMax) {
		this.compBuilderIsActiveMax = compBuilderIsActiveMax;
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
        return "CompBuilderCompanyQuery {" +
                "projectAnnounceId = " + projectAnnounceId + 
				", projectAnnounceIdMin = " + projectAnnounceIdMin + 
				", projectAnnounceIdMax = " + projectAnnounceIdMax + 
				", projectAnnounceProjectId = " + projectAnnounceProjectId + 
				", projectAnnounceProjectIdMin = " + projectAnnounceProjectIdMin + 
				", projectAnnounceProjectIdMax = " + projectAnnounceProjectIdMax + 
				", projectAnnounceAnnounceDesc = " + projectAnnounceAnnounceDesc + 
				", projectAnnounceFirstCandidate = " + projectAnnounceFirstCandidate + 
				", projectAnnounceFirstBuilderName = " + projectAnnounceFirstBuilderName + 
				", projectAnnounceFirstMarkMoney = " + projectAnnounceFirstMarkMoney + 
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
				", compBuilderId = " + compBuilderId + 
				", compBuilderIdMin = " + compBuilderIdMin + 
				", compBuilderIdMax = " + compBuilderIdMax + 
				", compBuilderCompId = " + compBuilderCompId + 
				", compBuilderCompIdMin = " + compBuilderCompIdMin + 
				", compBuilderCompIdMax = " + compBuilderCompIdMax + 
				", compBuilderName = " + compBuilderName + 
				", compBuilderGender = " + compBuilderGender + 
				", compBuilderRegNum = " + compBuilderRegNum + 
				", compBuilderMajorLevel = " + compBuilderMajorLevel + 
				", compBuilderVersion = " + compBuilderVersion + 
				", compBuilderVersionMin = " + compBuilderVersionMin + 
				", compBuilderVersionMax = " + compBuilderVersionMax + 
				", compBuilderCreateTime = " + compBuilderCreateTime + 
				", compBuilderCreateTimeMin = " + compBuilderCreateTimeMin + 
				", compBuilderCreateTimeMax = " + compBuilderCreateTimeMax + 
				", compBuilderUpdateTime = " + compBuilderUpdateTime + 
				", compBuilderUpdateTimeMin = " + compBuilderUpdateTimeMin + 
				", compBuilderUpdateTimeMax = " + compBuilderUpdateTimeMax + 
				", compBuilderIsActive = " + compBuilderIsActive + 
				", compBuilderIsActiveMin = " + compBuilderIsActiveMin + 
				", compBuilderIsActiveMax = " + compBuilderIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
