package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.BuilderResourceDAO;
import top.zywork.dos.BuilderResourceDO;
import top.zywork.dto.BuilderResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.BuilderResourceService;

import javax.annotation.PostConstruct;

/**
 * BuilderResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "builderResourceService")
public class BuilderResourceServiceImpl extends AbstractBaseService implements BuilderResourceService {

    private BuilderResourceDAO builderResourceDAO;

    @Autowired
    public void setBuilderResourceDAO(BuilderResourceDAO builderResourceDAO) {
        super.setBaseDAO(builderResourceDAO);
        this.builderResourceDAO = builderResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(BuilderResourceDO.class, BuilderResourceDTO.class);
    }
}
