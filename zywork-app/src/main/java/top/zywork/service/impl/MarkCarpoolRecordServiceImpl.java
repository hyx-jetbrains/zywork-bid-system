package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.dao.MarkCarpoolRecordDAO;
import top.zywork.dos.MarkCarpoolRecordDO;
import top.zywork.dto.MarkCarpoolRecordDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.MarkCarpoolRecordService;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @Override
    public MarkCarpoolRecordDTO getByUserIdAndCarpoolId(Long userId, Long markCarpoolId) {
        Object obj = markCarpoolRecordDAO.getByUserIdAndCarpoolId(userId, markCarpoolId);
        if (null == obj) {
            return null;
        }
        return BeanUtils.copy(obj, MarkCarpoolRecordDTO.class);
    }


}
