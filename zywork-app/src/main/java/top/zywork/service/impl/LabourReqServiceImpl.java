package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.LabourReqDAO;
import top.zywork.dos.LabourReqDO;
import top.zywork.dto.LabourReqDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.LabourReqService;

import javax.annotation.PostConstruct;

/**
 * LabourReqServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "labourReqService")
public class LabourReqServiceImpl extends AbstractBaseService implements LabourReqService {

    private LabourReqDAO labourReqDAO;

    @Autowired
    public void setLabourReqDAO(LabourReqDAO labourReqDAO) {
        super.setBaseDAO(labourReqDAO);
        this.labourReqDAO = labourReqDAO;
    }

    @PostConstruct
    public void init() {
        super.init(LabourReqDO.class, LabourReqDTO.class);
    }
}
