package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserBuilderDO数据对象实体类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserBuilderDO extends BaseDO {

    private static final long serialVersionUID = -9223372035066988437L;

    //t_builder表的字段对应的属性
	// 建造师编号
	private Long builderId;
	// 用户编号
	private Long builderUserId;
	// 姓名
	private String builderName;
	// 性别
	private Byte builderGender;
	// 出生年份
	private Date builderBirthday;
	// 证件地址
	private String builderCertificateAddress;
	// 证书类别
	private String builderCertificateType;
	// 证书专业类型
	private String builderCertificateMajorType;
	// 证书状态
	private String builderCertificateStatus;
	// 注册状态
	private String builderCertificateRegStatus;
	// 期望年薪
	private String builderSalary;
	// 手机号
	private String builderPhone;
	// 说明
	private String builderMemo;
	// 版本号
	private Integer builderVersion;
	// 创建时间
	private Date builderCreateTime;
	// 更新时间
	private Date builderUpdateTime;
	// 是否激活
	private Byte builderIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserBuilderDO () {}

    public UserBuilderDO (Long builderId, Long builderUserId, String builderName, Byte builderGender, Date builderBirthday, String builderCertificateAddress, String builderCertificateType, String builderCertificateMajorType, String builderCertificateStatus, String builderCertificateRegStatus, String builderSalary, String builderPhone, String builderMemo, Integer builderVersion, Date builderCreateTime, Date builderUpdateTime, Byte builderIsActive, String userDetailNickname, String userDetailHeadicon) {
        this.builderId = builderId;
		this.builderUserId = builderUserId;
		this.builderName = builderName;
		this.builderGender = builderGender;
		this.builderBirthday = builderBirthday;
		this.builderCertificateAddress = builderCertificateAddress;
		this.builderCertificateType = builderCertificateType;
		this.builderCertificateMajorType = builderCertificateMajorType;
		this.builderCertificateStatus = builderCertificateStatus;
		this.builderCertificateRegStatus = builderCertificateRegStatus;
		this.builderSalary = builderSalary;
		this.builderPhone = builderPhone;
		this.builderMemo = builderMemo;
		this.builderVersion = builderVersion;
		this.builderCreateTime = builderCreateTime;
		this.builderUpdateTime = builderUpdateTime;
		this.builderIsActive = builderIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getBuilderId() {
		return builderId;
	}

	public void setBuilderId(Long builderId) {
		this.builderId = builderId;
	}

	public Long getBuilderUserId() {
		return builderUserId;
	}

	public void setBuilderUserId(Long builderUserId) {
		this.builderUserId = builderUserId;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public Byte getBuilderGender() {
		return builderGender;
	}

	public void setBuilderGender(Byte builderGender) {
		this.builderGender = builderGender;
	}

	public Date getBuilderBirthday() {
		return builderBirthday;
	}

	public void setBuilderBirthday(Date builderBirthday) {
		this.builderBirthday = builderBirthday;
	}

	public String getBuilderCertificateAddress() {
		return builderCertificateAddress;
	}

	public void setBuilderCertificateAddress(String builderCertificateAddress) {
		this.builderCertificateAddress = builderCertificateAddress;
	}

	public String getBuilderCertificateType() {
		return builderCertificateType;
	}

	public void setBuilderCertificateType(String builderCertificateType) {
		this.builderCertificateType = builderCertificateType;
	}

	public String getBuilderCertificateMajorType() {
		return builderCertificateMajorType;
	}

	public void setBuilderCertificateMajorType(String builderCertificateMajorType) {
		this.builderCertificateMajorType = builderCertificateMajorType;
	}

	public String getBuilderCertificateStatus() {
		return builderCertificateStatus;
	}

	public void setBuilderCertificateStatus(String builderCertificateStatus) {
		this.builderCertificateStatus = builderCertificateStatus;
	}

	public String getBuilderCertificateRegStatus() {
		return builderCertificateRegStatus;
	}

	public void setBuilderCertificateRegStatus(String builderCertificateRegStatus) {
		this.builderCertificateRegStatus = builderCertificateRegStatus;
	}

	public String getBuilderSalary() {
		return builderSalary;
	}

	public void setBuilderSalary(String builderSalary) {
		this.builderSalary = builderSalary;
	}

	public String getBuilderPhone() {
		return builderPhone;
	}

	public void setBuilderPhone(String builderPhone) {
		this.builderPhone = builderPhone;
	}

	public String getBuilderMemo() {
		return builderMemo;
	}

	public void setBuilderMemo(String builderMemo) {
		this.builderMemo = builderMemo;
	}

	public Integer getBuilderVersion() {
		return builderVersion;
	}

	public void setBuilderVersion(Integer builderVersion) {
		this.builderVersion = builderVersion;
	}

	public Date getBuilderCreateTime() {
		return builderCreateTime;
	}

	public void setBuilderCreateTime(Date builderCreateTime) {
		this.builderCreateTime = builderCreateTime;
	}

	public Date getBuilderUpdateTime() {
		return builderUpdateTime;
	}

	public void setBuilderUpdateTime(Date builderUpdateTime) {
		this.builderUpdateTime = builderUpdateTime;
	}

	public Byte getBuilderIsActive() {
		return builderIsActive;
	}

	public void setBuilderIsActive(Byte builderIsActive) {
		this.builderIsActive = builderIsActive;
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
        return "UserBuilderDO {" +
                "builderId = " + builderId + 
				", builderUserId = " + builderUserId + 
				", builderName = " + builderName + 
				", builderGender = " + builderGender + 
				", builderBirthday = " + builderBirthday + 
				", builderCertificateAddress = " + builderCertificateAddress + 
				", builderCertificateType = " + builderCertificateType + 
				", builderCertificateMajorType = " + builderCertificateMajorType + 
				", builderCertificateStatus = " + builderCertificateStatus + 
				", builderCertificateRegStatus = " + builderCertificateRegStatus + 
				", builderSalary = " + builderSalary + 
				", builderPhone = " + builderPhone + 
				", builderMemo = " + builderMemo + 
				", builderVersion = " + builderVersion + 
				", builderCreateTime = " + builderCreateTime + 
				", builderUpdateTime = " + builderUpdateTime + 
				", builderIsActive = " + builderIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
