package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectVO值对象类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ProjectVO extends BaseVO {

    private static final long serialVersionUID = -9223372036124834920L;

    // 招投标项目编号
	private Long id;
	// 项目名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 32, message = "必须是1-32个字符")
	private String title;
	// 项目类型
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String projectType;
	// 城市
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String city;
	// 项目详情
	@Size(min = 0, max = 2000, message = "必须小于2000个字符")
	private String projectDetail;
	// 发布状态
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String releaseStatus;
	// 招标单位名称
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String markUnitName;
	// 项目投资
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String projectInvest;
	// 审查方式
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String checkPattern;
	// 企业资质类型
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String compAptitudeType;
	// 建造师等级
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String builderLevel;
	// 资金落实(%)
	private Float moneyToImplement;
	// 招标代理
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String tenderingAgent;
	// 联系电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String phone;
	// 要约价(元)
	private Long offerPrice;
	// 保证金(万元)
	private Long assurePrice;
	// 工期(天)
	private Integer constructionPeriod;
	// 下载截止时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date downloadEndTime;
	// 其他要求
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String otherDemand;
	// 开标信息
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String openMarkInfo;
	// 开标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTime;
	// 开标地点
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String openMarkAddr;
	// 中标公示
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String inMarkPublicity;
	// 中标单位
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String inMarkComp;
	// 公告时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date noticeTime;
	// 点击次数
	private Long clickCount;
	// 是否电子标
	private Byte isElectronic;
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
	
    public ProjectVO () {}

    public ProjectVO (Long id, String title, String projectType, String city, String projectDetail, String releaseStatus, String markUnitName, String projectInvest, String checkPattern, String compAptitudeType, String builderLevel, Float moneyToImplement, String tenderingAgent, String phone, Long offerPrice, Long assurePrice, Integer constructionPeriod, Date downloadEndTime, String otherDemand, String openMarkInfo, Date openMarkTime, String openMarkAddr, String inMarkPublicity, String inMarkComp, Date noticeTime, Long clickCount, Byte isElectronic, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.projectType = projectType;
		this.city = city;
		this.projectDetail = projectDetail;
		this.releaseStatus = releaseStatus;
		this.markUnitName = markUnitName;
		this.projectInvest = projectInvest;
		this.checkPattern = checkPattern;
		this.compAptitudeType = compAptitudeType;
		this.builderLevel = builderLevel;
		this.moneyToImplement = moneyToImplement;
		this.tenderingAgent = tenderingAgent;
		this.phone = phone;
		this.offerPrice = offerPrice;
		this.assurePrice = assurePrice;
		this.constructionPeriod = constructionPeriod;
		this.downloadEndTime = downloadEndTime;
		this.otherDemand = otherDemand;
		this.openMarkInfo = openMarkInfo;
		this.openMarkTime = openMarkTime;
		this.openMarkAddr = openMarkAddr;
		this.inMarkPublicity = inMarkPublicity;
		this.inMarkComp = inMarkComp;
		this.noticeTime = noticeTime;
		this.clickCount = clickCount;
		this.isElectronic = isElectronic;
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

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getMarkUnitName() {
		return markUnitName;
	}

	public void setMarkUnitName(String markUnitName) {
		this.markUnitName = markUnitName;
	}

	public String getProjectInvest() {
		return projectInvest;
	}

	public void setProjectInvest(String projectInvest) {
		this.projectInvest = projectInvest;
	}

	public String getCheckPattern() {
		return checkPattern;
	}

	public void setCheckPattern(String checkPattern) {
		this.checkPattern = checkPattern;
	}

	public String getCompAptitudeType() {
		return compAptitudeType;
	}

	public void setCompAptitudeType(String compAptitudeType) {
		this.compAptitudeType = compAptitudeType;
	}

	public String getBuilderLevel() {
		return builderLevel;
	}

	public void setBuilderLevel(String builderLevel) {
		this.builderLevel = builderLevel;
	}

	public Float getMoneyToImplement() {
		return moneyToImplement;
	}

	public void setMoneyToImplement(Float moneyToImplement) {
		this.moneyToImplement = moneyToImplement;
	}

	public String getTenderingAgent() {
		return tenderingAgent;
	}

	public void setTenderingAgent(String tenderingAgent) {
		this.tenderingAgent = tenderingAgent;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Long offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Long getAssurePrice() {
		return assurePrice;
	}

	public void setAssurePrice(Long assurePrice) {
		this.assurePrice = assurePrice;
	}

	public Integer getConstructionPeriod() {
		return constructionPeriod;
	}

	public void setConstructionPeriod(Integer constructionPeriod) {
		this.constructionPeriod = constructionPeriod;
	}

	public Date getDownloadEndTime() {
		return downloadEndTime;
	}

	public void setDownloadEndTime(Date downloadEndTime) {
		this.downloadEndTime = downloadEndTime;
	}

	public String getOtherDemand() {
		return otherDemand;
	}

	public void setOtherDemand(String otherDemand) {
		this.otherDemand = otherDemand;
	}

	public String getOpenMarkInfo() {
		return openMarkInfo;
	}

	public void setOpenMarkInfo(String openMarkInfo) {
		this.openMarkInfo = openMarkInfo;
	}

	public Date getOpenMarkTime() {
		return openMarkTime;
	}

	public void setOpenMarkTime(Date openMarkTime) {
		this.openMarkTime = openMarkTime;
	}

	public String getOpenMarkAddr() {
		return openMarkAddr;
	}

	public void setOpenMarkAddr(String openMarkAddr) {
		this.openMarkAddr = openMarkAddr;
	}

	public String getInMarkPublicity() {
		return inMarkPublicity;
	}

	public void setInMarkPublicity(String inMarkPublicity) {
		this.inMarkPublicity = inMarkPublicity;
	}

	public String getInMarkComp() {
		return inMarkComp;
	}

	public void setInMarkComp(String inMarkComp) {
		this.inMarkComp = inMarkComp;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public Long getClickCount() {
		return clickCount;
	}

	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}

	public Byte getIsElectronic() {
		return isElectronic;
	}

	public void setIsElectronic(Byte isElectronic) {
		this.isElectronic = isElectronic;
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
        return "ProjectVO {" +
                "id = " + id + 
				", title = " + title + 
				", projectType = " + projectType + 
				", city = " + city + 
				", projectDetail = " + projectDetail + 
				", releaseStatus = " + releaseStatus + 
				", markUnitName = " + markUnitName + 
				", projectInvest = " + projectInvest + 
				", checkPattern = " + checkPattern + 
				", compAptitudeType = " + compAptitudeType + 
				", builderLevel = " + builderLevel + 
				", moneyToImplement = " + moneyToImplement + 
				", tenderingAgent = " + tenderingAgent + 
				", phone = " + phone + 
				", offerPrice = " + offerPrice + 
				", assurePrice = " + assurePrice + 
				", constructionPeriod = " + constructionPeriod + 
				", downloadEndTime = " + downloadEndTime + 
				", otherDemand = " + otherDemand + 
				", openMarkInfo = " + openMarkInfo + 
				", openMarkTime = " + openMarkTime + 
				", openMarkAddr = " + openMarkAddr + 
				", inMarkPublicity = " + inMarkPublicity + 
				", inMarkComp = " + inMarkComp + 
				", noticeTime = " + noticeTime + 
				", clickCount = " + clickCount + 
				", isElectronic = " + isElectronic + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}