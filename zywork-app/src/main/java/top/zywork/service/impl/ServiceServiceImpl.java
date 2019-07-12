package top.zywork.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.RedisUtils;
import top.zywork.constant.RedisKeyConstants;
import top.zywork.dao.ServiceDAO;
import top.zywork.dos.ServiceDO;
import top.zywork.dto.ServiceDTO;
import top.zywork.query.ServiceQuery;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ServiceService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * ServiceServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-05-28<br/>
 *
 * @author http://zywork.top 邓敏
 * @version 1.0
 */
@Service(value = "serviceService")
public class ServiceServiceImpl extends AbstractBaseService implements ServiceService {

    private ServiceDAO serviceDAO;

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setServiceDAO(ServiceDAO serviceDAO) {
        super.setBaseDAO(serviceDAO);
        this.serviceDAO = serviceDAO;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        super.init(ServiceDO.class, ServiceDTO.class);
    }

    @Override
    public String[] getAllVipServiceUrl() {
        ServiceQuery serviceQuery = new ServiceQuery();
        serviceQuery.setIsActive((byte)0);
        List<Object> objectList = serviceDAO.listAllByCondition(serviceQuery);
        List<ServiceDTO> serviceDTOList = BeanUtils.copy(objectList, ServiceDTO.class);
        StringBuilder urls = new StringBuilder();
        for (ServiceDTO serviceDTO : serviceDTOList) {
            String tempUrls = serviceDTO.getUrls();
            if (!StringUtils.isEmpty(tempUrls)) {
               urls.append(tempUrls).append(",");
            }
        }
        String tempUrl = urls.toString();
        RedisUtils.save(redisTemplate, RedisKeyConstants.REDIS_CODE_KEY_SERVICE_URL, tempUrl);
        return tempUrl.split(",");
    }
}
