package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserCouponDAO;
import top.zywork.dos.UserCouponDO;
import top.zywork.dto.UserCouponDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserCouponService;

import javax.annotation.PostConstruct;

/**
 * UserCouponServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userCouponService")
public class UserCouponServiceImpl extends AbstractBaseService implements UserCouponService {

    private UserCouponDAO userCouponDAO;

    @Autowired
    public void setUserCouponDAO(UserCouponDAO userCouponDAO) {
        super.setBaseDAO(userCouponDAO);
        this.userCouponDAO = userCouponDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserCouponDO.class, UserCouponDTO.class);
    }
}
