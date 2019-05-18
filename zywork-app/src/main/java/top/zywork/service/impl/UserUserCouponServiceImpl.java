package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserUserCouponDAO;
import top.zywork.dos.UserUserCouponDO;
import top.zywork.dto.UserUserCouponDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserUserCouponService;

import javax.annotation.PostConstruct;

/**
 * UserUserCouponServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userUserCouponService")
public class UserUserCouponServiceImpl extends AbstractBaseService implements UserUserCouponService {

    private UserUserCouponDAO userUserCouponDAO;

    @Autowired
    public void setUserUserCouponDAO(UserUserCouponDAO userUserCouponDAO) {
        super.setBaseDAO(userUserCouponDAO);
        this.userUserCouponDAO = userUserCouponDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserUserCouponDO.class, UserUserCouponDTO.class);
    }
}
