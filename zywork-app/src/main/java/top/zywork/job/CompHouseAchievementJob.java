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
 * 一天执行一次<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@ExposeClass(type = "job")
public class CompHouseAchievementJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(CompHouseAchievementJob.class);

    private CompanyPythonService companyPythonService;

    @Value("${pythonPageNoFilesPath}")
    private String filesPath;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute CompHouseAchievementJob......");
//        String path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_HOUSE_ACHIEVEMENT;
//        String pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
//        try {
//            companyPythonService.getCompHouseAchievement(pageNo, PythonConstants.DEFAULT_IS_UPDATE_FLAG, false);
//            int tempPageNo = Integer.valueOf(pageNo);
//            tempPageNo++;
//            IOUtils.writeText(tempPageNo + "", path);
//        } catch (Exception e) {
//            logger.error("CompHouseAchievementJob Error:pageNo:{}", pageNo);
//        }
        String pageNo = "1";
        try {
            companyPythonService.getCompHouseAchievement(pageNo, PythonConstants.DEFAULT_IS_UPDATE_FLAG, false);
        } catch (Exception e) {
            logger.error("CompHouseAchievementJob Error:pageNo:{}", pageNo);
        }
        logger.info("executed CompHouseAchievementJob......");
    }

    @Autowired
    public void setCompanyPythonService(CompanyPythonService companyPythonService) {
        this.companyPythonService = companyPythonService;
    }

}
