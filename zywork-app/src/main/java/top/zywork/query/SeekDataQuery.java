package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SeekDataQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SeekDataQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036406870070L;

    // 求带资料编号
	private Long id;
	// 求带资料编号（最小值）
	private Long idMin;
	// 求带资料编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 出发地点
	private String startAddr;
	// 目的地
	private String endAddr;
	// 资料类型
	private String dataType;
	// 资料数量
	private Integer dataCount;
	// 资料数量（最小值）
	private Integer dataCountMin;
	// 资料数量（最大值）
	private Integer dataCountMax;
	// 最晚时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date latestTime;
	// 最晚时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date latestTimeMin;
	// 最晚时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date latestTimeMax;
	// 赏金
	private Long price;
	// 赏金（最小值）
	private Long priceMin;
	// 赏金（最大值）
	private Long priceMax;
	// 联系电话
	private String phone;
	// 是否加急
	private Integer isUrgent;
	// 是否加急（最小值）
	private Integer isUrgentMin;
	// 是否加急（最大值）
	private Integer isUrgentMax;
	// 备注
	private String memo;
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
	
    public SeekDataQuery () {}

    public SeekDataQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String startAddr, String endAddr, String dataType, Integer dataCount, Integer dataCountMin, Integer dataCountMax, Date latestTime, Date latestTimeMin, Date latestTimeMax, Long price, Long priceMin, Long priceMax, String phone, Integer isUrgent, Integer isUrgentMin, Integer isUrgentMax, String memo, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.startAddr = startAddr;
		this.endAddr = endAddr;
		this.dataType = dataType;
		this.dataCount = dataCount;
		this.dataCountMin = dataCountMin;
		this.dataCountMax = dataCountMax;
		this.latestTime = latestTime;
		this.latestTimeMin = latestTimeMin;
		this.latestTimeMax = latestTimeMax;
		this.price = price;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.phone = phone;
		this.isUrgent = isUrgent;
		this.isUrgentMin = isUrgentMin;
		this.isUrgentMax = isUrgentMax;
		this.memo = memo;
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

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}

	public Integer getDataCountMin() {
		return dataCountMin;
	}

	public void setDataCountMin(Integer dataCountMin) {
		this.dataCountMin = dataCountMin;
	}

	public Integer getDataCountMax() {
		return dataCountMax;
	}

	public void setDataCountMax(Integer dataCountMax) {
		this.dataCountMax = dataCountMax;
	}

	public Date getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}

	public Date getLatestTimeMin() {
		return latestTimeMin;
	}

	public void setLatestTimeMin(Date latestTimeMin) {
		this.latestTimeMin = latestTimeMin;
	}

	public Date getLatestTimeMax() {
		return latestTimeMax;
	}

	public void setLatestTimeMax(Date latestTimeMax) {
		this.latestTimeMax = latestTimeMax;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Integer isUrgent) {
		this.isUrgent = isUrgent;
	}

	public Integer getIsUrgentMin() {
		return isUrgentMin;
	}

	public void setIsUrgentMin(Integer isUrgentMin) {
		this.isUrgentMin = isUrgentMin;
	}

	public Integer getIsUrgentMax() {
		return isUrgentMax;
	}

	public void setIsUrgentMax(Integer isUrgentMax) {
		this.isUrgentMax = isUrgentMax;
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
        return "SeekDataQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", startAddr = " + startAddr + 
				", endAddr = " + endAddr + 
				", dataType = " + dataType + 
				", dataCount = " + dataCount + 
				", dataCountMin = " + dataCountMin + 
				", dataCountMax = " + dataCountMax + 
				", latestTime = " + latestTime + 
				", latestTimeMin = " + latestTimeMin + 
				", latestTimeMax = " + latestTimeMax + 
				", price = " + price + 
				", priceMin = " + priceMin + 
				", priceMax = " + priceMax + 
				", phone = " + phone + 
				", isUrgent = " + isUrgent + 
				", isUrgentMin = " + isUrgentMin + 
				", isUrgentMax = " + isUrgentMax + 
				", memo = " + memo + 
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
