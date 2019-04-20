package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompWaterMonitorAchievementDAO;
import top.zywork.dos.CompWaterMonitorAchievementDO;
import top.zywork.dto.CompWaterMonitorAchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompWaterMonitorAchievementService;

import javax.annotation.PostConstruct;

/**
 * CompWaterMonitorAchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compWaterMonitorAchievementService")
public class CompWaterMonitorAchievementServiceImpl extends AbstractBaseService implements CompWaterMonitorAchievementService {

    private CompWaterMonitorAchievementDAO compWaterMonitorAchievementDAO;

    @Autowired
    public void setCompWaterMonitorAchievementDAO(CompWaterMonitorAchievementDAO compWaterMonitorAchievementDAO) {
        super.setBaseDAO(compWaterMonitorAchievementDAO);
        this.compWaterMonitorAchievementDAO = compWaterMonitorAchievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompWaterMonitorAchievementDO.class, CompWaterMonitorAchievementDTO.class);
    }
}
