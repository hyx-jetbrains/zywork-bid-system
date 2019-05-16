package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * MarkCarpoolDTO数据传输对象类<br/>
 *
 * 创建于2019-05-16<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class MarkCarpoolDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035813953795L;

    // 开标拼车编号
	private Long id;
	// 用户编号
	private Long userId;
	// 项目编号
	private Long projectId;
	// 出发城市
	private String startCity;
	// 出发地点
	private String startAddr;
	// 目的地城市
	private String endCity;
	// 目的地
	private String endAddr;
	// 出发时间
	private Date startTime;
	// 汽车类型
	private String carType;
	// 搭载人数
	private Integer peopleCount;
	// 申请人数
	private Integer recordCount;
	// 价格
	private Long price;
	// 联系人姓名
	private String name;
	// 联系人电话
	private String phone;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public MarkCarpoolDTO () {}

    public MarkCarpoolDTO (Long id, Long userId, Long projectId, String startCity, String startAddr, String endCity, String endAddr, Date startTime, String carType, Integer peopleCount, Integer recordCount, Long price, String name, String phone, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.startCity = startCity;
		this.startAddr = startAddr;
		this.endCity = endCity;
		this.endAddr = endAddr;
		this.startTime = startTime;
		this.carType = carType;
		this.peopleCount = peopleCount;
		this.recordCount = recordCount;
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

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
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
        return "MarkCarpoolDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", projectId = " + projectId + 
				", startCity = " + startCity + 
				", startAddr = " + startAddr + 
				", endCity = " + endCity + 
				", endAddr = " + endAddr + 
				", startTime = " + startTime + 
				", carType = " + carType + 
				", peopleCount = " + peopleCount + 
				", recordCount = " + recordCount + 
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
