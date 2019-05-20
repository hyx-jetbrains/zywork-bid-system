package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserMessageDTO数据传输对象类<br/>
 *
 * 创建于2019-05-20<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMessageDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036785876782L;

    // 消息发送编号
	private Long id;
	// 消息编号
	private Long messageId;
	// 用户编号
	private Long userId;
	// 是否已读
	private Byte isRead;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserMessageDTO () {}

    public UserMessageDTO (Long id, Long messageId, Long userId, Byte isRead, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.messageId = messageId;
		this.userId = userId;
		this.isRead = isRead;
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

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Byte getIsRead() {
		return isRead;
	}

	public void setIsRead(Byte isRead) {
		this.isRead = isRead;
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
        return "UserMessageDTO {" +
                "id = " + id + 
				", messageId = " + messageId + 
				", userId = " + userId + 
				", isRead = " + isRead + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
