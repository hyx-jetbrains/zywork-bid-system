package top.zywork.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.google.common.base.Splitter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.ali.AliyunSmsConfig;
import top.zywork.ali.AliyunSmsUtils;
import top.zywork.ali.SmsSwitchConfig;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateFormatUtils;
import top.zywork.common.DateParseUtils;
import top.zywork.common.DateUtils;
import top.zywork.constant.NoticeConstants;
import top.zywork.constant.ProjectConstants;
import top.zywork.controller.BuilderReqController;
import top.zywork.dao.*;
import top.zywork.dos.ProjectDO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.dto.UserDTO;
import top.zywork.enums.DatePatternEnum;
import top.zywork.enums.NoticeEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.query.ProjectQuery;
import top.zywork.query.SubscribeQuery;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectService;
import top.zywork.service.SysConfigService;
import top.zywork.vo.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ProjectServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "projectService")
public class ProjectServiceImpl extends AbstractBaseService implements ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private ProjectDAO projectDAO;

    private ProjectResourceDAO projectResourceDAO;

    private UserNoticeDAO userNoticeDAO;

    private SubscribeDAO subscribeDAO;

    private SysConfigService sysConfigService;

    private UserDAO userDAO;

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        super.setBaseDAO(projectDAO);
        this.projectDAO = projectDAO;
    }

    @Autowired
    public void setProjectResourceDAO(ProjectResourceDAO projectResourceDAO) {
        this.projectResourceDAO = projectResourceDAO;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectDO.class, ProjectDTO.class);
    }

    @Override
    public ProjectVO getOpenMark(ProjectVO projectVO) {
        // 开标时间
        Date openMarkDate = projectVO.getOpenMarkTime();
        // 默认公告中
        String markStatus = ProjectConstants.MARK_PUBLICIT_NOTICE;
        if (openMarkDate != null && !"".equals(openMarkDate.toString())) {
            // 当前时间
            long currTime = DateUtils.millis(DateUtils.currentDate());
            // 开标时间
            long openMarkTime = DateUtils.millis(openMarkDate);
            if (openMarkTime > currTime) {
                // 待开标
                markStatus = ProjectConstants.MARK_PUBLICIT_WAIT_MARK;
            } else {
                // 已开标
                markStatus = ProjectConstants.MARK_PUBLICIT_IN_MARK;
            }
        }
        projectVO.setMarkStatus(markStatus);
        return projectVO;
    }

    @Override
    public List<ProjectVO> getOpenMarkList(List<ProjectVO> projectVOList) {
        List<ProjectVO> tempProjectVOList = new ArrayList<>();
        for (ProjectVO one : projectVOList) {
            one = getOpenMark(one);
            tempProjectVOList.add(one);
        }
        return tempProjectVOList;
    }

    @Override
    public PagerDTO listPageByUserId(Object queryObj, Long userId) {
        List<Object> arrList = new ArrayList<Object>();
        PagerDTO pagerDTO = new PagerDTO();
        Long count = projectDAO.countByUserId(queryObj, userId);
        if(count > 0) {
            List<Object> list = projectDAO.listPageByUserId(queryObj, userId);

            for (int i = 0; i < list.size(); i++) {
                ProjectVO projectVO = BeanUtils.copy(list.get(i), ProjectVO.class);

                List<Object> obj = projectResourceDAO.countProjectResource(projectVO.getId());

                ProjectResourceCountVO resourceCountVO = new ProjectResourceCountVO();
                resourceCountVO.setProject(projectVO);
                resourceCountVO.setObj(obj);
                arrList.add(resourceCountVO);
            }
        }
        pagerDTO.setRows(arrList);
        pagerDTO.setTotal(count);
        return pagerDTO;
    }

    @Override
    public PagerDTO listProjectByPage(ProjectQuery projectQuery) {
        List<Object> arrList = new ArrayList<Object>();
        PagerDTO pagerDTO = new PagerDTO();
        Long count = projectDAO.countByCondition(projectQuery);
        if(count > 0) {
            List<Object> list = projectDAO.listPageByCondition(projectQuery);

            for (int i = 0; i < list.size() ; i++) {
                ProjectVO projectVO = BeanUtils.copy(list.get(i), ProjectVO.class);
                List<Object> obj = projectResourceDAO.countProjectResource(projectVO.getId());

                ProjectResourceCountVO resourceCountVO = new ProjectResourceCountVO();
                resourceCountVO.setProject(projectVO);
                resourceCountVO.setObj(obj);
                arrList.add(resourceCountVO);
            }
        }
        pagerDTO.setRows(arrList);
        pagerDTO.setTotal(count);
        return pagerDTO;
    }

    @Override
    public PagerDTO findProjectByd(Long id) {
        ProjectQuery projectQuery = new ProjectQuery();
        projectQuery.setId(id);
        return listProjectByPage(projectQuery);
    }

    @Override
    public Object getProjectBySelect(Long id, String city, List<Object> list) {
        return projectDAO.getProjectBySelect(id, city, list);
    }

    @Override
    public void updateMarkStatus() {
        projectDAO.updateMarkStatus();
    }

    @Override
    public Object getByTitle(String title) {
        return projectDAO.getByTitle(title);
    }

    @Autowired
    public void setUserNoticeDAO(UserNoticeDAO userNoticeDAO) {
        this.userNoticeDAO = userNoticeDAO;
    }

    @Autowired
    public void setSubscribeDAO(SubscribeDAO subscribeDAO) { this.subscribeDAO = subscribeDAO; }

    @Override
    public void subscribleNotice(ProjectVO projectVO, String type) {
        // 查询所有的订阅信息
        SubscribeQuery subscribeQuery = new SubscribeQuery();
        subscribeQuery.setIsActive((byte)0);
        List<Object> objList = subscribeDAO.listAllByCondition(subscribeQuery);
        if(objList != null && objList.size() > 0) {
            List<SubscribeVO> list = BeanUtils.copy(objList, SubscribeVO.class);
            StringBuilder userIds = new StringBuilder();
            JSONObject templateParam = new JSONObject();
            for(SubscribeVO subscribeVO: list) {
                Long userId = subscribeVO.getUserId();
                // 一、判断用户是否开通了订阅推送
                if (0 == subscribeVO.getIsSubscribe()) {
                    // 用户未开通订阅推送，直接跳过当前循环
                    continue;
                }
                // 二、用户开通了订阅推送，判断城市是否匹配
                if (!subscribeVO.getCity().equals("全省")) {
                    // 用户设置的不是全省，需要判断当前项目是否满足
                    if (!projectVO.getCity().equals(subscribeVO.getCity())) {
                        // 和用户订阅的城市不匹配，跳出本次循环，继续判断下个用户
                        continue;
                    }
                }
                // 三、用户设置了全省或者当前这个项目和用户订阅的城市匹配，继续判断项目类型是否匹配
                if (!org.apache.commons.lang.StringUtils.isEmpty(subscribeVO.getProjectType())) {
                    // 用户设置了订阅的项目类型
                    if (!subscribeVO.getProjectType().contains(projectVO.getProjectType())) {
                        // 当前项目不在用户订阅的项目类型当中
                        continue;
                    }
                }
                if ("政府采购".equals(projectVO.getProjectType())) {
                    // 如果当前项目是政府采购，还需要判断用户有没有订阅关键字
                    if (!org.apache.commons.lang.StringUtils.isEmpty(subscribeVO.getKeyword())) {
                        // 用户有输入关键字
                        if (!projectVO.getTitle().contains(subscribeVO.getKeyword())) {
                            // 当前项目不包含用户订阅的关键字
                            continue;
                        }
                    }
                } else {
                    String tempProjectInvest = projectVO.getProjectInvest();
                    if (org.apache.commons.lang.StringUtils.isNotEmpty(tempProjectInvest)) {
                        // 当前项目有设置金额，需要判断用户订阅的金额区间
                        Pattern pat = Pattern.compile(ProjectConstants.ZHCN_TEXT_REG);
                        Matcher mat = pat.matcher(tempProjectInvest);
                        Double projectInvest = Double.valueOf(mat.replaceAll("").trim());
                        // 四、用户设置了全省或者当前这个项目和用户订阅的城市匹配，并且没有设置订阅的类型，继续判断金额区间
                        if (0 != subscribeVO.getMinMoney()) {
                            // 用设置了最小金额
                            double minMoney = Double.valueOf(subscribeVO.getMinMoney()) / 100;
                            if (projectInvest < minMoney) {
                                // 当前项目的金额小于用户订阅的最小金额
                                continue;
                            }
                        }
                        if (0 != subscribeVO.getMaxMoney()) {
                            // 用户设置了最大金额
                            double maxMoney = Double.valueOf(subscribeVO.getMaxMoney()) / 100;
                            if (projectInvest > maxMoney) {
                                // 当前项目的金额大于用户订阅的金额
                                continue;
                            }
                        }
                    }

                }

                // 五、上面的条件都满足，继续判断订阅的招标单位
//                if (!org.apache.commons.lang.StringUtils.isEmpty(subscribeVO.getTenderee())) {
//                    // 用户有订阅专门的投标单位
//                    if (!subscribeVO.getTenderee().contains(projectVO.getInMarkComp())) {
//                        // 当前项目的招标单位不在用户的订阅里面
//                        continue;
//                    }
//                }
                // 六、满足用户的所有订阅条件，给用户推送消息
                String title = "";
                String descContent = "";
                String content = projectVO.getProjectType() + "-" + projectVO.getTitle();
                if (ProjectConstants.PROJECT_SUBSCRIBE_TYPE_UPDATE.equals(type)) {
                    title = "项目订阅更新";
                    content = "项目订阅更新通知：" + content;
                    descContent = "您订阅的项目"+content+"符合条件的项目发布了，具体内容可点击《立即查看》按钮前往查看";
                } else if (ProjectConstants.PROJECT_SUBSCRIBE_TYPE_OPEN_MARK.equals(type)) {
                    title = "开标通知";
                    content = "项目订阅开标通知：" + content + "于" + projectVO.getOpenMarkTime() + "开标";
                    descContent = "您订阅的项目"+content+"于"+projectVO.getOpenMarkTime()+"开标，具体内容可点击《立即查看》按钮前往查看";
                    templateParam.put("openMarkTime", DateFormatUtils.format(projectVO.getOpenMarkTime(), DatePatternEnum.DATE.getValue()));
                }
                String tempProjectTitle = projectVO.getTitle();
                if (tempProjectTitle.length() > 16) {
                    tempProjectTitle = tempProjectTitle.substring(0,16) + "...";
                }
//                Iterable<String> iterableProjectTitle = Splitter.fixedLength(ProjectConstants.SMS_PROJECT_TITLE_SPLIT_LENGTH).split(tempProjectTitle);
//                Iterator<String> iteratorProjectTitle = iterableProjectTitle.iterator();
//                int i = 1;
//                while (i < 6) {
//                    if (iteratorProjectTitle.hasNext()) {
//                        templateParam.put("projectTitle" + i, iteratorProjectTitle.next());
//                    } else {
//                        templateParam.put("projectTitle" + i, "");
//                    }
//                    i++;
//                }
                templateParam.put("projectTitle", tempProjectTitle);
                templateParam.put("projectType", projectVO.getProjectType());
                saveNotice(userId, projectVO, title, content, descContent);
                if (StringUtils.isEmpty(userIds.toString())) {
                    userIds.append(userId);
                } else {
                    userIds.append(",").append(userId);
                }
            }
            // 开始处理发送短信提醒
            if (userIds.length() > 0) {
                List<Object> objectList = userDAO.listByUserIds(userIds.toString().split(","));
                if (null != objectList && objectList.size() > 0) {
                    List<UserDTO> userDTOList = BeanUtils.copy(objectList, UserDTO.class);
                    StringBuilder userPhones = new StringBuilder();
                    for (UserDTO userDTO : userDTOList) {
                        String phone = userDTO.getPhone();
                        if (StringUtils.isEmpty(phone)) {
                            continue;
                        }
                        if (StringUtils.isEmpty(userPhones.toString())) {
                            userPhones.append(phone);
                        } else {
                            userPhones.append(",").append(phone);
                        }
                    }
                    if (userPhones.length() > 0) {
                        sendSmsNotice(type, userPhones.toString(), templateParam.toJSONString());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("[铅山县][线下]江西众诚投资咨询有限公司关于江西省铅山县陈坊乡陈坊村中国传统村落保护发展规划（2019-2035）（采购编号：JXZC2019-C080）竞争性磋商采购公告".length());
        AliyunSmsConfig aliyunSmsConfig = new AliyunSmsConfig("LTAICo2uh0fDKnN0", "Pi1UR1H2FhUiFPOP0IW2QqSuDWnC1j", "江西数达信息科技有限公司");
        aliyunSmsConfig.setRegionId("cn-shenzhen");
        String phones = "18279700225";
        JSONObject templateParam = new JSONObject();
        String tempProjectTitle = "[铅山县][线下]江西众诚投资咨询有限公司关于江西省铅山县陈坊乡陈坊村中国传统村落保护发展规划（2019-2035）（采购编号：JXZC2019-C080）竞争性磋商采购公告".substring(0, 16) + "...";
//        Iterable<String> iterableProjectTitle = Splitter.fixedLength(ProjectConstants.SMS_PROJECT_TITLE_SPLIT_LENGTH).split(tempProjectTitle);
//        Iterator<String> iteratorProjectTitle = iterableProjectTitle.iterator();
//        int i = 1;
//        while (i < 6) {
//            if (iteratorProjectTitle.hasNext()) {
//                templateParam.put("projectTitle" + i, iteratorProjectTitle.next());
//            } else {
//                templateParam.put("projectTitle" + i, "");
//            }
//            i++;
//        }
        templateParam.put("projectTitle", tempProjectTitle);
        templateParam.put("projectType", "政府采购");
        SendSmsResponse sendSmsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phones, ProjectConstants.SMS_NOTICE_TEMPLATE_CODE_SUBSCRIBE_NOTICE,
                templateParam.toJSONString(), null);
        System.out.println(sendSmsResponse);
    }

    /***
     * @description:  保存用户通知信息
     * @param userId 用户id
     * @param projectVO 项目
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-27 11:54
     */
    public void saveNotice(Long userId, ProjectVO projectVO, String title, String content, String descContent) {
        Long projectId = projectVO.getId();
        UserNoticeVO userNoticeVO= new UserNoticeVO();
        userNoticeVO.setUserId(userId);
        userNoticeVO.setItemId(projectId);
        userNoticeVO.setPageUrl(NoticeConstants.projectUrl);
        userNoticeVO.setTitle(title);
        userNoticeVO.setMainContent(content);
        userNoticeVO.setDetailContent(descContent);
        userNoticeVO.setNoticeType(NoticeEnum.SUBSCRIBE_MESSAGE.getValue());
        userNoticeDAO.save(userNoticeVO);
    }

    /***
     * @description:  发送短信通知
     * @param type 订阅的类型
     * @param phones 需要发送的手机号
     * @param templateParam 模版的参数
     * @return: void
     * @author: 危锦辉 http://wjhsmart.vip
     * @date: 2019-06-27 15:25
     */
    public void sendSmsNotice(String type, String phones, String templateParam) {
        SmsSwitchConfig smsSwitchConfig = sysConfigService.getByName(SysConfigEnum.SMS_SWITCH_CONFIG.getValue(), SmsSwitchConfig.class);
        AliyunSmsConfig aliyunSmsConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
        try {
            if (ProjectConstants.PROJECT_SUBSCRIBE_TYPE_UPDATE.equals(type)) {
                // 项目订阅提醒
                if (ProjectConstants.SMS_SWITCH_TRUE.equals(smsSwitchConfig.getSubscribeNotice())) {
                    // 只有配置中开启了短信提醒，才需要发送短信提醒
                    SendSmsResponse sendSmsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phones, ProjectConstants.SMS_NOTICE_TEMPLATE_CODE_SUBSCRIBE_NOTICE,
                            templateParam, null);
                    if (!sendSmsResponse.getCode().equals("OK")) {
                        logger.error("短信发送失败：" + sendSmsResponse.getMessage());
                    }
                }
            } else if (ProjectConstants.PROJECT_SUBSCRIBE_TYPE_OPEN_MARK.equals(type)) {
                // 开标提醒
                if (ProjectConstants.SMS_SWITCH_TRUE.equals(smsSwitchConfig.getOpenMarkNotice())) {
                    // 只有配置中开启了短信提醒，才需要发送短信提醒
                    SendSmsResponse sendSmsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phones, ProjectConstants.SMS_NOTICE_TEMPLATE_CODE_OPEN_MARK_NOTICE,
                            templateParam, null);
                    if (!sendSmsResponse.getCode().equals("OK")) {
                        logger.error("短信发送失败：" + sendSmsResponse.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
