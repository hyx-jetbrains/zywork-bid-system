package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserExpertQuery查询对象类<br/>
 *
 * 创建于2019-05-06<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserExpertQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035586769592L;

    // 专家信息编号
	private Long id;
	// 专家信息编号（最小值）
	private Long idMin;
	// 专家信息编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 专家姓名
	private String name;
	// 性别
	private Byte gender;
	// 性别（最小值）
	private Byte genderMin;
	// 性别（最大值）
	private Byte genderMax;
	// 年龄
	private Integer age;
	// 年龄（最小值）
	private Integer ageMin;
	// 年龄（最大值）
	private Integer ageMax;
	// 专家类别
	private String type;
	// 是否全职
	private Byte isFulltime;
	// 是否全职（最小值）
	private Byte isFulltimeMin;
	// 是否全职（最大值）
	private Byte isFulltimeMax;
	// 联系电话
	private String phone;
	// 个人情况介绍
	private String memo;
	// 审核状态
	private Byte examineStatus;
	// 审核状态（最小值）
	private Byte examineStatusMin;
	// 审核状态（最大值）
	private Byte examineStatusMax;
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
	
    public UserExpertQuery () {}

    public UserExpertQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String name, Byte gender, Byte genderMin, Byte genderMax, Integer age, Integer ageMin, Integer ageMax, String type, Byte isFulltime, Byte isFulltimeMin, Byte isFulltimeMax, String phone, String memo, Byte examineStatus, Byte examineStatusMin, Byte examineStatusMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.name = name;
		this.gender = gender;
		this.genderMin = genderMin;
		this.genderMax = genderMax;
		this.age = age;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.type = type;
		this.isFulltime = isFulltime;
		this.isFulltimeMin = isFulltimeMin;
		this.isFulltimeMax = isFulltimeMax;
		this.phone = phone;
		this.memo = memo;
		this.examineStatus = examineStatus;
		this.examineStatusMin = examineStatusMin;
		this.examineStatusMax = examineStatusMax;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
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

	public Byte getGenderMin() {
		return genderMin;
	}

	public void setGenderMin(Byte genderMin) {
		this.genderMin = genderMin;
	}

	public Byte getGenderMax() {
		return genderMax;
	}

	public void setGenderMax(Byte genderMax) {
		this.genderMax = genderMax;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
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

	public Byte getIsFulltimeMin() {
		return isFulltimeMin;
	}

	public void setIsFulltimeMin(Byte isFulltimeMin) {
		this.isFulltimeMin = isFulltimeMin;
	}

	public Byte getIsFulltimeMax() {
		return isFulltimeMax;
	}

	public void setIsFulltimeMax(Byte isFulltimeMax) {
		this.isFulltimeMax = isFulltimeMax;
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

	public Byte getExamineStatusMin() {
		return examineStatusMin;
	}

	public void setExamineStatusMin(Byte examineStatusMin) {
		this.examineStatusMin = examineStatusMin;
	}

	public Byte getExamineStatusMax() {
		return examineStatusMax;
	}

	public void setExamineStatusMax(Byte examineStatusMax) {
		this.examineStatusMax = examineStatusMax;
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
        return "UserExpertQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", name = " + name + 
				", gender = " + gender + 
				", genderMin = " + genderMin + 
				", genderMax = " + genderMax + 
				", age = " + age + 
				", ageMin = " + ageMin + 
				", ageMax = " + ageMax + 
				", type = " + type + 
				", isFulltime = " + isFulltime + 
				", isFulltimeMin = " + isFulltimeMin + 
				", isFulltimeMax = " + isFulltimeMax + 
				", phone = " + phone + 
				", memo = " + memo + 
				", examineStatus = " + examineStatus + 
				", examineStatusMin = " + examineStatusMin + 
				", examineStatusMax = " + examineStatusMax + 
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
