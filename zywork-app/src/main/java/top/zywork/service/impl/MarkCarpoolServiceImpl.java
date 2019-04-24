package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.MarkCarpoolDAO;
import top.zywork.dos.MarkCarpoolDO;
import top.zywork.dto.MarkCarpoolDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.MarkCarpoolService;

import javax.annotation.PostConstruct;

/**
 * MarkCarpoolServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "markCarpoolService")
public class MarkCarpoolServiceImpl extends AbstractBaseService implements MarkCarpoolService {

    private MarkCarpoolDAO markCarpoolDAO;

    @Autowired
    public void setMarkCarpoolDAO(MarkCarpoolDAO markCarpoolDAO) {
        super.setBaseDAO(markCarpoolDAO);
        this.markCarpoolDAO = markCarpoolDAO;
    }

    @PostConstruct
    public void init() {
        super.init(MarkCarpoolDO.class, MarkCarpoolDTO.class);
    }

    @Override
    public Object getByprojectId(Long projectId) {
        return markCarpoolDAO.getByprojectId(projectId);
    }
}
