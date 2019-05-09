package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ExpertQuestionTypeDAO;
import top.zywork.dos.ExpertQuestionTypeDO;
import top.zywork.dto.ExpertQuestionTypeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ExpertQuestionTypeService;

import javax.annotation.PostConstruct;

/**
 * ExpertQuestionTypeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-09<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "expertQuestionTypeService")
public class ExpertQuestionTypeServiceImpl extends AbstractBaseService implements ExpertQuestionTypeService {

    private ExpertQuestionTypeDAO expertQuestionTypeDAO;

    @Autowired
    public void setExpertQuestionTypeDAO(ExpertQuestionTypeDAO expertQuestionTypeDAO) {
        super.setBaseDAO(expertQuestionTypeDAO);
        this.expertQuestionTypeDAO = expertQuestionTypeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ExpertQuestionTypeDO.class, ExpertQuestionTypeDTO.class);
    }
}
