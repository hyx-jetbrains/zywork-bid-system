package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserMarkSeekcarRecordDAO;
import top.zywork.dos.UserMarkSeekcarRecordDO;
import top.zywork.dto.UserMarkSeekcarRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserMarkSeekcarRecordService;

import javax.annotation.PostConstruct;

/**
 * UserMarkSeekcarRecordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "userMarkSeekcarRecordService")
public class UserMarkSeekcarRecordServiceImpl extends AbstractBaseService implements UserMarkSeekcarRecordService {

    private UserMarkSeekcarRecordDAO userMarkSeekcarRecordDAO;

    @Autowired
    public void setUserMarkSeekcarRecordDAO(UserMarkSeekcarRecordDAO userMarkSeekcarRecordDAO) {
        super.setBaseDAO(userMarkSeekcarRecordDAO);
        this.userMarkSeekcarRecordDAO = userMarkSeekcarRecordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserMarkSeekcarRecordDO.class, UserMarkSeekcarRecordDTO.class);
    }
}
