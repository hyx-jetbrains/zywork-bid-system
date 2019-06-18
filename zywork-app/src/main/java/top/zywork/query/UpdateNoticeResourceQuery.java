package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UpdateNoticeResourceQuery查询对象类<br/>
 *
 * 创建于2019-06-18<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class UpdateNoticeResourceQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035293806679L;

    // 更新公告资源编号
	private Long id;
	// 更新公告资源编号（最小值）
	private Long idMin;
	// 更新公告资源编号（最大值）
	private Long idMax;
	// 更新公告编号
	private Long noticeId;
	// 更新公告编号（最小值）
	private Long noticeIdMin;
	// 更新公告编号（最大值）
	private Long noticeIdMax;
	// 资源编号
	private Long resourceId;
	// 资源编号（最小值）
	private Long resourceIdMin;
	// 资源编号（最大值）
	private Long resourceIdMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public UpdateNoticeResourceQuery () {}

    public UpdateNoticeResourceQuery (Long id, Long idMin, Long idMax, Long noticeId, Long noticeIdMin, Long noticeIdMax, Long resourceId, Long resourceIdMin, Long resourceIdMax, Integer version, Integer versionMin, Integer versionMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Date createTime, Date createTimeMin, Date createTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.noticeId = noticeId;
		this.noticeIdMin = noticeIdMin;
		this.noticeIdMax = noticeIdMax;
		this.resourceId = resourceId;
		this.resourceIdMin = resourceIdMin;
		this.resourceIdMax = resourceIdMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}

	public Long getNoticeIdMin() {
		return noticeIdMin;
	}

	public void setNoticeIdMin(Long noticeIdMin) {
		this.noticeIdMin = noticeIdMin;
	}

	public Long getNoticeIdMax() {
		return noticeIdMax;
	}

	public void setNoticeIdMax(Long noticeIdMax) {
		this.noticeIdMax = noticeIdMax;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getResourceIdMin() {
		return resourceIdMin;
	}

	public void setResourceIdMin(Long resourceIdMin) {
		this.resourceIdMin = resourceIdMin;
	}

	public Long getResourceIdMax() {
		return resourceIdMax;
	}

	public void setResourceIdMax(Long resourceIdMax) {
		this.resourceIdMax = resourceIdMax;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "UpdateNoticeResourceQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", noticeId = " + noticeId + 
				", noticeIdMin = " + noticeIdMin + 
				", noticeIdMax = " + noticeIdMax + 
				", resourceId = " + resourceId + 
				", resourceIdMin = " + resourceIdMin + 
				", resourceIdMax = " + resourceIdMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
