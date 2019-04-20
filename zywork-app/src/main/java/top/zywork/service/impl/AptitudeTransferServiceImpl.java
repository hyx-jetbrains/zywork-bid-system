package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.AptitudeTransferDAO;
import top.zywork.dos.AptitudeTransferDO;
import top.zywork.dto.AptitudeTransferDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.AptitudeTransferService;

import javax.annotation.PostConstruct;

/**
 * AptitudeTransferServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "aptitudeTransferService")
public class AptitudeTransferServiceImpl extends AbstractBaseService implements AptitudeTransferService {

    private AptitudeTransferDAO aptitudeTransferDAO;

    @Autowired
    public void setAptitudeTransferDAO(AptitudeTransferDAO aptitudeTransferDAO) {
        super.setBaseDAO(aptitudeTransferDAO);
        this.aptitudeTransferDAO = aptitudeTransferDAO;
    }

    @PostConstruct
    public void init() {
        super.init(AptitudeTransferDO.class, AptitudeTransferDTO.class);
    }
}
