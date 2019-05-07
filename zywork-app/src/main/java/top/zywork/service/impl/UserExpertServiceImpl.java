package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserExpertDAO;
import top.zywork.dos.UserExpertDO;
import top.zywork.dto.UserExpertDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserExpertService;

import javax.annotation.PostConstruct;

/**
 * UserExpertServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-06<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userExpertService")
public class UserExpertServiceImpl extends AbstractBaseService implements UserExpertService {

    private UserExpertDAO userExpertDAO;

    @Autowired
    public void setUserExpertDAO(UserExpertDAO userExpertDAO) {
        super.setBaseDAO(userExpertDAO);
        this.userExpertDAO = userExpertDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserExpertDO.class, UserExpertDTO.class);
    }
}
