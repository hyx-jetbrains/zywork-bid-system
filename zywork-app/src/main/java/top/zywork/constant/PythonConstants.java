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
     * 企业类型-房建及市政设计单位
     */
    public static final String COMPANY_TYPE_HOUSE_DEVISE = "房建及市政设计单位";
    /**
     * 企业类型-房建及市政监理单位
     */
    public static final String COMPANY_TYPE_HOUSE_MONITOR = "房建及市政监理单位";


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
    public static final String DEFAULT_PAGE_SIXE = "5";


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
    /**
     * 房建及市政设计单位-161
     */
    public static final String COMP_TYPE_HOUSE_DEVISE_BIDDER = "161";
    /**
     * 房建及市政监理单位-141
     */
    public static final String COMP_TYPE_HOUSE_MONITOR_BIDDER = "141";

    /**
     * 是否更新标识
     */
    public static final boolean DEFAULT_IS_UPDATE_FLAG = false;
    /**
     * 是否更新标识字符串
     */
    public static final String IS_UPDATE_FLAG_STR = "update";


    /**
     * 生成静态html页面的头部部分代码
     */
    public static final String HTML_HEAD = "<!DOCTYPE html><html><head><meta charset='utf-8'></head><body>";
    /**
     * 生成静态html底部的部分代码
     */
    public static final String HTML_FOOT = "</body></html>";


    /**
     * 房建业绩的页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_HOUSE_ACHIEVEMENT = "comp_house_achievement_page_no.txt";
    /**
     * 房建招标代理页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_HOUSE_AGENT = "comp_house_agent_page_no.txt";
    /**
     * 房建投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_HOUSE_BIDDER = "comp_house_bidder_page_no.txt";
    /**
     * 重点工程页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_KEY_PROJECT_BIDDER = "comp_key_project_bidder_page_no.txt";
    /**
     * 交通工程招标代理页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_TRAFFIC_AGENT = "comp_traffic_agent_page_no.txt";
    /**
     * 交通工程投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_TRAFFIC_BIDDER = "comp_traffic_bidder_page_no.txt";
    /**
     * 水利工程招标代理页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_WATER_AGENT = "comp_water_agent_page_no.txt";
    /**
     * 水利工程投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_WATER_BIDDER = "comp_water_bidder_page_no.txt";
    /**
     * 水利勘查投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_WATER_DEVISE_BIDDER = "comp_water_devise_bidder_page_no.txt";
    /**
     * 水利监理工程投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_WATER_MONITOR_BIDDER = "comp_water_monitor_bidder_page_no.txt";
    /**
     * 房建及市政设计单位投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_HOUSE_DEVISE_BIDDER = "comp_house_devise_bidder_page_no.txt";
    /**
     * 房建及市政监理单位投标人页码文件名
     */
    public static final String PAGE_NO_FILE_NAME_COMP_HOUSE_MONITOR_BIDDER = "comp_house_monitor_bidder_page_no.txt";
}
