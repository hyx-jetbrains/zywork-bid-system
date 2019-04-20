package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompPersonnelDAO;
import top.zywork.dos.CompPersonnelDO;
import top.zywork.dto.CompPersonnelDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompPersonnelService;

import javax.annotation.PostConstruct;

/**
 * CompPersonnelServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compPersonnelService")
public class CompPersonnelServiceImpl extends AbstractBaseService implements CompPersonnelService {

    private CompPersonnelDAO compPersonnelDAO;

    @Autowired
    public void setCompPersonnelDAO(CompPersonnelDAO compPersonnelDAO) {
        super.setBaseDAO(compPersonnelDAO);
        this.compPersonnelDAO = compPersonnelDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompPersonnelDO.class, CompPersonnelDTO.class);
    }
}
