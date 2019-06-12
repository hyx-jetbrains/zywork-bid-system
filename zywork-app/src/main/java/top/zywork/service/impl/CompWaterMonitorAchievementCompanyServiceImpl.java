package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompWaterMonitorAchievementCompanyDAO;
import top.zywork.dos.CompWaterMonitorAchievementCompanyDO;
import top.zywork.dto.CompWaterMonitorAchievementCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompWaterMonitorAchievementCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompWaterMonitorAchievementCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compWaterMonitorAchievementCompanyService")
public class CompWaterMonitorAchievementCompanyServiceImpl extends AbstractBaseService implements CompWaterMonitorAchievementCompanyService {

    private CompWaterMonitorAchievementCompanyDAO compWaterMonitorAchievementCompanyDAO;

    @Autowired
    public void setCompWaterMonitorAchievementCompanyDAO(CompWaterMonitorAchievementCompanyDAO compWaterMonitorAchievementCompanyDAO) {
        super.setBaseDAO(compWaterMonitorAchievementCompanyDAO);
        this.compWaterMonitorAchievementCompanyDAO = compWaterMonitorAchievementCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompWaterMonitorAchievementCompanyDO.class, CompWaterMonitorAchievementCompanyDTO.class);
    }
}
