package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GuaranteeVO值对象类<br/>
 *
 * 创建于2019-04-29<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class GuaranteeVO extends BaseVO {

    private static final long serialVersionUID = -9223372034874822721L;

    // 保函编号
	private Long id;
	// 项目编号
	private Long projectId;
	// 项目名称
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String projectName;
	// 开标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTime;
	// 招标单位名称
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String markUnitName;
	// 工期(天)
	private Integer constructionPeriod;
	// 担保金额(万元)
	private Long assurePrice;
	// 担保公司
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String guaranteeComp;
	// 申请人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String applicant;
	// 联系人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String name;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
	// 地址
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String address;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GuaranteeVO () {}

    public GuaranteeVO (Long id, Long projectId, String projectName, Date openMarkTime, String markUnitName, Integer constructionPeriod, Long assurePrice, String guaranteeComp, String applicant, String name, String phone, String address, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.projectId = projectId;
		this.projectName = projectName;
		this.openMarkTime = openMarkTime;
		this.markUnitName = markUnitName;
		this.constructionPeriod = constructionPeriod;
		this.assurePrice = assurePrice;
		this.guaranteeComp = guaranteeComp;
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
        return "GuaranteeVO {" +
                "id = " + id + 
				", projectId = " + projectId + 
				", projectName = " + projectName + 
				", openMarkTime = " + openMarkTime + 
				", markUnitName = " + markUnitName + 
				", constructionPeriod = " + constructionPeriod + 
				", assurePrice = " + assurePrice + 
				", guaranteeComp = " + guaranteeComp + 
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
