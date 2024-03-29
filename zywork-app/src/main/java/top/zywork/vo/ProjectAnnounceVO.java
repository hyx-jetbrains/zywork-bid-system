package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProjectAnnounceVO值对象类<br/>
 *
 * 创建于2019-06-11<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class ProjectAnnounceVO extends BaseVO {

    private static final long serialVersionUID = -9223372034980587964L;

    // 公示编号
	private Long id;
	// 项目编号
	private Long projectId;
	// 标题
	@Size(min = 0, max = 65535, message = "必须小于65535个字符")
	private String title;
	// 项目类型
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String projectType;
	// 公示详情
	@Size(min = 0, max = 16777215, message = "必须小于16777215个字符")
	private String announceDesc;
	// 第一候选人
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String firstCandidate;
	// 建造师姓名
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String firstBuilderName;
	// 中标金额
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String firstMarkMoney;
	// 第二候选人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String secondCandidate;
	// 第三候选人
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String thirdCandidate;
	// 源地址
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String sourceUrl;
	// 内部地址
	@Size(min = 0, max = 300, message = "必须小于300个字符")
	private String inwordHtmlUrl;
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
	
    public ProjectAnnounceVO () {}

    public ProjectAnnounceVO (Long id, Long projectId, String title, String projectType, String announceDesc, String firstCandidate, String firstBuilderName, String firstMarkMoney, String secondCandidate, String thirdCandidate, String sourceUrl, String inwordHtmlUrl, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.projectId = projectId;
		this.title = title;
		this.projectType = projectType;
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
        return "ProjectAnnounceVO {" +
                "id = " + id + 
				", projectId = " + projectId + 
				", title = " + title + 
				", projectType = " + projectType + 
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
