package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserGuaranteeDAO;
import top.zywork.dos.UserGuaranteeDO;
import top.zywork.dto.UserGuaranteeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserGuaranteeService;

import javax.annotation.PostConstruct;

/**
 * UserGuaranteeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userGuaranteeService")
public class UserGuaranteeServiceImpl extends AbstractBaseService implements UserGuaranteeService {

    private UserGuaranteeDAO userGuaranteeDAO;

    @Autowired
    public void setUserGuaranteeDAO(UserGuaranteeDAO userGuaranteeDAO) {
        super.setBaseDAO(userGuaranteeDAO);
        this.userGuaranteeDAO = userGuaranteeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserGuaranteeDO.class, UserGuaranteeDTO.class);
    }
}
