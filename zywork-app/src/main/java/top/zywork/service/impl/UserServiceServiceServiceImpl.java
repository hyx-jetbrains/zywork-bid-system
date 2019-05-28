package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserServiceServiceDAO;
import top.zywork.dos.UserServiceServiceDO;
import top.zywork.dto.UserServiceServiceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserServiceServiceService;

import javax.annotation.PostConstruct;

/**
 * UserServiceServiceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userServiceServiceService")
public class UserServiceServiceServiceImpl extends AbstractBaseService implements UserServiceServiceService {

    private UserServiceServiceDAO userServiceServiceDAO;

    @Autowired
    public void setUserServiceServiceDAO(UserServiceServiceDAO userServiceServiceDAO) {
        super.setBaseDAO(userServiceServiceDAO);
        this.userServiceServiceDAO = userServiceServiceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserServiceServiceDO.class, UserServiceServiceDTO.class);
    }
}
