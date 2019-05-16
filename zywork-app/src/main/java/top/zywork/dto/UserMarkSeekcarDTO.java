package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserMarkSeekcarDTO数据传输对象类<br/>
 *
 * 创建于2019-05-16<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMarkSeekcarDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036244114439L;

    //t_mark_seekcar表的字段对应的属性
	// 开标找车编号
	private Long markSeekcarId;
	// 用户编号
	private Long markSeekcarUserId;
	// 项目编号
	private Long markSeekcarProjectId;
	// 出发城市
	private String markSeekcarStartCity;
	// 出发地点
	private String markSeekcarStartAddr;
	// 目的地城市
	private String markSeekcarEndCity;
	// 目的地
	private String markSeekcarEndAddr;
	// 出发时间
	private Date markSeekcarStartTime;
	// 联系人姓名
	private String markSeekcarName;
	// 联系人电话
	private String markSeekcarPhone;
	// 备注
	private String markSeekcarMemo;
	// 申请人数
	private Integer markSeekcarRecordCount;
	// 版本号
	private Integer markSeekcarVersion;
	// 创建时间
	private Date markSeekcarCreateTime;
	// 更新时间
	private Date markSeekcarUpdateTime;
	// 是否激活
	private Byte markSeekcarIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserMarkSeekcarDTO () {}

    public UserMarkSeekcarDTO (Long markSeekcarId, Long markSeekcarUserId, Long markSeekcarProjectId, String markSeekcarStartCity, String markSeekcarStartAddr, String markSeekcarEndCity, String markSeekcarEndAddr, Date markSeekcarStartTime, String markSeekcarName, String markSeekcarPhone, String markSeekcarMemo, Integer markSeekcarRecordCount, Integer markSeekcarVersion, Date markSeekcarCreateTime, Date markSeekcarUpdateTime, Byte markSeekcarIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.markSeekcarId = markSeekcarId;
		this.markSeekcarUserId = markSeekcarUserId;
		this.markSeekcarProjectId = markSeekcarProjectId;
		this.markSeekcarStartCity = markSeekcarStartCity;
		this.markSeekcarStartAddr = markSeekcarStartAddr;
		this.markSeekcarEndCity = markSeekcarEndCity;
		this.markSeekcarEndAddr = markSeekcarEndAddr;
		this.markSeekcarStartTime = markSeekcarStartTime;
		this.markSeekcarName = markSeekcarName;
		this.markSeekcarPhone = markSeekcarPhone;
		this.markSeekcarMemo = markSeekcarMemo;
		this.markSeekcarRecordCount = markSeekcarRecordCount;
		this.markSeekcarVersion = markSeekcarVersion;
		this.markSeekcarCreateTime = markSeekcarCreateTime;
		this.markSeekcarUpdateTime = markSeekcarUpdateTime;
		this.markSeekcarIsActive = markSeekcarIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getMarkSeekcarId() {
		return markSeekcarId;
	}

	public void setMarkSeekcarId(Long markSeekcarId) {
		this.markSeekcarId = markSeekcarId;
	}

	public Long getMarkSeekcarUserId() {
		return markSeekcarUserId;
	}

	public void setMarkSeekcarUserId(Long markSeekcarUserId) {
		this.markSeekcarUserId = markSeekcarUserId;
	}

	public Long getMarkSeekcarProjectId() {
		return markSeekcarProjectId;
	}

	public void setMarkSeekcarProjectId(Long markSeekcarProjectId) {
		this.markSeekcarProjectId = markSeekcarProjectId;
	}

	public String getMarkSeekcarStartCity() {
		return markSeekcarStartCity;
	}

	public void setMarkSeekcarStartCity(String markSeekcarStartCity) {
		this.markSeekcarStartCity = markSeekcarStartCity;
	}

	public String getMarkSeekcarStartAddr() {
		return markSeekcarStartAddr;
	}

	public void setMarkSeekcarStartAddr(String markSeekcarStartAddr) {
		this.markSeekcarStartAddr = markSeekcarStartAddr;
	}

	public String getMarkSeekcarEndCity() {
		return markSeekcarEndCity;
	}

	public void setMarkSeekcarEndCity(String markSeekcarEndCity) {
		this.markSeekcarEndCity = markSeekcarEndCity;
	}

	public String getMarkSeekcarEndAddr() {
		return markSeekcarEndAddr;
	}

	public void setMarkSeekcarEndAddr(String markSeekcarEndAddr) {
		this.markSeekcarEndAddr = markSeekcarEndAddr;
	}

	public Date getMarkSeekcarStartTime() {
		return markSeekcarStartTime;
	}

	public void setMarkSeekcarStartTime(Date markSeekcarStartTime) {
		this.markSeekcarStartTime = markSeekcarStartTime;
	}

	public String getMarkSeekcarName() {
		return markSeekcarName;
	}

	public void setMarkSeekcarName(String markSeekcarName) {
		this.markSeekcarName = markSeekcarName;
	}

	public String getMarkSeekcarPhone() {
		return markSeekcarPhone;
	}

	public void setMarkSeekcarPhone(String markSeekcarPhone) {
		this.markSeekcarPhone = markSeekcarPhone;
	}

	public String getMarkSeekcarMemo() {
		return markSeekcarMemo;
	}

	public void setMarkSeekcarMemo(String markSeekcarMemo) {
		this.markSeekcarMemo = markSeekcarMemo;
	}

	public Integer getMarkSeekcarRecordCount() {
		return markSeekcarRecordCount;
	}

	public void setMarkSeekcarRecordCount(Integer markSeekcarRecordCount) {
		this.markSeekcarRecordCount = markSeekcarRecordCount;
	}

	public Integer getMarkSeekcarVersion() {
		return markSeekcarVersion;
	}

	public void setMarkSeekcarVersion(Integer markSeekcarVersion) {
		this.markSeekcarVersion = markSeekcarVersion;
	}

	public Date getMarkSeekcarCreateTime() {
		return markSeekcarCreateTime;
	}

	public void setMarkSeekcarCreateTime(Date markSeekcarCreateTime) {
		this.markSeekcarCreateTime = markSeekcarCreateTime;
	}

	public Date getMarkSeekcarUpdateTime() {
		return markSeekcarUpdateTime;
	}

	public void setMarkSeekcarUpdateTime(Date markSeekcarUpdateTime) {
		this.markSeekcarUpdateTime = markSeekcarUpdateTime;
	}

	public Byte getMarkSeekcarIsActive() {
		return markSeekcarIsActive;
	}

	public void setMarkSeekcarIsActive(Byte markSeekcarIsActive) {
		this.markSeekcarIsActive = markSeekcarIsActive;
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
        return "UserMarkSeekcarDTO {" +
                "markSeekcarId = " + markSeekcarId + 
				", markSeekcarUserId = " + markSeekcarUserId + 
				", markSeekcarProjectId = " + markSeekcarProjectId + 
				", markSeekcarStartCity = " + markSeekcarStartCity + 
				", markSeekcarStartAddr = " + markSeekcarStartAddr + 
				", markSeekcarEndCity = " + markSeekcarEndCity + 
				", markSeekcarEndAddr = " + markSeekcarEndAddr + 
				", markSeekcarStartTime = " + markSeekcarStartTime + 
				", markSeekcarName = " + markSeekcarName + 
				", markSeekcarPhone = " + markSeekcarPhone + 
				", markSeekcarMemo = " + markSeekcarMemo + 
				", markSeekcarRecordCount = " + markSeekcarRecordCount + 
				", markSeekcarVersion = " + markSeekcarVersion + 
				", markSeekcarCreateTime = " + markSeekcarCreateTime + 
				", markSeekcarUpdateTime = " + markSeekcarUpdateTime + 
				", markSeekcarIsActive = " + markSeekcarIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
