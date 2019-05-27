package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UpdateNoticeDAO;
import top.zywork.dos.UpdateNoticeDO;
import top.zywork.dto.UpdateNoticeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UpdateNoticeService;

import javax.annotation.PostConstruct;

/**
 * UpdateNoticeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-27<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "updateNoticeService")
public class UpdateNoticeServiceImpl extends AbstractBaseService implements UpdateNoticeService {

    private UpdateNoticeDAO updateNoticeDAO;

    @Autowired
    public void setUpdateNoticeDAO(UpdateNoticeDAO updateNoticeDAO) {
        super.setBaseDAO(updateNoticeDAO);
        this.updateNoticeDAO = updateNoticeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UpdateNoticeDO.class, UpdateNoticeDTO.class);
    }
}
