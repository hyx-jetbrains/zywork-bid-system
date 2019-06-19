package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.annotation.ExposeClass;
import top.zywork.service.ProjectService;

/*** 
 * @description:  把待开标的数据改成已开标，每天凌晨执行一次
 * @return:  
 * @author: 危锦辉 http://wjhsmart.vip
 * @date: 2019-06-18 18:32
 */
@ExposeClass(type = "job")
public class UpdateMarkStatusJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(UpdateMarkStatusJob.class);

    private ProjectService projectService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute UpdateMarkStatusJob......");
        projectService.updateMarkStatus();
        logger.info("executed UpdateMarkStatusJob......");
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

}
