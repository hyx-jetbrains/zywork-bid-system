package top.zywork.python.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.zywork.common.*;
import top.zywork.constant.ProjectConstants;
import top.zywork.constant.PythonConstants;
import top.zywork.dao.*;
import top.zywork.dto.*;
import top.zywork.enums.DatePatternEnum;
import top.zywork.python.CompanyPythonService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 获取企业信息的接口实现类<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "companyPythonService")
public class CompanyPythonServiceImpl implements CompanyPythonService {

    private static final Logger logger = LoggerFactory.getLogger(CompanyPythonServiceImpl.class);

    private CompanyDAO companyDAO;

    private CompPersonnelDAO compPersonnelDAO;

    private CompAptitudeDAO compAptitudeDAO;

    private CompBuilderDAO compBuilderDAO;

    private CompTrafficAchievementDAO compTrafficAchievementDAO;

    private CompWaterAchievementDAO compWaterAchievementDAO;

    private CompKeyProjectAchievementDAO compKeyProjectAchievementDAO;

    private CompWaterMonitorAchievementDAO compWaterMonitorAchievementDAO;

    private CompWaterDeviseAchievementDAO compWaterDeviseAchievementDAO;

    private CompHouseAchievementDAO compHouseAchievementDAO;

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    @Override
    public void getCompanyInfo(String type, String compType, String pageNo, String pageSize, boolean isUpate) throws Exception {
        try {
            StringBuilder url = new StringBuilder();
            url.append(PythonConstants.BASE_URL)
                    .append(PythonConstants.COMPANY_INFO_URL)
                    .append("?")
                    .append("type=")
                    .append(type)
                    .append("&compType=")
                    .append(compType)
                    .append("&pageNo=")
                    .append(pageNo)
                    .append("&pageSize=")
                    .append(pageSize);
            HttpUtils.timeout(PythonConstants.TIME_OUT);
            String content = HttpUtils.get(url.toString());
            JSONArray jsonArray = JSON.parseArray(content);
            if (null == jsonArray || jsonArray.isEmpty()) {
                logger.info("未获取到企业信息");
                return;
            }
            int len = jsonArray.size();
            for (int i = 0; i < len; i++) {
                CompanyDTO companyDTO = new CompanyDTO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // 企业名称
                String compName = jsonObject.getString("compName");
                String industryType = jsonObject.getString("industryType");
                Object obj = companyDAO.getByName(compName);
                boolean companyFlag = true;
                // 默认是保存数据
                boolean updateFlag = false;
                if (null != obj) {
                    companyDTO = BeanUtils.copy(obj, CompanyDTO.class);
                    // 公司已经存在，判断行业类型是否是一样的
                    if (!companyDTO.getIndustryType().contains(industryType)) {
                        // 表示该公司有两个以上的身份
                        logger.info("该公司有两个以上的身份：" + companyDTO);
                        companyDTO.setIndustryType(companyDTO.getIndustryType() + "," + industryType);
                        companyDTO.setVersion(companyDTO.getVersion()+1);
                        companyDAO.update(companyDTO);
                    }
                    updateFlag = true;
                    logger.info("该公司已存在：" + compName + ",是否更新数据：" + isUpate);
                    if (!isUpate) {
                        // 如果不需要更新数据，则不用处理公司信息
                        companyFlag = false;
                    }
                }
                if (companyFlag) {
                    // 如果公司信息已经存在，则不需要再储存公司信息
                    companyDTO.setCompName(compName);
                    // 注册地区
                    String regAddress = jsonObject.getString("regAddress");
                    companyDTO.setRegAddress(regAddress);
                    // 默认省外
                    Integer jurisdictionType = 1;
                    if (!StringUtils.isEmpty(regAddress)) {
                        String tempProvince = regAddress.split("/")[0];
                        if (tempProvince.equals("江西省")) {
                            // 是江西省，则设置成省内
                            jurisdictionType = 0;
                        }
                    }
                    companyDTO.setJurisdictionType(jurisdictionType.byteValue());
                    // 城市
                    String city = jsonObject.getString("city");
                    companyDTO.setCity(city);
                    // 企业类型
                    String tempCompType = jsonObject.getString("compType");
                    companyDTO.setCompType(tempCompType);
                    // 行业分类
                    if (!updateFlag) {
                        // 如果是需要更新数据，则不更新这个字段，否则就需要保存行业类型
                        companyDTO.setIndustryType(industryType);
                    }
                    // 法人
                    String legalPerson = jsonObject.getString("legalPerson");
                    companyDTO.setLegalPerson(legalPerson);
                    // 法人电话
                    String legalPersonPhone = jsonObject.getString("legalPersonPhone");
                    companyDTO.setLegalPerson(legalPerson);
                    // 负责人
                    String responsible = jsonObject.getString("responsible");
                    companyDTO.setResponsible(responsible);
                    // 负责人电话
                    String responsiblePhone = jsonObject.getString("responsiblePhone");
                    companyDTO.setResponsiblePhone(responsiblePhone);
                    // 单位电话
                    String compPhone = jsonObject.getString("compPhone");
                    companyDTO.setCompPhone(compPhone);
                    // 联系地址
                    String compAddr = jsonObject.getString("compAddr");
                    companyDTO.setCompAddr(compAddr);
                    // 注册资本
                    String regCapital = jsonObject.getString("regCapital");
                    companyDTO.setRegCapital(regCapital);
                    // 经营范围
                    String businessScope = jsonObject.getString("businessScope");
                    companyDTO.setBusinessScope(businessScope);
                    // 可承担业务
                    String affordableBusiness = jsonObject.getString("affordableBusiness");
                    companyDTO.setAffordableBusiness(affordableBusiness);
                    // 源地址
                    String sourceUrl = jsonObject.getString("sourceUrl");
                    companyDTO.setSourceUrl(sourceUrl);
                    if (updateFlag) {
                        // 更新公司信息
                        companyDTO.setVersion(companyDTO.getVersion()+1);
                        companyDAO.update(companyDTO);
                    } else {
                        // 保存公司信息
                        companyDAO.save(companyDTO);
                    }

                }
                Long compId = companyDTO.getId();
                // 企业人员
                JSONArray personnelArray = jsonObject.getJSONArray("compPersonnelList");
                if (null != personnelArray && !personnelArray.isEmpty()) {
                    saveCompPersonnelInfo(compId, personnelArray, isUpate);
                }
                // 企业资质
                JSONArray aptitudeArray = jsonObject.getJSONArray("compAptitudeList");
                if (null != aptitudeArray && !aptitudeArray.isEmpty()) {
                    saveCompAptitudeInfo(compId, aptitudeArray, isUpate);
                }
                // 企业建造师
                JSONArray builderArray = jsonObject.getJSONArray("compBuilderList");
                if (null != builderArray && !builderArray.isEmpty()) {
                    saveCompBuilderInfo(compId, builderArray, isUpate);
                }
                // 企业业绩
                JSONArray achievementArray = jsonObject.getJSONArray("compAchievementList");
                if (null != achievementArray && !achievementArray.isEmpty()) {
                    saveCompAchievementInfo(compId, achievementArray, industryType, isUpate);
                }
                // 需要判断需不需要匹配房建业绩
                if (PythonConstants.COMPANY_TYPE_HOUSE.equals(industryType)) {
                    // 需要判断当前企业是否有房屋市建业绩
                    updateCompHouseAchievement(compId, compName);
                }

            }
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /***
     * @description: 保存企业人员信息
     * @param compId 企业id
     * @param array json数组对象
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 13:36
     */
    private void saveCompPersonnelInfo(Long compId, JSONArray array, boolean isUpdate) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            CompPersonnelDTO compPersonnelDTO = new CompPersonnelDTO();
            // 姓名
            String name = jsonObj.getString("name");
            Object obj = compPersonnelDAO.getByCompIdAndName(compId, name);
            boolean updateFlag = false;
            if (null != obj) {
                updateFlag = true;
                // 说明该人员信息已经存在
                compPersonnelDTO = BeanUtils.copy(obj, CompPersonnelDTO.class);
                logger.info(compId + "该人员已存在：" + name + "，是否需要更新：" + isUpdate);
                if (!isUpdate) {
                    continue;
                }
            }
            compPersonnelDTO.setCompId(compId);
            compPersonnelDTO.setName(name);
            // 职称
            String jobTitle = jsonObj.getString("jobTitle");
            compPersonnelDTO.setJobTitle(jobTitle);
            // 职业资格及专业
            String jobDetail = jsonObj.getString("jobDetail");
            compPersonnelDTO.setJobDetail(jobDetail);
            if (updateFlag) {
                // 更新企业人员信息
                compPersonnelDTO.setVersion(compPersonnelDTO.getVersion()+1);
                compPersonnelDAO.update(compPersonnelDTO);
            } else {
                // 保存企业人员信息
                compPersonnelDAO.save(compPersonnelDTO);
            }
        }
    }

    /***
     * @description:  保存企业资质信息
     * @param compId 企业id
     * @param array json数组对象
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 13:37
     */
    private void saveCompAptitudeInfo(Long compId, JSONArray array, boolean isUpdate) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            CompAptitudeDTO compAptitudeDTO = new CompAptitudeDTO();
            // 证件号码
            String certificateNum = jsonObj.getString("certificateNum");
            // 资质详情
            String certificateDetail = jsonObj.getString("certificateDetail");
            Object obj = compAptitudeDAO.getByCompIdAndCertificateDetail(compId, certificateDetail);
            boolean updateFlag = false;
            if (null != obj) {
                updateFlag = true;
                // 说明该资质信息已经存在
                compAptitudeDTO = BeanUtils.copy(obj, CompAptitudeDTO.class);
                logger.info(compId + "该资质已存在：" + certificateNum + ",是否需要更新：" + isUpdate);
                if (!isUpdate) {
                    continue;
                }
            }
            compAptitudeDTO.setCompId(compId);
            compAptitudeDTO.setCertificateNum(certificateNum);

            compAptitudeDTO.setCertificateDetail(certificateDetail);
            if (updateFlag) {
                // 更新企业资质信息
                compAptitudeDTO.setVersion(compAptitudeDTO.getVersion()+1);
                compAptitudeDAO.update(compAptitudeDTO);
            } else {
                // 保存企业资质信息
                compAptitudeDAO.save(compAptitudeDTO);
            }
        }
    }

    /***
     * @description: 保存企业建造师信息
     * @param compId 企业id
     * @param array 建造师数组
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 13:51
     */
    private void saveCompBuilderInfo(Long compId, JSONArray array, boolean isUpdate) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            CompBuilderDTO compBuilderDTO = new CompBuilderDTO();
            // 姓名
            String name = jsonObj.getString("name");
            Object obj = compBuilderDAO.getByCompIdAndName(compId, name);
            boolean updateFlag = false;
            if (null != obj) {
                updateFlag = true;
                // 说明该建造师信息已经存在
                compBuilderDTO = BeanUtils.copy(obj, CompBuilderDTO.class);
                logger.info(compId + "该建造师已存在：" + name + ",是否需要更新：" + isUpdate);
                if (!isUpdate) {
                    continue;
                }
            }
            compBuilderDTO.setCompId(compId);
            compBuilderDTO.setName(name);
            // 性别
            String gender = jsonObj.getString("gender");
            compBuilderDTO.setGender(gender);
            // 注册证件号码
            String regNum = jsonObj.getString("regNum");
            compBuilderDTO.setRegNum(regNum);
            // 专业等级
            String majorLevel = jsonObj.getString("majorLevel");
            compBuilderDTO.setMajorLevel(majorLevel);
            if (updateFlag) {
                // 更新企业建造师信息
                compBuilderDTO.setVersion(compBuilderDTO.getVersion()+1);
                compBuilderDAO.update(compBuilderDTO);
            } else {
                // 保存企业建造师信息
                compBuilderDAO.save(compBuilderDTO);
            }

        }
    }

    /***
     * @description:  保存企业业绩信息
     * @param compId 企业id
     * @param array 业绩数组
     * @param compType 企业类型
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 14:33
     */
    private void saveCompAchievementInfo(Long compId, JSONArray array, String compType, boolean isUpdate) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            String projectName = jsonObj.getString("projectName");
            boolean updateFlag = false;
            if (PythonConstants.COMPANY_TYPE_KEY_PROJECT.equals(compType)) {
                // 重点工程业绩
                CompKeyProjectAchievementDTO compKeyProjectAchievementDTO = new CompKeyProjectAchievementDTO();
                Object obj = compKeyProjectAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    updateFlag = true;
                    // 说明该业绩已存在
                    compKeyProjectAchievementDTO = BeanUtils.copy(obj, CompKeyProjectAchievementDTO.class);
                    logger.info(compId + ":" + compType + "业绩已存在：" + projectName + ",是否需要更新：" + isUpdate);
                    if (!isUpdate) {
                        continue;
                    }
                }
                compKeyProjectAchievementDTO.setCompId(compId);
                compKeyProjectAchievementDTO.setProjectName(projectName);
                // 建设单位
                String buildComp = jsonObj.getString("buildComp");
                compKeyProjectAchievementDTO.setBuildComp(buildComp);
                // 中标金额
                String markMoney = jsonObj.getString("markMoney");
                if (StringUtils.isNotEmpty(markMoney)) {
                    compKeyProjectAchievementDTO.setMarkMoney(markMoney);
                    // 金额
                    compKeyProjectAchievementDTO.setMoney(new BigDecimal(markMoney));
                }
                // 开工时间
                String startDate = jsonObj.getString("startDate").trim();
                if (StringUtils.isNotEmpty(startDate)) {
                    compKeyProjectAchievementDTO.setStartDate(formatDate(startDate));
                }
                // 竣工时间
                String endDate = jsonObj.getString("endDate").trim();
                if (StringUtils.isNotEmpty(endDate)) {
                    compKeyProjectAchievementDTO.setEndDate(formatDate(endDate));
                }
                if (updateFlag) {
                    // 更新重点工程业绩
                    compKeyProjectAchievementDTO.setVersion(compKeyProjectAchievementDTO.getVersion()+1);
                    compKeyProjectAchievementDAO.update(compKeyProjectAchievementDTO);
                } else {
                    // 保存重点工程业绩
                    compKeyProjectAchievementDAO.save(compKeyProjectAchievementDTO);
                }
            } else if (PythonConstants.COMPANY_TYPE_TRAFFIC.equals(compType)) {
                // 交通施工业绩
                CompTrafficAchievementDTO compTrafficAchievementDTO = new CompTrafficAchievementDTO();
                Object obj = compTrafficAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    updateFlag = true;
                    // 说明该业绩已存在
                    compTrafficAchievementDTO = BeanUtils.copy(obj, CompTrafficAchievementDTO.class);
                    logger.info(compId + ":" + compType + "业绩已存在：" + projectName + ",是否需要更新：" + isUpdate);
                    if (!isUpdate) {
                        continue;
                    }
                }
                compTrafficAchievementDTO.setCompId(compId);
                compTrafficAchievementDTO.setProjectName(projectName);
                // 项目负责人
                String name = jsonObj.getString("name");
                compTrafficAchievementDTO.setName(name);
                // 技术负责人
                String technologyName = jsonObj.getString("technologyName");
                compTrafficAchievementDTO.setTechnologyName(technologyName);
                // 合同金额
                String contractAmount = jsonObj.getString("contractAmount");
                if (StringUtils.isNotEmpty(contractAmount)) {
                    compTrafficAchievementDTO.setContractAmount(contractAmount);
                    compTrafficAchievementDTO.setMoney(new BigDecimal(contractAmount));
                }
                // 工程地点
                String workAddr = jsonObj.getString("workAddr");
                compTrafficAchievementDTO.setWorkAddr(workAddr);
                // 开工时间
                String startDate = jsonObj.getString("startDate").trim();
                if (StringUtils.isNotEmpty(startDate)) {
                    compTrafficAchievementDTO.setStartDate(formatDate(startDate));
                }
                // 竣工时间
                String endDate = jsonObj.getString("endDate").trim();
                if (StringUtils.isNotEmpty(endDate)) {
                    compTrafficAchievementDTO.setEndDate(formatDate(endDate));
                }
                // 验证状态
                String validStatus = jsonObj.getString("validStatus");
                compTrafficAchievementDTO.setValidStatus(validStatus);
                // 内部地址
                String inwardHtmlUrl = jsonObj.getString("inwardHtmlUrl");
                compTrafficAchievementDTO.setInwardHtmlUrl(inwardHtmlUrl);
                if (updateFlag) {
                    // 更新交通业绩
                    compTrafficAchievementDTO.setVersion(compTrafficAchievementDTO.getVersion()+1);
                    compTrafficAchievementDAO.update(compTrafficAchievementDTO);
                } else {
                    // 保存交通业绩
                    compTrafficAchievementDAO.save(compTrafficAchievementDTO);
                }
            } else if (PythonConstants.COMPANY_TYPE_WATER.equals(compType)) {
                // 水利施工业绩
                CompWaterAchievementDTO compWaterAchievementDTO = new CompWaterAchievementDTO();
                Object obj = compWaterAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    updateFlag = true;
                    compWaterAchievementDTO = BeanUtils.copy(obj, CompWaterAchievementDTO.class);
                    logger.info(compId + ":" + compType + "业绩已存在：" + projectName + ",是否需要更新：" + isUpdate);
                    if (!isUpdate) {
                        continue;
                    }
                }
                compWaterAchievementDTO.setCompId(compId);
                compWaterAchievementDTO.setProjectName(projectName);
                // 合同金额
                String contractAmount = jsonObj.getString("contractAmount");
                if (StringUtils.isNotEmpty(contractAmount)) {
                    compWaterAchievementDTO.setContractAmount(contractAmount);
                    // 金额
                    compWaterAchievementDTO.setMoney(new BigDecimal(contractAmount));
                }
                // 开工时间
                String startDate = jsonObj.getString("startDate").trim();
                if (StringUtils.isNotEmpty(startDate)) {
                    compWaterAchievementDTO.setStartDate(formatDate(startDate));
                }
                // 竣工时间
                String endDate = jsonObj.getString("endDate").trim();
                if (StringUtils.isNotEmpty(endDate)) {
                    compWaterAchievementDTO.setEndDate(formatDate(endDate));
                }
                // 项目负责人
                String name = jsonObj.getString("name");
                compWaterAchievementDTO.setName(name);
                // 内部地址
                String inwardHtmlUrl = jsonObj.getString("inwardHtmlUrl");
                compWaterAchievementDTO.setInwardHtmlUrl(inwardHtmlUrl);
                if (updateFlag) {
                    // 更新水利施工业绩
                    compWaterAchievementDTO.setVersion(compWaterAchievementDTO.getVersion()+1);
                    compWaterAchievementDAO.update(compWaterAchievementDTO);
                } else {
                    // 保存水利施工业绩
                    compWaterAchievementDAO.save(compWaterAchievementDTO);
                }
            } else if (PythonConstants.COMPANY_TYPE_WATER_MONITOR.equals(compType)) {
                // 水利监理业绩
                CompWaterMonitorAchievementDTO compWaterMonitorAchievementDTO = new CompWaterMonitorAchievementDTO();
                Object obj = compWaterMonitorAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    updateFlag = true;
                    compWaterMonitorAchievementDTO = BeanUtils.copy(obj, CompWaterMonitorAchievementDTO.class);
                    logger.info(compId + ":" + compType + "业绩已存在：" + projectName + "，是否更新：" + isUpdate);
                    if (!isUpdate) {
                        continue;
                    }
                }
                compWaterMonitorAchievementDTO.setCompId(compId);
                compWaterMonitorAchievementDTO.setProjectName(projectName);
                // 项目类型
                String projectType = jsonObj.getString("projectType");
                compWaterMonitorAchievementDTO.setProjectType(projectType);
                // 建设单位
                String buildComp = jsonObj.getString("buildComp");
                compWaterMonitorAchievementDTO.setBuildComp(buildComp);
                // 合同金额
                String contractAmount = jsonObj.getString("contractAmount");
                if (!StringUtils.isEmpty(contractAmount)) {
                    compWaterMonitorAchievementDTO.setContractAmount(contractAmount);
                    // 金额
                    compWaterMonitorAchievementDTO.setMoney(new BigDecimal(contractAmount));
                }
                // 合同签订日期
                String contractDate = jsonObj.getString("contractDate").trim();
                if (StringUtils.isNotEmpty(contractDate)) {
                    compWaterMonitorAchievementDTO.setContractDate(formatDate(contractDate));
                }
                // 开工时间
                String startDate = jsonObj.getString("startDate").trim();
                if (StringUtils.isNotEmpty(startDate)) {
                    compWaterMonitorAchievementDTO.setStartDate(formatDate(startDate));
                }
                if (updateFlag) {
                    // 更新水利简历业绩
                    compWaterMonitorAchievementDTO.setVersion(compWaterMonitorAchievementDTO.getVersion()+1);
                    compWaterMonitorAchievementDAO.update(compWaterMonitorAchievementDTO);
                } else {
                    // 保存水利监理业绩
                    compWaterMonitorAchievementDAO.save(compWaterMonitorAchievementDTO);
                }
            } else if (PythonConstants.COMPANY_TYPE_WATER_DEVISE.equals(compType)) {
                // 水利勘查业绩
                CompWaterDeviseAchievementDTO compWaterDeviseAchievementDTO = new CompWaterDeviseAchievementDTO();
                Object obj = compWaterDeviseAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    updateFlag = true;
                    compWaterDeviseAchievementDTO = BeanUtils.copy(obj, CompWaterDeviseAchievementDTO.class);
                    logger.info(compId + ":" + compType + "业绩已存在：" + projectName + "，是否更新：" + isUpdate);
                    if (!isUpdate) {
                        continue;
                    }
                }
                compWaterDeviseAchievementDTO.setCompId(compId);
                compWaterDeviseAchievementDTO.setProjectName(projectName);
                // 项目类型
                String tenderingComp = jsonObj.getString("tenderingComp");
                compWaterDeviseAchievementDTO.setTenderingComp(tenderingComp);
                // 招标(单位)人
                String buildComp = jsonObj.getString("buildComp");
                compWaterDeviseAchievementDTO.setBuildComp(buildComp);
                // 合同金额
                String contractAmount = jsonObj.getString("contractAmount");
                if (!StringUtils.isEmpty(contractAmount)) {
                    compWaterDeviseAchievementDTO.setContractAmount(contractAmount);
                    // 金额
                    compWaterDeviseAchievementDTO.setMoney(new BigDecimal(contractAmount));
                }
                // 项目负责人
                String name = jsonObj.getString("name");
                compWaterDeviseAchievementDTO.setName(name);
                // 中标时间
                String markDate = jsonObj.getString("markDate").trim();
                if (StringUtils.isNotEmpty(markDate)) {
                    compWaterDeviseAchievementDTO.setMarkDate(formatDate(markDate));
                }
                if (updateFlag) {
                    // 更新水利勘查业绩
                    compWaterDeviseAchievementDTO.setVersion(compWaterDeviseAchievementDTO.getVersion()+1);
                    compWaterDeviseAchievementDAO.update(compWaterDeviseAchievementDTO);
                } else {
                    // 保存水利勘查业绩
                    compWaterDeviseAchievementDAO.save(compWaterDeviseAchievementDTO);
                }
            } else {
                break;
            }
        }
    }

    /***
     * @description:  根据企业名称更新房建业绩信息，把房建业绩和企业做匹配
     * @param compId 企业id
     * @param compName 企业名称
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-05 17:53
     */
    private void updateCompHouseAchievement(Long compId, String compName) {
        try {
            List<Object> objectList = compHouseAchievementDAO.getByCompIdAndMarkComp(0L, compName);
            if (objectList.size() <= 0) {
                // 表示没有匹配的
                return;
            }
            List<CompHouseAchievementDTO> compHouseAchievementDTOList = BeanUtils.copy(objectList, CompHouseAchievementDTO.class);
            for (CompHouseAchievementDTO compHouseAchievementDTO : compHouseAchievementDTOList) {
                compHouseAchievementDTO.setCompId(compId);
                compHouseAchievementDTO.setVersion(compHouseAchievementDTO.getVersion()+1);
                compHouseAchievementDAO.update(compHouseAchievementDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getCompHouseAchievement(String pageNo, boolean isUpdate, boolean isInit) throws Exception {
        try {
            // 这个请求比较特殊，超时时间设置长一点
            HttpUtils.timeout(600000);
            StringBuilder url = new StringBuilder();
            String content = "";
            if (isInit) {
                url.append(PythonConstants.BASE_URL)
                        .append(PythonConstants.COMP_HOUSE_ACHIEVEMENt_INIT_URL);
                content = HttpUtils.get(url.toString());
                if (StringUtils.isEmpty(content)) {
                    logger.error("初始化文件信息失败");
                    return;
                }
                // 避免还未收到响应，就发起了请求
                Thread.sleep(347);
            }
            url.setLength(0);
            content = "";
            url.append(PythonConstants.BASE_URL)
                    .append(PythonConstants.COMP_HOUSE_ACHIEVEMENt_INFO_URL)
                    .append("?pageNo=")
                    .append(pageNo);
            content = HttpUtils.get(url.toString());
            if (StringUtils.isEmpty(content)) {
                logger.error("未获取到业绩信息");
                return;
            }
            JSONArray jsonArray = JSON.parseArray(content);
            int len = jsonArray.size();
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CompHouseAchievementDTO compHouseAchievementDTO = new CompHouseAchievementDTO();
                // 工程名称
                String projectName = jsonObject.getString("projectName");
                Object obj = compHouseAchievementDAO.getByProjectName(projectName);
                boolean updateFlag = false;
                if (null != obj) {
                    // 说明该业绩已存在
                    updateFlag = true;
                    compHouseAchievementDTO = BeanUtils.copy(obj, CompHouseAchievementDTO.class);
                    logger.info("业绩已存在：" + projectName + ",是否更新：" + isUpdate);
                    if (!isUpdate) {
                        continue;
                    }
                }
                // 中标单位
                String markComp = jsonObject.getString("markComp");
                if (StringUtils.isNotEmpty(markComp)) {
                    // 中标单位不为空，根据公司名称查询系统中是和否有对应的企业信息
                    Object companyObj = companyDAO.getByName(markComp);
                    if (null != companyObj) {
                        // 说明有获取到公司信息
                        CompanyDTO companyDTO = BeanUtils.copy(companyObj, CompanyDTO.class);
                        compHouseAchievementDTO.setCompId(companyDTO.getId());
                    }
                }
                compHouseAchievementDTO.setProjectName(projectName);
                compHouseAchievementDTO.setMarkComp(markComp);
                // 注册建造师
                String builderName = jsonObject.getString("builderName");
                compHouseAchievementDTO.setBuilderName(builderName);
                // 中标金额
                String markMoney = jsonObject.getString("markMoney");
                if (!StringUtils.isEmpty(markMoney)) {
                    // 金额 元转成万元
                    BigDecimal tempMoney = new BigDecimal(markMoney).divide(new BigDecimal(10000));
                    compHouseAchievementDTO.setMarkMoney(tempMoney.toString());
                    compHouseAchievementDTO.setMoney(tempMoney);
                }
                // 建设规模
                String buildScale = jsonObject.getString("buildScale");
                compHouseAchievementDTO.setBuildScale(buildScale);
                // 项目所属地区归类
                String regionType = jsonObject.getString("regionType");
                compHouseAchievementDTO.setRegionType(regionType);
                // 建设单位
                String buildComp = jsonObject.getString("buildComp");
                compHouseAchievementDTO.setBuildComp(buildComp);
                // 工程地址
                String projectAddr = jsonObject.getString("projectAddr");
                compHouseAchievementDTO.setProjectAddr(projectAddr);
                // 合同签订日期
                String contractDate = jsonObject.getString("contractDate").trim();
                if (StringUtils.isNotEmpty(contractDate)) {
                    compHouseAchievementDTO.setContractDate(formatDate(contractDate));
                }
                // 中标日期
                String markDate = jsonObject.getString("markDate").trim();
                if (StringUtils.isNotEmpty(markDate)) {
                    compHouseAchievementDTO.setMarkDate(formatDate(markDate));
                }
                // 项目负责人
                String name = jsonObject.getString("name");
                compHouseAchievementDTO.setName(name);
                // 项目负责人证书号
                String certificateNum = jsonObject.getString("certificateNum");
                compHouseAchievementDTO.setCertificateNum(certificateNum);
                // 施工员
                String constructors = jsonObject.getString("constructors");
                compHouseAchievementDTO.setConstructors(constructors);
                // 施工员证书号
                String constructorsCertificateNum = jsonObject.getString("constructorsCertificateNum");
                compHouseAchievementDTO.setConstructorsCertificateNum(constructorsCertificateNum);
                // 施工员身份证号
                String constructorsIdNum = jsonObject.getString("constructorsIdNum");
                compHouseAchievementDTO.setConstructorsIdNum(constructorsIdNum);
                // 质量员
                String qualityWorker = jsonObject.getString("qualityWorker");
                compHouseAchievementDTO.setQualityWorker(qualityWorker);
                // 质量员证书号
                String qualityWorkerCertificateNum = jsonObject.getString("qualityWorkerCertificateNum");
                compHouseAchievementDTO.setQualityWorkerCertificateNum(qualityWorkerCertificateNum);
                // 质量员身份证号
                String qualityWorkerIdNum = jsonObject.getString("qualityWorkerIdNum");
                compHouseAchievementDTO.setQualityWorkerIdNum(qualityWorkerIdNum);
                // 安全员
                String securityOfficer = jsonObject.getString("securityOfficer");
                compHouseAchievementDTO.setSecurityOfficer(securityOfficer);
                // 安全员证书号
                String securityOfficerCertificateNum = jsonObject.getString("securityOfficerCertificateNum");
                compHouseAchievementDTO.setSecurityOfficerCertificateNum(securityOfficerCertificateNum);
                // 安全员身份证号
                String securityOfficerIdNum = jsonObject.getString("securityOfficerIdNum");
                compHouseAchievementDTO.setSecurityOfficerIdNum(securityOfficerIdNum);
                // 标准员
                String standardWorker = jsonObject.getString("standardWorker");
                compHouseAchievementDTO.setStandardWorker(standardWorker);
                // 标准员证书号
                String standardWorkerCertificateNum = jsonObject.getString("standardWorkerCertificateNum");
                compHouseAchievementDTO.setStandardWorkerCertificateNum(standardWorkerCertificateNum);
                // 标准员身份证号
                String standardWorkerIdNum = jsonObject.getString("standardWorkerIdNum");
                compHouseAchievementDTO.setStandardWorkerIdNum(standardWorkerIdNum);
                // 材料员
                String materialMan = jsonObject.getString("materialMan");
                compHouseAchievementDTO.setMaterialMan(materialMan);
                // 材料员证书号
                String materialManCertificateNum = jsonObject.getString("materialManCertificateNum");
                compHouseAchievementDTO.setMaterialManCertificateNum(materialManCertificateNum);
                // 材料员身份证号
                String materialManIdNum = jsonObject.getString("materialManIdNum");
                compHouseAchievementDTO.setMaterialManIdNum(materialManIdNum);
                // 机械员
                String mechanic = jsonObject.getString("mechanic");
                compHouseAchievementDTO.setMechanic(mechanic);
                // 机械员证书号
                String mechanicCertificateNum = jsonObject.getString("mechanicCertificateNum");
                compHouseAchievementDTO.setMechanicCertificateNum(mechanicCertificateNum);
                // 机械员身份证号
                String mechanicIdNum = jsonObject.getString("mechanicIdNum");
                compHouseAchievementDTO.setMechanicIdNum(mechanicIdNum);
                // 劳务员
                String labors = jsonObject.getString("labors");
                compHouseAchievementDTO.setLabors(labors);
                // 劳务员证书号
                String laborsCertificateNum = jsonObject.getString("laborsCertificateNum");
                compHouseAchievementDTO.setLaborsCertificateNum(laborsCertificateNum);
                // 劳务员身份证号
                String laborsIdNum = jsonObject.getString("laborsIdNum");
                compHouseAchievementDTO.setLaborsIdNum(laborsIdNum);
                // 资料员
                String dataClerk = jsonObject.getString("dataClerk");
                compHouseAchievementDTO.setDataClerk(dataClerk);
                // 资料员证书号
                String dataClerkCertificateNum = jsonObject.getString("dataClerkCertificateNum");
                compHouseAchievementDTO.setDataClerkCertificateNum(dataClerkCertificateNum);
                // 资料员身份证号
                String dataClerkIdNum = jsonObject.getString("dataClerkIdNum");
                compHouseAchievementDTO.setDataClerkIdNum(dataClerkIdNum);
                // 源地址
                String sourceUrl = jsonObject.getString("sourceUrl");
                compHouseAchievementDTO.setSourceUrl(sourceUrl);

                String fileName = UUIDUtils.uuid() +".html";
                String projectDetail = jsonObject.getString("contentDetail");
                String newFileName = "";
                newFileName = CommonMethodUtils.generatorHtmlCode(fileName, projectDetail, location);
                if (StringUtils.isNotEmpty(newFileName)) {
                    compHouseAchievementDTO.setInwardHtmlUrl(uri + "/" + newFileName);
                }
                if (updateFlag) {
                    // 更新房建业绩信息
                    compHouseAchievementDTO.setVersion(compHouseAchievementDTO.getVersion()+1);
                    compHouseAchievementDAO.update(compHouseAchievementDTO);
                } else {
                    // 保存房建业绩信息
                    compHouseAchievementDAO.save(compHouseAchievementDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Date formatDate(String dateStr) {
        if (StringUtils.isNotEmpty(dateStr)) {
            if (dateStr.contains("/")) {
                dateStr = dateStr.replaceAll("/", "-");
            }
            return DateParseUtils.parseDate(dateStr, DatePatternEnum.DATE.getValue());
        }
        return null;
    }

    @Autowired
    public void setCompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Autowired
    public void setCompPersonnelDAO(CompPersonnelDAO compPersonnelDAO) {
        this.compPersonnelDAO = compPersonnelDAO;
    }

    @Autowired
    public void setCompAptitudeDAO(CompAptitudeDAO compAptitudeDAO) {
        this.compAptitudeDAO = compAptitudeDAO;
    }

    @Autowired
    public void setCompBuilderDAO(CompBuilderDAO compBuilderDAO) {
        this.compBuilderDAO = compBuilderDAO;
    }

    @Autowired
    public void setCompTrafficAchievementDAO(CompTrafficAchievementDAO compTrafficAchievementDAO) {
        this.compTrafficAchievementDAO = compTrafficAchievementDAO;
    }

    @Autowired
    public void setCompWaterAchievementDAO(CompWaterAchievementDAO compWaterAchievementDAO) {
        this.compWaterAchievementDAO = compWaterAchievementDAO;
    }

    @Autowired
    public void setCompKeyProjectAchievementDAO(CompKeyProjectAchievementDAO compKeyProjectAchievementDAO) {
        this.compKeyProjectAchievementDAO = compKeyProjectAchievementDAO;
    }

    @Autowired
    public void setCompWaterMonitorAchievementDAO(CompWaterMonitorAchievementDAO compWaterMonitorAchievementDAO) {
        this.compWaterMonitorAchievementDAO = compWaterMonitorAchievementDAO;
    }

    @Autowired
    public void setCompWaterDeviseAchievementDAO(CompWaterDeviseAchievementDAO compWaterDeviseAchievementDAO) {
        this.compWaterDeviseAchievementDAO = compWaterDeviseAchievementDAO;
    }

    @Autowired
    public void setCompHouseAchievementDAO(CompHouseAchievementDAO compHouseAchievementDAO) {
        this.compHouseAchievementDAO = compHouseAchievementDAO;
    }
}
