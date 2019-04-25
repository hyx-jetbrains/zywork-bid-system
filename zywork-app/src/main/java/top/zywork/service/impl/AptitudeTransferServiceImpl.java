package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.AptitudeResourceDAO;
import top.zywork.dao.AptitudeTransferDAO;
import top.zywork.dos.AptitudeTransferDO;
import top.zywork.dto.AptitudeResourceDTO;
import top.zywork.dto.AptitudeTransferDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.AptitudeTransferService;
import top.zywork.vo.AptitudeTransferVO;

import javax.annotation.PostConstruct;

/**
 * AptitudeTransferServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-19<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "aptitudeTransferService")
public class AptitudeTransferServiceImpl extends AbstractBaseService implements AptitudeTransferService {

    /**
     * 资质转让DAO
     */
    private AptitudeTransferDAO aptitudeTransferDAO;

    /**
     * 资质附件DAO
     */
    private AptitudeResourceDAO aptitudeResourceDAO;

    @Autowired
    public void setAptitudeTransferDAO(AptitudeTransferDAO aptitudeTransferDAO) {
        super.setBaseDAO(aptitudeTransferDAO);
        this.aptitudeTransferDAO = aptitudeTransferDAO;
    }

    @Autowired
    public void setAptitudeResourceDAO(AptitudeResourceDAO aptitudeResourceDAO) {
        this.aptitudeResourceDAO = aptitudeResourceDAO;
    }

    @PostConstruct
    public void init() {
        super.init(AptitudeTransferDO.class, AptitudeTransferDTO.class);
    }

    @Override
    public int saveAptitudeTransfer(AptitudeTransferVO aptitudeTransferVO) {
        Long[] resourceIdArr = aptitudeTransferVO.getResourceId();
        int res = aptitudeTransferDAO.save(aptitudeTransferVO);
        if (resourceIdArr.length > 0) {
            for (Long resourceId : resourceIdArr) {
                AptitudeResourceDTO aptitudeResourceDTO = new AptitudeResourceDTO();
                aptitudeResourceDTO.setAptitudeId(aptitudeTransferVO.getId());
                aptitudeResourceDTO.setResourceId(resourceId);
                aptitudeResourceDAO.save(aptitudeResourceDTO);
            }
        }
        return res;
    }
}
