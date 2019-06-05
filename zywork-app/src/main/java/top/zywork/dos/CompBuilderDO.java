package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CompBuilderDO数据对象实体类<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class CompBuilderDO extends BaseDO {

    private static final long serialVersionUID = -9223372035264683632L;

    // 企业建造师编号
	private Long id;
	// 企业编号
	private Long compId;
	// 姓名
	private String name;
	// 性别
	private String gender;
	// 注册证件号码
	private String regNum;
	// 专业等级
	private String majorLevel;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public CompBuilderDO () {}

    public CompBuilderDO (Long id, Long compId, String name, String gender, String regNum, String majorLevel, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.compId = compId;
		this.name = name;
		this.gender = gender;
		this.regNum = regNum;
		this.majorLevel = majorLevel;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getMajorLevel() {
		return majorLevel;
	}

	public void setMajorLevel(String majorLevel) {
		this.majorLevel = majorLevel;
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
        return "CompBuilderDO {" +
                "id = " + id + 
				", compId = " + compId + 
				", name = " + name + 
				", gender = " + gender + 
				", regNum = " + regNum + 
				", majorLevel = " + majorLevel + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
