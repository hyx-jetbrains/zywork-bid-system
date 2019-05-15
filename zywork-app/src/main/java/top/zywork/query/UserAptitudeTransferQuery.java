package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserAptitudeTransferQuery查询对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserAptitudeTransferQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035882186604L;

    //t_aptitude_transfer表的字段对应的属性
	// 资质转让编号
	private Long aptitudeTransferId;
	// 资质转让编号（最小值）
	private Long aptitudeTransferIdMin;
	// 资质转让编号（最大值）
	private Long aptitudeTransferIdMax;
	// 用户编号
	private Long aptitudeTransferUserId;
	// 用户编号（最小值）
	private Long aptitudeTransferUserIdMin;
	// 用户编号（最大值）
	private Long aptitudeTransferUserIdMax;
	// 转让类别
	private Byte aptitudeTransferType;
	// 转让类别（最小值）
	private Byte aptitudeTransferTypeMin;
	// 转让类别（最大值）
	private Byte aptitudeTransferTypeMax;
	// 项目名称
	private String aptitudeTransferTitle;
	// 企业资质等级
	private String aptitudeTransferCompAptitudeLevel;
	// 企业资质类型
	private String aptitudeTransferCompAptitudeType;
	// 联系电话
	private String aptitudeTransferPhone;
	// 备注
	private String aptitudeTransferMemo;
	// 版本号
	private Integer aptitudeTransferVersion;
	// 版本号（最小值）
	private Integer aptitudeTransferVersionMin;
	// 版本号（最大值）
	private Integer aptitudeTransferVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aptitudeTransferCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aptitudeTransferCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aptitudeTransferCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aptitudeTransferUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aptitudeTransferUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date aptitudeTransferUpdateTimeMax;
	// 是否激活
	private Byte aptitudeTransferIsActive;
	// 是否激活（最小值）
	private Byte aptitudeTransferIsActiveMin;
	// 是否激活（最大值）
	private Byte aptitudeTransferIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserAptitudeTransferQuery () {}

    public UserAptitudeTransferQuery (Long aptitudeTransferId, Long aptitudeTransferIdMin, Long aptitudeTransferIdMax, Long aptitudeTransferUserId, Long aptitudeTransferUserIdMin, Long aptitudeTransferUserIdMax, Byte aptitudeTransferType, Byte aptitudeTransferTypeMin, Byte aptitudeTransferTypeMax, String aptitudeTransferTitle, String aptitudeTransferCompAptitudeLevel, String aptitudeTransferCompAptitudeType, String aptitudeTransferPhone, String aptitudeTransferMemo, Integer aptitudeTransferVersion, Integer aptitudeTransferVersionMin, Integer aptitudeTransferVersionMax, Date aptitudeTransferCreateTime, Date aptitudeTransferCreateTimeMin, Date aptitudeTransferCreateTimeMax, Date aptitudeTransferUpdateTime, Date aptitudeTransferUpdateTimeMin, Date aptitudeTransferUpdateTimeMax, Byte aptitudeTransferIsActive, Byte aptitudeTransferIsActiveMin, Byte aptitudeTransferIsActiveMax, String userDetailNickname, String userDetailHeadicon) {
        this.aptitudeTransferId = aptitudeTransferId;
		this.aptitudeTransferIdMin = aptitudeTransferIdMin;
		this.aptitudeTransferIdMax = aptitudeTransferIdMax;
		this.aptitudeTransferUserId = aptitudeTransferUserId;
		this.aptitudeTransferUserIdMin = aptitudeTransferUserIdMin;
		this.aptitudeTransferUserIdMax = aptitudeTransferUserIdMax;
		this.aptitudeTransferType = aptitudeTransferType;
		this.aptitudeTransferTypeMin = aptitudeTransferTypeMin;
		this.aptitudeTransferTypeMax = aptitudeTransferTypeMax;
		this.aptitudeTransferTitle = aptitudeTransferTitle;
		this.aptitudeTransferCompAptitudeLevel = aptitudeTransferCompAptitudeLevel;
		this.aptitudeTransferCompAptitudeType = aptitudeTransferCompAptitudeType;
		this.aptitudeTransferPhone = aptitudeTransferPhone;
		this.aptitudeTransferMemo = aptitudeTransferMemo;
		this.aptitudeTransferVersion = aptitudeTransferVersion;
		this.aptitudeTransferVersionMin = aptitudeTransferVersionMin;
		this.aptitudeTransferVersionMax = aptitudeTransferVersionMax;
		this.aptitudeTransferCreateTime = aptitudeTransferCreateTime;
		this.aptitudeTransferCreateTimeMin = aptitudeTransferCreateTimeMin;
		this.aptitudeTransferCreateTimeMax = aptitudeTransferCreateTimeMax;
		this.aptitudeTransferUpdateTime = aptitudeTransferUpdateTime;
		this.aptitudeTransferUpdateTimeMin = aptitudeTransferUpdateTimeMin;
		this.aptitudeTransferUpdateTimeMax = aptitudeTransferUpdateTimeMax;
		this.aptitudeTransferIsActive = aptitudeTransferIsActive;
		this.aptitudeTransferIsActiveMin = aptitudeTransferIsActiveMin;
		this.aptitudeTransferIsActiveMax = aptitudeTransferIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getAptitudeTransferId() {
		return aptitudeTransferId;
	}

	public void setAptitudeTransferId(Long aptitudeTransferId) {
		this.aptitudeTransferId = aptitudeTransferId;
	}

	public Long getAptitudeTransferIdMin() {
		return aptitudeTransferIdMin;
	}

	public void setAptitudeTransferIdMin(Long aptitudeTransferIdMin) {
		this.aptitudeTransferIdMin = aptitudeTransferIdMin;
	}

	public Long getAptitudeTransferIdMax() {
		return aptitudeTransferIdMax;
	}

	public void setAptitudeTransferIdMax(Long aptitudeTransferIdMax) {
		this.aptitudeTransferIdMax = aptitudeTransferIdMax;
	}

	public Long getAptitudeTransferUserId() {
		return aptitudeTransferUserId;
	}

	public void setAptitudeTransferUserId(Long aptitudeTransferUserId) {
		this.aptitudeTransferUserId = aptitudeTransferUserId;
	}

	public Long getAptitudeTransferUserIdMin() {
		return aptitudeTransferUserIdMin;
	}

	public void setAptitudeTransferUserIdMin(Long aptitudeTransferUserIdMin) {
		this.aptitudeTransferUserIdMin = aptitudeTransferUserIdMin;
	}

	public Long getAptitudeTransferUserIdMax() {
		return aptitudeTransferUserIdMax;
	}

	public void setAptitudeTransferUserIdMax(Long aptitudeTransferUserIdMax) {
		this.aptitudeTransferUserIdMax = aptitudeTransferUserIdMax;
	}

	public Byte getAptitudeTransferType() {
		return aptitudeTransferType;
	}

	public void setAptitudeTransferType(Byte aptitudeTransferType) {
		this.aptitudeTransferType = aptitudeTransferType;
	}

	public Byte getAptitudeTransferTypeMin() {
		return aptitudeTransferTypeMin;
	}

	public void setAptitudeTransferTypeMin(Byte aptitudeTransferTypeMin) {
		this.aptitudeTransferTypeMin = aptitudeTransferTypeMin;
	}

	public Byte getAptitudeTransferTypeMax() {
		return aptitudeTransferTypeMax;
	}

	public void setAptitudeTransferTypeMax(Byte aptitudeTransferTypeMax) {
		this.aptitudeTransferTypeMax = aptitudeTransferTypeMax;
	}

	public String getAptitudeTransferTitle() {
		return aptitudeTransferTitle;
	}

	public void setAptitudeTransferTitle(String aptitudeTransferTitle) {
		this.aptitudeTransferTitle = aptitudeTransferTitle;
	}

	public String getAptitudeTransferCompAptitudeLevel() {
		return aptitudeTransferCompAptitudeLevel;
	}

	public void setAptitudeTransferCompAptitudeLevel(String aptitudeTransferCompAptitudeLevel) {
		this.aptitudeTransferCompAptitudeLevel = aptitudeTransferCompAptitudeLevel;
	}

	public String getAptitudeTransferCompAptitudeType() {
		return aptitudeTransferCompAptitudeType;
	}

	public void setAptitudeTransferCompAptitudeType(String aptitudeTransferCompAptitudeType) {
		this.aptitudeTransferCompAptitudeType = aptitudeTransferCompAptitudeType;
	}

	public String getAptitudeTransferPhone() {
		return aptitudeTransferPhone;
	}

	public void setAptitudeTransferPhone(String aptitudeTransferPhone) {
		this.aptitudeTransferPhone = aptitudeTransferPhone;
	}

	public String getAptitudeTransferMemo() {
		return aptitudeTransferMemo;
	}

	public void setAptitudeTransferMemo(String aptitudeTransferMemo) {
		this.aptitudeTransferMemo = aptitudeTransferMemo;
	}

	public Integer getAptitudeTransferVersion() {
		return aptitudeTransferVersion;
	}

	public void setAptitudeTransferVersion(Integer aptitudeTransferVersion) {
		this.aptitudeTransferVersion = aptitudeTransferVersion;
	}

	public Integer getAptitudeTransferVersionMin() {
		return aptitudeTransferVersionMin;
	}

	public void setAptitudeTransferVersionMin(Integer aptitudeTransferVersionMin) {
		this.aptitudeTransferVersionMin = aptitudeTransferVersionMin;
	}

	public Integer getAptitudeTransferVersionMax() {
		return aptitudeTransferVersionMax;
	}

	public void setAptitudeTransferVersionMax(Integer aptitudeTransferVersionMax) {
		this.aptitudeTransferVersionMax = aptitudeTransferVersionMax;
	}

	public Date getAptitudeTransferCreateTime() {
		return aptitudeTransferCreateTime;
	}

	public void setAptitudeTransferCreateTime(Date aptitudeTransferCreateTime) {
		this.aptitudeTransferCreateTime = aptitudeTransferCreateTime;
	}

	public Date getAptitudeTransferCreateTimeMin() {
		return aptitudeTransferCreateTimeMin;
	}

	public void setAptitudeTransferCreateTimeMin(Date aptitudeTransferCreateTimeMin) {
		this.aptitudeTransferCreateTimeMin = aptitudeTransferCreateTimeMin;
	}

	public Date getAptitudeTransferCreateTimeMax() {
		return aptitudeTransferCreateTimeMax;
	}

	public void setAptitudeTransferCreateTimeMax(Date aptitudeTransferCreateTimeMax) {
		this.aptitudeTransferCreateTimeMax = aptitudeTransferCreateTimeMax;
	}

	public Date getAptitudeTransferUpdateTime() {
		return aptitudeTransferUpdateTime;
	}

	public void setAptitudeTransferUpdateTime(Date aptitudeTransferUpdateTime) {
		this.aptitudeTransferUpdateTime = aptitudeTransferUpdateTime;
	}

	public Date getAptitudeTransferUpdateTimeMin() {
		return aptitudeTransferUpdateTimeMin;
	}

	public void setAptitudeTransferUpdateTimeMin(Date aptitudeTransferUpdateTimeMin) {
		this.aptitudeTransferUpdateTimeMin = aptitudeTransferUpdateTimeMin;
	}

	public Date getAptitudeTransferUpdateTimeMax() {
		return aptitudeTransferUpdateTimeMax;
	}

	public void setAptitudeTransferUpdateTimeMax(Date aptitudeTransferUpdateTimeMax) {
		this.aptitudeTransferUpdateTimeMax = aptitudeTransferUpdateTimeMax;
	}

	public Byte getAptitudeTransferIsActive() {
		return aptitudeTransferIsActive;
	}

	public void setAptitudeTransferIsActive(Byte aptitudeTransferIsActive) {
		this.aptitudeTransferIsActive = aptitudeTransferIsActive;
	}

	public Byte getAptitudeTransferIsActiveMin() {
		return aptitudeTransferIsActiveMin;
	}

	public void setAptitudeTransferIsActiveMin(Byte aptitudeTransferIsActiveMin) {
		this.aptitudeTransferIsActiveMin = aptitudeTransferIsActiveMin;
	}

	public Byte getAptitudeTransferIsActiveMax() {
		return aptitudeTransferIsActiveMax;
	}

	public void setAptitudeTransferIsActiveMax(Byte aptitudeTransferIsActiveMax) {
		this.aptitudeTransferIsActiveMax = aptitudeTransferIsActiveMax;
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
        return "UserAptitudeTransferQuery {" +
                "aptitudeTransferId = " + aptitudeTransferId + 
				", aptitudeTransferIdMin = " + aptitudeTransferIdMin + 
				", aptitudeTransferIdMax = " + aptitudeTransferIdMax + 
				", aptitudeTransferUserId = " + aptitudeTransferUserId + 
				", aptitudeTransferUserIdMin = " + aptitudeTransferUserIdMin + 
				", aptitudeTransferUserIdMax = " + aptitudeTransferUserIdMax + 
				", aptitudeTransferType = " + aptitudeTransferType + 
				", aptitudeTransferTypeMin = " + aptitudeTransferTypeMin + 
				", aptitudeTransferTypeMax = " + aptitudeTransferTypeMax + 
				", aptitudeTransferTitle = " + aptitudeTransferTitle + 
				", aptitudeTransferCompAptitudeLevel = " + aptitudeTransferCompAptitudeLevel + 
				", aptitudeTransferCompAptitudeType = " + aptitudeTransferCompAptitudeType + 
				", aptitudeTransferPhone = " + aptitudeTransferPhone + 
				", aptitudeTransferMemo = " + aptitudeTransferMemo + 
				", aptitudeTransferVersion = " + aptitudeTransferVersion + 
				", aptitudeTransferVersionMin = " + aptitudeTransferVersionMin + 
				", aptitudeTransferVersionMax = " + aptitudeTransferVersionMax + 
				", aptitudeTransferCreateTime = " + aptitudeTransferCreateTime + 
				", aptitudeTransferCreateTimeMin = " + aptitudeTransferCreateTimeMin + 
				", aptitudeTransferCreateTimeMax = " + aptitudeTransferCreateTimeMax + 
				", aptitudeTransferUpdateTime = " + aptitudeTransferUpdateTime + 
				", aptitudeTransferUpdateTimeMin = " + aptitudeTransferUpdateTimeMin + 
				", aptitudeTransferUpdateTimeMax = " + aptitudeTransferUpdateTimeMax + 
				", aptitudeTransferIsActive = " + aptitudeTransferIsActive + 
				", aptitudeTransferIsActiveMin = " + aptitudeTransferIsActiveMin + 
				", aptitudeTransferIsActiveMax = " + aptitudeTransferIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
