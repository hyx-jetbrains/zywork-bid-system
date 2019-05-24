package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ProjectResourceResourceDAO;
import top.zywork.dos.ProjectResourceResourceDO;
import top.zywork.dto.ProjectResourceResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectResourceResourceService;

import javax.annotation.PostConstruct;

/**
 * ProjectResourceResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-24<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "projectResourceResourceService")
public class ProjectResourceResourceServiceImpl extends AbstractBaseService implements ProjectResourceResourceService {

    private ProjectResourceResourceDAO projectResourceResourceDAO;

    @Autowired
    public void setProjectResourceResourceDAO(ProjectResourceResourceDAO projectResourceResourceDAO) {
        super.setBaseDAO(projectResourceResourceDAO);
        this.projectResourceResourceDAO = projectResourceResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectResourceResourceDO.class, ProjectResourceResourceDTO.class);
    }
}
