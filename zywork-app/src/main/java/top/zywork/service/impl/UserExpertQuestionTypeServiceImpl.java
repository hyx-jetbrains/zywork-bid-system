package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserExpertQuestionTypeDAO;
import top.zywork.dos.UserExpertQuestionTypeDO;
import top.zywork.dto.UserExpertQuestionTypeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserExpertQuestionTypeService;

import javax.annotation.PostConstruct;

/**
 * UserExpertQuestionTypeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "userExpertQuestionTypeService")
public class UserExpertQuestionTypeServiceImpl extends AbstractBaseService implements UserExpertQuestionTypeService {

    private UserExpertQuestionTypeDAO userExpertQuestionTypeDAO;

    @Autowired
    public void setUserExpertQuestionTypeDAO(UserExpertQuestionTypeDAO userExpertQuestionTypeDAO) {
        super.setBaseDAO(userExpertQuestionTypeDAO);
        this.userExpertQuestionTypeDAO = userExpertQuestionTypeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserExpertQuestionTypeDO.class, UserExpertQuestionTypeDTO.class);
    }
}
