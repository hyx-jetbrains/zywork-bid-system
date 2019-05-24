package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectResourceResourceQuery查询对象类<br/>
 *
 * 创建于2019-05-24<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectResourceResourceQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036818974622L;

    //t_project_resource表的字段对应的属性
	// 项目资源表主键
	private Long projectResourceId;
	// 项目资源表主键（最小值）
	private Long projectResourceIdMin;
	// 项目资源表主键（最大值）
	private Long projectResourceIdMax;
	// 项目编号
	private Long projectResourceProjectId;
	// 项目编号（最小值）
	private Long projectResourceProjectIdMin;
	// 项目编号（最大值）
	private Long projectResourceProjectIdMax;
	// 资源编号
	private Long projectResourceResourceId;
	// 资源编号（最小值）
	private Long projectResourceResourceIdMin;
	// 资源编号（最大值）
	private Long projectResourceResourceIdMax;
	// 资源类别
	private Byte projectResourceResType;
	// 资源类别（最小值）
	private Byte projectResourceResTypeMin;
	// 资源类别（最大值）
	private Byte projectResourceResTypeMax;
	// 版本号
	private Integer projectResourceVersion;
	// 版本号（最小值）
	private Integer projectResourceVersionMin;
	// 版本号（最大值）
	private Integer projectResourceVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date projectResourceUpdateTimeMax;
	// 是否激活
	private Byte projectResourceIsActive;
	// 是否激活（最小值）
	private Byte projectResourceIsActiveMin;
	// 是否激活（最大值）
	private Byte projectResourceIsActiveMax;
	//t_resource表的字段对应的属性
	// 用户编号
	private Long resourceUserId;
	// 用户编号（最小值）
	private Long resourceUserIdMin;
	// 用户编号（最大值）
	private Long resourceUserIdMax;
	// 资源类型
	private String resourceMimeType;
	// 资源地址
	private String resourceUrl;
	// 资源扩展名
	private String resourceExtension;
	
    public ProjectResourceResourceQuery () {}

    public ProjectResourceResourceQuery (Long projectResourceId, Long projectResourceIdMin, Long projectResourceIdMax, Long projectResourceProjectId, Long projectResourceProjectIdMin, Long projectResourceProjectIdMax, Long projectResourceResourceId, Long projectResourceResourceIdMin, Long projectResourceResourceIdMax, Byte projectResourceResType, Byte projectResourceResTypeMin, Byte projectResourceResTypeMax, Integer projectResourceVersion, Integer projectResourceVersionMin, Integer projectResourceVersionMax, Date projectResourceCreateTime, Date projectResourceCreateTimeMin, Date projectResourceCreateTimeMax, Date projectResourceUpdateTime, Date projectResourceUpdateTimeMin, Date projectResourceUpdateTimeMax, Byte projectResourceIsActive, Byte projectResourceIsActiveMin, Byte projectResourceIsActiveMax, Long resourceUserId, Long resourceUserIdMin, Long resourceUserIdMax, String resourceMimeType, String resourceUrl, String resourceExtension) {
        this.projectResourceId = projectResourceId;
		this.projectResourceIdMin = projectResourceIdMin;
		this.projectResourceIdMax = projectResourceIdMax;
		this.projectResourceProjectId = projectResourceProjectId;
		this.projectResourceProjectIdMin = projectResourceProjectIdMin;
		this.projectResourceProjectIdMax = projectResourceProjectIdMax;
		this.projectResourceResourceId = projectResourceResourceId;
		this.projectResourceResourceIdMin = projectResourceResourceIdMin;
		this.projectResourceResourceIdMax = projectResourceResourceIdMax;
		this.projectResourceResType = projectResourceResType;
		this.projectResourceResTypeMin = projectResourceResTypeMin;
		this.projectResourceResTypeMax = projectResourceResTypeMax;
		this.projectResourceVersion = projectResourceVersion;
		this.projectResourceVersionMin = projectResourceVersionMin;
		this.projectResourceVersionMax = projectResourceVersionMax;
		this.projectResourceCreateTime = projectResourceCreateTime;
		this.projectResourceCreateTimeMin = projectResourceCreateTimeMin;
		this.projectResourceCreateTimeMax = projectResourceCreateTimeMax;
		this.projectResourceUpdateTime = projectResourceUpdateTime;
		this.projectResourceUpdateTimeMin = projectResourceUpdateTimeMin;
		this.projectResourceUpdateTimeMax = projectResourceUpdateTimeMax;
		this.projectResourceIsActive = projectResourceIsActive;
		this.projectResourceIsActiveMin = projectResourceIsActiveMin;
		this.projectResourceIsActiveMax = projectResourceIsActiveMax;
		this.resourceUserId = resourceUserId;
		this.resourceUserIdMin = resourceUserIdMin;
		this.resourceUserIdMax = resourceUserIdMax;
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

	public Long getProjectResourceIdMin() {
		return projectResourceIdMin;
	}

	public void setProjectResourceIdMin(Long projectResourceIdMin) {
		this.projectResourceIdMin = projectResourceIdMin;
	}

	public Long getProjectResourceIdMax() {
		return projectResourceIdMax;
	}

	public void setProjectResourceIdMax(Long projectResourceIdMax) {
		this.projectResourceIdMax = projectResourceIdMax;
	}

	public Long getProjectResourceProjectId() {
		return projectResourceProjectId;
	}

	public void setProjectResourceProjectId(Long projectResourceProjectId) {
		this.projectResourceProjectId = projectResourceProjectId;
	}

	public Long getProjectResourceProjectIdMin() {
		return projectResourceProjectIdMin;
	}

	public void setProjectResourceProjectIdMin(Long projectResourceProjectIdMin) {
		this.projectResourceProjectIdMin = projectResourceProjectIdMin;
	}

	public Long getProjectResourceProjectIdMax() {
		return projectResourceProjectIdMax;
	}

	public void setProjectResourceProjectIdMax(Long projectResourceProjectIdMax) {
		this.projectResourceProjectIdMax = projectResourceProjectIdMax;
	}

	public Long getProjectResourceResourceId() {
		return projectResourceResourceId;
	}

	public void setProjectResourceResourceId(Long projectResourceResourceId) {
		this.projectResourceResourceId = projectResourceResourceId;
	}

	public Long getProjectResourceResourceIdMin() {
		return projectResourceResourceIdMin;
	}

	public void setProjectResourceResourceIdMin(Long projectResourceResourceIdMin) {
		this.projectResourceResourceIdMin = projectResourceResourceIdMin;
	}

	public Long getProjectResourceResourceIdMax() {
		return projectResourceResourceIdMax;
	}

	public void setProjectResourceResourceIdMax(Long projectResourceResourceIdMax) {
		this.projectResourceResourceIdMax = projectResourceResourceIdMax;
	}

	public Byte getProjectResourceResType() {
		return projectResourceResType;
	}

	public void setProjectResourceResType(Byte projectResourceResType) {
		this.projectResourceResType = projectResourceResType;
	}

	public Byte getProjectResourceResTypeMin() {
		return projectResourceResTypeMin;
	}

	public void setProjectResourceResTypeMin(Byte projectResourceResTypeMin) {
		this.projectResourceResTypeMin = projectResourceResTypeMin;
	}

	public Byte getProjectResourceResTypeMax() {
		return projectResourceResTypeMax;
	}

	public void setProjectResourceResTypeMax(Byte projectResourceResTypeMax) {
		this.projectResourceResTypeMax = projectResourceResTypeMax;
	}

	public Integer getProjectResourceVersion() {
		return projectResourceVersion;
	}

	public void setProjectResourceVersion(Integer projectResourceVersion) {
		this.projectResourceVersion = projectResourceVersion;
	}

	public Integer getProjectResourceVersionMin() {
		return projectResourceVersionMin;
	}

	public void setProjectResourceVersionMin(Integer projectResourceVersionMin) {
		this.projectResourceVersionMin = projectResourceVersionMin;
	}

	public Integer getProjectResourceVersionMax() {
		return projectResourceVersionMax;
	}

	public void setProjectResourceVersionMax(Integer projectResourceVersionMax) {
		this.projectResourceVersionMax = projectResourceVersionMax;
	}

	public Date getProjectResourceCreateTime() {
		return projectResourceCreateTime;
	}

	public void setProjectResourceCreateTime(Date projectResourceCreateTime) {
		this.projectResourceCreateTime = projectResourceCreateTime;
	}

	public Date getProjectResourceCreateTimeMin() {
		return projectResourceCreateTimeMin;
	}

	public void setProjectResourceCreateTimeMin(Date projectResourceCreateTimeMin) {
		this.projectResourceCreateTimeMin = projectResourceCreateTimeMin;
	}

	public Date getProjectResourceCreateTimeMax() {
		return projectResourceCreateTimeMax;
	}

	public void setProjectResourceCreateTimeMax(Date projectResourceCreateTimeMax) {
		this.projectResourceCreateTimeMax = projectResourceCreateTimeMax;
	}

	public Date getProjectResourceUpdateTime() {
		return projectResourceUpdateTime;
	}

	public void setProjectResourceUpdateTime(Date projectResourceUpdateTime) {
		this.projectResourceUpdateTime = projectResourceUpdateTime;
	}

	public Date getProjectResourceUpdateTimeMin() {
		return projectResourceUpdateTimeMin;
	}

	public void setProjectResourceUpdateTimeMin(Date projectResourceUpdateTimeMin) {
		this.projectResourceUpdateTimeMin = projectResourceUpdateTimeMin;
	}

	public Date getProjectResourceUpdateTimeMax() {
		return projectResourceUpdateTimeMax;
	}

	public void setProjectResourceUpdateTimeMax(Date projectResourceUpdateTimeMax) {
		this.projectResourceUpdateTimeMax = projectResourceUpdateTimeMax;
	}

	public Byte getProjectResourceIsActive() {
		return projectResourceIsActive;
	}

	public void setProjectResourceIsActive(Byte projectResourceIsActive) {
		this.projectResourceIsActive = projectResourceIsActive;
	}

	public Byte getProjectResourceIsActiveMin() {
		return projectResourceIsActiveMin;
	}

	public void setProjectResourceIsActiveMin(Byte projectResourceIsActiveMin) {
		this.projectResourceIsActiveMin = projectResourceIsActiveMin;
	}

	public Byte getProjectResourceIsActiveMax() {
		return projectResourceIsActiveMax;
	}

	public void setProjectResourceIsActiveMax(Byte projectResourceIsActiveMax) {
		this.projectResourceIsActiveMax = projectResourceIsActiveMax;
	}

	public Long getResourceUserId() {
		return resourceUserId;
	}

	public void setResourceUserId(Long resourceUserId) {
		this.resourceUserId = resourceUserId;
	}

	public Long getResourceUserIdMin() {
		return resourceUserIdMin;
	}

	public void setResourceUserIdMin(Long resourceUserIdMin) {
		this.resourceUserIdMin = resourceUserIdMin;
	}

	public Long getResourceUserIdMax() {
		return resourceUserIdMax;
	}

	public void setResourceUserIdMax(Long resourceUserIdMax) {
		this.resourceUserIdMax = resourceUserIdMax;
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
        return "ProjectResourceResourceQuery {" +
                "projectResourceId = " + projectResourceId + 
				", projectResourceIdMin = " + projectResourceIdMin + 
				", projectResourceIdMax = " + projectResourceIdMax + 
				", projectResourceProjectId = " + projectResourceProjectId + 
				", projectResourceProjectIdMin = " + projectResourceProjectIdMin + 
				", projectResourceProjectIdMax = " + projectResourceProjectIdMax + 
				", projectResourceResourceId = " + projectResourceResourceId + 
				", projectResourceResourceIdMin = " + projectResourceResourceIdMin + 
				", projectResourceResourceIdMax = " + projectResourceResourceIdMax + 
				", projectResourceResType = " + projectResourceResType + 
				", projectResourceResTypeMin = " + projectResourceResTypeMin + 
				", projectResourceResTypeMax = " + projectResourceResTypeMax + 
				", projectResourceVersion = " + projectResourceVersion + 
				", projectResourceVersionMin = " + projectResourceVersionMin + 
				", projectResourceVersionMax = " + projectResourceVersionMax + 
				", projectResourceCreateTime = " + projectResourceCreateTime + 
				", projectResourceCreateTimeMin = " + projectResourceCreateTimeMin + 
				", projectResourceCreateTimeMax = " + projectResourceCreateTimeMax + 
				", projectResourceUpdateTime = " + projectResourceUpdateTime + 
				", projectResourceUpdateTimeMin = " + projectResourceUpdateTimeMin + 
				", projectResourceUpdateTimeMax = " + projectResourceUpdateTimeMax + 
				", projectResourceIsActive = " + projectResourceIsActive + 
				", projectResourceIsActiveMin = " + projectResourceIsActiveMin + 
				", projectResourceIsActiveMax = " + projectResourceIsActiveMax + 
				", resourceUserId = " + resourceUserId + 
				", resourceUserIdMin = " + resourceUserIdMin + 
				", resourceUserIdMax = " + resourceUserIdMax + 
				", resourceMimeType = " + resourceMimeType + 
				", resourceUrl = " + resourceUrl + 
				", resourceExtension = " + resourceExtension + 
				" }";
    }

}
