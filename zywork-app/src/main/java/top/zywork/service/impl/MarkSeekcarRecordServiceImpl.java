package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.MarkSeekcarRecordDAO;
import top.zywork.dos.MarkSeekcarRecordDO;
import top.zywork.dto.MarkSeekcarRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.MarkSeekcarRecordService;

import javax.annotation.PostConstruct;

/**
 * MarkSeekcarRecordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "markSeekcarRecordService")
public class MarkSeekcarRecordServiceImpl extends AbstractBaseService implements MarkSeekcarRecordService {

    private MarkSeekcarRecordDAO markSeekcarRecordDAO;

    @Autowired
    public void setMarkSeekcarRecordDAO(MarkSeekcarRecordDAO markSeekcarRecordDAO) {
        super.setBaseDAO(markSeekcarRecordDAO);
        this.markSeekcarRecordDAO = markSeekcarRecordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(MarkSeekcarRecordDO.class, MarkSeekcarRecordDTO.class);
    }
}
