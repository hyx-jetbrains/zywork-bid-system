package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.BuilderReqDAO;
import top.zywork.dos.BuilderReqDO;
import top.zywork.dto.BuilderReqDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.BuilderReqService;

import javax.annotation.PostConstruct;

/**
 * BuilderReqServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "builderReqService")
public class BuilderReqServiceImpl extends AbstractBaseService implements BuilderReqService {

    private BuilderReqDAO builderReqDAO;

    @Autowired
    public void setBuilderReqDAO(BuilderReqDAO builderReqDAO) {
        super.setBaseDAO(builderReqDAO);
        this.builderReqDAO = builderReqDAO;
    }

    @PostConstruct
    public void init() {
        super.init(BuilderReqDO.class, BuilderReqDTO.class);
    }
}
