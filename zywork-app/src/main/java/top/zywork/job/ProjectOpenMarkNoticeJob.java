package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.annotation.ExposeClass;
import top.zywork.common.BeanUtils;
import top.zywork.common.DateParseUtils;
import top.zywork.common.DateUtils;
import top.zywork.constant.ProjectConstants;
import top.zywork.dos.StatisticsDauDO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ProjectDTO;
import top.zywork.enums.DatePatternEnum;
import top.zywork.query.ProjectQuery;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.service.ProjectService;
import top.zywork.service.StatisticsDauService;
import top.zywork.vo.ProjectVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/***
 * @description:  项目开标通知的job，每天执行一次即可
 * @return:
 * @author: 危锦辉 http://wjhsmart.vip
 * @date: 2019-06-27 13:56
 */
@ExposeClass(type = "job")
public class ProjectOpenMarkNoticeJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(ProjectOpenMarkNoticeJob.class);

    private ProjectService projectService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute ProjectOpenMarkNoticeJob......");
        // 取明天的日期
        LocalDate localDate = LocalDate.now().plusDays(1);
        String tommorrowDate = localDate.format(DateTimeFormatter.ofPattern(DatePatternEnum.DATE.getValue()));
        Date tommorrowDateMin = DateParseUtils.parseDate(tommorrowDate + " 00:00:00", DatePatternEnum.DATETIME.getValue());
        Date tommorrowDateMax = DateParseUtils.parseDate(tommorrowDate + " 23:59:59", DatePatternEnum.DATETIME.getValue());
        ProjectQuery projectQuery = new ProjectQuery();
        projectQuery.setIsActive((byte)0);
        projectQuery.setOpenMarkTimeMin(tommorrowDateMin);
        projectQuery.setOpenMarkTimeMax(tommorrowDateMax);
        projectQuery.setReleaseStatus(ProjectConstants.RELEASE_STAUTS_TRUE);
        projectQuery.setMarkStatus(ProjectConstants.MARK_PUBLICIT_WAIT_MARK);
        PagerDTO pagerDTO = projectService.listAllByCondition(projectQuery);
        List<Object> objectList = pagerDTO.getRows();
        if (null != objectList && objectList.size() > 0) {
            List<ProjectVO> projectVOList = BeanUtils.copy(objectList, ProjectVO.class);
            for (ProjectVO projectVO : projectVOList) {
                // 发送开标通知
                projectService.subscribleNotice(projectVO, ProjectConstants.PROJECT_SUBSCRIBE_TYPE_OPEN_MARK);
            }
        }
        logger.info("executed ProjectOpenMarkNoticeJob......");
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
