package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ProjectAnnounceProjectDAO;
import top.zywork.dos.ProjectAnnounceProjectDO;
import top.zywork.dto.ProjectAnnounceProjectDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectAnnounceProjectService;

import javax.annotation.PostConstruct;

/**
 * ProjectAnnounceProjectServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-29<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "projectAnnounceProjectService")
public class ProjectAnnounceProjectServiceImpl extends AbstractBaseService implements ProjectAnnounceProjectService {

    private ProjectAnnounceProjectDAO projectAnnounceProjectDAO;

    @Autowired
    public void setProjectAnnounceProjectDAO(ProjectAnnounceProjectDAO projectAnnounceProjectDAO) {
        super.setBaseDAO(projectAnnounceProjectDAO);
        this.projectAnnounceProjectDAO = projectAnnounceProjectDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectAnnounceProjectDO.class, ProjectAnnounceProjectDTO.class);
    }
}
