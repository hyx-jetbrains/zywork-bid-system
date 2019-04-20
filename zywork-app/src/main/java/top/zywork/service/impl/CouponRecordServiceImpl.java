package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CouponRecordDAO;
import top.zywork.dos.CouponRecordDO;
import top.zywork.dto.CouponRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CouponRecordService;

import javax.annotation.PostConstruct;

/**
 * CouponRecordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "couponRecordService")
public class CouponRecordServiceImpl extends AbstractBaseService implements CouponRecordService {

    private CouponRecordDAO couponRecordDAO;

    @Autowired
    public void setCouponRecordDAO(CouponRecordDAO couponRecordDAO) {
        super.setBaseDAO(couponRecordDAO);
        this.couponRecordDAO = couponRecordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CouponRecordDO.class, CouponRecordDTO.class);
    }
}
