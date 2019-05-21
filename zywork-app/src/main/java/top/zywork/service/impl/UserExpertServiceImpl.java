package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.UserExpertDAO;
import top.zywork.dao.UserExpertQuestionTypeDAO;
import top.zywork.dos.UserExpertDO;
import top.zywork.dto.UserExpertDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserExpertService;
import top.zywork.vo.UserExpertQuestionTypeVO;
import top.zywork.vo.UserExpertVO;

import javax.annotation.PostConstruct;

/**
 * UserExpertServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-06<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "userExpertService")
public class UserExpertServiceImpl extends AbstractBaseService implements UserExpertService {

    private UserExpertDAO userExpertDAO;

    private UserExpertQuestionTypeDAO userExpertQuestionTypeDAO;

    @Autowired
    public void setUserExpertDAO(UserExpertDAO userExpertDAO) {
        super.setBaseDAO(userExpertDAO);
        this.userExpertDAO = userExpertDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserExpertDO.class, UserExpertDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveExpert(UserExpertVO userExpertVO, String  questionTypeId) {
        userExpertDAO.save(userExpertVO);

        String[] arr = questionTypeId.split(",");
        for(int i = 0; i < arr.length; i++) {
            UserExpertQuestionTypeVO eqt = new UserExpertQuestionTypeVO();
            eqt.setUserExpertId(userExpertVO.getId());
            Long id = Long.valueOf(arr[i]);
            eqt.setQuestionTypeId(id);
            userExpertQuestionTypeDAO.save(eqt);
        }
    }

    @Override
    public Object getByUserId(Long userId) {
        return userExpertDAO.getByUserId(userId);
    }

    @Autowired
    public void setUserExpertQuestionTypeDAO(UserExpertQuestionTypeDAO userExpertQuestionTypeDAO) {
        this.userExpertQuestionTypeDAO = userExpertQuestionTypeDAO;
    }
}
