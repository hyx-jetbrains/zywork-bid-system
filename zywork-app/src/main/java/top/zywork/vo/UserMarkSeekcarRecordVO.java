package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMarkSeekcarRecordVO值对象类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMarkSeekcarRecordVO extends BaseVO {

    private static final long serialVersionUID = -9223372036346094792L;

    //t_mark_seekcar_record表的字段对应的属性
	// 拼车记录编号
	private Long markSeekcarRecordId;
	// 用户编号
	private Long markSeekcarRecordUserId;
	// 找车编号
	private Long markSeekcarRecordMarkSeekcarId;
	// 版本号
	private Integer markSeekcarRecordVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date markSeekcarRecordUpdateTime;
	// 是否激活
	private Byte markSeekcarRecordIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
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
	
    public UserMarkSeekcarRecordVO () {}

    public UserMarkSeekcarRecordVO (Long markSeekcarRecordId, Long markSeekcarRecordUserId, Long markSeekcarRecordMarkSeekcarId, Integer markSeekcarRecordVersion, Date markSeekcarRecordCreateTime, Date markSeekcarRecordUpdateTime, Byte markSeekcarRecordIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.markSeekcarRecordId = markSeekcarRecordId;
		this.markSeekcarRecordUserId = markSeekcarRecordUserId;
		this.markSeekcarRecordMarkSeekcarId = markSeekcarRecordMarkSeekcarId;
		this.markSeekcarRecordVersion = markSeekcarRecordVersion;
		this.markSeekcarRecordCreateTime = markSeekcarRecordCreateTime;
		this.markSeekcarRecordUpdateTime = markSeekcarRecordUpdateTime;
		this.markSeekcarRecordIsActive = markSeekcarRecordIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getMarkSeekcarRecordId() {
		return markSeekcarRecordId;
	}

	public void setMarkSeekcarRecordId(Long markSeekcarRecordId) {
		this.markSeekcarRecordId = markSeekcarRecordId;
	}

	public Long getMarkSeekcarRecordUserId() {
		return markSeekcarRecordUserId;
	}

	public void setMarkSeekcarRecordUserId(Long markSeekcarRecordUserId) {
		this.markSeekcarRecordUserId = markSeekcarRecordUserId;
	}

	public Long getMarkSeekcarRecordMarkSeekcarId() {
		return markSeekcarRecordMarkSeekcarId;
	}

	public void setMarkSeekcarRecordMarkSeekcarId(Long markSeekcarRecordMarkSeekcarId) {
		this.markSeekcarRecordMarkSeekcarId = markSeekcarRecordMarkSeekcarId;
	}

	public Integer getMarkSeekcarRecordVersion() {
		return markSeekcarRecordVersion;
	}

	public void setMarkSeekcarRecordVersion(Integer markSeekcarRecordVersion) {
		this.markSeekcarRecordVersion = markSeekcarRecordVersion;
	}

	public Date getMarkSeekcarRecordCreateTime() {
		return markSeekcarRecordCreateTime;
	}

	public void setMarkSeekcarRecordCreateTime(Date markSeekcarRecordCreateTime) {
		this.markSeekcarRecordCreateTime = markSeekcarRecordCreateTime;
	}

	public Date getMarkSeekcarRecordUpdateTime() {
		return markSeekcarRecordUpdateTime;
	}

	public void setMarkSeekcarRecordUpdateTime(Date markSeekcarRecordUpdateTime) {
		this.markSeekcarRecordUpdateTime = markSeekcarRecordUpdateTime;
	}

	public Byte getMarkSeekcarRecordIsActive() {
		return markSeekcarRecordIsActive;
	}

	public void setMarkSeekcarRecordIsActive(Byte markSeekcarRecordIsActive) {
		this.markSeekcarRecordIsActive = markSeekcarRecordIsActive;
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
        return "UserMarkSeekcarRecordVO {" +
                "markSeekcarRecordId = " + markSeekcarRecordId + 
				", markSeekcarRecordUserId = " + markSeekcarRecordUserId + 
				", markSeekcarRecordMarkSeekcarId = " + markSeekcarRecordMarkSeekcarId + 
				", markSeekcarRecordVersion = " + markSeekcarRecordVersion + 
				", markSeekcarRecordCreateTime = " + markSeekcarRecordCreateTime + 
				", markSeekcarRecordUpdateTime = " + markSeekcarRecordUpdateTime + 
				", markSeekcarRecordIsActive = " + markSeekcarRecordIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
