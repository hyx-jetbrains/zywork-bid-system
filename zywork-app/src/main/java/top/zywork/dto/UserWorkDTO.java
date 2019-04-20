package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserWorkDTO数据传输对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserWorkDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036638008060L;

    // 工作信息编号
	private Long id;
	// 用户编号
	private Long userId;
	// 身份证号
	private String idNum;
	// 工作单位
	private String workUnit;
	// 职务
	private String jobTitle;
	// 工作地点
	private String workAddr;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserWorkDTO () {}

    public UserWorkDTO (Long id, Long userId, String idNum, String workUnit, String jobTitle, String workAddr, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.idNum = idNum;
		this.workUnit = workUnit;
		this.jobTitle = jobTitle;
		this.workAddr = workAddr;
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

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getWorkAddr() {
		return workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
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
        return "UserWorkDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", idNum = " + idNum + 
				", workUnit = " + workUnit + 
				", jobTitle = " + jobTitle + 
				", workAddr = " + workAddr + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
