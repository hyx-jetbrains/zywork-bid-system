package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserLabourDAO;
import top.zywork.dos.UserLabourDO;
import top.zywork.dto.UserLabourDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserLabourService;

import javax.annotation.PostConstruct;

/**
 * UserLabourServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "userLabourService")
public class UserLabourServiceImpl extends AbstractBaseService implements UserLabourService {

    private UserLabourDAO userLabourDAO;

    @Autowired
    public void setUserLabourDAO(UserLabourDAO userLabourDAO) {
        super.setBaseDAO(userLabourDAO);
        this.userLabourDAO = userLabourDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserLabourDO.class, UserLabourDTO.class);
    }
}
