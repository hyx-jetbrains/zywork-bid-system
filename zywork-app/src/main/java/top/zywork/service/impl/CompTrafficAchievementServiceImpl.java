package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompTrafficAchievementDAO;
import top.zywork.dos.CompTrafficAchievementDO;
import top.zywork.dto.CompTrafficAchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompTrafficAchievementService;

import javax.annotation.PostConstruct;

/**
 * CompTrafficAchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compTrafficAchievementService")
public class CompTrafficAchievementServiceImpl extends AbstractBaseService implements CompTrafficAchievementService {

    private CompTrafficAchievementDAO compTrafficAchievementDAO;

    @Autowired
    public void setCompTrafficAchievementDAO(CompTrafficAchievementDAO compTrafficAchievementDAO) {
        super.setBaseDAO(compTrafficAchievementDAO);
        this.compTrafficAchievementDAO = compTrafficAchievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompTrafficAchievementDO.class, CompTrafficAchievementDTO.class);
    }
}
