package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserLabourQuery查询对象类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserLabourQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035803407807L;

    //t_labour表的字段对应的属性
	// 劳务求职编号
	private Long labourId;
	// 劳务求职编号（最小值）
	private Long labourIdMin;
	// 劳务求职编号（最大值）
	private Long labourIdMax;
	// 用户编号
	private Long labourUserId;
	// 用户编号（最小值）
	private Long labourUserIdMin;
	// 用户编号（最大值）
	private Long labourUserIdMax;
	// 姓名
	private String labourName;
	// 年龄
	private Integer labourAge;
	// 年龄（最小值）
	private Integer labourAgeMin;
	// 年龄（最大值）
	private Integer labourAgeMax;
	// 从事工种
	private String labourWorkType;
	// 求职类型
	private String labourJobType;
	// 工作地点
	private String labourWorkAddr;
	// 详细地址
	private String labourAddrDesc;
	// 待遇要求
	private String labourTreatment;
	// 联系电话
	private String labourPhone;
	// 其他说明
	private String labourMemo;
	// 版本号
	private Integer labourVersion;
	// 版本号（最小值）
	private Integer labourVersionMin;
	// 版本号（最大值）
	private Integer labourVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourUpdateTimeMax;
	// 是否激活
	private Byte labourIsActive;
	// 是否激活（最小值）
	private Byte labourIsActiveMin;
	// 是否激活（最大值）
	private Byte labourIsActiveMax;
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
	
    public UserLabourQuery () {}

    public UserLabourQuery (Long labourId, Long labourIdMin, Long labourIdMax, Long labourUserId, Long labourUserIdMin, Long labourUserIdMax, String labourName, Integer labourAge, Integer labourAgeMin, Integer labourAgeMax, String labourWorkType, String labourJobType, String labourWorkAddr, String labourAddrDesc, String labourTreatment, String labourPhone, String labourMemo, Integer labourVersion, Integer labourVersionMin, Integer labourVersionMax, Date labourCreateTime, Date labourCreateTimeMin, Date labourCreateTimeMax, Date labourUpdateTime, Date labourUpdateTimeMin, Date labourUpdateTimeMax, Byte labourIsActive, Byte labourIsActiveMin, Byte labourIsActiveMax, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax) {
        this.labourId = labourId;
		this.labourIdMin = labourIdMin;
		this.labourIdMax = labourIdMax;
		this.labourUserId = labourUserId;
		this.labourUserIdMin = labourUserIdMin;
		this.labourUserIdMax = labourUserIdMax;
		this.labourName = labourName;
		this.labourAge = labourAge;
		this.labourAgeMin = labourAgeMin;
		this.labourAgeMax = labourAgeMax;
		this.labourWorkType = labourWorkType;
		this.labourJobType = labourJobType;
		this.labourWorkAddr = labourWorkAddr;
		this.labourAddrDesc = labourAddrDesc;
		this.labourTreatment = labourTreatment;
		this.labourPhone = labourPhone;
		this.labourMemo = labourMemo;
		this.labourVersion = labourVersion;
		this.labourVersionMin = labourVersionMin;
		this.labourVersionMax = labourVersionMax;
		this.labourCreateTime = labourCreateTime;
		this.labourCreateTimeMin = labourCreateTimeMin;
		this.labourCreateTimeMax = labourCreateTimeMax;
		this.labourUpdateTime = labourUpdateTime;
		this.labourUpdateTimeMin = labourUpdateTimeMin;
		this.labourUpdateTimeMax = labourUpdateTimeMax;
		this.labourIsActive = labourIsActive;
		this.labourIsActiveMin = labourIsActiveMin;
		this.labourIsActiveMax = labourIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		
    }

    public Long getLabourId() {
		return labourId;
	}

	public void setLabourId(Long labourId) {
		this.labourId = labourId;
	}

	public Long getLabourIdMin() {
		return labourIdMin;
	}

	public void setLabourIdMin(Long labourIdMin) {
		this.labourIdMin = labourIdMin;
	}

	public Long getLabourIdMax() {
		return labourIdMax;
	}

	public void setLabourIdMax(Long labourIdMax) {
		this.labourIdMax = labourIdMax;
	}

	public Long getLabourUserId() {
		return labourUserId;
	}

	public void setLabourUserId(Long labourUserId) {
		this.labourUserId = labourUserId;
	}

	public Long getLabourUserIdMin() {
		return labourUserIdMin;
	}

	public void setLabourUserIdMin(Long labourUserIdMin) {
		this.labourUserIdMin = labourUserIdMin;
	}

	public Long getLabourUserIdMax() {
		return labourUserIdMax;
	}

	public void setLabourUserIdMax(Long labourUserIdMax) {
		this.labourUserIdMax = labourUserIdMax;
	}

	public String getLabourName() {
		return labourName;
	}

	public void setLabourName(String labourName) {
		this.labourName = labourName;
	}

	public Integer getLabourAge() {
		return labourAge;
	}

	public void setLabourAge(Integer labourAge) {
		this.labourAge = labourAge;
	}

	public Integer getLabourAgeMin() {
		return labourAgeMin;
	}

	public void setLabourAgeMin(Integer labourAgeMin) {
		this.labourAgeMin = labourAgeMin;
	}

	public Integer getLabourAgeMax() {
		return labourAgeMax;
	}

	public void setLabourAgeMax(Integer labourAgeMax) {
		this.labourAgeMax = labourAgeMax;
	}

	public String getLabourWorkType() {
		return labourWorkType;
	}

	public void setLabourWorkType(String labourWorkType) {
		this.labourWorkType = labourWorkType;
	}

	public String getLabourJobType() {
		return labourJobType;
	}

	public void setLabourJobType(String labourJobType) {
		this.labourJobType = labourJobType;
	}

	public String getLabourWorkAddr() {
		return labourWorkAddr;
	}

	public void setLabourWorkAddr(String labourWorkAddr) {
		this.labourWorkAddr = labourWorkAddr;
	}

	public String getLabourAddrDesc() {
		return labourAddrDesc;
	}

	public void setLabourAddrDesc(String labourAddrDesc) {
		this.labourAddrDesc = labourAddrDesc;
	}

	public String getLabourTreatment() {
		return labourTreatment;
	}

	public void setLabourTreatment(String labourTreatment) {
		this.labourTreatment = labourTreatment;
	}

	public String getLabourPhone() {
		return labourPhone;
	}

	public void setLabourPhone(String labourPhone) {
		this.labourPhone = labourPhone;
	}

	public String getLabourMemo() {
		return labourMemo;
	}

	public void setLabourMemo(String labourMemo) {
		this.labourMemo = labourMemo;
	}

	public Integer getLabourVersion() {
		return labourVersion;
	}

	public void setLabourVersion(Integer labourVersion) {
		this.labourVersion = labourVersion;
	}

	public Integer getLabourVersionMin() {
		return labourVersionMin;
	}

	public void setLabourVersionMin(Integer labourVersionMin) {
		this.labourVersionMin = labourVersionMin;
	}

	public Integer getLabourVersionMax() {
		return labourVersionMax;
	}

	public void setLabourVersionMax(Integer labourVersionMax) {
		this.labourVersionMax = labourVersionMax;
	}

	public Date getLabourCreateTime() {
		return labourCreateTime;
	}

	public void setLabourCreateTime(Date labourCreateTime) {
		this.labourCreateTime = labourCreateTime;
	}

	public Date getLabourCreateTimeMin() {
		return labourCreateTimeMin;
	}

	public void setLabourCreateTimeMin(Date labourCreateTimeMin) {
		this.labourCreateTimeMin = labourCreateTimeMin;
	}

	public Date getLabourCreateTimeMax() {
		return labourCreateTimeMax;
	}

	public void setLabourCreateTimeMax(Date labourCreateTimeMax) {
		this.labourCreateTimeMax = labourCreateTimeMax;
	}

	public Date getLabourUpdateTime() {
		return labourUpdateTime;
	}

	public void setLabourUpdateTime(Date labourUpdateTime) {
		this.labourUpdateTime = labourUpdateTime;
	}

	public Date getLabourUpdateTimeMin() {
		return labourUpdateTimeMin;
	}

	public void setLabourUpdateTimeMin(Date labourUpdateTimeMin) {
		this.labourUpdateTimeMin = labourUpdateTimeMin;
	}

	public Date getLabourUpdateTimeMax() {
		return labourUpdateTimeMax;
	}

	public void setLabourUpdateTimeMax(Date labourUpdateTimeMax) {
		this.labourUpdateTimeMax = labourUpdateTimeMax;
	}

	public Byte getLabourIsActive() {
		return labourIsActive;
	}

	public void setLabourIsActive(Byte labourIsActive) {
		this.labourIsActive = labourIsActive;
	}

	public Byte getLabourIsActiveMin() {
		return labourIsActiveMin;
	}

	public void setLabourIsActiveMin(Byte labourIsActiveMin) {
		this.labourIsActiveMin = labourIsActiveMin;
	}

	public Byte getLabourIsActiveMax() {
		return labourIsActiveMax;
	}

	public void setLabourIsActiveMax(Byte labourIsActiveMax) {
		this.labourIsActiveMax = labourIsActiveMax;
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
        return "UserLabourQuery {" +
                "labourId = " + labourId + 
				", labourIdMin = " + labourIdMin + 
				", labourIdMax = " + labourIdMax + 
				", labourUserId = " + labourUserId + 
				", labourUserIdMin = " + labourUserIdMin + 
				", labourUserIdMax = " + labourUserIdMax + 
				", labourName = " + labourName + 
				", labourAge = " + labourAge + 
				", labourAgeMin = " + labourAgeMin + 
				", labourAgeMax = " + labourAgeMax + 
				", labourWorkType = " + labourWorkType + 
				", labourJobType = " + labourJobType + 
				", labourWorkAddr = " + labourWorkAddr + 
				", labourAddrDesc = " + labourAddrDesc + 
				", labourTreatment = " + labourTreatment + 
				", labourPhone = " + labourPhone + 
				", labourMemo = " + labourMemo + 
				", labourVersion = " + labourVersion + 
				", labourVersionMin = " + labourVersionMin + 
				", labourVersionMax = " + labourVersionMax + 
				", labourCreateTime = " + labourCreateTime + 
				", labourCreateTimeMin = " + labourCreateTimeMin + 
				", labourCreateTimeMax = " + labourCreateTimeMax + 
				", labourUpdateTime = " + labourUpdateTime + 
				", labourUpdateTimeMin = " + labourUpdateTimeMin + 
				", labourUpdateTimeMax = " + labourUpdateTimeMax + 
				", labourIsActive = " + labourIsActive + 
				", labourIsActiveMin = " + labourIsActiveMin + 
				", labourIsActiveMax = " + labourIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				" }";
    }

}
