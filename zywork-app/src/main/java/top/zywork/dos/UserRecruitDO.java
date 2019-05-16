package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserRecruitDO数据对象实体类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserRecruitDO extends BaseDO {

    private static final long serialVersionUID = -9223372036594742257L;

    //t_recruit表的字段对应的属性
	// 招聘编号
	private Long recruitId;
	// 用户编号
	private Long recruitUserId;
	// 招聘岗位
	private String recruitJobTitle;
	// 是否全职
	private Byte recruitIsFulltime;
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
	// 版本号
	private Integer recruitVersion;
	// 创建时间
	private Date recruitCreateTime;
	// 更新时间
	private Date recruitUpdateTime;
	// 是否激活
	private Byte recruitIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserRecruitDO () {}

    public UserRecruitDO (Long recruitId, Long recruitUserId, String recruitJobTitle, Byte recruitIsFulltime, String recruitWorkYear, String recruitEducation, String recruitSalary, String recruitWorkAddr, String recruitMemo, Integer recruitVersion, Date recruitCreateTime, Date recruitUpdateTime, Byte recruitIsActive, String userDetailNickname, String userDetailHeadicon) {
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
        return "UserRecruitDO {" +
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