package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserBuilderReqQuery查询对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserBuilderReqQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036759543846L;

    //t_builder_req表的字段对应的属性
	// 建造师需求编号
	private Long builderReqId;
	// 建造师需求编号（最小值）
	private Long builderReqIdMin;
	// 建造师需求编号（最大值）
	private Long builderReqIdMax;
	// 用户编号
	private Long builderReqUserId;
	// 用户编号（最小值）
	private Long builderReqUserIdMin;
	// 用户编号（最大值）
	private Long builderReqUserIdMax;
	// 姓名
	private String builderReqName;
	// 手机号
	private String builderReqPhone;
	// 说明
	private String builderReqMemo;
	// 所需人才
	private String builderReqPeople;
	// 所需人数
	private Integer builderReqPeopleCount;
	// 所需人数（最小值）
	private Integer builderReqPeopleCountMin;
	// 所需人数（最大值）
	private Integer builderReqPeopleCountMax;
	// 提供年薪
	private Long builderReqSalary;
	// 提供年薪（最小值）
	private Long builderReqSalaryMin;
	// 提供年薪（最大值）
	private Long builderReqSalaryMax;
	// 企业地址
	private String builderReqCompAddr;
	// 企业名称
	private String builderReqCompName;
	// 版本号
	private Integer builderReqVersion;
	// 版本号（最小值）
	private Integer builderReqVersionMin;
	// 版本号（最大值）
	private Integer builderReqVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderReqCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderReqCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderReqCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderReqUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderReqUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date builderReqUpdateTimeMax;
	// 是否激活
	private Byte builderReqIsActive;
	// 是否激活（最小值）
	private Byte builderReqIsActiveMin;
	// 是否激活（最大值）
	private Byte builderReqIsActiveMax;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserBuilderReqQuery () {}

    public UserBuilderReqQuery (Long builderReqId, Long builderReqIdMin, Long builderReqIdMax, Long builderReqUserId, Long builderReqUserIdMin, Long builderReqUserIdMax, String builderReqName, String builderReqPhone, String builderReqMemo, String builderReqPeople, Integer builderReqPeopleCount, Integer builderReqPeopleCountMin, Integer builderReqPeopleCountMax, Long builderReqSalary, Long builderReqSalaryMin, Long builderReqSalaryMax, String builderReqCompAddr, String builderReqCompName, Integer builderReqVersion, Integer builderReqVersionMin, Integer builderReqVersionMax, Date builderReqCreateTime, Date builderReqCreateTimeMin, Date builderReqCreateTimeMax, Date builderReqUpdateTime, Date builderReqUpdateTimeMin, Date builderReqUpdateTimeMax, Byte builderReqIsActive, Byte builderReqIsActiveMin, Byte builderReqIsActiveMax, String userDetailNickname, String userDetailHeadicon) {
        this.builderReqId = builderReqId;
		this.builderReqIdMin = builderReqIdMin;
		this.builderReqIdMax = builderReqIdMax;
		this.builderReqUserId = builderReqUserId;
		this.builderReqUserIdMin = builderReqUserIdMin;
		this.builderReqUserIdMax = builderReqUserIdMax;
		this.builderReqName = builderReqName;
		this.builderReqPhone = builderReqPhone;
		this.builderReqMemo = builderReqMemo;
		this.builderReqPeople = builderReqPeople;
		this.builderReqPeopleCount = builderReqPeopleCount;
		this.builderReqPeopleCountMin = builderReqPeopleCountMin;
		this.builderReqPeopleCountMax = builderReqPeopleCountMax;
		this.builderReqSalary = builderReqSalary;
		this.builderReqSalaryMin = builderReqSalaryMin;
		this.builderReqSalaryMax = builderReqSalaryMax;
		this.builderReqCompAddr = builderReqCompAddr;
		this.builderReqCompName = builderReqCompName;
		this.builderReqVersion = builderReqVersion;
		this.builderReqVersionMin = builderReqVersionMin;
		this.builderReqVersionMax = builderReqVersionMax;
		this.builderReqCreateTime = builderReqCreateTime;
		this.builderReqCreateTimeMin = builderReqCreateTimeMin;
		this.builderReqCreateTimeMax = builderReqCreateTimeMax;
		this.builderReqUpdateTime = builderReqUpdateTime;
		this.builderReqUpdateTimeMin = builderReqUpdateTimeMin;
		this.builderReqUpdateTimeMax = builderReqUpdateTimeMax;
		this.builderReqIsActive = builderReqIsActive;
		this.builderReqIsActiveMin = builderReqIsActiveMin;
		this.builderReqIsActiveMax = builderReqIsActiveMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getBuilderReqId() {
		return builderReqId;
	}

	public void setBuilderReqId(Long builderReqId) {
		this.builderReqId = builderReqId;
	}

	public Long getBuilderReqIdMin() {
		return builderReqIdMin;
	}

	public void setBuilderReqIdMin(Long builderReqIdMin) {
		this.builderReqIdMin = builderReqIdMin;
	}

	public Long getBuilderReqIdMax() {
		return builderReqIdMax;
	}

	public void setBuilderReqIdMax(Long builderReqIdMax) {
		this.builderReqIdMax = builderReqIdMax;
	}

	public Long getBuilderReqUserId() {
		return builderReqUserId;
	}

	public void setBuilderReqUserId(Long builderReqUserId) {
		this.builderReqUserId = builderReqUserId;
	}

	public Long getBuilderReqUserIdMin() {
		return builderReqUserIdMin;
	}

	public void setBuilderReqUserIdMin(Long builderReqUserIdMin) {
		this.builderReqUserIdMin = builderReqUserIdMin;
	}

	public Long getBuilderReqUserIdMax() {
		return builderReqUserIdMax;
	}

	public void setBuilderReqUserIdMax(Long builderReqUserIdMax) {
		this.builderReqUserIdMax = builderReqUserIdMax;
	}

	public String getBuilderReqName() {
		return builderReqName;
	}

	public void setBuilderReqName(String builderReqName) {
		this.builderReqName = builderReqName;
	}

	public String getBuilderReqPhone() {
		return builderReqPhone;
	}

	public void setBuilderReqPhone(String builderReqPhone) {
		this.builderReqPhone = builderReqPhone;
	}

	public String getBuilderReqMemo() {
		return builderReqMemo;
	}

	public void setBuilderReqMemo(String builderReqMemo) {
		this.builderReqMemo = builderReqMemo;
	}

	public String getBuilderReqPeople() {
		return builderReqPeople;
	}

	public void setBuilderReqPeople(String builderReqPeople) {
		this.builderReqPeople = builderReqPeople;
	}

	public Integer getBuilderReqPeopleCount() {
		return builderReqPeopleCount;
	}

	public void setBuilderReqPeopleCount(Integer builderReqPeopleCount) {
		this.builderReqPeopleCount = builderReqPeopleCount;
	}

	public Integer getBuilderReqPeopleCountMin() {
		return builderReqPeopleCountMin;
	}

	public void setBuilderReqPeopleCountMin(Integer builderReqPeopleCountMin) {
		this.builderReqPeopleCountMin = builderReqPeopleCountMin;
	}

	public Integer getBuilderReqPeopleCountMax() {
		return builderReqPeopleCountMax;
	}

	public void setBuilderReqPeopleCountMax(Integer builderReqPeopleCountMax) {
		this.builderReqPeopleCountMax = builderReqPeopleCountMax;
	}

	public Long getBuilderReqSalary() {
		return builderReqSalary;
	}

	public void setBuilderReqSalary(Long builderReqSalary) {
		this.builderReqSalary = builderReqSalary;
	}

	public Long getBuilderReqSalaryMin() {
		return builderReqSalaryMin;
	}

	public void setBuilderReqSalaryMin(Long builderReqSalaryMin) {
		this.builderReqSalaryMin = builderReqSalaryMin;
	}

	public Long getBuilderReqSalaryMax() {
		return builderReqSalaryMax;
	}

	public void setBuilderReqSalaryMax(Long builderReqSalaryMax) {
		this.builderReqSalaryMax = builderReqSalaryMax;
	}

	public String getBuilderReqCompAddr() {
		return builderReqCompAddr;
	}

	public void setBuilderReqCompAddr(String builderReqCompAddr) {
		this.builderReqCompAddr = builderReqCompAddr;
	}

	public String getBuilderReqCompName() {
		return builderReqCompName;
	}

	public void setBuilderReqCompName(String builderReqCompName) {
		this.builderReqCompName = builderReqCompName;
	}

	public Integer getBuilderReqVersion() {
		return builderReqVersion;
	}

	public void setBuilderReqVersion(Integer builderReqVersion) {
		this.builderReqVersion = builderReqVersion;
	}

	public Integer getBuilderReqVersionMin() {
		return builderReqVersionMin;
	}

	public void setBuilderReqVersionMin(Integer builderReqVersionMin) {
		this.builderReqVersionMin = builderReqVersionMin;
	}

	public Integer getBuilderReqVersionMax() {
		return builderReqVersionMax;
	}

	public void setBuilderReqVersionMax(Integer builderReqVersionMax) {
		this.builderReqVersionMax = builderReqVersionMax;
	}

	public Date getBuilderReqCreateTime() {
		return builderReqCreateTime;
	}

	public void setBuilderReqCreateTime(Date builderReqCreateTime) {
		this.builderReqCreateTime = builderReqCreateTime;
	}

	public Date getBuilderReqCreateTimeMin() {
		return builderReqCreateTimeMin;
	}

	public void setBuilderReqCreateTimeMin(Date builderReqCreateTimeMin) {
		this.builderReqCreateTimeMin = builderReqCreateTimeMin;
	}

	public Date getBuilderReqCreateTimeMax() {
		return builderReqCreateTimeMax;
	}

	public void setBuilderReqCreateTimeMax(Date builderReqCreateTimeMax) {
		this.builderReqCreateTimeMax = builderReqCreateTimeMax;
	}

	public Date getBuilderReqUpdateTime() {
		return builderReqUpdateTime;
	}

	public void setBuilderReqUpdateTime(Date builderReqUpdateTime) {
		this.builderReqUpdateTime = builderReqUpdateTime;
	}

	public Date getBuilderReqUpdateTimeMin() {
		return builderReqUpdateTimeMin;
	}

	public void setBuilderReqUpdateTimeMin(Date builderReqUpdateTimeMin) {
		this.builderReqUpdateTimeMin = builderReqUpdateTimeMin;
	}

	public Date getBuilderReqUpdateTimeMax() {
		return builderReqUpdateTimeMax;
	}

	public void setBuilderReqUpdateTimeMax(Date builderReqUpdateTimeMax) {
		this.builderReqUpdateTimeMax = builderReqUpdateTimeMax;
	}

	public Byte getBuilderReqIsActive() {
		return builderReqIsActive;
	}

	public void setBuilderReqIsActive(Byte builderReqIsActive) {
		this.builderReqIsActive = builderReqIsActive;
	}

	public Byte getBuilderReqIsActiveMin() {
		return builderReqIsActiveMin;
	}

	public void setBuilderReqIsActiveMin(Byte builderReqIsActiveMin) {
		this.builderReqIsActiveMin = builderReqIsActiveMin;
	}

	public Byte getBuilderReqIsActiveMax() {
		return builderReqIsActiveMax;
	}

	public void setBuilderReqIsActiveMax(Byte builderReqIsActiveMax) {
		this.builderReqIsActiveMax = builderReqIsActiveMax;
	}

	public String getUserDetailNickname() {
		return userDetailNickname;
	}

	public void setUserDetailNickname(String userDetailNickname) {
		this.userDetailNickname = userDetailNickname;
	}

	public String getUserDetailHeadicon() {
		return userDetailHeadicon;
	}

	public void setUserDetailHeadicon(String userDetailHeadicon) {
		this.userDetailHeadicon = userDetailHeadicon;
	}

	
    @Override
    public String toString() {
        return "UserBuilderReqQuery {" +
                "builderReqId = " + builderReqId + 
				", builderReqIdMin = " + builderReqIdMin + 
				", builderReqIdMax = " + builderReqIdMax + 
				", builderReqUserId = " + builderReqUserId + 
				", builderReqUserIdMin = " + builderReqUserIdMin + 
				", builderReqUserIdMax = " + builderReqUserIdMax + 
				", builderReqName = " + builderReqName + 
				", builderReqPhone = " + builderReqPhone + 
				", builderReqMemo = " + builderReqMemo + 
				", builderReqPeople = " + builderReqPeople + 
				", builderReqPeopleCount = " + builderReqPeopleCount + 
				", builderReqPeopleCountMin = " + builderReqPeopleCountMin + 
				", builderReqPeopleCountMax = " + builderReqPeopleCountMax + 
				", builderReqSalary = " + builderReqSalary + 
				", builderReqSalaryMin = " + builderReqSalaryMin + 
				", builderReqSalaryMax = " + builderReqSalaryMax + 
				", builderReqCompAddr = " + builderReqCompAddr + 
				", builderReqCompName = " + builderReqCompName + 
				", builderReqVersion = " + builderReqVersion + 
				", builderReqVersionMin = " + builderReqVersionMin + 
				", builderReqVersionMax = " + builderReqVersionMax + 
				", builderReqCreateTime = " + builderReqCreateTime + 
				", builderReqCreateTimeMin = " + builderReqCreateTimeMin + 
				", builderReqCreateTimeMax = " + builderReqCreateTimeMax + 
				", builderReqUpdateTime = " + builderReqUpdateTime + 
				", builderReqUpdateTimeMin = " + builderReqUpdateTimeMin + 
				", builderReqUpdateTimeMax = " + builderReqUpdateTimeMax + 
				", builderReqIsActive = " + builderReqIsActive + 
				", builderReqIsActiveMin = " + builderReqIsActiveMin + 
				", builderReqIsActiveMax = " + builderReqIsActiveMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
