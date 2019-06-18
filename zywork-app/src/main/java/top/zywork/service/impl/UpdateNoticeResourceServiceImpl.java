package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UpdateNoticeResourceDAO;
import top.zywork.dos.UpdateNoticeResourceDO;
import top.zywork.dto.UpdateNoticeResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UpdateNoticeResourceService;

import javax.annotation.PostConstruct;

/**
 * UpdateNoticeResourceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-06-18<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "updateNoticeResourceService")
public class UpdateNoticeResourceServiceImpl extends AbstractBaseService implements UpdateNoticeResourceService {

    private UpdateNoticeResourceDAO updateNoticeResourceDAO;

    @Autowired
    public void setUpdateNoticeResourceDAO(UpdateNoticeResourceDAO updateNoticeResourceDAO) {
        super.setBaseDAO(updateNoticeResourceDAO);
        this.updateNoticeResourceDAO = updateNoticeResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UpdateNoticeResourceDO.class, UpdateNoticeResourceDTO.class);
    }
}
