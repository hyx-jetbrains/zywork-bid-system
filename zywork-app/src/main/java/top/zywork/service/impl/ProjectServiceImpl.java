package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ProjectDAO;
import top.zywork.dos.ProjectDO;
import top.zywork.dto.ProjectDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectService;

import javax.annotation.PostConstruct;

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

    private ProjectDAO projectDAO;

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        super.setBaseDAO(projectDAO);
        this.projectDAO = projectDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectDO.class, ProjectDTO.class);
    }
}
