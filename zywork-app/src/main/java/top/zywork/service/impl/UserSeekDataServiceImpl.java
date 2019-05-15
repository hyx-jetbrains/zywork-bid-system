package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserSeekDataDAO;
import top.zywork.dos.UserSeekDataDO;
import top.zywork.dto.UserSeekDataDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserSeekDataService;

import javax.annotation.PostConstruct;

/**
 * UserSeekDataServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userSeekDataService")
public class UserSeekDataServiceImpl extends AbstractBaseService implements UserSeekDataService {

    private UserSeekDataDAO userSeekDataDAO;

    @Autowired
    public void setUserSeekDataDAO(UserSeekDataDAO userSeekDataDAO) {
        super.setBaseDAO(userSeekDataDAO);
        this.userSeekDataDAO = userSeekDataDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserSeekDataDO.class, UserSeekDataDTO.class);
    }
}
