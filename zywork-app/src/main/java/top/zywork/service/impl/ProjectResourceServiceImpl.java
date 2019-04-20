package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ProjectResourceDAO;
import top.zywork.dos.ProjectResourceDO;
import top.zywork.dto.ProjectResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectResourceService;

import javax.annotation.PostConstruct;

/**
 * ProjectResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "projectResourceService")
public class ProjectResourceServiceImpl extends AbstractBaseService implements ProjectResourceService {

    private ProjectResourceDAO projectResourceDAO;

    @Autowired
    public void setProjectResourceDAO(ProjectResourceDAO projectResourceDAO) {
        super.setBaseDAO(projectResourceDAO);
        this.projectResourceDAO = projectResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectResourceDO.class, ProjectResourceDTO.class);
    }
}
