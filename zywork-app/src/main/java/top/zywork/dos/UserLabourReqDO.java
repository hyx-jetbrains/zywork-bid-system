package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserLabourReqDO数据对象实体类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserLabourReqDO extends BaseDO {

    private static final long serialVersionUID = -9223372036075094048L;

    //t_labour_req表的字段对应的属性
	// 劳务需求编号
	private Long labourReqId;
	// 用户编号
	private Long labourReqUserId;
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
	// 创建时间
	private Date labourReqCreateTime;
	// 更新时间
	private Date labourReqUpdateTime;
	// 是否激活
	private Byte labourReqIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserLabourReqDO () {}

    public UserLabourReqDO (Long labourReqId, Long labourReqUserId, String labourReqCompName, String labourReqWorkType, String labourReqJobType, String labourReqWorkAddr, String labourReqAddrDesc, String labourReqTreatment, String labourReqPhone, String labourReqMemo, Integer labourReqVersion, Date labourReqCreateTime, Date labourReqUpdateTime, Byte labourReqIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.labourReqId = labourReqId;
		this.labourReqUserId = labourReqUserId;
		this.labourReqCompName = labourReqCompName;
		this.labourReqWorkType = labourReqWorkType;
		this.labourReqJobType = labourReqJobType;
		this.labourReqWorkAddr = labourReqWorkAddr;
		this.labourReqAddrDesc = labourReqAddrDesc;
		this.labourReqTreatment = labourReqTreatment;
		this.labourReqPhone = labourReqPhone;
		this.labourReqMemo = labourReqMemo;
		this.labourReqVersion = labourReqVersion;
		this.labourReqCreateTime = labourReqCreateTime;
		this.labourReqUpdateTime = labourReqUpdateTime;
		this.labourReqIsActive = labourReqIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getLabourReqId() {
		return labourReqId;
	}

	public void setLabourReqId(Long labourReqId) {
		this.labourReqId = labourReqId;
	}

	public Long getLabourReqUserId() {
		return labourReqUserId;
	}

	public void setLabourReqUserId(Long labourReqUserId) {
		this.labourReqUserId = labourReqUserId;
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

	public Date getLabourReqCreateTime() {
		return labourReqCreateTime;
	}

	public void setLabourReqCreateTime(Date labourReqCreateTime) {
		this.labourReqCreateTime = labourReqCreateTime;
	}

	public Date getLabourReqUpdateTime() {
		return labourReqUpdateTime;
	}

	public void setLabourReqUpdateTime(Date labourReqUpdateTime) {
		this.labourReqUpdateTime = labourReqUpdateTime;
	}

	public Byte getLabourReqIsActive() {
		return labourReqIsActive;
	}

	public void setLabourReqIsActive(Byte labourReqIsActive) {
		this.labourReqIsActive = labourReqIsActive;
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

	
    @Override
    public String toString() {
        return "UserLabourReqDO {" +
                "labourReqId = " + labourReqId + 
				", labourReqUserId = " + labourReqUserId + 
				", labourReqCompName = " + labourReqCompName + 
				", labourReqWorkType = " + labourReqWorkType + 
				", labourReqJobType = " + labourReqJobType + 
				", labourReqWorkAddr = " + labourReqWorkAddr + 
				", labourReqAddrDesc = " + labourReqAddrDesc + 
				", labourReqTreatment = " + labourReqTreatment + 
				", labourReqPhone = " + labourReqPhone + 
				", labourReqMemo = " + labourReqMemo + 
				", labourReqVersion = " + labourReqVersion + 
				", labourReqCreateTime = " + labourReqCreateTime + 
				", labourReqUpdateTime = " + labourReqUpdateTime + 
				", labourReqIsActive = " + labourReqIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
