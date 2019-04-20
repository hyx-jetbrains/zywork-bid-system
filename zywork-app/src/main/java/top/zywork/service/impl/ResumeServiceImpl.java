package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ResumeDAO;
import top.zywork.dos.ResumeDO;
import top.zywork.dto.ResumeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ResumeService;

import javax.annotation.PostConstruct;

/**
 * ResumeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "resumeService")
public class ResumeServiceImpl extends AbstractBaseService implements ResumeService {

    private ResumeDAO resumeDAO;

    @Autowired
    public void setResumeDAO(ResumeDAO resumeDAO) {
        super.setBaseDAO(resumeDAO);
        this.resumeDAO = resumeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ResumeDO.class, ResumeDTO.class);
    }
}
