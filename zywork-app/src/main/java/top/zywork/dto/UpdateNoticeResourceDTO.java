package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UpdateNoticeResourceDTO数据传输对象类<br/>
 *
 * 创建于2019-06-18<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UpdateNoticeResourceDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036051071935L;

    // 更新公告资源编号
	private Long id;
	// 更新公告编号
	private Long noticeId;
	// 资源编号
	private Long resourceId;
	// 版本号
	private Integer version;
	// 更新时间
	private Date updateTime;
	// 创建时间
	private Date createTime;
	// 是否激活
	private Byte isActive;
	
    public UpdateNoticeResourceDTO () {}

    public UpdateNoticeResourceDTO (Long id, Long noticeId, Long resourceId, Integer version, Date updateTime, Date createTime, Byte isActive) {
        this.id = id;
		this.noticeId = noticeId;
		this.resourceId = resourceId;
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

	public Long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
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
        return "UpdateNoticeResourceDTO {" +
                "id = " + id + 
				", noticeId = " + noticeId + 
				", resourceId = " + resourceId + 
				", version = " + version + 
				", updateTime = " + updateTime + 
				", createTime = " + createTime + 
				", isActive = " + isActive + 
				" }";
    }

}
