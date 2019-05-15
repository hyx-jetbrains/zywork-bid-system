package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMarkSeekcarQuery查询对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserMarkSeekcarQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036038801431L;

    //t_mark_seekcar表的字段对应的属性
	// 开标找车编号
	private Long markSeekcarId;
	// 开标找车编号（最小值）
	private Long markSeekcarIdMin;
	// 开标找车编号（最大值）
	private Long markSeekcarIdMax;
	// 用户编号
	private Long markSeekcarUserId;
	// 用户编号（最小值）
	private Long markSeekcarUserIdMin;
	// 用户编号（最大值）
	private Long markSeekcarUserIdMax;
	// 项目编号
	private Long markSeekcarProjectId;
	// 项目编号（最小值）
	private Long markSeekcarProjectIdMin;
	// 项目编号（最大值）
	private Long markSeekcarProjectIdMax;
	// 出发城市
	private String markSeekcarStartCity;
	// 出发地点
	private String markSeekcarStartAddr;
	// 目的地城市
	private String markSeekcarEndCity;
	// 目的地
	private String markSeekcarEndAddr;
	// 出发时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarStartTime;
	// 出发时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarStartTimeMin;
	// 出发时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarStartTimeMax;
	// 联系人姓名
	private String markSeekcarName;
	// 联系人电话
	private String markSeekcarPhone;
	// 备注
	private String markSeekcarMemo;
	// 版本号
	private Integer markSeekcarVersion;
	// 版本号（最小值）
	private Integer markSeekcarVersionMin;
	// 版本号（最大值）
	private Integer markSeekcarVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarUpdateTimeMax;
	// 是否激活
	private Byte markSeekcarIsActive;
	// 是否激活（最小值）
	private Byte markSeekcarIsActiveMin;
	// 是否激活（最大值）
	private Byte markSeekcarIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserMarkSeekcarQuery () {}

    public UserMarkSeekcarQuery (Long markSeekcarId, Long markSeekcarIdMin, Long markSeekcarIdMax, Long markSeekcarUserId, Long markSeekcarUserIdMin, Long markSeekcarUserIdMax, Long markSeekcarProjectId, Long markSeekcarProjectIdMin, Long markSeekcarProjectIdMax, String markSeekcarStartCity, String markSeekcarStartAddr, String markSeekcarEndCity, String markSeekcarEndAddr, Date markSeekcarStartTime, Date markSeekcarStartTimeMin, Date markSeekcarStartTimeMax, String markSeekcarName, String markSeekcarPhone, String markSeekcarMemo, Integer markSeekcarVersion, Integer markSeekcarVersionMin, Integer markSeekcarVersionMax, Date markSeekcarCreateTime, Date markSeekcarCreateTimeMin, Date markSeekcarCreateTimeMax, Date markSeekcarUpdateTime, Date markSeekcarUpdateTimeMin, Date markSeekcarUpdateTimeMax, Byte markSeekcarIsActive, Byte markSeekcarIsActiveMin, Byte markSeekcarIsActiveMax, String userDetailNickname, String userDetailHeadicon) {
        this.markSeekcarId = markSeekcarId;
		this.markSeekcarIdMin = markSeekcarIdMin;
		this.markSeekcarIdMax = markSeekcarIdMax;
		this.markSeekcarUserId = markSeekcarUserId;
		this.markSeekcarUserIdMin = markSeekcarUserIdMin;
		this.markSeekcarUserIdMax = markSeekcarUserIdMax;
		this.markSeekcarProjectId = markSeekcarProjectId;
		this.markSeekcarProjectIdMin = markSeekcarProjectIdMin;
		this.markSeekcarProjectIdMax = markSeekcarProjectIdMax;
		this.markSeekcarStartCity = markSeekcarStartCity;
		this.markSeekcarStartAddr = markSeekcarStartAddr;
		this.markSeekcarEndCity = markSeekcarEndCity;
		this.markSeekcarEndAddr = markSeekcarEndAddr;
		this.markSeekcarStartTime = markSeekcarStartTime;
		this.markSeekcarStartTimeMin = markSeekcarStartTimeMin;
		this.markSeekcarStartTimeMax = markSeekcarStartTimeMax;
		this.markSeekcarName = markSeekcarName;
		this.markSeekcarPhone = markSeekcarPhone;
		this.markSeekcarMemo = markSeekcarMemo;
		this.markSeekcarVersion = markSeekcarVersion;
		this.markSeekcarVersionMin = markSeekcarVersionMin;
		this.markSeekcarVersionMax = markSeekcarVersionMax;
		this.markSeekcarCreateTime = markSeekcarCreateTime;
		this.markSeekcarCreateTimeMin = markSeekcarCreateTimeMin;
		this.markSeekcarCreateTimeMax = markSeekcarCreateTimeMax;
		this.markSeekcarUpdateTime = markSeekcarUpdateTime;
		this.markSeekcarUpdateTimeMin = markSeekcarUpdateTimeMin;
		this.markSeekcarUpdateTimeMax = markSeekcarUpdateTimeMax;
		this.markSeekcarIsActive = markSeekcarIsActive;
		this.markSeekcarIsActiveMin = markSeekcarIsActiveMin;
		this.markSeekcarIsActiveMax = markSeekcarIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getMarkSeekcarId() {
		return markSeekcarId;
	}

	public void setMarkSeekcarId(Long markSeekcarId) {
		this.markSeekcarId = markSeekcarId;
	}

	public Long getMarkSeekcarIdMin() {
		return markSeekcarIdMin;
	}

	public void setMarkSeekcarIdMin(Long markSeekcarIdMin) {
		this.markSeekcarIdMin = markSeekcarIdMin;
	}

	public Long getMarkSeekcarIdMax() {
		return markSeekcarIdMax;
	}

	public void setMarkSeekcarIdMax(Long markSeekcarIdMax) {
		this.markSeekcarIdMax = markSeekcarIdMax;
	}

	public Long getMarkSeekcarUserId() {
		return markSeekcarUserId;
	}

	public void setMarkSeekcarUserId(Long markSeekcarUserId) {
		this.markSeekcarUserId = markSeekcarUserId;
	}

	public Long getMarkSeekcarUserIdMin() {
		return markSeekcarUserIdMin;
	}

	public void setMarkSeekcarUserIdMin(Long markSeekcarUserIdMin) {
		this.markSeekcarUserIdMin = markSeekcarUserIdMin;
	}

	public Long getMarkSeekcarUserIdMax() {
		return markSeekcarUserIdMax;
	}

	public void setMarkSeekcarUserIdMax(Long markSeekcarUserIdMax) {
		this.markSeekcarUserIdMax = markSeekcarUserIdMax;
	}

	public Long getMarkSeekcarProjectId() {
		return markSeekcarProjectId;
	}

	public void setMarkSeekcarProjectId(Long markSeekcarProjectId) {
		this.markSeekcarProjectId = markSeekcarProjectId;
	}

	public Long getMarkSeekcarProjectIdMin() {
		return markSeekcarProjectIdMin;
	}

	public void setMarkSeekcarProjectIdMin(Long markSeekcarProjectIdMin) {
		this.markSeekcarProjectIdMin = markSeekcarProjectIdMin;
	}

	public Long getMarkSeekcarProjectIdMax() {
		return markSeekcarProjectIdMax;
	}

	public void setMarkSeekcarProjectIdMax(Long markSeekcarProjectIdMax) {
		this.markSeekcarProjectIdMax = markSeekcarProjectIdMax;
	}

	public String getMarkSeekcarStartCity() {
		return markSeekcarStartCity;
	}

	public void setMarkSeekcarStartCity(String markSeekcarStartCity) {
		this.markSeekcarStartCity = markSeekcarStartCity;
	}

	public String getMarkSeekcarStartAddr() {
		return markSeekcarStartAddr;
	}

	public void setMarkSeekcarStartAddr(String markSeekcarStartAddr) {
		this.markSeekcarStartAddr = markSeekcarStartAddr;
	}

	public String getMarkSeekcarEndCity() {
		return markSeekcarEndCity;
	}

	public void setMarkSeekcarEndCity(String markSeekcarEndCity) {
		this.markSeekcarEndCity = markSeekcarEndCity;
	}

	public String getMarkSeekcarEndAddr() {
		return markSeekcarEndAddr;
	}

	public void setMarkSeekcarEndAddr(String markSeekcarEndAddr) {
		this.markSeekcarEndAddr = markSeekcarEndAddr;
	}

	public Date getMarkSeekcarStartTime() {
		return markSeekcarStartTime;
	}

	public void setMarkSeekcarStartTime(Date markSeekcarStartTime) {
		this.markSeekcarStartTime = markSeekcarStartTime;
	}

	public Date getMarkSeekcarStartTimeMin() {
		return markSeekcarStartTimeMin;
	}

	public void setMarkSeekcarStartTimeMin(Date markSeekcarStartTimeMin) {
		this.markSeekcarStartTimeMin = markSeekcarStartTimeMin;
	}

	public Date getMarkSeekcarStartTimeMax() {
		return markSeekcarStartTimeMax;
	}

	public void setMarkSeekcarStartTimeMax(Date markSeekcarStartTimeMax) {
		this.markSeekcarStartTimeMax = markSeekcarStartTimeMax;
	}

	public String getMarkSeekcarName() {
		return markSeekcarName;
	}

	public void setMarkSeekcarName(String markSeekcarName) {
		this.markSeekcarName = markSeekcarName;
	}

	public String getMarkSeekcarPhone() {
		return markSeekcarPhone;
	}

	public void setMarkSeekcarPhone(String markSeekcarPhone) {
		this.markSeekcarPhone = markSeekcarPhone;
	}

	public String getMarkSeekcarMemo() {
		return markSeekcarMemo;
	}

	public void setMarkSeekcarMemo(String markSeekcarMemo) {
		this.markSeekcarMemo = markSeekcarMemo;
	}

	public Integer getMarkSeekcarVersion() {
		return markSeekcarVersion;
	}

	public void setMarkSeekcarVersion(Integer markSeekcarVersion) {
		this.markSeekcarVersion = markSeekcarVersion;
	}

	public Integer getMarkSeekcarVersionMin() {
		return markSeekcarVersionMin;
	}

	public void setMarkSeekcarVersionMin(Integer markSeekcarVersionMin) {
		this.markSeekcarVersionMin = markSeekcarVersionMin;
	}

	public Integer getMarkSeekcarVersionMax() {
		return markSeekcarVersionMax;
	}

	public void setMarkSeekcarVersionMax(Integer markSeekcarVersionMax) {
		this.markSeekcarVersionMax = markSeekcarVersionMax;
	}

	public Date getMarkSeekcarCreateTime() {
		return markSeekcarCreateTime;
	}

	public void setMarkSeekcarCreateTime(Date markSeekcarCreateTime) {
		this.markSeekcarCreateTime = markSeekcarCreateTime;
	}

	public Date getMarkSeekcarCreateTimeMin() {
		return markSeekcarCreateTimeMin;
	}

	public void setMarkSeekcarCreateTimeMin(Date markSeekcarCreateTimeMin) {
		this.markSeekcarCreateTimeMin = markSeekcarCreateTimeMin;
	}

	public Date getMarkSeekcarCreateTimeMax() {
		return markSeekcarCreateTimeMax;
	}

	public void setMarkSeekcarCreateTimeMax(Date markSeekcarCreateTimeMax) {
		this.markSeekcarCreateTimeMax = markSeekcarCreateTimeMax;
	}

	public Date getMarkSeekcarUpdateTime() {
		return markSeekcarUpdateTime;
	}

	public void setMarkSeekcarUpdateTime(Date markSeekcarUpdateTime) {
		this.markSeekcarUpdateTime = markSeekcarUpdateTime;
	}

	public Date getMarkSeekcarUpdateTimeMin() {
		return markSeekcarUpdateTimeMin;
	}

	public void setMarkSeekcarUpdateTimeMin(Date markSeekcarUpdateTimeMin) {
		this.markSeekcarUpdateTimeMin = markSeekcarUpdateTimeMin;
	}

	public Date getMarkSeekcarUpdateTimeMax() {
		return markSeekcarUpdateTimeMax;
	}

	public void setMarkSeekcarUpdateTimeMax(Date markSeekcarUpdateTimeMax) {
		this.markSeekcarUpdateTimeMax = markSeekcarUpdateTimeMax;
	}

	public Byte getMarkSeekcarIsActive() {
		return markSeekcarIsActive;
	}

	public void setMarkSeekcarIsActive(Byte markSeekcarIsActive) {
		this.markSeekcarIsActive = markSeekcarIsActive;
	}

	public Byte getMarkSeekcarIsActiveMin() {
		return markSeekcarIsActiveMin;
	}

	public void setMarkSeekcarIsActiveMin(Byte markSeekcarIsActiveMin) {
		this.markSeekcarIsActiveMin = markSeekcarIsActiveMin;
	}

	public Byte getMarkSeekcarIsActiveMax() {
		return markSeekcarIsActiveMax;
	}

	public void setMarkSeekcarIsActiveMax(Byte markSeekcarIsActiveMax) {
		this.markSeekcarIsActiveMax = markSeekcarIsActiveMax;
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
        return "UserMarkSeekcarQuery {" +
                "markSeekcarId = " + markSeekcarId + 
				", markSeekcarIdMin = " + markSeekcarIdMin + 
				", markSeekcarIdMax = " + markSeekcarIdMax + 
				", markSeekcarUserId = " + markSeekcarUserId + 
				", markSeekcarUserIdMin = " + markSeekcarUserIdMin + 
				", markSeekcarUserIdMax = " + markSeekcarUserIdMax + 
				", markSeekcarProjectId = " + markSeekcarProjectId + 
				", markSeekcarProjectIdMin = " + markSeekcarProjectIdMin + 
				", markSeekcarProjectIdMax = " + markSeekcarProjectIdMax + 
				", markSeekcarStartCity = " + markSeekcarStartCity + 
				", markSeekcarStartAddr = " + markSeekcarStartAddr + 
				", markSeekcarEndCity = " + markSeekcarEndCity + 
				", markSeekcarEndAddr = " + markSeekcarEndAddr + 
				", markSeekcarStartTime = " + markSeekcarStartTime + 
				", markSeekcarStartTimeMin = " + markSeekcarStartTimeMin + 
				", markSeekcarStartTimeMax = " + markSeekcarStartTimeMax + 
				", markSeekcarName = " + markSeekcarName + 
				", markSeekcarPhone = " + markSeekcarPhone + 
				", markSeekcarMemo = " + markSeekcarMemo + 
				", markSeekcarVersion = " + markSeekcarVersion + 
				", markSeekcarVersionMin = " + markSeekcarVersionMin + 
				", markSeekcarVersionMax = " + markSeekcarVersionMax + 
				", markSeekcarCreateTime = " + markSeekcarCreateTime + 
				", markSeekcarCreateTimeMin = " + markSeekcarCreateTimeMin + 
				", markSeekcarCreateTimeMax = " + markSeekcarCreateTimeMax + 
				", markSeekcarUpdateTime = " + markSeekcarUpdateTime + 
				", markSeekcarUpdateTimeMin = " + markSeekcarUpdateTimeMin + 
				", markSeekcarUpdateTimeMax = " + markSeekcarUpdateTimeMax + 
				", markSeekcarIsActive = " + markSeekcarIsActive + 
				", markSeekcarIsActiveMin = " + markSeekcarIsActiveMin + 
				", markSeekcarIsActiveMax = " + markSeekcarIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
