package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ArticleDTO数据传输对象类<br/>
 *
 * 创建于2019-02-21<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ArticleDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035090998868L;

    // 文章编号
	private Long id;
	// 类别编号
	private Long categoryId;
	// 文章标题
	private String title;
	// 封面图片
	private String coverImg;
	// 文章摘要
	private String summary;
	// 文章内容
	private String content;
	// 阅读量
	private Integer viewCount;
	// 版本号
	private Integer version;
	// 创建人编号
	private Long createId;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ArticleDTO () {}

    public ArticleDTO (Long id, Long categoryId, String title, String coverImg, String summary, String content, Integer viewCount, Integer version, Long createId, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.coverImg = coverImg;
		this.summary = summary;
		this.content = content;
		this.viewCount = viewCount;
		this.version = version;
		this.createId = createId;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
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
        return "ArticleDTO {" +
                "id = " + id + 
				", categoryId = " + categoryId + 
				", title = " + title + 
				", coverImg = " + coverImg + 
				", summary = " + summary + 
				", content = " + content + 
				", viewCount = " + viewCount + 
				", version = " + version + 
				", createId = " + createId + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
