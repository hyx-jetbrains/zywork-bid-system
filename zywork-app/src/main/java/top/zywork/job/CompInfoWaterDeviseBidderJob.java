package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.annotation.ExposeClass;
import top.zywork.constant.PythonConstants;
import top.zywork.python.CompanyPythonService;

/**
 * 访问python接口获取水利勘查投标人公司信息的作业,
 * 每半个小时执行一次<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@ExposeClass(type = "job")
public class CompInfoWaterDeviseBidderJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(CompInfoWaterDeviseBidderJob.class);

    private CompanyPythonService companyPythonService;

    public static int pageNo = 1;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute CompInfoWaterDeviseBidderJob......");
        companyPythonService.getCompanyInfo(PythonConstants.TYPE_BIDDER, PythonConstants.COMP_TYPE_WATER_DEVISE_BIDDER, String.valueOf(pageNo), PythonConstants.DEFAULT_PAGE_SIXE);
        pageNo++;
        logger.info("executed CompInfoWaterDeviseBidderJob......");
    }

    @Autowired
    public void setCompanyPythonService(CompanyPythonService companyPythonService) {
        this.companyPythonService = companyPythonService;
    }

}
