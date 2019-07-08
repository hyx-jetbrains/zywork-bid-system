package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * LabourReqDTO数据传输对象类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class LabourReqDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035294300731L;

    // 劳务需求编号
	private Long id;
	// 用户编号
	private Long userId;
	// 企业名称
	private String compName;
	// 从事工种
	private String workType;
	// 求职类型
	private String jobType;
	// 工作地点
	private String workAddr;
	// 详细地址
	private String addrDesc;
	// 待遇要求
	private String treatment;
	// 联系电话
	private String phone;
	// 其他说明
	private String memo;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public LabourReqDTO () {}

    public LabourReqDTO (Long id, Long userId, String compName, String workType, String jobType, String workAddr, String addrDesc, String treatment, String phone, String memo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.compName = compName;
		this.workType = workType;
		this.jobType = jobType;
		this.workAddr = workAddr;
		this.addrDesc = addrDesc;
		this.treatment = treatment;
		this.phone = phone;
		this.memo = memo;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getWorkAddr() {
		return workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}

	public String getAddrDesc() {
		return addrDesc;
	}

	public void setAddrDesc(String addrDesc) {
		this.addrDesc = addrDesc;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
        return "LabourReqDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", compName = " + compName + 
				", workType = " + workType + 
				", jobType = " + jobType + 
				", workAddr = " + workAddr + 
				", addrDesc = " + addrDesc + 
				", treatment = " + treatment + 
				", phone = " + phone + 
				", memo = " + memo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
