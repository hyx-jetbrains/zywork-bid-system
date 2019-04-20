package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.SeekDataDAO;
import top.zywork.dos.SeekDataDO;
import top.zywork.dto.SeekDataDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.SeekDataService;

import javax.annotation.PostConstruct;

/**
 * SeekDataServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "seekDataService")
public class SeekDataServiceImpl extends AbstractBaseService implements SeekDataService {

    private SeekDataDAO seekDataDAO;

    @Autowired
    public void setSeekDataDAO(SeekDataDAO seekDataDAO) {
        super.setBaseDAO(seekDataDAO);
        this.seekDataDAO = seekDataDAO;
    }

    @PostConstruct
    public void init() {
        super.init(SeekDataDO.class, SeekDataDTO.class);
    }
}
