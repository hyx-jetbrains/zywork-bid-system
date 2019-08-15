package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.zywork.common.IOUtils;
import top.zywork.constant.PythonConstants;
import top.zywork.dao.CompanyDAO;
import top.zywork.dos.CompanyDO;
import top.zywork.dto.CompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompanyService;
import top.zywork.vo.CompanyPythonVO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "companyService")
public class CompanyServiceImpl extends AbstractBaseService implements CompanyService {

    private CompanyDAO companyDAO;

    @Value("${pythonPageNoFilesPath}")
    private String filesPath;

    @Autowired
    public void setCompanyDAO(CompanyDAO companyDAO) {
        super.setBaseDAO(companyDAO);
        this.companyDAO = companyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompanyDO.class, CompanyDTO.class);
    }

    @Override
    public List<CompanyPythonVO> getPageNoFileValue() {
        List<CompanyPythonVO> companyPythonVOList = new ArrayList<>();
        try {
            // 房建招标代理页码文件名
            CompanyPythonVO companyPythonVO = new CompanyPythonVO();
            String path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_AGENT;
            String pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("代理机构-房建招标代理");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("167");
            companyPythonVOList.add(companyPythonVO);
            // 交通工程招标代理页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_TRAFFIC_AGENT;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("代理机构-交通招标代理");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("109");
            companyPythonVOList.add(companyPythonVO);
            // 水利工程招标代理页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_WATER_AGENT;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("代理机构-水利招标代理");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("50");
            companyPythonVOList.add(companyPythonVO);
            // 房建投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-房建及市政施工单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("1697");
            companyPythonVOList.add(companyPythonVO);
            // 交通工程投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_TRAFFIC_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-交通施工单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("681");
            companyPythonVOList.add(companyPythonVO);
            // 水利工程投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_WATER_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-水利施工单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("308");
            companyPythonVOList.add(companyPythonVO);
            // 重点工程页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_KEY_PROJECT_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-重点工程投标单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("1096");
            companyPythonVOList.add(companyPythonVO);
            // 房建及市政监理单位投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_MONITOR_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-房建及市政监理单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("104");
            companyPythonVOList.add(companyPythonVO);
            // 水利监理工程投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_WATER_MONITOR_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-水利监理单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("38");
            companyPythonVOList.add(companyPythonVO);
            // 房建及市政设计单位投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_DEVISE_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-房建及市政设计单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("200");
            companyPythonVOList.add(companyPythonVO);
            // 水利勘查投标人页码文件名
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_WATER_DEVISE_BIDDER;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("投标人-水利勘查设计单位");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("37");
            companyPythonVOList.add(companyPythonVO);
            // 房建业绩
            companyPythonVO = new CompanyPythonVO();
            path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_ACHIEVEMENT;
            pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
            companyPythonVO.setTypeName("房建施工单位业绩");
            companyPythonVO.setPageNo(pageNo);
            companyPythonVO.setEstimatePageNo("3188");
            companyPythonVOList.add(companyPythonVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyPythonVOList;
    }
}
