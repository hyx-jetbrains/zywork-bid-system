package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.MarkCarpoolRecordDAO;
import top.zywork.dos.MarkCarpoolRecordDO;
import top.zywork.dto.MarkCarpoolRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.MarkCarpoolRecordService;

import javax.annotation.PostConstruct;

/**
 * MarkCarpoolRecordServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-14<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "markCarpoolRecordService")
public class MarkCarpoolRecordServiceImpl extends AbstractBaseService implements MarkCarpoolRecordService {

    private MarkCarpoolRecordDAO markCarpoolRecordDAO;

    @Autowired
    public void setMarkCarpoolRecordDAO(MarkCarpoolRecordDAO markCarpoolRecordDAO) {
        super.setBaseDAO(markCarpoolRecordDAO);
        this.markCarpoolRecordDAO = markCarpoolRecordDAO;
    }

    @PostConstruct
    public void init() {
        super.init(MarkCarpoolRecordDO.class, MarkCarpoolRecordDTO.class);
    }
}
