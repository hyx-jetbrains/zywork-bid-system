package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserRecruitQuery查询对象类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserRecruitQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034967962123L;

    //t_recruit表的字段对应的属性
	// 招聘编号
	private Long recruitId;
	// 招聘编号（最小值）
	private Long recruitIdMin;
	// 招聘编号（最大值）
	private Long recruitIdMax;
	// 用户编号
	private Long recruitUserId;
	// 用户编号（最小值）
	private Long recruitUserIdMin;
	// 用户编号（最大值）
	private Long recruitUserIdMax;
	// 招聘岗位
	private String recruitJobTitle;
	// 是否全职
	private Byte recruitIsFulltime;
	// 是否全职（最小值）
	private Byte recruitIsFulltimeMin;
	// 是否全职（最大值）
	private Byte recruitIsFulltimeMax;
	// 工作时间（年）
	private String recruitWorkYear;
	// 要求学历
	private String recruitEducation;
	// 提供月薪
	private String recruitSalary;
	// 工作地
	private String recruitWorkAddr;
	// 职位描述
	private String recruitMemo;
	// 招聘状态
	private String recruitRecruitStatus;
	// 版本号
	private Integer recruitVersion;
	// 版本号（最小值）
	private Integer recruitVersionMin;
	// 版本号（最大值）
	private Integer recruitVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitUpdateTimeMax;
	// 是否激活
	private Byte recruitIsActive;
	// 是否激活（最小值）
	private Byte recruitIsActiveMin;
	// 是否激活（最大值）
	private Byte recruitIsActiveMax;
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

	// 联系电话
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    public UserRecruitQuery () {}

    public UserRecruitQuery (Long recruitId, Long recruitIdMin, Long recruitIdMax, Long recruitUserId, Long recruitUserIdMin, Long recruitUserIdMax, String recruitJobTitle, Byte recruitIsFulltime, Byte recruitIsFulltimeMin, Byte recruitIsFulltimeMax, String recruitWorkYear, String recruitEducation, String recruitSalary, String recruitWorkAddr, String recruitMemo, String recruitRecruitStatus, Integer recruitVersion, Integer recruitVersionMin, Integer recruitVersionMax, Date recruitCreateTime, Date recruitCreateTimeMin, Date recruitCreateTimeMax, Date recruitUpdateTime, Date recruitUpdateTimeMin, Date recruitUpdateTimeMax, Byte recruitIsActive, Byte recruitIsActiveMin, Byte recruitIsActiveMax, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax) {
        this.recruitId = recruitId;
		this.recruitIdMin = recruitIdMin;
		this.recruitIdMax = recruitIdMax;
		this.recruitUserId = recruitUserId;
		this.recruitUserIdMin = recruitUserIdMin;
		this.recruitUserIdMax = recruitUserIdMax;
		this.recruitJobTitle = recruitJobTitle;
		this.recruitIsFulltime = recruitIsFulltime;
		this.recruitIsFulltimeMin = recruitIsFulltimeMin;
		this.recruitIsFulltimeMax = recruitIsFulltimeMax;
		this.recruitWorkYear = recruitWorkYear;
		this.recruitEducation = recruitEducation;
		this.recruitSalary = recruitSalary;
		this.recruitWorkAddr = recruitWorkAddr;
		this.recruitMemo = recruitMemo;
		this.recruitRecruitStatus = recruitRecruitStatus;
		this.recruitVersion = recruitVersion;
		this.recruitVersionMin = recruitVersionMin;
		this.recruitVersionMax = recruitVersionMax;
		this.recruitCreateTime = recruitCreateTime;
		this.recruitCreateTimeMin = recruitCreateTimeMin;
		this.recruitCreateTimeMax = recruitCreateTimeMax;
		this.recruitUpdateTime = recruitUpdateTime;
		this.recruitUpdateTimeMin = recruitUpdateTimeMin;
		this.recruitUpdateTimeMax = recruitUpdateTimeMax;
		this.recruitIsActive = recruitIsActive;
		this.recruitIsActiveMin = recruitIsActiveMin;
		this.recruitIsActiveMax = recruitIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		
    }

    public Long getRecruitId() {
		return recruitId;
	}

	public void setRecruitId(Long recruitId) {
		this.recruitId = recruitId;
	}

	public Long getRecruitIdMin() {
		return recruitIdMin;
	}

	public void setRecruitIdMin(Long recruitIdMin) {
		this.recruitIdMin = recruitIdMin;
	}

	public Long getRecruitIdMax() {
		return recruitIdMax;
	}

	public void setRecruitIdMax(Long recruitIdMax) {
		this.recruitIdMax = recruitIdMax;
	}

	public Long getRecruitUserId() {
		return recruitUserId;
	}

	public void setRecruitUserId(Long recruitUserId) {
		this.recruitUserId = recruitUserId;
	}

	public Long getRecruitUserIdMin() {
		return recruitUserIdMin;
	}

	public void setRecruitUserIdMin(Long recruitUserIdMin) {
		this.recruitUserIdMin = recruitUserIdMin;
	}

	public Long getRecruitUserIdMax() {
		return recruitUserIdMax;
	}

	public void setRecruitUserIdMax(Long recruitUserIdMax) {
		this.recruitUserIdMax = recruitUserIdMax;
	}

	public String getRecruitJobTitle() {
		return recruitJobTitle;
	}

	public void setRecruitJobTitle(String recruitJobTitle) {
		this.recruitJobTitle = recruitJobTitle;
	}

	public Byte getRecruitIsFulltime() {
		return recruitIsFulltime;
	}

	public void setRecruitIsFulltime(Byte recruitIsFulltime) {
		this.recruitIsFulltime = recruitIsFulltime;
	}

	public Byte getRecruitIsFulltimeMin() {
		return recruitIsFulltimeMin;
	}

	public void setRecruitIsFulltimeMin(Byte recruitIsFulltimeMin) {
		this.recruitIsFulltimeMin = recruitIsFulltimeMin;
	}

	public Byte getRecruitIsFulltimeMax() {
		return recruitIsFulltimeMax;
	}

	public void setRecruitIsFulltimeMax(Byte recruitIsFulltimeMax) {
		this.recruitIsFulltimeMax = recruitIsFulltimeMax;
	}

	public String getRecruitWorkYear() {
		return recruitWorkYear;
	}

	public void setRecruitWorkYear(String recruitWorkYear) {
		this.recruitWorkYear = recruitWorkYear;
	}

	public String getRecruitEducation() {
		return recruitEducation;
	}

	public void setRecruitEducation(String recruitEducation) {
		this.recruitEducation = recruitEducation;
	}

	public String getRecruitSalary() {
		return recruitSalary;
	}

	public void setRecruitSalary(String recruitSalary) {
		this.recruitSalary = recruitSalary;
	}

	public String getRecruitWorkAddr() {
		return recruitWorkAddr;
	}

	public void setRecruitWorkAddr(String recruitWorkAddr) {
		this.recruitWorkAddr = recruitWorkAddr;
	}

	public String getRecruitMemo() {
		return recruitMemo;
	}

	public void setRecruitMemo(String recruitMemo) {
		this.recruitMemo = recruitMemo;
	}

	public String getRecruitRecruitStatus() {
		return recruitRecruitStatus;
	}

	public void setRecruitRecruitStatus(String recruitRecruitStatus) {
		this.recruitRecruitStatus = recruitRecruitStatus;
	}

	public Integer getRecruitVersion() {
		return recruitVersion;
	}

	public void setRecruitVersion(Integer recruitVersion) {
		this.recruitVersion = recruitVersion;
	}

	public Integer getRecruitVersionMin() {
		return recruitVersionMin;
	}

	public void setRecruitVersionMin(Integer recruitVersionMin) {
		this.recruitVersionMin = recruitVersionMin;
	}

	public Integer getRecruitVersionMax() {
		return recruitVersionMax;
	}

	public void setRecruitVersionMax(Integer recruitVersionMax) {
		this.recruitVersionMax = recruitVersionMax;
	}

	public Date getRecruitCreateTime() {
		return recruitCreateTime;
	}

	public void setRecruitCreateTime(Date recruitCreateTime) {
		this.recruitCreateTime = recruitCreateTime;
	}

	public Date getRecruitCreateTimeMin() {
		return recruitCreateTimeMin;
	}

	public void setRecruitCreateTimeMin(Date recruitCreateTimeMin) {
		this.recruitCreateTimeMin = recruitCreateTimeMin;
	}

	public Date getRecruitCreateTimeMax() {
		return recruitCreateTimeMax;
	}

	public void setRecruitCreateTimeMax(Date recruitCreateTimeMax) {
		this.recruitCreateTimeMax = recruitCreateTimeMax;
	}

	public Date getRecruitUpdateTime() {
		return recruitUpdateTime;
	}

	public void setRecruitUpdateTime(Date recruitUpdateTime) {
		this.recruitUpdateTime = recruitUpdateTime;
	}

	public Date getRecruitUpdateTimeMin() {
		return recruitUpdateTimeMin;
	}

	public void setRecruitUpdateTimeMin(Date recruitUpdateTimeMin) {
		this.recruitUpdateTimeMin = recruitUpdateTimeMin;
	}

	public Date getRecruitUpdateTimeMax() {
		return recruitUpdateTimeMax;
	}

	public void setRecruitUpdateTimeMax(Date recruitUpdateTimeMax) {
		this.recruitUpdateTimeMax = recruitUpdateTimeMax;
	}

	public Byte getRecruitIsActive() {
		return recruitIsActive;
	}

	public void setRecruitIsActive(Byte recruitIsActive) {
		this.recruitIsActive = recruitIsActive;
	}

	public Byte getRecruitIsActiveMin() {
		return recruitIsActiveMin;
	}

	public void setRecruitIsActiveMin(Byte recruitIsActiveMin) {
		this.recruitIsActiveMin = recruitIsActiveMin;
	}

	public Byte getRecruitIsActiveMax() {
		return recruitIsActiveMax;
	}

	public void setRecruitIsActiveMax(Byte recruitIsActiveMax) {
		this.recruitIsActiveMax = recruitIsActiveMax;
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
        return "UserRecruitQuery {" +
                "recruitId = " + recruitId + 
				", recruitIdMin = " + recruitIdMin + 
				", recruitIdMax = " + recruitIdMax + 
				", recruitUserId = " + recruitUserId + 
				", recruitUserIdMin = " + recruitUserIdMin + 
				", recruitUserIdMax = " + recruitUserIdMax + 
				", recruitJobTitle = " + recruitJobTitle + 
				", recruitIsFulltime = " + recruitIsFulltime + 
				", recruitIsFulltimeMin = " + recruitIsFulltimeMin + 
				", recruitIsFulltimeMax = " + recruitIsFulltimeMax + 
				", recruitWorkYear = " + recruitWorkYear + 
				", recruitEducation = " + recruitEducation + 
				", recruitSalary = " + recruitSalary + 
				", recruitWorkAddr = " + recruitWorkAddr + 
				", recruitMemo = " + recruitMemo + 
				", recruitRecruitStatus = " + recruitRecruitStatus + 
				", recruitVersion = " + recruitVersion + 
				", recruitVersionMin = " + recruitVersionMin + 
				", recruitVersionMax = " + recruitVersionMax + 
				", recruitCreateTime = " + recruitCreateTime + 
				", recruitCreateTimeMin = " + recruitCreateTimeMin + 
				", recruitCreateTimeMax = " + recruitCreateTimeMax + 
				", recruitUpdateTime = " + recruitUpdateTime + 
				", recruitUpdateTimeMin = " + recruitUpdateTimeMin + 
				", recruitUpdateTimeMax = " + recruitUpdateTimeMax + 
				", recruitIsActive = " + recruitIsActive + 
				", recruitIsActiveMin = " + recruitIsActiveMin + 
				", recruitIsActiveMax = " + recruitIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				" }";
    }

}
