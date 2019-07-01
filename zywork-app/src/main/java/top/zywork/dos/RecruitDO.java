package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * RecruitDO数据对象实体类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class RecruitDO extends BaseDO {

    private static final long serialVersionUID = -9223372036524057792L;

    // 招聘编号
	private Long id;
	// 用户编号
	private Long userId;
	// 招聘岗位
	private String jobTitle;
	// 是否全职
	private Byte isFulltime;
	// 工作时间（年）
	private String workYear;
	// 要求学历
	private String education;
	// 提供月薪
	private String salary;
	// 工作地
	private String workAddr;
	// 职位描述
	private String memo;
	// 招聘状态
	private String recruitStatus;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;

	// 联系电话
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public RecruitDO () {}

    public RecruitDO (Long id, Long userId, String jobTitle, Byte isFulltime, String workYear, String education, String salary, String workAddr, String memo, String recruitStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.jobTitle = jobTitle;
		this.isFulltime = isFulltime;
		this.workYear = workYear;
		this.education = education;
		this.salary = salary;
		this.workAddr = workAddr;
		this.memo = memo;
		this.recruitStatus = recruitStatus;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Byte getIsFulltime() {
		return isFulltime;
	}

	public void setIsFulltime(Byte isFulltime) {
		this.isFulltime = isFulltime;
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

	public String getWorkAddr() {
		return workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRecruitStatus() {
		return recruitStatus;
	}

	public void setRecruitStatus(String recruitStatus) {
		this.recruitStatus = recruitStatus;
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
        return "RecruitDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", jobTitle = " + jobTitle + 
				", isFulltime = " + isFulltime + 
				", workYear = " + workYear + 
				", education = " + education + 
				", salary = " + salary + 
				", workAddr = " + workAddr + 
				", memo = " + memo + 
				", recruitStatus = " + recruitStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
