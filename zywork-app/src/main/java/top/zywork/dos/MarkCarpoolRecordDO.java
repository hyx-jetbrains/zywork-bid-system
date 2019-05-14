package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * MarkCarpoolRecordDO数据对象实体类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class MarkCarpoolRecordDO extends BaseDO {

    private static final long serialVersionUID = -9223372035845224230L;

    // 拼车记录编号
	private Long id;
	// 用户编号
	private Long userId;
	// 拼车编号
	private Long markCarpoolId;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public MarkCarpoolRecordDO () {}

    public MarkCarpoolRecordDO (Long id, Long userId, Long markCarpoolId, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.markCarpoolId = markCarpoolId;
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

	public Long getMarkCarpoolId() {
		return markCarpoolId;
	}

	public void setMarkCarpoolId(Long markCarpoolId) {
		this.markCarpoolId = markCarpoolId;
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
        return "MarkCarpoolRecordDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", markCarpoolId = " + markCarpoolId + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
