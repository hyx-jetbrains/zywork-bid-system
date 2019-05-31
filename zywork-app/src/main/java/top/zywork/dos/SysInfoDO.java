package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SysInfoDO数据对象实体类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class SysInfoDO extends BaseDO {

    private static final long serialVersionUID = -9223372035097977994L;

    // 系统信息编号
	private Long id;
	// 公司名称
	private String compName;
	// 头部图标
	private String headIcon;
	// 菜单小图标
	private String menuIconMin;
	// 菜单大图标
	private String menuIconMax;
	// 默认头像
	private String defaultHead;
	// 背景图片
	private String backgroundIcon;
	// 域名
	private String doMain;
	// 公司地址
	private String compAddr;
	// 公司电话
	private String compPhone;
	// 公司邮箱
	private String compEmail;
	// 公司说明
	private String compMemo;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public SysInfoDO () {}

    public SysInfoDO (Long id, String compName, String headIcon, String menuIconMin, String menuIconMax, String defaultHead, String backgroundIcon, String doMain, String compAddr, String compPhone, String compEmail, String compMemo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compName = compName;
		this.headIcon = headIcon;
		this.menuIconMin = menuIconMin;
		this.menuIconMax = menuIconMax;
		this.defaultHead = defaultHead;
		this.backgroundIcon = backgroundIcon;
		this.doMain = doMain;
		this.compAddr = compAddr;
		this.compPhone = compPhone;
		this.compEmail = compEmail;
		this.compMemo = compMemo;
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

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public String getMenuIconMin() {
		return menuIconMin;
	}

	public void setMenuIconMin(String menuIconMin) {
		this.menuIconMin = menuIconMin;
	}

	public String getMenuIconMax() {
		return menuIconMax;
	}

	public void setMenuIconMax(String menuIconMax) {
		this.menuIconMax = menuIconMax;
	}

	public String getDefaultHead() {
		return defaultHead;
	}

	public void setDefaultHead(String defaultHead) {
		this.defaultHead = defaultHead;
	}

	public String getBackgroundIcon() {
		return backgroundIcon;
	}

	public void setBackgroundIcon(String backgroundIcon) {
		this.backgroundIcon = backgroundIcon;
	}

	public String getDoMain() {
		return doMain;
	}

	public void setDoMain(String doMain) {
		this.doMain = doMain;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public String getCompPhone() {
		return compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public String getCompEmail() {
		return compEmail;
	}

	public void setCompEmail(String compEmail) {
		this.compEmail = compEmail;
	}

	public String getCompMemo() {
		return compMemo;
	}

	public void setCompMemo(String compMemo) {
		this.compMemo = compMemo;
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
        return "SysInfoDO {" +
                "id = " + id + 
				", compName = " + compName + 
				", headIcon = " + headIcon + 
				", menuIconMin = " + menuIconMin + 
				", menuIconMax = " + menuIconMax + 
				", defaultHead = " + defaultHead + 
				", backgroundIcon = " + backgroundIcon + 
				", doMain = " + doMain + 
				", compAddr = " + compAddr + 
				", compPhone = " + compPhone + 
				", compEmail = " + compEmail + 
				", compMemo = " + compMemo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
