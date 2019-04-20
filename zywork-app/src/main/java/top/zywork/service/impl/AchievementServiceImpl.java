package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.AchievementDAO;
import top.zywork.dos.AchievementDO;
import top.zywork.dto.AchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.AchievementService;

import javax.annotation.PostConstruct;

/**
 * AchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "achievementService")
public class AchievementServiceImpl extends AbstractBaseService implements AchievementService {

    private AchievementDAO achievementDAO;

    @Autowired
    public void setAchievementDAO(AchievementDAO achievementDAO) {
        super.setBaseDAO(achievementDAO);
        this.achievementDAO = achievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(AchievementDO.class, AchievementDTO.class);
    }
}
