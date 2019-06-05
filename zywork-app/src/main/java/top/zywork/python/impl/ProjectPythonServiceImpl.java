package top.zywork.python.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.zywork.common.IOUtils;
import top.zywork.common.UUIDUtils;
import top.zywork.dao.ProjectDAO;
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

    private ProjectDAO projectDAO;

    @Value("${projectDetail.uri}")
    private String uri;

    @Override
    public void saveProject(String data) {
        if(data != null) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            if(jsonArray != null && jsonArray.size()> 0) {
                for (int i = 0; i < jsonArray.size() ; i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);

                    uri = uri + UUIDUtils.uuid() +".html";
                    IOUtils.writeText(obj.getString("projectDetail"),uri);

                    ProjectVO projectVO = new ProjectVO();
                    projectVO.setTitle(obj.getString("title"));
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
                    if(obj.getLong("offerPrice") != null) {
                        projectVO.setOfferPrice(obj.getLong("offerPrice") * 100);
                    }

                    if(obj.getLong("assurePrice") != null) {
                        projectVO.setAssurePrice(obj.getLong("assurePrice") * 100);
                    }
                    projectVO.setConstructionPeriod(obj.getInteger("constructionPeriod"));
                    projectVO.setDownloadEndTime(obj.getDate("downloadEndTime"));
                    projectVO.setOtherDemand(obj.getString("otherDemand"));
                    projectVO.setOpenMarkTime(obj.getDate("openMarkTime"));
                    projectVO.setOpenMarkAddr(obj.getString("openMarkAddr"));
                    projectVO.setInMarkComp(obj.getString("inMarkComp"));
                    projectVO.setNoticeTime(obj.getDate("noticeTime"));
                    projectVO.setSourceUrl(obj.getString("sourceUrl"));
                    projectVO.setInwardHtmlUrl(uri);
                    projectDAO.save(projectVO);
                }
            }
        }
    }

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
}
