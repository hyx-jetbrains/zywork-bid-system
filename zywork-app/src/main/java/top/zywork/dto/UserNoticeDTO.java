package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserNoticeDTO数据传输对象类<br/>
 *
 * 创建于2019-06-01<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserNoticeDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035588261297L;

    // 消息通知编号
	private Long id;
	// 用户编号
	private Long userId;
	// 链接编号
	private Long itemId;
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
	// 通知类型
	private Byte noticeType;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserNoticeDTO () {}

    public UserNoticeDTO (Long id, Long userId, Long itemId, String pageUrl, String title, String mainContent, String detailContent, Byte isRead, Byte noticeType, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.pageUrl = pageUrl;
		this.title = title;
		this.mainContent = mainContent;
		this.detailContent = detailContent;
		this.isRead = isRead;
		this.noticeType = noticeType;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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

	public Byte getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Byte noticeType) {
		this.noticeType = noticeType;
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
        return "UserNoticeDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", itemId = " + itemId + 
				", pageUrl = " + pageUrl + 
				", title = " + title + 
				", mainContent = " + mainContent + 
				", detailContent = " + detailContent + 
				", isRead = " + isRead + 
				", noticeType = " + noticeType + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
