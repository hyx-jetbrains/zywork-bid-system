package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ExpertSubscribeVO值对象类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ExpertSubscribeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035192790614L;

    // 专家预约编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 预约专家编号
	private Long expertUserId;
	// 问题类别编号
	private Long questionTypeId;
	// 问题说明
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String questionDesc;
	// 回复用户编号
	private Long replyUserId;
	// 回复内容
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String replyContent;
	// 回复时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTime;
	// 预约状态
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String subscribeStatus;
	// 预约价格
	private Long price;
	// 支付状态
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String payStatus;
	// 支付方式
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String payType;
	// 交易编号
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String transactionNo;
	// 预约标识
	private Byte vipFlag;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ExpertSubscribeVO () {}

    public ExpertSubscribeVO (Long id, Long userId, Long expertUserId, Long questionTypeId, String questionDesc, Long replyUserId, String replyContent, Date replyTime, String subscribeStatus, Long price, String payStatus, String payType, String transactionNo, Byte vipFlag, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
        return "ExpertSubscribeVO {" +
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
