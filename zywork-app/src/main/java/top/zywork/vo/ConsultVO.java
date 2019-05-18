package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ConsultVO值对象类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class ConsultVO extends BaseVO {

    private static final long serialVersionUID = -9223372035550667319L;

    // 咨询编号
	private Long id;
	// 用户编号
	private Long userId;
	// 问题类别编号
	@NotNull(message = "此项是必须项")
	private Long questionTypeId;
	// 问题说明
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String consultDesc;
	// 回复人编号
	private Long replyUserId;
	// 回复内容
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String replyContent;
	// 回复时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTime;
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
	
    public ConsultVO () {}

    public ConsultVO (Long id, Long userId, Long questionTypeId, String consultDesc, Long replyUserId, String replyContent, Date replyTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.questionTypeId = questionTypeId;
		this.consultDesc = consultDesc;
		this.replyUserId = replyUserId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
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

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getConsultDesc() {
		return consultDesc;
	}

	public void setConsultDesc(String consultDesc) {
		this.consultDesc = consultDesc;
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
        return "ConsultVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", questionTypeId = " + questionTypeId + 
				", consultDesc = " + consultDesc + 
				", replyUserId = " + replyUserId + 
				", replyContent = " + replyContent + 
				", replyTime = " + replyTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
