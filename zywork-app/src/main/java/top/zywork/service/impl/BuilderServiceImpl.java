package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.BuilderDAO;
import top.zywork.dos.BuilderDO;
import top.zywork.dto.BuilderDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.BuilderService;

import javax.annotation.PostConstruct;

/**
 * BuilderServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "builderService")
public class BuilderServiceImpl extends AbstractBaseService implements BuilderService {

    private BuilderDAO builderDAO;

    @Autowired
    public void setBuilderDAO(BuilderDAO builderDAO) {
        super.setBaseDAO(builderDAO);
        this.builderDAO = builderDAO;
    }

    @PostConstruct
    public void init() {
        super.init(BuilderDO.class, BuilderDTO.class);
    }
}
