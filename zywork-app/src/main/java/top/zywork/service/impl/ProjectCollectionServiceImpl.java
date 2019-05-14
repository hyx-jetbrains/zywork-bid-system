package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ProjectCollectionDAO;
import top.zywork.dos.ProjectCollectionDO;
import top.zywork.dto.ProjectCollectionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectCollectionService;

import javax.annotation.PostConstruct;

/**
 * ProjectCollectionServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "projectCollectionService")
public class ProjectCollectionServiceImpl extends AbstractBaseService implements ProjectCollectionService {

    private ProjectCollectionDAO projectCollectionDAO;

    @Autowired
    public void setProjectCollectionDAO(ProjectCollectionDAO projectCollectionDAO) {
        super.setBaseDAO(projectCollectionDAO);
        this.projectCollectionDAO = projectCollectionDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectCollectionDO.class, ProjectCollectionDTO.class);
    }

    @Override
    public Object getByUserAndProject(Long userId, Long projectId) {
        return projectCollectionDAO.getByUserAndProject(userId, projectId);
    }
}
