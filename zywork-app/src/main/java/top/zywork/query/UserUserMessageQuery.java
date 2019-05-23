package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserMessageQuery查询对象类<br/>
 *
 * 创建于2019-05-23<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserUserMessageQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035300749820L;

    //t_user_message表的字段对应的属性
	// 消息发送编号
	private Long userMessageId;
	// 消息发送编号（最小值）
	private Long userMessageIdMin;
	// 消息发送编号（最大值）
	private Long userMessageIdMax;
	// 消息编号
	private Long userMessageMessageId;
	// 消息编号（最小值）
	private Long userMessageMessageIdMin;
	// 消息编号（最大值）
	private Long userMessageMessageIdMax;
	// 用户编号
	private Long userMessageUserId;
	// 用户编号（最小值）
	private Long userMessageUserIdMin;
	// 用户编号（最大值）
	private Long userMessageUserIdMax;
	// 是否已读
	private Byte userMessageIsRead;
	// 是否已读（最小值）
	private Byte userMessageIsReadMin;
	// 是否已读（最大值）
	private Byte userMessageIsReadMax;
	// 版本号
	private Integer userMessageVersion;
	// 版本号（最小值）
	private Integer userMessageVersionMin;
	// 版本号（最大值）
	private Integer userMessageVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageUpdateTimeMax;
	// 是否激活
	private Byte userMessageIsActive;
	// 是否激活（最小值）
	private Byte userMessageIsActiveMin;
	// 是否激活（最大值）
	private Byte userMessageIsActiveMax;
	//t_message表的字段对应的属性
	// 消息标题
	private String messageTitle;
	// 消息摘要
	private String messageSummary;
	// 消息内容
	private String messageContent;
	// 消息类型
	private String messageMessageType;
	
    public UserUserMessageQuery () {}

    public UserUserMessageQuery (Long userMessageId, Long userMessageIdMin, Long userMessageIdMax, Long userMessageMessageId, Long userMessageMessageIdMin, Long userMessageMessageIdMax, Long userMessageUserId, Long userMessageUserIdMin, Long userMessageUserIdMax, Byte userMessageIsRead, Byte userMessageIsReadMin, Byte userMessageIsReadMax, Integer userMessageVersion, Integer userMessageVersionMin, Integer userMessageVersionMax, Date userMessageCreateTime, Date userMessageCreateTimeMin, Date userMessageCreateTimeMax, Date userMessageUpdateTime, Date userMessageUpdateTimeMin, Date userMessageUpdateTimeMax, Byte userMessageIsActive, Byte userMessageIsActiveMin, Byte userMessageIsActiveMax, String messageTitle, String messageSummary, String messageContent, String messageMessageType) {
        this.userMessageId = userMessageId;
		this.userMessageIdMin = userMessageIdMin;
		this.userMessageIdMax = userMessageIdMax;
		this.userMessageMessageId = userMessageMessageId;
		this.userMessageMessageIdMin = userMessageMessageIdMin;
		this.userMessageMessageIdMax = userMessageMessageIdMax;
		this.userMessageUserId = userMessageUserId;
		this.userMessageUserIdMin = userMessageUserIdMin;
		this.userMessageUserIdMax = userMessageUserIdMax;
		this.userMessageIsRead = userMessageIsRead;
		this.userMessageIsReadMin = userMessageIsReadMin;
		this.userMessageIsReadMax = userMessageIsReadMax;
		this.userMessageVersion = userMessageVersion;
		this.userMessageVersionMin = userMessageVersionMin;
		this.userMessageVersionMax = userMessageVersionMax;
		this.userMessageCreateTime = userMessageCreateTime;
		this.userMessageCreateTimeMin = userMessageCreateTimeMin;
		this.userMessageCreateTimeMax = userMessageCreateTimeMax;
		this.userMessageUpdateTime = userMessageUpdateTime;
		this.userMessageUpdateTimeMin = userMessageUpdateTimeMin;
		this.userMessageUpdateTimeMax = userMessageUpdateTimeMax;
		this.userMessageIsActive = userMessageIsActive;
		this.userMessageIsActiveMin = userMessageIsActiveMin;
		this.userMessageIsActiveMax = userMessageIsActiveMax;
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

	public Long getUserMessageIdMin() {
		return userMessageIdMin;
	}

	public void setUserMessageIdMin(Long userMessageIdMin) {
		this.userMessageIdMin = userMessageIdMin;
	}

	public Long getUserMessageIdMax() {
		return userMessageIdMax;
	}

	public void setUserMessageIdMax(Long userMessageIdMax) {
		this.userMessageIdMax = userMessageIdMax;
	}

	public Long getUserMessageMessageId() {
		return userMessageMessageId;
	}

	public void setUserMessageMessageId(Long userMessageMessageId) {
		this.userMessageMessageId = userMessageMessageId;
	}

	public Long getUserMessageMessageIdMin() {
		return userMessageMessageIdMin;
	}

	public void setUserMessageMessageIdMin(Long userMessageMessageIdMin) {
		this.userMessageMessageIdMin = userMessageMessageIdMin;
	}

	public Long getUserMessageMessageIdMax() {
		return userMessageMessageIdMax;
	}

	public void setUserMessageMessageIdMax(Long userMessageMessageIdMax) {
		this.userMessageMessageIdMax = userMessageMessageIdMax;
	}

	public Long getUserMessageUserId() {
		return userMessageUserId;
	}

	public void setUserMessageUserId(Long userMessageUserId) {
		this.userMessageUserId = userMessageUserId;
	}

	public Long getUserMessageUserIdMin() {
		return userMessageUserIdMin;
	}

	public void setUserMessageUserIdMin(Long userMessageUserIdMin) {
		this.userMessageUserIdMin = userMessageUserIdMin;
	}

	public Long getUserMessageUserIdMax() {
		return userMessageUserIdMax;
	}

	public void setUserMessageUserIdMax(Long userMessageUserIdMax) {
		this.userMessageUserIdMax = userMessageUserIdMax;
	}

	public Byte getUserMessageIsRead() {
		return userMessageIsRead;
	}

	public void setUserMessageIsRead(Byte userMessageIsRead) {
		this.userMessageIsRead = userMessageIsRead;
	}

	public Byte getUserMessageIsReadMin() {
		return userMessageIsReadMin;
	}

	public void setUserMessageIsReadMin(Byte userMessageIsReadMin) {
		this.userMessageIsReadMin = userMessageIsReadMin;
	}

	public Byte getUserMessageIsReadMax() {
		return userMessageIsReadMax;
	}

	public void setUserMessageIsReadMax(Byte userMessageIsReadMax) {
		this.userMessageIsReadMax = userMessageIsReadMax;
	}

	public Integer getUserMessageVersion() {
		return userMessageVersion;
	}

	public void setUserMessageVersion(Integer userMessageVersion) {
		this.userMessageVersion = userMessageVersion;
	}

	public Integer getUserMessageVersionMin() {
		return userMessageVersionMin;
	}

	public void setUserMessageVersionMin(Integer userMessageVersionMin) {
		this.userMessageVersionMin = userMessageVersionMin;
	}

	public Integer getUserMessageVersionMax() {
		return userMessageVersionMax;
	}

	public void setUserMessageVersionMax(Integer userMessageVersionMax) {
		this.userMessageVersionMax = userMessageVersionMax;
	}

	public Date getUserMessageCreateTime() {
		return userMessageCreateTime;
	}

	public void setUserMessageCreateTime(Date userMessageCreateTime) {
		this.userMessageCreateTime = userMessageCreateTime;
	}

	public Date getUserMessageCreateTimeMin() {
		return userMessageCreateTimeMin;
	}

	public void setUserMessageCreateTimeMin(Date userMessageCreateTimeMin) {
		this.userMessageCreateTimeMin = userMessageCreateTimeMin;
	}

	public Date getUserMessageCreateTimeMax() {
		return userMessageCreateTimeMax;
	}

	public void setUserMessageCreateTimeMax(Date userMessageCreateTimeMax) {
		this.userMessageCreateTimeMax = userMessageCreateTimeMax;
	}

	public Date getUserMessageUpdateTime() {
		return userMessageUpdateTime;
	}

	public void setUserMessageUpdateTime(Date userMessageUpdateTime) {
		this.userMessageUpdateTime = userMessageUpdateTime;
	}

	public Date getUserMessageUpdateTimeMin() {
		return userMessageUpdateTimeMin;
	}

	public void setUserMessageUpdateTimeMin(Date userMessageUpdateTimeMin) {
		this.userMessageUpdateTimeMin = userMessageUpdateTimeMin;
	}

	public Date getUserMessageUpdateTimeMax() {
		return userMessageUpdateTimeMax;
	}

	public void setUserMessageUpdateTimeMax(Date userMessageUpdateTimeMax) {
		this.userMessageUpdateTimeMax = userMessageUpdateTimeMax;
	}

	public Byte getUserMessageIsActive() {
		return userMessageIsActive;
	}

	public void setUserMessageIsActive(Byte userMessageIsActive) {
		this.userMessageIsActive = userMessageIsActive;
	}

	public Byte getUserMessageIsActiveMin() {
		return userMessageIsActiveMin;
	}

	public void setUserMessageIsActiveMin(Byte userMessageIsActiveMin) {
		this.userMessageIsActiveMin = userMessageIsActiveMin;
	}

	public Byte getUserMessageIsActiveMax() {
		return userMessageIsActiveMax;
	}

	public void setUserMessageIsActiveMax(Byte userMessageIsActiveMax) {
		this.userMessageIsActiveMax = userMessageIsActiveMax;
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
        return "UserUserMessageQuery {" +
                "userMessageId = " + userMessageId + 
				", userMessageIdMin = " + userMessageIdMin + 
				", userMessageIdMax = " + userMessageIdMax + 
				", userMessageMessageId = " + userMessageMessageId + 
				", userMessageMessageIdMin = " + userMessageMessageIdMin + 
				", userMessageMessageIdMax = " + userMessageMessageIdMax + 
				", userMessageUserId = " + userMessageUserId + 
				", userMessageUserIdMin = " + userMessageUserIdMin + 
				", userMessageUserIdMax = " + userMessageUserIdMax + 
				", userMessageIsRead = " + userMessageIsRead + 
				", userMessageIsReadMin = " + userMessageIsReadMin + 
				", userMessageIsReadMax = " + userMessageIsReadMax + 
				", userMessageVersion = " + userMessageVersion + 
				", userMessageVersionMin = " + userMessageVersionMin + 
				", userMessageVersionMax = " + userMessageVersionMax + 
				", userMessageCreateTime = " + userMessageCreateTime + 
				", userMessageCreateTimeMin = " + userMessageCreateTimeMin + 
				", userMessageCreateTimeMax = " + userMessageCreateTimeMax + 
				", userMessageUpdateTime = " + userMessageUpdateTime + 
				", userMessageUpdateTimeMin = " + userMessageUpdateTimeMin + 
				", userMessageUpdateTimeMax = " + userMessageUpdateTimeMax + 
				", userMessageIsActive = " + userMessageIsActive + 
				", userMessageIsActiveMin = " + userMessageIsActiveMin + 
				", userMessageIsActiveMax = " + userMessageIsActiveMax + 
				", messageTitle = " + messageTitle + 
				", messageSummary = " + messageSummary + 
				", messageContent = " + messageContent + 
				", messageMessageType = " + messageMessageType + 
				" }";
    }

}
