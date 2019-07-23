package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * AdvertisementVO值对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class AdvertisementVO extends BaseVO {

    private static final long serialVersionUID = -9223372035236721523L;

    // 轮播广告编号
	private Long id;
	// 轮播图标题
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String title;
	// 内容
	@Size(min = 0, max = 5000, message = "必须小于5000个字符")
	private String content;
	// 图片地址
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String imgUrl;
	// URL链接
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String url;
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
	
    public AdvertisementVO () {}

    public AdvertisementVO (Long id, String title, String content, String imgUrl, String url, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
		this.url = url;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
        return "AdvertisementVO {" +
                "id = " + id + 
				", title = " + title + 
				", content = " + content + 
				", imgUrl = " + imgUrl + 
				", url = " + url + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
