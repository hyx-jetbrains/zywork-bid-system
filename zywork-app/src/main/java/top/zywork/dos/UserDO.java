package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserDO数据对象实体类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserDO extends BaseDO {

    private static final long serialVersionUID = -9223372035448455418L;

    // 用户编号
	private Long id;
	// 手机号
	private String phone;
	// 用户邮箱
	private String email;
	// 登录密码
	private String password;
	// 加密盐值
	private String salt;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserDO () {}

    public UserDO (Long id, String phone, String email, String password, String salt, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.salt = salt;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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
        return "UserDO {" +
                "id = " + id + 
				", phone = " + phone + 
				", email = " + email + 
				", password = " + password + 
				", salt = " + salt + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
