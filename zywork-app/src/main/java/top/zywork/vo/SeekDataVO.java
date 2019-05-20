package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SeekDataVO值对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SeekDataVO extends BaseVO {

    private static final long serialVersionUID = -9223372036005265463L;

    // 求带资料编号
	private Long id;
	// 用户编号
	private Long userId;
	// 出发地点
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String startAddr;
	// 目的地
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String endAddr;
	// 资料类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String dataType;
	// 资料数量
	@NotNull(message = "此项是必须项")
	private Integer dataCount;
	// 最晚时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date latestTime;
	// 赏金
	private Long price;
	// 联系电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
	// 是否加急
	private Integer isUrgent;
	// 备注
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String memo;
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
	
    public SeekDataVO () {}

    public SeekDataVO (Long id, Long userId, String startAddr, String endAddr, String dataType, Integer dataCount, Date latestTime, Long price, String phone, Integer isUrgent, String memo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.startAddr = startAddr;
		this.endAddr = endAddr;
		this.dataType = dataType;
		this.dataCount = dataCount;
		this.latestTime = latestTime;
		this.price = price;
		this.phone = phone;
		this.isUrgent = isUrgent;
		this.memo = memo;
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

	public String getStartAddr() {
		return startAddr;
	}

	public void setStartAddr(String startAddr) {
		this.startAddr = startAddr;
	}

	public String getEndAddr() {
		return endAddr;
	}

	public void setEndAddr(String endAddr) {
		this.endAddr = endAddr;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}

	public Date getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Integer isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
        return "SeekDataVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", startAddr = " + startAddr + 
				", endAddr = " + endAddr + 
				", dataType = " + dataType + 
				", dataCount = " + dataCount + 
				", latestTime = " + latestTime + 
				", price = " + price + 
				", phone = " + phone + 
				", isUrgent = " + isUrgent + 
				", memo = " + memo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
