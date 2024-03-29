package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserBankcardVO值对象类<br/>
 *
 * 创建于2019-01-11<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserBankcardVO extends BaseVO {

    private static final long serialVersionUID = -9223372035219500461L;

    // 银行卡编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 持卡人姓名
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String accountName;
	// 银行代码
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String bankCode;
	// 银行名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String bankName;
	// 银行卡号
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 25, message = "必须是1-25个字符")
	private String bankcardNo;
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
	
    public UserBankcardVO () {}

    public UserBankcardVO (Long id, Long userId, String accountName, String bankCode, String bankName, String bankcardNo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.accountName = accountName;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankcardNo = bankcardNo;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankcardNo() {
		return bankcardNo;
	}

	public void setBankcardNo(String bankcardNo) {
		this.bankcardNo = bankcardNo;
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
        return "UserBankcardVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", accountName = " + accountName + 
				", bankCode = " + bankCode + 
				", bankName = " + bankName + 
				", bankcardNo = " + bankcardNo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
