package top.zywork.constant;

/**
 * @program: zywork-app
 * @description: Python相关的常量类
 * @author: 危锦辉 http://wjhsmart.vip
 * @create: 2019-06-05 11:24
 */
public class PythonConstants {
    /**
     * python接口地址
     */
    public static final String BASE_URL = "http://127.0.0.1:5000/";

    /**
     * 获取公司信息接口地址
     */
    public static final String COMPANY_INFO_URL = "company/info";
    /**
     * 获取房建业绩信息接口地址
     */
    public static final String COMP_HOUSE_ACHIEVEMENt_INFO_URL = "comp-house-achievement/house";
    /**
     * 获取房建工程信息接口地址
     */
    public static final String PROJECT_HOUSE = "project/house";
    /**
     * 获取重点工程信息接口地址
     */
    public static final String PROJECT_KEY = "project/key";
    /**
     * 获取其他项目信息接口地址
     */
    public static final String PROJECT_OTHER = "project/other";
    /**
     * 获取政府采购信息接口地址
     */
    public static final String PROJECT_PROCUREMENT = "project/procurement";
    /**
     * 获取交通工程信息接口地址
     */
    public static final String PROJECT_TRAFFIC = "project/traffic";
    /**
     * 获取水利信息接口地址
     */
    public static final String PROJECT_CONSERVANCY = "project/conservancy";
    /**
     * 获取房建工程公示信息接口地址
     */
    public static final String PROJECT_ANNOUNCE_HOUSE = "project-announce/house";
    /**
     * 获取重点工程公示信息接口地址
     */
    public static final String PROJECT_ANNOUNCE_KEY = "project-announce/key";
    /**
     * 获取其他项目公示信息接口地址
     */
    public static final String PROJECT_ANNOUNCE_OTHER = "project-announce/other";
    /**
     * 获取政府采购公示信息接口地址
     */
    public static final String PROJECT_ANNOUNCE_PROCUREMENT = "project-announce/procurement";
    /**
     * 获取交通工程公示信息接口地址
     */
    public static final String PROJECT_ANNOUNCE_TRAFFIC = "project-announce/traffic";
    /**
     * 获取水利公示信息接口地址
     */
    public static final String PROJECT_ANNOUNCE_CONSERVANCY = "project-announce/conservancy";


    /**
     * 企业类型-房建及市政施工单位
     */
    public static final String COMPANY_TYPE_HOUSE = "房建及市政施工单位";
    /**
     * 企业类型-交通施工单位
     */
    public static final String COMPANY_TYPE_TRAFFIC = "交通施工单位";
    /**
     * 企业类型-水利施工单位
     */
    public static final String COMPANY_TYPE_WATER = "水利施工单位";
    /**
     * 企业类型-重点工程投标单位
     */
    public static final String COMPANY_TYPE_KEY_PROJECT = "重点工程投标单位";
    /**
     * 企业类型-水利监理单位
     */
    public static final String COMPANY_TYPE_WATER_MONITOR = "水利监理单位";
    /**
     * 企业类型-水利勘查设计单位
     */
    public static final String COMPANY_TYPE_WATER_DEVISE = "水利勘查设计单位";


    /**
     * 超时时间-1分钟-60秒-60000毫秒
     */
    public static final int TIME_OUT = 60000;
    /**
     * 默认查询页码-1
     */
    public static final String DEFAULT_PAGE_NO = "1";
    /**
     * 默认查询个数-22
     */
    public static final String DEFAULT_PAGE_SIXE = "10";


    /**
     * 请求类型-代理机构-1
     */
    public static final String TYPE_AGENT = "1";
    /**
     * 请求类型-投标人-3
     */
    public static final String TYPE_BIDDER = "3";
    /**
     * 房建招标代理-181
     */
    public static final String COMP_TYPE_HOUSE_AGENT = "181";
    /**
     * 交通招标代理-182
     */
    public static final String COMP_TYPE_TRAFFIC_AGENT = "182";
    /**
     * 水利招标代理-183
     */
    public static final String COMP_TYPE_WATER_AGENT = "183";
    /**
     * 房建及市政施工单位-131
     */
    public static final String COMP_TYPE_HOUSE_BIDDER = "131";
    /**
     * 交通施工单位-132
     */
    public static final String COMP_TYPE_TRAFFIC_BIDDER = "132";
    /**
     * 水利施工单位-133
     */
    public static final String COMP_TYPE_WATER_BIDDER = "133";
    /**
     * 重点工程投标单位-135
     */
    public static final String COMP_TYPE_KEY_PROJECT_BIDDER = "135";
    /**
     * 水利监理单位-143
     */
    public static final String COMP_TYPE_WATER_MONITOR_BIDDER = "143";
    /**
     * 水利勘查设计单位-163
     */
    public static final String COMP_TYPE_WATER_DEVISE_BIDDER = "163";
}
