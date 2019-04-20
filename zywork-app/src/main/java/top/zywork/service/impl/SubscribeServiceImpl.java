package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.SubscribeDAO;
import top.zywork.dos.SubscribeDO;
import top.zywork.dto.SubscribeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.SubscribeService;

import javax.annotation.PostConstruct;

/**
 * SubscribeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "subscribeService")
public class SubscribeServiceImpl extends AbstractBaseService implements SubscribeService {

    private SubscribeDAO subscribeDAO;

    @Autowired
    public void setSubscribeDAO(SubscribeDAO subscribeDAO) {
        super.setBaseDAO(subscribeDAO);
        this.subscribeDAO = subscribeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(SubscribeDO.class, SubscribeDTO.class);
    }
}
