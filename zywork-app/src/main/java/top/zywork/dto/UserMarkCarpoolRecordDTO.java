package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserMarkCarpoolRecordDTO数据传输对象类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMarkCarpoolRecordDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372034813175955L;

    //t_mark_carpool_record表的字段对应的属性
	// 拼车记录编号
	private Long markCarpoolRecordId;
	// 用户编号
	private Long markCarpoolRecordUserId;
	// 拼车编号
	private Long markCarpoolRecordMarkCarpoolId;
	// 版本号
	private Integer markCarpoolRecordVersion;
	// 创建时间
	private Date markCarpoolRecordCreateTime;
	// 更新时间
	private Date markCarpoolRecordUpdateTime;
	// 是否激活
	private Byte markCarpoolRecordIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	// 手机号
	private String userPhone;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
    public UserMarkCarpoolRecordDTO () {}

    public UserMarkCarpoolRecordDTO (Long markCarpoolRecordId, Long markCarpoolRecordUserId, Long markCarpoolRecordMarkCarpoolId, Integer markCarpoolRecordVersion, Date markCarpoolRecordCreateTime, Date markCarpoolRecordUpdateTime, Byte markCarpoolRecordIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.markCarpoolRecordId = markCarpoolRecordId;
		this.markCarpoolRecordUserId = markCarpoolRecordUserId;
		this.markCarpoolRecordMarkCarpoolId = markCarpoolRecordMarkCarpoolId;
		this.markCarpoolRecordVersion = markCarpoolRecordVersion;
		this.markCarpoolRecordCreateTime = markCarpoolRecordCreateTime;
		this.markCarpoolRecordUpdateTime = markCarpoolRecordUpdateTime;
		this.markCarpoolRecordIsActive = markCarpoolRecordIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getMarkCarpoolRecordId() {
		return markCarpoolRecordId;
	}

	public void setMarkCarpoolRecordId(Long markCarpoolRecordId) {
		this.markCarpoolRecordId = markCarpoolRecordId;
	}

	public Long getMarkCarpoolRecordUserId() {
		return markCarpoolRecordUserId;
	}

	public void setMarkCarpoolRecordUserId(Long markCarpoolRecordUserId) {
		this.markCarpoolRecordUserId = markCarpoolRecordUserId;
	}

	public Long getMarkCarpoolRecordMarkCarpoolId() {
		return markCarpoolRecordMarkCarpoolId;
	}

	public void setMarkCarpoolRecordMarkCarpoolId(Long markCarpoolRecordMarkCarpoolId) {
		this.markCarpoolRecordMarkCarpoolId = markCarpoolRecordMarkCarpoolId;
	}

	public Integer getMarkCarpoolRecordVersion() {
		return markCarpoolRecordVersion;
	}

	public void setMarkCarpoolRecordVersion(Integer markCarpoolRecordVersion) {
		this.markCarpoolRecordVersion = markCarpoolRecordVersion;
	}

	public Date getMarkCarpoolRecordCreateTime() {
		return markCarpoolRecordCreateTime;
	}

	public void setMarkCarpoolRecordCreateTime(Date markCarpoolRecordCreateTime) {
		this.markCarpoolRecordCreateTime = markCarpoolRecordCreateTime;
	}

	public Date getMarkCarpoolRecordUpdateTime() {
		return markCarpoolRecordUpdateTime;
	}

	public void setMarkCarpoolRecordUpdateTime(Date markCarpoolRecordUpdateTime) {
		this.markCarpoolRecordUpdateTime = markCarpoolRecordUpdateTime;
	}

	public Byte getMarkCarpoolRecordIsActive() {
		return markCarpoolRecordIsActive;
	}

	public void setMarkCarpoolRecordIsActive(Byte markCarpoolRecordIsActive) {
		this.markCarpoolRecordIsActive = markCarpoolRecordIsActive;
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
        return "UserMarkCarpoolRecordDTO {" +
                "markCarpoolRecordId = " + markCarpoolRecordId + 
				", markCarpoolRecordUserId = " + markCarpoolRecordUserId + 
				", markCarpoolRecordMarkCarpoolId = " + markCarpoolRecordMarkCarpoolId + 
				", markCarpoolRecordVersion = " + markCarpoolRecordVersion + 
				", markCarpoolRecordCreateTime = " + markCarpoolRecordCreateTime + 
				", markCarpoolRecordUpdateTime = " + markCarpoolRecordUpdateTime + 
				", markCarpoolRecordIsActive = " + markCarpoolRecordIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
