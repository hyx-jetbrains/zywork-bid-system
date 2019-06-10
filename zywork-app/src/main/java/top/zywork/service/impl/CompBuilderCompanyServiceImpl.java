package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompBuilderCompanyDAO;
import top.zywork.dos.CompBuilderCompanyDO;
import top.zywork.dto.CompBuilderCompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompBuilderCompanyService;

import javax.annotation.PostConstruct;

/**
 * CompBuilderCompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-10<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "compBuilderCompanyService")
public class CompBuilderCompanyServiceImpl extends AbstractBaseService implements CompBuilderCompanyService {

    private CompBuilderCompanyDAO compBuilderCompanyDAO;

    @Autowired
    public void setCompBuilderCompanyDAO(CompBuilderCompanyDAO compBuilderCompanyDAO) {
        super.setBaseDAO(compBuilderCompanyDAO);
        this.compBuilderCompanyDAO = compBuilderCompanyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompBuilderCompanyDO.class, CompBuilderCompanyDTO.class);
    }
}
