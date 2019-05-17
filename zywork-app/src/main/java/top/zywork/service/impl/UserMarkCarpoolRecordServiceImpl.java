package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserMarkCarpoolRecordDAO;
import top.zywork.dos.UserMarkCarpoolRecordDO;
import top.zywork.dto.UserMarkCarpoolRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserMarkCarpoolRecordService;

import javax.annotation.PostConstruct;

/**
 * UserMarkCarpoolRecordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-17<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "userMarkCarpoolRecordService")
public class UserMarkCarpoolRecordServiceImpl extends AbstractBaseService implements UserMarkCarpoolRecordService {

    private UserMarkCarpoolRecordDAO userMarkCarpoolRecordDAO;

    @Autowired
    public void setUserMarkCarpoolRecordDAO(UserMarkCarpoolRecordDAO userMarkCarpoolRecordDAO) {
        super.setBaseDAO(userMarkCarpoolRecordDAO);
        this.userMarkCarpoolRecordDAO = userMarkCarpoolRecordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserMarkCarpoolRecordDO.class, UserMarkCarpoolRecordDTO.class);
    }
}
