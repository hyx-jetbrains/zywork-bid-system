package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMessageQuery查询对象类<br/>
 *
 * 创建于2019-05-20<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserMessageQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035693865249L;

    // 消息发送编号
	private Long id;
	// 消息发送编号（最小值）
	private Long idMin;
	// 消息发送编号（最大值）
	private Long idMax;
	// 消息编号
	private Long messageId;
	// 消息编号（最小值）
	private Long messageIdMin;
	// 消息编号（最大值）
	private Long messageIdMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 是否已读
	private Byte isRead;
	// 是否已读（最小值）
	private Byte isReadMin;
	// 是否已读（最大值）
	private Byte isReadMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public UserMessageQuery () {}

    public UserMessageQuery (Long id, Long idMin, Long idMax, Long messageId, Long messageIdMin, Long messageIdMax, Long userId, Long userIdMin, Long userIdMax, Byte isRead, Byte isReadMin, Byte isReadMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.messageId = messageId;
		this.messageIdMin = messageIdMin;
		this.messageIdMax = messageIdMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.isRead = isRead;
		this.isReadMin = isReadMin;
		this.isReadMax = isReadMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getMessageIdMin() {
		return messageIdMin;
	}

	public void setMessageIdMin(Long messageIdMin) {
		this.messageIdMin = messageIdMin;
	}

	public Long getMessageIdMax() {
		return messageIdMax;
	}

	public void setMessageIdMax(Long messageIdMax) {
		this.messageIdMax = messageIdMax;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
	}

	public Byte getIsRead() {
		return isRead;
	}

	public void setIsRead(Byte isRead) {
		this.isRead = isRead;
	}

	public Byte getIsReadMin() {
		return isReadMin;
	}

	public void setIsReadMin(Byte isReadMin) {
		this.isReadMin = isReadMin;
	}

	public Byte getIsReadMax() {
		return isReadMax;
	}

	public void setIsReadMax(Byte isReadMax) {
		this.isReadMax = isReadMax;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "UserMessageQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", messageId = " + messageId + 
				", messageIdMin = " + messageIdMin + 
				", messageIdMax = " + messageIdMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", isRead = " + isRead + 
				", isReadMin = " + isReadMin + 
				", isReadMax = " + isReadMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
