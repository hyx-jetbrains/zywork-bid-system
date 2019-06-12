package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompHouseAchievementCompanyDAO;
import top.zywork.dos.CompHouseAchievementCompanyDO;
import top.zywork.dto.CompHouseAchievementCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompHouseAchievementCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompHouseAchievementCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compHouseAchievementCompanyService")
public class CompHouseAchievementCompanyServiceImpl extends AbstractBaseService implements CompHouseAchievementCompanyService {

    private CompHouseAchievementCompanyDAO compHouseAchievementCompanyDAO;

    @Autowired
    public void setCompHouseAchievementCompanyDAO(CompHouseAchievementCompanyDAO compHouseAchievementCompanyDAO) {
        super.setBaseDAO(compHouseAchievementCompanyDAO);
        this.compHouseAchievementCompanyDAO = compHouseAchievementCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompHouseAchievementCompanyDO.class, CompHouseAchievementCompanyDTO.class);
    }
}
