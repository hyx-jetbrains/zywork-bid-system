package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.LabourDAO;
import top.zywork.dos.LabourDO;
import top.zywork.dto.LabourDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.LabourService;

import javax.annotation.PostConstruct;

/**
 * LabourServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-07-08<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "labourService")
public class LabourServiceImpl extends AbstractBaseService implements LabourService {

    private LabourDAO labourDAO;

    @Autowired
    public void setLabourDAO(LabourDAO labourDAO) {
        super.setBaseDAO(labourDAO);
        this.labourDAO = labourDAO;
    }

    @PostConstruct
    public void init() {
        super.init(LabourDO.class, LabourDTO.class);
    }
}
