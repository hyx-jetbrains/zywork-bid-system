package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ServiceDAO;
import top.zywork.dos.ServiceDO;
import top.zywork.dto.ServiceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ServiceService;

import javax.annotation.PostConstruct;

/**
 * ServiceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "serviceService")
public class ServiceServiceImpl extends AbstractBaseService implements ServiceService {

    private ServiceDAO serviceDAO;

    @Autowired
    public void setServiceDAO(ServiceDAO serviceDAO) {
        super.setBaseDAO(serviceDAO);
        this.serviceDAO = serviceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ServiceDO.class, ServiceDTO.class);
    }
}
