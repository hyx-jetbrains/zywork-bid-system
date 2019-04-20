package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.HeadlinesDAO;
import top.zywork.dos.HeadlinesDO;
import top.zywork.dto.HeadlinesDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.HeadlinesService;

import javax.annotation.PostConstruct;

/**
 * HeadlinesServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "headlinesService")
public class HeadlinesServiceImpl extends AbstractBaseService implements HeadlinesService {

    private HeadlinesDAO headlinesDAO;

    @Autowired
    public void setHeadlinesDAO(HeadlinesDAO headlinesDAO) {
        super.setBaseDAO(headlinesDAO);
        this.headlinesDAO = headlinesDAO;
    }

    @PostConstruct
    public void init() {
        super.init(HeadlinesDO.class, HeadlinesDTO.class);
    }
}
