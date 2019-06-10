package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectAnnounceDO数据对象实体类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectAnnounceDO extends BaseDO {

    private static final long serialVersionUID = -9223372035115495800L;

    // 公示编号
	private Long id;
	// 项目编号
	private Long projectId;
	// 公示详情
	private String announceDesc;
	// 第一候选人
	private String firstCandidate;
	// 建造师姓名
	private String firstBuilderName;
	// 中标金额
	private String firstMarkMoney;
	// 第二候选人
	private String secondCandidate;
	// 第三候选人
	private String thirdCandidate;
	// 源地址
	private String sourceUrl;
	// 内部地址
	private String inwordHtmlUrl;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ProjectAnnounceDO () {}

    public ProjectAnnounceDO (Long id, Long projectId, String announceDesc, String firstCandidate, String firstBuilderName, String firstMarkMoney, String secondCandidate, String thirdCandidate, String sourceUrl, String inwordHtmlUrl, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.projectId = projectId;
		this.announceDesc = announceDesc;
		this.firstCandidate = firstCandidate;
		this.firstBuilderName = firstBuilderName;
		this.firstMarkMoney = firstMarkMoney;
		this.secondCandidate = secondCandidate;
		this.thirdCandidate = thirdCandidate;
		this.sourceUrl = sourceUrl;
		this.inwordHtmlUrl = inwordHtmlUrl;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getAnnounceDesc() {
		return announceDesc;
	}

	public void setAnnounceDesc(String announceDesc) {
		this.announceDesc = announceDesc;
	}

	public String getFirstCandidate() {
		return firstCandidate;
	}

	public void setFirstCandidate(String firstCandidate) {
		this.firstCandidate = firstCandidate;
	}

	public String getFirstBuilderName() {
		return firstBuilderName;
	}

	public void setFirstBuilderName(String firstBuilderName) {
		this.firstBuilderName = firstBuilderName;
	}

	public String getFirstMarkMoney() {
		return firstMarkMoney;
	}

	public void setFirstMarkMoney(String firstMarkMoney) {
		this.firstMarkMoney = firstMarkMoney;
	}

	public String getSecondCandidate() {
		return secondCandidate;
	}

	public void setSecondCandidate(String secondCandidate) {
		this.secondCandidate = secondCandidate;
	}

	public String getThirdCandidate() {
		return thirdCandidate;
	}

	public void setThirdCandidate(String thirdCandidate) {
		this.thirdCandidate = thirdCandidate;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getInwordHtmlUrl() {
		return inwordHtmlUrl;
	}

	public void setInwordHtmlUrl(String inwordHtmlUrl) {
		this.inwordHtmlUrl = inwordHtmlUrl;
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
        return "ProjectAnnounceDO {" +
                "id = " + id + 
				", projectId = " + projectId + 
				", announceDesc = " + announceDesc + 
				", firstCandidate = " + firstCandidate + 
				", firstBuilderName = " + firstBuilderName + 
				", firstMarkMoney = " + firstMarkMoney + 
				", secondCandidate = " + secondCandidate + 
				", thirdCandidate = " + thirdCandidate + 
				", sourceUrl = " + sourceUrl + 
				", inwordHtmlUrl = " + inwordHtmlUrl + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
