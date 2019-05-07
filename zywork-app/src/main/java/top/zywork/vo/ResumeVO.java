package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ResumeVO值对象类<br/>
 *
 * 创建于2019-05-07<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ResumeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035460444477L;

    // 简历编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 姓名
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String name;
	// 性别
	private Byte gender;
	// 年龄
	private Integer age;
	// 求职类型
	private Byte isFulltime;
	// 求职岗位
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String jobTitle;
	// 工作时间（年）
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String workYear;
	// 学历
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String education;
	// 要求薪资/月
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String salary;
	// 是否允许平台推荐
	private Integer isRecommend;
	// 我的资质
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String aptitude;
	// 个人简介
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String intorduce;
	// 是否开放简历
	private Integer isShow;
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
	
    public ResumeVO () {}

    public ResumeVO (Long id, Long userId, String name, Byte gender, Integer age, Byte isFulltime, String jobTitle, String workYear, String education, String salary, Integer isRecommend, String aptitude, String intorduce, Integer isShow, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.isFulltime = isFulltime;
		this.jobTitle = jobTitle;
		this.workYear = workYear;
		this.education = education;
		this.salary = salary;
		this.isRecommend = isRecommend;
		this.aptitude = aptitude;
		this.intorduce = intorduce;
		this.isShow = isShow;
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

	public Byte getIsFulltime() {
		return isFulltime;
	}

	public void setIsFulltime(Byte isFulltime) {
		this.isFulltime = isFulltime;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getAptitude() {
		return aptitude;
	}

	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	public String getIntorduce() {
		return intorduce;
	}

	public void setIntorduce(String intorduce) {
		this.intorduce = intorduce;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
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
        return "ResumeVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", name = " + name + 
				", gender = " + gender + 
				", age = " + age + 
				", isFulltime = " + isFulltime + 
				", jobTitle = " + jobTitle + 
				", workYear = " + workYear + 
				", education = " + education + 
				", salary = " + salary + 
				", isRecommend = " + isRecommend + 
				", aptitude = " + aptitude + 
				", intorduce = " + intorduce + 
				", isShow = " + isShow + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
