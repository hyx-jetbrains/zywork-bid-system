package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ResumeQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ResumeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035964726706L;

    // 简历编号
	private Long id;
	// 简历编号（最小值）
	private Long idMin;
	// 简历编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 姓名
	private String name;
	// 性别
	private String gender;
	// 年龄
	private Integer age;
	// 年龄（最小值）
	private Integer ageMin;
	// 年龄（最大值）
	private Integer ageMax;
	// 求职类型
	private Byte isFulltime;
	// 求职类型（最小值）
	private Byte isFulltimeMin;
	// 求职类型（最大值）
	private Byte isFulltimeMax;
	// 求职岗位
	private String jobTitle;
	// 工作时间（年）
	private String workYear;
	// 学历
	private String education;
	// 要求薪资/月
	private String salary;
	// 是否允许平台推荐
	private Integer isRecommend;
	// 是否允许平台推荐（最小值）
	private Integer isRecommendMin;
	// 是否允许平台推荐（最大值）
	private Integer isRecommendMax;
	// 我的资质
	private String aptitude;
	// 个人简介
	private String intorduce;
	// 是否开放简历
	private Integer isShow;
	// 是否开放简历（最小值）
	private Integer isShowMin;
	// 是否开放简历（最大值）
	private Integer isShowMax;
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
	
    public ResumeQuery () {}

    public ResumeQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String name, String gender, Integer age, Integer ageMin, Integer ageMax, Byte isFulltime, Byte isFulltimeMin, Byte isFulltimeMax, String jobTitle, String workYear, String education, String salary, Integer isRecommend, Integer isRecommendMin, Integer isRecommendMax, String aptitude, String intorduce, Integer isShow, Integer isShowMin, Integer isShowMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.isFulltime = isFulltime;
		this.isFulltimeMin = isFulltimeMin;
		this.isFulltimeMax = isFulltimeMax;
		this.jobTitle = jobTitle;
		this.workYear = workYear;
		this.education = education;
		this.salary = salary;
		this.isRecommend = isRecommend;
		this.isRecommendMin = isRecommendMin;
		this.isRecommendMax = isRecommendMax;
		this.aptitude = aptitude;
		this.intorduce = intorduce;
		this.isShow = isShow;
		this.isShowMin = isShowMin;
		this.isShowMax = isShowMax;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Integer getIsRecommendMin() {
		return isRecommendMin;
	}

	public void setIsRecommendMin(Integer isRecommendMin) {
		this.isRecommendMin = isRecommendMin;
	}

	public Integer getIsRecommendMax() {
		return isRecommendMax;
	}

	public void setIsRecommendMax(Integer isRecommendMax) {
		this.isRecommendMax = isRecommendMax;
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

	public Integer getIsShowMin() {
		return isShowMin;
	}

	public void setIsShowMin(Integer isShowMin) {
		this.isShowMin = isShowMin;
	}

	public Integer getIsShowMax() {
		return isShowMax;
	}

	public void setIsShowMax(Integer isShowMax) {
		this.isShowMax = isShowMax;
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
        return "ResumeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", name = " + name + 
				", gender = " + gender + 
				", age = " + age + 
				", ageMin = " + ageMin + 
				", ageMax = " + ageMax + 
				", isFulltime = " + isFulltime + 
				", isFulltimeMin = " + isFulltimeMin + 
				", isFulltimeMax = " + isFulltimeMax + 
				", jobTitle = " + jobTitle + 
				", workYear = " + workYear + 
				", education = " + education + 
				", salary = " + salary + 
				", isRecommend = " + isRecommend + 
				", isRecommendMin = " + isRecommendMin + 
				", isRecommendMax = " + isRecommendMax + 
				", aptitude = " + aptitude + 
				", intorduce = " + intorduce + 
				", isShow = " + isShow + 
				", isShowMin = " + isShowMin + 
				", isShowMax = " + isShowMax + 
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
