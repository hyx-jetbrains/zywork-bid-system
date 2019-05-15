package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserMarkSeekcarDAO;
import top.zywork.dos.UserMarkSeekcarDO;
import top.zywork.dto.UserMarkSeekcarDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserMarkSeekcarService;

import javax.annotation.PostConstruct;

/**
 * UserMarkSeekcarServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userMarkSeekcarService")
public class UserMarkSeekcarServiceImpl extends AbstractBaseService implements UserMarkSeekcarService {

    private UserMarkSeekcarDAO userMarkSeekcarDAO;

    @Autowired
    public void setUserMarkSeekcarDAO(UserMarkSeekcarDAO userMarkSeekcarDAO) {
        super.setBaseDAO(userMarkSeekcarDAO);
        this.userMarkSeekcarDAO = userMarkSeekcarDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserMarkSeekcarDO.class, UserMarkSeekcarDTO.class);
    }
}
