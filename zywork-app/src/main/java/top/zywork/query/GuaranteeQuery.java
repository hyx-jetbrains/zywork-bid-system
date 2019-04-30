package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GuaranteeQuery查询对象类<br/>
 *
 * 创建于2019-04-29<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class GuaranteeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035550801952L;

    // 保函编号
	private Long id;
	// 保函编号（最小值）
	private Long idMin;
	// 保函编号（最大值）
	private Long idMax;
	// 项目编号
	private Long projectId;
	// 项目编号（最小值）
	private Long projectIdMin;
	// 项目编号（最大值）
	private Long projectIdMax;
	// 项目名称
	private String projectName;
	// 开标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTime;
	// 开标时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTimeMin;
	// 开标时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTimeMax;
	// 招标单位名称
	private String markUnitName;
	// 工期(天)
	private Integer constructionPeriod;
	// 工期(天)（最小值）
	private Integer constructionPeriodMin;
	// 工期(天)（最大值）
	private Integer constructionPeriodMax;
	// 担保金额(万元)
	private Long assurePrice;
	// 担保金额(万元)（最小值）
	private Long assurePriceMin;
	// 担保金额(万元)（最大值）
	private Long assurePriceMax;
	// 担保公司
	private String guaranteeComp;
	// 申请人
	private String applicant;
	// 联系人
	private String name;
	// 手机号
	private String phone;
	// 地址
	private String address;
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
	
    public GuaranteeQuery () {}

    public GuaranteeQuery (Long id, Long idMin, Long idMax, Long projectId, Long projectIdMin, Long projectIdMax, String projectName, Date openMarkTime, Date openMarkTimeMin, Date openMarkTimeMax, String markUnitName, Integer constructionPeriod, Integer constructionPeriodMin, Integer constructionPeriodMax, Long assurePrice, Long assurePriceMin, Long assurePriceMax, String guaranteeComp, String applicant, String name, String phone, String address, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.projectId = projectId;
		this.projectIdMin = projectIdMin;
		this.projectIdMax = projectIdMax;
		this.projectName = projectName;
		this.openMarkTime = openMarkTime;
		this.openMarkTimeMin = openMarkTimeMin;
		this.openMarkTimeMax = openMarkTimeMax;
		this.markUnitName = markUnitName;
		this.constructionPeriod = constructionPeriod;
		this.constructionPeriodMin = constructionPeriodMin;
		this.constructionPeriodMax = constructionPeriodMax;
		this.assurePrice = assurePrice;
		this.assurePriceMin = assurePriceMin;
		this.assurePriceMax = assurePriceMax;
		this.guaranteeComp = guaranteeComp;
		this.applicant = applicant;
		this.name = name;
		this.phone = phone;
		this.address = address;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getProjectIdMin() {
		return projectIdMin;
	}

	public void setProjectIdMin(Long projectIdMin) {
		this.projectIdMin = projectIdMin;
	}

	public Long getProjectIdMax() {
		return projectIdMax;
	}

	public void setProjectIdMax(Long projectIdMax) {
		this.projectIdMax = projectIdMax;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getOpenMarkTime() {
		return openMarkTime;
	}

	public void setOpenMarkTime(Date openMarkTime) {
		this.openMarkTime = openMarkTime;
	}

	public Date getOpenMarkTimeMin() {
		return openMarkTimeMin;
	}

	public void setOpenMarkTimeMin(Date openMarkTimeMin) {
		this.openMarkTimeMin = openMarkTimeMin;
	}

	public Date getOpenMarkTimeMax() {
		return openMarkTimeMax;
	}

	public void setOpenMarkTimeMax(Date openMarkTimeMax) {
		this.openMarkTimeMax = openMarkTimeMax;
	}

	public String getMarkUnitName() {
		return markUnitName;
	}

	public void setMarkUnitName(String markUnitName) {
		this.markUnitName = markUnitName;
	}

	public Integer getConstructionPeriod() {
		return constructionPeriod;
	}

	public void setConstructionPeriod(Integer constructionPeriod) {
		this.constructionPeriod = constructionPeriod;
	}

	public Integer getConstructionPeriodMin() {
		return constructionPeriodMin;
	}

	public void setConstructionPeriodMin(Integer constructionPeriodMin) {
		this.constructionPeriodMin = constructionPeriodMin;
	}

	public Integer getConstructionPeriodMax() {
		return constructionPeriodMax;
	}

	public void setConstructionPeriodMax(Integer constructionPeriodMax) {
		this.constructionPeriodMax = constructionPeriodMax;
	}

	public Long getAssurePrice() {
		return assurePrice;
	}

	public void setAssurePrice(Long assurePrice) {
		this.assurePrice = assurePrice;
	}

	public Long getAssurePriceMin() {
		return assurePriceMin;
	}

	public void setAssurePriceMin(Long assurePriceMin) {
		this.assurePriceMin = assurePriceMin;
	}

	public Long getAssurePriceMax() {
		return assurePriceMax;
	}

	public void setAssurePriceMax(Long assurePriceMax) {
		this.assurePriceMax = assurePriceMax;
	}

	public String getGuaranteeComp() {
		return guaranteeComp;
	}

	public void setGuaranteeComp(String guaranteeComp) {
		this.guaranteeComp = guaranteeComp;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
        return "GuaranteeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", projectId = " + projectId + 
				", projectIdMin = " + projectIdMin + 
				", projectIdMax = " + projectIdMax + 
				", projectName = " + projectName + 
				", openMarkTime = " + openMarkTime + 
				", openMarkTimeMin = " + openMarkTimeMin + 
				", openMarkTimeMax = " + openMarkTimeMax + 
				", markUnitName = " + markUnitName + 
				", constructionPeriod = " + constructionPeriod + 
				", constructionPeriodMin = " + constructionPeriodMin + 
				", constructionPeriodMax = " + constructionPeriodMax + 
				", assurePrice = " + assurePrice + 
				", assurePriceMin = " + assurePriceMin + 
				", assurePriceMax = " + assurePriceMax + 
				", guaranteeComp = " + guaranteeComp + 
				", applicant = " + applicant + 
				", name = " + name + 
				", phone = " + phone + 
				", address = " + address + 
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
