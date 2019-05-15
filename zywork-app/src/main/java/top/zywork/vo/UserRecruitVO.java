package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserRecruitVO值对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserRecruitVO extends BaseVO {

    private static final long serialVersionUID = -9223372035822355208L;

    //t_recruit表的字段对应的属性
	// 招聘编号
	private Long recruitId;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long recruitUserId;
	// 招聘岗位
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String recruitJobTitle;
	// 是否全职
	@NotNull(message = "此项是必须项")
	private Byte recruitIsFulltime;
	// 工作时间（年）
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String recruitWorkYear;
	// 要求学历
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String recruitEducation;
	// 提供月薪
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String recruitSalary;
	// 工作地
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String recruitWorkAddr;
	// 职位描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String recruitMemo;
	// 版本号
	private Integer recruitVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recruitUpdateTime;
	// 是否激活
	private Byte recruitIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String userDetailHeadicon;
	
    public UserRecruitVO () {}

    public UserRecruitVO (Long recruitId, Long recruitUserId, String recruitJobTitle, Byte recruitIsFulltime, String recruitWorkYear, String recruitEducation, String recruitSalary, String recruitWorkAddr, String recruitMemo, Integer recruitVersion, Date recruitCreateTime, Date recruitUpdateTime, Byte recruitIsActive, String userDetailNickname, String userDetailHeadicon) {
        this.recruitId = recruitId;
		this.recruitUserId = recruitUserId;
		this.recruitJobTitle = recruitJobTitle;
		this.recruitIsFulltime = recruitIsFulltime;
		this.recruitWorkYear = recruitWorkYear;
		this.recruitEducation = recruitEducation;
		this.recruitSalary = recruitSalary;
		this.recruitWorkAddr = recruitWorkAddr;
		this.recruitMemo = recruitMemo;
		this.recruitVersion = recruitVersion;
		this.recruitCreateTime = recruitCreateTime;
		this.recruitUpdateTime = recruitUpdateTime;
		this.recruitIsActive = recruitIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getRecruitId() {
		return recruitId;
	}

	public void setRecruitId(Long recruitId) {
		this.recruitId = recruitId;
	}

	public Long getRecruitUserId() {
		return recruitUserId;
	}

	public void setRecruitUserId(Long recruitUserId) {
		this.recruitUserId = recruitUserId;
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

	public Integer getRecruitVersion() {
		return recruitVersion;
	}

	public void setRecruitVersion(Integer recruitVersion) {
		this.recruitVersion = recruitVersion;
	}

	public Date getRecruitCreateTime() {
		return recruitCreateTime;
	}

	public void setRecruitCreateTime(Date recruitCreateTime) {
		this.recruitCreateTime = recruitCreateTime;
	}

	public Date getRecruitUpdateTime() {
		return recruitUpdateTime;
	}

	public void setRecruitUpdateTime(Date recruitUpdateTime) {
		this.recruitUpdateTime = recruitUpdateTime;
	}

	public Byte getRecruitIsActive() {
		return recruitIsActive;
	}

	public void setRecruitIsActive(Byte recruitIsActive) {
		this.recruitIsActive = recruitIsActive;
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
        return "UserRecruitVO {" +
                "recruitId = " + recruitId + 
				", recruitUserId = " + recruitUserId + 
				", recruitJobTitle = " + recruitJobTitle + 
				", recruitIsFulltime = " + recruitIsFulltime + 
				", recruitWorkYear = " + recruitWorkYear + 
				", recruitEducation = " + recruitEducation + 
				", recruitSalary = " + recruitSalary + 
				", recruitWorkAddr = " + recruitWorkAddr + 
				", recruitMemo = " + recruitMemo + 
				", recruitVersion = " + recruitVersion + 
				", recruitCreateTime = " + recruitCreateTime + 
				", recruitUpdateTime = " + recruitUpdateTime + 
				", recruitIsActive = " + recruitIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
