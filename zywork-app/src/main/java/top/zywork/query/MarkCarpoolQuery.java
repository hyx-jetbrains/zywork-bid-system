package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MarkCarpoolQuery查询对象类<br/>
 *
 * 创建于2019-05-16<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class MarkCarpoolQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036682293981L;

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
	// 出发城市
	private String startCity;
	// 出发地点
	private String startAddr;
	// 目的地城市
	private String endCity;
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
	// 申请人数
	private Integer recordCount;
	// 申请人数（最小值）
	private Integer recordCountMin;
	// 申请人数（最大值）
	private Integer recordCountMax;
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

    public MarkCarpoolQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long projectId, Long projectIdMin, Long projectIdMax, String startCity, String startAddr, String endCity, String endAddr, Date startTime, Date startTimeMin, Date startTimeMax, String carType, Integer peopleCount, Integer peopleCountMin, Integer peopleCountMax, Integer recordCount, Integer recordCountMin, Integer recordCountMax, Long price, Long priceMin, Long priceMax, String name, String phone, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.projectId = projectId;
		this.projectIdMin = projectIdMin;
		this.projectIdMax = projectIdMax;
		this.startCity = startCity;
		this.startAddr = startAddr;
		this.endCity = endCity;
		this.endAddr = endAddr;
		this.startTime = startTime;
		this.startTimeMin = startTimeMin;
		this.startTimeMax = startTimeMax;
		this.carType = carType;
		this.peopleCount = peopleCount;
		this.peopleCountMin = peopleCountMin;
		this.peopleCountMax = peopleCountMax;
		this.recordCount = recordCount;
		this.recordCountMin = recordCountMin;
		this.recordCountMax = recordCountMax;
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

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getRecordCountMin() {
		return recordCountMin;
	}

	public void setRecordCountMin(Integer recordCountMin) {
		this.recordCountMin = recordCountMin;
	}

	public Integer getRecordCountMax() {
		return recordCountMax;
	}

	public void setRecordCountMax(Integer recordCountMax) {
		this.recordCountMax = recordCountMax;
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
				", startCity = " + startCity + 
				", startAddr = " + startAddr + 
				", endCity = " + endCity + 
				", endAddr = " + endAddr + 
				", startTime = " + startTime + 
				", startTimeMin = " + startTimeMin + 
				", startTimeMax = " + startTimeMax + 
				", carType = " + carType + 
				", peopleCount = " + peopleCount + 
				", peopleCountMin = " + peopleCountMin + 
				", peopleCountMax = " + peopleCountMax + 
				", recordCount = " + recordCount + 
				", recordCountMin = " + recordCountMin + 
				", recordCountMax = " + recordCountMax + 
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
