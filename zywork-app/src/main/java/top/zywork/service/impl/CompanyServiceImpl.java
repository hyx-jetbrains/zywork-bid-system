package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.CompanyDAO;
import top.zywork.dos.CompanyDO;
import top.zywork.dto.CompanyDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.CompanyService;

import javax.annotation.PostConstruct;

/**
 * CompanyServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "companyService")
public class CompanyServiceImpl extends AbstractBaseService implements CompanyService {

    private CompanyDAO companyDAO;

    @Autowired
    public void setCompanyDAO(CompanyDAO companyDAO) {
        super.setBaseDAO(companyDAO);
        this.companyDAO = companyDAO;
    }

    @PostConstruct
    public void init() {
        super.init(CompanyDO.class, CompanyDTO.class);
    }
}
