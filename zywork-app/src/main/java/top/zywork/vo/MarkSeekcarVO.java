package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MarkSeekcarVO值对象类<br/>
 *
 * 创建于2019-05-16<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class MarkSeekcarVO extends BaseVO {

    private static final long serialVersionUID = -9223372035966818791L;

    // 开标找车编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 项目编号
	@NotNull(message = "此项是必须项")
	private Long projectId;
	// 出发城市
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String startCity;
	// 出发地点
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String startAddr;
	// 目的地城市
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String endCity;
	// 目的地
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String endAddr;
	// 出发时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	// 联系人姓名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String name;
	// 联系人电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
	// 备注
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String memo;
	// 申请人数
	private Integer recordCount;
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
	
    public MarkSeekcarVO () {}

    public MarkSeekcarVO (Long id, Long userId, Long projectId, String startCity, String startAddr, String endCity, String endAddr, Date startTime, String name, String phone, String memo, Integer recordCount, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.startCity = startCity;
		this.startAddr = startAddr;
		this.endCity = endCity;
		this.endAddr = endAddr;
		this.startTime = startTime;
		this.name = name;
		this.phone = phone;
		this.memo = memo;
		this.recordCount = recordCount;
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

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getStartAddr() {
		return startAddr;
	}

	public void setStartAddr(String startAddr) {
		this.startAddr = startAddr;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
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

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
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
        return "MarkSeekcarVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", projectId = " + projectId + 
				", startCity = " + startCity + 
				", startAddr = " + startAddr + 
				", endCity = " + endCity + 
				", endAddr = " + endAddr + 
				", startTime = " + startTime + 
				", name = " + name + 
				", phone = " + phone + 
				", memo = " + memo + 
				", recordCount = " + recordCount + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
