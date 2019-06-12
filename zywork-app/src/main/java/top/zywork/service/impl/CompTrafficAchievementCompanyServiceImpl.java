package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompTrafficAchievementCompanyDAO;
import top.zywork.dos.CompTrafficAchievementCompanyDO;
import top.zywork.dto.CompTrafficAchievementCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompTrafficAchievementCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompTrafficAchievementCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compTrafficAchievementCompanyService")
public class CompTrafficAchievementCompanyServiceImpl extends AbstractBaseService implements CompTrafficAchievementCompanyService {

    private CompTrafficAchievementCompanyDAO compTrafficAchievementCompanyDAO;

    @Autowired
    public void setCompTrafficAchievementCompanyDAO(CompTrafficAchievementCompanyDAO compTrafficAchievementCompanyDAO) {
        super.setBaseDAO(compTrafficAchievementCompanyDAO);
        this.compTrafficAchievementCompanyDAO = compTrafficAchievementCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompTrafficAchievementCompanyDO.class, CompTrafficAchievementCompanyDTO.class);
    }
}
