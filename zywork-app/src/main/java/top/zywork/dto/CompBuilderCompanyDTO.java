package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompBuilderCompanyDTO数据传输对象类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompBuilderCompanyDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035949255596L;

    //t_comp_aptitude表的字段对应的属性
	// 企业资质编号
	private Long compAptitudeId;
	// 企业编号
	private Long compAptitudeCompId;
	// 证件号码
	private String compAptitudeCertificateNum;
	// 资质详情
	private String compAptitudeCertificateDetail;
	// 版本号
	private Integer compAptitudeVersion;
	// 创建时间
	private Date compAptitudeCreateTime;
	// 更新时间
	private Date compAptitudeUpdateTime;
	// 是否激活
	private Byte compAptitudeIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	//t_comp_builder表的字段对应的属性
	// 企业建造师编号
	private Long compBuilderId;
	// 企业编号
	private Long compBuilderCompId;
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
	// 创建时间
	private Date compBuilderCreateTime;
	// 更新时间
	private Date compBuilderUpdateTime;
	// 是否激活
	private Byte compBuilderIsActive;
	
    public CompBuilderCompanyDTO () {}

    public CompBuilderCompanyDTO (Long compAptitudeId, Long compAptitudeCompId, String compAptitudeCertificateNum, String compAptitudeCertificateDetail, Integer compAptitudeVersion, Date compAptitudeCreateTime, Date compAptitudeUpdateTime, Byte compAptitudeIsActive, String companyCompType, String companyIndustryType, String companyCompName, Long compBuilderId, Long compBuilderCompId, String compBuilderName, String compBuilderGender, String compBuilderRegNum, String compBuilderMajorLevel, Integer compBuilderVersion, Date compBuilderCreateTime, Date compBuilderUpdateTime, Byte compBuilderIsActive) {
        this.compAptitudeId = compAptitudeId;
		this.compAptitudeCompId = compAptitudeCompId;
		this.compAptitudeCertificateNum = compAptitudeCertificateNum;
		this.compAptitudeCertificateDetail = compAptitudeCertificateDetail;
		this.compAptitudeVersion = compAptitudeVersion;
		this.compAptitudeCreateTime = compAptitudeCreateTime;
		this.compAptitudeUpdateTime = compAptitudeUpdateTime;
		this.compAptitudeIsActive = compAptitudeIsActive;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
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
		
    }

    public Long getCompAptitudeId() {
		return compAptitudeId;
	}

	public void setCompAptitudeId(Long compAptitudeId) {
		this.compAptitudeId = compAptitudeId;
	}

	public Long getCompAptitudeCompId() {
		return compAptitudeCompId;
	}

	public void setCompAptitudeCompId(Long compAptitudeCompId) {
		this.compAptitudeCompId = compAptitudeCompId;
	}

	public String getCompAptitudeCertificateNum() {
		return compAptitudeCertificateNum;
	}

	public void setCompAptitudeCertificateNum(String compAptitudeCertificateNum) {
		this.compAptitudeCertificateNum = compAptitudeCertificateNum;
	}

	public String getCompAptitudeCertificateDetail() {
		return compAptitudeCertificateDetail;
	}

	public void setCompAptitudeCertificateDetail(String compAptitudeCertificateDetail) {
		this.compAptitudeCertificateDetail = compAptitudeCertificateDetail;
	}

	public Integer getCompAptitudeVersion() {
		return compAptitudeVersion;
	}

	public void setCompAptitudeVersion(Integer compAptitudeVersion) {
		this.compAptitudeVersion = compAptitudeVersion;
	}

	public Date getCompAptitudeCreateTime() {
		return compAptitudeCreateTime;
	}

	public void setCompAptitudeCreateTime(Date compAptitudeCreateTime) {
		this.compAptitudeCreateTime = compAptitudeCreateTime;
	}

	public Date getCompAptitudeUpdateTime() {
		return compAptitudeUpdateTime;
	}

	public void setCompAptitudeUpdateTime(Date compAptitudeUpdateTime) {
		this.compAptitudeUpdateTime = compAptitudeUpdateTime;
	}

	public Byte getCompAptitudeIsActive() {
		return compAptitudeIsActive;
	}

	public void setCompAptitudeIsActive(Byte compAptitudeIsActive) {
		this.compAptitudeIsActive = compAptitudeIsActive;
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

	
    @Override
    public String toString() {
        return "CompBuilderCompanyDTO {" +
                "compAptitudeId = " + compAptitudeId + 
				", compAptitudeCompId = " + compAptitudeCompId + 
				", compAptitudeCertificateNum = " + compAptitudeCertificateNum + 
				", compAptitudeCertificateDetail = " + compAptitudeCertificateDetail + 
				", compAptitudeVersion = " + compAptitudeVersion + 
				", compAptitudeCreateTime = " + compAptitudeCreateTime + 
				", compAptitudeUpdateTime = " + compAptitudeUpdateTime + 
				", compAptitudeIsActive = " + compAptitudeIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
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
				" }";
    }

}
