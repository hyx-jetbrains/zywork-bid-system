package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GuaranteeDTO数据传输对象类<br/>
 *
 * 创建于2019-05-13<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class GuaranteeDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035276731385L;

    // 保函编号
	private Long id;
	// 项目编号
	private Long projectId;
	// 用户编号
	private Long userId;
	// 项目名称
	private String projectName;
	// 开标时间
	private Date openMarkTime;
	// 招标单位名称
	private String markUnitName;
	// 工期(天)
	private Integer constructionPeriod;
	// 担保金额(万元)
	private Long assurePrice;
	// 担保公司
	private String guaranteeComp;
	// 保函费(元)
	private Long guaranteePrice;
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
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GuaranteeDTO () {}

    public GuaranteeDTO (Long id, Long projectId, Long userId, String projectName, Date openMarkTime, String markUnitName, Integer constructionPeriod, Long assurePrice, String guaranteeComp, Long guaranteePrice, String applicant, String name, String phone, String address, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.projectId = projectId;
		this.userId = userId;
		this.projectName = projectName;
		this.openMarkTime = openMarkTime;
		this.markUnitName = markUnitName;
		this.constructionPeriod = constructionPeriod;
		this.assurePrice = assurePrice;
		this.guaranteeComp = guaranteeComp;
		this.guaranteePrice = guaranteePrice;
		this.applicant = applicant;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Long getAssurePrice() {
		return assurePrice;
	}

	public void setAssurePrice(Long assurePrice) {
		this.assurePrice = assurePrice;
	}

	public String getGuaranteeComp() {
		return guaranteeComp;
	}

	public void setGuaranteeComp(String guaranteeComp) {
		this.guaranteeComp = guaranteeComp;
	}

	public Long getGuaranteePrice() {
		return guaranteePrice;
	}

	public void setGuaranteePrice(Long guaranteePrice) {
		this.guaranteePrice = guaranteePrice;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "GuaranteeDTO {" +
                "id = " + id + 
				", projectId = " + projectId + 
				", userId = " + userId + 
				", projectName = " + projectName + 
				", openMarkTime = " + openMarkTime + 
				", markUnitName = " + markUnitName + 
				", constructionPeriod = " + constructionPeriod + 
				", assurePrice = " + assurePrice + 
				", guaranteeComp = " + guaranteeComp + 
				", guaranteePrice = " + guaranteePrice + 
				", applicant = " + applicant + 
				", name = " + name + 
				", phone = " + phone + 
				", address = " + address + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
