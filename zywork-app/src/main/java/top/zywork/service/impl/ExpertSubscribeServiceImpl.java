package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ExpertSubscribeDAO;
import top.zywork.dos.ExpertSubscribeDO;
import top.zywork.dto.ExpertSubscribeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ExpertSubscribeService;

import javax.annotation.PostConstruct;

/**
 * ExpertSubscribeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "expertSubscribeService")
public class ExpertSubscribeServiceImpl extends AbstractBaseService implements ExpertSubscribeService {

    private ExpertSubscribeDAO expertSubscribeDAO;

    @Autowired
    public void setExpertSubscribeDAO(ExpertSubscribeDAO expertSubscribeDAO) {
        super.setBaseDAO(expertSubscribeDAO);
        this.expertSubscribeDAO = expertSubscribeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ExpertSubscribeDO.class, ExpertSubscribeDTO.class);
    }
}
