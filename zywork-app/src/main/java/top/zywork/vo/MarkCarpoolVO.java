package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MarkCarpoolVO值对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class MarkCarpoolVO extends BaseVO {

    private static final long serialVersionUID = -9223372036853225426L;

    // 开标拼车编号
	private Long id;
	// 用户编号
	private Long userId;
	// 项目编号
	@NotNull(message = "此项是必须项")
	private Long projectId;
	// 城市
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String city;
	// 出发地点
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String startAddr;
	// 目的地
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String endAddr;
	// 出发时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	// 汽车类型
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String carType;
	// 搭载人数
	private Integer peopleCount;
	// 价格
	private Long price;
	// 联系人姓名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String name;
	// 联系人电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
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
	
    public MarkCarpoolVO () {}

    public MarkCarpoolVO (Long id, Long userId, Long projectId, String city, String startAddr, String endAddr, Date startTime, String carType, Integer peopleCount, Long price, String name, String phone, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.city = city;
		this.startAddr = startAddr;
		this.endAddr = endAddr;
		this.startTime = startTime;
		this.carType = carType;
		this.peopleCount = peopleCount;
		this.price = price;
		this.name = name;
		this.phone = phone;
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

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
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
        return "MarkCarpoolVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", projectId = " + projectId + 
				", city = " + city + 
				", startAddr = " + startAddr + 
				", endAddr = " + endAddr + 
				", startTime = " + startTime + 
				", carType = " + carType + 
				", peopleCount = " + peopleCount + 
				", price = " + price + 
				", name = " + name + 
				", phone = " + phone + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
