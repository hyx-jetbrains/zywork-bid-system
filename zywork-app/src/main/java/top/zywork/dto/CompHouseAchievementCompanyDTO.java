package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompHouseAchievementCompanyDTO数据传输对象类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompHouseAchievementCompanyDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036785496135L;

    //t_comp_house_achievement表的字段对应的属性
	// 企业房建业绩编号
	private Long compHouseAchievementId;
	// 企业编号
	private Long compHouseAchievementCompId;
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
	private Date compHouseAchievementContractDate;
	// 中标日期
	private Date compHouseAchievementMarkDate;
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
	// 创建时间
	private Date compHouseAchievementCreateTime;
	// 更新时间
	private Date compHouseAchievementUpdateTime;
	// 是否激活
	private Byte compHouseAchievementIsActive;
	//t_company表的字段对应的属性
	// 企业类型
	private String companyCompType;
	// 行业分类
	private String companyIndustryType;
	// 企业名称
	private String companyCompName;
	// 金额
	private BigDecimal money;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
    public CompHouseAchievementCompanyDTO () {}

    public CompHouseAchievementCompanyDTO (Long compHouseAchievementId, Long compHouseAchievementCompId, String compHouseAchievementProjectName, String compHouseAchievementBuilderName, String compHouseAchievementMarkMoney, String compHouseAchievementBuildScale, String compHouseAchievementRegionType, String compHouseAchievementMarkComp, String compHouseAchievementBuildComp, String compHouseAchievementProjectAddr, Date compHouseAchievementContractDate, Date compHouseAchievementMarkDate, String compHouseAchievementName, String compHouseAchievementCertificateNum, String compHouseAchievementConstructors, String compHouseAchievementConstructorsCertificateNum, String compHouseAchievementConstructorsIdNum, String compHouseAchievementQualityWorker, String compHouseAchievementQualityWorkerCertificateNum, String compHouseAchievementQualityWorkerIdNum, String compHouseAchievementSecurityOfficer, String compHouseAchievementSecurityOfficerCertificateNum, String compHouseAchievementSecurityOfficerIdNum, String compHouseAchievementStandardWorker, String compHouseAchievementStandardWorkerCertificateNum, String compHouseAchievementStandardWorkerIdNum, String compHouseAchievementMaterialMan, String compHouseAchievementMaterialManCertificateNum, String compHouseAchievementMaterialManIdNum, String compHouseAchievementMechanic, String compHouseAchievementMechanicCertificateNum, String compHouseAchievementMechanicIdNum, String compHouseAchievementLabors, String compHouseAchievementLaborsCertificateNum, String compHouseAchievementLaborsIdNum, String compHouseAchievementDataClerk, String compHouseAchievementDataClerkCertificateNum, String compHouseAchievementDataClerkIdNum, Integer compHouseAchievementVersion, Date compHouseAchievementCreateTime, Date compHouseAchievementUpdateTime, Byte compHouseAchievementIsActive, String companyCompType, String companyIndustryType, String companyCompName) {
        this.compHouseAchievementId = compHouseAchievementId;
		this.compHouseAchievementCompId = compHouseAchievementCompId;
		this.compHouseAchievementProjectName = compHouseAchievementProjectName;
		this.compHouseAchievementBuilderName = compHouseAchievementBuilderName;
		this.compHouseAchievementMarkMoney = compHouseAchievementMarkMoney;
		this.compHouseAchievementBuildScale = compHouseAchievementBuildScale;
		this.compHouseAchievementRegionType = compHouseAchievementRegionType;
		this.compHouseAchievementMarkComp = compHouseAchievementMarkComp;
		this.compHouseAchievementBuildComp = compHouseAchievementBuildComp;
		this.compHouseAchievementProjectAddr = compHouseAchievementProjectAddr;
		this.compHouseAchievementContractDate = compHouseAchievementContractDate;
		this.compHouseAchievementMarkDate = compHouseAchievementMarkDate;
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
		this.compHouseAchievementCreateTime = compHouseAchievementCreateTime;
		this.compHouseAchievementUpdateTime = compHouseAchievementUpdateTime;
		this.compHouseAchievementIsActive = compHouseAchievementIsActive;
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

	public Long getCompHouseAchievementCompId() {
		return compHouseAchievementCompId;
	}

	public void setCompHouseAchievementCompId(Long compHouseAchievementCompId) {
		this.compHouseAchievementCompId = compHouseAchievementCompId;
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

	public Date getCompHouseAchievementMarkDate() {
		return compHouseAchievementMarkDate;
	}

	public void setCompHouseAchievementMarkDate(Date compHouseAchievementMarkDate) {
		this.compHouseAchievementMarkDate = compHouseAchievementMarkDate;
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

	public Date getCompHouseAchievementCreateTime() {
		return compHouseAchievementCreateTime;
	}

	public void setCompHouseAchievementCreateTime(Date compHouseAchievementCreateTime) {
		this.compHouseAchievementCreateTime = compHouseAchievementCreateTime;
	}

	public Date getCompHouseAchievementUpdateTime() {
		return compHouseAchievementUpdateTime;
	}

	public void setCompHouseAchievementUpdateTime(Date compHouseAchievementUpdateTime) {
		this.compHouseAchievementUpdateTime = compHouseAchievementUpdateTime;
	}

	public Byte getCompHouseAchievementIsActive() {
		return compHouseAchievementIsActive;
	}

	public void setCompHouseAchievementIsActive(Byte compHouseAchievementIsActive) {
		this.compHouseAchievementIsActive = compHouseAchievementIsActive;
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
        return "CompHouseAchievementCompanyDTO {" +
                "compHouseAchievementId = " + compHouseAchievementId + 
				", compHouseAchievementCompId = " + compHouseAchievementCompId + 
				", compHouseAchievementProjectName = " + compHouseAchievementProjectName + 
				", compHouseAchievementBuilderName = " + compHouseAchievementBuilderName + 
				", compHouseAchievementMarkMoney = " + compHouseAchievementMarkMoney + 
				", compHouseAchievementBuildScale = " + compHouseAchievementBuildScale + 
				", compHouseAchievementRegionType = " + compHouseAchievementRegionType + 
				", compHouseAchievementMarkComp = " + compHouseAchievementMarkComp + 
				", compHouseAchievementBuildComp = " + compHouseAchievementBuildComp + 
				", compHouseAchievementProjectAddr = " + compHouseAchievementProjectAddr + 
				", compHouseAchievementContractDate = " + compHouseAchievementContractDate + 
				", compHouseAchievementMarkDate = " + compHouseAchievementMarkDate + 
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
				", compHouseAchievementCreateTime = " + compHouseAchievementCreateTime + 
				", compHouseAchievementUpdateTime = " + compHouseAchievementUpdateTime + 
				", compHouseAchievementIsActive = " + compHouseAchievementIsActive + 
				", companyCompType = " + companyCompType + 
				", companyIndustryType = " + companyIndustryType + 
				", companyCompName = " + companyCompName + 
				" }";
    }

}
