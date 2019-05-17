package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMarkSeekcarRecordQuery查询对象类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMarkSeekcarRecordQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035645088217L;

    //t_mark_seekcar_record表的字段对应的属性
	// 拼车记录编号
	private Long markSeekcarRecordId;
	// 拼车记录编号（最小值）
	private Long markSeekcarRecordIdMin;
	// 拼车记录编号（最大值）
	private Long markSeekcarRecordIdMax;
	// 用户编号
	private Long markSeekcarRecordUserId;
	// 用户编号（最小值）
	private Long markSeekcarRecordUserIdMin;
	// 用户编号（最大值）
	private Long markSeekcarRecordUserIdMax;
	// 找车编号
	private Long markSeekcarRecordMarkSeekcarId;
	// 找车编号（最小值）
	private Long markSeekcarRecordMarkSeekcarIdMin;
	// 找车编号（最大值）
	private Long markSeekcarRecordMarkSeekcarIdMax;
	// 版本号
	private Integer markSeekcarRecordVersion;
	// 版本号（最小值）
	private Integer markSeekcarRecordVersionMin;
	// 版本号（最大值）
	private Integer markSeekcarRecordVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordUpdateTimeMax;
	// 是否激活
	private Byte markSeekcarRecordIsActive;
	// 是否激活（最小值）
	private Byte markSeekcarRecordIsActiveMin;
	// 是否激活（最大值）
	private Byte markSeekcarRecordIsActiveMax;
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
	
    public UserMarkSeekcarRecordQuery () {}

    public UserMarkSeekcarRecordQuery (Long markSeekcarRecordId, Long markSeekcarRecordIdMin, Long markSeekcarRecordIdMax, Long markSeekcarRecordUserId, Long markSeekcarRecordUserIdMin, Long markSeekcarRecordUserIdMax, Long markSeekcarRecordMarkSeekcarId, Long markSeekcarRecordMarkSeekcarIdMin, Long markSeekcarRecordMarkSeekcarIdMax, Integer markSeekcarRecordVersion, Integer markSeekcarRecordVersionMin, Integer markSeekcarRecordVersionMax, Date markSeekcarRecordCreateTime, Date markSeekcarRecordCreateTimeMin, Date markSeekcarRecordCreateTimeMax, Date markSeekcarRecordUpdateTime, Date markSeekcarRecordUpdateTimeMin, Date markSeekcarRecordUpdateTimeMax, Byte markSeekcarRecordIsActive, Byte markSeekcarRecordIsActiveMin, Byte markSeekcarRecordIsActiveMax, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax) {
        this.markSeekcarRecordId = markSeekcarRecordId;
		this.markSeekcarRecordIdMin = markSeekcarRecordIdMin;
		this.markSeekcarRecordIdMax = markSeekcarRecordIdMax;
		this.markSeekcarRecordUserId = markSeekcarRecordUserId;
		this.markSeekcarRecordUserIdMin = markSeekcarRecordUserIdMin;
		this.markSeekcarRecordUserIdMax = markSeekcarRecordUserIdMax;
		this.markSeekcarRecordMarkSeekcarId = markSeekcarRecordMarkSeekcarId;
		this.markSeekcarRecordMarkSeekcarIdMin = markSeekcarRecordMarkSeekcarIdMin;
		this.markSeekcarRecordMarkSeekcarIdMax = markSeekcarRecordMarkSeekcarIdMax;
		this.markSeekcarRecordVersion = markSeekcarRecordVersion;
		this.markSeekcarRecordVersionMin = markSeekcarRecordVersionMin;
		this.markSeekcarRecordVersionMax = markSeekcarRecordVersionMax;
		this.markSeekcarRecordCreateTime = markSeekcarRecordCreateTime;
		this.markSeekcarRecordCreateTimeMin = markSeekcarRecordCreateTimeMin;
		this.markSeekcarRecordCreateTimeMax = markSeekcarRecordCreateTimeMax;
		this.markSeekcarRecordUpdateTime = markSeekcarRecordUpdateTime;
		this.markSeekcarRecordUpdateTimeMin = markSeekcarRecordUpdateTimeMin;
		this.markSeekcarRecordUpdateTimeMax = markSeekcarRecordUpdateTimeMax;
		this.markSeekcarRecordIsActive = markSeekcarRecordIsActive;
		this.markSeekcarRecordIsActiveMin = markSeekcarRecordIsActiveMin;
		this.markSeekcarRecordIsActiveMax = markSeekcarRecordIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		
    }

    public Long getMarkSeekcarRecordId() {
		return markSeekcarRecordId;
	}

	public void setMarkSeekcarRecordId(Long markSeekcarRecordId) {
		this.markSeekcarRecordId = markSeekcarRecordId;
	}

	public Long getMarkSeekcarRecordIdMin() {
		return markSeekcarRecordIdMin;
	}

	public void setMarkSeekcarRecordIdMin(Long markSeekcarRecordIdMin) {
		this.markSeekcarRecordIdMin = markSeekcarRecordIdMin;
	}

	public Long getMarkSeekcarRecordIdMax() {
		return markSeekcarRecordIdMax;
	}

	public void setMarkSeekcarRecordIdMax(Long markSeekcarRecordIdMax) {
		this.markSeekcarRecordIdMax = markSeekcarRecordIdMax;
	}

	public Long getMarkSeekcarRecordUserId() {
		return markSeekcarRecordUserId;
	}

	public void setMarkSeekcarRecordUserId(Long markSeekcarRecordUserId) {
		this.markSeekcarRecordUserId = markSeekcarRecordUserId;
	}

	public Long getMarkSeekcarRecordUserIdMin() {
		return markSeekcarRecordUserIdMin;
	}

	public void setMarkSeekcarRecordUserIdMin(Long markSeekcarRecordUserIdMin) {
		this.markSeekcarRecordUserIdMin = markSeekcarRecordUserIdMin;
	}

	public Long getMarkSeekcarRecordUserIdMax() {
		return markSeekcarRecordUserIdMax;
	}

	public void setMarkSeekcarRecordUserIdMax(Long markSeekcarRecordUserIdMax) {
		this.markSeekcarRecordUserIdMax = markSeekcarRecordUserIdMax;
	}

	public Long getMarkSeekcarRecordMarkSeekcarId() {
		return markSeekcarRecordMarkSeekcarId;
	}

	public void setMarkSeekcarRecordMarkSeekcarId(Long markSeekcarRecordMarkSeekcarId) {
		this.markSeekcarRecordMarkSeekcarId = markSeekcarRecordMarkSeekcarId;
	}

	public Long getMarkSeekcarRecordMarkSeekcarIdMin() {
		return markSeekcarRecordMarkSeekcarIdMin;
	}

	public void setMarkSeekcarRecordMarkSeekcarIdMin(Long markSeekcarRecordMarkSeekcarIdMin) {
		this.markSeekcarRecordMarkSeekcarIdMin = markSeekcarRecordMarkSeekcarIdMin;
	}

	public Long getMarkSeekcarRecordMarkSeekcarIdMax() {
		return markSeekcarRecordMarkSeekcarIdMax;
	}

	public void setMarkSeekcarRecordMarkSeekcarIdMax(Long markSeekcarRecordMarkSeekcarIdMax) {
		this.markSeekcarRecordMarkSeekcarIdMax = markSeekcarRecordMarkSeekcarIdMax;
	}

	public Integer getMarkSeekcarRecordVersion() {
		return markSeekcarRecordVersion;
	}

	public void setMarkSeekcarRecordVersion(Integer markSeekcarRecordVersion) {
		this.markSeekcarRecordVersion = markSeekcarRecordVersion;
	}

	public Integer getMarkSeekcarRecordVersionMin() {
		return markSeekcarRecordVersionMin;
	}

	public void setMarkSeekcarRecordVersionMin(Integer markSeekcarRecordVersionMin) {
		this.markSeekcarRecordVersionMin = markSeekcarRecordVersionMin;
	}

	public Integer getMarkSeekcarRecordVersionMax() {
		return markSeekcarRecordVersionMax;
	}

	public void setMarkSeekcarRecordVersionMax(Integer markSeekcarRecordVersionMax) {
		this.markSeekcarRecordVersionMax = markSeekcarRecordVersionMax;
	}

	public Date getMarkSeekcarRecordCreateTime() {
		return markSeekcarRecordCreateTime;
	}

	public void setMarkSeekcarRecordCreateTime(Date markSeekcarRecordCreateTime) {
		this.markSeekcarRecordCreateTime = markSeekcarRecordCreateTime;
	}

	public Date getMarkSeekcarRecordCreateTimeMin() {
		return markSeekcarRecordCreateTimeMin;
	}

	public void setMarkSeekcarRecordCreateTimeMin(Date markSeekcarRecordCreateTimeMin) {
		this.markSeekcarRecordCreateTimeMin = markSeekcarRecordCreateTimeMin;
	}

	public Date getMarkSeekcarRecordCreateTimeMax() {
		return markSeekcarRecordCreateTimeMax;
	}

	public void setMarkSeekcarRecordCreateTimeMax(Date markSeekcarRecordCreateTimeMax) {
		this.markSeekcarRecordCreateTimeMax = markSeekcarRecordCreateTimeMax;
	}

	public Date getMarkSeekcarRecordUpdateTime() {
		return markSeekcarRecordUpdateTime;
	}

	public void setMarkSeekcarRecordUpdateTime(Date markSeekcarRecordUpdateTime) {
		this.markSeekcarRecordUpdateTime = markSeekcarRecordUpdateTime;
	}

	public Date getMarkSeekcarRecordUpdateTimeMin() {
		return markSeekcarRecordUpdateTimeMin;
	}

	public void setMarkSeekcarRecordUpdateTimeMin(Date markSeekcarRecordUpdateTimeMin) {
		this.markSeekcarRecordUpdateTimeMin = markSeekcarRecordUpdateTimeMin;
	}

	public Date getMarkSeekcarRecordUpdateTimeMax() {
		return markSeekcarRecordUpdateTimeMax;
	}

	public void setMarkSeekcarRecordUpdateTimeMax(Date markSeekcarRecordUpdateTimeMax) {
		this.markSeekcarRecordUpdateTimeMax = markSeekcarRecordUpdateTimeMax;
	}

	public Byte getMarkSeekcarRecordIsActive() {
		return markSeekcarRecordIsActive;
	}

	public void setMarkSeekcarRecordIsActive(Byte markSeekcarRecordIsActive) {
		this.markSeekcarRecordIsActive = markSeekcarRecordIsActive;
	}

	public Byte getMarkSeekcarRecordIsActiveMin() {
		return markSeekcarRecordIsActiveMin;
	}

	public void setMarkSeekcarRecordIsActiveMin(Byte markSeekcarRecordIsActiveMin) {
		this.markSeekcarRecordIsActiveMin = markSeekcarRecordIsActiveMin;
	}

	public Byte getMarkSeekcarRecordIsActiveMax() {
		return markSeekcarRecordIsActiveMax;
	}

	public void setMarkSeekcarRecordIsActiveMax(Byte markSeekcarRecordIsActiveMax) {
		this.markSeekcarRecordIsActiveMax = markSeekcarRecordIsActiveMax;
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
        return "UserMarkSeekcarRecordQuery {" +
                "markSeekcarRecordId = " + markSeekcarRecordId + 
				", markSeekcarRecordIdMin = " + markSeekcarRecordIdMin + 
				", markSeekcarRecordIdMax = " + markSeekcarRecordIdMax + 
				", markSeekcarRecordUserId = " + markSeekcarRecordUserId + 
				", markSeekcarRecordUserIdMin = " + markSeekcarRecordUserIdMin + 
				", markSeekcarRecordUserIdMax = " + markSeekcarRecordUserIdMax + 
				", markSeekcarRecordMarkSeekcarId = " + markSeekcarRecordMarkSeekcarId + 
				", markSeekcarRecordMarkSeekcarIdMin = " + markSeekcarRecordMarkSeekcarIdMin + 
				", markSeekcarRecordMarkSeekcarIdMax = " + markSeekcarRecordMarkSeekcarIdMax + 
				", markSeekcarRecordVersion = " + markSeekcarRecordVersion + 
				", markSeekcarRecordVersionMin = " + markSeekcarRecordVersionMin + 
				", markSeekcarRecordVersionMax = " + markSeekcarRecordVersionMax + 
				", markSeekcarRecordCreateTime = " + markSeekcarRecordCreateTime + 
				", markSeekcarRecordCreateTimeMin = " + markSeekcarRecordCreateTimeMin + 
				", markSeekcarRecordCreateTimeMax = " + markSeekcarRecordCreateTimeMax + 
				", markSeekcarRecordUpdateTime = " + markSeekcarRecordUpdateTime + 
				", markSeekcarRecordUpdateTimeMin = " + markSeekcarRecordUpdateTimeMin + 
				", markSeekcarRecordUpdateTimeMax = " + markSeekcarRecordUpdateTimeMax + 
				", markSeekcarRecordIsActive = " + markSeekcarRecordIsActive + 
				", markSeekcarRecordIsActiveMin = " + markSeekcarRecordIsActiveMin + 
				", markSeekcarRecordIsActiveMax = " + markSeekcarRecordIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				" }";
    }

}
