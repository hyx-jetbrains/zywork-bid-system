package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserExpertQuestionTypeVO值对象类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UserExpertQuestionTypeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035710566097L;

    // 专家类别编号
	private Long id;
	// 专家信息编号
	private Long userExpertId;
	// 问题类别编号
	private Long questionTypeId;
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
	
    public UserExpertQuestionTypeVO () {}

    public UserExpertQuestionTypeVO (Long id, Long userExpertId, Long questionTypeId, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userExpertId = userExpertId;
		this.questionTypeId = questionTypeId;
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

	public Long getUserExpertId() {
		return userExpertId;
	}

	public void setUserExpertId(Long userExpertId) {
		this.userExpertId = userExpertId;
	}

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
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
        return "UserExpertQuestionTypeVO {" +
                "id = " + id + 
				", userExpertId = " + userExpertId + 
				", questionTypeId = " + questionTypeId + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
