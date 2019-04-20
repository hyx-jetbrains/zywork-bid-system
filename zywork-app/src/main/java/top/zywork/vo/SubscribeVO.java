package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SubscribeVO值对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SubscribeVO extends BaseVO {

    private static final long serialVersionUID = -9223372036135563034L;

    // 订阅编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 城市
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String city;
	// 项目类型
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String projectType;
	// 最小金额
	private Long minMoney;
	// 最大金额
	private Long maxMoney;
	// 招标人
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String tenderee;
	// 资质类别
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String aptitudeType;
	// 关键字
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String keyword;
	// 是否开通订阅
	private Integer isSubscribe;
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
	
    public SubscribeVO () {}

    public SubscribeVO (Long id, Long userId, String city, String projectType, Long minMoney, Long maxMoney, String tenderee, String aptitudeType, String keyword, Integer isSubscribe, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.city = city;
		this.projectType = projectType;
		this.minMoney = minMoney;
		this.maxMoney = maxMoney;
		this.tenderee = tenderee;
		this.aptitudeType = aptitudeType;
		this.keyword = keyword;
		this.isSubscribe = isSubscribe;
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

	public Long getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(Long maxMoney) {
		this.maxMoney = maxMoney;
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
        return "SubscribeVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", city = " + city + 
				", projectType = " + projectType + 
				", minMoney = " + minMoney + 
				", maxMoney = " + maxMoney + 
				", tenderee = " + tenderee + 
				", aptitudeType = " + aptitudeType + 
				", keyword = " + keyword + 
				", isSubscribe = " + isSubscribe + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
