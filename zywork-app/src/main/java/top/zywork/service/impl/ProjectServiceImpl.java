package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.dao.ProjectDAO;
import top.zywork.dos.ProjectDO;
import top.zywork.dto.ProjectDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ProjectService;
import top.zywork.vo.ProjectVO;

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

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        super.setBaseDAO(projectDAO);
        this.projectDAO = projectDAO;
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
            if (openMarkTime < currTime) {
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

}
