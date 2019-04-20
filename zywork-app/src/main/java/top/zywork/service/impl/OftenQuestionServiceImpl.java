package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.OftenQuestionDAO;
import top.zywork.dos.OftenQuestionDO;
import top.zywork.dto.OftenQuestionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.OftenQuestionService;

import javax.annotation.PostConstruct;

/**
 * OftenQuestionServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-20<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "oftenQuestionService")
public class OftenQuestionServiceImpl extends AbstractBaseService implements OftenQuestionService {

    private OftenQuestionDAO oftenQuestionDAO;

    @Autowired
    public void setOftenQuestionDAO(OftenQuestionDAO oftenQuestionDAO) {
        super.setBaseDAO(oftenQuestionDAO);
        this.oftenQuestionDAO = oftenQuestionDAO;
    }

    @PostConstruct
    public void init() {
        super.init(OftenQuestionDO.class, OftenQuestionDTO.class);
    }
}
