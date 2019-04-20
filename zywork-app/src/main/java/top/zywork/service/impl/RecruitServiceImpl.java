package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.RecruitDAO;
import top.zywork.dos.RecruitDO;
import top.zywork.dto.RecruitDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.RecruitService;

import javax.annotation.PostConstruct;

/**
 * RecruitServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "recruitService")
public class RecruitServiceImpl extends AbstractBaseService implements RecruitService {

    private RecruitDAO recruitDAO;

    @Autowired
    public void setRecruitDAO(RecruitDAO recruitDAO) {
        super.setBaseDAO(recruitDAO);
        this.recruitDAO = recruitDAO;
    }

    @PostConstruct
    public void init() {
        super.init(RecruitDO.class, RecruitDTO.class);
    }
}
