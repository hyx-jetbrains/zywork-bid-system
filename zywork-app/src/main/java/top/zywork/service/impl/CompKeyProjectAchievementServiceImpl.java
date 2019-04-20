package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompKeyProjectAchievementDAO;
import top.zywork.dos.CompKeyProjectAchievementDO;
import top.zywork.dto.CompKeyProjectAchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompKeyProjectAchievementService;

import javax.annotation.PostConstruct;

/**
 * CompKeyProjectAchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compKeyProjectAchievementService")
public class CompKeyProjectAchievementServiceImpl extends AbstractBaseService implements CompKeyProjectAchievementService {

    private CompKeyProjectAchievementDAO compKeyProjectAchievementDAO;

    @Autowired
    public void setCompKeyProjectAchievementDAO(CompKeyProjectAchievementDAO compKeyProjectAchievementDAO) {
        super.setBaseDAO(compKeyProjectAchievementDAO);
        this.compKeyProjectAchievementDAO = compKeyProjectAchievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompKeyProjectAchievementDO.class, CompKeyProjectAchievementDTO.class);
    }
}
