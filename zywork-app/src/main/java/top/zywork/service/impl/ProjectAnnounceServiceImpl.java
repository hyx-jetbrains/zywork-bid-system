package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.dao.ProjectAnnounceDAO;
import top.zywork.dos.ProjectAnnounceDO;
import top.zywork.dto.ProjectAnnounceDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectAnnounceService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * ProjectAnnounceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "projectAnnounceService")
public class ProjectAnnounceServiceImpl extends AbstractBaseService implements ProjectAnnounceService {

    private ProjectAnnounceDAO projectAnnounceDAO;

    @Autowired
    public void setProjectAnnounceDAO(ProjectAnnounceDAO projectAnnounceDAO) {
        super.setBaseDAO(projectAnnounceDAO);
        this.projectAnnounceDAO = projectAnnounceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectAnnounceDO.class, ProjectAnnounceDTO.class);
    }

    @Override
    public List<ProjectDTO> getProjectSelect(Long projectId) {
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        List<Object> list = projectAnnounceDAO.getProjectSelect(projectId);
        if (null != list && list.size() > 0) {
            projectDTOList = BeanUtils.copy(list, ProjectDTO.class);
        }
        return projectDTOList;
    }

    @Override
    public Object getByProjectId(Long projectId) {
        return projectAnnounceDAO.getByProjectId(projectId);
    }
}
