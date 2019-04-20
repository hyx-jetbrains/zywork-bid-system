package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MarkCarpoolQuery查询对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class MarkCarpoolQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036699093307L;

    // 开标拼车编号
	private Long id;
	// 开标拼车编号（最小值）
	private Long idMin;
	// 开标拼车编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 项目编号
	private Long projectId;
	// 项目编号（最小值）
	private Long projectIdMin;
	// 项目编号（最大值）
	private Long projectIdMax;
	// 城市
	private String city;
	// 出发地点
	private String startAddr;
	// 目的地
	private String endAddr;
	// 出发时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	// 出发时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTimeMin;
	// 出发时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTimeMax;
	// 汽车类型
	private String carType;
	// 搭载人数
	private Integer peopleCount;
	// 搭载人数（最小值）
	private Integer peopleCountMin;
	// 搭载人数（最大值）
	private Integer peopleCountMax;
	// 价格
	private Long price;
	// 价格（最小值）
	private Long priceMin;
	// 价格（最大值）
	private Long priceMax;
	// 联系人姓名
	private String name;
	// 联系人电话
	private String phone;
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
	
    public MarkCarpoolQuery () {}

    public MarkCarpoolQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long projectId, Long projectIdMin, Long projectIdMax, String city, String startAddr, String endAddr, Date startTime, Date startTimeMin, Date startTimeMax, String carType, Integer peopleCount, Integer peopleCountMin, Integer peopleCountMax, Long price, Long priceMin, Long priceMax, String name, String phone, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.projectId = projectId;
		this.projectIdMin = projectIdMin;
		this.projectIdMax = projectIdMax;
		this.city = city;
		this.startAddr = startAddr;
		this.endAddr = endAddr;
		this.startTime = startTime;
		this.startTimeMin = startTimeMin;
		this.startTimeMax = startTimeMax;
		this.carType = carType;
		this.peopleCount = peopleCount;
		this.peopleCountMin = peopleCountMin;
		this.peopleCountMax = peopleCountMax;
		this.price = price;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.name = name;
		this.phone = phone;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getProjectIdMin() {
		return projectIdMin;
	}

	public void setProjectIdMin(Long projectIdMin) {
		this.projectIdMin = projectIdMin;
	}

	public Long getProjectIdMax() {
		return projectIdMax;
	}

	public void setProjectIdMax(Long projectIdMax) {
		this.projectIdMax = projectIdMax;
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

	public Date getStartTimeMin() {
		return startTimeMin;
	}

	public void setStartTimeMin(Date startTimeMin) {
		this.startTimeMin = startTimeMin;
	}

	public Date getStartTimeMax() {
		return startTimeMax;
	}

	public void setStartTimeMax(Date startTimeMax) {
		this.startTimeMax = startTimeMax;
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

	public Integer getPeopleCountMin() {
		return peopleCountMin;
	}

	public void setPeopleCountMin(Integer peopleCountMin) {
		this.peopleCountMin = peopleCountMin;
	}

	public Integer getPeopleCountMax() {
		return peopleCountMax;
	}

	public void setPeopleCountMax(Integer peopleCountMax) {
		this.peopleCountMax = peopleCountMax;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Long priceMin) {
		this.priceMin = priceMin;
	}

	public Long getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Long priceMax) {
		this.priceMax = priceMax;
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
        return "MarkCarpoolQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", projectId = " + projectId + 
				", projectIdMin = " + projectIdMin + 
				", projectIdMax = " + projectIdMax + 
				", city = " + city + 
				", startAddr = " + startAddr + 
				", endAddr = " + endAddr + 
				", startTime = " + startTime + 
				", startTimeMin = " + startTimeMin + 
				", startTimeMax = " + startTimeMax + 
				", carType = " + carType + 
				", peopleCount = " + peopleCount + 
				", peopleCountMin = " + peopleCountMin + 
				", peopleCountMax = " + peopleCountMax + 
				", price = " + price + 
				", priceMin = " + priceMin + 
				", priceMax = " + priceMax + 
				", name = " + name + 
				", phone = " + phone + 
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
