package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMarkCarpoolRecordQuery查询对象类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMarkCarpoolRecordQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034763847796L;

    //t_mark_carpool_record表的字段对应的属性
	// 拼车记录编号
	private Long markCarpoolRecordId;
	// 拼车记录编号（最小值）
	private Long markCarpoolRecordIdMin;
	// 拼车记录编号（最大值）
	private Long markCarpoolRecordIdMax;
	// 用户编号
	private Long markCarpoolRecordUserId;
	// 用户编号（最小值）
	private Long markCarpoolRecordUserIdMin;
	// 用户编号（最大值）
	private Long markCarpoolRecordUserIdMax;
	// 拼车编号
	private Long markCarpoolRecordMarkCarpoolId;
	// 拼车编号（最小值）
	private Long markCarpoolRecordMarkCarpoolIdMin;
	// 拼车编号（最大值）
	private Long markCarpoolRecordMarkCarpoolIdMax;
	// 版本号
	private Integer markCarpoolRecordVersion;
	// 版本号（最小值）
	private Integer markCarpoolRecordVersionMin;
	// 版本号（最大值）
	private Integer markCarpoolRecordVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolRecordCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolRecordCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolRecordCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolRecordUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolRecordUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markCarpoolRecordUpdateTimeMax;
	// 是否激活
	private Byte markCarpoolRecordIsActive;
	// 是否激活（最小值）
	private Byte markCarpoolRecordIsActiveMin;
	// 是否激活（最大值）
	private Byte markCarpoolRecordIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	// 性别（最小值）
	private Byte userDetailGenderMin;
	// 性别（最大值）
	private Byte userDetailGenderMax;
	
    public UserMarkCarpoolRecordQuery () {}

    public UserMarkCarpoolRecordQuery (Long markCarpoolRecordId, Long markCarpoolRecordIdMin, Long markCarpoolRecordIdMax, Long markCarpoolRecordUserId, Long markCarpoolRecordUserIdMin, Long markCarpoolRecordUserIdMax, Long markCarpoolRecordMarkCarpoolId, Long markCarpoolRecordMarkCarpoolIdMin, Long markCarpoolRecordMarkCarpoolIdMax, Integer markCarpoolRecordVersion, Integer markCarpoolRecordVersionMin, Integer markCarpoolRecordVersionMax, Date markCarpoolRecordCreateTime, Date markCarpoolRecordCreateTimeMin, Date markCarpoolRecordCreateTimeMax, Date markCarpoolRecordUpdateTime, Date markCarpoolRecordUpdateTimeMin, Date markCarpoolRecordUpdateTimeMax, Byte markCarpoolRecordIsActive, Byte markCarpoolRecordIsActiveMin, Byte markCarpoolRecordIsActiveMax, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax) {
        this.markCarpoolRecordId = markCarpoolRecordId;
		this.markCarpoolRecordIdMin = markCarpoolRecordIdMin;
		this.markCarpoolRecordIdMax = markCarpoolRecordIdMax;
		this.markCarpoolRecordUserId = markCarpoolRecordUserId;
		this.markCarpoolRecordUserIdMin = markCarpoolRecordUserIdMin;
		this.markCarpoolRecordUserIdMax = markCarpoolRecordUserIdMax;
		this.markCarpoolRecordMarkCarpoolId = markCarpoolRecordMarkCarpoolId;
		this.markCarpoolRecordMarkCarpoolIdMin = markCarpoolRecordMarkCarpoolIdMin;
		this.markCarpoolRecordMarkCarpoolIdMax = markCarpoolRecordMarkCarpoolIdMax;
		this.markCarpoolRecordVersion = markCarpoolRecordVersion;
		this.markCarpoolRecordVersionMin = markCarpoolRecordVersionMin;
		this.markCarpoolRecordVersionMax = markCarpoolRecordVersionMax;
		this.markCarpoolRecordCreateTime = markCarpoolRecordCreateTime;
		this.markCarpoolRecordCreateTimeMin = markCarpoolRecordCreateTimeMin;
		this.markCarpoolRecordCreateTimeMax = markCarpoolRecordCreateTimeMax;
		this.markCarpoolRecordUpdateTime = markCarpoolRecordUpdateTime;
		this.markCarpoolRecordUpdateTimeMin = markCarpoolRecordUpdateTimeMin;
		this.markCarpoolRecordUpdateTimeMax = markCarpoolRecordUpdateTimeMax;
		this.markCarpoolRecordIsActive = markCarpoolRecordIsActive;
		this.markCarpoolRecordIsActiveMin = markCarpoolRecordIsActiveMin;
		this.markCarpoolRecordIsActiveMax = markCarpoolRecordIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		
    }

    public Long getMarkCarpoolRecordId() {
		return markCarpoolRecordId;
	}

	public void setMarkCarpoolRecordId(Long markCarpoolRecordId) {
		this.markCarpoolRecordId = markCarpoolRecordId;
	}

	public Long getMarkCarpoolRecordIdMin() {
		return markCarpoolRecordIdMin;
	}

	public void setMarkCarpoolRecordIdMin(Long markCarpoolRecordIdMin) {
		this.markCarpoolRecordIdMin = markCarpoolRecordIdMin;
	}

	public Long getMarkCarpoolRecordIdMax() {
		return markCarpoolRecordIdMax;
	}

	public void setMarkCarpoolRecordIdMax(Long markCarpoolRecordIdMax) {
		this.markCarpoolRecordIdMax = markCarpoolRecordIdMax;
	}

	public Long getMarkCarpoolRecordUserId() {
		return markCarpoolRecordUserId;
	}

	public void setMarkCarpoolRecordUserId(Long markCarpoolRecordUserId) {
		this.markCarpoolRecordUserId = markCarpoolRecordUserId;
	}

	public Long getMarkCarpoolRecordUserIdMin() {
		return markCarpoolRecordUserIdMin;
	}

	public void setMarkCarpoolRecordUserIdMin(Long markCarpoolRecordUserIdMin) {
		this.markCarpoolRecordUserIdMin = markCarpoolRecordUserIdMin;
	}

	public Long getMarkCarpoolRecordUserIdMax() {
		return markCarpoolRecordUserIdMax;
	}

	public void setMarkCarpoolRecordUserIdMax(Long markCarpoolRecordUserIdMax) {
		this.markCarpoolRecordUserIdMax = markCarpoolRecordUserIdMax;
	}

	public Long getMarkCarpoolRecordMarkCarpoolId() {
		return markCarpoolRecordMarkCarpoolId;
	}

	public void setMarkCarpoolRecordMarkCarpoolId(Long markCarpoolRecordMarkCarpoolId) {
		this.markCarpoolRecordMarkCarpoolId = markCarpoolRecordMarkCarpoolId;
	}

	public Long getMarkCarpoolRecordMarkCarpoolIdMin() {
		return markCarpoolRecordMarkCarpoolIdMin;
	}

	public void setMarkCarpoolRecordMarkCarpoolIdMin(Long markCarpoolRecordMarkCarpoolIdMin) {
		this.markCarpoolRecordMarkCarpoolIdMin = markCarpoolRecordMarkCarpoolIdMin;
	}

	public Long getMarkCarpoolRecordMarkCarpoolIdMax() {
		return markCarpoolRecordMarkCarpoolIdMax;
	}

	public void setMarkCarpoolRecordMarkCarpoolIdMax(Long markCarpoolRecordMarkCarpoolIdMax) {
		this.markCarpoolRecordMarkCarpoolIdMax = markCarpoolRecordMarkCarpoolIdMax;
	}

	public Integer getMarkCarpoolRecordVersion() {
		return markCarpoolRecordVersion;
	}

	public void setMarkCarpoolRecordVersion(Integer markCarpoolRecordVersion) {
		this.markCarpoolRecordVersion = markCarpoolRecordVersion;
	}

	public Integer getMarkCarpoolRecordVersionMin() {
		return markCarpoolRecordVersionMin;
	}

	public void setMarkCarpoolRecordVersionMin(Integer markCarpoolRecordVersionMin) {
		this.markCarpoolRecordVersionMin = markCarpoolRecordVersionMin;
	}

	public Integer getMarkCarpoolRecordVersionMax() {
		return markCarpoolRecordVersionMax;
	}

	public void setMarkCarpoolRecordVersionMax(Integer markCarpoolRecordVersionMax) {
		this.markCarpoolRecordVersionMax = markCarpoolRecordVersionMax;
	}

	public Date getMarkCarpoolRecordCreateTime() {
		return markCarpoolRecordCreateTime;
	}

	public void setMarkCarpoolRecordCreateTime(Date markCarpoolRecordCreateTime) {
		this.markCarpoolRecordCreateTime = markCarpoolRecordCreateTime;
	}

	public Date getMarkCarpoolRecordCreateTimeMin() {
		return markCarpoolRecordCreateTimeMin;
	}

	public void setMarkCarpoolRecordCreateTimeMin(Date markCarpoolRecordCreateTimeMin) {
		this.markCarpoolRecordCreateTimeMin = markCarpoolRecordCreateTimeMin;
	}

	public Date getMarkCarpoolRecordCreateTimeMax() {
		return markCarpoolRecordCreateTimeMax;
	}

	public void setMarkCarpoolRecordCreateTimeMax(Date markCarpoolRecordCreateTimeMax) {
		this.markCarpoolRecordCreateTimeMax = markCarpoolRecordCreateTimeMax;
	}

	public Date getMarkCarpoolRecordUpdateTime() {
		return markCarpoolRecordUpdateTime;
	}

	public void setMarkCarpoolRecordUpdateTime(Date markCarpoolRecordUpdateTime) {
		this.markCarpoolRecordUpdateTime = markCarpoolRecordUpdateTime;
	}

	public Date getMarkCarpoolRecordUpdateTimeMin() {
		return markCarpoolRecordUpdateTimeMin;
	}

	public void setMarkCarpoolRecordUpdateTimeMin(Date markCarpoolRecordUpdateTimeMin) {
		this.markCarpoolRecordUpdateTimeMin = markCarpoolRecordUpdateTimeMin;
	}

	public Date getMarkCarpoolRecordUpdateTimeMax() {
		return markCarpoolRecordUpdateTimeMax;
	}

	public void setMarkCarpoolRecordUpdateTimeMax(Date markCarpoolRecordUpdateTimeMax) {
		this.markCarpoolRecordUpdateTimeMax = markCarpoolRecordUpdateTimeMax;
	}

	public Byte getMarkCarpoolRecordIsActive() {
		return markCarpoolRecordIsActive;
	}

	public void setMarkCarpoolRecordIsActive(Byte markCarpoolRecordIsActive) {
		this.markCarpoolRecordIsActive = markCarpoolRecordIsActive;
	}

	public Byte getMarkCarpoolRecordIsActiveMin() {
		return markCarpoolRecordIsActiveMin;
	}

	public void setMarkCarpoolRecordIsActiveMin(Byte markCarpoolRecordIsActiveMin) {
		this.markCarpoolRecordIsActiveMin = markCarpoolRecordIsActiveMin;
	}

	public Byte getMarkCarpoolRecordIsActiveMax() {
		return markCarpoolRecordIsActiveMax;
	}

	public void setMarkCarpoolRecordIsActiveMax(Byte markCarpoolRecordIsActiveMax) {
		this.markCarpoolRecordIsActiveMax = markCarpoolRecordIsActiveMax;
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

	public Byte getUserDetailGender() {
		return userDetailGender;
	}

	public void setUserDetailGender(Byte userDetailGender) {
		this.userDetailGender = userDetailGender;
	}

	public Byte getUserDetailGenderMin() {
		return userDetailGenderMin;
	}

	public void setUserDetailGenderMin(Byte userDetailGenderMin) {
		this.userDetailGenderMin = userDetailGenderMin;
	}

	public Byte getUserDetailGenderMax() {
		return userDetailGenderMax;
	}

	public void setUserDetailGenderMax(Byte userDetailGenderMax) {
		this.userDetailGenderMax = userDetailGenderMax;
	}

	
    @Override
    public String toString() {
        return "UserMarkCarpoolRecordQuery {" +
                "markCarpoolRecordId = " + markCarpoolRecordId + 
				", markCarpoolRecordIdMin = " + markCarpoolRecordIdMin + 
				", markCarpoolRecordIdMax = " + markCarpoolRecordIdMax + 
				", markCarpoolRecordUserId = " + markCarpoolRecordUserId + 
				", markCarpoolRecordUserIdMin = " + markCarpoolRecordUserIdMin + 
				", markCarpoolRecordUserIdMax = " + markCarpoolRecordUserIdMax + 
				", markCarpoolRecordMarkCarpoolId = " + markCarpoolRecordMarkCarpoolId + 
				", markCarpoolRecordMarkCarpoolIdMin = " + markCarpoolRecordMarkCarpoolIdMin + 
				", markCarpoolRecordMarkCarpoolIdMax = " + markCarpoolRecordMarkCarpoolIdMax + 
				", markCarpoolRecordVersion = " + markCarpoolRecordVersion + 
				", markCarpoolRecordVersionMin = " + markCarpoolRecordVersionMin + 
				", markCarpoolRecordVersionMax = " + markCarpoolRecordVersionMax + 
				", markCarpoolRecordCreateTime = " + markCarpoolRecordCreateTime + 
				", markCarpoolRecordCreateTimeMin = " + markCarpoolRecordCreateTimeMin + 
				", markCarpoolRecordCreateTimeMax = " + markCarpoolRecordCreateTimeMax + 
				", markCarpoolRecordUpdateTime = " + markCarpoolRecordUpdateTime + 
				", markCarpoolRecordUpdateTimeMin = " + markCarpoolRecordUpdateTimeMin + 
				", markCarpoolRecordUpdateTimeMax = " + markCarpoolRecordUpdateTimeMax + 
				", markCarpoolRecordIsActive = " + markCarpoolRecordIsActive + 
				", markCarpoolRecordIsActiveMin = " + markCarpoolRecordIsActiveMin + 
				", markCarpoolRecordIsActiveMax = " + markCarpoolRecordIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				" }";
    }

}
