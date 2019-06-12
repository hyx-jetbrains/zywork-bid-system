package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompWaterDeviseAchievementCompanyDAO;
import top.zywork.dos.CompWaterDeviseAchievementCompanyDO;
import top.zywork.dto.CompWaterDeviseAchievementCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompWaterDeviseAchievementCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompWaterDeviseAchievementCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compWaterDeviseAchievementCompanyService")
public class CompWaterDeviseAchievementCompanyServiceImpl extends AbstractBaseService implements CompWaterDeviseAchievementCompanyService {

    private CompWaterDeviseAchievementCompanyDAO compWaterDeviseAchievementCompanyDAO;

    @Autowired
    public void setCompWaterDeviseAchievementCompanyDAO(CompWaterDeviseAchievementCompanyDAO compWaterDeviseAchievementCompanyDAO) {
        super.setBaseDAO(compWaterDeviseAchievementCompanyDAO);
        this.compWaterDeviseAchievementCompanyDAO = compWaterDeviseAchievementCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompWaterDeviseAchievementCompanyDO.class, CompWaterDeviseAchievementCompanyDTO.class);
    }
}
