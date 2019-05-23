package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserMessageDO数据对象实体类<br/>
 *
 * 创建于2019-05-23<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserUserMessageDO extends BaseDO {

    private static final long serialVersionUID = -9223372034765350414L;

    //t_user_message表的字段对应的属性
	// 消息发送编号
	private Long userMessageId;
	// 消息编号
	private Long userMessageMessageId;
	// 用户编号
	private Long userMessageUserId;
	// 是否已读
	private Byte userMessageIsRead;
	// 版本号
	private Integer userMessageVersion;
	// 创建时间
	private Date userMessageCreateTime;
	// 更新时间
	private Date userMessageUpdateTime;
	// 是否激活
	private Byte userMessageIsActive;
	//t_message表的字段对应的属性
	// 消息标题
	private String messageTitle;
	// 消息摘要
	private String messageSummary;
	// 消息内容
	private String messageContent;
	// 消息类型
	private String messageMessageType;
	
    public UserUserMessageDO () {}

    public UserUserMessageDO (Long userMessageId, Long userMessageMessageId, Long userMessageUserId, Byte userMessageIsRead, Integer userMessageVersion, Date userMessageCreateTime, Date userMessageUpdateTime, Byte userMessageIsActive, String messageTitle, String messageSummary, String messageContent, String messageMessageType) {
        this.userMessageId = userMessageId;
		this.userMessageMessageId = userMessageMessageId;
		this.userMessageUserId = userMessageUserId;
		this.userMessageIsRead = userMessageIsRead;
		this.userMessageVersion = userMessageVersion;
		this.userMessageCreateTime = userMessageCreateTime;
		this.userMessageUpdateTime = userMessageUpdateTime;
		this.userMessageIsActive = userMessageIsActive;
		this.messageTitle = messageTitle;
		this.messageSummary = messageSummary;
		this.messageContent = messageContent;
		this.messageMessageType = messageMessageType;
		
    }

    public Long getUserMessageId() {
		return userMessageId;
	}

	public void setUserMessageId(Long userMessageId) {
		this.userMessageId = userMessageId;
	}

	public Long getUserMessageMessageId() {
		return userMessageMessageId;
	}

	public void setUserMessageMessageId(Long userMessageMessageId) {
		this.userMessageMessageId = userMessageMessageId;
	}

	public Long getUserMessageUserId() {
		return userMessageUserId;
	}

	public void setUserMessageUserId(Long userMessageUserId) {
		this.userMessageUserId = userMessageUserId;
	}

	public Byte getUserMessageIsRead() {
		return userMessageIsRead;
	}

	public void setUserMessageIsRead(Byte userMessageIsRead) {
		this.userMessageIsRead = userMessageIsRead;
	}

	public Integer getUserMessageVersion() {
		return userMessageVersion;
	}

	public void setUserMessageVersion(Integer userMessageVersion) {
		this.userMessageVersion = userMessageVersion;
	}

	public Date getUserMessageCreateTime() {
		return userMessageCreateTime;
	}

	public void setUserMessageCreateTime(Date userMessageCreateTime) {
		this.userMessageCreateTime = userMessageCreateTime;
	}

	public Date getUserMessageUpdateTime() {
		return userMessageUpdateTime;
	}

	public void setUserMessageUpdateTime(Date userMessageUpdateTime) {
		this.userMessageUpdateTime = userMessageUpdateTime;
	}

	public Byte getUserMessageIsActive() {
		return userMessageIsActive;
	}

	public void setUserMessageIsActive(Byte userMessageIsActive) {
		this.userMessageIsActive = userMessageIsActive;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageSummary() {
		return messageSummary;
	}

	public void setMessageSummary(String messageSummary) {
		this.messageSummary = messageSummary;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageMessageType() {
		return messageMessageType;
	}

	public void setMessageMessageType(String messageMessageType) {
		this.messageMessageType = messageMessageType;
	}

	
    @Override
    public String toString() {
        return "UserUserMessageDO {" +
                "userMessageId = " + userMessageId + 
				", userMessageMessageId = " + userMessageMessageId + 
				", userMessageUserId = " + userMessageUserId + 
				", userMessageIsRead = " + userMessageIsRead + 
				", userMessageVersion = " + userMessageVersion + 
				", userMessageCreateTime = " + userMessageCreateTime + 
				", userMessageUpdateTime = " + userMessageUpdateTime + 
				", userMessageIsActive = " + userMessageIsActive + 
				", messageTitle = " + messageTitle + 
				", messageSummary = " + messageSummary + 
				", messageContent = " + messageContent + 
				", messageMessageType = " + messageMessageType + 
				" }";
    }

}
