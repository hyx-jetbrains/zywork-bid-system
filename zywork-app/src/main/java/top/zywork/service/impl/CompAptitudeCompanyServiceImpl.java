package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompAptitudeCompanyDAO;
import top.zywork.dos.CompAptitudeCompanyDO;
import top.zywork.dto.CompAptitudeCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompAptitudeCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompAptitudeCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compAptitudeCompanyService")
public class CompAptitudeCompanyServiceImpl extends AbstractBaseService implements CompAptitudeCompanyService {

    private CompAptitudeCompanyDAO compAptitudeCompanyDAO;

    @Autowired
    public void setCompAptitudeCompanyDAO(CompAptitudeCompanyDAO compAptitudeCompanyDAO) {
        super.setBaseDAO(compAptitudeCompanyDAO);
        this.compAptitudeCompanyDAO = compAptitudeCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompAptitudeCompanyDO.class, CompAptitudeCompanyDTO.class);
    }
}
