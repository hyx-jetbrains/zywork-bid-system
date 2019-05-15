package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMarkCarpoolQuery查询对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserMarkCarpoolQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036131439971L;

    //t_mark_carpool表的字段对应的属性
	// 开标拼车编号
	private Long markCarpoolId;
	// 开标拼车编号（最小值）
	private Long markCarpoolIdMin;
	// 开标拼车编号（最大值）
	private Long markCarpoolIdMax;
	// 用户编号
	private Long markCarpoolUserId;
	// 用户编号（最小值）
	private Long markCarpoolUserIdMin;
	// 用户编号（最大值）
	private Long markCarpoolUserIdMax;
	// 项目编号
	private Long markCarpoolProjectId;
	// 项目编号（最小值）
	private Long markCarpoolProjectIdMin;
	// 项目编号（最大值）
	private Long markCarpoolProjectIdMax;
	// 出发城市
	private String markCarpoolStartCity;
	// 出发地点
	private String markCarpoolStartAddr;
	// 目的地城市
	private String markCarpoolEndCity;
	// 目的地
	private String markCarpoolEndAddr;
	// 出发时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolStartTime;
	// 出发时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolStartTimeMin;
	// 出发时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolStartTimeMax;
	// 汽车类型
	private String markCarpoolCarType;
	// 搭载人数
	private Integer markCarpoolPeopleCount;
	// 搭载人数（最小值）
	private Integer markCarpoolPeopleCountMin;
	// 搭载人数（最大值）
	private Integer markCarpoolPeopleCountMax;
	// 价格
	private Long markCarpoolPrice;
	// 价格（最小值）
	private Long markCarpoolPriceMin;
	// 价格（最大值）
	private Long markCarpoolPriceMax;
	// 联系人姓名
	private String markCarpoolName;
	// 联系人电话
	private String markCarpoolPhone;
	// 版本号
	private Integer markCarpoolVersion;
	// 版本号（最小值）
	private Integer markCarpoolVersionMin;
	// 版本号（最大值）
	private Integer markCarpoolVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolUpdateTimeMax;
	// 是否激活
	private Byte markCarpoolIsActive;
	// 是否激活（最小值）
	private Byte markCarpoolIsActiveMin;
	// 是否激活（最大值）
	private Byte markCarpoolIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserMarkCarpoolQuery () {}

    public UserMarkCarpoolQuery (Long markCarpoolId, Long markCarpoolIdMin, Long markCarpoolIdMax, Long markCarpoolUserId, Long markCarpoolUserIdMin, Long markCarpoolUserIdMax, Long markCarpoolProjectId, Long markCarpoolProjectIdMin, Long markCarpoolProjectIdMax, String markCarpoolStartCity, String markCarpoolStartAddr, String markCarpoolEndCity, String markCarpoolEndAddr, Date markCarpoolStartTime, Date markCarpoolStartTimeMin, Date markCarpoolStartTimeMax, String markCarpoolCarType, Integer markCarpoolPeopleCount, Integer markCarpoolPeopleCountMin, Integer markCarpoolPeopleCountMax, Long markCarpoolPrice, Long markCarpoolPriceMin, Long markCarpoolPriceMax, String markCarpoolName, String markCarpoolPhone, Integer markCarpoolVersion, Integer markCarpoolVersionMin, Integer markCarpoolVersionMax, Date markCarpoolCreateTime, Date markCarpoolCreateTimeMin, Date markCarpoolCreateTimeMax, Date markCarpoolUpdateTime, Date markCarpoolUpdateTimeMin, Date markCarpoolUpdateTimeMax, Byte markCarpoolIsActive, Byte markCarpoolIsActiveMin, Byte markCarpoolIsActiveMax, String userDetailNickname, String userDetailHeadicon) {
        this.markCarpoolId = markCarpoolId;
		this.markCarpoolIdMin = markCarpoolIdMin;
		this.markCarpoolIdMax = markCarpoolIdMax;
		this.markCarpoolUserId = markCarpoolUserId;
		this.markCarpoolUserIdMin = markCarpoolUserIdMin;
		this.markCarpoolUserIdMax = markCarpoolUserIdMax;
		this.markCarpoolProjectId = markCarpoolProjectId;
		this.markCarpoolProjectIdMin = markCarpoolProjectIdMin;
		this.markCarpoolProjectIdMax = markCarpoolProjectIdMax;
		this.markCarpoolStartCity = markCarpoolStartCity;
		this.markCarpoolStartAddr = markCarpoolStartAddr;
		this.markCarpoolEndCity = markCarpoolEndCity;
		this.markCarpoolEndAddr = markCarpoolEndAddr;
		this.markCarpoolStartTime = markCarpoolStartTime;
		this.markCarpoolStartTimeMin = markCarpoolStartTimeMin;
		this.markCarpoolStartTimeMax = markCarpoolStartTimeMax;
		this.markCarpoolCarType = markCarpoolCarType;
		this.markCarpoolPeopleCount = markCarpoolPeopleCount;
		this.markCarpoolPeopleCountMin = markCarpoolPeopleCountMin;
		this.markCarpoolPeopleCountMax = markCarpoolPeopleCountMax;
		this.markCarpoolPrice = markCarpoolPrice;
		this.markCarpoolPriceMin = markCarpoolPriceMin;
		this.markCarpoolPriceMax = markCarpoolPriceMax;
		this.markCarpoolName = markCarpoolName;
		this.markCarpoolPhone = markCarpoolPhone;
		this.markCarpoolVersion = markCarpoolVersion;
		this.markCarpoolVersionMin = markCarpoolVersionMin;
		this.markCarpoolVersionMax = markCarpoolVersionMax;
		this.markCarpoolCreateTime = markCarpoolCreateTime;
		this.markCarpoolCreateTimeMin = markCarpoolCreateTimeMin;
		this.markCarpoolCreateTimeMax = markCarpoolCreateTimeMax;
		this.markCarpoolUpdateTime = markCarpoolUpdateTime;
		this.markCarpoolUpdateTimeMin = markCarpoolUpdateTimeMin;
		this.markCarpoolUpdateTimeMax = markCarpoolUpdateTimeMax;
		this.markCarpoolIsActive = markCarpoolIsActive;
		this.markCarpoolIsActiveMin = markCarpoolIsActiveMin;
		this.markCarpoolIsActiveMax = markCarpoolIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getMarkCarpoolId() {
		return markCarpoolId;
	}

	public void setMarkCarpoolId(Long markCarpoolId) {
		this.markCarpoolId = markCarpoolId;
	}

	public Long getMarkCarpoolIdMin() {
		return markCarpoolIdMin;
	}

	public void setMarkCarpoolIdMin(Long markCarpoolIdMin) {
		this.markCarpoolIdMin = markCarpoolIdMin;
	}

	public Long getMarkCarpoolIdMax() {
		return markCarpoolIdMax;
	}

	public void setMarkCarpoolIdMax(Long markCarpoolIdMax) {
		this.markCarpoolIdMax = markCarpoolIdMax;
	}

	public Long getMarkCarpoolUserId() {
		return markCarpoolUserId;
	}

	public void setMarkCarpoolUserId(Long markCarpoolUserId) {
		this.markCarpoolUserId = markCarpoolUserId;
	}

	public Long getMarkCarpoolUserIdMin() {
		return markCarpoolUserIdMin;
	}

	public void setMarkCarpoolUserIdMin(Long markCarpoolUserIdMin) {
		this.markCarpoolUserIdMin = markCarpoolUserIdMin;
	}

	public Long getMarkCarpoolUserIdMax() {
		return markCarpoolUserIdMax;
	}

	public void setMarkCarpoolUserIdMax(Long markCarpoolUserIdMax) {
		this.markCarpoolUserIdMax = markCarpoolUserIdMax;
	}

	public Long getMarkCarpoolProjectId() {
		return markCarpoolProjectId;
	}

	public void setMarkCarpoolProjectId(Long markCarpoolProjectId) {
		this.markCarpoolProjectId = markCarpoolProjectId;
	}

	public Long getMarkCarpoolProjectIdMin() {
		return markCarpoolProjectIdMin;
	}

	public void setMarkCarpoolProjectIdMin(Long markCarpoolProjectIdMin) {
		this.markCarpoolProjectIdMin = markCarpoolProjectIdMin;
	}

	public Long getMarkCarpoolProjectIdMax() {
		return markCarpoolProjectIdMax;
	}

	public void setMarkCarpoolProjectIdMax(Long markCarpoolProjectIdMax) {
		this.markCarpoolProjectIdMax = markCarpoolProjectIdMax;
	}

	public String getMarkCarpoolStartCity() {
		return markCarpoolStartCity;
	}

	public void setMarkCarpoolStartCity(String markCarpoolStartCity) {
		this.markCarpoolStartCity = markCarpoolStartCity;
	}

	public String getMarkCarpoolStartAddr() {
		return markCarpoolStartAddr;
	}

	public void setMarkCarpoolStartAddr(String markCarpoolStartAddr) {
		this.markCarpoolStartAddr = markCarpoolStartAddr;
	}

	public String getMarkCarpoolEndCity() {
		return markCarpoolEndCity;
	}

	public void setMarkCarpoolEndCity(String markCarpoolEndCity) {
		this.markCarpoolEndCity = markCarpoolEndCity;
	}

	public String getMarkCarpoolEndAddr() {
		return markCarpoolEndAddr;
	}

	public void setMarkCarpoolEndAddr(String markCarpoolEndAddr) {
		this.markCarpoolEndAddr = markCarpoolEndAddr;
	}

	public Date getMarkCarpoolStartTime() {
		return markCarpoolStartTime;
	}

	public void setMarkCarpoolStartTime(Date markCarpoolStartTime) {
		this.markCarpoolStartTime = markCarpoolStartTime;
	}

	public Date getMarkCarpoolStartTimeMin() {
		return markCarpoolStartTimeMin;
	}

	public void setMarkCarpoolStartTimeMin(Date markCarpoolStartTimeMin) {
		this.markCarpoolStartTimeMin = markCarpoolStartTimeMin;
	}

	public Date getMarkCarpoolStartTimeMax() {
		return markCarpoolStartTimeMax;
	}

	public void setMarkCarpoolStartTimeMax(Date markCarpoolStartTimeMax) {
		this.markCarpoolStartTimeMax = markCarpoolStartTimeMax;
	}

	public String getMarkCarpoolCarType() {
		return markCarpoolCarType;
	}

	public void setMarkCarpoolCarType(String markCarpoolCarType) {
		this.markCarpoolCarType = markCarpoolCarType;
	}

	public Integer getMarkCarpoolPeopleCount() {
		return markCarpoolPeopleCount;
	}

	public void setMarkCarpoolPeopleCount(Integer markCarpoolPeopleCount) {
		this.markCarpoolPeopleCount = markCarpoolPeopleCount;
	}

	public Integer getMarkCarpoolPeopleCountMin() {
		return markCarpoolPeopleCountMin;
	}

	public void setMarkCarpoolPeopleCountMin(Integer markCarpoolPeopleCountMin) {
		this.markCarpoolPeopleCountMin = markCarpoolPeopleCountMin;
	}

	public Integer getMarkCarpoolPeopleCountMax() {
		return markCarpoolPeopleCountMax;
	}

	public void setMarkCarpoolPeopleCountMax(Integer markCarpoolPeopleCountMax) {
		this.markCarpoolPeopleCountMax = markCarpoolPeopleCountMax;
	}

	public Long getMarkCarpoolPrice() {
		return markCarpoolPrice;
	}

	public void setMarkCarpoolPrice(Long markCarpoolPrice) {
		this.markCarpoolPrice = markCarpoolPrice;
	}

	public Long getMarkCarpoolPriceMin() {
		return markCarpoolPriceMin;
	}

	public void setMarkCarpoolPriceMin(Long markCarpoolPriceMin) {
		this.markCarpoolPriceMin = markCarpoolPriceMin;
	}

	public Long getMarkCarpoolPriceMax() {
		return markCarpoolPriceMax;
	}

	public void setMarkCarpoolPriceMax(Long markCarpoolPriceMax) {
		this.markCarpoolPriceMax = markCarpoolPriceMax;
	}

	public String getMarkCarpoolName() {
		return markCarpoolName;
	}

	public void setMarkCarpoolName(String markCarpoolName) {
		this.markCarpoolName = markCarpoolName;
	}

	public String getMarkCarpoolPhone() {
		return markCarpoolPhone;
	}

	public void setMarkCarpoolPhone(String markCarpoolPhone) {
		this.markCarpoolPhone = markCarpoolPhone;
	}

	public Integer getMarkCarpoolVersion() {
		return markCarpoolVersion;
	}

	public void setMarkCarpoolVersion(Integer markCarpoolVersion) {
		this.markCarpoolVersion = markCarpoolVersion;
	}

	public Integer getMarkCarpoolVersionMin() {
		return markCarpoolVersionMin;
	}

	public void setMarkCarpoolVersionMin(Integer markCarpoolVersionMin) {
		this.markCarpoolVersionMin = markCarpoolVersionMin;
	}

	public Integer getMarkCarpoolVersionMax() {
		return markCarpoolVersionMax;
	}

	public void setMarkCarpoolVersionMax(Integer markCarpoolVersionMax) {
		this.markCarpoolVersionMax = markCarpoolVersionMax;
	}

	public Date getMarkCarpoolCreateTime() {
		return markCarpoolCreateTime;
	}

	public void setMarkCarpoolCreateTime(Date markCarpoolCreateTime) {
		this.markCarpoolCreateTime = markCarpoolCreateTime;
	}

	public Date getMarkCarpoolCreateTimeMin() {
		return markCarpoolCreateTimeMin;
	}

	public void setMarkCarpoolCreateTimeMin(Date markCarpoolCreateTimeMin) {
		this.markCarpoolCreateTimeMin = markCarpoolCreateTimeMin;
	}

	public Date getMarkCarpoolCreateTimeMax() {
		return markCarpoolCreateTimeMax;
	}

	public void setMarkCarpoolCreateTimeMax(Date markCarpoolCreateTimeMax) {
		this.markCarpoolCreateTimeMax = markCarpoolCreateTimeMax;
	}

	public Date getMarkCarpoolUpdateTime() {
		return markCarpoolUpdateTime;
	}

	public void setMarkCarpoolUpdateTime(Date markCarpoolUpdateTime) {
		this.markCarpoolUpdateTime = markCarpoolUpdateTime;
	}

	public Date getMarkCarpoolUpdateTimeMin() {
		return markCarpoolUpdateTimeMin;
	}

	public void setMarkCarpoolUpdateTimeMin(Date markCarpoolUpdateTimeMin) {
		this.markCarpoolUpdateTimeMin = markCarpoolUpdateTimeMin;
	}

	public Date getMarkCarpoolUpdateTimeMax() {
		return markCarpoolUpdateTimeMax;
	}

	public void setMarkCarpoolUpdateTimeMax(Date markCarpoolUpdateTimeMax) {
		this.markCarpoolUpdateTimeMax = markCarpoolUpdateTimeMax;
	}

	public Byte getMarkCarpoolIsActive() {
		return markCarpoolIsActive;
	}

	public void setMarkCarpoolIsActive(Byte markCarpoolIsActive) {
		this.markCarpoolIsActive = markCarpoolIsActive;
	}

	public Byte getMarkCarpoolIsActiveMin() {
		return markCarpoolIsActiveMin;
	}

	public void setMarkCarpoolIsActiveMin(Byte markCarpoolIsActiveMin) {
		this.markCarpoolIsActiveMin = markCarpoolIsActiveMin;
	}

	public Byte getMarkCarpoolIsActiveMax() {
		return markCarpoolIsActiveMax;
	}

	public void setMarkCarpoolIsActiveMax(Byte markCarpoolIsActiveMax) {
		this.markCarpoolIsActiveMax = markCarpoolIsActiveMax;
	}

	public String getUserDetailNickname() {
		return userDetailNickname;
	}

	public void setUserDetailNickname(String userDetailNickname) {
		this.userDetailNickname = userDetailNickname;
	}

	public String getUserDetailHeadicon() {
		return userDetailHeadicon;
	}

	public void setUserDetailHeadicon(String userDetailHeadicon) {
		this.userDetailHeadicon = userDetailHeadicon;
	}

	
    @Override
    public String toString() {
        return "UserMarkCarpoolQuery {" +
                "markCarpoolId = " + markCarpoolId + 
				", markCarpoolIdMin = " + markCarpoolIdMin + 
				", markCarpoolIdMax = " + markCarpoolIdMax + 
				", markCarpoolUserId = " + markCarpoolUserId + 
				", markCarpoolUserIdMin = " + markCarpoolUserIdMin + 
				", markCarpoolUserIdMax = " + markCarpoolUserIdMax + 
				", markCarpoolProjectId = " + markCarpoolProjectId + 
				", markCarpoolProjectIdMin = " + markCarpoolProjectIdMin + 
				", markCarpoolProjectIdMax = " + markCarpoolProjectIdMax + 
				", markCarpoolStartCity = " + markCarpoolStartCity + 
				", markCarpoolStartAddr = " + markCarpoolStartAddr + 
				", markCarpoolEndCity = " + markCarpoolEndCity + 
				", markCarpoolEndAddr = " + markCarpoolEndAddr + 
				", markCarpoolStartTime = " + markCarpoolStartTime + 
				", markCarpoolStartTimeMin = " + markCarpoolStartTimeMin + 
				", markCarpoolStartTimeMax = " + markCarpoolStartTimeMax + 
				", markCarpoolCarType = " + markCarpoolCarType + 
				", markCarpoolPeopleCount = " + markCarpoolPeopleCount + 
				", markCarpoolPeopleCountMin = " + markCarpoolPeopleCountMin + 
				", markCarpoolPeopleCountMax = " + markCarpoolPeopleCountMax + 
				", markCarpoolPrice = " + markCarpoolPrice + 
				", markCarpoolPriceMin = " + markCarpoolPriceMin + 
				", markCarpoolPriceMax = " + markCarpoolPriceMax + 
				", markCarpoolName = " + markCarpoolName + 
				", markCarpoolPhone = " + markCarpoolPhone + 
				", markCarpoolVersion = " + markCarpoolVersion + 
				", markCarpoolVersionMin = " + markCarpoolVersionMin + 
				", markCarpoolVersionMax = " + markCarpoolVersionMax + 
				", markCarpoolCreateTime = " + markCarpoolCreateTime + 
				", markCarpoolCreateTimeMin = " + markCarpoolCreateTimeMin + 
				", markCarpoolCreateTimeMax = " + markCarpoolCreateTimeMax + 
				", markCarpoolUpdateTime = " + markCarpoolUpdateTime + 
				", markCarpoolUpdateTimeMin = " + markCarpoolUpdateTimeMin + 
				", markCarpoolUpdateTimeMax = " + markCarpoolUpdateTimeMax + 
				", markCarpoolIsActive = " + markCarpoolIsActive + 
				", markCarpoolIsActiveMin = " + markCarpoolIsActiveMin + 
				", markCarpoolIsActiveMax = " + markCarpoolIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
