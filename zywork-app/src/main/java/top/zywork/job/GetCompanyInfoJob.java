package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.annotation.ExposeClass;
import top.zywork.python.CompanyPythonService;

/**
 * 访问python接口获取企业信息的作业<br/>
 *
 * 创建于2019-06-05<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@ExposeClass(type = "job")
public class GetCompanyInfoJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(GetCompanyInfoJob.class);

    private CompanyPythonService companyPythonService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute GetCompanyInfoJob......");
        companyPythonService.getCompanyInfo("3", "132", "1", "1");
        logger.info("executed GetCompanyInfoJob......");
    }

    @Autowired
    public void setCompanyPythonService(CompanyPythonService companyPythonService) {
        this.companyPythonService = companyPythonService;
    }

}
