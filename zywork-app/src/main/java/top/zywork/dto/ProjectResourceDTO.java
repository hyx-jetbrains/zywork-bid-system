package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectResourceDTO数据传输对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ProjectResourceDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035156977338L;

    // 项目资源表主键
	private Long id;
	// 项目编号
	private Long projectId;
	// 资源编号
	private Long resourceId;
	// 资源类别
	private Byte resType;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ProjectResourceDTO () {}

    public ProjectResourceDTO (Long id, Long projectId, Long resourceId, Byte resType, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.projectId = projectId;
		this.resourceId = resourceId;
		this.resType = resType;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Byte getResType() {
		return resType;
	}

	public void setResType(Byte resType) {
		this.resType = resType;
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
        return "ProjectResourceDTO {" +
                "id = " + id + 
				", projectId = " + projectId + 
				", resourceId = " + resourceId + 
				", resType = " + resType + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
