package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompWaterAchievementDAO;
import top.zywork.dos.CompWaterAchievementDO;
import top.zywork.dto.CompWaterAchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompWaterAchievementService;

import javax.annotation.PostConstruct;

/**
 * CompWaterAchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compWaterAchievementService")
public class CompWaterAchievementServiceImpl extends AbstractBaseService implements CompWaterAchievementService {

    private CompWaterAchievementDAO compWaterAchievementDAO;

    @Autowired
    public void setCompWaterAchievementDAO(CompWaterAchievementDAO compWaterAchievementDAO) {
        super.setBaseDAO(compWaterAchievementDAO);
        this.compWaterAchievementDAO = compWaterAchievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompWaterAchievementDO.class, CompWaterAchievementDTO.class);
    }
}
