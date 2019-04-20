package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ConsultDAO;
import top.zywork.dos.ConsultDO;
import top.zywork.dto.ConsultDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ConsultService;

import javax.annotation.PostConstruct;

/**
 * ConsultServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "consultService")
public class ConsultServiceImpl extends AbstractBaseService implements ConsultService {

    private ConsultDAO consultDAO;

    @Autowired
    public void setConsultDAO(ConsultDAO consultDAO) {
        super.setBaseDAO(consultDAO);
        this.consultDAO = consultDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ConsultDO.class, ConsultDTO.class);
    }
}
