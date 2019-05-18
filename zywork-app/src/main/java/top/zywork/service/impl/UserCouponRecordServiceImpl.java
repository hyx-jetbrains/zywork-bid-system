package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserCouponRecordDAO;
import top.zywork.dos.UserCouponRecordDO;
import top.zywork.dto.UserCouponRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserCouponRecordService;

import javax.annotation.PostConstruct;

/**
 * UserCouponRecordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-18<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userCouponRecordService")
public class UserCouponRecordServiceImpl extends AbstractBaseService implements UserCouponRecordService {

    private UserCouponRecordDAO userCouponRecordDAO;

    @Autowired
    public void setUserCouponRecordDAO(UserCouponRecordDAO userCouponRecordDAO) {
        super.setBaseDAO(userCouponRecordDAO);
        this.userCouponRecordDAO = userCouponRecordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserCouponRecordDO.class, UserCouponRecordDTO.class);
    }
}
