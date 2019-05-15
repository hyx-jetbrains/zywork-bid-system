package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserAptitudeTransferDAO;
import top.zywork.dos.UserAptitudeTransferDO;
import top.zywork.dto.UserAptitudeTransferDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserAptitudeTransferService;

import javax.annotation.PostConstruct;

/**
 * UserAptitudeTransferServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userAptitudeTransferService")
public class UserAptitudeTransferServiceImpl extends AbstractBaseService implements UserAptitudeTransferService {

    private UserAptitudeTransferDAO userAptitudeTransferDAO;

    @Autowired
    public void setUserAptitudeTransferDAO(UserAptitudeTransferDAO userAptitudeTransferDAO) {
        super.setBaseDAO(userAptitudeTransferDAO);
        this.userAptitudeTransferDAO = userAptitudeTransferDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserAptitudeTransferDO.class, UserAptitudeTransferDTO.class);
    }
}
