package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ExpertSubscribeDTO数据传输对象类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ExpertSubscribeDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036782334135L;

    // 专家预约编号
	private Long id;
	// 用户编号
	private Long userId;
	// 预约专家编号
	private Long expertUserId;
	// 问题类别编号
	private Long questionTypeId;
	// 问题说明
	private String questionDesc;
	// 回复用户编号
	private Long replyUserId;
	// 回复内容
	private String replyContent;
	// 回复时间
	private Date replyTime;
	// 预约状态
	private String subscribeStatus;
	// 预约价格
	private Long price;
	// 支付状态
	private String payStatus;
	// 支付方式
	private String payType;
	// 交易编号
	private String transactionNo;
	// 预约标识
	private Byte vipFlag;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ExpertSubscribeDTO () {}

    public ExpertSubscribeDTO (Long id, Long userId, Long expertUserId, Long questionTypeId, String questionDesc, Long replyUserId, String replyContent, Date replyTime, String subscribeStatus, Long price, String payStatus, String payType, String transactionNo, Byte vipFlag, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.expertUserId = expertUserId;
		this.questionTypeId = questionTypeId;
		this.questionDesc = questionDesc;
		this.replyUserId = replyUserId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.subscribeStatus = subscribeStatus;
		this.price = price;
		this.payStatus = payStatus;
		this.payType = payType;
		this.transactionNo = transactionNo;
		this.vipFlag = vipFlag;
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

	public Long getExpertUserId() {
		return expertUserId;
	}

	public void setExpertUserId(Long expertUserId) {
		this.expertUserId = expertUserId;
	}

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public Long getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(Long replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(String subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Byte getVipFlag() {
		return vipFlag;
	}

	public void setVipFlag(Byte vipFlag) {
		this.vipFlag = vipFlag;
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
        return "ExpertSubscribeDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", expertUserId = " + expertUserId + 
				", questionTypeId = " + questionTypeId + 
				", questionDesc = " + questionDesc + 
				", replyUserId = " + replyUserId + 
				", replyContent = " + replyContent + 
				", replyTime = " + replyTime + 
				", subscribeStatus = " + subscribeStatus + 
				", price = " + price + 
				", payStatus = " + payStatus + 
				", payType = " + payType + 
				", transactionNo = " + transactionNo + 
				", vipFlag = " + vipFlag + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
