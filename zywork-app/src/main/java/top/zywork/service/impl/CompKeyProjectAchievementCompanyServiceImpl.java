package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompKeyProjectAchievementCompanyDAO;
import top.zywork.dos.CompKeyProjectAchievementCompanyDO;
import top.zywork.dto.CompKeyProjectAchievementCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompKeyProjectAchievementCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompKeyProjectAchievementCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-12<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compKeyProjectAchievementCompanyService")
public class CompKeyProjectAchievementCompanyServiceImpl extends AbstractBaseService implements CompKeyProjectAchievementCompanyService {

    private CompKeyProjectAchievementCompanyDAO compKeyProjectAchievementCompanyDAO;

    @Autowired
    public void setCompKeyProjectAchievementCompanyDAO(CompKeyProjectAchievementCompanyDAO compKeyProjectAchievementCompanyDAO) {
        super.setBaseDAO(compKeyProjectAchievementCompanyDAO);
        this.compKeyProjectAchievementCompanyDAO = compKeyProjectAchievementCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompKeyProjectAchievementCompanyDO.class, CompKeyProjectAchievementCompanyDTO.class);
    }
}
