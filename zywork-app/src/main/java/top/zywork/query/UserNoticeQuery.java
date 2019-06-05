package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserNoticeQuery查询对象类<br/>
 *
 * 创建于2019-06-01<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserNoticeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036167020904L;

    // 消息通知编号
	private Long id;
	// 消息通知编号（最小值）
	private Long idMin;
	// 消息通知编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 链接编号
	private Long itemId;
	// 链接编号（最小值）
	private Long itemIdMin;
	// 链接编号（最大值）
	private Long itemIdMax;
	// 页面路径
	private String pageUrl;
	// 项目名称
	private String title;
	// 主要内容
	private String mainContent;
	// 详细内容
	private String detailContent;
	// 是否已读
	private Byte isRead;
	// 是否已读（最小值）
	private Byte isReadMin;
	// 是否已读（最大值）
	private Byte isReadMax;
	// 通知类型
	private Byte noticeType;
	// 通知类型（最小值）
	private Byte noticeTypeMin;
	// 通知类型（最大值）
	private Byte noticeTypeMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public UserNoticeQuery () {}

    public UserNoticeQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long itemId, Long itemIdMin, Long itemIdMax, String pageUrl, String title, String mainContent, String detailContent, Byte isRead, Byte isReadMin, Byte isReadMax, Byte noticeType, Byte noticeTypeMin, Byte noticeTypeMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.itemId = itemId;
		this.itemIdMin = itemIdMin;
		this.itemIdMax = itemIdMax;
		this.pageUrl = pageUrl;
		this.title = title;
		this.mainContent = mainContent;
		this.detailContent = detailContent;
		this.isRead = isRead;
		this.isReadMin = isReadMin;
		this.isReadMax = isReadMax;
		this.noticeType = noticeType;
		this.noticeTypeMin = noticeTypeMin;
		this.noticeTypeMax = noticeTypeMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemIdMin() {
		return itemIdMin;
	}

	public void setItemIdMin(Long itemIdMin) {
		this.itemIdMin = itemIdMin;
	}

	public Long getItemIdMax() {
		return itemIdMax;
	}

	public void setItemIdMax(Long itemIdMax) {
		this.itemIdMax = itemIdMax;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainContent() {
		return mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

	public String getDetailContent() {
		return detailContent;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public Byte getIsRead() {
		return isRead;
	}

	public void setIsRead(Byte isRead) {
		this.isRead = isRead;
	}

	public Byte getIsReadMin() {
		return isReadMin;
	}

	public void setIsReadMin(Byte isReadMin) {
		this.isReadMin = isReadMin;
	}

	public Byte getIsReadMax() {
		return isReadMax;
	}

	public void setIsReadMax(Byte isReadMax) {
		this.isReadMax = isReadMax;
	}

	public Byte getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Byte noticeType) {
		this.noticeType = noticeType;
	}

	public Byte getNoticeTypeMin() {
		return noticeTypeMin;
	}

	public void setNoticeTypeMin(Byte noticeTypeMin) {
		this.noticeTypeMin = noticeTypeMin;
	}

	public Byte getNoticeTypeMax() {
		return noticeTypeMax;
	}

	public void setNoticeTypeMax(Byte noticeTypeMax) {
		this.noticeTypeMax = noticeTypeMax;
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
        return "UserNoticeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", itemId = " + itemId + 
				", itemIdMin = " + itemIdMin + 
				", itemIdMax = " + itemIdMax + 
				", pageUrl = " + pageUrl + 
				", title = " + title + 
				", mainContent = " + mainContent + 
				", detailContent = " + detailContent + 
				", isRead = " + isRead + 
				", isReadMin = " + isReadMin + 
				", isReadMax = " + isReadMax + 
				", noticeType = " + noticeType + 
				", noticeTypeMin = " + noticeTypeMin + 
				", noticeTypeMax = " + noticeTypeMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
