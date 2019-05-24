package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectResourceResourceVO值对象类<br/>
 *
 * 创建于2019-05-24<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectResourceResourceVO extends BaseVO {

    private static final long serialVersionUID = -9223372036325395359L;

    //t_project_resource表的字段对应的属性
	// 项目资源表主键
	private Long projectResourceId;
	// 项目编号
	@NotNull(message = "此项是必须项")
	private Long projectResourceProjectId;
	// 资源编号
	@NotNull(message = "此项是必须项")
	private Long projectResourceResourceId;
	// 资源类别
	@NotNull(message = "此项是必须项")
	private Byte projectResourceResType;
	// 版本号
	private Integer projectResourceVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceUpdateTime;
	// 是否激活
	private Byte projectResourceIsActive;
	//t_resource表的字段对应的属性
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long resourceUserId;
	// 资源类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String resourceMimeType;
	// 资源地址
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String resourceUrl;
	// 资源扩展名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String resourceExtension;
	
    public ProjectResourceResourceVO () {}

    public ProjectResourceResourceVO (Long projectResourceId, Long projectResourceProjectId, Long projectResourceResourceId, Byte projectResourceResType, Integer projectResourceVersion, Date projectResourceCreateTime, Date projectResourceUpdateTime, Byte projectResourceIsActive, Long resourceUserId, String resourceMimeType, String resourceUrl, String resourceExtension) {
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
        return "ProjectResourceResourceVO {" +
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
