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
import top.zywork.constant.PythonConstants;
import top.zywork.dao.ProjectAnnounceDAO;
import top.zywork.dao.ProjectDAO;
import top.zywork.dos.ProjectDO;
import top.zywork.python.ProjectAnnouncePythonService;
import top.zywork.python.ProjectPythonService;
import top.zywork.vo.ProjectAnnounceVO;
import top.zywork.vo.ProjectVO;

/**
 * 获取招标信息的接口实现类<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "projectAnnouncePythonService")
public class ProjectAnnouncePythonServiceImpl implements ProjectAnnouncePythonService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectAnnouncePythonServiceImpl.class);

    private ProjectAnnounceDAO projectAnnounceDAO;

    private ProjectDAO projectDAO;

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    @Override
    public void saveProjectAnnounce(String url, boolean isUpdate) {
        HttpUtils.timeout(PythonConstants.TIME_OUT);
        String data = HttpUtils.get(url);
        if(data != null) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            if(jsonArray != null && jsonArray.size()> 0) {
                for (int i = 0; i < jsonArray.size() ; i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    ProjectAnnounceVO projectAnnounceVO = new ProjectAnnounceVO();
                    String tempTitle = obj.getString("title");

                    Object projectAnnounceObj = projectAnnounceDAO.getByTitle(tempTitle);
                    boolean updateFlag = false;
                    if (projectAnnounceObj != null) {
                        updateFlag = true;
                        logger.info("该公示已存在：" + tempTitle + ",是否更新：" + isUpdate);
                        if (!isUpdate) {
                            continue;
                        }
                    }

                    String inMarkComp = obj.getString("firstCandidate");
                    if(!StringUtils.isEmpty(tempTitle)) {
                        String title = tempTitle.replace("[中标候选人公示]","");
                        Object pobj = projectDAO.getByTitle(title);
                        if(pobj != null) {
                            ProjectDO projectDO = BeanUtils.copy(pobj, ProjectDO.class);
                            projectAnnounceVO.setProjectId(projectDO.getId());
                            // 把中标单位更新进去
                            projectDO.setInMarkComp(inMarkComp);
                            projectDAO.update(projectDO);
                        }
                    }

                    String fileName = UUIDUtils.uuid() +".html";
                    String projectDetail = obj.getString("projectDetail");
                    CommonMethodUtils.generatorHtmlCode(fileName, projectDetail, location);

                    projectAnnounceVO.setProjectType(obj.getString("projectType"));
                    projectAnnounceVO.setTitle(tempTitle);
                    projectAnnounceVO.setAnnounceDesc(obj.getString("announceDesc"));
                    projectAnnounceVO.setFirstCandidate(inMarkComp);
                    projectAnnounceVO.setFirstBuilderName(obj.getString("firstBuilderName"));
                    projectAnnounceVO.setFirstMarkMoney(obj.getString("firstMarkMoney"));
                    projectAnnounceVO.setSecondCandidate(obj.getString("secondCandidate"));
                    projectAnnounceVO.setThirdCandidate(obj.getString("thirdCandidate"));
                    projectAnnounceVO.setSourceUrl(obj.getString("sourceUrl"));
                    projectAnnounceVO.setInwordHtmlUrl(uri + "/" + fileName);
                    if (updateFlag) {
                        projectAnnounceDAO.update(projectAnnounceVO);
                    } else {
                        projectAnnounceDAO.save(projectAnnounceVO);
                    }
                }
            }
        }
    }

    @Autowired
    public void setProjectAnnounceDAO(ProjectAnnounceDAO projectAnnounceDAO) {
        this.projectAnnounceDAO = projectAnnounceDAO;
    }

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
}
