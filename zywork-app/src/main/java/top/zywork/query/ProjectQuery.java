package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectQuery查询对象类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public class ProjectQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035046657404L;

    // 招投标项目编号
	private Long id;
	// 招投标项目编号（最小值）
	private Long idMin;
	// 招投标项目编号（最大值）
	private Long idMax;
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
	// 资金落实(%)（最小值）
	private Float moneyToImplementMin;
	// 资金落实(%)（最大值）
	private Float moneyToImplementMax;
	// 招标代理
	private String tenderingAgent;
	// 联系电话
	private String phone;
	// 要约价(元)
	private BigDecimal offerPrice;
	// 要约价(元)（最小值）
	private BigDecimal offerPriceMin;
	// 要约价(元)（最大值）
	private BigDecimal offerPriceMax;
	// 保证金(万元)
	private BigDecimal assurePrice;
	// 保证金(万元)（最小值）
	private BigDecimal assurePriceMin;
	// 保证金(万元)（最大值）
	private BigDecimal assurePriceMax;
	// 工期(天)
	private Integer constructionPeriod;
	// 工期(天)（最小值）
	private Integer constructionPeriodMin;
	// 工期(天)（最大值）
	private Integer constructionPeriodMax;
	// 下载截止时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date downloadEndTime;
	// 下载截止时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date downloadEndTimeMin;
	// 下载截止时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date downloadEndTimeMax;
	// 其他要求
	private String otherDemand;
	// 开标信息
	private String openMarkInfo;
	// 开标时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTime;
	// 开标时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTimeMin;
	// 开标时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openMarkTimeMax;
	// 开标地点
	private String openMarkAddr;
	// 开标状态
	private String markStatus;
	// 中标单位
	private String inMarkComp;
	// 公告时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date noticeTime;
	// 公告时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date noticeTimeMin;
	// 公告时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date noticeTimeMax;
	// 点击次数
	private Long clickCount;
	// 点击次数（最小值）
	private Long clickCountMin;
	// 点击次数（最大值）
	private Long clickCountMax;
	// 是否电子标
	private Byte isElectronic;
	// 是否电子标（最小值）
	private Byte isElectronicMin;
	// 是否电子标（最大值）
	private Byte isElectronicMax;
	// 源地址
	private String sourceUrl;
	// 内部地址
	private String inwardHtmlUrl;
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
	// 附件个数
	private Integer resourceCount;

	public Integer getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(Integer resourceCount) {
		this.resourceCount = resourceCount;
	}
    public ProjectQuery () {}

    public ProjectQuery (Long id, Long idMin, Long idMax, String title, String projectType, String city, String projectDetail, String releaseStatus, String markUnitName, String projectInvest, String checkPattern, String compAptitudeType, String builderLevel, Float moneyToImplement, Float moneyToImplementMin, Float moneyToImplementMax, String tenderingAgent, String phone, BigDecimal offerPrice, BigDecimal offerPriceMin, BigDecimal offerPriceMax, BigDecimal assurePrice, BigDecimal assurePriceMin, BigDecimal assurePriceMax, Integer constructionPeriod, Integer constructionPeriodMin, Integer constructionPeriodMax, Date downloadEndTime, Date downloadEndTimeMin, Date downloadEndTimeMax, String otherDemand, String openMarkInfo, Date openMarkTime, Date openMarkTimeMin, Date openMarkTimeMax, String openMarkAddr, String markStatus, String inMarkComp, Date noticeTime, Date noticeTimeMin, Date noticeTimeMax, Long clickCount, Long clickCountMin, Long clickCountMax, Byte isElectronic, Byte isElectronicMin, Byte isElectronicMax, String sourceUrl, String inwardHtmlUrl, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
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
		this.moneyToImplementMin = moneyToImplementMin;
		this.moneyToImplementMax = moneyToImplementMax;
		this.tenderingAgent = tenderingAgent;
		this.phone = phone;
		this.offerPrice = offerPrice;
		this.offerPriceMin = offerPriceMin;
		this.offerPriceMax = offerPriceMax;
		this.assurePrice = assurePrice;
		this.assurePriceMin = assurePriceMin;
		this.assurePriceMax = assurePriceMax;
		this.constructionPeriod = constructionPeriod;
		this.constructionPeriodMin = constructionPeriodMin;
		this.constructionPeriodMax = constructionPeriodMax;
		this.downloadEndTime = downloadEndTime;
		this.downloadEndTimeMin = downloadEndTimeMin;
		this.downloadEndTimeMax = downloadEndTimeMax;
		this.otherDemand = otherDemand;
		this.openMarkInfo = openMarkInfo;
		this.openMarkTime = openMarkTime;
		this.openMarkTimeMin = openMarkTimeMin;
		this.openMarkTimeMax = openMarkTimeMax;
		this.openMarkAddr = openMarkAddr;
		this.markStatus = markStatus;
		this.inMarkComp = inMarkComp;
		this.noticeTime = noticeTime;
		this.noticeTimeMin = noticeTimeMin;
		this.noticeTimeMax = noticeTimeMax;
		this.clickCount = clickCount;
		this.clickCountMin = clickCountMin;
		this.clickCountMax = clickCountMax;
		this.isElectronic = isElectronic;
		this.isElectronicMin = isElectronicMin;
		this.isElectronicMax = isElectronicMax;
		this.sourceUrl = sourceUrl;
		this.inwardHtmlUrl = inwardHtmlUrl;
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

	public Float getMoneyToImplementMin() {
		return moneyToImplementMin;
	}

	public void setMoneyToImplementMin(Float moneyToImplementMin) {
		this.moneyToImplementMin = moneyToImplementMin;
	}

	public Float getMoneyToImplementMax() {
		return moneyToImplementMax;
	}

	public void setMoneyToImplementMax(Float moneyToImplementMax) {
		this.moneyToImplementMax = moneyToImplementMax;
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

	public BigDecimal getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(BigDecimal offerPrice) {
		this.offerPrice = offerPrice;
	}

	public BigDecimal getOfferPriceMin() {
		return offerPriceMin;
	}

	public void setOfferPriceMin(BigDecimal offerPriceMin) {
		this.offerPriceMin = offerPriceMin;
	}

	public BigDecimal getOfferPriceMax() {
		return offerPriceMax;
	}

	public void setOfferPriceMax(BigDecimal offerPriceMax) {
		this.offerPriceMax = offerPriceMax;
	}

	public BigDecimal getAssurePrice() {
		return assurePrice;
	}

	public void setAssurePrice(BigDecimal assurePrice) {
		this.assurePrice = assurePrice;
	}

	public BigDecimal getAssurePriceMin() {
		return assurePriceMin;
	}

	public void setAssurePriceMin(BigDecimal assurePriceMin) {
		this.assurePriceMin = assurePriceMin;
	}

	public BigDecimal getAssurePriceMax() {
		return assurePriceMax;
	}

	public void setAssurePriceMax(BigDecimal assurePriceMax) {
		this.assurePriceMax = assurePriceMax;
	}

	public Integer getConstructionPeriod() {
		return constructionPeriod;
	}

	public void setConstructionPeriod(Integer constructionPeriod) {
		this.constructionPeriod = constructionPeriod;
	}

	public Integer getConstructionPeriodMin() {
		return constructionPeriodMin;
	}

	public void setConstructionPeriodMin(Integer constructionPeriodMin) {
		this.constructionPeriodMin = constructionPeriodMin;
	}

	public Integer getConstructionPeriodMax() {
		return constructionPeriodMax;
	}

	public void setConstructionPeriodMax(Integer constructionPeriodMax) {
		this.constructionPeriodMax = constructionPeriodMax;
	}

	public Date getDownloadEndTime() {
		return downloadEndTime;
	}

	public void setDownloadEndTime(Date downloadEndTime) {
		this.downloadEndTime = downloadEndTime;
	}

	public Date getDownloadEndTimeMin() {
		return downloadEndTimeMin;
	}

	public void setDownloadEndTimeMin(Date downloadEndTimeMin) {
		this.downloadEndTimeMin = downloadEndTimeMin;
	}

	public Date getDownloadEndTimeMax() {
		return downloadEndTimeMax;
	}

	public void setDownloadEndTimeMax(Date downloadEndTimeMax) {
		this.downloadEndTimeMax = downloadEndTimeMax;
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

	public Date getOpenMarkTimeMin() {
		return openMarkTimeMin;
	}

	public void setOpenMarkTimeMin(Date openMarkTimeMin) {
		this.openMarkTimeMin = openMarkTimeMin;
	}

	public Date getOpenMarkTimeMax() {
		return openMarkTimeMax;
	}

	public void setOpenMarkTimeMax(Date openMarkTimeMax) {
		this.openMarkTimeMax = openMarkTimeMax;
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

	public Date getNoticeTimeMin() {
		return noticeTimeMin;
	}

	public void setNoticeTimeMin(Date noticeTimeMin) {
		this.noticeTimeMin = noticeTimeMin;
	}

	public Date getNoticeTimeMax() {
		return noticeTimeMax;
	}

	public void setNoticeTimeMax(Date noticeTimeMax) {
		this.noticeTimeMax = noticeTimeMax;
	}

	public Long getClickCount() {
		return clickCount;
	}

	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}

	public Long getClickCountMin() {
		return clickCountMin;
	}

	public void setClickCountMin(Long clickCountMin) {
		this.clickCountMin = clickCountMin;
	}

	public Long getClickCountMax() {
		return clickCountMax;
	}

	public void setClickCountMax(Long clickCountMax) {
		this.clickCountMax = clickCountMax;
	}

	public Byte getIsElectronic() {
		return isElectronic;
	}

	public void setIsElectronic(Byte isElectronic) {
		this.isElectronic = isElectronic;
	}

	public Byte getIsElectronicMin() {
		return isElectronicMin;
	}

	public void setIsElectronicMin(Byte isElectronicMin) {
		this.isElectronicMin = isElectronicMin;
	}

	public Byte getIsElectronicMax() {
		return isElectronicMax;
	}

	public void setIsElectronicMax(Byte isElectronicMax) {
		this.isElectronicMax = isElectronicMax;
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
        return "ProjectQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
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
				", moneyToImplementMin = " + moneyToImplementMin + 
				", moneyToImplementMax = " + moneyToImplementMax + 
				", tenderingAgent = " + tenderingAgent + 
				", phone = " + phone + 
				", offerPrice = " + offerPrice + 
				", offerPriceMin = " + offerPriceMin + 
				", offerPriceMax = " + offerPriceMax + 
				", assurePrice = " + assurePrice + 
				", assurePriceMin = " + assurePriceMin + 
				", assurePriceMax = " + assurePriceMax + 
				", constructionPeriod = " + constructionPeriod + 
				", constructionPeriodMin = " + constructionPeriodMin + 
				", constructionPeriodMax = " + constructionPeriodMax + 
				", downloadEndTime = " + downloadEndTime + 
				", downloadEndTimeMin = " + downloadEndTimeMin + 
				", downloadEndTimeMax = " + downloadEndTimeMax + 
				", otherDemand = " + otherDemand + 
				", openMarkInfo = " + openMarkInfo + 
				", openMarkTime = " + openMarkTime + 
				", openMarkTimeMin = " + openMarkTimeMin + 
				", openMarkTimeMax = " + openMarkTimeMax + 
				", openMarkAddr = " + openMarkAddr + 
				", markStatus = " + markStatus + 
				", inMarkComp = " + inMarkComp + 
				", noticeTime = " + noticeTime + 
				", noticeTimeMin = " + noticeTimeMin + 
				", noticeTimeMax = " + noticeTimeMax + 
				", clickCount = " + clickCount + 
				", clickCountMin = " + clickCountMin + 
				", clickCountMax = " + clickCountMax + 
				", isElectronic = " + isElectronic + 
				", isElectronicMin = " + isElectronicMin + 
				", isElectronicMax = " + isElectronicMax + 
				", sourceUrl = " + sourceUrl + 
				", inwardHtmlUrl = " + inwardHtmlUrl + 
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
