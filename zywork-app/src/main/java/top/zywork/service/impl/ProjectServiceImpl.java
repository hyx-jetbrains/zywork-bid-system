package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.dao.ProjectDAO;
import top.zywork.dao.ProjectResourceDAO;
import top.zywork.dos.ProjectDO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.query.ProjectQuery;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectService;
import top.zywork.vo.ProjectResourceCountVO;
import top.zywork.vo.ProjectVO;
import top.zywork.vo.ResourceCountVO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private ProjectResourceDAO projectResourceDAO;

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        super.setBaseDAO(projectDAO);
        this.projectDAO = projectDAO;
    }

    @Autowired
    public void setProjectResourceDAO(ProjectResourceDAO projectResourceDAO) {
        this.projectResourceDAO = projectResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ProjectDO.class, ProjectDTO.class);
    }

    @Override
    public ProjectVO getOpenMark(ProjectVO projectVO) {
        // 开标时间
        Date openMarkDate = projectVO.getOpenMarkTime();
        // 默认公告中
        String markStatus = ProjectConstants.MARK_PUBLICIT_NOTICE;
        if (openMarkDate != null && !"".equals(openMarkDate.toString())) {
            // 当前时间
            long currTime = DateUtils.millis(DateUtils.currentDate());
            // 开标时间
            long openMarkTime = DateUtils.millis(openMarkDate);
            if (openMarkTime > currTime) {
                // 待开标
                markStatus = ProjectConstants.MARK_PUBLICIT_WAIT_MARK;
            } else {
                // 已开标
                markStatus = ProjectConstants.MARK_PUBLICIT_IN_MARK;
            }
        }
        projectVO.setMarkStatus(markStatus);
        return projectVO;
    }

    @Override
    public List<ProjectVO> getOpenMarkList(List<ProjectVO> projectVOList) {
        List<ProjectVO> tempProjectVOList = new ArrayList<>();
        for (ProjectVO one : projectVOList) {
            one = getOpenMark(one);
            tempProjectVOList.add(one);
        }
        return tempProjectVOList;
    }

    @Override
    public PagerDTO listPageByUserId(Object queryObj, Long userId) {
        List<Object> arrList = new ArrayList<Object>();
        PagerDTO pagerDTO = new PagerDTO();
        Long count = projectDAO.countByUserId(queryObj, userId);
        if(count > 0) {
            List<Object> list = projectDAO.listPageByUserId(queryObj, userId);

            for (int i = 0; i < list.size(); i++) {
                ProjectVO projectVO = BeanUtils.copy(list.get(i), ProjectVO.class);

                List<Object> obj = projectResourceDAO.countProjectResource(projectVO.getId());

                ProjectResourceCountVO resourceCountVO = new ProjectResourceCountVO();
                resourceCountVO.setProject(projectVO);
                resourceCountVO.setObj(obj);
                arrList.add(resourceCountVO);
            }
            pagerDTO.setRows(arrList);
            pagerDTO.setTotal(count);
        }
        return pagerDTO;
    }

    @Override
    public PagerDTO listProjectByPage(ProjectQuery projectQuery) {
        List<Object> arrList = new ArrayList<Object>();
        PagerDTO pagerDTO = new PagerDTO();
        Long count = projectDAO.countByCondition(projectQuery);
        if(count > 0) {
            List<Object> list = projectDAO.listPageByCondition(projectQuery);

            for (int i = 0; i < list.size() ; i++) {
                ProjectVO projectVO = BeanUtils.copy(list.get(i), ProjectVO.class);
                List<Object> obj = projectResourceDAO.countProjectResource(projectVO.getId());

                ProjectResourceCountVO resourceCountVO = new ProjectResourceCountVO();
                resourceCountVO.setProject(projectVO);
                resourceCountVO.setObj(obj);
                arrList.add(resourceCountVO);
            }
            pagerDTO.setRows(arrList);
            pagerDTO.setTotal(count);
        }

        return pagerDTO;
    }

    @Override
    public PagerDTO findProjectByd(Long id) {
        ProjectQuery projectQuery = new ProjectQuery();
        projectQuery.setId(id);
        return listProjectByPage(projectQuery);
    }

    @Override
    public Object getProjectBySelect(Long id, String city, List<Object> list) {
        return projectDAO.getProjectBySelect(id, city, list);
    }

}
