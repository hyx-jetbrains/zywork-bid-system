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
 * 创建于2019-07-10<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class GuaranteeVO extends BaseVO {

    private static final long serialVersionUID = -9223372034855388324L;

    // 保函编号
	private Long id;
	// 项目编号
	private Long projectId;
	// 用户编号
	private Long userId;
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
	// 保函费
	private Long guaranteePrice;
	// 申请单位
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String applicant;
	// 营业执照
	private Long applicantResId;
	// 营业执照地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String applicantResSrc;
	// 联系人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String name;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
	// 地址
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String address;
	// 开户行
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String bank;
	// 开户行照片
	private Long bankResId;
	// 开户行照片地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String bankResSrc;
	// 取件方式
	@Size(min = 0, max = 50, message = "必须小于50个字符")
	private String pickUpType;
	// 办理状态
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String handleStatus;
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

    public GuaranteeVO (Long id, Long projectId, Long userId, String projectName, Date openMarkTime, String markUnitName, Integer constructionPeriod, Long assurePrice, String guaranteeComp, Long guaranteePrice, String applicant, Long applicantResId, String applicantResSrc, String name, String phone, String address, String bank, Long bankResId, String bankResSrc, String pickUpType, String handleStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
		this.applicantResId = applicantResId;
		this.applicantResSrc = applicantResSrc;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.bank = bank;
		this.bankResId = bankResId;
		this.bankResSrc = bankResSrc;
		this.pickUpType = pickUpType;
		this.handleStatus = handleStatus;
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

	public Long getApplicantResId() {
		return applicantResId;
	}

	public void setApplicantResId(Long applicantResId) {
		this.applicantResId = applicantResId;
	}

	public String getApplicantResSrc() {
		return applicantResSrc;
	}

	public void setApplicantResSrc(String applicantResSrc) {
		this.applicantResSrc = applicantResSrc;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Long getBankResId() {
		return bankResId;
	}

	public void setBankResId(Long bankResId) {
		this.bankResId = bankResId;
	}

	public String getBankResSrc() {
		return bankResSrc;
	}

	public void setBankResSrc(String bankResSrc) {
		this.bankResSrc = bankResSrc;
	}

	public String getPickUpType() {
		return pickUpType;
	}

	public void setPickUpType(String pickUpType) {
		this.pickUpType = pickUpType;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
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
				", userId = " + userId + 
				", projectName = " + projectName + 
				", openMarkTime = " + openMarkTime + 
				", markUnitName = " + markUnitName + 
				", constructionPeriod = " + constructionPeriod + 
				", assurePrice = " + assurePrice + 
				", guaranteeComp = " + guaranteeComp + 
				", guaranteePrice = " + guaranteePrice + 
				", applicant = " + applicant + 
				", applicantResId = " + applicantResId + 
				", applicantResSrc = " + applicantResSrc + 
				", name = " + name + 
				", phone = " + phone + 
				", address = " + address + 
				", bank = " + bank + 
				", bankResId = " + bankResId + 
				", bankResSrc = " + bankResSrc + 
				", pickUpType = " + pickUpType + 
				", handleStatus = " + handleStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
