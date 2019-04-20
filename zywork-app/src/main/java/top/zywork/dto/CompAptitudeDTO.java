package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompAptitudeDTO数据传输对象类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompAptitudeDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036006448578L;

    // 企业资质编号
	private Long id;
	// 企业编号
	private Long compId;
	// 证件号码
	private String certificateNum;
	// 资质详情
	private String certificateDetail;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CompAptitudeDTO () {}

    public CompAptitudeDTO (Long id, Long compId, String certificateNum, String certificateDetail, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.certificateNum = certificateNum;
		this.certificateDetail = certificateDetail;
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

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getCertificateDetail() {
		return certificateDetail;
	}

	public void setCertificateDetail(String certificateDetail) {
		this.certificateDetail = certificateDetail;
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
        return "CompAptitudeDTO {" +
                "id = " + id + 
				", compId = " + compId + 
				", certificateNum = " + certificateNum + 
				", certificateDetail = " + certificateDetail + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
