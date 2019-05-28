package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ServiceDTO数据传输对象类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ServiceDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036071876608L;

    // 服务编号
	private Long id;
	// 服务标题
	private String title;
	// 详细说明
	private String memo;
	// 所有收费的url
	private String urls;
	// 服务价格
	private Long price;
	// 折扣
	private Integer discount;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ServiceDTO () {}

    public ServiceDTO (Long id, String title, String memo, String urls, Long price, Integer discount, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.memo = memo;
		this.urls = urls;
		this.price = price;
		this.discount = discount;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
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
        return "ServiceDTO {" +
                "id = " + id + 
				", title = " + title + 
				", memo = " + memo + 
				", urls = " + urls + 
				", price = " + price + 
				", discount = " + discount + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
