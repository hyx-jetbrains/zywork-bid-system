package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompAptitudeDAO;
import top.zywork.dos.CompAptitudeDO;
import top.zywork.dto.CompAptitudeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompAptitudeService;

import javax.annotation.PostConstruct;

/**
 * CompAptitudeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compAptitudeService")
public class CompAptitudeServiceImpl extends AbstractBaseService implements CompAptitudeService {

    private CompAptitudeDAO compAptitudeDAO;

    @Autowired
    public void setCompAptitudeDAO(CompAptitudeDAO compAptitudeDAO) {
        super.setBaseDAO(compAptitudeDAO);
        this.compAptitudeDAO = compAptitudeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompAptitudeDO.class, CompAptitudeDTO.class);
    }
}
