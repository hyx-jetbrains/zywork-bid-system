package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * BuilderVO值对象类<br/>
 *
 * 创建于2019-05-07<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class BuilderVO extends BaseVO {

    private static final long serialVersionUID = -9223372035335672447L;

    // 建造师编号
	private Long id;
	// 用户编号
	private Long userId;
	// 姓名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String name;
	// 性别
	private Byte gender;
	// 出生年份
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;
	// 证件地址
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String certificateAddress;
	// 证书类别
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String certificateType;
	// 证书专业类型
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String certificateMajorType;
	// 证书状态
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String certificateStatus;
	// 注册状态
	@Size(min = 0, max = 4, message = "必须小于4个字符")
	private String certificateRegStatus;
	// 期望年薪
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String salary;
	// 手机号
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String phone;
	// 说明
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
	private Long[] resourceId;
	
    public BuilderVO () {}

    public BuilderVO (Long id, Long userId, String name, Byte gender, Date birthday, String certificateAddress, String certificateType, String certificateMajorType, String certificateStatus, String certificateRegStatus, String salary, String phone, String memo, Integer version, Date createTime, Date updateTime, Byte isActive,Long [] resourceId) {
        this.id = id;
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.certificateAddress = certificateAddress;
		this.certificateType = certificateType;
		this.certificateMajorType = certificateMajorType;
		this.certificateStatus = certificateStatus;
		this.certificateRegStatus = certificateRegStatus;
		this.salary = salary;
		this.phone = phone;
		this.memo = memo;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		this.resourceId = resourceId;
		
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

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCertificateAddress() {
		return certificateAddress;
	}

	public void setCertificateAddress(String certificateAddress) {
		this.certificateAddress = certificateAddress;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateMajorType() {
		return certificateMajorType;
	}

	public void setCertificateMajorType(String certificateMajorType) {
		this.certificateMajorType = certificateMajorType;
	}

	public String getCertificateStatus() {
		return certificateStatus;
	}

	public void setCertificateStatus(String certificateStatus) {
		this.certificateStatus = certificateStatus;
	}

	public String getCertificateRegStatus() {
		return certificateRegStatus;
	}

	public void setCertificateRegStatus(String certificateRegStatus) {
		this.certificateRegStatus = certificateRegStatus;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
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

	public Long[] getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long[] resourceId) {
		this.resourceId = resourceId;
	}

	@Override
    public String toString() {
        return "BuilderVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", name = " + name + 
				", gender = " + gender + 
				", birthday = " + birthday + 
				", certificateAddress = " + certificateAddress + 
				", certificateType = " + certificateType + 
				", certificateMajorType = " + certificateMajorType + 
				", certificateStatus = " + certificateStatus + 
				", certificateRegStatus = " + certificateRegStatus + 
				", salary = " + salary + 
				", phone = " + phone + 
				", memo = " + memo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
