package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.SysInfoDAO;
import top.zywork.dos.SysInfoDO;
import top.zywork.dto.SysInfoDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.SysInfoService;

import javax.annotation.PostConstruct;

/**
 * SysInfoServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-31<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "sysInfoService")
public class SysInfoServiceImpl extends AbstractBaseService implements SysInfoService {

    private SysInfoDAO sysInfoDAO;

    @Autowired
    public void setSysInfoDAO(SysInfoDAO sysInfoDAO) {
        super.setBaseDAO(sysInfoDAO);
        this.sysInfoDAO = sysInfoDAO;
    }

    @PostConstruct
    public void init() {
        super.init(SysInfoDO.class, SysInfoDTO.class);
    }
}
