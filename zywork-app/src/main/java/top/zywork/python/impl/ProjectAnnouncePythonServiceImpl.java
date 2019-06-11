package top.zywork.python.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.IOUtils;
import top.zywork.common.UUIDUtils;
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

    private ProjectAnnounceDAO projectAnnounceDAO;

    private ProjectDAO projectDAO;

    @Value("${projectDetail.uri}")
    private String uri;

    @Value("${projectDetail.location}")
    private String location;

    @Override
    public void saveProjectAnnounce(String data) {
        if(data != null) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            if(jsonArray != null && jsonArray.size()> 0) {
                for (int i = 0; i < jsonArray.size() ; i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    ProjectAnnounceVO projectAnnounceVO = new ProjectAnnounceVO();


                    if(obj.getString("title") != null && obj.getString("title") != "") {
                        String title = obj.getString("title").replace("[中标候选人公示]","");
                        Object pobj = projectDAO.getByTitle(title);
                        if(pobj != null) {
                            ProjectDO projectDO = BeanUtils.copy(pobj, ProjectDO.class);
                            projectAnnounceVO.setProjectId(projectDO.getId());
                        }
                    }

                    String fileName = UUIDUtils.uuid() +".html";
                    String head = "<!DOCTYPE html><html><head><meta charset='utf-8'></head><body>";
                    String foot = "</body></html>";
                    IOUtils.writeText(head +obj.getString("projectDetail")+ foot, location + "/" + fileName);
                    projectAnnounceVO.setProjectType(obj.getString("projectType"));
                    projectAnnounceVO.setTitle(obj.getString("title"));
                    projectAnnounceVO.setAnnounceDesc(obj.getString("announceDesc"));
                    projectAnnounceVO.setFirstCandidate(obj.getString("firstCandidate"));
                    projectAnnounceVO.setFirstBuilderName(obj.getString("firstBuilderName"));
                    projectAnnounceVO.setFirstMarkMoney(obj.getString("firstMarkMoney"));
                    projectAnnounceVO.setSecondCandidate(obj.getString("secondCandidate"));
                    projectAnnounceVO.setThirdCandidate(obj.getString("thirdCandidate"));
                    projectAnnounceVO.setSourceUrl(obj.getString("sourceUrl"));
                    projectAnnounceVO.setInwordHtmlUrl(uri + "/" + fileName);
                    projectAnnounceDAO.save(projectAnnounceVO);
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
