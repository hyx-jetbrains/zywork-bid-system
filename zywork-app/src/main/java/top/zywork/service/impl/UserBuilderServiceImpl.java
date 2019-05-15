package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserBuilderDAO;
import top.zywork.dos.UserBuilderDO;
import top.zywork.dto.UserBuilderDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserBuilderService;

import javax.annotation.PostConstruct;

/**
 * UserBuilderServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userBuilderService")
public class UserBuilderServiceImpl extends AbstractBaseService implements UserBuilderService {

    private UserBuilderDAO userBuilderDAO;

    @Autowired
    public void setUserBuilderDAO(UserBuilderDAO userBuilderDAO) {
        super.setBaseDAO(userBuilderDAO);
        this.userBuilderDAO = userBuilderDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserBuilderDO.class, UserBuilderDTO.class);
    }
}
