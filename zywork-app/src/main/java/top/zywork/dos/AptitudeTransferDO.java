package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * AptitudeTransferDO数据对象实体类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class AptitudeTransferDO extends BaseDO {

    private static final long serialVersionUID = -9223372035338441801L;

    // 资质转让编号
	private Long id;
	// 用户编号
	private Long userId;
	// 转让类别
	private Byte type;
	// 项目名称
	private String title;
	// 企业资质等级
	private String compAptitudeLevel;
	// 企业资质类型
	private String compAptitudeType;
	// 联系电话
	private String phone;
	// 备注
	private String memo;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public AptitudeTransferDO () {}

    public AptitudeTransferDO (Long id, Long userId, Byte type, String title, String compAptitudeLevel, String compAptitudeType, String phone, String memo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.type = type;
		this.title = title;
		this.compAptitudeLevel = compAptitudeLevel;
		this.compAptitudeType = compAptitudeType;
		this.phone = phone;
		this.memo = memo;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompAptitudeLevel() {
		return compAptitudeLevel;
	}

	public void setCompAptitudeLevel(String compAptitudeLevel) {
		this.compAptitudeLevel = compAptitudeLevel;
	}

	public String getCompAptitudeType() {
		return compAptitudeType;
	}

	public void setCompAptitudeType(String compAptitudeType) {
		this.compAptitudeType = compAptitudeType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "AptitudeTransferDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", type = " + type + 
				", title = " + title + 
				", compAptitudeLevel = " + compAptitudeLevel + 
				", compAptitudeType = " + compAptitudeType + 
				", phone = " + phone + 
				", memo = " + memo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
