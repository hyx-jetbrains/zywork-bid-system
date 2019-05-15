package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserAptitudeTransferDO数据对象实体类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserAptitudeTransferDO extends BaseDO {

    private static final long serialVersionUID = -9223372035320995617L;

    //t_aptitude_transfer表的字段对应的属性
	// 资质转让编号
	private Long aptitudeTransferId;
	// 用户编号
	private Long aptitudeTransferUserId;
	// 转让类别
	private Byte aptitudeTransferType;
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
	// 创建时间
	private Date aptitudeTransferCreateTime;
	// 更新时间
	private Date aptitudeTransferUpdateTime;
	// 是否激活
	private Byte aptitudeTransferIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserAptitudeTransferDO () {}

    public UserAptitudeTransferDO (Long aptitudeTransferId, Long aptitudeTransferUserId, Byte aptitudeTransferType, String aptitudeTransferTitle, String aptitudeTransferCompAptitudeLevel, String aptitudeTransferCompAptitudeType, String aptitudeTransferPhone, String aptitudeTransferMemo, Integer aptitudeTransferVersion, Date aptitudeTransferCreateTime, Date aptitudeTransferUpdateTime, Byte aptitudeTransferIsActive, String userDetailNickname, String userDetailHeadicon) {
        this.aptitudeTransferId = aptitudeTransferId;
		this.aptitudeTransferUserId = aptitudeTransferUserId;
		this.aptitudeTransferType = aptitudeTransferType;
		this.aptitudeTransferTitle = aptitudeTransferTitle;
		this.aptitudeTransferCompAptitudeLevel = aptitudeTransferCompAptitudeLevel;
		this.aptitudeTransferCompAptitudeType = aptitudeTransferCompAptitudeType;
		this.aptitudeTransferPhone = aptitudeTransferPhone;
		this.aptitudeTransferMemo = aptitudeTransferMemo;
		this.aptitudeTransferVersion = aptitudeTransferVersion;
		this.aptitudeTransferCreateTime = aptitudeTransferCreateTime;
		this.aptitudeTransferUpdateTime = aptitudeTransferUpdateTime;
		this.aptitudeTransferIsActive = aptitudeTransferIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getAptitudeTransferId() {
		return aptitudeTransferId;
	}

	public void setAptitudeTransferId(Long aptitudeTransferId) {
		this.aptitudeTransferId = aptitudeTransferId;
	}

	public Long getAptitudeTransferUserId() {
		return aptitudeTransferUserId;
	}

	public void setAptitudeTransferUserId(Long aptitudeTransferUserId) {
		this.aptitudeTransferUserId = aptitudeTransferUserId;
	}

	public Byte getAptitudeTransferType() {
		return aptitudeTransferType;
	}

	public void setAptitudeTransferType(Byte aptitudeTransferType) {
		this.aptitudeTransferType = aptitudeTransferType;
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

	public Date getAptitudeTransferCreateTime() {
		return aptitudeTransferCreateTime;
	}

	public void setAptitudeTransferCreateTime(Date aptitudeTransferCreateTime) {
		this.aptitudeTransferCreateTime = aptitudeTransferCreateTime;
	}

	public Date getAptitudeTransferUpdateTime() {
		return aptitudeTransferUpdateTime;
	}

	public void setAptitudeTransferUpdateTime(Date aptitudeTransferUpdateTime) {
		this.aptitudeTransferUpdateTime = aptitudeTransferUpdateTime;
	}

	public Byte getAptitudeTransferIsActive() {
		return aptitudeTransferIsActive;
	}

	public void setAptitudeTransferIsActive(Byte aptitudeTransferIsActive) {
		this.aptitudeTransferIsActive = aptitudeTransferIsActive;
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
        return "UserAptitudeTransferDO {" +
                "aptitudeTransferId = " + aptitudeTransferId + 
				", aptitudeTransferUserId = " + aptitudeTransferUserId + 
				", aptitudeTransferType = " + aptitudeTransferType + 
				", aptitudeTransferTitle = " + aptitudeTransferTitle + 
				", aptitudeTransferCompAptitudeLevel = " + aptitudeTransferCompAptitudeLevel + 
				", aptitudeTransferCompAptitudeType = " + aptitudeTransferCompAptitudeType + 
				", aptitudeTransferPhone = " + aptitudeTransferPhone + 
				", aptitudeTransferMemo = " + aptitudeTransferMemo + 
				", aptitudeTransferVersion = " + aptitudeTransferVersion + 
				", aptitudeTransferCreateTime = " + aptitudeTransferCreateTime + 
				", aptitudeTransferUpdateTime = " + aptitudeTransferUpdateTime + 
				", aptitudeTransferIsActive = " + aptitudeTransferIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
