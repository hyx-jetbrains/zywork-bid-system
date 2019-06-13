package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.annotation.ExposeClass;
import top.zywork.common.HttpUtils;
import top.zywork.constant.PythonConstants;
import top.zywork.python.ProjectAnnouncePythonService;
import top.zywork.python.ProjectPythonService;

/**
 * DAU保存作业<br/>
 *
 * 创建于2019-01-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@ExposeClass(type = "job")
public class ProjectAnnounceOtherJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(ProjectAnnounceOtherJob.class);

    private ProjectAnnouncePythonService projectAnnouncePythonService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        logger.info("begin to execute ProjectAnnounceOtherJob......");
        String url = PythonConstants.BASE_URL+PythonConstants.PROJECT_ANNOUNCE_CONSERVANCY;
        HttpUtils.timeout(PythonConstants.TIME_OUT);
        String data = HttpUtils.get(url);
        projectAnnouncePythonService.saveProjectAnnounce(data);
        logger.info("executed ProjectAnnounceOtherJob......");
    }

    @Autowired
    public void setProjectAnnouncePythonService(ProjectAnnouncePythonService projectAnnouncePythonService) {
        this.projectAnnouncePythonService = projectAnnouncePythonService;
    }
}
