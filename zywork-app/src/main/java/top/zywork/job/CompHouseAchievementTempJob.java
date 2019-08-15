package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import top.zywork.annotation.ExposeClass;
import top.zywork.common.IOUtils;
import top.zywork.constant.PythonConstants;
import top.zywork.python.CompanyPythonService;

/**
 * 访问python接口获取房建业绩信息的作业,
 * 临时使用，需要重新抓取房建业绩的信息<br/>
 *
 * 创建于2019-08-15<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@ExposeClass(type = "job")
public class CompHouseAchievementTempJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(CompHouseAchievementTempJob.class);

    private CompanyPythonService companyPythonService;

    @Value("${pythonPageNoFilesPath}")
    private String filesPath;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute CompHouseAchievementTempJob......");
        String path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_ACHIEVEMENT;
        String pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
        try {
            companyPythonService.getCompHouseAchievement(pageNo, true, false);
            int tempPageNo = Integer.valueOf(pageNo);
            tempPageNo++;
            IOUtils.writeText(tempPageNo + "", path);
        } catch (Exception e) {
            logger.error("CompHouseAchievementJob Error:pageNo:{}", pageNo);
        }
        logger.info("executed CompHouseAchievementTempJob......");
    }

    @Autowired
    public void setCompanyPythonService(CompanyPythonService companyPythonService) {
        this.companyPythonService = companyPythonService;
    }

}
