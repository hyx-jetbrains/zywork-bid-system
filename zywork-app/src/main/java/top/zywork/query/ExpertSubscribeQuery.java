package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ExpertSubscribeQuery查询对象类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class ExpertSubscribeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035366446647L;

    // 专家预约编号
	private Long id;
	// 专家预约编号（最小值）
	private Long idMin;
	// 专家预约编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 预约专家编号
	private Long expertUserId;
	// 预约专家编号（最小值）
	private Long expertUserIdMin;
	// 预约专家编号（最大值）
	private Long expertUserIdMax;
	// 问题类型编号
	private Long questionTypeId;
	// 问题类型编号（最小值）
	private Long questionTypeIdMin;
	// 问题类型编号（最大值）
	private Long questionTypeIdMax;
	// 问题说明
	private String questionDesc;
	// 回复用户编号
	private Long replyUserId;
	// 回复用户编号（最小值）
	private Long replyUserIdMin;
	// 回复用户编号（最大值）
	private Long replyUserIdMax;
	// 回复内容
	private String replyContent;
	// 回复时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTime;
	// 回复时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTimeMin;
	// 回复时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTimeMax;
	// 预约状态
	private String subscribeStatus;
	// 预约价格
	private Long price;
	// 预约价格（最小值）
	private Long priceMin;
	// 预约价格（最大值）
	private Long priceMax;
	// 支付状态
	private String payStatus;
	// 支付方式
	private String payType;
	// 交易编号
	private String transactionNo;
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
	
    public ExpertSubscribeQuery () {}

    public ExpertSubscribeQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long expertUserId, Long expertUserIdMin, Long expertUserIdMax, Long questionTypeId, Long questionTypeIdMin, Long questionTypeIdMax, String questionDesc, Long replyUserId, Long replyUserIdMin, Long replyUserIdMax, String replyContent, Date replyTime, Date replyTimeMin, Date replyTimeMax, String subscribeStatus, Long price, Long priceMin, Long priceMax, String payStatus, String payType, String transactionNo, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.expertUserId = expertUserId;
		this.expertUserIdMin = expertUserIdMin;
		this.expertUserIdMax = expertUserIdMax;
		this.questionTypeId = questionTypeId;
		this.questionTypeIdMin = questionTypeIdMin;
		this.questionTypeIdMax = questionTypeIdMax;
		this.questionDesc = questionDesc;
		this.replyUserId = replyUserId;
		this.replyUserIdMin = replyUserIdMin;
		this.replyUserIdMax = replyUserIdMax;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyTimeMin = replyTimeMin;
		this.replyTimeMax = replyTimeMax;
		this.subscribeStatus = subscribeStatus;
		this.price = price;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.payStatus = payStatus;
		this.payType = payType;
		this.transactionNo = transactionNo;
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

	public Long getExpertUserId() {
		return expertUserId;
	}

	public void setExpertUserId(Long expertUserId) {
		this.expertUserId = expertUserId;
	}

	public Long getExpertUserIdMin() {
		return expertUserIdMin;
	}

	public void setExpertUserIdMin(Long expertUserIdMin) {
		this.expertUserIdMin = expertUserIdMin;
	}

	public Long getExpertUserIdMax() {
		return expertUserIdMax;
	}

	public void setExpertUserIdMax(Long expertUserIdMax) {
		this.expertUserIdMax = expertUserIdMax;
	}

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public Long getQuestionTypeIdMin() {
		return questionTypeIdMin;
	}

	public void setQuestionTypeIdMin(Long questionTypeIdMin) {
		this.questionTypeIdMin = questionTypeIdMin;
	}

	public Long getQuestionTypeIdMax() {
		return questionTypeIdMax;
	}

	public void setQuestionTypeIdMax(Long questionTypeIdMax) {
		this.questionTypeIdMax = questionTypeIdMax;
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

	public Long getReplyUserIdMin() {
		return replyUserIdMin;
	}

	public void setReplyUserIdMin(Long replyUserIdMin) {
		this.replyUserIdMin = replyUserIdMin;
	}

	public Long getReplyUserIdMax() {
		return replyUserIdMax;
	}

	public void setReplyUserIdMax(Long replyUserIdMax) {
		this.replyUserIdMax = replyUserIdMax;
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

	public Date getReplyTimeMin() {
		return replyTimeMin;
	}

	public void setReplyTimeMin(Date replyTimeMin) {
		this.replyTimeMin = replyTimeMin;
	}

	public Date getReplyTimeMax() {
		return replyTimeMax;
	}

	public void setReplyTimeMax(Date replyTimeMax) {
		this.replyTimeMax = replyTimeMax;
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

	public Long getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Long priceMin) {
		this.priceMin = priceMin;
	}

	public Long getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Long priceMax) {
		this.priceMax = priceMax;
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
        return "ExpertSubscribeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", expertUserId = " + expertUserId + 
				", expertUserIdMin = " + expertUserIdMin + 
				", expertUserIdMax = " + expertUserIdMax + 
				", questionTypeId = " + questionTypeId + 
				", questionTypeIdMin = " + questionTypeIdMin + 
				", questionTypeIdMax = " + questionTypeIdMax + 
				", questionDesc = " + questionDesc + 
				", replyUserId = " + replyUserId + 
				", replyUserIdMin = " + replyUserIdMin + 
				", replyUserIdMax = " + replyUserIdMax + 
				", replyContent = " + replyContent + 
				", replyTime = " + replyTime + 
				", replyTimeMin = " + replyTimeMin + 
				", replyTimeMax = " + replyTimeMax + 
				", subscribeStatus = " + subscribeStatus + 
				", price = " + price + 
				", priceMin = " + priceMin + 
				", priceMax = " + priceMax + 
				", payStatus = " + payStatus + 
				", payType = " + payType + 
				", transactionNo = " + transactionNo + 
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
