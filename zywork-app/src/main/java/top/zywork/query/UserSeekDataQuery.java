package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserSeekDataQuery查询对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserSeekDataQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035326213525L;

    //t_seek_data表的字段对应的属性
	// 求带资料编号
	private Long seekDataId;
	// 求带资料编号（最小值）
	private Long seekDataIdMin;
	// 求带资料编号（最大值）
	private Long seekDataIdMax;
	// 用户编号
	private Long seekDataUserId;
	// 用户编号（最小值）
	private Long seekDataUserIdMin;
	// 用户编号（最大值）
	private Long seekDataUserIdMax;
	// 出发地点
	private String seekDataStartAddr;
	// 目的地
	private String seekDataEndAddr;
	// 资料类型
	private String seekDataDataType;
	// 资料数量
	private Integer seekDataDataCount;
	// 资料数量（最小值）
	private Integer seekDataDataCountMin;
	// 资料数量（最大值）
	private Integer seekDataDataCountMax;
	// 最晚时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataLatestTime;
	// 最晚时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataLatestTimeMin;
	// 最晚时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataLatestTimeMax;
	// 赏金
	private Long seekDataPrice;
	// 赏金（最小值）
	private Long seekDataPriceMin;
	// 赏金（最大值）
	private Long seekDataPriceMax;
	// 联系电话
	private String seekDataPhone;
	// 是否加急
	private Integer seekDataIsUrgent;
	// 是否加急（最小值）
	private Integer seekDataIsUrgentMin;
	// 是否加急（最大值）
	private Integer seekDataIsUrgentMax;
	// 备注
	private String seekDataMemo;
	// 版本号
	private Integer seekDataVersion;
	// 版本号（最小值）
	private Integer seekDataVersionMin;
	// 版本号（最大值）
	private Integer seekDataVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataUpdateTimeMax;
	// 是否激活
	private Byte seekDataIsActive;
	// 是否激活（最小值）
	private Byte seekDataIsActiveMin;
	// 是否激活（最大值）
	private Byte seekDataIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserSeekDataQuery () {}

    public UserSeekDataQuery (Long seekDataId, Long seekDataIdMin, Long seekDataIdMax, Long seekDataUserId, Long seekDataUserIdMin, Long seekDataUserIdMax, String seekDataStartAddr, String seekDataEndAddr, String seekDataDataType, Integer seekDataDataCount, Integer seekDataDataCountMin, Integer seekDataDataCountMax, Date seekDataLatestTime, Date seekDataLatestTimeMin, Date seekDataLatestTimeMax, Long seekDataPrice, Long seekDataPriceMin, Long seekDataPriceMax, String seekDataPhone, Integer seekDataIsUrgent, Integer seekDataIsUrgentMin, Integer seekDataIsUrgentMax, String seekDataMemo, Integer seekDataVersion, Integer seekDataVersionMin, Integer seekDataVersionMax, Date seekDataCreateTime, Date seekDataCreateTimeMin, Date seekDataCreateTimeMax, Date seekDataUpdateTime, Date seekDataUpdateTimeMin, Date seekDataUpdateTimeMax, Byte seekDataIsActive, Byte seekDataIsActiveMin, Byte seekDataIsActiveMax, String userDetailNickname, String userDetailHeadicon) {
        this.seekDataId = seekDataId;
		this.seekDataIdMin = seekDataIdMin;
		this.seekDataIdMax = seekDataIdMax;
		this.seekDataUserId = seekDataUserId;
		this.seekDataUserIdMin = seekDataUserIdMin;
		this.seekDataUserIdMax = seekDataUserIdMax;
		this.seekDataStartAddr = seekDataStartAddr;
		this.seekDataEndAddr = seekDataEndAddr;
		this.seekDataDataType = seekDataDataType;
		this.seekDataDataCount = seekDataDataCount;
		this.seekDataDataCountMin = seekDataDataCountMin;
		this.seekDataDataCountMax = seekDataDataCountMax;
		this.seekDataLatestTime = seekDataLatestTime;
		this.seekDataLatestTimeMin = seekDataLatestTimeMin;
		this.seekDataLatestTimeMax = seekDataLatestTimeMax;
		this.seekDataPrice = seekDataPrice;
		this.seekDataPriceMin = seekDataPriceMin;
		this.seekDataPriceMax = seekDataPriceMax;
		this.seekDataPhone = seekDataPhone;
		this.seekDataIsUrgent = seekDataIsUrgent;
		this.seekDataIsUrgentMin = seekDataIsUrgentMin;
		this.seekDataIsUrgentMax = seekDataIsUrgentMax;
		this.seekDataMemo = seekDataMemo;
		this.seekDataVersion = seekDataVersion;
		this.seekDataVersionMin = seekDataVersionMin;
		this.seekDataVersionMax = seekDataVersionMax;
		this.seekDataCreateTime = seekDataCreateTime;
		this.seekDataCreateTimeMin = seekDataCreateTimeMin;
		this.seekDataCreateTimeMax = seekDataCreateTimeMax;
		this.seekDataUpdateTime = seekDataUpdateTime;
		this.seekDataUpdateTimeMin = seekDataUpdateTimeMin;
		this.seekDataUpdateTimeMax = seekDataUpdateTimeMax;
		this.seekDataIsActive = seekDataIsActive;
		this.seekDataIsActiveMin = seekDataIsActiveMin;
		this.seekDataIsActiveMax = seekDataIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getSeekDataId() {
		return seekDataId;
	}

	public void setSeekDataId(Long seekDataId) {
		this.seekDataId = seekDataId;
	}

	public Long getSeekDataIdMin() {
		return seekDataIdMin;
	}

	public void setSeekDataIdMin(Long seekDataIdMin) {
		this.seekDataIdMin = seekDataIdMin;
	}

	public Long getSeekDataIdMax() {
		return seekDataIdMax;
	}

	public void setSeekDataIdMax(Long seekDataIdMax) {
		this.seekDataIdMax = seekDataIdMax;
	}

	public Long getSeekDataUserId() {
		return seekDataUserId;
	}

	public void setSeekDataUserId(Long seekDataUserId) {
		this.seekDataUserId = seekDataUserId;
	}

	public Long getSeekDataUserIdMin() {
		return seekDataUserIdMin;
	}

	public void setSeekDataUserIdMin(Long seekDataUserIdMin) {
		this.seekDataUserIdMin = seekDataUserIdMin;
	}

	public Long getSeekDataUserIdMax() {
		return seekDataUserIdMax;
	}

	public void setSeekDataUserIdMax(Long seekDataUserIdMax) {
		this.seekDataUserIdMax = seekDataUserIdMax;
	}

	public String getSeekDataStartAddr() {
		return seekDataStartAddr;
	}

	public void setSeekDataStartAddr(String seekDataStartAddr) {
		this.seekDataStartAddr = seekDataStartAddr;
	}

	public String getSeekDataEndAddr() {
		return seekDataEndAddr;
	}

	public void setSeekDataEndAddr(String seekDataEndAddr) {
		this.seekDataEndAddr = seekDataEndAddr;
	}

	public String getSeekDataDataType() {
		return seekDataDataType;
	}

	public void setSeekDataDataType(String seekDataDataType) {
		this.seekDataDataType = seekDataDataType;
	}

	public Integer getSeekDataDataCount() {
		return seekDataDataCount;
	}

	public void setSeekDataDataCount(Integer seekDataDataCount) {
		this.seekDataDataCount = seekDataDataCount;
	}

	public Integer getSeekDataDataCountMin() {
		return seekDataDataCountMin;
	}

	public void setSeekDataDataCountMin(Integer seekDataDataCountMin) {
		this.seekDataDataCountMin = seekDataDataCountMin;
	}

	public Integer getSeekDataDataCountMax() {
		return seekDataDataCountMax;
	}

	public void setSeekDataDataCountMax(Integer seekDataDataCountMax) {
		this.seekDataDataCountMax = seekDataDataCountMax;
	}

	public Date getSeekDataLatestTime() {
		return seekDataLatestTime;
	}

	public void setSeekDataLatestTime(Date seekDataLatestTime) {
		this.seekDataLatestTime = seekDataLatestTime;
	}

	public Date getSeekDataLatestTimeMin() {
		return seekDataLatestTimeMin;
	}

	public void setSeekDataLatestTimeMin(Date seekDataLatestTimeMin) {
		this.seekDataLatestTimeMin = seekDataLatestTimeMin;
	}

	public Date getSeekDataLatestTimeMax() {
		return seekDataLatestTimeMax;
	}

	public void setSeekDataLatestTimeMax(Date seekDataLatestTimeMax) {
		this.seekDataLatestTimeMax = seekDataLatestTimeMax;
	}

	public Long getSeekDataPrice() {
		return seekDataPrice;
	}

	public void setSeekDataPrice(Long seekDataPrice) {
		this.seekDataPrice = seekDataPrice;
	}

	public Long getSeekDataPriceMin() {
		return seekDataPriceMin;
	}

	public void setSeekDataPriceMin(Long seekDataPriceMin) {
		this.seekDataPriceMin = seekDataPriceMin;
	}

	public Long getSeekDataPriceMax() {
		return seekDataPriceMax;
	}

	public void setSeekDataPriceMax(Long seekDataPriceMax) {
		this.seekDataPriceMax = seekDataPriceMax;
	}

	public String getSeekDataPhone() {
		return seekDataPhone;
	}

	public void setSeekDataPhone(String seekDataPhone) {
		this.seekDataPhone = seekDataPhone;
	}

	public Integer getSeekDataIsUrgent() {
		return seekDataIsUrgent;
	}

	public void setSeekDataIsUrgent(Integer seekDataIsUrgent) {
		this.seekDataIsUrgent = seekDataIsUrgent;
	}

	public Integer getSeekDataIsUrgentMin() {
		return seekDataIsUrgentMin;
	}

	public void setSeekDataIsUrgentMin(Integer seekDataIsUrgentMin) {
		this.seekDataIsUrgentMin = seekDataIsUrgentMin;
	}

	public Integer getSeekDataIsUrgentMax() {
		return seekDataIsUrgentMax;
	}

	public void setSeekDataIsUrgentMax(Integer seekDataIsUrgentMax) {
		this.seekDataIsUrgentMax = seekDataIsUrgentMax;
	}

	public String getSeekDataMemo() {
		return seekDataMemo;
	}

	public void setSeekDataMemo(String seekDataMemo) {
		this.seekDataMemo = seekDataMemo;
	}

	public Integer getSeekDataVersion() {
		return seekDataVersion;
	}

	public void setSeekDataVersion(Integer seekDataVersion) {
		this.seekDataVersion = seekDataVersion;
	}

	public Integer getSeekDataVersionMin() {
		return seekDataVersionMin;
	}

	public void setSeekDataVersionMin(Integer seekDataVersionMin) {
		this.seekDataVersionMin = seekDataVersionMin;
	}

	public Integer getSeekDataVersionMax() {
		return seekDataVersionMax;
	}

	public void setSeekDataVersionMax(Integer seekDataVersionMax) {
		this.seekDataVersionMax = seekDataVersionMax;
	}

	public Date getSeekDataCreateTime() {
		return seekDataCreateTime;
	}

	public void setSeekDataCreateTime(Date seekDataCreateTime) {
		this.seekDataCreateTime = seekDataCreateTime;
	}

	public Date getSeekDataCreateTimeMin() {
		return seekDataCreateTimeMin;
	}

	public void setSeekDataCreateTimeMin(Date seekDataCreateTimeMin) {
		this.seekDataCreateTimeMin = seekDataCreateTimeMin;
	}

	public Date getSeekDataCreateTimeMax() {
		return seekDataCreateTimeMax;
	}

	public void setSeekDataCreateTimeMax(Date seekDataCreateTimeMax) {
		this.seekDataCreateTimeMax = seekDataCreateTimeMax;
	}

	public Date getSeekDataUpdateTime() {
		return seekDataUpdateTime;
	}

	public void setSeekDataUpdateTime(Date seekDataUpdateTime) {
		this.seekDataUpdateTime = seekDataUpdateTime;
	}

	public Date getSeekDataUpdateTimeMin() {
		return seekDataUpdateTimeMin;
	}

	public void setSeekDataUpdateTimeMin(Date seekDataUpdateTimeMin) {
		this.seekDataUpdateTimeMin = seekDataUpdateTimeMin;
	}

	public Date getSeekDataUpdateTimeMax() {
		return seekDataUpdateTimeMax;
	}

	public void setSeekDataUpdateTimeMax(Date seekDataUpdateTimeMax) {
		this.seekDataUpdateTimeMax = seekDataUpdateTimeMax;
	}

	public Byte getSeekDataIsActive() {
		return seekDataIsActive;
	}

	public void setSeekDataIsActive(Byte seekDataIsActive) {
		this.seekDataIsActive = seekDataIsActive;
	}

	public Byte getSeekDataIsActiveMin() {
		return seekDataIsActiveMin;
	}

	public void setSeekDataIsActiveMin(Byte seekDataIsActiveMin) {
		this.seekDataIsActiveMin = seekDataIsActiveMin;
	}

	public Byte getSeekDataIsActiveMax() {
		return seekDataIsActiveMax;
	}

	public void setSeekDataIsActiveMax(Byte seekDataIsActiveMax) {
		this.seekDataIsActiveMax = seekDataIsActiveMax;
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
        return "UserSeekDataQuery {" +
                "seekDataId = " + seekDataId + 
				", seekDataIdMin = " + seekDataIdMin + 
				", seekDataIdMax = " + seekDataIdMax + 
				", seekDataUserId = " + seekDataUserId + 
				", seekDataUserIdMin = " + seekDataUserIdMin + 
				", seekDataUserIdMax = " + seekDataUserIdMax + 
				", seekDataStartAddr = " + seekDataStartAddr + 
				", seekDataEndAddr = " + seekDataEndAddr + 
				", seekDataDataType = " + seekDataDataType + 
				", seekDataDataCount = " + seekDataDataCount + 
				", seekDataDataCountMin = " + seekDataDataCountMin + 
				", seekDataDataCountMax = " + seekDataDataCountMax + 
				", seekDataLatestTime = " + seekDataLatestTime + 
				", seekDataLatestTimeMin = " + seekDataLatestTimeMin + 
				", seekDataLatestTimeMax = " + seekDataLatestTimeMax + 
				", seekDataPrice = " + seekDataPrice + 
				", seekDataPriceMin = " + seekDataPriceMin + 
				", seekDataPriceMax = " + seekDataPriceMax + 
				", seekDataPhone = " + seekDataPhone + 
				", seekDataIsUrgent = " + seekDataIsUrgent + 
				", seekDataIsUrgentMin = " + seekDataIsUrgentMin + 
				", seekDataIsUrgentMax = " + seekDataIsUrgentMax + 
				", seekDataMemo = " + seekDataMemo + 
				", seekDataVersion = " + seekDataVersion + 
				", seekDataVersionMin = " + seekDataVersionMin + 
				", seekDataVersionMax = " + seekDataVersionMax + 
				", seekDataCreateTime = " + seekDataCreateTime + 
				", seekDataCreateTimeMin = " + seekDataCreateTimeMin + 
				", seekDataCreateTimeMax = " + seekDataCreateTimeMax + 
				", seekDataUpdateTime = " + seekDataUpdateTime + 
				", seekDataUpdateTimeMin = " + seekDataUpdateTimeMin + 
				", seekDataUpdateTimeMax = " + seekDataUpdateTimeMax + 
				", seekDataIsActive = " + seekDataIsActive + 
				", seekDataIsActiveMin = " + seekDataIsActiveMin + 
				", seekDataIsActiveMax = " + seekDataIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
