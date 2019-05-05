package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * AptitudeResourceVO值对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class AptitudeResourceVO extends BaseVO {

    private static final long serialVersionUID = -9223372035636392430L;

    // 资质资源编号
	private Long id;
	// 资质编号
	@NotNull(message = "此项是必须项")
	private Long aptitudeId;
	// 资源编号
	@NotNull(message = "此项是必须项")
	private Long resourceId;
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
	
    public AptitudeResourceVO () {}

    public AptitudeResourceVO (Long id, Long aptitudeId, Long resourceId, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.aptitudeId = aptitudeId;
		this.resourceId = resourceId;
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

	public Long getAptitudeId() {
		return aptitudeId;
	}

	public void setAptitudeId(Long aptitudeId) {
		this.aptitudeId = aptitudeId;
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
        return "AptitudeResourceVO {" +
                "id = " + id + 
				", aptitudeId = " + aptitudeId + 
				", resourceId = " + resourceId + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
