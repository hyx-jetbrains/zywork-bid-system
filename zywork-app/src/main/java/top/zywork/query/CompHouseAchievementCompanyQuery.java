package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompHouseAchievementCompanyQuery查询对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompHouseAchievementCompanyQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036571314405L;

    //t_comp_house_achievement表的字段对应的属性
	// 企业房建业绩编号
	private Long compHouseAchievementId;
	// 企业房建业绩编号（最小值）
	private Long compHouseAchievementIdMin;
	// 企业房建业绩编号（最大值）
	private Long compHouseAchievementIdMax;
	// 企业编号
	private Long compHouseAchievementCompId;
	// 企业编号（最小值）
	private Long compHouseAchievementCompIdMin;
	// 企业编号（最大值）
	private Long compHouseAchievementCompIdMax;
	// 工程名称
	private String compHouseAchievementProjectName;
	// 注册建造师
	private String compHouseAchievementBuilderName;
	// 中标金额
	private String compHouseAchievementMarkMoney;
	// 建设规模
	private String compHouseAchievementBuildScale;
	// 项目所属地区归类
	private String compHouseAchievementRegionType;
	// 中标单位
	private String compHouseAchievementMarkComp;
	// 建设单位
	private String compHouseAchievementBuildComp;
	// 工程地址
	private String compHouseAchievementProjectAddr;
	// 合同签订日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementContractDate;
	// 合同签订日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementContractDateMin;
	// 合同签订日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementContractDateMax;
	// 中标日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementMarkDate;
	// 中标日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementMarkDateMin;
	// 中标日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementMarkDateMax;
	// 项目负责人
	private String compHouseAchievementName;
	// 项目负责人证书号
	private String compHouseAchievementCertificateNum;
	// 施工员
	private String compHouseAchievementConstructors;
	// 施工员证书号
	private String compHouseAchievementConstructorsCertificateNum;
	// 施工员身份证号
	private String compHouseAchievementConstructorsIdNum;
	// 质量员
	private String compHouseAchievementQualityWorker;
	// 质量员证书号
	private String compHouseAchievementQualityWorkerCertificateNum;
	// 质量员身份证号
	private String compHouseAchievementQualityWorkerIdNum;
	// 安全员
	private String compHouseAchievementSecurityOfficer;
	// 安全员证书号
	private String compHouseAchievementSecurityOfficerCertificateNum;
	// 安全员身份证号
	private String compHouseAchievementSecurityOfficerIdNum;
	// 标准员
	private String compHouseAchievementStandardWorker;
	// 标准员证书号
	private String compHouseAchievementStandardWorkerCertificateNum;
	// 标准员身份证号
	private String compHouseAchievementStandardWorkerIdNum;
	// 材料员
	private String compHouseAchievementMaterialMan;
	// 材料员证书号
	private String compHouseAchievementMaterialManCertificateNum;
	// 材料员身份证号
	private String compHouseAchievementMaterialManIdNum;
	// 机械员
	private String compHouseAchievementMechanic;
	// 机械员证书号
	private String compHouseAchievementMechanicCertificateNum;
	// 机械员身份证号
	private String compHouseAchievementMechanicIdNum;
	// 劳务员
	private String compHouseAchievementLabors;
	// 劳务员证书号
	private String compHouseAchievementLaborsCertificateNum;
	// 劳务员身份证号
	private String compHouseAchievementLaborsIdNum;
	// 资料员
	private String compHouseAchievementDataClerk;
	// 资料员证书号
	private String compHouseAchievementDataClerkCertificateNum;
	// 资料员身份证号
	private String compHouseAchievementDataClerkIdNum;
	// 版本号
	private Integer compHouseAchievementVersion;
	// 版本号（最小值）
	private Integer compHouseAchievementVersionMin;
	// 版本号（最大值）
	private Integer compHouseAchievementVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date compHouseAchievementUpdateTimeMax;
	// 是否激活
	private Byte compHouseAchievementIsActive;
	// 是否激活（最小值）
	private Byte compHouseAchievementIsActiveMin;
	// 是否激活（最大值）
	private Byte compHouseAchievementIsActiveMax;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	// 金额 （最小值）
	private BigDecimal moneyMin;
	// 金额 （最大值）
	private BigDecimal moneyMax;
	// 金额
	private BigDecimal money;
	// 源地址
	private String compHouseAchievementSourceUrl;
	// 内部地址
	private String compHouseAchievementInwardHtmlUrl;

	public String getCompHouseAchievementSourceUrl() {
		return compHouseAchievementSourceUrl;
	}

	public void setCompHouseAchievementSourceUrl(String compHouseAchievementSourceUrl) {
		this.compHouseAchievementSourceUrl = compHouseAchievementSourceUrl;
	}

	public String getCompHouseAchievementInwardHtmlUrl() {
		return compHouseAchievementInwardHtmlUrl;
	}

	public void setCompHouseAchievementInwardHtmlUrl(String compHouseAchievementInwardHtmlUrl) {
		this.compHouseAchievementInwardHtmlUrl = compHouseAchievementInwardHtmlUrl;
	}
	public BigDecimal getMoneyMin() {
		return moneyMin;
	}

	public void setMoneyMin(BigDecimal moneyMin) {
		this.moneyMin = moneyMin;
	}

	public BigDecimal getMoneyMax() {
		return moneyMax;
	}

	public void setMoneyMax(BigDecimal moneyMax) {
		this.moneyMax = moneyMax;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public CompHouseAchievementCompanyQuery () {}

    public CompHouseAchievementCompanyQuery (Long compHouseAchievementId, Long compHouseAchievementIdMin, Long compHouseAchievementIdMax, Long compHouseAchievementCompId, Long compHouseAchievementCompIdMin, Long compHouseAchievementCompIdMax, String compHouseAchievementProjectName, String compHouseAchievementBuilderName, String compHouseAchievementMarkMoney, String compHouseAchievementBuildScale, String compHouseAchievementRegionType, String compHouseAchievementMarkComp, String compHouseAchievementBuildComp, String compHouseAchievementProjectAddr, Date compHouseAchievementContractDate, Date compHouseAchievementContractDateMin, Date compHouseAchievementContractDateMax, Date compHouseAchievementMarkDate, Date compHouseAchievementMarkDateMin, Date compHouseAchievementMarkDateMax, String compHouseAchievementName, String compHouseAchievementCertificateNum, String compHouseAchievementConstructors, String compHouseAchievementConstructorsCertificateNum, String compHouseAchievementConstructorsIdNum, String compHouseAchievementQualityWorker, String compHouseAchievementQualityWorkerCertificateNum, String compHouseAchievementQualityWorkerIdNum, String compHouseAchievementSecurityOfficer, String compHouseAchievementSecurityOfficerCertificateNum, String compHouseAchievementSecurityOfficerIdNum, String compHouseAchievementStandardWorker, String compHouseAchievementStandardWorkerCertificateNum, String compHouseAchievementStandardWorkerIdNum, String compHouseAchievementMaterialMan, String compHouseAchievementMaterialManCertificateNum, String compHouseAchievementMaterialManIdNum, String compHouseAchievementMechanic, String compHouseAchievementMechanicCertificateNum, String compHouseAchievementMechanicIdNum, String compHouseAchievementLabors, String compHouseAchievementLaborsCertificateNum, String compHouseAchievementLaborsIdNum, String compHouseAchievementDataClerk, String compHouseAchievementDataClerkCertificateNum, String compHouseAchievementDataClerkIdNum, Integer compHouseAchievementVersion, Integer compHouseAchievementVersionMin, Integer compHouseAchievementVersionMax, Date compHouseAchievementCreateTime, Date compHouseAchievementCreateTimeMin, Date compHouseAchievementCreateTimeMax, Date compHouseAchievementUpdateTime, Date compHouseAchievementUpdateTimeMin, Date compHouseAchievementUpdateTimeMax, Byte compHouseAchievementIsActive, Byte compHouseAchievementIsActiveMin, Byte compHouseAchievementIsActiveMax, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compHouseAchievementId = compHouseAchievementId;
		this.compHouseAchievementIdMin = compHouseAchievementIdMin;
		this.compHouseAchievementIdMax = compHouseAchievementIdMax;
		this.compHouseAchievementCompId = compHouseAchievementCompId;
		this.compHouseAchievementCompIdMin = compHouseAchievementCompIdMin;
		this.compHouseAchievementCompIdMax = compHouseAchievementCompIdMax;
		this.compHouseAchievementProjectName = compHouseAchievementProjectName;
		this.compHouseAchievementBuilderName = compHouseAchievementBuilderName;
		this.compHouseAchievementMarkMoney = compHouseAchievementMarkMoney;
		this.compHouseAchievementBuildScale = compHouseAchievementBuildScale;
		this.compHouseAchievementRegionType = compHouseAchievementRegionType;
		this.compHouseAchievementMarkComp = compHouseAchievementMarkComp;
		this.compHouseAchievementBuildComp = compHouseAchievementBuildComp;
		this.compHouseAchievementProjectAddr = compHouseAchievementProjectAddr;
		this.compHouseAchievementContractDate = compHouseAchievementContractDate;
		this.compHouseAchievementContractDateMin = compHouseAchievementContractDateMin;
		this.compHouseAchievementContractDateMax = compHouseAchievementContractDateMax;
		this.compHouseAchievementMarkDate = compHouseAchievementMarkDate;
		this.compHouseAchievementMarkDateMin = compHouseAchievementMarkDateMin;
		this.compHouseAchievementMarkDateMax = compHouseAchievementMarkDateMax;
		this.compHouseAchievementName = compHouseAchievementName;
		this.compHouseAchievementCertificateNum = compHouseAchievementCertificateNum;
		this.compHouseAchievementConstructors = compHouseAchievementConstructors;
		this.compHouseAchievementConstructorsCertificateNum = compHouseAchievementConstructorsCertificateNum;
		this.compHouseAchievementConstructorsIdNum = compHouseAchievementConstructorsIdNum;
		this.compHouseAchievementQualityWorker = compHouseAchievementQualityWorker;
		this.compHouseAchievementQualityWorkerCertificateNum = compHouseAchievementQualityWorkerCertificateNum;
		this.compHouseAchievementQualityWorkerIdNum = compHouseAchievementQualityWorkerIdNum;
		this.compHouseAchievementSecurityOfficer = compHouseAchievementSecurityOfficer;
		this.compHouseAchievementSecurityOfficerCertificateNum = compHouseAchievementSecurityOfficerCertificateNum;
		this.compHouseAchievementSecurityOfficerIdNum = compHouseAchievementSecurityOfficerIdNum;
		this.compHouseAchievementStandardWorker = compHouseAchievementStandardWorker;
		this.compHouseAchievementStandardWorkerCertificateNum = compHouseAchievementStandardWorkerCertificateNum;
		this.compHouseAchievementStandardWorkerIdNum = compHouseAchievementStandardWorkerIdNum;
		this.compHouseAchievementMaterialMan = compHouseAchievementMaterialMan;
		this.compHouseAchievementMaterialManCertificateNum = compHouseAchievementMaterialManCertificateNum;
		this.compHouseAchievementMaterialManIdNum = compHouseAchievementMaterialManIdNum;
		this.compHouseAchievementMechanic = compHouseAchievementMechanic;
		this.compHouseAchievementMechanicCertificateNum = compHouseAchievementMechanicCertificateNum;
		this.compHouseAchievementMechanicIdNum = compHouseAchievementMechanicIdNum;
		this.compHouseAchievementLabors = compHouseAchievementLabors;
		this.compHouseAchievementLaborsCertificateNum = compHouseAchievementLaborsCertificateNum;
		this.compHouseAchievementLaborsIdNum = compHouseAchievementLaborsIdNum;
		this.compHouseAchievementDataClerk = compHouseAchievementDataClerk;
		this.compHouseAchievementDataClerkCertificateNum = compHouseAchievementDataClerkCertificateNum;
		this.compHouseAchievementDataClerkIdNum = compHouseAchievementDataClerkIdNum;
		this.compHouseAchievementVersion = compHouseAchievementVersion;
		this.compHouseAchievementVersionMin = compHouseAchievementVersionMin;
		this.compHouseAchievementVersionMax = compHouseAchievementVersionMax;
		this.compHouseAchievementCreateTime = compHouseAchievementCreateTime;
		this.compHouseAchievementCreateTimeMin = compHouseAchievementCreateTimeMin;
		this.compHouseAchievementCreateTimeMax = compHouseAchievementCreateTimeMax;
		this.compHouseAchievementUpdateTime = compHouseAchievementUpdateTime;
		this.compHouseAchievementUpdateTimeMin = compHouseAchievementUpdateTimeMin;
		this.compHouseAchievementUpdateTimeMax = compHouseAchievementUpdateTimeMax;
		this.compHouseAchievementIsActive = compHouseAchievementIsActive;
		this.compHouseAchievementIsActiveMin = compHouseAchievementIsActiveMin;
		this.compHouseAchievementIsActiveMax = compHouseAchievementIsActiveMax;
		this.companyCompType = companyCompType;
		this.companyIndustryType = companyIndustryType;
		this.companyCompName = companyCompName;
		
    }

    public Long getCompHouseAchievementId() {
		return compHouseAchievementId;
	}

	public void setCompHouseAchievementId(Long compHouseAchievementId) {
		this.compHouseAchievementId = compHouseAchievementId;
	}

	public Long getCompHouseAchievementIdMin() {
		return compHouseAchievementIdMin;
	}

	public void setCompHouseAchievementIdMin(Long compHouseAchievementIdMin) {
		this.compHouseAchievementIdMin = compHouseAchievementIdMin;
	}

	public Long getCompHouseAchievementIdMax() {
		return compHouseAchievementIdMax;
	}

	public void setCompHouseAchievementIdMax(Long compHouseAchievementIdMax) {
		this.compHouseAchievementIdMax = compHouseAchievementIdMax;
	}

	public Long getCompHouseAchievementCompId() {
		return compHouseAchievementCompId;
	}

	public void setCompHouseAchievementCompId(Long compHouseAchievementCompId) {
		this.compHouseAchievementCompId = compHouseAchievementCompId;
	}

	public Long getCompHouseAchievementCompIdMin() {
		return compHouseAchievementCompIdMin;
	}

	public void setCompHouseAchievementCompIdMin(Long compHouseAchievementCompIdMin) {
		this.compHouseAchievementCompIdMin = compHouseAchievementCompIdMin;
	}

	public Long getCompHouseAchievementCompIdMax() {
		return compHouseAchievementCompIdMax;
	}

	public void setCompHouseAchievementCompIdMax(Long compHouseAchievementCompIdMax) {
		this.compHouseAchievementCompIdMax = compHouseAchievementCompIdMax;
	}

	public String getCompHouseAchievementProjectName() {
		return compHouseAchievementProjectName;
	}

	public void setCompHouseAchievementProjectName(String compHouseAchievementProjectName) {
		this.compHouseAchievementProjectName = compHouseAchievementProjectName;
	}

	public String getCompHouseAchievementBuilderName() {
		return compHouseAchievementBuilderName;
	}

	public void setCompHouseAchievementBuilderName(String compHouseAchievementBuilderName) {
		this.compHouseAchievementBuilderName = compHouseAchievementBuilderName;
	}

	public String getCompHouseAchievementMarkMoney() {
		return compHouseAchievementMarkMoney;
	}

	public void setCompHouseAchievementMarkMoney(String compHouseAchievementMarkMoney) {
		this.compHouseAchievementMarkMoney = compHouseAchievementMarkMoney;
	}

	public String getCompHouseAchievementBuildScale() {
		return compHouseAchievementBuildScale;
	}

	public void setCompHouseAchievementBuildScale(String compHouseAchievementBuildScale) {
		this.compHouseAchievementBuildScale = compHouseAchievementBuildScale;
	}

	public String getCompHouseAchievementRegionType() {
		return compHouseAchievementRegionType;
	}

	public void setCompHouseAchievementRegionType(String compHouseAchievementRegionType) {
		this.compHouseAchievementRegionType = compHouseAchievementRegionType;
	}

	public String getCompHouseAchievementMarkComp() {
		return compHouseAchievementMarkComp;
	}

	public void setCompHouseAchievementMarkComp(String compHouseAchievementMarkComp) {
		this.compHouseAchievementMarkComp = compHouseAchievementMarkComp;
	}

	public String getCompHouseAchievementBuildComp() {
		return compHouseAchievementBuildComp;
	}

	public void setCompHouseAchievementBuildComp(String compHouseAchievementBuildComp) {
		this.compHouseAchievementBuildComp = compHouseAchievementBuildComp;
	}

	public String getCompHouseAchievementProjectAddr() {
		return compHouseAchievementProjectAddr;
	}

	public void setCompHouseAchievementProjectAddr(String compHouseAchievementProjectAddr) {
		this.compHouseAchievementProjectAddr = compHouseAchievementProjectAddr;
	}

	public Date getCompHouseAchievementContractDate() {
		return compHouseAchievementContractDate;
	}

	public void setCompHouseAchievementContractDate(Date compHouseAchievementContractDate) {
		this.compHouseAchievementContractDate = compHouseAchievementContractDate;
	}

	public Date getCompHouseAchievementContractDateMin() {
		return compHouseAchievementContractDateMin;
	}

	public void setCompHouseAchievementContractDateMin(Date compHouseAchievementContractDateMin) {
		this.compHouseAchievementContractDateMin = compHouseAchievementContractDateMin;
	}

	public Date getCompHouseAchievementContractDateMax() {
		return compHouseAchievementContractDateMax;
	}

	public void setCompHouseAchievementContractDateMax(Date compHouseAchievementContractDateMax) {
		this.compHouseAchievementContractDateMax = compHouseAchievementContractDateMax;
	}

	public Date getCompHouseAchievementMarkDate() {
		return compHouseAchievementMarkDate;
	}

	public void setCompHouseAchievementMarkDate(Date compHouseAchievementMarkDate) {
		this.compHouseAchievementMarkDate = compHouseAchievementMarkDate;
	}

	public Date getCompHouseAchievementMarkDateMin() {
		return compHouseAchievementMarkDateMin;
	}

	public void setCompHouseAchievementMarkDateMin(Date compHouseAchievementMarkDateMin) {
		this.compHouseAchievementMarkDateMin = compHouseAchievementMarkDateMin;
	}

	public Date getCompHouseAchievementMarkDateMax() {
		return compHouseAchievementMarkDateMax;
	}

	public void setCompHouseAchievementMarkDateMax(Date compHouseAchievementMarkDateMax) {
		this.compHouseAchievementMarkDateMax = compHouseAchievementMarkDateMax;
	}

	public String getCompHouseAchievementName() {
		return compHouseAchievementName;
	}

	public void setCompHouseAchievementName(String compHouseAchievementName) {
		this.compHouseAchievementName = compHouseAchievementName;
	}

	public String getCompHouseAchievementCertificateNum() {
		return compHouseAchievementCertificateNum;
	}

	public void setCompHouseAchievementCertificateNum(String compHouseAchievementCertificateNum) {
		this.compHouseAchievementCertificateNum = compHouseAchievementCertificateNum;
	}

	public String getCompHouseAchievementConstructors() {
		return compHouseAchievementConstructors;
	}

	public void setCompHouseAchievementConstructors(String compHouseAchievementConstructors) {
		this.compHouseAchievementConstructors = compHouseAchievementConstructors;
	}

	public String getCompHouseAchievementConstructorsCertificateNum() {
		return compHouseAchievementConstructorsCertificateNum;
	}

	public void setCompHouseAchievementConstructorsCertificateNum(String compHouseAchievementConstructorsCertificateNum) {
		this.compHouseAchievementConstructorsCertificateNum = compHouseAchievementConstructorsCertificateNum;
	}

	public String getCompHouseAchievementConstructorsIdNum() {
		return compHouseAchievementConstructorsIdNum;
	}

	public void setCompHouseAchievementConstructorsIdNum(String compHouseAchievementConstructorsIdNum) {
		this.compHouseAchievementConstructorsIdNum = compHouseAchievementConstructorsIdNum;
	}

	public String getCompHouseAchievementQualityWorker() {
		return compHouseAchievementQualityWorker;
	}

	public void setCompHouseAchievementQualityWorker(String compHouseAchievementQualityWorker) {
		this.compHouseAchievementQualityWorker = compHouseAchievementQualityWorker;
	}

	public String getCompHouseAchievementQualityWorkerCertificateNum() {
		return compHouseAchievementQualityWorkerCertificateNum;
	}

	public void setCompHouseAchievementQualityWorkerCertificateNum(String compHouseAchievementQualityWorkerCertificateNum) {
		this.compHouseAchievementQualityWorkerCertificateNum = compHouseAchievementQualityWorkerCertificateNum;
	}

	public String getCompHouseAchievementQualityWorkerIdNum() {
		return compHouseAchievementQualityWorkerIdNum;
	}

	public void setCompHouseAchievementQualityWorkerIdNum(String compHouseAchievementQualityWorkerIdNum) {
		this.compHouseAchievementQualityWorkerIdNum = compHouseAchievementQualityWorkerIdNum;
	}

	public String getCompHouseAchievementSecurityOfficer() {
		return compHouseAchievementSecurityOfficer;
	}

	public void setCompHouseAchievementSecurityOfficer(String compHouseAchievementSecurityOfficer) {
		this.compHouseAchievementSecurityOfficer = compHouseAchievementSecurityOfficer;
	}

	public String getCompHouseAchievementSecurityOfficerCertificateNum() {
		return compHouseAchievementSecurityOfficerCertificateNum;
	}

	public void setCompHouseAchievementSecurityOfficerCertificateNum(String compHouseAchievementSecurityOfficerCertificateNum) {
		this.compHouseAchievementSecurityOfficerCertificateNum = compHouseAchievementSecurityOfficerCertificateNum;
	}

	public String getCompHouseAchievementSecurityOfficerIdNum() {
		return compHouseAchievementSecurityOfficerIdNum;
	}

	public void setCompHouseAchievementSecurityOfficerIdNum(String compHouseAchievementSecurityOfficerIdNum) {
		this.compHouseAchievementSecurityOfficerIdNum = compHouseAchievementSecurityOfficerIdNum;
	}

	public String getCompHouseAchievementStandardWorker() {
		return compHouseAchievementStandardWorker;
	}

	public void setCompHouseAchievementStandardWorker(String compHouseAchievementStandardWorker) {
		this.compHouseAchievementStandardWorker = compHouseAchievementStandardWorker;
	}

	public String getCompHouseAchievementStandardWorkerCertificateNum() {
		return compHouseAchievementStandardWorkerCertificateNum;
	}

	public void setCompHouseAchievementStandardWorkerCertificateNum(String compHouseAchievementStandardWorkerCertificateNum) {
		this.compHouseAchievementStandardWorkerCertificateNum = compHouseAchievementStandardWorkerCertificateNum;
	}

	public String getCompHouseAchievementStandardWorkerIdNum() {
		return compHouseAchievementStandardWorkerIdNum;
	}

	public void setCompHouseAchievementStandardWorkerIdNum(String compHouseAchievementStandardWorkerIdNum) {
		this.compHouseAchievementStandardWorkerIdNum = compHouseAchievementStandardWorkerIdNum;
	}

	public String getCompHouseAchievementMaterialMan() {
		return compHouseAchievementMaterialMan;
	}

	public void setCompHouseAchievementMaterialMan(String compHouseAchievementMaterialMan) {
		this.compHouseAchievementMaterialMan = compHouseAchievementMaterialMan;
	}

	public String getCompHouseAchievementMaterialManCertificateNum() {
		return compHouseAchievementMaterialManCertificateNum;
	}

	public void setCompHouseAchievementMaterialManCertificateNum(String compHouseAchievementMaterialManCertificateNum) {
		this.compHouseAchievementMaterialManCertificateNum = compHouseAchievementMaterialManCertificateNum;
	}

	public String getCompHouseAchievementMaterialManIdNum() {
		return compHouseAchievementMaterialManIdNum;
	}

	public void setCompHouseAchievementMaterialManIdNum(String compHouseAchievementMaterialManIdNum) {
		this.compHouseAchievementMaterialManIdNum = compHouseAchievementMaterialManIdNum;
	}

	public String getCompHouseAchievementMechanic() {
		return compHouseAchievementMechanic;
	}

	public void setCompHouseAchievementMechanic(String compHouseAchievementMechanic) {
		this.compHouseAchievementMechanic = compHouseAchievementMechanic;
	}

	public String getCompHouseAchievementMechanicCertificateNum() {
		return compHouseAchievementMechanicCertificateNum;
	}

	public void setCompHouseAchievementMechanicCertificateNum(String compHouseAchievementMechanicCertificateNum) {
		this.compHouseAchievementMechanicCertificateNum = compHouseAchievementMechanicCertificateNum;
	}

	public String getCompHouseAchievementMechanicIdNum() {
		return compHouseAchievementMechanicIdNum;
	}

	public void setCompHouseAchievementMechanicIdNum(String compHouseAchievementMechanicIdNum) {
		this.compHouseAchievementMechanicIdNum = compHouseAchievementMechanicIdNum;
	}

	public String getCompHouseAchievementLabors() {
		return compHouseAchievementLabors;
	}

	public void setCompHouseAchievementLabors(String compHouseAchievementLabors) {
		this.compHouseAchievementLabors = compHouseAchievementLabors;
	}

	public String getCompHouseAchievementLaborsCertificateNum() {
		return compHouseAchievementLaborsCertificateNum;
	}

	public void setCompHouseAchievementLaborsCertificateNum(String compHouseAchievementLaborsCertificateNum) {
		this.compHouseAchievementLaborsCertificateNum = compHouseAchievementLaborsCertificateNum;
	}

	public String getCompHouseAchievementLaborsIdNum() {
		return compHouseAchievementLaborsIdNum;
	}

	public void setCompHouseAchievementLaborsIdNum(String compHouseAchievementLaborsIdNum) {
		this.compHouseAchievementLaborsIdNum = compHouseAchievementLaborsIdNum;
	}

	public String getCompHouseAchievementDataClerk() {
		return compHouseAchievementDataClerk;
	}

	public void setCompHouseAchievementDataClerk(String compHouseAchievementDataClerk) {
		this.compHouseAchievementDataClerk = compHouseAchievementDataClerk;
	}

	public String getCompHouseAchievementDataClerkCertificateNum() {
		return compHouseAchievementDataClerkCertificateNum;
	}

	public void setCompHouseAchievementDataClerkCertificateNum(String compHouseAchievementDataClerkCertificateNum) {
		this.compHouseAchievementDataClerkCertificateNum = compHouseAchievementDataClerkCertificateNum;
	}

	public String getCompHouseAchievementDataClerkIdNum() {
		return compHouseAchievementDataClerkIdNum;
	}

	public void setCompHouseAchievementDataClerkIdNum(String compHouseAchievementDataClerkIdNum) {
		this.compHouseAchievementDataClerkIdNum = compHouseAchievementDataClerkIdNum;
	}

	public Integer getCompHouseAchievementVersion() {
		return compHouseAchievementVersion;
	}

	public void setCompHouseAchievementVersion(Integer compHouseAchievementVersion) {
		this.compHouseAchievementVersion = compHouseAchievementVersion;
	}

	public Integer getCompHouseAchievementVersionMin() {
		return compHouseAchievementVersionMin;
	}

	public void setCompHouseAchievementVersionMin(Integer compHouseAchievementVersionMin) {
		this.compHouseAchievementVersionMin = compHouseAchievementVersionMin;
	}

	public Integer getCompHouseAchievementVersionMax() {
		return compHouseAchievementVersionMax;
	}

	public void setCompHouseAchievementVersionMax(Integer compHouseAchievementVersionMax) {
		this.compHouseAchievementVersionMax = compHouseAchievementVersionMax;
	}

	public Date getCompHouseAchievementCreateTime() {
		return compHouseAchievementCreateTime;
	}

	public void setCompHouseAchievementCreateTime(Date compHouseAchievementCreateTime) {
		this.compHouseAchievementCreateTime = compHouseAchievementCreateTime;
	}

	public Date getCompHouseAchievementCreateTimeMin() {
		return compHouseAchievementCreateTimeMin;
	}

	public void setCompHouseAchievementCreateTimeMin(Date compHouseAchievementCreateTimeMin) {
		this.compHouseAchievementCreateTimeMin = compHouseAchievementCreateTimeMin;
	}

	public Date getCompHouseAchievementCreateTimeMax() {
		return compHouseAchievementCreateTimeMax;
	}

	public void setCompHouseAchievementCreateTimeMax(Date compHouseAchievementCreateTimeMax) {
		this.compHouseAchievementCreateTimeMax = compHouseAchievementCreateTimeMax;
	}

	public Date getCompHouseAchievementUpdateTime() {
		return compHouseAchievementUpdateTime;
	}

	public void setCompHouseAchievementUpdateTime(Date compHouseAchievementUpdateTime) {
		this.compHouseAchievementUpdateTime = compHouseAchievementUpdateTime;
	}

	public Date getCompHouseAchievementUpdateTimeMin() {
		return compHouseAchievementUpdateTimeMin;
	}

	public void setCompHouseAchievementUpdateTimeMin(Date compHouseAchievementUpdateTimeMin) {
		this.compHouseAchievementUpdateTimeMin = compHouseAchievementUpdateTimeMin;
	}

	public Date getCompHouseAchievementUpdateTimeMax() {
		return compHouseAchievementUpdateTimeMax;
	}

	public void setCompHouseAchievementUpdateTimeMax(Date compHouseAchievementUpdateTimeMax) {
		this.compHouseAchievementUpdateTimeMax = compHouseAchievementUpdateTimeMax;
	}

	public Byte getCompHouseAchievementIsActive() {
		return compHouseAchievementIsActive;
	}

	public void setCompHouseAchievementIsActive(Byte compHouseAchievementIsActive) {
		this.compHouseAchievementIsActive = compHouseAchievementIsActive;
	}

	public Byte getCompHouseAchievementIsActiveMin() {
		return compHouseAchievementIsActiveMin;
	}

	public void setCompHouseAchievementIsActiveMin(Byte compHouseAchievementIsActiveMin) {
		this.compHouseAchievementIsActiveMin = compHouseAchievementIsActiveMin;
	}

	public Byte getCompHouseAchievementIsActiveMax() {
		return compHouseAchievementIsActiveMax;
	}

	public void setCompHouseAchievementIsActiveMax(Byte compHouseAchievementIsActiveMax) {
		this.compHouseAchievementIsActiveMax = compHouseAchievementIsActiveMax;
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
        return "CompHouseAchievementCompanyQuery {" +
                "compHouseAchievementId = " + compHouseAchievementId + 
				", compHouseAchievementIdMin = " + compHouseAchievementIdMin + 
				", compHouseAchievementIdMax = " + compHouseAchievementIdMax + 
				", compHouseAchievementCompId = " + compHouseAchievementCompId + 
				", compHouseAchievementCompIdMin = " + compHouseAchievementCompIdMin + 
				", compHouseAchievementCompIdMax = " + compHouseAchievementCompIdMax + 
				", compHouseAchievementProjectName = " + compHouseAchievementProjectName + 
				", compHouseAchievementBuilderName = " + compHouseAchievementBuilderName + 
				", compHouseAchievementMarkMoney = " + compHouseAchievementMarkMoney + 
				", compHouseAchievementBuildScale = " + compHouseAchievementBuildScale + 
				", compHouseAchievementRegionType = " + compHouseAchievementRegionType + 
				", compHouseAchievementMarkComp = " + compHouseAchievementMarkComp + 
				", compHouseAchievementBuildComp = " + compHouseAchievementBuildComp + 
				", compHouseAchievementProjectAddr = " + compHouseAchievementProjectAddr + 
				", compHouseAchievementContractDate = " + compHouseAchievementContractDate + 
				", compHouseAchievementContractDateMin = " + compHouseAchievementContractDateMin + 
				", compHouseAchievementContractDateMax = " + compHouseAchievementContractDateMax + 
				", compHouseAchievementMarkDate = " + compHouseAchievementMarkDate + 
				", compHouseAchievementMarkDateMin = " + compHouseAchievementMarkDateMin + 
				", compHouseAchievementMarkDateMax = " + compHouseAchievementMarkDateMax + 
				", compHouseAchievementName = " + compHouseAchievementName + 
				", compHouseAchievementCertificateNum = " + compHouseAchievementCertificateNum + 
				", compHouseAchievementConstructors = " + compHouseAchievementConstructors + 
				", compHouseAchievementConstructorsCertificateNum = " + compHouseAchievementConstructorsCertificateNum + 
				", compHouseAchievementConstructorsIdNum = " + compHouseAchievementConstructorsIdNum + 
				", compHouseAchievementQualityWorker = " + compHouseAchievementQualityWorker + 
				", compHouseAchievementQualityWorkerCertificateNum = " + compHouseAchievementQualityWorkerCertificateNum + 
				", compHouseAchievementQualityWorkerIdNum = " + compHouseAchievementQualityWorkerIdNum + 
				", compHouseAchievementSecurityOfficer = " + compHouseAchievementSecurityOfficer + 
				", compHouseAchievementSecurityOfficerCertificateNum = " + compHouseAchievementSecurityOfficerCertificateNum + 
				", compHouseAchievementSecurityOfficerIdNum = " + compHouseAchievementSecurityOfficerIdNum + 
				", compHouseAchievementStandardWorker = " + compHouseAchievementStandardWorker + 
				", compHouseAchievementStandardWorkerCertificateNum = " + compHouseAchievementStandardWorkerCertificateNum + 
				", compHouseAchievementStandardWorkerIdNum = " + compHouseAchievementStandardWorkerIdNum + 
				", compHouseAchievementMaterialMan = " + compHouseAchievementMaterialMan + 
				", compHouseAchievementMaterialManCertificateNum = " + compHouseAchievementMaterialManCertificateNum + 
				", compHouseAchievementMaterialManIdNum = " + compHouseAchievementMaterialManIdNum + 
				", compHouseAchievementMechanic = " + compHouseAchievementMechanic + 
				", compHouseAchievementMechanicCertificateNum = " + compHouseAchievementMechanicCertificateNum + 
				", compHouseAchievementMechanicIdNum = " + compHouseAchievementMechanicIdNum + 
				", compHouseAchievementLabors = " + compHouseAchievementLabors + 
				", compHouseAchievementLaborsCertificateNum = " + compHouseAchievementLaborsCertificateNum + 
				", compHouseAchievementLaborsIdNum = " + compHouseAchievementLaborsIdNum + 
				", compHouseAchievementDataClerk = " + compHouseAchievementDataClerk + 
				", compHouseAchievementDataClerkCertificateNum = " + compHouseAchievementDataClerkCertificateNum + 
				", compHouseAchievementDataClerkIdNum = " + compHouseAchievementDataClerkIdNum + 
				", compHouseAchievementVersion = " + compHouseAchievementVersion + 
				", compHouseAchievementVersionMin = " + compHouseAchievementVersionMin + 
				", compHouseAchievementVersionMax = " + compHouseAchievementVersionMax + 
				", compHouseAchievementCreateTime = " + compHouseAchievementCreateTime + 
				", compHouseAchievementCreateTimeMin = " + compHouseAchievementCreateTimeMin + 
				", compHouseAchievementCreateTimeMax = " + compHouseAchievementCreateTimeMax + 
				", compHouseAchievementUpdateTime = " + compHouseAchievementUpdateTime + 
				", compHouseAchievementUpdateTimeMin = " + compHouseAchievementUpdateTimeMin + 
				", compHouseAchievementUpdateTimeMax = " + compHouseAchievementUpdateTimeMax + 
				", compHouseAchievementIsActive = " + compHouseAchievementIsActive + 
				", compHouseAchievementIsActiveMin = " + compHouseAchievementIsActiveMin + 
				", compHouseAchievementIsActiveMax = " + compHouseAchievementIsActiveMax + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
