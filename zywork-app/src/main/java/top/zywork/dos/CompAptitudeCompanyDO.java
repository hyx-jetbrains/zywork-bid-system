package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompAptitudeCompanyDO数据对象实体类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompAptitudeCompanyDO extends BaseDO {

    private static final long serialVersionUID = -9223372034933309519L;

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
	
    public CompAptitudeCompanyDO () {}

    public CompAptitudeCompanyDO (Long compAptitudeId, Long compAptitudeCompId, String compAptitudeCertificateNum, String compAptitudeCertificateDetail, Integer compAptitudeVersion, Date compAptitudeCreateTime, Date compAptitudeUpdateTime, Byte compAptitudeIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
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

	
    @Override
    public String toString() {
        return "CompAptitudeCompanyDO {" +
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
				" }";
    }

}
