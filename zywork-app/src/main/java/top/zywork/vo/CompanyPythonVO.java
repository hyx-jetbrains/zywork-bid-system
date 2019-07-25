package top.zywork.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/***
 * @description: 企业信息爬取文件的分页页码实体类
 * @return:
 * @author: 危锦辉 http://wjhsmart.vip
 * @date: 2019-07-25 11:06
 */
public class CompanyPythonVO extends BaseVO {

    private static final long serialVersionUID = -9223372035914960569L;

	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 当前页码
	 */
    private String pageNo;
	/**
	 * 预计页码
	 */
    private String estimatePageNo;

	public CompanyPythonVO() {
	}

	public CompanyPythonVO(String typeName, String pageNo, String estimatePageNo) {
		this.typeName = typeName;
		this.pageNo = pageNo;
		this.estimatePageNo = estimatePageNo;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getEstimatePageNo() {
		return estimatePageNo;
	}

	public void setEstimatePageNo(String estimatePageNo) {
		this.estimatePageNo = estimatePageNo;
	}

	@Override
	public String toString() {
		return "CompanyPythonVO{" +
				"typeName='" + typeName + '\'' +
				", pageNo='" + pageNo + '\'' +
				", estimatePageNo='" + estimatePageNo + '\'' +
				'}';
	}
}
