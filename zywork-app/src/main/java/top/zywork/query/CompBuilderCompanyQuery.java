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

    private static final long serialVersionUID = -9223372036114352403L;

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

    public CompBuilderCompanyQuery (Long compBuilderId, Long compBuilderIdMin, Long compBuilderIdMax, Long compBuilderCompId, Long compBuilderCompIdMin, Long compBuilderCompIdMax, String compBuilderName, String compBuilderGender, String compBuilderRegNum, String compBuilderMajorLevel, Integer compBuilderVersion, Integer compBuilderVersionMin, Integer compBuilderVersionMax, Date compBuilderCreateTime, Date compBuilderCreateTimeMin, Date compBuilderCreateTimeMax, Date compBuilderUpdateTime, Date compBuilderUpdateTimeMin, Date compBuilderUpdateTimeMax, Byte compBuilderIsActive, Byte compBuilderIsActiveMin, Byte compBuilderIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
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
                "compBuilderId = " + compBuilderId + 
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
