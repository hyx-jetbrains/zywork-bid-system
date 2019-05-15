package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserBuilderReqDTO数据传输对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserBuilderReqDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036226374862L;

    //t_builder_req表的字段对应的属性
	// 建造师需求编号
	private Long builderReqId;
	// 用户编号
	private Long builderReqUserId;
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
	// 提供年薪
	private Long builderReqSalary;
	// 企业地址
	private String builderReqCompAddr;
	// 企业名称
	private String builderReqCompName;
	// 版本号
	private Integer builderReqVersion;
	// 创建时间
	private Date builderReqCreateTime;
	// 更新时间
	private Date builderReqUpdateTime;
	// 是否激活
	private Byte builderReqIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	
    public UserBuilderReqDTO () {}

    public UserBuilderReqDTO (Long builderReqId, Long builderReqUserId, String builderReqName, String builderReqPhone, String builderReqMemo, String builderReqPeople, Integer builderReqPeopleCount, Long builderReqSalary, String builderReqCompAddr, String builderReqCompName, Integer builderReqVersion, Date builderReqCreateTime, Date builderReqUpdateTime, Byte builderReqIsActive, String userDetailNickname, String userDetailHeadicon) {
        this.builderReqId = builderReqId;
		this.builderReqUserId = builderReqUserId;
		this.builderReqName = builderReqName;
		this.builderReqPhone = builderReqPhone;
		this.builderReqMemo = builderReqMemo;
		this.builderReqPeople = builderReqPeople;
		this.builderReqPeopleCount = builderReqPeopleCount;
		this.builderReqSalary = builderReqSalary;
		this.builderReqCompAddr = builderReqCompAddr;
		this.builderReqCompName = builderReqCompName;
		this.builderReqVersion = builderReqVersion;
		this.builderReqCreateTime = builderReqCreateTime;
		this.builderReqUpdateTime = builderReqUpdateTime;
		this.builderReqIsActive = builderReqIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getBuilderReqId() {
		return builderReqId;
	}

	public void setBuilderReqId(Long builderReqId) {
		this.builderReqId = builderReqId;
	}

	public Long getBuilderReqUserId() {
		return builderReqUserId;
	}

	public void setBuilderReqUserId(Long builderReqUserId) {
		this.builderReqUserId = builderReqUserId;
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

	public Long getBuilderReqSalary() {
		return builderReqSalary;
	}

	public void setBuilderReqSalary(Long builderReqSalary) {
		this.builderReqSalary = builderReqSalary;
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

	public Date getBuilderReqCreateTime() {
		return builderReqCreateTime;
	}

	public void setBuilderReqCreateTime(Date builderReqCreateTime) {
		this.builderReqCreateTime = builderReqCreateTime;
	}

	public Date getBuilderReqUpdateTime() {
		return builderReqUpdateTime;
	}

	public void setBuilderReqUpdateTime(Date builderReqUpdateTime) {
		this.builderReqUpdateTime = builderReqUpdateTime;
	}

	public Byte getBuilderReqIsActive() {
		return builderReqIsActive;
	}

	public void setBuilderReqIsActive(Byte builderReqIsActive) {
		this.builderReqIsActive = builderReqIsActive;
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
        return "UserBuilderReqDTO {" +
                "builderReqId = " + builderReqId + 
				", builderReqUserId = " + builderReqUserId + 
				", builderReqName = " + builderReqName + 
				", builderReqPhone = " + builderReqPhone + 
				", builderReqMemo = " + builderReqMemo + 
				", builderReqPeople = " + builderReqPeople + 
				", builderReqPeopleCount = " + builderReqPeopleCount + 
				", builderReqSalary = " + builderReqSalary + 
				", builderReqCompAddr = " + builderReqCompAddr + 
				", builderReqCompName = " + builderReqCompName + 
				", builderReqVersion = " + builderReqVersion + 
				", builderReqCreateTime = " + builderReqCreateTime + 
				", builderReqUpdateTime = " + builderReqUpdateTime + 
				", builderReqIsActive = " + builderReqIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
