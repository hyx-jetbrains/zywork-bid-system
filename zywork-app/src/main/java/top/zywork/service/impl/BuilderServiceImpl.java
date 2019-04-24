package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.BuilderDAO;
import top.zywork.dao.BuilderResourceDAO;
import top.zywork.dos.BuilderDO;
import top.zywork.dto.BuilderDTO;
import top.zywork.dto.BuilderResourceDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.BuilderResourceService;
import top.zywork.service.BuilderService;
import top.zywork.vo.BuilderVO;

import javax.annotation.PostConstruct;

/**
 * BuilderServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "builderService")
public class BuilderServiceImpl extends AbstractBaseService implements BuilderService {

    private BuilderDAO builderDAO;

    private BuilderResourceDAO builderResourceDAO;

    @Autowired
    public void setBuilderDAO(BuilderDAO builderDAO) {
        super.setBaseDAO(builderDAO);
        this.builderDAO = builderDAO;
    }

    @Autowired
    public void setBuilderResourceDAO(BuilderResourceDAO builderResourceDAO) {
        super.setBaseDAO(builderResourceDAO);
        this.builderResourceDAO = builderResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(BuilderDO.class, BuilderDTO.class);
    }

    @Override
    public int saveBuilder(BuilderVO builderVO) {
        Long[] resourceIdArr = builderVO.getResourceId();
        int res = builderDAO.save(builderVO);
        if (resourceIdArr.length > 0) {
            for (Long resourceId : resourceIdArr) {
                BuilderResourceDTO builderResourceDTO = new BuilderResourceDTO();
                builderResourceDTO.setBuilderId(builderVO.getId());
                builderResourceDTO.setResourceId(resourceId);
                builderResourceDAO.save(builderResourceDTO);
            }
        }
        return res;
    }
}
