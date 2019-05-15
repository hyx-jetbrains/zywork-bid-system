package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserBuilderQuery查询对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserBuilderQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036134176769L;

    //t_builder表的字段对应的属性
	// 建造师编号
	private Long builderId;
	// 建造师编号（最小值）
	private Long builderIdMin;
	// 建造师编号（最大值）
	private Long builderIdMax;
	// 用户编号
	private Long builderUserId;
	// 用户编号（最小值）
	private Long builderUserIdMin;
	// 用户编号（最大值）
	private Long builderUserIdMax;
	// 姓名
	private String builderName;
	// 性别
	private Byte builderGender;
	// 性别（最小值）
	private Byte builderGenderMin;
	// 性别（最大值）
	private Byte builderGenderMax;
	// 出生年份
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderBirthday;
	// 出生年份（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderBirthdayMin;
	// 出生年份（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderBirthdayMax;
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
	// 版本号（最小值）
	private Integer builderVersionMin;
	// 版本号（最大值）
	private Integer builderVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderUpdateTimeMax;
	// 是否激活
	private Byte builderIsActive;
	// 是否激活（最小值）
	private Byte builderIsActiveMin;
	// 是否激活（最大值）
	private Byte builderIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserBuilderQuery () {}

    public UserBuilderQuery (Long builderId, Long builderIdMin, Long builderIdMax, Long builderUserId, Long builderUserIdMin, Long builderUserIdMax, String builderName, Byte builderGender, Byte builderGenderMin, Byte builderGenderMax, Date builderBirthday, Date builderBirthdayMin, Date builderBirthdayMax, String builderCertificateAddress, String builderCertificateType, String builderCertificateMajorType, String builderCertificateStatus, String builderCertificateRegStatus, String builderSalary, String builderPhone, String builderMemo, Integer builderVersion, Integer builderVersionMin, Integer builderVersionMax, Date builderCreateTime, Date builderCreateTimeMin, Date builderCreateTimeMax, Date builderUpdateTime, Date builderUpdateTimeMin, Date builderUpdateTimeMax, Byte builderIsActive, Byte builderIsActiveMin, Byte builderIsActiveMax, String userDetailNickname, String userDetailHeadicon) {
        this.builderId = builderId;
		this.builderIdMin = builderIdMin;
		this.builderIdMax = builderIdMax;
		this.builderUserId = builderUserId;
		this.builderUserIdMin = builderUserIdMin;
		this.builderUserIdMax = builderUserIdMax;
		this.builderName = builderName;
		this.builderGender = builderGender;
		this.builderGenderMin = builderGenderMin;
		this.builderGenderMax = builderGenderMax;
		this.builderBirthday = builderBirthday;
		this.builderBirthdayMin = builderBirthdayMin;
		this.builderBirthdayMax = builderBirthdayMax;
		this.builderCertificateAddress = builderCertificateAddress;
		this.builderCertificateType = builderCertificateType;
		this.builderCertificateMajorType = builderCertificateMajorType;
		this.builderCertificateStatus = builderCertificateStatus;
		this.builderCertificateRegStatus = builderCertificateRegStatus;
		this.builderSalary = builderSalary;
		this.builderPhone = builderPhone;
		this.builderMemo = builderMemo;
		this.builderVersion = builderVersion;
		this.builderVersionMin = builderVersionMin;
		this.builderVersionMax = builderVersionMax;
		this.builderCreateTime = builderCreateTime;
		this.builderCreateTimeMin = builderCreateTimeMin;
		this.builderCreateTimeMax = builderCreateTimeMax;
		this.builderUpdateTime = builderUpdateTime;
		this.builderUpdateTimeMin = builderUpdateTimeMin;
		this.builderUpdateTimeMax = builderUpdateTimeMax;
		this.builderIsActive = builderIsActive;
		this.builderIsActiveMin = builderIsActiveMin;
		this.builderIsActiveMax = builderIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getBuilderId() {
		return builderId;
	}

	public void setBuilderId(Long builderId) {
		this.builderId = builderId;
	}

	public Long getBuilderIdMin() {
		return builderIdMin;
	}

	public void setBuilderIdMin(Long builderIdMin) {
		this.builderIdMin = builderIdMin;
	}

	public Long getBuilderIdMax() {
		return builderIdMax;
	}

	public void setBuilderIdMax(Long builderIdMax) {
		this.builderIdMax = builderIdMax;
	}

	public Long getBuilderUserId() {
		return builderUserId;
	}

	public void setBuilderUserId(Long builderUserId) {
		this.builderUserId = builderUserId;
	}

	public Long getBuilderUserIdMin() {
		return builderUserIdMin;
	}

	public void setBuilderUserIdMin(Long builderUserIdMin) {
		this.builderUserIdMin = builderUserIdMin;
	}

	public Long getBuilderUserIdMax() {
		return builderUserIdMax;
	}

	public void setBuilderUserIdMax(Long builderUserIdMax) {
		this.builderUserIdMax = builderUserIdMax;
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

	public Byte getBuilderGenderMin() {
		return builderGenderMin;
	}

	public void setBuilderGenderMin(Byte builderGenderMin) {
		this.builderGenderMin = builderGenderMin;
	}

	public Byte getBuilderGenderMax() {
		return builderGenderMax;
	}

	public void setBuilderGenderMax(Byte builderGenderMax) {
		this.builderGenderMax = builderGenderMax;
	}

	public Date getBuilderBirthday() {
		return builderBirthday;
	}

	public void setBuilderBirthday(Date builderBirthday) {
		this.builderBirthday = builderBirthday;
	}

	public Date getBuilderBirthdayMin() {
		return builderBirthdayMin;
	}

	public void setBuilderBirthdayMin(Date builderBirthdayMin) {
		this.builderBirthdayMin = builderBirthdayMin;
	}

	public Date getBuilderBirthdayMax() {
		return builderBirthdayMax;
	}

	public void setBuilderBirthdayMax(Date builderBirthdayMax) {
		this.builderBirthdayMax = builderBirthdayMax;
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

	public Integer getBuilderVersionMin() {
		return builderVersionMin;
	}

	public void setBuilderVersionMin(Integer builderVersionMin) {
		this.builderVersionMin = builderVersionMin;
	}

	public Integer getBuilderVersionMax() {
		return builderVersionMax;
	}

	public void setBuilderVersionMax(Integer builderVersionMax) {
		this.builderVersionMax = builderVersionMax;
	}

	public Date getBuilderCreateTime() {
		return builderCreateTime;
	}

	public void setBuilderCreateTime(Date builderCreateTime) {
		this.builderCreateTime = builderCreateTime;
	}

	public Date getBuilderCreateTimeMin() {
		return builderCreateTimeMin;
	}

	public void setBuilderCreateTimeMin(Date builderCreateTimeMin) {
		this.builderCreateTimeMin = builderCreateTimeMin;
	}

	public Date getBuilderCreateTimeMax() {
		return builderCreateTimeMax;
	}

	public void setBuilderCreateTimeMax(Date builderCreateTimeMax) {
		this.builderCreateTimeMax = builderCreateTimeMax;
	}

	public Date getBuilderUpdateTime() {
		return builderUpdateTime;
	}

	public void setBuilderUpdateTime(Date builderUpdateTime) {
		this.builderUpdateTime = builderUpdateTime;
	}

	public Date getBuilderUpdateTimeMin() {
		return builderUpdateTimeMin;
	}

	public void setBuilderUpdateTimeMin(Date builderUpdateTimeMin) {
		this.builderUpdateTimeMin = builderUpdateTimeMin;
	}

	public Date getBuilderUpdateTimeMax() {
		return builderUpdateTimeMax;
	}

	public void setBuilderUpdateTimeMax(Date builderUpdateTimeMax) {
		this.builderUpdateTimeMax = builderUpdateTimeMax;
	}

	public Byte getBuilderIsActive() {
		return builderIsActive;
	}

	public void setBuilderIsActive(Byte builderIsActive) {
		this.builderIsActive = builderIsActive;
	}

	public Byte getBuilderIsActiveMin() {
		return builderIsActiveMin;
	}

	public void setBuilderIsActiveMin(Byte builderIsActiveMin) {
		this.builderIsActiveMin = builderIsActiveMin;
	}

	public Byte getBuilderIsActiveMax() {
		return builderIsActiveMax;
	}

	public void setBuilderIsActiveMax(Byte builderIsActiveMax) {
		this.builderIsActiveMax = builderIsActiveMax;
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
        return "UserBuilderQuery {" +
                "builderId = " + builderId + 
				", builderIdMin = " + builderIdMin + 
				", builderIdMax = " + builderIdMax + 
				", builderUserId = " + builderUserId + 
				", builderUserIdMin = " + builderUserIdMin + 
				", builderUserIdMax = " + builderUserIdMax + 
				", builderName = " + builderName + 
				", builderGender = " + builderGender + 
				", builderGenderMin = " + builderGenderMin + 
				", builderGenderMax = " + builderGenderMax + 
				", builderBirthday = " + builderBirthday + 
				", builderBirthdayMin = " + builderBirthdayMin + 
				", builderBirthdayMax = " + builderBirthdayMax + 
				", builderCertificateAddress = " + builderCertificateAddress + 
				", builderCertificateType = " + builderCertificateType + 
				", builderCertificateMajorType = " + builderCertificateMajorType + 
				", builderCertificateStatus = " + builderCertificateStatus + 
				", builderCertificateRegStatus = " + builderCertificateRegStatus + 
				", builderSalary = " + builderSalary + 
				", builderPhone = " + builderPhone + 
				", builderMemo = " + builderMemo + 
				", builderVersion = " + builderVersion + 
				", builderVersionMin = " + builderVersionMin + 
				", builderVersionMax = " + builderVersionMax + 
				", builderCreateTime = " + builderCreateTime + 
				", builderCreateTimeMin = " + builderCreateTimeMin + 
				", builderCreateTimeMax = " + builderCreateTimeMax + 
				", builderUpdateTime = " + builderUpdateTime + 
				", builderUpdateTimeMin = " + builderUpdateTimeMin + 
				", builderUpdateTimeMax = " + builderUpdateTimeMax + 
				", builderIsActive = " + builderIsActive + 
				", builderIsActiveMin = " + builderIsActiveMin + 
				", builderIsActiveMax = " + builderIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
