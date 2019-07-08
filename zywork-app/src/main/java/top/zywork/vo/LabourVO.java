package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * LabourVO值对象类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class LabourVO extends BaseVO {

    private static final long serialVersionUID = -9223372035629958457L;

    // 劳务求职编号
	private Long id;
	// 用户编号
	private Long userId;
	// 姓名
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String name;
	// 年龄
	private Integer age;
	// 从事工种
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String workType;
	// 求职类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String jobType;
	// 工作地点
	@Size(min = 0, max = 30, message = "必须小于30个字符")
	private String workAddr;
	// 详细地址
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String addrDesc;
	// 待遇要求
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String treatment;
	// 联系电话
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String phone;
	// 其他说明
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String memo;
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
	
    public LabourVO () {}

    public LabourVO (Long id, Long userId, String name, Integer age, String workType, String jobType, String workAddr, String addrDesc, String treatment, String phone, String memo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.name = name;
		this.age = age;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
        return "LabourVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", name = " + name + 
				", age = " + age + 
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
