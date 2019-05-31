package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SysInfoQuery查询对象类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class SysInfoQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035831363918L;

    // 系统信息编号
	private Long id;
	// 系统信息编号（最小值）
	private Long idMin;
	// 系统信息编号（最大值）
	private Long idMax;
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
	
    public SysInfoQuery () {}

    public SysInfoQuery (Long id, Long idMin, Long idMax, String compName, String headIcon, String menuIconMin, String menuIconMax, String defaultHead, String backgroundIcon, String doMain, String compAddr, String compPhone, String compEmail, String compMemo, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
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
        return "SysInfoQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
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
