package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * BuilderReqDO数据对象实体类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class BuilderReqDO extends BaseDO {

    private static final long serialVersionUID = -9223372036461915543L;

    // 建造师需求编号
	private Long id;
	// 用户编号
	private Long userId;
	// 手机号
	private String phone;
	// 说明
	private String memo;
	// 所需人数
	private Integer peopleCount;
	// 提供年薪
	private Long salary;
	// 企业地址
	private String compAddr;
	// 企业名称
	private String compName;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public BuilderReqDO () {}

    public BuilderReqDO (Long id, Long userId, String phone, String memo, Integer peopleCount, Long salary, String compAddr, String compName, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.phone = phone;
		this.memo = memo;
		this.peopleCount = peopleCount;
		this.salary = salary;
		this.compAddr = compAddr;
		this.compName = compName;
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

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
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
        return "BuilderReqDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", phone = " + phone + 
				", memo = " + memo + 
				", peopleCount = " + peopleCount + 
				", salary = " + salary + 
				", compAddr = " + compAddr + 
				", compName = " + compName + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
