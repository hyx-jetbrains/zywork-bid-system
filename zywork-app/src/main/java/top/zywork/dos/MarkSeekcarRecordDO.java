package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * MarkSeekcarRecordDO数据对象实体类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class MarkSeekcarRecordDO extends BaseDO {

    private static final long serialVersionUID = -9223372035351980850L;

    // 拼车记录编号
	private Long id;
	// 用户编号
	private Long userId;
	// 找车编号
	private Long markSeekcarId;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public MarkSeekcarRecordDO () {}

    public MarkSeekcarRecordDO (Long id, Long userId, Long markSeekcarId, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.markSeekcarId = markSeekcarId;
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

	public Long getMarkSeekcarId() {
		return markSeekcarId;
	}

	public void setMarkSeekcarId(Long markSeekcarId) {
		this.markSeekcarId = markSeekcarId;
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
        return "MarkSeekcarRecordDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", markSeekcarId = " + markSeekcarId + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
