package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompWaterDeviseAchievementDAO;
import top.zywork.dos.CompWaterDeviseAchievementDO;
import top.zywork.dto.CompWaterDeviseAchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompWaterDeviseAchievementService;

import javax.annotation.PostConstruct;

/**
 * CompWaterDeviseAchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compWaterDeviseAchievementService")
public class CompWaterDeviseAchievementServiceImpl extends AbstractBaseService implements CompWaterDeviseAchievementService {

    private CompWaterDeviseAchievementDAO compWaterDeviseAchievementDAO;

    @Autowired
    public void setCompWaterDeviseAchievementDAO(CompWaterDeviseAchievementDAO compWaterDeviseAchievementDAO) {
        super.setBaseDAO(compWaterDeviseAchievementDAO);
        this.compWaterDeviseAchievementDAO = compWaterDeviseAchievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompWaterDeviseAchievementDO.class, CompWaterDeviseAchievementDTO.class);
    }
}
