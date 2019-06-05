package top.zywork.python;

/**
 * 获取企业新的接口类<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
public interface CompanyPythonService {

    /***
     * @description:  获取企业信息，包括企业的信息、人员、资质、业绩、建造师
     * @param type 查询类型 1-代理机构 3-投标人
     * @param compType 公司类型 181-房建招标代理 182-交通招标代理 183-水利招标代理 131-房建及市政施工单位 132-交通施工单位 133-水利施工单位 135-重点工程投标单位 143-水利监理单位 163-水利勘查设计单位
     * @param pageNo 查询页码
     * @param pageSize 查询个数
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 17:26
     */
    void getCompanyInfo(String type, String compType, String pageNo, String pageSize);

    /***
     * @description:  获取企业房建业绩信息
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 17:29
     */
    void getCompHouseAchievement();
}
