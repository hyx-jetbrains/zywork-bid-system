package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompBuilderCompanyDO数据对象实体类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompBuilderCompanyDO extends BaseDO {

    private static final long serialVersionUID = -9223372036197590204L;

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
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompBuilderCompanyDO () {}

    public CompBuilderCompanyDO (Long compBuilderId, Long compBuilderCompId, String compBuilderName, String compBuilderGender, String compBuilderRegNum, String compBuilderMajorLevel, Integer compBuilderVersion, Date compBuilderCreateTime, Date compBuilderUpdateTime, Byte compBuilderIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
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
        return "CompBuilderCompanyDO {" +
                "compBuilderId = " + compBuilderId + 
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
