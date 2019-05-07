package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserExpertVO值对象类<br/>
 *
 * 创建于2019-05-06<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserExpertVO extends BaseVO {

    private static final long serialVersionUID = -9223372036308989658L;

    // 专家信息编号
	private Long id;
	// 用户编号
	private Long userId;
	// 专家姓名
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String name;
	// 性别
	private Byte gender;
	// 年龄
	private Integer age;
	// 专家类别
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String type;
	// 是否全职
	private Byte isFulltime;
	// 联系电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
	// 个人情况介绍
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String memo;
	// 审核状态
	private Byte examineStatus;
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
	
    public UserExpertVO () {}

    public UserExpertVO (Long id, Long userId, String name, Byte gender, Integer age, String type, Byte isFulltime, String phone, String memo, Byte examineStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.type = type;
		this.isFulltime = isFulltime;
		this.phone = phone;
		this.memo = memo;
		this.examineStatus = examineStatus;
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

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Byte getIsFulltime() {
		return isFulltime;
	}

	public void setIsFulltime(Byte isFulltime) {
		this.isFulltime = isFulltime;
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

	public Byte getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(Byte examineStatus) {
		this.examineStatus = examineStatus;
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
        return "UserExpertVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", name = " + name + 
				", gender = " + gender + 
				", age = " + age + 
				", type = " + type + 
				", isFulltime = " + isFulltime + 
				", phone = " + phone + 
				", memo = " + memo + 
				", examineStatus = " + examineStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
