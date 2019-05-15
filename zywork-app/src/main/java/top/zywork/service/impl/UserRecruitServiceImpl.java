package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserRecruitDAO;
import top.zywork.dos.UserRecruitDO;
import top.zywork.dto.UserRecruitDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserRecruitService;

import javax.annotation.PostConstruct;

/**
 * UserRecruitServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-15<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userRecruitService")
public class UserRecruitServiceImpl extends AbstractBaseService implements UserRecruitService {

    private UserRecruitDAO userRecruitDAO;

    @Autowired
    public void setUserRecruitDAO(UserRecruitDAO userRecruitDAO) {
        super.setBaseDAO(userRecruitDAO);
        this.userRecruitDAO = userRecruitDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserRecruitDO.class, UserRecruitDTO.class);
    }
}
