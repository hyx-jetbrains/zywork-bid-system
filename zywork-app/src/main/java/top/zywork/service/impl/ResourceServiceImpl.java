package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ResourceDAO;
import top.zywork.dos.ResourceDO;
import top.zywork.dto.ResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ResourceService;

import javax.annotation.PostConstruct;

/**
 * ResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "resourceService")
public class ResourceServiceImpl extends AbstractBaseService implements ResourceService {

    private ResourceDAO resourceDAO;

    @Autowired
    public void setResourceDAO(ResourceDAO resourceDAO) {
        super.setBaseDAO(resourceDAO);
        this.resourceDAO = resourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ResourceDO.class, ResourceDTO.class);
    }
}
