package top.zywork.python.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateParseUtils;
import top.zywork.common.HttpUtils;
import top.zywork.constant.PythonConstants;
import top.zywork.dao.*;
import top.zywork.dto.*;
import top.zywork.enums.DatePatternEnum;
import top.zywork.python.CompanyPythonService;

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

    @Override
    public void getCompanyInfo(String type, String compType, String pageNo, String pageSize) {
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
            if (null == jsonArray) {
                logger.error("未获取到企业信息");
                return;
            }
            int len = jsonArray.size();
            for (int i = 0; i < len; i++) {
                CompanyDTO companyDTO = new CompanyDTO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // 企业名称
                String compName = jsonObject.getString("compName");
                Object obj = companyDAO.getByName(compName);
                boolean companyFlag = true;
                if (null != obj) {
                    companyFlag = false;
                    companyDTO = BeanUtils.copy(obj, CompanyDTO.class);
                    logger.error("该公司已存在：" + compName);
                }
                if (companyFlag) {
                    // 如果公司信息已经存在，则不需要再储存公司信息
                    companyDTO.setCompName(compName);
                    // 城市
                    String city = jsonObject.getString("city");
                    companyDTO.setCity(city);
                    // 企业类型
                    String tempCompType = jsonObject.getString("compType");
                    companyDTO.setCompType(tempCompType);
                    // 行业分类
                    String industryType = jsonObject.getString("industryType");
                    companyDTO.setIndustryType(industryType);
                    // 法人
                    String legalPerson = jsonObject.getString("legalPerson");
                    companyDTO.setLegalPerson(legalPerson);
                    // 法人电话
                    String legalPersonPhone = jsonObject.getString("legalPersonPhone");
                    companyDTO.setLegalPerson(legalPerson);
                    // 注册地区
                    String regAddress = jsonObject.getString("regAddress");
                    companyDTO.setRegAddress(regAddress);
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
                    // 保存公司信息
                    companyDAO.save(companyDTO);
                }
                Long compId = companyDTO.getId();
                // 企业人员
                JSONArray personnelArray = jsonObject.getJSONArray("compPersonnelList");
                if (null != personnelArray && !personnelArray.isEmpty()) {
                    saveCompPersonnelInfo(compId, personnelArray);
                }
                // 企业资质
                JSONArray aptitudeArray = jsonObject.getJSONArray("compAptitudeList");
                if (null != aptitudeArray && !aptitudeArray.isEmpty()) {
                    saveCompAptitudeInfo(compId, aptitudeArray);
                }
                // 企业建造师
                JSONArray builderArray = jsonObject.getJSONArray("compBuilderList");
                if (null != builderArray && !builderArray.isEmpty()) {
                    saveCompBuilderInfo(compId, builderArray);
                }
                // 企业业绩
                JSONArray achievementArray = jsonObject.getJSONArray("compAchievementList");
                if (null != achievementArray && !achievementArray.isEmpty()) {
                    saveCompAchievementInfo(compId, achievementArray, companyDTO.getIndustryType());
                }
                // 需要判断需不需要匹配房建业绩
                if (PythonConstants.COMPANY_TYPE_HOUSE.equals(companyDTO.getIndustryType())) {
                    // 需要判断当前企业是否有房屋市建业绩
                    updateCompHouseAchievement(compId, compName);
                }

            }
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
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
    private void saveCompPersonnelInfo(Long compId, JSONArray array) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            CompPersonnelDTO compPersonnelDTO = new CompPersonnelDTO();
            // 姓名
            String name = jsonObj.getString("name");
            Object obj = compPersonnelDAO.getByCompIdAndName(compId, name);
            if (null != obj) {
                // 说明该人员信息已经存在
                logger.error(compId + "该人员已存在：" + name);
                continue;
            }
            compPersonnelDTO.setCompId(compId);
            compPersonnelDTO.setName(name);
            // 职称
            String jobTitle = jsonObj.getString("jobTitle");
            compPersonnelDTO.setJobTitle(jobTitle);
            // 职业资格及专业
            String jobDetail = jsonObj.getString("jobDetail");
            compPersonnelDTO.setJobDetail(jobDetail);
            // 保存企业人员信息
            compPersonnelDAO.save(compPersonnelDTO);
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
    private void saveCompAptitudeInfo(Long compId, JSONArray array) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            CompAptitudeDTO compAptitudeDTO = new CompAptitudeDTO();
            // 证件号码
            String certificateNum = jsonObj.getString("certificateNum");
            Object obj = compAptitudeDAO.getByCompIdAndCertificateNum(compId, certificateNum);
            if (null != obj) {
                // 说明该资质信息已经存在
                logger.error(compId + "该资质已存在：" + certificateNum);
                continue;
            }
            compAptitudeDTO.setCompId(compId);
            compAptitudeDTO.setCertificateNum(certificateNum);
            // 资质详情
            String certificateDetail = jsonObj.getString("certificateDetail");
            compAptitudeDTO.setCertificateDetail(certificateDetail);
            // 保存企业资质信息
            compAptitudeDAO.save(compAptitudeDTO);
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
    private void saveCompBuilderInfo(Long compId, JSONArray array) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            CompBuilderDTO compBuilderDTO = new CompBuilderDTO();
            // 姓名
            String name = jsonObj.getString("name");
            Object obj = compBuilderDAO.getByCompIdAndName(compId, name);
            if (null != obj) {
                // 说明该建造师信息已经存在
                logger.error(compId + "该建造师已存在：" + name);
                continue;
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
            // 保存企业建造师信息
            compBuilderDAO.save(compBuilderDTO);

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
    private void saveCompAchievementInfo(Long compId, JSONArray array, String compType) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            String projectName = jsonObj.getString("projectName");
            if (PythonConstants.COMPANY_TYPE_KEY_PROJECT.equals(compType)) {
                // 重点工程业绩
                CompKeyProjectAchievementDTO compKeyProjectAchievementDTO = new CompKeyProjectAchievementDTO();
                Object obj = compKeyProjectAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    logger.error(compId + ":" + compType + "业绩已存在：" + projectName);
                    continue;
                }
                compKeyProjectAchievementDTO.setCompId(compId);
                compKeyProjectAchievementDTO.setProjectName(projectName);
                // 建设单位
                String buildComp = jsonObj.getString("buildComp");
                compKeyProjectAchievementDTO.setBuildComp(buildComp);
                // 中标金额
                String markMoney = jsonObj.getString("markMoney");
                compKeyProjectAchievementDTO.setMarkMoney(markMoney);
                // 开工时间
                String startDate = jsonObj.getString("startDate");
                compKeyProjectAchievementDTO.setStartDate(DateParseUtils.parseDate(startDate, DatePatternEnum.DATE.getValue()));
                // 竣工时间
                String endDate = jsonObj.getString("endDate");
                compKeyProjectAchievementDTO.setEndDate(DateParseUtils.parseDate(endDate, DatePatternEnum.DATE.getValue()));
                // 保存重点工程业绩
                compKeyProjectAchievementDAO.save(compKeyProjectAchievementDTO);
            } else if (PythonConstants.COMPANY_TYPE_TRAFFIC.equals(compType)) {
                // 交通施工业绩
                CompTrafficAchievementDTO compTrafficAchievementDTO = new CompTrafficAchievementDTO();
                Object obj = compTrafficAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    logger.error(compId + ":" + compType + "业绩已存在：" + projectName);
                    continue;
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
                compTrafficAchievementDTO.setContractAmount(contractAmount);
                // 工程地点
                String workAddr = jsonObj.getString("workAddr");
                compTrafficAchievementDTO.setWorkAddr(workAddr);
                // 开工时间
                String startDate = jsonObj.getString("startDate");
                compTrafficAchievementDTO.setStartDate(DateParseUtils.parseDate(startDate, DatePatternEnum.DATE.getValue()));
                // 竣工时间
                String endDate = jsonObj.getString("endDate");
                compTrafficAchievementDTO.setEndDate(DateParseUtils.parseDate(endDate, DatePatternEnum.DATE.getValue()));
                // 验证状态
                String validStatus = jsonObj.getString("validStatus");
                compTrafficAchievementDTO.setValidStatus(validStatus);
                // 保存交通业绩
                compTrafficAchievementDAO.save(compTrafficAchievementDTO);
            } else if (PythonConstants.COMPANY_TYPE_WATER.equals(compType)) {
                // 水利施工业绩
                CompWaterAchievementDTO compWaterAchievementDTO = new CompWaterAchievementDTO();
                Object obj = compWaterAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    logger.error(compId + ":" + compType + "业绩已存在：" + projectName);
                    continue;
                }
                compWaterAchievementDTO.setCompId(compId);
                compWaterAchievementDTO.setProjectName(projectName);
                // 合同金额
                String contractAmount = jsonObj.getString("contractAmount");
                compWaterAchievementDTO.setContractAmount(contractAmount);
                // 开工时间
                String startDate = jsonObj.getString("startDate");
                compWaterAchievementDTO.setStartDate(DateParseUtils.parseDate(startDate, DatePatternEnum.DATE.getValue()));
                // 竣工时间
                String endDate = jsonObj.getString("endDate");
                compWaterAchievementDTO.setEndDate(DateParseUtils.parseDate(endDate, DatePatternEnum.DATE.getValue()));
                // 项目负责人
                String name = jsonObj.getString("name");
                compWaterAchievementDTO.setName(name);
                // 保存水利施工业绩
                compWaterAchievementDAO.save(compWaterAchievementDTO);
            } else if (PythonConstants.COMPANY_TYPE_WATER_MONITOR.equals(compType)) {
                // 水利监理业绩
                CompWaterMonitorAchievementDTO compWaterMonitorAchievementDTO = new CompWaterMonitorAchievementDTO();
                Object obj = compWaterMonitorAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    logger.error(compId + ":" + compType + "业绩已存在：" + projectName);
                    continue;
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
                compWaterMonitorAchievementDTO.setContractAmount(contractAmount);
                // 合同签订日期
                String contractDate = jsonObj.getString("contractDate");
                compWaterMonitorAchievementDTO.setContractDate(DateParseUtils.parseDate(contractDate, DatePatternEnum.DATE.getValue()));
                // 开工时间
                String startDate = jsonObj.getString("startDate");
                compWaterMonitorAchievementDTO.setStartDate(DateParseUtils.parseDate(startDate, DatePatternEnum.DATE.getValue()));
                // 保存水利监理业绩
                compWaterMonitorAchievementDAO.save(compWaterMonitorAchievementDTO);
            } else if (PythonConstants.COMPANY_TYPE_WATER_DEVISE.equals(compType)) {
                // 水利勘查业绩
                CompWaterDeviseAchievementDTO compWaterDeviseAchievementDTO = new CompWaterDeviseAchievementDTO();
                Object obj = compWaterDeviseAchievementDAO.getByCompIdAndProjectName(compId, projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    logger.error(compId + ":" + compType + "业绩已存在：" + projectName);
                    continue;
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
                compWaterDeviseAchievementDTO.setContractAmount(contractAmount);
                // 项目负责人
                String name = jsonObj.getString("name");
                compWaterDeviseAchievementDTO.setName(name);
                // 中标时间
                String markDate = jsonObj.getString("markDate");
                compWaterDeviseAchievementDTO.setMarkDate(DateParseUtils.parseDate(markDate, DatePatternEnum.DATE.getValue()));
                // 保存水利勘查业绩
                compWaterDeviseAchievementDAO.save(compWaterDeviseAchievementDTO);
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
                compHouseAchievementDAO.update(compHouseAchievementDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getCompHouseAchievement() {
        try {
            StringBuilder url = new StringBuilder();
            url.append(PythonConstants.BASE_URL)
                    .append(PythonConstants.COMP_HOUSE_ACHIEVEMENt_INFO_URL);
            HttpUtils.timeout(PythonConstants.TIME_OUT);
            String content = HttpUtils.get(url.toString());
            JSONArray jsonArray = JSON.parseArray(content);
            if (null == jsonArray) {
                logger.error("未获取到业绩信息");
                return;
            }
            int len = jsonArray.size();
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CompHouseAchievementDTO compHouseAchievementDTO = new CompHouseAchievementDTO();
                // 工程名称
                String projectName = jsonObject.getString("projectName");
                Object obj = compHouseAchievementDAO.getByProjectName(projectName);
                if (null != obj) {
                    // 说明该业绩已存在
                    logger.error("业绩已存在：" + projectName);
                    continue;
                }
                // 中标单位
                String markComp = jsonObject.getString("markComp");
                if (!"".equals(markComp)) {
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
                compHouseAchievementDTO.setMarkMoney(markMoney);
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
                String contractDate = jsonObject.getString("contractDate");
                compHouseAchievementDTO.setContractDate(DateParseUtils.parseDate(contractDate, DatePatternEnum.DATE.getValue()));
                // 中标日期
                String markDate = jsonObject.getString("markDate");
                compHouseAchievementDTO.setMarkDate(DateParseUtils.parseDate(markDate, DatePatternEnum.DATE.getValue()));
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
                // 保存房建业绩信息
                compHouseAchievementDAO.save(compHouseAchievementDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
