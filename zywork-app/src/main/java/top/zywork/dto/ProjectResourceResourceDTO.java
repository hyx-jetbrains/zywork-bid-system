package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectResourceResourceDTO数据传输对象类<br/>
 *
 * 创建于2019-05-24<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectResourceResourceDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036401511983L;

    //t_project_resource表的字段对应的属性
	// 项目资源表主键
	private Long projectResourceId;
	// 项目编号
	private Long projectResourceProjectId;
	// 资源编号
	private Long projectResourceResourceId;
	// 资源类别
	private Byte projectResourceResType;
	// 版本号
	private Integer projectResourceVersion;
	// 创建时间
	private Date projectResourceCreateTime;
	// 更新时间
	private Date projectResourceUpdateTime;
	// 是否激活
	private Byte projectResourceIsActive;
	//t_resource表的字段对应的属性
	// 用户编号
	private Long resourceUserId;
	// 资源类型
	private String resourceMimeType;
	// 资源地址
	private String resourceUrl;
	// 资源扩展名
	private String resourceExtension;
	
    public ProjectResourceResourceDTO () {}

    public ProjectResourceResourceDTO (Long projectResourceId, Long projectResourceProjectId, Long projectResourceResourceId, Byte projectResourceResType, Integer projectResourceVersion, Date projectResourceCreateTime, Date projectResourceUpdateTime, Byte projectResourceIsActive, Long resourceUserId, String resourceMimeType, String resourceUrl, String resourceExtension) {
        this.projectResourceId = projectResourceId;
		this.projectResourceProjectId = projectResourceProjectId;
		this.projectResourceResourceId = projectResourceResourceId;
		this.projectResourceResType = projectResourceResType;
		this.projectResourceVersion = projectResourceVersion;
		this.projectResourceCreateTime = projectResourceCreateTime;
		this.projectResourceUpdateTime = projectResourceUpdateTime;
		this.projectResourceIsActive = projectResourceIsActive;
		this.resourceUserId = resourceUserId;
		this.resourceMimeType = resourceMimeType;
		this.resourceUrl = resourceUrl;
		this.resourceExtension = resourceExtension;
		
    }

    public Long getProjectResourceId() {
		return projectResourceId;
	}

	public void setProjectResourceId(Long projectResourceId) {
		this.projectResourceId = projectResourceId;
	}

	public Long getProjectResourceProjectId() {
		return projectResourceProjectId;
	}

	public void setProjectResourceProjectId(Long projectResourceProjectId) {
		this.projectResourceProjectId = projectResourceProjectId;
	}

	public Long getProjectResourceResourceId() {
		return projectResourceResourceId;
	}

	public void setProjectResourceResourceId(Long projectResourceResourceId) {
		this.projectResourceResourceId = projectResourceResourceId;
	}

	public Byte getProjectResourceResType() {
		return projectResourceResType;
	}

	public void setProjectResourceResType(Byte projectResourceResType) {
		this.projectResourceResType = projectResourceResType;
	}

	public Integer getProjectResourceVersion() {
		return projectResourceVersion;
	}

	public void setProjectResourceVersion(Integer projectResourceVersion) {
		this.projectResourceVersion = projectResourceVersion;
	}

	public Date getProjectResourceCreateTime() {
		return projectResourceCreateTime;
	}

	public void setProjectResourceCreateTime(Date projectResourceCreateTime) {
		this.projectResourceCreateTime = projectResourceCreateTime;
	}

	public Date getProjectResourceUpdateTime() {
		return projectResourceUpdateTime;
	}

	public void setProjectResourceUpdateTime(Date projectResourceUpdateTime) {
		this.projectResourceUpdateTime = projectResourceUpdateTime;
	}

	public Byte getProjectResourceIsActive() {
		return projectResourceIsActive;
	}

	public void setProjectResourceIsActive(Byte projectResourceIsActive) {
		this.projectResourceIsActive = projectResourceIsActive;
	}

	public Long getResourceUserId() {
		return resourceUserId;
	}

	public void setResourceUserId(Long resourceUserId) {
		this.resourceUserId = resourceUserId;
	}

	public String getResourceMimeType() {
		return resourceMimeType;
	}

	public void setResourceMimeType(String resourceMimeType) {
		this.resourceMimeType = resourceMimeType;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getResourceExtension() {
		return resourceExtension;
	}

	public void setResourceExtension(String resourceExtension) {
		this.resourceExtension = resourceExtension;
	}

	
    @Override
    public String toString() {
        return "ProjectResourceResourceDTO {" +
                "projectResourceId = " + projectResourceId + 
				", projectResourceProjectId = " + projectResourceProjectId + 
				", projectResourceResourceId = " + projectResourceResourceId + 
				", projectResourceResType = " + projectResourceResType + 
				", projectResourceVersion = " + projectResourceVersion + 
				", projectResourceCreateTime = " + projectResourceCreateTime + 
				", projectResourceUpdateTime = " + projectResourceUpdateTime + 
				", projectResourceIsActive = " + projectResourceIsActive + 
				", resourceUserId = " + resourceUserId + 
				", resourceMimeType = " + resourceMimeType + 
				", resourceUrl = " + resourceUrl + 
				", resourceExtension = " + resourceExtension + 
				" }";
    }

}
