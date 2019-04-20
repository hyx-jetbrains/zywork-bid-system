package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompBuilderDAO;
import top.zywork.dos.CompBuilderDO;
import top.zywork.dto.CompBuilderDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompBuilderService;

import javax.annotation.PostConstruct;

/**
 * CompBuilderServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compBuilderService")
public class CompBuilderServiceImpl extends AbstractBaseService implements CompBuilderService {

    private CompBuilderDAO compBuilderDAO;

    @Autowired
    public void setCompBuilderDAO(CompBuilderDAO compBuilderDAO) {
        super.setBaseDAO(compBuilderDAO);
        this.compBuilderDAO = compBuilderDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompBuilderDO.class, CompBuilderDTO.class);
    }
}
