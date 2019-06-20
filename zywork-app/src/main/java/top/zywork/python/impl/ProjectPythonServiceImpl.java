package top.zywork.python.impl;

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
import top.zywork.dao.ProjectAnnounceDAO;
import top.zywork.dao.ProjectDAO;
import top.zywork.dto.ProjectAnnounceDTO;
import top.zywork.enums.DatePatternEnum;
import top.zywork.python.ProjectPythonService;
import top.zywork.vo.ProjectVO;

/**
 * 获取招标信息的接口实现类<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "projectPythonService")
public class ProjectPythonServiceImpl implements ProjectPythonService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectPythonServiceImpl.class);

    private ProjectDAO projectDAO;

    private ProjectAnnounceDAO projectAnnounceDAO;

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    @Override
    public void saveProject(String url) {
        HttpUtils.timeout(PythonConstants.TIME_OUT);
        String data = HttpUtils.get(url);
        if(data != null) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            if(jsonArray != null && jsonArray.size()> 0) {
                for (int i = 0; i < jsonArray.size() ; i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String title = obj.getString("title");

                    Object projectObj = projectDAO.getByTitle(title);
                    if (null != projectObj) {
                        logger.info("项目已存在：" + title);
                        continue;
                    }

                    String fileName = UUIDUtils.uuid() +".html";
                    String head = "<!DOCTYPE html><html><head><meta charset='utf-8'></head><body>";
                    String foot = "</body></html>";

                    IOUtils.writeText(head +obj.getString("projectDetail")+ foot, location + "/" + fileName);

                    ProjectVO projectVO = new ProjectVO();
                    projectVO.setTitle(title);
                    projectVO.setProjectType(obj.getString("projectType"));
                    projectVO.setCity(obj.getString("city"));
                    projectVO.setProjectDetail(obj.getString("projectDetail"));
                    projectVO.setMarkUnitName(obj.getString("markUnitName"));
                    projectVO.setProjectInvest(obj.getString("projectInvest"));
                    projectVO.setCheckPattern(obj.getString("checkPattern"));
                    projectVO.setCompAptitudeType(obj.getString("compAptitudeType"));
                    projectVO.setBuilderLevel(obj.getString("builderLevel"));
                    projectVO.setMoneyToImplement(obj.getFloat("moneyToImplement"));
                    projectVO.setTenderingAgent(obj.getString("tenderingAgent"));
                    projectVO.setPhone(obj.getString("phone"));
                    projectVO.setMarkStatus(ProjectConstants.MARK_PUBLICIT_NOTICE);
                    if(obj.getLong("offerPrice") != null) {
                        projectVO.setOfferPrice(obj.getBigDecimal("offerPrice"));
                    }

                    if(obj.getLong("assurePrice") != null) {
                        projectVO.setAssurePrice(obj.getBigDecimal("assurePrice"));
                    }
                    projectVO.setConstructionPeriod(obj.getInteger("constructionPeriod"));
                    projectVO.setDownloadEndTime(obj.getDate("downloadEndTime"));
                    projectVO.setOtherDemand(obj.getString("otherDemand"));
                    projectVO.setOpenMarkTime(obj.getDate("openMarkTime"));
                    projectVO.setOpenMarkAddr(obj.getString("openMarkAddr"));
                    projectVO.setInMarkComp(obj.getString("inMarkComp"));
                    String noticeTime = obj.getString("noticeTime");
                    if (!StringUtils.isEmpty(noticeTime)) {
                        projectVO.setNoticeTime(DateParseUtils.parseDate(noticeTime, DatePatternEnum.DATE.getValue()));
                    }
                    projectVO.setSourceUrl(obj.getString("sourceUrl"));
                    projectVO.setInwardHtmlUrl(uri + "/" + fileName);
                    projectVO.setResourceCount(0);
                    projectDAO.save(projectVO);

                    // 根据名称查询业绩，如果有查询到，则更新
                    Object tempObj = projectAnnounceDAO.getByTitle(title + "[中标候选人公示]");
                    if (null != tempObj) {
                        ProjectAnnounceDTO projectAnnounceDTO = BeanUtils.copy(tempObj, ProjectAnnounceDTO.class);
                        if (projectAnnounceDTO.getId() == 0) {
                            // 说明该业绩还未匹配对应的项目
                            projectAnnounceDTO.setProjectId(projectVO.getId());
                            projectAnnounceDAO.update(projectAnnounceDTO);
                            projectVO.setInMarkComp(projectAnnounceDTO.getFirstCandidate());
                            projectDAO.update(projectVO);
                        }
                    }


                }
            }
        }
    }

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Autowired
    public void setProjectAnnounceDAO(ProjectAnnounceDAO projectAnnounceDAO) {
        this.projectAnnounceDAO = projectAnnounceDAO;
    }
}
