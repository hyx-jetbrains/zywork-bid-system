package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompWaterAchievementCompanyDAO;
import top.zywork.dos.CompWaterAchievementCompanyDO;
import top.zywork.dto.CompWaterAchievementCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompWaterAchievementCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompWaterAchievementCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compWaterAchievementCompanyService")
public class CompWaterAchievementCompanyServiceImpl extends AbstractBaseService implements CompWaterAchievementCompanyService {

    private CompWaterAchievementCompanyDAO compWaterAchievementCompanyDAO;

    @Autowired
    public void setCompWaterAchievementCompanyDAO(CompWaterAchievementCompanyDAO compWaterAchievementCompanyDAO) {
        super.setBaseDAO(compWaterAchievementCompanyDAO);
        this.compWaterAchievementCompanyDAO = compWaterAchievementCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompWaterAchievementCompanyDO.class, CompWaterAchievementCompanyDTO.class);
    }
}
