package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectDTO数据传输对象类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class ProjectDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036584410823L;

    // 招投标项目编号
	private Long id;
	// 项目名称
	private String title;
	// 项目类型
	private String projectType;
	// 城市
	private String city;
	// 项目详情
	private String projectDetail;
	// 发布状态
	private String releaseStatus;
	// 招标单位名称
	private String markUnitName;
	// 项目投资
	private String projectInvest;
	// 审查方式
	private String checkPattern;
	// 企业资质类型
	private String compAptitudeType;
	// 建造师等级
	private String builderLevel;
	// 资金落实(%)
	private Float moneyToImplement;
	// 招标代理
	private String tenderingAgent;
	// 联系电话
	private String phone;
	// 要约价(元)
	private String offerPrice;
	// 保证金(万元)
	private String assurePrice;
	// 工期(天)
	private Integer constructionPeriod;
	// 下载截止时间
	private Date downloadEndTime;
	// 其他要求
	private String otherDemand;
	// 开标信息
	private String openMarkInfo;
	// 开标时间
	private Date openMarkTime;
	// 开标地点
	private String openMarkAddr;
	// 开标状态
	private String markStatus;
	// 中标单位
	private String inMarkComp;
	// 公告时间
	private Date noticeTime;
	// 点击次数
	private Long clickCount;
	// 是否电子标
	private Byte isElectronic;
	// 源地址
	private String sourceUrl;
	// 内部地址
	private String inwardHtmlUrl;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	// 附件个数
	private Integer resourceCount;
	// 是否可以申请保函
	private Byte isGuarantee;

	public Byte getIsGuarantee() {
		return isGuarantee;
	}

	public void setIsGuarantee(Byte isGuarantee) {
		this.isGuarantee = isGuarantee;
	}
	public Integer getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(Integer resourceCount) {
		this.resourceCount = resourceCount;
	}
    public ProjectDTO () {}

    public ProjectDTO (Long id, String title, String projectType, String city, String projectDetail, String releaseStatus, String markUnitName, String projectInvest, String checkPattern, String compAptitudeType, String builderLevel, Float moneyToImplement, String tenderingAgent, String phone, String offerPrice, String assurePrice, Integer constructionPeriod, Date downloadEndTime, String otherDemand, String openMarkInfo, Date openMarkTime, String openMarkAddr, String markStatus, String inMarkComp, Date noticeTime, Long clickCount, Byte isElectronic, String sourceUrl, String inwardHtmlUrl, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
		this.markStatus = markStatus;
		this.inMarkComp = inMarkComp;
		this.noticeTime = noticeTime;
		this.clickCount = clickCount;
		this.isElectronic = isElectronic;
		this.sourceUrl = sourceUrl;
		this.inwardHtmlUrl = inwardHtmlUrl;
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

	public String getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getAssurePrice() {
		return assurePrice;
	}

	public void setAssurePrice(String assurePrice) {
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

	public String getMarkStatus() {
		return markStatus;
	}

	public void setMarkStatus(String markStatus) {
		this.markStatus = markStatus;
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

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getInwardHtmlUrl() {
		return inwardHtmlUrl;
	}

	public void setInwardHtmlUrl(String inwardHtmlUrl) {
		this.inwardHtmlUrl = inwardHtmlUrl;
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
        return "ProjectDTO {" +
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
				", markStatus = " + markStatus + 
				", inMarkComp = " + inMarkComp + 
				", noticeTime = " + noticeTime + 
				", clickCount = " + clickCount + 
				", isElectronic = " + isElectronic + 
				", sourceUrl = " + sourceUrl + 
				", inwardHtmlUrl = " + inwardHtmlUrl + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
