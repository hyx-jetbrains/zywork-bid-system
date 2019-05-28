package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserServiceDAO;
import top.zywork.dos.UserServiceDO;
import top.zywork.dto.UserServiceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserServiceService;

import javax.annotation.PostConstruct;

/**
 * UserServiceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userServiceService")
public class UserServiceServiceImpl extends AbstractBaseService implements UserServiceService {

    private UserServiceDAO userServiceDAO;

    @Autowired
    public void setUserServiceDAO(UserServiceDAO userServiceDAO) {
        super.setBaseDAO(userServiceDAO);
        this.userServiceDAO = userServiceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserServiceDO.class, UserServiceDTO.class);
    }
}
