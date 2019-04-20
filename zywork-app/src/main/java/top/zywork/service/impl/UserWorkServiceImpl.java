package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserWorkDAO;
import top.zywork.dos.UserWorkDO;
import top.zywork.dto.UserWorkDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserWorkService;

import javax.annotation.PostConstruct;

/**
 * UserWorkServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userWorkService")
public class UserWorkServiceImpl extends AbstractBaseService implements UserWorkService {

    private UserWorkDAO userWorkDAO;

    @Autowired
    public void setUserWorkDAO(UserWorkDAO userWorkDAO) {
        super.setBaseDAO(userWorkDAO);
        this.userWorkDAO = userWorkDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserWorkDO.class, UserWorkDTO.class);
    }
}
