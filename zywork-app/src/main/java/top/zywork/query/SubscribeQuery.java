package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SubscribeQuery查询对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SubscribeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035606968467L;

    // 订阅编号
	private Long id;
	// 订阅编号（最小值）
	private Long idMin;
	// 订阅编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 城市
	private String city;
	// 项目类型
	private String projectType;
	// 最小金额
	private Long minMoney;
	// 最小金额（最小值）
	private Long minMoneyMin;
	// 最小金额（最大值）
	private Long minMoneyMax;
	// 最大金额
	private Long maxMoney;
	// 最大金额（最小值）
	private Long maxMoneyMin;
	// 最大金额（最大值）
	private Long maxMoneyMax;
	// 招标人
	private String tenderee;
	// 资质类别
	private String aptitudeType;
	// 关键字
	private String keyword;
	// 是否开通订阅
	private Integer isSubscribe;
	// 是否开通订阅（最小值）
	private Integer isSubscribeMin;
	// 是否开通订阅（最大值）
	private Integer isSubscribeMax;
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
	
    public SubscribeQuery () {}

    public SubscribeQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String city, String projectType, Long minMoney, Long minMoneyMin, Long minMoneyMax, Long maxMoney, Long maxMoneyMin, Long maxMoneyMax, String tenderee, String aptitudeType, String keyword, Integer isSubscribe, Integer isSubscribeMin, Integer isSubscribeMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.city = city;
		this.projectType = projectType;
		this.minMoney = minMoney;
		this.minMoneyMin = minMoneyMin;
		this.minMoneyMax = minMoneyMax;
		this.maxMoney = maxMoney;
		this.maxMoneyMin = maxMoneyMin;
		this.maxMoneyMax = maxMoneyMax;
		this.tenderee = tenderee;
		this.aptitudeType = aptitudeType;
		this.keyword = keyword;
		this.isSubscribe = isSubscribe;
		this.isSubscribeMin = isSubscribeMin;
		this.isSubscribeMax = isSubscribeMax;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Long getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(Long minMoney) {
		this.minMoney = minMoney;
	}

	public Long getMinMoneyMin() {
		return minMoneyMin;
	}

	public void setMinMoneyMin(Long minMoneyMin) {
		this.minMoneyMin = minMoneyMin;
	}

	public Long getMinMoneyMax() {
		return minMoneyMax;
	}

	public void setMinMoneyMax(Long minMoneyMax) {
		this.minMoneyMax = minMoneyMax;
	}

	public Long getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(Long maxMoney) {
		this.maxMoney = maxMoney;
	}

	public Long getMaxMoneyMin() {
		return maxMoneyMin;
	}

	public void setMaxMoneyMin(Long maxMoneyMin) {
		this.maxMoneyMin = maxMoneyMin;
	}

	public Long getMaxMoneyMax() {
		return maxMoneyMax;
	}

	public void setMaxMoneyMax(Long maxMoneyMax) {
		this.maxMoneyMax = maxMoneyMax;
	}

	public String getTenderee() {
		return tenderee;
	}

	public void setTenderee(String tenderee) {
		this.tenderee = tenderee;
	}

	public String getAptitudeType() {
		return aptitudeType;
	}

	public void setAptitudeType(String aptitudeType) {
		this.aptitudeType = aptitudeType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(Integer isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public Integer getIsSubscribeMin() {
		return isSubscribeMin;
	}

	public void setIsSubscribeMin(Integer isSubscribeMin) {
		this.isSubscribeMin = isSubscribeMin;
	}

	public Integer getIsSubscribeMax() {
		return isSubscribeMax;
	}

	public void setIsSubscribeMax(Integer isSubscribeMax) {
		this.isSubscribeMax = isSubscribeMax;
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
        return "SubscribeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", city = " + city + 
				", projectType = " + projectType + 
				", minMoney = " + minMoney + 
				", minMoneyMin = " + minMoneyMin + 
				", minMoneyMax = " + minMoneyMax + 
				", maxMoney = " + maxMoney + 
				", maxMoneyMin = " + maxMoneyMin + 
				", maxMoneyMax = " + maxMoneyMax + 
				", tenderee = " + tenderee + 
				", aptitudeType = " + aptitudeType + 
				", keyword = " + keyword + 
				", isSubscribe = " + isSubscribe + 
				", isSubscribeMin = " + isSubscribeMin + 
				", isSubscribeMax = " + isSubscribeMax + 
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
