package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CouponDAO;
import top.zywork.dos.CouponDO;
import top.zywork.dto.CouponDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CouponService;

import javax.annotation.PostConstruct;

/**
 * CouponServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "couponService")
public class CouponServiceImpl extends AbstractBaseService implements CouponService {

    private CouponDAO couponDAO;

    @Autowired
    public void setCouponDAO(CouponDAO couponDAO) {
        super.setBaseDAO(couponDAO);
        this.couponDAO = couponDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CouponDO.class, CouponDTO.class);
    }
}
