package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.AptitudeResourceDAO;
import top.zywork.dos.AptitudeResourceDO;
import top.zywork.dto.AptitudeResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.AptitudeResourceService;

import javax.annotation.PostConstruct;

/**
 * AptitudeResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "aptitudeResourceService")
public class AptitudeResourceServiceImpl extends AbstractBaseService implements AptitudeResourceService {

    private AptitudeResourceDAO aptitudeResourceDAO;

    @Autowired
    public void setAptitudeResourceDAO(AptitudeResourceDAO aptitudeResourceDAO) {
        super.setBaseDAO(aptitudeResourceDAO);
        this.aptitudeResourceDAO = aptitudeResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(AptitudeResourceDO.class, AptitudeResourceDTO.class);
    }
}
