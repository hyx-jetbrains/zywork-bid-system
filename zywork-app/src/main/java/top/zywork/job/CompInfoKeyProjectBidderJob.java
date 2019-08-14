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
 * 访问python接口获取重点工程投标人公司信息的作业,
 * 每半个小时执行一次<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@ExposeClass(type = "job")
public class CompInfoKeyProjectBidderJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(CompInfoKeyProjectBidderJob.class);

    private CompanyPythonService companyPythonService;

    @Value("${pythonPageNoFilesPath}")
    private String filesPath;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute CompInfoKeyProjectBidderJob......");
        String path = filesPath + PythonConstants.PAGE_NO_FILE_NAME_COMP_KEY_PROJECT_BIDDER;
        String pageNo = IOUtils.getText(path).replaceAll("\r\n", "");
        try {
            companyPythonService.getCompanyInfo(PythonConstants.TYPE_BIDDER, PythonConstants.COMP_TYPE_KEY_PROJECT_BIDDER, pageNo, PythonConstants.DEFAULT_PAGE_SIXE, PythonConstants.DEFAULT_IS_UPDATE_FLAG);
            int tempPageNo = Integer.valueOf(pageNo);
            tempPageNo++;
            IOUtils.writeText(tempPageNo + "", path);
        } catch (Exception e) {
            logger.error("CompInfoKeyProjectBidderJob Error:pageNo:{}", pageNo);
            e.printStackTrace();
        }
        logger.info("executed CompInfoKeyProjectBidderJob......");
    }

    @Autowired
    public void setCompanyPythonService(CompanyPythonService companyPythonService) {
        this.companyPythonService = companyPythonService;
    }

}
