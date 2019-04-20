package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.MarkSeekcarDAO;
import top.zywork.dos.MarkSeekcarDO;
import top.zywork.dto.MarkSeekcarDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.MarkSeekcarService;

import javax.annotation.PostConstruct;

/**
 * MarkSeekcarServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "markSeekcarService")
public class MarkSeekcarServiceImpl extends AbstractBaseService implements MarkSeekcarService {

    private MarkSeekcarDAO markSeekcarDAO;

    @Autowired
    public void setMarkSeekcarDAO(MarkSeekcarDAO markSeekcarDAO) {
        super.setBaseDAO(markSeekcarDAO);
        this.markSeekcarDAO = markSeekcarDAO;
    }

    @PostConstruct
    public void init() {
        super.init(MarkSeekcarDO.class, MarkSeekcarDTO.class);
    }
}
