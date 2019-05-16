package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserMarkCarpoolDTO数据传输对象类<br/>
 *
 * 创建于2019-05-16<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMarkCarpoolDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035475706149L;

    //t_mark_carpool表的字段对应的属性
	// 开标拼车编号
	private Long markCarpoolId;
	// 用户编号
	private Long markCarpoolUserId;
	// 项目编号
	private Long markCarpoolProjectId;
	// 出发城市
	private String markCarpoolStartCity;
	// 出发地点
	private String markCarpoolStartAddr;
	// 目的地城市
	private String markCarpoolEndCity;
	// 目的地
	private String markCarpoolEndAddr;
	// 出发时间
	private Date markCarpoolStartTime;
	// 汽车类型
	private String markCarpoolCarType;
	// 搭载人数
	private Integer markCarpoolPeopleCount;
	// 申请人数
	private Integer markCarpoolRecordCount;
	// 价格
	private Long markCarpoolPrice;
	// 联系人姓名
	private String markCarpoolName;
	// 联系人电话
	private String markCarpoolPhone;
	// 版本号
	private Integer markCarpoolVersion;
	// 创建时间
	private Date markCarpoolCreateTime;
	// 更新时间
	private Date markCarpoolUpdateTime;
	// 是否激活
	private Byte markCarpoolIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 性别
	private Byte userDetailGender;
	
    public UserMarkCarpoolDTO () {}

    public UserMarkCarpoolDTO (Long markCarpoolId, Long markCarpoolUserId, Long markCarpoolProjectId, String markCarpoolStartCity, String markCarpoolStartAddr, String markCarpoolEndCity, String markCarpoolEndAddr, Date markCarpoolStartTime, String markCarpoolCarType, Integer markCarpoolPeopleCount, Integer markCarpoolRecordCount, Long markCarpoolPrice, String markCarpoolName, String markCarpoolPhone, Integer markCarpoolVersion, Date markCarpoolCreateTime, Date markCarpoolUpdateTime, Byte markCarpoolIsActive, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender) {
        this.markCarpoolId = markCarpoolId;
		this.markCarpoolUserId = markCarpoolUserId;
		this.markCarpoolProjectId = markCarpoolProjectId;
		this.markCarpoolStartCity = markCarpoolStartCity;
		this.markCarpoolStartAddr = markCarpoolStartAddr;
		this.markCarpoolEndCity = markCarpoolEndCity;
		this.markCarpoolEndAddr = markCarpoolEndAddr;
		this.markCarpoolStartTime = markCarpoolStartTime;
		this.markCarpoolCarType = markCarpoolCarType;
		this.markCarpoolPeopleCount = markCarpoolPeopleCount;
		this.markCarpoolRecordCount = markCarpoolRecordCount;
		this.markCarpoolPrice = markCarpoolPrice;
		this.markCarpoolName = markCarpoolName;
		this.markCarpoolPhone = markCarpoolPhone;
		this.markCarpoolVersion = markCarpoolVersion;
		this.markCarpoolCreateTime = markCarpoolCreateTime;
		this.markCarpoolUpdateTime = markCarpoolUpdateTime;
		this.markCarpoolIsActive = markCarpoolIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailGender = userDetailGender;
		
    }

    public Long getMarkCarpoolId() {
		return markCarpoolId;
	}

	public void setMarkCarpoolId(Long markCarpoolId) {
		this.markCarpoolId = markCarpoolId;
	}

	public Long getMarkCarpoolUserId() {
		return markCarpoolUserId;
	}

	public void setMarkCarpoolUserId(Long markCarpoolUserId) {
		this.markCarpoolUserId = markCarpoolUserId;
	}

	public Long getMarkCarpoolProjectId() {
		return markCarpoolProjectId;
	}

	public void setMarkCarpoolProjectId(Long markCarpoolProjectId) {
		this.markCarpoolProjectId = markCarpoolProjectId;
	}

	public String getMarkCarpoolStartCity() {
		return markCarpoolStartCity;
	}

	public void setMarkCarpoolStartCity(String markCarpoolStartCity) {
		this.markCarpoolStartCity = markCarpoolStartCity;
	}

	public String getMarkCarpoolStartAddr() {
		return markCarpoolStartAddr;
	}

	public void setMarkCarpoolStartAddr(String markCarpoolStartAddr) {
		this.markCarpoolStartAddr = markCarpoolStartAddr;
	}

	public String getMarkCarpoolEndCity() {
		return markCarpoolEndCity;
	}

	public void setMarkCarpoolEndCity(String markCarpoolEndCity) {
		this.markCarpoolEndCity = markCarpoolEndCity;
	}

	public String getMarkCarpoolEndAddr() {
		return markCarpoolEndAddr;
	}

	public void setMarkCarpoolEndAddr(String markCarpoolEndAddr) {
		this.markCarpoolEndAddr = markCarpoolEndAddr;
	}

	public Date getMarkCarpoolStartTime() {
		return markCarpoolStartTime;
	}

	public void setMarkCarpoolStartTime(Date markCarpoolStartTime) {
		this.markCarpoolStartTime = markCarpoolStartTime;
	}

	public String getMarkCarpoolCarType() {
		return markCarpoolCarType;
	}

	public void setMarkCarpoolCarType(String markCarpoolCarType) {
		this.markCarpoolCarType = markCarpoolCarType;
	}

	public Integer getMarkCarpoolPeopleCount() {
		return markCarpoolPeopleCount;
	}

	public void setMarkCarpoolPeopleCount(Integer markCarpoolPeopleCount) {
		this.markCarpoolPeopleCount = markCarpoolPeopleCount;
	}

	public Integer getMarkCarpoolRecordCount() {
		return markCarpoolRecordCount;
	}

	public void setMarkCarpoolRecordCount(Integer markCarpoolRecordCount) {
		this.markCarpoolRecordCount = markCarpoolRecordCount;
	}

	public Long getMarkCarpoolPrice() {
		return markCarpoolPrice;
	}

	public void setMarkCarpoolPrice(Long markCarpoolPrice) {
		this.markCarpoolPrice = markCarpoolPrice;
	}

	public String getMarkCarpoolName() {
		return markCarpoolName;
	}

	public void setMarkCarpoolName(String markCarpoolName) {
		this.markCarpoolName = markCarpoolName;
	}

	public String getMarkCarpoolPhone() {
		return markCarpoolPhone;
	}

	public void setMarkCarpoolPhone(String markCarpoolPhone) {
		this.markCarpoolPhone = markCarpoolPhone;
	}

	public Integer getMarkCarpoolVersion() {
		return markCarpoolVersion;
	}

	public void setMarkCarpoolVersion(Integer markCarpoolVersion) {
		this.markCarpoolVersion = markCarpoolVersion;
	}

	public Date getMarkCarpoolCreateTime() {
		return markCarpoolCreateTime;
	}

	public void setMarkCarpoolCreateTime(Date markCarpoolCreateTime) {
		this.markCarpoolCreateTime = markCarpoolCreateTime;
	}

	public Date getMarkCarpoolUpdateTime() {
		return markCarpoolUpdateTime;
	}

	public void setMarkCarpoolUpdateTime(Date markCarpoolUpdateTime) {
		this.markCarpoolUpdateTime = markCarpoolUpdateTime;
	}

	public Byte getMarkCarpoolIsActive() {
		return markCarpoolIsActive;
	}

	public void setMarkCarpoolIsActive(Byte markCarpoolIsActive) {
		this.markCarpoolIsActive = markCarpoolIsActive;
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
        return "UserMarkCarpoolDTO {" +
                "markCarpoolId = " + markCarpoolId + 
				", markCarpoolUserId = " + markCarpoolUserId + 
				", markCarpoolProjectId = " + markCarpoolProjectId + 
				", markCarpoolStartCity = " + markCarpoolStartCity + 
				", markCarpoolStartAddr = " + markCarpoolStartAddr + 
				", markCarpoolEndCity = " + markCarpoolEndCity + 
				", markCarpoolEndAddr = " + markCarpoolEndAddr + 
				", markCarpoolStartTime = " + markCarpoolStartTime + 
				", markCarpoolCarType = " + markCarpoolCarType + 
				", markCarpoolPeopleCount = " + markCarpoolPeopleCount + 
				", markCarpoolRecordCount = " + markCarpoolRecordCount + 
				", markCarpoolPrice = " + markCarpoolPrice + 
				", markCarpoolName = " + markCarpoolName + 
				", markCarpoolPhone = " + markCarpoolPhone + 
				", markCarpoolVersion = " + markCarpoolVersion + 
				", markCarpoolCreateTime = " + markCarpoolCreateTime + 
				", markCarpoolUpdateTime = " + markCarpoolUpdateTime + 
				", markCarpoolIsActive = " + markCarpoolIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailGender = " + userDetailGender + 
				" }";
    }

}
