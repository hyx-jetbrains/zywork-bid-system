package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompHouseAchievementDAO;
import top.zywork.dos.CompHouseAchievementDO;
import top.zywork.dto.CompHouseAchievementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompHouseAchievementService;

import javax.annotation.PostConstruct;

/**
 * CompHouseAchievementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compHouseAchievementService")
public class CompHouseAchievementServiceImpl extends AbstractBaseService implements CompHouseAchievementService {

    private CompHouseAchievementDAO compHouseAchievementDAO;

    @Autowired
    public void setCompHouseAchievementDAO(CompHouseAchievementDAO compHouseAchievementDAO) {
        super.setBaseDAO(compHouseAchievementDAO);
        this.compHouseAchievementDAO = compHouseAchievementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompHouseAchievementDO.class, CompHouseAchievementDTO.class);
    }
}
