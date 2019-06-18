package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UpdateNoticeDO数据对象实体类<br/>
 *
 * 创建于2019-05-27<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UpdateNoticeDO extends BaseDO {

    private static final long serialVersionUID = -9223372036694798022L;

    // 更新公告编号
	private Long id;
	// 公告标题
	private String title;
	// 公告内容
	private String content;
	// 公告简介
	private String synopsis;
	// 版本号
	private Integer version;
	// 更新时间
	private Date updateTime;
	// 创建时间
	private Date createTime;
	// 是否激活
	private Byte isActive;
	// 资源编号
	private Long resourceId;

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public UpdateNoticeDO () {}

    public UpdateNoticeDO (Long id, String title, String content, String synopsis, Integer version, Date updateTime, Date createTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.content = content;
		this.synopsis = synopsis;
		this.version = version;
		this.updateTime = updateTime;
		this.createTime = createTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "UpdateNoticeDO {" +
                "id = " + id + 
				", title = " + title + 
				", content = " + content + 
				", synopsis = " + synopsis + 
				", version = " + version + 
				", updateTime = " + updateTime + 
				", createTime = " + createTime + 
				", isActive = " + isActive + 
				" }";
    }

}
