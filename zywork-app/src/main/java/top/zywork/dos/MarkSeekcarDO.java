package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * MarkSeekcarDO数据对象实体类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class MarkSeekcarDO extends BaseDO {

    private static final long serialVersionUID = -9223372034935527631L;

    // 开标找车编号
	private Long id;
	// 用户编号
	private Long userId;
	// 项目编号
	private Long projectId;
	// 城市
	private String city;
	// 出发地点
	private String startAddr;
	// 目的地
	private String endAddr;
	// 出发时间
	private Date startTime;
	// 联系人姓名
	private String name;
	// 联系人电话
	private String phone;
	// 备注
	private String memo;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public MarkSeekcarDO () {}

    public MarkSeekcarDO (Long id, Long userId, Long projectId, String city, String startAddr, String endAddr, Date startTime, String name, String phone, String memo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.city = city;
		this.startAddr = startAddr;
		this.endAddr = endAddr;
		this.startTime = startTime;
		this.name = name;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStartAddr() {
		return startAddr;
	}

	public void setStartAddr(String startAddr) {
		this.startAddr = startAddr;
	}

	public String getEndAddr() {
		return endAddr;
	}

	public void setEndAddr(String endAddr) {
		this.endAddr = endAddr;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
        return "MarkSeekcarDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", projectId = " + projectId + 
				", city = " + city + 
				", startAddr = " + startAddr + 
				", endAddr = " + endAddr + 
				", startTime = " + startTime + 
				", name = " + name + 
				", phone = " + phone + 
				", memo = " + memo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
