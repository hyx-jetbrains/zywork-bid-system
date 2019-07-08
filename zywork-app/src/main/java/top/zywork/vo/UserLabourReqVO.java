package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserLabourReqVO值对象类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserLabourReqVO extends BaseVO {

    private static final long serialVersionUID = -9223372035864508075L;

    //t_labour_req表的字段对应的属性
	// 劳务需求编号
	private Long labourReqId;
	// 用户编号
	private Long labourReqUserId;
	// 企业名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 300, message = "必须是1-300个字符")
	private String labourReqCompName;
	// 从事工种
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String labourReqWorkType;
	// 求职类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String labourReqJobType;
	// 工作地点
	@Size(min = 0, max = 30, message = "必须小于30个字符")
	private String labourReqWorkAddr;
	// 详细地址
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String labourReqAddrDesc;
	// 待遇要求
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String labourReqTreatment;
	// 联系电话
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String labourReqPhone;
	// 其他说明
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String labourReqMemo;
	// 版本号
	private Integer labourReqVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourReqUpdateTime;
	// 是否激活
	private Byte labourReqIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserLabourReqVO () {}

    public UserLabourReqVO (Long labourReqId, Long labourReqUserId, String labourReqCompName, String labourReqWorkType, String labourReqJobType, String labourReqWorkAddr, String labourReqAddrDesc, String labourReqTreatment, String labourReqPhone, String labourReqMemo, Integer labourReqVersion, Date labourReqCreateTime, Date labourReqUpdateTime, Byte labourReqIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
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
        return "UserLabourReqVO {" +
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
