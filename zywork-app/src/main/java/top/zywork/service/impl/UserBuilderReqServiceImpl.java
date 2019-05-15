package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserBuilderReqDAO;
import top.zywork.dos.UserBuilderReqDO;
import top.zywork.dto.UserBuilderReqDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserBuilderReqService;

import javax.annotation.PostConstruct;

/**
 * UserBuilderReqServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userBuilderReqService")
public class UserBuilderReqServiceImpl extends AbstractBaseService implements UserBuilderReqService {

    private UserBuilderReqDAO userBuilderReqDAO;

    @Autowired
    public void setUserBuilderReqDAO(UserBuilderReqDAO userBuilderReqDAO) {
        super.setBaseDAO(userBuilderReqDAO);
        this.userBuilderReqDAO = userBuilderReqDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserBuilderReqDO.class, UserBuilderReqDTO.class);
    }
}
