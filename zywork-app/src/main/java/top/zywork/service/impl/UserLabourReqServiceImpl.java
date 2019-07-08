package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserLabourReqDAO;
import top.zywork.dos.UserLabourReqDO;
import top.zywork.dto.UserLabourReqDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserLabourReqService;

import javax.annotation.PostConstruct;

/**
 * UserLabourReqServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "userLabourReqService")
public class UserLabourReqServiceImpl extends AbstractBaseService implements UserLabourReqService {

    private UserLabourReqDAO userLabourReqDAO;

    @Autowired
    public void setUserLabourReqDAO(UserLabourReqDAO userLabourReqDAO) {
        super.setBaseDAO(userLabourReqDAO);
        this.userLabourReqDAO = userLabourReqDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserLabourReqDO.class, UserLabourReqDTO.class);
    }
}
