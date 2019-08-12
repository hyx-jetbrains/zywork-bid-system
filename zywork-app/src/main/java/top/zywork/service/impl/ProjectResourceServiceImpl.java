package top.zywork.service.impl;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.dao.ProjectResourceDAO;
import top.zywork.dao.ResourceDAO;
import top.zywork.dos.ProjectResourceDO;
import top.zywork.dto.ProjectResourceDTO;
import top.zywork.dto.ResourceDTO;
import top.zywork.query.ProjectResourceQuery;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectResourceService;
import top.zywork.service.ProjectService;
import top.zywork.vo.ProjectVO;
import top.zywork.vo.ResponseStatusVO;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

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

    private ResourceDAO resourceDAO;

    private ProjectService projectService;

    @Autowired
    public void setProjectResourceDAO(ProjectResourceDAO projectResourceDAO) {
        super.setBaseDAO(projectResourceDAO);
        this.projectResourceDAO = projectResourceDAO;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setResourceDAO(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectResourceDO.class, ProjectResourceDTO.class);
    }

    @Override
    public ResponseStatusVO deleteByCond(ProjectResourceQuery projectResourceQuery) {
        try {
            List<Object> objectList = projectResourceDAO.listAllByCondition(projectResourceQuery);
            if (null != objectList && objectList.size() > 0) {
                List<ProjectResourceDTO> projectResourceDTOList = BeanUtils.copy(objectList, ProjectResourceDTO.class);
                StringBuilder projectResourceIds = new StringBuilder();
                StringBuilder resourceIds = new StringBuilder();
                for (ProjectResourceDTO projectResourceDTO : projectResourceDTOList) {
                    ProjectVO projectVO = BeanUtils.copy(projectService.getById(projectResourceDTO.getProjectId()), ProjectVO.class);
                    projectVO.setResourceCount(projectVO.getResourceCount() - 1);
                    projectService.update(projectVO);
                    Long id = projectResourceDTO.getId();
                    Long resourceId = projectResourceDTO.getResourceId();
                    if (StringUtils.isEmpty(projectResourceIds.toString())) {
                        projectResourceIds.append(id);
                    } else {
                        projectResourceIds.append(",").append(id);
                    }
                    if (StringUtils.isEmpty(resourceId.toString())) {
                        resourceIds.append(resourceId);
                    } else {
                        resourceIds.append(",").append(resourceId);
                    }
                }
                List<ResourceDTO> resourceDTOList = BeanUtils.copy(resourceDAO.listByIds(resourceIds.toString().split(",")), ResourceDTO.class);
                for (ResourceDTO resourceDTO : resourceDTOList) {
                    String url = "/data/bid-system/" + resourceDTO.getUrl();
                    File file = new File(url);
                    if(file.exists()) {
                        file.delete();
                    }
                }
                projectResourceDAO.removeByIds(projectResourceIds.toString().split(","));
                resourceDAO.removeByIds(resourceIds.toString().split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatusVO.error("删除失败，请联系管理员", null);
        }
        return ResponseStatusVO.ok("删除成功", null);
    }
}
