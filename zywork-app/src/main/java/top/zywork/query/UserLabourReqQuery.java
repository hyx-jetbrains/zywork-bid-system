package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserLabourReqQuery查询对象类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserLabourReqQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034942854269L;

    //t_labour_req表的字段对应的属性
	// 劳务需求编号
	private Long labourReqId;
	// 劳务需求编号（最小值）
	private Long labourReqIdMin;
	// 劳务需求编号（最大值）
	private Long labourReqIdMax;
	// 用户编号
	private Long labourReqUserId;
	// 用户编号（最小值）
	private Long labourReqUserIdMin;
	// 用户编号（最大值）
	private Long labourReqUserIdMax;
	// 企业名称
	private String labourReqCompName;
	// 从事工种
	private String labourReqWorkType;
	// 求职类型
	private String labourReqJobType;
	// 工作地点
	private String labourReqWorkAddr;
	// 详细地址
	private String labourReqAddrDesc;
	// 待遇要求
	private String labourReqTreatment;
	// 联系电话
	private String labourReqPhone;
	// 其他说明
	private String labourReqMemo;
	// 版本号
	private Integer labourReqVersion;
	// 版本号（最小值）
	private Integer labourReqVersionMin;
	// 版本号（最大值）
	private Integer labourReqVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqUpdateTimeMax;
	// 是否激活
	private Byte labourReqIsActive;
	// 是否激活（最小值）
	private Byte labourReqIsActiveMin;
	// 是否激活（最大值）
	private Byte labourReqIsActiveMax;
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
	
    public UserLabourReqQuery () {}

    public UserLabourReqQuery (Long labourReqId, Long labourReqIdMin, Long labourReqIdMax, Long labourReqUserId, Long labourReqUserIdMin, Long labourReqUserIdMax, String labourReqCompName, String labourReqWorkType, String labourReqJobType, String labourReqWorkAddr, String labourReqAddrDesc, String labourReqTreatment, String labourReqPhone, String labourReqMemo, Integer labourReqVersion, Integer labourReqVersionMin, Integer labourReqVersionMax, Date labourReqCreateTime, Date labourReqCreateTimeMin, Date labourReqCreateTimeMax, Date labourReqUpdateTime, Date labourReqUpdateTimeMin, Date labourReqUpdateTimeMax, Byte labourReqIsActive, Byte labourReqIsActiveMin, Byte labourReqIsActiveMax, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax) {
        this.labourReqId = labourReqId;
		this.labourReqIdMin = labourReqIdMin;
		this.labourReqIdMax = labourReqIdMax;
		this.labourReqUserId = labourReqUserId;
		this.labourReqUserIdMin = labourReqUserIdMin;
		this.labourReqUserIdMax = labourReqUserIdMax;
		this.labourReqCompName = labourReqCompName;
		this.labourReqWorkType = labourReqWorkType;
		this.labourReqJobType = labourReqJobType;
		this.labourReqWorkAddr = labourReqWorkAddr;
		this.labourReqAddrDesc = labourReqAddrDesc;
		this.labourReqTreatment = labourReqTreatment;
		this.labourReqPhone = labourReqPhone;
		this.labourReqMemo = labourReqMemo;
		this.labourReqVersion = labourReqVersion;
		this.labourReqVersionMin = labourReqVersionMin;
		this.labourReqVersionMax = labourReqVersionMax;
		this.labourReqCreateTime = labourReqCreateTime;
		this.labourReqCreateTimeMin = labourReqCreateTimeMin;
		this.labourReqCreateTimeMax = labourReqCreateTimeMax;
		this.labourReqUpdateTime = labourReqUpdateTime;
		this.labourReqUpdateTimeMin = labourReqUpdateTimeMin;
		this.labourReqUpdateTimeMax = labourReqUpdateTimeMax;
		this.labourReqIsActive = labourReqIsActive;
		this.labourReqIsActiveMin = labourReqIsActiveMin;
		this.labourReqIsActiveMax = labourReqIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		
    }

    public Long getLabourReqId() {
		return labourReqId;
	}

	public void setLabourReqId(Long labourReqId) {
		this.labourReqId = labourReqId;
	}

	public Long getLabourReqIdMin() {
		return labourReqIdMin;
	}

	public void setLabourReqIdMin(Long labourReqIdMin) {
		this.labourReqIdMin = labourReqIdMin;
	}

	public Long getLabourReqIdMax() {
		return labourReqIdMax;
	}

	public void setLabourReqIdMax(Long labourReqIdMax) {
		this.labourReqIdMax = labourReqIdMax;
	}

	public Long getLabourReqUserId() {
		return labourReqUserId;
	}

	public void setLabourReqUserId(Long labourReqUserId) {
		this.labourReqUserId = labourReqUserId;
	}

	public Long getLabourReqUserIdMin() {
		return labourReqUserIdMin;
	}

	public void setLabourReqUserIdMin(Long labourReqUserIdMin) {
		this.labourReqUserIdMin = labourReqUserIdMin;
	}

	public Long getLabourReqUserIdMax() {
		return labourReqUserIdMax;
	}

	public void setLabourReqUserIdMax(Long labourReqUserIdMax) {
		this.labourReqUserIdMax = labourReqUserIdMax;
	}

	public String getLabourReqCompName() {
		return labourReqCompName;
	}

	public void setLabourReqCompName(String labourReqCompName) {
		this.labourReqCompName = labourReqCompName;
	}

	public String getLabourReqWorkType() {
		return labourReqWorkType;
	}

	public void setLabourReqWorkType(String labourReqWorkType) {
		this.labourReqWorkType = labourReqWorkType;
	}

	public String getLabourReqJobType() {
		return labourReqJobType;
	}

	public void setLabourReqJobType(String labourReqJobType) {
		this.labourReqJobType = labourReqJobType;
	}

	public String getLabourReqWorkAddr() {
		return labourReqWorkAddr;
	}

	public void setLabourReqWorkAddr(String labourReqWorkAddr) {
		this.labourReqWorkAddr = labourReqWorkAddr;
	}

	public String getLabourReqAddrDesc() {
		return labourReqAddrDesc;
	}

	public void setLabourReqAddrDesc(String labourReqAddrDesc) {
		this.labourReqAddrDesc = labourReqAddrDesc;
	}

	public String getLabourReqTreatment() {
		return labourReqTreatment;
	}

	public void setLabourReqTreatment(String labourReqTreatment) {
		this.labourReqTreatment = labourReqTreatment;
	}

	public String getLabourReqPhone() {
		return labourReqPhone;
	}

	public void setLabourReqPhone(String labourReqPhone) {
		this.labourReqPhone = labourReqPhone;
	}

	public String getLabourReqMemo() {
		return labourReqMemo;
	}

	public void setLabourReqMemo(String labourReqMemo) {
		this.labourReqMemo = labourReqMemo;
	}

	public Integer getLabourReqVersion() {
		return labourReqVersion;
	}

	public void setLabourReqVersion(Integer labourReqVersion) {
		this.labourReqVersion = labourReqVersion;
	}

	public Integer getLabourReqVersionMin() {
		return labourReqVersionMin;
	}

	public void setLabourReqVersionMin(Integer labourReqVersionMin) {
		this.labourReqVersionMin = labourReqVersionMin;
	}

	public Integer getLabourReqVersionMax() {
		return labourReqVersionMax;
	}

	public void setLabourReqVersionMax(Integer labourReqVersionMax) {
		this.labourReqVersionMax = labourReqVersionMax;
	}

	public Date getLabourReqCreateTime() {
		return labourReqCreateTime;
	}

	public void setLabourReqCreateTime(Date labourReqCreateTime) {
		this.labourReqCreateTime = labourReqCreateTime;
	}

	public Date getLabourReqCreateTimeMin() {
		return labourReqCreateTimeMin;
	}

	public void setLabourReqCreateTimeMin(Date labourReqCreateTimeMin) {
		this.labourReqCreateTimeMin = labourReqCreateTimeMin;
	}

	public Date getLabourReqCreateTimeMax() {
		return labourReqCreateTimeMax;
	}

	public void setLabourReqCreateTimeMax(Date labourReqCreateTimeMax) {
		this.labourReqCreateTimeMax = labourReqCreateTimeMax;
	}

	public Date getLabourReqUpdateTime() {
		return labourReqUpdateTime;
	}

	public void setLabourReqUpdateTime(Date labourReqUpdateTime) {
		this.labourReqUpdateTime = labourReqUpdateTime;
	}

	public Date getLabourReqUpdateTimeMin() {
		return labourReqUpdateTimeMin;
	}

	public void setLabourReqUpdateTimeMin(Date labourReqUpdateTimeMin) {
		this.labourReqUpdateTimeMin = labourReqUpdateTimeMin;
	}

	public Date getLabourReqUpdateTimeMax() {
		return labourReqUpdateTimeMax;
	}

	public void setLabourReqUpdateTimeMax(Date labourReqUpdateTimeMax) {
		this.labourReqUpdateTimeMax = labourReqUpdateTimeMax;
	}

	public Byte getLabourReqIsActive() {
		return labourReqIsActive;
	}

	public void setLabourReqIsActive(Byte labourReqIsActive) {
		this.labourReqIsActive = labourReqIsActive;
	}

	public Byte getLabourReqIsActiveMin() {
		return labourReqIsActiveMin;
	}

	public void setLabourReqIsActiveMin(Byte labourReqIsActiveMin) {
		this.labourReqIsActiveMin = labourReqIsActiveMin;
	}

	public Byte getLabourReqIsActiveMax() {
		return labourReqIsActiveMax;
	}

	public void setLabourReqIsActiveMax(Byte labourReqIsActiveMax) {
		this.labourReqIsActiveMax = labourReqIsActiveMax;
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
        return "UserLabourReqQuery {" +
                "labourReqId = " + labourReqId + 
				", labourReqIdMin = " + labourReqIdMin + 
				", labourReqIdMax = " + labourReqIdMax + 
				", labourReqUserId = " + labourReqUserId + 
				", labourReqUserIdMin = " + labourReqUserIdMin + 
				", labourReqUserIdMax = " + labourReqUserIdMax + 
				", labourReqCompName = " + labourReqCompName + 
				", labourReqWorkType = " + labourReqWorkType + 
				", labourReqJobType = " + labourReqJobType + 
				", labourReqWorkAddr = " + labourReqWorkAddr + 
				", labourReqAddrDesc = " + labourReqAddrDesc + 
				", labourReqTreatment = " + labourReqTreatment + 
				", labourReqPhone = " + labourReqPhone + 
				", labourReqMemo = " + labourReqMemo + 
				", labourReqVersion = " + labourReqVersion + 
				", labourReqVersionMin = " + labourReqVersionMin + 
				", labourReqVersionMax = " + labourReqVersionMax + 
				", labourReqCreateTime = " + labourReqCreateTime + 
				", labourReqCreateTimeMin = " + labourReqCreateTimeMin + 
				", labourReqCreateTimeMax = " + labourReqCreateTimeMax + 
				", labourReqUpdateTime = " + labourReqUpdateTime + 
				", labourReqUpdateTimeMin = " + labourReqUpdateTimeMin + 
				", labourReqUpdateTimeMax = " + labourReqUpdateTimeMax + 
				", labourReqIsActive = " + labourReqIsActive + 
				", labourReqIsActiveMin = " + labourReqIsActiveMin + 
				", labourReqIsActiveMax = " + labourReqIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				" }";
    }

}
