package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * OftenQuestionDTO数据传输对象类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class OftenQuestionDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035346860121L;

    // 常见问题编号
	private Long id;
	// 问题类别编号
	private Long questionTypeId;
	// 问题标题
	private String title;
	// 问题解答
	private String content;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public OftenQuestionDTO () {}

    public OftenQuestionDTO (Long id, Long questionTypeId, String title, String content, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.questionTypeId = questionTypeId;
		this.title = title;
		this.content = content;
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

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
        return "OftenQuestionDTO {" +
                "id = " + id + 
				", questionTypeId = " + questionTypeId + 
				", title = " + title + 
				", content = " + content + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
