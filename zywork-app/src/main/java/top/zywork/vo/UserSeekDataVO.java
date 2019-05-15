package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserSeekDataVO值对象类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
public class UserSeekDataVO extends BaseVO {

    private static final long serialVersionUID = -9223372036643792185L;

    //t_seek_data表的字段对应的属性
	// 求带资料编号
	private Long seekDataId;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long seekDataUserId;
	// 出发地点
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String seekDataStartAddr;
	// 目的地
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String seekDataEndAddr;
	// 资料类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 10, message = "必须是1-10个字符")
	private String seekDataDataType;
	// 资料数量
	@NotNull(message = "此项是必须项")
	private Integer seekDataDataCount;
	// 最晚时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataLatestTime;
	// 赏金
	private Long seekDataPrice;
	// 联系电话
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String seekDataPhone;
	// 是否加急
	private Integer seekDataIsUrgent;
	// 备注
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String seekDataMemo;
	// 版本号
	private Integer seekDataVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date seekDataUpdateTime;
	// 是否激活
	private Byte seekDataIsActive;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String userDetailHeadicon;
	
    public UserSeekDataVO () {}

    public UserSeekDataVO (Long seekDataId, Long seekDataUserId, String seekDataStartAddr, String seekDataEndAddr, String seekDataDataType, Integer seekDataDataCount, Date seekDataLatestTime, Long seekDataPrice, String seekDataPhone, Integer seekDataIsUrgent, String seekDataMemo, Integer seekDataVersion, Date seekDataCreateTime, Date seekDataUpdateTime, Byte seekDataIsActive, String userDetailNickname, String userDetailHeadicon) {
        this.seekDataId = seekDataId;
		this.seekDataUserId = seekDataUserId;
		this.seekDataStartAddr = seekDataStartAddr;
		this.seekDataEndAddr = seekDataEndAddr;
		this.seekDataDataType = seekDataDataType;
		this.seekDataDataCount = seekDataDataCount;
		this.seekDataLatestTime = seekDataLatestTime;
		this.seekDataPrice = seekDataPrice;
		this.seekDataPhone = seekDataPhone;
		this.seekDataIsUrgent = seekDataIsUrgent;
		this.seekDataMemo = seekDataMemo;
		this.seekDataVersion = seekDataVersion;
		this.seekDataCreateTime = seekDataCreateTime;
		this.seekDataUpdateTime = seekDataUpdateTime;
		this.seekDataIsActive = seekDataIsActive;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		
    }

    public Long getSeekDataId() {
		return seekDataId;
	}

	public void setSeekDataId(Long seekDataId) {
		this.seekDataId = seekDataId;
	}

	public Long getSeekDataUserId() {
		return seekDataUserId;
	}

	public void setSeekDataUserId(Long seekDataUserId) {
		this.seekDataUserId = seekDataUserId;
	}

	public String getSeekDataStartAddr() {
		return seekDataStartAddr;
	}

	public void setSeekDataStartAddr(String seekDataStartAddr) {
		this.seekDataStartAddr = seekDataStartAddr;
	}

	public String getSeekDataEndAddr() {
		return seekDataEndAddr;
	}

	public void setSeekDataEndAddr(String seekDataEndAddr) {
		this.seekDataEndAddr = seekDataEndAddr;
	}

	public String getSeekDataDataType() {
		return seekDataDataType;
	}

	public void setSeekDataDataType(String seekDataDataType) {
		this.seekDataDataType = seekDataDataType;
	}

	public Integer getSeekDataDataCount() {
		return seekDataDataCount;
	}

	public void setSeekDataDataCount(Integer seekDataDataCount) {
		this.seekDataDataCount = seekDataDataCount;
	}

	public Date getSeekDataLatestTime() {
		return seekDataLatestTime;
	}

	public void setSeekDataLatestTime(Date seekDataLatestTime) {
		this.seekDataLatestTime = seekDataLatestTime;
	}

	public Long getSeekDataPrice() {
		return seekDataPrice;
	}

	public void setSeekDataPrice(Long seekDataPrice) {
		this.seekDataPrice = seekDataPrice;
	}

	public String getSeekDataPhone() {
		return seekDataPhone;
	}

	public void setSeekDataPhone(String seekDataPhone) {
		this.seekDataPhone = seekDataPhone;
	}

	public Integer getSeekDataIsUrgent() {
		return seekDataIsUrgent;
	}

	public void setSeekDataIsUrgent(Integer seekDataIsUrgent) {
		this.seekDataIsUrgent = seekDataIsUrgent;
	}

	public String getSeekDataMemo() {
		return seekDataMemo;
	}

	public void setSeekDataMemo(String seekDataMemo) {
		this.seekDataMemo = seekDataMemo;
	}

	public Integer getSeekDataVersion() {
		return seekDataVersion;
	}

	public void setSeekDataVersion(Integer seekDataVersion) {
		this.seekDataVersion = seekDataVersion;
	}

	public Date getSeekDataCreateTime() {
		return seekDataCreateTime;
	}

	public void setSeekDataCreateTime(Date seekDataCreateTime) {
		this.seekDataCreateTime = seekDataCreateTime;
	}

	public Date getSeekDataUpdateTime() {
		return seekDataUpdateTime;
	}

	public void setSeekDataUpdateTime(Date seekDataUpdateTime) {
		this.seekDataUpdateTime = seekDataUpdateTime;
	}

	public Byte getSeekDataIsActive() {
		return seekDataIsActive;
	}

	public void setSeekDataIsActive(Byte seekDataIsActive) {
		this.seekDataIsActive = seekDataIsActive;
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
        return "UserSeekDataVO {" +
                "seekDataId = " + seekDataId + 
				", seekDataUserId = " + seekDataUserId + 
				", seekDataStartAddr = " + seekDataStartAddr + 
				", seekDataEndAddr = " + seekDataEndAddr + 
				", seekDataDataType = " + seekDataDataType + 
				", seekDataDataCount = " + seekDataDataCount + 
				", seekDataLatestTime = " + seekDataLatestTime + 
				", seekDataPrice = " + seekDataPrice + 
				", seekDataPhone = " + seekDataPhone + 
				", seekDataIsUrgent = " + seekDataIsUrgent + 
				", seekDataMemo = " + seekDataMemo + 
				", seekDataVersion = " + seekDataVersion + 
				", seekDataCreateTime = " + seekDataCreateTime + 
				", seekDataUpdateTime = " + seekDataUpdateTime + 
				", seekDataIsActive = " + seekDataIsActive + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				" }";
    }

}
