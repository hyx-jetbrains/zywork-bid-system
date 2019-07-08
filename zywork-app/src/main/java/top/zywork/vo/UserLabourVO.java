package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserLabourVO值对象类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserLabourVO extends BaseVO {

    private static final long serialVersionUID = -9223372036547722950L;

    //t_labour表的字段对应的属性
	// 劳务求职编号
	private Long labourId;
	// 用户编号
	private Long labourUserId;
	// 姓名
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String labourName;
	// 年龄
	private Integer labourAge;
	// 从事工种
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String labourWorkType;
	// 求职类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String labourJobType;
	// 工作地点
	@Size(min = 0, max = 30, message = "必须小于30个字符")
	private String labourWorkAddr;
	// 详细地址
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String labourAddrDesc;
	// 待遇要求
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String labourTreatment;
	// 联系电话
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String labourPhone;
	// 其他说明
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String labourMemo;
	// 版本号
	private Integer labourVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date labourUpdateTime;
	// 是否激活
	private Byte labourIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserLabourVO () {}

    public UserLabourVO (Long labourId, Long labourUserId, String labourName, Integer labourAge, String labourWorkType, String labourJobType, String labourWorkAddr, String labourAddrDesc, String labourTreatment, String labourPhone, String labourMemo, Integer labourVersion, Date labourCreateTime, Date labourUpdateTime, Byte labourIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.labourId = labourId;
		this.labourUserId = labourUserId;
		this.labourName = labourName;
		this.labourAge = labourAge;
		this.labourWorkType = labourWorkType;
		this.labourJobType = labourJobType;
		this.labourWorkAddr = labourWorkAddr;
		this.labourAddrDesc = labourAddrDesc;
		this.labourTreatment = labourTreatment;
		this.labourPhone = labourPhone;
		this.labourMemo = labourMemo;
		this.labourVersion = labourVersion;
		this.labourCreateTime = labourCreateTime;
		this.labourUpdateTime = labourUpdateTime;
		this.labourIsActive = labourIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getLabourId() {
		return labourId;
	}

	public void setLabourId(Long labourId) {
		this.labourId = labourId;
	}

	public Long getLabourUserId() {
		return labourUserId;
	}

	public void setLabourUserId(Long labourUserId) {
		this.labourUserId = labourUserId;
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

	public Date getLabourCreateTime() {
		return labourCreateTime;
	}

	public void setLabourCreateTime(Date labourCreateTime) {
		this.labourCreateTime = labourCreateTime;
	}

	public Date getLabourUpdateTime() {
		return labourUpdateTime;
	}

	public void setLabourUpdateTime(Date labourUpdateTime) {
		this.labourUpdateTime = labourUpdateTime;
	}

	public Byte getLabourIsActive() {
		return labourIsActive;
	}

	public void setLabourIsActive(Byte labourIsActive) {
		this.labourIsActive = labourIsActive;
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
        return "UserLabourVO {" +
                "labourId = " + labourId + 
				", labourUserId = " + labourUserId + 
				", labourName = " + labourName + 
				", labourAge = " + labourAge + 
				", labourWorkType = " + labourWorkType + 
				", labourJobType = " + labourJobType + 
				", labourWorkAddr = " + labourWorkAddr + 
				", labourAddrDesc = " + labourAddrDesc + 
				", labourTreatment = " + labourTreatment + 
				", labourPhone = " + labourPhone + 
				", labourMemo = " + labourMemo + 
				", labourVersion = " + labourVersion + 
				", labourCreateTime = " + labourCreateTime + 
				", labourUpdateTime = " + labourUpdateTime + 
				", labourIsActive = " + labourIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
