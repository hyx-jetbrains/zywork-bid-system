package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CompHouseAchievementQuery查询对象类<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompHouseAchievementQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036754155336L;

    // 企业房建业绩编号
	private Long id;
	// 企业房建业绩编号（最小值）
	private Long idMin;
	// 企业房建业绩编号（最大值）
	private Long idMax;
	// 企业编号
	private Long compId;
	// 企业编号（最小值）
	private Long compIdMin;
	// 企业编号（最大值）
	private Long compIdMax;
	// 工程名称
	private String projectName;
	// 注册建造师
	private String builderName;
	// 中标金额
	private String markMoney;
	// 建设规模
	private String buildScale;
	// 项目所属地区归类
	private String regionType;
	// 中标单位
	private String markComp;
	// 建设单位
	private String buildComp;
	// 工程地址
	private String projectAddr;
	// 合同签订日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date contractDate;
	// 合同签订日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date contractDateMin;
	// 合同签订日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date contractDateMax;
	// 中标日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markDate;
	// 中标日期（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markDateMin;
	// 中标日期（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markDateMax;
	// 项目负责人
	private String name;
	// 项目负责人证书号
	private String certificateNum;
	// 施工员
	private String constructors;
	// 施工员证书号
	private String constructorsCertificateNum;
	// 施工员身份证号
	private String constructorsIdNum;
	// 质量员
	private String qualityWorker;
	// 质量员证书号
	private String qualityWorkerCertificateNum;
	// 质量员身份证号
	private String qualityWorkerIdNum;
	// 安全员
	private String securityOfficer;
	// 安全员证书号
	private String securityOfficerCertificateNum;
	// 安全员身份证号
	private String securityOfficerIdNum;
	// 标准员
	private String standardWorker;
	// 标准员证书号
	private String standardWorkerCertificateNum;
	// 标准员身份证号
	private String standardWorkerIdNum;
	// 材料员
	private String materialMan;
	// 材料员证书号
	private String materialManCertificateNum;
	// 材料员身份证号
	private String materialManIdNum;
	// 机械员
	private String mechanic;
	// 机械员证书号
	private String mechanicCertificateNum;
	// 机械员身份证号
	private String mechanicIdNum;
	// 劳务员
	private String labors;
	// 劳务员证书号
	private String laborsCertificateNum;
	// 劳务员身份证号
	private String laborsIdNum;
	// 资料员
	private String dataClerk;
	// 资料员证书号
	private String dataClerkCertificateNum;
	// 资料员身份证号
	private String dataClerkIdNum;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public CompHouseAchievementQuery () {}

    public CompHouseAchievementQuery (Long id, Long idMin, Long idMax, Long compId, Long compIdMin, Long compIdMax, String projectName, String builderName, String markMoney, String buildScale, String regionType, String markComp, String buildComp, String projectAddr, Date contractDate, Date contractDateMin, Date contractDateMax, Date markDate, Date markDateMin, Date markDateMax, String name, String certificateNum, String constructors, String constructorsCertificateNum, String constructorsIdNum, String qualityWorker, String qualityWorkerCertificateNum, String qualityWorkerIdNum, String securityOfficer, String securityOfficerCertificateNum, String securityOfficerIdNum, String standardWorker, String standardWorkerCertificateNum, String standardWorkerIdNum, String materialMan, String materialManCertificateNum, String materialManIdNum, String mechanic, String mechanicCertificateNum, String mechanicIdNum, String labors, String laborsCertificateNum, String laborsIdNum, String dataClerk, String dataClerkCertificateNum, String dataClerkIdNum, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.compId = compId;
		this.compIdMin = compIdMin;
		this.compIdMax = compIdMax;
		this.projectName = projectName;
		this.builderName = builderName;
		this.markMoney = markMoney;
		this.buildScale = buildScale;
		this.regionType = regionType;
		this.markComp = markComp;
		this.buildComp = buildComp;
		this.projectAddr = projectAddr;
		this.contractDate = contractDate;
		this.contractDateMin = contractDateMin;
		this.contractDateMax = contractDateMax;
		this.markDate = markDate;
		this.markDateMin = markDateMin;
		this.markDateMax = markDateMax;
		this.name = name;
		this.certificateNum = certificateNum;
		this.constructors = constructors;
		this.constructorsCertificateNum = constructorsCertificateNum;
		this.constructorsIdNum = constructorsIdNum;
		this.qualityWorker = qualityWorker;
		this.qualityWorkerCertificateNum = qualityWorkerCertificateNum;
		this.qualityWorkerIdNum = qualityWorkerIdNum;
		this.securityOfficer = securityOfficer;
		this.securityOfficerCertificateNum = securityOfficerCertificateNum;
		this.securityOfficerIdNum = securityOfficerIdNum;
		this.standardWorker = standardWorker;
		this.standardWorkerCertificateNum = standardWorkerCertificateNum;
		this.standardWorkerIdNum = standardWorkerIdNum;
		this.materialMan = materialMan;
		this.materialManCertificateNum = materialManCertificateNum;
		this.materialManIdNum = materialManIdNum;
		this.mechanic = mechanic;
		this.mechanicCertificateNum = mechanicCertificateNum;
		this.mechanicIdNum = mechanicIdNum;
		this.labors = labors;
		this.laborsCertificateNum = laborsCertificateNum;
		this.laborsIdNum = laborsIdNum;
		this.dataClerk = dataClerk;
		this.dataClerkCertificateNum = dataClerkCertificateNum;
		this.dataClerkIdNum = dataClerkIdNum;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public Long getCompIdMin() {
		return compIdMin;
	}

	public void setCompIdMin(Long compIdMin) {
		this.compIdMin = compIdMin;
	}

	public Long getCompIdMax() {
		return compIdMax;
	}

	public void setCompIdMax(Long compIdMax) {
		this.compIdMax = compIdMax;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public String getMarkMoney() {
		return markMoney;
	}

	public void setMarkMoney(String markMoney) {
		this.markMoney = markMoney;
	}

	public String getBuildScale() {
		return buildScale;
	}

	public void setBuildScale(String buildScale) {
		this.buildScale = buildScale;
	}

	public String getRegionType() {
		return regionType;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public String getMarkComp() {
		return markComp;
	}

	public void setMarkComp(String markComp) {
		this.markComp = markComp;
	}

	public String getBuildComp() {
		return buildComp;
	}

	public void setBuildComp(String buildComp) {
		this.buildComp = buildComp;
	}

	public String getProjectAddr() {
		return projectAddr;
	}

	public void setProjectAddr(String projectAddr) {
		this.projectAddr = projectAddr;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getContractDateMin() {
		return contractDateMin;
	}

	public void setContractDateMin(Date contractDateMin) {
		this.contractDateMin = contractDateMin;
	}

	public Date getContractDateMax() {
		return contractDateMax;
	}

	public void setContractDateMax(Date contractDateMax) {
		this.contractDateMax = contractDateMax;
	}

	public Date getMarkDate() {
		return markDate;
	}

	public void setMarkDate(Date markDate) {
		this.markDate = markDate;
	}

	public Date getMarkDateMin() {
		return markDateMin;
	}

	public void setMarkDateMin(Date markDateMin) {
		this.markDateMin = markDateMin;
	}

	public Date getMarkDateMax() {
		return markDateMax;
	}

	public void setMarkDateMax(Date markDateMax) {
		this.markDateMax = markDateMax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getConstructors() {
		return constructors;
	}

	public void setConstructors(String constructors) {
		this.constructors = constructors;
	}

	public String getConstructorsCertificateNum() {
		return constructorsCertificateNum;
	}

	public void setConstructorsCertificateNum(String constructorsCertificateNum) {
		this.constructorsCertificateNum = constructorsCertificateNum;
	}

	public String getConstructorsIdNum() {
		return constructorsIdNum;
	}

	public void setConstructorsIdNum(String constructorsIdNum) {
		this.constructorsIdNum = constructorsIdNum;
	}

	public String getQualityWorker() {
		return qualityWorker;
	}

	public void setQualityWorker(String qualityWorker) {
		this.qualityWorker = qualityWorker;
	}

	public String getQualityWorkerCertificateNum() {
		return qualityWorkerCertificateNum;
	}

	public void setQualityWorkerCertificateNum(String qualityWorkerCertificateNum) {
		this.qualityWorkerCertificateNum = qualityWorkerCertificateNum;
	}

	public String getQualityWorkerIdNum() {
		return qualityWorkerIdNum;
	}

	public void setQualityWorkerIdNum(String qualityWorkerIdNum) {
		this.qualityWorkerIdNum = qualityWorkerIdNum;
	}

	public String getSecurityOfficer() {
		return securityOfficer;
	}

	public void setSecurityOfficer(String securityOfficer) {
		this.securityOfficer = securityOfficer;
	}

	public String getSecurityOfficerCertificateNum() {
		return securityOfficerCertificateNum;
	}

	public void setSecurityOfficerCertificateNum(String securityOfficerCertificateNum) {
		this.securityOfficerCertificateNum = securityOfficerCertificateNum;
	}

	public String getSecurityOfficerIdNum() {
		return securityOfficerIdNum;
	}

	public void setSecurityOfficerIdNum(String securityOfficerIdNum) {
		this.securityOfficerIdNum = securityOfficerIdNum;
	}

	public String getStandardWorker() {
		return standardWorker;
	}

	public void setStandardWorker(String standardWorker) {
		this.standardWorker = standardWorker;
	}

	public String getStandardWorkerCertificateNum() {
		return standardWorkerCertificateNum;
	}

	public void setStandardWorkerCertificateNum(String standardWorkerCertificateNum) {
		this.standardWorkerCertificateNum = standardWorkerCertificateNum;
	}

	public String getStandardWorkerIdNum() {
		return standardWorkerIdNum;
	}

	public void setStandardWorkerIdNum(String standardWorkerIdNum) {
		this.standardWorkerIdNum = standardWorkerIdNum;
	}

	public String getMaterialMan() {
		return materialMan;
	}

	public void setMaterialMan(String materialMan) {
		this.materialMan = materialMan;
	}

	public String getMaterialManCertificateNum() {
		return materialManCertificateNum;
	}

	public void setMaterialManCertificateNum(String materialManCertificateNum) {
		this.materialManCertificateNum = materialManCertificateNum;
	}

	public String getMaterialManIdNum() {
		return materialManIdNum;
	}

	public void setMaterialManIdNum(String materialManIdNum) {
		this.materialManIdNum = materialManIdNum;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getMechanicCertificateNum() {
		return mechanicCertificateNum;
	}

	public void setMechanicCertificateNum(String mechanicCertificateNum) {
		this.mechanicCertificateNum = mechanicCertificateNum;
	}

	public String getMechanicIdNum() {
		return mechanicIdNum;
	}

	public void setMechanicIdNum(String mechanicIdNum) {
		this.mechanicIdNum = mechanicIdNum;
	}

	public String getLabors() {
		return labors;
	}

	public void setLabors(String labors) {
		this.labors = labors;
	}

	public String getLaborsCertificateNum() {
		return laborsCertificateNum;
	}

	public void setLaborsCertificateNum(String laborsCertificateNum) {
		this.laborsCertificateNum = laborsCertificateNum;
	}

	public String getLaborsIdNum() {
		return laborsIdNum;
	}

	public void setLaborsIdNum(String laborsIdNum) {
		this.laborsIdNum = laborsIdNum;
	}

	public String getDataClerk() {
		return dataClerk;
	}

	public void setDataClerk(String dataClerk) {
		this.dataClerk = dataClerk;
	}

	public String getDataClerkCertificateNum() {
		return dataClerkCertificateNum;
	}

	public void setDataClerkCertificateNum(String dataClerkCertificateNum) {
		this.dataClerkCertificateNum = dataClerkCertificateNum;
	}

	public String getDataClerkIdNum() {
		return dataClerkIdNum;
	}

	public void setDataClerkIdNum(String dataClerkIdNum) {
		this.dataClerkIdNum = dataClerkIdNum;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "CompHouseAchievementQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", compId = " + compId + 
				", compIdMin = " + compIdMin + 
				", compIdMax = " + compIdMax + 
				", projectName = " + projectName + 
				", builderName = " + builderName + 
				", markMoney = " + markMoney + 
				", buildScale = " + buildScale + 
				", regionType = " + regionType + 
				", markComp = " + markComp + 
				", buildComp = " + buildComp + 
				", projectAddr = " + projectAddr + 
				", contractDate = " + contractDate + 
				", contractDateMin = " + contractDateMin + 
				", contractDateMax = " + contractDateMax + 
				", markDate = " + markDate + 
				", markDateMin = " + markDateMin + 
				", markDateMax = " + markDateMax + 
				", name = " + name + 
				", certificateNum = " + certificateNum + 
				", constructors = " + constructors + 
				", constructorsCertificateNum = " + constructorsCertificateNum + 
				", constructorsIdNum = " + constructorsIdNum + 
				", qualityWorker = " + qualityWorker + 
				", qualityWorkerCertificateNum = " + qualityWorkerCertificateNum + 
				", qualityWorkerIdNum = " + qualityWorkerIdNum + 
				", securityOfficer = " + securityOfficer + 
				", securityOfficerCertificateNum = " + securityOfficerCertificateNum + 
				", securityOfficerIdNum = " + securityOfficerIdNum + 
				", standardWorker = " + standardWorker + 
				", standardWorkerCertificateNum = " + standardWorkerCertificateNum + 
				", standardWorkerIdNum = " + standardWorkerIdNum + 
				", materialMan = " + materialMan + 
				", materialManCertificateNum = " + materialManCertificateNum + 
				", materialManIdNum = " + materialManIdNum + 
				", mechanic = " + mechanic + 
				", mechanicCertificateNum = " + mechanicCertificateNum + 
				", mechanicIdNum = " + mechanicIdNum + 
				", labors = " + labors + 
				", laborsCertificateNum = " + laborsCertificateNum + 
				", laborsIdNum = " + laborsIdNum + 
				", dataClerk = " + dataClerk + 
				", dataClerkCertificateNum = " + dataClerkCertificateNum + 
				", dataClerkIdNum = " + dataClerkIdNum + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
