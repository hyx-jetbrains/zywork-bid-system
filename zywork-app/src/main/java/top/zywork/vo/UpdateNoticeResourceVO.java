package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UpdateNoticeResourceVO值对象类<br/>
 *
 * 创建于2019-06-18<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UpdateNoticeResourceVO extends BaseVO {

    private static final long serialVersionUID = -9223372035824725801L;

    // 更新公告资源编号
	private Long id;
	// 更新公告编号
	private Long noticeId;
	// 资源编号
	private Long resourceId;
	// 版本号
	private Integer version;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 是否激活
	private Byte isActive;
	
    public UpdateNoticeResourceVO () {}

    public UpdateNoticeResourceVO (Long id, Long noticeId, Long resourceId, Integer version, Date updateTime, Date createTime, Byte isActive) {
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
        return "UpdateNoticeResourceVO {" +
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
