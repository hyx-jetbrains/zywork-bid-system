package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompAptitudeCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompAptitudeCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035607849807L;

    //t_comp_aptitude表的字段对应的属性
	// 企业资质编号
	private Long compAptitudeId;
	// 企业资质编号（最小值）
	private Long compAptitudeIdMin;
	// 企业资质编号（最大值）
	private Long compAptitudeIdMax;
	// 企业编号
	private Long compAptitudeCompId;
	// 企业编号（最小值）
	private Long compAptitudeCompIdMin;
	// 企业编号（最大值）
	private Long compAptitudeCompIdMax;
	// 证件号码
	private String compAptitudeCertificateNum;
	// 资质详情
	private String compAptitudeCertificateDetail;
	// 版本号
	private Integer compAptitudeVersion;
	// 版本号（最小值）
	private Integer compAptitudeVersionMin;
	// 版本号（最大值）
	private Integer compAptitudeVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compAptitudeCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compAptitudeCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compAptitudeCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compAptitudeUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compAptitudeUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compAptitudeUpdateTimeMax;
	// 是否激活
	private Byte compAptitudeIsActive;
	// 是否激活（最小值）
	private Byte compAptitudeIsActiveMin;
	// 是否激活（最大值）
	private Byte compAptitudeIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	
    public CompAptitudeCompanyQuery () {}

    public CompAptitudeCompanyQuery (Long compAptitudeId, Long compAptitudeIdMin, Long compAptitudeIdMax, Long compAptitudeCompId, Long compAptitudeCompIdMin, Long compAptitudeCompIdMax, String compAptitudeCertificateNum, String compAptitudeCertificateDetail, Integer compAptitudeVersion, Integer compAptitudeVersionMin, Integer compAptitudeVersionMax, Date compAptitudeCreateTime, Date compAptitudeCreateTimeMin, Date compAptitudeCreateTimeMax, Date compAptitudeUpdateTime, Date compAptitudeUpdateTimeMin, Date compAptitudeUpdateTimeMax, Byte compAptitudeIsActive, Byte compAptitudeIsActiveMin, Byte compAptitudeIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compAptitudeId = compAptitudeId;
		this.compAptitudeIdMin = compAptitudeIdMin;
		this.compAptitudeIdMax = compAptitudeIdMax;
		this.compAptitudeCompId = compAptitudeCompId;
		this.compAptitudeCompIdMin = compAptitudeCompIdMin;
		this.compAptitudeCompIdMax = compAptitudeCompIdMax;
		this.compAptitudeCertificateNum = compAptitudeCertificateNum;
		this.compAptitudeCertificateDetail = compAptitudeCertificateDetail;
		this.compAptitudeVersion = compAptitudeVersion;
		this.compAptitudeVersionMin = compAptitudeVersionMin;
		this.compAptitudeVersionMax = compAptitudeVersionMax;
		this.compAptitudeCreateTime = compAptitudeCreateTime;
		this.compAptitudeCreateTimeMin = compAptitudeCreateTimeMin;
		this.compAptitudeCreateTimeMax = compAptitudeCreateTimeMax;
		this.compAptitudeUpdateTime = compAptitudeUpdateTime;
		this.compAptitudeUpdateTimeMin = compAptitudeUpdateTimeMin;
		this.compAptitudeUpdateTimeMax = compAptitudeUpdateTimeMax;
		this.compAptitudeIsActive = compAptitudeIsActive;
		this.compAptitudeIsActiveMin = compAptitudeIsActiveMin;
		this.compAptitudeIsActiveMax = compAptitudeIsActiveMax;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompAptitudeId() {
		return compAptitudeId;
	}

	public void setCompAptitudeId(Long compAptitudeId) {
		this.compAptitudeId = compAptitudeId;
	}

	public Long getCompAptitudeIdMin() {
		return compAptitudeIdMin;
	}

	public void setCompAptitudeIdMin(Long compAptitudeIdMin) {
		this.compAptitudeIdMin = compAptitudeIdMin;
	}

	public Long getCompAptitudeIdMax() {
		return compAptitudeIdMax;
	}

	public void setCompAptitudeIdMax(Long compAptitudeIdMax) {
		this.compAptitudeIdMax = compAptitudeIdMax;
	}

	public Long getCompAptitudeCompId() {
		return compAptitudeCompId;
	}

	public void setCompAptitudeCompId(Long compAptitudeCompId) {
		this.compAptitudeCompId = compAptitudeCompId;
	}

	public Long getCompAptitudeCompIdMin() {
		return compAptitudeCompIdMin;
	}

	public void setCompAptitudeCompIdMin(Long compAptitudeCompIdMin) {
		this.compAptitudeCompIdMin = compAptitudeCompIdMin;
	}

	public Long getCompAptitudeCompIdMax() {
		return compAptitudeCompIdMax;
	}

	public void setCompAptitudeCompIdMax(Long compAptitudeCompIdMax) {
		this.compAptitudeCompIdMax = compAptitudeCompIdMax;
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

	public Integer getCompAptitudeVersionMin() {
		return compAptitudeVersionMin;
	}

	public void setCompAptitudeVersionMin(Integer compAptitudeVersionMin) {
		this.compAptitudeVersionMin = compAptitudeVersionMin;
	}

	public Integer getCompAptitudeVersionMax() {
		return compAptitudeVersionMax;
	}

	public void setCompAptitudeVersionMax(Integer compAptitudeVersionMax) {
		this.compAptitudeVersionMax = compAptitudeVersionMax;
	}

	public Date getCompAptitudeCreateTime() {
		return compAptitudeCreateTime;
	}

	public void setCompAptitudeCreateTime(Date compAptitudeCreateTime) {
		this.compAptitudeCreateTime = compAptitudeCreateTime;
	}

	public Date getCompAptitudeCreateTimeMin() {
		return compAptitudeCreateTimeMin;
	}

	public void setCompAptitudeCreateTimeMin(Date compAptitudeCreateTimeMin) {
		this.compAptitudeCreateTimeMin = compAptitudeCreateTimeMin;
	}

	public Date getCompAptitudeCreateTimeMax() {
		return compAptitudeCreateTimeMax;
	}

	public void setCompAptitudeCreateTimeMax(Date compAptitudeCreateTimeMax) {
		this.compAptitudeCreateTimeMax = compAptitudeCreateTimeMax;
	}

	public Date getCompAptitudeUpdateTime() {
		return compAptitudeUpdateTime;
	}

	public void setCompAptitudeUpdateTime(Date compAptitudeUpdateTime) {
		this.compAptitudeUpdateTime = compAptitudeUpdateTime;
	}

	public Date getCompAptitudeUpdateTimeMin() {
		return compAptitudeUpdateTimeMin;
	}

	public void setCompAptitudeUpdateTimeMin(Date compAptitudeUpdateTimeMin) {
		this.compAptitudeUpdateTimeMin = compAptitudeUpdateTimeMin;
	}

	public Date getCompAptitudeUpdateTimeMax() {
		return compAptitudeUpdateTimeMax;
	}

	public void setCompAptitudeUpdateTimeMax(Date compAptitudeUpdateTimeMax) {
		this.compAptitudeUpdateTimeMax = compAptitudeUpdateTimeMax;
	}

	public Byte getCompAptitudeIsActive() {
		return compAptitudeIsActive;
	}

	public void setCompAptitudeIsActive(Byte compAptitudeIsActive) {
		this.compAptitudeIsActive = compAptitudeIsActive;
	}

	public Byte getCompAptitudeIsActiveMin() {
		return compAptitudeIsActiveMin;
	}

	public void setCompAptitudeIsActiveMin(Byte compAptitudeIsActiveMin) {
		this.compAptitudeIsActiveMin = compAptitudeIsActiveMin;
	}

	public Byte getCompAptitudeIsActiveMax() {
		return compAptitudeIsActiveMax;
	}

	public void setCompAptitudeIsActiveMax(Byte compAptitudeIsActiveMax) {
		this.compAptitudeIsActiveMax = compAptitudeIsActiveMax;
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
        return "CompAptitudeCompanyQuery {" +
                "compAptitudeId = " + compAptitudeId + 
				", compAptitudeIdMin = " + compAptitudeIdMin + 
				", compAptitudeIdMax = " + compAptitudeIdMax + 
				", compAptitudeCompId = " + compAptitudeCompId + 
				", compAptitudeCompIdMin = " + compAptitudeCompIdMin + 
				", compAptitudeCompIdMax = " + compAptitudeCompIdMax + 
				", compAptitudeCertificateNum = " + compAptitudeCertificateNum + 
				", compAptitudeCertificateDetail = " + compAptitudeCertificateDetail + 
				", compAptitudeVersion = " + compAptitudeVersion + 
				", compAptitudeVersionMin = " + compAptitudeVersionMin + 
				", compAptitudeVersionMax = " + compAptitudeVersionMax + 
				", compAptitudeCreateTime = " + compAptitudeCreateTime + 
				", compAptitudeCreateTimeMin = " + compAptitudeCreateTimeMin + 
				", compAptitudeCreateTimeMax = " + compAptitudeCreateTimeMax + 
				", compAptitudeUpdateTime = " + compAptitudeUpdateTime + 
				", compAptitudeUpdateTimeMin = " + compAptitudeUpdateTimeMin + 
				", compAptitudeUpdateTimeMax = " + compAptitudeUpdateTimeMax + 
				", compAptitudeIsActive = " + compAptitudeIsActive + 
				", compAptitudeIsActiveMin = " + compAptitudeIsActiveMin + 
				", compAptitudeIsActiveMax = " + compAptitudeIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
