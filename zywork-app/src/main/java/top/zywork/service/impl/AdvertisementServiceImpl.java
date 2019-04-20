package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.AdvertisementDAO;
import top.zywork.dos.AdvertisementDO;
import top.zywork.dto.AdvertisementDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.AdvertisementService;

import javax.annotation.PostConstruct;

/**
 * AdvertisementServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "advertisementService")
public class AdvertisementServiceImpl extends AbstractBaseService implements AdvertisementService {

    private AdvertisementDAO advertisementDAO;

    @Autowired
    public void setAdvertisementDAO(AdvertisementDAO advertisementDAO) {
        super.setBaseDAO(advertisementDAO);
        this.advertisementDAO = advertisementDAO;
    }

    @PostConstruct
    public void init() {
        super.init(AdvertisementDO.class, AdvertisementDTO.class);
    }
}
